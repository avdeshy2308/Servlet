function fn(){
	var str=f1.uname.value;
	var str1=f1.pass.value;
	if(str.length==0){
		alert("Please Enter UserName")
		return false;
	}
	if(str1.length==0){
		alert("Please Enter Password")
		return false;
	}
}