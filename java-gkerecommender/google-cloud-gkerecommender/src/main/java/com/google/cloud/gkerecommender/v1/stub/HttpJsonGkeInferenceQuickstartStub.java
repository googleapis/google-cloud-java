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

package com.google.cloud.gkerecommender.v1.stub;

import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServerVersionsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServersPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchProfilesPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest;
import com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse;
import com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest;
import com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse;
import com.google.cloud.gkerecommender.v1.FetchModelServersRequest;
import com.google.cloud.gkerecommender.v1.FetchModelServersResponse;
import com.google.cloud.gkerecommender.v1.FetchModelsRequest;
import com.google.cloud.gkerecommender.v1.FetchModelsResponse;
import com.google.cloud.gkerecommender.v1.FetchProfilesRequest;
import com.google.cloud.gkerecommender.v1.FetchProfilesResponse;
import com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest;
import com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse;
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
 * REST stub implementation for the GkeInferenceQuickstart service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonGkeInferenceQuickstartStub extends GkeInferenceQuickstartStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<FetchModelsRequest, FetchModelsResponse>
      fetchModelsMethodDescriptor =
          ApiMethodDescriptor.<FetchModelsRequest, FetchModelsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/FetchModels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchModelsRequest>newBuilder()
                      .setPath(
                          "/v1/models:fetch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasPageSize()) {
                              serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchModelsResponse>newBuilder()
                      .setDefaultInstance(FetchModelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchModelServersRequest, FetchModelServersResponse>
      fetchModelServersMethodDescriptor =
          ApiMethodDescriptor.<FetchModelServersRequest, FetchModelServersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/FetchModelServers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchModelServersRequest>newBuilder()
                      .setPath(
                          "/v1/modelServers:fetch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchModelServersRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchModelServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "model", request.getModel());
                            if (request.hasPageSize()) {
                              serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchModelServersResponse>newBuilder()
                      .setDefaultInstance(FetchModelServersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>
      fetchModelServerVersionsMethodDescriptor =
          ApiMethodDescriptor
              .<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/FetchModelServerVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchModelServerVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/modelServerVersions:fetch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchModelServerVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchModelServerVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "model", request.getModel());
                            serializer.putQueryParam(
                                fields, "modelServer", request.getModelServer());
                            if (request.hasPageSize()) {
                              serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchModelServerVersionsResponse>newBuilder()
                      .setDefaultInstance(FetchModelServerVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchProfilesRequest, FetchProfilesResponse>
      fetchProfilesMethodDescriptor =
          ApiMethodDescriptor.<FetchProfilesRequest, FetchProfilesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/FetchProfiles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchProfilesRequest>newBuilder()
                      .setPath(
                          "/v1/profiles:fetch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchProfilesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchProfilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchProfilesResponse>newBuilder()
                      .setDefaultInstance(FetchProfilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
      generateOptimizedManifestMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/GenerateOptimizedManifest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateOptimizedManifestRequest>newBuilder()
                      .setPath(
                          "/v1/optimizedManifest:generate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateOptimizedManifestRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateOptimizedManifestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateOptimizedManifestResponse>newBuilder()
                      .setDefaultInstance(GenerateOptimizedManifestResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
      fetchBenchmarkingDataMethodDescriptor =
          ApiMethodDescriptor
              .<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/FetchBenchmarkingData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchBenchmarkingDataRequest>newBuilder()
                      .setPath(
                          "/v1/benchmarkingData:fetch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchBenchmarkingDataRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchBenchmarkingDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchBenchmarkingDataResponse>newBuilder()
                      .setDefaultInstance(FetchBenchmarkingDataResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<FetchModelsRequest, FetchModelsResponse> fetchModelsCallable;
  private final UnaryCallable<FetchModelsRequest, FetchModelsPagedResponse>
      fetchModelsPagedCallable;
  private final UnaryCallable<FetchModelServersRequest, FetchModelServersResponse>
      fetchModelServersCallable;
  private final UnaryCallable<FetchModelServersRequest, FetchModelServersPagedResponse>
      fetchModelServersPagedCallable;
  private final UnaryCallable<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>
      fetchModelServerVersionsCallable;
  private final UnaryCallable<
          FetchModelServerVersionsRequest, FetchModelServerVersionsPagedResponse>
      fetchModelServerVersionsPagedCallable;
  private final UnaryCallable<FetchProfilesRequest, FetchProfilesResponse> fetchProfilesCallable;
  private final UnaryCallable<FetchProfilesRequest, FetchProfilesPagedResponse>
      fetchProfilesPagedCallable;
  private final UnaryCallable<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
      generateOptimizedManifestCallable;
  private final UnaryCallable<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
      fetchBenchmarkingDataCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGkeInferenceQuickstartStub create(
      GkeInferenceQuickstartStubSettings settings) throws IOException {
    return new HttpJsonGkeInferenceQuickstartStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGkeInferenceQuickstartStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGkeInferenceQuickstartStub(
        GkeInferenceQuickstartStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGkeInferenceQuickstartStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGkeInferenceQuickstartStub(
        GkeInferenceQuickstartStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGkeInferenceQuickstartStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGkeInferenceQuickstartStub(
      GkeInferenceQuickstartStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGkeInferenceQuickstartCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGkeInferenceQuickstartStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGkeInferenceQuickstartStub(
      GkeInferenceQuickstartStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<FetchModelsRequest, FetchModelsResponse> fetchModelsTransportSettings =
        HttpJsonCallSettings.<FetchModelsRequest, FetchModelsResponse>newBuilder()
            .setMethodDescriptor(fetchModelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<FetchModelServersRequest, FetchModelServersResponse>
        fetchModelServersTransportSettings =
            HttpJsonCallSettings.<FetchModelServersRequest, FetchModelServersResponse>newBuilder()
                .setMethodDescriptor(fetchModelServersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>
        fetchModelServerVersionsTransportSettings =
            HttpJsonCallSettings
                .<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>newBuilder()
                .setMethodDescriptor(fetchModelServerVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<FetchProfilesRequest, FetchProfilesResponse>
        fetchProfilesTransportSettings =
            HttpJsonCallSettings.<FetchProfilesRequest, FetchProfilesResponse>newBuilder()
                .setMethodDescriptor(fetchProfilesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
        generateOptimizedManifestTransportSettings =
            HttpJsonCallSettings
                .<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>newBuilder()
                .setMethodDescriptor(generateOptimizedManifestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
        fetchBenchmarkingDataTransportSettings =
            HttpJsonCallSettings
                .<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>newBuilder()
                .setMethodDescriptor(fetchBenchmarkingDataMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.fetchModelsCallable =
        callableFactory.createUnaryCallable(
            fetchModelsTransportSettings, settings.fetchModelsSettings(), clientContext);
    this.fetchModelsPagedCallable =
        callableFactory.createPagedCallable(
            fetchModelsTransportSettings, settings.fetchModelsSettings(), clientContext);
    this.fetchModelServersCallable =
        callableFactory.createUnaryCallable(
            fetchModelServersTransportSettings,
            settings.fetchModelServersSettings(),
            clientContext);
    this.fetchModelServersPagedCallable =
        callableFactory.createPagedCallable(
            fetchModelServersTransportSettings,
            settings.fetchModelServersSettings(),
            clientContext);
    this.fetchModelServerVersionsCallable =
        callableFactory.createUnaryCallable(
            fetchModelServerVersionsTransportSettings,
            settings.fetchModelServerVersionsSettings(),
            clientContext);
    this.fetchModelServerVersionsPagedCallable =
        callableFactory.createPagedCallable(
            fetchModelServerVersionsTransportSettings,
            settings.fetchModelServerVersionsSettings(),
            clientContext);
    this.fetchProfilesCallable =
        callableFactory.createUnaryCallable(
            fetchProfilesTransportSettings, settings.fetchProfilesSettings(), clientContext);
    this.fetchProfilesPagedCallable =
        callableFactory.createPagedCallable(
            fetchProfilesTransportSettings, settings.fetchProfilesSettings(), clientContext);
    this.generateOptimizedManifestCallable =
        callableFactory.createUnaryCallable(
            generateOptimizedManifestTransportSettings,
            settings.generateOptimizedManifestSettings(),
            clientContext);
    this.fetchBenchmarkingDataCallable =
        callableFactory.createUnaryCallable(
            fetchBenchmarkingDataTransportSettings,
            settings.fetchBenchmarkingDataSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(fetchModelsMethodDescriptor);
    methodDescriptors.add(fetchModelServersMethodDescriptor);
    methodDescriptors.add(fetchModelServerVersionsMethodDescriptor);
    methodDescriptors.add(fetchProfilesMethodDescriptor);
    methodDescriptors.add(generateOptimizedManifestMethodDescriptor);
    methodDescriptors.add(fetchBenchmarkingDataMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<FetchModelsRequest, FetchModelsResponse> fetchModelsCallable() {
    return fetchModelsCallable;
  }

  @Override
  public UnaryCallable<FetchModelsRequest, FetchModelsPagedResponse> fetchModelsPagedCallable() {
    return fetchModelsPagedCallable;
  }

  @Override
  public UnaryCallable<FetchModelServersRequest, FetchModelServersResponse>
      fetchModelServersCallable() {
    return fetchModelServersCallable;
  }

  @Override
  public UnaryCallable<FetchModelServersRequest, FetchModelServersPagedResponse>
      fetchModelServersPagedCallable() {
    return fetchModelServersPagedCallable;
  }

  @Override
  public UnaryCallable<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>
      fetchModelServerVersionsCallable() {
    return fetchModelServerVersionsCallable;
  }

  @Override
  public UnaryCallable<FetchModelServerVersionsRequest, FetchModelServerVersionsPagedResponse>
      fetchModelServerVersionsPagedCallable() {
    return fetchModelServerVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<FetchProfilesRequest, FetchProfilesResponse> fetchProfilesCallable() {
    return fetchProfilesCallable;
  }

  @Override
  public UnaryCallable<FetchProfilesRequest, FetchProfilesPagedResponse>
      fetchProfilesPagedCallable() {
    return fetchProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
      generateOptimizedManifestCallable() {
    return generateOptimizedManifestCallable;
  }

  @Override
  public UnaryCallable<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
      fetchBenchmarkingDataCallable() {
    return fetchBenchmarkingDataCallable;
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
