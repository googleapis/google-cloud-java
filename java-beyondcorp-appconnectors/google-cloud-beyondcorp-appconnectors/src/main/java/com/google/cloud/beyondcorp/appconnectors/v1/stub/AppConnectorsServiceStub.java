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

package com.google.cloud.beyondcorp.appconnectors.v1.stub;

import static com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorsServiceClient.ListAppConnectorsPagedResponse;
import static com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorsServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.beyondcorp.appconnectors.v1.AppConnector;
import com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorOperationMetadata;
import com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse;
import com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest;
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
 * Base stub class for the AppConnectorsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AppConnectorsServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListAppConnectorsRequest, ListAppConnectorsPagedResponse>
      listAppConnectorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppConnectorsPagedCallable()");
  }

  public UnaryCallable<ListAppConnectorsRequest, ListAppConnectorsResponse>
      listAppConnectorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppConnectorsCallable()");
  }

  public UnaryCallable<GetAppConnectorRequest, AppConnector> getAppConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: getAppConnectorCallable()");
  }

  public OperationCallable<CreateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      createAppConnectorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAppConnectorOperationCallable()");
  }

  public UnaryCallable<CreateAppConnectorRequest, Operation> createAppConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: createAppConnectorCallable()");
  }

  public OperationCallable<UpdateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      updateAppConnectorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAppConnectorOperationCallable()");
  }

  public UnaryCallable<UpdateAppConnectorRequest, Operation> updateAppConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAppConnectorCallable()");
  }

  public OperationCallable<DeleteAppConnectorRequest, Empty, AppConnectorOperationMetadata>
      deleteAppConnectorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAppConnectorOperationCallable()");
  }

  public UnaryCallable<DeleteAppConnectorRequest, Operation> deleteAppConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAppConnectorCallable()");
  }

  public OperationCallable<ReportStatusRequest, AppConnector, AppConnectorOperationMetadata>
      reportStatusOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: reportStatusOperationCallable()");
  }

  public UnaryCallable<ReportStatusRequest, Operation> reportStatusCallable() {
    throw new UnsupportedOperationException("Not implemented: reportStatusCallable()");
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
