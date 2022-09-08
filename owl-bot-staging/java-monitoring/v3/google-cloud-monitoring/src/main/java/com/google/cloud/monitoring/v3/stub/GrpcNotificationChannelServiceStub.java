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

import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.monitoring.v3.CreateNotificationChannelRequest;
import com.google.monitoring.v3.DeleteNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelDescriptorRequest;
import com.google.monitoring.v3.GetNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse;
import com.google.monitoring.v3.ListNotificationChannelsRequest;
import com.google.monitoring.v3.ListNotificationChannelsResponse;
import com.google.monitoring.v3.NotificationChannel;
import com.google.monitoring.v3.NotificationChannelDescriptor;
import com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.UpdateNotificationChannelRequest;
import com.google.monitoring.v3.VerifyNotificationChannelRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the NotificationChannelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcNotificationChannelServiceStub extends NotificationChannelServiceStub {
  private static final MethodDescriptor<
          ListNotificationChannelDescriptorsRequest, ListNotificationChannelDescriptorsResponse>
      listNotificationChannelDescriptorsMethodDescriptor =
          MethodDescriptor
              .<ListNotificationChannelDescriptorsRequest,
                  ListNotificationChannelDescriptorsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.NotificationChannelService/ListNotificationChannelDescriptors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListNotificationChannelDescriptorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListNotificationChannelDescriptorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
      getNotificationChannelDescriptorMethodDescriptor =
          MethodDescriptor
              .<GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.NotificationChannelService/GetNotificationChannelDescriptor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetNotificationChannelDescriptorRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(NotificationChannelDescriptor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListNotificationChannelsRequest, ListNotificationChannelsResponse>
      listNotificationChannelsMethodDescriptor =
          MethodDescriptor
              .<ListNotificationChannelsRequest, ListNotificationChannelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.NotificationChannelService/ListNotificationChannels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNotificationChannelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNotificationChannelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNotificationChannelRequest, NotificationChannel>
      getNotificationChannelMethodDescriptor =
          MethodDescriptor.<GetNotificationChannelRequest, NotificationChannel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.NotificationChannelService/GetNotificationChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNotificationChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(NotificationChannel.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateNotificationChannelRequest, NotificationChannel>
      createNotificationChannelMethodDescriptor =
          MethodDescriptor.<CreateNotificationChannelRequest, NotificationChannel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.NotificationChannelService/CreateNotificationChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNotificationChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(NotificationChannel.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateNotificationChannelRequest, NotificationChannel>
      updateNotificationChannelMethodDescriptor =
          MethodDescriptor.<UpdateNotificationChannelRequest, NotificationChannel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.NotificationChannelService/UpdateNotificationChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNotificationChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(NotificationChannel.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNotificationChannelRequest, Empty>
      deleteNotificationChannelMethodDescriptor =
          MethodDescriptor.<DeleteNotificationChannelRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.NotificationChannelService/DeleteNotificationChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNotificationChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SendNotificationChannelVerificationCodeRequest, Empty>
      sendNotificationChannelVerificationCodeMethodDescriptor =
          MethodDescriptor.<SendNotificationChannelVerificationCodeRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.NotificationChannelService/SendNotificationChannelVerificationCode")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SendNotificationChannelVerificationCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetNotificationChannelVerificationCodeRequest,
          GetNotificationChannelVerificationCodeResponse>
      getNotificationChannelVerificationCodeMethodDescriptor =
          MethodDescriptor
              .<GetNotificationChannelVerificationCodeRequest,
                  GetNotificationChannelVerificationCodeResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.NotificationChannelService/GetNotificationChannelVerificationCode")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetNotificationChannelVerificationCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      GetNotificationChannelVerificationCodeResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<VerifyNotificationChannelRequest, NotificationChannel>
      verifyNotificationChannelMethodDescriptor =
          MethodDescriptor.<VerifyNotificationChannelRequest, NotificationChannel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.NotificationChannelService/VerifyNotificationChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(VerifyNotificationChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(NotificationChannel.getDefaultInstance()))
              .build();

  private final UnaryCallable<
          ListNotificationChannelDescriptorsRequest, ListNotificationChannelDescriptorsResponse>
      listNotificationChannelDescriptorsCallable;
  private final UnaryCallable<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsPagedResponse>
      listNotificationChannelDescriptorsPagedCallable;
  private final UnaryCallable<
          GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
      getNotificationChannelDescriptorCallable;
  private final UnaryCallable<ListNotificationChannelsRequest, ListNotificationChannelsResponse>
      listNotificationChannelsCallable;
  private final UnaryCallable<
          ListNotificationChannelsRequest, ListNotificationChannelsPagedResponse>
      listNotificationChannelsPagedCallable;
  private final UnaryCallable<GetNotificationChannelRequest, NotificationChannel>
      getNotificationChannelCallable;
  private final UnaryCallable<CreateNotificationChannelRequest, NotificationChannel>
      createNotificationChannelCallable;
  private final UnaryCallable<UpdateNotificationChannelRequest, NotificationChannel>
      updateNotificationChannelCallable;
  private final UnaryCallable<DeleteNotificationChannelRequest, Empty>
      deleteNotificationChannelCallable;
  private final UnaryCallable<SendNotificationChannelVerificationCodeRequest, Empty>
      sendNotificationChannelVerificationCodeCallable;
  private final UnaryCallable<
          GetNotificationChannelVerificationCodeRequest,
          GetNotificationChannelVerificationCodeResponse>
      getNotificationChannelVerificationCodeCallable;
  private final UnaryCallable<VerifyNotificationChannelRequest, NotificationChannel>
      verifyNotificationChannelCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcNotificationChannelServiceStub create(
      NotificationChannelServiceStubSettings settings) throws IOException {
    return new GrpcNotificationChannelServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNotificationChannelServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcNotificationChannelServiceStub(
        NotificationChannelServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNotificationChannelServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNotificationChannelServiceStub(
        NotificationChannelServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcNotificationChannelServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcNotificationChannelServiceStub(
      NotificationChannelServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcNotificationChannelServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNotificationChannelServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcNotificationChannelServiceStub(
      NotificationChannelServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            ListNotificationChannelDescriptorsRequest, ListNotificationChannelDescriptorsResponse>
        listNotificationChannelDescriptorsTransportSettings =
            GrpcCallSettings
                .<ListNotificationChannelDescriptorsRequest,
                    ListNotificationChannelDescriptorsResponse>
                    newBuilder()
                .setMethodDescriptor(listNotificationChannelDescriptorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
        getNotificationChannelDescriptorTransportSettings =
            GrpcCallSettings
                .<GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
                    newBuilder()
                .setMethodDescriptor(getNotificationChannelDescriptorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListNotificationChannelsRequest, ListNotificationChannelsResponse>
        listNotificationChannelsTransportSettings =
            GrpcCallSettings
                .<ListNotificationChannelsRequest, ListNotificationChannelsResponse>newBuilder()
                .setMethodDescriptor(listNotificationChannelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetNotificationChannelRequest, NotificationChannel>
        getNotificationChannelTransportSettings =
            GrpcCallSettings.<GetNotificationChannelRequest, NotificationChannel>newBuilder()
                .setMethodDescriptor(getNotificationChannelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateNotificationChannelRequest, NotificationChannel>
        createNotificationChannelTransportSettings =
            GrpcCallSettings.<CreateNotificationChannelRequest, NotificationChannel>newBuilder()
                .setMethodDescriptor(createNotificationChannelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateNotificationChannelRequest, NotificationChannel>
        updateNotificationChannelTransportSettings =
            GrpcCallSettings.<UpdateNotificationChannelRequest, NotificationChannel>newBuilder()
                .setMethodDescriptor(updateNotificationChannelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "notification_channel.name",
                          String.valueOf(request.getNotificationChannel().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteNotificationChannelRequest, Empty>
        deleteNotificationChannelTransportSettings =
            GrpcCallSettings.<DeleteNotificationChannelRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteNotificationChannelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SendNotificationChannelVerificationCodeRequest, Empty>
        sendNotificationChannelVerificationCodeTransportSettings =
            GrpcCallSettings.<SendNotificationChannelVerificationCodeRequest, Empty>newBuilder()
                .setMethodDescriptor(sendNotificationChannelVerificationCodeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<
            GetNotificationChannelVerificationCodeRequest,
            GetNotificationChannelVerificationCodeResponse>
        getNotificationChannelVerificationCodeTransportSettings =
            GrpcCallSettings
                .<GetNotificationChannelVerificationCodeRequest,
                    GetNotificationChannelVerificationCodeResponse>
                    newBuilder()
                .setMethodDescriptor(getNotificationChannelVerificationCodeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<VerifyNotificationChannelRequest, NotificationChannel>
        verifyNotificationChannelTransportSettings =
            GrpcCallSettings.<VerifyNotificationChannelRequest, NotificationChannel>newBuilder()
                .setMethodDescriptor(verifyNotificationChannelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.listNotificationChannelDescriptorsCallable =
        callableFactory.createUnaryCallable(
            listNotificationChannelDescriptorsTransportSettings,
            settings.listNotificationChannelDescriptorsSettings(),
            clientContext);
    this.listNotificationChannelDescriptorsPagedCallable =
        callableFactory.createPagedCallable(
            listNotificationChannelDescriptorsTransportSettings,
            settings.listNotificationChannelDescriptorsSettings(),
            clientContext);
    this.getNotificationChannelDescriptorCallable =
        callableFactory.createUnaryCallable(
            getNotificationChannelDescriptorTransportSettings,
            settings.getNotificationChannelDescriptorSettings(),
            clientContext);
    this.listNotificationChannelsCallable =
        callableFactory.createUnaryCallable(
            listNotificationChannelsTransportSettings,
            settings.listNotificationChannelsSettings(),
            clientContext);
    this.listNotificationChannelsPagedCallable =
        callableFactory.createPagedCallable(
            listNotificationChannelsTransportSettings,
            settings.listNotificationChannelsSettings(),
            clientContext);
    this.getNotificationChannelCallable =
        callableFactory.createUnaryCallable(
            getNotificationChannelTransportSettings,
            settings.getNotificationChannelSettings(),
            clientContext);
    this.createNotificationChannelCallable =
        callableFactory.createUnaryCallable(
            createNotificationChannelTransportSettings,
            settings.createNotificationChannelSettings(),
            clientContext);
    this.updateNotificationChannelCallable =
        callableFactory.createUnaryCallable(
            updateNotificationChannelTransportSettings,
            settings.updateNotificationChannelSettings(),
            clientContext);
    this.deleteNotificationChannelCallable =
        callableFactory.createUnaryCallable(
            deleteNotificationChannelTransportSettings,
            settings.deleteNotificationChannelSettings(),
            clientContext);
    this.sendNotificationChannelVerificationCodeCallable =
        callableFactory.createUnaryCallable(
            sendNotificationChannelVerificationCodeTransportSettings,
            settings.sendNotificationChannelVerificationCodeSettings(),
            clientContext);
    this.getNotificationChannelVerificationCodeCallable =
        callableFactory.createUnaryCallable(
            getNotificationChannelVerificationCodeTransportSettings,
            settings.getNotificationChannelVerificationCodeSettings(),
            clientContext);
    this.verifyNotificationChannelCallable =
        callableFactory.createUnaryCallable(
            verifyNotificationChannelTransportSettings,
            settings.verifyNotificationChannelSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<
          ListNotificationChannelDescriptorsRequest, ListNotificationChannelDescriptorsResponse>
      listNotificationChannelDescriptorsCallable() {
    return listNotificationChannelDescriptorsCallable;
  }

  @Override
  public UnaryCallable<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsPagedResponse>
      listNotificationChannelDescriptorsPagedCallable() {
    return listNotificationChannelDescriptorsPagedCallable;
  }

  @Override
  public UnaryCallable<GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
      getNotificationChannelDescriptorCallable() {
    return getNotificationChannelDescriptorCallable;
  }

  @Override
  public UnaryCallable<ListNotificationChannelsRequest, ListNotificationChannelsResponse>
      listNotificationChannelsCallable() {
    return listNotificationChannelsCallable;
  }

  @Override
  public UnaryCallable<ListNotificationChannelsRequest, ListNotificationChannelsPagedResponse>
      listNotificationChannelsPagedCallable() {
    return listNotificationChannelsPagedCallable;
  }

  @Override
  public UnaryCallable<GetNotificationChannelRequest, NotificationChannel>
      getNotificationChannelCallable() {
    return getNotificationChannelCallable;
  }

  @Override
  public UnaryCallable<CreateNotificationChannelRequest, NotificationChannel>
      createNotificationChannelCallable() {
    return createNotificationChannelCallable;
  }

  @Override
  public UnaryCallable<UpdateNotificationChannelRequest, NotificationChannel>
      updateNotificationChannelCallable() {
    return updateNotificationChannelCallable;
  }

  @Override
  public UnaryCallable<DeleteNotificationChannelRequest, Empty>
      deleteNotificationChannelCallable() {
    return deleteNotificationChannelCallable;
  }

  @Override
  public UnaryCallable<SendNotificationChannelVerificationCodeRequest, Empty>
      sendNotificationChannelVerificationCodeCallable() {
    return sendNotificationChannelVerificationCodeCallable;
  }

  @Override
  public UnaryCallable<
          GetNotificationChannelVerificationCodeRequest,
          GetNotificationChannelVerificationCodeResponse>
      getNotificationChannelVerificationCodeCallable() {
    return getNotificationChannelVerificationCodeCallable;
  }

  @Override
  public UnaryCallable<VerifyNotificationChannelRequest, NotificationChannel>
      verifyNotificationChannelCallable() {
    return verifyNotificationChannelCallable;
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
