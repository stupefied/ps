import java.util.*;
import java.util.stream.*;

//https://leetcode.com/problems/design-search-autocomplete-system/submissions/

class AutocompleteSystem {

    int LIMIT = 3;
    TrieNode root = new TrieNode();
    TrieNode current = root;

    HashMap<String, Integer> sentenceUsage = new HashMap<String, Integer>(); ;
    StringBuilder searchString = new StringBuilder();;

    class TrieNode {
        HashMap<Character, TrieNode> nextNodes = new HashMap<Character, TrieNode>();
        HashSet<String> sentences = new HashSet<String>();
    }

    public List<String> input(char c) {
        if (('a' <= c && c <= 'z') || (c == ' ')) {
            searchString.append(c);
            current = current.nextNodes.computeIfAbsent(c, tn -> new TrieNode());
            return getTopNSentences(LIMIT, current.sentences);
        } else if (c == '#') {
            searchString = new StringBuilder();
            current = this.root;
            addSentence(this.root, searchString.toString(), 1);
        }
        return new ArrayList<>();
    }

    private void addSentence(TrieNode node, String sentence, int usage) {
        sentenceUsage.put(sentence, sentenceUsage.getOrDefault(sentence, 0) + usage);
        TrieNode curr = node;
        for (int i = 0; i < sentence.length(); i++) {
            curr = curr.nextNodes.computeIfAbsent(sentence.charAt(i), tn -> new TrieNode());
            curr.sentences.add(sentence);
        }
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        IntStream.range(0, sentences.length)
            .forEach( i -> addSentence(this.root, sentences[i], times[i]));
        /*
        for (int i = 0; i < sentences.length; i++) {
        }
        */
    }

    class SentenceUsage {
        int usage;
        String sentence;
        public SentenceUsage(String sentence, int usage) { this.sentence = sentence; this.usage = usage;};
    }

    private List<String> getTopNSentences(int N, HashSet<String> sentences) {

        List<SentenceUsage> usage = sentences.stream()
            .map(s -> new SentenceUsage(s, sentenceUsage.get(s)))
            .collect(Collectors.toList());

        Collections.sort(usage, (a, b) -> {
            int comp = Integer.compare(b.usage, a.usage);
            return comp != 0? comp : a.sentence.compareTo(b.sentence);
        });

        return usage.stream()
            .map(n -> n.sentence)
            .limit(N)
            .collect(Collectors.toList());
    }
}
