import Luxoft.OcurrencesDescTreeMap;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OcurrencesDescTest {

    @Test
    public void testOcurrencesDescSort() {

        int[] givenArray =  new int[]{1,4,2,1,1,3,2,1,3};
        int[] expectedArray = new int[]{1,1,1,1,2,2,3,3,4};
        int[] sortedArray = OcurrencesDescTreeMap.ocurrencesDescSort(givenArray);

        Arrays.stream(givenArray).forEach(System.out::print);
        System.out.println();
        Arrays.stream(sortedArray).forEach(System.out::print);

        assertArrayEquals(expectedArray,sortedArray);

    }
}