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

package com.google.cloud.geminidataanalytics.v1beta.stub;

import static com.google.cloud.geminidataanalytics.v1beta.DataA2AServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.geminidataanalytics.v1beta.AgentCard;
import com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest;
import com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest;
import com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse;
import com.google.cloud.geminidataanalytics.v1beta.StreamResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the DataA2AService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonDataA2AServiceStub extends DataA2AServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SendMessageRequest, SendMessageResponse>
      sendMessageMethodDescriptor =
          ApiMethodDescriptor.<SendMessageRequest, SendMessageResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataA2AService/SendMessage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SendMessageRequest>newBuilder()
                      .setPath(
                          "/v1beta/a2a/{tenant=projects/*/locations/*/agents/*}/v1/message:send",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SendMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "tenant", request.getTenant());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/a2a/{tenant=projects/*/locations/*/dataAgents/*}/v1/message:send")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SendMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearTenant().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SendMessageResponse>newBuilder()
                      .setDefaultInstance(SendMessageResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SendMessageRequest, StreamResponse>
      sendStreamingMessageMethodDescriptor =
          ApiMethodDescriptor.<SendMessageRequest, StreamResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataA2AService/SendStreamingMessage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SendMessageRequest>newBuilder()
                      .setPath(
                          "/v1beta/a2a/{tenant=projects/*/locations/*/agents/*}/v1/message:stream",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SendMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "tenant", request.getTenant());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/a2a/{tenant=projects/*/locations/*/dataAgents/*}/v1/message:stream")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SendMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearTenant().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StreamResponse>newBuilder()
                      .setDefaultInstance(StreamResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAgentCardRequest, AgentCard>
      getAgentCardMethodDescriptor =
          ApiMethodDescriptor.<GetAgentCardRequest, AgentCard>newBuilder()
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataA2AService/GetAgentCard")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAgentCardRequest>newBuilder()
                      .setPath(
                          "/v1beta/a2a/{tenant=projects/*/locations/*/agents/*}/v1/card",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAgentCardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "tenant", request.getTenant());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/a2a/{tenant=projects/*/locations/*/dataAgents/*}/v1/card")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAgentCardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AgentCard>newBuilder()
                      .setDefaultInstance(AgentCard.getDefaultInstance())
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

  private final UnaryCallable<SendMessageRequest, SendMessageResponse> sendMessageCallable;
  private final ServerStreamingCallable<SendMessageRequest, StreamResponse>
      sendStreamingMessageCallable;
  private final UnaryCallable<GetAgentCardRequest, AgentCard> getAgentCardCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataA2AServiceStub create(DataA2AServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDataA2AServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataA2AServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataA2AServiceStub(
        DataA2AServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataA2AServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataA2AServiceStub(
        DataA2AServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataA2AServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataA2AServiceStub(
      DataA2AServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataA2AServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataA2AServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataA2AServiceStub(
      DataA2AServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SendMessageRequest, SendMessageResponse> sendMessageTransportSettings =
        HttpJsonCallSettings.<SendMessageRequest, SendMessageResponse>newBuilder()
            .setMethodDescriptor(sendMessageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tenant", String.valueOf(request.getTenant()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SendMessageRequest, StreamResponse> sendStreamingMessageTransportSettings =
        HttpJsonCallSettings.<SendMessageRequest, StreamResponse>newBuilder()
            .setMethodDescriptor(sendStreamingMessageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tenant", String.valueOf(request.getTenant()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAgentCardRequest, AgentCard> getAgentCardTransportSettings =
        HttpJsonCallSettings.<GetAgentCardRequest, AgentCard>newBuilder()
            .setMethodDescriptor(getAgentCardMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tenant", String.valueOf(request.getTenant()));
                  return builder.build();
                })
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

    this.sendMessageCallable =
        callableFactory.createUnaryCallable(
            sendMessageTransportSettings, settings.sendMessageSettings(), clientContext);
    this.sendStreamingMessageCallable =
        callableFactory.createServerStreamingCallable(
            sendStreamingMessageTransportSettings,
            settings.sendStreamingMessageSettings(),
            clientContext);
    this.getAgentCardCallable =
        callableFactory.createUnaryCallable(
            getAgentCardTransportSettings, settings.getAgentCardSettings(), clientContext);
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
    methodDescriptors.add(sendMessageMethodDescriptor);
    methodDescriptors.add(sendStreamingMessageMethodDescriptor);
    methodDescriptors.add(getAgentCardMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SendMessageRequest, SendMessageResponse> sendMessageCallable() {
    return sendMessageCallable;
  }

  @Override
  public ServerStreamingCallable<SendMessageRequest, StreamResponse>
      sendStreamingMessageCallable() {
    return sendStreamingMessageCallable;
  }

  @Override
  public UnaryCallable<GetAgentCardRequest, AgentCard> getAgentCardCallable() {
    return getAgentCardCallable;
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
