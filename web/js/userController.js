/**
 * 系统用户管理前端控制器
 */

/**
 * 登录校验
 * @returns
 */
function loginCheck() {
    var account = $("#account").val();
    var password = $("#password").val();
    var url = $("#url").val();
    if (account == "") {
        // alert(123)
        $("#mes").html("请填写登陆账号！！！");
        return false;
    } else if (password == "") {
        $("#mes").html("请输入用户密码！！！");
        return false;
    } else {
        $.ajax({
            type : "post",
            url : url,
            data : {
                account : account,
                password : password
            },
            success : function(data) {
                if (data == "登录失败") {
                    $("#mes").html("登录失败，核对账号密码！！");
                } else {
                    window.location.href = "/jsp/frame/main.jsp";
                }
            }
        });
    }
}
/*注册用户*/
function reguser(){
    var xhttp = getXhttpObject();
    var name = $("#name").val();
    var account = $("#account").val();
    var password = $("#password").val();
    var url = $("#url").attr("value");
    if(name == "" || name =="null" || name == "undefined" || name == undefined )
    {
        $("#mes").html("请填写用户名称！");
        return false;
    }else if(account == "" || account =="null" || account == "undefined" ||
        account === undefined ){
        $("#mes").html("请填写用户帐号！");
        return false;
    }else if(password == "" || password =="null" || password == "undefined" ||
        password == undefined ){
        $("#mes").html("请填写用户密码！");
        return false;
    }else{
        xhttp.onreadystatechange=function(){
            if(this.readyState==4){
                if(this.status == 200 ){
                    var res = this.responseText;
                    alert(res);
                }else{
                    alert(res);
                }
            };
//打开传输通道
            xhttp.open('POST', url, true);//异步通信吗??
//定义传输的文件HTTP头信息
            xhttp.setRequestHeader("Content-type",
                "application/x-www-form-urlencoded");
//发送 无参数时发送null
// xmlHttp.send(null);
            xhttp.send("name=" + name + "&password=" +
                password+"&account"+account);
        }
    }
}
/**
 * 用户注册校验
 *
 * @returns {Boolean}
 */
function reg() {
    $("#mesg").html("");
    var name = $("#name").val();
    var password = $("#password").val();
    var account = $("#account").val();
    var qrmm = $("#qrmm").val();
    var url = $("#url").attr("value");
    if (name == "") {
        $("#mesg").html("请填写用户姓名");
        return false;
    } else if (password == "") {
        $("#mesg").html("请填写用户密码");
        return false;
    } else if (qrmm == "") {
        $("#mesg").html("请填写确认密码");
        return false;
    } else if (password != qrmm) {
        $("#mesg").html("两次密码输入不相同，请重新输入");
        return false;
    } else if (account == "") {
        $("#mesg").html("请填写注册账号");
    } else {
        $.ajax({
            type : "post",
            data : {
                account : account
            },
            url : url,
            success : function(data) {
                if (data == "tg") {
                    $.ajax({
                        type : "post",
                        url : $('#regForm').attr("action"),
                        data : $('#regForm').serialize(),
                        success : function(data) {
                            if (data == "cg") {
                                $("#mesg").html("注册成功，请返回后登陆系统");
                            } else {
                                $("#mesg").html("注册失败，请重试");
                            }
                        }
                    });
                } else if (data == "cf") {
                    $("#mesg").html("注册账号已存在，请重新填写注册账号！");
                }
            }
        });
    }
}