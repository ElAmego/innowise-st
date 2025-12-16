package by.egoramel.parser.impl;

import by.egoramel.composite.Composite;
import by.egoramel.composite.impl.TextComposite;
import by.egoramel.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.egoramel.enums.TextComponentType.PARAGRAPH;

@SuppressWarnings("unused")
public final class TextParser extends AbstractParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PARAGRAPH_REGEX = "\\S.*?(?=\\s{5,}\\S|$)";

    @Override
    public void parse(final String text, final Composite parentComposite) {
        LOGGER.debug("Starting TextParser.parse()");
        final Pattern pattern = Pattern.compile(PARAGRAPH_REGEX);
        final Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            final Composite composite = new TextComposite(PARAGRAPH);
            parentComposite.add(composite);

            final Parser nextParser = getNextParser();
            final String paragraph = matcher.group();
            LOGGER.trace("Paragraph '{}' has fond.", paragraph);

            if (nextParser != null) {
                LOGGER.trace("Passing Paragraph to next parser.");
                nextParser.parse(paragraph, composite);
            }
        }
    }
}