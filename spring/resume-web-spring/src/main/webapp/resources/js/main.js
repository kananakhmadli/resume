let btnOpen = document.querySelector("#opne-popup");
let btnClose = document.querySelector("#close-popup");
let popup = document.querySelector(".popup");

let popupContainer = document.querySelector(".popup-container");

btnOpen.addEventListener("click", function () {
    popup.style.visibility = "visible";
    popupContainer.style.transform = "scale(1)";
    popup.style.opacity = "1";
    btnOpen.style.display="none"
})

btnClose.addEventListener("click", function () {
    popup.style.visibility = "hidden";
    popup.style.opacity = "0";
    popupContainer.style.transform = "scale(0)";
    btnOpen.style.display="block"

})
