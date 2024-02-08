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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.ToolsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.ToolsClient.ListToolsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportToolsMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportToolsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Tool;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest;
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
 * Base stub class for the Tools service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ToolsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreateToolRequest, Tool> createToolCallable() {
    throw new UnsupportedOperationException("Not implemented: createToolCallable()");
  }

  public UnaryCallable<ListToolsRequest, ListToolsPagedResponse> listToolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listToolsPagedCallable()");
  }

  public UnaryCallable<ListToolsRequest, ListToolsResponse> listToolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listToolsCallable()");
  }

  public OperationCallable<ExportToolsRequest, ExportToolsResponse, ExportToolsMetadata>
      exportToolsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportToolsOperationCallable()");
  }

  public UnaryCallable<ExportToolsRequest, Operation> exportToolsCallable() {
    throw new UnsupportedOperationException("Not implemented: exportToolsCallable()");
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
