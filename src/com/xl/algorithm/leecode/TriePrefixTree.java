package com.xl.algorithm.leecode;

import sun.dc.pr.PRError;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * https://github.com/SacredParadise/leetcode/blob/master/problems/208.implement-trie-prefix-tree.md
 *
 */
public class TriePrefixTree {

    public static final int LETTER_NUM = 26;

    TrieNode root;

    public TriePrefixTree() {
        root = new TrieNode();
    }

    class TrieNode {
        private int num; //由根至该节点组成的字符串模式出现的次数

        private char val; //存的字符

        private TrieNode[] children;

        private boolean isEnd; //是否叶子节点

        TrieNode() {
            num = 1;
            children = new TrieNode[LETTER_NUM];
        }
    }

    /**
     * 插入元素
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        char[] letters = word.toCharArray();
        TrieNode node = root;
        for (char letter : letters) {
            int pos = letter - 'a';
            TrieNode nodeT = node.children[pos];
            if (nodeT == null) {
                nodeT = new TrieNode();
                nodeT.val = letter;
                node.children[pos] = nodeT;
            } else {
                nodeT.num++;
            }

            node = nodeT;
        }

        node.isEnd = true;
    }

    /**
     * 判断单词是否存在
     * @param word
     * @return
     */
    public boolean has(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        char[] letters = word.toCharArray();
        TrieNode node = root;
        for (char letter : letters) {
            int pos = letter - 'a';
            TrieNode nodeT = node.children[pos];
            if (nodeT == null) {
                return false;
            }

            node = nodeT;
        }

        return node.isEnd;
    }

    /**
     * 找出特定前缀的单词
     * TODO 未完全实现
     * @param prefix
     * @return 以prefix为前缀的所有单词
     */
    public String[] prefix(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return new String[0];
        }

        char[] letters = prefix.toCharArray();
        TrieNode node = root;

        //找到prefix所在TriNode节点
        for (char letter : letters) {
            int pos = letter - 'a';
            TrieNode nodeT = node.children[pos];
            if (nodeT == null) {
                return new String[0];
            }

            node = nodeT;
        }

        if (node.isEnd) {
            return new String[] {prefix};
        }

        List<String> results = new LinkedList<>();
        results.add(prefix);


        //可采用递归方式简单
        Stack<TrieNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TrieNode tempNode = stack.pop();
            if (tempNode.isEnd) {
                results.add(prefix + tempNode.val);
            }
            for (TrieNode trieNode : tempNode.children) {

            }
        }

        //找出所有前缀的单词
        while (!node.isEnd && node.children.length > 0) {
            for (TrieNode trieNode : node.children) {
                if (trieNode.isEnd) {
                    results.add(prefix + trieNode.val);
                }

//                for (TrieNode )

            }
        }

        return null;
    }

    private void preTraverse(TrieNode node) {
        if (node != null) {
            System.out.print(node.val);
        }

        for (TrieNode trieNode : node.children) {
            if (trieNode == null) {
                continue;
            }
            preTraverse(trieNode);

            if (trieNode.isEnd) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        TriePrefixTree tree = new TriePrefixTree();
        tree.insert("apple");
        System.out.println(tree.has("apple"));
        System.out.println(tree.has("app"));
        tree.insert("orange");
        tree.insert("banana");
        tree.insert("monkey");
        tree.insert("giraffe");
        tree.insert("tortoise");
        tree.insert("horse");
        tree.insert("elephant");
        tree.insert("oce");
        tree.insert("land");

        tree.preTraverse(tree.root);

    }

}
