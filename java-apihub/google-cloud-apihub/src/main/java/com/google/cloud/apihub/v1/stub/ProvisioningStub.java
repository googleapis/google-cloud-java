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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ProvisioningClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.ApiHubInstance;
import com.google.cloud.apihub.v1.CreateApiHubInstanceRequest;
import com.google.cloud.apihub.v1.GetApiHubInstanceRequest;
import com.google.cloud.apihub.v1.LookupApiHubInstanceRequest;
import com.google.cloud.apihub.v1.LookupApiHubInstanceResponse;
import com.google.cloud.apihub.v1.OperationMetadata;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Provisioning service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ProvisioningStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateApiHubInstanceRequest, ApiHubInstance, OperationMetadata>
      createApiHubInstanceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createApiHubInstanceOperationCallable()");
  }

  public UnaryCallable<CreateApiHubInstanceRequest, Operation> createApiHubInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: createApiHubInstanceCallable()");
  }

  public UnaryCallable<GetApiHubInstanceRequest, ApiHubInstance> getApiHubInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getApiHubInstanceCallable()");
  }

  public UnaryCallable<LookupApiHubInstanceRequest, LookupApiHubInstanceResponse>
      lookupApiHubInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: lookupApiHubInstanceCallable()");
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
