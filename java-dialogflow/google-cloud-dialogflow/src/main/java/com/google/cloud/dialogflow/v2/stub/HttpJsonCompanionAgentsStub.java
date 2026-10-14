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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.CompanionAgentsClient.ListCompanionAgentsPagedResponse;
import static com.google.cloud.dialogflow.v2.CompanionAgentsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2.CompanionAgent;
import com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest;
import com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest;
import com.google.cloud.dialogflow.v2.GetCompanionAgentRequest;
import com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest;
import com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse;
import com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest;
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
 * REST stub implementation for the CompanionAgents service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonCompanionAgentsStub extends CompanionAgentsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateCompanionAgentRequest, CompanionAgent>
      createCompanionAgentMethodDescriptor =
          ApiMethodDescriptor.<CreateCompanionAgentRequest, CompanionAgent>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.CompanionAgents/CreateCompanionAgent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCompanionAgentRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/companionAgents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCompanionAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCompanionAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "companionAgentId", request.getCompanionAgentId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("companionAgent", request.getCompanionAgent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompanionAgent>newBuilder()
                      .setDefaultInstance(CompanionAgent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCompanionAgentRequest, CompanionAgent>
      getCompanionAgentMethodDescriptor =
          ApiMethodDescriptor.<GetCompanionAgentRequest, CompanionAgent>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.CompanionAgents/GetCompanionAgent")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCompanionAgentRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/companionAgents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCompanionAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCompanionAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompanionAgent>newBuilder()
                      .setDefaultInstance(CompanionAgent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCompanionAgentRequest, CompanionAgent>
      updateCompanionAgentMethodDescriptor =
          ApiMethodDescriptor.<UpdateCompanionAgentRequest, CompanionAgent>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.CompanionAgents/UpdateCompanionAgent")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCompanionAgentRequest>newBuilder()
                      .setPath(
                          "/v2/{companionAgent.name=projects/*/locations/*/companionAgents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCompanionAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "companionAgent.name",
                                request.getCompanionAgent().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCompanionAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("companionAgent", request.getCompanionAgent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompanionAgent>newBuilder()
                      .setDefaultInstance(CompanionAgent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCompanionAgentRequest, Empty>
      deleteCompanionAgentMethodDescriptor =
          ApiMethodDescriptor.<DeleteCompanionAgentRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.CompanionAgents/DeleteCompanionAgent")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCompanionAgentRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/companionAgents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCompanionAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCompanionAgentRequest> serializer =
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

  private static final ApiMethodDescriptor<ListCompanionAgentsRequest, ListCompanionAgentsResponse>
      listCompanionAgentsMethodDescriptor =
          ApiMethodDescriptor.<ListCompanionAgentsRequest, ListCompanionAgentsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.CompanionAgents/ListCompanionAgents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCompanionAgentsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/companionAgents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCompanionAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCompanionAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCompanionAgentsResponse>newBuilder()
                      .setDefaultInstance(ListCompanionAgentsResponse.getDefaultInstance())
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
                          "/v2/{name=projects/*}/locations",
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
                          "/v2/{name=projects/*/locations/*}",
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

  private final UnaryCallable<CreateCompanionAgentRequest, CompanionAgent>
      createCompanionAgentCallable;
  private final UnaryCallable<GetCompanionAgentRequest, CompanionAgent> getCompanionAgentCallable;
  private final UnaryCallable<UpdateCompanionAgentRequest, CompanionAgent>
      updateCompanionAgentCallable;
  private final UnaryCallable<DeleteCompanionAgentRequest, Empty> deleteCompanionAgentCallable;
  private final UnaryCallable<ListCompanionAgentsRequest, ListCompanionAgentsResponse>
      listCompanionAgentsCallable;
  private final UnaryCallable<ListCompanionAgentsRequest, ListCompanionAgentsPagedResponse>
      listCompanionAgentsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCompanionAgentsStub create(CompanionAgentsStubSettings settings)
      throws IOException {
    return new HttpJsonCompanionAgentsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCompanionAgentsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCompanionAgentsStub(
        CompanionAgentsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCompanionAgentsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCompanionAgentsStub(
        CompanionAgentsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCompanionAgentsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCompanionAgentsStub(
      CompanionAgentsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCompanionAgentsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCompanionAgentsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCompanionAgentsStub(
      CompanionAgentsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateCompanionAgentRequest, CompanionAgent>
        createCompanionAgentTransportSettings =
            HttpJsonCallSettings.<CreateCompanionAgentRequest, CompanionAgent>newBuilder()
                .setMethodDescriptor(createCompanionAgentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetCompanionAgentRequest, CompanionAgent>
        getCompanionAgentTransportSettings =
            HttpJsonCallSettings.<GetCompanionAgentRequest, CompanionAgent>newBuilder()
                .setMethodDescriptor(getCompanionAgentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<UpdateCompanionAgentRequest, CompanionAgent>
        updateCompanionAgentTransportSettings =
            HttpJsonCallSettings.<UpdateCompanionAgentRequest, CompanionAgent>newBuilder()
                .setMethodDescriptor(updateCompanionAgentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "companion_agent.name",
                          String.valueOf(request.getCompanionAgent().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteCompanionAgentRequest, Empty> deleteCompanionAgentTransportSettings =
        HttpJsonCallSettings.<DeleteCompanionAgentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCompanionAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListCompanionAgentsRequest, ListCompanionAgentsResponse>
        listCompanionAgentsTransportSettings =
            HttpJsonCallSettings
                .<ListCompanionAgentsRequest, ListCompanionAgentsResponse>newBuilder()
                .setMethodDescriptor(listCompanionAgentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
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

    this.createCompanionAgentCallable =
        callableFactory.createUnaryCallable(
            createCompanionAgentTransportSettings,
            settings.createCompanionAgentSettings(),
            clientContext);
    this.getCompanionAgentCallable =
        callableFactory.createUnaryCallable(
            getCompanionAgentTransportSettings,
            settings.getCompanionAgentSettings(),
            clientContext);
    this.updateCompanionAgentCallable =
        callableFactory.createUnaryCallable(
            updateCompanionAgentTransportSettings,
            settings.updateCompanionAgentSettings(),
            clientContext);
    this.deleteCompanionAgentCallable =
        callableFactory.createUnaryCallable(
            deleteCompanionAgentTransportSettings,
            settings.deleteCompanionAgentSettings(),
            clientContext);
    this.listCompanionAgentsCallable =
        callableFactory.createUnaryCallable(
            listCompanionAgentsTransportSettings,
            settings.listCompanionAgentsSettings(),
            clientContext);
    this.listCompanionAgentsPagedCallable =
        callableFactory.createPagedCallable(
            listCompanionAgentsTransportSettings,
            settings.listCompanionAgentsSettings(),
            clientContext);
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
    methodDescriptors.add(createCompanionAgentMethodDescriptor);
    methodDescriptors.add(getCompanionAgentMethodDescriptor);
    methodDescriptors.add(updateCompanionAgentMethodDescriptor);
    methodDescriptors.add(deleteCompanionAgentMethodDescriptor);
    methodDescriptors.add(listCompanionAgentsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateCompanionAgentRequest, CompanionAgent> createCompanionAgentCallable() {
    return createCompanionAgentCallable;
  }

  @Override
  public UnaryCallable<GetCompanionAgentRequest, CompanionAgent> getCompanionAgentCallable() {
    return getCompanionAgentCallable;
  }

  @Override
  public UnaryCallable<UpdateCompanionAgentRequest, CompanionAgent> updateCompanionAgentCallable() {
    return updateCompanionAgentCallable;
  }

  @Override
  public UnaryCallable<DeleteCompanionAgentRequest, Empty> deleteCompanionAgentCallable() {
    return deleteCompanionAgentCallable;
  }

  @Override
  public UnaryCallable<ListCompanionAgentsRequest, ListCompanionAgentsResponse>
      listCompanionAgentsCallable() {
    return listCompanionAgentsCallable;
  }

  @Override
  public UnaryCallable<ListCompanionAgentsRequest, ListCompanionAgentsPagedResponse>
      listCompanionAgentsPagedCallable() {
    return listCompanionAgentsPagedCallable;
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
