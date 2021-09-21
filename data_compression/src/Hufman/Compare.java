package Hufman;

import java.util.Comparator;

public class Compare implements Comparator <Probability> {

    public int compare (Probability a , Probability b){

        return Double.compare( a.prob , b.prob);

    }

}

