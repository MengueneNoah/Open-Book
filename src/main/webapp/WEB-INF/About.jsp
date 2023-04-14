<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>OpenBook - About</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

</head>

<body>
    <jsp:include page="partials/navbar.jsp" />


    <section id="apropos" class="apropos section-bg">
        <div class="container">
            <div class="row">
                <div class="col-xl-5 col-lg-6 d-flex justify-content-center align-items-stretch position-relative">
                    <video src="https://youtu.be/YewQfTQnBgM" class="glightbox play-btn mb-4"></video>
                </div>
                <div
                    class="col-xl-7 col-lg-6 d-flex flex-column align-items-stretch justify-content-center py-5 px-lg-5">
                    <h1>À propos de Open Book</h1>
                    <h4 class="mb-3">Découvrez notre librairie numérique</h4>
                    <p class="mt-2" style="text-align: justify;">Open Book est une librairie numérique proposant une
                        large sélection de
                        livres électroniques de qualité. Nous mettons à disposition des lecteurs des ouvrages de
                        différents genres, allant de la fiction à la non-fiction, en passant par les ouvrages de
                        référence. Grâce à notre plateforme, vous pouvez découvrir et lire des livres depuis votre
                        ordinateur, tablette ou téléphone portable, où que vous soyez dans le monde.</p>

                    <div class="icon-box">
                        <div class="d-flex align-items-center">
                            <div class="icon me-2"><i class="bi bi-patch-check-fill"></i></div>
                            <h4 class="title"><a class="text-dark" href="#">Qualité garantie</a></h4>
                        </div>
                        <p class="description">Tous les livres proposés sur Open Book sont soigneusement
                            sélectionnés pour leur qualité et leur pertinence, afin de garantir une expérience de
                            lecture agréable pour nos utilisateurs.</p>
                    </div>

                    <div class="icon-box" data-aos-delay="100">
                        <div class="d-flex align-items-center">
                            <div class="icon me-2"><i class="bi bi-star-fill"></i></div>
                            <h4 class="title"><a class="text-dark" href="#">Offres spéciales</a></h4>
                        </div>
                        <p class="description">Nous proposons régulièrement des offres spéciales sur certains
                            livres, ainsi que des réductions pour les utilisateurs réguliers. Inscrivez-vous à notre
                            newsletter pour être tenu informé de nos promotions en cours.</p>
                    </div>

                    <div class="icon-box">
                        <div class="d-flex align-items-center">
                            <div class="icon me-2"><i class="bi bi-globe"></i></div>
                            <h4 class="title"><a class="text-dark" href="#">Plateforme conviviale</a></h4>
                        </div>
                        <p class="description">Notre plateforme a été conçue pour offrir une expérience utilisateur
                            simple et intuitive. Trouvez facilement les livres que vous recherchez grâce à notre
                            fonction de recherche avancée, et gérez votre bibliothèque numérique depuis votre compte
                            utilisateur.</p>
                    </div>

                </div>
            </div>
        </div>

    </section><!-- Fin de la section À propos -->
    <section id="team" class="team section-bg">
        <div class="container">

            <div class="section-title text-center pb-3">
                <h2 data-aos="fade-up pb-3">Team</h2>
                <p data-aos="fade-up">Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid
                    fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui
                    impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>
            </div>

            <div class="row pb-3">

                <div class="col-lg-4 col-md-6 d-flex align-items-stretch" data-aos="fade-up">
                    <div class="member shadow-lg px-2 pt-2 pb-5 mb-3  text-center rounded-3"
                        style="background-color: #33333377">
                        <div class="member-img">
                            <img src="https://bootstrapmade.com/demo/templates/Flexor/assets/img/team/team-2.jpg"
                                class="mb-3 img-fluid shadow-lg rounded-3" alt="">
                            <div class="social">
                                <a href=""><i class="bi bi-twitter"></i></a>
                                <a href=""><i class="bi bi-facebook"></i></a>
                                <a href=""><i class="bi bi-instagram"></i></a>
                                <a href=""><i class="bi bi-linkedin"></i></a>
                            </div>
                        </div>
                        <div class="member-info">
                            <h4>Kamdem Fokom Bismark</h4>
                            <span>Chief Executive Officer</span>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="100">
                    <div class="member shadow-lg px-2 pt-2 pb-5 mb-3 text-center rounded-3"
                        style="background-color: #33333377">
                        <div class="member-img">
                            <img src="https://bootstrapmade.com/demo/templates/Flexor/assets/img/team/team-2.jpg"
                                class="mb-3 img-fluid shadow-lg rounded-3" alt="">
                            <div class="social">
                                <a href=""><i class="bi bi-twitter"></i></a>
                                <a href=""><i class="bi bi-facebook"></i></a>
                                <a href=""><i class="bi bi-instagram"></i></a>
                                <a href=""><i class="bi bi-linkedin"></i></a>
                            </div>
                        </div>
                        <div class="member-info">
                            <h4>Menguene Noah Chantal</h4>
                            <span>Product Manager</span>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="200">
                    <div class="member shadow-lg px-2 pt-2 pb-5 mb-3 text-center rounded-3"
                        style="background-color: #33333377">
                        <div class="member-img">
                            <img src="https://bootstrapmade.com/demo/templates/Flexor/assets/img/team/team-2.jpg"
                                class="mb-3 img-fluid shadow-lg rounded-3" alt="">
                            <div class="social">
                                <a href=""><i class="bi bi-twitter"></i></a>
                                <a href=""><i class="bi bi-facebook"></i></a>
                                <a href=""><i class="bi bi-instagram"></i></a>
                                <a href=""><i class="bi bi-linkedin"></i></a>
                            </div>
                        </div>
                        <div class="member-info">
                            <h4>Eyebe Eloundou Joel Cedric</h4>
                            <span>Developpeur Back-end</span>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </section><!-- End Team Section -->



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