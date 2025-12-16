package by.egoramel.composite.impl;

import by.egoramel.composite.Composite;
import by.egoramel.composite.TextComponent;
import by.egoramel.enums.TextComponentType;

import java.util.ArrayList;
import java.util.List;

public final class TextComposite implements Composite {
    private final TextComponentType textComponentType;
    private final List<TextComponent> textComponentList = new ArrayList<>();
    private static final String SPACE = " ";
    private static final String NEW_PARAGRAPH = "\n";

    public TextComposite(final TextComponentType textComponentType) {
        this.textComponentType = textComponentType;
    }

    @Override
    public int count() {
        int result = 0;

        for (final TextComponent textComponent : textComponentList) {
            result += textComponent.count();
        }

        return result;
    }

    @Override
    public String asString() {
        StringBuilder text = new StringBuilder();

        for (final TextComponent component : textComponentList) {
            text.append(component.asString());

            if (textComponentType == TextComponentType.SENTENCE || textComponentType == TextComponentType.PARAGRAPH) {
                text.append(SPACE);
            }

            if (textComponentType == TextComponentType.TEXT) {
                text.append(NEW_PARAGRAPH);
            }
        }

        return text.toString();
    }

    @Override
    public void add(final TextComponent textComponent) {
        textComponentList.add(textComponent);
    }

    @Override
    public List<TextComponent> getChildren() {
        return List.copyOf(textComponentList);
    }
}