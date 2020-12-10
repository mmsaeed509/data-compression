/**
 *
 Name : Mahmoud Mohamed Said Ahmed       ID : 20180261

 Name : Karim Reda Abd-elhamed Arafaa    ID : 20180202

 Name : Ahmed Emad Youssef               ID : 20180017

 **/

package LZ78;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        ArrayList<String> Dictionary = new ArrayList<>();
        ArrayList<Tag> Tags;
        Decompression dee = new Decompression() ;
        int size;
        System.out.println("welcome to LZ78 compression program ");
        OUTER:
        while (true) {
            int choice;
            System.out.println("please Enter 1 to compress, 2 to decompress, 3 to exit: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                {
                    System.out.println("Enter Statement to be compressed: ");
                    String Data = input.next();
                    Compression demo = new Compression(Data);
                    demo.compress();
                    demo.PrintList();
                    demo.StoreDataToFile();
                    System.out.println("Decompression of these data is: ");
                    Dictionary = demo.getDictionaryList();
                    Tags = new ArrayList<>();
                    Tags = demo.getTags();
                    Decompression demo2 = new Decompression();
                    break;
                }
                case 2:
                {
                    dee.decompress();
                    break;
                }
                case 3:
                    System.out.println("Thank You Use Program \n");
                    break OUTER;
                default:
                    System.out.println("please Enter 1 to compress, 2 to decompress: (not another number) ");
                    break;
            }
        }

    }

}
