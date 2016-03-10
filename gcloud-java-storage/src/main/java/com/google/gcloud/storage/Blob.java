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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.gcloud.storage.Blob.BlobSourceOption.toGetOptions;
import static com.google.gcloud.storage.Blob.BlobSourceOption.toSourceOptions;

import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.Function;
import com.google.gcloud.ReadChannel;
import com.google.gcloud.WriteChannel;
import com.google.gcloud.storage.Storage.BlobTargetOption;
import com.google.gcloud.storage.Storage.BlobWriteOption;
import com.google.gcloud.storage.Storage.CopyRequest;
import com.google.gcloud.storage.Storage.SignUrlOption;
import com.google.gcloud.storage.spi.StorageRpc;
import com.google.gcloud.storage.spi.StorageRpc.Tuple;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * A Google cloud storage object.
 *
 * <p>Objects of this class are immutable. Operations that modify the blob like {@link #update} and
 * {@link #copyTo} return a new object. To get a {@code Blob} object with the most recent
 * information use {@link #reload}. {@code Blob} adds a layer of service-related functionality over
 * {@link BlobInfo}.
 * </p>
 */
public final class Blob extends BlobInfo {

  private static final long serialVersionUID = -6806832496717441434L;

  private final StorageOptions options;
  private transient Storage storage;

  static final Function<Tuple<Storage, StorageObject>, Blob> BLOB_FROM_PB_FUNCTION =
      new Function<Tuple<Storage, StorageObject>, Blob>() {
        @Override
        public Blob apply(Tuple<Storage, StorageObject> pb) {
          return Blob.fromPb(pb.x(), pb.y());
        }
      };

  /**
   * Class for specifying blob source options when {@code Blob} methods are used.
   */
  public static class BlobSourceOption extends Option {

    private static final long serialVersionUID = 214616862061934846L;

    private BlobSourceOption(StorageRpc.Option rpcOption) {
      super(rpcOption, null);
    }

    private Storage.BlobSourceOption toSourceOptions(BlobInfo blobInfo) {
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

    private Storage.BlobGetOption toGetOption(BlobInfo blobInfo) {
      switch (rpcOption()) {
        case IF_GENERATION_MATCH:
          return Storage.BlobGetOption.generationMatch(blobInfo.generation());
        case IF_GENERATION_NOT_MATCH:
          return Storage.BlobGetOption.generationNotMatch(blobInfo.generation());
        case IF_METAGENERATION_MATCH:
          return Storage.BlobGetOption.metagenerationMatch(blobInfo.metageneration());
        case IF_METAGENERATION_NOT_MATCH:
          return Storage.BlobGetOption.metagenerationNotMatch(blobInfo.metageneration());
        default:
          throw new AssertionError("Unexpected enum value");
      }
    }

    /**
     * Returns an option for blob's generation match. If this option is used the request will fail
     * if generation does not match.
     */
    public static BlobSourceOption generationMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_MATCH);
    }

    /**
     * Returns an option for blob's generation mismatch. If this option is used the request will
     * fail if generation matches.
     */
    public static BlobSourceOption generationNotMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_NOT_MATCH);
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    public static BlobSourceOption metagenerationMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH);
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if metageneration matches.
     */
    public static BlobSourceOption metagenerationNotMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH);
    }

    static Storage.BlobSourceOption[] toSourceOptions(BlobInfo blobInfo,
        BlobSourceOption... options) {
      Storage.BlobSourceOption[] convertedOptions = new Storage.BlobSourceOption[options.length];
      int index = 0;
      for (BlobSourceOption option : options) {
        convertedOptions[index++] = option.toSourceOptions(blobInfo);
      }
      return convertedOptions;
    }

    static Storage.BlobGetOption[] toGetOptions(BlobInfo blobInfo, BlobSourceOption... options) {
      Storage.BlobGetOption[] convertedOptions = new Storage.BlobGetOption[options.length];
      int index = 0;
      for (BlobSourceOption option : options) {
        convertedOptions[index++] = option.toGetOption(blobInfo);
      }
      return convertedOptions;
    }
  }

  /**
   * Builder for {@code Blob}.
   */
  public static class Builder extends BlobInfo.Builder {

    private final Storage storage;
    private final BlobInfo.BuilderImpl infoBuilder;

    Builder(Blob blob) {
      this.storage = blob.storage();
      this.infoBuilder = new BlobInfo.BuilderImpl(blob);
    }

    @Override
    public Builder blobId(BlobId blobId) {
      infoBuilder.blobId(blobId);
      return this;
    }

    @Override
    Builder id(String id) {
      infoBuilder.id(id);
      return this;
    }

    @Override
    public Builder contentType(String contentType) {
      infoBuilder.contentType(contentType);
      return this;
    }

    @Override
    public Builder contentDisposition(String contentDisposition) {
      infoBuilder.contentDisposition(contentDisposition);
      return this;
    }

    @Override
    public Builder contentLanguage(String contentLanguage) {
      infoBuilder.contentLanguage(contentLanguage);
      return this;
    }

    @Override
    public Builder contentEncoding(String contentEncoding) {
      infoBuilder.contentEncoding(contentEncoding);
      return this;
    }

    @Override
    Builder componentCount(Integer componentCount) {
      infoBuilder.componentCount(componentCount);
      return this;
    }

    @Override
    public Builder cacheControl(String cacheControl) {
      infoBuilder.cacheControl(cacheControl);
      return this;
    }

    @Override
    public Builder acl(List<Acl> acl) {
      infoBuilder.acl(acl);
      return this;
    }

    @Override
    Builder owner(Acl.Entity owner) {
      infoBuilder.owner(owner);
      return this;
    }

    @Override
    Builder size(Long size) {
      infoBuilder.size(size);
      return this;
    }

    @Override
    Builder etag(String etag) {
      infoBuilder.etag(etag);
      return this;
    }

    @Override
    Builder selfLink(String selfLink) {
      infoBuilder.selfLink(selfLink);
      return this;
    }

    @Override
    public Builder md5(String md5) {
      infoBuilder.md5(md5);
      return this;
    }

    @Override
    public Builder crc32c(String crc32c) {
      infoBuilder.crc32c(crc32c);
      return this;
    }

    @Override
    Builder mediaLink(String mediaLink) {
      infoBuilder.mediaLink(mediaLink);
      return this;
    }

    @Override
    public Builder metadata(Map<String, String> metadata) {
      infoBuilder.metadata(metadata);
      return this;
    }

    @Override
    Builder metageneration(Long metageneration) {
      infoBuilder.metageneration(metageneration);
      return this;
    }

    @Override
    Builder deleteTime(Long deleteTime) {
      infoBuilder.deleteTime(deleteTime);
      return this;
    }

    @Override
    Builder updateTime(Long updateTime) {
      infoBuilder.updateTime(updateTime);
      return this;
    }

    @Override
    Builder isDirectory(boolean isDirectory) {
      infoBuilder.isDirectory(isDirectory);
      return this;
    }

    @Override
    public Blob build() {
      return new Blob(storage, infoBuilder);
    }
  }

  Blob(Storage storage, BlobInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.storage = checkNotNull(storage);
    this.options = storage.options();
  }

  /**
   * Checks if this blob exists.
   *
   * @param options blob read options
   * @return true if this blob exists, false otherwise
   * @throws StorageException upon failure
   */
  public boolean exists(BlobSourceOption... options) {
    int length = options.length;
    Storage.BlobGetOption[] getOptions = Arrays.copyOf(toGetOptions(this, options), length + 1);
    getOptions[length] = Storage.BlobGetOption.fields();
    return storage.get(blobId(), getOptions) != null;
  }

  /**
   * Returns this blob's content.
   *
   * @param options blob read options
   * @throws StorageException upon failure
   */
  public byte[] content(Storage.BlobSourceOption... options) {
    return storage.readAllBytes(blobId(), options);
  }

  /**
   * Fetches current blob's latest information. Returns {@code null} if the blob does not exist.
   *
   * @param options blob read options
   * @return a {@code Blob} object with latest information or {@code null} if not found
   * @throws StorageException upon failure
   */
  public Blob reload(BlobSourceOption... options) {
    return storage.get(blobId(), toGetOptions(this, options));
  }

  /**
   * Updates the blob's information. Bucket or blob's name cannot be changed by this method. If you
   * want to rename the blob or move it to a different bucket use the {@link #copyTo} and
   * {@link #delete} operations. A new {@code Blob} object is returned. By default no checks are
   * made on the metadata generation of the current blob. If you want to update the information only
   * if the current blob metadata are at their latest version use the {@code metagenerationMatch}
   * option: {@code newBlob.update(BlobTargetOption.metagenerationMatch())}.
   *
   * <p>Original metadata are merged with metadata in the provided in this {@code blob}. To replace
   * metadata instead you first have to unset them. Unsetting metadata can be done by setting this
   * {@code blob}'s metadata to {@code null}.
   * </p>
   *
   * <p>Example usage of replacing blob's metadata:
   * <pre> {@code
   * blob.toBuilder().metadata(null).build().update();
   * blob.toBuilder().metadata(newMetadata).build().update();
   * }
   * </pre>
   *
   * @param options update options
   * @return a {@code Blob} object with updated information
   * @throws StorageException upon failure
   */
  public Blob update(BlobTargetOption... options) {
    return storage.update(this, options);
  }

  /**
   * Deletes this blob.
   *
   * @param options blob delete options
   * @return {@code true} if blob was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  public boolean delete(BlobSourceOption... options) {
    return storage.delete(blobId(), toSourceOptions(this, options));
  }

  /**
   * Sends a copy request for the current blob to the target blob. Possibly also some of the
   * metadata are copied (e.g. content-type).
   *
   * @param targetBlob target blob's id
   * @param options source blob options
   * @return a {@link CopyWriter} object that can be used to get information on the newly created
   *     blob or to complete the copy if more than one RPC request is needed
   * @throws StorageException upon failure
   */
  public CopyWriter copyTo(BlobId targetBlob, BlobSourceOption... options) {
    CopyRequest copyRequest = CopyRequest.builder()
        .source(bucket(), name())
        .sourceOptions(toSourceOptions(this, options))
        .target(targetBlob)
        .build();
    return storage.copy(copyRequest);
  }

  /**
   * Sends a copy request for the current blob to the target bucket, preserving its name. Possibly
   * copying also some of the metadata (e.g. content-type).
   *
   * @param targetBucket target bucket's name
   * @param options source blob options
   * @return a {@link CopyWriter} object that can be used to get information on the newly created
   *     blob or to complete the copy if more than one RPC request is needed
   * @throws StorageException upon failure
   */
  public CopyWriter copyTo(String targetBucket, BlobSourceOption... options) {
    return copyTo(targetBucket, name(), options);
  }

  /**
   * Sends a copy request for the current blob to the target blob. Possibly also some of the
   * metadata are copied (e.g. content-type).
   *
   * @param targetBucket target bucket's name
   * @param targetBlob target blob's name
   * @param options source blob options
   * @return a {@link CopyWriter} object that can be used to get information on the newly created
   *     blob or to complete the copy if more than one RPC request is needed
   * @throws StorageException upon failure
   */
  public CopyWriter copyTo(String targetBucket, String targetBlob, BlobSourceOption... options) {
    return copyTo(BlobId.of(targetBucket, targetBlob), options);
  }

  /**
   * Returns a {@code ReadChannel} object for reading this blob's content.
   *
   * @param options blob read options
   * @throws StorageException upon failure
   */
  public ReadChannel reader(BlobSourceOption... options) {
    return storage.reader(blobId(), toSourceOptions(this, options));
  }

  /**
   * Returns a {@code WriteChannel} object for writing to this blob. By default any md5 and
   * crc32c values in the current blob are ignored unless requested via the
   * {@code BlobWriteOption.md5Match} and {@code BlobWriteOption.crc32cMatch} options.
   *
   * @param options target blob options
   * @throws StorageException upon failure
   */
  public WriteChannel writer(BlobWriteOption... options) {
    return storage.writer(this, options);
  }

  /**
   * Generates a signed URL for this blob. If you want to allow access to for a fixed amount of time
   * for this blob, you can use this method to generate a URL that is only valid within a certain
   * time period. This is particularly useful if you don't want publicly accessible blobs, but don't
   * want to require users to explicitly log in.
   *
   * @param duration time until the signed URL expires, expressed in {@code unit}. The finer
   *     granularity supported is 1 second, finer granularities will be truncated
   * @param unit time unit of the {@code duration} parameter
   * @param options optional URL signing options
   * @return a signed URL for this bucket and the specified options
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed-URLs</a>
   */
  public URL signUrl(long duration, TimeUnit unit, SignUrlOption... options) {
    return storage.signUrl(this, duration, unit, options);
  }

  /**
   * Returns the blob's {@code Storage} object used to issue requests.
   */
  public Storage storage() {
    return storage;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Blob && Objects.equals(toPb(), ((Blob) obj).toPb())
        && Objects.equals(options, ((Blob) obj).options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.storage = options.service();
  }

  static Blob fromPb(Storage storage, StorageObject storageObject) {
    BlobInfo info = BlobInfo.fromPb(storageObject);
    return new Blob(storage, new BlobInfo.BuilderImpl(info));
  }
}
