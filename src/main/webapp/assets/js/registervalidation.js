/**
 * @author mundie
 */
/*
 * User Login validations

$(window).bind("pageshow", function() {
	    var form = $('form'); 
	    // let the browser natively reset defaults
	    form[0].reset();
	}); */

$(function() {
	$("#registerValidationFeedback").hide();
	jQuery.validator.setDefaults({
	    errorPlacement: function(error, element) {
	        error.appendTo(element.prev().parent());
	    }
	});
	var registerValidator = $("#userRegistrationForm").validate(
					{
						rules : {
							firstName : {
								required : true,
								minlength : 1,
								maxlength : 100,
							},
							lastName : {
								minlength : 1,
								maxlength : 100,
							},
							address1 : {
								maxlength : 100,
							},
							address2 : {
								maxlength : 100,
							},
							city : {
								required : true,
							},
							state : {
								required : true,
							},
							country : {
								required : true,
							},
							phone1 : {
								required : true,
								number : true,
								rangelength : [10,13],
							},
							
							email : {
								required : true,
								email : true,
								isRasikEmp : true,
							},
							companyName : {
								maxlength : 100,
							},
							designation:{
								required: {
						            depends: function(element) {
						            	var pattern=/@erasik.com/;
						        		return (pattern.test($("#email").val())) ;
						            }
								},
							},
							username : {
								required : true,
								maxlength : 100,
							},
							password : {
								required : true,
								minlength : 8,
							},
							confirmPassword : {
								required : true,
								rangelength : [8,12],
								equalTo : "#password",
							},
						},
						messages : {
							firstName : {
								required : "Please enter First Name.",
								maxlength : "First Name is longer than 100 characters.",
							},
							lastName : {
								maxlength : "First Last is longer than 100 characters.",
							},
							address1 : {
								maxlength : "Address Line 1 is longer than 100 characters.",
							},
							address2 : {
								maxlength : "Address Line 2 is longer than 100 characters.",
							},
							city : {
								required : "Please enter City.",
							},
							state : {
								required : "Please select State.",
							},
							country : {
								required : "Please select Country.",
							},
							phone1 : {
								required : "Please enter Phone No.",
								number : "Please enter valid Phone No.",
								maxlength : "Phone No is longer than 10 digits.",
							},
							email : {
								required : "Please enter EMail ID.",
								email : "Please enter valid EMail ID.",
							},
							companyName : {
								maxlength : "Company name is longer than 100 characters.",
							},
							designation : {
								required : "Please select designation.",
								maxlength : "Designation is longer than 100 characters.",
							},
							username : {
								required : "Please enter User Name.",
								maxlength : "User name is longer than 100 characters.",
							},
							password : {
								required : "Please enter password",
								minlength : "Password should be minimum 8 characters long.",
								maxlength : "Password is longer than 12 characters.",
							},
							confirmPassword : {
								required : "Please re-enter Password.",
								minlength : "Password should be minimum 8 characters long.",
								equalTo : "Please enter Confirm Password same as Password.",
							},
						},
						invalidHandler : function(form, validator) {
							var errors = validator.numberOfInvalids();
							if (errors) {
								var message = errors == 1 ? 'You missed 1 field. It has been highlighted'
										: 'You missed '
												+ errors
												+ ' fields. They have been highlighted';
								$("#registerValidationFeedback span").html(message);
								$("#registerValidationFeedback").show();
							} else {
								$("#registerValidationFeedback").hide();

							}
						},
						submitHandler: function(form) { 
							$("#designationHidden").val($("#designation").val());
							$("#companyHidden").val($("#companyName").val());
							form.submit();
						},
						
						/*onfocusout: function(element) {
							console.log($(element).attr("id"));
							if($(element).attr("id")!="email" && $(element).attr("id")!="companyname"){
							$(element).valid();}
							
						},*/
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

	$.validator.addMethod("isRasikEmp", function(value) {
		var pattern=/@erasik.com/;
		if (pattern.test(value)) {
			$("#companyName").val("Rasik Sahitya Pvt. Ltd.");
			$("#companyName").prop( "disabled", true );
			$("#designation").remove();
			var html_content='<select tabindex="120" name="designation" id="designation" th:field="*{designation}" placeholder="Designation" required="required">';
			html_content+="<option value=''>Please select</option>";
			html_content+="<option value='manager'>Manager</option>";
			html_content+="<option value='accountant'>Accountant</option>";
			html_content+="</select>";
			$("#companyName").parent().next().append(html_content);
			$("#designation").prev().attr('class','required');
			$("#designation").focus();
		} else {
			$("#companyName").val("");
			$("#companyName").prop( "disabled", false );
			$("#designation").remove();
			var html_content='<input type="text" tabindex="120" autocomplete="on" name="designation" id="designation" th:field="*{designation}" placeholder="Designation"/>';
			$("#companyName").parent().next().append(html_content);
			$("#designation").prev().removeClass('required');
			$("#companyName").focus();
		}
		
		$("#designation").bind("change",function(){
			var value=$(this).val();
			$("#designationHidden").val(value);
			$("#companyHidden").val($("#companyName").val());
		});
		
		$("#companyName").bind("change",function(){
			var value=$(this).val();
			$("#companyHidden").val(value);
		});
		return true;
	}, "");
	$("#country").change(function(){
		var selectedCountry=$(this).val();
		var statesArray=[];
		$("#state").html("");
		switch(selectedCountry){
		case("India"):
			$.getJSON("../../erasik/assets/data/states_ind.json",function(data){
				statesArray=data;
				populateStates(statesArray);
			});
		break;
		case("US"):
			$.getJSON("../../erasik/assets/data/states_usa.json",function(data){
				statesArray=data;
				populateStates(statesArray);
			});
		break;
		default:
		break;
		}
		
	});
	$("#needverify").bind("change",function(){
		if($(this).is(":checked")){
			if(registerValidator.element("#email")){
				$("#email").parent().find(".fieldInstructions").html("E-mail ID verification pending...");
			}
			if(registerValidator.element("#phone1")){
				$("#phone1").parent().find(".fieldInstructions").html("Phone number verification pending...");
			}
		}
	});
	$("#email").bind("blur",function(){
		if(registerValidator.element("#email") && $("#needverify").is(":checked")){
			$(this).parent().find(".fieldInstructions").html("E-mail ID verification pending.");
	}
	});
	$("#phone1").bind("blur",function(){
		console.log($("#phone1").parent().find(".fieldInstructions"));
		if(registerValidator.element("#phone1") && $("#needverify").is(":checked")){
			$(this).parent().find(".fieldInstructions").html("Phone number verification pending...");
	}
	});

});
function populateStates(istatesArray){
	var output="";
	if(istatesArray.length>1){
		output="<option value=''>Select State</option>";
		$.each(istatesArray,function(key,value){
			output+="<option value='"+value+"'>"+value+"</option>";
		});
	}
	else{
		output="<option value=''>Country not selected</option>";
	}
	$("#state").html(output);
}

/*
 * end of user register validation
 */