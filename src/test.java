import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class test {
    public static void main(String args[]){
        //This is master
        System.out.println("dev02 upper");
        //dev01Change
        int a=3;
        int b=4;
        System.out.println(a+b);
        //mochix/mcdev01-begin
        String io="ds";
        String mochi2="modified--mochixDEV2";
        //mochix/mcdev01-end
        System.out.println("dev02 add");
        System.out.println("dev02 down");
        System.out.println("another");
    }
}
