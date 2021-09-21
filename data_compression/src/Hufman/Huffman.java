package Hufman;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {

    public static PriorityQueue <Probability> priorityQueue ;
    public static String txt ;

    static int getIndex(char x){

        for (int i = 0; i < txt.length() ; i++ ) {

            if (txt.charAt(i) == x )
                return i;

        }

        return 0;
    }

    static void constructInput(String txt){
        int arr[] = new int[300];
        for(int i = 0 ; i < txt.length();++i){
            arr[txt.charAt(i)]++;
        }
        for(int i = 0 ; i< 300;++i){
            if(arr[i]==0) continue;
            char x = (char) i;
            priorityQueue.add(new Probability(x+"", arr[i]));
        }
    }

    static void readInput() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s;
        double d;
        for (int i = 0; i < n; ++i) {
            s = in.next();
            d = in.nextDouble();
            txt += s;
            priorityQueue.add(new Probability(s, d));

        }
    }

    public static void print() {
        for (Object x : priorityQueue.toArray()) {
            System.out.println(((Probability) x).toString());
        }
    }

    public static void solve() {
        if (priorityQueue.size() == 1) { //if one element onl is left in the queue , set empty tag
            priorityQueue.peek().tag = "";
            return;
        }
        Probability s1, s2, add;

        s1 = priorityQueue.poll();
        s2 = priorityQueue.poll();
        add = new Probability(s2.string + s1.string, s1.prob + s2.prob);
        priorityQueue.add(add);

        solve();
        if (getIndex(s1.string.charAt(0)) >= getIndex(s2.string.charAt(0))) {
            s1.tag = add.tag + '1';
            s2.tag = add.tag + '0';
        } else {
            s1.tag = add.tag + '0';
            s2.tag = add.tag + '1';
        }

        priorityQueue.remove(add);
        priorityQueue.add(s2);
        priorityQueue.add(s1);

    }


}

