/**
 *
 Name : Mahmoud Mohamed Said Ahmed       ID : 20180261

 Name : Karim Reda Abd-elhamed Arafaa    ID : 20180202

 Name : Ahmed Emad Youssef               ID : 20180017

 **/

package Hufman;

import java.io.*;
import java.util.*;

public class Compression {

    ArrayList<Node> nodes;
    HandlingNodes handle = new HandlingNodes();
    String data;
    String CompressedCode;


    Compression(){
        nodes = new ArrayList<>();
        CompressedCode = new String();
    }

    public void Compress(String Data){
        data = Data;
        handle.HandleNodes(Data);
        nodes = handle.GetNodes();

        for(int i=0; i<Data.length(); i++)
        {
            String cur = new String();
            cur += Data.charAt(i);
            for(int j=0; j<nodes.size(); j++)
                if((cur.compareTo(nodes.get(j).symbol)) == 0)
                {
                    CompressedCode += nodes.get(j).code;
                    break;
                }
        }
    }

    public String GetCompressed(){
        return CompressedCode;
    }

    public void Read(String path){
        try{
            FileReader fr = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            //------//
            Compress(line);
            Write();
            //-----//
            br.close();
            fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void Write(){
        try{
            BufferedWriter CodeFile = new BufferedWriter(new FileWriter(new File("C-Code.txt")));
            CodeFile.write(CompressedCode);
            CodeFile.close();

            BufferedWriter TableFile = new BufferedWriter(new FileWriter(new File("C-Table.txt")));
            for(int i=0; i<nodes.size(); i++){
                if(nodes.get(i).symbol.length() == 1){
                    String line = nodes.get(i).symbol + "," + nodes.get(i).code;
                    TableFile.write(line);
                    TableFile.newLine();
                }
            }
            TableFile.write(File.separator);
            TableFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public String GetData(){
        return data;
    }

}
