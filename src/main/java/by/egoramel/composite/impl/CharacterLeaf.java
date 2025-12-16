package by.egoramel.composite.impl;

import by.egoramel.composite.TextComponent;
import by.egoramel.enums.TextComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CharacterLeaf implements TextComponent {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int characterLength = 1;
    private final TextComponentType textComponentType;
    private final char character;

    public CharacterLeaf(final TextComponentType textComponentType, final char character) {
        LOGGER.debug("Creating CharacterLeaf with type: {} and character: '{}'.", textComponentType, character);
        this.textComponentType = textComponentType;
        this.character = character;
    }

    @Override
    public String asString() {
        LOGGER.debug("Calling asString() for character: '{}'.", character);
        return String.valueOf(character);
    }

    @Override
    public int count() {
        LOGGER.debug("Calling count() for character: '{}'.", character);
        return characterLength;
    }
}