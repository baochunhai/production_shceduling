var type = "D0001";

	
	
$(function() {
	loadTree();
	//loadDataGrid("");
	// 添加数据对话框
	$('#insertDlg').dialog({
		title : '添加数据',
		width : 360,
		height : 200,
		closed : true,
		modal : true,
		buttons : [ {
			text : '保存',
			handler : function() {
				// 访问后台数据
				insertData();
			}
		}, {
			text : '关闭',
			handler : function() {
				// 关闭对话框
				$("#insertDlg").dialog('close');
			}
		} ]
	});
	// 修改数据对话框
	$('#updateDlg').dialog({
		title : '修改数据',
		width : 400,
		height : 260,
		closed : true,
		modal : true,
		buttons : [ {
			text : '保存',
			handler : function() {
				// 访问后台数据
				updateData();
			}
		}, {
			text : '关闭',
			handler : function() {
				// 关闭对话框
				$("#updateDlg").dialog('close');
			}
		} ]
	});
});

/**
 * 加载两侧菜单
 */
function loadTree() {
	$.ajax({
		type : 'POST',
		url : 'menu/menulist?type='+type,
		dataType : 'json',
		success : function(rtn) {
			disposeTree(rtn);
			//loadDataGrid("");
		}
	});
}
/**
 * 处理左侧菜单
 */
function disposeTree(data) {
	console.log(data)
	// 加载左侧菜单
	$('#tt').tree({
		data : data,
		loadFilter: function(data){
			console.info(data);
			return data;
		},
		onClick : function(node) {
			// 显示子菜单到datagrid
			if(node.url!="#"){
				var processno = node.url;
				
				if(processno.indexOf("insert")>0){
					var subtitle = node.text; 
					var url = node.url;
					var icon = $(this).find('.icon').attr('class');
					addTab(subtitle, url, icon);
					
					//loadDataGrid(node,insert,inserttoobar,$('#insert'));
				}
				if(processno.indexOf("delay")>0){
					var subtitle = node.text; 
					var url = node.url;
					var icon = $(this).find('.icon').attr('class');
					addTab(subtitle, url, icon);
					//loadDataGrid(node,delay,$('#delSerch'),$('#delay'));
				}
				if(processno.indexOf("fault")>0){
					var subtitle = node.text; 
					var url = node.url;
					var icon = $(this).find('.icon').attr('class');
					addTab(subtitle, url, icon);
					//loadDataGrid(node,fault,$('#faultSerch'),$('#fault'));
				}
				if(processno.indexOf("complete")>0){
					var subtitle = node.text; 
					var url = node.url;
					var icon = $(this).find('.icon').attr('class');
					addTab(subtitle, url, icon);
					//loadDataGrid(node,complete,$('#completeSerch'),$('#complete'));
				}
			}
			
		}
	});
}

/**
 * 加载表格数据 menuid：菜单id
 */
function loadDataGrid(node,comlumns,toobar,tab1) {
	var processno = node.url;
	var text = node.text;
	tab1.datagrid({
		url : processno+'listByPage',
		title : valid(text),
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}] ],
		columns : comlumns,
		sortable : true,
		fitColumns:true,
		iconCls : 'icon-tip',
		singleSelect : false,// 如果为true，则只允许选择一行。
		pagination : true,// 如果为true，则在DataGrid控件底部显示分页工具栏。
		striped : true,// 是否显示斑马线效果。
		collapsible : true,	//定义是否显示可折叠按钮。
		rownumbers : true,//如果为true，则显示一个行号列。
		nowrap : true,//如果为true，则在同一行中显示数据。设置为true可以提高加载性能。
		/*sortName : idField,//定义哪些列可以进行排序。
		sortOrder : 'asc',//定义列的排序顺序，只能是'asc'或'desc'。
*/		remoteSort : false,//定义从服务器对数据进行排序。
		loading : true,//显示载入状态。
		loadMsg : '数据加载中...',// 在从远程站点加载数据的时候显示提示消息。
		pageNumber : 1,// 在设置分页属性的时候初始化页码。
		pageSize : 10,// 在设置分页属性的时候初始化页面大小。
		pageList : [ 10, 20, 30, 40, 50 ],//在设置分页属性的时候 初始化页面大小选择列表。
		toolbar : toobar
	});
}

/**
 * 添加数据
 */


/**
 * 删除数据
 */
function deleteData(menuid) {
	var gridData = $('#grid').datagrid('getData').rows[0];
	$.messager.confirm('警告', '确认要删除“' + gridData.menuname + '”菜单吗?',function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : 'menu/menudelete',
						data : {
							'menuid' : menuid
						},
						dataType : 'json',
						success : function(data) {
							$.messager.alert("提示", data.msg, 'info',function() {
												if (data.status == 200) {
													// 刷新表格数据
//													$('#grid').datagrid('deleteRow', 0);
//													loadDataGrid();
													// 刷新树形菜单
													loadTree();
												}
											});
						}
					});
				}
			});
}

