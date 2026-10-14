import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class MyTests {
    @Run
    public void testLogin() {
        System.out.println("Login test passed");
    }

    @Run
    public void testSignup() {
        System.out.println("Signup test passed");
    }

    public void helperMethod() {
        System.out.println("Helper method");
    }

    @Run
    public void testLogout() {
        System.out.println("Logout test passed");
    }
}

public class p7_partA_2 {
    public static void main(String[] args)
            throws Exception {

        MyTests obj = new MyTests();
        int count = 0;

        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Run.class)
                    && method.getParameterCount() == 0) {

                method.invoke(obj);
                count++;
            }
        }

        System.out.println("Total tests run: " + count);
    }
}
