<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
=======
>>>>>>> afe7fe70395e081c5f19c2ee0978642e8d7fbbda
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
<<<<<<< HEAD
    <title>Contacts page</title>
=======
    <title>OpenBook - Contacts</title>
>>>>>>> afe7fe70395e081c5f19c2ee0978642e8d7fbbda

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
<<<<<<< HEAD
    
=======
   
>>>>>>> afe7fe70395e081c5f19c2ee0978642e8d7fbbda
</head>

<body>
    <jsp:include page="partials/navbar.jsp" />

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
        <div class="container">

            <div class="section-title text-center pt-4">
                <h2 data-aos="fade-up text-center">Contact</h2>
                <p data-aos="fade-up">Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid
                    fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui
                    impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>
            </div>

            <div class="row justify-content-center">

                <div class="col-xl-3 col-lg-4 mt-4" data-aos="fade-up">
                    <div class="info-box">
                        <i class="bx bx-map"></i>
                        <h3>Our Address</h3>
                        <p>A108 Adam Street, New York, NY 535022</p>
                    </div>
                </div>

                <div class="col-xl-3 col-lg-4 mt-4 text-center" data-aos="fade-up" data-aos-delay="100">
                    <div class="info-box">
                        <i class="bx bx-envelope"></i>
                        <h3>Email Us</h3>
                        <p>info@example.com<br>contact@example.com</p>
                    </div>
                </div>
                <div class="col-xl-3 col-lg-4 mt-4 text-end" data-aos="fade-up" data-aos-delay="200">
                    <div class="info-box">
                        <i class="bx bx-phone-call"></i>
                        <h3>Call Us</h3>
                        <p>+1 5589 55488 55<br>+1 6678 254445 41</p>
                    </div>
                </div>
            </div>

            <div class="mx-auto my-3" style="height: 2px; width: 50%; background-color: black;"></div>

            <div class="row justify-content-center" data-aos="fade-up" data-aos-delay="300">
                <div class="col-xl-9 col-lg-12 mt-4 mb-5">
                    <form action="forms/contact.php" method="post" role="form" class="php-email-form">
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <input type="text" name="name" class="form-control" id="name"
                                    placeholder="Your Name" required>
                            </div>
                            <div class="col-md-6 form-group mt-3 mt-md-0">
                                <input type="email" class="form-control" name="email" id="email"
                                    placeholder="Your Email" required>
                            </div>
                        </div>
                        <div class="form-group mt-3">
                            <input type="text" class="form-control" name="subject" id="subject"
                                placeholder="Subject" required>
                        </div>
                        <div class="form-group mt-3">
                            <textarea class="form-control" name="message" rows="5" placeholder="Message"
                                required></textarea>
                        </div>
                        <div class="my-3">
                            <div class="loading">Loading</div>
                            <div class="error-message"></div>
                            <div class="sent-message">Your message has been sent. Thank you!</div>
                        </div>
                        <div class="text-center"><button class="btn btn-primary" type="submit">Send Message</button>
                        </div>
                    </form>
                </div>

            </div>

        </div>
    </section><!-- End Contact Section -->



    <jsp:include page="partials/footer.jsp" />
    <script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<<<<<<< HEAD

=======
        
>>>>>>> afe7fe70395e081c5f19c2ee0978642e8d7fbbda
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
        integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
</body>

</html>