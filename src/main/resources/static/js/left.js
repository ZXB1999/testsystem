/*打开侧栏，修改侧栏宽度，主体左跨度、背景透明度*/
function openNav() {
	document.getElementById("mySidenav").style.width = "250px";
	document.getElementById("main").style.marginLeft = "250px";
	document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}
/*关闭侧栏，恢复原始侧栏宽度，主体左跨度、背景透明度*/
function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
	document.getElementById("main").style.marginLeft = "0";
	document.body.style.backgroundColor = "white";
}
// 汉堡菜单跳转
function runtoline(data) {
	var type = data.type;
	if (type==1){
		document.getElementById("SrC").src="http://localhost:8091/userlist";
		$("#run1").click(function () {
			$.ajax({
				async:false,
				url:"/user",
				type:"post",
				data:"",
				dataType:"json",
				success: function (data) {
					console.log(data)
				}
			})
		})
	}else if (type==2){
		document.getElementById("SrC").src="http://localhost:8091/job";
	}else if (type==3){
		document.getElementById("SrC").src="http://localhost:8091/swagger-ui.html";
	}else if (type==4){
		document.getElementById("SrC").src="http://localhost:8091/findStudentBySex";
	}else if (type==5){
		document.getElementById("SrC").src="http://localhost:8091/uploadpage";
	}
}