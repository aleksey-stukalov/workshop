var oauthToken = null;

function login() {
    var userLogin = $('#loginField').val();
    var userPassword = $('#passwordField').val();
    console.log ( '#someButton was clicked' );
    $.post({
        url: 'http://localhost:8080/app/rest/v2/oauth/token',
        headers: {
            'Authorization': 'Basic Y2xpZW50OnNlY3JldA==',
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        dataType: 'json',
        data: {grant_type: 'password', username: userLogin, password: userPassword},
        success: function (data) {
            oauthToken = data.access_token;
            $('#loggedInStatus').show();
            $('#loginForm').hide();
            loadRecentOrders();
        }
    })
}

function loadRecentOrders() {
    $.get({
        url: 'http://localhost:8080/app/rest/v2/entities/workshop$Order?view=_local',
        headers: {
            'Authorization': 'Bearer ' + oauthToken,
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        success: function (data) {
            $('#recentOrders').show();
            $.each(data, function (i, order) {
                $('#ordersList').append("<li>" + order.description + "</li>");
            });
        }
    });
}
