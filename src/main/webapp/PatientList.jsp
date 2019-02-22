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
  <%--引入两个样式--%>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/icon.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/default/easyui.css" type="text/css">
  <script type="text/javascript">
      $(function () {
          $("#myDatagrid").datagrid({
              title:"患者表格",
              url:"${pageContext.request.contextPath}/selectPatientByPage",
              /*让datagrid做分页*/
              pagination:true,
              toolbar:"#myTools",
              columns:[[
                  {checkbox:true},
                  {field:"id",title:"编号"},
                  {field:"name",title:"姓名"},
                  {field:"sex",title:"性别",formatter:function (value,rowData,rowIndex) {
                          if(value==0){
                              return "女"
                          }
                          return "男"
                      }},
                  {field:"birth",title:"出生日期",formatter:function (value,rowData,rowIndex) {
                          var date=new Date(value)
                          var year=date.getFullYear();
                          var month=date.getMonth()+1;
                          var day=date.getDay();
                          return year+"/"+month+"/"+day
                      }},
                  {field:"idcard",title:"身份证号"},
                  {field:"address",title:"住址"},
                  {field:"mobile",title:"手机号"},
                  {field:"status",title:"操作",formatter:function (value,rowData,rowIndex) {
                      if(value==0){
                          return "<a href='${pageContext.request.contextPath}/triage/selectById?id="+rowData.id+"' style='color: red'>挂号</a>"+"<a href='' style='color:green'>下载诊断</a>"

                      }else{
                          return "<a href='#' style='color: green'>已经挂号</a>"+"<a href='' style='color:green'>下载诊断</a>"
                      }
                      }}
              ]],

              //修改③：双击的时候，打开修改对话框
              onDblClickRow:function(rowIndex, rowData){
                  //打开修改对话
                  //把原本的内容写入到修改对话框中对应的输入框中，显示出来
                  toOpenUpdateDialog(rowIndex,rowData);

              },
              //修改③：双击的时候，打开修改对话框===END===
          })

          //修改②：把修改div标签转换成dialog控件效果
          $("#updateDiv").dialog({
              closed:true,
              width:300,
              height:150,
              title:"修改对话框"
          })
          //修改②：把修改div标签转换成dialog控件效果=====END====

          $("#myInsert").dialog({
              closed:true,
              width:300,
              height:150,
              title:"添加对话框"
          })
      })
      /*修改第一步*/


      //修改④：定义一个函数，用来打开修改对话框以及显示原始内容
      function toOpenUpdateDialog(rowIndex,rowData) {
          //打开修改对话框；调用dialog的open方法，把对话框打开
          $("#updateDiv").dialog("open");

          //显示原始数据
          $("#updateId").val(rowData.id);
          $("#updateName").val(rowData.name);
         if(rowData.sex==1){
             $("#updateSex").prop("checked","checked");
         }else{
             $("#updateSex1").prop("checked","checked");
         }
          $("#updateIdcard").val(rowData.idcard);
          $("#updateAddress").val(rowData.address);
          $("#updateMobile").val(rowData.mobile);





      }
      /*条件查询*/
      function search() {
          var name=$("#name").val();
          console.log("******"+name)
          $("#myDatagrid").datagrid("load",{"name":name})
      }
      function doUpdate() {
          alert("进来修改了")
          $("#updateForm").form("submit",{
              url:"${pageContext.request.contextPath}/updatePatient",
              success:function (data) {
                  console.log(data)
                  if(data=="true"){
                      $("#updateDiv").dialog("close")
                      $("#myDatagrid").datagrid("reload")
                  }else{
                      $.messager.alert("警告框","修改失败","error")
                      $("#updateDiv").dialog("close")

                  }
              }
          })
      }
      /*添加*/
      /*第一步打开添加输入框*/
      function toOpenAddDialog() {
          $("#myInsert").dialog("open")
      }
      /*进行添加*/
      function doInsert() {
          alert("进来添加")
          $("#insertForm").form("submit",{
              url:"${pageContext.request.contextPath}/insertPatient",
              success:function(data){
                  if(data=="true"){
                      $("#myInsert").dialog("close")
                      $("#myDatagrid").datagrid("reload")
                  }else{
                      $.messager.alert("警告框","添加失败","error")

                  }
              }
          })
      }


      /*批量删除*/
      function doMultiDelete() {
          //1.返回所选中的内容
          //2.判断是否有选中的内容
          //3.if没有选中内容给出提示，选中的话给一个提示框是否确认删除
          var selectRows=$("#myDatagrid").datagrid("getSelections");
          if(selectRows.length==0){
              $.messager.alert("删除提示框","没有选中内容请选中内容再进行删除","info")
          }else {
              alert("确认要删除吗");
              //创建一个数组
              var selectIds=new Array(selectRows.length);
              //遍历选中的数组获得选中的id值进行批量删除
              for (var i = 0; i <selectRows.length ; i++) {
                  selectIds[i]=selectRows[i].id;
              }
              $.ajax({
                  url:"${pageContext.request.contextPath}/multiDelete1",
                  data:"id="+selectIds,
                  traditional:true,
                  success:function (data) {
                      if(data==true){
                          $("#myDatagrid").datagrid("reload");
                      }else{
                          $.messager.alert("删除提示框","删除失败","error")
                      }
                  }
              })
          }

      }
  </script>
</head>
<body>
姓名:<input id="name"><input type="button" onclick="search()" value="搜索">
<table id="myDatagrid"></table>
<%--添加按钮--%>
<div id="myTools">
  <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="toOpenAddDialog()">添加</a>
  <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="doMultiDelete()">批量删除</a>

</div>
<%--添加--%>
<div id="myInsert">
  <form id="insertForm">
    姓名:<input type="text" name="name"><br>
    性别:<input type="radio" name="sex" value="1" checked="checked">男
    <input type="radio" name="sex" value="0">女<br>
    出生日期:<input type="date" name="birth"><br>
    身份证号:<input type="text" name="idcard"><br>
    家庭住址:<input type="text" name="address"><br>
    电话:<input type="text" name="mobile"><br>
    <input type="button" value="确认添加" onclick="doInsert()">
  </form>
</div>


<%--修改①：修改对话框对应的HTML--%>
<div id="updateDiv">
  <form method="post" id="updateForm">
    <input type="hidden" id="updateId" name="id">
    姓名：<input id="updateName" name="name"/><br>
    性别:<input type="radio" name="sex" value="1" id="updateSex">男
    <input type="radio" name="sex" value="0" id="updateSex1">女<br>
    身份证号：<input id="updateIdcard" name="idcard"><br>
    地址：<input id="updateAddress" name="address"><br>
    手机号：<input id="updateMobile" name="mobile"><br>

    <input type="button" value="修改" onclick="doUpdate()"/>
  </form>
</div>
<%--修改①：====END====--%>
</body>
</html>
