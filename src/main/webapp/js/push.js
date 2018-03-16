$(function () {

    $("#email").click(function () {
        var email = {};
        email.subject = "Push button";
        email.recipients = ["trevorvbrooks@gmail.com"];
        email.body = "A push button was pressed";

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