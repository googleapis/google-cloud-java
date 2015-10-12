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

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.storage.Storage.BlobTargetOption;
import com.google.gcloud.storage.Storage.CopyRequest;
import com.google.gcloud.storage.Storage.SignUrlOption;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A Google cloud storage object.
 *
 * <p>
 * Objects of this class are immutable. Operations that modify the blob like {@link #update} and
 * {@link #copyTo} return a new object. To get a {@code Blob} object with the most recent
 * information use {@link #reload}.
 * </p>
 */
public final class Blob {

  private final Storage storage;
  private final BlobInfo info;

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

  /**
   * Constructs a {@code Blob} object for the provided {@code BlobInfo}. The storage service is used
   * to issue requests.
   * 
   * @param storage the storage service used for issuing requests
   * @param info blob's info
   */
  public Blob(Storage storage, BlobInfo info) {
    this.storage = checkNotNull(storage);
    this.info = checkNotNull(info);
  }

  /**
   * Constructs a {@code Blob} object for the provided bucket and blob names. The storage service is
   * used to issue requests.
   * 
   * @param storage the storage service used for issuing requests
   * @param bucket bucket's name
   * @param blob blob's name
   */
  public Blob(Storage storage, String bucket, String blob) {
    this.storage = checkNotNull(storage);
    this.info = BlobInfo.of(checkNotNull(bucket), checkNotNull(blob));
  }

  /**
   * Returns the blob's information.
   */
  public BlobInfo info() {
    return info;
  }

  /**
   * Checks if this blob exists.
   *
   * @return true if this blob exists, false otherwise
   * @throws StorageException upon failure
   */
  public boolean exists() {
    return storage.get(info.bucket(), info.name()) != null;
  }

  /**
   * Returns this blob's content.
   *
   * @param options blob read options
   * @throws StorageException upon failure
   */
  public byte[] content(Storage.BlobSourceOption... options) {
    return storage.readAllBytes(info.bucket(), info.name(), options);
  }

  /**
   * Fetches current blob's latest information.
   *
   * @param options blob read options
   * @return a {@code Blob} object with latest information
   * @throws StorageException upon failure
   */
  public Blob reload(BlobSourceOption... options) {
    return new Blob(storage, storage.get(info.bucket(), info.name(), convert(info, options)));
  }

  /**
   * Updates the blob's information. Bucket or blob's name cannot be changed by this method. If you
   * want to rename the blob or move it to a different bucket use the {@link #copyTo} and
   * {@link #delete} operations. A new {@code Blob} object is returned. By default no checks are
   * made on the metadata generation of the current blob. If you want to update the information only
   * if the current blob metadata are at their latest version use the {@code metagenerationMatch}
   * option: {@code blob.update(newInfo, BlobTargetOption.metagenerationMatch())}.
   *
   * @param blobInfo new blob's information. Bucket and blob names must match the current ones
   * @param options update options
   * @return a {@code Blob} object with updated information
   * @throws StorageException upon failure
   */
  public Blob update(BlobInfo blobInfo, BlobTargetOption... options) {
    checkArgument(Objects.equals(blobInfo.bucket(), info.bucket()), "Bucket name must match");
    checkArgument(Objects.equals(blobInfo.name(), info.name()), "Blob name must match");
    return new Blob(storage, storage.update(blobInfo, options));
  }

  /**
   * Deletes this blob.
   *
   * @param options blob delete options
   * @return true if blob was deleted
   * @throws StorageException upon failure
   */
  public boolean delete(BlobSourceOption... options) {
    return storage.delete(info.bucket(), info.name(), convert(info, options));
  }

  /**
   * Copies this blob to the target bucket, preserving its name. Possibly copying also some of the
   * metadata (e.g. content-type).
   *
   * @param targetBucket target bucket's name
   * @param options source blob options
   * @return the copied blob
   * @throws StorageException upon failure
   */
  public Blob copyTo(String targetBucket, BlobSourceOption... options) {
    return copyTo(targetBucket, info.name(), options);
  }

  /**
   * Copies this blob to the target bucket with a new name. Possibly copying also some of the
   * metadata (e.g. content-type).
   *
   * @param targetBucket target bucket's name
   * @param targetBlob target blob's name
   * @param options source blob options
   * @return the copied blob
   * @throws StorageException upon failure
   */
  public Blob copyTo(String targetBucket, String targetBlob, BlobSourceOption... options) {
    BlobInfo updatedInfo = info.toBuilder().bucket(targetBucket).name(targetBlob).build();
    CopyRequest copyRequest =
        CopyRequest.builder().source(info.bucket(), info.name())
            .sourceOptions(convert(info, options)).target(updatedInfo).build();
    return new Blob(storage, storage.copy(copyRequest));
  }

  /**
   * Returns a {@code BlobReadChannel} object for reading this blob's content.
   *
   * @param options blob read options
   * @throws StorageException upon failure
   */
  public BlobReadChannel reader(BlobSourceOption... options) {
    return storage.reader(info.bucket(), info.name(), convert(info, options));
  }

  /**
   * Returns a {@code BlobWriteChannel} object for writing to this blob.
   *
   * @param options target blob options
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
   * @param options signed url options
   * @return a signed URL for this bucket and the specified options
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed-URLs</a>
   */
  public URL signUrl(long expirationTimeInSeconds, SignUrlOption... options) {
    return storage.signUrl(info, expirationTimeInSeconds, options);
  }

  /**
   * Returns the blob's {@code Storage} object used to issue requests.
   */
  public Storage storage() {
    return storage;
  }

  /**
   * Gets the requested blobs. If {@code infos.length == 0} an empty list is returned. If
   * {@code infos.length > 1} a batch request is used to fetch blobs.
   *
   * @param storage the storage service used to issue the request
   * @param infos the blobs to get
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it has
   * been denied the corresponding item in the list is {@code null}.
   */
  public static List<Blob> get(final Storage storage, BlobInfo... infos) {
    checkNotNull(storage);
    checkNotNull(infos);
    int length = infos.length;
    switch (length) {
      case 0:
        return Collections.emptyList();
      case 1:
        return Collections.singletonList(
            new Blob(storage, storage.get(infos[0].bucket(), infos[0].name())));
      default:
        return Collections.unmodifiableList(Lists.transform(storage.get(infos),
            new Function<BlobInfo, Blob>() {
              @Override
              public Blob apply(BlobInfo f) {
                return f != null ? new Blob(storage, f) : null;
              }
            }));
    }
  }

  /**
   * Updates the requested blobs. If {@code infos.length == 0} an empty list is returned. If
   * {@code infos.length > 1} a batch request is used to update blobs.
   *
   * @param storage the storage service used to issue the request
   * @param infos the blobs to update
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it has
   * been denied the corresponding item in the list is {@code null}.
   */
  public static List<Blob> update(final Storage storage, BlobInfo... infos) {
    checkNotNull(storage);
    checkNotNull(infos);
    int length = infos.length;
    switch (length) {
      case 0:
        return Collections.emptyList();
      case 1:
        return Collections.singletonList(new Blob(storage, storage.update(infos[0])));
      default:
        return Collections.unmodifiableList(Lists.transform(storage.update(infos),
            new Function<BlobInfo, Blob>() {
              @Override
              public Blob apply(BlobInfo f) {
                return f != null ? new Blob(storage, f) : null;
              }
            }));
    }
  }

  /**
   * Deletes the requested blobs. If {@code infos.length == 0} an empty list is returned. If
   * {@code infos.length > 1} a batch request is used to delete blobs.
   *
   * @param storage the storage service used to issue the request
   * @param infos the blobs to delete
   * @return an immutable list of booleans. If a blob has been deleted the corresponding item in the
   * list is {@code true}. If deletion failed or access to the resource was denied the item is
   * {@code false}.
   */
  public static List<Boolean> delete(Storage storage, BlobInfo... infos) {
    checkNotNull(storage);
    checkNotNull(infos);
    int length = infos.length;
    switch (length) {
      case 0:
        return Collections.emptyList();
      case 1:
        return Collections.singletonList(storage.delete(infos[0].bucket(), infos[0].name()));
      default:
        return Collections.unmodifiableList(storage.delete(infos));
    }
  }
}
