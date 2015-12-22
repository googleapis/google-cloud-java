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
import static com.google.gcloud.storage.Bucket.BucketSourceOption.toGetOptions;
import static com.google.gcloud.storage.Bucket.BucketSourceOption.toSourceOptions;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Iterators;
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.storage.Storage.BlobGetOption;
import com.google.gcloud.storage.Storage.BlobTargetOption;
import com.google.gcloud.storage.Storage.BlobWriteOption;
import com.google.gcloud.storage.Storage.BucketTargetOption;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * A Google cloud storage bucket.
 *
 * <p>Objects of this class are immutable. Operations that modify the bucket like {@link #update}
 * return a new object. To get a {@code Bucket} object with the most recent information use
 * {@link #reload}.
 * </p>
 */
public final class Bucket {

  private final Storage storage;
  private final BucketInfo info;

  private static class BlobPageFetcher implements PageImpl.NextPageFetcher<Blob> {

    private static final long serialVersionUID = 3221100177471323801L;

    private final StorageOptions options;
    private final Page<BlobInfo> infoPage;

    BlobPageFetcher(StorageOptions options, Page<BlobInfo> infoPage) {
      this.options = options;
      this.infoPage = infoPage;
    }

    @Override
    public Page<Blob> nextPage() {
      Page<BlobInfo> nextInfoPage = infoPage.nextPage();
      return new PageImpl<>(new BlobPageFetcher(options, nextInfoPage),
          nextInfoPage.nextPageCursor(), new LazyBlobIterable(options, nextInfoPage.values()));
    }
  }

  private static class LazyBlobIterable implements Iterable<Blob>, Serializable {

    private static final long serialVersionUID = -3092290247725378832L;

    private final StorageOptions options;
    private Iterable<BlobInfo> infoIterable;
    private transient Storage storage;

    public LazyBlobIterable(StorageOptions options, Iterable<BlobInfo> infoIterable) {
      this.options = options;
      this.infoIterable = infoIterable;
      this.storage = options.service();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.storage = options.service();
    }

    @Override
    public Iterator<Blob> iterator() {
      return Iterators.transform(infoIterable.iterator(), new Function<BlobInfo, Blob>() {
        @Override
        public Blob apply(BlobInfo blobInfo) {
          return new Blob(storage, blobInfo);
        }
      });
    }

    @Override
    public int hashCode() {
      return Objects.hash(options, infoIterable);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof LazyBlobIterable)) {
        return false;
      }
      LazyBlobIterable other = (LazyBlobIterable) obj;
      return Objects.equals(options, other.options)
          && Objects.equals(infoIterable, other.infoIterable);
    }
  }

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

  /**
   * Constructs a {@code Bucket} object for the provided {@code BucketInfo}. The storage service is
   * used to issue requests.
   * 
   * @param storage the storage service used for issuing requests
   * @param info bucket's info
   */
  public Bucket(Storage storage, BucketInfo info) {
    this.storage = checkNotNull(storage);
    this.info = checkNotNull(info);
  }

  /**
   * Creates a {@code Bucket} object for the provided bucket name. Performs an RPC call to get the
   * latest bucket information.
   * 
   * @param storage the storage service used for issuing requests
   * @param bucket bucket's name
   * @return the {@code Bucket} object or {@code null} if not found.
   * @throws StorageException upon failure
   */
  public static Bucket load(Storage storage, String bucket) {
    BucketInfo info = storage.get(bucket);
    return info != null ? new Bucket(storage, info) : null;
  }

  /**
   * Returns the bucket's information.
   */
  public BucketInfo info() {
    return info;
  }

  /**
   * Checks if this bucket exists.
   *
   * @return true if this bucket exists, false otherwise
   * @throws StorageException upon failure
   */
  public boolean exists(BucketSourceOption... options) {
    int length = options.length;
    Storage.BucketGetOption[] getOptions = Arrays.copyOf(toGetOptions(info, options), length + 1);
    getOptions[length] = Storage.BucketGetOption.fields();
    return storage.get(info.name(), getOptions) != null;
  }

  /**
   * Fetches current bucket's latest information.
   *
   * @param options bucket read options
   * @return a {@code Bucket} object with latest information
   * @throws StorageException upon failure
   */
  public Bucket reload(BucketSourceOption... options) {
    return new Bucket(storage, storage.get(info.name(), toGetOptions(info, options)));
  }

  /**
   * Updates the bucket's information. Bucket's name cannot be changed. A new {@code Bucket} object
   * is returned. By default no checks are made on the metadata generation of the current bucket.
   * If you want to update the information only if the current bucket metadata are at their latest
   * version use the {@code metagenerationMatch} option:
   * {@code bucket.update(newInfo, BucketTargetOption.metagenerationMatch())}
   *
   * @param bucketInfo new bucket's information. Name must match the one of the current bucket
   * @param options update options
   * @return a {@code Bucket} object with updated information
   * @throws StorageException upon failure
   */
  public Bucket update(BucketInfo bucketInfo, BucketTargetOption... options) {
    checkArgument(Objects.equals(bucketInfo.name(), info.name()), "Bucket name must match");
    return new Bucket(storage, storage.update(bucketInfo, options));
  }

  /**
   * Deletes this bucket.
   *
   * @param options bucket delete options
   * @return {@code true} if bucket was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  public boolean delete(BucketSourceOption... options) {
    return storage.delete(info.name(), toSourceOptions(info, options));
  }

  /**
   * Returns the paginated list of {@code Blob} in this bucket.
   * 
   * @param options options for listing blobs
   * @throws StorageException upon failure
   */
  public Page<Blob> list(Storage.BlobListOption... options) {
    Page<BlobInfo> infoPage = storage.list(info.name(), options);
    StorageOptions storageOptions = storage.options();
    return new PageImpl<>(new BlobPageFetcher(storageOptions, infoPage), infoPage.nextPageCursor(),
        new LazyBlobIterable(storageOptions, infoPage.values()));
  }

  /**
   * Returns the requested blob in this bucket or {@code null} if not found.
   * 
   * @param blob name of the requested blob
   * @param options blob search options
   * @throws StorageException upon failure
   */
  public Blob get(String blob, BlobGetOption... options) {
    return new Blob(storage, storage.get(BlobId.of(info.name(), blob), options));
  }

  /**
   * Returns a list of requested blobs in this bucket. Blobs that do not exist are null.
   * 
   * @param blobName1 first blob to get
   * @param blobName2 second blob to get
   * @param blobNames other blobs to get
   * @return an immutable list of {@code Blob} objects.
   * @throws StorageException upon failure
   */
  public List<Blob> get(String blobName1, String blobName2, String... blobNames) {
    BatchRequest.Builder batch = BatchRequest.builder();
    batch.get(info.name(), blobName1);
    batch.get(info.name(), blobName2);
    for (String name : blobNames) {
      batch.get(info.name(), name);
    }
    List<Blob> blobs = new ArrayList<>(blobNames.length);
    BatchResponse response = storage.apply(batch.build());
    for (BatchResponse.Result<BlobInfo> result : response.gets()) {
      BlobInfo blobInfo = result.get();
      blobs.add(blobInfo != null ? new Blob(storage, blobInfo) : null);
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
   * @return a complete blob information.
   * @throws StorageException upon failure
   */
  public Blob create(String blob, byte[] content, String contentType, BlobTargetOption... options) {
    BlobInfo blobInfo = BlobInfo.builder(BlobId.of(info.name(), blob))
        .contentType(MoreObjects.firstNonNull(contentType, Storage.DEFAULT_CONTENT_TYPE)).build();
    return new Blob(storage, storage.create(blobInfo, content, options));
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
   * @return a complete blob information.
   * @throws StorageException upon failure
   */
  public Blob create(String blob, InputStream content, String contentType,
      BlobWriteOption... options) {
    BlobInfo blobInfo = BlobInfo.builder(BlobId.of(info.name(), blob))
        .contentType(MoreObjects.firstNonNull(contentType, Storage.DEFAULT_CONTENT_TYPE)).build();
    return new Blob(storage, storage.create(blobInfo, content, options));
  }

  /**
   * Returns the bucket's {@code Storage} object used to issue requests.
   */
  public Storage storage() {
    return storage;
  }
}
