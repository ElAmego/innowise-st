package by.egoramel.parser.impl;

import by.egoramel.composite.Composite;
import by.egoramel.composite.impl.TextComposite;
import by.egoramel.parser.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.egoramel.enums.TextComponentType.SENTENCE;

public final class ParagraphParser extends AbstractParser {
    private static final String SENTENCE_REGEX = "[^.!?]*[.!?]";

    @Override
    public void parse(final String text, final Composite parentComposite) {
        final Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        final Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            final Composite composite = new TextComposite(SENTENCE);
            parentComposite.add(composite);

            final Parser nextParser = getNextParser();
            final String sentence = matcher.group();

            if (nextParser != null) {
                nextParser.parse(sentence, composite);
            }
        }
    }
}