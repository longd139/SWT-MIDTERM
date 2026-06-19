# PHẦN 1: TẠO CHECKLIST CHUẨN CHO TESTING BÀI 1 (CALCULATOR)

## 1.1. Phương Pháp Luận Nghiên Cứu (Methodology)

The test checklist and test design matrix were created before any unit test implementation. They serve as the baseline evaluation model for measuring the coverage and quality of manually written tests and AI-generated tests. By defining testing scenarios independently from the source code implementation, the study minimizes bias and ensures a fair comparison between human-generated and AI-generated testing artifacts.

## 1.2. Giả Định Kiểm Thử (Assumptions)

- **Phạm vi xử lý:** Máy tính giả định chỉ xử lý tối đa hai toán hạng tại một thời điểm.
- **Kiểu dữ liệu:** Kiểu dữ liệu thực tế (số nguyên `int` hay số thực `double`) sẽ được xác nhận chính xác ngay khi nhận mã nguồn từ thành viên phụ trách (Linh).
- **Quản lý trạng thái:** Trường hợp chuỗi tính liên tiếp (C25) chỉ áp dụng nếu cấu trúc mã nguồn gốc có cơ chế lưu trữ trạng thái.
- **Xử lý biên nâng cao:** Trường hợp tràn số (C26) được phân loại là ca kiểm thử nâng cao, tùy thuộc vào kiểu dữ liệu thực tế được áp dụng trong mã nguồn.

## 1.3. Ma Trận Truy Vết Yêu Cầu (Requirements Traceability Matrix - RTM)

_Bảng này đóng vai trò truy vết để đảm bảo toàn bộ các yêu cầu chức năng từ đề bài đều được bao phủ bởi các kịch bản kiểm thử tương ứng._

| Yêu cầu kiểm thử từ đề bài         | Mã ca kiểm thử tương ứng (Checklist ID) |
| :--------------------------------- | :-------------------------------------- |
| **Phép cộng (`+`)**                | C01, C05, C09, C13                      |
| **Phép trừ (`-`)**                 | C02, C06, C10, C14                      |
| **Phép nhân (`*` hoặc `x`)**       | C03, C07, C11, C15, C23, C24            |
| **Phép chia (`/`)**                | C04, C08, C12, C16, C21, C22            |
| **Toán tử không hợp lệ / Lỗi**     | C17, C18, C19, C20                      |
| **Trường hợp đặc biệt / Nâng cao** | C25, C26                                |

---

## 1.4. Bảng Checklist Kiểm Thử Chi Tiết (Test Checklist Table)

| Nhóm Trường Hợp                                  | ID      | Kịch Bản Kiểm Thử Chi Tiết                             | Expected Output / Hành Vi Kỳ Vọng           |
| :----------------------------------------------- | :------ | :----------------------------------------------------- | :------------------------------------------ |
| **Normal Cases**<br>_(Bình thường)_              | **C01** | Phép cộng hai số nguyên dương ($2 + 3$)                | $5$                                         |
|                                                  | **C02** | Phép trừ hai số nguyên dương ($10 - 4$)                | $6$                                         |
|                                                  | **C03** | Phép nhân hai số nguyên dương ($5 \times 6$)           | $30$                                        |
|                                                  | **C04** | Phép chia hết hai số nguyên dương ($20 / 5$)           | $4$                                         |
| **Negative Numbers**<br>_(Số âm)_                | **C05** | Phép cộng có chứa số âm ($-2 + 3$)                     | $1$                                         |
|                                                  | **C06** | Phép trừ có chứa số âm ($-5 - (-3)$)                   | $-2$                                        |
|                                                  | **C07** | Phép nhân có chứa số âm ($-4 \times 2$)                | $-8$                                        |
|                                                  | **C08** | Phép chia có chứa số âm ($-10 / 2$)                    | $-5$                                        |
| **Zero Values**<br>_(Số 0)_                      | **C09** | Phép toán cộng hai số không ($0 + 0$)                  | $0$                                         |
|                                                  | **C10** | Phép toán cộng một số với không ($5 + 0$)              | $5$                                         |
|                                                  | **C11** | Phép toán nhân một số với không ($0 \times 10$)        | $0$                                         |
|                                                  | **C12** | Phép toán chia có số bị chia là không ($0 / 5$)        | $0$                                         |
| **Decimal Numbers**<br>_(Số thập phân)_          | **C13** | Phép cộng hai số thập phân ($1.5 + 2.5$)               | $4.0$                                       |
|                                                  | **C14** | Phép trừ hai số thập phân ($5.5 - 2.2$)                | $3.3$                                       |
|                                                  | **C15** | Phép nhân hai số thập phân ($2.5 \times 2$)            | $5.0$                                       |
|                                                  | **C16** | Phép chia ra kết quả số thập phân ($5 / 2$)            | $2.5$                                       |
| **Invalid Operator**<br>_(Toán tử lỗi)_          | **C17** | Sử dụng toán tử không hợp lệ: Phần trăm (`%`)          | Ném ngoại lệ / Báo lỗi hệ thống             |
|                                                  | **C18** | Sử dụng toán tử không hợp lệ: Mũ (`^`)                 | Ném ngoại lệ / Báo lỗi hệ thống             |
|                                                  | **C19** | Sử dụng toán tử dạng chuỗi chữ không hợp lệ (`abc`)    | Ném ngoại lệ / Báo lỗi hệ thống             |
|                                                  | **C20** | Để trống ký tự phép toán (Empty/Null operator)         | Ném ngoại lệ / Báo lỗi hệ thống             |
| **Exception Cases**<br>_(Chia cho 0)_            | **C21** | Chia cho số không (`/ 0`) với kiểu dữ liệu `int`       | Ném `ArithmeticException`                   |
|                                                  | **C22** | Chia cho số không (`/ 0`) với kiểu dữ liệu `double`    | Trả về `Infinity` hoặc `-Infinity`          |
| **Operator Variants**<br>_(Biến thể ký tự)_      | **C23** | Kiểm tra phép nhân bằng ký tự ngôi sao (`*`)           | Kết quả phép nhân chính xác                 |
|                                                  | **C24** | Kiểm tra phép nhân bằng ký tự chữ (`x` hoặc `X`)       | Kết quả phép nhân chính xác                 |
| **Optional Advanced**<br>_(Nâng cao - Tùy chọn)_ | **C25** | **Chaining Operations:** Chuỗi tính liên tiếp          | Kết quả tích lũy đúng _(Nếu code có state)_ |
|                                                  | **C26** | **Data Overflow:** Biên dữ liệu lớn ($MAX\_VALUE + 1$) | Kiểm tra tràn số hoặc cơ chế bảo vệ bộ nhớ  |
