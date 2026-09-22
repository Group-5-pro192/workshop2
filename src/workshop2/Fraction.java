package workshop2;

public class Fraction {

    // ==========================================
    // THÀNH VIÊN 1: Cấu trúc, Khởi tạo & Getter/Setter
    // Nhiệm vụ:
    // - Khai báo 2 thuộc tính: numerator, denominator (private int).
    // - Viết 3 Constructor:
    //     + Fraction(): mặc định tử = 0, mẫu = 1.
    //     + Fraction(int numerator): tử = numerator, mẫu = 1.
    //     + Fraction(int numerator, int denominator): kiểm tra mẫu != 0, 
    //       gán giá trị và gọi simplify() để tối giản.
    // - Viết Getter/Setter:
    //     + getNumerator(), setNumerator(int numerator)
    //     + getDenominator(), setDenominator(int denominator): kiểm tra mẫu != 0.
    // ==========================================
    // TODO Member 1: Khai báo thuộc tính ở đây
    private int numerator;
    private int denominator;

    // TODO Member 1: Viết 3 Constructor ở đây
    public Fraction() {
        // Viết mã khởi tạo mặc định...
    }

    public Fraction(int numerator) {
        // Viết mã khởi tạo với 1 tham số...
    }

    public Fraction(int numerator, int denominator) {
        // Viết mã khởi tạo với 2 tham số (nhớ validate mẫu khác 0 và gọi simplify)...
    }

    // TODO Member 1: Viết Getter và Setter ở đây
    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        // Viết mã gán tử số...
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        // Viết mã gán mẫu số (nhớ kiểm tra mẫu khác 0)...
    }

    // ==========================================
    // THÀNH VIÊN 2: Tối giản Phân số & Hiển thị
    // Nhiệm vụ:
    // - private int gcd(int a, int b): Tìm ước chung lớn nhất (dùng thuật toán Euclid).
    // - private void simplify(): Tối giản tử/mẫu bằng gcd và đẩy dấu trừ về tử nếu mẫu âm.
    // - @Override public String toString(): Trả về chuỗi dạng "a/b", "a" (nếu mẫu = 1) hoặc "0".
    // ==========================================
    // TODO Member 2: Viết hàm gcd
    private int gcd(int a, int b) {
        // Viết thuật toán tìm ƯCLN tại đây...
        return 1;
    }

    // TODO Member 2: Viết hàm simplify
    private void simplify() {
        // Viết mã rút gọn và xử lý dấu âm tại đây...
    }

    // TODO Member 2: Override toString
    @Override
    public String toString() {
        // Trả về chuỗi hiển thị đúng định dạng...
        return "";
    }

    // ==========================================
    // THÀNH VIÊN 3: Phép Cộng & Phép Trừ
    // Nhiệm vụ:
    // - Cài đặt phép cộng:
    //     + Fraction add(Fraction other)
    //     + Fraction add(int other)
    // - Cài đặt phép trừ:
    //     + Fraction subtract(Fraction other)
    //     + Fraction subtract(int other)
    // ==========================================
    // TODO Member 3: Phép Cộng
// Viết mã cộng 2 phân số...

    public Fraction add(Fraction other) {
        if (other == null) {
            throw new IllegalArgumentException("Fraction cannot be null.");
        }
        int newNumerator = this.numerator * other.denominator
                + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;

        return new Fraction(newNumerator, newDenominator);
    }
// Viết mã cộng phân số với số nguyên...
    public Fraction add(int other) {
        int newNumerator = this.numerator + other * this.denominator;

        return new Fraction(newNumerator, this.denominator);
    }
    // TODO Member 3: Phép Trừ
// Viết mã trừ 2 phân số...
    public Fraction subtract(Fraction other) {
        if (other == null) {
            throw new IllegalArgumentException("Fraction cannot be null.");
        }
        int newNumerator = this.numerator * other.denominator
                - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;

        return new Fraction(newNumerator, newDenominator);
    }
// Viết mã trừ phân số với số nguyên...
    public Fraction subtract(int other) {
        int newNumerator = this.numerator - other * this.denominator;

        return new Fraction(newNumerator, this.denominator);
    }

    // ==========================================
    // THÀNH VIÊN 4: Phép Nhân & Phép Chia
    // Nhiệm vụ:
    // - Cài đặt phép nhân:
    //     + Fraction multiply(Fraction other)
    //     + Fraction multiply(int other)
    // - Cài đặt phép chia (Nhớ ném ArithmeticException nếu chia cho 0 hoặc chia phân số có tử = 0):
    //     + Fraction divide(Fraction other)
    //     + Fraction divide(int other)
    // ==========================================
    // TODO Member 4: Phép Nhân
    public Fraction multiply(Fraction other) {
        // Viết mã nhân 2 phân số...
        return null;
    }

    public Fraction multiply(int other) {
        // Viết mã nhân phân số với số nguyên...
        return null;
    }

    // TODO Member 4: Phép Chia
    public Fraction divide(Fraction other) {
        // Viết mã chia 2 phân số...
        return null;
    }

    public Fraction divide(int other) {
        // Viết mã chia phân số cho số nguyên...
        return null;
    }
}
