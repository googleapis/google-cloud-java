/*
 * Copyright 2023 Google LLC
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

package com.google.apps.meet.v2.stub;

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
import com.google.apps.meet.v2.CreateSpaceRequest;
import com.google.apps.meet.v2.EndActiveConferenceRequest;
import com.google.apps.meet.v2.GetSpaceRequest;
import com.google.apps.meet.v2.Space;
import com.google.apps.meet.v2.UpdateSpaceRequest;
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
 * REST stub implementation for the SpacesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonSpacesServiceStub extends SpacesServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateSpaceRequest, Space> createSpaceMethodDescriptor =
      ApiMethodDescriptor.<CreateSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.apps.meet.v2.SpacesService/CreateSpace")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateSpaceRequest>newBuilder()
                  .setPath(
                      "/v2/spaces",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("space", request.getSpace(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetSpaceRequest, Space> getSpaceMethodDescriptor =
      ApiMethodDescriptor.<GetSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.apps.meet.v2.SpacesService/GetSpace")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSpaceRequest>newBuilder()
                  .setPath(
                      "/v2/{name=spaces/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateSpaceRequest, Space> updateSpaceMethodDescriptor =
      ApiMethodDescriptor.<UpdateSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.apps.meet.v2.SpacesService/UpdateSpace")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateSpaceRequest>newBuilder()
                  .setPath(
                      "/v2/{space.name=spaces/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "space.name", request.getSpace().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("space", request.getSpace(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<EndActiveConferenceRequest, Empty>
      endActiveConferenceMethodDescriptor =
          ApiMethodDescriptor.<EndActiveConferenceRequest, Empty>newBuilder()
              .setFullMethodName("google.apps.meet.v2.SpacesService/EndActiveConference")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EndActiveConferenceRequest>newBuilder()
                      .setPath(
                          "/v2/{name=spaces/*}:endActiveConference",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EndActiveConferenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EndActiveConferenceRequest> serializer =
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable;
  private final UnaryCallable<GetSpaceRequest, Space> getSpaceCallable;
  private final UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable;
  private final UnaryCallable<EndActiveConferenceRequest, Empty> endActiveConferenceCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSpacesServiceStub create(SpacesServiceStubSettings settings)
      throws IOException {
    return new HttpJsonSpacesServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSpacesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSpacesServiceStub(
        SpacesServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSpacesServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSpacesServiceStub(
        SpacesServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSpacesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSpacesServiceStub(
      SpacesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSpacesServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSpacesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSpacesServiceStub(
      SpacesServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateSpaceRequest, Space> createSpaceTransportSettings =
        HttpJsonCallSettings.<CreateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(createSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetSpaceRequest, Space> getSpaceTransportSettings =
        HttpJsonCallSettings.<GetSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(getSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSpaceRequest, Space> updateSpaceTransportSettings =
        HttpJsonCallSettings.<UpdateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(updateSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("space.name", String.valueOf(request.getSpace().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<EndActiveConferenceRequest, Empty> endActiveConferenceTransportSettings =
        HttpJsonCallSettings.<EndActiveConferenceRequest, Empty>newBuilder()
            .setMethodDescriptor(endActiveConferenceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createSpaceCallable =
        callableFactory.createUnaryCallable(
            createSpaceTransportSettings, settings.createSpaceSettings(), clientContext);
    this.getSpaceCallable =
        callableFactory.createUnaryCallable(
            getSpaceTransportSettings, settings.getSpaceSettings(), clientContext);
    this.updateSpaceCallable =
        callableFactory.createUnaryCallable(
            updateSpaceTransportSettings, settings.updateSpaceSettings(), clientContext);
    this.endActiveConferenceCallable =
        callableFactory.createUnaryCallable(
            endActiveConferenceTransportSettings,
            settings.endActiveConferenceSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createSpaceMethodDescriptor);
    methodDescriptors.add(getSpaceMethodDescriptor);
    methodDescriptors.add(updateSpaceMethodDescriptor);
    methodDescriptors.add(endActiveConferenceMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    return createSpaceCallable;
  }

  @Override
  public UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    return getSpaceCallable;
  }

  @Override
  public UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    return updateSpaceCallable;
  }

  @Override
  public UnaryCallable<EndActiveConferenceRequest, Empty> endActiveConferenceCallable() {
    return endActiveConferenceCallable;
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
