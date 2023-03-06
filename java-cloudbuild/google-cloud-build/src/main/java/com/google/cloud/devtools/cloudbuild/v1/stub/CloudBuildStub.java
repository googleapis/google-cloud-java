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

package com.google.cloud.devtools.cloudbuild.v1.stub;

import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildTriggersPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildsPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListWorkerPoolsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloudbuild.v1.ApproveBuildRequest;
import com.google.cloudbuild.v1.Build;
import com.google.cloudbuild.v1.BuildOperationMetadata;
import com.google.cloudbuild.v1.BuildTrigger;
import com.google.cloudbuild.v1.CancelBuildRequest;
import com.google.cloudbuild.v1.CreateBuildRequest;
import com.google.cloudbuild.v1.CreateBuildTriggerRequest;
import com.google.cloudbuild.v1.CreateWorkerPoolOperationMetadata;
import com.google.cloudbuild.v1.CreateWorkerPoolRequest;
import com.google.cloudbuild.v1.DeleteBuildTriggerRequest;
import com.google.cloudbuild.v1.DeleteWorkerPoolOperationMetadata;
import com.google.cloudbuild.v1.DeleteWorkerPoolRequest;
import com.google.cloudbuild.v1.GetBuildRequest;
import com.google.cloudbuild.v1.GetBuildTriggerRequest;
import com.google.cloudbuild.v1.GetWorkerPoolRequest;
import com.google.cloudbuild.v1.ListBuildTriggersRequest;
import com.google.cloudbuild.v1.ListBuildTriggersResponse;
import com.google.cloudbuild.v1.ListBuildsRequest;
import com.google.cloudbuild.v1.ListBuildsResponse;
import com.google.cloudbuild.v1.ListWorkerPoolsRequest;
import com.google.cloudbuild.v1.ListWorkerPoolsResponse;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse;
import com.google.cloudbuild.v1.RetryBuildRequest;
import com.google.cloudbuild.v1.RunBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateWorkerPoolOperationMetadata;
import com.google.cloudbuild.v1.UpdateWorkerPoolRequest;
import com.google.cloudbuild.v1.WorkerPool;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudBuild service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudBuildStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateBuildRequest, Build, BuildOperationMetadata>
      createBuildOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createBuildOperationCallable()");
  }

  public UnaryCallable<CreateBuildRequest, Operation> createBuildCallable() {
    throw new UnsupportedOperationException("Not implemented: createBuildCallable()");
  }

  public UnaryCallable<GetBuildRequest, Build> getBuildCallable() {
    throw new UnsupportedOperationException("Not implemented: getBuildCallable()");
  }

  public UnaryCallable<ListBuildsRequest, ListBuildsPagedResponse> listBuildsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBuildsPagedCallable()");
  }

  public UnaryCallable<ListBuildsRequest, ListBuildsResponse> listBuildsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBuildsCallable()");
  }

  public UnaryCallable<CancelBuildRequest, Build> cancelBuildCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelBuildCallable()");
  }

  public OperationCallable<RetryBuildRequest, Build, BuildOperationMetadata>
      retryBuildOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: retryBuildOperationCallable()");
  }

  public UnaryCallable<RetryBuildRequest, Operation> retryBuildCallable() {
    throw new UnsupportedOperationException("Not implemented: retryBuildCallable()");
  }

  public OperationCallable<ApproveBuildRequest, Build, BuildOperationMetadata>
      approveBuildOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: approveBuildOperationCallable()");
  }

  public UnaryCallable<ApproveBuildRequest, Operation> approveBuildCallable() {
    throw new UnsupportedOperationException("Not implemented: approveBuildCallable()");
  }

  public UnaryCallable<CreateBuildTriggerRequest, BuildTrigger> createBuildTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: createBuildTriggerCallable()");
  }

  public UnaryCallable<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: getBuildTriggerCallable()");
  }

  public UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersPagedResponse>
      listBuildTriggersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBuildTriggersPagedCallable()");
  }

  public UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersResponse>
      listBuildTriggersCallable() {
    throw new UnsupportedOperationException("Not implemented: listBuildTriggersCallable()");
  }

  public UnaryCallable<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBuildTriggerCallable()");
  }

  public UnaryCallable<UpdateBuildTriggerRequest, BuildTrigger> updateBuildTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBuildTriggerCallable()");
  }

  public OperationCallable<RunBuildTriggerRequest, Build, BuildOperationMetadata>
      runBuildTriggerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: runBuildTriggerOperationCallable()");
  }

  public UnaryCallable<RunBuildTriggerRequest, Operation> runBuildTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: runBuildTriggerCallable()");
  }

  public UnaryCallable<ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>
      receiveTriggerWebhookCallable() {
    throw new UnsupportedOperationException("Not implemented: receiveTriggerWebhookCallable()");
  }

  public OperationCallable<CreateWorkerPoolRequest, WorkerPool, CreateWorkerPoolOperationMetadata>
      createWorkerPoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkerPoolOperationCallable()");
  }

  public UnaryCallable<CreateWorkerPoolRequest, Operation> createWorkerPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkerPoolCallable()");
  }

  public UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkerPoolCallable()");
  }

  public OperationCallable<DeleteWorkerPoolRequest, Empty, DeleteWorkerPoolOperationMetadata>
      deleteWorkerPoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkerPoolOperationCallable()");
  }

  public UnaryCallable<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkerPoolCallable()");
  }

  public OperationCallable<UpdateWorkerPoolRequest, WorkerPool, UpdateWorkerPoolOperationMetadata>
      updateWorkerPoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkerPoolOperationCallable()");
  }

  public UnaryCallable<UpdateWorkerPoolRequest, Operation> updateWorkerPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkerPoolCallable()");
  }

  public UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsPagedResponse>
      listWorkerPoolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkerPoolsPagedCallable()");
  }

  public UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse> listWorkerPoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkerPoolsCallable()");
  }

  @Override
  public abstract void close();
}
