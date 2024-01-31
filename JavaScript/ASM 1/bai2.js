var img = [
    "img/3.jpg",
    "img/1.jpg",
    "img/3.jpg",
    "img/2.jpg",
    "img/5.jpg",
    "img/6.jpg",
    "img/7.jpg",
    "img/8.jpg",
    "img/9.jpg",
]

var index = 0;

function Next() {
    index++;
    if (index >= img.length) index = 0;
    var hinh = document.getElementById("hinh");
    hinh.src = img[index];
    document.getElementById("indexdot").innerHTML = index + 1 + "/" + img.length;
}

function Prev() {
    index--;
    if (index < 0) index = img.length - 1;
    var hinh = document.getElementById("hinh");
    hinh.src = img[index];
    document.getElementById("indexdot").innerHTML = index + 1 + "/" + img.length;
}