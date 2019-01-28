package com.sonus.ems.technothon.chatbot.RBBNChatBot;

import opennlp.tools.sentdetect.*;
import opennlp.tools.tokenize.*;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.namefind.*;
import opennlp.tools.util.*;
import java.io.*;
public class NLPTest {
    public static void findName(String sentence[]){
        try {
            InputStream is = new FileInputStream("en-ner-person.bin");

            TokenNameFinderModel model = new TokenNameFinderModel(is);
            NameFinderME nameFinder = new NameFinderME(model);

            Span nameSpans[] = nameFinder.find(sentence);

            for (Span s : nameSpans)
                System.out.println(s.toString());
            is.close();
        }catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }
    public static String[] Tokenize(String sentance){
        String tokens[]=null;
        try {
            InputStream is = new FileInputStream("en-token.bin");
            TokenizerModel model = new TokenizerModel(is);

            Tokenizer tokenizer = new TokenizerME(model);

            tokens = tokenizer.tokenize(sentance);

          //  for (String a : tokens)
            //    System.out.println(a);

            is.close();
        }catch (InvalidFormatException exp)
        {
            exp.printStackTrace();
        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }
        return tokens;
    }
    public static void convertParagraphToSentence(String paragraph)
    {
        try {
            InputStream is = new FileInputStream("en-sent.bin");
            SentenceModel model = new SentenceModel(is);
            SentenceDetectorME sdetector = new SentenceDetectorME(model);

            String sentences[] = sdetector.sentDetect(paragraph);

            for (int i = 0; i < sentences.length; i++)
                System.out.println(sentences[i]);
            is.close();
        }catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        String paragraph = "I'm Upen. i'm from dhanbad.";
        convertParagraphToSentence(paragraph);
        String tokens[]=Tokenize(paragraph);
        findName(tokens);
    }
}
