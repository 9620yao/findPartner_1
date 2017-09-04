function loadAdminInfo() {
	$.get("user/getByid", {
		"faid" : faid
	}, function(data) {
		$("#pictrue").val("");
		if (data.picture) {
			$(".pic").attr("src", data.picture)
		} else {
			$(".pic").attr("src", "images/timg.jpg")
		}
		$('#nickname').html(data.nickname);
	}, "json")
}
loadAdminInfo();

function chgPic(obj) {
	$(".uimg").attr("src", window.URL.createObjectURL(obj.files[0]))
}
