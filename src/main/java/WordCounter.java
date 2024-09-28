import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = countWordFrequency("words.txt");
        printSortedWordFrequency(wordCount);
    }

    public static Map<String, Integer> countWordFrequency(String fileName) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordCount;
    }

    public static void printSortedWordFrequency(Map<String, Integer> wordCount) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordCount.entrySet());

        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
