package person.walker.backtracking;

import org.junit.Test;

/**
 * reference to Trie...dictionary tree
 */
public class WordDictionary {
    class TrieNode{
        TrieNode[] childs = new TrieNode[26]; // a-z
        int count; //frequence;
        char prefix; //当前节点的字符前缀
        public TrieNode(char prefix){
            this.prefix = prefix;
            count = 1;
        }
        public TrieNode(){}
        public void addCount(){
            this.count++;
        }
        public void setPrefix(char prefix){
            this.prefix = prefix;
        }
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode searchNode = root;
        for (int level = 0;level < word.length();level++){
            char currentChar = word.charAt(level);
            TrieNode node = searchNode.childs[currentChar-'a'];
            if (searchNode.childs[currentChar-'a'] == null)      //如果这个前缀的还是null，那么新建插入一个
                searchNode.childs[currentChar-'a'] = new TrieNode(currentChar);
            else
                node.count++;  //子节点不为null ，词频属性加1.....
            searchNode = searchNode.childs[currentChar-'a'];
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode searchNode = root;
        for (int level = 0;level < word.length();level++){
            char currentChar = word.charAt(level);
            if (currentChar == '.'){
                return recursive(word.substring(level,word.length()),searchNode,0);
            }
            TrieNode node = searchNode.childs[currentChar-'a'];
            if (node == null)
                return false;
            searchNode = node;
        }
        int childCount = 0;
        for (TrieNode trieNode : searchNode.childs){
            if (trieNode == null)
                continue;
            childCount += trieNode.count;
        }
        return searchNode.count > childCount;
    }

    private boolean recursive(String substring, TrieNode searchNode, int currentIndex) {
        for (int index = currentIndex; index < substring.length();index++){
            char currentChar = substring.charAt(index);
            if (currentChar == '.'){
                for (TrieNode node : searchNode.childs){
                    if (node == null)
                        continue;
                    if (recursive(substring,node,index+1)) //回溯遍历全部26个子节点，如果找到了就返回true
                        return true;
                }
                return false;
            }
            TrieNode node = searchNode.childs[currentChar-'a'];
            if (node == null)
                return false;
            searchNode = node;
        }
        int childCount = 0;
        for (TrieNode trieNode : searchNode.childs){
            if (trieNode == null)
                continue;
            childCount += trieNode.count;
        }
        return searchNode.count > childCount;
    }

}


