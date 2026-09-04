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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.AssistantServiceClient.ListAssistantsPagedResponse;

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
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.Assistant;
import com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.GetAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest;
import com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse;
import com.google.cloud.discoveryengine.v1beta.StreamAssistRequest;
import com.google.cloud.discoveryengine.v1beta.StreamAssistResponse;
import com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest;
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

  private static final ApiMethodDescriptor<StreamAssistRequest, StreamAssistResponse>
      streamAssistMethodDescriptor =
          ApiMethodDescriptor.<StreamAssistRequest, StreamAssistResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/StreamAssist")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StreamAssistRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/collections/*/engines/*/assistants/*}:streamAssist",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StreamAssistRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StreamAssistRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StreamAssistResponse>newBuilder()
                      .setDefaultInstance(StreamAssistResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAssistantRequest, Assistant>
      createAssistantMethodDescriptor =
          ApiMethodDescriptor.<CreateAssistantRequest, Assistant>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/CreateAssistant")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAssistantRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*/engines/*}/assistants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAssistantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAssistantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "assistantId", request.getAssistantId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("assistant", request.getAssistant(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Assistant>newBuilder()
                      .setDefaultInstance(Assistant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAssistantRequest, Empty>
      deleteAssistantMethodDescriptor =
          ApiMethodDescriptor.<DeleteAssistantRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/DeleteAssistant")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAssistantRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/collections/*/engines/*/assistants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAssistantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAssistantRequest> serializer =
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

  private static final ApiMethodDescriptor<UpdateAssistantRequest, Assistant>
      updateAssistantMethodDescriptor =
          ApiMethodDescriptor.<UpdateAssistantRequest, Assistant>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/UpdateAssistant")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAssistantRequest>newBuilder()
                      .setPath(
                          "/v1beta/{assistant.name=projects/*/locations/*/collections/*/engines/*/assistants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAssistantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "assistant.name", request.getAssistant().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAssistantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("assistant", request.getAssistant(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Assistant>newBuilder()
                      .setDefaultInstance(Assistant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAssistantRequest, Assistant>
      getAssistantMethodDescriptor =
          ApiMethodDescriptor.<GetAssistantRequest, Assistant>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/GetAssistant")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAssistantRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/collections/*/engines/*/assistants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAssistantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAssistantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Assistant>newBuilder()
                      .setDefaultInstance(Assistant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAssistantsRequest, ListAssistantsResponse>
      listAssistantsMethodDescriptor =
          ApiMethodDescriptor.<ListAssistantsRequest, ListAssistantsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/ListAssistants")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAssistantsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*/engines/*}/assistants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssistantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssistantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAssistantsResponse>newBuilder()
                      .setDefaultInstance(ListAssistantsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final ServerStreamingCallable<StreamAssistRequest, StreamAssistResponse>
      streamAssistCallable;
  private final UnaryCallable<CreateAssistantRequest, Assistant> createAssistantCallable;
  private final UnaryCallable<DeleteAssistantRequest, Empty> deleteAssistantCallable;
  private final UnaryCallable<UpdateAssistantRequest, Assistant> updateAssistantCallable;
  private final UnaryCallable<GetAssistantRequest, Assistant> getAssistantCallable;
  private final UnaryCallable<ListAssistantsRequest, ListAssistantsResponse> listAssistantsCallable;
  private final UnaryCallable<ListAssistantsRequest, ListAssistantsPagedResponse>
      listAssistantsPagedCallable;

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

    HttpJsonCallSettings<StreamAssistRequest, StreamAssistResponse> streamAssistTransportSettings =
        HttpJsonCallSettings.<StreamAssistRequest, StreamAssistResponse>newBuilder()
            .setMethodDescriptor(streamAssistMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateAssistantRequest, Assistant> createAssistantTransportSettings =
        HttpJsonCallSettings.<CreateAssistantRequest, Assistant>newBuilder()
            .setMethodDescriptor(createAssistantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<DeleteAssistantRequest, Empty> deleteAssistantTransportSettings =
        HttpJsonCallSettings.<DeleteAssistantRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAssistantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UpdateAssistantRequest, Assistant> updateAssistantTransportSettings =
        HttpJsonCallSettings.<UpdateAssistantRequest, Assistant>newBuilder()
            .setMethodDescriptor(updateAssistantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("assistant.name", String.valueOf(request.getAssistant().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAssistantRequest, Assistant> getAssistantTransportSettings =
        HttpJsonCallSettings.<GetAssistantRequest, Assistant>newBuilder()
            .setMethodDescriptor(getAssistantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListAssistantsRequest, ListAssistantsResponse>
        listAssistantsTransportSettings =
            HttpJsonCallSettings.<ListAssistantsRequest, ListAssistantsResponse>newBuilder()
                .setMethodDescriptor(listAssistantsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.streamAssistCallable =
        callableFactory.createServerStreamingCallable(
            streamAssistTransportSettings, settings.streamAssistSettings(), clientContext);
    this.createAssistantCallable =
        callableFactory.createUnaryCallable(
            createAssistantTransportSettings, settings.createAssistantSettings(), clientContext);
    this.deleteAssistantCallable =
        callableFactory.createUnaryCallable(
            deleteAssistantTransportSettings, settings.deleteAssistantSettings(), clientContext);
    this.updateAssistantCallable =
        callableFactory.createUnaryCallable(
            updateAssistantTransportSettings, settings.updateAssistantSettings(), clientContext);
    this.getAssistantCallable =
        callableFactory.createUnaryCallable(
            getAssistantTransportSettings, settings.getAssistantSettings(), clientContext);
    this.listAssistantsCallable =
        callableFactory.createUnaryCallable(
            listAssistantsTransportSettings, settings.listAssistantsSettings(), clientContext);
    this.listAssistantsPagedCallable =
        callableFactory.createPagedCallable(
            listAssistantsTransportSettings, settings.listAssistantsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(streamAssistMethodDescriptor);
    methodDescriptors.add(createAssistantMethodDescriptor);
    methodDescriptors.add(deleteAssistantMethodDescriptor);
    methodDescriptors.add(updateAssistantMethodDescriptor);
    methodDescriptors.add(getAssistantMethodDescriptor);
    methodDescriptors.add(listAssistantsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public ServerStreamingCallable<StreamAssistRequest, StreamAssistResponse> streamAssistCallable() {
    return streamAssistCallable;
  }

  @Override
  public UnaryCallable<CreateAssistantRequest, Assistant> createAssistantCallable() {
    return createAssistantCallable;
  }

  @Override
  public UnaryCallable<DeleteAssistantRequest, Empty> deleteAssistantCallable() {
    return deleteAssistantCallable;
  }

  @Override
  public UnaryCallable<UpdateAssistantRequest, Assistant> updateAssistantCallable() {
    return updateAssistantCallable;
  }

  @Override
  public UnaryCallable<GetAssistantRequest, Assistant> getAssistantCallable() {
    return getAssistantCallable;
  }

  @Override
  public UnaryCallable<ListAssistantsRequest, ListAssistantsResponse> listAssistantsCallable() {
    return listAssistantsCallable;
  }

  @Override
  public UnaryCallable<ListAssistantsRequest, ListAssistantsPagedResponse>
      listAssistantsPagedCallable() {
    return listAssistantsPagedCallable;
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