/**
 * 修改数据
 */
function updateData() {
	var formData = $('#updateForm').serializeJSON();
	if(formData.is_parent == '是'){
		formData.is_parent = 1;
	} else{
		formData.is_parent = 0;
	}
	$.ajax({
		type : 'POST',
		url : 'menu/menuupdate',
		data : formData,
		dataType : 'json',
		success : function(data) {
			$.messager.alert("提示", data.msg, 'info', function() {
				if (data.status == 200) {
				// 刷新表格数据
				$('#grid').datagrid('reload');
				// 刷新树形菜单
				loadTree();
				// 关闭对话框
				$('#updateDlg').dialog('close');
				// 清除表单数据
				$('#updateForm').form('clear');
				}
			});
		}
	});
}
/**
 * 重命名菜单
 */

function addTab(subtitle, url, icon) {
	var jq = top.jQuery;
	if (!jq('#tabs').tabs('exists', subtitle)) {
		jq('#tabs').tabs('add', {
			title : subtitle,
			content : createFrame(url),
			//href:url,
			closable : true,
			icon : icon
		});
	//window.open(url);  
	} else {
		jq('#tabs').tabs('select', subtitle);
		jq('#mm-tabupdate').click();
	}
	tabClose();
}
function closeTab(action) {
	var jq = top.jQuery;
	var alltabs = jq('#tabs').tabs('tabs');
	var currentTab = jq('#tabs').tabs('getSelected');
	var allTabtitle = [];
	$.each(alltabs, function(i, n) {
		allTabtitle.push($(n).panel('options').title);
	})

	switch (action) {
	case "refresh":
		var iframe = $(currentTab.panel('options').content);
		var src = iframe.attr('src');
		jq('#tabs').tabs('update', {
			tab : currentTab,
			options : {
				content : createFrame(src)
			}
		})
		break;
	case "close":
		var currtab_title = currentTab.panel('options').title;
		jq('#tabs').tabs('close', currtab_title);
		break;
	case "closeall":
		$.each(allTabtitle, function(i, n) {
			if (n != onlyOpenTitle) {
				jq('#tabs').tabs('close', n);
			}
		});
		break;
	case "closeother":
		var currtab_title = currentTab.panel('options').title;
		$.each(allTabtitle, function(i, n) {
			if (n != currtab_title && n != onlyOpenTitle) {
				jq('#tabs').tabs('close', n);
			}
		});
		break;
	case "closeright":
		var tabIndex = jq('#tabs').tabs('getTabIndex', currentTab);

		if (tabIndex == alltabs.length - 1) {
			alert('亲，后边没有啦 ^@^!!');
			return false;
		}
		$.each(allTabtitle, function(i, n) {
			if (i > tabIndex) {
				if (n != onlyOpenTitle) {
					jq('#tabs').tabs('close', n);
				}
			}
		});

		break;
	case "closeleft":
		var tabIndex = jq('#tabs').tabs('getTabIndex', currentTab);
		if (tabIndex == 1) {
			alert('亲，前边那个上头有人，咱惹不起哦。 ^@^!!');
			return false;
		}
		$.each(allTabtitle, function(i, n) {
			if (i < tabIndex) {
				if (n != onlyOpenTitle) {
					jq('#tabs').tabs('close', n);
				}
			}
		});

		break;
	case "exit":
		jq('#closeMenu').menu('hide');
		break;
	}
}
function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="' + url
			+ '" style="width:100%;height:100%;"></iframe>';
	return s;
}
function tabClose() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close', subtitle);
	})
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();

		$('#mm').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
}

// 绑定右键菜单事件
function tabCloseEven() {

	$('#mm').menu({
		onClick : function(item) {
			closeTab(item.id);
		}
	});

	return false;
}
function valid(data){
	 if(typeof(data)=="undefined"){  
	        return "";  
	    }else if(data==null){  
	        return "";  
	    }else{
	    	return data;
	    }  
	    
}
function formatterDate(date) {
	//得到日期并转换
	
	var oDate = new Date(date), 
	oYear = oDate.getFullYear(), 
	oMonth = oDate.getMonth() + 1, 
	oDay = oDate.getDate(), 
	oHour = oDate.getHours(), 
	oMin = oDate.getMinutes(), 
	oSen = oDate.getSeconds(), 
	oTime = oYear + '-'	+ getzf(oMonth) + '-' + getzf(oDay) + ' ' + getzf(oHour) + ':'
			+ getzf(oMin) + ':' + getzf(oSen);// 最后拼接时间
	
	return oTime;
};
//补0操作
function getzf(num) {
	if (parseInt(num) < 10) {
		num = '0' + num;
	}
	return num;
}
