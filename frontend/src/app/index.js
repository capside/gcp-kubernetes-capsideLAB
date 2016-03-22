$(document).ready(function(){
	$("#btnApiCall1").click(function(){
	    $.get('/api')
	        .done(function(response){
	            $("#panel1 .message").append(createAlert("success","<b>The message from the server is</b>: "+response));
	        })
	        .fail(function(error){
                $("#panel1 .message").append(createAlert("danger","<b>Error:</b>: "+error));
	        });
    });
    $("#btnApiCall2").click(function(){
        var username = $("#txtNombre").val();
        $.get(`/api/user/${username}`)
            .done(function(response){
                $("#panel2 .message").append(createAlert("success","<b>The message from the server is</b>: "+response));
            })
            .fail(function(error){
                console.log(error);
                $("#panel2 .message").append(createAlert("danger",`<b>Error (${error.status}):</b> ${error.statusText}`));
            });
    });
    $("#btnApiCall3").click(function(){
            $.getJSON('/api/movies')
                .done(function(response){
                    var movieList = $("<ul></ul>");
                    response.forEach(function(movie){
                        movieList.append(createMovieDetail(movie))
                    });
                    var alert = createAlert("success","<b>Movie List</b>:");
                    alert.append(movieList);
                    $("#panel3 .message").append(alert);
                })
                .fail(function(error){
                    console.log(error);
                    $("#panel3 .message").append(createAlert("danger",`<b>Error (${error.status}):</b> ${error.responseText}`));
                });
        });
});

function createAlert(type,message){
    var alertBox = $("<p></p>");
    alertBox.addClass("alert alert-"+type);
    alertBox.html(message);

    return alertBox;
}

function createMovieDetail(movie){
    var item = $("<li></li>");
    var detailList = $("<ul></ul>");
    var nameItem = $("<li></li>");
    nameItem.html(movie.name);
    var publishedDateItem = $("<li></li>");
    publishedDateItem.html(movie.publishedDate);
    var descriptionItem = $("<li></li>");
    descriptionItem.html(movie.description);
    var separatorItem = $("<br />");

    detailList.append(nameItem);
    detailList.append(publishedDateItem);
    detailList.append(descriptionItem);
    item.append(detailList);
    item.append(separatorItem);

    return item;
}
