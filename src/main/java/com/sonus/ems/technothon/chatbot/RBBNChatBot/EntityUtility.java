package com.sonus.ems.technothon.chatbot.RBBNChatBot;

public class EntityUtility {
    static final int ALPHABET_SIZE = 26;
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        boolean isEndOfWord;
        String entity = "";
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };

    public static TrieNode root;

    public static void insert(String key,String entity)
    {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
        pCrawl.entity = entity;
    }

    public  TrieNode search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return null;

            pCrawl = pCrawl.children[index];
        }

        return pCrawl;
    }

    public void EntityUtility()
    {
        String keys[] = {"ems","sbc","rsm","psx"};
        String entities[] = {"Device","Device","Device","Device"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i],entities[i]);
    }
}
