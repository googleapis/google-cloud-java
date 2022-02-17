/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.ContentServiceClient.ListContentPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.Content;
import com.google.cloud.dataplex.v1.CreateContentRequest;
import com.google.cloud.dataplex.v1.DeleteContentRequest;
import com.google.cloud.dataplex.v1.GetContentRequest;
import com.google.cloud.dataplex.v1.ListContentRequest;
import com.google.cloud.dataplex.v1.ListContentResponse;
import com.google.cloud.dataplex.v1.UpdateContentRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ContentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcContentServiceStub extends ContentServiceStub {
  private static final MethodDescriptor<CreateContentRequest, Content>
      createContentMethodDescriptor =
          MethodDescriptor.<CreateContentRequest, Content>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.ContentService/CreateContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateContentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Content.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateContentRequest, Content>
      updateContentMethodDescriptor =
          MethodDescriptor.<UpdateContentRequest, Content>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.ContentService/UpdateContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateContentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Content.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteContentRequest, Empty> deleteContentMethodDescriptor =
      MethodDescriptor.<DeleteContentRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.ContentService/DeleteContent")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteContentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetContentRequest, Content> getContentMethodDescriptor =
      MethodDescriptor.<GetContentRequest, Content>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.ContentService/GetContent")
          .setRequestMarshaller(ProtoUtils.marshaller(GetContentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Content.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListContentRequest, ListContentResponse>
      listContentMethodDescriptor =
          MethodDescriptor.<ListContentRequest, ListContentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.ContentService/ListContent")
              .setRequestMarshaller(ProtoUtils.marshaller(ListContentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListContentResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateContentRequest, Content> createContentCallable;
  private final UnaryCallable<UpdateContentRequest, Content> updateContentCallable;
  private final UnaryCallable<DeleteContentRequest, Empty> deleteContentCallable;
  private final UnaryCallable<GetContentRequest, Content> getContentCallable;
  private final UnaryCallable<ListContentRequest, ListContentResponse> listContentCallable;
  private final UnaryCallable<ListContentRequest, ListContentPagedResponse>
      listContentPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcContentServiceStub create(ContentServiceStubSettings settings)
      throws IOException {
    return new GrpcContentServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcContentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcContentServiceStub(
        ContentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcContentServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcContentServiceStub(
        ContentServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcContentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcContentServiceStub(ContentServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcContentServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcContentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcContentServiceStub(
      ContentServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateContentRequest, Content> createContentTransportSettings =
        GrpcCallSettings.<CreateContentRequest, Content>newBuilder()
            .setMethodDescriptor(createContentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateContentRequest, Content> updateContentTransportSettings =
        GrpcCallSettings.<UpdateContentRequest, Content>newBuilder()
            .setMethodDescriptor(updateContentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("content.name", String.valueOf(request.getContent().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteContentRequest, Empty> deleteContentTransportSettings =
        GrpcCallSettings.<DeleteContentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteContentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetContentRequest, Content> getContentTransportSettings =
        GrpcCallSettings.<GetContentRequest, Content>newBuilder()
            .setMethodDescriptor(getContentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListContentRequest, ListContentResponse> listContentTransportSettings =
        GrpcCallSettings.<ListContentRequest, ListContentResponse>newBuilder()
            .setMethodDescriptor(listContentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();

    this.createContentCallable =
        callableFactory.createUnaryCallable(
            createContentTransportSettings, settings.createContentSettings(), clientContext);
    this.updateContentCallable =
        callableFactory.createUnaryCallable(
            updateContentTransportSettings, settings.updateContentSettings(), clientContext);
    this.deleteContentCallable =
        callableFactory.createUnaryCallable(
            deleteContentTransportSettings, settings.deleteContentSettings(), clientContext);
    this.getContentCallable =
        callableFactory.createUnaryCallable(
            getContentTransportSettings, settings.getContentSettings(), clientContext);
    this.listContentCallable =
        callableFactory.createUnaryCallable(
            listContentTransportSettings, settings.listContentSettings(), clientContext);
    this.listContentPagedCallable =
        callableFactory.createPagedCallable(
            listContentTransportSettings, settings.listContentSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateContentRequest, Content> createContentCallable() {
    return createContentCallable;
  }

  @Override
  public UnaryCallable<UpdateContentRequest, Content> updateContentCallable() {
    return updateContentCallable;
  }

  @Override
  public UnaryCallable<DeleteContentRequest, Empty> deleteContentCallable() {
    return deleteContentCallable;
  }

  @Override
  public UnaryCallable<GetContentRequest, Content> getContentCallable() {
    return getContentCallable;
  }

  @Override
  public UnaryCallable<ListContentRequest, ListContentResponse> listContentCallable() {
    return listContentCallable;
  }

  @Override
  public UnaryCallable<ListContentRequest, ListContentPagedResponse> listContentPagedCallable() {
    return listContentPagedCallable;
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
