package Library;

public class LibraryBook {
    public String ISBN;
    public String id;
    public String title;
    public String author;
    public boolean isBorrowed;
    public String borrowerId; // 借走这本书的学生学号

    public LibraryBook(String ISBN, String id, String title, String author) {
        this.ISBN = ISBN;
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
        this.borrowerId = null;
    }

    public void showInfo() {
        String status = isBorrowed ? "已借出（借阅者：" + borrowerId + "）" : "在馆";
        IO.println("[" + id + "] 《" + title + "》 " + author + "，ISBN: " + ISBN + "，状态: " + status);
    }
}
