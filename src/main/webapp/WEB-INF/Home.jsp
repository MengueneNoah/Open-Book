<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <title>OpenBook - Home </title>

</head>

<body>
  <jsp:include page="partials/navbar.jsp" />


  <div style="margin-top: 60px; margin-bottom: 30px"
    class="inset-0 px-5 opacity-75 d-flex flex-column justify-content-center align-items-center">
    <h1 class="text-center text-dark fw-bold fs-3 mb-4">La bibliothèque OpenBook est l'endroit <span
        class="text-primary">fournisseur digital</span> <br /> idéal pour tous les amoureux de la lecture</h1>
    <p class="text-center text-black mb-4">Notre équipe de bibliothécaires passionnés est à votre disposition pour vous
      aider à trouver les livres qui vous intéressent et vous conseiller sur les nouveautés littéraires à ne pas
      manquer. Nous organisons également régulièrement des événements tels que des clubs de lecture, des conférences et
      des séances de dédicaces pour offrir à nos lecteurs une expérience encore plus enrichissante.<br />

      Que vous soyez un lecteur assidu ou que vous cherchiez simplement à passer un moment agréable en feuilletant un
      bon livre, la bibliothèque X est l'endroit parfait pour vous. Nous sommes impatients de vous accueillir et de vous
      aider à découvrir votre prochaine lecture préférée.</p>
    <button class="btn btn-primary fw-bold py-3 px-5 rounded">Besoin d'un service</button>
  </div>

  <section style="color: #000; background-color: #f3f2f2;">
    <div class="container py-5">
      <div class="row d-flex justify-content-center">
        <div class="col-md-10 col-xl-8 text-center">
          <h3 class="fw-bold mb-4">Avis de nos clients</h3>
          <p class="mb-4 pb-2 mb-md-5 pb-md-0">
            Découvrez ce que nos clients disent de notre librairie. Nous sommes fiers de leur fournir un service de
            qualité et des produits qui les enchantent.
          </p>
        </div>
      </div>
       <p>Information sur l'auteur </p>
    
	    <c:forEach var="author" items="${auteurs}">
	        
	        <div>
	            <p>ID : ${author.getId()}</p>
	            <p>Name : ${author.getName()}  </p>
	            <p>Nationality : ${author.getNationality()}</p>
	        </div>
	    </c:forEach>


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

    <jsp:include page="partials/footer.jsp" />
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      crossorigin="anonymous"></script>
</body>

</html>