function search() {
    var book = $("#inputBook").val();
    var word = $("#inputWord").val();
    $.ajax(
        {
            url: "frequency",
            method: "POST",
            data: {
                book: book,
                word: word
            },
            success: function (data) {
                $("#frequency").text("Частота слова: " + data);
            }
        }
    );
}

function init () {
    //$("#btnSearch").bind("click", search());
}