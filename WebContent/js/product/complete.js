/**
 * esayui通用增删改查以及导入导出
 */
//提交的方法名称
var method = "";
var listParam = "";
var saveParam = "";
$(function() {
	//如果是process,查询mpsno
	
		$.ajax({
			url : "../proPlane/processCompleteMps",
			data : "",
			dataType : 'json',
			type : 'post',
			success : function(rtn) {
				// 成功的话，我们要关闭窗口
				var data = [];
				data.push({"text":"请选择","value":""});
				$.each(rtn, function (i, item) {
					//alert(item.mpsno)
					data.push({"text":$.trim(item.mpsno),"value":$.trim(item.mpsno)});
				});
				
				$("#mpsno").combobox('loadData',data)
			}
		});
		
		$("#mpsno").combobox({
			
			onChange:function(mpsno){
				$.ajax({
					url : "getProcessno",
					data : {"mpsno":mpsno},
					dataType : 'json',
					type : 'post',
					success : function(rtn) {
						// 成功的话，我们要关闭窗口
						var data = [];
						data.push({"text":"请选择","value":""});
						$.each(rtn, function (i, item) {
							//alert(item.mpsno)
							data.push({"text":$.trim(item.sequenceno),"value":$.trim(item.sequenceno)});
						});
						
						$("#processno").combobox('loadData',data)
					}
				});
			}
		})
		
		/*$("#processno").combobox({
	        onSelect: function () {
	        	if($("mpsno").val()==undefined||$("mpsno").val()=="请选择"){
					$.messager.alert("提示", "请选择生产计划号", 'info', function() {})
				}
				$.ajax({
					url : "getProcessno",
					data : {"processno":$("mpsno").val()},
					dataType : 'json',
					type : 'post',
					success : function(rtn) {
						// 成功的话，我们要关闭窗口
						var data = [];
						data.push({"text":"请选择","value":""});
						$.each(rtn, function (i, item) {
							//alert(item.mpsno)
							data.push({"text":$.trim(item.mpsno),"value":$.trim(item.mpsno)});
						});
						
						$("#processno").combobox('loadData',data)
					}
				});
	        }
	    })*/
		
	
	// 加载表格数据
	$('#complete').datagrid({
		url : 'completelistByPage',
		idField : idField,//指明哪一个字段是标识字段。
		title : title,
		columns : columns,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}/*, {
			title : '',
			field : idField,
			sortable : true,
			width:0
		} */] ],
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
		pageSize : 50,// 在设置分页属性的时候初始化页面大小。
		pageList : [ 10, 20, 30, 40, 50 ],//在设置分页属性的时候 初始化页面大小选择列表。
		//toolbar : $('#completeSerch'),
		toolbar :[ {
			text : '插入工件',
			iconCls : 'icon-add',
			handler : function() {
				var rows = $('#complete').datagrid('getSelections');
				if(rows.length<1){
					$.messager.alert("提示", "请选中要插入的工件", 'info', function() {
					});
				}else{
					var items=[];
			        for(i=0;i<rows.length;i++){  //遍历数组
			        	var item = new Object();
			        	item.mpsno=rows[i].MPSNO;
			        	item.cdate=new Date();
			        	items.push(item);
			        }
					insertData(items);
				}
			}
		}],
		onDblClickRow : function() {
			edit();
		},
	});
function insertData(data1) {
	// 提交添加数据的表单
	var formData = data1;
	$.ajax({
		type : 'POST',
		url : 'insertGA',
		data : JSON.stringify(data1),
		dataType : 'json',
		contentType : 'application/json; charset=UTF-8',
		success : function(data) {
			console.info(data);
			$.messager.alert("提示", data.msg, 'info', function() {
				if (data.status == 200) {
					// 刷新表格数据
					$('#complete').datagrid('reload');
					// 刷新树形菜单
					// 关闭对话框
					//$('#completeDlg').dialog('close');
					// 清除表单数据
					//$('#completeForm').form('clear');
				}
			});
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
	// 点击保存按钮
	$('#btncomSearch').bind('click', function() {
		// 做表单字段验证，当所有字段都有效的时候返回true。该方法使用validatebox(验证框)插件。
		var isValid = $('#completeForm').form('validate');
		if (isValid == false) {
			return;
		}
		var formData = $('#completeForm').serializeJSON();
		$.ajax({
			url : "savecomplete",
			data : formData,
			dataType : 'json',
			type : 'post',
			success : function(rtn) {
				$.messager.alert("提示", rtn.msg, 'info', function() {
					if (rtn.status == 200) {
						// 刷新表格数据
						$('#complete').datagrid('reload');
					}
				});
			}
		});

	});	
	
	function insertData(data1) {
		// 提交添加数据的表单
		var formData = data1;
		$.ajax({
			type : 'POST',
			url : 'insertGA',
			data : JSON.stringify(data1),
			dataType : 'json',
			contentType : 'application/json; charset=UTF-8',
			success : function(data) {
				$.messager.alert("提示", data.msg, 'info', function() {
					if (data.status == 200) {
						// 刷新表格数据
						$('#complete').datagrid('reload');
						// 刷新树形菜单
					}
				});
			}
		});
	}
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
									$.messager.alert('提示', data.msg,
											'info', function() {
												if (data.status==200) {
													$('#importDlg').dialog('close');
													$('#importForm').form('clear');
													$('#grid').datagrid('reload');
												}
											});
								}
							});
						}
					} ]
				});
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