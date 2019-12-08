/**
 * esayui通用增删改查以及导入导出
 */
//提交的方法名称
var method = "";
var listParam = "";
var saveParam = "";
$(function() {
	//loadProduct();
	//lastProduct();
	// 加载表格数据
	$.ajax({
		url : "configSelect",
		data : "",
		dataType : 'json',
		async:false,
		type : 'post',
		success : function(rtn) {
			$('#geneNumber').val(rtn.geneNumber);
			$('#generation').val(rtn.generation);
			$('#gap').val(rtn.gap);
			$('#cross').val(rtn.cross);
			$('#aberrance').val(rtn.aberrance);
		}
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
		var isValid = $('#conform').form('validate');
		if (isValid == false) {
			return;
		}
		var formData = $('#conform').serializeJSON();
		$.ajax({
			url : "configSave",
			data : formData,
			dataType : 'json',
			type : 'post',
			success : function(rtn) {
				$.messager.alert("提示", rtn.msg, 'info', function() {
				});
			}
		});

	});
	// 点击重置按钮
	$('#btnRes').bind('click', function() {
		$('#conform').form('clear');

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
													$('#product').datagrid('reload');
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
	
	$('#grid').datagrid('reload');
}
