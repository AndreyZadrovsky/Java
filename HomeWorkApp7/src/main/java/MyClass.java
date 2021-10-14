public class Class {

    @BeforeSuite
    public void before(){
        System.out.println("BeforeSuite");
    }
    @Test(priority = 1)
    public void test1(){
        System.out.println("Test1");
    }

    @Test(priority = 1)
    public void test2(){
        System.out.println("Test2");
    }

    @Test(priority = 1)
    public void test3(){
        System.out.println("Test3");
    }

    @Test(priority = 1)
    public void test4(){
        System.out.println("Test4");
    }

    @Test(priority = 1)
    public void test5(){
        System.out.println("Test5");
    }

    @Test(priority = 1)
    public void test6(){
        System.out.println("Test6");
    }

    @Test(priority = 1)
    public void test7(){
        System.out.println("Test7");
    }

    @Test(priority = 1)
    public void test8(){
        System.out.println("Test8");
    }

    @BeforeSuite
    public void after() {
        System.out.println("After");
                 }
}
