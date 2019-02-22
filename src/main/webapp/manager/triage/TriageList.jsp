<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
		<!--font-awesome字体图标库-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
		<script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<title>分诊管理</title>
		<style type="text/css">
			th {
				text-align: center;
			}
			
			body {
				background-color: #ffff1;
			}
			
			html {
				margin: 1px;
			}
		</style>
	</head>

	<body>
		<iframe src="../../iframe/nav.html" width="100%" frameborder="0"></iframe>
		<div style="margin-bottom:30px" class="container-fluid">

			<!--统计信息-->
			<div class="row">
				<!--当前科室下，所有待诊断的患者信息：按照序号，按照未诊断优先-->
				
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<table class="table table-bordered table-hover">
						<thead>
							<tr class="bg-primary" style="font-size: 25px;">
								<th colspan="6">科室患者信息 · ${pageScope.tDepartment.name}</th>
							</tr>
							<tr class="bg-info">
								<th>序号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>出生年月日</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${requestScope.list}" var="triage">
							<tr>
								<td>${triage.id}</td>
								<td>${triage.tPatient.name}</td>
								<c:if test="${triage.tPatient.sex==0}">
									<td>男</td>
								</c:if>
								<c:if test="${triage.tPatient.sex==1}">
									<td>女</td>
								</c:if>
								<td>${triage.tPatient.birth}</td>
								<c:choose>
									<c:when test="${triage.status==0}">
										<td class="text-primary">等待诊断 </td>
									</c:when>
									<c:when test="${triage.status==1}">
										<td class="text-primary">诊断结束 </td>
									</c:when>
									<c:otherwise>
										<td class="text-primary">诊断中 <i class="fa fa-spinner fa-spin"></i></td>
									</c:otherwise>

								</c:choose>
								<td>
									<a href="${pageContext.request.contextPath}/triage/updateTriageStatus?id=${triage.id}" class="btn btn-xs btn-success">叫号 <i class="fa fa-user-circle"></i></a>
									<c:if test="${triage.status==0}">
										<a href="#" class="btn disabled btn-xs btn-primary">诊断 <i class="fa fa-medkit"></i></a>
									</c:if>
									<c:if test="${triage.status==1}">
										<a href="#" class="btn disabled btn-xs btn-primary">诊断 <i class="fa fa-medkit"></i></a>
									</c:if>
									<c:if test="${triage.status==2}">
										<a href="${pageContext.request.contextPath}/triage/selectDoctorAndPatient?id=${triage.tPatient.id}" class="btn btn-xs btn-primary">诊断 <i class="fa fa-medkit"></i></a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
		<!--分页-->
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<ul class="pager">
					<li class="previous"><a href="#" class="btn btn-default">上一页</a></li>
					<li><a href="#" class="btn btn-default active disabled">第2页</a></li>
					<li class="next"><a href="#" class="btn btn-default">下一页</a></li>
				</ul>
			</div>
			<div class="col-md-4"></div>
		</div>
		<!--底部-->
		<footer class="panel-footer navbar-fixed-bottom">
			<div class="container">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8" style="text-align: left;">
						&trade;百知教育 网址:
						<a href="http://www.baizhiedu.com">http://www.baizhiedu.com</a>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>

		</footer>
	</body>

</html>