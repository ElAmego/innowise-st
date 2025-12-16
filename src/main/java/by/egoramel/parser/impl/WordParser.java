package by.egoramel.parser.impl;

import by.egoramel.composite.Composite;
import by.egoramel.composite.TextComponent;
import by.egoramel.composite.impl.CharacterLeaf;

import static by.egoramel.enums.TextComponentType.SYMBOL;

public final class WordParser extends AbstractParser {

    @Override
    public void parse(final String text, final Composite parentComposite) {
        final char[] chars = text.toCharArray();

        for (final char character: chars) {
            final TextComponent characterComponent = new CharacterLeaf(SYMBOL, character);
            parentComposite.add(characterComponent);
        }
    }
}