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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.SnoozeServiceClient.ListSnoozesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.monitoring.v3.CreateSnoozeRequest;
import com.google.monitoring.v3.GetSnoozeRequest;
import com.google.monitoring.v3.ListSnoozesRequest;
import com.google.monitoring.v3.ListSnoozesResponse;
import com.google.monitoring.v3.Snooze;
import com.google.monitoring.v3.UpdateSnoozeRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SnoozeService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSnoozeServiceStub extends SnoozeServiceStub {
  private static final MethodDescriptor<CreateSnoozeRequest, Snooze> createSnoozeMethodDescriptor =
      MethodDescriptor.<CreateSnoozeRequest, Snooze>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.monitoring.v3.SnoozeService/CreateSnooze")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSnoozeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Snooze.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSnoozesRequest, ListSnoozesResponse>
      listSnoozesMethodDescriptor =
          MethodDescriptor.<ListSnoozesRequest, ListSnoozesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.SnoozeService/ListSnoozes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSnoozesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSnoozesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSnoozeRequest, Snooze> getSnoozeMethodDescriptor =
      MethodDescriptor.<GetSnoozeRequest, Snooze>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.monitoring.v3.SnoozeService/GetSnooze")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSnoozeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Snooze.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSnoozeRequest, Snooze> updateSnoozeMethodDescriptor =
      MethodDescriptor.<UpdateSnoozeRequest, Snooze>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.monitoring.v3.SnoozeService/UpdateSnooze")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSnoozeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Snooze.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateSnoozeRequest, Snooze> createSnoozeCallable;
  private final UnaryCallable<ListSnoozesRequest, ListSnoozesResponse> listSnoozesCallable;
  private final UnaryCallable<ListSnoozesRequest, ListSnoozesPagedResponse>
      listSnoozesPagedCallable;
  private final UnaryCallable<GetSnoozeRequest, Snooze> getSnoozeCallable;
  private final UnaryCallable<UpdateSnoozeRequest, Snooze> updateSnoozeCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSnoozeServiceStub create(SnoozeServiceStubSettings settings)
      throws IOException {
    return new GrpcSnoozeServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSnoozeServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcSnoozeServiceStub(SnoozeServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSnoozeServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSnoozeServiceStub(
        SnoozeServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSnoozeServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSnoozeServiceStub(SnoozeServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSnoozeServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSnoozeServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSnoozeServiceStub(
      SnoozeServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSnoozeRequest, Snooze> createSnoozeTransportSettings =
        GrpcCallSettings.<CreateSnoozeRequest, Snooze>newBuilder()
            .setMethodDescriptor(createSnoozeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListSnoozesRequest, ListSnoozesResponse> listSnoozesTransportSettings =
        GrpcCallSettings.<ListSnoozesRequest, ListSnoozesResponse>newBuilder()
            .setMethodDescriptor(listSnoozesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetSnoozeRequest, Snooze> getSnoozeTransportSettings =
        GrpcCallSettings.<GetSnoozeRequest, Snooze>newBuilder()
            .setMethodDescriptor(getSnoozeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateSnoozeRequest, Snooze> updateSnoozeTransportSettings =
        GrpcCallSettings.<UpdateSnoozeRequest, Snooze>newBuilder()
            .setMethodDescriptor(updateSnoozeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("snooze.name", String.valueOf(request.getSnooze().getName()));
                  return params.build();
                })
            .build();

    this.createSnoozeCallable =
        callableFactory.createUnaryCallable(
            createSnoozeTransportSettings, settings.createSnoozeSettings(), clientContext);
    this.listSnoozesCallable =
        callableFactory.createUnaryCallable(
            listSnoozesTransportSettings, settings.listSnoozesSettings(), clientContext);
    this.listSnoozesPagedCallable =
        callableFactory.createPagedCallable(
            listSnoozesTransportSettings, settings.listSnoozesSettings(), clientContext);
    this.getSnoozeCallable =
        callableFactory.createUnaryCallable(
            getSnoozeTransportSettings, settings.getSnoozeSettings(), clientContext);
    this.updateSnoozeCallable =
        callableFactory.createUnaryCallable(
            updateSnoozeTransportSettings, settings.updateSnoozeSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateSnoozeRequest, Snooze> createSnoozeCallable() {
    return createSnoozeCallable;
  }

  @Override
  public UnaryCallable<ListSnoozesRequest, ListSnoozesResponse> listSnoozesCallable() {
    return listSnoozesCallable;
  }

  @Override
  public UnaryCallable<ListSnoozesRequest, ListSnoozesPagedResponse> listSnoozesPagedCallable() {
    return listSnoozesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSnoozeRequest, Snooze> getSnoozeCallable() {
    return getSnoozeCallable;
  }

  @Override
  public UnaryCallable<UpdateSnoozeRequest, Snooze> updateSnoozeCallable() {
    return updateSnoozeCallable;
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
