/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.storage;

import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.HmacKeyMetadata;
import com.google.api.services.storage.model.Notification;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.cloud.storage.spi.v1.StorageRpc.RewriteRequest;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class HttpRetryAlgorithmManager implements Serializable {

  private static final long serialVersionUID = -3301856948991518651L;
  final StorageRetryStrategy retryStrategy;

  HttpRetryAlgorithmManager(StorageRetryStrategy retryStrategy) {
    this.retryStrategy = retryStrategy;
  }

  /**
   * Some operations are inherently idempotent after they're started (Resumable uploads, rewrites)
   * provide access to the idempotent {@link ResultRetryAlgorithm} for those uses.
   */
  ResultRetryAlgorithm<?> idempotent() {
    return retryStrategy.getIdempotentHandler();
  }

  ResultRetryAlgorithm<?> nonIdempotent() {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketAclCreate(
      BucketAccessControl pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketAclDelete(
      String pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketAclGet(
      String pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketAclUpdate(
      BucketAccessControl pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketAclList(
      String pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketsCreate(
      Bucket pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketsDelete(
      Bucket pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketsGet(Bucket pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketsUpdate(
      Bucket pb, Map<StorageRpc.Option, ?> optionsMap) {
    // TODO: Include etag when it is supported by the library
    return optionsMap.containsKey(StorageRpc.Option.IF_METAGENERATION_MATCH)
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketsList(Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketsLockRetentionPolicy(
      Bucket pb, Map<StorageRpc.Option, ?> optionsMap) {
    // Always idempotent because IfMetagenerationMatch is required
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketsGetIamPolicy(
      String bucket, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketsSetIamPolicy(
      String bucket, Policy pb, Map<StorageRpc.Option, ?> optionsMap) {
    return pb.getEtag() != null
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForBucketsTestIamPermissions(
      String bucket, List<String> permissions, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForDefaultObjectAclCreate(ObjectAccessControl pb) {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForDefaultObjectAclDelete(String pb) {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForDefaultObjectAclGet(String pb) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForDefaultObjectAclUpdate(ObjectAccessControl pb) {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForDefaultObjectAclList(String pb) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForHmacKeyCreate(
      String pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForHmacKeyDelete(
      HmacKeyMetadata pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForHmacKeyGet(
      String accessId, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForHmacKeyUpdate(
      HmacKeyMetadata pb, Map<StorageRpc.Option, ?> optionsMap) {
    // TODO: Include etag when it is supported by the library
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForHmacKeyList(Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectAclCreate(ObjectAccessControl aclPb) {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectAclDelete(
      String bucket, String name, Long generation, String pb) {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectAclList(String bucket, String name, Long generation) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectAclGet(
      String bucket, String name, Long generation, String pb) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectAclUpdate(ObjectAccessControl aclPb) {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectsCreate(
      StorageObject pb, Map<StorageRpc.Option, ?> optionsMap) {
    if (pb.getGeneration() != null && pb.getGeneration() == 0) {
      return retryStrategy.getIdempotentHandler();
    }
    return optionsMap.containsKey(StorageRpc.Option.IF_GENERATION_MATCH)
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectsDelete(
      StorageObject pb, Map<StorageRpc.Option, ?> optionsMap) {
    return optionsMap.containsKey(StorageRpc.Option.IF_GENERATION_MATCH)
            || (pb.getGeneration() != null && pb.getGeneration() > 0)
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectsGet(
      StorageObject pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectsRestore(
      StorageObject pb, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectsUpdate(
      StorageObject pb, Map<StorageRpc.Option, ?> optionsMap) {
    return optionsMap.containsKey(StorageRpc.Option.IF_METAGENERATION_MATCH)
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectsList(
      String bucket, Map<StorageRpc.Option, ?> optionsMap) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectsRewrite(RewriteRequest pb) {
    return pb.targetOptions.containsKey(StorageRpc.Option.IF_GENERATION_MATCH)
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectsMove(
      ImmutableMap<StorageRpc.Option, ?> sourceOptions,
      ImmutableMap<StorageRpc.Option, ?> targetOptions) {
    return targetOptions.containsKey(StorageRpc.Option.IF_GENERATION_MATCH)
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForObjectsCompose(
      List<StorageObject> sources, StorageObject target, Map<StorageRpc.Option, ?> optionsMap) {
    return optionsMap.containsKey(StorageRpc.Option.IF_GENERATION_MATCH)
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForResumableUploadSessionCreate(
      Map<StorageRpc.Option, ?> optionsMap) {
    return optionsMap.containsKey(StorageRpc.Option.IF_GENERATION_MATCH)
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForResumableUploadSessionWrite(
      Map<StorageRpc.Option, ?> optionsMap) {
    // writing to a resumable upload session is always idempotent once it's active
    // even if the start of the session wasn't idempotent our incremental writes can be.
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForServiceAccountGet(String pb) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForNotificationCreate(String bucket, Notification pb) {
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForNotificationGet(String bucket, String notificationId) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForNotificationList(String bucket) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getForNotificationDelete(String bucket, String notificationId) {
    return retryStrategy.getIdempotentHandler();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof HttpRetryAlgorithmManager)) {
      return false;
    }
    HttpRetryAlgorithmManager that = (HttpRetryAlgorithmManager) o;
    return Objects.equals(retryStrategy, that.retryStrategy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(retryStrategy);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("retryStrategy", retryStrategy).toString();
  }
}
