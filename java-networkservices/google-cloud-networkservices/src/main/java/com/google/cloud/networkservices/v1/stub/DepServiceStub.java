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

package com.google.cloud.networkservices.v1.stub;

import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbRouteExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbTrafficExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.LbRouteExtension;
import com.google.cloud.networkservices.v1.LbTrafficExtension;
import com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest;
import com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse;
import com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest;
import com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse;
import com.google.cloud.networkservices.v1.OperationMetadata;
import com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest;
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
 * Base stub class for the DepService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DepServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsPagedResponse>
      listLbTrafficExtensionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listLbTrafficExtensionsPagedCallable()");
  }

  public UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>
      listLbTrafficExtensionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLbTrafficExtensionsCallable()");
  }

  public UnaryCallable<GetLbTrafficExtensionRequest, LbTrafficExtension>
      getLbTrafficExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: getLbTrafficExtensionCallable()");
  }

  public OperationCallable<CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      createLbTrafficExtensionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createLbTrafficExtensionOperationCallable()");
  }

  public UnaryCallable<CreateLbTrafficExtensionRequest, Operation>
      createLbTrafficExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: createLbTrafficExtensionCallable()");
  }

  public OperationCallable<UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      updateLbTrafficExtensionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateLbTrafficExtensionOperationCallable()");
  }

  public UnaryCallable<UpdateLbTrafficExtensionRequest, Operation>
      updateLbTrafficExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLbTrafficExtensionCallable()");
  }

  public OperationCallable<DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
      deleteLbTrafficExtensionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteLbTrafficExtensionOperationCallable()");
  }

  public UnaryCallable<DeleteLbTrafficExtensionRequest, Operation>
      deleteLbTrafficExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLbTrafficExtensionCallable()");
  }

  public UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsPagedResponse>
      listLbRouteExtensionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listLbRouteExtensionsPagedCallable()");
  }

  public UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>
      listLbRouteExtensionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLbRouteExtensionsCallable()");
  }

  public UnaryCallable<GetLbRouteExtensionRequest, LbRouteExtension> getLbRouteExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: getLbRouteExtensionCallable()");
  }

  public OperationCallable<CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      createLbRouteExtensionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createLbRouteExtensionOperationCallable()");
  }

  public UnaryCallable<CreateLbRouteExtensionRequest, Operation> createLbRouteExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: createLbRouteExtensionCallable()");
  }

  public OperationCallable<UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      updateLbRouteExtensionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateLbRouteExtensionOperationCallable()");
  }

  public UnaryCallable<UpdateLbRouteExtensionRequest, Operation> updateLbRouteExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLbRouteExtensionCallable()");
  }

  public OperationCallable<DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
      deleteLbRouteExtensionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteLbRouteExtensionOperationCallable()");
  }

  public UnaryCallable<DeleteLbRouteExtensionRequest, Operation> deleteLbRouteExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLbRouteExtensionCallable()");
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
