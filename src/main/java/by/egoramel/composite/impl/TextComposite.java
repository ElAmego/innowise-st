package by.egoramel.composite.impl;

import by.egoramel.composite.Composite;
import by.egoramel.composite.Leaf;
import by.egoramel.enums.TextComponentType;

import java.util.ArrayList;
import java.util.List;

public final class TextComposite implements Composite {
    private final TextComponentType textComponentType;
    private final List<Leaf> leafList = new ArrayList<>();

    public TextComposite(final TextComponentType textComponentType) {
        this.textComponentType = textComponentType;
    }

    @Override
    public int count() {
        int result = 0;

        for (final Leaf leaf: leafList) {
            result += leaf.count();
        }

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (final Leaf leaf: leafList) {
            stringBuilder.append(leaf.toString());
        }

        return stringBuilder.toString();
    }

    @Override
    public void addLeaf(final Leaf leaf) {
        leafList.add(leaf);
    }
}