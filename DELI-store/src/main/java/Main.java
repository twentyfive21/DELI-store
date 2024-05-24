



import static com.pluralsight.showMenu.DisplayMenu.display;
import static com.pluralsight.showMenu.DisplayMenu.loadSignatureSandwiches;

public class Main {
    // ************ start of the program ***************
    public static void main(String[] args) {
        // method calling from DisplayMenu class
        loadSignatureSandwiches();
        display();
    }

}
