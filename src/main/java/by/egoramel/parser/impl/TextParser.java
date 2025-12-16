package by.egoramel.parser.impl;

import by.egoramel.composite.Composite;
import by.egoramel.composite.impl.TextComposite;
import by.egoramel.parser.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.egoramel.enums.TextComponentType.PARAGRAPH;

public final class TextParser extends AbstractParser {
    private static final String PARAGRAPH_REGEX = "\\S.*?(?=\\s{5,}\\S|$)";

    @Override
    public void parse(final String text, final Composite parentComposite) {
        final Pattern pattern = Pattern.compile(PARAGRAPH_REGEX);
        final Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            final Composite composite = new TextComposite(PARAGRAPH);
            parentComposite.add(composite);

            final Parser nextParser = getNextParser();
            final String paragraph = matcher.group();

            if (nextParser != null) {
                nextParser.parse(paragraph, composite);
            }
        }
    }
}