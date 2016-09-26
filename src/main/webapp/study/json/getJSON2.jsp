<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getJSON2.jsp</title>
<link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
	
<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

</head>
<body>
<h1>JSON (Javascript Object Notation)</h1>
<h1>이기종 간에 데이타 통신방법</h1>
<ol>
	<li>콤마 seperator(ex ==> 10, 총무부, 서울)</li>
	<li>XML</li>
	<li>JSON</li>
</ol>

<hr>
<h1>AJAX (Asyncronous Javascript And Xml) 비동기 자바스크립트 데이터 통신 기술</h1>

<button class="btn btn-primary">getJSON2 messages</button>

<div id="list"></div>

<script id="result" type="text/x-handlebars-template">
	<ul>
		{{#each .}}
		<li class="list-group-item">
			[{{mid}}] {{targetid}} <i class="fa fa-backward fa-spin"></i> {{sender}} {{message}}
		</li>
		{{/each}}
	</ul>
</script>

<script type="text/javascript">

	$('button').eq(0).on('click', function() {
		

	$.getJSON("/messages/listmessage?mid=1", function(data) {
		console.log(data);
		console.log("mid = " + data.mid);
		console.log("targetid = " + data.targetid);
		console.log("sender = " + data.sender);
		console.log("message = " + data.message);
		
		var msg = {
				mid : data.mid,
				targetid : data.targetid,
				sender : data.sender,
				message : data.message
			};
		

		console.dir(msg);

		var template = $('#result');
		
		var ctemplate = Handlebars.compile(template.html());
		
		var html = ctemplate(msg);
		
		$('#list').html(html);
// 		$('#emps').append(html);		
		
// 		var li = '<li class="list-group-item">' + data.mid + "," + data.targetid + "," + data.sender + "," + data.message + "</li>";
		
		
// 		$('#result').html(li);
		});
	});
	

</script>
</body>
</html>