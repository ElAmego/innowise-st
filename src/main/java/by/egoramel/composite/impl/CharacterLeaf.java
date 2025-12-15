package by.egoramel.composite.impl;

import by.egoramel.composite.Leaf;
import by.egoramel.enums.TextComponentType;

public final class CharacterLeaf implements Leaf {
    private static final int characterLength = 1;
    private final TextComponentType textComponentType;
    private final char character;

    public CharacterLeaf(final TextComponentType textComponentType, final char character) {
        this.textComponentType = textComponentType;
        this.character = character;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }

    @Override
    public int count() {
        return characterLength;
    }
}