$(function () {

    $("#email").click(function () {
        var email = {};
        email.subject = "TEST";
        email.recipients = ["trevorvbrooks@gmail.com"];
        email.body = "This is only a test";

        var json = JSON.stringify(email);

        $.post( "api/button/result", json).done(function( data ) {
            window.alert("Response:" + data);
        });
    });

});