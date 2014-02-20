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
    
    /*Add Item Type*/
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
	
	/*Add Item Binding Type*/
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
	
	/*Add Item Discount*/
	$("#addDiscountAjax").click(function(){		  
    	$.get( "addDiscountAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
	submitDiscountAjax=function(){
		$.post("submitItemDiscount.html",$("#itemDidcountForm").serialize(),function(data){
			alert(data);+
			$( "#float-modal-form" ).dialog( "close" );
		});
	}
	
	/*Add Item language*/
	$("#addLanguageAjax").click(function(){		  
    	$.get( "addLanguageAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
	submitLanguageAjax=function(){
		$.post("submitItemlanguage.html",$("#itemlanguageForm").serialize(),function(data){
			alert(data);+
			$( "#float-modal-form" ).dialog( "close" );
		});
	}
	
		
	/*Add Item Edition*/
	$("#addItemsEdtionAjax").click(function(){		  
    	$.get( "addItemsEdtionAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });	   
	
	submitadditemeditionAjax=function(){
		$.post("submitItemseditions.html",$("#itemsEditionForm").serialize(),function(data){
			alert(data);+
			$( "#float-modal-form" ).dialog( "close" );
		});
	}
	
	/*Add Item Stock Center*/
	$("#addStockCenterAjax").click(function(){		  
    	$.get( "addStockCenterAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
	
	submitStockCenterAjax=function(){
		$.post("submitStockCenter.html",$("#itemStockCenterForm").serialize(),function(data){
			alert(data);+
			$( "#float-modal-form" ).dialog( "close" );
		});
	}
	
	/*Add Item Author*/
	$("#addAuthorAjax").click(function(){		  
    	$.get( "addAuthorAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
	
	submitAuthorAjax=function(){
		$.post("submitAuthor.html",$("#itemAuthorForm").serialize(),function(data){
			alert(data);+
			$( "#float-modal-form" ).dialog( "close" );
		});
	}
	
	/*Add Item Publish Supplier*/
	$("#addPublSupplAjax").click(function(){		  
    	$.get( "addPublSupplAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$l( "#float-modal-form" ).html( data );

    		});
    });
	
	submitPublSupplAjax=function(){
		$.post("submitAuthor.html",$("#itemAuthorForm").serialize(),function(data){
			alert(data);+
			$( "#float-modal-form" ).dialog( "close" );
		});
	}
	
	/*Add Item Translation*/
	$("#addTranslationsAjax").click(function(){		  
    	$.get( "addTranslationsAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
	submitTranslationsAjax=function(){
		$.post("submitTranslations.html",$("#itemTranslationForm").serialize(),function(data){
			alert(data);+
			$( "#float-modal-form" ).dialog( "close" );
		});
	}

     /*
     */

});

