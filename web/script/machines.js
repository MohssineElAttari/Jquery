$(document).ready(function () {

    $('#container').on('click', '.update', function () {
        var id = $(this).attr("v");
        $.ajax({
            url: "LoadMachine",
            type: 'GET',
            data: {id: id},
            success: function (data) {
                $("#marque").val(data.marque);
                $("#reference").val(data.reference);
                var s = (moment(new Date(data.dateAchat)).format('L')).split("/");
                var d = s[2] + "-" + s[0] + "-" + s[1];
                $("#date").val(d);
                $("#prix").val(data.prix);
                $("#save").html("Modifier");
                $("#operation").val("update");
                $("#operation").attr("v", id);
            },
            error: function (errorThrown) {
                console.log("erreur");
            }
        });
    });

    $('#container').on('click', '.delete', function () {
        var id = $(this).attr("v");
        if (confirm("Voulez-vous Vraiement supprimer cette machine ?")) {
            $.ajax({
                url: "DeleteMachine",
                type: 'GET',
                cache: false,
                data: {id: id},
                success: function (data) {
                    $("#container").empty();
                    $("#container").html(remplir(data));
                },
                error: function (errorThrown) {
                    console.log("erreur");
                }
            });
            return true;
        } else {
            return false;
        }
    });


    $("#save").click(function () {
        var marque = $("#marque").val();
        var reference = $("#reference").val();
        var date = $("#date").val();
        var prix = $("#prix").val();
        var operation = $("#operation").val();
        var id = $("#operation").attr("v");
        $.ajax({
            url: "AddMachine",
            type: 'GET',
            data: {marque: marque, reference: reference, date: date, prix: prix, operation: operation, id: id},
            success: function (data) {
                init(); //vider les champs 
                $("#container").empty(); //vider le tableau
                $("#container").html(remplir(data)); // remplir le tableau
                $("#save").html("Ajouter");
            },
            error: function (errorThrown) {
                console.log("erreur");
            }
        });
    });

    function init() {
        $("#marque").val("");
        $("#reference").val("");
        $("#date").val("");
        $("#prix").val("");
    }

    function remplir(data) {
        var ligne = "";
        for (i = 0; i < data.length; i++) {
            var s = (moment(new Date(data[i].dateAchat)).format('L')).split("/");
            var d = s[1] + "/" + s[0] + "/" + s[2];
            ligne += '<tr><td>' + data[i].id + '</td><td>' + data[i].marque + '</td><td>' + data[i].reference + '</td><td>' + d + '</td><td>' + data[i].prix + '</td><td><button class="delete" v="' + data[i].id + '">Supprimer</button></td><td><button class="update" v="' + data[i].id + '">Modifier</button></td></tr>';
        }
        return ligne;
    }
});