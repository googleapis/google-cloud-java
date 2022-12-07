/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.ContextsClient.ListContextsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ContextsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.Context;
import com.google.cloud.dialogflow.v2beta1.CreateContextRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteContextRequest;
import com.google.cloud.dialogflow.v2beta1.GetContextRequest;
import com.google.cloud.dialogflow.v2beta1.ListContextsRequest;
import com.google.cloud.dialogflow.v2beta1.ListContextsResponse;
import com.google.cloud.dialogflow.v2beta1.UpdateContextRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Contexts service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonContextsStub extends ContextsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListContextsRequest, ListContextsResponse>
      listContextsMethodDescriptor =
          ApiMethodDescriptor.<ListContextsRequest, ListContextsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Contexts/ListContexts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListContextsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/agent/sessions/*}/contexts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListContextsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/agent/environments/*/users/*/sessions/*}/contexts",
                          "/v2beta1/{parent=projects/*/locations/*/agent/sessions/*}/contexts",
                          "/v2beta1/{parent=projects/*/locations/*/agent/environments/*/users/*/sessions/*}/contexts")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListContextsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListContextsResponse>newBuilder()
                      .setDefaultInstance(ListContextsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetContextRequest, Context> getContextMethodDescriptor =
      ApiMethodDescriptor.<GetContextRequest, Context>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.v2beta1.Contexts/GetContext")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetContextRequest>newBuilder()
                  .setPath(
                      "/v2beta1/{name=projects/*/agent/sessions/*/contexts/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetContextRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v2beta1/{name=projects/*/agent/environments/*/users/*/sessions/*/contexts/*}",
                      "/v2beta1/{name=projects/*/locations/*/agent/sessions/*/contexts/*}",
                      "/v2beta1/{name=projects/*/locations/*/agent/environments/*/users/*/sessions/*/contexts/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetContextRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Context>newBuilder()
                  .setDefaultInstance(Context.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateContextRequest, Context>
      createContextMethodDescriptor =
          ApiMethodDescriptor.<CreateContextRequest, Context>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Contexts/CreateContext")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateContextRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/agent/sessions/*}/contexts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateContextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/agent/environments/*/users/*/sessions/*}/contexts",
                          "/v2beta1/{parent=projects/*/locations/*/agent/sessions/*}/contexts",
                          "/v2beta1/{parent=projects/*/locations/*/agent/environments/*/users/*/sessions/*}/contexts")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateContextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("context", request.getContext(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Context>newBuilder()
                      .setDefaultInstance(Context.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateContextRequest, Context>
      updateContextMethodDescriptor =
          ApiMethodDescriptor.<UpdateContextRequest, Context>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Contexts/UpdateContext")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateContextRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{context.name=projects/*/agent/sessions/*/contexts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateContextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "context.name", request.getContext().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{context.name=projects/*/agent/environments/*/users/*/sessions/*/contexts/*}",
                          "/v2beta1/{context.name=projects/*/locations/*/agent/sessions/*/contexts/*}",
                          "/v2beta1/{context.name=projects/*/locations/*/agent/environments/*/users/*/sessions/*/contexts/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateContextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("context", request.getContext(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Context>newBuilder()
                      .setDefaultInstance(Context.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteContextRequest, Empty>
      deleteContextMethodDescriptor =
          ApiMethodDescriptor.<DeleteContextRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Contexts/DeleteContext")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteContextRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/agent/sessions/*/contexts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteContextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{name=projects/*/agent/environments/*/users/*/sessions/*/contexts/*}",
                          "/v2beta1/{name=projects/*/locations/*/agent/sessions/*/contexts/*}",
                          "/v2beta1/{name=projects/*/locations/*/agent/environments/*/users/*/sessions/*/contexts/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteContextRequest> serializer =
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

  private static final ApiMethodDescriptor<DeleteAllContextsRequest, Empty>
      deleteAllContextsMethodDescriptor =
          ApiMethodDescriptor.<DeleteAllContextsRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Contexts/DeleteAllContexts")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAllContextsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/agent/sessions/*}/contexts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAllContextsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/agent/environments/*/users/*/sessions/*}/contexts",
                          "/v2beta1/{parent=projects/*/locations/*/agent/sessions/*}/contexts",
                          "/v2beta1/{parent=projects/*/locations/*/agent/environments/*/users/*/sessions/*}/contexts")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAllContextsRequest> serializer =
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

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*}/locations",
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
                          "/v2beta1/{name=projects/*/locations/*}",
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

  private final UnaryCallable<ListContextsRequest, ListContextsResponse> listContextsCallable;
  private final UnaryCallable<ListContextsRequest, ListContextsPagedResponse>
      listContextsPagedCallable;
  private final UnaryCallable<GetContextRequest, Context> getContextCallable;
  private final UnaryCallable<CreateContextRequest, Context> createContextCallable;
  private final UnaryCallable<UpdateContextRequest, Context> updateContextCallable;
  private final UnaryCallable<DeleteContextRequest, Empty> deleteContextCallable;
  private final UnaryCallable<DeleteAllContextsRequest, Empty> deleteAllContextsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonContextsStub create(ContextsStubSettings settings)
      throws IOException {
    return new HttpJsonContextsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonContextsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonContextsStub(
        ContextsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonContextsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonContextsStub(
        ContextsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonContextsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonContextsStub(ContextsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonContextsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonContextsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonContextsStub(
      ContextsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListContextsRequest, ListContextsResponse> listContextsTransportSettings =
        HttpJsonCallSettings.<ListContextsRequest, ListContextsResponse>newBuilder()
            .setMethodDescriptor(listContextsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetContextRequest, Context> getContextTransportSettings =
        HttpJsonCallSettings.<GetContextRequest, Context>newBuilder()
            .setMethodDescriptor(getContextMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateContextRequest, Context> createContextTransportSettings =
        HttpJsonCallSettings.<CreateContextRequest, Context>newBuilder()
            .setMethodDescriptor(createContextMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateContextRequest, Context> updateContextTransportSettings =
        HttpJsonCallSettings.<UpdateContextRequest, Context>newBuilder()
            .setMethodDescriptor(updateContextMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteContextRequest, Empty> deleteContextTransportSettings =
        HttpJsonCallSettings.<DeleteContextRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteContextMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteAllContextsRequest, Empty> deleteAllContextsTransportSettings =
        HttpJsonCallSettings.<DeleteAllContextsRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAllContextsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listContextsCallable =
        callableFactory.createUnaryCallable(
            listContextsTransportSettings, settings.listContextsSettings(), clientContext);
    this.listContextsPagedCallable =
        callableFactory.createPagedCallable(
            listContextsTransportSettings, settings.listContextsSettings(), clientContext);
    this.getContextCallable =
        callableFactory.createUnaryCallable(
            getContextTransportSettings, settings.getContextSettings(), clientContext);
    this.createContextCallable =
        callableFactory.createUnaryCallable(
            createContextTransportSettings, settings.createContextSettings(), clientContext);
    this.updateContextCallable =
        callableFactory.createUnaryCallable(
            updateContextTransportSettings, settings.updateContextSettings(), clientContext);
    this.deleteContextCallable =
        callableFactory.createUnaryCallable(
            deleteContextTransportSettings, settings.deleteContextSettings(), clientContext);
    this.deleteAllContextsCallable =
        callableFactory.createUnaryCallable(
            deleteAllContextsTransportSettings,
            settings.deleteAllContextsSettings(),
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
    methodDescriptors.add(listContextsMethodDescriptor);
    methodDescriptors.add(getContextMethodDescriptor);
    methodDescriptors.add(createContextMethodDescriptor);
    methodDescriptors.add(updateContextMethodDescriptor);
    methodDescriptors.add(deleteContextMethodDescriptor);
    methodDescriptors.add(deleteAllContextsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListContextsRequest, ListContextsResponse> listContextsCallable() {
    return listContextsCallable;
  }

  @Override
  public UnaryCallable<ListContextsRequest, ListContextsPagedResponse> listContextsPagedCallable() {
    return listContextsPagedCallable;
  }

  @Override
  public UnaryCallable<GetContextRequest, Context> getContextCallable() {
    return getContextCallable;
  }

  @Override
  public UnaryCallable<CreateContextRequest, Context> createContextCallable() {
    return createContextCallable;
  }

  @Override
  public UnaryCallable<UpdateContextRequest, Context> updateContextCallable() {
    return updateContextCallable;
  }

  @Override
  public UnaryCallable<DeleteContextRequest, Empty> deleteContextCallable() {
    return deleteContextCallable;
  }

  @Override
  public UnaryCallable<DeleteAllContextsRequest, Empty> deleteAllContextsCallable() {
    return deleteAllContextsCallable;
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
