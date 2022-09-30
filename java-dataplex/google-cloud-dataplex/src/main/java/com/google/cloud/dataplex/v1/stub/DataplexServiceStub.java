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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListAssetActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListAssetsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLakeActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLakesPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListSessionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListTasksPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListZoneActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListZonesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.Asset;
import com.google.cloud.dataplex.v1.CancelJobRequest;
import com.google.cloud.dataplex.v1.CreateAssetRequest;
import com.google.cloud.dataplex.v1.CreateEnvironmentRequest;
import com.google.cloud.dataplex.v1.CreateLakeRequest;
import com.google.cloud.dataplex.v1.CreateTaskRequest;
import com.google.cloud.dataplex.v1.CreateZoneRequest;
import com.google.cloud.dataplex.v1.DeleteAssetRequest;
import com.google.cloud.dataplex.v1.DeleteEnvironmentRequest;
import com.google.cloud.dataplex.v1.DeleteLakeRequest;
import com.google.cloud.dataplex.v1.DeleteTaskRequest;
import com.google.cloud.dataplex.v1.DeleteZoneRequest;
import com.google.cloud.dataplex.v1.Environment;
import com.google.cloud.dataplex.v1.GetAssetRequest;
import com.google.cloud.dataplex.v1.GetEnvironmentRequest;
import com.google.cloud.dataplex.v1.GetJobRequest;
import com.google.cloud.dataplex.v1.GetLakeRequest;
import com.google.cloud.dataplex.v1.GetTaskRequest;
import com.google.cloud.dataplex.v1.GetZoneRequest;
import com.google.cloud.dataplex.v1.Job;
import com.google.cloud.dataplex.v1.Lake;
import com.google.cloud.dataplex.v1.ListActionsResponse;
import com.google.cloud.dataplex.v1.ListAssetActionsRequest;
import com.google.cloud.dataplex.v1.ListAssetsRequest;
import com.google.cloud.dataplex.v1.ListAssetsResponse;
import com.google.cloud.dataplex.v1.ListEnvironmentsRequest;
import com.google.cloud.dataplex.v1.ListEnvironmentsResponse;
import com.google.cloud.dataplex.v1.ListJobsRequest;
import com.google.cloud.dataplex.v1.ListJobsResponse;
import com.google.cloud.dataplex.v1.ListLakeActionsRequest;
import com.google.cloud.dataplex.v1.ListLakesRequest;
import com.google.cloud.dataplex.v1.ListLakesResponse;
import com.google.cloud.dataplex.v1.ListSessionsRequest;
import com.google.cloud.dataplex.v1.ListSessionsResponse;
import com.google.cloud.dataplex.v1.ListTasksRequest;
import com.google.cloud.dataplex.v1.ListTasksResponse;
import com.google.cloud.dataplex.v1.ListZoneActionsRequest;
import com.google.cloud.dataplex.v1.ListZonesRequest;
import com.google.cloud.dataplex.v1.ListZonesResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.Task;
import com.google.cloud.dataplex.v1.UpdateAssetRequest;
import com.google.cloud.dataplex.v1.UpdateEnvironmentRequest;
import com.google.cloud.dataplex.v1.UpdateLakeRequest;
import com.google.cloud.dataplex.v1.UpdateTaskRequest;
import com.google.cloud.dataplex.v1.UpdateZoneRequest;
import com.google.cloud.dataplex.v1.Zone;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataplexService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataplexServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateLakeRequest, Lake, OperationMetadata>
      createLakeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createLakeOperationCallable()");
  }

  public UnaryCallable<CreateLakeRequest, Operation> createLakeCallable() {
    throw new UnsupportedOperationException("Not implemented: createLakeCallable()");
  }

  public OperationCallable<UpdateLakeRequest, Lake, OperationMetadata>
      updateLakeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLakeOperationCallable()");
  }

  public UnaryCallable<UpdateLakeRequest, Operation> updateLakeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLakeCallable()");
  }

  public OperationCallable<DeleteLakeRequest, Empty, OperationMetadata>
      deleteLakeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLakeOperationCallable()");
  }

  public UnaryCallable<DeleteLakeRequest, Operation> deleteLakeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLakeCallable()");
  }

  public UnaryCallable<ListLakesRequest, ListLakesPagedResponse> listLakesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLakesPagedCallable()");
  }

  public UnaryCallable<ListLakesRequest, ListLakesResponse> listLakesCallable() {
    throw new UnsupportedOperationException("Not implemented: listLakesCallable()");
  }

  public UnaryCallable<GetLakeRequest, Lake> getLakeCallable() {
    throw new UnsupportedOperationException("Not implemented: getLakeCallable()");
  }

  public UnaryCallable<ListLakeActionsRequest, ListLakeActionsPagedResponse>
      listLakeActionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLakeActionsPagedCallable()");
  }

  public UnaryCallable<ListLakeActionsRequest, ListActionsResponse> listLakeActionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLakeActionsCallable()");
  }

  public OperationCallable<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createZoneOperationCallable()");
  }

  public UnaryCallable<CreateZoneRequest, Operation> createZoneCallable() {
    throw new UnsupportedOperationException("Not implemented: createZoneCallable()");
  }

  public OperationCallable<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateZoneOperationCallable()");
  }

  public UnaryCallable<UpdateZoneRequest, Operation> updateZoneCallable() {
    throw new UnsupportedOperationException("Not implemented: updateZoneCallable()");
  }

  public OperationCallable<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteZoneOperationCallable()");
  }

  public UnaryCallable<DeleteZoneRequest, Operation> deleteZoneCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteZoneCallable()");
  }

  public UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listZonesPagedCallable()");
  }

  public UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable() {
    throw new UnsupportedOperationException("Not implemented: listZonesCallable()");
  }

  public UnaryCallable<GetZoneRequest, Zone> getZoneCallable() {
    throw new UnsupportedOperationException("Not implemented: getZoneCallable()");
  }

  public UnaryCallable<ListZoneActionsRequest, ListZoneActionsPagedResponse>
      listZoneActionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listZoneActionsPagedCallable()");
  }

  public UnaryCallable<ListZoneActionsRequest, ListActionsResponse> listZoneActionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listZoneActionsCallable()");
  }

  public OperationCallable<CreateAssetRequest, Asset, OperationMetadata>
      createAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAssetOperationCallable()");
  }

  public UnaryCallable<CreateAssetRequest, Operation> createAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: createAssetCallable()");
  }

  public OperationCallable<UpdateAssetRequest, Asset, OperationMetadata>
      updateAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAssetOperationCallable()");
  }

  public UnaryCallable<UpdateAssetRequest, Operation> updateAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAssetCallable()");
  }

  public OperationCallable<DeleteAssetRequest, Empty, OperationMetadata>
      deleteAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAssetOperationCallable()");
  }

  public UnaryCallable<DeleteAssetRequest, Operation> deleteAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAssetCallable()");
  }

  public UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetsPagedCallable()");
  }

  public UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetsCallable()");
  }

  public UnaryCallable<GetAssetRequest, Asset> getAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: getAssetCallable()");
  }

  public UnaryCallable<ListAssetActionsRequest, ListAssetActionsPagedResponse>
      listAssetActionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetActionsPagedCallable()");
  }

  public UnaryCallable<ListAssetActionsRequest, ListActionsResponse> listAssetActionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetActionsCallable()");
  }

  public OperationCallable<CreateTaskRequest, Task, OperationMetadata>
      createTaskOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTaskOperationCallable()");
  }

  public UnaryCallable<CreateTaskRequest, Operation> createTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: createTaskCallable()");
  }

  public OperationCallable<UpdateTaskRequest, Task, OperationMetadata>
      updateTaskOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTaskOperationCallable()");
  }

  public UnaryCallable<UpdateTaskRequest, Operation> updateTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTaskCallable()");
  }

  public OperationCallable<DeleteTaskRequest, Empty, OperationMetadata>
      deleteTaskOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTaskOperationCallable()");
  }

  public UnaryCallable<DeleteTaskRequest, Operation> deleteTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTaskCallable()");
  }

  public UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTasksPagedCallable()");
  }

  public UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable() {
    throw new UnsupportedOperationException("Not implemented: listTasksCallable()");
  }

  public UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: getTaskCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsPagedCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsCallable()");
  }

  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getJobCallable()");
  }

  public UnaryCallable<CancelJobRequest, Empty> cancelJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelJobCallable()");
  }

  public OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createEnvironmentOperationCallable()");
  }

  public UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: createEnvironmentCallable()");
  }

  public OperationCallable<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateEnvironmentOperationCallable()");
  }

  public UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEnvironmentCallable()");
  }

  public OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteEnvironmentOperationCallable()");
  }

  public UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEnvironmentCallable()");
  }

  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnvironmentsPagedCallable()");
  }

  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnvironmentsCallable()");
  }

  public UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getEnvironmentCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsPagedCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsCallable()");
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

  @Override
  public abstract void close();
}
