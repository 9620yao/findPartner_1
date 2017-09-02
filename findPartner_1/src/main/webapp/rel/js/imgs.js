imgcount();
function imgcount() {
	$.post("album/countAlbum", {
		"aaid" : faid
	}, function(data) {
		if (data == null || data == "") {
			return false
		}
		$(".spcount").html(data[0].counts)
	}, "json")
}
function showalbum() {
	$.post("album/list",{
		"faid" : faid
	},
	function(data) {
		if (data == null || data == "") {
			return false
		}
		var album = '';
		for (var i = 0; i < data.length; i++) {
			album += "<div><img onclick=\"openpic("+ data[i].abid+ ")\" ";
			if(data[i].aheader == null || data[i].aheader == ""){
				album += " src=\"images/pic-none.png\"/>";
			}else{
				album += " src=\""+data[i].aheader+"\"/>";
			}
			album += "<span>"+ data[i].abname + "</span></div>"
		}
		$("#container").html(album)
	}, "json")
}
showalbum();
function openpic(date) {
	if (date != null) {
		var url = "page/albumpic.jsp?aid=" + faid + "&abid=" + date;
		self.location = url;
	}
}
var ue = UE.getEditor("ueditor");
function addAlbum() {
	$(".alcontent").val(ue.getContentTxt());
	$(".strimg").val(url);
	$(".aaid").val(faid);
	$("#alform").submit()
};