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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.ToolsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.ToolsClient.ListToolVersionsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.ToolsClient.ListToolsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateToolRequest;
import com.google.cloud.dialogflow.cx.v3.CreateToolVersionRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteToolRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteToolVersionRequest;
import com.google.cloud.dialogflow.cx.v3.GetToolRequest;
import com.google.cloud.dialogflow.cx.v3.GetToolVersionRequest;
import com.google.cloud.dialogflow.cx.v3.ListToolVersionsRequest;
import com.google.cloud.dialogflow.cx.v3.ListToolVersionsResponse;
import com.google.cloud.dialogflow.cx.v3.ListToolsRequest;
import com.google.cloud.dialogflow.cx.v3.ListToolsResponse;
import com.google.cloud.dialogflow.cx.v3.RestoreToolVersionRequest;
import com.google.cloud.dialogflow.cx.v3.RestoreToolVersionResponse;
import com.google.cloud.dialogflow.cx.v3.Tool;
import com.google.cloud.dialogflow.cx.v3.ToolVersion;
import com.google.cloud.dialogflow.cx.v3.UpdateToolRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Tools service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ToolsStub implements BackgroundResource {

  public UnaryCallable<CreateToolRequest, Tool> createToolCallable() {
    throw new UnsupportedOperationException("Not implemented: createToolCallable()");
  }

  public UnaryCallable<ListToolsRequest, ListToolsPagedResponse> listToolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listToolsPagedCallable()");
  }

  public UnaryCallable<ListToolsRequest, ListToolsResponse> listToolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listToolsCallable()");
  }

  public UnaryCallable<GetToolRequest, Tool> getToolCallable() {
    throw new UnsupportedOperationException("Not implemented: getToolCallable()");
  }

  public UnaryCallable<UpdateToolRequest, Tool> updateToolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateToolCallable()");
  }

  public UnaryCallable<DeleteToolRequest, Empty> deleteToolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteToolCallable()");
  }

  public UnaryCallable<ListToolVersionsRequest, ListToolVersionsPagedResponse>
      listToolVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listToolVersionsPagedCallable()");
  }

  public UnaryCallable<ListToolVersionsRequest, ListToolVersionsResponse>
      listToolVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listToolVersionsCallable()");
  }

  public UnaryCallable<CreateToolVersionRequest, ToolVersion> createToolVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: createToolVersionCallable()");
  }

  public UnaryCallable<GetToolVersionRequest, ToolVersion> getToolVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getToolVersionCallable()");
  }

  public UnaryCallable<DeleteToolVersionRequest, Empty> deleteToolVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteToolVersionCallable()");
  }

  public UnaryCallable<RestoreToolVersionRequest, RestoreToolVersionResponse>
      restoreToolVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreToolVersionCallable()");
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
