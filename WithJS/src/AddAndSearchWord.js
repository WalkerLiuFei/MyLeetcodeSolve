/**
 * Created by Administrator on 2016/11/30 0030.
 */
/**
 * @constructor
 */
window.onload = function () {
    var wordDic = new WordDictionary();
    wordDic.addWord("adbc");
   console.log( wordDic.search("adb"))

}
var TrieNode = {
    //TrieNode[]
    childs: [],
    count: 0,
    prefix: '',
    addCount: function () {
        this.count++
    },
    setPrefix: function (prefix) {
        this.prefix = prefix
    }
}
var WordDictionary = function () {

};

WordDictionary.prototype = {
    root: Object.create(TrieNode),
    addWord: function (word) {
        var searchNode = this.root;
        for (var level = 0; level < word.length; level++) {
            console.log(searchNode)
            var currentChar = word.charCodeAt(level);
            var node = searchNode.childs[currentChar - 97];
            if (node == undefined) { //如果这个前缀的还是null，那么新建插入一个
                node = Object.create(TrieNode);
                node.prefix =  currentChar;
                searchNode.childs.push(node)
                /*searchNode.childs[currentChar - 97] = Object.create(TrieNode);
                searchNode.childs[currentChar - 97].childs[currentChar - 97].prefix = currentChar;*/
            }
            else
                node.count++;  //子节点不为null ，词频属性加1.....
            console.log(searchNode.childs[currentChar-97])
            searchNode = searchNode.childs[currentChar-97];
        }
    },
    search:　function(word){
        var searchNode = this.root;
        for (var level = 0;level < word.length;level++){
            var currentChar = word.charCodeAt[level];
            if (currentChar == '.'){
                return recursive(word[level,word.length],searchNode,0);
            }
            var node = searchNode.childs[currentChar-97];
            if (node == undefined)
                return false;
            searchNode = node;
        }
        return checkEndNodeAvailable(searchNode)

        //another function which response to act as recursive function
        function recursive(subString,searchNode,currentIndex){
            for (var index = currentIndex; index < substring.length();index++){
                var currentChar = substring.charAt(index);
                if (currentChar == '.'){
                    var searchResult = false;
                    searchNode.childs.forEach(searchResult =  function(element){
                        if (node != undefined && recursive(substring,node,index+1)) //回溯遍历全部26个子节点，如果找到了就返回true
                            return true;
                        return false;
                    })
                    return searchResult;
                }
                var node = searchNode.childs[currentChar-97];
                if (node == undefined)
                    return false;
                searchNode = node;
            }
            return checkEndNodeAvailable(searchNode)
        }
        //检查是否有当前节点为结束的单词......
        function checkEndNodeAvailable(node){
            if (!(node.constructor === TrieNode))
                return false;
            var childCount = 0;
            searchNode.childs.forEach(function(element){
                childCount+=element.count
            })
            return searchNode.count > childCount;
        }
    }
}