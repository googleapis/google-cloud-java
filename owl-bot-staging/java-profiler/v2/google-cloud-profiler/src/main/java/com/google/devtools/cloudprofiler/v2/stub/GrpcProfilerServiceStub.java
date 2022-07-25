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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest;
import com.google.devtools.cloudprofiler.v2.CreateProfileRequest;
import com.google.devtools.cloudprofiler.v2.Profile;
import com.google.devtools.cloudprofiler.v2.UpdateProfileRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ProfilerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcProfilerServiceStub extends ProfilerServiceStub {
  private static final MethodDescriptor<CreateProfileRequest, Profile>
      createProfileMethodDescriptor =
          MethodDescriptor.<CreateProfileRequest, Profile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudprofiler.v2.ProfilerService/CreateProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Profile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateOfflineProfileRequest, Profile>
      createOfflineProfileMethodDescriptor =
          MethodDescriptor.<CreateOfflineProfileRequest, Profile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.cloudprofiler.v2.ProfilerService/CreateOfflineProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOfflineProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Profile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateProfileRequest, Profile>
      updateProfileMethodDescriptor =
          MethodDescriptor.<UpdateProfileRequest, Profile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudprofiler.v2.ProfilerService/UpdateProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Profile.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateProfileRequest, Profile> createProfileCallable;
  private final UnaryCallable<CreateOfflineProfileRequest, Profile> createOfflineProfileCallable;
  private final UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcProfilerServiceStub create(ProfilerServiceStubSettings settings)
      throws IOException {
    return new GrpcProfilerServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcProfilerServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcProfilerServiceStub(
        ProfilerServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcProfilerServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcProfilerServiceStub(
        ProfilerServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcProfilerServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProfilerServiceStub(
      ProfilerServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcProfilerServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcProfilerServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProfilerServiceStub(
      ProfilerServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateProfileRequest, Profile> createProfileTransportSettings =
        GrpcCallSettings.<CreateProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(createProfileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateOfflineProfileRequest, Profile> createOfflineProfileTransportSettings =
        GrpcCallSettings.<CreateOfflineProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(createOfflineProfileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateProfileRequest, Profile> updateProfileTransportSettings =
        GrpcCallSettings.<UpdateProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(updateProfileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("profile.name", String.valueOf(request.getProfile().getName()));
                  return params.build();
                })
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
