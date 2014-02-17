/**
 * @author manasi
 */
$("document").ready(function() {

    $("#validationFeedback").hide();
    $("#adminmenu").attr("class","activePage");

    var queryValidator = $("#itemTypeForm").validate({
        rules : {
            description : {
                required : true,
                minlength : 1,
                maxlength : 24
            },
            
            vatPerc : {
                required : true,
                number:true
            }
        },
        messages : {
        	description : {
                required : "Item description is required"
            },
            vatPerc : {
                required : "Please enter a valid number"
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
    $("#reset").click(function() {
        queryValidator.resetForm();
        $("#validationFeedback span").html("");
        $("#validationFeedback").hide();
    });

    $('a[href="#listItemtypes.html"]').click(function(){
    	$.get("listItemtypes.html",function(data){
			$( "#ajaxForm").html(data);
    	});
	});
    
    $('a[href="#showItemTypes.html"]').click(function(){
    	$.get("addItemTypeAjax.html",function(data){
			$( "#ajaxForm").html(data);
    	});
	});

	submitAjax = function(){
		$.post("submitItemTypes.html",$("#itemTypeForm").serialize(),function(data){
			alert(data);
			$( "#float-modal-form" ).dialog( "close" );
		});
	};

    

});

