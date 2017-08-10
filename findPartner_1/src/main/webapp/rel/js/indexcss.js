userpower();
function userpower(){
	$.post("power/sure",{"faid":faid},function(data){
		//alert(data);
		if(data){
			if(url.indexOf("page/lw-index.jsp")>0){
				self.location="page/lw-power.jsp?aid="+faid;
			}
			return false;
		}else{
			if(url.indexOf("page/lw-power.jsp")>0){
				self.location="page/lw-index.jsp?aid="+faid;
			}
			return false;
		}
	},"json");
}

/*var target = document.querySelector(".target");
var links = document.querySelectorAll("#head a");
var colors = ["deepskyblue", "orange", "firebrick", "gold", "magenta", "black", "darkblue"];

function mouseenterFunc() {
	if (!this.parentNode.classList.contains("active")) {
		for (var i = 0; i < links.length; i++) {
			if (links[i].parentNode.classList.contains("active")) {
				links[i].parentNode.classList.remove("active");
			}
			//links[i].style.opacity = "0.25"; 除当前鼠标的位置，其他节点都隐藏
		}

		this.parentNode.classList.add("active");
		this.style.opacity = "1";

		var width = this.getBoundingClientRect().width;
		var height = this.getBoundingClientRect().height;
		var left = this.getBoundingClientRect().left + window.pageXOffset;
		var top = this.getBoundingClientRect().top + window.pageYOffset;
		var color = colors[Math.floor(Math.random() * colors.length)];

		target.style.width = width + "px";
		target.style.height = height + "px";
		target.style.left = left + "px";
		target.style.top = top + "px";
		target.style.borderColor = color;
		target.style.transform = "none";
	}
}

for (var i = 0; i < links.length; i++) {
	links[i].addEventListener("mouseenter", mouseenterFunc);
}

function resizeFunc() {
	var active = document.querySelector("#head li.active");

	if (active) {
		var left = active.getBoundingClientRect().left + window.pageXOffset;
		var top = active.getBoundingClientRect().top + window.pageYOffset;

		target.style.left = left + "px";
		target.style.top = top + "px";
	}
}

window.addEventListener("resize", resizeFunc);*/