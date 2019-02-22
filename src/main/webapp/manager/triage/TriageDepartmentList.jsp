<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
		<title>医院分诊管理系统首页</title>
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
		<iframe src="${pageContext.request.contextPath}/iframe/nav.html" width="100%" frameborder="0"></iframe>
		<div style="margin-bottom:30px" class="container-fluid">

			<!--统计信息-->
			<div class="row">
				<!--各个科室的分诊信息-->
				
				<div class="col-md-3">
					<div class="panel panel-default">
						<div class="panel-heading">
							<p style="text-align: center;">
								<span class="bg-primary" style="font-size: 25px;"> ${requestScope.tDepartment.name} <i class="fa fa-home"></i> </span>
							</p>
						</div>
						<div class="panel-body">
							<p>待诊断人数: <span class="badge">${requestScope.count}</span></p>
							<a href="${pageContext.request.contextPath}/triage/selectAllTriage" class="btn btn-success">开诊 <i class="fa fa-angle-double-right"></i></a>
						</div>
						<div class="panel-footer" style="text-align: right;">
							<span class="text-primary">${requestScope.tDepartment.area}</span>
						</div>
					</div>
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