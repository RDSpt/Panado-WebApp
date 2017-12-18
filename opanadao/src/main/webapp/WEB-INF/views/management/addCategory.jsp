<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container" style="margin-top: 50px;">
    <br>
    <div class="row">
        <div class="col-xs-12 col-md-12">
            <c:if test="${not empty message}">
                <div class="alert alert-success alert-dismissible">
                    <p> ${message} </p>
                    <button type="button" class="close" data-dismiss="alert">&nbsp;&nbsp;&nbsp;&times;</button>
                </div>
            </c:if>
        </div>
        <div class="offset-md-2 col-md-8">
            <div class="card">
                <div class="card-header card-title text-center">
                    <h4>${title}</h4>
                </div>

                <form:form id="categoryForm" modelAttribute="category" action="${contextRoot}/gerir/categoria"
                           method="post"
                           class="form-horizontal">
                    <div class=" card-body">
                        <div class="form-group row">
                            <label class="col-form-label col-md-4" for="category_name"> Nome da Categoria</label>
                            <div class="col-md-8">
                                <form:input type="text" path="name" id="category_name" class="form-control"
                                            placeholder="Nome da Categoria"/>
                                <form:errors path="name" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-form-label col-md-4" for="category_description"> Descrição</label>
                            <div class="col-md-8">
                                <form:textarea cols="" rows="5" path="description" id="category_description"
                                               class="form-control" placeholder="Descriçao da Categoria"/>
                                <form:errors path="description" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 text-center card-footer">
                        <input type="submit" name="submit" id="submit" value="Submeter"
                               class="btn btn-primary"/>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
