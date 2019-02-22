<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/site.css" />
		<title></title>
	</head>
	<body>
		<div class="list-group">
		  <a class="list-group-item" href="${pageContext.request.contextPath}/DepartmentList.jsp"><i class="fa fa-home fa-fw"></i>&nbsp; 科室管理</a>
		  <a class="list-group-item" href="${pageContext.request.contextPath}/PatientList.jsp"><i class="fa fa-book fa-fw"></i>&nbsp; 患者管理</a>
		  <a class="list-group-item" href="${pageContext.request.contextPath}/triage/getAll"><i class="fa fa-pencil fa-fw"></i>&nbsp; 分诊管理</a>
		  <a class="list-group-item" href="${pageContext.request.contextPath}/DrugList.jsp"><i class="fa fa-cog fa-fw"></i>&nbsp; 医药采购平台</a>
		</div>
	</body>
</html>
