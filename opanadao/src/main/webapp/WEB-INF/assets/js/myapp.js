$(function () {
    console.log(menu);
    //solving active menu
    switch (menu) {
        case 'Produtos':
            $('#produtos').addClass('active');
            $('#a_todos').addClass('active');
            break;
        case 'Kebab':
            $('#produtos').addClass('active');
            $('#a_Kebab').addClass('active');
            break;
        case 'Panado':
            $('#produtos').addClass('active');
            $('#a_Panado').addClass('active');
            break;
        case 'Hamburger':
            $('#produtos').addClass('active');
            $('#a_Hamburger').addClass('active');
            break;
        case 'Sobre Nós':
            $('#sobrenos').addClass('active');
            break;
        case 'Manage Products':
            $('#manageProducts').addClass('active');
            break;
        case 'Contactos':
            $('#contactos').addClass('active');
            break;
        case 'Gerir Produtos':
            $("#manageProducts").addClass('active');
            $("#gerirProdutos").addClass('active');
            break;
        case 'Adicionar Produtos':
            $("#manageProducts").addClass('active');
            $("#adicionarProdutos").addClass('active');
            break;
        case 'Cart':
            $('#cart').addClass('active');
            break;
        default:
            $('#home').addClass('active');
            break;


    }

    /*CSRF*/
    var token = $('meta[name="_csrf"]').attr('content');
    var header = $('meta[name="_csrf_header"]').attr('content');
    if (token.length > 0 && header.length > 0) {
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);


        });
    }


    /*DATATABLE PRODUCTS*/
    var $table = $('#productListTable');

    if ($table.length) {

        var jsonUrl = '';
        if (window.categoryId === '') {
            jsonUrl = window.contextRoot + '/json/data/produtos/';
        } else {
            jsonUrl = window.contextRoot + '/json/data/produtos/' + window.categoryId + '/';

        }

        $table.DataTable({
                lengthMenu: [[3, 5, 10, -1], ['3', '5', '10', 'Todos']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc: ''
                },
                columns: [
                    {
                        bSortable: false,
                        data: 'code',
                        mRender: function (data, type, row) {
                            return "<img class='dataTableImg' src='" + window.contextRoot + "/resources/images/produtos/" + data + ".jpg'/>"
                        }
                    },
                    {
                        data: 'name'
                    },

                    {
                        data: 'price',
                        mRender: function (data, type, row) {
                            return data + ' €';
                        }
                    },
                    {
                        data: 'quantity',
                        mRender: function (data, type, row) {
                            if (data < 1) {
                                return "<span style='red'> Out of Stock!</span>";
                            }
                            return data;
                        }
                    },
                    {
                        data: 'id',
                        bSortable: false,
                        mRender: function (data, type, row) {
                            var str = "";
                            str += " <a class = 'btn btn-primary' href='" + window.contextRoot + "/produtos/produto_desc/" + data + "/'><i class='fa fa-eye fa-lg' aria-hidden='true'></i></a> &nbsp; ";
                            if (userRole === 'ADMIN') {
                                str += " <a class = 'btn btn-warning' href='" + window.contextRoot + "/gerir/produtos/" + data + "/'><i class='fa fa-pencil-square-o' aria-hidden='true'></i></a>";
                            } else {

                                if (row.quantity < 1) {
                                    str += " <a class = 'btn btn-danger disabled' href='javascript:void(0);'><i class='fa fa-cart-plus fa-lg' aria-hidden='true'></i></a>";
                                } else {


                                    str += " <a class = 'btn btn-primary' href='" + window.contextRoot + "/cart/" + data + "/add/'><i class='fa fa-cart-plus fa-lg' aria-hidden='true'></i></a>";
                                }
                            }
                            return str;
                        }
                    }
                ]
            }
        );
    }

    /*ERROR FADE*/

    var $alert = $('.alert');
    if ($alert.length) {
        setTimeout(function () {
            $alert.fadeOut('slow');
        }, 3000);
    }

    /*CONFIRM ALERT*/

    $('.switch input[type="checkbox"]').on('change', function () {

        var checkbox = $(this);
        var checked = checkbox.prop('checked');
        var dMsg = (checked) ? "Tem a certeza que quer activar o produto?" : "Tem a certeza que quer desactivar o produto?";
        var value = checkbox.prop('value');

        bootbox.confirm({
            size: 'medium',
            title: "Estado do produto",
            message: dMsg,
            callback: function (confirmed) {
                if (confirmed) {
                    console.log(value);
                    bootbox.alert({
                        size: 'medium',
                        title: "Informação",
                        message: "Operção em: " + value
                    })
                } else {
                    checkbox.prop('checked', !checked)
                }
            }
        })

    });

    /*DataTable for ADMIN*/

    var $adminProductsTable = $('#adminProductsTable');

    if ($adminProductsTable.length) {

        var jsonUrl = window.contextRoot + '/json/data/admin/produtos/';

        $adminProductsTable.DataTable({
            lengthMenu: [[10, 30, 50, -1], ['10', '30', '50', 'Todos']],
            pageLength: 30,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'id'
                },
                {
                    bSortable: false,
                    data: 'code',
                    mRender: function (data, type, row) {
                        return "<img class='adminDataTableImg' src='" + window.contextRoot + "/resources/images/produtos/" + data + ".jpg'/>"
                    }
                },
                {
                    data: 'name'
                },
                {
                    data: 'quantity',
                    mRender: function (data, type, row) {
                        if (data < 1) {
                            return "<span style='red'> Out of Stock!</span>";
                        }
                        return data;
                    }
                },
                {
                    data: 'price',
                    mRender: function (data, type, row) {
                        return data + ' €';
                    }
                },

                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<label class="switch">';
                        if (data) {
                            str += '<input type="checkbox" checked="checked" value="' + row.id + '" />';
                        } else {
                            str += '<input type="checkbox" value="' + row.id + '" />';
                        }
                        str += '<div class="slider" ></div>';
                        str += ' </label>';
                        return str
                    }
                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="' + window.contextRoot + '/gerir/adicionarProdutos/' + data + '" class="btn btn-warning">';
                        str += '<i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>';
                        return str;
                    }
                }
            ],
            initComplete: function () {
                var api = this.api();
                api.$('.switch input[type="checkbox"]').on('change', function () {

                    var checkbox = $(this);
                    var checked = checkbox.prop('checked');
                    var dMsg = (checked) ? "Tem a certeza que quer activar o produto?" : "Tem a certeza que quer desactivar o produto?";
                    var value = checkbox.prop('value');

                    bootbox.confirm({
                        size: 'medium',
                        title: "Estado do produto",
                        message: dMsg,
                        callback: function (confirmed) {
                            if (confirmed) {
                                console.log(value);
                                var activationURL = window.contextRoot + '/gerir/produtos/' + value + '/activar';
                                $.post(activationURL, function (data) {
                                    bootbox.alert({
                                        size: 'medium',
                                        title: "Informação",
                                        message: data
                                    })
                                });
                            } else {
                                checkbox.prop('checked', !checked)
                            }
                        }
                    });
                });
            }
        });
    }

