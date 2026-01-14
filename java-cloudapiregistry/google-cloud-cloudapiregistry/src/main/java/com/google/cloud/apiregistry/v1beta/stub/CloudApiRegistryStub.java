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

package com.google.cloud.apiregistry.v1beta.stub;

import static com.google.cloud.apiregistry.v1beta.CloudApiRegistryClient.ListLocationsPagedResponse;
import static com.google.cloud.apiregistry.v1beta.CloudApiRegistryClient.ListMcpServersPagedResponse;
import static com.google.cloud.apiregistry.v1beta.CloudApiRegistryClient.ListMcpToolsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apiregistry.v1beta.GetMcpServerRequest;
import com.google.cloud.apiregistry.v1beta.GetMcpToolRequest;
import com.google.cloud.apiregistry.v1beta.ListMcpServersRequest;
import com.google.cloud.apiregistry.v1beta.ListMcpServersResponse;
import com.google.cloud.apiregistry.v1beta.ListMcpToolsRequest;
import com.google.cloud.apiregistry.v1beta.ListMcpToolsResponse;
import com.google.cloud.apiregistry.v1beta.McpServer;
import com.google.cloud.apiregistry.v1beta.McpTool;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudApiRegistry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class CloudApiRegistryStub implements BackgroundResource {

  public UnaryCallable<GetMcpServerRequest, McpServer> getMcpServerCallable() {
    throw new UnsupportedOperationException("Not implemented: getMcpServerCallable()");
  }

  public UnaryCallable<ListMcpServersRequest, ListMcpServersPagedResponse>
      listMcpServersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMcpServersPagedCallable()");
  }

  public UnaryCallable<ListMcpServersRequest, ListMcpServersResponse> listMcpServersCallable() {
    throw new UnsupportedOperationException("Not implemented: listMcpServersCallable()");
  }

  public UnaryCallable<GetMcpToolRequest, McpTool> getMcpToolCallable() {
    throw new UnsupportedOperationException("Not implemented: getMcpToolCallable()");
  }

  public UnaryCallable<ListMcpToolsRequest, ListMcpToolsPagedResponse> listMcpToolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMcpToolsPagedCallable()");
  }

  public UnaryCallable<ListMcpToolsRequest, ListMcpToolsResponse> listMcpToolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMcpToolsCallable()");
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
