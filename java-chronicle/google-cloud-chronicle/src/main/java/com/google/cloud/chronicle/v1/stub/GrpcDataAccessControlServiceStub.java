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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessLabelsPagedResponse;
import static com.google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessScopesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.CreateDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.CreateDataAccessScopeRequest;
import com.google.cloud.chronicle.v1.DataAccessLabel;
import com.google.cloud.chronicle.v1.DataAccessScope;
import com.google.cloud.chronicle.v1.DeleteDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.DeleteDataAccessScopeRequest;
import com.google.cloud.chronicle.v1.GetDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.GetDataAccessScopeRequest;
import com.google.cloud.chronicle.v1.ListDataAccessLabelsRequest;
import com.google.cloud.chronicle.v1.ListDataAccessLabelsResponse;
import com.google.cloud.chronicle.v1.ListDataAccessScopesRequest;
import com.google.cloud.chronicle.v1.ListDataAccessScopesResponse;
import com.google.cloud.chronicle.v1.UpdateDataAccessLabelRequest;
import com.google.cloud.chronicle.v1.UpdateDataAccessScopeRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataAccessControlService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataAccessControlServiceStub extends DataAccessControlServiceStub {
  private static final MethodDescriptor<CreateDataAccessLabelRequest, DataAccessLabel>
      createDataAccessLabelMethodDescriptor =
          MethodDescriptor.<CreateDataAccessLabelRequest, DataAccessLabel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/CreateDataAccessLabel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataAccessLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataAccessLabel.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDataAccessLabelRequest, DataAccessLabel>
      getDataAccessLabelMethodDescriptor =
          MethodDescriptor.<GetDataAccessLabelRequest, DataAccessLabel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/GetDataAccessLabel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataAccessLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataAccessLabel.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>
      listDataAccessLabelsMethodDescriptor =
          MethodDescriptor.<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/ListDataAccessLabels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataAccessLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataAccessLabelsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDataAccessLabelRequest, DataAccessLabel>
      updateDataAccessLabelMethodDescriptor =
          MethodDescriptor.<UpdateDataAccessLabelRequest, DataAccessLabel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/UpdateDataAccessLabel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataAccessLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataAccessLabel.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDataAccessLabelRequest, Empty>
      deleteDataAccessLabelMethodDescriptor =
          MethodDescriptor.<DeleteDataAccessLabelRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/DeleteDataAccessLabel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataAccessLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateDataAccessScopeRequest, DataAccessScope>
      createDataAccessScopeMethodDescriptor =
          MethodDescriptor.<CreateDataAccessScopeRequest, DataAccessScope>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/CreateDataAccessScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataAccessScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataAccessScope.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDataAccessScopeRequest, DataAccessScope>
      getDataAccessScopeMethodDescriptor =
          MethodDescriptor.<GetDataAccessScopeRequest, DataAccessScope>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/GetDataAccessScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataAccessScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataAccessScope.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDataAccessScopesRequest, ListDataAccessScopesResponse>
      listDataAccessScopesMethodDescriptor =
          MethodDescriptor.<ListDataAccessScopesRequest, ListDataAccessScopesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/ListDataAccessScopes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataAccessScopesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataAccessScopesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDataAccessScopeRequest, DataAccessScope>
      updateDataAccessScopeMethodDescriptor =
          MethodDescriptor.<UpdateDataAccessScopeRequest, DataAccessScope>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/UpdateDataAccessScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataAccessScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataAccessScope.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDataAccessScopeRequest, Empty>
      deleteDataAccessScopeMethodDescriptor =
          MethodDescriptor.<DeleteDataAccessScopeRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DataAccessControlService/DeleteDataAccessScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataAccessScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateDataAccessLabelRequest, DataAccessLabel>
      createDataAccessLabelCallable;
  private final UnaryCallable<GetDataAccessLabelRequest, DataAccessLabel>
      getDataAccessLabelCallable;
  private final UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>
      listDataAccessLabelsCallable;
  private final UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsPagedResponse>
      listDataAccessLabelsPagedCallable;
  private final UnaryCallable<UpdateDataAccessLabelRequest, DataAccessLabel>
      updateDataAccessLabelCallable;
  private final UnaryCallable<DeleteDataAccessLabelRequest, Empty> deleteDataAccessLabelCallable;
  private final UnaryCallable<CreateDataAccessScopeRequest, DataAccessScope>
      createDataAccessScopeCallable;
  private final UnaryCallable<GetDataAccessScopeRequest, DataAccessScope>
      getDataAccessScopeCallable;
  private final UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesResponse>
      listDataAccessScopesCallable;
  private final UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesPagedResponse>
      listDataAccessScopesPagedCallable;
  private final UnaryCallable<UpdateDataAccessScopeRequest, DataAccessScope>
      updateDataAccessScopeCallable;
  private final UnaryCallable<DeleteDataAccessScopeRequest, Empty> deleteDataAccessScopeCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataAccessControlServiceStub create(
      DataAccessControlServiceStubSettings settings) throws IOException {
    return new GrpcDataAccessControlServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataAccessControlServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataAccessControlServiceStub(
        DataAccessControlServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataAccessControlServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataAccessControlServiceStub(
        DataAccessControlServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataAccessControlServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataAccessControlServiceStub(
      DataAccessControlServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDataAccessControlServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataAccessControlServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataAccessControlServiceStub(
      DataAccessControlServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDataAccessLabelRequest, DataAccessLabel>
        createDataAccessLabelTransportSettings =
            GrpcCallSettings.<CreateDataAccessLabelRequest, DataAccessLabel>newBuilder()
                .setMethodDescriptor(createDataAccessLabelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataAccessLabelRequest, DataAccessLabel>
        getDataAccessLabelTransportSettings =
            GrpcCallSettings.<GetDataAccessLabelRequest, DataAccessLabel>newBuilder()
                .setMethodDescriptor(getDataAccessLabelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>
        listDataAccessLabelsTransportSettings =
            GrpcCallSettings.<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>newBuilder()
                .setMethodDescriptor(listDataAccessLabelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateDataAccessLabelRequest, DataAccessLabel>
        updateDataAccessLabelTransportSettings =
            GrpcCallSettings.<UpdateDataAccessLabelRequest, DataAccessLabel>newBuilder()
                .setMethodDescriptor(updateDataAccessLabelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_access_label.name",
                          String.valueOf(request.getDataAccessLabel().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteDataAccessLabelRequest, Empty> deleteDataAccessLabelTransportSettings =
        GrpcCallSettings.<DeleteDataAccessLabelRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataAccessLabelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDataAccessScopeRequest, DataAccessScope>
        createDataAccessScopeTransportSettings =
            GrpcCallSettings.<CreateDataAccessScopeRequest, DataAccessScope>newBuilder()
                .setMethodDescriptor(createDataAccessScopeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataAccessScopeRequest, DataAccessScope>
        getDataAccessScopeTransportSettings =
            GrpcCallSettings.<GetDataAccessScopeRequest, DataAccessScope>newBuilder()
                .setMethodDescriptor(getDataAccessScopeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDataAccessScopesRequest, ListDataAccessScopesResponse>
        listDataAccessScopesTransportSettings =
            GrpcCallSettings.<ListDataAccessScopesRequest, ListDataAccessScopesResponse>newBuilder()
                .setMethodDescriptor(listDataAccessScopesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateDataAccessScopeRequest, DataAccessScope>
        updateDataAccessScopeTransportSettings =
            GrpcCallSettings.<UpdateDataAccessScopeRequest, DataAccessScope>newBuilder()
                .setMethodDescriptor(updateDataAccessScopeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_access_scope.name",
                          String.valueOf(request.getDataAccessScope().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteDataAccessScopeRequest, Empty> deleteDataAccessScopeTransportSettings =
        GrpcCallSettings.<DeleteDataAccessScopeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataAccessScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createDataAccessLabelCallable =
        callableFactory.createUnaryCallable(
            createDataAccessLabelTransportSettings,
            settings.createDataAccessLabelSettings(),
            clientContext);
    this.getDataAccessLabelCallable =
        callableFactory.createUnaryCallable(
            getDataAccessLabelTransportSettings,
            settings.getDataAccessLabelSettings(),
            clientContext);
    this.listDataAccessLabelsCallable =
        callableFactory.createUnaryCallable(
            listDataAccessLabelsTransportSettings,
            settings.listDataAccessLabelsSettings(),
            clientContext);
    this.listDataAccessLabelsPagedCallable =
        callableFactory.createPagedCallable(
            listDataAccessLabelsTransportSettings,
            settings.listDataAccessLabelsSettings(),
            clientContext);
    this.updateDataAccessLabelCallable =
        callableFactory.createUnaryCallable(
            updateDataAccessLabelTransportSettings,
            settings.updateDataAccessLabelSettings(),
            clientContext);
    this.deleteDataAccessLabelCallable =
        callableFactory.createUnaryCallable(
            deleteDataAccessLabelTransportSettings,
            settings.deleteDataAccessLabelSettings(),
            clientContext);
    this.createDataAccessScopeCallable =
        callableFactory.createUnaryCallable(
            createDataAccessScopeTransportSettings,
            settings.createDataAccessScopeSettings(),
            clientContext);
    this.getDataAccessScopeCallable =
        callableFactory.createUnaryCallable(
            getDataAccessScopeTransportSettings,
            settings.getDataAccessScopeSettings(),
            clientContext);
    this.listDataAccessScopesCallable =
        callableFactory.createUnaryCallable(
            listDataAccessScopesTransportSettings,
            settings.listDataAccessScopesSettings(),
            clientContext);
    this.listDataAccessScopesPagedCallable =
        callableFactory.createPagedCallable(
            listDataAccessScopesTransportSettings,
            settings.listDataAccessScopesSettings(),
            clientContext);
    this.updateDataAccessScopeCallable =
        callableFactory.createUnaryCallable(
            updateDataAccessScopeTransportSettings,
            settings.updateDataAccessScopeSettings(),
            clientContext);
    this.deleteDataAccessScopeCallable =
        callableFactory.createUnaryCallable(
            deleteDataAccessScopeTransportSettings,
            settings.deleteDataAccessScopeSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateDataAccessLabelRequest, DataAccessLabel>
      createDataAccessLabelCallable() {
    return createDataAccessLabelCallable;
  }

  @Override
  public UnaryCallable<GetDataAccessLabelRequest, DataAccessLabel> getDataAccessLabelCallable() {
    return getDataAccessLabelCallable;
  }

  @Override
  public UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>
      listDataAccessLabelsCallable() {
    return listDataAccessLabelsCallable;
  }

  @Override
  public UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsPagedResponse>
      listDataAccessLabelsPagedCallable() {
    return listDataAccessLabelsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateDataAccessLabelRequest, DataAccessLabel>
      updateDataAccessLabelCallable() {
    return updateDataAccessLabelCallable;
  }

  @Override
  public UnaryCallable<DeleteDataAccessLabelRequest, Empty> deleteDataAccessLabelCallable() {
    return deleteDataAccessLabelCallable;
  }

  @Override
  public UnaryCallable<CreateDataAccessScopeRequest, DataAccessScope>
      createDataAccessScopeCallable() {
    return createDataAccessScopeCallable;
  }

  @Override
  public UnaryCallable<GetDataAccessScopeRequest, DataAccessScope> getDataAccessScopeCallable() {
    return getDataAccessScopeCallable;
  }

  @Override
  public UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesResponse>
      listDataAccessScopesCallable() {
    return listDataAccessScopesCallable;
  }

  @Override
  public UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesPagedResponse>
      listDataAccessScopesPagedCallable() {
    return listDataAccessScopesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateDataAccessScopeRequest, DataAccessScope>
      updateDataAccessScopeCallable() {
    return updateDataAccessScopeCallable;
  }

  @Override
  public UnaryCallable<DeleteDataAccessScopeRequest, Empty> deleteDataAccessScopeCallable() {
    return deleteDataAccessScopeCallable;
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
