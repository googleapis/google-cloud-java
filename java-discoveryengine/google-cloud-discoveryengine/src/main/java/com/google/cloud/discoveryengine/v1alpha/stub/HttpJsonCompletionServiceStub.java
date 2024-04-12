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

package com.google.cloud.discoveryengine.v1alpha.stub;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CompleteQueryRequest;
import com.google.cloud.discoveryengine.v1alpha.CompleteQueryResponse;
import com.google.cloud.discoveryengine.v1alpha.ImportSuggestionDenyListEntriesMetadata;
import com.google.cloud.discoveryengine.v1alpha.ImportSuggestionDenyListEntriesRequest;
import com.google.cloud.discoveryengine.v1alpha.ImportSuggestionDenyListEntriesResponse;
import com.google.cloud.discoveryengine.v1alpha.PurgeSuggestionDenyListEntriesMetadata;
import com.google.cloud.discoveryengine.v1alpha.PurgeSuggestionDenyListEntriesRequest;
import com.google.cloud.discoveryengine.v1alpha.PurgeSuggestionDenyListEntriesResponse;
import com.google.common.collect.ImmutableMap;
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
          .add(PurgeSuggestionDenyListEntriesResponse.getDescriptor())
          .add(ImportSuggestionDenyListEntriesResponse.getDescriptor())
          .add(PurgeSuggestionDenyListEntriesMetadata.getDescriptor())
          .add(ImportSuggestionDenyListEntriesMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CompleteQueryRequest, CompleteQueryResponse>
      completeQueryMethodDescriptor =
          ApiMethodDescriptor.<CompleteQueryRequest, CompleteQueryResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.CompletionService/CompleteQuery")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CompleteQueryRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{dataStore=projects/*/locations/*/dataStores/*}:completeQuery",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "dataStore", request.getDataStore());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{dataStore=projects/*/locations/*/collections/*/dataStores/*}:completeQuery")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "includeTailSuggestions",
                                request.getIncludeTailSuggestions());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "queryModel", request.getQueryModel());
                            serializer.putQueryParam(
                                fields, "userPseudoId", request.getUserPseudoId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<ImportSuggestionDenyListEntriesRequest, Operation>
      importSuggestionDenyListEntriesMethodDescriptor =
          ApiMethodDescriptor.<ImportSuggestionDenyListEntriesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.CompletionService/ImportSuggestionDenyListEntries")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportSuggestionDenyListEntriesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*}/suggestionDenyListEntries:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportSuggestionDenyListEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=projects/*/locations/*/dataStores/*}/suggestionDenyListEntries:import")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportSuggestionDenyListEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportSuggestionDenyListEntriesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<PurgeSuggestionDenyListEntriesRequest, Operation>
      purgeSuggestionDenyListEntriesMethodDescriptor =
          ApiMethodDescriptor.<PurgeSuggestionDenyListEntriesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.CompletionService/PurgeSuggestionDenyListEntries")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PurgeSuggestionDenyListEntriesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*}/suggestionDenyListEntries:purge",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PurgeSuggestionDenyListEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=projects/*/locations/*/dataStores/**}/suggestionDenyListEntries:purge")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PurgeSuggestionDenyListEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PurgeSuggestionDenyListEntriesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet(
                            "/v1alpha/{name=projects/*/locations/*/collections/*/dataConnector/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/evaluations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet(
                            "/v1alpha/{name=projects/*/locations/*/collections/*/dataConnector}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<CompleteQueryRequest, CompleteQueryResponse>
        completeQueryTransportSettings =
            HttpJsonCallSettings.<CompleteQueryRequest, CompleteQueryResponse>newBuilder()
                .setMethodDescriptor(completeQueryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("data_store", String.valueOf(request.getDataStore()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ImportSuggestionDenyListEntriesRequest, Operation>
        importSuggestionDenyListEntriesTransportSettings =
            HttpJsonCallSettings.<ImportSuggestionDenyListEntriesRequest, Operation>newBuilder()
                .setMethodDescriptor(importSuggestionDenyListEntriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PurgeSuggestionDenyListEntriesRequest, Operation>
        purgeSuggestionDenyListEntriesTransportSettings =
            HttpJsonCallSettings.<PurgeSuggestionDenyListEntriesRequest, Operation>newBuilder()
                .setMethodDescriptor(purgeSuggestionDenyListEntriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(completeQueryMethodDescriptor);
    methodDescriptors.add(importSuggestionDenyListEntriesMethodDescriptor);
    methodDescriptors.add(purgeSuggestionDenyListEntriesMethodDescriptor);
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
