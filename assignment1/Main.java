import Library.Admin;
import Library.Library;
import Library.LibraryBook;
import Library.Student;

public class Main {
    public static void main(String[] args) {
        // 建馆、建管理员
        Library library = new Library("图书馆");
        Admin admin = new Admin("A001", "王老师");
        admin.manageLibrary(library);

        // 馆藏入库
        library.addBook(new LibraryBook("978-7-111-11111-1", "B001", "Java 核心技术", "Horstmann"));
        library.addBook(new LibraryBook("978-7-111-22222-2", "B002", "算法导论", "Cormen"));
        library.addBook(new LibraryBook("978-7-115-33333-3", "B003", "深入理解计算机系统", "Bryant"));

        // 学生借书
        Student alice = new Student("S2025001", "小明");
        Student bob = new Student("S2025002", "小红");

        library.lendBook(alice, "B001");
        library.lendBook(bob, "B001");   // 已被借出，失败
        library.lendBook(bob, "B999");   // 不存在，失败
        library.lendBook(bob, "B003");

        // 查看各自借阅情况
        alice.showInfo();
        bob.showInfo();

        // 还书
        library.receiveBook(alice, library.findBook("B001"));
        library.receiveBook(bob, library.findBook("B001")); // 没借过，失败

        // 管理员巡查馆藏
        admin.inspect();
    }
}
