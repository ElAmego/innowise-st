package by.egoramel.parser.impl;

import by.egoramel.composite.Composite;
import by.egoramel.composite.TextComponent;
import by.egoramel.composite.impl.CharacterLeaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.egoramel.enums.TextComponentType.SYMBOL;

@SuppressWarnings("unused")
public final class WordParser extends AbstractParser {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void parse(final String text, final Composite parentComposite) {
        LOGGER.debug("Starting WordParser.parse()");
        final char[] chars = text.toCharArray();

        for (final char character: chars) {
            LOGGER.trace("Character '{}' has fond.", character);
            final TextComponent characterComponent = new CharacterLeaf(SYMBOL, character);
            parentComposite.add(characterComponent);
        }
    }
}