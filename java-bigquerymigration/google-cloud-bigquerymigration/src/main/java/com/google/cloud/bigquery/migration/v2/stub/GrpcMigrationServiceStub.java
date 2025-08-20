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

package com.google.cloud.bigquery.migration.v2.stub;

import static com.google.cloud.bigquery.migration.v2.MigrationServiceClient.ListMigrationSubtasksPagedResponse;
import static com.google.cloud.bigquery.migration.v2.MigrationServiceClient.ListMigrationWorkflowsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.migration.v2.CreateMigrationWorkflowRequest;
import com.google.cloud.bigquery.migration.v2.DeleteMigrationWorkflowRequest;
import com.google.cloud.bigquery.migration.v2.GetMigrationSubtaskRequest;
import com.google.cloud.bigquery.migration.v2.GetMigrationWorkflowRequest;
import com.google.cloud.bigquery.migration.v2.ListMigrationSubtasksRequest;
import com.google.cloud.bigquery.migration.v2.ListMigrationSubtasksResponse;
import com.google.cloud.bigquery.migration.v2.ListMigrationWorkflowsRequest;
import com.google.cloud.bigquery.migration.v2.ListMigrationWorkflowsResponse;
import com.google.cloud.bigquery.migration.v2.MigrationSubtask;
import com.google.cloud.bigquery.migration.v2.MigrationWorkflow;
import com.google.cloud.bigquery.migration.v2.StartMigrationWorkflowRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MigrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcMigrationServiceStub extends MigrationServiceStub {
  private static final MethodDescriptor<CreateMigrationWorkflowRequest, MigrationWorkflow>
      createMigrationWorkflowMethodDescriptor =
          MethodDescriptor.<CreateMigrationWorkflowRequest, MigrationWorkflow>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/CreateMigrationWorkflow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMigrationWorkflowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MigrationWorkflow.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMigrationWorkflowRequest, MigrationWorkflow>
      getMigrationWorkflowMethodDescriptor =
          MethodDescriptor.<GetMigrationWorkflowRequest, MigrationWorkflow>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/GetMigrationWorkflow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMigrationWorkflowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MigrationWorkflow.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>
      listMigrationWorkflowsMethodDescriptor =
          MethodDescriptor
              .<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/ListMigrationWorkflows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMigrationWorkflowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMigrationWorkflowsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMigrationWorkflowRequest, Empty>
      deleteMigrationWorkflowMethodDescriptor =
          MethodDescriptor.<DeleteMigrationWorkflowRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/DeleteMigrationWorkflow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMigrationWorkflowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<StartMigrationWorkflowRequest, Empty>
      startMigrationWorkflowMethodDescriptor =
          MethodDescriptor.<StartMigrationWorkflowRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/StartMigrationWorkflow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartMigrationWorkflowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMigrationSubtaskRequest, MigrationSubtask>
      getMigrationSubtaskMethodDescriptor =
          MethodDescriptor.<GetMigrationSubtaskRequest, MigrationSubtask>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/GetMigrationSubtask")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMigrationSubtaskRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MigrationSubtask.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>
      listMigrationSubtasksMethodDescriptor =
          MethodDescriptor.<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/ListMigrationSubtasks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMigrationSubtasksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMigrationSubtasksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateMigrationWorkflowRequest, MigrationWorkflow>
      createMigrationWorkflowCallable;
  private final UnaryCallable<GetMigrationWorkflowRequest, MigrationWorkflow>
      getMigrationWorkflowCallable;
  private final UnaryCallable<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>
      listMigrationWorkflowsCallable;
  private final UnaryCallable<ListMigrationWorkflowsRequest, ListMigrationWorkflowsPagedResponse>
      listMigrationWorkflowsPagedCallable;
  private final UnaryCallable<DeleteMigrationWorkflowRequest, Empty>
      deleteMigrationWorkflowCallable;
  private final UnaryCallable<StartMigrationWorkflowRequest, Empty> startMigrationWorkflowCallable;
  private final UnaryCallable<GetMigrationSubtaskRequest, MigrationSubtask>
      getMigrationSubtaskCallable;
  private final UnaryCallable<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>
      listMigrationSubtasksCallable;
  private final UnaryCallable<ListMigrationSubtasksRequest, ListMigrationSubtasksPagedResponse>
      listMigrationSubtasksPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMigrationServiceStub create(MigrationServiceStubSettings settings)
      throws IOException {
    return new GrpcMigrationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMigrationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMigrationServiceStub(
        MigrationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMigrationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMigrationServiceStub(
        MigrationServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMigrationServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMigrationServiceStub(
      MigrationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcMigrationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMigrationServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMigrationServiceStub(
      MigrationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateMigrationWorkflowRequest, MigrationWorkflow>
        createMigrationWorkflowTransportSettings =
            GrpcCallSettings.<CreateMigrationWorkflowRequest, MigrationWorkflow>newBuilder()
                .setMethodDescriptor(createMigrationWorkflowMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMigrationWorkflowRequest, MigrationWorkflow>
        getMigrationWorkflowTransportSettings =
            GrpcCallSettings.<GetMigrationWorkflowRequest, MigrationWorkflow>newBuilder()
                .setMethodDescriptor(getMigrationWorkflowMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>
        listMigrationWorkflowsTransportSettings =
            GrpcCallSettings
                .<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>newBuilder()
                .setMethodDescriptor(listMigrationWorkflowsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMigrationWorkflowRequest, Empty>
        deleteMigrationWorkflowTransportSettings =
            GrpcCallSettings.<DeleteMigrationWorkflowRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteMigrationWorkflowMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StartMigrationWorkflowRequest, Empty> startMigrationWorkflowTransportSettings =
        GrpcCallSettings.<StartMigrationWorkflowRequest, Empty>newBuilder()
            .setMethodDescriptor(startMigrationWorkflowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetMigrationSubtaskRequest, MigrationSubtask>
        getMigrationSubtaskTransportSettings =
            GrpcCallSettings.<GetMigrationSubtaskRequest, MigrationSubtask>newBuilder()
                .setMethodDescriptor(getMigrationSubtaskMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>
        listMigrationSubtasksTransportSettings =
            GrpcCallSettings
                .<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>newBuilder()
                .setMethodDescriptor(listMigrationSubtasksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createMigrationWorkflowCallable =
        callableFactory.createUnaryCallable(
            createMigrationWorkflowTransportSettings,
            settings.createMigrationWorkflowSettings(),
            clientContext);
    this.getMigrationWorkflowCallable =
        callableFactory.createUnaryCallable(
            getMigrationWorkflowTransportSettings,
            settings.getMigrationWorkflowSettings(),
            clientContext);
    this.listMigrationWorkflowsCallable =
        callableFactory.createUnaryCallable(
            listMigrationWorkflowsTransportSettings,
            settings.listMigrationWorkflowsSettings(),
            clientContext);
    this.listMigrationWorkflowsPagedCallable =
        callableFactory.createPagedCallable(
            listMigrationWorkflowsTransportSettings,
            settings.listMigrationWorkflowsSettings(),
            clientContext);
    this.deleteMigrationWorkflowCallable =
        callableFactory.createUnaryCallable(
            deleteMigrationWorkflowTransportSettings,
            settings.deleteMigrationWorkflowSettings(),
            clientContext);
    this.startMigrationWorkflowCallable =
        callableFactory.createUnaryCallable(
            startMigrationWorkflowTransportSettings,
            settings.startMigrationWorkflowSettings(),
            clientContext);
    this.getMigrationSubtaskCallable =
        callableFactory.createUnaryCallable(
            getMigrationSubtaskTransportSettings,
            settings.getMigrationSubtaskSettings(),
            clientContext);
    this.listMigrationSubtasksCallable =
        callableFactory.createUnaryCallable(
            listMigrationSubtasksTransportSettings,
            settings.listMigrationSubtasksSettings(),
            clientContext);
    this.listMigrationSubtasksPagedCallable =
        callableFactory.createPagedCallable(
            listMigrationSubtasksTransportSettings,
            settings.listMigrationSubtasksSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateMigrationWorkflowRequest, MigrationWorkflow>
      createMigrationWorkflowCallable() {
    return createMigrationWorkflowCallable;
  }

  @Override
  public UnaryCallable<GetMigrationWorkflowRequest, MigrationWorkflow>
      getMigrationWorkflowCallable() {
    return getMigrationWorkflowCallable;
  }

  @Override
  public UnaryCallable<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>
      listMigrationWorkflowsCallable() {
    return listMigrationWorkflowsCallable;
  }

  @Override
  public UnaryCallable<ListMigrationWorkflowsRequest, ListMigrationWorkflowsPagedResponse>
      listMigrationWorkflowsPagedCallable() {
    return listMigrationWorkflowsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteMigrationWorkflowRequest, Empty> deleteMigrationWorkflowCallable() {
    return deleteMigrationWorkflowCallable;
  }

  @Override
  public UnaryCallable<StartMigrationWorkflowRequest, Empty> startMigrationWorkflowCallable() {
    return startMigrationWorkflowCallable;
  }

  @Override
  public UnaryCallable<GetMigrationSubtaskRequest, MigrationSubtask> getMigrationSubtaskCallable() {
    return getMigrationSubtaskCallable;
  }

  @Override
  public UnaryCallable<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>
      listMigrationSubtasksCallable() {
    return listMigrationSubtasksCallable;
  }

  @Override
  public UnaryCallable<ListMigrationSubtasksRequest, ListMigrationSubtasksPagedResponse>
      listMigrationSubtasksPagedCallable() {
    return listMigrationSubtasksPagedCallable;
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
