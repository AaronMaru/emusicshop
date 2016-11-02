<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>


            <p class="lead">Here is the detail information of the product:</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="#" alt="image" style="width:100% height:300px"/>
                </div>
                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDecription}</p>
                    <p><strong>Manufacturer</strong>: ${product.productManufacturer}</p>
                    <p><strong>Category</strong>: ${product.productCategory}</p>
                    <p><strong>Condition</strong>: ${product.productCondition}</p>
                    <p>${product.productPrice} USD</p>

                    <br/>

                </div>
            </div>
        </div>
	</div>
</div>
<script src="<c:url value="/resources/js/product.js"/>"></script>
<%@include file="/WEB-INF/views/partials/footer.jsp" %>
