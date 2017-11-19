<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajax Test !!</h1>
	
	<div>REPLYER <input type="text" name="replyer" id="newReplyWriter"></div>
	<div>REPLY TEXT <input type="text" name="replytext" id="newReplyText"></div>
	<button id="replyAddBtn">ADD REPLY</button>
	
	<ul id="replies">

	</ul>

	<!-- jQuery 2.1.4 -->
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	
	<script>
	
		var bno = 7;
		function getAllList() {
			$.getJSON("/replies/all/" + bno, function(data){
				console.log(data.length);
			
				var str = "";
				$(data).each(function(){
					str += "<li data-rno='"+this.rno+"' class='replyLi'>"
					+ this.rno + " : " + this.replytext
					+ "</li>"
				});
				$("#replies").html(str);
			});
		}
		
		$("#replyAddBtn").on("click", function(){
			var replyer = $("#newReplyWriter").val();
			var replytext = $("#newReplyText").val();
			
			$.ajax({
				type : 'post',
				url : '/replies',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					bno : bno,
					replyer : replyer,
					replytext : replytext
				}),
				success : function(result) {
					if (result == 'SUCCESS') {
						alert("등록 되었습니다.");
						getAllList();
					}
				}
			});
		});
		
	</script>

</body>
</html>
