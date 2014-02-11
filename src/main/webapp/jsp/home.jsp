<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="assets/js/libs/modernizr-2.5.2.min.js"></script> <
<style>
      body { background-color: #eee; font: helvetica; }
      #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
      .green { font-weight: bold; color: green; }
      .message { margin-bottom: 10px; }
      label { width:70px; display:inline-block;}
      .hide { display: none; }
      .error { color: red; font-size: 0.8em; }
    </style>
<title>Kriyas Skeleton</title>
</head>
<body>
<b>User Info </b><br/>
${userInfo.name}
<br/>
<hr/>

 <h2>Get By ID</h2>
    <form id="idForm">
      <div class="error hide" id="idError">Please enter a valid ID in range 0-3</div>
      <label for="personId">ID (0-3): </label><input name="id" id="personId" value="0" type="text"/>
      <input type="submit" value="Get Person By ID" /> <br /><br/>
      <div id="personIdResponse"> </div>
    </form>

<script type="text/javascript">
  
    $(document).ready(function() {
    	
    	 // Request Person by ID AJAX
        $('#idForm').submit(function(e) {
          var userId = +$('#personId').val();
          if(!validatePersonId(userId)) 
            return false;
          $.get('${pageContext.request.contextPath}/user.do/' + userId, function(user) {
            $('#personIdResponse').text(user.userId + ':  Name ' + user.name);
          });
          e.preventDefault(); // prevent actual form submit
        });
    	
    });
    
    function validatePersonId(personId) {
        console.log(personId);
        if(personId === undefined || personId < 0 || personId > 3) {
          $('#idError').show();
          return false;
        }
        else {
          $('#idError').hide();
          return true;
        }
      }
  </script>  
    

</body>
</html>