<div class="container">
    <h2>Detalhes de ${product.name}</h2>
    <div class="container">
        <div class="row breadcrumb">
            <a class="breadcrumb-item" href="${contextRoot}/produtos/"> Produtos </a>
            <a class="breadcrumb-item"
               href="${contextRoot}/produtos/${productCategory.id}/"> ${productCategory.name}</a></li>
            <span class="breadcrumb-item active"> ${product.name}</span>

        </div>
        <div class="row">

            <div class="col-xs-12 col-md-3">
                <%-- BreadCrumb --%>

                <%--Image--%>
                <div class="thumbnail">
                    <img src="${images}/produtos/${product.code}.jpg" class="img img-responsive singlePageImg"/>
                </div>
            </div>
            <div class="col-xs-12 col-md-9">
                <%-- Info --%>
                <h3>${product.name}</h3>
                <hr/>
                <p>${product.description}</p>
                <hr/>
                <h4>Price: <strong> ${product.price} €</strong></h4>
                <hr/>


                <c:choose>
                    <c:when test="${product.quantity<1}">
                        <h6>Qty. Available: <span color="red">Out of Stock!</span></h6>
                    </c:when>
                    <c:otherwise>
                        <h6>Qty. Available: ${product.quantity}</h6>
                    </c:otherwise>
                </c:choose>
        <security:authorize access="hasAuthority('CUSTOMER')">
                <c:choose>
                    <c:when test="${product.quantity<1}">
                        <a href="javascript:void(0)" class="btn btn-danger disabled" style="text-decoration: line-through;"><i
                                class='fa fa-cart-plus fa-lg'
                                aria-hidden='true'> Comprar</i></a>
                    </c:when>
                    <c:otherwise>
                        <a href="${contextRoot}/car/add/${product.id}/" class="btn btn-sucess"><i
                                class='fa fa-cart-plus fa-lg'
                                aria-hidden='true'> Comprar</i></a>
                    </c:otherwise>
                </c:choose>
        </security:authorize>
                    <security:authorize access="hasAuthority('ADMIN')">
                        <a href="${contextRoot}/gerir/produtos/${product.id}/" class="btn btn-warning"><i
                                class='fa fa-pencil-square-o fa-lg'
                                aria-hidden='true'> Comprar</i></a>
                    </security:authorize>
                <a href="${contextRoot}/produtos/${productCategory.id}/" class="btn btn-sucess">Voltar</a>
            </div>
        </div>
    </div>

</div>