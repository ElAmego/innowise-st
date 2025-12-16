package by.egoramel.parser.impl;

import by.egoramel.composite.Composite;
import by.egoramel.composite.TextComponent;
import by.egoramel.composite.impl.CharacterLeaf;
import by.egoramel.composite.impl.TextComposite;
import by.egoramel.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.egoramel.enums.TextComponentType.PUNCTUATION;
import static by.egoramel.enums.TextComponentType.WORD;

@SuppressWarnings("unused")
public final class LexemeParser extends AbstractParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String WORD_WITH_PUNCTUATION_REGEX = "\\p{L}+|\\p{P}+";
    private static final String WORD_REGEX = "\\p{L}+";

    @Override
    public void parse(final String text, final Composite parentComposite) {
        LOGGER.debug("Starting LexemeParser.parse()");
        final Pattern wordWithPunctuationPattern = Pattern.compile(WORD_WITH_PUNCTUATION_REGEX);
        final Matcher wordWithPunctuationMatcher = wordWithPunctuationPattern.matcher(text);

        while (wordWithPunctuationMatcher.find()) {
            final String word = wordWithPunctuationMatcher.group();

            if (word.matches(WORD_REGEX)) {
                LOGGER.trace("Lexeme '{}' identified as WORD", word);
                final Composite composite = new TextComposite(WORD);
                parentComposite.add(composite);

                final Parser nextParser = getNextParser();

                if (nextParser != null) {
                    LOGGER.trace("Passing WORD to next parser.");
                            nextParser.parse(word, composite);
                }
            } else {
                LOGGER.trace("Lexeme '{}' identified as PUNCTUATION", word);
                for (char character : word.toCharArray()) {
                    final TextComponent punctuationLeaf = new CharacterLeaf(PUNCTUATION, character);
                    parentComposite.add(punctuationLeaf);
                }
            }
        }
    }
}