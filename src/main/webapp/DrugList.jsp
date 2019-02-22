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
      $(function () {
          $("#myDatagrid").datagrid({
              title:"患者表格",
              url:"${pageContext.request.contextPath}/selectByPageDrug",
              /*让datagrid做分页*/
              pagination:true,
              toolbar:"#myTools",
              columns:[[
                  {checkbox:true},
                  {field:"id",title:"编号"},
                  {field:"name",title:"药品名"},
                  {field:"spec",title:"规格"},
                  {field:"unit",title:"单位"},
                  {field:"productCompany",title:"生产企业" },
                  {field:"productDate",title:"生产日期",formatter:function (value,rowDate,rowIndex) {
                          var date=new Date(value)
                          var year=date.getFullYear();
                          var month=date.getMonth()+1;
                          var day=date.getDay();
                          return year+"/"+month+"/"+day

                      }},
                  {field:"okDate",title:"保质期至",formatter:function (value,rowDate,rowIndex) {
                          var date=new Date(value)
                          var year=date.getFullYear();
                          var month=date.getMonth()+1;
                          var day=date.getDay();
                          return year+"/"+month+"/"+day

                      }},
                  {field:"importPrice",title:"进价"},
                  {field:"price",title:"零售价"},

                  {field:"saleStatus",title:"销售状态",formatter:function (value,rowData,rowIndex) {
                          if(value==0){
                              return "正常销售"
                          }else{
                              return "停售"
                          }
                      }},
                  {field:"isImport",title:"是否是进口",formatter:function (value,rowData,rowIndex) {
                          if(value==0){
                              return "进口"
                          }else{
                              return "非进口药"
                          }
                      }},
                  {field:"description",title:"产品说明"},
                  {field:"cz",title:"操作",formatter:function (value,rowData,rowIndex) {
                      console.log("+++++"+rowData.id)
                       console.log("*****"+rowData.saleStatus)
                      if(rowData.saleStatus==0){
                          return "<a href=\"${pageContext.request.contextPath}/updateSaleStatus?id="+rowData.id+"&saleStatus="+rowData.saleStatus+"\">停售</a>"+"<a href=\"\" style='color:green'>提交审核</a>"
                      }else{
                          return "<a href=\"${pageContext.request.contextPath}/updateSaleStatus?id="+rowData.id+"&saleStatus="+rowData.saleStatus+"\" style='color: red'>上架</a>"+"<a href=\"${pageContext.request.contextPath}/updateExamStatus?id="+rowData.id+"\" style='color:green'>提交审核</a>"
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
      })
      /*修改第一步*/


      //修改④：定义一个函数，用来打开修改对话框以及显示原始内容
      function toOpenUpdateDialog(rowIndex,rowData) {
          //打开修改对话框；调用dialog的open方法，把对话框打开
          $("#updateDiv").dialog("open");

          //显示原始数据
          $("#updateId").val(rowData.id);
          $("#updateName").val(rowData.name)
          $("#updateSpec").val(rowData.spec)
          $("#updateUnit").val(rowData.unit)
          $("#updateCompany").val(rowData.productCompany)
          var date=new Date(rowData.productDate)
          var year=date.getFullYear();
          var month=date.getMonth()+1;
          var day=date.getDay();
          var date1=year+"/"+month+"/"+day
         $("#updateProductDate").val(date1)

          var date=new Date(rowData.okDate)
          var year=date.getFullYear();
          var month=date.getMonth()+1;
          var day=date.getDay();
          var date2=year+"/"+month+"/"+day
         $("#updateOkDate").val(date2)
          $("#updateImportPrice").val(rowData.importPrice)
          $("#updatePrice").val(rowData.price)
          if(rowData.saleStatus==0){
              $("#updateSaleStatus").prop("checked","checked");
          }else{
              $("#updateSaleStatus1").prop("checked","checked")

          }
          if(rowData.isImport==0){
              $("#updateIsImport").prop("checked","checked");
          }else{
              $("#updateIsImport1").prop("checked","checked")

          }
          $("#updateDescription").val(rowData.description)






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
              url:"${pageContext.request.contextPath}/updateDrug",
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

      function toOpenAddDialog() {
          window.location.href="${pageContext.request.contextPath}/manager/drug/AddDrug.jsp"

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
                  url:"${pageContext.request.contextPath}/multiDeleteDrug",
                  data:"ids="+selectIds,
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
药品名:<input id="name"><input type="button" onclick="search()" value="搜索">
<table id="myDatagrid"></table>
<%--添加按钮--%>
<div id="myTools">
  <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="toOpenAddDialog()">添加</a>
  <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="doMultiDelete()">批量删除</a>

</div>



<%--修改①：修改对话框对应的HTML--%>
<div id="updateDiv">
  <form method="post" id="updateForm">
    <input type="hidden" id="updateId" name="id"/>
    药品名称:<input type="text" id="updateName" name="name"/><br/>
    药品规格:<input type="text" id="updateSpec" name="spec"/><br/>
    药品单位:<input type="text" id="updateUnit" name="unit"/><br/>
    生产公司:<input type="text" id="updateCompany" name="productCompany"/><br/>
    生产日期:<input type="text" id="updateProductDate" name="productDate"/><br/>
    保质期至:<input type="text" id="updateOkDate" name="okDate"/><br/>
    进价:<input type="text" id="updateImportPrice" name="importPrice"/><br/>
    零售价:<input type="text" id="updatePrice" name="price"/><br/>
    销售状态:<input type="radio" id="updateSaleStatus" name="saleStatus" value="0"/>正常
    <input type="radio" id="updateSaleStatus1" name="saleStatus" value="1"/>停售<br/>
    是否进口:<input type="radio" id="updateIsImport" name="isImport" value="0"/>是
    <input type="radio" id="updateIsImport1" name="isImport" value="1"/>非进口<br/>
    药品描述:<input type="text" id="updateDescription" name="description"/>
    <input type="button" value="修改" onclick="doUpdate()"/>
  </form>
</div>
</body>
</html>
