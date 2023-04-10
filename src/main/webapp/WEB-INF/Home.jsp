<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
    integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
    crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
  <script>
    $(document).ready(function () {
      $('#type').select2({
        placeholder: 'Sélectionnez un type de documents'
      });

      $('#title').select2({
        placeholder: 'Sélectionnez un titre'
      });

      $('#author').select2({
        placeholder: 'Sélectionnez un auteur'
      });

      $('#publishing_house').select2({
        placeholder: "Sélectionnez une maison d'édition"
      });
    });
    
	 // Récupération du bouton et du modal
    var modalBtn = document.getElementById("modalBtn");
    var modal = document.getElementById("modalRelatedContent");

    // Ajout de l'événement clic au bouton
    modalBtn.addEventListener("click", function() {
      modal.style.display = "block";
    });

    // Fermeture du modal lorsque l'utilisateur clique sur le bouton de fermeture
    modal.querySelector(".close").addEventListener("click", function() {
      modal.style.display = "none";
    });

    // Fermeture du modal lorsque l'utilisateur clique en dehors du modal
    window.addEventListener("click", function(event) {
      if (event.target == modal) {
        modal.style.display = "none";
      }
    });

  </script>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <title>OpenBook - Home </title>

</head>

<body>
  <jsp:include page="partials/navbar.jsp" />
   <jsp:include page="partials/details.jsp" />

  <div style="margin-top: 60px; margin-bottom: 30px"
    class="inset-0 px-5 opacity-75 d-flex flex-column justify-content-center align-items-center">
    <h1 class="text-center text-dark fw-bold fs-3 mb-4">La bibliothèque OpenBook est l'endroit <span
        class="text-primary">fournisseur digital</span> <br /> idéal pour tous les amoureux de la lecture</h1>
    <p class="text-center text-black mb-4">Notre équipe de bibliothécaires passionnés est à votre disposition pour vous
      aider à trouver les documents qui vous intéressent et vous conseiller sur les nouveautés littéraires à ne pas
      manquer. Nous organisons également régulièrement des événements tels que des clubs de lecture, des conférences et
      des séances de dédicaces pour offrir à nos lecteurs une expérience encore plus enrichissante.<br />
      Que vous soyez un lecteur assidu ou que vous cherchiez simplement à passer un moment agréable en feuilletant un
      bon livre, la bibliothèque X est l'endroit parfait pour vous. Nous sommes impatients de vous accueillir et de vous
      aider à découvrir votre prochaine lecture préférée.</p>
    <button class="btn btn-primary fw-bold py-3 px-5 rounded">Besoin d'un service</button>
  </div>


  <section class="mt-4 mb-4">

    <div class="container">
      <form action="container">
        <div class="my-3">
          <div class="row">
            <div class="col-sm-3">
              <select class="form-control" id="title" name="title">
                <option value="">Title</option>
                <c:forEach var="doc" items="${documents}">
                  <option value="${ doc.getId() }">${ doc.getTitle() }</option>
                </c:forEach>
              </select>
            </div>

            <div class="col-sm-3">
              <select class="form-control" id="author" name="author">
                <option value="">Auteur</option>
                <c:forEach var="author" items="${authors}">
                  <option value="${ author.getId() }">${ author.getName() }</option>
                </c:forEach>
              </select>
            </div>

            <div class="col-sm-3">
              <select class="form-control" id="type" name="type">
                <option value="">Sélectionnez un type de document</option>
                <c:forEach var="documentType" items="${types}">
                  <option value="${ documentType.getId() }">${ documentType.getLibelle() }</option>
                </c:forEach>
              </select>
            </div>

            <div class="col-sm-3">
              <select class="form-control" id="publishing_house" name="publishing_house">
                <option value="">Sélectionnez une maison d'édition</option>
                <c:forEach var="publishingHouse" items="${publishingHouses}">
                  <option value="${ publishingHouse.getId() }">${ publishingHouse.getName() }</option>
                </c:forEach>
              </select>

            </div>
          </div>
        </div>
      </form>
      <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
          <c:forEach items="${documents}" var="document" varStatus="loop">
            <c:if test="${loop.index % 3 == 0}">
              <div class="carousel-item ${loop.index == 0 ? 'active' : ''}">
                <div class="row row-cols-1 row-cols-md-3 g-4">
            </c:if>
            <div class="col">
              <div class="card h-100">
                <img src="${document.getImageUrl()}" class="card-img-top" alt="${document.getTitle()}" />
                <div class="card-body">
                  <h5 class="card-title" style="font-weight: bold;"> ${document.getTitle()}</h5>
                  <c:set var="summary">${document.getSummary()}</c:set>
                  <c:set var="summaryWithoutFirstSentence" value="${fn:substringAfter(summary, '. ')}" />
                  <p style="text-align: justify;" class="card-text">${fn:substringBefore(summary, '. ')}. <span
                      class="more-text d-none">${summaryWithoutFirstSentence}</span></p>

                </div>

                <div style="text-align: center; margin: 1%; width: 100%; font-weight: bold;">
                  <table class="table table-striped">
                    <tr>
                      <td>Auteur </td>
                      <td>${ document.getAuthor().getName() }</td>
                    </tr>

                    <tr>
                      <td>Maison d'édition </td>
                      <td>${ document.getPublishingHouse().getName() }</td>
                    </tr>

                    <tr>
                      <td>Publier le </td>
                      <td>${ document.getPublicationDate() }</td>
                    </tr>
                  </table>
                </div>

                <div style="margin-left: 2%; margin-bottom: 2%; width: 100%;">
                	<!-- Button trigger modal-->
                	<button type="button" class="btn btn-primary" id="modalBtn">Lire la suite</button>
                </div>

              </div>
            </div>
            <c:if test="${(loop.index + 1) % 3 == 0 || loop.last}">
        </div>
      </div>
      </c:if>
      </c:forEach>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
    </div>
    </div>
  </section>


  <section style="color: #000; background-color: #f3f2f2;">
    <div class="container py-5">
      <div class="row d-flex justify-content-center">
        <div class="col-md-10 col-xl-8 text-center">
          <h3 class="fw-bold mb-4">Avis de nos clients</h3>
         <p class="mb-4 pb-2 mb-md-5 pb-md-0">Découvrez ce que nos clients disent de notre librairie. Nous sommes fiers de leur fournir un service de qualité et des produits qui les enchantent.</p>
        </div>
      </div>


      <div class="row text-center container">
        <c:forEach var="testimonial" items="${testimonials}">
          <div class="col-md-4 mb-4 mb-md-0">
            <div class="card">
              <div class="card-body py-4 mt-2">
                <div class="d-flex justify-content-center mb-4">
                  <img src="${testimonial.picture}" class="rounded-circle shadow-1-strong" width="100" height="100" />
                </div>
                <h5 class="font-weight-bold">${testimonial.name}</h5>
                <h6 class="font-weight-bold my-3">${testimonial.post}</h6>
                <ul class="list-unstyled d-flex justify-content-center">
                  <c:forEach begin="1" end="${testimonial.like}" varStatus="star">
                    <li>
                      <i class="bi bi-star-fill"></i>
                    </li>
                  </c:forEach>
                  <c:forEach begin="${testimonial.like+1}" end="5">
                    <li>
                      <i class="bi bi-star"></i>
                    </li>
                  </c:forEach>
                </ul>
                <p class="mb-2">
                  <i class="bi bi-quote"></i> ${testimonial.texte}
                </p>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </section>

  <jsp:include page="partials/footer.jsp" />
  <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    crossorigin="anonymous"></script>
</body>

</html>