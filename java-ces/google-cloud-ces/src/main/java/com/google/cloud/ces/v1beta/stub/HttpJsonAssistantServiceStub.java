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

package com.google.cloud.ces.v1beta.stub;

import static com.google.cloud.ces.v1beta.AssistantServiceClient.ListAssistantSessionsPagedResponse;
import static com.google.cloud.ces.v1beta.AssistantServiceClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ces.v1beta.AssistantSession;
import com.google.cloud.ces.v1beta.ChatAiAssistantRequest;
import com.google.cloud.ces.v1beta.ChatAiAssistantResponse;
import com.google.cloud.ces.v1beta.CreateAssistantSessionRequest;
import com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest;
import com.google.cloud.ces.v1beta.GetAssistantSessionRequest;
import com.google.cloud.ces.v1beta.ListAssistantSessionsRequest;
import com.google.cloud.ces.v1beta.ListAssistantSessionsResponse;
import com.google.cloud.ces.v1beta.RunAssistantRequest;
import com.google.cloud.ces.v1beta.RunAssistantResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AssistantService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAssistantServiceStub extends AssistantServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ListAssistantSessionsRequest, ListAssistantSessionsResponse>
      listAssistantSessionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAssistantSessionsRequest, ListAssistantSessionsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/ListAssistantSessions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAssistantSessionsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}/assistantSessions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssistantSessionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssistantSessionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAssistantSessionsResponse>newBuilder()
                      .setDefaultInstance(ListAssistantSessionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAssistantSessionRequest, AssistantSession>
      getAssistantSessionMethodDescriptor =
          ApiMethodDescriptor.<GetAssistantSessionRequest, AssistantSession>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/GetAssistantSession")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAssistantSessionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/assistantSessions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAssistantSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAssistantSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AssistantSession>newBuilder()
                      .setDefaultInstance(AssistantSession.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAssistantSessionRequest, AssistantSession>
      createAssistantSessionMethodDescriptor =
          ApiMethodDescriptor.<CreateAssistantSessionRequest, AssistantSession>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/CreateAssistantSession")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAssistantSessionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}/assistantSessions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAssistantSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAssistantSessionRequest> serializer =
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
                  ProtoMessageResponseParser.<AssistantSession>newBuilder()
                      .setDefaultInstance(AssistantSession.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAssistantSessionRequest, Empty>
      deleteAssistantSessionMethodDescriptor =
          ApiMethodDescriptor.<DeleteAssistantSessionRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/DeleteAssistantSession")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAssistantSessionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/assistantSessions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAssistantSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAssistantSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunAssistantRequest, RunAssistantResponse>
      runAssistantMethodDescriptor =
          ApiMethodDescriptor.<RunAssistantRequest, RunAssistantResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/RunAssistant")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunAssistantRequest>newBuilder()
                      .setPath(
                          "/v1beta/{app=projects/*/locations/*/apps/*}:runAssistant",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunAssistantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "app", request.getApp());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunAssistantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearApp().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunAssistantResponse>newBuilder()
                      .setDefaultInstance(RunAssistantResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ChatAiAssistantRequest, ChatAiAssistantResponse>
      chatAiAssistantMethodDescriptor =
          ApiMethodDescriptor.<ChatAiAssistantRequest, ChatAiAssistantResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/ChatAiAssistant")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ChatAiAssistantRequest>newBuilder()
                      .setPath(
                          "/v1beta/{app=projects/*/locations/*/apps/*}:chatAiAssistant",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ChatAiAssistantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "app", request.getApp());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ChatAiAssistantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearApp().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChatAiAssistantResponse>newBuilder()
                      .setDefaultInstance(ChatAiAssistantResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListAssistantSessionsRequest, ListAssistantSessionsResponse>
      listAssistantSessionsCallable;
  private final UnaryCallable<ListAssistantSessionsRequest, ListAssistantSessionsPagedResponse>
      listAssistantSessionsPagedCallable;
  private final UnaryCallable<GetAssistantSessionRequest, AssistantSession>
      getAssistantSessionCallable;
  private final UnaryCallable<CreateAssistantSessionRequest, AssistantSession>
      createAssistantSessionCallable;
  private final UnaryCallable<DeleteAssistantSessionRequest, Empty> deleteAssistantSessionCallable;
  private final UnaryCallable<RunAssistantRequest, RunAssistantResponse> runAssistantCallable;
  private final UnaryCallable<ChatAiAssistantRequest, ChatAiAssistantResponse>
      chatAiAssistantCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAssistantServiceStub create(AssistantServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAssistantServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAssistantServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAssistantServiceStub(
        AssistantServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAssistantServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAssistantServiceStub(
        AssistantServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAssistantServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAssistantServiceStub(
      AssistantServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAssistantServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAssistantServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAssistantServiceStub(
      AssistantServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListAssistantSessionsRequest, ListAssistantSessionsResponse>
        listAssistantSessionsTransportSettings =
            HttpJsonCallSettings
                .<ListAssistantSessionsRequest, ListAssistantSessionsResponse>newBuilder()
                .setMethodDescriptor(listAssistantSessionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetAssistantSessionRequest, AssistantSession>
        getAssistantSessionTransportSettings =
            HttpJsonCallSettings.<GetAssistantSessionRequest, AssistantSession>newBuilder()
                .setMethodDescriptor(getAssistantSessionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<CreateAssistantSessionRequest, AssistantSession>
        createAssistantSessionTransportSettings =
            HttpJsonCallSettings.<CreateAssistantSessionRequest, AssistantSession>newBuilder()
                .setMethodDescriptor(createAssistantSessionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<DeleteAssistantSessionRequest, Empty>
        deleteAssistantSessionTransportSettings =
            HttpJsonCallSettings.<DeleteAssistantSessionRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAssistantSessionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<RunAssistantRequest, RunAssistantResponse> runAssistantTransportSettings =
        HttpJsonCallSettings.<RunAssistantRequest, RunAssistantResponse>newBuilder()
            .setMethodDescriptor(runAssistantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("app", String.valueOf(request.getApp()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getApp())
            .build();
    HttpJsonCallSettings<ChatAiAssistantRequest, ChatAiAssistantResponse>
        chatAiAssistantTransportSettings =
            HttpJsonCallSettings.<ChatAiAssistantRequest, ChatAiAssistantResponse>newBuilder()
                .setMethodDescriptor(chatAiAssistantMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("app", String.valueOf(request.getApp()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getApp())
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listAssistantSessionsCallable =
        callableFactory.createUnaryCallable(
            listAssistantSessionsTransportSettings,
            settings.listAssistantSessionsSettings(),
            clientContext);
    this.listAssistantSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listAssistantSessionsTransportSettings,
            settings.listAssistantSessionsSettings(),
            clientContext);
    this.getAssistantSessionCallable =
        callableFactory.createUnaryCallable(
            getAssistantSessionTransportSettings,
            settings.getAssistantSessionSettings(),
            clientContext);
    this.createAssistantSessionCallable =
        callableFactory.createUnaryCallable(
            createAssistantSessionTransportSettings,
            settings.createAssistantSessionSettings(),
            clientContext);
    this.deleteAssistantSessionCallable =
        callableFactory.createUnaryCallable(
            deleteAssistantSessionTransportSettings,
            settings.deleteAssistantSessionSettings(),
            clientContext);
    this.runAssistantCallable =
        callableFactory.createUnaryCallable(
            runAssistantTransportSettings, settings.runAssistantSettings(), clientContext);
    this.chatAiAssistantCallable =
        callableFactory.createUnaryCallable(
            chatAiAssistantTransportSettings, settings.chatAiAssistantSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listAssistantSessionsMethodDescriptor);
    methodDescriptors.add(getAssistantSessionMethodDescriptor);
    methodDescriptors.add(createAssistantSessionMethodDescriptor);
    methodDescriptors.add(deleteAssistantSessionMethodDescriptor);
    methodDescriptors.add(runAssistantMethodDescriptor);
    methodDescriptors.add(chatAiAssistantMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListAssistantSessionsRequest, ListAssistantSessionsResponse>
      listAssistantSessionsCallable() {
    return listAssistantSessionsCallable;
  }

  @Override
  public UnaryCallable<ListAssistantSessionsRequest, ListAssistantSessionsPagedResponse>
      listAssistantSessionsPagedCallable() {
    return listAssistantSessionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAssistantSessionRequest, AssistantSession> getAssistantSessionCallable() {
    return getAssistantSessionCallable;
  }

  @Override
  public UnaryCallable<CreateAssistantSessionRequest, AssistantSession>
      createAssistantSessionCallable() {
    return createAssistantSessionCallable;
  }

  @Override
  public UnaryCallable<DeleteAssistantSessionRequest, Empty> deleteAssistantSessionCallable() {
    return deleteAssistantSessionCallable;
  }

  @Override
  public UnaryCallable<RunAssistantRequest, RunAssistantResponse> runAssistantCallable() {
    return runAssistantCallable;
  }

  @Override
  public UnaryCallable<ChatAiAssistantRequest, ChatAiAssistantResponse> chatAiAssistantCallable() {
    return chatAiAssistantCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
