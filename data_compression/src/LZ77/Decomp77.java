package LZ77;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decomp77 {

    public void decompress() throws IOException {
        FileOutputStream filew = new FileOutputStream("Decomp77.txt");
        try ( ObjectOutputStream dataw = new ObjectOutputStream(filew)) {
            Scanner input = new Scanner(System.in);
            int Length = 0, CharNum = 0, NumTag = 0;
            String Char;
            ArrayList<String> Data = new ArrayList<>();
            System.out.print("Enter Number Of Tags \n");
            NumTag = input.nextInt();
            for (int i = 0; i < NumTag; i++) {
                System.out.println("\n Enter "
                        + "Length &"
                        + " Char Num &"
                        + " Char   "
                );
                Length = input.nextInt();
                CharNum = input.nextInt();

                if (Length == 0 && CharNum == 0) {
                    Char = input.next();
                    Data.add(Char);
                } else {
                    Char = input.next();
                    int FromIndex = Data.size() - Length;
                    int ToIndex = FromIndex + CharNum;
                    List<String> Move = Data.subList(FromIndex, ToIndex);
                    Data.addAll(Move);
                    Data.add(Char);
                }
            }
            System.out.print(Data);
            System.out.println();
            dataw.writeObject(Data);
            dataw.flush();
        }
    }

}
