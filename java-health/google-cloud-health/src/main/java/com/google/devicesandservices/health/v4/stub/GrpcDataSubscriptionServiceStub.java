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

package com.google.devicesandservices.health.v4.stub;

import static com.google.devicesandservices.health.v4.DataSubscriptionServiceClient.ListSubscribersPagedResponse;
import static com.google.devicesandservices.health.v4.DataSubscriptionServiceClient.ListSubscriptionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devicesandservices.health.v4.CreateSubscriberMetadata;
import com.google.devicesandservices.health.v4.CreateSubscriberRequest;
import com.google.devicesandservices.health.v4.CreateSubscriptionRequest;
import com.google.devicesandservices.health.v4.DeleteSubscriberMetadata;
import com.google.devicesandservices.health.v4.DeleteSubscriberRequest;
import com.google.devicesandservices.health.v4.DeleteSubscriptionRequest;
import com.google.devicesandservices.health.v4.ListSubscribersRequest;
import com.google.devicesandservices.health.v4.ListSubscribersResponse;
import com.google.devicesandservices.health.v4.ListSubscriptionsRequest;
import com.google.devicesandservices.health.v4.ListSubscriptionsResponse;
import com.google.devicesandservices.health.v4.Subscriber;
import com.google.devicesandservices.health.v4.Subscription;
import com.google.devicesandservices.health.v4.UpdateSubscriberMetadata;
import com.google.devicesandservices.health.v4.UpdateSubscriberRequest;
import com.google.devicesandservices.health.v4.UpdateSubscriptionRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataSubscriptionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataSubscriptionServiceStub extends DataSubscriptionServiceStub {
  private static final MethodDescriptor<CreateSubscriberRequest, Operation>
      createSubscriberMethodDescriptor =
          MethodDescriptor.<CreateSubscriberRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/CreateSubscriber")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSubscriberRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListSubscribersRequest, ListSubscribersResponse>
      listSubscribersMethodDescriptor =
          MethodDescriptor.<ListSubscribersRequest, ListSubscribersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/ListSubscribers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSubscribersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSubscribersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateSubscriberRequest, Operation>
      updateSubscriberMethodDescriptor =
          MethodDescriptor.<UpdateSubscriberRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/UpdateSubscriber")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSubscriberRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSubscriberRequest, Operation>
      deleteSubscriberMethodDescriptor =
          MethodDescriptor.<DeleteSubscriberRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/DeleteSubscriber")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSubscriberRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateSubscriptionRequest, Subscription>
      createSubscriptionMethodDescriptor =
          MethodDescriptor.<CreateSubscriptionRequest, Subscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/CreateSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Subscription.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsMethodDescriptor =
          MethodDescriptor.<ListSubscriptionsRequest, ListSubscriptionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/ListSubscriptions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSubscriptionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateSubscriptionRequest, Subscription>
      updateSubscriptionMethodDescriptor =
          MethodDescriptor.<UpdateSubscriptionRequest, Subscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/UpdateSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Subscription.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSubscriptionRequest, Empty>
      deleteSubscriptionMethodDescriptor =
          MethodDescriptor.<DeleteSubscriptionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/DeleteSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateSubscriberRequest, Operation> createSubscriberCallable;
  private final OperationCallable<CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
      createSubscriberOperationCallable;
  private final UnaryCallable<ListSubscribersRequest, ListSubscribersResponse>
      listSubscribersCallable;
  private final UnaryCallable<ListSubscribersRequest, ListSubscribersPagedResponse>
      listSubscribersPagedCallable;
  private final UnaryCallable<UpdateSubscriberRequest, Operation> updateSubscriberCallable;
  private final OperationCallable<UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
      updateSubscriberOperationCallable;
  private final UnaryCallable<DeleteSubscriberRequest, Operation> deleteSubscriberCallable;
  private final OperationCallable<DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
      deleteSubscriberOperationCallable;
  private final UnaryCallable<CreateSubscriptionRequest, Subscription> createSubscriptionCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable;
  private final UnaryCallable<UpdateSubscriptionRequest, Subscription> updateSubscriptionCallable;
  private final UnaryCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataSubscriptionServiceStub create(
      DataSubscriptionServiceStubSettings settings) throws IOException {
    return new GrpcDataSubscriptionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataSubscriptionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataSubscriptionServiceStub(
        DataSubscriptionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataSubscriptionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataSubscriptionServiceStub(
        DataSubscriptionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataSubscriptionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataSubscriptionServiceStub(
      DataSubscriptionServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDataSubscriptionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataSubscriptionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataSubscriptionServiceStub(
      DataSubscriptionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSubscriberRequest, Operation> createSubscriberTransportSettings =
        GrpcCallSettings.<CreateSubscriberRequest, Operation>newBuilder()
            .setMethodDescriptor(createSubscriberMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<ListSubscribersRequest, ListSubscribersResponse>
        listSubscribersTransportSettings =
            GrpcCallSettings.<ListSubscribersRequest, ListSubscribersResponse>newBuilder()
                .setMethodDescriptor(listSubscribersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateSubscriberRequest, Operation> updateSubscriberTransportSettings =
        GrpcCallSettings.<UpdateSubscriberRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSubscriberMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subscriber.name", String.valueOf(request.getSubscriber().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSubscriberRequest, Operation> deleteSubscriberTransportSettings =
        GrpcCallSettings.<DeleteSubscriberRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSubscriberMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateSubscriptionRequest, Subscription> createSubscriptionTransportSettings =
        GrpcCallSettings.<CreateSubscriptionRequest, Subscription>newBuilder()
            .setMethodDescriptor(createSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<ListSubscriptionsRequest, ListSubscriptionsResponse>
        listSubscriptionsTransportSettings =
            GrpcCallSettings.<ListSubscriptionsRequest, ListSubscriptionsResponse>newBuilder()
                .setMethodDescriptor(listSubscriptionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateSubscriptionRequest, Subscription> updateSubscriptionTransportSettings =
        GrpcCallSettings.<UpdateSubscriptionRequest, Subscription>newBuilder()
            .setMethodDescriptor(updateSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "subscription.name", String.valueOf(request.getSubscription().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionTransportSettings =
        GrpcCallSettings.<DeleteSubscriptionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();

    this.createSubscriberCallable =
        callableFactory.createUnaryCallable(
            createSubscriberTransportSettings, settings.createSubscriberSettings(), clientContext);
    this.createSubscriberOperationCallable =
        callableFactory.createOperationCallable(
            createSubscriberTransportSettings,
            settings.createSubscriberOperationSettings(),
            clientContext,
            operationsStub);
    this.listSubscribersCallable =
        callableFactory.createUnaryCallable(
            listSubscribersTransportSettings, settings.listSubscribersSettings(), clientContext);
    this.listSubscribersPagedCallable =
        callableFactory.createPagedCallable(
            listSubscribersTransportSettings, settings.listSubscribersSettings(), clientContext);
    this.updateSubscriberCallable =
        callableFactory.createUnaryCallable(
            updateSubscriberTransportSettings, settings.updateSubscriberSettings(), clientContext);
    this.updateSubscriberOperationCallable =
        callableFactory.createOperationCallable(
            updateSubscriberTransportSettings,
            settings.updateSubscriberOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSubscriberCallable =
        callableFactory.createUnaryCallable(
            deleteSubscriberTransportSettings, settings.deleteSubscriberSettings(), clientContext);
    this.deleteSubscriberOperationCallable =
        callableFactory.createOperationCallable(
            deleteSubscriberTransportSettings,
            settings.deleteSubscriberOperationSettings(),
            clientContext,
            operationsStub);
    this.createSubscriptionCallable =
        callableFactory.createUnaryCallable(
            createSubscriptionTransportSettings,
            settings.createSubscriptionSettings(),
            clientContext);
    this.listSubscriptionsCallable =
        callableFactory.createUnaryCallable(
            listSubscriptionsTransportSettings,
            settings.listSubscriptionsSettings(),
            clientContext);
    this.listSubscriptionsPagedCallable =
        callableFactory.createPagedCallable(
            listSubscriptionsTransportSettings,
            settings.listSubscriptionsSettings(),
            clientContext);
    this.updateSubscriptionCallable =
        callableFactory.createUnaryCallable(
            updateSubscriptionTransportSettings,
            settings.updateSubscriptionSettings(),
            clientContext);
    this.deleteSubscriptionCallable =
        callableFactory.createUnaryCallable(
            deleteSubscriptionTransportSettings,
            settings.deleteSubscriptionSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateSubscriberRequest, Operation> createSubscriberCallable() {
    return createSubscriberCallable;
  }

  @Override
  public OperationCallable<CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
      createSubscriberOperationCallable() {
    return createSubscriberOperationCallable;
  }

  @Override
  public UnaryCallable<ListSubscribersRequest, ListSubscribersResponse> listSubscribersCallable() {
    return listSubscribersCallable;
  }

  @Override
  public UnaryCallable<ListSubscribersRequest, ListSubscribersPagedResponse>
      listSubscribersPagedCallable() {
    return listSubscribersPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateSubscriberRequest, Operation> updateSubscriberCallable() {
    return updateSubscriberCallable;
  }

  @Override
  public OperationCallable<UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
      updateSubscriberOperationCallable() {
    return updateSubscriberOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSubscriberRequest, Operation> deleteSubscriberCallable() {
    return deleteSubscriberCallable;
  }

  @Override
  public OperationCallable<DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
      deleteSubscriberOperationCallable() {
    return deleteSubscriberOperationCallable;
  }

  @Override
  public UnaryCallable<CreateSubscriptionRequest, Subscription> createSubscriptionCallable() {
    return createSubscriptionCallable;
  }

  @Override
  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    return listSubscriptionsCallable;
  }

  @Override
  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    return listSubscriptionsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateSubscriptionRequest, Subscription> updateSubscriptionCallable() {
    return updateSubscriptionCallable;
  }

  @Override
  public UnaryCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable() {
    return deleteSubscriptionCallable;
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
