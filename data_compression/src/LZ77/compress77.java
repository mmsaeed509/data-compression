package LZ77;

import java.io.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class compress77 {

    public void compress() throws IOException {
        FileInputStream FileRead1 = new FileInputStream("/home/ozil/GitHub/data-compression/data_compression/test.txt");
        DataInputStream DataRead1 = new DataInputStream(FileRead1);
        BufferedReader readdata = new BufferedReader(new InputStreamReader(DataRead1));
        FileOutputStream Filewrite = new FileOutputStream("Compress.txt");
        DataOutputStream DataWrite = new DataOutputStream(Filewrite);
        String input = readdata.readLine();
        System.out.print(input);
        System.out.println();
        int Pointer = 0, CharLen = 0;
        char NextChar = '0';
        String word, Char = null;
        int i=0, j = 0, searchword, length = 0;
        for (i = 0; i < input.length(); i++) {
            word = null;
            word = input.substring(0, i);
            j = i + 1;
            do {
                Char = input.substring(i, j);
                searchword = word.lastIndexOf(Char);
                if (searchword != -1) {
                    length = searchword;
                    j++;

                    if (j > input.length()) {
                        i = input.length();
                        Pointer = word.length() - length;
                        CharLen = Char.length();
                        NextChar = ' ';
                        DataWrite.writeInt(Pointer);
                        DataWrite.writeInt(CharLen);
                        DataWrite.writeChar(NextChar);
                        break;
                    }
                } else {
                    i = word.length() + (Char.length() - 1);
                    if (Char.length() == 1) {
                        Pointer = 0;
                        CharLen = 0;
                    } else {
                        Pointer = word.length() - length;
                        CharLen = Char.length() - 1;

                    }
                    NextChar = Char.charAt(Char.length() - 1);
                    DataWrite.writeInt(Pointer);
                    DataWrite.writeInt(CharLen);
                    DataWrite.writeChar(NextChar);
                    break;
                }
            } while (searchword != -1);
        }
        FileInputStream FileRead2 = new FileInputStream("Compress.txt");
        DataInputStream DataRead2 = new DataInputStream(FileRead2);
        int LengthChar = 0, NumCharBefor = 0;
        char LastChar;
        while (FileRead2.available() != 0) {
            LengthChar = DataRead2.readInt();
            NumCharBefor = DataRead2.readInt();
            LastChar = DataRead2.readChar();
            System.out.println("("+LengthChar+","+NumCharBefor+","+LastChar+")");
        }

    }

}
