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

package com.google.cloud.support.v2beta.stub;

import static com.google.cloud.support.v2beta.CommentServiceClient.ListCommentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2beta.Comment;
import com.google.cloud.support.v2beta.CreateCommentRequest;
import com.google.cloud.support.v2beta.GetCommentRequest;
import com.google.cloud.support.v2beta.ListCommentsRequest;
import com.google.cloud.support.v2beta.ListCommentsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CommentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcCommentServiceStub extends CommentServiceStub {
  private static final MethodDescriptor<ListCommentsRequest, ListCommentsResponse>
      listCommentsMethodDescriptor =
          MethodDescriptor.<ListCommentsRequest, ListCommentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.support.v2beta.CommentService/ListComments")
              .setRequestMarshaller(ProtoUtils.marshaller(ListCommentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCommentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCommentRequest, Comment>
      createCommentMethodDescriptor =
          MethodDescriptor.<CreateCommentRequest, Comment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.support.v2beta.CommentService/CreateComment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Comment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCommentRequest, Comment> getCommentMethodDescriptor =
      MethodDescriptor.<GetCommentRequest, Comment>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.support.v2beta.CommentService/GetComment")
          .setRequestMarshaller(ProtoUtils.marshaller(GetCommentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Comment.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListCommentsRequest, ListCommentsResponse> listCommentsCallable;
  private final UnaryCallable<ListCommentsRequest, ListCommentsPagedResponse>
      listCommentsPagedCallable;
  private final UnaryCallable<CreateCommentRequest, Comment> createCommentCallable;
  private final UnaryCallable<GetCommentRequest, Comment> getCommentCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCommentServiceStub create(CommentServiceStubSettings settings)
      throws IOException {
    return new GrpcCommentServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCommentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCommentServiceStub(
        CommentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCommentServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCommentServiceStub(
        CommentServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCommentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCommentServiceStub(CommentServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCommentServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCommentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCommentServiceStub(
      CommentServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListCommentsRequest, ListCommentsResponse> listCommentsTransportSettings =
        GrpcCallSettings.<ListCommentsRequest, ListCommentsResponse>newBuilder()
            .setMethodDescriptor(listCommentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateCommentRequest, Comment> createCommentTransportSettings =
        GrpcCallSettings.<CreateCommentRequest, Comment>newBuilder()
            .setMethodDescriptor(createCommentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetCommentRequest, Comment> getCommentTransportSettings =
        GrpcCallSettings.<GetCommentRequest, Comment>newBuilder()
            .setMethodDescriptor(getCommentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listCommentsCallable =
        callableFactory.createUnaryCallable(
            listCommentsTransportSettings, settings.listCommentsSettings(), clientContext);
    this.listCommentsPagedCallable =
        callableFactory.createPagedCallable(
            listCommentsTransportSettings, settings.listCommentsSettings(), clientContext);
    this.createCommentCallable =
        callableFactory.createUnaryCallable(
            createCommentTransportSettings, settings.createCommentSettings(), clientContext);
    this.getCommentCallable =
        callableFactory.createUnaryCallable(
            getCommentTransportSettings, settings.getCommentSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListCommentsRequest, ListCommentsResponse> listCommentsCallable() {
    return listCommentsCallable;
  }

  @Override
  public UnaryCallable<ListCommentsRequest, ListCommentsPagedResponse> listCommentsPagedCallable() {
    return listCommentsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateCommentRequest, Comment> createCommentCallable() {
    return createCommentCallable;
  }

  @Override
  public UnaryCallable<GetCommentRequest, Comment> getCommentCallable() {
    return getCommentCallable;
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
