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

package com.google.gcloud.spi;

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
    public final StorageObject target;
    public final Map<StorageRpc.Option, ?> targetOptions;
    public final Long megabytesRewrittenPerCall;

    public RewriteRequest(StorageObject source, Map<StorageRpc.Option, ?> sourceOptions,
        StorageObject target, Map<StorageRpc.Option, ?> targetOptions,
        Long megabytesRewrittenPerCall) {
      this.source = source;
      this.sourceOptions = sourceOptions;
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
          && Objects.equals(this.target, other.target)
          && Objects.equals(this.targetOptions, other.targetOptions)
          && Objects.equals(this.megabytesRewrittenPerCall, other.megabytesRewrittenPerCall);
    }

    @Override
    public int hashCode() {
      return Objects.hash(source, sourceOptions, target, targetOptions, megabytesRewrittenPerCall);
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

  Bucket create(Bucket bucket, Map<Option, ?> options) throws StorageException;

  StorageObject create(StorageObject object, InputStream content, Map<Option, ?> options)
      throws StorageException;

  Tuple<String, Iterable<Bucket>> list(Map<Option, ?> options) throws StorageException;

  Tuple<String, Iterable<StorageObject>> list(String bucket, Map<Option, ?> options)
      throws StorageException;

  /**
   * Returns the requested bucket or {@code null} if not found.
   *
   * @throws StorageException upon failure
   */
  Bucket get(Bucket bucket, Map<Option, ?> options) throws StorageException;

  /**
   * Returns the requested storage object or {@code null} if not found.
   *
   * @throws StorageException upon failure
   */
  StorageObject get(StorageObject object, Map<Option, ?> options)
      throws StorageException;

  Bucket patch(Bucket bucket, Map<Option, ?> options) throws StorageException;

  StorageObject patch(StorageObject storageObject, Map<Option, ?> options)
      throws StorageException;

  boolean delete(Bucket bucket, Map<Option, ?> options) throws StorageException;

  boolean delete(StorageObject object, Map<Option, ?> options) throws StorageException;

  BatchResponse batch(BatchRequest request) throws StorageException;

  StorageObject compose(Iterable<StorageObject> sources, StorageObject target,
      Map<Option, ?> targetOptions) throws StorageException;

  byte[] load(StorageObject storageObject, Map<Option, ?> options)
      throws StorageException;

  Tuple<String, byte[]> read(StorageObject from, Map<Option, ?> options, long position, int bytes)
      throws StorageException;

  String open(StorageObject object, Map<Option, ?> options) throws StorageException;

  void write(String uploadId, byte[] toWrite, int toWriteOffset, StorageObject dest,
      long destOffset, int length, boolean last) throws StorageException;

  RewriteResponse openRewrite(RewriteRequest rewriteRequest) throws StorageException;

  RewriteResponse continueRewrite(RewriteResponse previousResponse) throws StorageException;
}
