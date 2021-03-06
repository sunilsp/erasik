/**
 * @author manasi
 */
$("document"). ready(function() {
	/*
	 * Start of Set pop-up for Stock Center
	 */
	$("#selectStockCenter").dialog({
		autoOpen: false,
		height: 300,
		width: 600,
		modal: true, 
		closeOnEscape: false,
		open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); }
		});
	$("#tempFileId").val(tempId);
	$( "#selectStockCenter" ).dialog( "option", "height", 250 );
	$( "#selectStockCenter" ).dialog( "option", "title", "Select Stock Center" );
	$( "#selectStockCenter").dialog("open");
	$("#stockcenterValidationFeedback").hide();
	 var stockcenterValidator = $("#itemStockcenter").validate
		({
	        rules : {
	        	stockCenterDD: {
	                required : true,
	            },
	        },
	        invalidHandler : function(form, validator) {
		        var errors = validator.numberOfInvalids();
		        if (errors) {
		            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
		            $("#stockcenterValidationFeedback span").html(message);
		            $("#stockcenterValidationFeedback").show();
		        } else {
		            $("#stockcenterValidationFeedback").hide();
		       
		        }
	        
	        },
	        submitHandler : function(form){
	        	$("#selectStockCenter").dialog("close");
	        },
	    });
	 /*
	  * End of Set pop-up for Stock Center
	  */
	$("#isbnno").focus();
	
	/*
	 * Make fields optional on radio click
	 */
	$("#translationRadioYAjax").change(function(){
	if ( $( this ).is( ":checked" ) )
	{
		$("#translationDetails").show();
		$("#TranslationsDD").attr("required","on");
		$("#TranslationsDD").rules('add',{
	                required : true
	            }
			);
		}
	});
	
	$("#translationRadioNAjax").change(function(){
		if ( $( this ).is( ":checked" ) ){
			$("#translationDetails").hide();
			$("#TranslationsDD").removeAttr( "required" );
			$("#TranslationsDD").rules('remove', 'required');
		}
	});
	
	$("#reprintRadioYAjax").change(function(){
		if ( $( this ).is( ":checked" ) )
		{
			$("#reprintDetails").show();
			$("#reprintDropdown").attr("required","on");
			$("#reprintDropdown").rules('add', {
	                required : true,
	            });
		}
	});
	
	$("#reprintRadioNAjax").change(function(){
		if ( $( this ).is( ":checked" ) ){
			$("#reprintDetails").hide();
			$("#reprintDropdown").removeAttr( "required" );
			$("#reprintDropdown").rules('remove','required');
		}
	});
	
	$("#awardRadioYAjax").change(function(){
		if ( $( this ).is( ":checked" ) )
		{
			$("#awardDetails").show();
			$("#AwarddetailsDD").attr("required","on");
			$("#AwarddetailsDD").rules('add', {
	                required : true,
	            });
		}
	});
	$("#awardRadioNAjax").change(function(){
		if ( $( this ).is( ":checked" ) ){
			$("#awardDetails").hide();
			$("#AwarddetailsDD").removeAttr( "required" );
			$("#AwarddetailsDD").rules('remove','required');
		}
	});
	/*
	 * custom validation
	 */
	
	jQuery.validator.setDefaults({
	    errorPlacement: function(error, element) {
	        error.appendTo(element.prev().parent());
	    }
	});
	
	jQuery.validator.addMethod("numberGreaterThan", 
		function(value, element, params) {
	
		    if (!/Invalid|NaN/.test(value)) {
		        return (Number(value) >= Number($(params).val()));
		    }
	
		    return isNaN(value) && isNaN($(params).val()) 
		        || (Number(value) >= Number($(params).val())); 
		},'Must be greater than {0}.');

	jQuery.validator.addMethod("numberLessThan", 
			function(value, element, params) {

		if (!/Invalid|NaN/.test(value)) {
	        return (Number(value) <=	Number($(params).val()));
	    }

	    return isNaN(value) && isNaN($(params).val()) 
	        || (Number(value) <=	Number($(params).val())); 
			},'Must be less than {0}.');
	
	
	jQuery.culture = Globalize.culture("en-GB");
	jQuery.validator.methods.date = function (value, element) {
		return this.optional(element)|| Globalize.parseDate(value, "dd/MM/yyyy", "en-GB")|| Globalize.parseDate(value, "yyyy-mm-dd");
     };
	/*
	 * custom validation
	 */
	

	/*
	 * Start of Add Item Form validations 
	 */
	
	$( "#validationFeedback").hide();
	/*
	 * start of validation settings
	 */
	var queryValidator = $("#addItemForm").validate({
        rules : {        	
        	userBookCode: {
                required : true,
            },
            isbnno: {
                required : false,
            },
        	itemTypeDropdown : {
                required : true,
            }, 
            languageDropdown : {
                required : true,
            },
            translationsDD : {
            	required : true,
            },
            reprintDropdown : {
            	required : true,
            },
            englishName: {
                required : false,
            },
            marathiName : {
                required : true,
            },
            authorDD : {
            	required : true,
            },
            PublSupplDD : {
            	required : true,
            },
            price : {
                required : true,
                number:true,
                range:[0,10000000],
            },
            discountedprice : {
                required : false,
                number:true,
                range:[0,10000000],
            },
            discountedpriceEndDate: {
                required : true,
                date:true,
            },
            purchasePrice: {
                required : true,
                number:true,
                numberLessThan:"#price",
                range:[0,10000000],
            },
            purchaseDiscountPercent: {
                required : true,
                number:true,
                range:[0,100],
            },
            
            maxSaleDiscountPrecent:{
            	required:true,
                number:true,
                range:[0,100],
            },
            
            maxSaleDiscountPrice:{
            	required:true,
                number:true,
                range:[0,100],
            },
            editionDropdown: {
                required : true,
            },
            CategoriesDD : {
            	required : true,
            },       
            AwarddetailsDD : {
                required : true,
            },
            awardRadio:{
            	required:true,
            },
            qtyInHand : {
                required : true,
                number:true,
            },
            noOfPages:{
            	required:true,
            	number:true,
            	range:[1,1000000],
            },
            bindingTypeDropdown : {
                required : true,
            },
            stockAmount:{
            	required:true,
                number:true,
            },
            location:{
            	required:true,
            },
            minLevel : {
                required : true,
                number:true,
                min:0,
            },
            maxLevel : {
                required : true,
                number:true,
                min:0,
            },
            itemCoverImageFileName:{
            	required:true,
            },
            maxSalePrice : {
                required : true,
                number:true,
            },            
            description : {
                maxlength : 24,
            },            
            maxSalePriceEndDate : {
            	required : true,
                date : true,
            },        	
            maxOwDiscountPrecent : {
                required : true,
                number: true,
            },
        },
        messages : {
        	 purchaseDiscountPercent: {
                 required : "Discount percent should be at least 0.",
             },
             purchasePrice: {
                 numberLessThan:"Should be less than Printed Price.",
             },
        },
        invalidHandler : function(form, validator) {
            var errors = validator.numberOfInvalids();
            if (errors) {
                var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
                $("#validationFeedback span").html(message);
                $("#validationFeedback").show();
            } else {
                $("#validationFeedback").hide();
           
            }
        },
        onfocusout: function(element) {
			$(element).valid();
		},
        submitHandler : function(form){
        	alert("check");
        	$("#hbindingtype").val(($("#bindingTypeDropdown").val()));
    		$("#hitemtype").val(($("#itemTypeDropdown").val()));
    		$("#hitemlanguage").val(($("#languageDropdown").val()));
    		$("#hitemsedition").val(($("#editionDropdown").val()));
    		$("#hitemsstockcenters").val(($("#stockCenterDD").val()));
    		$("#hitemsauthorses").val(($("#authorDD").val()));
    		$("#hitemspublsuppls").val(($("#PublSupplDD").val()));
    		$("#htranslations").val(($("#TranslationslDD").val()));
    		$("#hitemscategories").val(($("#CategoriesDD").val()));
    		$("#hawarddetails").val(($("#AwarddetailsDD").val()));
    		$("#marathiName").val(HTMLEncode($("#marathiName").val()));
			form.submit();
        },
    });
	
	$("#addItemsubmitbtn").click(function(){
		$("#hbindingtype").val(($("#bindingTypeDropdown").val()));
		$("#hitemtype").val(($("#itemTypeDropdown").val()));
		$("#hitemlanguage").val(($("#languageDropdown").val()));
		$("#hitemsedition").val(($("#editionDropdown").val()));
		$("#hitemsstockcenters").val(($("#stockCenterDD").val()));
		$("#hitemsauthorses").val(($("#authorDD").val()));
		$("#hitemspublsuppls").val(($("#PublSupplDD").val()));
		$("#htranslations").val(($("#TranslationslDD").val()));
		$("#hitemscategories").val(($("#CategoriesDD").val()));
		$("#hawarddetails").val(($("#AwarddetailsDD").val()));
		$("#marathiName").val(HTMLEncode($("#marathiName").val()));
	
		
	});
	/*
	 * end of validation settings
	 */
	$( "#reset").click(function() {
        queryValidator.resetForm();
        $("#validationFeedback span").html("");
        $("#validationFeedback").hide();
    });  
	
	/*
	 * End of Add Item Form validations 
	 */
	
	var dateOptions = {
		    dateFormat: "dd/mm/yy",
			changeMonth:true,
			changeYear:true,
		};
	
	
	$( "#maxSalePriceEndDate" ).datepicker(dateOptions);
	$( "#maxOwDiscountEndDate" ).datepicker(dateOptions);
	$( "#maxInwDiscountEndDate" ).datepicker(dateOptions);
	$( "#discountedpriceEndDate" ).datepicker(dateOptions);
    
    /**
     * 
     */
    $("#float-modal-form").dialog({
		autoOpen: false,
		height: 450,
		width: 600,
		modal: true, 
		});


    /*Add Item Type*/
    $("#addItemTypeAjax").click(function(){
    	$.get( "addItemTypeAjax.html", function( data ) 
    			{
		  			$( "#float-modal-form" ).dialog( "open" );
		  			$( "#float-modal-form" ).dialog( "option", "height", 350 );
		  			$( "#float-modal-form" ).dialog( "option", "title", "Add Item Types" );
					$( "#float-modal-form" ).html( data );
					$( "#typeValidationFeedback").hide();
					var typeValidator = $("#itemTypeForm").validate
					({
				        rules : {
				        	description: {
				                required : true,
				                rangelength:[1,50],
				            },
				            vatPerc: {
				                number:true,
				                required:false,
				                range:[0,100],
				            },
				        },
				        messages : {
				        	description: {
				                required : "Provide item description.",
				            },
				        },
				        invalidHandler : function(form, validator) {
					        var errors = validator.numberOfInvalids();
					        if (errors) {
					            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
					            $("#typeValidationFeedback span").html(message);
					            $("#typeValidationFeedback").show();
					        } else {
					            $("#typeValidationFeedback").hide();
					       
					        }
				        },
				        submitHandler : function(form){
				        	alert("Item type saved.");
				        	form.submit();
				        },
				        
				    });
					$( "#typeReset").click(function() {
						typeValidator.resetForm();
				        $("#typeValidationFeedback span").html("");
				        $("#typeValidationFeedback").hide();
				    });
					
					$( "#itemTypeCancel").click(function() {
						$( "#float-modal-form" ).dialog( "close" );
						event.preventDefault();
						});
					}); 
    	});
    submitItemTypeAjax = function(){
		$.ajax({
			type: "POST",
			url: "submitItemTypes.html",
			data:$("#itemTypeForm").serialize(),
			dataType:"json"
		}).done(function(data) {
			$("#float-modal-form" ).dialog( "close" );
			$("#itemTypeDropdown").empty();
			$("#itemTypeDropdown").append(
					"<option value='' >" + "Select" + "</option>");
			 $.each(data, function(i, val) {				 
	                $("#itemTypeDropdown").append(
	                		"<option value=" + val.itemTypeId + ">" + val.description+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });
	};  
	
	/*Add Item Binding Type*/
	$("#addBindingTypeAjax").click(function(){		  
    	$.get( "addBindingTypeAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
  			$( "#float-modal-form" ).dialog( "option", "width", 650 );
  			$( "#float-modal-form" ).dialog( "option", "height", 500 );
  			$( "#float-modal-form" ).dialog( "option", "title", "Add Binding Types" );
			$( "#float-modal-form" ).html( data );
			$( "#bindingValidationFeedback").hide();
			var bindingValidator = $("#bindingTypeForm").validate
			({
		        rules : {
		        	bindingTypeName: {
		                required : true,
		            },
		            height: {
		                required : true,
		                number:true,
		                range:[0,10000000],
		            },
		            width: {
		                required : true,
		                number:true,
		                range:[0,10000000],
		            },
		            length: {
		                required : true,
		                number:true,
		                range:[0,10000000],
		            },
		        },
		        invalidHandler : function(form, validator) {
			        var errors = validator.numberOfInvalids();
			        if (errors) {
			            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
			            $("#bindingValidationFeedback span").html(message);
			            $("#bindingValidationFeedback").show();
			        } else {
			            $("#bindingValidationFeedback").hide();
			       
			        }
		        },
		        submitHandler : function(form){
		        	form.submit();
		        },
		    });
			$( "#bindingReset").click(function() {
				bindingValidator.resetForm();
				$("#bindingValidationFeedback span").html("");
				$("#bindingValidationFeedback").hide();
		    });	
			$( "#bindingTypeCancel").click(function() {
				$( "#float-modal-form" ).dialog( "close" );
				event.preventDefault();
		    });
    	}); 
    });	    
	submitBindingTypeAjax = function(){

		$.ajax({
			type: "POST",
			url: "submitBindingTypes.html",
			data:$("#bindingTypeForm").serialize(),
			dataType:"json"
		}).done(function(data) {
		    alert( "Binding Type Saved" );
			$( "#float-modal-form" ).dialog( "close" );
			$("#bindingTypeDropdown").empty();
			  $("#bindingTypeDropdown").append(
                      "<option value='' >" + "Select" + "</option>");
          
			 $.each(data, function(i, val) {
				 
	                $("#bindingTypeDropdown").append(
	                        "<option value=" + val.bindingTypeId + ">" + val.bindingTypeName+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });

	};
	
	/*Add Item Discount*/
	$("#addDiscountAjax").click(function(){		  
    	$.get( "addDiscountAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
	submitDiscountAjax=function(){
		$.post("submitItemDiscount.html",$("#itemDidcountForm").serialize(),function(data){
			alert(data);
			$( "#float-modal-form" ).dialog( "close" );
		});
	};
	
	/*Add Item language*/
	$("#addLanguageAjax").click(function(){		  
    	$.get( "addLanguageAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
  			$( "#float-modal-form" ).dialog( "option", "height", 280 );
  			$( "#float-modal-form" ).dialog( "option", "title", "Add Language" );
			$( "#float-modal-form" ).html( data );
			$( "#languageValidationFeedback").hide();
			var languageValidator = $("#itemlanguageForm").validate
			({
		        rules : {
		        	languageName: {
		                required : true,
		                maxlength:50,
		            }
		        },
		        messages : {
		        	languageName: {
		                required : "Provide language name.",
		                maxlength : "Language name is too long. Allowed length 25.",
		            },
		        },
		        invalidHandler : function(form, validator) {
			        var errors = validator.numberOfInvalids();
			        if (errors) {
			            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
			            $("#languageValidationFeedback span").html(message);
			            $("#languageValidationFeedback").show();
			        } else {
			            $("#languageValidationFeedback").hide();
			       
			        }
		        },
		        submitHandler : function(form){
				    alert( "Language Saved" );
		        	form.submit();		        
		        },
		        
		    });
			$( "#languageReset").click(function() {
				languageValidator.resetForm();
		        $("#languageValidationFeedback span").html("");
		        $("#languageValidationFeedback").hide();
		    });
			
			$( "#languageCancel").click(function() {
				$( "#float-modal-form" ).dialog( "close" );
				event.preventDefault();
		    });

    		});
    });
	submitLanguageAjax=function(){

		
		$.ajax({
			type: "POST",
			url: "submitItemlanguage.html",
			data:$("#itemlanguageForm").serialize(),
			dataType:"json"
		}).done(function(data) {
			$( "#float-modal-form" ).dialog( "close" );
			$("#languageDropdown").empty();
			 $("#languageDropdown").append(
                     "<option value='' >" + "Select"+ "</option>");
			 $.each(data, function(i, val) {
				 
	                $("#languageDropdown").append(
	                        "<option value=" + val.languageId + ">" + val.languageName+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });

	};
	
		
	/*Add Item Edition*/
	$("#addItemsEdtionAjax").click(function(){		  
    	$.get( "addItemsEdtionAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
  			$( "#float-modal-form" ).dialog( "option", "height", 400 );
  			$( "#float-modal-form" ).dialog( "option", "title", "Add New Edition" );
			$( "#float-modal-form" ).html( data );
			$( "#editionValidationFeedback").hide();
			var nowYear = new Date().getFullYear();
			var editionValidator = $("#itemsEditionForm").validate
			({
		        rules : {
		        	itemsedition: {
		                required : true,
		            },
		            editionMonth: {
		                required : true,
		            },
		            editionYear : {
		            	required : true,
		            	max:nowYear,
		            },
		        },
		        invalidHandler : function(form, validator) {
			        var errors = validator.numberOfInvalids();
			        if (errors) {
			            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
			            $("#editionValidationFeedback span").html(message);
			            $("#editionValidationFeedback").show();
			        } else {
			            $("#editionValidationFeedback").hide();
			       
			        }
		        },
		        submitHandler : function(form){
		        	form.submit();
		        
		        },
		        
		    });
			$( "#edtionReset").click(function() {
				editionValidator.resetForm();
		        $("#editionValidationFeedback span").html("");
		        $("#editionValidationFeedback").hide();
		    });
			
			$( "#edtionCancel").click(function() {
				$( "#float-modal-form" ).dialog( "close" );
				event.preventDefault();
		    });

    		});
    });	   
	
	submitadditemeditionAjax=function(){

		$.ajax({
			type: "POST",
			url: "submitItemseditions.html",
			data:$("#itemsEditionForm").serialize(),
			dataType:"json"
		}).done(function(data) {
		    alert("Edition Saved.");
			$("#float-modal-form").dialog( "close" );
			$("#editionDropdown").empty();
			$("#editionDropdown").append(
                    "<option value='' >" + "Select"+ "</option>");
			 $.each(data, function(i, val) {
	                $("#editionDropdown").append(
	                        "<option value=" + val.editionId + ">" + val.edition+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });

	};
	
	/*Add Item Stock Center*/
	$("#addStockCenterAjax").click(function(){		  
    	$.get( "addStockCenterAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
  			$( "#float-modal-form" ).dialog( "option", "height", 550 );
  			$( "#float-modal-form" ).dialog( "option", "title", "Add New Stock Center" );
			$( "#float-modal-form" ).html( data );
			$( "#addStockCenterValidationFeedback").hide();
			var stockValidator = $("#itemStockCenterForm").validate
			({
		        rules : {
		        	stockCenterHead: {
		                required : true,
		            },
		            address1: {
		                required : true,
		            },
		            address2: {
		                required : true,
		            },
		            address3: {
		                required : false,
		            },
		            phone1: {
		                required : true,
		                number:true,
		            },
		            phone2: {
		                required : false,
		                number:true,
		            },
		            contactPerson:{
		            	required : true,
		            },
		            centerCount:{
		            	required:true,
		            	number:true,
		            },
		            canCreateInvoice:{
		            	required:true,
		            },
		        },
		        invalidHandler : function(form, validator) {
			        var errors = validator.numberOfInvalids();
			        if (errors) {
			            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
			            $("#addStockCenterValidationFeedback span").html(message);
			            $("#addStockCenterValidationFeedback").show();
			        } else {
			            $("#addStockCenterValidationFeedback").hide();
			       
			        }
		        },
		        submitHandler : function(form){
		        	form.submit();
		        
		        },
		        
		    });
			$( "#addStockCenterReset").click(function() {
				stockValidator.resetForm();
		        $("#addStockCenterValidationFeedback span").html("");
		        $("#addStockCenterValidationFeedback").hide();
		    });
			$( "#addStockCenterCancel").click(function() {
				$( "#float-modal-form" ).dialog( "close" );
				event.preventDefault();
		    });

    		});
    });
	
	submitStockCenterAjax=function(){
		
		$.ajax({
			type: "POST",
			url: "submitStockCenterAjax.html",
			data:$("#itemStockCenterForm").serialize(),
			dataType:"json"
		}).done(function(data) {
		    alert( "Stock Center Saved" );
			$( "#float-modal-form" ).dialog( "close" );
			$("#stockCenterDD").empty();
			$("#stockCenterDD").append(
                    "<option value='' >" + "Select"+ "</option>");
			 $.each(data, function(i, val) {
				 
	                $("#stockCenterDD").append(
	                        "<option value=" + val.stockCenterId + ">" + val.stockCenterId+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });

	},
	
	/*Add Item Author*/
	$("#addAuthorAjax").click(function(){		  
    	$.get( "addAuthorAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
  			$( "#float-modal-form" ).dialog( "option", "width", 800 );
  			$( "#float-modal-form" ).dialog( "option", "height", 500 );
  			$( "#float-modal-form" ).dialog( "option", "title", "Add New Author" );
			$( "#float-modal-form" ).html( data );
			$( "#authorValidationFeedback").hide();
			/*
			 * custom validation
			*/
			jQuery.validator.addMethod("dateGreaterThan", 
					function(value, element, params) {
						if($(params).val()=="") return true;

					    if (!/Invalid|NaN/.test(new Date(value))) {
					        return new Date(value) > new Date($(params).val());
					    }

					    return isNaN(value) && isNaN($(params).val()) 
					        || (Number(value) > Number($(params).val())); 
					},'Must be greater than {0}.');

			jQuery.validator.addMethod("dateLessThan", 
					function(value, element, params) {
						if($(params).val()=="") return true;

					    if (!/Invalid|NaN/.test(new Date(value))) {
					        return new Date(value) < new Date($(params).val());
					    }

					    return isNaN(value) && isNaN($(params).val()) 
					        || (Number(value) < Number($(params).val())); 
					},'Must be less than {0}.');
			/*
			 *End of custom validation
			 */
			var authorValidator = $("#itemAuthorForm").validate
			({
		       rules : {
		        	auth_en_name: {
		                required : true,
		                maxlength:50,
		            } ,
		            auth_mr_name: {
		                required : true,
		                maxlength:50,
		            },
		            address1: {
		                required : false,
		                maxlength:50,
		            },
		            address2: {
		                required : false,
		                maxlength:50,
		            },
		            address3: {
		                required : false,
		                maxlength:50,
		            },
		            pincode: {
		                required : true,
		                number:true,
		                rangelength:[6,6],
		            },
		            city: {
		                required : true,
		                maxlength:50,
		            },
		            state: {
		                required : true,
		                maxlength:50,
		            },
		            country: {
		                required : true,
		            },
		            email: {
		                required : false,
		                email:true,
		                maxlength:50,
		            },
		            phone1: {
		                required : false,
		                number:true,
		                maxlength:12,
		            },
		            phone2: {
		                required : false,
		                number:true,
		                maxlength:12,
		            },
		            fax: {
		                required : false,
		                number:true,
		                maxlength:12,
		            },
		            mobile: {
		                required : false,
		                number:true,
		                maxlength:10,
		            },
		            prefix: {
		                required : false,
		            },
		            dateOfBirth: {
		                required : false,
		                date:true,
		                dateLessThan: '#expiredDate',
		            },
		            expiredDate: {
		            	required : false,
		                date:true,
		                dateGreaterThan: "#dateOfBirth",
		            },
		            photo: {
		                required : false,
		            },
		        },
		        invalidHandler : function(form, validator) {
			        var errors = validator.numberOfInvalids();
			        if (errors) {
			            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
			            $("#authorValidationFeedback span").html(message);
			            $("#authorValidationFeedback").show();
			        } else {
			            $("#authorValidationFeedback").hide();
			       
			        }
		        },
		        submitHandler : function(form){
		        	form.submit();
		        },
		        
		        
		    });
			$( "#authorReset").click(function() {
				authorValidator.resetForm();
		        $("#authorValidationFeedback span").html("");
		        $("#authorValidationFeedback").hide();
		    });
			
			/**
			 * 
			 */
			var today = new Date();
			var dateOptionsDOE = {
			    maxDate: today,
			    dateFormat: "dd/mm/yy",
				changeMonth:true,
				changeYear:true,
				onClose:function(selectedDate){
					$("#dateOfBirth").datepicker("option","maxDate",selectedDate);
				},
			};
			var dateOptionsDOB = {
				    maxDate: today,
				    dateFormat: "dd/mm/yy",
					changeMonth:true,
					changeYear:true,
					onClose:function(selectedDate){
						$("#expiredDate").datepicker("option","minDate",selectedDate);
					},
				};
			/*
			 * 
			 */
			
			$( "#expiredDate" ).datepicker(dateOptionsDOE);
			$( "#dateOfBirth" ).datepicker(dateOptionsDOB);
			
			$( "#authorCancel").click(function() {
				$( "#float-modal-form" ).dialog( "close" );
				event.preventDefault();
	    	});
    	});
    });
	
	submitaddauthorAjax=function(){
		
		$("#auth_mr_name").val(HTMLEncode($("#auth_mr_name").val()));
		
		
		$.ajax({
			type: "POST",
			url: "submitaddAuthorAjax.html",
			data:$("#itemAuthorForm").serialize(),
			dataType:"json"
		}).done(function(data) {
       	 alert( "Author Saved" );
			
			$( "#float-modal-form" ).dialog( "close" );
			$("#authorDD").empty();
			$("#authorDD").append(
                     "<option value='' >" + "Select"+ "</option>");
			 $.each(data, function(i, val) {
				 
	                $("#authorDD").append(
	                        "<option value=" + val.authorId + ">" + val.englishName+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });	
		
	};

	
	$("#addItemsReprintAjax").click(function(){
		$.get( "addItemReprintAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
  			$( "#float-modal-form" ).dialog( "option", "height", 400 );
  			$( "#float-modal-form" ).dialog( "option", "title", "Add New Reprint" );
			$( "#float-modal-form" ).html( data );
			$( "#reprintValidationFeedback").hide();
			var nowYear = new Date().getFullYear();
			var reprintValidator = $("#itemsReprintForm").validate
			({
		        rules : {
		        	itemsreprint: {
		                required : true,
		            },
		            reprintMonth: {
		                required : true,
		            },
		            reprintYear : {
		            	required : true,
		            	max:nowYear,
		            }
		        },
		        invalidHandler : function(form, validator) {
			        var errors = validator.numberOfInvalids();
			        if (errors) {
			            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
			            $("#reprintValidationFeedback span").html(message);
			            $("#reprintValidationFeedback").show();
			        } else {
			            $("#reprintValidationFeedback").hide();
			       
			        }
		        },
		        submitHandler : function(form){
		        	alert("In submit handler");
		        	form.submit();		        
		        },
		        
		    });
			$( "#additemsreprintReset").click(function() {
				reprintValidator.resetForm();
		        $("#reprintValidationFeedback span").html("");
		        $("#reprintValidationFeedback").hide();
		    });
			
			$( "#additemsreprintCancel").click(function() {
				$( "#float-modal-form" ).dialog( "close" );
				event.preventDefault();
		    });

    		});
	});
	
	submitadditemReprintAjax=function(){
		$.ajax({
			type: "POST",
			url: "submitadditemReprintAjax.html",
			data:$("#itemsReprintForm").serialize(),
			dataType:"json"
		}).done(function(data) {
		    alert("Item reprint Saved");
			$( "#float-modal-form" ).dialog( "close" );
			$("#reprintDropdown").empty();
			$("#reprintDropdown").append(
                     "<option value='' >" + "Select"+ "</option>");
			 $.each(data, function(i, val) {
				 
	                $("#reprintDropdown").append(
	                        "<option value=" + val.reprintId + ">" + val.reprint+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });
		};
	
	/*Add Item Publish Supplier*/
	$("#addPublSupplAjax").click(function(){		  
    	$.get( "addPublSupplAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
  			$( "#float-modal-form" ).dialog( "option", "width", 800 );
  			$( "#float-modal-form" ).dialog( "option", "height", 500 );
  			$( "#float-modal-form" ).dialog( "option", "title", "Add New Publish Supplier" );
			$( "#float-modal-form" ).html( data );
			$( "#pubSupplValidationFeedback").hide();
			
			var publValidator = $("#itemsPublSupplForm").validate
			({
		        rules : {
		        	englishName: {
		                required : true,
		                maxlength:50,
		            },
		            pubsupplmarathiName: {
		                required : true,
		                maxlength:50,
		            },
		            address1: {
		                required : false,
		                maxlength:50,
		            },
		            address2: {
		                required : false,
		                maxlength:50,
		            },
		            address3: {
		                required : false,
		                maxlength:50,
		            },
		            pincode: {
		                required : true,
		                number:true,
		                maxlength:6,
		                minlength:6,
		            },
		            city: {
		                required : true,
		                maxlength:50,
		            },
		            state: {
		                required : true,
		                maxlength:50,
		            },
		            country: {
		                required : true,
		            },
		            email: {
		                required : true,
		                email:true,
		            },
		            phone1: {
		                required : false,
		                number:true,
		                maxlength:12,
		            },
		            phone2: {
		                required : false,
		                number:true,
		                maxlength:12,
		            },
		            fax: {
		                required : false,
		                maxlength:12,
		            },
		            mobile: {
		                required : false,
		                number:true,
		                maxlength:10,
		            },
		            website: {
		                required : false,
		                url:true,
		            },
		            contactPerson: {
		                required : true,
		                maxlength:50,
		            }
		        },
		        invalidHandler : function(form, validator) {
			        var errors = validator.numberOfInvalids();
			        if (errors) {
			            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
			            $("#pubSupplValidationFeedback span").html(message);
			            $("#pubSupplValidationFeedback").show();
			        } else {
			            $("#pubSupplValidationFeedback").hide();
			       
			        }
		        },
		        submitHandler : function(form){
		        	form.submit();
		        },
		        
		    });
			$( "#publishReset").click(function() {
				publValidator.resetForm();
		        $("#pubSupplValidationFeedback span").html("");
		        $("#pubSupplValidationFeedback").hide();
		    });
			
			$( "#addpublsupplCancel").click(function() {
				$( "#float-modal-form" ).dialog( "close" );
		    });

    		});
    });
	
	submitpublsupplAjax=function(){
		$("#pubsupplmarathiName").val(HTMLEncode($("#pubsupplmarathiName").val()));
		
		$.ajax({
			type: "POST",
			url: "submitpublsupplAjax.html",
			data:$("#itemsPublSupplForm").serialize(),
			dataType:"json"
		}).done(function(data) {
		    alert( "Publisher/Supplier Saved" );
			$( "#float-modal-form" ).dialog( "close" );
			$("#PublSupplDD").empty();
			$("#PublSupplDD").append(
                     "<option value='' >" + "Select"+ "</option>");
			 $.each(data, function(i, val) {
				 
	                $("#PublSupplDD").append(
	                        "<option value=" + val.pubSupId + ">" + val.englishName+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });


	};
	
	/*Add Item Category*/
	$("#addCategoriesAjax").click(function(){		  
    	$.get( "addCategoriesAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
  			$( "#float-modal-form" ).dialog( "option", "height", 350 );
  			$( "#float-modal-form" ).dialog( "option", "title", "Add New Category" );
			$( "#float-modal-form" ).html( data );
			$( "#categoryValidationFeedback").hide();
			var categoryValidator = $("#itemCategoryForm").validate
			({
		        rules : {
		        	categoryHeadEnglish: {
		                required : true,
		            },
		            categoryHeadMarathi: {
		                required : true,
		            }
		        },
		        invalidHandler : function(form, validator) {
			        var errors = validator.numberOfInvalids();
			        if (errors) {
			            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
			            $("#categoryValidationFeedback span").html(message);
			            $("#categoryValidationFeedback").show();
			        } else {
			            $("#categoryValidationFeedback").hide();
			       
			        }
		        },
		        submitHandler : function(form){
		        	form.submit();		        
		        },
		        
		    });
			$( "#categoryReset").click(function() {
				categoryValidator.resetForm();
		        $("#categoryValidationFeedback span").html("");
		        $("#categoryValidationFeedback").hide();
		    });
			$( "#categoryCancel").click(function() {
				$( "#float-modal-form" ).dialog( "close" );
				event.preventDefault();
		    });	

    		});
    });
	submitadditemcategoryAjax=function(){
		
		$("#categoryHeadMarathi").val(HTMLEncode($("#categoryHeadMarathi").val()));
	
		$.ajax({
			type: "POST",
			url: "submitadditemcategoryAjax.html",
			data:$("#itemCategoryForm").serialize(),
			dataType:"json"
		}).done(function(data) {
		    alert( "Category Saved" );
			$( "#float-modal-form" ).dialog( "close" );
			$("#CategoriesDD").empty();
			$("#CategoriesDD").append(
                     "<option value='' >" + "Select"+ "</option>");
			 $.each(data, function(i, val) {
				 
	                $("#CategoriesDD").append(
	                        "<option value=" + val.categoryId + ">" + val.categoryHeadEnglish+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });
	};

	/*Add Item Translation*/
	$("#addTranslationsAjax").click(function(){		  
    	$.get( "addTranslationsAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
  			$( "#float-modal-form" ).dialog( "option", "height", 400 );
  			$( "#float-modal-form" ).dialog( "option", "title", "Add Translation" );
			$( "#float-modal-form" ).html( data );
			$( "#translationValidationFeedback").hide();
			var translateValidator = $("#itemTranslationForm").validate
			({
		        rules : {
		        	translatedfrom: {
		                required : true,
		                maxlength:50,
		            },
		            originalname: {
		                required : true,
		                maxlength:50,
		            }
		            ,
		            originalauthor: {
		                required : true,
		                maxlength:50,
		            },
		        },
		        invalidHandler : function(form, validator) {
			        var errors = validator.numberOfInvalids();
			        if (errors) {
			            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
			            $("#translationValidationFeedback span").html(message);
			            $("#translationValidationFeedback").show();
			        } else {
			            $("#translationValidationFeedback").hide();
			       
			        }
		        },
		        submitHandler : function(form){
				    alert( "Translation Saved" );
		        	form.submit();
		        },
		        
		    });
			$( "#translationReset").click(function() {
				translateValidator.resetForm();
		        $("#translationValidationFeedback span").html("");
		        $("#translationValidationFeedback").hide();
		    });
			
			$( "#translationCancel").click(function() {
				$( "#float-modal-form" ).dialog( "close" );
				event.preventDefault();
		    });

    		});
    });
	
		submitTranslationsAjax=function(){
		
		$.ajax({
			type: "POST",
			url: "submitTranslations.html",
			data:$("#itemTranslationForm").serialize(),
			dataType:"json"
		}).done(function(data) {
			$( "#float-modal-form" ).dialog( "close" );
			$("#translationsDD").empty();
			$("#translationsDD").append(
                    "<option value='' >" + "Select"+ "</option>");
			 $.each(data, function(i, val) {
				 
	                $("#translationsDD").append(
	                        "<option value=" + val.translaionId + ">" + val.originalname+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });

		};
		
	/*
	 * 
	 */
		
	$("#addAwarddetailsAjax").click(function(){		  
    	$.get( "addAwarddetailsAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
  			$( "#float-modal-form" ).dialog( "option", "height", 400 );
  			$( "#float-modal-form" ).dialog( "option", "title", "Add Award Details" );
			$( "#float-modal-form" ).html( data );
			$( "#awardValidationFeedback").hide();
			var awardValidator = $("#itemAwardForm").validate
			({
		        rules : {
		        	awardDetailsEnglish: {
		                required : true,
		            },
		            awardDetailsMarathi: {
		                required : true,
		            }
		            ,
		            dateOfAward: {
		                required : true,
		                date:true,
		            }
		        },
		        invalidHandler : function(form, validator) {
			        var errors = validator.numberOfInvalids();
			        if (errors) {
			            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
			            $("#awardValidationFeedback span").html(message);
			            $("#awardValidationFeedback").show();
			        } else {
			            $("#awardValidationFeedback").hide();
			       
			        }
		        },
		        submitHandler : function(form){
		        	alert("in submit handler");
		        	form.submit();
		        
		        },
		        
		    });
			$( "#awardReset").click(function() {
				awardValidator.resetForm();
		        $("#awardValidationFeedback span").html("");
		        $("#awardValidationFeedback").hide();
		    });
			
			$( "#awardCancel").click(function() {
				$( "#float-modal-form" ).dialog( "close" );
				event.preventDefault();
		    });
			/**
			 * 
			 */
			var today = new Date();
			var dateOptions = {
			    maxDate: today,
			    dateFormat: "dd/mm/yy",
			    changeMonth:true,
			    changeYear:true,
			};
			
			$( "#dateOfAward" ).datepicker(dateOptions);

    		});
    });

	

	submitadditemAwardAjax=function(){		
		$("#awardDetailsMarathi").val(HTMLEncode($("#awardDetailsMarathi").val()));
		
		$.ajax({
			type: "POST",
			url: "submitaddAwardAjax.html",
			data:$("#itemAwardForm").serialize(),
			dataType:"json"
		}).done(function(data) {
		    alert( "Award Details Saved" );
			$( "#float-modal-form" ).dialog( "close" );
			$("#AwarddetailsDD").empty();
			$("#AwarddetailsDD").append(
                    "<option value='' >" + "Select"+ "</option>");
			 $.each(data, function(i, val) {
				 
	                $("#AwarddetailsDD").append(
	                        "<option value=" + val.awardDetailId + ">" + val.awardDetailsEnglish+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });
		
	};

		$("#uploadItemCoverbtn").click(function(){		  
		    	$.get( "uploadItemCover.html", function( data ) {
		  			$( "#float-modal-form" ).dialog( "open" );
		  			$( "#float-modal-form" ).dialog( "option", "height", 300 );
		  			$( "#float-modal-form" ).dialog( "option", "width", 480 );
		  			$( "#float-modal-form" ).dialog( "option", "title", "Upload Item Cover" );
					$( "#float-modal-form" ).html( data );
					$( "#itemCoverValidationFeedback").hide();
					var coverValidator = $("#uploadItemCover").validate
					({
				        rules : {
				        	file: {
				                required : true,
				            },
				        },
				        invalidHandler : function(form, validator) {
					        var errors = validator.numberOfInvalids();
					        if (errors) {
					            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
					            $("#itemCoverValidationFeedback span").html(message);
					            $("#itemCoverValidationFeedback").show();
					        } else {
					            $("#itemCoverValidationFeedback").hide();
					       
					        }
				        },
				        submitHandler : function(form){
				        	event.preventDefault();
							data = new FormData();
						    data.append( 'file', $( '#file' )[0].files[0] );
						    data.append( 'tempFileId', $( '#tempFileId').val() );
						    
							$.ajax({
							    url: "uploadItemCoverFile.html",
							    type: "POST",
							    data: data,							   
							    contentType: false,
							    cache: false,
							    processData: false,
							    dataType: "text",
							    success: function(data){
							    	 $("#itemCoverImageFileName").text(data);
							    	 $("#itemCoverImage").val(data);
									$( "#float-modal-form" ).dialog( "close" );
									
							    }
								});	
				        
				        },
				        
				    });
					$( "#itemCoverReset").click(function() {
						coverValidator.resetForm();
				        $("#itemCoverValidationFeedback span").html("");
				        $("#itemCoverValidationFeedback").hide();
				    });
					
					$( "#uploadItemCoverCancel").click(function() {
						$("#picture").val(false);
						$( "#float-modal-form" ).dialog( "close" );
						event.preventDefault();
				    	});
					
		    		});
		    });
			
			
			
			$("#uploadebookFilebtn").click(function(){		  
		    	$.get( "uploadebookFile.html", function( data ) {
		  			$( "#float-modal-form" ).dialog( "open" );
		  			$( "#float-modal-form" ).dialog( "option", "height", 300 );
		  			$( "#float-modal-form" ).dialog( "option", "width", 480 );
		  			$( "#float-modal-form" ).dialog( "option", "title", "Upload Ebook File" );
					$( "#float-modal-form" ).html( data );
					$( "#ebookValidationFeedback").hide();
					var ebookValidator = $("#uploadebookFile").validate
					({
				        rules : {
				        	file: {
				                required : true,
				            },
				        },
				        invalidHandler : function(form, validator) {
					        var errors = validator.numberOfInvalids();
					        if (errors) {
					            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
					            $("#ebookValidationFeedback span").html(message);
					            $("#ebookValidationFeedback").show();
					        } else {
					            $("#ebookValidationFeedback").hide();
					       
					        }
				        },
				        submitHandler : function(form){
				        	
				        },
				        
				    });
					$( "#itemCoverReset").click(function() {
						ebookValidator.resetForm();
				        $("#ebookValidationFeedback span").html("");
				        $("#ebookValidationFeedback").hide();
				    });
					
					$( "#uploadebookFileCancel").click(function() {
						$("#ebook").val(false);
						$( "#float-modal-form" ).dialog( "close" );
						event.preventDefault();
				    	});
		
		    		});
		    });
			
			
			$("#uploadaudioBookbtn").click(function(){		  
		    	$.get( "uploadaudioBookFile.html", function( data ) {
		  			$( "#float-modal-form" ).dialog( "open" );
		  			$( "#float-modal-form" ).dialog( "option", "height", 300 );
		  			$( "#float-modal-form" ).dialog( "option", "width", 480 );
		  			$( "#float-modal-form" ).dialog( "option", "title", "Upload Ebook File" );
					$( "#float-modal-form" ).html( data );
					$( "#audiobookValidationFeedback").hide();
					var audioValidator = $("#uploadaudiobookFile").validate
					({
				        rules : {
				        	file: {
				                required : true,
				            },
				        },
				        invalidHandler : function(form, validator) {
					        var errors = validator.numberOfInvalids();
					        if (errors) {
					            var message = errors == 1 ? 'You missed 1 field. It has been highlighted' : 'You missed ' + errors + ' fields. They have been highlighted';
					            $("#audiobookValidationFeedback span").html(message);
					            $("#audiobookValidationFeedback").show();
					        } else {
					            $("#audiobookValidationFeedback").hide();
					       
					        }
				        },
				        submitHandler : function(form){
				        	
				        },
				        
				    });
					$( "#audiobookReset").click(function() {
						audioValidator.resetForm();
				        $("#audiobookValidationFeedback span").html("");
				        $("#audiobookValidationFeedback").hide();
				    });
					
					$( "#uploadaudiobookFileCancel").click(function() {
						$("#audiobook").val(false);
						$( "#float-modal-form" ).dialog( "close" );
						event.preventDefault();
				    	});
		    		});
		    });
			
			
		//	$("#uploadItemCoverCancel").click(function(){
			closeDialog=function(event){
			$("#picture").val(false);
				$( "#float-modal-form" ).dialog( "close" );
				event.preventDefault();
			};
			
			// Multipart File upload
			uploadebookFile=function(event){
				event.preventDefault();
				if($("#file").val() == null || $("#file").val() == ""){
					
					$("#dialog").dialog();
					return false;
				}
				data = new FormData();
			    data.append( 'file', $( '#file' )[0].files[0] );
			    data.append( 'tempFileId', $( '#tempFileId').val() );
			    
				$.ajax({
				    url: "uploadebookFileSubmit.html",
				    type: "POST",
				    data: data,
				   
				    contentType: false,
				    cache: false,
				    processData: false,
				    dataType: "text",
				    success: function(data){
				    	 alert(data);
				    	 $("#ebookFileName").text(data);
				    	 $("#ebookFile").val(data);
						$( "#float-modal-form" ).dialog( "close" );
						
				    },
					});		
				
			};
		
			
			uploadItemCoverFile=function(event){
				event.preventDefault();
				if($("#file").val() == null || $("#file").val() == ""){
					
					$("#dialog").dialog();
					return false;
				}
				data = new FormData();
			    data.append( 'file', $( '#file' )[0].files[0] );
			    data.append( 'tempFileId', $( '#tempFileId').val() );
			    
				$.ajax({
				    url: "uploadItemCoverFile.html",
				    type: "POST",
				    data: data,
				    contentType: false,
				    cache: false,
				    processData: false,
				    dataType: "text",
				    success: function(data){
				    	 alert(data);
				    	 $("#itemCoverImageFileName").text(data);
				    	 $("#itemCoverImage").val(data);
						$( "#float-modal-form" ).dialog( "close" );
						
				    },
					});		
				
			};
			
			uploadaudiobookFile=function(event){
				event.preventDefault();
				if($("#file").val() == null || $("#file").val() == ""){
					
					$("#dialog").dialog();
					return false;
				}
				data = new FormData();
			    data.append( 'file', $( '#file' )[0].files[0] );
			    data.append( 'tempFileId', $( '#tempFileId').val() );
			    
				$.ajax({
				    url: "uploadAudioFileSubmit.html",
				    type: "POST",
				    data: data,				   
				    contentType: false,
				    cache: false,
				    processData: false,
				    dataType: "text",
				    success: function(data){
				    	 alert(data);
				    	 $("#audioBookFileName").text(data);
				    	 $("#audioBookFile").val(data);
						$( "#float-modal-form" ).dialog( "close" );
						
				    },
					});		
				
			};
			
		   $("#itemsPublSupplForm").submit(function(){
			   var marathiConvert=HTMLEncode($("#marathiName").val());
					$("#pubsupplmarathiName").val(marathiConvert);
					$.post("submitpublsupplAjax.html",$("#itemsPublSupplForm").serialize(),function(data){
						alert(data);
						$( "#float-modal-form" ).dialog( "close" );
					});
		
		        });

		   $("#exitAddItem").click(function(){
			   window.location="showItemTypes.html";
		   });
		   
		  
		
		   var englishNameofBook="";
		  /* $("#marathiName").keypress(function(event){
			   englishNameofBook.concat(String.fromCharCode(event.which));
			  });
		   */
		  /* $("#marathiName").blur(function(){
			   $("#englishName").val($("#marathiName").val());
			});
		  */ 
		   
		   $("#purchasePrice").blur(function(){
			   if($("#price").val() != ""){
				   if($("#purchasePrice").val() != ""){
					   var p_val=Math.round((($("#price").val()-$("#purchasePrice").val())/$("#price").val()) * 100);
					   if(!isNaN(p_val)){
						   $("#purchaseDiscountPercent").val(p_val);
					   }			   
				   }
			   }
		   });
		   
		   
		   $("#purchaseDiscountPercent").blur(function(){
			   if($("#price").val() != ""){
				   if($("#purchaseDiscountPercent").val() != ""){
					   var p_val=$("#price").val()-($("#price").val()*$("#purchaseDiscountPercent").val() /100);
					   if(!isNaN(p_val)){
					   $("#purchasePrice").val(p_val);
					   }
				   }
			   }
		   });
		   
		   $("#maxSaleDiscountPrecent").blur(function(){
			   if($("#price").val() != ""){
				   if($("#maxSaleDiscountPrecent").val() != ""){
					   var p_val=$("#price").val()-($("#price").val()*$("#maxSaleDiscountPrecent").val() /100);
					   if(!isNaN(p_val)){
					   $("#maxSaleDiscountPrice").val(p_val);
					   }
				   }
			   }
		   });
		   
		   $("#maxSaleDiscountPrice").blur(function(){
			   if($("#price").val() != ""){
				   if($("#maxSaleDiscountPrice").val() != ""){
					   var p_val= (($("#price").val()-$("#maxSaleDiscountPrice").val())/$("#price").val()) * 100;
						   if(!isNaN(p_val)){
					   $("#maxSaleDiscountPrecent").val(p_val);
						   }
				   }
			   }
		   });
		   
			function HTMLEncode(str){
				  var i = str.length,
				      aRet = [];

				  while (i--) {
				    var iC = str[i].charCodeAt();
				    if (iC < 65 || iC > 127 || (iC>90 && iC<97)) {
				      aRet[i] = '&#'+iC+';';
				    } else {
				      aRet[i] = str[i];
				    }
				   }
				  return aRet.join('');    
				}		
	/*
     */

});

