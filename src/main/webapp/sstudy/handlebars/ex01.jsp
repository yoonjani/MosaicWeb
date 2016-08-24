<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>


<script	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<script id="mytemplate" type="text/x-handlebars-template">
	<li><i class="fa fa-backward fa-spin"></i> {{empno}} {{ename}} {{loc}}</li>
</script>
</head>
<body>
	<button id="btn1" class="btn btn-primary">append</button>
	
	<ol id="emps"></ol>

<script type="text/javascript">
	$('#btn1').on('click', function() {
		var template = $('#mytemplate');
		
		var ctemplate = Handlebars.compile(template.html());
		
		var emp = {
			empno : 10,
			ename : "hong",
			loc : "seoul"
		};
		
		var html = ctemplate(emp);
		
// 		$('#emps').html(html);
		$('#emps').append(html);
	});


</script>

</body>
</html>