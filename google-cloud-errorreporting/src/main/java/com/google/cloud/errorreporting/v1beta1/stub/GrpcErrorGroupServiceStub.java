/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.errorreporting.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.errorreporting.v1beta1.ErrorGroupServiceSettings;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup;
import com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest;
import com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Stackdriver Error Reporting API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcErrorGroupServiceStub extends ErrorGroupServiceStub {

  private static final MethodDescriptor<GetGroupRequest, ErrorGroup> getGroupMethodDescriptor =
      MethodDescriptor.<GetGroupRequest, ErrorGroup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.devtools.clouderrorreporting.v1beta1.ErrorGroupService/GetGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ErrorGroup.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<UpdateGroupRequest, ErrorGroup>
      updateGroupMethodDescriptor =
          MethodDescriptor.<UpdateGroupRequest, ErrorGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.clouderrorreporting.v1beta1.ErrorGroupService/UpdateGroup")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ErrorGroup.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<GetGroupRequest, ErrorGroup> getGroupCallable;
  private final UnaryCallable<UpdateGroupRequest, ErrorGroup> updateGroupCallable;

  public static final GrpcErrorGroupServiceStub create(ErrorGroupServiceSettings settings)
      throws IOException {
    return new GrpcErrorGroupServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcErrorGroupServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcErrorGroupServiceStub(
        ErrorGroupServiceSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcErrorGroupServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcErrorGroupServiceStub(
      ErrorGroupServiceSettings settings, ClientContext clientContext) throws IOException {

    GrpcCallSettings<GetGroupRequest, ErrorGroup> getGroupTransportSettings =
        GrpcCallSettings.<GetGroupRequest, ErrorGroup>newBuilder()
            .setMethodDescriptor(getGroupMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateGroupRequest, ErrorGroup> updateGroupTransportSettings =
        GrpcCallSettings.<UpdateGroupRequest, ErrorGroup>newBuilder()
            .setMethodDescriptor(updateGroupMethodDescriptor)
            .build();

    this.getGroupCallable =
        GrpcCallableFactory.createUnaryCallable(
            getGroupTransportSettings, settings.getGroupSettings(), clientContext);
    this.updateGroupCallable =
        GrpcCallableFactory.createUnaryCallable(
            updateGroupTransportSettings, settings.updateGroupSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<GetGroupRequest, ErrorGroup> getGroupCallable() {
    return getGroupCallable;
  }

  public UnaryCallable<UpdateGroupRequest, ErrorGroup> updateGroupCallable() {
    return updateGroupCallable;
  }

  @Override
  public final void close() throws Exception {
    shutdown();
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
