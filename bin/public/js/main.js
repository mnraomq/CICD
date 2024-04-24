// The root URL for the RESTful services
//mg
var rootURL = "http://localhost:8081/books";


var findAll = function () {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json",
		success: renderList
	});
};



var renderList = function (data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	list = data == null ? [] : (data instanceof Array ? data : [data]);
	$(".details").remove();
	$.each(list, function (index, book) {
		var img = "images/" + book.image;
		var htmlStr = '<div class="details" id="' + book.id + '"><img src=' + '"' + img + '"' + 'height="150">';
		htmlStr += '<h1>' + book.title + '</h1>';
		htmlStr += '<h2>By ' + book.author + '</h2>';
		htmlStr += '<h2>Illustrated by ' + book.illustrated + '</h2>';
		htmlStr += '<input class="infoButton" id="' + book.id + '" type="button" value="More Info" id="' + book.id + '"></div>';
		$('#bookList').append(htmlStr);
	});
};



var findById = function (id) {
	$.ajax({
		type: 'GET',
		url: rootURL + '/' + id,
		dataType: "json",
		success: function (book) {
			showDetails(book);
		}
	});
}

var showDetails = function (book) {
	$('#detailsModal').find('.modal-title').text(book.title);
	$('#pic').attr('src', 'images/' + book.imageModal);
	$('#rrp').val("\u20AC" + book.rrp);
	$('#online_price').val("\u20AC" + book.online);
	var savings = book.rrp - book.online;
	var percent = (savings / book.rrp) * 100;
	var saving = (savings).toFixed(2) + " (" + (percent).toFixed(0) + "%)";
	$('#saving').val("\u20AC" + saving);
	$('#detailsModal').modal('show');
}

var searchPriceLessThan = function () {
	$.ajax({
		type: 'GET',
		url: rootURL + '/pricelessthan/10',
		dataType: "json",
		success: function (data) {
			renderList(data);
		}
	});
}
var searchPriceMoreThan = function () {
	$.ajax({
		type: 'GET',
		url: rootURL + '/pricemorethan/10',
		dataType: "json",
		success: function (data) {
			renderList(data);
		}
	});
}

var findBySeries = function (series) {
	$.ajax({
		type: 'GET',
		url: rootURL + '/search/series/' + series,
		dataType: "json",
		success: function (data) {
			renderList(data);
		}
	});
}

var findByTitle = function (title) {
	$.ajax({
		type: 'GET',
		url: rootURL + '/search/title/' + title,
		dataType: "json",
		success: function (data) {
			renderList(data);
		}
	});
}


//When the DOM is ready.
$(document).ready(function () {
	$(document).on("click", ".infoButton", function () { findById(this.id); });
	
	$(document).on("click", "#showAllBooks", function () {
		findAll();
	});

	$(document).on("click", "#searchPriceMoreButton", function () {
		searchPriceMoreThan();
	});

	$(document).on("click", "#searchPriceLessButton", function () {
		searchPriceLessThan();
	});
	
	// Event handler for the modal filter

	$(document).on("click", "#searchSeriesButton", function () {
		$('#filterModalSeries').modal('show');
	});

	$(document).on("click", "#searchTitleButton", function () {
		$('#filterModalTitle').modal('show');
	});

	$(document).on("click", "#submitSeriesButton", function () {
		$('#filterModalSeries').modal('hide');
		if (($('#series').val()) == "") {
			findAll();
		}
		else {
			findBySeries($('#series').val());
		}
	});
	$(document).on("click", "#submitTitleButton", function () {
		$('#filterModalTitle').modal('hide');
		if (($('#title').val()) == "") {
			findAll();
		}
		else {
			console.log("Title search parameter: "+$('#title').val());
			findByTitle($('#title').val());
		}
	});
	findAll();
});

