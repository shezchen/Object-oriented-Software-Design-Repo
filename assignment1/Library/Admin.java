package Library;

import java.util.ArrayList;

public class Admin {
    public String adminId;
    public String adminName;
    public ArrayList<Library> managedLibraries;

    public Admin(String adminId, String adminName) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.managedLibraries = new ArrayList<>();
    }

    public void manageLibrary(Library library) {
        managedLibraries.add(library);
        IO.println("管理员 " + adminName + " 开始管理 " + library.name);
    }

    // 巡查：打印所辖每个馆的馆藏情况
    public void inspect() {
        for (Library library : managedLibraries) {
            IO.println("=== " + library.name + " 共有 " + library.books.size() + " 本书 ===");
            for (LibraryBook book : library.books) {
                book.showInfo();
            }
        }
    }
}
