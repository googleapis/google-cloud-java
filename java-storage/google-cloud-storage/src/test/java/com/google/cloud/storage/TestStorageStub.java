/*
 * Copyright 2026 Google LLC
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

import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.storage.v2.Bucket;
import com.google.storage.v2.CreateBucketRequest;
import com.google.storage.v2.DeleteObjectRequest;
import com.google.storage.v2.GetObjectRequest;
import com.google.storage.v2.MoveObjectRequest;
import com.google.storage.v2.Object;
import com.google.storage.v2.RestoreObjectRequest;
import com.google.storage.v2.RewriteObjectRequest;
import com.google.storage.v2.RewriteResponse;
import com.google.storage.v2.UpdateObjectRequest;
import com.google.storage.v2.stub.StorageStub;
import java.util.concurrent.TimeUnit;
import org.mockito.Mockito;

class TestStorageStub extends StorageStub {
  UnaryCallable<CreateBucketRequest, Bucket> createBucketCallable;
  UnaryCallable<GetObjectRequest, Object> getObjectCallable;
  UnaryCallable<DeleteObjectRequest, Empty> deleteObjectCallable;
  UnaryCallable<UpdateObjectRequest, Object> updateObjectCallable;
  UnaryCallable<RestoreObjectRequest, Object> restoreObjectCallable;
  UnaryCallable<MoveObjectRequest, Object> moveObjectCallable;
  UnaryCallable<RewriteObjectRequest, RewriteResponse> rewriteObjectCallable;

  @SuppressWarnings("unchecked")
  static <ReqT, RespT> UnaryCallable<ReqT, RespT> mockCallable() {
    return Mockito.mock(UnaryCallable.class, Mockito.withSettings().withoutAnnotations());
  }

  @Override
  public UnaryCallable<CreateBucketRequest, Bucket> createBucketCallable() {
    return createBucketCallable;
  }

  @Override
  public UnaryCallable<GetObjectRequest, Object> getObjectCallable() {
    return getObjectCallable;
  }

  @Override
  public UnaryCallable<DeleteObjectRequest, Empty> deleteObjectCallable() {
    return deleteObjectCallable;
  }

  @Override
  public UnaryCallable<UpdateObjectRequest, Object> updateObjectCallable() {
    return updateObjectCallable;
  }

  @Override
  public UnaryCallable<RestoreObjectRequest, Object> restoreObjectCallable() {
    return restoreObjectCallable;
  }

  @Override
  public UnaryCallable<MoveObjectRequest, Object> moveObjectCallable() {
    return moveObjectCallable;
  }

  @Override
  public UnaryCallable<RewriteObjectRequest, RewriteResponse> rewriteObjectCallable() {
    return rewriteObjectCallable;
  }

  @Override
  public void shutdown() {}

  @Override
  public boolean isShutdown() {
    return false;
  }

  @Override
  public boolean isTerminated() {
    return false;
  }

  @Override
  public void shutdownNow() {}

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return false;
  }

  @Override
  public void close() {}
}
