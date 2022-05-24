import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class test {
    public static void main(String args[]){
        //This is master
        System.out.println("dev02 upper");
        //dev01Change
        int a=3;
        int b=4;
        System.out.println(a+b);
        System.out.println("dev02 add");
        System.out.println("dev02 down");
    }
}
