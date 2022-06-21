/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.BackendBucketsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendBucketRequest;
import com.google.cloud.compute.v1.BackendBucket;
import com.google.cloud.compute.v1.BackendBucketList;
import com.google.cloud.compute.v1.DeleteBackendBucketRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendBucketRequest;
import com.google.cloud.compute.v1.GetBackendBucketRequest;
import com.google.cloud.compute.v1.InsertBackendBucketRequest;
import com.google.cloud.compute.v1.ListBackendBucketsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchBackendBucketRequest;
import com.google.cloud.compute.v1.SetEdgeSecurityPolicyBackendBucketRequest;
import com.google.cloud.compute.v1.UpdateBackendBucketRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BackendBuckets service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class BackendBucketsStub implements BackgroundResource {

  public OperationCallable<AddSignedUrlKeyBackendBucketRequest, Operation, Operation>
      addSignedUrlKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addSignedUrlKeyOperationCallable()");
  }

  public UnaryCallable<AddSignedUrlKeyBackendBucketRequest, Operation> addSignedUrlKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: addSignedUrlKeyCallable()");
  }

  public OperationCallable<DeleteBackendBucketRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteBackendBucketRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public OperationCallable<DeleteSignedUrlKeyBackendBucketRequest, Operation, Operation>
      deleteSignedUrlKeyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSignedUrlKeyOperationCallable()");
  }

  public UnaryCallable<DeleteSignedUrlKeyBackendBucketRequest, Operation>
      deleteSignedUrlKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSignedUrlKeyCallable()");
  }

  public UnaryCallable<GetBackendBucketRequest, BackendBucket> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertBackendBucketRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertBackendBucketRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListBackendBucketsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListBackendBucketsRequest, BackendBucketList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PatchBackendBucketRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchBackendBucketRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public OperationCallable<SetEdgeSecurityPolicyBackendBucketRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setEdgeSecurityPolicyOperationCallable()");
  }

  public UnaryCallable<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
      setEdgeSecurityPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setEdgeSecurityPolicyCallable()");
  }

  public OperationCallable<UpdateBackendBucketRequest, Operation, Operation>
      updateOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOperationCallable()");
  }

  public UnaryCallable<UpdateBackendBucketRequest, Operation> updateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCallable()");
  }

  @Override
  public abstract void close();
}
