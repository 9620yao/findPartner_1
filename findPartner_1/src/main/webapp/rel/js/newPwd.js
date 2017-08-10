var url = window.location.href;
var email = url.split('?')[1].split('=')[1];
alert(email);
$('#newemail').val(email);