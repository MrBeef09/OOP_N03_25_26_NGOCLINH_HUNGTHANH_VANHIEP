# Project Thanh - Linh - Hiep

1. Nguyễn Hưng Thành MSSV: 2301068 
2. Mai Ngọc Linh MSSV: 23010717
3. Nguyễn Văn Hiệp MSSV: 23010859

# PROJECT:Xây dựng ứng dụng chọn trường đại học cho sinh viên cấp ba

1. Yêu cầu chính:
Chức năng chính
   Ứng dụng tư vấn chọn trường đại học cho học sinh cấp ba của chúng em được xây dưng với 3 chức năng chính.
   + Học sinh có thể xem danh sách trường đại học được sắp xếp theo thang điểm đánh giá dựa trên nhiều tiêu chí.
   + Học sinh có thể xem tư vấn để đưa ra ngành học phù hợp với bản thân
   + Học sinh có thể đánh giá trường đại học
   Admin có thể CRUD các object chính là trường đại học , cơ sở vật chất , đội ngũ giáo viên, ngành học.
2.
LINK Class UML
   <img width="700" height="600" alt="575460689_1545405759921577_6807243004918379597_n" src="https://github.com/user-attachments/assets/9c218bd8-1066-48dc-beb6-f36543b84e04" />
LINK Sequence UML
+ sơ đồ tuần tự của user học sinh của cả hệ thống cho cả 3 chức năng
<img width="929" height="1989" alt="Untitled" src="https://github.com/user-attachments/assets/9b4da8ee-58d6-439f-99d3-364eed025dfe" />
+ sơ đồ tuần tự của admin
<img width="929" height="2086" alt="admin" src="https://github.com/user-attachments/assets/20506eac-9391-4d8d-a969-e08d9638e934" />
3. Cơ sở lý thuyết

Ngôn ngữ lập trình: Java
Mô hình hướng đối tượng (OOP): sử dụng các nguyên lý đóng gói, kế thừa, đa hình.
Mô hình MVC (Model – View – Controller).
Cơ sở dữ liệu: MySQL / Aiven.

4. Thiết kế và cài đặt
4.1. Kiến trúc chương trình:
Ứng dụng được thiết kế theo mô hình MVC:
Model: quản lý dữ liệu và logic gợi ý.
View: giao diện html hiển thị.
Controller: xử lý yêu cầu từ người dùng.
4.2 Các module chính
   TruongdaihocModel, CosovatchatModel, DoingugiaovienModel, NganhhocModel.
4.3 Giao diện
   Trang chủ chính khi đã đăng nhập với học sinh
<img width="628" height="299" alt="image" src="https://github.com/user-attachments/assets/fdbfe924-11bd-4f59-bf50-b8e2fc8562d1" />
Trang chủ admin
<img width="632" height="302" alt="image" src="https://github.com/user-attachments/assets/3d810a0f-33bc-4375-a268-87217da4c923" />
Với chức năng xem trường đại học sắp xếp của học sinh
<img width="613" height="293" alt="image" src="https://github.com/user-attachments/assets/8b0c8fd2-448d-4b06-9150-cbac9156cb33" />
Trang tư vấn ngành học
<img width="616" height="586" alt="image" src="https://github.com/user-attachments/assets/5b069095-4680-4141-b1c1-cea3b5df0fe0" />
<img width="616" height="586" alt="image" src="https://github.com/user-attachments/assets/4ed7f7fa-c1f4-4c16-a719-fd76f14646e5" />





