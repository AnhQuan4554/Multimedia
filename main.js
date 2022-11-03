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
const btnCloseInforDetail = document.querySelectorAll(".btnCloseInforDetail");
const inforDetail = document.querySelectorAll(".inforDetail");
const placeText = document.querySelector(".placeText");
const searchInforInput = document.querySelector(".searchInfor input");
const imgNewWriter_item_left = document.querySelector(
  ".newWriter_item-left img"
);
const imgNewWriter_item_right = document.querySelectorAll(
  ".newWriter_item-right img"
);
const arrangeWriters = document.querySelectorAll(".arrangeWriter");
const pageItems = document.querySelectorAll(".pageItem");
//////////////////////////////
infor_teacher_item.forEach((item, index) => {
  item.addEventListener("click", () => {
    inforDetail[index].style.display = "flex";
  });
});
btnCloseInforDetail.forEach((item, index) => {
  item.addEventListener("click", () => {
    inforDetail[index].style.display = "none";
  });
});
const iconChoice = document.querySelector(".iconChoice");

document.addEventListener("scroll", (event) => {
  // console.log(iconChoice.getBoundingClientRect().top, window.scrollY);
  if (iconChoice.getBoundingClientRect().top - window.scrollY < 350) {
    iconChoice.classList.add("active");
  } else {
    iconChoice.classList.remove("active");
  }
});
const infor_teacher_items = document.querySelectorAll(".infor_teacher_item");
document.addEventListener("scroll", (event) => {
  // console.log(infor_teacher_items[0]);
  infor_teacher_items.forEach((item) => {
    if (item.getBoundingClientRect().top - window.scrollY < 350) {
      item.classList.add("active");
    } else {
      item.classList.remove("active");
    }
  });
  if (searchInforInput.getBoundingClientRect().top - window.scrollY < 350) {
    searchInforInput.classList.add("active");
    // Xuất hiện text

    setTimeout(() => {
      placeText.style.display = "block";
    }, 2000);
  } else {
    searchInforInput.classList.remove("active");
    placeText.style.display = "none";
  }
  // img other Page
  if (
    imgNewWriter_item_right[0].getBoundingClientRect().top - window.scrollY <
    -500
  ) {
    imgNewWriter_item_right[0].classList.add("active");
    imgNewWriter_item_right[1].classList.add("active");
    imgNewWriter_item_left.classList.add("active");
  } else {
    imgNewWriter_item_right[0].classList.remove("active");
    imgNewWriter_item_right[1].classList.remove("active");
    imgNewWriter_item_left.classList.remove("active");
  }
});
document.addEventListener("scroll", (event) => {
  if (arrangeWriters[0].getBoundingClientRect().top - window.scrollY < 300) {
    arrangeWriters.forEach((item) => {
      item.classList.add("active");
    });
  } else {
    arrangeWriters.forEach((item) => {
      item.classList.remove("active");
    });
  }
});
// document.querySelector("body").style.background = "red";
