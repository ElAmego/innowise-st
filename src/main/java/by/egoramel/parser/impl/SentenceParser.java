package by.egoramel.parser.impl;

import by.egoramel.composite.Composite;
import by.egoramel.composite.impl.TextComposite;
import by.egoramel.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.egoramel.enums.TextComponentType.LEXEME;

@SuppressWarnings("unused")
public final class SentenceParser extends AbstractParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String LEXEME_REGEX = "\\S+";

    @Override
    public void parse(final String text, final Composite parentComposite) {
        LOGGER.debug("Starting SentenceParser.parse()");
        final Pattern pattern = Pattern.compile(LEXEME_REGEX);
        final Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            final Composite composite = new TextComposite(LEXEME);
            parentComposite.add(composite);

            final Parser nextParser = getNextParser();
            final String lexeme = matcher.group();
            LOGGER.trace("Lexeme '{}' has fond.", lexeme);

            if (nextParser != null) {
                LOGGER.trace("Passing Lexeme to next parser.");
                nextParser.parse(lexeme, composite);
            }
        }
    }
}