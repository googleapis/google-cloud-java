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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.meet.v2.CreateSpaceRequest;
import com.google.apps.meet.v2.EndActiveConferenceRequest;
import com.google.apps.meet.v2.GetSpaceRequest;
import com.google.apps.meet.v2.Space;
import com.google.apps.meet.v2.UpdateSpaceRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SpacesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSpacesServiceStub extends SpacesServiceStub {
  private static final MethodDescriptor<CreateSpaceRequest, Space> createSpaceMethodDescriptor =
      MethodDescriptor.<CreateSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.apps.meet.v2.SpacesService/CreateSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetSpaceRequest, Space> getSpaceMethodDescriptor =
      MethodDescriptor.<GetSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.apps.meet.v2.SpacesService/GetSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSpaceRequest, Space> updateSpaceMethodDescriptor =
      MethodDescriptor.<UpdateSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.apps.meet.v2.SpacesService/UpdateSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<EndActiveConferenceRequest, Empty>
      endActiveConferenceMethodDescriptor =
          MethodDescriptor.<EndActiveConferenceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.apps.meet.v2.SpacesService/EndActiveConference")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EndActiveConferenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable;
  private final UnaryCallable<GetSpaceRequest, Space> getSpaceCallable;
  private final UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable;
  private final UnaryCallable<EndActiveConferenceRequest, Empty> endActiveConferenceCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSpacesServiceStub create(SpacesServiceStubSettings settings)
      throws IOException {
    return new GrpcSpacesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSpacesServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcSpacesServiceStub(SpacesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSpacesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSpacesServiceStub(
        SpacesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSpacesServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSpacesServiceStub(SpacesServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSpacesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSpacesServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSpacesServiceStub(
      SpacesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSpaceRequest, Space> createSpaceTransportSettings =
        GrpcCallSettings.<CreateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(createSpaceMethodDescriptor)
            .build();
    GrpcCallSettings<GetSpaceRequest, Space> getSpaceTransportSettings =
        GrpcCallSettings.<GetSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(getSpaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSpaceRequest, Space> updateSpaceTransportSettings =
        GrpcCallSettings.<UpdateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(updateSpaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("space.name", String.valueOf(request.getSpace().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EndActiveConferenceRequest, Empty> endActiveConferenceTransportSettings =
        GrpcCallSettings.<EndActiveConferenceRequest, Empty>newBuilder()
            .setMethodDescriptor(endActiveConferenceMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
