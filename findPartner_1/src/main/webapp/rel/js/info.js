$('.mgdiv').hide();
function loadInfo() {
	$.post("user/uid", function(data) {
		if (data == null || data == "") {
			return false;
		}
		$("#nickname").val(data.nickname);
		$("#uname").val(data.login.uname);
		$("#email").html(data.login.email);
		$("#age").html(data.age);
		$("#phone").val(data.login.phone);
		$("#lid").val(data.login.lid);

		$("#gender").val(data.login.gender);
		checked(data.login.gender)
		$(".birthday1").val(data.birthday);

		$("#star").val(data.star);
		$("#job").val(data.job);
		$("#company").val(data.company);
		$("#school").val(data.school);
		$("#hobby").val(data.hobby);

		$("#address").val(data.address);
		$("#hometown").val(data.hometown);

		$("#distpicker").distpicker('destroy');
		$("#distpicker").distpicker({
			autoSelect : false,
			placeholder : true
		});
		if(data.aressa!=null&&data.aressa!=""){
			ashowdistpicker(data.aressa.province, data.aressa.city,
					data.aressa.district);
		}
		if(data.aressh!=null&&data.aressh!=""){
			hshowdistpicker(data.aressh.province, data.aressh.city,
					data.aressh.district);
		}
	}, "json")
}
loadInfo();
function checked(obj) {
	if (obj == "女") {
		$('#inlineRadio2').attr("checked", true);
	} else if (obj == "男") {
		$('#inlineRadio1').attr("checked", true);
	} else {
		$('#inlineRadio1').attr("checked", true);
		return false;
	}
}
function ashowdistpicker(ps, cs, ds) {
	var $province = $(".province");
	$province.val(ps);
	$province.trigger("change");
	var $city = $(".city");
	$city.val(cs);
	$city.trigger("change");
	var $district = $(".district");
	$district.val(ds);
	$district.trigger("change");
}
function hshowdistpicker(ps, cs, ds) {
	var $province = $(".hprovince");
	$province.val(ps);
	$province.trigger("change");
	var $city = $(".hcity");
	$city.val(cs);
	$city.trigger("change");
	var $district = $(".hdistrict");
	$district.val(ds);
	$district.trigger("change");
}
function update() {
	$('#province').val($(".province option:checked").text());
	$('#hprovince').val($(".hprovince option:checked").text());
	$('#city').val($(".city option:checked").text());
	$('#hcity').val($(".hcity option:checked").text());
	$('#district').val($(".district option:checked").text());
	$('#hdistrict').val($(".hdistrict option:checked").text())
	$('#gender').val($('.opdiv input[name="inlineRadioOptions"]:checked ').val());
	$('.birthday').val($('.birthday1').val());
	$('.uform').submit();
	/*$('.mgdiv').show();
	$('.mg').html("系统错误....");*/
}
function loadPage(href) {
	$.ajaxSetup({cache: false });
	$(".other").load(href);
}
function reload(){
	parent.location.reload();// 刷新缓存
}