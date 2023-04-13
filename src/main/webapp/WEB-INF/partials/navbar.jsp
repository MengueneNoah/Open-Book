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
                    <a class="btn btn-primary" href="/OpenBook/LoginServlet" style="margin-right: 5px;"
                        id="signin-link">Sign In</a>
                </li>

                <li class="nav-item">
                    <a class="btn btn-success" href="/OpenBook/RegisterServlet" id="signup-link">Sign Up</a>
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
    if (currentLink === "/OpenBook/LoginServlet") {
        document.getElementById("signin-link").classList.add("active");
    } else if (currentLink === "/OpenBook/RegisterServlet") {
        document.getElementById("signup-link").classList.add("active");
    }

    // Masquage du bouton "Sign Up" si on n'est pas sur la page "Sign In"
    if (currentLink !== "/OpenBook/LoginServlet") {
        document.getElementById("signup-link").style.display = "none";
    }
</script>