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

package com.google.cloud.biglake.hive.v1beta.stub;

import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveCatalogsPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveDatabasesPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveTablesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.HiveCatalog;
import com.google.cloud.biglake.hive.v1beta.HiveDatabase;
import com.google.cloud.biglake.hive.v1beta.HiveTable;
import com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse;
import com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse;
import com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse;
import com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the HiveMetastoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcHiveMetastoreServiceStub extends HiveMetastoreServiceStub {
  private static final MethodDescriptor<CreateHiveCatalogRequest, HiveCatalog>
      createHiveCatalogMethodDescriptor =
          MethodDescriptor.<CreateHiveCatalogRequest, HiveCatalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/CreateHiveCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHiveCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HiveCatalog.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetHiveCatalogRequest, HiveCatalog>
      getHiveCatalogMethodDescriptor =
          MethodDescriptor.<GetHiveCatalogRequest, HiveCatalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/GetHiveCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetHiveCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HiveCatalog.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListHiveCatalogsRequest, ListHiveCatalogsResponse>
      listHiveCatalogsMethodDescriptor =
          MethodDescriptor.<ListHiveCatalogsRequest, ListHiveCatalogsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/ListHiveCatalogs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHiveCatalogsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHiveCatalogsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateHiveCatalogRequest, HiveCatalog>
      updateHiveCatalogMethodDescriptor =
          MethodDescriptor.<UpdateHiveCatalogRequest, HiveCatalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/UpdateHiveCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateHiveCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HiveCatalog.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteHiveCatalogRequest, Empty>
      deleteHiveCatalogMethodDescriptor =
          MethodDescriptor.<DeleteHiveCatalogRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/DeleteHiveCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteHiveCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateHiveDatabaseRequest, HiveDatabase>
      createHiveDatabaseMethodDescriptor =
          MethodDescriptor.<CreateHiveDatabaseRequest, HiveDatabase>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/CreateHiveDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHiveDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HiveDatabase.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetHiveDatabaseRequest, HiveDatabase>
      getHiveDatabaseMethodDescriptor =
          MethodDescriptor.<GetHiveDatabaseRequest, HiveDatabase>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/GetHiveDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetHiveDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HiveDatabase.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListHiveDatabasesRequest, ListHiveDatabasesResponse>
      listHiveDatabasesMethodDescriptor =
          MethodDescriptor.<ListHiveDatabasesRequest, ListHiveDatabasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/ListHiveDatabases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHiveDatabasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHiveDatabasesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateHiveDatabaseRequest, HiveDatabase>
      updateHiveDatabaseMethodDescriptor =
          MethodDescriptor.<UpdateHiveDatabaseRequest, HiveDatabase>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/UpdateHiveDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateHiveDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HiveDatabase.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteHiveDatabaseRequest, Empty>
      deleteHiveDatabaseMethodDescriptor =
          MethodDescriptor.<DeleteHiveDatabaseRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/DeleteHiveDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteHiveDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateHiveTableRequest, HiveTable>
      createHiveTableMethodDescriptor =
          MethodDescriptor.<CreateHiveTableRequest, HiveTable>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/CreateHiveTable")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHiveTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HiveTable.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetHiveTableRequest, HiveTable>
      getHiveTableMethodDescriptor =
          MethodDescriptor.<GetHiveTableRequest, HiveTable>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/GetHiveTable")
              .setRequestMarshaller(ProtoUtils.marshaller(GetHiveTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HiveTable.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListHiveTablesRequest, ListHiveTablesResponse>
      listHiveTablesMethodDescriptor =
          MethodDescriptor.<ListHiveTablesRequest, ListHiveTablesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/ListHiveTables")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHiveTablesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHiveTablesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateHiveTableRequest, HiveTable>
      updateHiveTableMethodDescriptor =
          MethodDescriptor.<UpdateHiveTableRequest, HiveTable>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/UpdateHiveTable")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateHiveTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HiveTable.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteHiveTableRequest, Empty>
      deleteHiveTableMethodDescriptor =
          MethodDescriptor.<DeleteHiveTableRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/DeleteHiveTable")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteHiveTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
      batchCreatePartitionsMethodDescriptor =
          MethodDescriptor.<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/BatchCreatePartitions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreatePartitionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreatePartitionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchDeletePartitionsRequest, Empty>
      batchDeletePartitionsMethodDescriptor =
          MethodDescriptor.<BatchDeletePartitionsRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/BatchDeletePartitions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeletePartitionsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
      batchUpdatePartitionsMethodDescriptor =
          MethodDescriptor.<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/BatchUpdatePartitions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdatePartitionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchUpdatePartitionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsMethodDescriptor =
          MethodDescriptor.<ListPartitionsRequest, ListPartitionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(
                  "google.cloud.biglake.hive.v1beta.HiveMetastoreService/ListPartitions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPartitionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPartitionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateHiveCatalogRequest, HiveCatalog> createHiveCatalogCallable;
  private final UnaryCallable<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogCallable;
  private final UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsResponse>
      listHiveCatalogsCallable;
  private final UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsPagedResponse>
      listHiveCatalogsPagedCallable;
  private final UnaryCallable<UpdateHiveCatalogRequest, HiveCatalog> updateHiveCatalogCallable;
  private final UnaryCallable<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogCallable;
  private final UnaryCallable<CreateHiveDatabaseRequest, HiveDatabase> createHiveDatabaseCallable;
  private final UnaryCallable<GetHiveDatabaseRequest, HiveDatabase> getHiveDatabaseCallable;
  private final UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesResponse>
      listHiveDatabasesCallable;
  private final UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesPagedResponse>
      listHiveDatabasesPagedCallable;
  private final UnaryCallable<UpdateHiveDatabaseRequest, HiveDatabase> updateHiveDatabaseCallable;
  private final UnaryCallable<DeleteHiveDatabaseRequest, Empty> deleteHiveDatabaseCallable;
  private final UnaryCallable<CreateHiveTableRequest, HiveTable> createHiveTableCallable;
  private final UnaryCallable<GetHiveTableRequest, HiveTable> getHiveTableCallable;
  private final UnaryCallable<ListHiveTablesRequest, ListHiveTablesResponse> listHiveTablesCallable;
  private final UnaryCallable<ListHiveTablesRequest, ListHiveTablesPagedResponse>
      listHiveTablesPagedCallable;
  private final UnaryCallable<UpdateHiveTableRequest, HiveTable> updateHiveTableCallable;
  private final UnaryCallable<DeleteHiveTableRequest, Empty> deleteHiveTableCallable;
  private final UnaryCallable<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
      batchCreatePartitionsCallable;
  private final UnaryCallable<BatchDeletePartitionsRequest, Empty> batchDeletePartitionsCallable;
  private final UnaryCallable<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
      batchUpdatePartitionsCallable;
  private final ServerStreamingCallable<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcHiveMetastoreServiceStub create(HiveMetastoreServiceStubSettings settings)
      throws IOException {
    return new GrpcHiveMetastoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcHiveMetastoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcHiveMetastoreServiceStub(
        HiveMetastoreServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcHiveMetastoreServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcHiveMetastoreServiceStub(
        HiveMetastoreServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcHiveMetastoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcHiveMetastoreServiceStub(
      HiveMetastoreServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcHiveMetastoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcHiveMetastoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcHiveMetastoreServiceStub(
      HiveMetastoreServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateHiveCatalogRequest, HiveCatalog> createHiveCatalogTransportSettings =
        GrpcCallSettings.<CreateHiveCatalogRequest, HiveCatalog>newBuilder()
            .setMethodDescriptor(createHiveCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogTransportSettings =
        GrpcCallSettings.<GetHiveCatalogRequest, HiveCatalog>newBuilder()
            .setMethodDescriptor(getHiveCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListHiveCatalogsRequest, ListHiveCatalogsResponse>
        listHiveCatalogsTransportSettings =
            GrpcCallSettings.<ListHiveCatalogsRequest, ListHiveCatalogsResponse>newBuilder()
                .setMethodDescriptor(listHiveCatalogsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateHiveCatalogRequest, HiveCatalog> updateHiveCatalogTransportSettings =
        GrpcCallSettings.<UpdateHiveCatalogRequest, HiveCatalog>newBuilder()
            .setMethodDescriptor(updateHiveCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "hive_catalog.name", String.valueOf(request.getHiveCatalog().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogTransportSettings =
        GrpcCallSettings.<DeleteHiveCatalogRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteHiveCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateHiveDatabaseRequest, HiveDatabase> createHiveDatabaseTransportSettings =
        GrpcCallSettings.<CreateHiveDatabaseRequest, HiveDatabase>newBuilder()
            .setMethodDescriptor(createHiveDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetHiveDatabaseRequest, HiveDatabase> getHiveDatabaseTransportSettings =
        GrpcCallSettings.<GetHiveDatabaseRequest, HiveDatabase>newBuilder()
            .setMethodDescriptor(getHiveDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListHiveDatabasesRequest, ListHiveDatabasesResponse>
        listHiveDatabasesTransportSettings =
            GrpcCallSettings.<ListHiveDatabasesRequest, ListHiveDatabasesResponse>newBuilder()
                .setMethodDescriptor(listHiveDatabasesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateHiveDatabaseRequest, HiveDatabase> updateHiveDatabaseTransportSettings =
        GrpcCallSettings.<UpdateHiveDatabaseRequest, HiveDatabase>newBuilder()
            .setMethodDescriptor(updateHiveDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "hive_database.name", String.valueOf(request.getHiveDatabase().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteHiveDatabaseRequest, Empty> deleteHiveDatabaseTransportSettings =
        GrpcCallSettings.<DeleteHiveDatabaseRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteHiveDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateHiveTableRequest, HiveTable> createHiveTableTransportSettings =
        GrpcCallSettings.<CreateHiveTableRequest, HiveTable>newBuilder()
            .setMethodDescriptor(createHiveTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetHiveTableRequest, HiveTable> getHiveTableTransportSettings =
        GrpcCallSettings.<GetHiveTableRequest, HiveTable>newBuilder()
            .setMethodDescriptor(getHiveTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListHiveTablesRequest, ListHiveTablesResponse>
        listHiveTablesTransportSettings =
            GrpcCallSettings.<ListHiveTablesRequest, ListHiveTablesResponse>newBuilder()
                .setMethodDescriptor(listHiveTablesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateHiveTableRequest, HiveTable> updateHiveTableTransportSettings =
        GrpcCallSettings.<UpdateHiveTableRequest, HiveTable>newBuilder()
            .setMethodDescriptor(updateHiveTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("hive_table.name", String.valueOf(request.getHiveTable().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteHiveTableRequest, Empty> deleteHiveTableTransportSettings =
        GrpcCallSettings.<DeleteHiveTableRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteHiveTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
        batchCreatePartitionsTransportSettings =
            GrpcCallSettings
                .<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>newBuilder()
                .setMethodDescriptor(batchCreatePartitionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<BatchDeletePartitionsRequest, Empty> batchDeletePartitionsTransportSettings =
        GrpcCallSettings.<BatchDeletePartitionsRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeletePartitionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
        batchUpdatePartitionsTransportSettings =
            GrpcCallSettings
                .<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>newBuilder()
                .setMethodDescriptor(batchUpdatePartitionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ListPartitionsRequest, ListPartitionsResponse>
        listPartitionsTransportSettings =
            GrpcCallSettings.<ListPartitionsRequest, ListPartitionsResponse>newBuilder()
                .setMethodDescriptor(listPartitionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.createHiveCatalogCallable =
        callableFactory.createUnaryCallable(
            createHiveCatalogTransportSettings,
            settings.createHiveCatalogSettings(),
            clientContext);
    this.getHiveCatalogCallable =
        callableFactory.createUnaryCallable(
            getHiveCatalogTransportSettings, settings.getHiveCatalogSettings(), clientContext);
    this.listHiveCatalogsCallable =
        callableFactory.createUnaryCallable(
            listHiveCatalogsTransportSettings, settings.listHiveCatalogsSettings(), clientContext);
    this.listHiveCatalogsPagedCallable =
        callableFactory.createPagedCallable(
            listHiveCatalogsTransportSettings, settings.listHiveCatalogsSettings(), clientContext);
    this.updateHiveCatalogCallable =
        callableFactory.createUnaryCallable(
            updateHiveCatalogTransportSettings,
            settings.updateHiveCatalogSettings(),
            clientContext);
    this.deleteHiveCatalogCallable =
        callableFactory.createUnaryCallable(
            deleteHiveCatalogTransportSettings,
            settings.deleteHiveCatalogSettings(),
            clientContext);
    this.createHiveDatabaseCallable =
        callableFactory.createUnaryCallable(
            createHiveDatabaseTransportSettings,
            settings.createHiveDatabaseSettings(),
            clientContext);
    this.getHiveDatabaseCallable =
        callableFactory.createUnaryCallable(
            getHiveDatabaseTransportSettings, settings.getHiveDatabaseSettings(), clientContext);
    this.listHiveDatabasesCallable =
        callableFactory.createUnaryCallable(
            listHiveDatabasesTransportSettings,
            settings.listHiveDatabasesSettings(),
            clientContext);
    this.listHiveDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listHiveDatabasesTransportSettings,
            settings.listHiveDatabasesSettings(),
            clientContext);
    this.updateHiveDatabaseCallable =
        callableFactory.createUnaryCallable(
            updateHiveDatabaseTransportSettings,
            settings.updateHiveDatabaseSettings(),
            clientContext);
    this.deleteHiveDatabaseCallable =
        callableFactory.createUnaryCallable(
            deleteHiveDatabaseTransportSettings,
            settings.deleteHiveDatabaseSettings(),
            clientContext);
    this.createHiveTableCallable =
        callableFactory.createUnaryCallable(
            createHiveTableTransportSettings, settings.createHiveTableSettings(), clientContext);
    this.getHiveTableCallable =
        callableFactory.createUnaryCallable(
            getHiveTableTransportSettings, settings.getHiveTableSettings(), clientContext);
    this.listHiveTablesCallable =
        callableFactory.createUnaryCallable(
            listHiveTablesTransportSettings, settings.listHiveTablesSettings(), clientContext);
    this.listHiveTablesPagedCallable =
        callableFactory.createPagedCallable(
            listHiveTablesTransportSettings, settings.listHiveTablesSettings(), clientContext);
    this.updateHiveTableCallable =
        callableFactory.createUnaryCallable(
            updateHiveTableTransportSettings, settings.updateHiveTableSettings(), clientContext);
    this.deleteHiveTableCallable =
        callableFactory.createUnaryCallable(
            deleteHiveTableTransportSettings, settings.deleteHiveTableSettings(), clientContext);
    this.batchCreatePartitionsCallable =
        callableFactory.createUnaryCallable(
            batchCreatePartitionsTransportSettings,
            settings.batchCreatePartitionsSettings(),
            clientContext);
    this.batchDeletePartitionsCallable =
        callableFactory.createUnaryCallable(
            batchDeletePartitionsTransportSettings,
            settings.batchDeletePartitionsSettings(),
            clientContext);
    this.batchUpdatePartitionsCallable =
        callableFactory.createUnaryCallable(
            batchUpdatePartitionsTransportSettings,
            settings.batchUpdatePartitionsSettings(),
            clientContext);
    this.listPartitionsCallable =
        callableFactory.createServerStreamingCallable(
            listPartitionsTransportSettings, settings.listPartitionsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateHiveCatalogRequest, HiveCatalog> createHiveCatalogCallable() {
    return createHiveCatalogCallable;
  }

  @Override
  public UnaryCallable<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogCallable() {
    return getHiveCatalogCallable;
  }

  @Override
  public UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsResponse>
      listHiveCatalogsCallable() {
    return listHiveCatalogsCallable;
  }

  @Override
  public UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsPagedResponse>
      listHiveCatalogsPagedCallable() {
    return listHiveCatalogsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateHiveCatalogRequest, HiveCatalog> updateHiveCatalogCallable() {
    return updateHiveCatalogCallable;
  }

  @Override
  public UnaryCallable<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogCallable() {
    return deleteHiveCatalogCallable;
  }

  @Override
  public UnaryCallable<CreateHiveDatabaseRequest, HiveDatabase> createHiveDatabaseCallable() {
    return createHiveDatabaseCallable;
  }

  @Override
  public UnaryCallable<GetHiveDatabaseRequest, HiveDatabase> getHiveDatabaseCallable() {
    return getHiveDatabaseCallable;
  }

  @Override
  public UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesResponse>
      listHiveDatabasesCallable() {
    return listHiveDatabasesCallable;
  }

  @Override
  public UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesPagedResponse>
      listHiveDatabasesPagedCallable() {
    return listHiveDatabasesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateHiveDatabaseRequest, HiveDatabase> updateHiveDatabaseCallable() {
    return updateHiveDatabaseCallable;
  }

  @Override
  public UnaryCallable<DeleteHiveDatabaseRequest, Empty> deleteHiveDatabaseCallable() {
    return deleteHiveDatabaseCallable;
  }

  @Override
  public UnaryCallable<CreateHiveTableRequest, HiveTable> createHiveTableCallable() {
    return createHiveTableCallable;
  }

  @Override
  public UnaryCallable<GetHiveTableRequest, HiveTable> getHiveTableCallable() {
    return getHiveTableCallable;
  }

  @Override
  public UnaryCallable<ListHiveTablesRequest, ListHiveTablesResponse> listHiveTablesCallable() {
    return listHiveTablesCallable;
  }

  @Override
  public UnaryCallable<ListHiveTablesRequest, ListHiveTablesPagedResponse>
      listHiveTablesPagedCallable() {
    return listHiveTablesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateHiveTableRequest, HiveTable> updateHiveTableCallable() {
    return updateHiveTableCallable;
  }

  @Override
  public UnaryCallable<DeleteHiveTableRequest, Empty> deleteHiveTableCallable() {
    return deleteHiveTableCallable;
  }

  @Override
  public UnaryCallable<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
      batchCreatePartitionsCallable() {
    return batchCreatePartitionsCallable;
  }

  @Override
  public UnaryCallable<BatchDeletePartitionsRequest, Empty> batchDeletePartitionsCallable() {
    return batchDeletePartitionsCallable;
  }

  @Override
  public UnaryCallable<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
      batchUpdatePartitionsCallable() {
    return batchUpdatePartitionsCallable;
  }

  @Override
  public ServerStreamingCallable<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsCallable() {
    return listPartitionsCallable;
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
