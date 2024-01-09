package demo_singleton;

public class SingleObject {
    private static final SingleObject instance = new SingleObject();
    // Constructor không tham số để ở private.
    private SingleObject(){

    }
    // Phương thức giúp lấy ra Instance của Class.
    public static SingleObject getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello, World!");
    }
}
