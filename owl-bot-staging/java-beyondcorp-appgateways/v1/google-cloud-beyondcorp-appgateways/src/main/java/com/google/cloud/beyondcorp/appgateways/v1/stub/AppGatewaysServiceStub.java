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

package com.google.cloud.beyondcorp.appgateways.v1.stub;

import static com.google.cloud.beyondcorp.appgateways.v1.AppGatewaysServiceClient.ListAppGatewaysPagedResponse;
import static com.google.cloud.beyondcorp.appgateways.v1.AppGatewaysServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.beyondcorp.appgateways.v1.AppGateway;
import com.google.cloud.beyondcorp.appgateways.v1.AppGatewayOperationMetadata;
import com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest;
import com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest;
import com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest;
import com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest;
import com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse;
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
 * Base stub class for the AppGatewaysService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AppGatewaysServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListAppGatewaysRequest, ListAppGatewaysPagedResponse>
      listAppGatewaysPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppGatewaysPagedCallable()");
  }

  public UnaryCallable<ListAppGatewaysRequest, ListAppGatewaysResponse> listAppGatewaysCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppGatewaysCallable()");
  }

  public UnaryCallable<GetAppGatewayRequest, AppGateway> getAppGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: getAppGatewayCallable()");
  }

  public OperationCallable<CreateAppGatewayRequest, AppGateway, AppGatewayOperationMetadata>
      createAppGatewayOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAppGatewayOperationCallable()");
  }

  public UnaryCallable<CreateAppGatewayRequest, Operation> createAppGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: createAppGatewayCallable()");
  }

  public OperationCallable<DeleteAppGatewayRequest, Empty, AppGatewayOperationMetadata>
      deleteAppGatewayOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAppGatewayOperationCallable()");
  }

  public UnaryCallable<DeleteAppGatewayRequest, Operation> deleteAppGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAppGatewayCallable()");
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
