<#macro masterTemplate title="Welcome">
	<!DOCTYPE html
		PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
		<title>${title} | 哨兵</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body>
		<div class="page">
			<div class="header">
				<div class="leftside">
					哨兵 Sentry
				</div>
				<div class="rightside>
					一天一个想法
				</div> 
			</div>
			<h1>Sentry</h1>
			<div class="navigation">
					<a  href="/main">主页</a> |
					<a  href="/playground">操场</a>
			</div>
			<div class="body">
				<#nested />
			</div>
			<div class="footer">
				哨兵 Sentry&mdash; 一天一个想法 | <a href = "https://github.com/JavaProgrammerLB">吃西瓜的刘备</a>
			</div>
		</div>
	</body>
</#macro>