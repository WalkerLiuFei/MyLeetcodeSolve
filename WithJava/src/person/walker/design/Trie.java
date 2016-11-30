package person.walker.design;


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

public class Trie {
    private TrieNode root;

    public Trie() {
         root = new TrieNode();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        TrieNode searchNode = root;
        for (int level = 0;level < word.length();level++){
            char currentChar = word.charAt(level);
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



    public boolean startsWith(String prefix) {
        TrieNode searchNode = root;
        for (int level = 0;level < prefix.length();level++){
            char currentChar = prefix.charAt(level);
            TrieNode node = searchNode.childs[currentChar-'a'];
            if (node == null)
                return false;
            searchNode = node;
        }
        return true;
    }
}