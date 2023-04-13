
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
          <a class="nav-link" href="/OpenBook/" id="home-link">Home</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="/OpenBook/AboutServlet" id="about-link">About</a>
        </li>
    
        <li class="nav-item">
          <a class="nav-link" href="/OpenBook/ContactServlet" id="contact-link">Contact</a>
        </li>
        
        <li class="nav-item">
            <a class="btn btn-primary" href="/OpenBook/loginServlet" style="margin-right: 5px;" type="button" id="signin-button">Sign In</a>
        </li>
        
        <li class="nav-item">
          <a class="btn btn-success" href="/OpenBook/RegisterServlet" type="button" id="signup-button">Sign Up</a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>

<script>
  // Récupération du lien actif
  var currentLink = window.location.pathname;

  // Ajout de la classe "active" sur l'élément correspondant
  if (currentLink === "/OpenBook/") {
    document.getElementById("home-link").classList.add("active");
  } else if (currentLink === "/OpenBook/AboutServlet") {
    document.getElementById("about-link").classList.add("active");
  } else if (currentLink === "/OpenBook/ContactServlet") {
    document.getElementById("contact-link").classList.add("active");
  }
  
  // Ajout de la classe "active" sur le bouton correspondant
  if (currentLink === "/OpenBook/SignInServlet") {
    document.getElementById("signin-button").classList.add("active");
  } else if (currentLink === "/OpenBook/SignUpServlet") {
    document.getElementById("signup-button").classList.add("active");
  }
</script>