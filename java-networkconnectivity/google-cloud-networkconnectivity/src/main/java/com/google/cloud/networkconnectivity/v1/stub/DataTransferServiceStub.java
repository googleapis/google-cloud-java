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

package com.google.cloud.networkconnectivity.v1.stub;

import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListDestinationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListMulticloudDataTransferConfigsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListMulticloudDataTransferSupportedServicesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkconnectivity.v1.CreateDestinationRequest;
import com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest;
import com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest;
import com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest;
import com.google.cloud.networkconnectivity.v1.Destination;
import com.google.cloud.networkconnectivity.v1.GetDestinationRequest;
import com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest;
import com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferSupportedServiceRequest;
import com.google.cloud.networkconnectivity.v1.ListDestinationsRequest;
import com.google.cloud.networkconnectivity.v1.ListDestinationsResponse;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferSupportedServicesRequest;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferSupportedServicesResponse;
import com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig;
import com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest;
import com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest;
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
 * Base stub class for the DataTransferService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataTransferServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<
          ListMulticloudDataTransferConfigsRequest, ListMulticloudDataTransferConfigsPagedResponse>
      listMulticloudDataTransferConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMulticloudDataTransferConfigsPagedCallable()");
  }

  public UnaryCallable<
          ListMulticloudDataTransferConfigsRequest, ListMulticloudDataTransferConfigsResponse>
      listMulticloudDataTransferConfigsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMulticloudDataTransferConfigsCallable()");
  }

  public UnaryCallable<GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
      getMulticloudDataTransferConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getMulticloudDataTransferConfigCallable()");
  }

  public OperationCallable<
          CreateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      createMulticloudDataTransferConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMulticloudDataTransferConfigOperationCallable()");
  }

  public UnaryCallable<CreateMulticloudDataTransferConfigRequest, Operation>
      createMulticloudDataTransferConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMulticloudDataTransferConfigCallable()");
  }

  public OperationCallable<
          UpdateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      updateMulticloudDataTransferConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMulticloudDataTransferConfigOperationCallable()");
  }

  public UnaryCallable<UpdateMulticloudDataTransferConfigRequest, Operation>
      updateMulticloudDataTransferConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMulticloudDataTransferConfigCallable()");
  }

  public OperationCallable<DeleteMulticloudDataTransferConfigRequest, Empty, OperationMetadata>
      deleteMulticloudDataTransferConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMulticloudDataTransferConfigOperationCallable()");
  }

  public UnaryCallable<DeleteMulticloudDataTransferConfigRequest, Operation>
      deleteMulticloudDataTransferConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMulticloudDataTransferConfigCallable()");
  }

  public UnaryCallable<ListDestinationsRequest, ListDestinationsPagedResponse>
      listDestinationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDestinationsPagedCallable()");
  }

  public UnaryCallable<ListDestinationsRequest, ListDestinationsResponse>
      listDestinationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDestinationsCallable()");
  }

  public UnaryCallable<GetDestinationRequest, Destination> getDestinationCallable() {
    throw new UnsupportedOperationException("Not implemented: getDestinationCallable()");
  }

  public OperationCallable<CreateDestinationRequest, Destination, OperationMetadata>
      createDestinationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDestinationOperationCallable()");
  }

  public UnaryCallable<CreateDestinationRequest, Operation> createDestinationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDestinationCallable()");
  }

  public OperationCallable<UpdateDestinationRequest, Destination, OperationMetadata>
      updateDestinationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDestinationOperationCallable()");
  }

  public UnaryCallable<UpdateDestinationRequest, Operation> updateDestinationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDestinationCallable()");
  }

  public OperationCallable<DeleteDestinationRequest, Empty, OperationMetadata>
      deleteDestinationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDestinationOperationCallable()");
  }

  public UnaryCallable<DeleteDestinationRequest, Operation> deleteDestinationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDestinationCallable()");
  }

  public UnaryCallable<
          GetMulticloudDataTransferSupportedServiceRequest, MulticloudDataTransferSupportedService>
      getMulticloudDataTransferSupportedServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getMulticloudDataTransferSupportedServiceCallable()");
  }

  public UnaryCallable<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesPagedResponse>
      listMulticloudDataTransferSupportedServicesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMulticloudDataTransferSupportedServicesPagedCallable()");
  }

  public UnaryCallable<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse>
      listMulticloudDataTransferSupportedServicesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMulticloudDataTransferSupportedServicesCallable()");
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
