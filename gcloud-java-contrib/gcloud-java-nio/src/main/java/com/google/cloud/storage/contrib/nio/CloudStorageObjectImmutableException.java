package com.google.cloud.storage.contrib.nio;

/**
 * Exception reminding user that Cloud Storage objects can't be mutated.
 */
public final class CloudStorageObjectImmutableException extends UnsupportedOperationException {

  CloudStorageObjectImmutableException() {
    super("Cloud Storage objects are immutable.");
  }
}
