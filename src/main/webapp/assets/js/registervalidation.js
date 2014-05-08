/**
 * @author mundie
 */
/*
	 * User Login validations
	 */
$(function(){
	$("#registerValidationFeedback").hide();
	var registerValidator = $("#registerForm").validate({
		rules : {
			firstname : {
				required : true,
				minlength:1,
				maxlength : 100
			},
			lastname : {
				required : true,
				minlength : 1,
				maxlength : 100
			},
			address1 : {
				minlength : 1,
				maxlength : 100
			},
			address2 : {
				minlength : 1,
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
			phone : {
				required : true,
				number:true,
				maxlength:10
			},
			email : {
				required : true,
				email:true
			},
			company : {
				maxlength:100
			},
			desination : {
				maxlength:100
			},
			userName:{
				required:true
			},
			userPassword:{
				required:true,
				minlength:8
			},
			confirmPassword:{
				required:true,
				minlength:8,
				equalTo:"#userPassword"
			}
		},
		messages: {
			firstname : {
				required : "Please enter First Name",
				maxlength : "First Name is longer than 100 characters"
			},
			lastname : {
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
			phone : {
				required : "Please enter Phone No",
				number: "Please enter valid Phone No",
				maxlength: "Phone No is longer than 10 digits"
			},
			email : {
				required : "Please enter EMail ID",
				email:"Please enter valid EMail ID"
			},
			company : {
				maxlength:"Company name is longer than 100 characters"
			},
			desination : {
				maxlength:"Designation is longer than 100 characters"
			},
			userName:{
				required:"Please enter User Name",
				maxlength:"User name is longer than 100 characters"
			},
			userPassword:{
				required:"Please enter password",
				minlength:"Password should be minimum 8 characters long"
			},
			confirmPassword:{
				required:"Please confirm password",
				minlength:"Password should be minimum 8 characters long",
				equalTo:"Please enter Confirm Password same as Password"
			}
		},
		invalidHandler : function(form, validator) {
			var errors = validator.numberOfInvalids();
			if (errors) {
				var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
				$("#registerValidationFeedback span").html(message);
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
});
	/*
	 * end of user register validation
	 */