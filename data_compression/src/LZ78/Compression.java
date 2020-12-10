/**
 *
 Name : Mahmoud Mohamed Said Ahmed       ID : 20180261

 Name : Karim Reda Abd-elhamed Arafaa    ID : 20180202

 Name : Ahmed Emad Youssef               ID : 20180017

 **/

package LZ78;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Compression {

    String data;
    String DictPath = "Dictionary.txt";
    String TagsPath = "Tags.txt";
    String DataPath = "Data.txt";
    ArrayList<String> DictionaryList = new ArrayList<>();
    ArrayList<Tag> tags = new ArrayList<>();

    public ArrayList<String> getDictionaryList() {
        return DictionaryList;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public Compression() {
        data = new String();
        DictionaryList.add("\0");
    }

    public Compression(String d) {
        data = d;
        DictionaryList.add("\0");
    }

    public void ReadDataFromFile() {
        FileReader DataFile = null;
        BufferedReader DataBuff = null;
    }

    public void compress() {

        String Cur = "";
        int DictionaryIndex = 0;
        for (int i = 0; i < data.length(); i++) {
            char CurChar = data.charAt(i);
            Cur += CurChar;
            int check = SearchIndex(Cur);

            if (check == -1) {
                Tag tag = new Tag();
                tag.pointer += DictionaryIndex;
                tag.NextChar += data.charAt(i);
                tags.add(tag);
                DictionaryList.add(Cur);
                Cur = "";
                DictionaryIndex = 0;
            } else if (i == data.length() - 1) {
                Tag tag = new Tag();
                tag.pointer += DictionaryIndex;
                tag.NextChar += '\0';
                tags.add(tag);
                break;
            } else if (check > -1) {
                DictionaryIndex = check;
            }
        }
    }

    int SearchIndex(String cur) {
        int Index = -1;
        for (int i = 0; i < DictionaryList.size(); i++) {
            if (DictionaryList.get(i).equals(cur)) {
                Index = i;
                break;
            }
        }
        return Index;
    }

    public void PrintList() {
        System.out.println("DictoinaryList: ");
        for (int i = 0; i < DictionaryList.size(); i++) {
            System.out.println(DictionaryList.get(i));
        }
        System.out.println("TagsList: ");
        for (int i = 0; i < tags.size(); i++) {
            System.out.println(tags.get(i).pointer + " , " + tags.get(i).NextChar);
        }
    }

    public void StoreDataToFile() {
        FileWriter DictFile = null;
        FileWriter TagsFile = null;
        BufferedWriter DictBuff = null;
        BufferedWriter TagsBuff = null;
        try {
            DictFile = new FileWriter(new File(DictPath));
            TagsFile = new FileWriter(new File(TagsPath));
            DictBuff = new BufferedWriter(DictFile);
            TagsBuff = new BufferedWriter(TagsFile);
            for (int i = 0; i < DictionaryList.size(); i++) {
                DictBuff.write(DictionaryList.get(i) + "\r\n");
            }
            DictBuff.flush();
            for (int i = 0; i < tags.size(); i++) {
                TagsBuff.write(tags.get(i).pointer + "\r\n");
                TagsBuff.write(tags.get(i).NextChar + "\r\n");
            }
            TagsBuff.flush();
        } catch (IOException e) {
        } finally {
            try {
                if (DictFile != null) {
                    DictFile.close();
                }
                if (DictBuff != null) {
                    DictBuff.close();
                }
                if (TagsFile != null) {
                    TagsFile.close();
                }
                if (TagsBuff != null) {
                    TagsBuff.close();
                }
            } catch (IOException e) {
            }
        }
        System.out.println("Storing Done Succefully!!!");
    }

}
