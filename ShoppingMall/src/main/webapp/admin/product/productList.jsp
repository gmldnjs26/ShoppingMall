<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
	<h1>상품리스트</h1>
	<form name="frm" method="post">
		<table>
			<tr>
				<td width="642">상품명 <input type="text" name="key"> <input
					class="btn" type="button" name="btn_search" value="검색"
					onClick="go_search()"> <input class="btn" type="button"
					name="btn_total" value="전체보기 " onClick="go_total()"> <input
					class="btn" type="button" name="btn_write" value="상품등록"
					onClick="go_wrt()">
				</td>
			</tr>
		</table>
		<table id="productList">
			<tr>
				<th>번호</th>
				<th>상품명</th>
				<th>원가</th>
				<th>판매가</th>
				<th>등록일</th>
				<th>사용유무</th>
			</tr>
			<c:choose>
				<c:when test="${pageMaker.totalCount<=0}">
					<tr>
						<td width="100%" colspan="7" align="center" height="23">등록된
							상품이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${productList}" var="productVO">
						<tr>
							<td height="23" align="center">${productVO.pseq}</td>
							<td
								style="text-align: left; padding-left: 50px; padding-right: 0px;">
								<a href="#" onClick="go_detail('${tpage}', '${productVO.pseq}')">
									${productVO.name} </a>
							</td>
							<td><fmt:formatNumber value="${productVO.price1}" /></td>
							<td><fmt:formatNumber value="${productVO.price2}" /></td>
							<td><fmt:formatDate value="${productVO.indate}" /></td>
							<td><c:choose>
									<c:when test='${productVO.useyn=="1"}'>미사용</c:when>
									<c:otherwise>사용</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
					<ul class="btn-group pagination">
						<c:if test="${pageMaker.prev }">
							<li><a href='<c:url value="admin_product_list2.do?page=${pageMaker.startPage-1 }"/>'><i
									class="fa fa-chevron-left"></i></a></li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage }"
							end="${pageMaker.endPage }" var="idx">
							<li><a href='<c:url value="admin_product_list2.do?page=${idx }"/>'><i
									class="fa">${idx }</i></a></li>
						</c:forEach>
						<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
							<li><a
								href='<c:url value="admin_product_list2.do?page=${pageMaker.endPage+1 }"/>'><i
									class="fa fa-chevron-right"></i></a></li>
						</c:if>
					</ul>
				</c:otherwise>
			</c:choose>
		</table>
	</form>
</article>
<%@ include file="/admin/footer.jsp"%>
</body>
</html>