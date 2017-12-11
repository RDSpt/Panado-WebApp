$(function () {
    console.log(menu);
    //solving active menu
    switch (menu) {
        case 'Produtos':
            $('#produtos').addClass('active');
            $('a_todos').addClass('active');
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
        case 'Contactos':
            $('#contactos').addClass('active');
            break;
        default:
            $('#home').addClass('active');
            break;
    }
});

//jquery dataTable

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

                    if (row.quantity < 1) {
                        str += " <a class = 'btn btn-danger disabled' href='javascript:void(0);'><i class='fa fa-cart-plus fa-lg' aria-hidden='true'></i></a>";
                    } else {

                        str += " <a class = 'btn btn-primary' href='" + window.contextRoot + "/cart/add/" + data + "/'><i class='fa fa-cart-plus fa-lg' aria-hidden='true'></i></a>";

                    }
                    return str;
                }
            }
        ]
    });
}