package com.example.btth.repository;

import org.springframework.stereotype.Repository;
import com.example.btth.entity.Student;
import java.util.ArrayList;
import java.util.List;

@Repository // Đánh dấu lớp này thuộc tầng dữ liệu, Spring sẽ tự động tạo và quản lý đối tượng này
public class StudentRepository {
    // Khai báo một danh sách để lưu trữ dữ liệu sinh viên trong bộ nhớ (RAM)
    private List<Student> students;

    /**
     * Hàm khởi tạo (Constructor).
     * Dùng để khởi tạo "dữ liệu cứng" (Mock Data) ngay khi ứng dụng chạy,
     * thay thế cho việc truy vấn từ cơ sở dữ liệu thật.
     */
    public StudentRepository() {
        students = new ArrayList<>();
        // Khởi tạo danh sách 15 sinh viên với đầy đủ các thuộc tính để kiểm thử các chức năng
       students.add(new Student(1, "Hoang Thien Son", "B21DCCN001", "CNTT", 2021, 3.8, "Đang học"));
        students.add(new Student(2, "Ha Quang Huy", "B20DCCN002", "CNTT", 2020, 3.2, "Đang học"));
        students.add(new Student(3, "Hoang Nguyen Duc", "B19ATKM003", "ATTT", 2019, 2.5, "Bảo lưu"));
        students.add(new Student(4, "Trinh Khac Hung", "B18DCCN004", "CNTT", 2018, 3.9, "Tốt nghiệp"));
        students.add(new Student(5, "Nguyen Hoang Nhat", "B21PTIT005", "PTIT", 2021, 3.5, "Đang học"));
        students.add(new Student(6, "Doan Viet Anh", "B21DCCN006", "CNTT", 2021, 3.1, "Đang học"));

    }

    /**
     * Trình xuất toàn bộ danh sách sinh viên hiện có.
     * Tầng Service sẽ gọi hàm này để lấy dữ liệu thô trước khi lọc hoặc sắp xếp.
     */
    public List<Student> getAll() {
        return students;
    }

    /**
     * Tìm kiếm một sinh viên cụ thể dựa trên ID.
     * Sử dụng Stream API để duyệt danh sách và tìm phần tử khớp với ID truyền vào.
     */
    public Student getById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id) // Lọc sinh viên có ID trùng khớp
                .findFirst()                  // Lấy kết quả đầu tiên tìm thấy
                .orElse(null);                // Nếu không thấy thì trả về null
    }
}
