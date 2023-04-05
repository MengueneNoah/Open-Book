
<nav class="navbar navbar-expand-lg navbar-dark bg-dark rounded">
  <div class="container-fluid">
    <a class="navbar-brand" href="/home-work/">OpenBook</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
      aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">
                      
        <li class="nav-item">
          <a class="nav-link" href="/home-work/" id="home-link">Home</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="/home-work/AboutServlet" id="about-link">About</a>
        </li>
    
        <li class="nav-item">
          <a class="nav-link" href="#" id="contact-link">Contact</a>
        </li>
        
        <li class="nav-item">
            <button class="btn btn-primary" style="margin-right: 5px;" type="button" id="signin-button">Sign In</button>
        </li>
        
        <li class="nav-item">
          <button class="btn btn-success" type="button" id="signup-button">Sign Up</button>
        </li>
        
      </ul>
    </div>
  </div>
</nav>

<script>
  // Récupération du lien actif
  var currentLink = window.location.pathname;

  // Ajout de la classe "active" sur l'élément correspondant
  if (currentLink === "/home-work/") {
    document.getElementById("home-link").classList.add("active");
  } else if (currentLink === "/home-work/AboutServlet") {
    document.getElementById("about-link").classList.add("active");
  } else if (currentLink === "/home-work/ContactServlet") {
    document.getElementById("contact-link").classList.add("active");
  }
  
  // Ajout de la classe "active" sur le bouton correspondant
  if (currentLink === "/home-work/SignInServlet") {
    document.getElementById("signin-button").classList.add("active");
  } else if (currentLink === "/home-work/SignUpServlet") {
    document.getElementById("signup-button").classList.add("active");
  }
</script>