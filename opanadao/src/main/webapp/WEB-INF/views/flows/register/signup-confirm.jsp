<%@include file="../shared/flows-header.jsp" %>

<div class="container" style="margin-top: 60px;">

    <div class="row">
        <!-- columns for Display The personal details -->
        <div class="col-xs-12 col-md-12">
            <div class="card">
                <div class="card-deck card-body">
                    <div class="card ">
                        <div class="card-header card-title text-center">
                            <h4>Dados Pessoais</h4>
                        </div>

                        <div class="card-body">
                            <div class="text-center">
                                <h4>${registerModel.user.first_name} ${registerModel.user.last_name}</h4>
                                <h5>Email: ${registerModel.user.email}</h5>
                                <h5>Numero: ${registerModel.user.contact_number}</h5>

                            </div>
                        </div>
                        <div class="card-footer">
                            <a href="${flowExecutionUrl }&_eventId_personal"
                               class="btn btn-primary">Personal</a>
                        </div>
                    </div>


                    <!-- column for Display the address -->
                    <div class="card">
                        <div class="card-header card-title text-center">
                            <h4>Morada</h4>
                        </div>

                        <div class="card-body">
                            <div class="text-center">
                                <h4>Morada: ${registerModel.address.addressLineOne}</h4>
                                <h5>Código Postal: ${registerModel.address.postalCode}</h5>
                                <h5>Cidade: ${registerModel.address.city}</h5>
                                <h5>País: ${registerModel.address.country}</h5>

                            </div>
                        </div>
                        <div class="card-footer">
                            <a href="${flowExecutionUrl }&_eventId_address"
                               class="btn btn-primary">Edit </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 text-center card-footer">
                    <a href="${flowExecutionUrl }&_eventId_submit"
                       class="btn btn-primary btn-lg">Confirm</a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../shared/flows-footer.jsp" %>