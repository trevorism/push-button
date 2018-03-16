$(function () {

    $("#email").click(function () {
        var email = {};
        email.subject = "TEST";
        email.recipients = ["trevorvbrooks@gmail.com"];
        email.body = "This is only a test";

        var button = {};
        button.name = "email";
        button.parameters = email;

        var json = JSON.stringify(button);

        $.ajax({
            url: "api/push/result",
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