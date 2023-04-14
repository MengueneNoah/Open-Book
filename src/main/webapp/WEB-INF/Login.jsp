<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

    <title>OpenBook - Login</title>
</head>

<body>
    <jsp:include page="partials/navbar.jsp" />
    <section class="gradient-custom"
        style="background: linear-gradient(to bottom, #000000dd, #00000077), url(https://bootstrapmade.com/demo/templates/Flexor/assets/img/team/team-2.jpg); background-size: cover;">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card bg-dark text-white" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">

                            <div class="mb-md-5 mt-md-4 pb-5">
	                            <form method="post" action="/OpenBook/LoginServlet">
	
	                                <h2 class="fw-bold mb-2 text-uppercase">Connexion</h2>
	                                <p class="text-white-50 mb-5">Veuillez saisir votre addresse email et votre mot de passe!</p>
	
	                                <div class="form-outline form-white text-start mb-4">
	                                    <label class="form-label" for="typeEmailX">Email</label>
	                                    <input required type="email" placeholder="Entrer votre email" id="typeEmailX" name="email" class="form-control form-control-lg" />
	                                </div>
	
	                                <div class="form-outline text-start form-white mb-4">
	                                    <label class="form-label" for="typePasswordX">Mot de passe </label>
	                                    <input required minLength="5" type="password" placeholder="Entrer votre mot de passe" id="typePasswordX"
	                                       name="password" class="form-control form-control-lg" />
	                                </div>
	                                
	                               <div class="form-check d-flex justify-content-center mb-5">
									    <label class="form-check-label" style="color: red;">
									        <% if (request.getAttribute("error") != null && (boolean) request.getAttribute("error")) { %>
									            <span class="error-message"><%= request.getAttribute("messageError") %></span>
									        <% } %>
									    </label>
									</div>
		
	                                <button class="btn btn-outline-light btn-lg px-5" type="submit">Connexion</button>
								</form>
								
                            </div>

                            <div>
                                <p class="mb-0">Vous n'avez pas de compte ? <a href="/OpenBook/RegisterServlet"
                                        class="text-white-50 fw-bold">S'inscrire</a>
                                </p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <jsp:include page="partials/footer.jsp" />
    <script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
        integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
</body>

</html>