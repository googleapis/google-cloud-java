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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gcloud.AuthCredentials.ServiceAccountAuthCredentials;
import com.google.gcloud.Service;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.spi.StorageRpc.Tuple;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * An interface for Google Cloud Storage.
 *
 * @see <a href="https://cloud.google.com/storage/docs">Google Cloud Storage</a>
 */
public interface Storage extends Service<StorageOptions> {

  public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";

  enum PredefinedAcl {
    AUTHENTICATED_READ("authenticatedRead"),
    ALL_AUTHENTICATED_USERS("allAuthenticatedUsers"),
    PRIVATE("private"),
    PROJECT_PRIVATE("projectPrivate"),
    PUBLIC_READ("publicRead"),
    PUBLIC_READ_WRITE("publicReadWrite"),
    BUCKET_OWNER_READ("bucketOwnerRead"),
    BUCKET_OWNER_FULL_CONTROL("bucketOwnerFullControl");

    private final String entry;

    PredefinedAcl(String entry) {
      this.entry = entry;
    }

    String entry() {
      return entry;
    }
  }

  class BucketTargetOption extends Option {

    private static final long serialVersionUID = -5880204616982900975L;

    private BucketTargetOption(StorageRpc.Option rpcOption, Object value) {
      super(rpcOption, value);
    }

    private BucketTargetOption(StorageRpc.Option rpcOption) {
      this(rpcOption, null);
    }

    public static BucketTargetOption predefinedAcl(PredefinedAcl acl) {
      return new BucketTargetOption(StorageRpc.Option.PREDEFINED_ACL, acl.entry());
    }

    public static BucketTargetOption predefinedDefaultObjectAcl(PredefinedAcl acl) {
      return new BucketTargetOption(StorageRpc.Option.PREDEFINED_DEFAULT_OBJECT_ACL, acl.entry());
    }

    public static BucketTargetOption metagenerationMatch() {
      return new BucketTargetOption(StorageRpc.Option.IF_METAGENERATION_MATCH);
    }

