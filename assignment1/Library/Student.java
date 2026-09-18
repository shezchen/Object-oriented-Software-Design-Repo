package Library;

import java.util.ArrayList;

public class Student {
    public String studentId;
    public String studentName;
    public ArrayList<LibraryBook> borrowedBooks;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.borrowedBooks = new ArrayList<>();
    }

    public void showInfo() {
        IO.println("学生 " + studentName + "（" + studentId + "）已借 " + borrowedBooks.size() + " 本书：");
        for (LibraryBook book : borrowedBooks) {
            IO.println("  - 《" + book.title + "》");
        }
    }
}
