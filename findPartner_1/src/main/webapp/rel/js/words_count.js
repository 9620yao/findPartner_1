$('#wordsInfo').datagrid({
	url : 'words/countWords',
	fitColumns : true,
	// fit:true,
	singleSelect : true,
	border : false,
	pagination : true,
	columns : [ [ {
		field : 'waid',
		title : '用户',
		width : 50,
		align : 'center'
	}, {
		field : 'counts',
		title : '留言数量',
		width : 100,
		align : 'center'
	} ] ],
});

function unclearQueryWordsCount() {
	var select = $("#WordselectCount").val();
	var param = $("#paramterWC").val();
	$('#wordsInfo').datagrid({
		url : 'words/findunclearing?waid=' + param,
		fitColumns : true,
		//fit : true,
		singleSelect : true,
		border : false,
		pagination : true,
		columns : [ [ {
			field : 'waid',
			title : '用户',
			width : 50,
			align : 'center'
		}, {
			field : 'counts',
			title : '留言数量',
			width : 100,
			align : 'center'
		} ] ],
	});
}
