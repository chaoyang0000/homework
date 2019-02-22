<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/12/6
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>easyUI</title>
    <%--引入jquery脚本库--%>
    <%--引入easyUI脚本库--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min1.3.5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min1.3.5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN1.3.5.js"></script>
    <%--引入两个样式--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/default/easyui.css" type="text/css">
    <script type="text/javascript">
       /* $(function () {
            $("#username").validatebox({
                required:true,
                /!*当设置了必填项没有输入内容显示的内容*!/
                missingMessage:"用户名不能为空",

            })
            $.extend($.fn.validatebox.defaults.rules, {
                checkPassword: {
                    /!*
                    * validator验证器函数
                    * value输入框中的内容
                    * 符合要求返回true不符合要求返回false
                    * *!/
                    validator: function(value, param){
                        /!*正则表达式进行验证*!/
                        var reg=/^\d{6}$/

                        return reg.test(value);
                    },
                    /!*无效信息当不满足验证条件返回FALSE时会显示*!/
                    message:"请输入六位数字"
                }
            });

            $("#password").validatebox({
                required:true,
                missingMessage:"密码输入不能为空",
                /!*使用自己定义的判断规则*!/
                validType:"checkPassword"

            })

            $.extend($.fn.validatebox.defaults.rules, {
                checkRePassword: {
                    validator: function(value, param){
                       var i= $(param[0]).val();
                        return value==i;
                    },
                    message:"两次输入的密码不一致"
                }
            });
            $("#rePassword").validatebox({
                required:true,
                missingMessage:"确认密码不能为空",
                validType:"checkRePassword['#password']"

            })
        })
*/
        /*登陆*/
        $(function () {
            $("#username1").validatebox({
                required:true,
                missingMessage:"输入的账号不能为空",
            })
            $.extend($.fn.validatebox.defaults.rules, {
                checkPassword: {
                    /*
                    * validator验证器函数
                    * value输入框中的内容
                    * 符合要求返回true不符合要求返回false
                    * */
                    validator: function(value, param){
                        /*正则表达式进行验证*/
                        var reg=/^\d{6}$/

                        return reg.test(value);
                    },
                    /*无效信息当不满足验证条件返回FALSE时会显示*/
                    message:"请输入六位数字"
                }
            });
            $("#password1").validatebox({
                required:true,
                missingMessage:"输入的密码不能为空",
                validType:"checkPassword"
            })


        })


    </script>
</head>
<body>
<%--&lt;%&ndash;注册验证&ndash;%&gt;
用户名:<input type="text" id="username"><br>
密码:<input type="password" id="password"><br>
确认密码:<input type="password" id="rePassword"><br>
<input type="button" value="注册">--%>
<h1 align="center">欢迎使用医院分诊管理系统</h1>
<h3 align="center" style="color: red">${request.error}</h3>
<form action="${pageContext.request.contextPath}/login" method="post">
用户名:<input type="text" id="username1" name="username"><br>
密码:<input type="text" id="password1" name="password"><br>
验证码:<input type="text" name="code"><img src="${pageContext.request.contextPath}/getImage" ><br>
    <input type="submit" value="登陆" ><a href="${pageContext.request.contextPath}/Regist.jsp" style="color: red">前往注册</a>
</form>
</body>
</html>
