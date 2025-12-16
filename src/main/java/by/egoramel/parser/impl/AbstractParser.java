package by.egoramel.parser.impl;

import by.egoramel.parser.Parser;

public abstract class AbstractParser implements Parser {
    private Parser nextParser;

    @Override
    public void setNextParser(final Parser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Parser getNextParser() {
        return nextParser;
    }
}