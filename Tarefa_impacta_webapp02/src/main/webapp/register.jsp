<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- loader-->
  <link href="css/pace.min.css" rel="stylesheet"/>
  <script src="js/pace.min.js"></script>
  <!--favicon-->
  <link rel="icon" href="images/favicon.ico" type="image/x-icon">
  <!-- Bootstrap core CSS-->
  <link href="css/bootstrap.min.css" rel="stylesheet"/>
  <!-- animate CSS-->
  <link href="css/animate.css" rel="stylesheet" type="text/css"/>
  <!-- Icons CSS-->
  <link href="css/icons.css" rel="stylesheet" type="text/css"/>
  <!-- Custom Style-->
  <link href="css/app-style.css" rel="stylesheet"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js" integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <title>TESTE ATOS</title>
</head>
<body class="bg-theme bg-theme1">

<input type="hidden" id="statusInput" value="<%= request.getAttribute("status") %>">

<!-- start loader -->
   <div id="pageloader-overlay" class="visible incoming"><div class="loader-wrapper-outer"><div class="loader-wrapper-inner" ><div class="loader"></div></div></div></div>
<!-- end loader -->

<!-- Start wrapper-->
 <div id="wrapper">

	<div class="card card-authentication1 mx-auto my-4">
		<div class="card-body">
		 <div class="card-content p-2">
		 	<div class="text-center">
		 		<img src="images/logo-icon.png" alt="logo icon">
		 	</div>
		  <div class="card-title text-uppercase text-center py-3">Registro</div>
		    <form action="register" method="post">
			  <div class="form-group">
			  <label for="exampleInputName" class="sr-only">Nome</label>
			   <div class="position-relative has-icon-right">
				  <input type="text" id="exampleInputName" name="user" class="form-control input-shadow" placeholder="Insira seu nome">
				  <div class="form-control-position">
					  <i class="icon-user"></i>
				  </div>
			   </div>
			  </div>
			  <div class="form-group">
			  <label for="exampleInputEmailId" class="sr-only">Email ID</label>
			   <div class="position-relative has-icon-right">
				  <input type="text" id="exampleInputEmailId" name="email" class="form-control input-shadow" placeholder="Insira Email ID">
				  <div class="form-control-position">
					  <i class="icon-envelope-open"></i>
				  </div>
			   </div>
			  </div>
			  <div class="form-group">
			   <label for="exampleInputPassword" class="sr-only">Password</label>
			   <div class="position-relative has-icon-right">
				  <input type="password" id="exampleInputPassword" name="pass" class="form-control input-shadow" placeholder="Insira Password">
				  <div class="form-control-position">
					  <i class="icon-lock"></i>
				  </div>
			   </div>
			  </div>

			 <input type="submit" value="Registrar" class="btn btn-light btn-block waves-effect waves-light"></input>
			 </form>
		   </div>
		  </div>
		  <div class="card-footer text-center py-3">
		    <p class="text-warning mb-0">Ja tenho conta! <a href="login.jsp"> Entrar </a></p>
		  </div>
	     </div>
    
	</div><!--wrapper-->
	
  <!-- Bootstrap core JavaScript-->
  <script src="js/jquery.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/app-script.js"></script>
  <script type="text/javascript">
    var status=document.getElementById("statusInput").value;
    if(status == "sucesso"){
    	swal("Resultado","Registrado com sucesso!", "success");
    } 
    if(status == "falha") {
    	swal("Resultado","Falha no registro!","warning");
    }
  </script>
</body>
</html>