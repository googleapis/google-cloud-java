/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networkconnectivity.v1beta.stub;

import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListRemoteTransportProfilesPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListTransportsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest;
import com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest;
import com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest;
import com.google.cloud.networkconnectivity.v1beta.GetStatusRequest;
import com.google.cloud.networkconnectivity.v1beta.GetStatusResponse;
import com.google.cloud.networkconnectivity.v1beta.GetTransportRequest;
import com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest;
import com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse;
import com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest;
import com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse;
import com.google.cloud.networkconnectivity.v1beta.OperationMetadata;
import com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile;
import com.google.cloud.networkconnectivity.v1beta.Transport;
import com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest;
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
 * Base stub class for the TransportManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class TransportManagerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesPagedResponse>
      listRemoteTransportProfilesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRemoteTransportProfilesPagedCallable()");
  }

  public UnaryCallable<ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesResponse>
      listRemoteTransportProfilesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRemoteTransportProfilesCallable()");
  }

  public UnaryCallable<GetRemoteTransportProfileRequest, RemoteTransportProfile>
      getRemoteTransportProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getRemoteTransportProfileCallable()");
  }

  public UnaryCallable<ListTransportsRequest, ListTransportsPagedResponse>
      listTransportsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransportsPagedCallable()");
  }

  public UnaryCallable<ListTransportsRequest, ListTransportsResponse> listTransportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransportsCallable()");
  }

  public UnaryCallable<GetTransportRequest, Transport> getTransportCallable() {
    throw new UnsupportedOperationException("Not implemented: getTransportCallable()");
  }

  public UnaryCallable<GetStatusRequest, GetStatusResponse> getStatusCallable() {
    throw new UnsupportedOperationException("Not implemented: getStatusCallable()");
  }

  public OperationCallable<CreateTransportRequest, Transport, OperationMetadata>
      createTransportOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTransportOperationCallable()");
  }

  public UnaryCallable<CreateTransportRequest, Operation> createTransportCallable() {
    throw new UnsupportedOperationException("Not implemented: createTransportCallable()");
  }

  public OperationCallable<UpdateTransportRequest, Transport, OperationMetadata>
      updateTransportOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTransportOperationCallable()");
  }

  public UnaryCallable<UpdateTransportRequest, Operation> updateTransportCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTransportCallable()");
  }

  public OperationCallable<DeleteTransportRequest, Empty, OperationMetadata>
      deleteTransportOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTransportOperationCallable()");
  }

  public UnaryCallable<DeleteTransportRequest, Operation> deleteTransportCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTransportCallable()");
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
