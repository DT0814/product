<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/jquery-1.12.4.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script src="/js/axios.js"></script>
    <script src="/js/vue.js"></script>
    <script src="/js/jquery.cookie.js"></script>
</head>
<body>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<div class="container" id="bd">
    <div class="col-md-6 col-md-offset-3">
        <form id="loginForm">
            <div class="form-group has-feedback">
                <label>账号</label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    <input name="account" class="form-control" placeholder="请输入登录账号" maxlength="20" type="text">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class=" glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <label>密码</label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input name="pass" class="form-control" placeholder="请输入密码" maxlength="20" type="password">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-7">
                    <div class="form-group has-feedback">
                        <label>验证码</label>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-qrcode"></span></span>
                            <input class="form-control" name="vali" placeholder="请输入验证码" maxlength="4" type="text">
                        </div>
                        <span style="color:red;" class="tips">
                            <img v-on:click="updateValidate($event)" src="${APP_PATH}/currency/validate.action"/>
                        </span>
                        <span class="glyphicon glyphicon-remove form-control-feedback"></span>
                        <span class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                </div>
                <div class="col-xs-5" style="padding-top: 30px">
                    <div id="idcode" style="background: transparent;"></div>
                </div>
            </div>
            <div class="form-group">
                <input class="form-control btn btn-primary" value="登录" v-on:click="login()">
            </div>
        </form>
    </div>
</div>
<script>
    var vu = new Vue({
                el: "#bd",
                data: {},
                methods: {
                    updateValidate: function (ele) {
                        $(ele.currentTarget).prop("src", "${APP_PATH}/currency/validate.action?" + new Date());
                    },
                    login: function () {
                        axios.post("/user/login.action", $("#loginForm").serialize()).then(function (response) {
                            console.log(response);
                            var data = response.data;
                            if (data.code != 200) {
                                alert(data.msg);
                            } else {
                                $.cookie('user_name', data.name, {expires: 7, path: '/'});
                                $.cookie('user_uid', data.uid, {expires: 7, path: '/'});
                                $.cookie('user_isLogin', true, {expires: 7, path: '/'});
                                location.href = "/jsp/index.jsp";
                            }
                        });
                    }
                }
            }
    );


</script>
</body>
</html>