//Validation code for Category
    var $categoryForm = $("#categoryForm");

    if ($categoryForm.length) {
        $categoryForm.validate({
            rules: {
                name: {
                    required: true,
                    minlength: 2
                },
                description: {
                    required: true
                }
            },
            messages: {

                name: {
                    required: "Por favor adicione o nome da categoria!",
                    minlength: "O nome da categoria tem que ter pelo menos 2 letras!"
                },
                description: {
                    required: "Por favor adicione uma descrição!"
                }
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                //add the class of help-block
                error.addClass("help-block");
                error.insertAfter(element);
            }
        });
    }
    /*LOGIN FORM*/
//Validation code for login
    var $loginForm = $("#loginForm");

    if ($loginForm.length) {
        $loginForm.validate({
            rules: {
                username: {
                    required: true,
                    email: true
                },
                password: {
                    required: true
                }
            },
            messages: {

                username: {
                    required: "Por favor insira o seu e-mail!",
                    minlength: "Por favor insira um e-mail valido!"
                },
                password: {
                    required: "Por favor insira a password!"
                }
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                //add the class of help-block
                error.addClass("help-block");
                error.insertAfter(element);
            }
        });
    }

    /*CART*/
    $('button[name="refreshCart"]').click(function(){
        var cartLineId = $(this).attr('value');
        var countField = $('#count_' + cartLineId);
        var originalCount = countField.attr('value');
        // do the checking only the count has changed
        if(countField.val() !== originalCount) {
            // check if the quantity is within the specified range
            if(countField.val() < 1) {
                // set the field back to the original field
                countField.val(originalCount);
                bootbox.alert({
                    size: 'medium',
                    title: 'Error',
                    message: 'Product Count should be minimum 1 and maximum 3!'
                });
            }
            else {
                // use the window.location.href property to send the request to the server
                var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + countField.val();
                console.log(updateUrl);
                window.location.href = updateUrl;
            }
        }
    });
})
;

