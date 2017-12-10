<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<script>
	var result = '${msg}';
	if (result == 'success') alert('처리가 완료 되었습니다.'); 
	
	$(document).ready(function(){
		$('#searchBtn').on("click", function(event){
			self.location = "list"
				+ '${pageMaker.makeQuery(1)}'
				+ "&searchType="
				+ $("select option:selected").val()
				+ "&keyword="
				+ $("#keywordInput").val();
		});
		
		$("#newBtn").on("click", function(event){
			self.location = "register";
		});
	});
</script>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">SEARCH BOARD</h3>
					<div class="box-body">
							<select name="searchType">
								<option value="n" ${cri.searchType == null ? 'selected' : ''}>-----</option>
								<option value="t" ${cri.searchType == 't' ? 'selected' : ''}>Title</option>
								<option value="c" ${cri.searchType == 'c' ? 'selected' : ''}>Content</option>
								<option value="w" ${cri.searchType == 'w' ? 'selected' : ''}>Writer</option>
								<option value="tc" ${cri.searchType == 'tc' ? 'selected' : ''}>Title or Content</option>
								<option value="cw" ${cri.searchType == 'cw' ? 'selected' : ''}>Content or Writer</option>
								<option value="tcw" ${cri.searchType == 'tcw' ? 'selected' : ''}>Title or Content or Writer</option>
							</select>
							<input type="text" name="keyword" id="keywordInput" value="${cri.keyword}">
							<button id="searchBtn">Search</button>
							<button id="newBtn">New Board</button>
						</div>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px;">BNO</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width: 40px;">VIEWCNT</th>
						</tr>
						<c:forEach items="${list}" var="boardVO">
						<tr>
							<td><c:out value="${boardVO.bno}"/></td>
							<td>
								<a href="/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${boardVO.bno}">
									<c:out value="${boardVO.title}"/> [<c:out value="${boardVO.replycnt}"/>]
								</a>
							</td>
							<td><c:out value="${boardVO.writer}"/></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}"/></td>
							<td><span class="badge bg-red"><c:out value="${boardVO.viewcnt}"/></span></td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
							<c:if test="${pageMaker.prev == true}">
							<li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}">&laquo</a></li>
							</c:if>
							
							<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
							<li <c:out value="${pageMaker.cri.page == idx ? 'class=active':''}"/>>
								<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
							</li>
							</c:forEach>
							
							<c:if test="${pageMaker.next == true}">
							<li><a href="list${pageMaker.makeSearch(pageMaker.endPage + 1)}">&raquo</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--/.col (left) -->
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->


<%@include file="../include/footer.jsp"%>


