function loginCheck() {
    var username = $("#username");
    if (null == username || username == "") {
        alert("username is empty!");
        return false;
    }
    var password = $("#password");
    if (null == password || password == "") {
        alert("password is empty!");
        return false;
    }
    return true;
}
function login() {
    var username = $("#username").val();
    var password = $("#password").val();
    alert(username);
    if (loginCheck() == false) {
        return false;
    }
    //提交表单
    $.ajax({
        url: "login/login",
        type: "post",
        dataType: "json",
        async: false, //加上之后不在跳转进error
        data: {
            username: username,
            password: password
        },
        success: function (result) {
            //console.log(result);
            alert("11111111111");
            alert(result.message);
            if (result.code == 200) {
                window.location.href = "login/success";
            } else {
                //alert(result.message);
            }
            window.location.href = "login/success";
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("222222");
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}