$(document).ready(
    function() {
        // SUBMIT FORM
        $("#validationForm").submit(function(event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPostForm();
        });

        function ajaxPostForm() {

            // PREPARE FORM DATA
            var formData = {
                userType : $("#role").val(),
                name : $("#name").val(),
                email : $("#email").val()
            }

            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "/",
                data : JSON.stringify(formData),
                dataType : 'json',
                success : function(result) {
                    $("#result").html(result.name + " is valid.");
                },
                error : function(e) {
                    $("#result").html(e.responseJSON.message);
                    console.log(e.responseJSON.message);
                }
            });

        }

    })
