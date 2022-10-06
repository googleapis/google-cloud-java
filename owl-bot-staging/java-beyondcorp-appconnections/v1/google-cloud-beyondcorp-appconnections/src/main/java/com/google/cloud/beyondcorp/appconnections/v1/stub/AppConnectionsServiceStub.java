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

package com.google.cloud.beyondcorp.appconnections.v1.stub;

import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ListAppConnectionsPagedResponse;
import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ResolveAppConnectionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.beyondcorp.appconnections.v1.AppConnection;
import com.google.cloud.beyondcorp.appconnections.v1.AppConnectionOperationMetadata;
import com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest;
import com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest;
import com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest;
import com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest;
import com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse;
import com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest;
import com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse;
import com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest;
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
 * Base stub class for the AppConnectionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AppConnectionsServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListAppConnectionsRequest, ListAppConnectionsPagedResponse>
      listAppConnectionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppConnectionsPagedCallable()");
  }

  public UnaryCallable<ListAppConnectionsRequest, ListAppConnectionsResponse>
      listAppConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppConnectionsCallable()");
  }

  public UnaryCallable<GetAppConnectionRequest, AppConnection> getAppConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getAppConnectionCallable()");
  }

  public OperationCallable<
          CreateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      createAppConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAppConnectionOperationCallable()");
  }

  public UnaryCallable<CreateAppConnectionRequest, Operation> createAppConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createAppConnectionCallable()");
  }

  public OperationCallable<
          UpdateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      updateAppConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAppConnectionOperationCallable()");
  }

  public UnaryCallable<UpdateAppConnectionRequest, Operation> updateAppConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAppConnectionCallable()");
  }

  public OperationCallable<DeleteAppConnectionRequest, Empty, AppConnectionOperationMetadata>
      deleteAppConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAppConnectionOperationCallable()");
  }

  public UnaryCallable<DeleteAppConnectionRequest, Operation> deleteAppConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAppConnectionCallable()");
  }

  public UnaryCallable<ResolveAppConnectionsRequest, ResolveAppConnectionsPagedResponse>
      resolveAppConnectionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: resolveAppConnectionsPagedCallable()");
  }

  public UnaryCallable<ResolveAppConnectionsRequest, ResolveAppConnectionsResponse>
      resolveAppConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: resolveAppConnectionsCallable()");
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
