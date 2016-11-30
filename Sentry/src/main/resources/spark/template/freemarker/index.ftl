<!doctype html>
<html>
  <head>
      <meta charset="utf-8">
      <title>Sentry</title>
      <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
    <div class="title">
      <input type="button" class="refresh" value="刷新" onclick="location.href='refresh'"/>
      <h4>最新节目</h4>
    </div>
	<#list contents as con>
    <div class="content">
      <a class="line" href=${con.url}>${con.title}</a>
    </div>
    </#list>
  </body>
</html>
