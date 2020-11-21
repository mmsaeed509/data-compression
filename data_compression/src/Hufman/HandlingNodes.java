package Hufman;

import java.util.ArrayList;

public class HandlingNodes {

    ArrayList<Node> nodes;
    ArrayList<String> Symbols;

    HandlingNodes(){
        nodes = new ArrayList<>();
        Symbols = new ArrayList<>();
    }

    public void HandleNodes(String data){
        getFreqs(data);
        sortNodes();
        for(int i=nodes.size()-1; i>1; i--)
        {
            Node tmp = new Node();
            tmp.symbol += nodes.get(i-1).symbol + nodes.get(i).symbol;
            tmp.freq = nodes.get(i-1).freq + nodes.get(i).freq;
            if(nodes.get(i-1).symbol.length() == 1 ){
                nodes.get(i-1).left = null; nodes.get(i-1).right = null; }
            if(nodes.get(i).symbol.length() == 1){
                nodes.get(i).left = null; nodes.get(i).right = null; }
            tmp.left = nodes.get(i-1);
            tmp.right = nodes.get(i);
            nodes.add(tmp);
            sortNode(tmp);
        }
        getHashed();
    }

    public void getFreqs(String data) //Initiate array with all chars with freqs.
    {
        Symbols = new ArrayList<>();
        for(int i=0; i<data.length(); i++)
        {
            String cur = new String();
            cur += data.charAt(i);
            int ind = searchInd(cur);
            if(ind == -1)
            {
                Node node = new Node();
                node.freq = 1;
                node.symbol += cur;
                nodes.add(node);
            }
            else{
                nodes.get(ind).freq++;
            }
        }
    }

    public void sortNodes(){ //used only one time at the beginning
        for(int i=0, j, biggest ; i<nodes.size()-1; i++)
        {
            for(j=i+1, biggest=i; j<nodes.size(); j++)
                if(nodes.get(j).freq > nodes.get(biggest).freq)
                    biggest=j;
            if(biggest != i){
                Node tmp = new Node();
                tmp = nodes.get(i);
                nodes.set(i,  nodes.get(biggest));
                nodes.set(biggest,  tmp);
            }
        }
    }

    public void sortNode(Node tmp){
        int i;
        for(i=0; i<nodes.size(); i++){
            if(nodes.get(i).freq < tmp.freq)
                break;
        }

        for(int j=nodes.size()-1; j>i; j--) //shift nodes
        {
            Node tmp2 = nodes.get(j-1);
            nodes.set(j-1, nodes.get(j));
            nodes.set(j, tmp2);
        }
        nodes.set(i,  tmp);
    }

    public int searchInd(String cur){
        for(int i=0; i<nodes.size(); i++)
            if((cur.compareTo(nodes.get(i).symbol)) == 0)
                return i;
        return -1;
    }

    public void getHashed(){
        nodes.get(0).code += "1";
        nodes.get(1).code += "0";
        for(int i=0; i<nodes.size(); i++){
            if(nodes.get(i).left != null){
                nodes.get(i).left.code += nodes.get(i).code + "1";
            }
            if(nodes.get(i).right != null){
                nodes.get(i).right.code += nodes.get(i).code + "0";
            }
        }
    }

    public void print(){
        for(int i=0; i<nodes.size(); i++)
            System.out.println(nodes.get(i).symbol);
    }

    public ArrayList<Node> GetNodes(){
        return nodes;
    }

}
