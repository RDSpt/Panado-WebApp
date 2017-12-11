<div class="container">
    <%--BreadCrumb component--%>
    <div class="row breadcrumb">
        <c:if test="${userClickAllProducts == true}">
            <script>
                window.categoryId = '';
            </script>
            <a class="breadcrumb-item" href="${contextRoot}/produtos/"> Produtos </a>
            <span class="breadcrumb-item active"> Todos</span>
        </c:if>
        <c:if test="${userClickSelectedProduct == true}">
            <script>
                window.categoryId = '${category.id}';
            </script>
            <a class="breadcrumb-item" href="${contextRoot}/produtos/"> Produtos </a>
            <span class="breadcrumb-item active"> ${category.name}</span>
        </c:if>
    </div>
    <div class="row">
        <div class="col-md-3">
            <%@ include file="shared/sidebar.jsp" %>
        </div>
        <div class="col-md-9">

            <%-- List of Project --%>
            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <table id="productListTable" class="table table-striped table-borderd">
                        <thead>
                        <tr>
                            <th></th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th></th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>