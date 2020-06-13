const body = document.querySelector("body");

const IMG_NUMBER = 3;

function paintImg(imgNumber){
    const img = new Image();
    img.src = `img/${imgNumber}.jpg`;
    img.classList.add("bgImg");
    body.prepend(img);
}

function genRandom() {
    const number = Math.floor(Math.random()*IMG_NUMBER) + 1;
    return number;
}

function init() {
    const randomNumber = genRandom();
    paintImg(randomNumber);
}

init();