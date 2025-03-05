<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach var="stud" items="${list}">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">
									<c:out value="${stud.studentName}"></c:out>
								</h5>
								<!-- Product price-->

								<c:out value="${stud.address}"></c:out>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<c:out value="${stud.phone}"></c:out>

							</div>
						</div>
					</div>
				</div>
			</c:forEach>


		</div>
	</div>
</section>