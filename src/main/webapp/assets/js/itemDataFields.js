/**
 * @author manasi
 */
$("document").ready(function() {

    $("#validationFeedback").hide();
    /**
     * 
     */
    $( "#maxSalePriceEndDate" ).datepicker();
	$( "#maxOwDiscountEndDate" ).datepicker();
	$( "#maxInwDiscountEndDate" ).datepicker();
	//$( "#maxOwDiscountEndDate" ).datepicker();
    $("#float-modal-form").dialog({
		autoOpen: false,
		height: 450,
		width: 600,
		modal: true, 
		});
    
    $("#addItemType").click(
    		function(){
    			/*$( "#float-modal-form" ).dialog( "open" );*/
    		
    		
    			$( "#float-modal-form" ).dialog( "open" );
    			$( "#float-modal-form" ).html( data );
    			
    			
    		}
		);
    $("#addBidingType").click(
    		function(){
    			$( "#float-modal-form" ).dialog( "open" );
    		}
		);
    $("#addDiscount").click(
    		function(){
    			$( "#float-modal-form" ).dialog( "open" );
    		}
		);
    $("#addEdtion").click(
    		function(){
    			$( "#float-modal-form" ).dialog( "open" );
    		}
		);
     
     /*
     */
    $("#adminmenu").attr("class","activePage");
    var queryValidator = $("#customerForm").validate({
        rules : {
        	
        	contact_person : {
                required : true,
                maxlength : 24
            },
        	
            cust_type : {
                required : true,
                maxlength : 24
            },
             cust_en_name : {
                required : true,
                maxlength : 24
            },
            cust_mr_name: {
                required : true,
                maxlength : 24
            },
            address1 : {
                required : true,
                maxlength : 24
            },
            address2 : {
            	required : true,
                maxlength : 24
            },
            address3 : {
            	required : true,
                maxlength : 24
            },
        	
        	pincode : {
                required : true,
                number: true
            },
            email : {
                required : true,
                email : true
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
                required : true
            },
            phone2 : {
                required : true
            },
            fax : {
                required : true
            },
            mobile : {
                required : true
            }
        },
        messages : {
            cust_type: {
                required : "Provide customer type"
            },
            cust_mr_name: {
                required : "Provide customer marathi name"
            },
            city : {
                required : "Please provide customer city/town."
            },
            state : {
                required : "Please provide customer state."
            },
            country : {
                required : "Please provide customer country."
            },
            email : {
                required : "Provide customer e-mail ID.",
                email : "Please enter a valid email address, example: you@yourdomain.com"
            }
            
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
    
    $("#custTypedropdown").change( function() {
     $("#cust_type").val(this.value);	
    });
    
    $("#reset").click(function() {
        queryValidator.resetForm();
        $("#validationFeedback span").html("");
        $("#validationFeedback").hide();
    });
    
    $("#addItemTypeAjax").click(function(){
    	
  
    	$.get( "addItemTypeAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
    
	submitAjax = function(){
		$.post("submitItemTypes.html",function(data){
			alert(data);
			$( "#float-modal-form" ).dialog( "close" );
		});
	};
    

    
});

