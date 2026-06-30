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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTableRowsPagedResponse;
import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTablesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse;
import com.google.cloud.chronicle.v1.CreateDataTableRequest;
import com.google.cloud.chronicle.v1.CreateDataTableRowRequest;
import com.google.cloud.chronicle.v1.DataTable;
import com.google.cloud.chronicle.v1.DataTableOperationErrors;
import com.google.cloud.chronicle.v1.DataTableRow;
import com.google.cloud.chronicle.v1.DeleteDataTableRequest;
import com.google.cloud.chronicle.v1.DeleteDataTableRowRequest;
import com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest;
import com.google.cloud.chronicle.v1.GetDataTableRequest;
import com.google.cloud.chronicle.v1.GetDataTableRowRequest;
import com.google.cloud.chronicle.v1.ListDataTableRowsRequest;
import com.google.cloud.chronicle.v1.ListDataTableRowsResponse;
import com.google.cloud.chronicle.v1.ListDataTablesRequest;
import com.google.cloud.chronicle.v1.ListDataTablesResponse;
import com.google.cloud.chronicle.v1.UpdateDataTableRequest;
import com.google.cloud.chronicle.v1.UpdateDataTableRowRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataTableService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataTableServiceStub extends DataTableServiceStub {
  private static final MethodDescriptor<CreateDataTableRequest, DataTable>
      createDataTableMethodDescriptor =
          MethodDescriptor.<CreateDataTableRequest, DataTable>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/CreateDataTable")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataTable.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDataTablesRequest, ListDataTablesResponse>
      listDataTablesMethodDescriptor =
          MethodDescriptor.<ListDataTablesRequest, ListDataTablesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/ListDataTables")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataTablesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataTablesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDataTableRequest, DataTable>
      getDataTableMethodDescriptor =
          MethodDescriptor.<GetDataTableRequest, DataTable>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/GetDataTable")
              .setRequestMarshaller(ProtoUtils.marshaller(GetDataTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataTable.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDataTableRequest, DataTable>
      updateDataTableMethodDescriptor =
          MethodDescriptor.<UpdateDataTableRequest, DataTable>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/UpdateDataTable")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataTable.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDataTableRequest, Empty>
      deleteDataTableMethodDescriptor =
          MethodDescriptor.<DeleteDataTableRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/DeleteDataTable")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateDataTableRowRequest, DataTableRow>
      createDataTableRowMethodDescriptor =
          MethodDescriptor.<CreateDataTableRowRequest, DataTableRow>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/CreateDataTableRow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataTableRowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataTableRow.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDataTableRowRequest, DataTableRow>
      updateDataTableRowMethodDescriptor =
          MethodDescriptor.<UpdateDataTableRowRequest, DataTableRow>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/UpdateDataTableRow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataTableRowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataTableRow.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDataTableRowsRequest, ListDataTableRowsResponse>
      listDataTableRowsMethodDescriptor =
          MethodDescriptor.<ListDataTableRowsRequest, ListDataTableRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/ListDataTableRows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataTableRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataTableRowsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDataTableRowRequest, DataTableRow>
      getDataTableRowMethodDescriptor =
          MethodDescriptor.<GetDataTableRowRequest, DataTableRow>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/GetDataTableRow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataTableRowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataTableRow.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDataTableRowRequest, Empty>
      deleteDataTableRowMethodDescriptor =
          MethodDescriptor.<DeleteDataTableRowRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/DeleteDataTableRow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataTableRowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
      bulkCreateDataTableRowsMethodDescriptor =
          MethodDescriptor
              .<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataTableService/BulkCreateDataTableRows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BulkCreateDataTableRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BulkCreateDataTableRowsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
      bulkGetDataTableRowsMethodDescriptor =
          MethodDescriptor.<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.DataTableService/BulkGetDataTableRows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BulkGetDataTableRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BulkGetDataTableRowsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
      bulkReplaceDataTableRowsMethodDescriptor =
          MethodDescriptor
              .<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataTableService/BulkReplaceDataTableRows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BulkReplaceDataTableRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BulkReplaceDataTableRowsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
      bulkUpdateDataTableRowsMethodDescriptor =
          MethodDescriptor
              .<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataTableService/BulkUpdateDataTableRows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BulkUpdateDataTableRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BulkUpdateDataTableRowsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetDataTableOperationErrorsRequest, DataTableOperationErrors>
      getDataTableOperationErrorsMethodDescriptor =
          MethodDescriptor
              .<GetDataTableOperationErrorsRequest, DataTableOperationErrors>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataTableService/GetDataTableOperationErrors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataTableOperationErrorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DataTableOperationErrors.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateDataTableRequest, DataTable> createDataTableCallable;
  private final UnaryCallable<ListDataTablesRequest, ListDataTablesResponse> listDataTablesCallable;
  private final UnaryCallable<ListDataTablesRequest, ListDataTablesPagedResponse>
      listDataTablesPagedCallable;
  private final UnaryCallable<GetDataTableRequest, DataTable> getDataTableCallable;
  private final UnaryCallable<UpdateDataTableRequest, DataTable> updateDataTableCallable;
  private final UnaryCallable<DeleteDataTableRequest, Empty> deleteDataTableCallable;
  private final UnaryCallable<CreateDataTableRowRequest, DataTableRow> createDataTableRowCallable;
  private final UnaryCallable<UpdateDataTableRowRequest, DataTableRow> updateDataTableRowCallable;
  private final UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsResponse>
      listDataTableRowsCallable;
  private final UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsPagedResponse>
      listDataTableRowsPagedCallable;
  private final UnaryCallable<GetDataTableRowRequest, DataTableRow> getDataTableRowCallable;
  private final UnaryCallable<DeleteDataTableRowRequest, Empty> deleteDataTableRowCallable;
  private final UnaryCallable<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
      bulkCreateDataTableRowsCallable;
  private final UnaryCallable<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
      bulkGetDataTableRowsCallable;
  private final UnaryCallable<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
      bulkReplaceDataTableRowsCallable;
  private final UnaryCallable<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
      bulkUpdateDataTableRowsCallable;
  private final UnaryCallable<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
      getDataTableOperationErrorsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataTableServiceStub create(DataTableServiceStubSettings settings)
      throws IOException {
    return new GrpcDataTableServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataTableServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataTableServiceStub(
        DataTableServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataTableServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataTableServiceStub(
        DataTableServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataTableServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataTableServiceStub(
      DataTableServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataTableServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataTableServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataTableServiceStub(
      DataTableServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDataTableRequest, DataTable> createDataTableTransportSettings =
        GrpcCallSettings.<CreateDataTableRequest, DataTable>newBuilder()
            .setMethodDescriptor(createDataTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<ListDataTablesRequest, ListDataTablesResponse>
        listDataTablesTransportSettings =
            GrpcCallSettings.<ListDataTablesRequest, ListDataTablesResponse>newBuilder()
                .setMethodDescriptor(listDataTablesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetDataTableRequest, DataTable> getDataTableTransportSettings =
        GrpcCallSettings.<GetDataTableRequest, DataTable>newBuilder()
            .setMethodDescriptor(getDataTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateDataTableRequest, DataTable> updateDataTableTransportSettings =
        GrpcCallSettings.<UpdateDataTableRequest, DataTable>newBuilder()
            .setMethodDescriptor(updateDataTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_table.name", String.valueOf(request.getDataTable().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDataTableRequest, Empty> deleteDataTableTransportSettings =
        GrpcCallSettings.<DeleteDataTableRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateDataTableRowRequest, DataTableRow> createDataTableRowTransportSettings =
        GrpcCallSettings.<CreateDataTableRowRequest, DataTableRow>newBuilder()
            .setMethodDescriptor(createDataTableRowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateDataTableRowRequest, DataTableRow> updateDataTableRowTransportSettings =
        GrpcCallSettings.<UpdateDataTableRowRequest, DataTableRow>newBuilder()
            .setMethodDescriptor(updateDataTableRowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_table_row.name", String.valueOf(request.getDataTableRow().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDataTableRowsRequest, ListDataTableRowsResponse>
        listDataTableRowsTransportSettings =
            GrpcCallSettings.<ListDataTableRowsRequest, ListDataTableRowsResponse>newBuilder()
                .setMethodDescriptor(listDataTableRowsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetDataTableRowRequest, DataTableRow> getDataTableRowTransportSettings =
        GrpcCallSettings.<GetDataTableRowRequest, DataTableRow>newBuilder()
            .setMethodDescriptor(getDataTableRowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DeleteDataTableRowRequest, Empty> deleteDataTableRowTransportSettings =
        GrpcCallSettings.<DeleteDataTableRowRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataTableRowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
        bulkCreateDataTableRowsTransportSettings =
            GrpcCallSettings
                .<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>newBuilder()
                .setMethodDescriptor(bulkCreateDataTableRowsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
        bulkGetDataTableRowsTransportSettings =
            GrpcCallSettings.<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>newBuilder()
                .setMethodDescriptor(bulkGetDataTableRowsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
        bulkReplaceDataTableRowsTransportSettings =
            GrpcCallSettings
                .<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>newBuilder()
                .setMethodDescriptor(bulkReplaceDataTableRowsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
        bulkUpdateDataTableRowsTransportSettings =
            GrpcCallSettings
                .<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>newBuilder()
                .setMethodDescriptor(bulkUpdateDataTableRowsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
        getDataTableOperationErrorsTransportSettings =
            GrpcCallSettings
                .<GetDataTableOperationErrorsRequest, DataTableOperationErrors>newBuilder()
                .setMethodDescriptor(getDataTableOperationErrorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.createDataTableCallable =
        callableFactory.createUnaryCallable(
            createDataTableTransportSettings, settings.createDataTableSettings(), clientContext);
    this.listDataTablesCallable =
        callableFactory.createUnaryCallable(
            listDataTablesTransportSettings, settings.listDataTablesSettings(), clientContext);
    this.listDataTablesPagedCallable =
        callableFactory.createPagedCallable(
            listDataTablesTransportSettings, settings.listDataTablesSettings(), clientContext);
    this.getDataTableCallable =
        callableFactory.createUnaryCallable(
            getDataTableTransportSettings, settings.getDataTableSettings(), clientContext);
    this.updateDataTableCallable =
        callableFactory.createUnaryCallable(
            updateDataTableTransportSettings, settings.updateDataTableSettings(), clientContext);
    this.deleteDataTableCallable =
        callableFactory.createUnaryCallable(
            deleteDataTableTransportSettings, settings.deleteDataTableSettings(), clientContext);
    this.createDataTableRowCallable =
        callableFactory.createUnaryCallable(
            createDataTableRowTransportSettings,
            settings.createDataTableRowSettings(),
            clientContext);
    this.updateDataTableRowCallable =
        callableFactory.createUnaryCallable(
            updateDataTableRowTransportSettings,
            settings.updateDataTableRowSettings(),
            clientContext);
    this.listDataTableRowsCallable =
        callableFactory.createUnaryCallable(
            listDataTableRowsTransportSettings,
            settings.listDataTableRowsSettings(),
            clientContext);
    this.listDataTableRowsPagedCallable =
        callableFactory.createPagedCallable(
            listDataTableRowsTransportSettings,
            settings.listDataTableRowsSettings(),
            clientContext);
    this.getDataTableRowCallable =
        callableFactory.createUnaryCallable(
            getDataTableRowTransportSettings, settings.getDataTableRowSettings(), clientContext);
    this.deleteDataTableRowCallable =
        callableFactory.createUnaryCallable(
            deleteDataTableRowTransportSettings,
            settings.deleteDataTableRowSettings(),
            clientContext);
    this.bulkCreateDataTableRowsCallable =
        callableFactory.createUnaryCallable(
            bulkCreateDataTableRowsTransportSettings,
            settings.bulkCreateDataTableRowsSettings(),
            clientContext);
    this.bulkGetDataTableRowsCallable =
        callableFactory.createUnaryCallable(
            bulkGetDataTableRowsTransportSettings,
            settings.bulkGetDataTableRowsSettings(),
            clientContext);
    this.bulkReplaceDataTableRowsCallable =
        callableFactory.createUnaryCallable(
            bulkReplaceDataTableRowsTransportSettings,
            settings.bulkReplaceDataTableRowsSettings(),
            clientContext);
    this.bulkUpdateDataTableRowsCallable =
        callableFactory.createUnaryCallable(
            bulkUpdateDataTableRowsTransportSettings,
            settings.bulkUpdateDataTableRowsSettings(),
            clientContext);
    this.getDataTableOperationErrorsCallable =
        callableFactory.createUnaryCallable(
            getDataTableOperationErrorsTransportSettings,
            settings.getDataTableOperationErrorsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateDataTableRequest, DataTable> createDataTableCallable() {
    return createDataTableCallable;
  }

  @Override
  public UnaryCallable<ListDataTablesRequest, ListDataTablesResponse> listDataTablesCallable() {
    return listDataTablesCallable;
  }

  @Override
  public UnaryCallable<ListDataTablesRequest, ListDataTablesPagedResponse>
      listDataTablesPagedCallable() {
    return listDataTablesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataTableRequest, DataTable> getDataTableCallable() {
    return getDataTableCallable;
  }

  @Override
  public UnaryCallable<UpdateDataTableRequest, DataTable> updateDataTableCallable() {
    return updateDataTableCallable;
  }

  @Override
  public UnaryCallable<DeleteDataTableRequest, Empty> deleteDataTableCallable() {
    return deleteDataTableCallable;
  }

  @Override
  public UnaryCallable<CreateDataTableRowRequest, DataTableRow> createDataTableRowCallable() {
    return createDataTableRowCallable;
  }

  @Override
  public UnaryCallable<UpdateDataTableRowRequest, DataTableRow> updateDataTableRowCallable() {
    return updateDataTableRowCallable;
  }

  @Override
  public UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsResponse>
      listDataTableRowsCallable() {
    return listDataTableRowsCallable;
  }

  @Override
  public UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsPagedResponse>
      listDataTableRowsPagedCallable() {
    return listDataTableRowsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataTableRowRequest, DataTableRow> getDataTableRowCallable() {
    return getDataTableRowCallable;
  }

  @Override
  public UnaryCallable<DeleteDataTableRowRequest, Empty> deleteDataTableRowCallable() {
    return deleteDataTableRowCallable;
  }

  @Override
  public UnaryCallable<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
      bulkCreateDataTableRowsCallable() {
    return bulkCreateDataTableRowsCallable;
  }

  @Override
  public UnaryCallable<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
      bulkGetDataTableRowsCallable() {
    return bulkGetDataTableRowsCallable;
  }

  @Override
  public UnaryCallable<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
      bulkReplaceDataTableRowsCallable() {
    return bulkReplaceDataTableRowsCallable;
  }

  @Override
  public UnaryCallable<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
      bulkUpdateDataTableRowsCallable() {
    return bulkUpdateDataTableRowsCallable;
  }

  @Override
  public UnaryCallable<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
      getDataTableOperationErrorsCallable() {
    return getDataTableOperationErrorsCallable;
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
