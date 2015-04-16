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

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public interface StorageService extends Service<StorageServiceOptions> {

  // todo: provide way for construct signed URLs - https://cloud.google.com/storage/docs/access-control#Signed-URLs

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

  class Option implements Serializable {

    private static final long serialVersionUID = -73199088766477208L;

    private final String name;
    private final Object value;

    Option(String name, Object value) {
      this.name = checkNotNull(name);
      this.value = value;
    }

    String name() {
      return name;
    }

    Object value() {
      return value;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Option)) {
        return false;
      }
      Option other = (Option) obj;
      return Objects.equals(name, other.name)
          && Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, value);
    }
  }

  class BucketTargetOption extends Option {

    private static final long serialVersionUID = -5880204616982900975L;

    private BucketTargetOption(String name, Object value) {
      super(name, value);
    }

    public static BucketTargetOption predefinedAcl(PredefinedAcl acl) {
      return new BucketTargetOption("predefinedAcl", acl.entry());
    }

    public static BucketTargetOption predefinedDefaultObjectAcl(PredefinedAcl acl) {
      return new BucketTargetOption("predefinedDefaultObjectAcl", acl.entry());
    }

    public static BucketTargetOption metagenerationMatch(boolean match) {
      return new BucketTargetOption("ifMetagenerationMatch", match);
    }
  }

  class BucketSourceOption extends Option {

    private static final long serialVersionUID = 5185657617120212117L;

    private BucketSourceOption(String name, Object value) {
      super(name, value);
    }

    public static BucketSourceOption metagenerationMatch(boolean match) {
      return new BucketSourceOption("ifMetagenerationMatch", match);
    }
  }

  class BlobTargetOption extends Option {

    private static final long serialVersionUID = 214616862061934846L;

    private BlobTargetOption(String name, Object value) {
      super(name, value);
    }

    public static BlobTargetOption predefinedAcl(PredefinedAcl acl) {
      return new BlobTargetOption("predefinedAcl", acl.entry());
    }

    public static BlobTargetOption generationMath(boolean match) {
      return new BlobTargetOption("ifMetagenerationMatch", match);
    }

    public static BlobTargetOption metagenerationMatch(boolean match) {
      return new BlobTargetOption("ifMetagenerationMatch", match);
    }
  }

  class BlobSourceOption extends Option {

    private static final long serialVersionUID = -3712768261070182991L;

    private BlobSourceOption(String name, Object value) {
      super(name, value);
    }

    public static BlobSourceOption generationMath(boolean match) {
      return new BlobSourceOption("ifGenerationMatch", match);
    }

    public static BlobSourceOption metagenerationMatch(boolean match) {
      return new BlobSourceOption("ifMetagenerationMatch", match);
    }
  }

  class ComposeRequest implements Serializable {

    private static final long serialVersionUID = -7385681353748590911L;

    private final String sourceBucket;
    private final List<SourceBlob> sourceBlobs;
    private final Blob target;
    private final List<BlobTargetOption> targetOptions;

    private static class SourceBlob implements Serializable {

      private static final long serialVersionUID = 4094962795951990439L;

      final String blob;
      final String generation;

      SourceBlob(String blob) {
        this(blob, null);
      }

      SourceBlob(String blob, String generation) {
        this.blob = blob;
        this.generation = generation;
      }
    }

    public static class Builder {

      private String bucket;
      private List<SourceBlob> sourceBlobs = new LinkedList<>();
      private Blob target;
      private Set<BlobTargetOption> targetOptions = new LinkedHashSet<>();

      public Builder sourceBucket(String bucket) {
        this.bucket = bucket;
        return this;
      }

      public Builder addSource(Iterable<String> blobs) {
        for (String blob : blobs) {
          sourceBlobs.add(new SourceBlob(blob));
        }
        return this;
      }

      public Builder addSource(String... blobs) {
        return addSource(Arrays.asList(blobs));
      }

      public Builder addSource(String blob, String generation) {
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
        return new ComposeRequest(this);
      }
    }

    private ComposeRequest(Builder builder) {
      sourceBucket = checkNotNull(builder.bucket);
      sourceBlobs = ImmutableList.copyOf(builder.sourceBlobs);
      target = checkNotNull(builder.target);
      targetOptions = ImmutableList.copyOf(builder.targetOptions);
    }

    String sourceBucket() {
      return sourceBucket;
    }

    List<SourceBlob> sourceBlobs() {
      return sourceBlobs;
    }

    Blob target() {
      return target;
    }

    List<BlobTargetOption> targetOptions() {
      return targetOptions;
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
      private Set<BlobSourceOption> sourceOptions;
      private Blob target;
      private Set<BlobTargetOption> targetOptions;

      public void source(Blob source) {
        this.source = source;
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
        return new CopyRequest(this);
      }
    }

    private CopyRequest(Builder builder) {
      source = checkNotNull(builder.source);
      sourceOptions = ImmutableList.copyOf(builder.sourceOptions);
      target = checkNotNull(builder.target);
      targetOptions = ImmutableList.copyOf(builder.targetOptions);
    }

    Blob source() {
      return source;
    }

    public List<BlobSourceOption> sourceOptions() {
      return sourceOptions;
    }

    Blob target() {
      return target;
    }

    List<BlobTargetOption> targetOptions() {
      return targetOptions;
    }

    public static Builder builder() {
      return new Builder();
    }
  }

  Bucket create(Bucket bucket, BucketTargetOption... option);

  Blob create(Blob blob, ByteBuffer content, BlobTargetOption... option);

  Bucket get(String bucket, BucketSourceOption... options);

  Blob get(String bucket, String blob, BlobSourceOption... options);

  Iterator<Bucket> list();

  Iterator<Blob> list(String bucket, ListOptions settings);

  Bucket update(Bucket bucket, BucketTargetOption... option);

  Blob update(Blob blob, BlobTargetOption... option);

  void delete(Bucket bucket, BucketSourceOption... option);

  void delete(Blob blob, BlobSourceOption... option);

  Blob compose(ComposeRequest composeRequest);

  Blob copy(CopyRequest copyRequest);

  BlobReadChannel readFrom(Blob blob, BlobSourceOption... option);

  BlobWriteChannel writeTo(Blob blob, BlobTargetOption... option);
}
