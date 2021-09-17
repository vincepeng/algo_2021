package leetcode.editor.cn;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


//127-单词接龙
public class P127_WordLadder {

    public static void main(String[] args) {
        test1();
        test2();


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
                "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"};

        Arrays.sort(wordList);
        long start = Instant.now().getEpochSecond();
        //        System.out.println(solution.ladderLength(beginWord, endWord, Arrays.asList(wordList)));
        System.out.println("cost: " + (Instant.now().getEpochSecond() - start) + " s");
    }


    private static void test1() {
        Solution solution2 = new P127_WordLadder().new Solution();
        String beginWord2 = "hit";
        String endWord2 = "cog";
        //        String[] wordList2 = {"hot", "dot", "dog", "lot", "log"};
        String[] wordList2 = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution2.ladderLength(beginWord2, endWord2, Arrays.asList(wordList2)));
    }


    private static void test2() {
        Solution solution2 = new P127_WordLadder().new Solution();
        String beginWord2 = "a";
        String endWord2 = "c";
        //        String[] wordList2 = {"hot", "dot", "dog", "lot", "log"};
        String[] wordList2 = {"a", "b", "c"};
        System.out.println(solution2.ladderLength(beginWord2, endWord2, Arrays.asList(wordList2)));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //广度优先
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            //1.wordList会多次遍历,然后这里使用set加快查询
            Set<String> wordSets = new HashSet<>(wordList);

            int level = 1;
            if (beginWord.equals(endWord)) {
                return level;
            }
            //不在字典中,则直接退出,无法转化
            if (!wordSets.contains(endWord)) {
                return 0;
            }
            LinkedList<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.addLast(beginWord);
            visited.add(beginWord);
            //2.使用广度优先方法
            while (queue.size() > 0) {
                int levelSize = queue.size();
                //3.由于是一层层的,所以需记录一下层的数量,
                for (int index = 0; index < levelSize; index++) {
                    String poll = queue.poll();
                    char[] chars = poll.toCharArray();
                    //3.由于单词可能会很长,如果按照单词的维度容易超过,因此这里使用字母来;(word.length*26)
                    for (int i = 0; i < chars.length; i++) {
                        char backup = chars[i];
                        for (char j = 'a'; j <= 'z'; j++) {
                            //与原先字母一样,则跳过
                            if (backup == j) {
                                continue;
                            }else {
                                chars[i] = j;
                                String newStr = new String(chars);
                                //不在单词表中,直接跳过
                                if (!wordSets.contains(newStr)) {
                                    continue;
                                }
                                if (newStr.equals(endWord)) {
                                    return level + 1;
                                }
                                //,且不是重复访问,如果重复访问肯定就不是最短路径了
                                if (!visited.contains(newStr)) {
                                    //                                    System.out.println(newStr);
                                    queue.addLast(newStr);
                                    visited.add(newStr);
                                }

                            }

                        }
                        //恢复到上面一层;
                        chars[i] = backup;
                    }
                }
                //上一层单词的遍历已经完成,这相当于到下一层了,则步数添加1个
                level++;
            }
            return 0;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}


