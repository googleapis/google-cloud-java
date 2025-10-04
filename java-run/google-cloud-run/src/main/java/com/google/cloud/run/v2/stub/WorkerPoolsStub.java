/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.run.v2.stub;

import static com.google.cloud.run.v2.WorkerPoolsClient.ListWorkerPoolsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.CreateWorkerPoolRequest;
import com.google.cloud.run.v2.DeleteWorkerPoolRequest;
import com.google.cloud.run.v2.GetWorkerPoolRequest;
import com.google.cloud.run.v2.ListWorkerPoolsRequest;
import com.google.cloud.run.v2.ListWorkerPoolsResponse;
import com.google.cloud.run.v2.UpdateWorkerPoolRequest;
import com.google.cloud.run.v2.WorkerPool;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the WorkerPools service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class WorkerPoolsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
      createWorkerPoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkerPoolOperationCallable()");
  }

  public UnaryCallable<CreateWorkerPoolRequest, Operation> createWorkerPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkerPoolCallable()");
  }

  public UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkerPoolCallable()");
  }

  public UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsPagedResponse>
      listWorkerPoolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkerPoolsPagedCallable()");
  }

  public UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse> listWorkerPoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkerPoolsCallable()");
  }

  public OperationCallable<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
      updateWorkerPoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkerPoolOperationCallable()");
  }

  public UnaryCallable<UpdateWorkerPoolRequest, Operation> updateWorkerPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkerPoolCallable()");
  }

  public OperationCallable<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
      deleteWorkerPoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkerPoolOperationCallable()");
  }

  public UnaryCallable<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkerPoolCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
