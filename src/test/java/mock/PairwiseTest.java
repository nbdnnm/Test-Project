package mock;


import org.testng.annotations.Test;

public class PairwiseTest {

    @Test(dataProvider = "pairwiseDataSetAgeSexLocation", dataProviderClass = PairwiseDataProvider.class)
    public void testWithPairwiseData(String sex, String age, String location) {
        System.out.println("Sex:" + sex + "\tAge:" + age + "\tLocation:" + location);
    }
}
