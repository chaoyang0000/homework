<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/12/18
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <%--引入easyUI脚本库--%>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min1.3.5.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min1.3.5.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN1.3.5.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>

  <%--引入两个样式--%>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/icon.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/default/easyui.css" type="text/css">
  <script type="text/javascript">
        $(function () {
            $("#myDategrid").datagrid({
                title:"部门表格",
                url:"${pageContext.request.contextPath}/selectByPage",
                /*让datagrid做分页*/
                pagination:true,
                toolbar:"#myTools",
                columns:[[
                    {checkbox:true},
                    {field:"id",title:"编号"},
                    {field:"name",title:"名称"},
                    {field:"telephone",title:"办公室电话"},
                    {field:"area",title:"所在区域"},
                    {field:"cz",title:"操作",formatter:function (value,rowData,rowIndex) {
                            return "<span style='color: red'>双击进行修改</span>"
                        }}
                ]],
            })
        })
  </script>

  <body>
  <table id="myDategrid"></table>
  </body>
</html>
