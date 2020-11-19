package com.bridge.resilience.bridgeresilience.extra;

import org.springframework.stereotype.Service;

@Service("trie")
public class Trie {

    private Node root;
    //Initilize your data structure here.
    public Trie(){
        root = new Node('\0');
    }
    //Inserts a word into the trie.
    public void insert(String word){
        Node curr = root;
        for (int i=0;i < word.length();i++){
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Node(c);
            curr = curr.children[c - 'a'];
        }
        curr.isword = true;
    }
    //return if the word is in the trie.
    public boolean search(String word){
        Node node = getNode(word);
        return  node != null && node.isword;
    }
    //returns if there is any word in the trie that starts with the given prefix.
    public boolean startWith(String prefix){
        return  getNode(prefix) != null;
    }
    private Node getNode(String word){
        Node curr = root;
        for (int i=0;i < word.length();i++){
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) return null;
            curr = curr.children[c - 'a'];
        }
        return curr;
    }
    class Node{
        public char c;
        public  boolean isword;
        public Node[] children;
        public Node(char c){
            this.c = c;
            isword = false;
            children =new Node[26];
        }
    }
}
