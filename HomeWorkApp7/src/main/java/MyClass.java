public class MyClass {

    @BeforeSuite
    public void before(){
        System.out.println("BeforeSuite");
    }
    @Test(priority = 1)
    public void test1(){
        System.out.println("Test1");
    }

    @Test(priority = 5)
    public void test2(){
        System.out.println("Test2");
    }

    @Test(priority = 2)
    public void test3(){
        System.out.println("Test3");
    }

    @Test(priority = 6)
    public void test4(){
        System.out.println("Test4");
    }

    @Test(priority = 3)
    public void test5(){
        System.out.println("Test5");
    }

    @Test(priority = 7)
    public void test6(){
        System.out.println("Test6");
    }

    @Test(priority = 4)
    public void test7(){
        System.out.println("Test7");
    }

    @Test(priority = 8)
    public void test8(){
        System.out.println("Test8");
    }

    @AfterSuite
    public void after() {
        System.out.println("AfterSuite");
                 }
}
