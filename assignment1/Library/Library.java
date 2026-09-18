package Library;

import java.util.ArrayList;

public class Library {
    public String name;
    public ArrayList<LibraryBook> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(LibraryBook book) {
        books.add(book);
        IO.println("馆藏新增：《" + book.title + "》");
    }

    // 按编号找书，找不到返回 null
    public LibraryBook findBook(String id) {
        for (LibraryBook book : books) {
            if (book.id.equals(id)) {
                return book;
            }
        }
        return null;
    }

    // 学生借书：书存在且在馆才能借出
    public boolean lendBook(Student student, String bookId) {
        LibraryBook book = findBook(bookId);
        if (book == null) {
            IO.println("借阅失败：不存在编号为 " + bookId + " 的书");
            return false;
        }
        if (book.isBorrowed) {
            IO.println("借阅失败：《" + book.title + "》已被借出");
            return false;
        }
        book.isBorrowed = true;
        book.borrowerId = student.studentId;
        student.borrowedBooks.add(book);
        IO.println(student.studentName + " 借到了《" + book.title + "》");
        return true;
    }

    // 学生还书
    public boolean receiveBook(Student student, LibraryBook book) {
        if (!student.borrowedBooks.contains(book)) {
            IO.println("归还失败：" + student.studentName + " 没有借过《" + book.title + "》");
            return false;
        }
        student.borrowedBooks.remove(book);
        book.isBorrowed = false;
        book.borrowerId = null;
        IO.println(student.studentName + " 归还了《" + book.title + "》");
        return true;
    }
}
