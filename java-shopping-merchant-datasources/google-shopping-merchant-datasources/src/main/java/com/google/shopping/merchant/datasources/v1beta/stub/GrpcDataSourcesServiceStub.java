/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.datasources.v1beta.stub;

import static com.google.shopping.merchant.datasources.v1beta.DataSourcesServiceClient.ListDataSourcesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.datasources.v1beta.CreateDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.DataSource;
import com.google.shopping.merchant.datasources.v1beta.DeleteDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.FetchDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.GetDataSourceRequest;
import com.google.shopping.merchant.datasources.v1beta.ListDataSourcesRequest;
import com.google.shopping.merchant.datasources.v1beta.ListDataSourcesResponse;
import com.google.shopping.merchant.datasources.v1beta.UpdateDataSourceRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataSourcesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDataSourcesServiceStub extends DataSourcesServiceStub {
  private static final MethodDescriptor<GetDataSourceRequest, DataSource>
      getDataSourceMethodDescriptor =
          MethodDescriptor.<GetDataSourceRequest, DataSource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/GetDataSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataSource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesMethodDescriptor =
          MethodDescriptor.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/ListDataSources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataSourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDataSourceRequest, DataSource>
      createDataSourceMethodDescriptor =
          MethodDescriptor.<CreateDataSourceRequest, DataSource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/CreateDataSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataSource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataSourceRequest, DataSource>
      updateDataSourceMethodDescriptor =
          MethodDescriptor.<UpdateDataSourceRequest, DataSource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/UpdateDataSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataSource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataSourceRequest, Empty>
      deleteDataSourceMethodDescriptor =
          MethodDescriptor.<DeleteDataSourceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/DeleteDataSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchDataSourceRequest, Empty>
      fetchDataSourceMethodDescriptor =
          MethodDescriptor.<FetchDataSourceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.datasources.v1beta.DataSourcesService/FetchDataSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchDataSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable;
  private final UnaryCallable<CreateDataSourceRequest, DataSource> createDataSourceCallable;
  private final UnaryCallable<UpdateDataSourceRequest, DataSource> updateDataSourceCallable;
  private final UnaryCallable<DeleteDataSourceRequest, Empty> deleteDataSourceCallable;
  private final UnaryCallable<FetchDataSourceRequest, Empty> fetchDataSourceCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataSourcesServiceStub create(DataSourcesServiceStubSettings settings)
      throws IOException {
    return new GrpcDataSourcesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataSourcesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataSourcesServiceStub(
        DataSourcesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataSourcesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataSourcesServiceStub(
        DataSourcesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataSourcesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataSourcesServiceStub(
      DataSourcesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataSourcesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataSourcesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataSourcesServiceStub(
      DataSourcesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetDataSourceRequest, DataSource> getDataSourceTransportSettings =
        GrpcCallSettings.<GetDataSourceRequest, DataSource>newBuilder()
            .setMethodDescriptor(getDataSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDataSourcesRequest, ListDataSourcesResponse>
        listDataSourcesTransportSettings =
            GrpcCallSettings.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
                .setMethodDescriptor(listDataSourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateDataSourceRequest, DataSource> createDataSourceTransportSettings =
        GrpcCallSettings.<CreateDataSourceRequest, DataSource>newBuilder()
            .setMethodDescriptor(createDataSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataSourceRequest, DataSource> updateDataSourceTransportSettings =
        GrpcCallSettings.<UpdateDataSourceRequest, DataSource>newBuilder()
            .setMethodDescriptor(updateDataSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_source.name", String.valueOf(request.getDataSource().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDataSourceRequest, Empty> deleteDataSourceTransportSettings =
        GrpcCallSettings.<DeleteDataSourceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<FetchDataSourceRequest, Empty> fetchDataSourceTransportSettings =
        GrpcCallSettings.<FetchDataSourceRequest, Empty>newBuilder()
            .setMethodDescriptor(fetchDataSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getDataSourceCallable =
        callableFactory.createUnaryCallable(
            getDataSourceTransportSettings, settings.getDataSourceSettings(), clientContext);
    this.listDataSourcesCallable =
        callableFactory.createUnaryCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.listDataSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.createDataSourceCallable =
        callableFactory.createUnaryCallable(
            createDataSourceTransportSettings, settings.createDataSourceSettings(), clientContext);
    this.updateDataSourceCallable =
        callableFactory.createUnaryCallable(
            updateDataSourceTransportSettings, settings.updateDataSourceSettings(), clientContext);
    this.deleteDataSourceCallable =
        callableFactory.createUnaryCallable(
            deleteDataSourceTransportSettings, settings.deleteDataSourceSettings(), clientContext);
    this.fetchDataSourceCallable =
        callableFactory.createUnaryCallable(
            fetchDataSourceTransportSettings, settings.fetchDataSourceSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    return getDataSourceCallable;
  }

  @Override
  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> listDataSourcesCallable() {
    return listDataSourcesCallable;
  }

  @Override
  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    return listDataSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDataSourceRequest, DataSource> createDataSourceCallable() {
    return createDataSourceCallable;
  }

  @Override
  public UnaryCallable<UpdateDataSourceRequest, DataSource> updateDataSourceCallable() {
    return updateDataSourceCallable;
  }

  @Override
  public UnaryCallable<DeleteDataSourceRequest, Empty> deleteDataSourceCallable() {
    return deleteDataSourceCallable;
  }

  @Override
  public UnaryCallable<FetchDataSourceRequest, Empty> fetchDataSourceCallable() {
    return fetchDataSourceCallable;
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
