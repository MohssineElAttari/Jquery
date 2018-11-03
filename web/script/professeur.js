$(document).ready(function () {



    $('#container').on('click', '.delete', function () {
        var id = $(this).attr("v");
        if (confirm("Voulez-vous Vraiement supprimer ce Professeur ?")) {
            $.ajax({
                url: "DeleteProfesseur",
                type: 'GET',
                cache: false,
                data: {id: id},
                success: function (data) {
                    $("#container").empty();
                    $("#container").html(remplir(data));
                },
                error: function (errorThrown) {
                    console.log("Erreur !");
                }
            });
            return true;
        } else {
            return false;
        }
    });

    $("#container").on('click', '.update', function () {
        var id = $(this).attr("v");
        $.ajax({
            url: "LoadProfesseur",
            type: 'GET',
            data: {id:id},
            success: function (data) {
                $("#nom").val(data.nom);
                $("#prenom").val(data.prenom);
                $("#adresse").val(data.adresse);
                $("#save").html("modifier");
                $("#operation").val("update");
                $("#operation").attr("v", id);
            },
            error: function (errorThrown) {
                console.log("Erreur");
            }
        });
    });
    $("#save").click(function () {
        var nom = $("#nom").val();
        var prenom = $("#prenom").val();
        var adresse = $("#adresse").val();
        var operation = $("#operation").val();
        var id = $("#operation").attr("v");
        $.ajax({
            url: 'AddProfesseur',
            type: 'GET',
            data: {nom: nom, prenom: prenom, adresse: adresse, operation: operation, id: id},
            success: function (data) {
                init(); //vider les champs 
                $("#container").empty(); //vider le tableau
                $("#container").html(remplir(data)); // remplir le tableau
                $("#save").html("Ajouter");
            },
            error: function (errorThrown) {
                console.log("Erreur !");
            }
        });
    });

    function init() {
        $("#nom").val("");
        $("#prenom").val("");
        $("#adresse").val("");
    }

    function remplir(data) {
        var ligne = "";
        for (i = 0; i < data.length; i++) {
            ligne += '<tr><td>' + data[i].id + '</td><td>' + data[i].nom + '</td><td>' + data[i].prenom + '</td><td>' + data[i].adresse + '</td><td><button class="delete" v="' + data[i].id + '">Supprimer</button></td><td><button class="update" v="' + data[i].id + '">Modifier</button></td></tr>';
        }
        return ligne;
    }
});