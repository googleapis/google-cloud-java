/*
 * Copyright 2024 Google LLC
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

package com.google.apps.events.subscriptions.v1.stub;

import static com.google.apps.events.subscriptions.v1.SubscriptionsServiceClient.ListSubscriptionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.events.subscriptions.v1.CreateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.DeleteSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.GetSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest;
import com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse;
import com.google.apps.events.subscriptions.v1.ReactivateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.Subscription;
import com.google.apps.events.subscriptions.v1.UpdateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest;
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
 * gRPC stub implementation for the SubscriptionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSubscriptionsServiceStub extends SubscriptionsServiceStub {
  private static final MethodDescriptor<CreateSubscriptionRequest, Operation>
      createSubscriptionMethodDescriptor =
          MethodDescriptor.<CreateSubscriptionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/CreateSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSubscriptionRequest, Operation>
      deleteSubscriptionMethodDescriptor =
          MethodDescriptor.<DeleteSubscriptionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/DeleteSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSubscriptionRequest, Subscription>
      getSubscriptionMethodDescriptor =
          MethodDescriptor.<GetSubscriptionRequest, Subscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/GetSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Subscription.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsMethodDescriptor =
          MethodDescriptor.<ListSubscriptionsRequest, ListSubscriptionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/ListSubscriptions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSubscriptionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSubscriptionRequest, Operation>
      updateSubscriptionMethodDescriptor =
          MethodDescriptor.<UpdateSubscriptionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/UpdateSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReactivateSubscriptionRequest, Operation>
      reactivateSubscriptionMethodDescriptor =
          MethodDescriptor.<ReactivateSubscriptionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/ReactivateSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReactivateSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateSubscriptionRequest, Operation> createSubscriptionCallable;
  private final OperationCallable<
          CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
      createSubscriptionOperationCallable;
  private final UnaryCallable<DeleteSubscriptionRequest, Operation> deleteSubscriptionCallable;
  private final OperationCallable<DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
      deleteSubscriptionOperationCallable;
  private final UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable;
  private final UnaryCallable<UpdateSubscriptionRequest, Operation> updateSubscriptionCallable;
  private final OperationCallable<
          UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
      updateSubscriptionOperationCallable;
  private final UnaryCallable<ReactivateSubscriptionRequest, Operation>
      reactivateSubscriptionCallable;
  private final OperationCallable<
          ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSubscriptionsServiceStub create(SubscriptionsServiceStubSettings settings)
      throws IOException {
    return new GrpcSubscriptionsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSubscriptionsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSubscriptionsServiceStub(
        SubscriptionsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSubscriptionsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSubscriptionsServiceStub(
        SubscriptionsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSubscriptionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSubscriptionsServiceStub(
      SubscriptionsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSubscriptionsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSubscriptionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSubscriptionsServiceStub(
      SubscriptionsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSubscriptionRequest, Operation> createSubscriptionTransportSettings =
        GrpcCallSettings.<CreateSubscriptionRequest, Operation>newBuilder()
            .setMethodDescriptor(createSubscriptionMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteSubscriptionRequest, Operation> deleteSubscriptionTransportSettings =
        GrpcCallSettings.<DeleteSubscriptionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionTransportSettings =
        GrpcCallSettings.<GetSubscriptionRequest, Subscription>newBuilder()
            .setMethodDescriptor(getSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSubscriptionsRequest, ListSubscriptionsResponse>
        listSubscriptionsTransportSettings =
            GrpcCallSettings.<ListSubscriptionsRequest, ListSubscriptionsResponse>newBuilder()
                .setMethodDescriptor(listSubscriptionsMethodDescriptor)
                .build();
    GrpcCallSettings<UpdateSubscriptionRequest, Operation> updateSubscriptionTransportSettings =
        GrpcCallSettings.<UpdateSubscriptionRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "subscription.name", String.valueOf(request.getSubscription().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ReactivateSubscriptionRequest, Operation>
        reactivateSubscriptionTransportSettings =
            GrpcCallSettings.<ReactivateSubscriptionRequest, Operation>newBuilder()
                .setMethodDescriptor(reactivateSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.createSubscriptionCallable =
        callableFactory.createUnaryCallable(
            createSubscriptionTransportSettings,
            settings.createSubscriptionSettings(),
            clientContext);
    this.createSubscriptionOperationCallable =
        callableFactory.createOperationCallable(
            createSubscriptionTransportSettings,
            settings.createSubscriptionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSubscriptionCallable =
        callableFactory.createUnaryCallable(
            deleteSubscriptionTransportSettings,
            settings.deleteSubscriptionSettings(),
            clientContext);
    this.deleteSubscriptionOperationCallable =
        callableFactory.createOperationCallable(
            deleteSubscriptionTransportSettings,
            settings.deleteSubscriptionOperationSettings(),
            clientContext,
            operationsStub);
    this.getSubscriptionCallable =
        callableFactory.createUnaryCallable(
            getSubscriptionTransportSettings, settings.getSubscriptionSettings(), clientContext);
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
    this.updateSubscriptionOperationCallable =
        callableFactory.createOperationCallable(
            updateSubscriptionTransportSettings,
            settings.updateSubscriptionOperationSettings(),
            clientContext,
            operationsStub);
    this.reactivateSubscriptionCallable =
        callableFactory.createUnaryCallable(
            reactivateSubscriptionTransportSettings,
            settings.reactivateSubscriptionSettings(),
            clientContext);
    this.reactivateSubscriptionOperationCallable =
        callableFactory.createOperationCallable(
            reactivateSubscriptionTransportSettings,
            settings.reactivateSubscriptionOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateSubscriptionRequest, Operation> createSubscriptionCallable() {
    return createSubscriptionCallable;
  }

  @Override
  public OperationCallable<CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
      createSubscriptionOperationCallable() {
    return createSubscriptionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSubscriptionRequest, Operation> deleteSubscriptionCallable() {
    return deleteSubscriptionCallable;
  }

  @Override
  public OperationCallable<DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
      deleteSubscriptionOperationCallable() {
    return deleteSubscriptionOperationCallable;
  }

  @Override
  public UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    return getSubscriptionCallable;
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
  public UnaryCallable<UpdateSubscriptionRequest, Operation> updateSubscriptionCallable() {
    return updateSubscriptionCallable;
  }

  @Override
  public OperationCallable<UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
      updateSubscriptionOperationCallable() {
    return updateSubscriptionOperationCallable;
  }

  @Override
  public UnaryCallable<ReactivateSubscriptionRequest, Operation> reactivateSubscriptionCallable() {
    return reactivateSubscriptionCallable;
  }

  @Override
  public OperationCallable<
          ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionOperationCallable() {
    return reactivateSubscriptionOperationCallable;
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
