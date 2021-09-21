/**
 *
Name : Mahmoud Mohamed Said Ahmed       ID : 20180261

Name : Karim Reda Abd-elhamed Arafaa    ID : 20180202

Name : Ahmed Emad Youssef               ID : 20180017

**/


import Hufman.*;
import LZ77.*;
import LZ78.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class winOzoz {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println("**************************************");
        System.out.println("*        Welcome In Win Ozoz         *");
        System.out.println("**************************************");
        System.out.println("* which algorithm you want to use in *");
        System.out.println("* compress and decompress the data   *");
        System.out.println("*                                    *");
        System.out.println("* 1 _ Huffman                        *");
        System.out.println("* 2 _ LZ77                           *");
        System.out.println("* 3 _ LZ88                           *");
        System.out.println("* 4 _ Exit                           *");
        System.out.println("*                                    *");
        System.out.println("**************************************");

        String choice ;
        Scanner scannerString = new Scanner(System.in);
        choice = scannerString.nextLine();

        // Huffman
        if (choice.equals("1")){


            Comparator <Probability> comparator = new Compare();
            Huffman.priorityQueue = new PriorityQueue<>(1,comparator);
            Scanner scanner = new Scanner(System.in);

            System.out.println("enter the txt : ");
            Huffman.txt = scanner.nextLine();
            Huffman.solve();
            Huffman.print();


        }
        // Huffman

        // LZ77
        else if (choice.equals("2")){

        }
        // LZ77

        // LZ88
        else if (choice.equals("3")){

        }
        // LZ88

        // Exit
        else if (choice.equals("4")){

            System.out.println(" Good Bye ^_^ ");
            System.exit(0);

        }
        // Exit

        else {

            System.out.println("Wrong Choice ");

        }



    }
}
