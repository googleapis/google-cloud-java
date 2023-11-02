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

package com.google.cloud.metastore.v1alpha.stub;

import static com.google.cloud.metastore.v1alpha.DataprocMetastoreFederationClient.ListFederationsPagedResponse;
import static com.google.cloud.metastore.v1alpha.DataprocMetastoreFederationClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.metastore.v1alpha.CreateFederationRequest;
import com.google.cloud.metastore.v1alpha.DeleteFederationRequest;
import com.google.cloud.metastore.v1alpha.Federation;
import com.google.cloud.metastore.v1alpha.GetFederationRequest;
import com.google.cloud.metastore.v1alpha.ListFederationsRequest;
import com.google.cloud.metastore.v1alpha.ListFederationsResponse;
import com.google.cloud.metastore.v1alpha.OperationMetadata;
import com.google.cloud.metastore.v1alpha.UpdateFederationRequest;
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
 * Base stub class for the DataprocMetastoreFederation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DataprocMetastoreFederationStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListFederationsRequest, ListFederationsPagedResponse>
      listFederationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFederationsPagedCallable()");
  }

  public UnaryCallable<ListFederationsRequest, ListFederationsResponse> listFederationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFederationsCallable()");
  }

  public UnaryCallable<GetFederationRequest, Federation> getFederationCallable() {
    throw new UnsupportedOperationException("Not implemented: getFederationCallable()");
  }

  public OperationCallable<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFederationOperationCallable()");
  }

  public UnaryCallable<CreateFederationRequest, Operation> createFederationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFederationCallable()");
  }

  public OperationCallable<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFederationOperationCallable()");
  }

  public UnaryCallable<UpdateFederationRequest, Operation> updateFederationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFederationCallable()");
  }

  public OperationCallable<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFederationOperationCallable()");
  }

  public UnaryCallable<DeleteFederationRequest, Operation> deleteFederationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFederationCallable()");
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
