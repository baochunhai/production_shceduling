/**
 * esayui通用增删改查以及导入导出
 */
//提交的方法名称
var method = "";
var listParam = "";
var saveParam = "";
$(function() {
	//如果是process,查询mpsno
/*	if(name=="process"){
		$.ajax({
			url : name + "AllMps",
			data : "",
			dataType : 'json',
			type : 'post',
			success : function(rtn) {
				// 成功的话，我们要关闭窗口
				var data = [];
				data.push({"text":"请选择","value":""});
				$.each(rtn, function (i, item) {
					//alert(item.mpsno)
					data.push({"text":$.trim(item.MPSNO),"value":$.trim(item.MPSNO)});
				});
				
				$("#mpsno").combobox('loadData',data)
			}
		});
		
	}*/
	var idField = '';
	var height = 300;
	var width = 300;
	var columns = [ [ {
		field : 'mpsno',
		title : '生产计划号',
		width : 100
	}, {
		field : 'type',
		title : '工件类型',
		width : 50
	}, {
		field : 'taskno',
		title : '任务号',
		width : 50
	}, {
		field : 'processfileno',
		title : '工艺文件号',
		width : 100
	}, {
		field : 'manunumber',
		title : '投产数量',
		width : 50,
	}, {
		field : 'startdate',
		title : '计划开始日期',
		width : 100,
		formatter : function(value) {
			 return new Date(value).Format("yyyy-MM-dd"); 
		}
	}, {
		field : 'enddate',
		title : '计划完成日期',
		width : 100,
		formatter : function(value) {
			 return new Date(value).Format("yyyy-MM-dd"); 
		}
	}, {
		field : 'department',
		title : '完成单位',
		width : 100,
	}, {
		field : 'status',
		title : '完成状态',
		width : 100,
	}] ];
	// 加载表格数据
	$('#insert').datagrid({
		url : 'insertlistByPage' + listParam,
		idField : idField,//指明哪一个字段是标识字段。
		title : "1.插单",
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
		pageSize : 10,// 在设置分页属性的时候初始化页面大小。
		pageList : [ 10, 20, 30, 40, 50 ],//在设置分页属性的时候 初始化页面大小选择列表。
		toolbar : [ {
			text : '插入工件',
			iconCls : 'icon-add',
			handler : function() {
				var rows = $('#insert').datagrid('getSelections');
				console.log(rows);
				var items=[];
                for(i=0;i<rows.length;i++){  //遍历数组
                	var item = new Object();
                	item.mpsno=rows[i].mpsno;
                	item.cdate=new Date();
                	items.push(item);
                }
                console.log(items);
				insertData(items);
			}
		}],
		onDblClickRow : function() {
			edit();
		},
	});
	
	columns = [ [ {
		field : 'mpsno',
		title : '生产计划号',
		width : 100
	}, {
		field : 'taskno',
		title : '任务号',
		width : 50
	}, {
		field : 'processfileno',
		title : '最新完工工序编号',
		width : 100
	}, {
		field : 'manunumber',
		title : '最新工序完工时间',
		width : 50,
	}, {
		field : 'startdate',
		title : '该工序的计划完工时间',
		width : 100
	}, {
		field : 'enddate',
		title : '延期时间',
		width : 100
	}] ];
	$('#delay').datagrid({
		url : 'delaylistByPage' + listParam,
		idField : idField,//指明哪一个字段是标识字段。
		title : "2.生产进度延期",
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
		fitColumns : true,
		/*sortName : idField,//定义哪些列可以进行排序。
		sortOrder : 'asc',//定义列的排序顺序，只能是'asc'或'desc'。
*/		remoteSort : false,//定义从服务器对数据进行排序。
		loading : true,//显示载入状态。
		loadMsg : '数据加载中...',// 在从远程站点加载数据的时候显示提示消息。
		pageNumber : 1,// 在设置分页属性的时候初始化页码。
		pageSize : 10,// 在设置分页属性的时候初始化页面大小。
		pageList : [ 10, 20, 30, 40, 50 ],//在设置分页属性的时候 初始化页面大小选择列表。
		toolbar :$('#delSerch') /*[ {
		text : '添加工件',
		iconCls : 'icon-add',
		handler : function() {
			var rows = $('#grid').datagrid('getSelections');
			console.log(rows);
			var items=[];
            for(i=0;i<rows.length;i++){  //遍历数组
            	var item = new Object();
            	item.mpsno=rows[i].mpsno;
            	item.cdate=new Date();
            	items.push(item);
            }
            console.log(items);
			insertData(items);
		}
	}]*/,
		onDblClickRow : function() {
			edit();
		},
	});
//设备故障
	columns = [ [ {
		field : 'machineno',
		title : '设备编号',
		width : 100
	}, {
		field : 'machinename',
		title : '设备名称	',
		width : 50
	}, {
		field : 'fstarttime',
		title : '故障开始时间',
		width : 100
	}, {
		field : 'precovertime',
		title : '故障预计修复工时',
		width : 50,
	}, {
		field : 'fendtime',
		title : '故障实际修复时间',
		width : 100
	}, {
		field : 'status',
		title : '设备状态',
		width : 100
	}] ];
	$('#devicefault').datagrid({
		url : 'faultlistByPage' + listParam,
		idField : idField,//指明哪一个字段是标识字段。
		title : "3.设备故障",
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
		pageSize : 10,// 在设置分页属性的时候初始化页面大小。
		pageList : [ 10, 20, 30, 40, 50 ],//在设置分页属性的时候 初始化页面大小选择列表。
		toolbar :$('#faultSerch'),
		onDblClickRow : function() {
			edit();
		},
	});
	//齐套性问题
	columns = [ [ {
		field : 'mpsno',
		title : '生产计划号',
		width : 100
	}, {
		field : 'taskno',
		title : '任务号',
		width : 50
	}, {
		field : 'processfileno',
		title : '最新完工工序编号',
		width : 100
	}, {
		field : 'manunumber',
		title : '最新工序完工时间',
		width : 50,
	}, {
		field : 'startdate',
		title : '该工序的计划完工时间',
		width : 100
	}, {
		field : 'enddate',
		title : '延期时间',
		width : 100
	}] ];
	$('#complete').datagrid({
		url : 'delaylistByPage' + listParam,
		idField : idField,//指明哪一个字段是标识字段。
		title : "4.齐套性问题",
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
		pageSize : 10,// 在设置分页属性的时候初始化页面大小。
		pageList : [ 10, 20, 30, 40, 50 ],//在设置分页属性的时候 初始化页面大小选择列表。
		/*toolbar :$('#delSerch') [ {
			text : '添加工件',
			iconCls : 'icon-add',
			handler : function() {
				var rows = $('#grid').datagrid('getSelections');
				console.log(rows);
				var items=[];
                for(i=0;i<rows.length;i++){  //遍历数组
                	var item = new Object();
                	item.mpsno=rows[i].mpsno;
                	item.cdate=new Date();
                	items.push(item);
                }
                console.log(items);
				insertData(items);
			}
		}],*/
		onDblClickRow : function() {
			edit();
		},
	});
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
 * 添加数据
 */
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
					$('#insert').datagrid('reload');
					// 刷新树形菜单
				}
			});
		}
	});
}

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
