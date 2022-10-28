const imgs = [
  "./img/banerMulti2.png",
  "./img/banerMulti1.png",
  "./img/banerMulti3.png",
];
const imgSlide = document.querySelector(".slide .slideImg");
const textSlide = document.querySelector(".sldie .slideText");
console.log(textSlide);

const contentChoice = document.querySelector(".contentChoice");
const imgChoice = document.querySelector("#imgChoice");
imgChoice.addEventListener("click", () => {
  contentChoice.classList.contains("show")
    ? contentChoice.classList.remove("show")
    : contentChoice.classList.add("show");
});
// contentChoice.addEventListener("click", () => {});
// contentChoice.classList.add(show);
