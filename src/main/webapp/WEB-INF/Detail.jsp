<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous" />

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css" />

    <title>OpenBook - ${document.getTitle()} </title>

</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark rounded">
        <div class="container-fluid">
            <a class="navbar-brand" href="/OpenBook/">OpenBook</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">

                    <li class="nav-item">
                        <a class="nav-link active" href="/OpenBook/" id="home-link">Retour</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>


    <div class="container-fluid py-2 bg-header">
        <div class="col-12 text-center">
            <h1 style="font-weight: bolder;">
                <c:out value="${document.getTitle()}" />
            </h1>
        </div>

    </div>

    <div class="container-fluid py-5 wow fadeInUp" data-wow-delay="0.1s">
        <div class="container">
            <div class="row g-5">
                <div class="col-lg-8">
                    <!-- Blog Detail Start -->
                    <div class="mb-5">
                        <img class="img-fluid w-100 rounded mb-5" src="${document.getImageUrl()}"
                            alt="${document.getTitle()}">
                        <h1 class="mb-4">
                            <c:out value="${document.getTitle()}" />
                        </h1>
                        <p style="text-align: justify;">
                            <c:out value="${document.getSummary()}" />
                        </p>

                        <ul class="list-group text-center">
                            <li class="list-group-item">
                                <p>Découvrez un chef-d'œuvre intemporel : ${document.getTitle()},
                                    publié le ${document.getPublicationDate()}
                                    par l'auteur renommé ${document.getAuthor().getName()}
                                    de nationalité ${document.getAuthor().getNationality()}.</p>
                            </li>
                            <li class="list-group-item">
                                <p>Plongez dans un monde captivant de ${document.getTitle()},
                                    édité par ${document.getPublishingHouse().getName()}
                                    situé à ${document.getPublishingHouse().getCountry()}.</p>
                            </li>
                            <li class="list-group-item">
                                <p>Explorez les recoins les plus sombres de l'univers avec ce livre palpitant, qui
                                    vous emmènera dans une quête épique à travers les étoiles.</p>
                            </li>
                            <li class="list-group-item">
                                <p>Type de document : ${document.getType().getLibelle()}.</p>
                            </li>
                            <li class="list-group-item">
                                <p>Maison d'édition : ${document.getPublishingHouse().getName()}
                                    situé à ${document.getPublishingHouse().getCountry()}.</p>
                            </li>
                            <li class="list-group-item">
                                <p>Auteur de nationalité : ${document.getAuthor().getNationality()}.</p>
                            </li>
                        </ul>

                    </div>

                </div>

                <!-- Sidebar Start -->
                <div class="col-lg-4">

                    <!-- Category Start -->
                    <div class="mb-5 wow slideInUp" data-wow-delay="0.1s">
                        <div class="section-title section-title-sm position-relative pb-3 mb-4">
                            <h3 class="mb-0">Categories</h3>
                        </div>
                        <c:forEach var="category" items="${categorys}">
                            <div class="link-animated d-flex flex-column justify-content-start">
                                <a class="h5 fw-semi-bold bg-light rounded py-2 px-3 mb-2"
                                    href="${category.getId()}"><i class="bi bi-arrow-right me-2"></i>
                                    <c:out value="${category.getLibelle()}" />
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- Category End -->

                    <!-- Plain Text Start -->
                    <div class="wow slideInUp" data-wow-delay="0.1s">
                        <div class="section-title section-title-sm position-relative pb-3 mb-4">
                            <h3 class="mb-0">Bon à savoir</h3>
                        </div>
                        <div class="bg-light text-center" style="padding: 30px;">
                            <p style="text-align: justify;">La lecture développe l'esprit d'analyse et l'esprit
                                critique. La lecture sollicite votre esprit critique et votre esprit d'analyse.
                                Chaque page tournée renforce le tissu de connaissances dans votre esprit et vous
                                aide à terme à mieux comprendre le monde qui vous entoure. Tout comme le sport par
                                exemple, la lecture procure du plaisir, aide à oublier les problèmes du quotidien et
                                nous éloigne du stress. La lecture permet de développer la mémoire et les capacités
                                cognitives. Comprendre un livre nécessite de retenir une grande quantité
                                d'informations.</p>
                        </div>
                    </div>

                    <!-- Plain Text End -->
                </div>
                <!-- Sidebar End -->
            </div>
        </div>
    </div>



    <jsp:include page="partials/footer.jsp" />
    <script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
        integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</body>

</html>