<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="../../css/style.css"/>
	<!--font-awesome字体图标库-->
	<link rel="stylesheet" type="text/css" href="../../css/font-awesome.min.css"/>
	<script src="../../js/jquery-1.10.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="../../js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<title>患者管理</title>
<style type="text/css">
	th {
		text-align: center;
	}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<iframe src="../../iframe/nav.html" width="100%" frameborder="0"></iframe>
		</div>
		<!--按钮工具栏-->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-2">
			</div>
			<div class="col-md-3">
				<form action="#" class="form form-inline input-group">
					<input type="text" class="form-control" placeholder="请输入日志关键词" name="name" id="name" />
					<span class="input-group-btn"><input type="submit" class="btn btn-success" value="搜索" /></span>	
				</form>
			</div>				
			<div class="col-md-5"></div>
		</div>
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<!--信息管理table-->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr class="bg-info text-capitalize">
							<th>id</th>
							<th>操作人</th>
							<th>内容</th>
							<th>时间</th>
						</tr>
					</thead>
					<tbody style="text-align: center;">
						<tr>
							<td>101</td>
							<td>菩提老祖</td>
							<td>诊断了病人wangyx</td>
							<td>2018年12月21日20:56:19</td>
						</tr>
						<tr>
							<td>101</td>
							<td>菩提老祖</td>
							<td>诊断了病人wangyx</td>
							<td>2018年12月21日20:56:19</td>
						</tr>
						<tr>
							<td>101</td>
							<td>菩提老祖</td>
							<td>诊断了病人wangyx</td>
							<td>2018年12月21日20:56:19</td>
						</tr>
						<tr>
							<td>101</td>
							<td>菩提老祖</td>
							<td>诊断了病人wangyx</td>
							<td>2018年12月21日20:56:19</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-2"></div>
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
		<div class="row">
			<div class="com-md-12">
				<!--底部-->
				<footer class="modal-footer navbar-fixed-bottom">
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-8" style="text-align: left;">
							&trade;百知教育 网址:<a href="http://www.baizhiedu.com">http://www.baizhiedu.com</a>
						</div>
						<div class="col-md-2"></div>
					</div>
				</footer>
			</div>
		</div>
	</div>
</body>
</html>
