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

package com.google.cloud.beyondcorp.clientconnectorservices.v1.stub;

import static com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesServiceClient.ListClientConnectorServicesPagedResponse;
import static com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServiceOperationMetadata;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest;
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
 * Base stub class for the ClientConnectorServicesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ClientConnectorServicesServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListClientConnectorServicesRequest, ListClientConnectorServicesPagedResponse>
      listClientConnectorServicesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listClientConnectorServicesPagedCallable()");
  }

  public UnaryCallable<ListClientConnectorServicesRequest, ListClientConnectorServicesResponse>
      listClientConnectorServicesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listClientConnectorServicesCallable()");
  }

  public UnaryCallable<GetClientConnectorServiceRequest, ClientConnectorService>
      getClientConnectorServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getClientConnectorServiceCallable()");
  }

  public OperationCallable<
          CreateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      createClientConnectorServiceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createClientConnectorServiceOperationCallable()");
  }

  public UnaryCallable<CreateClientConnectorServiceRequest, Operation>
      createClientConnectorServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createClientConnectorServiceCallable()");
  }

  public OperationCallable<
          UpdateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      updateClientConnectorServiceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateClientConnectorServiceOperationCallable()");
  }

  public UnaryCallable<UpdateClientConnectorServiceRequest, Operation>
      updateClientConnectorServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateClientConnectorServiceCallable()");
  }

  public OperationCallable<
          DeleteClientConnectorServiceRequest, Empty, ClientConnectorServiceOperationMetadata>
      deleteClientConnectorServiceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteClientConnectorServiceOperationCallable()");
  }

  public UnaryCallable<DeleteClientConnectorServiceRequest, Operation>
      deleteClientConnectorServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteClientConnectorServiceCallable()");
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
