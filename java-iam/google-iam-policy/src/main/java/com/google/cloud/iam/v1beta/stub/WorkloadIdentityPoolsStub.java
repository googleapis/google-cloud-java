/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iam.v1beta.stub;

import static com.google.cloud.iam.v1beta.WorkloadIdentityPoolsClient.ListWorkloadIdentityPoolProvidersPagedResponse;
import static com.google.cloud.iam.v1beta.WorkloadIdentityPoolsClient.ListWorkloadIdentityPoolsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.WorkloadIdentityPool;
import com.google.iam.v1beta.WorkloadIdentityPoolOperationMetadata;
import com.google.iam.v1beta.WorkloadIdentityPoolProvider;
import com.google.iam.v1beta.WorkloadIdentityPoolProviderOperationMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the WorkloadIdentityPools service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class WorkloadIdentityPoolsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsPagedResponse>
      listWorkloadIdentityPoolsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listWorkloadIdentityPoolsPagedCallable()");
  }

  public UnaryCallable<ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsResponse>
      listWorkloadIdentityPoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkloadIdentityPoolsCallable()");
  }

  public UnaryCallable<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
      getWorkloadIdentityPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkloadIdentityPoolCallable()");
  }

  public OperationCallable<
          CreateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      createWorkloadIdentityPoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createWorkloadIdentityPoolOperationCallable()");
  }

  public UnaryCallable<CreateWorkloadIdentityPoolRequest, Operation>
      createWorkloadIdentityPoolCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createWorkloadIdentityPoolCallable()");
  }

  public OperationCallable<
          UpdateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      updateWorkloadIdentityPoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateWorkloadIdentityPoolOperationCallable()");
  }

  public UnaryCallable<UpdateWorkloadIdentityPoolRequest, Operation>
      updateWorkloadIdentityPoolCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateWorkloadIdentityPoolCallable()");
  }

  public OperationCallable<
          DeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      deleteWorkloadIdentityPoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteWorkloadIdentityPoolOperationCallable()");
  }

  public UnaryCallable<DeleteWorkloadIdentityPoolRequest, Operation>
      deleteWorkloadIdentityPoolCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteWorkloadIdentityPoolCallable()");
  }

  public OperationCallable<
          UndeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      undeleteWorkloadIdentityPoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeleteWorkloadIdentityPoolOperationCallable()");
  }

  public UnaryCallable<UndeleteWorkloadIdentityPoolRequest, Operation>
      undeleteWorkloadIdentityPoolCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeleteWorkloadIdentityPoolCallable()");
  }

  public UnaryCallable<
          ListWorkloadIdentityPoolProvidersRequest, ListWorkloadIdentityPoolProvidersPagedResponse>
      listWorkloadIdentityPoolProvidersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listWorkloadIdentityPoolProvidersPagedCallable()");
  }

  public UnaryCallable<
          ListWorkloadIdentityPoolProvidersRequest, ListWorkloadIdentityPoolProvidersResponse>
      listWorkloadIdentityPoolProvidersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listWorkloadIdentityPoolProvidersCallable()");
  }

  public UnaryCallable<GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
      getWorkloadIdentityPoolProviderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getWorkloadIdentityPoolProviderCallable()");
  }

  public OperationCallable<
          CreateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      createWorkloadIdentityPoolProviderOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createWorkloadIdentityPoolProviderOperationCallable()");
  }

  public UnaryCallable<CreateWorkloadIdentityPoolProviderRequest, Operation>
      createWorkloadIdentityPoolProviderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createWorkloadIdentityPoolProviderCallable()");
  }

  public OperationCallable<
          UpdateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      updateWorkloadIdentityPoolProviderOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateWorkloadIdentityPoolProviderOperationCallable()");
  }

  public UnaryCallable<UpdateWorkloadIdentityPoolProviderRequest, Operation>
      updateWorkloadIdentityPoolProviderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateWorkloadIdentityPoolProviderCallable()");
  }

  public OperationCallable<
          DeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      deleteWorkloadIdentityPoolProviderOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteWorkloadIdentityPoolProviderOperationCallable()");
  }

  public UnaryCallable<DeleteWorkloadIdentityPoolProviderRequest, Operation>
      deleteWorkloadIdentityPoolProviderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteWorkloadIdentityPoolProviderCallable()");
  }

  public OperationCallable<
          UndeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      undeleteWorkloadIdentityPoolProviderOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeleteWorkloadIdentityPoolProviderOperationCallable()");
  }

  public UnaryCallable<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
      undeleteWorkloadIdentityPoolProviderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeleteWorkloadIdentityPoolProviderCallable()");
  }

  @Override
  public abstract void close();
}
