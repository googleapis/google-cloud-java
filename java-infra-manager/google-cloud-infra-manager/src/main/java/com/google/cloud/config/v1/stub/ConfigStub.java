/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.config.v1.stub;

import static com.google.cloud.config.v1.ConfigClient.ListDeploymentsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListLocationsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListPreviewsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListResourcesPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListRevisionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.config.v1.CreateDeploymentRequest;
import com.google.cloud.config.v1.CreatePreviewRequest;
import com.google.cloud.config.v1.DeleteDeploymentRequest;
import com.google.cloud.config.v1.DeletePreviewRequest;
import com.google.cloud.config.v1.DeleteStatefileRequest;
import com.google.cloud.config.v1.Deployment;
import com.google.cloud.config.v1.ExportDeploymentStatefileRequest;
import com.google.cloud.config.v1.ExportLockInfoRequest;
import com.google.cloud.config.v1.ExportPreviewResultRequest;
import com.google.cloud.config.v1.ExportPreviewResultResponse;
import com.google.cloud.config.v1.ExportRevisionStatefileRequest;
import com.google.cloud.config.v1.GetDeploymentRequest;
import com.google.cloud.config.v1.GetPreviewRequest;
import com.google.cloud.config.v1.GetResourceRequest;
import com.google.cloud.config.v1.GetRevisionRequest;
import com.google.cloud.config.v1.ImportStatefileRequest;
import com.google.cloud.config.v1.ListDeploymentsRequest;
import com.google.cloud.config.v1.ListDeploymentsResponse;
import com.google.cloud.config.v1.ListPreviewsRequest;
import com.google.cloud.config.v1.ListPreviewsResponse;
import com.google.cloud.config.v1.ListResourcesRequest;
import com.google.cloud.config.v1.ListResourcesResponse;
import com.google.cloud.config.v1.ListRevisionsRequest;
import com.google.cloud.config.v1.ListRevisionsResponse;
import com.google.cloud.config.v1.LockDeploymentRequest;
import com.google.cloud.config.v1.LockInfo;
import com.google.cloud.config.v1.OperationMetadata;
import com.google.cloud.config.v1.Preview;
import com.google.cloud.config.v1.Resource;
import com.google.cloud.config.v1.Revision;
import com.google.cloud.config.v1.Statefile;
import com.google.cloud.config.v1.UnlockDeploymentRequest;
import com.google.cloud.config.v1.UpdateDeploymentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Config service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ConfigStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeploymentsCallable()");
  }

  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeploymentCallable()");
  }

  public OperationCallable<CreateDeploymentRequest, Deployment, OperationMetadata>
      createDeploymentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeploymentOperationCallable()");
  }

  public UnaryCallable<CreateDeploymentRequest, Operation> createDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeploymentCallable()");
  }

  public OperationCallable<UpdateDeploymentRequest, Deployment, OperationMetadata>
      updateDeploymentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDeploymentOperationCallable()");
  }

  public UnaryCallable<UpdateDeploymentRequest, Operation> updateDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDeploymentCallable()");
  }

  public OperationCallable<DeleteDeploymentRequest, Deployment, OperationMetadata>
      deleteDeploymentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDeploymentOperationCallable()");
  }

  public UnaryCallable<DeleteDeploymentRequest, Operation> deleteDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDeploymentCallable()");
  }

  public UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRevisionsPagedCallable()");
  }

  public UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRevisionsCallable()");
  }

  public UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: getRevisionCallable()");
  }

  public UnaryCallable<GetResourceRequest, Resource> getResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getResourceCallable()");
  }

  public UnaryCallable<ListResourcesRequest, ListResourcesPagedResponse>
      listResourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listResourcesPagedCallable()");
  }

  public UnaryCallable<ListResourcesRequest, ListResourcesResponse> listResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listResourcesCallable()");
  }

  public UnaryCallable<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileCallable() {
    throw new UnsupportedOperationException("Not implemented: exportDeploymentStatefileCallable()");
  }

  public UnaryCallable<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileCallable() {
    throw new UnsupportedOperationException("Not implemented: exportRevisionStatefileCallable()");
  }

  public UnaryCallable<ImportStatefileRequest, Statefile> importStatefileCallable() {
    throw new UnsupportedOperationException("Not implemented: importStatefileCallable()");
  }

  public UnaryCallable<DeleteStatefileRequest, Empty> deleteStatefileCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteStatefileCallable()");
  }

  public OperationCallable<LockDeploymentRequest, Deployment, OperationMetadata>
      lockDeploymentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: lockDeploymentOperationCallable()");
  }

  public UnaryCallable<LockDeploymentRequest, Operation> lockDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: lockDeploymentCallable()");
  }

  public OperationCallable<UnlockDeploymentRequest, Deployment, OperationMetadata>
      unlockDeploymentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: unlockDeploymentOperationCallable()");
  }

  public UnaryCallable<UnlockDeploymentRequest, Operation> unlockDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: unlockDeploymentCallable()");
  }

  public UnaryCallable<ExportLockInfoRequest, LockInfo> exportLockInfoCallable() {
    throw new UnsupportedOperationException("Not implemented: exportLockInfoCallable()");
  }

  public OperationCallable<CreatePreviewRequest, Preview, OperationMetadata>
      createPreviewOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createPreviewOperationCallable()");
  }

  public UnaryCallable<CreatePreviewRequest, Operation> createPreviewCallable() {
    throw new UnsupportedOperationException("Not implemented: createPreviewCallable()");
  }

  public UnaryCallable<GetPreviewRequest, Preview> getPreviewCallable() {
    throw new UnsupportedOperationException("Not implemented: getPreviewCallable()");
  }

  public UnaryCallable<ListPreviewsRequest, ListPreviewsPagedResponse> listPreviewsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPreviewsPagedCallable()");
  }

  public UnaryCallable<ListPreviewsRequest, ListPreviewsResponse> listPreviewsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPreviewsCallable()");
  }

  public OperationCallable<DeletePreviewRequest, Preview, OperationMetadata>
      deletePreviewOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePreviewOperationCallable()");
  }

  public UnaryCallable<DeletePreviewRequest, Operation> deletePreviewCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePreviewCallable()");
  }

  public UnaryCallable<ExportPreviewResultRequest, ExportPreviewResultResponse>
      exportPreviewResultCallable() {
    throw new UnsupportedOperationException("Not implemented: exportPreviewResultCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
