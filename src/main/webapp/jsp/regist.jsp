<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script src="/js/jquery-1.12.4.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="/js/axios.js"></script>
<script src="/js/vue.js"></script>
<script src="/js/jquery.cookie.js"></script>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <form action="http://wwww.baidu.com" class="">

            <div class="form-group has-feedback">
                <label for="username">用户名</label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    <input id="username" class="form-control" placeholder="请输入用户名" maxlength="20" type="text">
                </div>

                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class=" glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

            <div class="form-group has-feedback">
                <label for="password">密码</label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="password" class="form-control" placeholder="请输入密码" maxlength="20" type="password">
                </div>

                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

            <div class="form-group has-feedback">
                <label for="passwordConfirm">确认密码</label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="passwordConfirm" class="form-control" placeholder="请再次输入密码" maxlength="20"
                           type="password">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>


            <div class="row">
                <div class="col-xs-7">
                    <div class="form-group has-feedback">
                        <label for="idcode-btn">验证码</label>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-qrcode"></span></span>
                            <input class="form-control" placeholder="请输入验证码" maxlength="4" type="text">
                        </div>
                        <span style="color:red;display: none;" class="tips"></span>
                        <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                        <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                </div>
                <div class="col-xs-5" style="padding-top: 30px">
                    <div id="idcode" style="background: transparent;"></div>
                </div>
            </div>

            <div class="form-group has-feedback">
                <label for="phoneNum">手机号码</label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                    <input id="phoneNum" class="form-control" placeholder="请输入手机号码" maxlength="11" type="text">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

            <div class="row">
                <div class="col-xs-7">
                    <div class="form-group has-feedback">
                        <label for="idcode-btn">校验码</label>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-qrcode"></span></span>
                            <input id="idcode-btn" class="form-control" placeholder="请输入校验码" maxlength="6" type="text">
                        </div>
                        <span style="color:red;display: none;" class="tips"></span>
                        <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                        <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                </div>
                <div class="col-xs-5 text-center" style="padding-top: 26px">
                    <button type="button" id="loadingButton" class="btn btn-primary" autocomplete="off">获取短信校验码</button>
                </div>
            </div>

            <div class="form-group">
                <input class="form-control btn btn-primary" id="submit" value="立&nbsp;&nbsp;即&nbsp;&nbsp;注&nbsp;&nbsp;册"
                       type="submit">
            </div>

            <div class="form-group">
                <input value="重置" id="reset" class="form-control btn btn-danger" type="reset">
            </div>
        </form>
    </div>
</div>
</body>
</html>
