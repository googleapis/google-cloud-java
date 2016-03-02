package com.google.cloud.storage.contrib.nio;

import java.nio.file.InvalidPathException;

/** Exception thrown when erroneously trying to operate on a path with a trailing slash. */
public final class CloudStoragePseudoDirectoryException extends InvalidPathException {
  CloudStoragePseudoDirectoryException(CloudStoragePath path) {
    super(path.toString(), "Can't perform I/O on pseudo-directories (trailing slash)");
  }
}
