<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />

    <title>OpenBook - Error </title>

</head>

<body>
	
    <!--Modal: modalRelatedContent-->
    <div class="modal" id="myModalDetailPageError">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title" style="color: red;">
                        ${modalTitle}
                    </h4>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <p style="text-align: text-justify;">${modalBody}</p>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <a class="btn btn-danger" href="${modalButtonLink}">${modalButtonText}</a>
                </div>

            </div>
        </div>
    </div>

    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
        integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script type="text/javascript">
    	$(document).ready(function() {
            // Utilisation de JSTL pour obtenir la valeur de la variable "error"
            var error = ${error};
            if (error) {
                // Afficher la modal si "error" est défini comme true
                $("#myModalDetailPageError").modal("show");
            }
        });
    </script>
</body>
</html>