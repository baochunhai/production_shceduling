/**
 * esayui通用增删改查以及导入导出
 */
// 提交的方法名称
var method = "";
var listParam = "";
var saveParam = "";
$(function() {
	if(name!="manue_plane"){
	// 加载表格数据
	$('#grid').datagrid({
		url : name + 'listByPage' + listParam,
		idField : idField,// 指明哪一个字段是标识字段。
		title : title,
		columns : columns,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} /*
			 * , { title : '', field : idField, sortable : true, width:0 }
			 */] ],
		sortable : true,
		fitColumns : true,
		iconCls : 'icon-tip',
		singleSelect : true,// 如果为true，则只允许选择一行。
		pagination : true,// 如果为true，则在DataGrid控件底部显示分页工具栏。
		striped : true,// 是否显示斑马线效果。
		collapsible : true, // 定义是否显示可折叠按钮。
		rownumbers : true,// 如果为true，则显示一个行号列。
		nowrap : true,// 如果为true，则在同一行中显示数据。设置为true可以提高加载性能。
		/*
		 * sortName : idField,//定义哪些列可以进行排序。 sortOrder :
		 * 'asc',//定义列的排序顺序，只能是'asc'或'desc'。
		 */remoteSort : false,// 定义从服务器对数据进行排序。
		loading : true,// 显示载入状态。
		loadMsg : '数据加载中...',// 在从远程站点加载数据的时候显示提示消息。
		pageNumber : 1,// 在设置分页属性的时候初始化页码。
		pageSize : 10,// 在设置分页属性的时候初始化页面大小。
		pageList : [ 10, 20, 30, 40, 50 ],// 在设置分页属性的时候 初始化页面大小选择列表。
		/*
		 * toolbar : [ { text : '新增', iconCls : 'icon-add', handler : function() { //
		 * 打开前清空表单 $('#editForm').form('clear'); // 设置保存按钮提交的方法为add method =
		 * "add"; // 关闭编辑窗口 $('#editDlg').dialog('open'); } }, '-', { text :
		 * '修改', iconCls : 'icon-edit', handler : function() { edit(); } }, '-', {
		 * text : '删除', iconCls : 'icon-cut', handler : function() { //
		 * 获取被选中行的数据 var selected = $('#grid').datagrid('getSelected');
		 * del(selected); } }, '-', { text : '导出', iconCls : 'icon-excel',
		 * handler : function() { var formData =
		 * $('#searchForm').serializeJSON(); // 下载文件 $.download(name + "export" +
		 * listParam, formData); } }, '-', { text : '导入', iconCls : 'icon-save',
		 * handler : function() { $('#importDlg').dialog('open'); } } ],
		 */
		onDblClickRow : function() {
			edit();
		},
		onClickRow:function(){
			var selected = $('#grid').datagrid('getSelected');
			$('#mpsno').val($.trim(selected.mpsno));
			$('#type').val($.trim(selected.type));
		},
		 onCheck:function(){
			 var selected = $('#grid').datagrid('getSelected');
				$('#mpsno').val($.trim(selected.mpsno));
				$('#type').val($.trim(selected.type));
		 }
	});
	}else{
		// 加载表格数据
		$('#grid').datagrid({
			url : name + 'listByPage' + listParam,
			idField : idField,// 指明哪一个字段是标识字段。
			title : title,
			columns : columns,
			sortable : true,
			fitColumns : true,
			iconCls : 'icon-tip',
			singleSelect : true,// 如果为true，则只允许选择一行。
			pagination : true,// 如果为true，则在DataGrid控件底部显示分页工具栏。
			striped : true,// 是否显示斑马线效果。
			collapsible : true, // 定义是否显示可折叠按钮。
			rownumbers : true,// 如果为true，则显示一个行号列。
			nowrap : true,// 如果为true，则在同一行中显示数据。设置为true可以提高加载性能。
			/*
			 * sortName : idField,//定义哪些列可以进行排序。 sortOrder :
			 * 'asc',//定义列的排序顺序，只能是'asc'或'desc'。
			 */remoteSort : false,// 定义从服务器对数据进行排序。
			loading : true,// 显示载入状态。
			loadMsg : '数据加载中...',// 在从远程站点加载数据的时候显示提示消息。
			pageNumber : 1,// 在设置分页属性的时候初始化页码。
			pageSize : 30,// 在设置分页属性的时候初始化页面大小。
			pageList : [ 10, 20, 30, 40, 50 ],// 在设置分页属性的时候 初始化页面大小选择列表。
			/*
			 * toolbar : [ { text : '新增', iconCls : 'icon-add', handler : function() { //
			 * 打开前清空表单 $('#editForm').form('clear'); // 设置保存按钮提交的方法为add method =
			 * "add"; // 关闭编辑窗口 $('#editDlg').dialog('open'); } }, '-', { text :
			 * '修改', iconCls : 'icon-edit', handler : function() { edit(); } }, '-', {
			 * text : '删除', iconCls : 'icon-cut', handler : function() { //
			 * 获取被选中行的数据 var selected = $('#grid').datagrid('getSelected');
			 * del(selected); } }, '-', { text : '导出', iconCls : 'icon-excel',
			 * handler : function() { var formData =
			 * $('#searchForm').serializeJSON(); // 下载文件 $.download(name + "export" +
			 * listParam, formData); } }, '-', { text : '导入', iconCls : 'icon-save',
			 * handler : function() { $('#importDlg').dialog('open'); } } ],
			 */
			onDblClickRow : function() {
				edit();
			},
			onClickRow:function(){
				var selected = $('#grid').datagrid('getSelected');
				console.info(selected)
				$('#mpsno').val($.trim(selected.mpsno));
				console.info($('#mpsno').val())
				$('#type').val($.trim(selected.type));
				console.info($('#type').val())
			},
			 onCheck:function(){
				 var selected = $('#grid').datagrid('getSelected');
				 	console.info(selected)
					$('#mpsno').val($.trim(selected.mpsno));
					console.info($('#mpsno').val())
					$('#type').val($.trim(selected.type));
					console.info($('#type').val())
			 }
		});
		
	}
	var h = 300;
	var w = 400;
	if (typeof (height) != "undefined") {
		h = height;
	}
	if (typeof (width) != "undefined") {
		w = width;
	}
	// 初始化编辑窗口
	$('#editDlg').dialog({
		title : '编辑',// 窗口标题
		width : w,// 窗口宽度
		height : h,// 窗口高度
		closed : true,// 窗口是是否为关闭状态, true：表示关闭
		modal : true
	// 模式窗口
	});

	// 点击保存按钮
	$('#btnSave').bind('click', function() {
		// 做表单字段验证，当所有字段都有效的时候返回true。该方法使用validatebox(验证框)插件。
		var isValid = $('#editForm').form('validate');
		if (isValid == false) {
			return;
		}
		var formData = $('#editForm').serializeJSON();
		$.ajax({
			url : name + method + saveParam,
			data : formData,
			dataType : 'json',
			type : 'post',
			success : function(rtn) {
				$.messager.alert("提示", rtn.msg, 'info', function() {
					if (rtn.status == 200) {
						// 成功的话，我们要关闭窗口
						$('#editDlg').dialog('close');
						// 刷新表格数据
						$('#grid').datagrid('reload');
					}
				});
			}
		});

	});

	// 判断是否有导入的功能
	var importForm = document.getElementById('importForm');
	if (importForm) {
		$('#importDlg').dialog(
				{
					title : '导入数据',
					width : 330,
					height : 106,
					modal : true,
					closed : true,
					buttons : [ {
						text : '导入',
						handler : function() {
							$.ajax({
								url : name + 'doImport',
								data : new FormData($('#importForm')[0]),
								type : 'post',
								processData : false,
								contentType : false,
								dataType : 'json',
								success : function(data) {
									$.messager.alert('提示', data.msg, 'info',
											function() {
												if (data.status == 200) {
													$('#importDlg').dialog(
															'close');
													$('#importForm').form(
															'clear');
													$('#grid').datagrid(
															'reload');
												}
											});
								}
							});
						}
					} ]
				});
	}
	// 自动补全
	$('#inputtable').combobox(
			{
				prompt : '输入关键字后自动搜索',
				mode : 'remote',
				url : _url,// _url,_value已经在各自的js文件中定义
				valueField : _value,
				textField : _value,
				panelHeight : 'auto',
				panelMaxHeight : 150,
				editable : true,
				hasDownArrow : false,
				onBeforeLoad : function(param) {
					if (param == null || param.q == null
							|| param.q.replace(/ /g, '') == '') {
						var value = $(this).combobox('getValue');
						if (value) {// 修改的时候才会出现q为空而value不为空
							param.id = value;
							return true;
						}
						return false;
					}
				}
			});
	// 回车事件绑定 搜索框是esayui动态生成的<input type="text" class="combo-text
	// validatebox-text" autocomplete="off" style="width: 167px; height: 20px;
	// line-height: 20px;">
	$('.combo-text').bind('keyup', function(event) {
		if (event.keyCode == "13") {
			// 回车执行查询
			$('#btnSearch').click();
			//reloadgrid();
		}
	});
	// 点击查询按钮
	$('#btnSearch').bind('click', function() {
		
		var icon = $(this).find('.icon').attr('class');
		var selected = $('#grid').datagrid('getSelected');
		var url = "apps/dataanalyze/manue_plane.html?mpsno="+$.trim($("#mpsno").val())/*+"&type="+decodeURIComponent($("#type").val())*/;
		if($.trim($("#mpsno").val())==""||$("#mpsno").val()==null){
			$.messager.alert("Warning","请选择要计算的工件");
			return;
		}
		tabTitle =selected.mpsno + "制造资源";
		addTab(tabTitle, url, icon);
		//reloadgrid()
	});

	// 点击重置按钮
	$('#btnReset').bind('click', function() {
		$('#searchForm').form('clear');
	});

	function reloadgrid() {
		// 把表单数据转换成json对象
		var formData = $('#searchForm').serializeJSON();
		$('#grid').datagrid('load', formData);
	}
});

/**
 * 删除
 */
function del(selected) {
	$.messager.confirm("确认", "确认要删除吗？", function(yes) {
		if (yes) {
			alert(selected)
			$.ajax({
				url : name + 'delete',
				data : selected,
				dataType : 'json',
				type : 'post',
				success : function(rtn) {
					$.messager.alert("提示", rtn.msg, 'info', function() {
						// 刷新表格数据
						$('#grid').datagrid('reload');
					});
				}
			});
		}
	});
}

function edit() {
	// 清空表单内容
	$('#editForm').form('clear');
	// 设置保存按钮提交的方法为update
	method = "update";
	// 弹出窗口
	$('#editDlg').dialog('open');
	// 获取被选中行的数据
	var selected = $('#grid').datagrid('getSelected');
	// 加载数据
	$('#editForm').form('load', selected);
}
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