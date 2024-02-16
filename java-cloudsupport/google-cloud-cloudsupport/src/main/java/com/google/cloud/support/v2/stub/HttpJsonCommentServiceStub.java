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

package com.google.cloud.support.v2.stub;

import static com.google.cloud.support.v2.CommentServiceClient.ListCommentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2.Comment;
import com.google.cloud.support.v2.CreateCommentRequest;
import com.google.cloud.support.v2.ListCommentsRequest;
import com.google.cloud.support.v2.ListCommentsResponse;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CommentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCommentServiceStub extends CommentServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListCommentsRequest, ListCommentsResponse>
      listCommentsMethodDescriptor =
          ApiMethodDescriptor.<ListCommentsRequest, ListCommentsResponse>newBuilder()
              .setFullMethodName("google.cloud.support.v2.CommentService/ListComments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCommentsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/cases/*}/comments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=organizations/*/cases/*}/comments")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCommentsResponse>newBuilder()
                      .setDefaultInstance(ListCommentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCommentRequest, Comment>
      createCommentMethodDescriptor =
          ApiMethodDescriptor.<CreateCommentRequest, Comment>newBuilder()
              .setFullMethodName("google.cloud.support.v2.CommentService/CreateComment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCommentRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/cases/*}/comments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=organizations/*/cases/*}/comments")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("comment", request.getComment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Comment>newBuilder()
                      .setDefaultInstance(Comment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListCommentsRequest, ListCommentsResponse> listCommentsCallable;
  private final UnaryCallable<ListCommentsRequest, ListCommentsPagedResponse>
      listCommentsPagedCallable;
  private final UnaryCallable<CreateCommentRequest, Comment> createCommentCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCommentServiceStub create(CommentServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCommentServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCommentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCommentServiceStub(
        CommentServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCommentServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCommentServiceStub(
        CommentServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCommentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCommentServiceStub(
      CommentServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCommentServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCommentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCommentServiceStub(
      CommentServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListCommentsRequest, ListCommentsResponse> listCommentsTransportSettings =
        HttpJsonCallSettings.<ListCommentsRequest, ListCommentsResponse>newBuilder()
            .setMethodDescriptor(listCommentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateCommentRequest, Comment> createCommentTransportSettings =
        HttpJsonCallSettings.<CreateCommentRequest, Comment>newBuilder()
            .setMethodDescriptor(createCommentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listCommentsMethodDescriptor);
    methodDescriptors.add(createCommentMethodDescriptor);
    return methodDescriptors;
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
