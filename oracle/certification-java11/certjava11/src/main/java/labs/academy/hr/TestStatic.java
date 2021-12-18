package labs.academy.hr;

import java.util.Scanner;

public class TestStatic {

    static int B;
    static int H;
    static boolean flag = false;

    static {
//        Scanner scan = new Scanner(System.in);
        B = 1;
        H = 3;
        flag = !(B <= 0 || H <= 0);
        if(!flag){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args){
            if(flag){
                int area=B*H;
                System.out.print(area);
            }
            
        }//

}
