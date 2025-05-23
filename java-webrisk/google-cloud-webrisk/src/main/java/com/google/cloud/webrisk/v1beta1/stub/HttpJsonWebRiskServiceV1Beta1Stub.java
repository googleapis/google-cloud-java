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

package com.google.cloud.webrisk.v1beta1.stub;

import com.google.api.core.BetaApi;
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
import com.google.protobuf.TypeRegistry;
import com.google.webrisk.v1beta1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1beta1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1beta1.SearchHashesRequest;
import com.google.webrisk.v1beta1.SearchHashesResponse;
import com.google.webrisk.v1beta1.SearchUrisRequest;
import com.google.webrisk.v1beta1.SearchUrisResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the WebRiskServiceV1Beta1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonWebRiskServiceV1Beta1Stub extends WebRiskServiceV1Beta1Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffMethodDescriptor =
          ApiMethodDescriptor
              .<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1/ComputeThreatListDiff")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ComputeThreatListDiffRequest>newBuilder()
                      .setPath(
                          "/v1beta1/threatLists:computeDiff",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeThreatListDiffRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeThreatListDiffRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "constraints", request.getConstraints());
                            serializer.putQueryParam(
                                fields, "threatType", request.getThreatTypeValue());
                            serializer.putQueryParam(
                                fields, "versionToken", request.getVersionToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ComputeThreatListDiffResponse>newBuilder()
                      .setDefaultInstance(ComputeThreatListDiffResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchUrisRequest, SearchUrisResponse>
      searchUrisMethodDescriptor =
          ApiMethodDescriptor.<SearchUrisRequest, SearchUrisResponse>newBuilder()
              .setFullMethodName("google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1/SearchUris")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchUrisRequest>newBuilder()
                      .setPath(
                          "/v1beta1/uris:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchUrisRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchUrisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "threatTypes", request.getThreatTypesList());
                            serializer.putQueryParam(fields, "uri", request.getUri());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchUrisResponse>newBuilder()
                      .setDefaultInstance(SearchUrisResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchHashesRequest, SearchHashesResponse>
      searchHashesMethodDescriptor =
          ApiMethodDescriptor.<SearchHashesRequest, SearchHashesResponse>newBuilder()
              .setFullMethodName("google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1/SearchHashes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchHashesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/hashes:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchHashesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchHashesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "hashPrefix", request.getHashPrefix());
                            serializer.putQueryParam(
                                fields, "threatTypes", request.getThreatTypesList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchHashesResponse>newBuilder()
                      .setDefaultInstance(SearchHashesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffCallable;
  private final UnaryCallable<SearchUrisRequest, SearchUrisResponse> searchUrisCallable;
  private final UnaryCallable<SearchHashesRequest, SearchHashesResponse> searchHashesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWebRiskServiceV1Beta1Stub create(
      WebRiskServiceV1Beta1StubSettings settings) throws IOException {
    return new HttpJsonWebRiskServiceV1Beta1Stub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWebRiskServiceV1Beta1Stub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonWebRiskServiceV1Beta1Stub(
        WebRiskServiceV1Beta1StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWebRiskServiceV1Beta1Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWebRiskServiceV1Beta1Stub(
        WebRiskServiceV1Beta1StubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWebRiskServiceV1Beta1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWebRiskServiceV1Beta1Stub(
      WebRiskServiceV1Beta1StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonWebRiskServiceV1Beta1CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWebRiskServiceV1Beta1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWebRiskServiceV1Beta1Stub(
      WebRiskServiceV1Beta1StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
        computeThreatListDiffTransportSettings =
            HttpJsonCallSettings
                .<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>newBuilder()
                .setMethodDescriptor(computeThreatListDiffMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SearchUrisRequest, SearchUrisResponse> searchUrisTransportSettings =
        HttpJsonCallSettings.<SearchUrisRequest, SearchUrisResponse>newBuilder()
            .setMethodDescriptor(searchUrisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SearchHashesRequest, SearchHashesResponse> searchHashesTransportSettings =
        HttpJsonCallSettings.<SearchHashesRequest, SearchHashesResponse>newBuilder()
            .setMethodDescriptor(searchHashesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.computeThreatListDiffCallable =
        callableFactory.createUnaryCallable(
            computeThreatListDiffTransportSettings,
            settings.computeThreatListDiffSettings(),
            clientContext);
    this.searchUrisCallable =
        callableFactory.createUnaryCallable(
            searchUrisTransportSettings, settings.searchUrisSettings(), clientContext);
    this.searchHashesCallable =
        callableFactory.createUnaryCallable(
            searchHashesTransportSettings, settings.searchHashesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(computeThreatListDiffMethodDescriptor);
    methodDescriptors.add(searchUrisMethodDescriptor);
    methodDescriptors.add(searchHashesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffCallable() {
    return computeThreatListDiffCallable;
  }

  @Override
  public UnaryCallable<SearchUrisRequest, SearchUrisResponse> searchUrisCallable() {
    return searchUrisCallable;
  }

  @Override
  public UnaryCallable<SearchHashesRequest, SearchHashesResponse> searchHashesCallable() {
    return searchHashesCallable;
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
