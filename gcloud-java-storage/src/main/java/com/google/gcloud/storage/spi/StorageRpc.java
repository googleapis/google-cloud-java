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

package com.google.gcloud.storage.spi;

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.StorageObject;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.storage.StorageException;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface StorageRpc {

  // These options are part of the Google Cloud storage header options
  enum Option {
    PREDEFINED_ACL("predefinedAcl"),
    PREDEFINED_DEFAULT_OBJECT_ACL("predefinedDefaultObjectAcl"),
    IF_METAGENERATION_MATCH("ifMetagenerationMatch"),
    IF_METAGENERATION_NOT_MATCH("ifMetagenerationNotMatch"),
    IF_GENERATION_MATCH("ifGenerationMatch"),
    IF_GENERATION_NOT_MATCH("ifGenerationNotMatch"),
    IF_SOURCE_METAGENERATION_MATCH("ifSourceMetagenerationMatch"),
    IF_SOURCE_METAGENERATION_NOT_MATCH("ifSourceMetagenerationNotMatch"),
    IF_SOURCE_GENERATION_MATCH("ifSourceGenerationMatch"),
    IF_SOURCE_GENERATION_NOT_MATCH("ifSourceGenerationNotMatch"),
    PREFIX("prefix"),
    MAX_RESULTS("maxResults"),
    PAGE_TOKEN("pageToken"),
    DELIMITER("delimiter"),
    VERSIONS("versions"),
    FIELDS("fields");

    private final String value;

    Option(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }

    @SuppressWarnings("unchecked")
    <T> T get(Map<Option, ?> options) {
      return (T) options.get(this);
    }

    String getString(Map<Option, ?> options) {
      return get(options);
    }

    Long getLong(Map<Option, ?> options) {
      return get(options);
    }

    Boolean getBoolean(Map<Option, ?> options) {
      return get(options);
    }
  }

  class Tuple<X, Y> {

    private final X x;
    private final Y y;

    private Tuple(X x, Y y) {
      this.x = x;
      this.y = y;
    }

    public static <X, Y> Tuple<X, Y> of(X x, Y y) {
      return new Tuple<>(x, y);
    }

    public X x() {
      return x;
    }

    public Y y() {
      return y;
    }
  }

  class BatchRequest {

    public final List<Tuple<StorageObject, Map<Option, ?>>> toDelete;
    public final List<Tuple<StorageObject, Map<Option, ?>>> toUpdate;
    public final List<Tuple<StorageObject, Map<Option, ?>>> toGet;

    public BatchRequest(Iterable<Tuple<StorageObject, Map<Option, ?>>> toDelete,
        Iterable<Tuple<StorageObject, Map<Option, ?>>> toUpdate,
        Iterable<Tuple<StorageObject, Map<Option, ?>>> toGet) {
      this.toDelete = ImmutableList.copyOf(
          firstNonNull(toDelete, ImmutableList.<Tuple<StorageObject, Map<Option, ?>>>of()));
      this.toUpdate = ImmutableList.copyOf(
          firstNonNull(toUpdate, ImmutableList.<Tuple<StorageObject, Map<Option, ?>>>of()));
      this.toGet = ImmutableList.copyOf(
          firstNonNull(toGet, ImmutableList.<Tuple<StorageObject, Map<Option, ?>>>of()));
    }
  }

  class BatchResponse {

    public final Map<StorageObject, Tuple<Boolean, StorageException>> deletes;
    public final Map<StorageObject, Tuple<StorageObject, StorageException>> updates;
    public final Map<StorageObject, Tuple<StorageObject, StorageException>> gets;

    public BatchResponse(Map<StorageObject, Tuple<Boolean, StorageException>> deletes,
        Map<StorageObject, Tuple<StorageObject, StorageException>> updates,
        Map<StorageObject, Tuple<StorageObject, StorageException>> gets) {
      this.deletes = ImmutableMap.copyOf(deletes);
      this.updates = ImmutableMap.copyOf(updates);
      this.gets = ImmutableMap.copyOf(gets);
    }
  }

  class RewriteRequest {

    public final StorageObject source;
    public final Map<StorageRpc.Option, ?> sourceOptions;
    public final boolean overrideInfo;
    public final StorageObject target;
    public final Map<StorageRpc.Option, ?> targetOptions;
    public final Long megabytesRewrittenPerCall;

    public RewriteRequest(StorageObject source, Map<StorageRpc.Option, ?> sourceOptions,
        boolean overrideInfo, StorageObject target, Map<StorageRpc.Option, ?> targetOptions,
        Long megabytesRewrittenPerCall) {
      this.source = source;
      this.sourceOptions = sourceOptions;
      this.overrideInfo = overrideInfo;
      this.target = target;
      this.targetOptions = targetOptions;
      this.megabytesRewrittenPerCall = megabytesRewrittenPerCall;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof RewriteRequest)) {
        return false;
      }
      final RewriteRequest other = (RewriteRequest) obj;
      return Objects.equals(this.source, other.source)
          && Objects.equals(this.sourceOptions, other.sourceOptions)
          && Objects.equals(this.overrideInfo, other.overrideInfo)
          && Objects.equals(this.target, other.target)
          && Objects.equals(this.targetOptions, other.targetOptions)
          && Objects.equals(this.megabytesRewrittenPerCall, other.megabytesRewrittenPerCall);
    }

    @Override
    public int hashCode() {
      return Objects.hash(source, sourceOptions, overrideInfo, target, targetOptions,
          megabytesRewrittenPerCall);
    }
  }

  class RewriteResponse {

    public final RewriteRequest rewriteRequest;
    public final StorageObject result;
    public final long blobSize;
    public final boolean isDone;
    public final String rewriteToken;
    public final long totalBytesRewritten;

    public RewriteResponse(RewriteRequest rewriteRequest, StorageObject result, long blobSize,
        boolean isDone, String rewriteToken, long totalBytesRewritten) {
      this.rewriteRequest = rewriteRequest;
      this.result = result;
      this.blobSize = blobSize;
      this.isDone = isDone;
      this.rewriteToken = rewriteToken;
      this.totalBytesRewritten = totalBytesRewritten;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof RewriteResponse)) {
        return false;
      }
      final RewriteResponse other = (RewriteResponse) obj;
      return Objects.equals(this.rewriteRequest, other.rewriteRequest)
          && Objects.equals(this.result, other.result)
          && Objects.equals(this.rewriteToken, other.rewriteToken)
          && this.blobSize == other.blobSize
          && Objects.equals(this.isDone, other.isDone)
          && this.totalBytesRewritten == other.totalBytesRewritten;
    }

    @Override
    public int hashCode() {
      return Objects.hash(rewriteRequest, result, blobSize, isDone, rewriteToken,
          totalBytesRewritten);
    }
  }

  /**
   * Creates a new bucket.
   *
   * @throws StorageException upon failure
   */
  Bucket create(Bucket bucket, Map<Option, ?> options);

  /**
   * Creates a new storage object.
   *
   * @throws StorageException upon failure
   */
  StorageObject create(StorageObject object, InputStream content, Map<Option, ?> options);

  /**
   * Lists the project's buckets.
   *
   * @throws StorageException upon failure
   */
  Tuple<String, Iterable<Bucket>> list(Map<Option, ?> options);

  /**
   * Lists the bucket's blobs.
   *
   * @throws StorageException upon failure
   */
  Tuple<String, Iterable<StorageObject>> list(String bucket, Map<Option, ?> options);

  /**
   * Returns the requested bucket or {@code null} if not found.
   *
   * @throws StorageException upon failure
   */
  Bucket get(Bucket bucket, Map<Option, ?> options);

  /**
   * Returns the requested storage object or {@code null} if not found.
   *
   * @throws StorageException upon failure
   */
  StorageObject get(StorageObject object, Map<Option, ?> options);

  /**
   * Updates bucket information.
   *
   * @throws StorageException upon failure
   */
  Bucket patch(Bucket bucket, Map<Option, ?> options);

  /**
   * Updates the storage object's information. Original metadata are merged with metadata in the
   * provided {@code storageObject}.
   *
   * @throws StorageException upon failure
   */
  StorageObject patch(StorageObject storageObject, Map<Option, ?> options);

  /**
   * Deletes the requested bucket.
   *
   * @return {@code true} if the bucket was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  boolean delete(Bucket bucket, Map<Option, ?> options);

  /**
   * Deletes the requested storage object.
   *
   * @return {@code true} if the storage object was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  boolean delete(StorageObject object, Map<Option, ?> options);

  /**
   * Sends a batch request.
   *
   * @throws StorageException upon failure
   */
  BatchResponse batch(BatchRequest request);

  /**
   * Sends a compose request.
   *
   * @throws StorageException upon failure
   */
  StorageObject compose(Iterable<StorageObject> sources, StorageObject target,
      Map<Option, ?> targetOptions);

  /**
   * Reads all the bytes from a storage object.
   *
   * @throws StorageException upon failure
   */
  byte[] load(StorageObject storageObject, Map<Option, ?> options);

  /**
   * Reads the given amount of bytes from a storage object at the given position.
   *
   * @throws StorageException upon failure
   */
  Tuple<String, byte[]> read(StorageObject from, Map<Option, ?> options, long position, int bytes);

  /**
   * Opens a resumable upload channel for a given storage object.
   *
   * @throws StorageException upon failure
   */
  String open(StorageObject object, Map<Option, ?> options);

  /**
   * Writes the provided bytes to a storage object at the provided location.
   *
   * @throws StorageException upon failure
   */
  void write(String uploadId, byte[] toWrite, int toWriteOffset, long destOffset, int length,
      boolean last);

  /**
   * Sends a rewrite request to open a rewrite channel.
   *
   * @throws StorageException upon failure
   */
  RewriteResponse openRewrite(RewriteRequest rewriteRequest);

  /**
   * Continues rewriting on an already open rewrite channel.
   *
   * @throws StorageException upon failure
   */
  RewriteResponse continueRewrite(RewriteResponse previousResponse);
}
