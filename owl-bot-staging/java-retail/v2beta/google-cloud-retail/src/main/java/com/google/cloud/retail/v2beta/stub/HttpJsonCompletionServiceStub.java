/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.retail.v2beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.CompleteQueryRequest;
import com.google.cloud.retail.v2beta.CompleteQueryResponse;
import com.google.cloud.retail.v2beta.ImportCompletionDataRequest;
import com.google.cloud.retail.v2beta.ImportCompletionDataResponse;
import com.google.cloud.retail.v2beta.ImportMetadata;
import com.google.longrunning.Operation;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CompletionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCompletionServiceStub extends CompletionServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ImportMetadata.getDescriptor())
          .add(ImportCompletionDataResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CompleteQueryRequest, CompleteQueryResponse>
      completeQueryMethodDescriptor =
          ApiMethodDescriptor.<CompleteQueryRequest, CompleteQueryResponse>newBuilder()
              .setFullMethodName("google.cloud.retail.v2beta.CompletionService/CompleteQuery")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CompleteQueryRequest>newBuilder()
                      .setPath(
                          "/v2beta/{catalog=projects/*/locations/*/catalogs/*}:completeQuery",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "catalog", request.getCatalog());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "dataset", request.getDataset());
                            serializer.putQueryParam(fields, "deviceType", request.getDeviceType());
                            serializer.putQueryParam(
                                fields, "languageCodes", request.getLanguageCodesList());
                            serializer.putQueryParam(
                                fields, "maxSuggestions", request.getMaxSuggestions());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "visitorId", request.getVisitorId());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompleteQueryResponse>newBuilder()
                      .setDefaultInstance(CompleteQueryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportCompletionDataRequest, Operation>
      importCompletionDataMethodDescriptor =
          ApiMethodDescriptor.<ImportCompletionDataRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2beta.CompletionService/ImportCompletionData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportCompletionDataRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*/catalogs/*}/completionData:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportCompletionDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportCompletionDataRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportCompletionDataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<CompleteQueryRequest, CompleteQueryResponse> completeQueryCallable;
  private final UnaryCallable<ImportCompletionDataRequest, Operation> importCompletionDataCallable;
  private final OperationCallable<
          ImportCompletionDataRequest, ImportCompletionDataResponse, ImportMetadata>
      importCompletionDataOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCompletionServiceStub create(CompletionServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCompletionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCompletionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCompletionServiceStub(
        CompletionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCompletionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCompletionServiceStub(
        CompletionServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCompletionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCompletionServiceStub(
      CompletionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCompletionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCompletionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCompletionServiceStub(
      CompletionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CompleteQueryRequest, CompleteQueryResponse>
        completeQueryTransportSettings =
            HttpJsonCallSettings.<CompleteQueryRequest, CompleteQueryResponse>newBuilder()
                .setMethodDescriptor(completeQueryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ImportCompletionDataRequest, Operation>
        importCompletionDataTransportSettings =
            HttpJsonCallSettings.<ImportCompletionDataRequest, Operation>newBuilder()
                .setMethodDescriptor(importCompletionDataMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.completeQueryCallable =
        callableFactory.createUnaryCallable(
            completeQueryTransportSettings, settings.completeQuerySettings(), clientContext);
    this.importCompletionDataCallable =
        callableFactory.createUnaryCallable(
            importCompletionDataTransportSettings,
            settings.importCompletionDataSettings(),
            clientContext);
    this.importCompletionDataOperationCallable =
        callableFactory.createOperationCallable(
            importCompletionDataTransportSettings,
            settings.importCompletionDataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(completeQueryMethodDescriptor);
    methodDescriptors.add(importCompletionDataMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CompleteQueryRequest, CompleteQueryResponse> completeQueryCallable() {
    return completeQueryCallable;
  }

  @Override
  public UnaryCallable<ImportCompletionDataRequest, Operation> importCompletionDataCallable() {
    return importCompletionDataCallable;
  }

  @Override
  public OperationCallable<
          ImportCompletionDataRequest, ImportCompletionDataResponse, ImportMetadata>
      importCompletionDataOperationCallable() {
    return importCompletionDataOperationCallable;
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
