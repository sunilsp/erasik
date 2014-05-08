/**
 * @author mundie
 */
/*
	 * User Login validations
	 */
$(function(){
	$("#loginValidationFeedback").hide();
	var loginValidator = $("#loginForm").validate({
		rules : {
			userName : {
				required : true,
				maxlength : 24
			},
			userPassword : {
				required : true,
				password:true,
				minlength : 8,
				maxlength : 24
			}
		},
		invalidHandler : function(form, validator) {
			var errors = validator.numberOfInvalids();
			if (errors) {
				var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
				$("#loginValidationFeedback span").html(message);
				$("#loginValidationFeedback").show();
			} else {
				$("#loginValidationFeedback").hide();

			}
		},
		submitHandler : function(form) {
			form.submit();

		},
		onkeyup : true,
	});
	$("#loginReset").click(function() {
		loginValidator.resetForm();
		$("#loginValidationFeedback span").html("");
		$("#loginValidationFeedback").hide();
	});

	$("#loginCancel").click(function() {
		$("#float-modal-form").dialog("close");
		event.preventDefault();
	});

	$("#showPassword").click(function() {
		console.log("in funct");
		if ($(this).is(':checked')) {
			document.getElementById("userPassword").setAttribute("type", "text");
		} else {
			document.getElementById("userPassword").setAttribute("type", "password");
		}
	});
});
	/*
	 * end of user login validation
	 */