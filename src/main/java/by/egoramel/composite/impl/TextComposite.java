package by.egoramel.composite.impl;

import by.egoramel.composite.Composite;
import by.egoramel.composite.TextComponent;
import by.egoramel.enums.TextComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public final class TextComposite implements Composite {
    private static final Logger LOGGER = LogManager.getLogger();
    private final TextComponentType textComponentType;
    private final List<TextComponent> textComponentList = new ArrayList<>();
    private static final String SPACE = " ";
    private static final String NEW_PARAGRAPH = "\n";

    public TextComposite(final TextComponentType textComponentType) {
        LOGGER.debug("Creating TextComposite with type: {}.", textComponentType);
        this.textComponentType = textComponentType;
    }

    @Override
    public int count() {
        LOGGER.debug("Calling count() for TextComposite of type: {}.", textComponentType);
        int result = 0;

        for (final TextComponent textComponent : textComponentList) {
            LOGGER.trace("Processing component.");
            result += textComponent.count();
        }

        LOGGER.debug("Total count for TextComposite of type {}: {}.", textComponentType, result);
        return result;
    }

    @Override
    public String asString() {
        LOGGER.debug("Calling asString() for TextComposite of type: {}.", textComponentType);
        StringBuilder text = new StringBuilder();

        for (final TextComponent component : textComponentList) {
            text.append(component.asString());

            if (textComponentType == TextComponentType.SENTENCE || textComponentType == TextComponentType.PARAGRAPH) {
                LOGGER.trace("Adding SPACE for component type: {}.", textComponentType);
                text.append(SPACE);
            }

            if (textComponentType == TextComponentType.TEXT) {
                LOGGER.trace("Adding NEW_PARAGRAPH for component type: TEXT.");
                text.append(NEW_PARAGRAPH);
            }
        }

        LOGGER.debug("Generated string for TextComposite of type {}: {}.", textComponentType, text.toString());
        return text.toString();
    }

    @Override
    public void add(final TextComponent textComponent) {
        LOGGER.debug("Adding component to TextComposite of type: {}", textComponentType);
        textComponentList.add(textComponent);
    }

    @Override
    public List<TextComponent> getChildren() {
        LOGGER.debug("Calling getChildren() for TextComposite of type: {}.", textComponentType);
        return List.copyOf(textComponentList);
    }
}