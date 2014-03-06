/**
 * @author manasi
 */
$("document").ready(function() {
	
	   $("#selectStockCenter").dialog({
			autoOpen: false,
			height: 200,
			width: 600,
			modal: true, 
			closeOnEscape: false,
			open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); }
			});
	
	$("#selectStockCenter").dialog("open");
		
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
        submitHandler : function(form){
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
    	$("#float-modal-form").attr("title","Add New Item Types");
    	$.get( "addItemTypeAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
    
    submitItemTypeAjax = function(){
		$.ajax({
			type: "POST",
			url: "submitItemTypes.html",
			data:$("#itemTypeForm").serialize(),
			dataType:"json"
		}).done(function(data) {
		    alert( "success" );
			$( "#float-modal-form" ).dialog( "close" );
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
			$( "#float-modal-form" ).html( data );

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
	}
	
	/*Add Item language*/
	$("#addLanguageAjax").click(function(){		  
    	$.get( "addLanguageAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
	submitLanguageAjax=function(){

		
		$.ajax({
			type: "POST",
			url: "submitItemlanguage.html",
			data:$("#itemlanguageForm").serialize(),
			dataType:"json"
		}).done(function(data) {
		    alert( "Language Saved" );
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

	}
	
		
	/*Add Item Edition*/
	$("#addItemsEdtionAjax").click(function(){		  
    	$.get( "addItemsEdtionAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });	   
	
	submitadditemeditionAjax=function(){

		$.ajax({
			type: "POST",
			url: "submitItemseditions.html",
			data:$("#itemsEditionForm").serialize(),
			dataType:"json"
		}).done(function(data) {
		    alert( "Edition Saved" );
			$( "#float-modal-form" ).dialog( "close" );
			$("#editionDropdown").empty();
			$("#editionDropdown").append(
                    "<option value='' >" + "Select"+ "</option>");
			 $.each(data, function(i, val) {
				 
	                $("#editionDropdown").append(
	                        "<option value=" + val.itemsEditionId + ">" + val.itemsedition+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
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
			alert(data);
			$( "#float-modal-form" ).dialog( "close" );
		});
	}
	
	/*Add Item Publish Supplier*/
	$("#addPublSupplAjax").click(function(){		  
    	$.get( "addPublSupplAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
	
	submitPublSupplAjax=function(){
		$.post("submitPublSuppl.html",$("#itemAuthorForm").serialize(),function(data){
			alert(data);
			$( "#float-modal-form" ).dialog( "close" );
		});
	}
	
	/*Add Item Category*/
	$("#addCategoriesAjax").click(function(){		  
    	$.get( "addCategoriesAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });
	submitTranslationsAjax=function(){
		$.post("submitTranslations.html",$("#itemTranslationForm").serialize(),function(data){
			alert(data);
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
	
	$("#addAwarddetailsAjax").click(function(){		  
    	$.get( "addAwarddetailsAjax.html", function( data ) {
  			$( "#float-modal-form" ).dialog( "open" );
			$( "#float-modal-form" ).html( data );

    		});
    });

	submitTranslationsAjax=function(){
	
		
		$.ajax({
			type: "POST",
			url: "submitTranslations.html",
			data:$("#itemTranslationForm").serialize(),
			dataType:"json"
		}).done(function(data) {
		    alert( "Translation Saved" );
			$( "#float-modal-form" ).dialog( "close" );
			$("#TranslationsDD").empty();
			$("#TranslationsDD").append(
                    "<option value='' >" + "Select"+ "</option>");
			 $.each(data, function(i, val) {
				 
	                $("#TranslationsDD").append(
	                        "<option value=" + val.translaionId + ">" + val.originalname+ "</option>");
	            });
		  })
		  .fail(function(faildata) {
		    alert(faildata.responseText);
		  });

	}

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
		
	}

		$("#uploadItemCoverbtn").click(function(){		  
		    	$.get( "uploadItemCover.html", function( data ) {
		  			$( "#float-modal-form" ).dialog( "open" );
					$( "#float-modal-form" ).html( data );
		
		    		});
		    });
			
			
			
			$("#uploadebookFilebtn").click(function(){		  
		    	$.get( "uploadebookFile.html", function( data ) {
		  			$( "#float-modal-form" ).dialog( "open" );
					$( "#float-modal-form" ).html( data );
		
		    		});
		    });
			
			
			$("#uploadaudioBookbtn").click(function(){		  
		    	$.get( "uploadaudioBookFile.html", function( data ) {
		  			$( "#float-modal-form" ).dialog( "open" );
					$( "#float-modal-form" ).html( data );
		
		    		});
		    });
			
			
		//	$("#uploadItemCoverCancel").click(function(){
			closeDialog=function(event){
			$("#picture").val(false);
				$( "#float-modal-form" ).dialog( "close" );
				event.preventDefault();
			}
			
			// Multipart File upload
			uploadebookFile=function(event){
				event.preventDefault();
				if($("#file").val() == null || $("#file").val() == ""){
					
					$("#dialog").dialog();
					return false;
				}
				data = new FormData();
			    data.append( 'file', $( '#file' )[0].files[0] );
			    
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
						
				    }
					});		
				
			}
		
			
			uploadItemCoverFile=function(event){
				event.preventDefault();
				if($("#file").val() == null || $("#file").val() == ""){
					
					$("#dialog").dialog();
					return false;
				}
				data = new FormData();
			    data.append( 'file', $( '#file' )[0].files[0] );
			    
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
						
				    }
					});		
				
			}
			
			uploadaudiobookFile=function(event){
				event.preventDefault();
				if($("#file").val() == null || $("#file").val() == ""){
					
					$("#dialog").dialog();
					return false;
				}
				data = new FormData();
			    data.append( 'file', $( '#file' )[0].files[0] );
			    
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
						
				    }
					});		
				
			}

						
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

				
			}
			
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

				
				
			}
			
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


			}
			
	
			
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
		   
		   $("#selectStockCenterSubmit").click(function(){
			  
			   $("#selectStockCenter").dialog("close");
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

