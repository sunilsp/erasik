/**
 * @author mundie
 */
/*
 * User Login validations
 */
$(function() {
	$("#registerValidationFeedback").hide();
	var registerValidator = $("#userRegistrationForm")
			.validate(
					{
						rules : {
							firstName : {
								required : true,
								minlength : 1,
								maxlength : 100
							},
							lastName : {
								required : true,
								minlength : 1,
								maxlength : 100
							},
							address1 : {
								maxlength : 100
							},
							address2 : {
								maxlength : 100
							},
							city : {
								required : true
							},
							state : {
								required : true
							},
							country : {
								required : true
							},
							phone1 : {
								required : true,
								number : true,
								maxlength : 13,
								minlength : 10
							},
							email : {
								required : true,
								email : true,
								isRasikEmp : /@erasik.com/
							},
							companyName : {
								maxlength : 100
							},
							designation : {
								maxlength : 100
							},
							username : {
								required : true,
								maxlength : 12
							},
							password : {
								required : true,
								minlength : 8
							},
							confirmPassword : {
								required : true,
								minlength : 8,
								equalTo : "#userPassword"
							}
						},
						messages : {
							firstName : {
								required : "Please enter First Name",
								maxlength : "First Name is longer than 100 characters"
							},
							lastName : {
								required : "Please enter Last Name",
								maxlength : "First Last is longer than 100 characters"
							},
							address1 : {
								maxlength : "Address Line 1 is longer than 100 characters"
							},
							address2 : {
								maxlength : "Address Line 2 is longer than 100 characters"
							},
							city : {
								required : "Please enter City"
							},
							state : {
								required : "Please select State"
							},
							country : {
								required : "Please select Country"
							},
							phone1 : {
								required : "Please enter Phone No",
								number : "Please enter valid Phone No",
								maxlength : "Phone No is longer than 10 digits"
							},
							email : {
								required : "Please enter EMail ID",
								email : "Please enter valid EMail ID",
							},
							companyName : {
								maxlength : "Company name is longer than 100 characters"
							},
							designation : {
								maxlength : "Designation is longer than 100 characters"
							},
							username : {
								required : "Please enter User Name",
								maxlength : "User name is longer than 100 characters"
							},
							password : {
								required : "Please enter password",
								minlength : "Password should be minimum 8 characters long"
							},
							confirmPassword : {
								required : "Please confirm password",
								minlength : "Password should be minimum 8 characters long",
								equalTo : "Please enter Confirm Password same as Password"
							}
						},
						invalidHandler : function(form, validator) {
							var errors = validator.numberOfInvalids();
							if (errors) {
								var message = errors == 1 ? 'You missed 1 field. It has been highlighted'
										: 'You missed '
												+ errors
												+ ' fields. They have been highlighted';
								$("#registerValidationFeedback span").html(
										message);
								$("#registerValidationFeedback").show();
							} else {
								$("#registerValidationFeedback").hide();

							}
						},
						submitHandler : function(form) {
							form.submit();

						},
						onkeyup : true,
					});
	$("#registerReset").click(function() {
		registerValidator.resetForm();
		$("#registerValidationFeedback span").html("");
		$("#registerValidationFeedback").hide();
	});

	$("#registerCancel").click(function() {
		$("#float-modal-form").dialog("close");
		event.preventDefault();
	});

	$.validator.addMethod("isRasikEmp", function(value, element, regexp) {
		console.log(regexp.test(value));
		if (regexp.test(value)) {
			$("#companyName").val("Rasik Sahitya Pvt. Ltd.");
			$("#companyName").prop( "disabled", true );
			$("#designation").remove();
			var html_content='<select tabindex="120" name="designation" id="designation" th:field="*{designation}" placeholder="Designation" required="required">';
			html_content+="<option value=''>Please select</option>";
			html_content+="<option value='manager'>Manager</option>";
			html_content+="<option value='accountant'>Accountant</option>";
			html_content+="</select>";
			$("#companyName").parent().next().append(html_content);
			$("#designation").focus();
			$("#designation").rules('add','required');
			$("#designation").prev().attr('class','required');
		} else {
			$("#companyName").val("");
			$("#companyName").prop( "disabled", false );
			$("#designation").remove();
			var html_content='<input type="text" tabindex="120" autocomplete="on" name="designation" id="designation" th:field="*{designation}" placeholder="Designation"/>';
			$("#companyName").parent().next().append(html_content);
			$("#designation").rules('remove','required');
			$("#companyName").focus();
			$("#designation").prev().removeClass('required');
		}
		return true;
	}, "");

});
/*
 * end of user register validation
 */