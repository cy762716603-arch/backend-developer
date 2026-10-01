import org.junit.jupiter.api.*;

public class JUnitTest {

    @DisplayName("1+2는 3이다")
    @Test
    public void junitTest(){
       int a = 1;
       int b = 2;
       int sum = 3;

       System.out.println("1+2는 3이다");

       Assertions.assertEquals(sum, a+b);
    }

    @DisplayName("1+3응 3이다")
    @Test
    public void junitFailTest(){
        int a = 1;
        int b = 2;
        int sum = 3;

        System.out.println("1+3응 3이다");

        Assertions.assertEquals(sum, a+b);
    }

    @BeforeEach
    public void prepare(){
        System.out.println("테스트 준비");
    }

    @AfterEach
    public void clean(){
        System.out.println("테스트 후 설겆어");
    }

    @BeforeAll
    public static void prepreAll(){
        System.out.println("테스트 후 설겆어");
    }

    @AfterAll
    public static void cleanAll(){
        System.out.println("테스트 후 설겆어");
    }

}