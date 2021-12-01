package io.hacksy.aoc.v2021.util;

import io.vavr.collection.List;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtil {
    public static File getResourceFile(String path) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try {
            return new File(loader.getResource(path).getFile());
        } catch (NullPointerException npe) {
            throw new FileUtilException(String.format("Unable to load resource: %s", path));
        }
    }

    public static List<Integer> fileToList(File file) {
        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
            return io.vavr.collection.Stream.ofAll(stream).map(Integer::parseInt).toList();
        } catch (Exception e) {
            return List.empty();
        }
    }

    public static List<String> fileToStringList(File file) {
        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
            return io.vavr.collection.Stream.ofAll(stream).toList();
        } catch (Exception e) {
            return List.empty();
        }
    }

    static class FileUtilException extends RuntimeException {
        FileUtilException(String msg) {
            super(msg);
        }
    }
}
