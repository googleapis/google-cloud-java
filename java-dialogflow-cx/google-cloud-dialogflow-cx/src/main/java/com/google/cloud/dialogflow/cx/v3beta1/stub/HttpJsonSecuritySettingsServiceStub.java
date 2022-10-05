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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.SecuritySettingsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.SecuritySettingsServiceClient.ListSecuritySettingsPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest;
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
 * REST stub implementation for the SecuritySettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSecuritySettingsServiceStub extends SecuritySettingsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateSecuritySettingsRequest, SecuritySettings>
      createSecuritySettingsMethodDescriptor =
          ApiMethodDescriptor.<CreateSecuritySettingsRequest, SecuritySettings>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.SecuritySettingsService/CreateSecuritySettings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSecuritySettingsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*}/securitySettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSecuritySettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSecuritySettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("securitySettings", request.getSecuritySettings(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecuritySettings>newBuilder()
                      .setDefaultInstance(SecuritySettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSecuritySettingsRequest, SecuritySettings>
      getSecuritySettingsMethodDescriptor =
          ApiMethodDescriptor.<GetSecuritySettingsRequest, SecuritySettings>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.SecuritySettingsService/GetSecuritySettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSecuritySettingsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/securitySettings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSecuritySettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSecuritySettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecuritySettings>newBuilder()
                      .setDefaultInstance(SecuritySettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSecuritySettingsRequest, SecuritySettings>
      updateSecuritySettingsMethodDescriptor =
          ApiMethodDescriptor.<UpdateSecuritySettingsRequest, SecuritySettings>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.SecuritySettingsService/UpdateSecuritySettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSecuritySettingsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{securitySettings.name=projects/*/locations/*/securitySettings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSecuritySettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "securitySettings.name",
                                request.getSecuritySettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSecuritySettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("securitySettings", request.getSecuritySettings(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecuritySettings>newBuilder()
                      .setDefaultInstance(SecuritySettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListSecuritySettingsRequest, ListSecuritySettingsResponse>
      listSecuritySettingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListSecuritySettingsRequest, ListSecuritySettingsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.SecuritySettingsService/ListSecuritySettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSecuritySettingsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*}/securitySettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSecuritySettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSecuritySettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSecuritySettingsResponse>newBuilder()
                      .setDefaultInstance(ListSecuritySettingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSecuritySettingsRequest, Empty>
      deleteSecuritySettingsMethodDescriptor =
          ApiMethodDescriptor.<DeleteSecuritySettingsRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.SecuritySettingsService/DeleteSecuritySettings")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSecuritySettingsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/securitySettings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSecuritySettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSecuritySettingsRequest> serializer =
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
                          "/v3beta1/{name=projects/*}/locations",
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
                          "/v3beta1/{name=projects/*/locations/*}",
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

  private final UnaryCallable<CreateSecuritySettingsRequest, SecuritySettings>
      createSecuritySettingsCallable;
  private final UnaryCallable<GetSecuritySettingsRequest, SecuritySettings>
      getSecuritySettingsCallable;
  private final UnaryCallable<UpdateSecuritySettingsRequest, SecuritySettings>
      updateSecuritySettingsCallable;
  private final UnaryCallable<ListSecuritySettingsRequest, ListSecuritySettingsResponse>
      listSecuritySettingsCallable;
  private final UnaryCallable<ListSecuritySettingsRequest, ListSecuritySettingsPagedResponse>
      listSecuritySettingsPagedCallable;
  private final UnaryCallable<DeleteSecuritySettingsRequest, Empty> deleteSecuritySettingsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSecuritySettingsServiceStub create(
      SecuritySettingsServiceStubSettings settings) throws IOException {
    return new HttpJsonSecuritySettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSecuritySettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSecuritySettingsServiceStub(
        SecuritySettingsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSecuritySettingsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSecuritySettingsServiceStub(
        SecuritySettingsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSecuritySettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecuritySettingsServiceStub(
      SecuritySettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSecuritySettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSecuritySettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecuritySettingsServiceStub(
      SecuritySettingsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateSecuritySettingsRequest, SecuritySettings>
        createSecuritySettingsTransportSettings =
            HttpJsonCallSettings.<CreateSecuritySettingsRequest, SecuritySettings>newBuilder()
                .setMethodDescriptor(createSecuritySettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetSecuritySettingsRequest, SecuritySettings>
        getSecuritySettingsTransportSettings =
            HttpJsonCallSettings.<GetSecuritySettingsRequest, SecuritySettings>newBuilder()
                .setMethodDescriptor(getSecuritySettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateSecuritySettingsRequest, SecuritySettings>
        updateSecuritySettingsTransportSettings =
            HttpJsonCallSettings.<UpdateSecuritySettingsRequest, SecuritySettings>newBuilder()
                .setMethodDescriptor(updateSecuritySettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListSecuritySettingsRequest, ListSecuritySettingsResponse>
        listSecuritySettingsTransportSettings =
            HttpJsonCallSettings
                .<ListSecuritySettingsRequest, ListSecuritySettingsResponse>newBuilder()
                .setMethodDescriptor(listSecuritySettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteSecuritySettingsRequest, Empty>
        deleteSecuritySettingsTransportSettings =
            HttpJsonCallSettings.<DeleteSecuritySettingsRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSecuritySettingsMethodDescriptor)
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

    this.createSecuritySettingsCallable =
        callableFactory.createUnaryCallable(
            createSecuritySettingsTransportSettings,
            settings.createSecuritySettingsSettings(),
            clientContext);
    this.getSecuritySettingsCallable =
        callableFactory.createUnaryCallable(
            getSecuritySettingsTransportSettings,
            settings.getSecuritySettingsSettings(),
            clientContext);
    this.updateSecuritySettingsCallable =
        callableFactory.createUnaryCallable(
            updateSecuritySettingsTransportSettings,
            settings.updateSecuritySettingsSettings(),
            clientContext);
    this.listSecuritySettingsCallable =
        callableFactory.createUnaryCallable(
            listSecuritySettingsTransportSettings,
            settings.listSecuritySettingsSettings(),
            clientContext);
    this.listSecuritySettingsPagedCallable =
        callableFactory.createPagedCallable(
            listSecuritySettingsTransportSettings,
            settings.listSecuritySettingsSettings(),
            clientContext);
    this.deleteSecuritySettingsCallable =
        callableFactory.createUnaryCallable(
            deleteSecuritySettingsTransportSettings,
            settings.deleteSecuritySettingsSettings(),
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
    methodDescriptors.add(createSecuritySettingsMethodDescriptor);
    methodDescriptors.add(getSecuritySettingsMethodDescriptor);
    methodDescriptors.add(updateSecuritySettingsMethodDescriptor);
    methodDescriptors.add(listSecuritySettingsMethodDescriptor);
    methodDescriptors.add(deleteSecuritySettingsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateSecuritySettingsRequest, SecuritySettings>
      createSecuritySettingsCallable() {
    return createSecuritySettingsCallable;
  }

  @Override
  public UnaryCallable<GetSecuritySettingsRequest, SecuritySettings> getSecuritySettingsCallable() {
    return getSecuritySettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSecuritySettingsRequest, SecuritySettings>
      updateSecuritySettingsCallable() {
    return updateSecuritySettingsCallable;
  }

  @Override
  public UnaryCallable<ListSecuritySettingsRequest, ListSecuritySettingsResponse>
      listSecuritySettingsCallable() {
    return listSecuritySettingsCallable;
  }

  @Override
  public UnaryCallable<ListSecuritySettingsRequest, ListSecuritySettingsPagedResponse>
      listSecuritySettingsPagedCallable() {
    return listSecuritySettingsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSecuritySettingsRequest, Empty> deleteSecuritySettingsCallable() {
    return deleteSecuritySettingsCallable;
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
