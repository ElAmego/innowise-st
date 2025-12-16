package by.egoramel.parser.impl;

import by.egoramel.composite.Composite;
import by.egoramel.composite.TextComponent;
import by.egoramel.composite.impl.CharacterLeaf;
import by.egoramel.composite.impl.TextComposite;
import by.egoramel.parser.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.egoramel.enums.TextComponentType.PUNCTUATION;
import static by.egoramel.enums.TextComponentType.WORD;

public final class LexemeParser extends AbstractParser {
    private static final String WORD_WITH_PUNCTUATION_REGEX = "\\p{L}+|\\p{P}+";
    private static final String WORD_REGEX = "\\p{L}+";

    @Override
    public void parse(final String text, final Composite parentComposite) {
        final Pattern wordWithPunctuationPattern = Pattern.compile(WORD_WITH_PUNCTUATION_REGEX);
        final Matcher wordWithPunctuationMatcher = wordWithPunctuationPattern.matcher(text);

        while (wordWithPunctuationMatcher.find()) {
            final String word = wordWithPunctuationMatcher.group();

            if (word.matches(WORD_REGEX)) {
                final Composite composite = new TextComposite(WORD);
                parentComposite.add(composite);

                final Parser nextParser = getNextParser();

                if (nextParser != null) {
                    nextParser.parse(word, composite);
                }
            } else {
                for (char character : word.toCharArray()) {
                    final TextComponent punctuationLeaf = new CharacterLeaf(PUNCTUATION, character);
                    parentComposite.add(punctuationLeaf);
                }
            }
        }
    }
}