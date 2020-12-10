/**
 *
 Name : Mahmoud Mohamed Said Ahmed       ID : 20180261

 Name : Karim Reda Abd-elhamed Arafaa    ID : 20180202

 Name : Ahmed Emad Youssef               ID : 20180017

 **/

package Hufman;

import java.io.*;
import java.util.*;

public class Decompression {

    ArrayList<Node> nodes;
    String data;
    String Code;
    int longest=0;

    Decompression(){
        nodes = new ArrayList<>();
        data = new String();
    }

    public String GetData(){
        return data;
    }

    public int Search(String cur){
        for(int i=0; i<nodes.size(); i++){
            if((cur.compareTo(nodes.get(i).code)) == 0)
                return i;
        }
        return -1;
    }

    public void Decompress(String code){
        Code = code;
        String cur = new String();
        for(int i=0; i<code.length(); i++){
            cur += code.charAt(i);
            int ind = Search(cur);
            if(ind != -1)
            {
                data += nodes.get(ind).symbol;
                cur="";
            }
            if(cur.length() > longest){
                System.out.println("error in code or Table!!!");
            }
        }
    }

    public void read(String Cpath, String Tpath){
        try{
            BufferedReader tableFile = new BufferedReader(new FileReader(new File(Tpath)));
            while(true){
                Node tmp = new Node();
                String line = tableFile.readLine();
                if((line.compareTo(File.separator)) == 0)
                    break;
                String []tmpLine = line.split(",");
                tmp.symbol = tmpLine[0];
                tmp.code = tmpLine[1];
                nodes.add(tmp);
            }
            tableFile.close();
            getLongest();

            BufferedReader codeFile = new BufferedReader(new FileReader(new File(Cpath)));
            String data = codeFile.readLine();
            Decompress(data);
            codeFile.close();
            Write();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void Write(){
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter(new File("D-Data.txt")));
            br.write(data);
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public String GetCode(){
        return Code;
    }

    public void getLongest(){ //check the error of the code or the table if exist,
        //for example if longest code is 00000(5 digits) and the cur code is 111111(6 digits) it warns
        //about error, not waiting till for-loop ends and print wrong data
        for(int i=0; i<nodes.size(); i++){
            if(nodes.get(i).code.length() > longest)
                longest = nodes.get(i).code.length();
        }
    }

}
