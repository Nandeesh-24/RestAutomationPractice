import org.testng.annotations.Test;

public class VerifyGrouping {
    @Test(groups = { "smoke" })
    public void test1() {
        System.out.println("smoke");
    }

    @Test(groups = { "regression" },dependsOnGroups = {"smoke"})
    public void test2() {
        System.out.println("regression");
    }

    @Test(groups = { "regression", "integration" })
    public void test3() {
        System.out.println("smoke");
        System.out.println("regression");
    }
}
