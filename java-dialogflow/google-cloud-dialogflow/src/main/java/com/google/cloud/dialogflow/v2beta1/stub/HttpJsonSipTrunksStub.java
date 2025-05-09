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

import static com.google.cloud.dialogflow.v2beta1.SipTrunksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.SipTrunksClient.ListSipTrunksPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest;
import com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest;
import com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest;
import com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse;
import com.google.cloud.dialogflow.v2beta1.SipTrunk;
import com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest;
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
 * REST stub implementation for the SipTrunks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSipTrunksStub extends SipTrunksStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateSipTrunkRequest, SipTrunk>
      createSipTrunkMethodDescriptor =
          ApiMethodDescriptor.<CreateSipTrunkRequest, SipTrunk>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.SipTrunks/CreateSipTrunk")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSipTrunkRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/locations/*}/sipTrunks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSipTrunkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSipTrunkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("sipTrunk", request.getSipTrunk(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SipTrunk>newBuilder()
                      .setDefaultInstance(SipTrunk.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSipTrunkRequest, Empty>
      deleteSipTrunkMethodDescriptor =
          ApiMethodDescriptor.<DeleteSipTrunkRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.SipTrunks/DeleteSipTrunk")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSipTrunkRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/locations/*/sipTrunks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSipTrunkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSipTrunkRequest> serializer =
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

  private static final ApiMethodDescriptor<ListSipTrunksRequest, ListSipTrunksResponse>
      listSipTrunksMethodDescriptor =
          ApiMethodDescriptor.<ListSipTrunksRequest, ListSipTrunksResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.SipTrunks/ListSipTrunks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSipTrunksRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/locations/*}/sipTrunks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSipTrunksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSipTrunksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSipTrunksResponse>newBuilder()
                      .setDefaultInstance(ListSipTrunksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSipTrunkRequest, SipTrunk>
      getSipTrunkMethodDescriptor =
          ApiMethodDescriptor.<GetSipTrunkRequest, SipTrunk>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.SipTrunks/GetSipTrunk")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSipTrunkRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/locations/*/sipTrunks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSipTrunkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSipTrunkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SipTrunk>newBuilder()
                      .setDefaultInstance(SipTrunk.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSipTrunkRequest, SipTrunk>
      updateSipTrunkMethodDescriptor =
          ApiMethodDescriptor.<UpdateSipTrunkRequest, SipTrunk>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.SipTrunks/UpdateSipTrunk")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSipTrunkRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{sipTrunk.name=projects/*/locations/*/sipTrunks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSipTrunkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "sipTrunk.name", request.getSipTrunk().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSipTrunkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("sipTrunk", request.getSipTrunk(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SipTrunk>newBuilder()
                      .setDefaultInstance(SipTrunk.getDefaultInstance())
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

  private final UnaryCallable<CreateSipTrunkRequest, SipTrunk> createSipTrunkCallable;
  private final UnaryCallable<DeleteSipTrunkRequest, Empty> deleteSipTrunkCallable;
  private final UnaryCallable<ListSipTrunksRequest, ListSipTrunksResponse> listSipTrunksCallable;
  private final UnaryCallable<ListSipTrunksRequest, ListSipTrunksPagedResponse>
      listSipTrunksPagedCallable;
  private final UnaryCallable<GetSipTrunkRequest, SipTrunk> getSipTrunkCallable;
  private final UnaryCallable<UpdateSipTrunkRequest, SipTrunk> updateSipTrunkCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSipTrunksStub create(SipTrunksStubSettings settings)
      throws IOException {
    return new HttpJsonSipTrunksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSipTrunksStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonSipTrunksStub(
        SipTrunksStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSipTrunksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSipTrunksStub(
        SipTrunksStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSipTrunksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSipTrunksStub(SipTrunksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSipTrunksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSipTrunksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSipTrunksStub(
      SipTrunksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateSipTrunkRequest, SipTrunk> createSipTrunkTransportSettings =
        HttpJsonCallSettings.<CreateSipTrunkRequest, SipTrunk>newBuilder()
            .setMethodDescriptor(createSipTrunkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSipTrunkRequest, Empty> deleteSipTrunkTransportSettings =
        HttpJsonCallSettings.<DeleteSipTrunkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSipTrunkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSipTrunksRequest, ListSipTrunksResponse>
        listSipTrunksTransportSettings =
            HttpJsonCallSettings.<ListSipTrunksRequest, ListSipTrunksResponse>newBuilder()
                .setMethodDescriptor(listSipTrunksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSipTrunkRequest, SipTrunk> getSipTrunkTransportSettings =
        HttpJsonCallSettings.<GetSipTrunkRequest, SipTrunk>newBuilder()
            .setMethodDescriptor(getSipTrunkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSipTrunkRequest, SipTrunk> updateSipTrunkTransportSettings =
        HttpJsonCallSettings.<UpdateSipTrunkRequest, SipTrunk>newBuilder()
            .setMethodDescriptor(updateSipTrunkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("sip_trunk.name", String.valueOf(request.getSipTrunk().getName()));
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

    this.createSipTrunkCallable =
        callableFactory.createUnaryCallable(
            createSipTrunkTransportSettings, settings.createSipTrunkSettings(), clientContext);
    this.deleteSipTrunkCallable =
        callableFactory.createUnaryCallable(
            deleteSipTrunkTransportSettings, settings.deleteSipTrunkSettings(), clientContext);
    this.listSipTrunksCallable =
        callableFactory.createUnaryCallable(
            listSipTrunksTransportSettings, settings.listSipTrunksSettings(), clientContext);
    this.listSipTrunksPagedCallable =
        callableFactory.createPagedCallable(
            listSipTrunksTransportSettings, settings.listSipTrunksSettings(), clientContext);
    this.getSipTrunkCallable =
        callableFactory.createUnaryCallable(
            getSipTrunkTransportSettings, settings.getSipTrunkSettings(), clientContext);
    this.updateSipTrunkCallable =
        callableFactory.createUnaryCallable(
            updateSipTrunkTransportSettings, settings.updateSipTrunkSettings(), clientContext);
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
    methodDescriptors.add(createSipTrunkMethodDescriptor);
    methodDescriptors.add(deleteSipTrunkMethodDescriptor);
    methodDescriptors.add(listSipTrunksMethodDescriptor);
    methodDescriptors.add(getSipTrunkMethodDescriptor);
    methodDescriptors.add(updateSipTrunkMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateSipTrunkRequest, SipTrunk> createSipTrunkCallable() {
    return createSipTrunkCallable;
  }

  @Override
  public UnaryCallable<DeleteSipTrunkRequest, Empty> deleteSipTrunkCallable() {
    return deleteSipTrunkCallable;
  }

  @Override
  public UnaryCallable<ListSipTrunksRequest, ListSipTrunksResponse> listSipTrunksCallable() {
    return listSipTrunksCallable;
  }

  @Override
  public UnaryCallable<ListSipTrunksRequest, ListSipTrunksPagedResponse>
      listSipTrunksPagedCallable() {
    return listSipTrunksPagedCallable;
  }

  @Override
  public UnaryCallable<GetSipTrunkRequest, SipTrunk> getSipTrunkCallable() {
    return getSipTrunkCallable;
  }

  @Override
  public UnaryCallable<UpdateSipTrunkRequest, SipTrunk> updateSipTrunkCallable() {
    return updateSipTrunkCallable;
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
