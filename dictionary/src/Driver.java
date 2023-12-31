import java.io.*;
import java.util.HashMap;

class Words {
    public String wordname, meaning;
    Words(String wordname, String meaning) {
        this.wordname = wordname;
        this.meaning = meaning;
    }
}

class Dictionary {
    public HashMap<String, Words> map = new HashMap<String, Words>();
    public void loadRecords() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parsedLine = line.split(",");
            String wordName = parsedLine[0];
            String meaning = parsedLine[1];
            Words words = new Words(wordName,meaning);
            this.map.put(wordName, words);
        }
        br.close();
    }

    public String findWord(String word) {
        for (String i : map.keySet()) {
            if (i.equals(word)) {
                Words newWord = map.get(i);
                return newWord.meaning;
            }
        }
        return null;
    }

    public void saveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newdictionary.txt"));
        for (String i : map.keySet()) {
            Words w = map.get(i);
            bw.write(w.wordname);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }
}

public class Driver {
    public static void main(String[] args) throws Exception {
        Dictionary obj = new Dictionary();
        obj.loadRecords();
        System.out.println(obj.findWord("cat"));
        obj.saveRecords();
    }
}