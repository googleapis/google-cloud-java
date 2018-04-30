/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.BackendBucketClient.ListBackendBucketsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.BackendBucket;
import com.google.cloud.compute.v1.BackendBucketList;
import com.google.cloud.compute.v1.DeleteBackendBucketHttpRequest;
import com.google.cloud.compute.v1.GetBackendBucketHttpRequest;
import com.google.cloud.compute.v1.InsertBackendBucketHttpRequest;
import com.google.cloud.compute.v1.ListBackendBucketsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchBackendBucketHttpRequest;
import com.google.cloud.compute.v1.UpdateBackendBucketHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class BackendBucketStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteBackendBucketHttpRequest, Operation> deleteBackendBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackendBucketCallable()");
  }

  @BetaApi
  public UnaryCallable<GetBackendBucketHttpRequest, BackendBucket> getBackendBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackendBucketCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertBackendBucketHttpRequest, Operation> insertBackendBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: insertBackendBucketCallable()");
  }

  @BetaApi
  public UnaryCallable<ListBackendBucketsHttpRequest, ListBackendBucketsPagedResponse>
      listBackendBucketsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackendBucketsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListBackendBucketsHttpRequest, BackendBucketList>
      listBackendBucketsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackendBucketsCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchBackendBucketHttpRequest, Operation> patchBackendBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: patchBackendBucketCallable()");
  }

  @BetaApi
  public UnaryCallable<UpdateBackendBucketHttpRequest, Operation> updateBackendBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackendBucketCallable()");
  }

  @Override
  public abstract void close();
}
