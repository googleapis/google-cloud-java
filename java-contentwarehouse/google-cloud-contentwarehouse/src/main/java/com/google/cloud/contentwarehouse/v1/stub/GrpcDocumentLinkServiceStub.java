/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.contentwarehouse.v1.stub;

import static com.google.cloud.contentwarehouse.v1.DocumentLinkServiceClient.ListLinkedSourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest;
import com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest;
import com.google.cloud.contentwarehouse.v1.DocumentLink;
import com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest;
import com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse;
import com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest;
import com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse;
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
 * gRPC stub implementation for the DocumentLinkService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDocumentLinkServiceStub extends DocumentLinkServiceStub {
  private static final MethodDescriptor<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
      listLinkedTargetsMethodDescriptor =
          MethodDescriptor.<ListLinkedTargetsRequest, ListLinkedTargetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentLinkService/ListLinkedTargets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLinkedTargetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLinkedTargetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLinkedSourcesRequest, ListLinkedSourcesResponse>
      listLinkedSourcesMethodDescriptor =
          MethodDescriptor.<ListLinkedSourcesRequest, ListLinkedSourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentLinkService/ListLinkedSources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLinkedSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLinkedSourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDocumentLinkRequest, DocumentLink>
      createDocumentLinkMethodDescriptor =
          MethodDescriptor.<CreateDocumentLinkRequest, DocumentLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentLinkService/CreateDocumentLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDocumentLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DocumentLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDocumentLinkRequest, Empty>
      deleteDocumentLinkMethodDescriptor =
          MethodDescriptor.<DeleteDocumentLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentLinkService/DeleteDocumentLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDocumentLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
      listLinkedTargetsCallable;
  private final UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesResponse>
      listLinkedSourcesCallable;
  private final UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesPagedResponse>
      listLinkedSourcesPagedCallable;
  private final UnaryCallable<CreateDocumentLinkRequest, DocumentLink> createDocumentLinkCallable;
  private final UnaryCallable<DeleteDocumentLinkRequest, Empty> deleteDocumentLinkCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDocumentLinkServiceStub create(DocumentLinkServiceStubSettings settings)
      throws IOException {
    return new GrpcDocumentLinkServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDocumentLinkServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDocumentLinkServiceStub(
        DocumentLinkServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDocumentLinkServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDocumentLinkServiceStub(
        DocumentLinkServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDocumentLinkServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDocumentLinkServiceStub(
      DocumentLinkServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDocumentLinkServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDocumentLinkServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDocumentLinkServiceStub(
      DocumentLinkServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
        listLinkedTargetsTransportSettings =
            GrpcCallSettings.<ListLinkedTargetsRequest, ListLinkedTargetsResponse>newBuilder()
                .setMethodDescriptor(listLinkedTargetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLinkedSourcesRequest, ListLinkedSourcesResponse>
        listLinkedSourcesTransportSettings =
            GrpcCallSettings.<ListLinkedSourcesRequest, ListLinkedSourcesResponse>newBuilder()
                .setMethodDescriptor(listLinkedSourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateDocumentLinkRequest, DocumentLink> createDocumentLinkTransportSettings =
        GrpcCallSettings.<CreateDocumentLinkRequest, DocumentLink>newBuilder()
            .setMethodDescriptor(createDocumentLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteDocumentLinkRequest, Empty> deleteDocumentLinkTransportSettings =
        GrpcCallSettings.<DeleteDocumentLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDocumentLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listLinkedTargetsCallable =
        callableFactory.createUnaryCallable(
            listLinkedTargetsTransportSettings,
            settings.listLinkedTargetsSettings(),
            clientContext);
    this.listLinkedSourcesCallable =
        callableFactory.createUnaryCallable(
            listLinkedSourcesTransportSettings,
            settings.listLinkedSourcesSettings(),
            clientContext);
    this.listLinkedSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listLinkedSourcesTransportSettings,
            settings.listLinkedSourcesSettings(),
            clientContext);
    this.createDocumentLinkCallable =
        callableFactory.createUnaryCallable(
            createDocumentLinkTransportSettings,
            settings.createDocumentLinkSettings(),
            clientContext);
    this.deleteDocumentLinkCallable =
        callableFactory.createUnaryCallable(
            deleteDocumentLinkTransportSettings,
            settings.deleteDocumentLinkSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
      listLinkedTargetsCallable() {
    return listLinkedTargetsCallable;
  }

  @Override
  public UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesResponse>
      listLinkedSourcesCallable() {
    return listLinkedSourcesCallable;
  }

  @Override
  public UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesPagedResponse>
      listLinkedSourcesPagedCallable() {
    return listLinkedSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDocumentLinkRequest, DocumentLink> createDocumentLinkCallable() {
    return createDocumentLinkCallable;
  }

  @Override
  public UnaryCallable<DeleteDocumentLinkRequest, Empty> deleteDocumentLinkCallable() {
    return deleteDocumentLinkCallable;
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
