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
	$("#eRasikContainer").hide();
	//$("#phone1").mask("(999)99-99-999999");
	jQuery.validator.setDefaults({
	    errorPlacement: function(error, element) {
	        error.appendTo(element.prev().parent());
	    }
	});
	$("#verification-dialog").dialog({
		autoOpen:false,
		height:450,
		width:550,
		modal:true,
		title:"E-mail ID and Phone number verification"
	});
	
	$( "#verification-dialog" ).on( "dialogopen", function( event, ui ) {
		$("#verification-accordion").accordion({ heightStyle: "fill" });
		$("#step1-email :button").on("click",function(){
			$("#verification-accordion").accordion("option","active",1);
		});
		$("#step2-OTP :button").on("click",function(){
			$("#verification-accordion").accordion("option","active",2);
		});
		$("#step4-OTPFailed :button").on("click",function(){
			$("#verification-accordion").accordion("option","active",1);
		});
	} );
	
	
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
								//isRasikEmp : true,
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
							if($("#needverify").is(":checked")){
								$("#designationHidden").val(($("#eRasikDesignation").val())?$("#eRasikDesignation").val():$("#nonERasikDesignation").val());
								$("#companyHidden").val($("#companyName").val());
								$("#verification-dialog").dialog("open");
							}
							else{
								form.submit();
							}
						},
						
						onfocusout: function(element) {
							$(element).valid();
						},
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

	$("#username").on("focusout",function(){
		if(registerValidator.element($(this))){
			var checkUsername= $.get("http://www.google.com",{username:$(this).val()})
			.done(function(data) {
				var iuserName=$("#username").val();
				var refStatus=$("#username").parent().find(".fieldInstructions");
				if(data){
					refStatus.html("Username "+iuserName+" is available.");
				}
				else{
					refStatus.html("Username "+iuserName+" is not available. Please chose another name.");
					$("#username").val("");
				}
			})
			.fail(function(data) {
				var refStatus=$("#username").parent().find(".fieldInstructions");
				refStatus.html("Checking if username is available. Can not contact server.");
					
			})
			.always(function(data) {
				var refStatus=$("#username").parent().find(".fieldInstructions");
				refStatus.html("Checking if username is available...");
			});
		}
	});
	$("#designation").bind("change",function(){
		$("#designationHidden").val(($("#eRasikDesignation").val())?$("#eRasikDesignation").val():$("#nonERasikDesignation").val());
		$("#companyHidden").val($("#companyName").val());
	});
	
	$("#companyName").bind("change",function(){
		var value=$(this).val();
		$("#companyHidden").val(value);
	});
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
		
		if(registerValidator.element($(this))){
			var checkEmail= $.get("http://www.google.com",{username:$(this).val()})
			.done(function(data) {
				/*var iEmail=$("#email").val();
				var refStatus=$("#email").parent().find(".fieldInstructions");
				if(data){
					refStatus.html("EMail ID "+iEmail+" is not yet registered.");
				}
				else{
					refStatus.html("Username "+iEmail+" is already registered.");
					$("#username").val("");
				}*/
			})
			.fail(function(data) {
				var refStatus=$("#username").parent().find(".fieldInstructions");
				refStatus.html("Checking if EMail ID is already registered. Can not contact server.");
					
			})
			.always(function(data) {
				var refStatus=$("#username").parent().find(".fieldInstructions");
				refStatus.html("Checking if EMail ID is already registered is available...");
			});
		}
		// script to run only if E-mail ID is not already registered.
		if(registerValidator.element("#email")){
		if($("#needverify").is(":checked")){
			$(this).parent().find(".fieldInstructions").html("E-mail ID verification pending...");
		}
		var pattern=/@erasik.com/i;
		if (pattern.test($(this).val())) {
			console.log("is erasik employee");
			$("#nonERasikDesignation").val("");			
			$("#companyName").val("Rasik Sahitya Pvt. Ltd.");
			$("#companyName").prop( "disabled", true );
			$("#eRasikContainer").show();
			$("#nonERasikContainer").hide();
			$("#eRasikDesignation").focus();
		} else {
			console.log("is not erasik employee");
			$("#eRasikDesignation").val("");
			$("#companyName").val("");
			$("#companyName").prop( "disabled", false );
			$("#eRasikContainer").hide();
			$("#nonERasikContainer").show();
			$("#companyName").focus();
		}
	}
	});
	$("#phone1").bind("blur",function(){
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