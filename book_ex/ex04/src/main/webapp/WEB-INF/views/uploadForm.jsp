<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	iframe {
		width: 0px;
		height: 0px;
		border: 0px;
	}
</style>

</head>
<body>

	<form id="form1" action="uploadForm" method="post" target="zeroForm" enctype="multipart/form-data">
		<input type="file" name="file"> <input type="submit">
	</form>
	
	<iframe name="zeroForm"></iframe>
	
	<script type="text/javascript">
		function addFilePath(msg) {
			alert(msg);
			document.getElementById("form1").reset();
		}
	</script>
	
</body>
</html>