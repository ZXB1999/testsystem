// 发送密码到后台
$("#sendTo").click(function () {
    var username=$("#username").val();
    var password=$("#password").val();
    $.ajax({
        async:false,
        url:"/login",
        type:"post",
        data:"&username="+username+"&password="+password,
        dataType:"json",
        success: function (data) {
            if(data.code == "1"){
                window.location.href = "/homepage";
            }else if(data.code == "2"){
                delCookie('username',' ',-1);
                window.location.href = "";
            }else{
                sweetAlert("error");
            }
        }
    })
})

//设置cookie
var setCookie = function (name, value, day) {
    //当设置的时间等于0时，不设置expires属性，cookie在浏览器关闭后删除
    var expires = day * 24 * 60 * 60 * 1000;
    var exp = new Date();
    exp.setTime(exp.getTime() + expires);
    document.cookie = name + "=" + value + ";expires=" + exp.toUTCString();
};

//传递cookie
function UserName() {
    var name = document.getElementById("username");
    if(name!=null){
        setCookie('username',name.value,1);
        location.href = 'http://localhost:8091/homepage'
    }else{
        delCookie('username',' ',-1);
        location.href = 'http://localhost:8091'
    }
}

//获取cookie代码
var getCookie = function (name) {
    var arr;
    var reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg)){
        return arr[2];
    }
    else
        return null;
};

// 点击获取按钮之后调用的函数
// function getcookie() {
//     console.log(getCookie("username"));
//
// }
// function deletecookie() {
//     delCookie('username',' ',-1)
// }

// 删除cookie
var delCookie = function (name) {
    setCookie(name, ' ', -1);
};