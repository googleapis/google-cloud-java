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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Tools service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcToolsStub extends ToolsStub {
  private static final MethodDescriptor<CreateToolRequest, Tool> createToolMethodDescriptor =
      MethodDescriptor.<CreateToolRequest, Tool>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Tools/CreateTool")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateToolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tool.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListToolsRequest, ListToolsResponse>
      listToolsMethodDescriptor =
          MethodDescriptor.<ListToolsRequest, ListToolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Tools/ListTools")
              .setRequestMarshaller(ProtoUtils.marshaller(ListToolsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListToolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportToolsRequest, Operation> exportToolsMethodDescriptor =
      MethodDescriptor.<ExportToolsRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Tools/ExportTools")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportToolsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetToolRequest, Tool> getToolMethodDescriptor =
      MethodDescriptor.<GetToolRequest, Tool>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Tools/GetTool")
          .setRequestMarshaller(ProtoUtils.marshaller(GetToolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tool.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateToolRequest, Tool> updateToolMethodDescriptor =
      MethodDescriptor.<UpdateToolRequest, Tool>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Tools/UpdateTool")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateToolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tool.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteToolRequest, Empty> deleteToolMethodDescriptor =
      MethodDescriptor.<DeleteToolRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Tools/DeleteTool")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteToolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateToolRequest, Tool> createToolCallable;
  private final UnaryCallable<ListToolsRequest, ListToolsResponse> listToolsCallable;
  private final UnaryCallable<ListToolsRequest, ListToolsPagedResponse> listToolsPagedCallable;
  private final UnaryCallable<ExportToolsRequest, Operation> exportToolsCallable;
  private final OperationCallable<ExportToolsRequest, ExportToolsResponse, ExportToolsMetadata>
      exportToolsOperationCallable;
  private final UnaryCallable<GetToolRequest, Tool> getToolCallable;
  private final UnaryCallable<UpdateToolRequest, Tool> updateToolCallable;
  private final UnaryCallable<DeleteToolRequest, Empty> deleteToolCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcToolsStub create(ToolsStubSettings settings) throws IOException {
    return new GrpcToolsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcToolsStub create(ClientContext clientContext) throws IOException {
    return new GrpcToolsStub(ToolsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcToolsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcToolsStub(
        ToolsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcToolsStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcToolsStub(ToolsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcToolsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcToolsStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcToolsStub(
      ToolsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateToolRequest, Tool> createToolTransportSettings =
        GrpcCallSettings.<CreateToolRequest, Tool>newBuilder()
            .setMethodDescriptor(createToolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListToolsRequest, ListToolsResponse> listToolsTransportSettings =
        GrpcCallSettings.<ListToolsRequest, ListToolsResponse>newBuilder()
            .setMethodDescriptor(listToolsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportToolsRequest, Operation> exportToolsTransportSettings =
        GrpcCallSettings.<ExportToolsRequest, Operation>newBuilder()
            .setMethodDescriptor(exportToolsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetToolRequest, Tool> getToolTransportSettings =
        GrpcCallSettings.<GetToolRequest, Tool>newBuilder()
            .setMethodDescriptor(getToolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateToolRequest, Tool> updateToolTransportSettings =
        GrpcCallSettings.<UpdateToolRequest, Tool>newBuilder()
            .setMethodDescriptor(updateToolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tool.name", String.valueOf(request.getTool().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteToolRequest, Empty> deleteToolTransportSettings =
        GrpcCallSettings.<DeleteToolRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteToolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createToolCallable =
        callableFactory.createUnaryCallable(
            createToolTransportSettings, settings.createToolSettings(), clientContext);
    this.listToolsCallable =
        callableFactory.createUnaryCallable(
            listToolsTransportSettings, settings.listToolsSettings(), clientContext);
    this.listToolsPagedCallable =
        callableFactory.createPagedCallable(
            listToolsTransportSettings, settings.listToolsSettings(), clientContext);
    this.exportToolsCallable =
        callableFactory.createUnaryCallable(
            exportToolsTransportSettings, settings.exportToolsSettings(), clientContext);
    this.exportToolsOperationCallable =
        callableFactory.createOperationCallable(
            exportToolsTransportSettings,
            settings.exportToolsOperationSettings(),
            clientContext,
            operationsStub);
    this.getToolCallable =
        callableFactory.createUnaryCallable(
            getToolTransportSettings, settings.getToolSettings(), clientContext);
    this.updateToolCallable =
        callableFactory.createUnaryCallable(
            updateToolTransportSettings, settings.updateToolSettings(), clientContext);
    this.deleteToolCallable =
        callableFactory.createUnaryCallable(
            deleteToolTransportSettings, settings.deleteToolSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateToolRequest, Tool> createToolCallable() {
    return createToolCallable;
  }

  @Override
  public UnaryCallable<ListToolsRequest, ListToolsResponse> listToolsCallable() {
    return listToolsCallable;
  }

  @Override
  public UnaryCallable<ListToolsRequest, ListToolsPagedResponse> listToolsPagedCallable() {
    return listToolsPagedCallable;
  }

  @Override
  public UnaryCallable<ExportToolsRequest, Operation> exportToolsCallable() {
    return exportToolsCallable;
  }

  @Override
  public OperationCallable<ExportToolsRequest, ExportToolsResponse, ExportToolsMetadata>
      exportToolsOperationCallable() {
    return exportToolsOperationCallable;
  }

  @Override
  public UnaryCallable<GetToolRequest, Tool> getToolCallable() {
    return getToolCallable;
  }

  @Override
  public UnaryCallable<UpdateToolRequest, Tool> updateToolCallable() {
    return updateToolCallable;
  }

  @Override
  public UnaryCallable<DeleteToolRequest, Empty> deleteToolCallable() {
    return deleteToolCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
