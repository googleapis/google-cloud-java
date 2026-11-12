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

import static com.google.cloud.chronicle.v1.SearchServiceClient.ListSearchedResultsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.ListSearchedResultsRequest;
import com.google.cloud.chronicle.v1.ListSearchedResultsResponse;
import com.google.cloud.chronicle.v1.SearchOperationMetadata;
import com.google.cloud.chronicle.v1.SearchRequest;
import com.google.cloud.chronicle.v1.SearchSession;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcSearchServiceStub extends SearchServiceStub {
  private static final MethodDescriptor<SearchRequest, Operation> searchMethodDescriptor =
      MethodDescriptor.<SearchRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.SearchService/Search")
          .setRequestMarshaller(ProtoUtils.marshaller(SearchRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListSearchedResultsRequest, ListSearchedResultsResponse>
      listSearchedResultsMethodDescriptor =
          MethodDescriptor.<ListSearchedResultsRequest, ListSearchedResultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.SearchService/ListSearchedResults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSearchedResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSearchedResultsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<SearchRequest, Operation> searchCallable;
  private final OperationCallable<SearchRequest, SearchSession, SearchOperationMetadata>
      searchOperationCallable;
  private final UnaryCallable<ListSearchedResultsRequest, ListSearchedResultsResponse>
      listSearchedResultsCallable;
  private final UnaryCallable<ListSearchedResultsRequest, ListSearchedResultsPagedResponse>
      listSearchedResultsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSearchServiceStub create(SearchServiceStubSettings settings)
      throws IOException {
    return new GrpcSearchServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSearchServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcSearchServiceStub(SearchServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSearchServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSearchServiceStub(
        SearchServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSearchServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSearchServiceStub(SearchServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSearchServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSearchServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSearchServiceStub(
      SearchServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SearchRequest, Operation> searchTransportSettings =
        GrpcCallSettings.<SearchRequest, Operation>newBuilder()
            .setMethodDescriptor(searchMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<ListSearchedResultsRequest, ListSearchedResultsResponse>
        listSearchedResultsTransportSettings =
            GrpcCallSettings.<ListSearchedResultsRequest, ListSearchedResultsResponse>newBuilder()
                .setMethodDescriptor(listSearchedResultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.searchCallable =
        callableFactory.createUnaryCallable(
            searchTransportSettings, settings.searchSettings(), clientContext);
    this.searchOperationCallable =
        callableFactory.createOperationCallable(
            searchTransportSettings,
            settings.searchOperationSettings(),
            clientContext,
            operationsStub);
    this.listSearchedResultsCallable =
        callableFactory.createUnaryCallable(
            listSearchedResultsTransportSettings,
            settings.listSearchedResultsSettings(),
            clientContext);
    this.listSearchedResultsPagedCallable =
        callableFactory.createPagedCallable(
            listSearchedResultsTransportSettings,
            settings.listSearchedResultsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SearchRequest, Operation> searchCallable() {
    return searchCallable;
  }

  @Override
  public OperationCallable<SearchRequest, SearchSession, SearchOperationMetadata>
      searchOperationCallable() {
    return searchOperationCallable;
  }

  @Override
  public UnaryCallable<ListSearchedResultsRequest, ListSearchedResultsResponse>
      listSearchedResultsCallable() {
    return listSearchedResultsCallable;
  }

  @Override
  public UnaryCallable<ListSearchedResultsRequest, ListSearchedResultsPagedResponse>
      listSearchedResultsPagedCallable() {
    return listSearchedResultsPagedCallable;
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
