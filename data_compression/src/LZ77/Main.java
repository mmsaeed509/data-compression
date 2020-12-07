package LZ77;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println();
        compress77 C77 =new compress77();
        Decomp77 D77=new Decomp77();
        Scanner input = new Scanner(System.in);
        boolean Exit = true;
        do {
            System.out.println("Choose you want "
                    + "1)- Compress 77 "
                    + "-2)- Decompress 77 "
                    + "-3- Exit ");
            int number = input.nextInt();
            switch(number){
                case 1:
                    C77.compress();
                    break;
                case 2:
                    D77.decompress();
                    break;
                case 3:
                    System.out.println("Thank You Use Program \n");
                    Exit=false;
                    break;
                default:
                    System.out.println("please Enter 1 to compress, 2 to decompress: (not another number) ");
                    break;
            }
        }while(Exit);

    }

}
