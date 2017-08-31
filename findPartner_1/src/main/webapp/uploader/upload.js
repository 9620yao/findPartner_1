$('#picData').fileinput({
	language : 'zh',
	uploadUrl : "albumpic/add",
	allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
	textEncoding : 'UTF-8',
});
$("#picData").on("fileuploaded", function(event, data, previewId, index) {
	if(data){
		listalbumpic();
		$('#myModal').modal('hide');
	}
});
$('#picData').on('fileerror', function(event, data, msg) {
	alert(msg);
});
