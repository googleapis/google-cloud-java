
/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.gcloud.storage.Blob.BlobSourceOption.convert;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.storage.Storage.BlobTargetOption;
import com.google.gcloud.storage.Storage.CopyRequest;
import com.google.gcloud.storage.Storage.SignUrlOption;

import java.net.URL;
import java.util.Objects;


/**
 * A Google cloud storage object.
 */
public final class Blob {

  private final Storage storage;
  private BlobInfo info;

  public static class BlobSourceOption extends Option {

    private static final long serialVersionUID = 214616862061934846L;

    private BlobSourceOption(StorageRpc.Option rpcOption) {
      super(rpcOption, null);
    }

    private Storage.BlobSourceOption convert(BlobInfo blobInfo) {
      switch (rpcOption()) {
        case IF_GENERATION_MATCH:
          return Storage.BlobSourceOption.generationMatch(blobInfo.generation());
        case IF_GENERATION_NOT_MATCH:
          return Storage.BlobSourceOption.generationNotMatch(blobInfo.generation());
        case IF_METAGENERATION_MATCH:
          return Storage.BlobSourceOption.metagenerationMatch(blobInfo.metageneration());
        case IF_METAGENERATION_NOT_MATCH:
          return Storage.BlobSourceOption.metagenerationNotMatch(blobInfo.metageneration());
        default:
          throw new AssertionError("Unexpected enum value");
      }
    }

    public static BlobSourceOption generationMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_MATCH);
    }

    public static BlobSourceOption generationNotMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_NOT_MATCH);
    }

    public static BlobSourceOption metagenerationMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH);
    }

    public static BlobSourceOption metagenerationNotMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH);
    }

    static Storage.BlobSourceOption[] convert(BlobInfo blobInfo, BlobSourceOption... options) {
      Storage.BlobSourceOption[] convertedOptions = new Storage.BlobSourceOption[options.length];
      int index = 0;
      for (BlobSourceOption option : options) {
        convertedOptions[index++] = option.convert(blobInfo);
      }
      return convertedOptions;
    }
  }

  public Blob(Storage storage, BlobInfo info) {
    this.storage = checkNotNull(storage);
    this.info = checkNotNull(info);
  }

  public BlobInfo info() {
    return info;
  }

  /**
   * Returns true if this blob exists.
   *
   * @throws StorageException upon failure
   */
  public boolean exists() {
    return storage.get(info.bucket(), info.name()) != null;
  }

  /**
   * Returns the blob's content.
   *
   * @throws StorageException upon failure
   */
  public byte[] content(Storage.BlobSourceOption... options) {
    return storage.readAllBytes(info.bucket(), info.name(), options);
  }

  /**
   * Updates the blob's information. Bucket or blob's name cannot be changed by this method. If you
   * want to rename the blob or move it to a different bucket use the {@link #copyTo} and
   * {@link #delete} operations.
   *
   * @throws StorageException upon failure
   */
  public void update(BlobInfo blobInfo, BlobTargetOption... options) {
    checkArgument(Objects.equals(blobInfo.bucket(), info.bucket()), "Bucket name must match");
    checkArgument(Objects.equals(blobInfo.name(), info.name()), "Blob name must match");
    info = storage.update(blobInfo, options);
  }

  /**
   * Deletes this blob.
   *
   * @return true if bucket was deleted
   * @throws StorageException upon failure
   */
  public boolean delete(BlobSourceOption... options) {
    return storage.delete(info.bucket(), info.name(), convert(info, options));
  }

  /**
   * Send a copy request.
   *
   * @return the copied blob.
   * @throws StorageException upon failure
   */
  public Blob copyTo(BlobInfo target, BlobSourceOption... options) {
    return copyTo(target, ImmutableList.copyOf(options), ImmutableList.<BlobTargetOption>of());
  }

  /**
   * Send a copy request.
   *
   * @return the copied blob.
   * @throws StorageException upon failure
   */
  public Blob copyTo(BlobInfo target, Iterable<BlobSourceOption> sourceOptions,
      Iterable<BlobTargetOption> targetOptions) {
    CopyRequest copyRequest =
        CopyRequest.builder().source(info.bucket(), info.name())
            .sourceOptions(convert(info, Iterables.toArray(sourceOptions, BlobSourceOption.class)))
            .target(target).targetOptions(targetOptions).build();
    return new Blob(storage, storage.copy(copyRequest));
  }

  /**
   * Returns a channel for reading this blob's content.
   *
   * @throws StorageException upon failure
   */
  public BlobReadChannel reader(BlobSourceOption... options) {
    return storage.reader(info.bucket(), info.name(), convert(info, options));
  }

  /**
   * Returns a channel for writing to this blob.
   *
   * @throws StorageException upon failure
   */
  public BlobWriteChannel writer(BlobTargetOption... options) {
    return storage.writer(info, options);
  }

  /**
   * Generates a signed URL for this blob. If you want to allow access to for a fixed amount of time
   * for this blob, you can use this method to generate a URL that is only valid within a certain
   * time period. This is particularly useful if you don't want publicly accessible blobs, but don't
   * want to require users to explicitly log in.
   *
   * @param expirationTimeInSeconds the signed URL expiration (using epoch time)
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed-URLs</a>
   */
  public URL signUrl(long expirationTimeInSeconds, SignUrlOption... options) {
    return storage.signUrl(info, expirationTimeInSeconds, options);
  }

  public Storage storage() {
    return storage;
  }
}
