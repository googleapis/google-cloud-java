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

package com.google.cloud.retail.v2.stub;

import static com.google.cloud.retail.v2.ControlServiceClient.ListControlsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.Control;
import com.google.cloud.retail.v2.CreateControlRequest;
import com.google.cloud.retail.v2.DeleteControlRequest;
import com.google.cloud.retail.v2.GetControlRequest;
import com.google.cloud.retail.v2.ListControlsRequest;
import com.google.cloud.retail.v2.ListControlsResponse;
import com.google.cloud.retail.v2.UpdateControlRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ControlService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcControlServiceStub extends ControlServiceStub {
  private static final MethodDescriptor<CreateControlRequest, Control>
      createControlMethodDescriptor =
          MethodDescriptor.<CreateControlRequest, Control>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ControlService/CreateControl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateControlRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Control.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteControlRequest, Empty> deleteControlMethodDescriptor =
      MethodDescriptor.<DeleteControlRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.retail.v2.ControlService/DeleteControl")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteControlRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateControlRequest, Control>
      updateControlMethodDescriptor =
          MethodDescriptor.<UpdateControlRequest, Control>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ControlService/UpdateControl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateControlRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Control.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetControlRequest, Control> getControlMethodDescriptor =
      MethodDescriptor.<GetControlRequest, Control>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.retail.v2.ControlService/GetControl")
          .setRequestMarshaller(ProtoUtils.marshaller(GetControlRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Control.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListControlsRequest, ListControlsResponse>
      listControlsMethodDescriptor =
          MethodDescriptor.<ListControlsRequest, ListControlsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ControlService/ListControls")
              .setRequestMarshaller(ProtoUtils.marshaller(ListControlsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListControlsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateControlRequest, Control> createControlCallable;
  private final UnaryCallable<DeleteControlRequest, Empty> deleteControlCallable;
  private final UnaryCallable<UpdateControlRequest, Control> updateControlCallable;
  private final UnaryCallable<GetControlRequest, Control> getControlCallable;
  private final UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable;
  private final UnaryCallable<ListControlsRequest, ListControlsPagedResponse>
      listControlsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcControlServiceStub create(ControlServiceStubSettings settings)
      throws IOException {
    return new GrpcControlServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcControlServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcControlServiceStub(
        ControlServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcControlServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcControlServiceStub(
        ControlServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcControlServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcControlServiceStub(ControlServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcControlServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcControlServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcControlServiceStub(
      ControlServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateControlRequest, Control> createControlTransportSettings =
        GrpcCallSettings.<CreateControlRequest, Control>newBuilder()
            .setMethodDescriptor(createControlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteControlRequest, Empty> deleteControlTransportSettings =
        GrpcCallSettings.<DeleteControlRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteControlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateControlRequest, Control> updateControlTransportSettings =
        GrpcCallSettings.<UpdateControlRequest, Control>newBuilder()
            .setMethodDescriptor(updateControlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("control.name", String.valueOf(request.getControl().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetControlRequest, Control> getControlTransportSettings =
        GrpcCallSettings.<GetControlRequest, Control>newBuilder()
            .setMethodDescriptor(getControlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListControlsRequest, ListControlsResponse> listControlsTransportSettings =
        GrpcCallSettings.<ListControlsRequest, ListControlsResponse>newBuilder()
            .setMethodDescriptor(listControlsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();

    this.createControlCallable =
        callableFactory.createUnaryCallable(
            createControlTransportSettings, settings.createControlSettings(), clientContext);
    this.deleteControlCallable =
        callableFactory.createUnaryCallable(
            deleteControlTransportSettings, settings.deleteControlSettings(), clientContext);
    this.updateControlCallable =
        callableFactory.createUnaryCallable(
            updateControlTransportSettings, settings.updateControlSettings(), clientContext);
    this.getControlCallable =
        callableFactory.createUnaryCallable(
            getControlTransportSettings, settings.getControlSettings(), clientContext);
    this.listControlsCallable =
        callableFactory.createUnaryCallable(
            listControlsTransportSettings, settings.listControlsSettings(), clientContext);
    this.listControlsPagedCallable =
        callableFactory.createPagedCallable(
            listControlsTransportSettings, settings.listControlsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateControlRequest, Control> createControlCallable() {
    return createControlCallable;
  }

  @Override
  public UnaryCallable<DeleteControlRequest, Empty> deleteControlCallable() {
    return deleteControlCallable;
  }

  @Override
  public UnaryCallable<UpdateControlRequest, Control> updateControlCallable() {
    return updateControlCallable;
  }

  @Override
  public UnaryCallable<GetControlRequest, Control> getControlCallable() {
    return getControlCallable;
  }

  @Override
  public UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable() {
    return listControlsCallable;
  }

  @Override
  public UnaryCallable<ListControlsRequest, ListControlsPagedResponse> listControlsPagedCallable() {
    return listControlsPagedCallable;
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
