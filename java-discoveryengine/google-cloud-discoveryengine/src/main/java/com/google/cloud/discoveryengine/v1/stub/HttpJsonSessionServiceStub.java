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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.SessionServiceClient.ListSessionsPagedResponse;

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
import com.google.cloud.discoveryengine.v1.CreateSessionRequest;
import com.google.cloud.discoveryengine.v1.DeleteSessionRequest;
import com.google.cloud.discoveryengine.v1.GetSessionRequest;
import com.google.cloud.discoveryengine.v1.ListSessionsRequest;
import com.google.cloud.discoveryengine.v1.ListSessionsResponse;
import com.google.cloud.discoveryengine.v1.Session;
import com.google.cloud.discoveryengine.v1.UpdateSessionRequest;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the SessionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonSessionServiceStub extends SessionServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateSessionRequest, Session>
      createSessionMethodDescriptor =
          ApiMethodDescriptor.<CreateSessionRequest, Session>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.SessionService/CreateSession")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSessionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataStores/*}/sessions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/collections/*/dataStores/*}/sessions",
                          "/v1/{parent=projects/*/locations/*/collections/*/engines/*}/sessions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("session", request.getSession(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Session>newBuilder()
                      .setDefaultInstance(Session.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSessionRequest, Empty>
      deleteSessionMethodDescriptor =
          ApiMethodDescriptor.<DeleteSessionRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.SessionService/DeleteSession")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSessionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataStores/*/sessions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/sessions/*}",
                          "/v1/{name=projects/*/locations/*/collections/*/engines/*/sessions/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSessionRequest> serializer =
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

  private static final ApiMethodDescriptor<UpdateSessionRequest, Session>
      updateSessionMethodDescriptor =
          ApiMethodDescriptor.<UpdateSessionRequest, Session>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.SessionService/UpdateSession")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSessionRequest>newBuilder()
                      .setPath(
                          "/v1/{session.name=projects/*/locations/*/dataStores/*/sessions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "session.name", request.getSession().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{session.name=projects/*/locations/*/collections/*/dataStores/*/sessions/*}",
                          "/v1/{session.name=projects/*/locations/*/collections/*/engines/*/sessions/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("session", request.getSession(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Session>newBuilder()
                      .setDefaultInstance(Session.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSessionRequest, Session> getSessionMethodDescriptor =
      ApiMethodDescriptor.<GetSessionRequest, Session>newBuilder()
          .setFullMethodName("google.cloud.discoveryengine.v1.SessionService/GetSession")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSessionRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/dataStores/*/sessions/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSessionRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/sessions/*}",
                      "/v1/{name=projects/*/locations/*/collections/*/engines/*/sessions/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSessionRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(
                            fields, "includeAnswerDetails", request.getIncludeAnswerDetails());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Session>newBuilder()
                  .setDefaultInstance(Session.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListSessionsRequest, ListSessionsResponse>
      listSessionsMethodDescriptor =
          ApiMethodDescriptor.<ListSessionsRequest, ListSessionsResponse>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.SessionService/ListSessions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSessionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataStores/*}/sessions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSessionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/collections/*/dataStores/*}/sessions",
                          "/v1/{parent=projects/*/locations/*/collections/*/engines/*}/sessions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSessionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSessionsResponse>newBuilder()
                      .setDefaultInstance(ListSessionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateSessionRequest, Session> createSessionCallable;
  private final UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable;
  private final UnaryCallable<UpdateSessionRequest, Session> updateSessionCallable;
  private final UnaryCallable<GetSessionRequest, Session> getSessionCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse>
      listSessionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSessionServiceStub create(SessionServiceStubSettings settings)
      throws IOException {
    return new HttpJsonSessionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSessionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSessionServiceStub(
        SessionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSessionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSessionServiceStub(
        SessionServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSessionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSessionServiceStub(
      SessionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSessionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSessionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSessionServiceStub(
      SessionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateSessionRequest, Session> createSessionTransportSettings =
        HttpJsonCallSettings.<CreateSessionRequest, Session>newBuilder()
            .setMethodDescriptor(createSessionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSessionRequest, Empty> deleteSessionTransportSettings =
        HttpJsonCallSettings.<DeleteSessionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSessionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSessionRequest, Session> updateSessionTransportSettings =
        HttpJsonCallSettings.<UpdateSessionRequest, Session>newBuilder()
            .setMethodDescriptor(updateSessionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session.name", String.valueOf(request.getSession().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSessionRequest, Session> getSessionTransportSettings =
        HttpJsonCallSettings.<GetSessionRequest, Session>newBuilder()
            .setMethodDescriptor(getSessionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSessionsRequest, ListSessionsResponse> listSessionsTransportSettings =
        HttpJsonCallSettings.<ListSessionsRequest, ListSessionsResponse>newBuilder()
            .setMethodDescriptor(listSessionsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.createSessionCallable =
        callableFactory.createUnaryCallable(
            createSessionTransportSettings, settings.createSessionSettings(), clientContext);
    this.deleteSessionCallable =
        callableFactory.createUnaryCallable(
            deleteSessionTransportSettings, settings.deleteSessionSettings(), clientContext);
    this.updateSessionCallable =
        callableFactory.createUnaryCallable(
            updateSessionTransportSettings, settings.updateSessionSettings(), clientContext);
    this.getSessionCallable =
        callableFactory.createUnaryCallable(
            getSessionTransportSettings, settings.getSessionSettings(), clientContext);
    this.listSessionsCallable =
        callableFactory.createUnaryCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);
    this.listSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createSessionMethodDescriptor);
    methodDescriptors.add(deleteSessionMethodDescriptor);
    methodDescriptors.add(updateSessionMethodDescriptor);
    methodDescriptors.add(getSessionMethodDescriptor);
    methodDescriptors.add(listSessionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    return createSessionCallable;
  }

  @Override
  public UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable() {
    return deleteSessionCallable;
  }

  @Override
  public UnaryCallable<UpdateSessionRequest, Session> updateSessionCallable() {
    return updateSessionCallable;
  }

  @Override
  public UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    return getSessionCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    return listSessionsCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    return listSessionsPagedCallable;
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
