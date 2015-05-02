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

import com.google.common.collect.ImmutableList;
import com.google.gcloud.Service;
import com.google.gcloud.spi.StorageRpc;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public interface StorageService extends Service<StorageServiceOptions> {

  // todo: provide way for construct signed URLs -
  // https://cloud.google.com/storage/docs/access-control#Signed-URLs

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

    public static BucketTargetOption predefinedAcl(PredefinedAcl acl) {
      return new BucketTargetOption(StorageRpc.Option.PREDEFINED_ACL, acl.entry());
    }

    public static BucketTargetOption predefinedDefaultObjectAcl(PredefinedAcl acl) {
      return new BucketTargetOption(StorageRpc.Option.PREDEFINED_DEFAULT_OBJECT_ACL, acl.entry());
    }

    public static BucketTargetOption metagenerationMatch(boolean match) {
      return new BucketTargetOption(StorageRpc.Option.IF_METAGENERATION_MATCH, match);
    }
  }

  class BucketSourceOption extends Option {

    private static final long serialVersionUID = 5185657617120212117L;

    private BucketSourceOption(StorageRpc.Option rpcOption, Object value) {
      super(rpcOption, value);
    }

    public static BucketSourceOption metagenerationMatch(boolean match) {
      return new BucketSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH, match);
    }
  }

  class BlobTargetOption extends Option {

    private static final long serialVersionUID = 214616862061934846L;

    private BlobTargetOption(StorageRpc.Option rpcOption, Object value) {
      super(rpcOption, value);
    }

    public static BlobTargetOption predefinedAcl(PredefinedAcl acl) {
      return new BlobTargetOption(StorageRpc.Option.PREDEFINED_ACL, acl.entry());
    }

    public static BlobTargetOption generationMath(boolean match) {
      return new BlobTargetOption(StorageRpc.Option.IF_GENERATION_MATCH, match);
    }

    public static BlobTargetOption metagenerationMatch(boolean match) {
      return new BlobTargetOption(StorageRpc.Option.IF_METAGENERATION_MATCH, match);
    }
  }

  class BlobSourceOption extends Option {

    private static final long serialVersionUID = -3712768261070182991L;

    private BlobSourceOption(StorageRpc.Option rpcOption, Object value) {
      super(rpcOption, value);
    }

    public static BlobSourceOption generationMath(boolean match) {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_MATCH, match);
    }

    public static BlobSourceOption metagenerationMatch(boolean match) {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH, match);
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

      public Builder addSource(String blob, long matchGeneration) {
        sourceBlobs.add(new SourceBlob(blob, matchGeneration));
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

    public static Builder builder() {
      return new Builder();
    }
  }

  class CopyRequest implements Serializable {

    private static final long serialVersionUID = -2606508373751748775L;

    private final Blob source;
    private final List<BlobSourceOption> sourceOptions;
    private final Blob target;
    private final List<BlobTargetOption> targetOptions;

    public static class Builder {

      private Blob source;
      private final Set<BlobSourceOption> sourceOptions = new LinkedHashSet<>();
      private Blob target;
      private final Set<BlobTargetOption> targetOptions = new LinkedHashSet<>();

      public Builder source(Blob source) {
        this.source = source;
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

    public Blob source() {
      return source;
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

    public static CopyRequest of(Blob source, Blob target) {
      return builder().source(source).target(target).build();
    }

    public static Builder builder() {
      return new Builder();
    }
  }

  /**
   * @throws StorageServiceException upon failure
   */
  Bucket create(Bucket bucket, BucketTargetOption... options);

  /**
   * @throws StorageServiceException upon failure
   */
  Blob create(Blob blob, byte[] content, BlobTargetOption... options);

  /**
   * @throws StorageServiceException upon failure
   */
  Bucket get(Bucket bucket, BucketSourceOption... options);

  /**
   * @throws StorageServiceException upon failure
   */
  Blob get(Blob blob, BlobSourceOption... options);

  /**
   * @throws StorageServiceException upon failure
   */
  ListResult<Bucket> list(BucketListOption... options);

  /**
   * Lists blobs for a bucket.
   * @throws StorageServiceException upon failure
   */
  ListResult<Blob> list(String bucket, BlobListOption... options);

  /**
   * @throws StorageServiceException upon failure
   */
  Bucket update(Bucket bucket, BucketTargetOption... options);

  /**
   * @throws StorageServiceException upon failure
   */
  Blob update(Blob blob, BlobTargetOption... options);

  /**
   * @throws StorageServiceException upon failure
   */
  boolean delete(Bucket bucket, BucketSourceOption... options);

  /**
   * @throws StorageServiceException upon failure
   */
  boolean delete(Blob blob, BlobSourceOption... options);

  /**
   * @throws StorageServiceException upon failure
   */
  Blob compose(ComposeRequest composeRequest);

  /**
   * @throws StorageServiceException upon failure
   */
  Blob copy(CopyRequest copyRequest);

  /**
   * @throws StorageServiceException upon failure
   */
  byte[] load(Blob blob, BlobSourceOption... options);


  BatchResponse apply(BatchRequest batchRequest);

  /**
   * @throws StorageServiceException upon failure
   */
  BlobReadChannel reader(Blob blob, BlobSourceOption... options);

  /**
   * @throws StorageServiceException upon failure
   */
  BlobWriteChannel writer(Blob blob, BlobTargetOption... options);
}
