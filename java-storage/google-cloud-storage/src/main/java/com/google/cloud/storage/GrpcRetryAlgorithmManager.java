/*
 * Copyright 2022 Google LLC
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
import com.google.common.base.MoreObjects;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.protobuf.ByteString;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.ComposeObjectRequest;
import com.google.storage.v2.CreateBucketRequest;
import com.google.storage.v2.DeleteBucketRequest;
import com.google.storage.v2.DeleteObjectRequest;
import com.google.storage.v2.GetBucketRequest;
import com.google.storage.v2.GetObjectRequest;
import com.google.storage.v2.ListBucketsRequest;
import com.google.storage.v2.ListObjectsRequest;
import com.google.storage.v2.LockBucketRetentionPolicyRequest;
import com.google.storage.v2.MoveObjectRequest;
import com.google.storage.v2.QueryWriteStatusRequest;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.RestoreObjectRequest;
import com.google.storage.v2.RewriteObjectRequest;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.UpdateBucketRequest;
import com.google.storage.v2.UpdateObjectRequest;
import com.google.storage.v2.WriteObjectRequest;
import java.io.Serializable;
import java.util.Objects;

final class GrpcRetryAlgorithmManager implements Serializable {

  private static final long serialVersionUID = 3084833873820431477L;
  final StorageRetryStrategy retryStrategy;

  GrpcRetryAlgorithmManager(StorageRetryStrategy retryStrategy) {
    this.retryStrategy = retryStrategy;
  }

  /**
   * Some operations are inherently idempotent after they're started (Resumable uploads, rewrites)
   * provide access to the idempotent {@link ResultRetryAlgorithm} for those uses.
   */
  ResultRetryAlgorithm<?> idempotent() {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(ComposeObjectRequest req) {
    return req.hasIfGenerationMatch()
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(CreateBucketRequest req) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(DeleteBucketRequest req) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(DeleteObjectRequest req) {
    if (req.getGeneration() > 0 || req.hasIfGenerationMatch()) {
      return retryStrategy.getIdempotentHandler();
    }
    return retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(GetBucketRequest req) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(GetIamPolicyRequest req) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(GetObjectRequest req) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(RestoreObjectRequest req) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(ListBucketsRequest req) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(ListObjectsRequest req) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(LockBucketRetentionPolicyRequest req) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(QueryWriteStatusRequest req) {
    // unique upload Id, always idempotent
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(ReadObjectRequest req) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(RewriteObjectRequest req) {
    return req.hasIfGenerationMatch()
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(MoveObjectRequest req) {
    return req.hasIfGenerationMatch()
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(SetIamPolicyRequest req) {
    if (req.getPolicy().getEtag().equals(ByteString.empty())) {
      return retryStrategy.getNonidempotentHandler();
    } else {
      return retryStrategy.getIdempotentHandler();
    }
  }

  public ResultRetryAlgorithm<?> getFor(StartResumableWriteRequest req) {
    return req.getWriteObjectSpec().hasIfGenerationMatch()
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(TestIamPermissionsRequest req) {
    return retryStrategy.getIdempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(UpdateBucketRequest req) {
    // TODO: account for acl "patch"
    // TODO: etag
    return req.hasIfMetagenerationMatch()
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(UpdateObjectRequest req) {
    // TODO: account for acl "patch"
    return req.hasIfMetagenerationMatch()
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(WriteObjectRequest req) {
    return req.getWriteObjectSpec().hasIfGenerationMatch()
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  public ResultRetryAlgorithm<?> getFor(BidiWriteObjectRequest req) {
    return req.getWriteObjectSpec().hasIfGenerationMatch()
        ? retryStrategy.getIdempotentHandler()
        : retryStrategy.getNonidempotentHandler();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof GrpcRetryAlgorithmManager)) {
      return false;
    }
    GrpcRetryAlgorithmManager that = (GrpcRetryAlgorithmManager) o;
    return Objects.equals(retryStrategy, that.retryStrategy);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(retryStrategy);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("retryStrategy", retryStrategy).toString();
  }
}
