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
import com.google.gcloud.AuthCredentials.ServiceAccountAuthCredentials;
import com.google.gcloud.Service;
import com.google.gcloud.spi.StorageRpc;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * An interface for Google Cloud Storage.
 *
 * @see <a href="https://cloud.google.com/storage/docs">Google Cloud Storage</a>
 */
public interface Storage extends Service<StorageOptions> {

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
      return of(sources, BlobInfo.of(bucket, target));
    }

    public static Builder builder() {
      return new Builder();
    }
  }

  class CopyRequest implements Serializable {

    private static final long serialVersionUID = -2606508373751748775L;

    private final String sourceBucket;
    private final String sourceBlob;
    private final List<BlobSourceOption> sourceOptions;
    private final BlobInfo target;
    private final List<BlobTargetOption> targetOptions;

    public static class Builder {

      private final Set<BlobSourceOption> sourceOptions = new LinkedHashSet<>();
      private final Set<BlobTargetOption> targetOptions = new LinkedHashSet<>();
      private String sourceBucket;
      private String sourceBlob;
      private BlobInfo target;

      public Builder source(String bucket, String blob) {
        this.sourceBucket = bucket;
        this.sourceBlob = blob;
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
        checkNotNull(sourceBucket);
        checkNotNull(sourceBlob);
        checkNotNull(target);
        return new CopyRequest(this);
      }
    }

    private CopyRequest(Builder builder) {
      sourceBucket = checkNotNull(builder.sourceBucket);
      sourceBlob = checkNotNull(builder.sourceBlob);
      sourceOptions = ImmutableList.copyOf(builder.sourceOptions);
      target = checkNotNull(builder.target);
      targetOptions = ImmutableList.copyOf(builder.targetOptions);
    }

    public String sourceBucket() {
      return sourceBucket;
    }

    public String sourceBlob() {
      return sourceBlob;
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

    public static CopyRequest of(String sourceBucket, String sourceBlob, String targetBlob) {
      return of(sourceBucket, sourceBlob, BlobInfo.of(sourceBucket, targetBlob));
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
   * {@link #writer} is recommended as it uses resumable upload.
   *
   * @return a complete blob information.
   * @throws StorageException upon failure
   */
  BlobInfo create(BlobInfo blobInfo, byte[] content, BlobTargetOption... options);

  /**
   * Create a new blob. Direct upload is used to upload {@code content}. For large content,
   * {@link #writer} is recommended as it uses resumable upload.
   *
   * @return a complete blob information.
   * @throws StorageException upon failure
   */
  BlobInfo create(BlobInfo blobInfo, InputStream content, BlobTargetOption... options);

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
   * Create a blob and return a channel for writing its content.
   *
   * @throws StorageException upon failure
   */
  BlobWriteChannel writer(BlobInfo blobInfo, BlobTargetOption... options);

  /**
   * Generates a signed URL for a blob.
   * If you have a blob that you want to allow access to for a fixed
   * amount of time, you can use this method to generate a URL that
   * is only valid within a certain time period.
   * This is particularly useful if you don't want publicly
   * accessible blobs, but don't want to require users to explicitly log in.
   *
   * @param blobInfo the blob associated with the signed url
   * @param  expirationTimeInSeconds the signed URL expiration (using epoch time)
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed-URLs</a>
   */
  URL signUrl(BlobInfo blobInfo, long expirationTimeInSeconds, SignUrlOption... options);

  /**
   * Gets the requested blobs. A batch request is used to perform this call.
   *
   * @param blobInfo1 first blob to get
   * @param blobInfo2 second blob to get
   * @param blobInfos other blobs to get
   * @return an immutable list of {@code BlobInfo} objects. If a blob does not exist or access to it
   * has been denied the corresponding item in the list is {@code null}.
   */
  List<BlobInfo> get(BlobInfo blobInfo1, BlobInfo blobInfo2, BlobInfo... blobInfos);

  /**
   * Updates the requested blobs. A batch request is used to perform this call.
   *
   * @param blobInfo1 first blob to update
   * @param blobInfo2 second blob to update
   * @param blobInfos other blobs to update
   * @return an immutable list of {@code BlobInfo} objects. If a blob does not exist or access to it
   * has been denied the corresponding item in the list is {@code null}.
   */
  List<BlobInfo> update(BlobInfo blobInfo1, BlobInfo blobInfo2, BlobInfo... blobInfos);

  /**
   * Deletes the requested blobs. A batch request is used to perform this call.
   *
   * @param blobInfo1 first blob to delete
   * @param blobInfo2 second blob to delete
   * @param blobInfos other blobs to delete
   * @return an immutable list of booleans. If a blob has been deleted the corresponding item in the
   * list is {@code true}. If deletion failed or access to the resource was denied the item is
   * {@code false}.
   */
  List<Boolean> delete(BlobInfo blobInfo1, BlobInfo blobInfo2, BlobInfo... blobInfos);
}
