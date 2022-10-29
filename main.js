const imgs = [
  "./img/banerMulti2.png",
  "./img/banerMulti1.png",
  "./img/banerMulti3.png",
];
const imgSlide = document.querySelector(".slide .slideImg");
const textSlide = document.querySelector(".sldie .slideText");

const contentChoice = document.querySelector(".contentChoice");
const imgChoice = document.querySelector("#imgChoice");
imgChoice.addEventListener("click", () => {
  contentChoice.classList.contains("show")
    ? contentChoice.classList.remove("show")
    : contentChoice.classList.add("show");
});
// contentChoice.addEventListener("click", () => {});
// contentChoice.classList.add(show);

////////////////////////// show ÌnorTeacher
const infor_teacher_item = document.querySelectorAll(".infor_teacher_item");
// const inforDetail = document.querySelectorAll(".inforDetail");
const inforDetail = document.querySelectorAll(".inforDetail");
infor_teacher_item.forEach((item, index) => {
  item.addEventListener("click", () => {
    inforDetail[index].style.display = "flex";
  });
});
// inforDetail.forEach((item) => {});
inforDetail.forEach((item) => {
  item.addEventListener("click", () => {
    item.style.display = "none";
  });
});
