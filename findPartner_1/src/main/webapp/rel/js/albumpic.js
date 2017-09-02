if (faid != null && faid != "") {
	$(".amyimg").attr("href", "page/lw-img.jsp?aid=" + faid);
}

listalbumpic();
function listalbumpic() {
	$.post("albumpic/list", function(data) {
		if (data == null || data == "") {
			$(".imgnotnull").show();
			return false
		}
		$("#imgnotnull").hide();
		var apicStr = '';
		for (var i = 0; i < data.length; i++) {
			apicStr += '<li data-src="' + data[i].apic+ '"><a href="javascript:void(0)">';
			apicStr += '<img src="' + data[i].apic + '"></a></li>';
		}
		$("#lightgallery")[0].innerHTML = apicStr;
		lightGallery();
	}, "json")
}
function lightGallery() {
	$(document).ready(function() {
		$("#lightgallery").lightGallery();
	});
}
function chgPic(obj) {
	$(".pic").attr("src", window.URL.createObjectURL(obj.files[0]))
}
