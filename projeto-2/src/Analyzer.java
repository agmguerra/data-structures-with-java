import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		List<Sentence> list = new LinkedList<Sentence>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       Sentence set = parseLine(line);
		       if (set != null) {
		    	   list.add(set);
		       }
		    }
		} catch (Exception e) {
			list = new ArrayList<Sentence>();
		}	
		return list; 

	}
	
	private static Sentence parseLine(String line) {
		if (!line.matches("^(0|1|2|-1|-2)\\s{1}.+")) {
			return null;
		} else {
			int score = Integer.parseInt(line.substring(0, line.indexOf(" ")));
			String text = line.substring( line.indexOf(" ") + 1);
			return new Sentence(score, text);
		}
		
	}

	
	private static List<String> splitSentenceIntoWords(String sentence) {
		
		List<String> sentenceParsed = new LinkedList<String>();
		if (sentence != null && !sentence.isEmpty()) {
			String[] textParts = sentence.split("\\s{1}");
			for (String part : textParts) {
				int j = part.indexOf("'");
				if (!part.startsWith("'") && j > 0) {
					part = part.substring(0, j + 1);
				}
				part = part.toLowerCase();
				if (part.matches("[a-z]+")) {
					sentenceParsed.add(part);
				}
			}
		}
		
		return sentenceParsed;
	}
	
	
	private static void parseSentence(Sentence sentence, Map<String, Word> words) {
		String[] textParts = sentence.getText().split("\\s{1}");
		for (String part : textParts) {
			

			List<String> validWordsFromSentence = splitSentenceIntoWords(part);
			if (!validWordsFromSentence.isEmpty()) {
				for (String sentencePart : validWordsFromSentence) {
					
		
				if (words.containsKey(sentencePart)) {
					Word word = words.get(sentencePart);
					word.increaseTotal(sentence.getScore());
					
				} else {
					Word word = new Word(sentencePart);
					word.increaseTotal(sentence.getScore());
					words.put(word.getText(), word);
				}
				}
			}
			
		}

	}
	
	public static Set<Word> allWords(List<Sentence> sentences) {
		
		Map<String, Word> words = new HashMap<String, Word>();
		if (sentences != null && !sentences.isEmpty() ) {
			for (Sentence sentence : sentences) {
				if (sentence != null && sentence.getText() != null) {
					parseSentence(sentence, words);
				}
			}
		}

		Set<Word> allWords = new HashSet<Word>(words.values());
		return allWords;

	}
	
	public static Map<String, Double> calculateScores(Set<Word> words) {

		Map<String, Double> wordScoreContainer = new HashMap<String, Double>();
		if (words != null && !words.isEmpty()) {

			for (Word word : words) {
				if (word != null) {
					wordScoreContainer.put(word.getText(), word.calculateScore());
				}
			}
		}
		
		return wordScoreContainer;

	}
	
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		List<String> sentenceParsed = splitSentenceIntoWords(sentence);
		int count = 0;
		double averageScore = 0.0;
		if (wordScores != null && !wordScores.isEmpty() && !sentenceParsed.isEmpty()) {
			for (String part: sentenceParsed) {
				if (wordScores.containsKey(part)) {
					averageScore += wordScores.get(part);
				} 
				count++;
			}
			averageScore = averageScore/count;
		} else {
			averageScore = 0;
		}
		
		return averageScore;

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
		
	}
}
