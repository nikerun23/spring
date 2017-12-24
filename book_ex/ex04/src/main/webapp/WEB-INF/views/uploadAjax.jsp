<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>uploadAjax</title>

<style>
	.fileDrop {
		width: 100%;
		height: 200px;
		border: 1px dotted blue;
	}
	small {
		margin-left: 3px;
		font-weight: bold;
		color: gray;
	}
</style>

</head>
<body>

	<h3>Ajax File Upload</h3>
	<div class="fileDrop"></div>
	<div class="uploadList"></div>
	
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script>
		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();
		});
		
		$(".fileDrop").on("drop", function(event){
			event.preventDefault();
			
			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];
			console.log(file);
			var formData = new FormData();
			
			formData.append("file", file);
			
			$.ajax({
				url : "/uploadAjax",
				data : formData,
				dataType : 'text',
				processData : false, // FormData 전송을 위한 설
				contentType : false, // FormData 전송을 위한 설
				type : 'POST',
				success : function(data) {
					alert(data);
					var str = "";
					
					if (checkImageType(data)) {
						str = "<div>"
							+ "<img src='displayFile?fileName=" + data + "'/>"
							+ data + "</div>";
					} else {
						str = "<div>"
							+ data + "</div>";
					}
					$(".uploadList").append(str);
				}
			});
		});
		
		function checkImageType(fileName) {
			var pattern = /jpg|gif|png|jpeg/i; // i 는 대소문자 구분없음
			return fileName.match(pattern);
		}
		
	</script>

</body>
</html>