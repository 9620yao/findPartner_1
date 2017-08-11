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
