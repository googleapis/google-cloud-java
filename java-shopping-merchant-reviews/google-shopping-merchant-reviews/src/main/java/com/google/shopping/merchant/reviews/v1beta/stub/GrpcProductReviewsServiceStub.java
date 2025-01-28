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

package com.google.shopping.merchant.reviews.v1beta.stub;

import static com.google.shopping.merchant.reviews.v1beta.ProductReviewsServiceClient.ListProductReviewsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest;
import com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse;
import com.google.shopping.merchant.reviews.v1beta.ProductReview;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ProductReviewsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcProductReviewsServiceStub extends ProductReviewsServiceStub {
  private static final MethodDescriptor<GetProductReviewRequest, ProductReview>
      getProductReviewMethodDescriptor =
          MethodDescriptor.<GetProductReviewRequest, ProductReview>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.ProductReviewsService/GetProductReview")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetProductReviewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProductReview.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListProductReviewsRequest, ListProductReviewsResponse>
      listProductReviewsMethodDescriptor =
          MethodDescriptor.<ListProductReviewsRequest, ListProductReviewsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.ProductReviewsService/ListProductReviews")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProductReviewsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProductReviewsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<InsertProductReviewRequest, ProductReview>
      insertProductReviewMethodDescriptor =
          MethodDescriptor.<InsertProductReviewRequest, ProductReview>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.ProductReviewsService/InsertProductReview")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InsertProductReviewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProductReview.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteProductReviewRequest, Empty>
      deleteProductReviewMethodDescriptor =
          MethodDescriptor.<DeleteProductReviewRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.ProductReviewsService/DeleteProductReview")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteProductReviewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetProductReviewRequest, ProductReview> getProductReviewCallable;
  private final UnaryCallable<ListProductReviewsRequest, ListProductReviewsResponse>
      listProductReviewsCallable;
  private final UnaryCallable<ListProductReviewsRequest, ListProductReviewsPagedResponse>
      listProductReviewsPagedCallable;
  private final UnaryCallable<InsertProductReviewRequest, ProductReview>
      insertProductReviewCallable;
  private final UnaryCallable<DeleteProductReviewRequest, Empty> deleteProductReviewCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcProductReviewsServiceStub create(
      ProductReviewsServiceStubSettings settings) throws IOException {
    return new GrpcProductReviewsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcProductReviewsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcProductReviewsServiceStub(
        ProductReviewsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcProductReviewsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcProductReviewsServiceStub(
        ProductReviewsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcProductReviewsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcProductReviewsServiceStub(
      ProductReviewsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcProductReviewsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcProductReviewsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcProductReviewsServiceStub(
      ProductReviewsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetProductReviewRequest, ProductReview> getProductReviewTransportSettings =
        GrpcCallSettings.<GetProductReviewRequest, ProductReview>newBuilder()
            .setMethodDescriptor(getProductReviewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListProductReviewsRequest, ListProductReviewsResponse>
        listProductReviewsTransportSettings =
            GrpcCallSettings.<ListProductReviewsRequest, ListProductReviewsResponse>newBuilder()
                .setMethodDescriptor(listProductReviewsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<InsertProductReviewRequest, ProductReview>
        insertProductReviewTransportSettings =
            GrpcCallSettings.<InsertProductReviewRequest, ProductReview>newBuilder()
                .setMethodDescriptor(insertProductReviewMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteProductReviewRequest, Empty> deleteProductReviewTransportSettings =
        GrpcCallSettings.<DeleteProductReviewRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteProductReviewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getProductReviewCallable =
        callableFactory.createUnaryCallable(
            getProductReviewTransportSettings, settings.getProductReviewSettings(), clientContext);
    this.listProductReviewsCallable =
        callableFactory.createUnaryCallable(
            listProductReviewsTransportSettings,
            settings.listProductReviewsSettings(),
            clientContext);
    this.listProductReviewsPagedCallable =
        callableFactory.createPagedCallable(
            listProductReviewsTransportSettings,
            settings.listProductReviewsSettings(),
            clientContext);
    this.insertProductReviewCallable =
        callableFactory.createUnaryCallable(
            insertProductReviewTransportSettings,
            settings.insertProductReviewSettings(),
            clientContext);
    this.deleteProductReviewCallable =
        callableFactory.createUnaryCallable(
            deleteProductReviewTransportSettings,
            settings.deleteProductReviewSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetProductReviewRequest, ProductReview> getProductReviewCallable() {
    return getProductReviewCallable;
  }

  @Override
  public UnaryCallable<ListProductReviewsRequest, ListProductReviewsResponse>
      listProductReviewsCallable() {
    return listProductReviewsCallable;
  }

  @Override
  public UnaryCallable<ListProductReviewsRequest, ListProductReviewsPagedResponse>
      listProductReviewsPagedCallable() {
    return listProductReviewsPagedCallable;
  }

  @Override
  public UnaryCallable<InsertProductReviewRequest, ProductReview> insertProductReviewCallable() {
    return insertProductReviewCallable;
  }

  @Override
  public UnaryCallable<DeleteProductReviewRequest, Empty> deleteProductReviewCallable() {
    return deleteProductReviewCallable;
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
