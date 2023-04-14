<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Open - Register</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
        
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

                                    <h2 class="fw-bold mb-2 text-uppercase">Register</h2>
                                    <p class="text-white-50 mb-5">Please enter your login and password!</p>

                                    <div class="form-outline form-white text-start mb-4">
                                        <label class="form-label" for="typeEmailX">Name</label>
                                        <input type="text" id="typeEmailX" class="form-control form-control-lg" />
                                    </div>

                                    <div class="form-outline form-white text-start mb-4">
                                        <label class="form-label" for="typeEmailX">Email</label>
                                        <input type="email" id="typeEmailX" class="form-control form-control-lg" />
                                    </div>

                                    <div class="form-outline text-start form-white mb-4">
                                        <label class="form-label" for="typePasswordX">Password</label>
                                        <input type="password" id="typePasswordX"
                                            class="form-control form-control-lg" />
                                    </div>

                                    <div class="form-outline text-start form-white mb-4">
                                        <label class="form-label" for="typePasswordX">Confirm Password</label>
                                        <input type="password" id="typePasswordX"
                                            class="form-control form-control-lg" />
                                    </div>

                                    <div class="form-check d-flex justify-content-center mb-5">
                                        <input class="form-check-input me-2" type="checkbox" value=""
                                            id="form2Example3c" />
                                        <label class="form-check-label" for="form2Example3">
                                            I agree all statements in <a href="#!">Terms of service</a>
                                        </label>
                                    </div>

                                    <button class="btn btn-outline-light btn-lg px-5" type="submit">Register</button>

                                    <div class="d-flex justify-content-center text-center mt-4 pt-1">
                                        <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                                        <a href="#!" class="text-white"><i
                                                class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                        <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                                    </div>

                                </div>

                                <div>
                                    <p class="mb-0">Don't have an account? <a href="#!"
                                            class="text-white-50 fw-bold">Sign In</a>
                                    </p>
                                </div>

                            </div>
=======
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>OpenBook - Register</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
    
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

                                <h2 class="fw-bold mb-2 text-uppercase">Register</h2>
                                <p class="text-white-50 mb-5">Please enter your login and password!</p>

                                <div class="form-outline form-white text-start mb-4">
                                    <label class="form-label" for="typeEmailX">Name</label>
                                    <input type="text" id="typeEmailX" class="form-control form-control-lg" />
                                </div>

                                <div class="form-outline form-white text-start mb-4">
                                    <label class="form-label" for="typeEmailX">Email</label>
                                    <input type="email" id="typeEmailX" class="form-control form-control-lg" />
                                </div>

                                <div class="form-outline text-start form-white mb-4">
                                    <label class="form-label" for="typePasswordX">Password</label>
                                    <input type="password" id="typePasswordX" class="form-control form-control-lg" />
                                </div>

                                <div class="form-outline text-start form-white mb-4">
                                    <label class="form-label" for="typePasswordX">Confirm Password</label>
                                    <input type="password" id="typePasswordX" class="form-control form-control-lg" />
                                </div>

                                <div class="form-check d-flex justify-content-center mb-5">
                                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />
                                    <label class="form-check-label" for="form2Example3">
                                        I agree all statements in <a href="#!">Terms of service</a>
                                    </label>
                                </div>

                                <button class="btn btn-outline-light btn-lg px-5" type="submit">Register</button>

                                <div class="d-flex justify-content-center text-center mt-4 pt-1">
                                    <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                                    <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                    <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                                </div>

                            </div>

                            <div>
                                <p class="mb-0">Don't have an account? <a href="#!" class="text-white-50 fw-bold">Sign
                                        In</a>
                                </p>
                            </div>

>>>>>>> afe7fe70395e081c5f19c2ee0978642e8d7fbbda
                        </div>
                    </div>
                </div>
            </div>
<<<<<<< HEAD
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
=======
        </div>
    </section>

    <jsp:include page="partials/footer.jsp" />
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
        
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
        integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
</body>

</html>
>>>>>>> afe7fe70395e081c5f19c2ee0978642e8d7fbbda
