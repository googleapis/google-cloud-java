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

package com.google.shopping.merchant.promotions.v1beta.stub;

import static com.google.shopping.merchant.promotions.v1beta.PromotionsServiceClient.ListPromotionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest;
import com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest;
import com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest;
import com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse;
import com.google.shopping.merchant.promotions.v1beta.Promotion;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the PromotionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcPromotionsServiceStub extends PromotionsServiceStub {
  private static final MethodDescriptor<InsertPromotionRequest, Promotion>
      insertPromotionMethodDescriptor =
          MethodDescriptor.<InsertPromotionRequest, Promotion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.promotions.v1beta.PromotionsService/InsertPromotion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InsertPromotionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Promotion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPromotionRequest, Promotion>
      getPromotionMethodDescriptor =
          MethodDescriptor.<GetPromotionRequest, Promotion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.promotions.v1beta.PromotionsService/GetPromotion")
              .setRequestMarshaller(ProtoUtils.marshaller(GetPromotionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Promotion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPromotionsRequest, ListPromotionsResponse>
      listPromotionsMethodDescriptor =
          MethodDescriptor.<ListPromotionsRequest, ListPromotionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.promotions.v1beta.PromotionsService/ListPromotions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPromotionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPromotionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<InsertPromotionRequest, Promotion> insertPromotionCallable;
  private final UnaryCallable<GetPromotionRequest, Promotion> getPromotionCallable;
  private final UnaryCallable<ListPromotionsRequest, ListPromotionsResponse> listPromotionsCallable;
  private final UnaryCallable<ListPromotionsRequest, ListPromotionsPagedResponse>
      listPromotionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPromotionsServiceStub create(PromotionsServiceStubSettings settings)
      throws IOException {
    return new GrpcPromotionsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPromotionsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPromotionsServiceStub(
        PromotionsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPromotionsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPromotionsServiceStub(
        PromotionsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPromotionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPromotionsServiceStub(
      PromotionsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcPromotionsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPromotionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPromotionsServiceStub(
      PromotionsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<InsertPromotionRequest, Promotion> insertPromotionTransportSettings =
        GrpcCallSettings.<InsertPromotionRequest, Promotion>newBuilder()
            .setMethodDescriptor(insertPromotionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPromotionRequest, Promotion> getPromotionTransportSettings =
        GrpcCallSettings.<GetPromotionRequest, Promotion>newBuilder()
            .setMethodDescriptor(getPromotionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPromotionsRequest, ListPromotionsResponse>
        listPromotionsTransportSettings =
            GrpcCallSettings.<ListPromotionsRequest, ListPromotionsResponse>newBuilder()
                .setMethodDescriptor(listPromotionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.insertPromotionCallable =
        callableFactory.createUnaryCallable(
            insertPromotionTransportSettings, settings.insertPromotionSettings(), clientContext);
    this.getPromotionCallable =
        callableFactory.createUnaryCallable(
            getPromotionTransportSettings, settings.getPromotionSettings(), clientContext);
    this.listPromotionsCallable =
        callableFactory.createUnaryCallable(
            listPromotionsTransportSettings, settings.listPromotionsSettings(), clientContext);
    this.listPromotionsPagedCallable =
        callableFactory.createPagedCallable(
            listPromotionsTransportSettings, settings.listPromotionsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<InsertPromotionRequest, Promotion> insertPromotionCallable() {
    return insertPromotionCallable;
  }

  @Override
  public UnaryCallable<GetPromotionRequest, Promotion> getPromotionCallable() {
    return getPromotionCallable;
  }

  @Override
  public UnaryCallable<ListPromotionsRequest, ListPromotionsResponse> listPromotionsCallable() {
    return listPromotionsCallable;
  }

  @Override
  public UnaryCallable<ListPromotionsRequest, ListPromotionsPagedResponse>
      listPromotionsPagedCallable() {
    return listPromotionsPagedCallable;
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
