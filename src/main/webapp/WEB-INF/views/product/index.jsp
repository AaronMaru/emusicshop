<%@include file="/WEB-INF/views/partials/header.jsp" %>
    <div class="container-wrapper">
        <div class="container">
            <div class="page-header">
                <h1>All Product</h1>
                <p class="lead">Checkout all the products available!</p>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr class="bg-success">
                        <td>Photo Thumb</td>
                        <td>Product Name</td>
                        <td>Category</td>
                        <td>Condition</td>
                        <td>Price</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ products }" var="product">
                        <tr>
                            <td><img src="#" alt="image" /></td>
                            <td>${ product.productName }</td>
                            <td>${ product.productCategory }</td>
                            <td>${ product.productCondition }</td>
                            <td>${ product.productPrice }</td>
                            <td><a href="<c:url value="/product/${ product.id }"/>" class="btn btn-primary">Detail</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <!-- FOOTER -->
            <%@include file="/WEB-INF/views/partials/footer.jsp" %>


