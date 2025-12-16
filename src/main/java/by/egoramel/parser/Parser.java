package by.egoramel.parser;

import by.egoramel.composite.Composite;

public interface Parser {
    void setNextParser(final Parser nextParser);
    Parser getNextParser();
    void parse(final String text, final Composite parentComposite);
}