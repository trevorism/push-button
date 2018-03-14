$(function () {

    $("#email").click(function () {
        var email = {};
        email.subject = "TEST";
        email.recipients = ["trevorvbrooks@gmail.com"];
        email.body = "This is only a test";

        var json = JSON.stringify(email);

        $.ajax({
            url: "api/button/result",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: json,
            success: function( data ) {
                window.alert("Response:" + data);
            }
        });
    });

});