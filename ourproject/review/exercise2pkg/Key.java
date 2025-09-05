package review.exercise2pkg;

public class Key {
    private String value;

    public Key(String value) {
        this.value = value;
    }

    //  Cố tình làm cho tất cả key có cùng hashCode
    // => sẽ tạo ra "collision" khi đưa vào HashMap
    @Override
    public int hashCode() {
        return 1;
    }

    // So sánh theo giá trị bên trong
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // cùng object
        if (obj == null || getClass() != obj.getClass()) return false; 
        Key key = (Key) obj;
        return value.equals(key.value); // so sánh nội dung
    }

    @Override
    public String toString() {
        return value;
    }
}
