package by.egoramel;

import by.egoramel.exception.CustomException;
import by.egoramel.reader.TextReader;
import by.egoramel.reader.impl.TextReaderImpl;

public class Main {
    public static void main(String[] args) throws CustomException {
        final String path = "data/example.txt";
        final TextReader textReader = new TextReaderImpl(path);
        System.out.println(textReader.readText());

        // FileReader -> Composite -> TextComponent parsers -> Chain Of Responsibility
    }
}