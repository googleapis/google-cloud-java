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

package com.google.cloud.bigquery.biglake.v1.stub;

import static com.google.cloud.bigquery.biglake.v1.MetastoreServiceClient.ListCatalogsPagedResponse;
import static com.google.cloud.bigquery.biglake.v1.MetastoreServiceClient.ListDatabasesPagedResponse;
import static com.google.cloud.bigquery.biglake.v1.MetastoreServiceClient.ListTablesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.biglake.v1.Catalog;
import com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest;
import com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.CreateTableRequest;
import com.google.cloud.bigquery.biglake.v1.Database;
import com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest;
import com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.DeleteTableRequest;
import com.google.cloud.bigquery.biglake.v1.GetCatalogRequest;
import com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.GetTableRequest;
import com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest;
import com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse;
import com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest;
import com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse;
import com.google.cloud.bigquery.biglake.v1.ListTablesRequest;
import com.google.cloud.bigquery.biglake.v1.ListTablesResponse;
import com.google.cloud.bigquery.biglake.v1.RenameTableRequest;
import com.google.cloud.bigquery.biglake.v1.Table;
import com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.UpdateTableRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MetastoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcMetastoreServiceStub extends MetastoreServiceStub {
  private static final MethodDescriptor<CreateCatalogRequest, Catalog>
      createCatalogMethodDescriptor =
          MethodDescriptor.<CreateCatalogRequest, Catalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/CreateCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Catalog.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCatalogRequest, Catalog>
      deleteCatalogMethodDescriptor =
          MethodDescriptor.<DeleteCatalogRequest, Catalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/DeleteCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Catalog.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCatalogRequest, Catalog> getCatalogMethodDescriptor =
      MethodDescriptor.<GetCatalogRequest, Catalog>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/GetCatalog")
          .setRequestMarshaller(ProtoUtils.marshaller(GetCatalogRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Catalog.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListCatalogsRequest, ListCatalogsResponse>
      listCatalogsMethodDescriptor =
          MethodDescriptor.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/ListCatalogs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListCatalogsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCatalogsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDatabaseRequest, Database>
      createDatabaseMethodDescriptor =
          MethodDescriptor.<CreateDatabaseRequest, Database>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/CreateDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Database.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDatabaseRequest, Database>
      deleteDatabaseMethodDescriptor =
          MethodDescriptor.<DeleteDatabaseRequest, Database>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/DeleteDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Database.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDatabaseRequest, Database>
      updateDatabaseMethodDescriptor =
          MethodDescriptor.<UpdateDatabaseRequest, Database>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/UpdateDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Database.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDatabaseRequest, Database> getDatabaseMethodDescriptor =
      MethodDescriptor.<GetDatabaseRequest, Database>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/GetDatabase")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatabaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Database.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListDatabasesRequest, ListDatabasesResponse>
      listDatabasesMethodDescriptor =
          MethodDescriptor.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/ListDatabases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatabasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatabasesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTableRequest, Table> createTableMethodDescriptor =
      MethodDescriptor.<CreateTableRequest, Table>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/CreateTable")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTableRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Table.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteTableRequest, Table> deleteTableMethodDescriptor =
      MethodDescriptor.<DeleteTableRequest, Table>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/DeleteTable")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTableRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Table.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateTableRequest, Table> updateTableMethodDescriptor =
      MethodDescriptor.<UpdateTableRequest, Table>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/UpdateTable")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateTableRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Table.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<RenameTableRequest, Table> renameTableMethodDescriptor =
      MethodDescriptor.<RenameTableRequest, Table>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/RenameTable")
          .setRequestMarshaller(ProtoUtils.marshaller(RenameTableRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Table.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetTableRequest, Table> getTableMethodDescriptor =
      MethodDescriptor.<GetTableRequest, Table>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/GetTable")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTableRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Table.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTablesRequest, ListTablesResponse>
      listTablesMethodDescriptor =
          MethodDescriptor.<ListTablesRequest, ListTablesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.biglake.v1.MetastoreService/ListTables")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTablesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTablesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateCatalogRequest, Catalog> createCatalogCallable;
  private final UnaryCallable<DeleteCatalogRequest, Catalog> deleteCatalogCallable;
  private final UnaryCallable<GetCatalogRequest, Catalog> getCatalogCallable;
  private final UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable;
  private final UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse>
      listCatalogsPagedCallable;
  private final UnaryCallable<CreateDatabaseRequest, Database> createDatabaseCallable;
  private final UnaryCallable<DeleteDatabaseRequest, Database> deleteDatabaseCallable;
  private final UnaryCallable<UpdateDatabaseRequest, Database> updateDatabaseCallable;
  private final UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable;
  private final UnaryCallable<CreateTableRequest, Table> createTableCallable;
  private final UnaryCallable<DeleteTableRequest, Table> deleteTableCallable;
  private final UnaryCallable<UpdateTableRequest, Table> updateTableCallable;
  private final UnaryCallable<RenameTableRequest, Table> renameTableCallable;
  private final UnaryCallable<GetTableRequest, Table> getTableCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMetastoreServiceStub create(MetastoreServiceStubSettings settings)
      throws IOException {
    return new GrpcMetastoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMetastoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMetastoreServiceStub(
        MetastoreServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMetastoreServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMetastoreServiceStub(
        MetastoreServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMetastoreServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetastoreServiceStub(
      MetastoreServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcMetastoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMetastoreServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetastoreServiceStub(
      MetastoreServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateCatalogRequest, Catalog> createCatalogTransportSettings =
        GrpcCallSettings.<CreateCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(createCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteCatalogRequest, Catalog> deleteCatalogTransportSettings =
        GrpcCallSettings.<DeleteCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(deleteCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetCatalogRequest, Catalog> getCatalogTransportSettings =
        GrpcCallSettings.<GetCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(getCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCatalogsRequest, ListCatalogsResponse> listCatalogsTransportSettings =
        GrpcCallSettings.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
            .setMethodDescriptor(listCatalogsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDatabaseRequest, Database> createDatabaseTransportSettings =
        GrpcCallSettings.<CreateDatabaseRequest, Database>newBuilder()
            .setMethodDescriptor(createDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDatabaseRequest, Database> deleteDatabaseTransportSettings =
        GrpcCallSettings.<DeleteDatabaseRequest, Database>newBuilder()
            .setMethodDescriptor(deleteDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDatabaseRequest, Database> updateDatabaseTransportSettings =
        GrpcCallSettings.<UpdateDatabaseRequest, Database>newBuilder()
            .setMethodDescriptor(updateDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database.name", String.valueOf(request.getDatabase().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDatabaseRequest, Database> getDatabaseTransportSettings =
        GrpcCallSettings.<GetDatabaseRequest, Database>newBuilder()
            .setMethodDescriptor(getDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDatabasesRequest, ListDatabasesResponse> listDatabasesTransportSettings =
        GrpcCallSettings.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
            .setMethodDescriptor(listDatabasesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateTableRequest, Table> createTableTransportSettings =
        GrpcCallSettings.<CreateTableRequest, Table>newBuilder()
            .setMethodDescriptor(createTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTableRequest, Table> deleteTableTransportSettings =
        GrpcCallSettings.<DeleteTableRequest, Table>newBuilder()
            .setMethodDescriptor(deleteTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTableRequest, Table> updateTableTransportSettings =
        GrpcCallSettings.<UpdateTableRequest, Table>newBuilder()
            .setMethodDescriptor(updateTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("table.name", String.valueOf(request.getTable().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RenameTableRequest, Table> renameTableTransportSettings =
        GrpcCallSettings.<RenameTableRequest, Table>newBuilder()
            .setMethodDescriptor(renameTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
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
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.createCatalogCallable =
        callableFactory.createUnaryCallable(
            createCatalogTransportSettings, settings.createCatalogSettings(), clientContext);
    this.deleteCatalogCallable =
        callableFactory.createUnaryCallable(
            deleteCatalogTransportSettings, settings.deleteCatalogSettings(), clientContext);
    this.getCatalogCallable =
        callableFactory.createUnaryCallable(
            getCatalogTransportSettings, settings.getCatalogSettings(), clientContext);
    this.listCatalogsCallable =
        callableFactory.createUnaryCallable(
            listCatalogsTransportSettings, settings.listCatalogsSettings(), clientContext);
    this.listCatalogsPagedCallable =
        callableFactory.createPagedCallable(
            listCatalogsTransportSettings, settings.listCatalogsSettings(), clientContext);
    this.createDatabaseCallable =
        callableFactory.createUnaryCallable(
            createDatabaseTransportSettings, settings.createDatabaseSettings(), clientContext);
    this.deleteDatabaseCallable =
        callableFactory.createUnaryCallable(
            deleteDatabaseTransportSettings, settings.deleteDatabaseSettings(), clientContext);
    this.updateDatabaseCallable =
        callableFactory.createUnaryCallable(
            updateDatabaseTransportSettings, settings.updateDatabaseSettings(), clientContext);
    this.getDatabaseCallable =
        callableFactory.createUnaryCallable(
            getDatabaseTransportSettings, settings.getDatabaseSettings(), clientContext);
    this.listDatabasesCallable =
        callableFactory.createUnaryCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.listDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.createTableCallable =
        callableFactory.createUnaryCallable(
            createTableTransportSettings, settings.createTableSettings(), clientContext);
    this.deleteTableCallable =
        callableFactory.createUnaryCallable(
            deleteTableTransportSettings, settings.deleteTableSettings(), clientContext);
    this.updateTableCallable =
        callableFactory.createUnaryCallable(
            updateTableTransportSettings, settings.updateTableSettings(), clientContext);
    this.renameTableCallable =
        callableFactory.createUnaryCallable(
            renameTableTransportSettings, settings.renameTableSettings(), clientContext);
    this.getTableCallable =
        callableFactory.createUnaryCallable(
            getTableTransportSettings, settings.getTableSettings(), clientContext);
    this.listTablesCallable =
        callableFactory.createUnaryCallable(
            listTablesTransportSettings, settings.listTablesSettings(), clientContext);
    this.listTablesPagedCallable =
        callableFactory.createPagedCallable(
            listTablesTransportSettings, settings.listTablesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateCatalogRequest, Catalog> createCatalogCallable() {
    return createCatalogCallable;
  }

  @Override
  public UnaryCallable<DeleteCatalogRequest, Catalog> deleteCatalogCallable() {
    return deleteCatalogCallable;
  }

  @Override
  public UnaryCallable<GetCatalogRequest, Catalog> getCatalogCallable() {
    return getCatalogCallable;
  }

  @Override
  public UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable() {
    return listCatalogsCallable;
  }

  @Override
  public UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse> listCatalogsPagedCallable() {
    return listCatalogsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDatabaseRequest, Database> createDatabaseCallable() {
    return createDatabaseCallable;
  }

  @Override
  public UnaryCallable<DeleteDatabaseRequest, Database> deleteDatabaseCallable() {
    return deleteDatabaseCallable;
  }

  @Override
  public UnaryCallable<UpdateDatabaseRequest, Database> updateDatabaseCallable() {
    return updateDatabaseCallable;
  }

  @Override
  public UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    return getDatabaseCallable;
  }

  @Override
  public UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    return listDatabasesCallable;
  }

  @Override
  public UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable() {
    return listDatabasesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTableRequest, Table> createTableCallable() {
    return createTableCallable;
  }

  @Override
  public UnaryCallable<DeleteTableRequest, Table> deleteTableCallable() {
    return deleteTableCallable;
  }

  @Override
  public UnaryCallable<UpdateTableRequest, Table> updateTableCallable() {
    return updateTableCallable;
  }

  @Override
  public UnaryCallable<RenameTableRequest, Table> renameTableCallable() {
    return renameTableCallable;
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
