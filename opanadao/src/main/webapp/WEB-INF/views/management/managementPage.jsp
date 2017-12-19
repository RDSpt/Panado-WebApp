<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-nav" style="margin-top: 60px;">
    <div class="container">
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item" id="gerirProdutos">
                    <a class="nav-link"  href="${contextRoot}/gerir/produtos">Gerir Produtos</a>
                </li>
                <li class="nav-item" id="adicionarProdutos">
                    <a class="nav-link"  href="${contextRoot}/gerir/adicionarProdutos">Adicionar
                        Produtos</a>
                </li>
                <li class="nav-item" id="adicionarCategorias">
                    <a class="nav-link"  href="${contextRoot}/gerir/adicionarCategorias">Adicionar
                        Categoria</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-12">
            <c:if test="${gerir == true}">
                <%@include file="manageProducts.jsp" %>
            </c:if>
            <c:if test="${adicionarProduto == true}">
                <%@include file="addProduct.jsp" %>
            </c:if>
            <c:if test="${adicionarCategoria == true}">
                <%@include file="addCategory.jsp" %>
            </c:if>
        </div>
    </div>
</div>

