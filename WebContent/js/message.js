$(function() {

	timerID = setInterval("longPolling()",60000);

});
function longPolling() {
	$.ajax({
		url : "showscheduling",
		data : {
			"count" : $("#hiddens").val()
		},
		type : 'post',
		dataType : 'json',
		success : function(rtn) {
			if (rtn.msg == "success") { // 请求成功
				$("#hiddens").val(rtn.data);
				sliderelay();
				
			}
		}
	});
}

/**
 * 关闭提示窗
 */
function guanbi() {
	$('#ceshi').window('close');
}

/**
 * 页面加载时右下角弹出提示审批框操作
 */
function sliderelay() {
	$.messager.show({
		id : 'ceshi',
		title : '工件加工消息',
		msg : '<font size="4" color="red">有新的工件加工信息，请确认！</font>',
		timeout : 21000,
		showType : 'slide'
	});
}
