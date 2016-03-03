package com.google.cloud.storage.contrib.nio;

/**
 * Exception thrown to indicate we don't support a mutation of a cloud storage object.
 */
public final class CloudStorageObjectImmutableException extends UnsupportedOperationException {

  CloudStorageObjectImmutableException() {
    super("Cloud Storage objects are immutable.");
  }
}