    public static BucketTargetOption metagenerationNotMatch() {
      return new BucketTargetOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH);
    }
  }

  class BucketSourceOption extends Option {

    private static final long serialVersionUID = 5185657617120212117L;

    private BucketSourceOption(StorageRpc.Option rpcOption, long metageneration) {
      super(rpcOption, metageneration);
    }

    public static BucketSourceOption metagenerationMatch(long metageneration) {
      return new BucketSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH, metageneration);
    }

    public static BucketSourceOption metagenerationNotMatch(long metageneration) {
      return new BucketSourceOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH, metageneration);
    }
  }

  class BlobTargetOption extends Option {

    private static final long serialVersionUID = 214616862061934846L;

    private BlobTargetOption(StorageRpc.Option rpcOption, Object value) {
      super(rpcOption, value);
    }

    private BlobTargetOption(StorageRpc.Option rpcOption) {
      this(rpcOption, null);
    }

    public static BlobTargetOption predefinedAcl(PredefinedAcl acl) {
      return new BlobTargetOption(StorageRpc.Option.PREDEFINED_ACL, acl.entry());
    }

    public static BlobTargetOption doesNotExist() {
      return new BlobTargetOption(StorageRpc.Option.IF_GENERATION_MATCH, 0L);
    }

    public static BlobTargetOption generationMatch() {
      return new BlobTargetOption(StorageRpc.Option.IF_GENERATION_MATCH);
    }

    public static BlobTargetOption generationNotMatch() {
      return new BlobTargetOption(StorageRpc.Option.IF_GENERATION_NOT_MATCH);
    }

    public static BlobTargetOption metagenerationMatch() {
      return new BlobTargetOption(StorageRpc.Option.IF_METAGENERATION_MATCH);
    }

    public static BlobTargetOption metagenerationNotMatch() {
      return new BlobTargetOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH);
    }

    static Tuple<BlobInfo, BlobTargetOption[]> convert(BlobInfo info, BlobWriteOption... options) {
      BlobInfo.Builder infoBuilder = info.toBuilder().crc32c(null).md5(null);
      List<BlobTargetOption> targetOptions = Lists.newArrayListWithCapacity(options.length);
      for (BlobWriteOption option : options) {
        switch (option.option) {
          case IF_CRC32C_MATCH:
            infoBuilder.crc32c(info.crc32c());
            break;
          case IF_MD5_MATCH:
            infoBuilder.md5(info.md5());
            break;
          default:
            targetOptions.add(option.toTargetOption());
            break;
        }
      }
      return Tuple.of(infoBuilder.build(),
          targetOptions.toArray(new BlobTargetOption[targetOptions.size()]));
    }
  }

  class BlobWriteOption implements Serializable {

    private static final long serialVersionUID = -3880421670966224580L;

    private final Option option;
    private final Object value;

    enum Option {
      PREDEFINED_ACL, IF_GENERATION_MATCH, IF_GENERATION_NOT_MATCH, IF_METAGENERATION_MATCH,
      IF_METAGENERATION_NOT_MATCH, IF_MD5_MATCH, IF_CRC32C_MATCH;

      StorageRpc.Option toRpcOption() {
        return StorageRpc.Option.valueOf(this.name());
      }
    }

    BlobTargetOption toTargetOption() {
      return new BlobTargetOption(this.option.toRpcOption(), this.value);
    }

    private BlobWriteOption(Option option, Object value) {
      this.option = option;
      this.value = value;
    }

    private BlobWriteOption(Option option) {
      this(option, null);
    }

    @Override
    public int hashCode() {
      return Objects.hash(option, value);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof BlobWriteOption)) {
        return false;
      }
      final BlobWriteOption other = (BlobWriteOption) obj;
      return this.option == other.option && Objects.equals(this.value, other.value);
    }

    public static BlobWriteOption predefinedAcl(PredefinedAcl acl) {
      return new BlobWriteOption(Option.PREDEFINED_ACL, acl.entry());
    }

    public static BlobWriteOption doesNotExist() {
      return new BlobWriteOption(Option.IF_GENERATION_MATCH, 0L);
    }

    public static BlobWriteOption generationMatch() {
      return new BlobWriteOption(Option.IF_GENERATION_MATCH);
    }

    public static BlobWriteOption generationNotMatch() {
      return new BlobWriteOption(Option.IF_GENERATION_NOT_MATCH);
    }

    public static BlobWriteOption metagenerationMatch() {
      return new BlobWriteOption(Option.IF_METAGENERATION_MATCH);
    }

    public static BlobWriteOption metagenerationNotMatch() {
      return new BlobWriteOption(Option.IF_METAGENERATION_NOT_MATCH);
    }

    public static BlobWriteOption md5Match() {
      return new BlobWriteOption(Option.IF_MD5_MATCH, true);
    }

    public static BlobWriteOption crc32cMatch() {
      return new BlobWriteOption(Option.IF_CRC32C_MATCH, true);
    }
  }

  class BlobSourceOption extends Option {

    private static final long serialVersionUID = -3712768261070182991L;

    private BlobSourceOption(StorageRpc.Option rpcOption, long value) {
      super(rpcOption, value);
    }

    public static BlobSourceOption generationMatch(long generation) {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_MATCH, generation);
    }

    public static BlobSourceOption generationNotMatch(long generation) {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_NOT_MATCH, generation);
    }

    public static BlobSourceOption metagenerationMatch(long metageneration) {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH, metageneration);
    }

    public static BlobSourceOption metagenerationNotMatch(long metageneration) {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH, metageneration);
    }
  }

  class BucketListOption extends Option {

    private static final long serialVersionUID = 8754017079673290353L;

    private BucketListOption(StorageRpc.Option option, Object value) {
      super(option, value);
    }

    public static BucketListOption maxResults(long maxResults) {
      return new BucketListOption(StorageRpc.Option.MAX_RESULTS, maxResults);
    }

    public static BucketListOption startPageToken(String pageToken) {
      return new BucketListOption(StorageRpc.Option.PAGE_TOKEN, pageToken);
    }

    public static BucketListOption prefix(String prefix) {
      return new BucketListOption(StorageRpc.Option.PREFIX, prefix);
    }
  }

  class BlobListOption extends Option {

    private static final long serialVersionUID = 9083383524788661294L;

    private BlobListOption(StorageRpc.Option option, Object value) {
      super(option, value);
    }

    public static BlobListOption maxResults(long maxResults) {
      return new BlobListOption(StorageRpc.Option.MAX_RESULTS, maxResults);
    }

    public static BlobListOption startPageToken(String pageToken) {
      return new BlobListOption(StorageRpc.Option.PAGE_TOKEN, pageToken);
    }

    public static BlobListOption prefix(String prefix) {
      return new BlobListOption(StorageRpc.Option.PREFIX, prefix);
    }

    public static BlobListOption recursive(boolean recursive) {
      return new BlobListOption(StorageRpc.Option.DELIMITER, recursive);
    }
  }

  class SignUrlOption implements Serializable {

    private static final long serialVersionUID = 7850569877451099267L;

    private final Option option;
    private final Object value;

    enum Option {
      HTTP_METHOD, CONTENT_TYPE, MD5, SERVICE_ACCOUNT_CRED
    }

    private SignUrlOption(Option option, Object value) {
      this.option = option;
      this.value = value;
    }

    Option option() {
      return option;
    }

    Object value() {
      return value;
    }

    /**
     * The HTTP method to be used with the signed URL.
     */
    public static SignUrlOption httpMethod(HttpMethod httpMethod) {
      return new SignUrlOption(Option.HTTP_METHOD, httpMethod.name());
    }

    /**
     * Use it if signature should include the blob's content-type.
     * When used, users of the signed URL should include the blob's content-type with their request.
     */
    public static SignUrlOption withContentType() {
      return new SignUrlOption(Option.CONTENT_TYPE, true);
    }

    /**
     * Use it if signature should include the blob's md5.
     * When used, users of the signed URL should include the blob's md5 with their request.
     */
    public static SignUrlOption withMd5() {
      return new SignUrlOption(Option.MD5, true);
    }

    /**
     * Service account credentials which are used for signing the URL.
     * If not provided an attempt will be made to get it from the environment.
     *
     * @see <a href="https://cloud.google.com/storage/docs/authentication#service_accounts">Service
     *     account</a>
     */
    public static SignUrlOption serviceAccount(ServiceAccountAuthCredentials credentials) {
      return new SignUrlOption(Option.SERVICE_ACCOUNT_CRED, credentials);
    }
  }

  class ComposeRequest implements Serializable {

    private static final long serialVersionUID = -7385681353748590911L;

    private final List<SourceBlob> sourceBlobs;
    private final BlobInfo target;
    private final List<BlobTargetOption> targetOptions;

    public static class SourceBlob implements Serializable {

      private static final long serialVersionUID = 4094962795951990439L;

      final String name;
      final Long generation;

      SourceBlob(String name) {
        this(name, null);
      }

      SourceBlob(String name, Long generation) {
        this.name = name;
        this.generation = generation;
      }

      public String name() {
        return name;
      }

      public Long generation() {
        return generation;
      }
    }

    public static class Builder {

      private final List<SourceBlob> sourceBlobs = new LinkedList<>();
      private final Set<BlobTargetOption> targetOptions = new LinkedHashSet<>();
      private BlobInfo target;

      public Builder addSource(Iterable<String> blobs) {
        for (String blob : blobs) {
          sourceBlobs.add(new SourceBlob(blob));
        }
        return this;
      }

      public Builder addSource(String... blobs) {
        return addSource(Arrays.asList(blobs));
      }

      /**
       * Add a source with a specific generation to match.
       */
      public Builder addSource(String blob, long generation) {
        sourceBlobs.add(new SourceBlob(blob, generation));
        return this;
      }

      public Builder target(BlobInfo target) {
        this.target = target;
        return this;
      }

      public Builder targetOptions(BlobTargetOption... options) {
        Collections.addAll(targetOptions, options);
        return this;
      }

      public Builder targetOptions(Iterable<BlobTargetOption> options) {
        Iterables.addAll(targetOptions, options);
        return this;
      }

      public ComposeRequest build() {
        checkArgument(!sourceBlobs.isEmpty());
        checkNotNull(target);
        return new ComposeRequest(this);
      }
    }

    private ComposeRequest(Builder builder) {
      sourceBlobs = ImmutableList.copyOf(builder.sourceBlobs);
      target = builder.target;
      targetOptions = ImmutableList.copyOf(builder.targetOptions);
    }

    public List<SourceBlob> sourceBlobs() {
      return sourceBlobs;
    }

    public BlobInfo target() {
      return target;
    }

    public List<BlobTargetOption> targetOptions() {
      return targetOptions;
    }

    public static ComposeRequest of(Iterable<String> sources, BlobInfo target) {
      return builder().target(target).addSource(sources).build();
    }

    public static ComposeRequest of(String bucket, Iterable<String> sources, String target) {
      return of(sources, BlobInfo.builder(BlobId.of(bucket, target)).build());
    }

    public static Builder builder() {
      return new Builder();
    }
  }

  class CopyRequest implements Serializable {

    private static final long serialVersionUID = -2606508373751748775L;

    private final BlobId source;
    private final List<BlobSourceOption> sourceOptions;
    private final BlobInfo target;
    private final List<BlobTargetOption> targetOptions;

    public static class Builder {

      private final Set<BlobSourceOption> sourceOptions = new LinkedHashSet<>();
      private final Set<BlobTargetOption> targetOptions = new LinkedHashSet<>();
      private BlobId source;
      private BlobInfo target;

      public Builder source(String bucket, String blob) {
        this.source = BlobId.of(bucket, blob);
        return this;
      }

      public Builder source(BlobId source) {
        this.source = source;
        return this;
      }

      public Builder sourceOptions(BlobSourceOption... options) {
        Collections.addAll(sourceOptions, options);
        return this;
      }

      public Builder sourceOptions(Iterable<BlobSourceOption> options) {
        Iterables.addAll(sourceOptions, options);
        return this;
      }

      public Builder target(BlobInfo target) {
        this.target = target;
        return this;
      }

      public Builder targetOptions(BlobTargetOption... options) {
        Collections.addAll(targetOptions, options);
        return this;
      }

      public Builder targetOptions(Iterable<BlobTargetOption> options) {
        Iterables.addAll(targetOptions, options);
        return this;
      }

      public CopyRequest build() {
        checkNotNull(source);
        checkNotNull(target);
        return new CopyRequest(this);
      }
    }

    private CopyRequest(Builder builder) {
      source = checkNotNull(builder.source);
      sourceOptions = ImmutableList.copyOf(builder.sourceOptions);
      target = checkNotNull(builder.target);
      targetOptions = ImmutableList.copyOf(builder.targetOptions);
    }

    public BlobId source() {
      return source;
    }

    public List<BlobSourceOption> sourceOptions() {
      return sourceOptions;
    }

    public BlobInfo target() {
      return target;
    }

    public List<BlobTargetOption> targetOptions() {
      return targetOptions;
    }

    public static CopyRequest of(String sourceBucket, String sourceBlob, BlobInfo target) {
      return builder().source(sourceBucket, sourceBlob).target(target).build();
    }

    public static CopyRequest of(BlobId sourceBlobId, BlobInfo target) {
      return builder().source(sourceBlobId).target(target).build();
    }

    public static CopyRequest of(String sourceBucket, String sourceBlob, String targetBlob) {
      return of(sourceBucket, sourceBlob,
          BlobInfo.builder(BlobId.of(sourceBucket, targetBlob)).build());
    }

    public static CopyRequest of(BlobId sourceBlobId, String targetBlob) {
      return of(sourceBlobId,
          BlobInfo.builder(BlobId.of(sourceBlobId.bucket(), targetBlob)).build());
    }

    public static Builder builder() {
      return new Builder();
    }
  }

  /**
   * Create a new bucket.
   *
   * @return a complete bucket information.
   * @throws StorageException upon failure
   */
  BucketInfo create(BucketInfo bucketInfo, BucketTargetOption... options);

  /**
   * Create a new blob with no content.
   *
   * @return a complete blob information.
   * @throws StorageException upon failure
   */
  BlobInfo create(BlobInfo blobInfo, BlobTargetOption... options);

  /**
   * Create a new blob. Direct upload is used to upload {@code content}. For large content,
   * {@link #writer} is recommended as it uses resumable upload. MD5 and CRC32C hashes of
   * {@code content} are computed and used for validating transferred data.
   *
   * @return a complete blob information.
   * @throws StorageException upon failure
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags">Hashes and ETags</a>
   */
  BlobInfo create(BlobInfo blobInfo, byte[] content, BlobTargetOption... options);

  /**
   * Create a new blob. Direct upload is used to upload {@code content}. For large content,
   * {@link #writer} is recommended as it uses resumable upload. By default any md5 and crc32c
   * values in the given {@code blobInfo} are ignored unless requested via the
   * {@code BlobWriteOption.md5Match} and {@code BlobWriteOption.crc32cMatch} options.
   *
   * @return a complete blob information.
   * @throws StorageException upon failure
   */
  BlobInfo create(BlobInfo blobInfo, InputStream content, BlobWriteOption... options);

  /**
   * Return the requested bucket or {@code null} if not found.
   *
   * @throws StorageException upon failure
   */
  BucketInfo get(String bucket, BucketSourceOption... options);

  /**
   * Return the requested blob or {@code null} if not found.
   *
   * @throws StorageException upon failure
   */
  BlobInfo get(String bucket, String blob, BlobSourceOption... options);

  /**
   * Return the requested blob or {@code null} if not found.
   *
   * @throws StorageException upon failure
   */
  BlobInfo get(BlobId blob, BlobSourceOption... options);

  /**
   * Return the requested blob or {@code null} if not found.
   *
   * @throws StorageException upon failure
   */
  BlobInfo get(BlobId blob);

  /**
   * List the project's buckets.
   *
   * @throws StorageException upon failure
   */
  ListResult<BucketInfo> list(BucketListOption... options);

  /**
   * List the bucket's blobs.
   *
   * @throws StorageException upon failure
   */
  ListResult<BlobInfo> list(String bucket, BlobListOption... options);

  /**
   * Update bucket information.
   *
   * @return the updated bucket
   * @throws StorageException upon failure
   */
  BucketInfo update(BucketInfo bucketInfo, BucketTargetOption... options);

  /**
   * Update blob information.
   *
   * @return the updated blob
   * @throws StorageException upon failure
   */
  BlobInfo update(BlobInfo blobInfo, BlobTargetOption... options);

  /**
   * Update blob information.
   *
   * @return the updated blob
   * @throws StorageException upon failure
   */
  BlobInfo update(BlobInfo blobInfo);

  /**
   * Delete the requested bucket.
   *
   * @return true if bucket was deleted
   * @throws StorageException upon failure
   */
  boolean delete(String bucket, BucketSourceOption... options);

  /**
   * Delete the requested blob.
   *
   * @return true if blob was deleted
   * @throws StorageException upon failure
   */
  boolean delete(String bucket, String blob, BlobSourceOption... options);

  /**
   * Delete the requested blob.
   *
   * @return true if blob was deleted
   * @throws StorageException upon failure
   */
  boolean delete(BlobId blob, BlobSourceOption... options);

  /**
   * Delete the requested blob.
   *
   * @return true if blob was deleted
   * @throws StorageException upon failure
   */
  boolean delete(BlobId blob);

  /**
   * Send a compose request.
   *
   * @return the composed blob.
   * @throws StorageException upon failure
   */
  BlobInfo compose(ComposeRequest composeRequest);

  /**
   * Send a copy request.
   *
   * @return the copied blob.
   * @throws StorageException upon failure
   */
  BlobInfo copy(CopyRequest copyRequest);

  /**
   * Reads all the bytes from a blob.
   *
   * @return the blob's content.
   * @throws StorageException upon failure
   */
  byte[] readAllBytes(String bucket, String blob, BlobSourceOption... options);

  /**
   * Reads all the bytes from a blob.
   *
   * @return the blob's content.
   * @throws StorageException upon failure
   */
  byte[] readAllBytes(BlobId blob, BlobSourceOption... options);

  /**
   * Send a batch request.
   *
   * @return the batch response
   * @throws StorageException upon failure
   */
  BatchResponse apply(BatchRequest batchRequest);

  /**
   * Return a channel for reading the blob's content.
   *
   * @throws StorageException upon failure
   */
  BlobReadChannel reader(String bucket, String blob, BlobSourceOption... options);

  /**
   * Return a channel for reading the blob's content.
   *
   * @throws StorageException upon failure
   */
  BlobReadChannel reader(BlobId blob, BlobSourceOption... options);

  /**
   * Create a blob and return a channel for writing its content. By default any md5 and crc32c
   * values in the given {@code blobInfo} are ignored unless requested via the
   * {@code BlobWriteOption.md5Match} and {@code BlobWriteOption.crc32cMatch} options.
   *
   * @throws StorageException upon failure
   */
  BlobWriteChannel writer(BlobInfo blobInfo, BlobWriteOption... options);

  /**
   * Generates a signed URL for a blob.
   * If you have a blob that you want to allow access to for a fixed
   * amount of time, you can use this method to generate a URL that
   * is only valid within a certain time period.
   * This is particularly useful if you don't want publicly
   * accessible blobs, but don't want to require users to explicitly log in.
   * <p>
   * Example usage of creating a signed URL that is valid for 2 weeks:
   * <pre>   {@code
   *     service.signUrl(BlobInfo.builder("bucket", "name").build(), 14, TimeUnit.DAYS);
   * }</pre>
   *
   * @param blobInfo the blob associated with the signed URL
   * @param duration time until the signed URL expires, expressed in {@code unit}. The finer
   *     granularity supported is 1 second, finer granularities will be truncated
   * @param unit time unit of the {@code duration} parameter
   * @param options optional URL signing options
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed-URLs</a>
   */
  URL signUrl(BlobInfo blobInfo, long duration, TimeUnit unit, SignUrlOption... options);

  /**
   * Gets the requested blobs. A batch request is used to perform this call.
   *
   * @param blobIds blobs to get
   * @return an immutable list of {@code BlobInfo} objects. If a blob does not exist or access to it
   *     has been denied the corresponding item in the list is {@code null}.
   * @throws StorageException upon failure
   */
  List<BlobInfo> get(BlobId... blobIds);

  /**
   * Updates the requested blobs. A batch request is used to perform this call.
   *
   * @param blobInfos blobs to update
   * @return an immutable list of {@code BlobInfo} objects. If a blob does not exist or access to it
   *     has been denied the corresponding item in the list is {@code null}.
   * @throws StorageException upon failure
   */
  List<BlobInfo> update(BlobInfo... blobInfos);

  /**
   * Deletes the requested blobs. A batch request is used to perform this call.
   *
   * @param blobIds blobs to delete
   * @return an immutable list of booleans. If a blob has been deleted the corresponding item in the
   *     list is {@code true}. If deletion failed or access to the resource was denied the item is
   *     {@code false}.
   * @throws StorageException upon failure
   */
  List<Boolean> delete(BlobId... blobIds);
}
