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
import com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest;
import com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest;
import com.google.cloud.discoveryengine.v1beta.UserStore;
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
 * REST stub implementation for the UserStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonUserStoreServiceStub extends UserStoreServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetUserStoreRequest, UserStore>
      getUserStoreMethodDescriptor =
          ApiMethodDescriptor.<GetUserStoreRequest, UserStore>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.UserStoreService/GetUserStore")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUserStoreRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/userStores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserStore>newBuilder()
                      .setDefaultInstance(UserStore.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateUserStoreRequest, UserStore>
      updateUserStoreMethodDescriptor =
          ApiMethodDescriptor.<UpdateUserStoreRequest, UserStore>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.UserStoreService/UpdateUserStore")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUserStoreRequest>newBuilder()
                      .setPath(
                          "/v1beta/{userStore.name=projects/*/locations/*/userStores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "userStore.name", request.getUserStore().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("userStore", request.getUserStore(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserStore>newBuilder()
                      .setDefaultInstance(UserStore.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetUserStoreRequest, UserStore> getUserStoreCallable;
  private final UnaryCallable<UpdateUserStoreRequest, UserStore> updateUserStoreCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonUserStoreServiceStub create(UserStoreServiceStubSettings settings)
      throws IOException {
    return new HttpJsonUserStoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonUserStoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonUserStoreServiceStub(
        UserStoreServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonUserStoreServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonUserStoreServiceStub(
        UserStoreServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonUserStoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonUserStoreServiceStub(
      UserStoreServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonUserStoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonUserStoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonUserStoreServiceStub(
      UserStoreServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetUserStoreRequest, UserStore> getUserStoreTransportSettings =
        HttpJsonCallSettings.<GetUserStoreRequest, UserStore>newBuilder()
            .setMethodDescriptor(getUserStoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UpdateUserStoreRequest, UserStore> updateUserStoreTransportSettings =
        HttpJsonCallSettings.<UpdateUserStoreRequest, UserStore>newBuilder()
            .setMethodDescriptor(updateUserStoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("user_store.name", String.valueOf(request.getUserStore().getName()));
                  return builder.build();
                })
            .build();

    this.getUserStoreCallable =
        callableFactory.createUnaryCallable(
            getUserStoreTransportSettings, settings.getUserStoreSettings(), clientContext);
    this.updateUserStoreCallable =
        callableFactory.createUnaryCallable(
            updateUserStoreTransportSettings, settings.updateUserStoreSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getUserStoreMethodDescriptor);
    methodDescriptors.add(updateUserStoreMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetUserStoreRequest, UserStore> getUserStoreCallable() {
    return getUserStoreCallable;
  }

  @Override
  public UnaryCallable<UpdateUserStoreRequest, UserStore> updateUserStoreCallable() {
    return updateUserStoreCallable;
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
