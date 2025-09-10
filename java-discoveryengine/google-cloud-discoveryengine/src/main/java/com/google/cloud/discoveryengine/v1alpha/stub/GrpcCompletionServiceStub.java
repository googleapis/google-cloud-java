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

package com.google.cloud.discoveryengine.v1alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CompleteQueryRequest;
import com.google.cloud.discoveryengine.v1alpha.CompleteQueryResponse;
import com.google.cloud.discoveryengine.v1alpha.ImportCompletionSuggestionsMetadata;
import com.google.cloud.discoveryengine.v1alpha.ImportCompletionSuggestionsRequest;
import com.google.cloud.discoveryengine.v1alpha.ImportCompletionSuggestionsResponse;
import com.google.cloud.discoveryengine.v1alpha.ImportSuggestionDenyListEntriesMetadata;
import com.google.cloud.discoveryengine.v1alpha.ImportSuggestionDenyListEntriesRequest;
import com.google.cloud.discoveryengine.v1alpha.ImportSuggestionDenyListEntriesResponse;
import com.google.cloud.discoveryengine.v1alpha.PurgeCompletionSuggestionsMetadata;
import com.google.cloud.discoveryengine.v1alpha.PurgeCompletionSuggestionsRequest;
import com.google.cloud.discoveryengine.v1alpha.PurgeCompletionSuggestionsResponse;
import com.google.cloud.discoveryengine.v1alpha.PurgeSuggestionDenyListEntriesMetadata;
import com.google.cloud.discoveryengine.v1alpha.PurgeSuggestionDenyListEntriesRequest;
import com.google.cloud.discoveryengine.v1alpha.PurgeSuggestionDenyListEntriesResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CompletionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcCompletionServiceStub extends CompletionServiceStub {
  private static final MethodDescriptor<CompleteQueryRequest, CompleteQueryResponse>
      completeQueryMethodDescriptor =
          MethodDescriptor.<CompleteQueryRequest, CompleteQueryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.CompletionService/CompleteQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CompleteQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CompleteQueryResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportSuggestionDenyListEntriesRequest, Operation>
      importSuggestionDenyListEntriesMethodDescriptor =
          MethodDescriptor.<ImportSuggestionDenyListEntriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.CompletionService/ImportSuggestionDenyListEntries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ImportSuggestionDenyListEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PurgeSuggestionDenyListEntriesRequest, Operation>
      purgeSuggestionDenyListEntriesMethodDescriptor =
          MethodDescriptor.<PurgeSuggestionDenyListEntriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.CompletionService/PurgeSuggestionDenyListEntries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PurgeSuggestionDenyListEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportCompletionSuggestionsRequest, Operation>
      importCompletionSuggestionsMethodDescriptor =
          MethodDescriptor.<ImportCompletionSuggestionsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.CompletionService/ImportCompletionSuggestions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportCompletionSuggestionsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PurgeCompletionSuggestionsRequest, Operation>
      purgeCompletionSuggestionsMethodDescriptor =
          MethodDescriptor.<PurgeCompletionSuggestionsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.CompletionService/PurgeCompletionSuggestions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PurgeCompletionSuggestionsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CompleteQueryRequest, CompleteQueryResponse> completeQueryCallable;
  private final UnaryCallable<ImportSuggestionDenyListEntriesRequest, Operation>
      importSuggestionDenyListEntriesCallable;
  private final OperationCallable<
          ImportSuggestionDenyListEntriesRequest,
          ImportSuggestionDenyListEntriesResponse,
          ImportSuggestionDenyListEntriesMetadata>
      importSuggestionDenyListEntriesOperationCallable;
  private final UnaryCallable<PurgeSuggestionDenyListEntriesRequest, Operation>
      purgeSuggestionDenyListEntriesCallable;
  private final OperationCallable<
          PurgeSuggestionDenyListEntriesRequest,
          PurgeSuggestionDenyListEntriesResponse,
          PurgeSuggestionDenyListEntriesMetadata>
      purgeSuggestionDenyListEntriesOperationCallable;
  private final UnaryCallable<ImportCompletionSuggestionsRequest, Operation>
      importCompletionSuggestionsCallable;
  private final OperationCallable<
          ImportCompletionSuggestionsRequest,
          ImportCompletionSuggestionsResponse,
          ImportCompletionSuggestionsMetadata>
      importCompletionSuggestionsOperationCallable;
  private final UnaryCallable<PurgeCompletionSuggestionsRequest, Operation>
      purgeCompletionSuggestionsCallable;
  private final OperationCallable<
          PurgeCompletionSuggestionsRequest,
          PurgeCompletionSuggestionsResponse,
          PurgeCompletionSuggestionsMetadata>
      purgeCompletionSuggestionsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCompletionServiceStub create(CompletionServiceStubSettings settings)
      throws IOException {
    return new GrpcCompletionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCompletionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCompletionServiceStub(
        CompletionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCompletionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCompletionServiceStub(
        CompletionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCompletionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCompletionServiceStub(
      CompletionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCompletionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCompletionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCompletionServiceStub(
      CompletionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CompleteQueryRequest, CompleteQueryResponse> completeQueryTransportSettings =
        GrpcCallSettings.<CompleteQueryRequest, CompleteQueryResponse>newBuilder()
            .setMethodDescriptor(completeQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_store", String.valueOf(request.getDataStore()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportSuggestionDenyListEntriesRequest, Operation>
        importSuggestionDenyListEntriesTransportSettings =
            GrpcCallSettings.<ImportSuggestionDenyListEntriesRequest, Operation>newBuilder()
                .setMethodDescriptor(importSuggestionDenyListEntriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<PurgeSuggestionDenyListEntriesRequest, Operation>
        purgeSuggestionDenyListEntriesTransportSettings =
            GrpcCallSettings.<PurgeSuggestionDenyListEntriesRequest, Operation>newBuilder()
                .setMethodDescriptor(purgeSuggestionDenyListEntriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ImportCompletionSuggestionsRequest, Operation>
        importCompletionSuggestionsTransportSettings =
            GrpcCallSettings.<ImportCompletionSuggestionsRequest, Operation>newBuilder()
                .setMethodDescriptor(importCompletionSuggestionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<PurgeCompletionSuggestionsRequest, Operation>
        purgeCompletionSuggestionsTransportSettings =
            GrpcCallSettings.<PurgeCompletionSuggestionsRequest, Operation>newBuilder()
                .setMethodDescriptor(purgeCompletionSuggestionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.completeQueryCallable =
        callableFactory.createUnaryCallable(
            completeQueryTransportSettings, settings.completeQuerySettings(), clientContext);
    this.importSuggestionDenyListEntriesCallable =
        callableFactory.createUnaryCallable(
            importSuggestionDenyListEntriesTransportSettings,
            settings.importSuggestionDenyListEntriesSettings(),
            clientContext);
    this.importSuggestionDenyListEntriesOperationCallable =
        callableFactory.createOperationCallable(
            importSuggestionDenyListEntriesTransportSettings,
            settings.importSuggestionDenyListEntriesOperationSettings(),
            clientContext,
            operationsStub);
    this.purgeSuggestionDenyListEntriesCallable =
        callableFactory.createUnaryCallable(
            purgeSuggestionDenyListEntriesTransportSettings,
            settings.purgeSuggestionDenyListEntriesSettings(),
            clientContext);
    this.purgeSuggestionDenyListEntriesOperationCallable =
        callableFactory.createOperationCallable(
            purgeSuggestionDenyListEntriesTransportSettings,
            settings.purgeSuggestionDenyListEntriesOperationSettings(),
            clientContext,
            operationsStub);
    this.importCompletionSuggestionsCallable =
        callableFactory.createUnaryCallable(
            importCompletionSuggestionsTransportSettings,
            settings.importCompletionSuggestionsSettings(),
            clientContext);
    this.importCompletionSuggestionsOperationCallable =
        callableFactory.createOperationCallable(
            importCompletionSuggestionsTransportSettings,
            settings.importCompletionSuggestionsOperationSettings(),
            clientContext,
            operationsStub);
    this.purgeCompletionSuggestionsCallable =
        callableFactory.createUnaryCallable(
            purgeCompletionSuggestionsTransportSettings,
            settings.purgeCompletionSuggestionsSettings(),
            clientContext);
    this.purgeCompletionSuggestionsOperationCallable =
        callableFactory.createOperationCallable(
            purgeCompletionSuggestionsTransportSettings,
            settings.purgeCompletionSuggestionsOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CompleteQueryRequest, CompleteQueryResponse> completeQueryCallable() {
    return completeQueryCallable;
  }

  @Override
  public UnaryCallable<ImportSuggestionDenyListEntriesRequest, Operation>
      importSuggestionDenyListEntriesCallable() {
    return importSuggestionDenyListEntriesCallable;
  }

  @Override
  public OperationCallable<
          ImportSuggestionDenyListEntriesRequest,
          ImportSuggestionDenyListEntriesResponse,
          ImportSuggestionDenyListEntriesMetadata>
      importSuggestionDenyListEntriesOperationCallable() {
    return importSuggestionDenyListEntriesOperationCallable;
  }

  @Override
  public UnaryCallable<PurgeSuggestionDenyListEntriesRequest, Operation>
      purgeSuggestionDenyListEntriesCallable() {
    return purgeSuggestionDenyListEntriesCallable;
  }

  @Override
  public OperationCallable<
          PurgeSuggestionDenyListEntriesRequest,
          PurgeSuggestionDenyListEntriesResponse,
          PurgeSuggestionDenyListEntriesMetadata>
      purgeSuggestionDenyListEntriesOperationCallable() {
    return purgeSuggestionDenyListEntriesOperationCallable;
  }

  @Override
  public UnaryCallable<ImportCompletionSuggestionsRequest, Operation>
      importCompletionSuggestionsCallable() {
    return importCompletionSuggestionsCallable;
  }

  @Override
  public OperationCallable<
          ImportCompletionSuggestionsRequest,
          ImportCompletionSuggestionsResponse,
          ImportCompletionSuggestionsMetadata>
      importCompletionSuggestionsOperationCallable() {
    return importCompletionSuggestionsOperationCallable;
  }

  @Override
  public UnaryCallable<PurgeCompletionSuggestionsRequest, Operation>
      purgeCompletionSuggestionsCallable() {
    return purgeCompletionSuggestionsCallable;
  }

  @Override
  public OperationCallable<
          PurgeCompletionSuggestionsRequest,
          PurgeCompletionSuggestionsResponse,
          PurgeCompletionSuggestionsMetadata>
      purgeCompletionSuggestionsOperationCallable() {
    return purgeCompletionSuggestionsOperationCallable;
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
