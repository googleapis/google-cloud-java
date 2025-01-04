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

import static com.google.shopping.merchant.reviews.v1beta.MerchantReviewsServiceClient.ListMerchantReviewsPagedResponse;

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
import com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest;
import com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse;
import com.google.shopping.merchant.reviews.v1beta.MerchantReview;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MerchantReviewsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMerchantReviewsServiceStub extends MerchantReviewsServiceStub {
  private static final MethodDescriptor<GetMerchantReviewRequest, MerchantReview>
      getMerchantReviewMethodDescriptor =
          MethodDescriptor.<GetMerchantReviewRequest, MerchantReview>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.MerchantReviewsService/GetMerchantReview")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMerchantReviewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MerchantReview.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMerchantReviewsRequest, ListMerchantReviewsResponse>
      listMerchantReviewsMethodDescriptor =
          MethodDescriptor.<ListMerchantReviewsRequest, ListMerchantReviewsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.MerchantReviewsService/ListMerchantReviews")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMerchantReviewsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMerchantReviewsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<InsertMerchantReviewRequest, MerchantReview>
      insertMerchantReviewMethodDescriptor =
          MethodDescriptor.<InsertMerchantReviewRequest, MerchantReview>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.MerchantReviewsService/InsertMerchantReview")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InsertMerchantReviewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MerchantReview.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMerchantReviewRequest, Empty>
      deleteMerchantReviewMethodDescriptor =
          MethodDescriptor.<DeleteMerchantReviewRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.MerchantReviewsService/DeleteMerchantReview")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMerchantReviewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetMerchantReviewRequest, MerchantReview> getMerchantReviewCallable;
  private final UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsResponse>
      listMerchantReviewsCallable;
  private final UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsPagedResponse>
      listMerchantReviewsPagedCallable;
  private final UnaryCallable<InsertMerchantReviewRequest, MerchantReview>
      insertMerchantReviewCallable;
  private final UnaryCallable<DeleteMerchantReviewRequest, Empty> deleteMerchantReviewCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMerchantReviewsServiceStub create(
      MerchantReviewsServiceStubSettings settings) throws IOException {
    return new GrpcMerchantReviewsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMerchantReviewsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMerchantReviewsServiceStub(
        MerchantReviewsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMerchantReviewsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMerchantReviewsServiceStub(
        MerchantReviewsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMerchantReviewsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMerchantReviewsServiceStub(
      MerchantReviewsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcMerchantReviewsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMerchantReviewsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMerchantReviewsServiceStub(
      MerchantReviewsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetMerchantReviewRequest, MerchantReview> getMerchantReviewTransportSettings =
        GrpcCallSettings.<GetMerchantReviewRequest, MerchantReview>newBuilder()
            .setMethodDescriptor(getMerchantReviewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListMerchantReviewsRequest, ListMerchantReviewsResponse>
        listMerchantReviewsTransportSettings =
            GrpcCallSettings.<ListMerchantReviewsRequest, ListMerchantReviewsResponse>newBuilder()
                .setMethodDescriptor(listMerchantReviewsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<InsertMerchantReviewRequest, MerchantReview>
        insertMerchantReviewTransportSettings =
            GrpcCallSettings.<InsertMerchantReviewRequest, MerchantReview>newBuilder()
                .setMethodDescriptor(insertMerchantReviewMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMerchantReviewRequest, Empty> deleteMerchantReviewTransportSettings =
        GrpcCallSettings.<DeleteMerchantReviewRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMerchantReviewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getMerchantReviewCallable =
        callableFactory.createUnaryCallable(
            getMerchantReviewTransportSettings,
            settings.getMerchantReviewSettings(),
            clientContext);
    this.listMerchantReviewsCallable =
        callableFactory.createUnaryCallable(
            listMerchantReviewsTransportSettings,
            settings.listMerchantReviewsSettings(),
            clientContext);
    this.listMerchantReviewsPagedCallable =
        callableFactory.createPagedCallable(
            listMerchantReviewsTransportSettings,
            settings.listMerchantReviewsSettings(),
            clientContext);
    this.insertMerchantReviewCallable =
        callableFactory.createUnaryCallable(
            insertMerchantReviewTransportSettings,
            settings.insertMerchantReviewSettings(),
            clientContext);
    this.deleteMerchantReviewCallable =
        callableFactory.createUnaryCallable(
            deleteMerchantReviewTransportSettings,
            settings.deleteMerchantReviewSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetMerchantReviewRequest, MerchantReview> getMerchantReviewCallable() {
    return getMerchantReviewCallable;
  }

  @Override
  public UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsResponse>
      listMerchantReviewsCallable() {
    return listMerchantReviewsCallable;
  }

  @Override
  public UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsPagedResponse>
      listMerchantReviewsPagedCallable() {
    return listMerchantReviewsPagedCallable;
  }

  @Override
  public UnaryCallable<InsertMerchantReviewRequest, MerchantReview> insertMerchantReviewCallable() {
    return insertMerchantReviewCallable;
  }

  @Override
  public UnaryCallable<DeleteMerchantReviewRequest, Empty> deleteMerchantReviewCallable() {
    return deleteMerchantReviewCallable;
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
