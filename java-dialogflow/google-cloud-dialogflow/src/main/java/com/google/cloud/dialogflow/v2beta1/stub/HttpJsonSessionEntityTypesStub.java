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

import static com.google.cloud.dialogflow.v2beta1.SessionEntityTypesClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.SessionEntityTypesClient.ListSessionEntityTypesPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest;
import com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest;
import com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest;
import com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse;
import com.google.cloud.dialogflow.v2beta1.SessionEntityType;
import com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest;
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
 * REST stub implementation for the SessionEntityTypes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSessionEntityTypesStub extends SessionEntityTypesStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>
      listSessionEntityTypesMethodDescriptor =
          ApiMethodDescriptor
              .<ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.SessionEntityTypes/ListSessionEntityTypes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSessionEntityTypesRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/agent/sessions/*}/entityTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSessionEntityTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/agent/environments/*/users/*/sessions/*}/entityTypes",
                          "/v2beta1/{parent=projects/*/locations/*/agent/sessions/*}/entityTypes",
                          "/v2beta1/{parent=projects/*/locations/*/agent/environments/*/users/*/sessions/*}/entityTypes")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSessionEntityTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSessionEntityTypesResponse>newBuilder()
                      .setDefaultInstance(ListSessionEntityTypesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSessionEntityTypeRequest, SessionEntityType>
      getSessionEntityTypeMethodDescriptor =
          ApiMethodDescriptor.<GetSessionEntityTypeRequest, SessionEntityType>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.SessionEntityTypes/GetSessionEntityType")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSessionEntityTypeRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/agent/sessions/*/entityTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSessionEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{name=projects/*/agent/environments/*/users/*/sessions/*/entityTypes/*}",
                          "/v2beta1/{name=projects/*/locations/*/agent/sessions/*/entityTypes/*}",
                          "/v2beta1/{name=projects/*/locations/*/agent/environments/*/users/*/sessions/*/entityTypes/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSessionEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SessionEntityType>newBuilder()
                      .setDefaultInstance(SessionEntityType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSessionEntityTypeRequest, SessionEntityType>
      createSessionEntityTypeMethodDescriptor =
          ApiMethodDescriptor.<CreateSessionEntityTypeRequest, SessionEntityType>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.SessionEntityTypes/CreateSessionEntityType")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSessionEntityTypeRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/agent/sessions/*}/entityTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSessionEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/agent/environments/*/users/*/sessions/*}/entityTypes",
                          "/v2beta1/{parent=projects/*/locations/*/agent/sessions/*}/entityTypes",
                          "/v2beta1/{parent=projects/*/locations/*/agent/environments/*/users/*/sessions/*}/entityTypes")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSessionEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "sessionEntityType", request.getSessionEntityType(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SessionEntityType>newBuilder()
                      .setDefaultInstance(SessionEntityType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSessionEntityTypeRequest, SessionEntityType>
      updateSessionEntityTypeMethodDescriptor =
          ApiMethodDescriptor.<UpdateSessionEntityTypeRequest, SessionEntityType>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.SessionEntityTypes/UpdateSessionEntityType")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSessionEntityTypeRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{sessionEntityType.name=projects/*/agent/sessions/*/entityTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSessionEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "sessionEntityType.name",
                                request.getSessionEntityType().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{sessionEntityType.name=projects/*/agent/environments/*/users/*/sessions/*/entityTypes/*}",
                          "/v2beta1/{sessionEntityType.name=projects/*/locations/*/agent/sessions/*/entityTypes/*}",
                          "/v2beta1/{sessionEntityType.name=projects/*/locations/*/agent/environments/*/users/*/sessions/*/entityTypes/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSessionEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "sessionEntityType", request.getSessionEntityType(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SessionEntityType>newBuilder()
                      .setDefaultInstance(SessionEntityType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSessionEntityTypeRequest, Empty>
      deleteSessionEntityTypeMethodDescriptor =
          ApiMethodDescriptor.<DeleteSessionEntityTypeRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.SessionEntityTypes/DeleteSessionEntityType")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSessionEntityTypeRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/agent/sessions/*/entityTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSessionEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{name=projects/*/agent/environments/*/users/*/sessions/*/entityTypes/*}",
                          "/v2beta1/{name=projects/*/locations/*/agent/sessions/*/entityTypes/*}",
                          "/v2beta1/{name=projects/*/locations/*/agent/environments/*/users/*/sessions/*/entityTypes/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSessionEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
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

  private final UnaryCallable<ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>
      listSessionEntityTypesCallable;
  private final UnaryCallable<ListSessionEntityTypesRequest, ListSessionEntityTypesPagedResponse>
      listSessionEntityTypesPagedCallable;
  private final UnaryCallable<GetSessionEntityTypeRequest, SessionEntityType>
      getSessionEntityTypeCallable;
  private final UnaryCallable<CreateSessionEntityTypeRequest, SessionEntityType>
      createSessionEntityTypeCallable;
  private final UnaryCallable<UpdateSessionEntityTypeRequest, SessionEntityType>
      updateSessionEntityTypeCallable;
  private final UnaryCallable<DeleteSessionEntityTypeRequest, Empty>
      deleteSessionEntityTypeCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSessionEntityTypesStub create(SessionEntityTypesStubSettings settings)
      throws IOException {
    return new HttpJsonSessionEntityTypesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSessionEntityTypesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSessionEntityTypesStub(
        SessionEntityTypesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSessionEntityTypesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSessionEntityTypesStub(
        SessionEntityTypesStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSessionEntityTypesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSessionEntityTypesStub(
      SessionEntityTypesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSessionEntityTypesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSessionEntityTypesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSessionEntityTypesStub(
      SessionEntityTypesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>
        listSessionEntityTypesTransportSettings =
            HttpJsonCallSettings
                .<ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>newBuilder()
                .setMethodDescriptor(listSessionEntityTypesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetSessionEntityTypeRequest, SessionEntityType>
        getSessionEntityTypeTransportSettings =
            HttpJsonCallSettings.<GetSessionEntityTypeRequest, SessionEntityType>newBuilder()
                .setMethodDescriptor(getSessionEntityTypeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateSessionEntityTypeRequest, SessionEntityType>
        createSessionEntityTypeTransportSettings =
            HttpJsonCallSettings.<CreateSessionEntityTypeRequest, SessionEntityType>newBuilder()
                .setMethodDescriptor(createSessionEntityTypeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateSessionEntityTypeRequest, SessionEntityType>
        updateSessionEntityTypeTransportSettings =
            HttpJsonCallSettings.<UpdateSessionEntityTypeRequest, SessionEntityType>newBuilder()
                .setMethodDescriptor(updateSessionEntityTypeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteSessionEntityTypeRequest, Empty>
        deleteSessionEntityTypeTransportSettings =
            HttpJsonCallSettings.<DeleteSessionEntityTypeRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSessionEntityTypeMethodDescriptor)
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

    this.listSessionEntityTypesCallable =
        callableFactory.createUnaryCallable(
            listSessionEntityTypesTransportSettings,
            settings.listSessionEntityTypesSettings(),
            clientContext);
    this.listSessionEntityTypesPagedCallable =
        callableFactory.createPagedCallable(
            listSessionEntityTypesTransportSettings,
            settings.listSessionEntityTypesSettings(),
            clientContext);
    this.getSessionEntityTypeCallable =
        callableFactory.createUnaryCallable(
            getSessionEntityTypeTransportSettings,
            settings.getSessionEntityTypeSettings(),
            clientContext);
    this.createSessionEntityTypeCallable =
        callableFactory.createUnaryCallable(
            createSessionEntityTypeTransportSettings,
            settings.createSessionEntityTypeSettings(),
            clientContext);
    this.updateSessionEntityTypeCallable =
        callableFactory.createUnaryCallable(
            updateSessionEntityTypeTransportSettings,
            settings.updateSessionEntityTypeSettings(),
            clientContext);
    this.deleteSessionEntityTypeCallable =
        callableFactory.createUnaryCallable(
            deleteSessionEntityTypeTransportSettings,
            settings.deleteSessionEntityTypeSettings(),
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
    methodDescriptors.add(listSessionEntityTypesMethodDescriptor);
    methodDescriptors.add(getSessionEntityTypeMethodDescriptor);
    methodDescriptors.add(createSessionEntityTypeMethodDescriptor);
    methodDescriptors.add(updateSessionEntityTypeMethodDescriptor);
    methodDescriptors.add(deleteSessionEntityTypeMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>
      listSessionEntityTypesCallable() {
    return listSessionEntityTypesCallable;
  }

  @Override
  public UnaryCallable<ListSessionEntityTypesRequest, ListSessionEntityTypesPagedResponse>
      listSessionEntityTypesPagedCallable() {
    return listSessionEntityTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSessionEntityTypeRequest, SessionEntityType>
      getSessionEntityTypeCallable() {
    return getSessionEntityTypeCallable;
  }

  @Override
  public UnaryCallable<CreateSessionEntityTypeRequest, SessionEntityType>
      createSessionEntityTypeCallable() {
    return createSessionEntityTypeCallable;
  }

  @Override
  public UnaryCallable<UpdateSessionEntityTypeRequest, SessionEntityType>
      updateSessionEntityTypeCallable() {
    return updateSessionEntityTypeCallable;
  }

  @Override
  public UnaryCallable<DeleteSessionEntityTypeRequest, Empty> deleteSessionEntityTypeCallable() {
    return deleteSessionEntityTypeCallable;
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
