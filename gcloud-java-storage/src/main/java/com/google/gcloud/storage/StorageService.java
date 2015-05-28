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
import com.google.gcloud.Service;
import com.google.gcloud.spi.StorageRpc;

import java.io.Serializable;
import java.net.URL;
import java.security.PrivateKey;
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
public interface StorageService extends Service<StorageServiceOptions> {

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

    private final String name;
    private final Object value;

    enum OPTIONS {

    }
    
    private SignUrlOption(String name, Object value) {
      this.name = name;
      this.value = value;
    }

    String name() {
      return name;
    }

    Object value() {
      return value;
    }

    /**
     * The HTTP method to be used with the signed URL.
     */
    public static SignUrlOption httpMethod(HttpMethod httpMethod) {
      return new SignUrlOption("HTTP_METHOD", httpMethod.name());
    }

    /**
     * Use it if signature should include the blob's content-type.
     * When used, users of the signed URL should include the blob's content-type with their request.
     */
    public static SignUrlOption withContentType() {
      return new SignUrlOption("CONTENT_TYPE", true);
    }

    /**
     * Use it if signature should include the blob's md5.
     * When used, users of the signed URL should include the blob's md5 with their request.
     */
    public static SignUrlOption withMd5() {
      return new SignUrlOption("MD5", true);
    }

    /**
     * The private key to use for signing the URL.
     * A private key is required for signing. If not provided an attempt will be made to get
     * it from the service credentials.
     */
    public static SignUrlOption signWith(PrivateKey privateKey) {
      return new SignUrlOption("PRIVATE_KEY", privateKey);
    }
  }

  class ComposeRequest implements Serializable {

    private static final long serialVersionUID = -7385681353748590911L;

    private final List<SourceBlob> sourceBlobs;
    private final Blob target;
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
      private Blob target;
      private final Set<BlobTargetOption> targetOptions = new LinkedHashSet<>();

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

      public Builder target(Blob target) {
        this.target = target;
        return this;
      }

      public Builder targetOptions(BlobTargetOption... options) {
        Collections.addAll(targetOptions, options);
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

    public Blob target() {
      return target;
    }

    public List<BlobTargetOption> targetOptions() {
      return targetOptions;
    }

    public static ComposeRequest of(Iterable<String> sources, Blob target) {
      return builder().target(target).addSource(sources).build();
    }

    public static ComposeRequest of(String bucket, Iterable<String> sources, String target) {
      return of(sources, Blob.of(bucket, target));
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
    private final Blob target;
    private final List<BlobTargetOption> targetOptions;

    public static class Builder {

      private String sourceBucket;
      private String sourceBlob;
      private final Set<BlobSourceOption> sourceOptions = new LinkedHashSet<>();
      private Blob target;
      private final Set<BlobTargetOption> targetOptions = new LinkedHashSet<>();

      public Builder source(String bucket, String blob) {
        this.sourceBucket = bucket;
        this.sourceBlob = blob;
        return this;
      }

      public Builder sourceOptions(BlobSourceOption... options) {
        Collections.addAll(sourceOptions, options);
        return this;
      }

      public Builder target(Blob target) {
        this.target = target;
        return this;
      }

      public Builder targetOptions(BlobTargetOption... options) {
        Collections.addAll(targetOptions, options);
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

    public Blob target() {
      return target;
    }

    public List<BlobTargetOption> targetOptions() {
      return targetOptions;
    }

    public static CopyRequest of(String sourceBucket, String sourceBlob, Blob target) {
      return builder().source(sourceBucket, sourceBlob).target(target).build();
    }

    public static CopyRequest of(String sourceBucket, String sourceBlob, String targetBlob) {
      return of(sourceBucket, sourceBlob, Blob.of(sourceBucket, targetBlob));
    }

    public static Builder builder() {
      return new Builder();
    }
  }

  /**
   * Create a new bucket.
   *
   * @return a complete bucket information.
   * @throws StorageServiceException upon failure
   */
  Bucket create(Bucket bucket, BucketTargetOption... options);

  /**
   * Create a new blob.
   *
   * @return a complete blob information.
   * @throws StorageServiceException upon failure
   */
  Blob create(Blob blob, byte[] content, BlobTargetOption... options);

  /**
   * Return the requested bucket or {@code null} if not found.
   *
   * @throws StorageServiceException upon failure
   */
  Bucket get(String bucket, BucketSourceOption... options);

  /**
   * Return the requested blob or {@code null} if not found.
   *
   * @throws StorageServiceException upon failure
   */
  Blob get(String bucket, String blob, BlobSourceOption... options);

  /**
   * List the project's buckets.
   *
   * @throws StorageServiceException upon failure
   */
  ListResult<Bucket> list(BucketListOption... options);

  /**
   * List the bucket's blobs.
   *
   * @throws StorageServiceException upon failure
   */
  ListResult<Blob> list(String bucket, BlobListOption... options);

  /**
   * Update bucket information.
   *
   * @return the updated bucket
   * @throws StorageServiceException upon failure
   */
  Bucket update(Bucket bucket, BucketTargetOption... options);

  /**
   * Update blob information.
   *
   * @return the updated blob
   * @throws StorageServiceException upon failure
   */
  Blob update(Blob blob, BlobTargetOption... options);

  /**
   * Delete the requested bucket.
   *
   * @return true if bucket was deleted
   * @throws StorageServiceException upon failure
   */
  boolean delete(String bucket, BucketSourceOption... options);

  /**
   * Delete the requested blob.
   *
   * @return true if blob was deleted
   * @throws StorageServiceException upon failure
   */
  boolean delete(String bucket, String blob, BlobSourceOption... options);

  /**
   * Send a compose request.
   *
   * @return the composed blob.
   * @throws StorageServiceException upon failure
   */
  Blob compose(ComposeRequest composeRequest);

  /**
   * Send a copy request.
   *
   * @return the copied blob.
   * @throws StorageServiceException upon failure
   */
  Blob copy(CopyRequest copyRequest);

  /**
   * Load the content of the given blob.
   *
   * @return the blob's content.
   * @throws StorageServiceException upon failure
   */
  byte[] load(String bucket, String blob, BlobSourceOption... options);

  /**
   * Send a batch request.
   *
   * @return the batch response
   * @throws StorageServiceException upon failure
   */
  BatchResponse apply(BatchRequest batchRequest);

  /**
   * Return a channel for reading the blob's content.
   *
   * @throws StorageServiceException upon failure
   */
  BlobReadChannel reader(String bucket, String blob, BlobSourceOption... options);

  /**
   * Create a blob and return a channel for writing its content.
   *
   * @throws StorageServiceException upon failure
   */
  BlobWriteChannel writer(Blob blob, BlobTargetOption... options);

  /**
   * Generates a signed URL for a blob.
   * If you have a blob that you want to allow access to for a fixed
   * amount of time, you can use this method to generate a URL that
   * is only valid within a certain time period.
   * This is particularly useful if you don't want publicly
   * accessible blobs, but don't want to require users to explicitly log in.
   *
   * @param blob the blob associated with the signed url
   * @param  expirationTimeMillis the signed URL expiration (epoch time in milliseconds)
   */
  URL signUrl(Blob blob, long expirationTimeMillis, SignUrlOption... options);
}
