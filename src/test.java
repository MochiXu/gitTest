import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class test {
    public static void main(String args[]){
        //This is master
        System.out.println("dev02 upper");
        //dev01Change
        int a = 3;
        int b = 4;
        System.out.println(a + b);
        //mochix/mcdev01-begin
        String io = "ds";
        String mochi2 = "modified--mochixDEV2";
        //mochix/mcdev01-end
        System.out.println("dev02 add");
        System.out.println("dev02 down");
        for (int k = 0; k > 0; k--) {
            System.out.println(k);
        }
        for (int i = 0; i < 9; i++) {
            System.out.println(i + " -");
        }
        for (int k = 0; k < 20; k++) {
            System.out.println(k);
        }
        for (int k = 0; k < 20; k++) {
            System.out.println(k);
        }
        for (int i = 9; i < 20; i--) {
            System.out.println("mo");
        }
    }
}
