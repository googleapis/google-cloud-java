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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListPluginInstancesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListPluginsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.stub.OperationsStub;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.CreatePluginInstanceRequest;
import com.google.cloud.apihub.v1.CreatePluginRequest;
import com.google.cloud.apihub.v1.DeletePluginInstanceRequest;
import com.google.cloud.apihub.v1.DeletePluginRequest;
import com.google.cloud.apihub.v1.DisablePluginInstanceActionRequest;
import com.google.cloud.apihub.v1.DisablePluginInstanceActionResponse;
import com.google.cloud.apihub.v1.DisablePluginRequest;
import com.google.cloud.apihub.v1.EnablePluginInstanceActionRequest;
import com.google.cloud.apihub.v1.EnablePluginInstanceActionResponse;
import com.google.cloud.apihub.v1.EnablePluginRequest;
import com.google.cloud.apihub.v1.ExecutePluginInstanceActionRequest;
import com.google.cloud.apihub.v1.ExecutePluginInstanceActionResponse;
import com.google.cloud.apihub.v1.GetPluginInstanceRequest;
import com.google.cloud.apihub.v1.GetPluginRequest;
import com.google.cloud.apihub.v1.ListPluginInstancesRequest;
import com.google.cloud.apihub.v1.ListPluginInstancesResponse;
import com.google.cloud.apihub.v1.ListPluginsRequest;
import com.google.cloud.apihub.v1.ListPluginsResponse;
import com.google.cloud.apihub.v1.OperationMetadata;
import com.google.cloud.apihub.v1.Plugin;
import com.google.cloud.apihub.v1.PluginInstance;
import com.google.cloud.apihub.v1.UpdatePluginInstanceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ApiHubPlugin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ApiHubPluginStub implements BackgroundResource {

  public OperationsStub getHttpJsonOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getHttpJsonOperationsStub()");
  }

  public UnaryCallable<GetPluginRequest, Plugin> getPluginCallable() {
    throw new UnsupportedOperationException("Not implemented: getPluginCallable()");
  }

  public UnaryCallable<EnablePluginRequest, Plugin> enablePluginCallable() {
    throw new UnsupportedOperationException("Not implemented: enablePluginCallable()");
  }

  public UnaryCallable<DisablePluginRequest, Plugin> disablePluginCallable() {
    throw new UnsupportedOperationException("Not implemented: disablePluginCallable()");
  }

  public UnaryCallable<CreatePluginRequest, Plugin> createPluginCallable() {
    throw new UnsupportedOperationException("Not implemented: createPluginCallable()");
  }

  public UnaryCallable<ListPluginsRequest, ListPluginsPagedResponse> listPluginsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPluginsPagedCallable()");
  }

  public UnaryCallable<ListPluginsRequest, ListPluginsResponse> listPluginsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPluginsCallable()");
  }

  public OperationCallable<DeletePluginRequest, Empty, OperationMetadata>
      deletePluginOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePluginOperationCallable()");
  }

  public UnaryCallable<DeletePluginRequest, Operation> deletePluginCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePluginCallable()");
  }

  public OperationCallable<CreatePluginInstanceRequest, PluginInstance, OperationMetadata>
      createPluginInstanceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPluginInstanceOperationCallable()");
  }

  public UnaryCallable<CreatePluginInstanceRequest, Operation> createPluginInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: createPluginInstanceCallable()");
  }

  public OperationCallable<
          ExecutePluginInstanceActionRequest,
          ExecutePluginInstanceActionResponse,
          OperationMetadata>
      executePluginInstanceActionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: executePluginInstanceActionOperationCallable()");
  }

  public UnaryCallable<ExecutePluginInstanceActionRequest, Operation>
      executePluginInstanceActionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: executePluginInstanceActionCallable()");
  }

  public UnaryCallable<GetPluginInstanceRequest, PluginInstance> getPluginInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getPluginInstanceCallable()");
  }

  public UnaryCallable<ListPluginInstancesRequest, ListPluginInstancesPagedResponse>
      listPluginInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPluginInstancesPagedCallable()");
  }

  public UnaryCallable<ListPluginInstancesRequest, ListPluginInstancesResponse>
      listPluginInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPluginInstancesCallable()");
  }

  public OperationCallable<
          EnablePluginInstanceActionRequest, EnablePluginInstanceActionResponse, OperationMetadata>
      enablePluginInstanceActionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: enablePluginInstanceActionOperationCallable()");
  }

  public UnaryCallable<EnablePluginInstanceActionRequest, Operation>
      enablePluginInstanceActionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: enablePluginInstanceActionCallable()");
  }

  public OperationCallable<
          DisablePluginInstanceActionRequest,
          DisablePluginInstanceActionResponse,
          OperationMetadata>
      disablePluginInstanceActionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disablePluginInstanceActionOperationCallable()");
  }

  public UnaryCallable<DisablePluginInstanceActionRequest, Operation>
      disablePluginInstanceActionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disablePluginInstanceActionCallable()");
  }

  public UnaryCallable<UpdatePluginInstanceRequest, PluginInstance> updatePluginInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePluginInstanceCallable()");
  }

  public OperationCallable<DeletePluginInstanceRequest, Empty, OperationMetadata>
      deletePluginInstanceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePluginInstanceOperationCallable()");
  }

  public UnaryCallable<DeletePluginInstanceRequest, Operation> deletePluginInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePluginInstanceCallable()");
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
