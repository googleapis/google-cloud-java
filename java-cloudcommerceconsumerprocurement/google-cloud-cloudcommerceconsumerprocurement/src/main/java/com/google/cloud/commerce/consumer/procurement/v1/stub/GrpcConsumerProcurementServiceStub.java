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

package com.google.cloud.commerce.consumer.procurement.v1.stub;

import static com.google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementServiceClient.ListOrdersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.commerce.consumer.procurement.v1.CancelOrderMetadata;
import com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest;
import com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest;
import com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest;
import com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse;
import com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderMetadata;
import com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest;
import com.google.cloud.commerce.consumer.procurement.v1.Order;
import com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderMetadata;
import com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ConsumerProcurementService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcConsumerProcurementServiceStub extends ConsumerProcurementServiceStub {
  private static final MethodDescriptor<PlaceOrderRequest, Operation> placeOrderMethodDescriptor =
      MethodDescriptor.<PlaceOrderRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService/PlaceOrder")
          .setRequestMarshaller(ProtoUtils.marshaller(PlaceOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetOrderRequest, Order> getOrderMethodDescriptor =
      MethodDescriptor.<GetOrderRequest, Order>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService/GetOrder")
          .setRequestMarshaller(ProtoUtils.marshaller(GetOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Order.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListOrdersRequest, ListOrdersResponse>
      listOrdersMethodDescriptor =
          MethodDescriptor.<ListOrdersRequest, ListOrdersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService/ListOrders")
              .setRequestMarshaller(ProtoUtils.marshaller(ListOrdersRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListOrdersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ModifyOrderRequest, Operation> modifyOrderMethodDescriptor =
      MethodDescriptor.<ModifyOrderRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService/ModifyOrder")
          .setRequestMarshaller(ProtoUtils.marshaller(ModifyOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CancelOrderRequest, Operation> cancelOrderMethodDescriptor =
      MethodDescriptor.<CancelOrderRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService/CancelOrder")
          .setRequestMarshaller(ProtoUtils.marshaller(CancelOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<PlaceOrderRequest, Operation> placeOrderCallable;
  private final OperationCallable<PlaceOrderRequest, Order, PlaceOrderMetadata>
      placeOrderOperationCallable;
  private final UnaryCallable<GetOrderRequest, Order> getOrderCallable;
  private final UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable;
  private final UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable;
  private final UnaryCallable<ModifyOrderRequest, Operation> modifyOrderCallable;
  private final OperationCallable<ModifyOrderRequest, Order, ModifyOrderMetadata>
      modifyOrderOperationCallable;
  private final UnaryCallable<CancelOrderRequest, Operation> cancelOrderCallable;
  private final OperationCallable<CancelOrderRequest, Order, CancelOrderMetadata>
      cancelOrderOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConsumerProcurementServiceStub create(
      ConsumerProcurementServiceStubSettings settings) throws IOException {
    return new GrpcConsumerProcurementServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConsumerProcurementServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConsumerProcurementServiceStub(
        ConsumerProcurementServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConsumerProcurementServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConsumerProcurementServiceStub(
        ConsumerProcurementServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcConsumerProcurementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConsumerProcurementServiceStub(
      ConsumerProcurementServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcConsumerProcurementServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConsumerProcurementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConsumerProcurementServiceStub(
      ConsumerProcurementServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<PlaceOrderRequest, Operation> placeOrderTransportSettings =
        GrpcCallSettings.<PlaceOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(placeOrderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetOrderRequest, Order> getOrderTransportSettings =
        GrpcCallSettings.<GetOrderRequest, Order>newBuilder()
            .setMethodDescriptor(getOrderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListOrdersRequest, ListOrdersResponse> listOrdersTransportSettings =
        GrpcCallSettings.<ListOrdersRequest, ListOrdersResponse>newBuilder()
            .setMethodDescriptor(listOrdersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ModifyOrderRequest, Operation> modifyOrderTransportSettings =
        GrpcCallSettings.<ModifyOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(modifyOrderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CancelOrderRequest, Operation> cancelOrderTransportSettings =
        GrpcCallSettings.<CancelOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(cancelOrderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.placeOrderCallable =
        callableFactory.createUnaryCallable(
            placeOrderTransportSettings, settings.placeOrderSettings(), clientContext);
    this.placeOrderOperationCallable =
        callableFactory.createOperationCallable(
            placeOrderTransportSettings,
            settings.placeOrderOperationSettings(),
            clientContext,
            operationsStub);
    this.getOrderCallable =
        callableFactory.createUnaryCallable(
            getOrderTransportSettings, settings.getOrderSettings(), clientContext);
    this.listOrdersCallable =
        callableFactory.createUnaryCallable(
            listOrdersTransportSettings, settings.listOrdersSettings(), clientContext);
    this.listOrdersPagedCallable =
        callableFactory.createPagedCallable(
            listOrdersTransportSettings, settings.listOrdersSettings(), clientContext);
    this.modifyOrderCallable =
        callableFactory.createUnaryCallable(
            modifyOrderTransportSettings, settings.modifyOrderSettings(), clientContext);
    this.modifyOrderOperationCallable =
        callableFactory.createOperationCallable(
            modifyOrderTransportSettings,
            settings.modifyOrderOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelOrderCallable =
        callableFactory.createUnaryCallable(
            cancelOrderTransportSettings, settings.cancelOrderSettings(), clientContext);
    this.cancelOrderOperationCallable =
        callableFactory.createOperationCallable(
            cancelOrderTransportSettings,
            settings.cancelOrderOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<PlaceOrderRequest, Operation> placeOrderCallable() {
    return placeOrderCallable;
  }

  @Override
  public OperationCallable<PlaceOrderRequest, Order, PlaceOrderMetadata>
      placeOrderOperationCallable() {
    return placeOrderOperationCallable;
  }

  @Override
  public UnaryCallable<GetOrderRequest, Order> getOrderCallable() {
    return getOrderCallable;
  }

  @Override
  public UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable() {
    return listOrdersCallable;
  }

  @Override
  public UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable() {
    return listOrdersPagedCallable;
  }

  @Override
  public UnaryCallable<ModifyOrderRequest, Operation> modifyOrderCallable() {
    return modifyOrderCallable;
  }

  @Override
  public OperationCallable<ModifyOrderRequest, Order, ModifyOrderMetadata>
      modifyOrderOperationCallable() {
    return modifyOrderOperationCallable;
  }

  @Override
  public UnaryCallable<CancelOrderRequest, Operation> cancelOrderCallable() {
    return cancelOrderCallable;
  }

  @Override
  public OperationCallable<CancelOrderRequest, Order, CancelOrderMetadata>
      cancelOrderOperationCallable() {
    return cancelOrderOperationCallable;
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
