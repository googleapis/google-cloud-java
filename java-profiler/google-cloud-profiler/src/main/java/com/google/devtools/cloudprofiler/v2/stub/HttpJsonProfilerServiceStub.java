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

package com.google.devtools.cloudprofiler.v2.stub;

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
import com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest;
import com.google.devtools.cloudprofiler.v2.CreateProfileRequest;
import com.google.devtools.cloudprofiler.v2.Profile;
import com.google.devtools.cloudprofiler.v2.UpdateProfileRequest;
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
 * REST stub implementation for the ProfilerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonProfilerServiceStub extends ProfilerServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateProfileRequest, Profile>
      createProfileMethodDescriptor =
          ApiMethodDescriptor.<CreateProfileRequest, Profile>newBuilder()
              .setFullMethodName("google.devtools.cloudprofiler.v2.ProfilerService/CreateProfile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateProfileRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/profiles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Profile>newBuilder()
                      .setDefaultInstance(Profile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateOfflineProfileRequest, Profile>
      createOfflineProfileMethodDescriptor =
          ApiMethodDescriptor.<CreateOfflineProfileRequest, Profile>newBuilder()
              .setFullMethodName(
                  "google.devtools.cloudprofiler.v2.ProfilerService/CreateOfflineProfile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateOfflineProfileRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/profiles:createOffline",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOfflineProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOfflineProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("profile", request.getProfile(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Profile>newBuilder()
                      .setDefaultInstance(Profile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateProfileRequest, Profile>
      updateProfileMethodDescriptor =
          ApiMethodDescriptor.<UpdateProfileRequest, Profile>newBuilder()
              .setFullMethodName("google.devtools.cloudprofiler.v2.ProfilerService/UpdateProfile")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProfileRequest>newBuilder()
                      .setPath(
                          "/v2/{profile.name=projects/*/profiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "profile.name", request.getProfile().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("profile", request.getProfile(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Profile>newBuilder()
                      .setDefaultInstance(Profile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateProfileRequest, Profile> createProfileCallable;
  private final UnaryCallable<CreateOfflineProfileRequest, Profile> createOfflineProfileCallable;
  private final UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProfilerServiceStub create(ProfilerServiceStubSettings settings)
      throws IOException {
    return new HttpJsonProfilerServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProfilerServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonProfilerServiceStub(
        ProfilerServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonProfilerServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProfilerServiceStub(
        ProfilerServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProfilerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProfilerServiceStub(
      ProfilerServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonProfilerServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProfilerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProfilerServiceStub(
      ProfilerServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateProfileRequest, Profile> createProfileTransportSettings =
        HttpJsonCallSettings.<CreateProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(createProfileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateOfflineProfileRequest, Profile>
        createOfflineProfileTransportSettings =
            HttpJsonCallSettings.<CreateOfflineProfileRequest, Profile>newBuilder()
                .setMethodDescriptor(createOfflineProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateProfileRequest, Profile> updateProfileTransportSettings =
        HttpJsonCallSettings.<UpdateProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(updateProfileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createProfileCallable =
        callableFactory.createUnaryCallable(
            createProfileTransportSettings, settings.createProfileSettings(), clientContext);
    this.createOfflineProfileCallable =
        callableFactory.createUnaryCallable(
            createOfflineProfileTransportSettings,
            settings.createOfflineProfileSettings(),
            clientContext);
    this.updateProfileCallable =
        callableFactory.createUnaryCallable(
            updateProfileTransportSettings, settings.updateProfileSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createProfileMethodDescriptor);
    methodDescriptors.add(createOfflineProfileMethodDescriptor);
    methodDescriptors.add(updateProfileMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateProfileRequest, Profile> createProfileCallable() {
    return createProfileCallable;
  }

  @Override
  public UnaryCallable<CreateOfflineProfileRequest, Profile> createOfflineProfileCallable() {
    return createOfflineProfileCallable;
  }

  @Override
  public UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable() {
    return updateProfileCallable;
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
