package Hufman;

import java.util.Objects;

public class Probability {

    public String string;
    public double prob ;
    public String tag;

    public Probability(String string, double prob) {
        this.string = string;
        this.prob = prob;
    }


    public boolean equals (Object obj){

        return this.prob==((Probability)obj).prob&&this.string==((Probability)obj).string;

    }

    @Override
    public String toString() {
        return "Probability {" + "string='" + string + '\'' + ", prob=" + prob + '}';
    }

}
