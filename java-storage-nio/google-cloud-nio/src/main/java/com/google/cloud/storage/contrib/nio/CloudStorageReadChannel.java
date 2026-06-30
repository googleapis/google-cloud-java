/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage.contrib.nio;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.StorageException;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.NoSuchFileException;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Cloud Storage read channel.
 *
 * @see CloudStorageWriteChannel
 */
@ThreadSafe
final class CloudStorageReadChannel implements SeekableByteChannel {

  private final Storage gcsStorage;
  private final BlobId file;
  // max # of times we may reopen the file
  @VisibleForTesting final int maxChannelReopens;
  // max # of times we may retry a GCS operation
  final int maxRetries;
  // open options, we keep them around for reopens.
  final BlobSourceOption[] blobSourceOptions;
  final CloudStorageConfiguration config;
  private ReadChannel channel;
  private long position;
  private long size;
  // generation at time of first open, to make sure reopens don't give us a different version of the
  // file.
  // It can be null if not implemented, in which case we don't check.
  private Long generation;

  /**
   * @param maxChannelReopens max number of times to try re-opening the channel if it closes on us
   *     unexpectedly.
   * @param config configuration for what to retry on.
   * @param blobSourceOptions BlobSourceOption.userProject if you want to pay the charges (required
   *     for requester-pays buckets). Note: Buckets that have Requester Pays disabled still accept
   *     requests that include a billing project, and charges are applied to the billing project
   *     supplied in the request. Consider any billing implications prior to including a billing
   *     project in all of your requests. Source:
   *     https://cloud.google.com/storage/docs/requester-pays
   * @param userProject: the project you want billed (set this for requester-pays buckets). Leave
   *     empty otherwise.
   */
  @CheckReturnValue
  @SuppressWarnings("resource")
  static CloudStorageReadChannel create(
      Storage gcsStorage,
      BlobId file,
      long position,
      int maxChannelReopens,
      final CloudStorageConfiguration config,
      @Nullable String userProject,
      BlobSourceOption... blobSourceOptions)
      throws IOException {
    return new CloudStorageReadChannel(
        gcsStorage, file, position, maxChannelReopens, config, userProject, blobSourceOptions);
  }

  private CloudStorageReadChannel(
      Storage gcsStorage,
      BlobId file,
      long position,
      int maxChannelReopens,
      final CloudStorageConfiguration config,
      @Nullable String userProject,
      BlobSourceOption... blobSourceOptions)
      throws IOException {
    this.gcsStorage = gcsStorage;
    this.file = file;
    this.position = position;
    this.maxChannelReopens = maxChannelReopens;
    this.maxRetries = Math.max(3, maxChannelReopens);
    this.config = config;
    // get the generation, enshrine that in our options
    fetchSize(gcsStorage, userProject, file);
    List<BlobSourceOption> options = Lists.newArrayList(blobSourceOptions);
    if (null != generation) {
      options.add(Storage.BlobSourceOption.generationMatch(generation));
    }
    if (!Strings.isNullOrEmpty(userProject)) {
      options.add(BlobSourceOption.userProject(userProject));
    }
    this.blobSourceOptions = options.toArray(new BlobSourceOption[options.size()]);

    // innerOpen checks that it sees the same generation as fetchSize did,
    // which ensure the file hasn't changed.
    innerOpen();
  }

  private void innerOpen() throws IOException {
    this.channel = gcsStorage.reader(file, blobSourceOptions);
    if (position > 0) {
      channel.seek(position);
    }
  }

  @Override
  public boolean isOpen() {
    synchronized (this) {
      return channel.isOpen();
    }
  }

  @Override
  public void close() throws IOException {
    synchronized (this) {
      channel.close();
    }
  }

  @Override
  public int read(ByteBuffer dst) throws IOException {
    synchronized (this) {
      checkOpen();
      int amt;
      final CloudStorageRetryHandler retryHandler =
          new CloudStorageRetryHandler(maxRetries, maxChannelReopens, config);
      dst.mark();
      while (true) {
        try {
          dst.reset();
          amt = channel.read(dst);
          break;
        } catch (StorageException exs) {
          // Will rethrow a StorageException if all retries/reopens are exhausted
          handleStorageException(exs, retryHandler);
        }
      }
      if (amt > 0) {
        position += amt;
        // This can only happen if the file changed under us and we didn't notice.
        if (position > size) {
          size = position;
        }
      }
      return amt;
    }
  }

  @Override
  public long size() throws IOException {
    synchronized (this) {
      checkOpen();
      return size;
    }
  }

  @Override
  public long position() throws IOException {
    synchronized (this) {
      checkOpen();
      return position;
    }
  }

  @Override
  public SeekableByteChannel position(long newPosition) throws IOException {
    checkArgument(newPosition >= 0);
    synchronized (this) {
      checkOpen();
      if (newPosition == position) {
        return this;
      }
      channel.seek(newPosition);
      position = newPosition;
      return this;
    }
  }

  @Override
  public int write(ByteBuffer src) throws IOException {
    throw new NonWritableChannelException();
  }

  @Override
  public SeekableByteChannel truncate(long size) throws IOException {
    throw new NonWritableChannelException();
  }

  private void checkOpen() throws ClosedChannelException {
    if (!channel.isOpen()) {
      throw new ClosedChannelException();
    }
  }

  private long fetchSize(Storage gcsStorage, @Nullable String userProject, BlobId file)
      throws IOException {
    final CloudStorageRetryHandler retryHandler =
        new CloudStorageRetryHandler(maxRetries, maxChannelReopens, config);

    while (true) {
      try {
        BlobInfo blobInfo;
        if (Strings.isNullOrEmpty(userProject)) {
          blobInfo =
              gcsStorage.get(
                  file,
                  Storage.BlobGetOption.fields(
                      Storage.BlobField.GENERATION, Storage.BlobField.SIZE));
        } else {
          blobInfo =
              gcsStorage.get(
                  file,
                  Storage.BlobGetOption.fields(
                      Storage.BlobField.GENERATION, Storage.BlobField.SIZE),
                  Storage.BlobGetOption.userProject(userProject));
        }
        if (blobInfo == null) {
          throw new NoSuchFileException(
              String.format("gs://%s/%s", file.getBucket(), file.getName()));
        }
        this.generation = blobInfo.getGeneration();
        this.size = blobInfo.getSize();
        return this.size;
      } catch (StorageException exs) {
        // Will rethrow a StorageException if all retries/reopens are exhausted
        retryHandler.handleStorageException(exs);
        // there's nothing to reopen yet, but retry even for a reopenable error.
      }
    }
  }

  /**
   * Handles a StorageException by reopening the channel or sleeping for a retry attempt if retry
   * count is not exhausted. Throws a StorageException if all reopens/retries are exhausted, or if
   * the StorageException is not reopenable/retryable.
   *
   * @param exs StorageException thrown by a GCS operation
   * @param retryHandler Keeps track of reopens/retries performed so far on this operation
   * @throws StorageException if all reopens/retries are exhausted, or if exs is not
   *     reopenable/retryable
   * @throws IOException if a reopen operation fails
   */
  private void handleStorageException(
      final StorageException exs, final CloudStorageRetryHandler retryHandler) throws IOException {
    boolean shouldReopen = retryHandler.handleStorageException(exs);
    if (shouldReopen) {
      // these errors aren't marked as retryable since the channel is closed;
      // but here at this higher level we can retry them.
      innerOpen();
    }
  }
}
