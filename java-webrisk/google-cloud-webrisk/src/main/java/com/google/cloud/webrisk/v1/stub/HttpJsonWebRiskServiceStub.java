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

package com.google.cloud.webrisk.v1.stub;

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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.protobuf.TypeRegistry;
import com.google.webrisk.v1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1.CreateSubmissionRequest;
import com.google.webrisk.v1.SearchHashesRequest;
import com.google.webrisk.v1.SearchHashesResponse;
import com.google.webrisk.v1.SearchUrisRequest;
import com.google.webrisk.v1.SearchUrisResponse;
import com.google.webrisk.v1.Submission;
import com.google.webrisk.v1.SubmitUriMetadata;
import com.google.webrisk.v1.SubmitUriRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the WebRiskService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonWebRiskServiceStub extends WebRiskServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Submission.getDescriptor())
          .add(SubmitUriMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffMethodDescriptor =
          ApiMethodDescriptor
              .<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>newBuilder()
              .setFullMethodName("google.cloud.webrisk.v1.WebRiskService/ComputeThreatListDiff")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ComputeThreatListDiffRequest>newBuilder()
                      .setPath(
                          "/v1/threatLists:computeDiff",
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
              .setFullMethodName("google.cloud.webrisk.v1.WebRiskService/SearchUris")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchUrisRequest>newBuilder()
                      .setPath(
                          "/v1/uris:search",
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
              .setFullMethodName("google.cloud.webrisk.v1.WebRiskService/SearchHashes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchHashesRequest>newBuilder()
                      .setPath(
                          "/v1/hashes:search",
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

  private static final ApiMethodDescriptor<CreateSubmissionRequest, Submission>
      createSubmissionMethodDescriptor =
          ApiMethodDescriptor.<CreateSubmissionRequest, Submission>newBuilder()
              .setFullMethodName("google.cloud.webrisk.v1.WebRiskService/CreateSubmission")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSubmissionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/submissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSubmissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSubmissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("submission", request.getSubmission(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Submission>newBuilder()
                      .setDefaultInstance(Submission.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SubmitUriRequest, Operation> submitUriMethodDescriptor =
      ApiMethodDescriptor.<SubmitUriRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.webrisk.v1.WebRiskService/SubmitUri")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SubmitUriRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*}/uris:submit",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SubmitUriRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SubmitUriRequest> serializer =
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
              (SubmitUriRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private final UnaryCallable<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffCallable;
  private final UnaryCallable<SearchUrisRequest, SearchUrisResponse> searchUrisCallable;
  private final UnaryCallable<SearchHashesRequest, SearchHashesResponse> searchHashesCallable;
  private final UnaryCallable<CreateSubmissionRequest, Submission> createSubmissionCallable;
  private final UnaryCallable<SubmitUriRequest, Operation> submitUriCallable;
  private final OperationCallable<SubmitUriRequest, Submission, SubmitUriMetadata>
      submitUriOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWebRiskServiceStub create(WebRiskServiceStubSettings settings)
      throws IOException {
    return new HttpJsonWebRiskServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWebRiskServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonWebRiskServiceStub(
        WebRiskServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWebRiskServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWebRiskServiceStub(
        WebRiskServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWebRiskServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWebRiskServiceStub(
      WebRiskServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonWebRiskServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWebRiskServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWebRiskServiceStub(
      WebRiskServiceStubSettings settings,
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
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder().setDelete("/v1/{name=projects/*/operations/*}").build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder().setGet("/v1/{name=projects/*/operations/*}").build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder().setGet("/v1/{name=projects/*}/operations").build())
                .build());

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
    HttpJsonCallSettings<CreateSubmissionRequest, Submission> createSubmissionTransportSettings =
        HttpJsonCallSettings.<CreateSubmissionRequest, Submission>newBuilder()
            .setMethodDescriptor(createSubmissionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SubmitUriRequest, Operation> submitUriTransportSettings =
        HttpJsonCallSettings.<SubmitUriRequest, Operation>newBuilder()
            .setMethodDescriptor(submitUriMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
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
    this.createSubmissionCallable =
        callableFactory.createUnaryCallable(
            createSubmissionTransportSettings, settings.createSubmissionSettings(), clientContext);
    this.submitUriCallable =
        callableFactory.createUnaryCallable(
            submitUriTransportSettings, settings.submitUriSettings(), clientContext);
    this.submitUriOperationCallable =
        callableFactory.createOperationCallable(
            submitUriTransportSettings,
            settings.submitUriOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(computeThreatListDiffMethodDescriptor);
    methodDescriptors.add(searchUrisMethodDescriptor);
    methodDescriptors.add(searchHashesMethodDescriptor);
    methodDescriptors.add(createSubmissionMethodDescriptor);
    methodDescriptors.add(submitUriMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
  public UnaryCallable<CreateSubmissionRequest, Submission> createSubmissionCallable() {
    return createSubmissionCallable;
  }

  @Override
  public UnaryCallable<SubmitUriRequest, Operation> submitUriCallable() {
    return submitUriCallable;
  }

  @Override
  public OperationCallable<SubmitUriRequest, Submission, SubmitUriMetadata>
      submitUriOperationCallable() {
    return submitUriOperationCallable;
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
