// Lớp đơn giản Soap, dùng để composition trong Bath
class Soap {
  private String s;

  Soap() {
    System.out.println("Soap()");
    s = "Constructed";
  }

  // Phương thức toString() trả về chuỗi mô tả đối tượng
  public String toString() {
    return s;
  }
}

// Lớp Bath minh họa tái sử dụng lớp bằng composition và nhiều cách khởi tạo biến
public class Bath {
  // 1. Khởi tạo ngay khi khai báo (field initialization)
  private String s1 = "Happy";
  private String s2 = "Happy";

  // chưa khởi tạo tại điểm khai báo
  private String s3;
  private String s4;

  // 4. Khối instance initializer: chạy trước constructor
  private int i;
  {
    i = 47;
  }

  private float toy;        // chưa khởi tạo

  // 2. Khai báo biến tham chiếu chưa khởi tạo tại điểm khai báo
  private Soap castille;

  public Bath() {
    System.out.println("Inside Bath()");
    // 2. Khởi tạo trong constructor
    s3 = "Joy";
    toy = 3.14f;

    castille = new Soap();
  }

  // 3. Lazy initialization: khởi tạo khi thực sự cần (trong toString)
  public String toString() {
    if (s4 == null) {
      s4 = "Joy";  // khởi tạo trì hoãn
    }

    return
      "s1 = " + s1 + "\n" +
      "s2 = " + s2 + "\n" +
      "s3 = " + s3 + "\n" +
      "s4 = " + s4 + "\n" +
      "i = " + i + "\n" +
      "toy = " + toy + "\n" +
      "castille = " + castille;  // tự gọi castille.toString()
  }

  // Hàm main để chạy thử
  public static void main(String[] args) {
    Bath b = new Bath();
    System.out.println(b);
  }
}
