import java.awt.*;

public class refrenceTypes {
    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = p1;
        p1.x = 3;
        System.out.println(p2);
        System.out.println();
        p2.y = 5;
        System.out.println(p1);
    }
}
