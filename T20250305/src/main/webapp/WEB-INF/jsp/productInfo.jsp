<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 상품상세. -->
<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="images/${prd.prodImage }" alt="..." /></div>
            <div class="col-md-6">
                <div class="small mb-1" id="code">CODE: <c:out value="${prd.prdCode}"></c:out></div>
                <h1 class="display-5 fw-bolder"><c:out value="${prd.prdName}"></c:out></h1>
                <div class="fs-5 mb-5">
                    <span class="text-decoration-line-through"><c:out value="${prd.originPrice}"></c:out></span>
                    <span><c:out value="${prd.salePrice}"></c:out></span>
                </div>
                <p class="lead"><c:out value="${prd.prdDesc}"></c:out></p>
                <div class="d-flex">
                    <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                    <button class="btn btn-outline-dark flex-shrink-0" type="button">
                        <i class="bi-cart-fill me-1"></i>
                        Add to cart
                    </button>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="py-5 bg-light" id="mock"></section>

<script src="js/relate.js"></script>