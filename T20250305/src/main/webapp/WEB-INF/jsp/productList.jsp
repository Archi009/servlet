<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 상품목록  -->
<header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Shop in style</h1>
                    <p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>
                </div>
            </div>
        </header>
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach var="pro" items="${list}">
            <div class="col mb-5">
                <div class="card h-100">
                    <!-- Sale badge-->
                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                    <!-- Product image-->
                    <a href="productInfo.do?prdCode=${pro.prdCode }"><img class="card-img-top" src="images/${pro.prodImage }" alt="..." /></a>
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder"><c:out value="${pro.prdName	 }"></c:out></h5>
                            <!-- Product reviews-->
                            <div class="d-flex justify-content-center small text-warning mb-2">
                                <c:forEach var="i" begin="1" end="${pro.starPoint }">
                                <div class="bi-star-fill"></div>
                                </c:forEach>
                                <c:forEach var="i" begin="1" end="${5-pro.starPoint }">
                                <div class="bi-star"></div>
                                </c:forEach>
                               
                            </div>
                            <!-- Product price-->
                            <span class="text-muted text-decoration-line-through"><c:out value="${pro.originPrice }"></c:out></span>
                            <c:out value="${pro.salePrice }"></c:out>
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                    </div>
                </div>
            </div>
        </c:forEach>
            
        </div>
    </div>
</section>
 