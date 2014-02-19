/**
 * @author manasi
 */
$("document").ready(function() {
	
	$( "#maxSalePriceEndDate" ).datepicker();
	$( "#maxOwDiscountEndDate" ).datepicker();
	$( "#maxInwDiscountEndDate" ).datepicker();
	
	$( "#validationFeedback").hide();
	
	/*
	 * start of validation settings
	 */
	var queryValidator = $("#addItemForm").validate({
        rules : {
        	
        	itemTypeDropdown : {
                required : true
            },        	
            bindingTypeDropdown : {
                required : true
            },
            languageDropdown : {
                required : true
            },
            editionDropdown: {
                required : true
            },
            stockCenterDD:{
            	required : true
            },
            authorDD:{required : true},
            PublSupplDD:{required : true},
            TranslationsDD:{required : true},
            CategoriesDD:{required : true},
            userBookCode : {
                required : true
            },
            englishName: {
                required : true
            },
            marathiName : {
                required : true
            },
            publisherCode : {
                required : true
            },
            price : {
                required : true,
                number:true
            },
            qtyInHand : {
                required : true,
                number:true
            },
            minLvl : {
                required : true,
                number:true
            },
            maxLvl : {
                required : true,
                number:true
            },
            
            maxSalePrice : {
                required : true,
                number:true
            },
            publMonth : {
                required : true
            },
            publYear : {
                required : true,
                number:true
            },
            isbnno : {
                required : true,
                number:true
            },            
            noOfPages : {
                required : true,
                number:true
            },
            
            description : {
                required : true,
                maxlength : 24
            },
            printStatus : {
            	required : true
            },
            maxSalePriceEndDate : {
            	required : true,
                date : true
            },        	
            maxOwDiscountPrecent : {
                required : true,
                number: true
            },
            maxOwDiscountEndDate : {
                required : true,
                date : true
            },
            maxInwDiscountPercent : {
                required : true,
                number: true
            },
            maxInwDiscountEndDate : {
                required : true
            }
        },
        messages : {
            
        },
       
        faultPlacement : function(fault, element) {
           
                fault.insertAfter(element);
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

        onkeyup : true,
        
    });
	/*
	 * end of validation settings
	 */
    $( "#reset").click(function() {
        queryValidator.resetForm();
        $("#validationFeedback span").html("");
        $("#validationFeedback").hide();
    });  
    
    /**
     * 
     */
    $("#float-modal-form").dialog({
		autoOpen: false,
		height: 450,
		width: 600,
		modal: true, 
		});
    
    $("#addItemTypeAjax").click(function(){
    	$.get( "addItemTypeAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
    submitItemTypeAjax = function(){
		$.post("submitItemTypes.html",$("#itemTypeForm").serialize(),function(data){
			alert(data);
			$( "#float-modal-form" ).dialog( "close" );
		});
	};  

	$("#addBindingTypeAjax").click(function(){		  
    	$.get( "addBindingTypeAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });	    
	submitBindingTypeAjax = function(){
		$.post("submitBindingTypes.html",$("#bindingTypeForm").serialize(),function(data){
			alert(data);+
			$( "#float-modal-form" ).dialog( "close" );
		});
	};
    
     /*
     */

});

