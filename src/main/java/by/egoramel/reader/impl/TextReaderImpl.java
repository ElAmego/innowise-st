package by.egoramel.reader.impl;

import by.egoramel.exception.CustomException;
import by.egoramel.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@SuppressWarnings("unused")
public final class TextReaderImpl implements TextReader {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String fileUrl;

    public TextReaderImpl(final String fileUrl) {
        LOGGER.debug("Creating TextReaderImpl with fileUrl: {}.", fileUrl);
        this.fileUrl = fileUrl;
    }

    @Override
    public String readText() throws CustomException {
        LOGGER.info("Starting to read text from file: {}.", fileUrl);
        final Path filePath = Path.of(fileUrl);
        String text;

        try {
            LOGGER.debug("Attempting to read all lines from file.");
            final List<String> allRows = Files.readAllLines(filePath);
            text = mergeRows(allRows);
        } catch (final IOException e) {
            LOGGER.error("IOException occurred while reading file: {}.", fileUrl, e);
            throw new CustomException(e);
        }

        LOGGER.info("Successfully read text from file: {}.", fileUrl);
        return text;
    }

    private String mergeRows(final List<String> allRows) {
        LOGGER.trace("Merging rows into single text.");
        final StringBuilder stringBuilder = new StringBuilder();

        for (final String row: allRows) {
            LOGGER.trace("Appending row.");
            stringBuilder.append(row);
        }

        LOGGER.trace("Merge completed.");
        return stringBuilder.toString();
    }
}