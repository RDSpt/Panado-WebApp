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
                <h6>Qty. Available: ${product.quantity}</h6>
                <a href="${contextRoot}/car/add/${product.id}/" class="btn btn-sucess"><i class='fa fa-cart-plus fa-lg'
                                                                                          aria-hidden='true'>Comprar</i></a>
                <a href="${contextRoot}/produtos/${productCategory.id}/" class="btn btn-sucess">Voltar</a>
            </div>
        </div>
    </div>

</div>