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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest;
import com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest;
import com.google.cloud.discoveryengine.v1beta.UserStore;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the UserStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcUserStoreServiceStub extends UserStoreServiceStub {
  private static final MethodDescriptor<GetUserStoreRequest, UserStore>
      getUserStoreMethodDescriptor =
          MethodDescriptor.<GetUserStoreRequest, UserStore>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.UserStoreService/GetUserStore")
              .setRequestMarshaller(ProtoUtils.marshaller(GetUserStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserStore.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateUserStoreRequest, UserStore>
      updateUserStoreMethodDescriptor =
          MethodDescriptor.<UpdateUserStoreRequest, UserStore>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.UserStoreService/UpdateUserStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUserStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserStore.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetUserStoreRequest, UserStore> getUserStoreCallable;
  private final UnaryCallable<UpdateUserStoreRequest, UserStore> updateUserStoreCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcUserStoreServiceStub create(UserStoreServiceStubSettings settings)
      throws IOException {
    return new GrpcUserStoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcUserStoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcUserStoreServiceStub(
        UserStoreServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcUserStoreServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcUserStoreServiceStub(
        UserStoreServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcUserStoreServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcUserStoreServiceStub(
      UserStoreServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcUserStoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcUserStoreServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcUserStoreServiceStub(
      UserStoreServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetUserStoreRequest, UserStore> getUserStoreTransportSettings =
        GrpcCallSettings.<GetUserStoreRequest, UserStore>newBuilder()
            .setMethodDescriptor(getUserStoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateUserStoreRequest, UserStore> updateUserStoreTransportSettings =
        GrpcCallSettings.<UpdateUserStoreRequest, UserStore>newBuilder()
            .setMethodDescriptor(updateUserStoreMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
