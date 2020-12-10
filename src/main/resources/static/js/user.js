$.ajax({
    async: false,
    url: "/user",
    type: "post",
    data: "",
    dataType: "json",
    success: function (data) {
        console.log(data)
        var tablelistsize = document.getElementById("list");//获取table
        var line = tablelistsize.rows[0].cells;//首先获得表格有多少列
        var x = tablelistsize.insertRow(1);//在第n行开始插入，第0行为标题
        var listlinner = Object.keys(data).length;//用户数（行数）
        for (var j = 0; j < listlinner; j++) {//行数
            var x = tablelistsize.insertRow(1 + j);
            for (var i = 0; i < line.length; i++) {
                var y = x.insertCell(i);
                if (i == 0) {
                    y.innerHTML = j + 1;
                } else if (i == 1) {
                    y.innerHTML = data[j + 1][0].username;
                } else if (i == 2) {
                    y.innerHTML = data[j + 1][0].password;
                }
            }
        }
    }
})