package by.egoramel.reader.impl;

import by.egoramel.exception.CustomException;
import by.egoramel.reader.TextReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class TextReaderImpl implements TextReader {
    private final String fileUrl;

    public TextReaderImpl(final String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String readText() throws CustomException {
        final Path filePath = Path.of(fileUrl);
        String text;

        try {
            final List<String> allRows = Files.readAllLines(filePath);
            text = mergeRows(allRows);
        } catch (final IOException e) {
            throw new CustomException(e);
        }

        return text;
    }

    private String mergeRows(final List<String> allRows) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final String row: allRows) {
            stringBuilder.append(row);
        }

        return stringBuilder.toString();
    }
}