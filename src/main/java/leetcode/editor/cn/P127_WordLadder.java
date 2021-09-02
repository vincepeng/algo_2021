package leetcode.editor.cn;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


//127-单词接龙
public class P127_WordLadder {

    public static void main(String[] args) {
        Solution solution2 = new P127_WordLadder().new Solution();
        String beginWord2 = "hit";
        String endWord2 = "cog";
        String[] wordList2 = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution2.ladderLength(beginWord2, endWord2, Arrays.asList(wordList2)));


        Solution solution = new P127_WordLadder().new Solution();
        String beginWord = "cet";
        String endWord = "ism";
        String[] wordList = {"kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay",
                "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has",
                "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono",
                "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old",
                "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag",
                "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron",
                "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod",
                "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye",
                "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat",
                "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee",
                "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see",
                "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum",
                "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin",
                "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray",
                "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo",
                "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil",
                "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil",
                "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net",
                "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him",
                "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top",
                "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid",
                "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid",
                "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun",
                "pat", "ten", "mob"};

        Arrays.sort(wordList);
        long start = Instant.now().getEpochSecond();
        System.out.println(solution.ladderLength(beginWord, endWord, Arrays.asList(wordList)));
        System.out.println("cost: " + (Instant.now().getEpochSecond() - start) + " s");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String> result = new ArrayList<>();

        private Map<String, Integer> subStrResult = new HashMap<>();

        private int maxLevel;


        private void doFind(String endWord, LinkedList<String> wordsRecords, HashMap<Integer, Map<String, List<Pair>>> wordIndexMap) {
            //终止条件;(单词用完)
            String currentWord = wordsRecords.getLast();
            Integer level = subStrResult.get(currentWord);
            if (level != null && level <= wordsRecords.size() + 1) {
                return;
            }

            //当前当前满足条件了
            if (currentWord.equals(endWord)) {

                //因为要找最短的
                if (wordsRecords.size() < result.size() || result.isEmpty()) {
                    //                    System.out.println(wordsRecords);
                    this.result = new ArrayList(wordsRecords);
                }
                return;
            }
            //已经遍历完成,但是没有找到
            if (wordsRecords.size() == maxLevel) {
                return;
            }
            //已经比当前的大了,直接忽略
            if (!result.isEmpty() && wordsRecords.size() >= this.result.size()) {

                return;
            }

            while (wordsRecords.size() > 0) {
                String currentWord = wordsRecords.poll();
                List<String> children = getChildren(currentWord, wordIndexMap, wordsRecords);
                doSearchNextLevel(children, wordsRecords, wordIndexMap, endWord);

            }


            wordsRecords.addLast(currentWord);
            subStrResult.put(currentWord, wordsRecords.size());
        }


        private void doSearchNextLevel(List<String> children, LinkedList<String> wordsRecords, HashMap<Integer, Map<String, List<Pair>>> wordIndexMap, String endWord) {
            wordsRecords.addLast();
            for (String child : children) {
                if (child.equals(endWord)) {
                    wordsRecords.addLast(child);
                    System.out.println(wordsRecords);
                    this.result = new ArrayList(wordsRecords);
                    return;
                }else {
                    subStrResult.put(child, wordsRecords.size());
                    //已经遍历完成,但是没有找到
                    if (wordsRecords.size() == maxLevel) {
                        return;
                    }
                }
            }
        }


        /**
         * 因为单词的数量更短,所以以单词的为基数
         */
        private List<String> getChildren(String currentWord, HashMap<Integer, Map<String, List<Pair>>> wordIndexMap, LinkedList<String> wordsRecords) {
            List<String> children = new ArrayList<>();
            for (int i = 0; i < currentWord.length(); i++) {
                String subStringWithoutI = getSubStringWithoutI(i, currentWord);
                Map<String, List<Pair>> stringListMap = wordIndexMap.get(i);
                List<Pair> pairs = stringListMap.get(subStringWithoutI);
                //没有子类
                if (pairs == null || pairs.isEmpty()) {
                    continue;
                }
                //找到那些没有用过的子类(复杂度 O(N)
                HashSet<String> tempSet = new HashSet<>(wordsRecords);
                List<String> collect = pairs.stream().filter(pair -> !tempSet.contains(pair.getWord())).map(Pair::getWord).collect(Collectors.toList());
                children.addAll(collect);

            }
            return children;
        }


        private String getSubStringWithoutI(int finalI, String s) {
            if (finalI == 0) {
                return s.substring(finalI + 1);
            }else if (finalI == s.length() - 1) {
                return s.substring(0, finalI);
            }else {
                return s.substring(0, finalI) + s.substring(finalI + 1);
            }
        }


        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            return useRecursion(beginWord, endWord, wordList);
        }


        private int useRecursion(String beginWord, String endWord, List<String> wordList) {

            this.maxLevel = wordList.size();
            HashMap<Integer, Map<String, List<Pair>>> wordMap = new HashMap<>();
            for (int i = 0; i < beginWord.length(); i++) {
                int finalI = i;
                Map<String, List<Pair>> groupList = wordList.stream().map(s -> {
                    String subStringWithoutI = getSubStringWithoutI(finalI, s);
                    Pair pair = new Pair(subStringWithoutI, s);
                    return pair;
                }).collect(Collectors.groupingBy(Pair::getSubString));
                wordMap.put(i, groupList);
            }


            LinkedList<String> wordsRecords = new LinkedList<>();
            wordsRecords.addLast(beginWord);
            doFind(endWord, wordsRecords, wordMap);

            return result.size();
        }


        class Pair {

            private String subString;

            private String word;


            public Pair(String subString, String word) {
                this.subString = subString;
                this.word = word;
            }


            @Override
            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;
                Pair pair = (Pair) o;
                return word.equals(pair.word);
            }


            public String getSubString() {
                return subString;
            }


            public String getWord() {
                return word;
            }


            @Override
            public int hashCode() {
                return Objects.hash(word);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}


