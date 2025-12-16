package by.egoramel.composite;

import java.util.List;

public interface Composite extends TextComponent {
    void add(final TextComponent textComponent);
    List<TextComponent> getChildren();
}