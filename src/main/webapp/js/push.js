$(function () {

    $("#vm").click(function () {
        var button = {};
        button.name = "Start Jenkins";
        button.parameters = {};
        button.topicName = "startvm";

        var json = JSON.stringify(button);

        var btn = $(this);
        btn.prop('disabled', true);

        $.ajax({
            url: "api/push/result",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: json,
            success: function() {
                btn.prop('disabled', false);
            },
            error: function(){
                btn.prop('disabled', false);
                window.alert("Error submitting request");
            }
        });
    });

});