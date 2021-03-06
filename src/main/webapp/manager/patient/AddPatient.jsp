<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="../../css/style.css"/>
	<script src="../../js/jquery-1.10.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="../../js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="../../datepicker/WdatePicker.js" type="text/javascript" charset="utf-8"></script>
<title>添加患者</title>
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
		
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<!--信息管理table-->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8" align="center" style="text-align: center;">
				<form class="form-inline" action="PatientList.jsp" method="get">
						<table align="center" class="table  table-bordered" style="width:60%;">
							<tr class="bg-info">
								<td style="text-align: center;" colspan="3"><span style="font-size: 20px;font-weight: bold;">患者信息添加</span></td>
							</tr>
							<tr class="active">
								<td style="width: 15%; vertical-align: middle">患者姓名</td>
								<td colspan="2"><input type="text" style="width: 90%;" placeholder="请输入科室名称" class="form-control" name="name" ></td>
							</tr>
							<tr class="active">
								<td style="width: 15%; vertical-align: middle">性别</td>
								<td>
									男 <input type="radio" name="sex" id="" />
									
								</td>
								<td>女 <input type="radio" name="sex" id="" /></td>
							</tr>
							<tr class="active">
								<td style="width: 15%; vertical-align: middle">生日</td>
								<td colspan="2"><input type="text" onclick="WdatePicker({fmtDate:'yyyy-MM-dd'})" style="width: 90%;height: 160%; border-color: lightgray;" placeholder="请输入所在区域" class="Wdate form-control" name="birth" ></td>
							</tr>
							<tr class="active">
								<td style="width: 15%; vertical-align: middle">身份证</td>
								<td colspan="2"> <input type="text" style="width: 90%;" placeholder="请输入办公室电话" class="form-control" name="idcard" ></td>
							</tr>
							<tr class="active">
								<td style="width: 15%; vertical-align: middle">手机号</td>
								<td colspan="2"><input type="text" style="width: 90%;" placeholder="请输入办公室电话" class="form-control" name="mobile" ></td>
							</tr> 
							<tr class="active">
								<td style="width: 10%; vertical-align: middle">住址</td>
								<td colspan="2"><input type="text" style="width: 90%;" placeholder="请输入办公室电话" class="form-control" name="address" ></td>
							</tr>
							<tr>
								<td colspan="3"><input type="submit" style="width: 200px;" class="btn btn-success" value="添加"></td>
							</tr>
						</table>
					</form>
			</div>
			<div class="col-md-2"></div>
		</div>
		<!--底部-->
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
