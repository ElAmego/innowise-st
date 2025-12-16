package by.egoramel.composite.impl;

import by.egoramel.composite.TextComponent;
import by.egoramel.enums.TextComponentType;

public final class CharacterLeaf implements TextComponent {
    private static final int characterLength = 1;
    private final TextComponentType textComponentType;
    private final char character;

    public CharacterLeaf(final TextComponentType textComponentType, final char character) {
        this.textComponentType = textComponentType;
        this.character = character;
    }

    @Override
    public String asString() {
        return String.valueOf(character);
    }

    @Override
    public int count() {
        return characterLength;
    }
}