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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.SampleQueryServiceClient.ListSampleQueriesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest;
import com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest;
import com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesMetadata;
import com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest;
import com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesResponse;
import com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest;
import com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse;
import com.google.cloud.discoveryengine.v1beta.SampleQuery;
import com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest;
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
 * gRPC stub implementation for the SampleQueryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSampleQueryServiceStub extends SampleQueryServiceStub {
  private static final MethodDescriptor<GetSampleQueryRequest, SampleQuery>
      getSampleQueryMethodDescriptor =
          MethodDescriptor.<GetSampleQueryRequest, SampleQuery>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.SampleQueryService/GetSampleQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSampleQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SampleQuery.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSampleQueriesRequest, ListSampleQueriesResponse>
      listSampleQueriesMethodDescriptor =
          MethodDescriptor.<ListSampleQueriesRequest, ListSampleQueriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.SampleQueryService/ListSampleQueries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSampleQueriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSampleQueriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSampleQueryRequest, SampleQuery>
      createSampleQueryMethodDescriptor =
          MethodDescriptor.<CreateSampleQueryRequest, SampleQuery>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.SampleQueryService/CreateSampleQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSampleQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SampleQuery.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSampleQueryRequest, SampleQuery>
      updateSampleQueryMethodDescriptor =
          MethodDescriptor.<UpdateSampleQueryRequest, SampleQuery>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.SampleQueryService/UpdateSampleQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSampleQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SampleQuery.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSampleQueryRequest, Empty>
      deleteSampleQueryMethodDescriptor =
          MethodDescriptor.<DeleteSampleQueryRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.SampleQueryService/DeleteSampleQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSampleQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportSampleQueriesRequest, Operation>
      importSampleQueriesMethodDescriptor =
          MethodDescriptor.<ImportSampleQueriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.SampleQueryService/ImportSampleQueries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportSampleQueriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetSampleQueryRequest, SampleQuery> getSampleQueryCallable;
  private final UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesResponse>
      listSampleQueriesCallable;
  private final UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesPagedResponse>
      listSampleQueriesPagedCallable;
  private final UnaryCallable<CreateSampleQueryRequest, SampleQuery> createSampleQueryCallable;
  private final UnaryCallable<UpdateSampleQueryRequest, SampleQuery> updateSampleQueryCallable;
  private final UnaryCallable<DeleteSampleQueryRequest, Empty> deleteSampleQueryCallable;
  private final UnaryCallable<ImportSampleQueriesRequest, Operation> importSampleQueriesCallable;
  private final OperationCallable<
          ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
      importSampleQueriesOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSampleQueryServiceStub create(SampleQueryServiceStubSettings settings)
      throws IOException {
    return new GrpcSampleQueryServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSampleQueryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSampleQueryServiceStub(
        SampleQueryServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSampleQueryServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSampleQueryServiceStub(
        SampleQueryServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSampleQueryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSampleQueryServiceStub(
      SampleQueryServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSampleQueryServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSampleQueryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSampleQueryServiceStub(
      SampleQueryServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetSampleQueryRequest, SampleQuery> getSampleQueryTransportSettings =
        GrpcCallSettings.<GetSampleQueryRequest, SampleQuery>newBuilder()
            .setMethodDescriptor(getSampleQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSampleQueriesRequest, ListSampleQueriesResponse>
        listSampleQueriesTransportSettings =
            GrpcCallSettings.<ListSampleQueriesRequest, ListSampleQueriesResponse>newBuilder()
                .setMethodDescriptor(listSampleQueriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateSampleQueryRequest, SampleQuery> createSampleQueryTransportSettings =
        GrpcCallSettings.<CreateSampleQueryRequest, SampleQuery>newBuilder()
            .setMethodDescriptor(createSampleQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSampleQueryRequest, SampleQuery> updateSampleQueryTransportSettings =
        GrpcCallSettings.<UpdateSampleQueryRequest, SampleQuery>newBuilder()
            .setMethodDescriptor(updateSampleQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "sample_query.name", String.valueOf(request.getSampleQuery().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSampleQueryRequest, Empty> deleteSampleQueryTransportSettings =
        GrpcCallSettings.<DeleteSampleQueryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSampleQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportSampleQueriesRequest, Operation> importSampleQueriesTransportSettings =
        GrpcCallSettings.<ImportSampleQueriesRequest, Operation>newBuilder()
            .setMethodDescriptor(importSampleQueriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getSampleQueryCallable =
        callableFactory.createUnaryCallable(
            getSampleQueryTransportSettings, settings.getSampleQuerySettings(), clientContext);
    this.listSampleQueriesCallable =
        callableFactory.createUnaryCallable(
            listSampleQueriesTransportSettings,
            settings.listSampleQueriesSettings(),
            clientContext);
    this.listSampleQueriesPagedCallable =
        callableFactory.createPagedCallable(
            listSampleQueriesTransportSettings,
            settings.listSampleQueriesSettings(),
            clientContext);
    this.createSampleQueryCallable =
        callableFactory.createUnaryCallable(
            createSampleQueryTransportSettings,
            settings.createSampleQuerySettings(),
            clientContext);
    this.updateSampleQueryCallable =
        callableFactory.createUnaryCallable(
            updateSampleQueryTransportSettings,
            settings.updateSampleQuerySettings(),
            clientContext);
    this.deleteSampleQueryCallable =
        callableFactory.createUnaryCallable(
            deleteSampleQueryTransportSettings,
            settings.deleteSampleQuerySettings(),
            clientContext);
    this.importSampleQueriesCallable =
        callableFactory.createUnaryCallable(
            importSampleQueriesTransportSettings,
            settings.importSampleQueriesSettings(),
            clientContext);
    this.importSampleQueriesOperationCallable =
        callableFactory.createOperationCallable(
            importSampleQueriesTransportSettings,
            settings.importSampleQueriesOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetSampleQueryRequest, SampleQuery> getSampleQueryCallable() {
    return getSampleQueryCallable;
  }

  @Override
  public UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesResponse>
      listSampleQueriesCallable() {
    return listSampleQueriesCallable;
  }

  @Override
  public UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesPagedResponse>
      listSampleQueriesPagedCallable() {
    return listSampleQueriesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSampleQueryRequest, SampleQuery> createSampleQueryCallable() {
    return createSampleQueryCallable;
  }

  @Override
  public UnaryCallable<UpdateSampleQueryRequest, SampleQuery> updateSampleQueryCallable() {
    return updateSampleQueryCallable;
  }

  @Override
  public UnaryCallable<DeleteSampleQueryRequest, Empty> deleteSampleQueryCallable() {
    return deleteSampleQueryCallable;
  }

  @Override
  public UnaryCallable<ImportSampleQueriesRequest, Operation> importSampleQueriesCallable() {
    return importSampleQueriesCallable;
  }

  @Override
  public OperationCallable<
          ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
      importSampleQueriesOperationCallable() {
    return importSampleQueriesOperationCallable;
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
