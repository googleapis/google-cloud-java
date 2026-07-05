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

package com.google.cloud.support.v2.stub;

import static com.google.cloud.support.v2.SupportEventSubscriptionServiceClient.ListSupportEventSubscriptionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2.CreateSupportEventSubscriptionRequest;
import com.google.cloud.support.v2.DeleteSupportEventSubscriptionRequest;
import com.google.cloud.support.v2.GetSupportEventSubscriptionRequest;
import com.google.cloud.support.v2.ListSupportEventSubscriptionsRequest;
import com.google.cloud.support.v2.ListSupportEventSubscriptionsResponse;
import com.google.cloud.support.v2.SupportEventSubscription;
import com.google.cloud.support.v2.UndeleteSupportEventSubscriptionRequest;
import com.google.cloud.support.v2.UpdateSupportEventSubscriptionRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SupportEventSubscriptionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSupportEventSubscriptionServiceStub extends SupportEventSubscriptionServiceStub {
  private static final MethodDescriptor<
          CreateSupportEventSubscriptionRequest, SupportEventSubscription>
      createSupportEventSubscriptionMethodDescriptor =
          MethodDescriptor
              .<CreateSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.support.v2.SupportEventSubscriptionService/CreateSupportEventSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSupportEventSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SupportEventSubscription.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetSupportEventSubscriptionRequest, SupportEventSubscription>
      getSupportEventSubscriptionMethodDescriptor =
          MethodDescriptor
              .<GetSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.support.v2.SupportEventSubscriptionService/GetSupportEventSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSupportEventSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SupportEventSubscription.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
      listSupportEventSubscriptionsMethodDescriptor =
          MethodDescriptor
              .<ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.support.v2.SupportEventSubscriptionService/ListSupportEventSubscriptions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSupportEventSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSupportEventSubscriptionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
      updateSupportEventSubscriptionMethodDescriptor =
          MethodDescriptor
              .<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.support.v2.SupportEventSubscriptionService/UpdateSupportEventSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSupportEventSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SupportEventSubscription.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      deleteSupportEventSubscriptionMethodDescriptor =
          MethodDescriptor
              .<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.support.v2.SupportEventSubscriptionService/DeleteSupportEventSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSupportEventSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SupportEventSubscription.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      undeleteSupportEventSubscriptionMethodDescriptor =
          MethodDescriptor
              .<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.support.v2.SupportEventSubscriptionService/UndeleteSupportEventSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UndeleteSupportEventSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SupportEventSubscription.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateSupportEventSubscriptionRequest, SupportEventSubscription>
      createSupportEventSubscriptionCallable;
  private final UnaryCallable<GetSupportEventSubscriptionRequest, SupportEventSubscription>
      getSupportEventSubscriptionCallable;
  private final UnaryCallable<
          ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
      listSupportEventSubscriptionsCallable;
  private final UnaryCallable<
          ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsPagedResponse>
      listSupportEventSubscriptionsPagedCallable;
  private final UnaryCallable<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
      updateSupportEventSubscriptionCallable;
  private final UnaryCallable<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      deleteSupportEventSubscriptionCallable;
  private final UnaryCallable<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      undeleteSupportEventSubscriptionCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSupportEventSubscriptionServiceStub create(
      SupportEventSubscriptionServiceStubSettings settings) throws IOException {
    return new GrpcSupportEventSubscriptionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSupportEventSubscriptionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSupportEventSubscriptionServiceStub(
        SupportEventSubscriptionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSupportEventSubscriptionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSupportEventSubscriptionServiceStub(
        SupportEventSubscriptionServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcSupportEventSubscriptionServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcSupportEventSubscriptionServiceStub(
      SupportEventSubscriptionServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSupportEventSubscriptionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSupportEventSubscriptionServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcSupportEventSubscriptionServiceStub(
      SupportEventSubscriptionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSupportEventSubscriptionRequest, SupportEventSubscription>
        createSupportEventSubscriptionTransportSettings =
            GrpcCallSettings
                .<CreateSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
                .setMethodDescriptor(createSupportEventSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetSupportEventSubscriptionRequest, SupportEventSubscription>
        getSupportEventSubscriptionTransportSettings =
            GrpcCallSettings
                .<GetSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
                .setMethodDescriptor(getSupportEventSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
        listSupportEventSubscriptionsTransportSettings =
            GrpcCallSettings
                .<ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
                    newBuilder()
                .setMethodDescriptor(listSupportEventSubscriptionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
        updateSupportEventSubscriptionTransportSettings =
            GrpcCallSettings
                .<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
                .setMethodDescriptor(updateSupportEventSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "support_event_subscription.name",
                          String.valueOf(request.getSupportEventSubscription().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
        deleteSupportEventSubscriptionTransportSettings =
            GrpcCallSettings
                .<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
                .setMethodDescriptor(deleteSupportEventSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
        undeleteSupportEventSubscriptionTransportSettings =
            GrpcCallSettings
                .<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
                .setMethodDescriptor(undeleteSupportEventSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.createSupportEventSubscriptionCallable =
        callableFactory.createUnaryCallable(
            createSupportEventSubscriptionTransportSettings,
            settings.createSupportEventSubscriptionSettings(),
            clientContext);
    this.getSupportEventSubscriptionCallable =
        callableFactory.createUnaryCallable(
            getSupportEventSubscriptionTransportSettings,
            settings.getSupportEventSubscriptionSettings(),
            clientContext);
    this.listSupportEventSubscriptionsCallable =
        callableFactory.createUnaryCallable(
            listSupportEventSubscriptionsTransportSettings,
            settings.listSupportEventSubscriptionsSettings(),
            clientContext);
    this.listSupportEventSubscriptionsPagedCallable =
        callableFactory.createPagedCallable(
            listSupportEventSubscriptionsTransportSettings,
            settings.listSupportEventSubscriptionsSettings(),
            clientContext);
    this.updateSupportEventSubscriptionCallable =
        callableFactory.createUnaryCallable(
            updateSupportEventSubscriptionTransportSettings,
            settings.updateSupportEventSubscriptionSettings(),
            clientContext);
    this.deleteSupportEventSubscriptionCallable =
        callableFactory.createUnaryCallable(
            deleteSupportEventSubscriptionTransportSettings,
            settings.deleteSupportEventSubscriptionSettings(),
            clientContext);
    this.undeleteSupportEventSubscriptionCallable =
        callableFactory.createUnaryCallable(
            undeleteSupportEventSubscriptionTransportSettings,
            settings.undeleteSupportEventSubscriptionSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateSupportEventSubscriptionRequest, SupportEventSubscription>
      createSupportEventSubscriptionCallable() {
    return createSupportEventSubscriptionCallable;
  }

  @Override
  public UnaryCallable<GetSupportEventSubscriptionRequest, SupportEventSubscription>
      getSupportEventSubscriptionCallable() {
    return getSupportEventSubscriptionCallable;
  }

  @Override
  public UnaryCallable<ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
      listSupportEventSubscriptionsCallable() {
    return listSupportEventSubscriptionsCallable;
  }

  @Override
  public UnaryCallable<
          ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsPagedResponse>
      listSupportEventSubscriptionsPagedCallable() {
    return listSupportEventSubscriptionsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
      updateSupportEventSubscriptionCallable() {
    return updateSupportEventSubscriptionCallable;
  }

  @Override
  public UnaryCallable<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      deleteSupportEventSubscriptionCallable() {
    return deleteSupportEventSubscriptionCallable;
  }

  @Override
  public UnaryCallable<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      undeleteSupportEventSubscriptionCallable() {
    return undeleteSupportEventSubscriptionCallable;
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
