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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListModelMonitoringJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListModelMonitorsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.SearchModelMonitoringAlertsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.SearchModelMonitoringStatsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateModelMonitorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse;
import com.google.cloud.aiplatform.v1beta1.ModelMonitor;
import com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest;
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
 * Base stub class for the ModelMonitoringService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ModelMonitoringServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateModelMonitorRequest, ModelMonitor, CreateModelMonitorOperationMetadata>
      createModelMonitorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createModelMonitorOperationCallable()");
  }

  public UnaryCallable<CreateModelMonitorRequest, Operation> createModelMonitorCallable() {
    throw new UnsupportedOperationException("Not implemented: createModelMonitorCallable()");
  }

  public OperationCallable<
          UpdateModelMonitorRequest, ModelMonitor, UpdateModelMonitorOperationMetadata>
      updateModelMonitorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateModelMonitorOperationCallable()");
  }

  public UnaryCallable<UpdateModelMonitorRequest, Operation> updateModelMonitorCallable() {
    throw new UnsupportedOperationException("Not implemented: updateModelMonitorCallable()");
  }

  public UnaryCallable<GetModelMonitorRequest, ModelMonitor> getModelMonitorCallable() {
    throw new UnsupportedOperationException("Not implemented: getModelMonitorCallable()");
  }

  public UnaryCallable<ListModelMonitorsRequest, ListModelMonitorsPagedResponse>
      listModelMonitorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listModelMonitorsPagedCallable()");
  }

  public UnaryCallable<ListModelMonitorsRequest, ListModelMonitorsResponse>
      listModelMonitorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listModelMonitorsCallable()");
  }

  public OperationCallable<DeleteModelMonitorRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteModelMonitorOperationCallable()");
  }

  public UnaryCallable<DeleteModelMonitorRequest, Operation> deleteModelMonitorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteModelMonitorCallable()");
  }

  public UnaryCallable<CreateModelMonitoringJobRequest, ModelMonitoringJob>
      createModelMonitoringJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createModelMonitoringJobCallable()");
  }

  public UnaryCallable<GetModelMonitoringJobRequest, ModelMonitoringJob>
      getModelMonitoringJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getModelMonitoringJobCallable()");
  }

  public UnaryCallable<ListModelMonitoringJobsRequest, ListModelMonitoringJobsPagedResponse>
      listModelMonitoringJobsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listModelMonitoringJobsPagedCallable()");
  }

  public UnaryCallable<ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse>
      listModelMonitoringJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listModelMonitoringJobsCallable()");
  }

  public OperationCallable<DeleteModelMonitoringJobRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitoringJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteModelMonitoringJobOperationCallable()");
  }

  public UnaryCallable<DeleteModelMonitoringJobRequest, Operation>
      deleteModelMonitoringJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteModelMonitoringJobCallable()");
  }

  public UnaryCallable<SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsPagedResponse>
      searchModelMonitoringStatsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchModelMonitoringStatsPagedCallable()");
  }

  public UnaryCallable<SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsResponse>
      searchModelMonitoringStatsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchModelMonitoringStatsCallable()");
  }

  public UnaryCallable<SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsPagedResponse>
      searchModelMonitoringAlertsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchModelMonitoringAlertsPagedCallable()");
  }

  public UnaryCallable<SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsResponse>
      searchModelMonitoringAlertsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchModelMonitoringAlertsCallable()");
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
