package by.egoramel.parser.impl;

import by.egoramel.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private Parser nextParser;

    @Override
    public void setNextParser(final Parser nextParser) {
        LOGGER.debug("Setting next parser.");
        this.nextParser = nextParser;
    }

    @Override
    public Parser getNextParser() {
        LOGGER.trace("Getting next parser.");
        return nextParser;
    }
}