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

package com.google.area120.tables.v1alpha.stub;

import static com.google.area120.tables.v1alpha.TablesServiceClient.ListRowsPagedResponse;
import static com.google.area120.tables.v1alpha.TablesServiceClient.ListTablesPagedResponse;
import static com.google.area120.tables.v1alpha.TablesServiceClient.ListWorkspacesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.area120.tables.v1alpha1.BatchCreateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchCreateRowsResponse;
import com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse;
import com.google.area120.tables.v1alpha1.CreateRowRequest;
import com.google.area120.tables.v1alpha1.DeleteRowRequest;
import com.google.area120.tables.v1alpha1.GetRowRequest;
import com.google.area120.tables.v1alpha1.GetTableRequest;
import com.google.area120.tables.v1alpha1.GetWorkspaceRequest;
import com.google.area120.tables.v1alpha1.ListRowsRequest;
import com.google.area120.tables.v1alpha1.ListRowsResponse;
import com.google.area120.tables.v1alpha1.ListTablesRequest;
import com.google.area120.tables.v1alpha1.ListTablesResponse;
import com.google.area120.tables.v1alpha1.ListWorkspacesRequest;
import com.google.area120.tables.v1alpha1.ListWorkspacesResponse;
import com.google.area120.tables.v1alpha1.Row;
import com.google.area120.tables.v1alpha1.Table;
import com.google.area120.tables.v1alpha1.UpdateRowRequest;
import com.google.area120.tables.v1alpha1.Workspace;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TablesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcTablesServiceStub extends TablesServiceStub {
  private static final MethodDescriptor<GetTableRequest, Table> getTableMethodDescriptor =
      MethodDescriptor.<GetTableRequest, Table>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.area120.tables.v1alpha1.TablesService/GetTable")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTableRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Table.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListTablesRequest, ListTablesResponse>
      listTablesMethodDescriptor =
          MethodDescriptor.<ListTablesRequest, ListTablesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/ListTables")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTablesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTablesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetWorkspaceRequest, Workspace>
      getWorkspaceMethodDescriptor =
          MethodDescriptor.<GetWorkspaceRequest, Workspace>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/GetWorkspace")
              .setRequestMarshaller(ProtoUtils.marshaller(GetWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Workspace.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListWorkspacesRequest, ListWorkspacesResponse>
      listWorkspacesMethodDescriptor =
          MethodDescriptor.<ListWorkspacesRequest, ListWorkspacesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/ListWorkspaces")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkspacesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkspacesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetRowRequest, Row> getRowMethodDescriptor =
      MethodDescriptor.<GetRowRequest, Row>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.area120.tables.v1alpha1.TablesService/GetRow")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRowRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Row.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListRowsRequest, ListRowsResponse>
      listRowsMethodDescriptor =
          MethodDescriptor.<ListRowsRequest, ListRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/ListRows")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListRowsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateRowRequest, Row> createRowMethodDescriptor =
      MethodDescriptor.<CreateRowRequest, Row>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.area120.tables.v1alpha1.TablesService/CreateRow")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateRowRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Row.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<BatchCreateRowsRequest, BatchCreateRowsResponse>
      batchCreateRowsMethodDescriptor =
          MethodDescriptor.<BatchCreateRowsRequest, BatchCreateRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/BatchCreateRows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateRowsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateRowRequest, Row> updateRowMethodDescriptor =
      MethodDescriptor.<UpdateRowRequest, Row>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.area120.tables.v1alpha1.TablesService/UpdateRow")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateRowRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Row.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
      batchUpdateRowsMethodDescriptor =
          MethodDescriptor.<BatchUpdateRowsRequest, BatchUpdateRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/BatchUpdateRows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdateRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchUpdateRowsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteRowRequest, Empty> deleteRowMethodDescriptor =
      MethodDescriptor.<DeleteRowRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.area120.tables.v1alpha1.TablesService/DeleteRow")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteRowRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<BatchDeleteRowsRequest, Empty>
      batchDeleteRowsMethodDescriptor =
          MethodDescriptor.<BatchDeleteRowsRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.area120.tables.v1alpha1.TablesService/BatchDeleteRows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetTableRequest, Table> getTableCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable;
  private final UnaryCallable<GetWorkspaceRequest, Workspace> getWorkspaceCallable;
  private final UnaryCallable<ListWorkspacesRequest, ListWorkspacesResponse> listWorkspacesCallable;
  private final UnaryCallable<ListWorkspacesRequest, ListWorkspacesPagedResponse>
      listWorkspacesPagedCallable;
  private final UnaryCallable<GetRowRequest, Row> getRowCallable;
  private final UnaryCallable<ListRowsRequest, ListRowsResponse> listRowsCallable;
  private final UnaryCallable<ListRowsRequest, ListRowsPagedResponse> listRowsPagedCallable;
  private final UnaryCallable<CreateRowRequest, Row> createRowCallable;
  private final UnaryCallable<BatchCreateRowsRequest, BatchCreateRowsResponse>
      batchCreateRowsCallable;
  private final UnaryCallable<UpdateRowRequest, Row> updateRowCallable;
  private final UnaryCallable<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
      batchUpdateRowsCallable;
  private final UnaryCallable<DeleteRowRequest, Empty> deleteRowCallable;
  private final UnaryCallable<BatchDeleteRowsRequest, Empty> batchDeleteRowsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTablesServiceStub create(TablesServiceStubSettings settings)
      throws IOException {
    return new GrpcTablesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTablesServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcTablesServiceStub(TablesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTablesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTablesServiceStub(
        TablesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTablesServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTablesServiceStub(TablesServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTablesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTablesServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTablesServiceStub(
      TablesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetTableRequest, Table> getTableTransportSettings =
        GrpcCallSettings.<GetTableRequest, Table>newBuilder()
            .setMethodDescriptor(getTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTablesRequest, ListTablesResponse> listTablesTransportSettings =
        GrpcCallSettings.<ListTablesRequest, ListTablesResponse>newBuilder()
            .setMethodDescriptor(listTablesMethodDescriptor)
            .build();
    GrpcCallSettings<GetWorkspaceRequest, Workspace> getWorkspaceTransportSettings =
        GrpcCallSettings.<GetWorkspaceRequest, Workspace>newBuilder()
            .setMethodDescriptor(getWorkspaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListWorkspacesRequest, ListWorkspacesResponse>
        listWorkspacesTransportSettings =
            GrpcCallSettings.<ListWorkspacesRequest, ListWorkspacesResponse>newBuilder()
                .setMethodDescriptor(listWorkspacesMethodDescriptor)
                .build();
    GrpcCallSettings<GetRowRequest, Row> getRowTransportSettings =
        GrpcCallSettings.<GetRowRequest, Row>newBuilder()
            .setMethodDescriptor(getRowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRowsRequest, ListRowsResponse> listRowsTransportSettings =
        GrpcCallSettings.<ListRowsRequest, ListRowsResponse>newBuilder()
            .setMethodDescriptor(listRowsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateRowRequest, Row> createRowTransportSettings =
        GrpcCallSettings.<CreateRowRequest, Row>newBuilder()
            .setMethodDescriptor(createRowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchCreateRowsRequest, BatchCreateRowsResponse>
        batchCreateRowsTransportSettings =
            GrpcCallSettings.<BatchCreateRowsRequest, BatchCreateRowsResponse>newBuilder()
                .setMethodDescriptor(batchCreateRowsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateRowRequest, Row> updateRowTransportSettings =
        GrpcCallSettings.<UpdateRowRequest, Row>newBuilder()
            .setMethodDescriptor(updateRowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("row.name", String.valueOf(request.getRow().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
        batchUpdateRowsTransportSettings =
            GrpcCallSettings.<BatchUpdateRowsRequest, BatchUpdateRowsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateRowsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteRowRequest, Empty> deleteRowTransportSettings =
        GrpcCallSettings.<DeleteRowRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchDeleteRowsRequest, Empty> batchDeleteRowsTransportSettings =
        GrpcCallSettings.<BatchDeleteRowsRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeleteRowsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getTableCallable =
        callableFactory.createUnaryCallable(
            getTableTransportSettings, settings.getTableSettings(), clientContext);
    this.listTablesCallable =
        callableFactory.createUnaryCallable(
            listTablesTransportSettings, settings.listTablesSettings(), clientContext);
    this.listTablesPagedCallable =
        callableFactory.createPagedCallable(
            listTablesTransportSettings, settings.listTablesSettings(), clientContext);
    this.getWorkspaceCallable =
        callableFactory.createUnaryCallable(
            getWorkspaceTransportSettings, settings.getWorkspaceSettings(), clientContext);
    this.listWorkspacesCallable =
        callableFactory.createUnaryCallable(
            listWorkspacesTransportSettings, settings.listWorkspacesSettings(), clientContext);
    this.listWorkspacesPagedCallable =
        callableFactory.createPagedCallable(
            listWorkspacesTransportSettings, settings.listWorkspacesSettings(), clientContext);
    this.getRowCallable =
        callableFactory.createUnaryCallable(
            getRowTransportSettings, settings.getRowSettings(), clientContext);
    this.listRowsCallable =
        callableFactory.createUnaryCallable(
            listRowsTransportSettings, settings.listRowsSettings(), clientContext);
    this.listRowsPagedCallable =
        callableFactory.createPagedCallable(
            listRowsTransportSettings, settings.listRowsSettings(), clientContext);
    this.createRowCallable =
        callableFactory.createUnaryCallable(
            createRowTransportSettings, settings.createRowSettings(), clientContext);
    this.batchCreateRowsCallable =
        callableFactory.createUnaryCallable(
            batchCreateRowsTransportSettings, settings.batchCreateRowsSettings(), clientContext);
    this.updateRowCallable =
        callableFactory.createUnaryCallable(
            updateRowTransportSettings, settings.updateRowSettings(), clientContext);
    this.batchUpdateRowsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateRowsTransportSettings, settings.batchUpdateRowsSettings(), clientContext);
    this.deleteRowCallable =
        callableFactory.createUnaryCallable(
            deleteRowTransportSettings, settings.deleteRowSettings(), clientContext);
    this.batchDeleteRowsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteRowsTransportSettings, settings.batchDeleteRowsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetTableRequest, Table> getTableCallable() {
    return getTableCallable;
  }

  @Override
  public UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable() {
    return listTablesCallable;
  }

  @Override
  public UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable() {
    return listTablesPagedCallable;
  }

  @Override
  public UnaryCallable<GetWorkspaceRequest, Workspace> getWorkspaceCallable() {
    return getWorkspaceCallable;
  }

  @Override
  public UnaryCallable<ListWorkspacesRequest, ListWorkspacesResponse> listWorkspacesCallable() {
    return listWorkspacesCallable;
  }

  @Override
  public UnaryCallable<ListWorkspacesRequest, ListWorkspacesPagedResponse>
      listWorkspacesPagedCallable() {
    return listWorkspacesPagedCallable;
  }

  @Override
  public UnaryCallable<GetRowRequest, Row> getRowCallable() {
    return getRowCallable;
  }

  @Override
  public UnaryCallable<ListRowsRequest, ListRowsResponse> listRowsCallable() {
    return listRowsCallable;
  }

  @Override
  public UnaryCallable<ListRowsRequest, ListRowsPagedResponse> listRowsPagedCallable() {
    return listRowsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateRowRequest, Row> createRowCallable() {
    return createRowCallable;
  }

  @Override
  public UnaryCallable<BatchCreateRowsRequest, BatchCreateRowsResponse> batchCreateRowsCallable() {
    return batchCreateRowsCallable;
  }

  @Override
  public UnaryCallable<UpdateRowRequest, Row> updateRowCallable() {
    return updateRowCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateRowsRequest, BatchUpdateRowsResponse> batchUpdateRowsCallable() {
    return batchUpdateRowsCallable;
  }

  @Override
  public UnaryCallable<DeleteRowRequest, Empty> deleteRowCallable() {
    return deleteRowCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteRowsRequest, Empty> batchDeleteRowsCallable() {
    return batchDeleteRowsCallable;
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
