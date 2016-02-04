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
import static com.google.gcloud.storage.Bucket.BucketSourceOption.toGetOptions;
import static com.google.gcloud.storage.Bucket.BucketSourceOption.toSourceOptions;

import com.google.common.base.MoreObjects;
import com.google.gcloud.Page;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.storage.Storage.BlobGetOption;
import com.google.gcloud.storage.Storage.BlobTargetOption;
import com.google.gcloud.storage.Storage.BlobWriteOption;
import com.google.gcloud.storage.Storage.BucketTargetOption;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A Google cloud storage bucket.
 *
 * <p>Objects of this class are immutable. Operations that modify the bucket like {@link #update}
 * return a new object. To get a {@code Bucket} object with the most recent information use
 * {@link #reload}. {@code Bucket} adds a layer of service-related functionality over
 * {@link BucketInfo}.
 * </p>
 */
public final class Bucket extends BucketInfo {

  private final StorageOptions options;
  private transient Storage storage;

  /**
   * Class for specifying bucket source options when {@code Bucket} methods are used.
   */
  public static class BucketSourceOption extends Option {

    private static final long serialVersionUID = 6928872234155522371L;

    private BucketSourceOption(StorageRpc.Option rpcOption) {
      super(rpcOption, null);
    }

    private Storage.BucketSourceOption toSourceOptions(BucketInfo bucketInfo) {
      switch (rpcOption()) {
        case IF_METAGENERATION_MATCH:
          return Storage.BucketSourceOption.metagenerationMatch(bucketInfo.metageneration());
        case IF_METAGENERATION_NOT_MATCH:
          return Storage.BucketSourceOption.metagenerationNotMatch(bucketInfo.metageneration());
        default:
          throw new AssertionError("Unexpected enum value");
      }
    }

    private Storage.BucketGetOption toGetOption(BucketInfo bucketInfo) {
      switch (rpcOption()) {
        case IF_METAGENERATION_MATCH:
          return Storage.BucketGetOption.metagenerationMatch(bucketInfo.metageneration());
        case IF_METAGENERATION_NOT_MATCH:
          return Storage.BucketGetOption.metagenerationNotMatch(bucketInfo.metageneration());
        default:
          throw new AssertionError("Unexpected enum value");
      }
    }

    /**
     * Returns an option for bucket's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    public static BucketSourceOption metagenerationMatch() {
      return new BucketSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH);
    }

    /**
     * Returns an option for bucket's metageneration mismatch. If this option is used the request
     * will fail if metageneration matches.
     */
    public static BucketSourceOption metagenerationNotMatch() {
      return new BucketSourceOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH);
    }

    static Storage.BucketSourceOption[] toSourceOptions(BucketInfo bucketInfo,
         BucketSourceOption... options) {
      Storage.BucketSourceOption[] convertedOptions =
          new Storage.BucketSourceOption[options.length];
      int index = 0;
      for (BucketSourceOption option : options) {
        convertedOptions[index++] = option.toSourceOptions(bucketInfo);
      }
      return convertedOptions;
    }

    static Storage.BucketGetOption[] toGetOptions(BucketInfo bucketInfo,
        BucketSourceOption... options) {
      Storage.BucketGetOption[] convertedOptions = new Storage.BucketGetOption[options.length];
      int index = 0;
      for (BucketSourceOption option : options) {
        convertedOptions[index++] = option.toGetOption(bucketInfo);
      }
      return convertedOptions;
    }
  }

  public static class Builder extends BucketInfo.Builder {
    private final Storage storage;
    private final BucketInfo.BuilderImpl infoBuilder;

    Builder(Bucket bucket) {
      this.storage = bucket.storage;
      this.infoBuilder = new BucketInfo.BuilderImpl(bucket);
    }

    @Override
    public Builder name(String name) {
      infoBuilder.name(name);
      return this;
    }

    @Override
    Builder id(String id) {
      infoBuilder.id(id);
      return this;
    }

    @Override
    Builder owner(Acl.Entity owner) {
      infoBuilder.owner(owner);
      return this;
    }

    @Override
    Builder selfLink(String selfLink) {
      infoBuilder.selfLink(selfLink);
      return this;
    }

    @Override
    public Builder versioningEnabled(Boolean enable) {
      infoBuilder.versioningEnabled(enable);
      return this;
    }

    @Override
    public Builder indexPage(String indexPage) {
      infoBuilder.indexPage(indexPage);
      return this;
    }

    @Override
    public Builder notFoundPage(String notFoundPage) {
      infoBuilder.notFoundPage(notFoundPage);
      return this;
    }

    @Override
    public Builder deleteRules(Iterable<? extends DeleteRule> rules) {
      infoBuilder.deleteRules(rules);
      return this;
    }

    @Override
    public Builder storageClass(String storageClass) {
      infoBuilder.storageClass(storageClass);
      return this;
    }

    @Override
    public Builder location(String location) {
      infoBuilder.location(location);
      return this;
    }

    @Override
    Builder etag(String etag) {
      infoBuilder.etag(etag);
      return this;
    }

    @Override
    Builder createTime(Long createTime) {
      infoBuilder.createTime(createTime);
      return this;
    }

    @Override
    Builder metageneration(Long metageneration) {
      infoBuilder.metageneration(metageneration);
      return this;
    }

    @Override
    public Builder cors(Iterable<Cors> cors) {
      infoBuilder.cors(cors);
      return this;
    }

    @Override
    public Builder acl(Iterable<Acl> acl) {
      infoBuilder.acl(acl);
      return this;
    }

    @Override
    public Builder defaultAcl(Iterable<Acl> acl) {
      infoBuilder.defaultAcl(acl);
      return this;
    }

    @Override
    public Bucket build() {
      return new Bucket(storage, infoBuilder);
    }
  }

  Bucket(Storage storage, BucketInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.storage = checkNotNull(storage);
    this.options = storage.options();
  }

  /**
   * Checks if this bucket exists.
   *
   * @return true if this bucket exists, false otherwise
   * @throws StorageException upon failure
   */
  public boolean exists(BucketSourceOption... options) {
    int length = options.length;
    Storage.BucketGetOption[] getOptions = Arrays.copyOf(toGetOptions(this, options), length + 1);
    getOptions[length] = Storage.BucketGetOption.fields();
    return storage.get(name(), getOptions) != null;
  }

  /**
   * Fetches current bucket's latest information. Returns {@code null} if the bucket does not exist.
   *
   * @param options bucket read options
   * @return a {@code Bucket} object with latest information or {@code null} if not found
   * @throws StorageException upon failure
   */
  public Bucket reload(BucketSourceOption... options) {
    return storage.get(name(), toGetOptions(this, options));
  }

  /**
   * Updates the bucket's information. Bucket's name cannot be changed. A new {@code Bucket} object
   * is returned. By default no checks are made on the metadata generation of the current bucket.
   * If you want to update the information only if the current bucket metadata are at their latest
   * version use the {@code metagenerationMatch} option:
   * {@code bucket.update(BucketTargetOption.metagenerationMatch())}
   *
   * @param options update options
   * @return a {@code Bucket} object with updated information
   * @throws StorageException upon failure
   */
  public Bucket update(BucketTargetOption... options) {
    return storage.update(this, options);
  }

  /**
   * Deletes this bucket.
   *
   * @param options bucket delete options
   * @return {@code true} if bucket was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  public boolean delete(BucketSourceOption... options) {
    return storage.delete(name(), toSourceOptions(this, options));
  }

  /**
   * Returns the paginated list of {@code Blob} in this bucket.
   *
   * @param options options for listing blobs
   * @throws StorageException upon failure
   */
  public Page<Blob> list(Storage.BlobListOption... options) {
    return storage.list(name(), options);
  }

  /**
   * Returns the requested blob in this bucket or {@code null} if not found.
   *
   * @param blob name of the requested blob
   * @param options blob search options
   * @throws StorageException upon failure
   */
  public Blob get(String blob, BlobGetOption... options) {
    return storage.get(BlobId.of(name(), blob), options);
  }

  /**
   * Returns a list of requested blobs in this bucket. Blobs that do not exist are null.
   *
   * @param blobName1 first blob to get
   * @param blobName2 second blob to get
   * @param blobNames other blobs to get
   * @return an immutable list of {@code Blob} objects
   * @throws StorageException upon failure
   */
  public List<Blob> get(String blobName1, String blobName2, String... blobNames) {
    BatchRequest.Builder batch = BatchRequest.builder();
    batch.get(name(), blobName1);
    batch.get(name(), blobName2);
    for (String name : blobNames) {
      batch.get(name(), name);
    }
    List<Blob> blobs = new ArrayList<>(blobNames.length);
    BatchResponse response = storage.submit(batch.build());
    for (BatchResponse.Result<Blob> result : response.gets()) {
      BlobInfo blobInfo = result.get();
      blobs.add(blobInfo != null ? new Blob(storage, new BlobInfo.BuilderImpl(blobInfo)) : null);
    }
    return Collections.unmodifiableList(blobs);
  }

  /**
   * Creates a new blob in this bucket. Direct upload is used to upload {@code content}.
   * For large content, {@link Blob#writer(com.google.gcloud.storage.Storage.BlobWriteOption...)}
   * is recommended as it uses resumable upload. MD5 and CRC32C hashes of {@code content} are
   * computed and used for validating transferred data.
   *
   * @param blob a blob name
   * @param content the blob content
   * @param contentType the blob content type. If {@code null} then
   *     {@value com.google.gcloud.storage.Storage#DEFAULT_CONTENT_TYPE} is used.
   * @param options options for blob creation
   * @return a complete blob information
   * @throws StorageException upon failure
   */
  public Blob create(String blob, byte[] content, String contentType, BlobTargetOption... options) {
    BlobInfo blobInfo = BlobInfo.builder(BlobId.of(name(), blob))
        .contentType(MoreObjects.firstNonNull(contentType, Storage.DEFAULT_CONTENT_TYPE)).build();
    return storage.create(blobInfo, content, options);
  }

  /**
   * Creates a new blob in this bucket. Direct upload is used to upload {@code content}.
   * For large content, {@link Blob#writer(com.google.gcloud.storage.Storage.BlobWriteOption...)}
   * is recommended as it uses resumable upload.
   *
   * @param blob a blob name
   * @param content the blob content as a stream
   * @param contentType the blob content type. If {@code null} then
   *     {@value com.google.gcloud.storage.Storage#DEFAULT_CONTENT_TYPE} is used.
   * @param options options for blob creation
   * @return a complete blob information
   * @throws StorageException upon failure
   */
  public Blob create(String blob, InputStream content, String contentType,
      BlobWriteOption... options) {
    BlobInfo blobInfo = BlobInfo.builder(BlobId.of(name(), blob))
        .contentType(MoreObjects.firstNonNull(contentType, Storage.DEFAULT_CONTENT_TYPE)).build();
    return storage.create(blobInfo, content, options);
  }

  /**
   * Returns the bucket's {@code Storage} object used to issue requests.
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
    return obj instanceof Bucket && Objects.equals(toPb(), ((Bucket) obj).toPb())
        && Objects.equals(options, ((Bucket) obj).options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.storage = options.service();
  }

  static Bucket fromPb(Storage storage, com.google.api.services.storage.model.Bucket bucketPb) {
    return new Bucket(storage, new BucketInfo.BuilderImpl(BucketInfo.fromPb(bucketPb)));
  }
}
