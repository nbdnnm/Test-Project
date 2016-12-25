package mock;

import general.PairwiseFile;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class PairwiseDataProvider {

    @DataProvider(name = "pairwiseDataSet1")
    public static Iterator<Object[]> pairwiseDataSet1() {
        PairwiseFile file = new PairwiseFile("pairwise/testPairwiseModel.txt");
        return file.iterator();
    }
}
