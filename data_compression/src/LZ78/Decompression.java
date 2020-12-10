/**
 *
 Name : Mahmoud Mohamed Said Ahmed       ID : 20180261

 Name : Karim Reda Abd-elhamed Arafaa    ID : 20180202

 Name : Ahmed Emad Youssef               ID : 20180017

 **/

package LZ78;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Decompression {

    public void decompress() throws IOException {
        Scanner input = new Scanner(System.in);
        int Length = 0, NumTag = 0, NumDic = 0;
        String Char;
        ArrayList<String> Data = new ArrayList<>();
        ArrayList<String> Data1 = new ArrayList<>();
        System.out.print("Enter Number Of ArrayList Dic \n");
        NumDic = input.nextInt();
        System.out.println("\n Enter The Element \n");
        for (int i = 0; i < NumDic; i++) {
            Char = input.next();
            Data.add(Char);
        }
        System.out.println("\n The Elements Is \n");
        for (int x = 0; x < Data.size(); x++) {
            System.out.print(Data.get(x));
            System.out.println();
        }
        System.out.println("Enter number of tag \n");
        NumTag = input.nextInt();
        for (int i = 0; i < NumTag; i++) {
            System.out.println("\n Enter "
                    + "Length &"
                    + " Char   "
            );
            Length = input.nextInt();
            if (Length == 0) {
                Char = input.next();
                Data1.add(Char);
            } else {
                Length -= 1;
                Char = input.next();
                String move = Data.get(Length);
                Data1.add(move);
                Data1.add(Char);
            }
        }
        for (int x = 0; x < Data1.size(); x++) {
            System.out.print(Data1.get(x));
        }
        System.out.println();
    }

}
