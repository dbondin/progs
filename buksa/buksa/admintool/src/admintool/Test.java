package admintool;

public class Test {
    public static void main(String [] args) {
        admintool.entity.Book b = new admintool.entity.Book();
        b.setTitle("newbook");
        b.setFilename("newbook.txt");
        b.setBinData(DataBase.getInstance().createBlob(new java.io.ByteArrayInputStream("hello".getBytes())));
        DataBase.getInstance().addBook(b);
        return;
    }
}
