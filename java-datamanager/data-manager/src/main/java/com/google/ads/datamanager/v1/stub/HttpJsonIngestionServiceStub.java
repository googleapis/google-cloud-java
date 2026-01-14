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

package com.google.ads.datamanager.v1.stub;

import com.google.ads.datamanager.v1.IngestAudienceMembersRequest;
import com.google.ads.datamanager.v1.IngestAudienceMembersResponse;
import com.google.ads.datamanager.v1.IngestEventsRequest;
import com.google.ads.datamanager.v1.IngestEventsResponse;
import com.google.ads.datamanager.v1.RemoveAudienceMembersRequest;
import com.google.ads.datamanager.v1.RemoveAudienceMembersResponse;
import com.google.ads.datamanager.v1.RetrieveRequestStatusRequest;
import com.google.ads.datamanager.v1.RetrieveRequestStatusResponse;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the IngestionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonIngestionServiceStub extends IngestionServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          IngestAudienceMembersRequest, IngestAudienceMembersResponse>
      ingestAudienceMembersMethodDescriptor =
          ApiMethodDescriptor
              .<IngestAudienceMembersRequest, IngestAudienceMembersResponse>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.IngestionService/IngestAudienceMembers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<IngestAudienceMembersRequest>newBuilder()
                      .setPath(
                          "/v1/audienceMembers:ingest",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<IngestAudienceMembersRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<IngestAudienceMembersRequest> serializer =
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
                  ProtoMessageResponseParser.<IngestAudienceMembersResponse>newBuilder()
                      .setDefaultInstance(IngestAudienceMembersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
      removeAudienceMembersMethodDescriptor =
          ApiMethodDescriptor
              .<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.IngestionService/RemoveAudienceMembers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveAudienceMembersRequest>newBuilder()
                      .setPath(
                          "/v1/audienceMembers:remove",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveAudienceMembersRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveAudienceMembersRequest> serializer =
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
                  ProtoMessageResponseParser.<RemoveAudienceMembersResponse>newBuilder()
                      .setDefaultInstance(RemoveAudienceMembersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<IngestEventsRequest, IngestEventsResponse>
      ingestEventsMethodDescriptor =
          ApiMethodDescriptor.<IngestEventsRequest, IngestEventsResponse>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.IngestionService/IngestEvents")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<IngestEventsRequest>newBuilder()
                      .setPath(
                          "/v1/events:ingest",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<IngestEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<IngestEventsRequest> serializer =
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
                  ProtoMessageResponseParser.<IngestEventsResponse>newBuilder()
                      .setDefaultInstance(IngestEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
      retrieveRequestStatusMethodDescriptor =
          ApiMethodDescriptor
              .<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.IngestionService/RetrieveRequestStatus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RetrieveRequestStatusRequest>newBuilder()
                      .setPath(
                          "/v1/requestStatus:retrieve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveRequestStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveRequestStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RetrieveRequestStatusResponse>newBuilder()
                      .setDefaultInstance(RetrieveRequestStatusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<IngestAudienceMembersRequest, IngestAudienceMembersResponse>
      ingestAudienceMembersCallable;
  private final UnaryCallable<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
      removeAudienceMembersCallable;
  private final UnaryCallable<IngestEventsRequest, IngestEventsResponse> ingestEventsCallable;
  private final UnaryCallable<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
      retrieveRequestStatusCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonIngestionServiceStub create(IngestionServiceStubSettings settings)
      throws IOException {
    return new HttpJsonIngestionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonIngestionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonIngestionServiceStub(
        IngestionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonIngestionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonIngestionServiceStub(
        IngestionServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonIngestionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonIngestionServiceStub(
      IngestionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonIngestionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonIngestionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonIngestionServiceStub(
      IngestionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<IngestAudienceMembersRequest, IngestAudienceMembersResponse>
        ingestAudienceMembersTransportSettings =
            HttpJsonCallSettings
                .<IngestAudienceMembersRequest, IngestAudienceMembersResponse>newBuilder()
                .setMethodDescriptor(ingestAudienceMembersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
        removeAudienceMembersTransportSettings =
            HttpJsonCallSettings
                .<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>newBuilder()
                .setMethodDescriptor(removeAudienceMembersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<IngestEventsRequest, IngestEventsResponse> ingestEventsTransportSettings =
        HttpJsonCallSettings.<IngestEventsRequest, IngestEventsResponse>newBuilder()
            .setMethodDescriptor(ingestEventsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
        retrieveRequestStatusTransportSettings =
            HttpJsonCallSettings
                .<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>newBuilder()
                .setMethodDescriptor(retrieveRequestStatusMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.ingestAudienceMembersCallable =
        callableFactory.createUnaryCallable(
            ingestAudienceMembersTransportSettings,
            settings.ingestAudienceMembersSettings(),
            clientContext);
    this.removeAudienceMembersCallable =
        callableFactory.createUnaryCallable(
            removeAudienceMembersTransportSettings,
            settings.removeAudienceMembersSettings(),
            clientContext);
    this.ingestEventsCallable =
        callableFactory.createUnaryCallable(
            ingestEventsTransportSettings, settings.ingestEventsSettings(), clientContext);
    this.retrieveRequestStatusCallable =
        callableFactory.createUnaryCallable(
            retrieveRequestStatusTransportSettings,
            settings.retrieveRequestStatusSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(ingestAudienceMembersMethodDescriptor);
    methodDescriptors.add(removeAudienceMembersMethodDescriptor);
    methodDescriptors.add(ingestEventsMethodDescriptor);
    methodDescriptors.add(retrieveRequestStatusMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<IngestAudienceMembersRequest, IngestAudienceMembersResponse>
      ingestAudienceMembersCallable() {
    return ingestAudienceMembersCallable;
  }

  @Override
  public UnaryCallable<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
      removeAudienceMembersCallable() {
    return removeAudienceMembersCallable;
  }

  @Override
  public UnaryCallable<IngestEventsRequest, IngestEventsResponse> ingestEventsCallable() {
    return ingestEventsCallable;
  }

  @Override
  public UnaryCallable<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
      retrieveRequestStatusCallable() {
    return retrieveRequestStatusCallable;
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
