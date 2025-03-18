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

package com.google.cloud.workflows.v1.stub;

import static com.google.cloud.workflows.v1.WorkflowsClient.ListLocationsPagedResponse;
import static com.google.cloud.workflows.v1.WorkflowsClient.ListWorkflowRevisionsPagedResponse;
import static com.google.cloud.workflows.v1.WorkflowsClient.ListWorkflowsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.workflows.v1.CreateWorkflowRequest;
import com.google.cloud.workflows.v1.DeleteWorkflowRequest;
import com.google.cloud.workflows.v1.GetWorkflowRequest;
import com.google.cloud.workflows.v1.ListWorkflowRevisionsRequest;
import com.google.cloud.workflows.v1.ListWorkflowRevisionsResponse;
import com.google.cloud.workflows.v1.ListWorkflowsRequest;
import com.google.cloud.workflows.v1.ListWorkflowsResponse;
import com.google.cloud.workflows.v1.OperationMetadata;
import com.google.cloud.workflows.v1.UpdateWorkflowRequest;
import com.google.cloud.workflows.v1.Workflow;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Workflows service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcWorkflowsStub extends WorkflowsStub {
  private static final MethodDescriptor<ListWorkflowsRequest, ListWorkflowsResponse>
      listWorkflowsMethodDescriptor =
          MethodDescriptor.<ListWorkflowsRequest, ListWorkflowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workflows.v1.Workflows/ListWorkflows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkflowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkflowsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkflowRequest, Workflow> getWorkflowMethodDescriptor =
      MethodDescriptor.<GetWorkflowRequest, Workflow>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.workflows.v1.Workflows/GetWorkflow")
          .setRequestMarshaller(ProtoUtils.marshaller(GetWorkflowRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Workflow.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateWorkflowRequest, Operation>
      createWorkflowMethodDescriptor =
          MethodDescriptor.<CreateWorkflowRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workflows.v1.Workflows/CreateWorkflow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkflowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkflowRequest, Operation>
      deleteWorkflowMethodDescriptor =
          MethodDescriptor.<DeleteWorkflowRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workflows.v1.Workflows/DeleteWorkflow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkflowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateWorkflowRequest, Operation>
      updateWorkflowMethodDescriptor =
          MethodDescriptor.<UpdateWorkflowRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workflows.v1.Workflows/UpdateWorkflow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWorkflowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse>
      listWorkflowRevisionsMethodDescriptor =
          MethodDescriptor.<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workflows.v1.Workflows/ListWorkflowRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkflowRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkflowRevisionsResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListWorkflowsRequest, ListWorkflowsResponse> listWorkflowsCallable;
  private final UnaryCallable<ListWorkflowsRequest, ListWorkflowsPagedResponse>
      listWorkflowsPagedCallable;
  private final UnaryCallable<GetWorkflowRequest, Workflow> getWorkflowCallable;
  private final UnaryCallable<CreateWorkflowRequest, Operation> createWorkflowCallable;
  private final OperationCallable<CreateWorkflowRequest, Workflow, OperationMetadata>
      createWorkflowOperationCallable;
  private final UnaryCallable<DeleteWorkflowRequest, Operation> deleteWorkflowCallable;
  private final OperationCallable<DeleteWorkflowRequest, Empty, OperationMetadata>
      deleteWorkflowOperationCallable;
  private final UnaryCallable<UpdateWorkflowRequest, Operation> updateWorkflowCallable;
  private final OperationCallable<UpdateWorkflowRequest, Workflow, OperationMetadata>
      updateWorkflowOperationCallable;
  private final UnaryCallable<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse>
      listWorkflowRevisionsCallable;
  private final UnaryCallable<ListWorkflowRevisionsRequest, ListWorkflowRevisionsPagedResponse>
      listWorkflowRevisionsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcWorkflowsStub create(WorkflowsStubSettings settings) throws IOException {
    return new GrpcWorkflowsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcWorkflowsStub create(ClientContext clientContext) throws IOException {
    return new GrpcWorkflowsStub(WorkflowsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcWorkflowsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcWorkflowsStub(
        WorkflowsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcWorkflowsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcWorkflowsStub(WorkflowsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcWorkflowsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcWorkflowsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcWorkflowsStub(
      WorkflowsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListWorkflowsRequest, ListWorkflowsResponse> listWorkflowsTransportSettings =
        GrpcCallSettings.<ListWorkflowsRequest, ListWorkflowsResponse>newBuilder()
            .setMethodDescriptor(listWorkflowsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetWorkflowRequest, Workflow> getWorkflowTransportSettings =
        GrpcCallSettings.<GetWorkflowRequest, Workflow>newBuilder()
            .setMethodDescriptor(getWorkflowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateWorkflowRequest, Operation> createWorkflowTransportSettings =
        GrpcCallSettings.<CreateWorkflowRequest, Operation>newBuilder()
            .setMethodDescriptor(createWorkflowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteWorkflowRequest, Operation> deleteWorkflowTransportSettings =
        GrpcCallSettings.<DeleteWorkflowRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteWorkflowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateWorkflowRequest, Operation> updateWorkflowTransportSettings =
        GrpcCallSettings.<UpdateWorkflowRequest, Operation>newBuilder()
            .setMethodDescriptor(updateWorkflowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("workflow.name", String.valueOf(request.getWorkflow().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse>
        listWorkflowRevisionsTransportSettings =
            GrpcCallSettings
                .<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse>newBuilder()
                .setMethodDescriptor(listWorkflowRevisionsMethodDescriptor)
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

    this.listWorkflowsCallable =
        callableFactory.createUnaryCallable(
            listWorkflowsTransportSettings, settings.listWorkflowsSettings(), clientContext);
    this.listWorkflowsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkflowsTransportSettings, settings.listWorkflowsSettings(), clientContext);
    this.getWorkflowCallable =
        callableFactory.createUnaryCallable(
            getWorkflowTransportSettings, settings.getWorkflowSettings(), clientContext);
    this.createWorkflowCallable =
        callableFactory.createUnaryCallable(
            createWorkflowTransportSettings, settings.createWorkflowSettings(), clientContext);
    this.createWorkflowOperationCallable =
        callableFactory.createOperationCallable(
            createWorkflowTransportSettings,
            settings.createWorkflowOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteWorkflowCallable =
        callableFactory.createUnaryCallable(
            deleteWorkflowTransportSettings, settings.deleteWorkflowSettings(), clientContext);
    this.deleteWorkflowOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkflowTransportSettings,
            settings.deleteWorkflowOperationSettings(),
            clientContext,
            operationsStub);
    this.updateWorkflowCallable =
        callableFactory.createUnaryCallable(
            updateWorkflowTransportSettings, settings.updateWorkflowSettings(), clientContext);
    this.updateWorkflowOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkflowTransportSettings,
            settings.updateWorkflowOperationSettings(),
            clientContext,
            operationsStub);
    this.listWorkflowRevisionsCallable =
        callableFactory.createUnaryCallable(
            listWorkflowRevisionsTransportSettings,
            settings.listWorkflowRevisionsSettings(),
            clientContext);
    this.listWorkflowRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkflowRevisionsTransportSettings,
            settings.listWorkflowRevisionsSettings(),
            clientContext);
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
  public UnaryCallable<ListWorkflowsRequest, ListWorkflowsResponse> listWorkflowsCallable() {
    return listWorkflowsCallable;
  }

  @Override
  public UnaryCallable<ListWorkflowsRequest, ListWorkflowsPagedResponse>
      listWorkflowsPagedCallable() {
    return listWorkflowsPagedCallable;
  }

  @Override
  public UnaryCallable<GetWorkflowRequest, Workflow> getWorkflowCallable() {
    return getWorkflowCallable;
  }

  @Override
  public UnaryCallable<CreateWorkflowRequest, Operation> createWorkflowCallable() {
    return createWorkflowCallable;
  }

  @Override
  public OperationCallable<CreateWorkflowRequest, Workflow, OperationMetadata>
      createWorkflowOperationCallable() {
    return createWorkflowOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkflowRequest, Operation> deleteWorkflowCallable() {
    return deleteWorkflowCallable;
  }

  @Override
  public OperationCallable<DeleteWorkflowRequest, Empty, OperationMetadata>
      deleteWorkflowOperationCallable() {
    return deleteWorkflowOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkflowRequest, Operation> updateWorkflowCallable() {
    return updateWorkflowCallable;
  }

  @Override
  public OperationCallable<UpdateWorkflowRequest, Workflow, OperationMetadata>
      updateWorkflowOperationCallable() {
    return updateWorkflowOperationCallable;
  }

  @Override
  public UnaryCallable<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse>
      listWorkflowRevisionsCallable() {
    return listWorkflowRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListWorkflowRevisionsRequest, ListWorkflowRevisionsPagedResponse>
      listWorkflowRevisionsPagedCallable() {
    return listWorkflowRevisionsPagedCallable;
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
