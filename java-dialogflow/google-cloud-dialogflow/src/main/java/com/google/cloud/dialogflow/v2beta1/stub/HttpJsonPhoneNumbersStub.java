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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.PhoneNumbersClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.PhoneNumbersClient.ListPhoneNumbersPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest;
import com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest;
import com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse;
import com.google.cloud.dialogflow.v2beta1.PhoneNumber;
import com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest;
import com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the PhoneNumbers service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonPhoneNumbersStub extends PhoneNumbersStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListPhoneNumbersRequest, ListPhoneNumbersResponse>
      listPhoneNumbersMethodDescriptor =
          ApiMethodDescriptor.<ListPhoneNumbersRequest, ListPhoneNumbersResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.PhoneNumbers/ListPhoneNumbers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPhoneNumbersRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*}/phoneNumbers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPhoneNumbersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2beta1/{parent=projects/*/locations/*}/phoneNumbers")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPhoneNumbersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPhoneNumbersResponse>newBuilder()
                      .setDefaultInstance(ListPhoneNumbersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePhoneNumberRequest, PhoneNumber>
      updatePhoneNumberMethodDescriptor =
          ApiMethodDescriptor.<UpdatePhoneNumberRequest, PhoneNumber>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.PhoneNumbers/UpdatePhoneNumber")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePhoneNumberRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{phoneNumber.name=projects/*/phoneNumbers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePhoneNumberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "phoneNumber.name", request.getPhoneNumber().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{phoneNumber.name=projects/*/locations/*/phoneNumbers/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePhoneNumberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("phoneNumber", request.getPhoneNumber(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PhoneNumber>newBuilder()
                      .setDefaultInstance(PhoneNumber.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePhoneNumberRequest, PhoneNumber>
      deletePhoneNumberMethodDescriptor =
          ApiMethodDescriptor.<DeletePhoneNumberRequest, PhoneNumber>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.PhoneNumbers/DeletePhoneNumber")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePhoneNumberRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/phoneNumbers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePhoneNumberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v2beta1/{name=projects/*/locations/*/phoneNumbers/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePhoneNumberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PhoneNumber>newBuilder()
                      .setDefaultInstance(PhoneNumber.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UndeletePhoneNumberRequest, PhoneNumber>
      undeletePhoneNumberMethodDescriptor =
          ApiMethodDescriptor.<UndeletePhoneNumberRequest, PhoneNumber>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.PhoneNumbers/UndeletePhoneNumber")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeletePhoneNumberRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/phoneNumbers/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeletePhoneNumberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{name=projects/*/locations/*/phoneNumbers/*}:undelete")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeletePhoneNumberRequest> serializer =
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
                  ProtoMessageResponseParser.<PhoneNumber>newBuilder()
                      .setDefaultInstance(PhoneNumber.getDefaultInstance())
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

  private final UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersResponse>
      listPhoneNumbersCallable;
  private final UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersPagedResponse>
      listPhoneNumbersPagedCallable;
  private final UnaryCallable<UpdatePhoneNumberRequest, PhoneNumber> updatePhoneNumberCallable;
  private final UnaryCallable<DeletePhoneNumberRequest, PhoneNumber> deletePhoneNumberCallable;
  private final UnaryCallable<UndeletePhoneNumberRequest, PhoneNumber> undeletePhoneNumberCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPhoneNumbersStub create(PhoneNumbersStubSettings settings)
      throws IOException {
    return new HttpJsonPhoneNumbersStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPhoneNumbersStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPhoneNumbersStub(
        PhoneNumbersStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPhoneNumbersStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPhoneNumbersStub(
        PhoneNumbersStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPhoneNumbersStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPhoneNumbersStub(PhoneNumbersStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPhoneNumbersCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPhoneNumbersStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPhoneNumbersStub(
      PhoneNumbersStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListPhoneNumbersRequest, ListPhoneNumbersResponse>
        listPhoneNumbersTransportSettings =
            HttpJsonCallSettings.<ListPhoneNumbersRequest, ListPhoneNumbersResponse>newBuilder()
                .setMethodDescriptor(listPhoneNumbersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePhoneNumberRequest, PhoneNumber> updatePhoneNumberTransportSettings =
        HttpJsonCallSettings.<UpdatePhoneNumberRequest, PhoneNumber>newBuilder()
            .setMethodDescriptor(updatePhoneNumberMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "phone_number.name", String.valueOf(request.getPhoneNumber().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeletePhoneNumberRequest, PhoneNumber> deletePhoneNumberTransportSettings =
        HttpJsonCallSettings.<DeletePhoneNumberRequest, PhoneNumber>newBuilder()
            .setMethodDescriptor(deletePhoneNumberMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UndeletePhoneNumberRequest, PhoneNumber>
        undeletePhoneNumberTransportSettings =
            HttpJsonCallSettings.<UndeletePhoneNumberRequest, PhoneNumber>newBuilder()
                .setMethodDescriptor(undeletePhoneNumberMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
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

    this.listPhoneNumbersCallable =
        callableFactory.createUnaryCallable(
            listPhoneNumbersTransportSettings, settings.listPhoneNumbersSettings(), clientContext);
    this.listPhoneNumbersPagedCallable =
        callableFactory.createPagedCallable(
            listPhoneNumbersTransportSettings, settings.listPhoneNumbersSettings(), clientContext);
    this.updatePhoneNumberCallable =
        callableFactory.createUnaryCallable(
            updatePhoneNumberTransportSettings,
            settings.updatePhoneNumberSettings(),
            clientContext);
    this.deletePhoneNumberCallable =
        callableFactory.createUnaryCallable(
            deletePhoneNumberTransportSettings,
            settings.deletePhoneNumberSettings(),
            clientContext);
    this.undeletePhoneNumberCallable =
        callableFactory.createUnaryCallable(
            undeletePhoneNumberTransportSettings,
            settings.undeletePhoneNumberSettings(),
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
    methodDescriptors.add(listPhoneNumbersMethodDescriptor);
    methodDescriptors.add(updatePhoneNumberMethodDescriptor);
    methodDescriptors.add(deletePhoneNumberMethodDescriptor);
    methodDescriptors.add(undeletePhoneNumberMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersResponse>
      listPhoneNumbersCallable() {
    return listPhoneNumbersCallable;
  }

  @Override
  public UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersPagedResponse>
      listPhoneNumbersPagedCallable() {
    return listPhoneNumbersPagedCallable;
  }

  @Override
  public UnaryCallable<UpdatePhoneNumberRequest, PhoneNumber> updatePhoneNumberCallable() {
    return updatePhoneNumberCallable;
  }

  @Override
  public UnaryCallable<DeletePhoneNumberRequest, PhoneNumber> deletePhoneNumberCallable() {
    return deletePhoneNumberCallable;
  }

  @Override
  public UnaryCallable<UndeletePhoneNumberRequest, PhoneNumber> undeletePhoneNumberCallable() {
    return undeletePhoneNumberCallable;
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
