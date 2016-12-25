package mock;


import org.testng.annotations.Test;

public class pairwiseTest {

    @Test(dataProvider = "pairwiseDataSet1", dataProviderClass = PairwiseDataProvider.class)
    public void testWithPairwiseData(String age, String sex, String location) {
        System.out.println("Age:" + age + " Sex:" + sex + " Location:" + location);
    }
}
