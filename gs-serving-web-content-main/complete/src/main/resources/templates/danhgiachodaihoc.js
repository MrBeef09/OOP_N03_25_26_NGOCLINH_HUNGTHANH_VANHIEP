let selectedRating = 0;
let currentSchool = "";
const reviewData = {}; // Lưu bình luận cho từng trường

// Khi click vào tên trường
function openReviewForm(schoolName) {
  currentSchool = schoolName;
  selectedRating = 0;

  // Ẩn danh sách, hiện chi tiết
  document.getElementById("university-list").style.display = "none";
  document.getElementById("page-title").textContent = "Đánh giá cho " + schoolName;
  document.getElementById("school-detail").style.display = "block";

  // Đặt tên trường
  document.getElementById("school-detail-name").textContent = schoolName;

  // Reset sao & nội dung
  document.querySelectorAll("#stars span").forEach(s => s.style.color = "#ccc");
  document.getElementById("comment").value = "";

  // Hiển thị các bình luận cũ (nếu có)
  showReviews(schoolName);
}

// Quay lại danh sách
function backToList() {
  document.getElementById("university-list").style.display = "block";
  document.getElementById("school-detail").style.display = "none";
  document.getElementById("page-title").textContent = "Danh sách các trường đại học";
}

// Chọn số sao
document.querySelectorAll("#stars span").forEach(star => {
  star.addEventListener("click", function() {
    selectedRating = this.getAttribute("data-value");
    document.querySelectorAll("#stars span").forEach(s => s.style.color = "#ccc");
    for (let i = 0; i < selectedRating; i++) {
      document.querySelectorAll("#stars span")[i].style.color = "gold";
    }
  });
});

// Gửi đánh giá
function submitReview() {
  const comment = document.getElementById("comment").value.trim();
  if (selectedRating === 0 || comment === "") {
    alert("Vui lòng chọn số sao và nhập bình luận!");
    return;
  }

  if (!reviewData[currentSchool]) reviewData[currentSchool] = [];

  reviewData[currentSchool].push({
    rating: Number(selectedRating),
    comment: comment
  });

  // Cập nhật hiển thị
  showReviews(currentSchool);
  updateUniversityStats(currentSchool);

  // Reset form
  document.getElementById("comment").value = "";
  document.querySelectorAll("#stars span").forEach(s => s.style.color = "#ccc");
  selectedRating = 0;
}

// Hiển thị danh sách bình luận của 1 trường
function showReviews(schoolName) {
  const container = document.getElementById("school-reviews");
  container.innerHTML = ""; // Xóa cũ

  const reviews = reviewData[schoolName] || [];
  if (reviews.length === 0) {
    container.innerHTML = "<p>Chưa có bình luận nào cho trường này.</p>";
    return;
  }

  reviews.forEach(r => {
    const item = document.createElement("div");
    item.classList.add("review-item");
    item.innerHTML = `
      <div class="stars-display">${"★".repeat(r.rating)}${"☆".repeat(5 - r.rating)}</div>
      <p>${r.comment}</p>
    `;
    container.appendChild(item);
  });
}

// Cập nhật sao trung bình & số bình luận trong danh sách
function updateUniversityStats(schoolName) {
  const data = reviewData[schoolName];
  const totalReviews = data.length;
  const avgRating = (data.reduce((sum, r) => sum + r.rating, 0) / totalReviews).toFixed(1);

  const li = document.querySelector(`.university-list li[data-school="${schoolName}"]`);
  if (li) {
    const info = li.querySelector(".university-info");
    const stars = Math.round(avgRating);
    info.querySelector(".stars").innerHTML = "★".repeat(stars) + "☆".repeat(5 - stars);
    info.querySelector(".review-count").textContent = `${totalReviews} bình luận (${avgRating}★)`;
  }
}
