//点击用户头像 用户昵称 进入他的主页
function showuser(date) {
	if (date != null) {
		var url = "page/lw-index.jsp?aid=" + date;
		// window.open(url); //打开新的页面并带参数过去
		window.open(url);
	}
}

function openpic(speakman, date) {
	if (date != null) {
		var url = "page/albumpic.jsp?aid=" + speakman + "&abid=" + date;
		window.open(url)
	}
};