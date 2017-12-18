<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/flows-header.jsp" %>


<div class="container" style="margin-top: 50px;">
    <br>
    <div class="row">
        <div class="col-xs-12 col-md-12">
            <div class="offset-md-2 col-md-8">
                <div class="card">
                    <div class="card-header card-title text-center">
                        <h4>Registar</h4>
                    </div>
                    <form:form class="form-horizontal" id="registerForm" method="post" modelAttribute="address">
                        <div class="card-body">

                            <!-- FORM Elements -->


                            <div class="form-group row">
                                <label class="control-label col-md-4" for="addressLineOne">Morada: </label>
                                <div class="col-md-8">
                                    <form:input type="text" path="addressLineOne" placeholder="Morada"
                                                class="form-control"/>
                                    <form:errors path="addressLineOne" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="control-label col-md-4" for="city">Cidade: </label>
                                <div class="col-md-8">
                                    <form:input type="text" path="city" placeholder="Cidade"
                                                class="form-control"/>
                                    <form:errors path="city" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="control-label col-md-4" for="country">País: </label>
                                <div class="col-md-8">
                                    <form:input type="text" path="country" placeholder="País"
                                                class="form-control"/>
                                    <form:errors path="country" cssClass="help-block errHighlight" element="em"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="control-label col-md-4" for="postalCode">Código Postal: </label>
                                <div class="col-md-8">
                                    <form:input type="text" path="postalCode"
                                                placeholder="XXXX-XXX" class="form-control"/>
                                    <form:errors path="postalCode" cssClass="help-block"
                                                 element="em"/>
                                </div>
                            </div>
                        </div>
                        <!-- Submit -->
                        <div class="col-md-12 text-center card-footer">
                            <!-- This name is important -->
                            <button type="submit" name="_eventId_personal"
                                    class="btn btn-primary">
                                <i class='fa fa-arrow-left fa-lg' aria-hidden='true'></i> Dados Pessoais
                            </button>
                            <button type="submit" name="_eventId_confirm"
                                    class="btn btn-primary">
                                <i class='fa fa-arrow-right fa-lg' aria-hidden='true'></i> Confirmar
                            </button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<%@ include file="../shared/flows-footer.jsp" %>


