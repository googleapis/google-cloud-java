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

package com.google.cloud.developerconnect.v1.stub;

import static com.google.cloud.developerconnect.v1.InsightsConfigServiceClient.ListInsightsConfigsPagedResponse;
import static com.google.cloud.developerconnect.v1.InsightsConfigServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.GetInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.InsightsConfig;
import com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest;
import com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse;
import com.google.cloud.developerconnect.v1.OperationMetadata;
import com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the InsightsConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class InsightsConfigServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsPagedResponse>
      listInsightsConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInsightsConfigsPagedCallable()");
  }

  public UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsResponse>
      listInsightsConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listInsightsConfigsCallable()");
  }

  public OperationCallable<CreateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      createInsightsConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInsightsConfigOperationCallable()");
  }

  public UnaryCallable<CreateInsightsConfigRequest, Operation> createInsightsConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createInsightsConfigCallable()");
  }

  public UnaryCallable<GetInsightsConfigRequest, InsightsConfig> getInsightsConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getInsightsConfigCallable()");
  }

  public OperationCallable<UpdateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      updateInsightsConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInsightsConfigOperationCallable()");
  }

  public UnaryCallable<UpdateInsightsConfigRequest, Operation> updateInsightsConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInsightsConfigCallable()");
  }

  public OperationCallable<DeleteInsightsConfigRequest, Empty, OperationMetadata>
      deleteInsightsConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteInsightsConfigOperationCallable()");
  }

  public UnaryCallable<DeleteInsightsConfigRequest, Operation> deleteInsightsConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInsightsConfigCallable()");
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
