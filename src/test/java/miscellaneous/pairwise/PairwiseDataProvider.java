package miscellaneous.pairwise;

import general.PairwiseFile;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class PairwiseDataProvider {

    @DataProvider(name = "pairwiseDataSetAgeSexLocation")
    public static Iterator<Object[]> pairwiseDataSetAgeSexLocation() {
        PairwiseFile file = new PairwiseFile("pairwise/testPairwiseModelAgeSexLocation.txt");
        return file.iterator();
    }
}
