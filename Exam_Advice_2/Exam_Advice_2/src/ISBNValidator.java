import java.util.Scanner;
import java.util.Stack;

public class ISBNValidator {

    public static void main(String[] args) {
        // Bước 1: Lấy số ISBN từ người dùng
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số ISBN (10 chữ số): ");
        String userInput = scanner.nextLine();

        // Bước 2: Kiểm tra độ dài của chuỗi
        if (userInput.length() != 10) {
            System.out.println("Số ISBN phải có 10 chữ số. Vui lòng thử lại.");
            return;
        }

        // Bước 3: Sử dụng Stack để lưu trữ chữ số và tính tổng
        Stack<Integer> digitStack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < userInput.length(); i++) {
            char digitChar = userInput.charAt(i);

            // Kiểm tra xem ký tự có phải là số không
            if (!Character.isDigit(digitChar)) {
                System.out.println("Số ISBN chỉ được chứa các chữ số. Vui lòng thử lại.");
                return;
            }

            int digit = Character.getNumericValue(digitChar);
            digitStack.push(digit);

            // Tính tổng theo công thức
            sum += (i + 1) * digit;
        }

        // Bước 4: Kiểm tra điều kiện và đưa ra kết luận
        if (sum % 11 == 0) {
            System.out.println("Số ISBN hợp lệ.");
        } else {
            System.out.println("Số ISBN không hợp lệ.");
        }
    }
}
