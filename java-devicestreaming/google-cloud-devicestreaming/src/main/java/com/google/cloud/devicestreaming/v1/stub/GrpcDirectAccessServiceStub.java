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

package com.google.cloud.devicestreaming.v1.stub;

import static com.google.cloud.devicestreaming.v1.DirectAccessServiceClient.ListDeviceSessionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.devicestreaming.v1.AdbMessage;
import com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest;
import com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest;
import com.google.cloud.devicestreaming.v1.DeviceMessage;
import com.google.cloud.devicestreaming.v1.DeviceSession;
import com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest;
import com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest;
import com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse;
import com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DirectAccessService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDirectAccessServiceStub extends DirectAccessServiceStub {
  private static final MethodDescriptor<CreateDeviceSessionRequest, DeviceSession>
      createDeviceSessionMethodDescriptor =
          MethodDescriptor.<CreateDeviceSessionRequest, DeviceSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.devicestreaming.v1.DirectAccessService/CreateDeviceSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDeviceSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeviceSession.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDeviceSessionsRequest, ListDeviceSessionsResponse>
      listDeviceSessionsMethodDescriptor =
          MethodDescriptor.<ListDeviceSessionsRequest, ListDeviceSessionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.devicestreaming.v1.DirectAccessService/ListDeviceSessions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeviceSessionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeviceSessionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDeviceSessionRequest, DeviceSession>
      getDeviceSessionMethodDescriptor =
          MethodDescriptor.<GetDeviceSessionRequest, DeviceSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.devicestreaming.v1.DirectAccessService/GetDeviceSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDeviceSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeviceSession.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelDeviceSessionRequest, Empty>
      cancelDeviceSessionMethodDescriptor =
          MethodDescriptor.<CancelDeviceSessionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.devicestreaming.v1.DirectAccessService/CancelDeviceSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelDeviceSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDeviceSessionRequest, DeviceSession>
      updateDeviceSessionMethodDescriptor =
          MethodDescriptor.<UpdateDeviceSessionRequest, DeviceSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.devicestreaming.v1.DirectAccessService/UpdateDeviceSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDeviceSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeviceSession.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AdbMessage, DeviceMessage> adbConnectMethodDescriptor =
      MethodDescriptor.<AdbMessage, DeviceMessage>newBuilder()
          .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName("google.cloud.devicestreaming.v1.DirectAccessService/AdbConnect")
          .setRequestMarshaller(ProtoUtils.marshaller(AdbMessage.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(DeviceMessage.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateDeviceSessionRequest, DeviceSession>
      createDeviceSessionCallable;
  private final UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsResponse>
      listDeviceSessionsCallable;
  private final UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsPagedResponse>
      listDeviceSessionsPagedCallable;
  private final UnaryCallable<GetDeviceSessionRequest, DeviceSession> getDeviceSessionCallable;
  private final UnaryCallable<CancelDeviceSessionRequest, Empty> cancelDeviceSessionCallable;
  private final UnaryCallable<UpdateDeviceSessionRequest, DeviceSession>
      updateDeviceSessionCallable;
  private final BidiStreamingCallable<AdbMessage, DeviceMessage> adbConnectCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDirectAccessServiceStub create(DirectAccessServiceStubSettings settings)
      throws IOException {
    return new GrpcDirectAccessServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDirectAccessServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDirectAccessServiceStub(
        DirectAccessServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDirectAccessServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDirectAccessServiceStub(
        DirectAccessServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDirectAccessServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDirectAccessServiceStub(
      DirectAccessServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDirectAccessServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDirectAccessServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDirectAccessServiceStub(
      DirectAccessServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDeviceSessionRequest, DeviceSession>
        createDeviceSessionTransportSettings =
            GrpcCallSettings.<CreateDeviceSessionRequest, DeviceSession>newBuilder()
                .setMethodDescriptor(createDeviceSessionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDeviceSessionsRequest, ListDeviceSessionsResponse>
        listDeviceSessionsTransportSettings =
            GrpcCallSettings.<ListDeviceSessionsRequest, ListDeviceSessionsResponse>newBuilder()
                .setMethodDescriptor(listDeviceSessionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDeviceSessionRequest, DeviceSession> getDeviceSessionTransportSettings =
        GrpcCallSettings.<GetDeviceSessionRequest, DeviceSession>newBuilder()
            .setMethodDescriptor(getDeviceSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CancelDeviceSessionRequest, Empty> cancelDeviceSessionTransportSettings =
        GrpcCallSettings.<CancelDeviceSessionRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelDeviceSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDeviceSessionRequest, DeviceSession>
        updateDeviceSessionTransportSettings =
            GrpcCallSettings.<UpdateDeviceSessionRequest, DeviceSession>newBuilder()
                .setMethodDescriptor(updateDeviceSessionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "device_session.name",
                          String.valueOf(request.getDeviceSession().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AdbMessage, DeviceMessage> adbConnectTransportSettings =
        GrpcCallSettings.<AdbMessage, DeviceMessage>newBuilder()
            .setMethodDescriptor(adbConnectMethodDescriptor)
            .build();

    this.createDeviceSessionCallable =
        callableFactory.createUnaryCallable(
            createDeviceSessionTransportSettings,
            settings.createDeviceSessionSettings(),
            clientContext);
    this.listDeviceSessionsCallable =
        callableFactory.createUnaryCallable(
            listDeviceSessionsTransportSettings,
            settings.listDeviceSessionsSettings(),
            clientContext);
    this.listDeviceSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listDeviceSessionsTransportSettings,
            settings.listDeviceSessionsSettings(),
            clientContext);
    this.getDeviceSessionCallable =
        callableFactory.createUnaryCallable(
            getDeviceSessionTransportSettings, settings.getDeviceSessionSettings(), clientContext);
    this.cancelDeviceSessionCallable =
        callableFactory.createUnaryCallable(
            cancelDeviceSessionTransportSettings,
            settings.cancelDeviceSessionSettings(),
            clientContext);
    this.updateDeviceSessionCallable =
        callableFactory.createUnaryCallable(
            updateDeviceSessionTransportSettings,
            settings.updateDeviceSessionSettings(),
            clientContext);
    this.adbConnectCallable =
        callableFactory.createBidiStreamingCallable(
            adbConnectTransportSettings, settings.adbConnectSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateDeviceSessionRequest, DeviceSession> createDeviceSessionCallable() {
    return createDeviceSessionCallable;
  }

  @Override
  public UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsResponse>
      listDeviceSessionsCallable() {
    return listDeviceSessionsCallable;
  }

  @Override
  public UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsPagedResponse>
      listDeviceSessionsPagedCallable() {
    return listDeviceSessionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDeviceSessionRequest, DeviceSession> getDeviceSessionCallable() {
    return getDeviceSessionCallable;
  }

  @Override
  public UnaryCallable<CancelDeviceSessionRequest, Empty> cancelDeviceSessionCallable() {
    return cancelDeviceSessionCallable;
  }

  @Override
  public UnaryCallable<UpdateDeviceSessionRequest, DeviceSession> updateDeviceSessionCallable() {
    return updateDeviceSessionCallable;
  }

  @Override
  public BidiStreamingCallable<AdbMessage, DeviceMessage> adbConnectCallable() {
    return adbConnectCallable;
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
