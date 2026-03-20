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

package com.google.ads.datamanager.v1.stub;

import static com.google.ads.datamanager.v1.PartnerLinkServiceClient.SearchPartnerLinksPagedResponse;

import com.google.ads.datamanager.v1.CreatePartnerLinkRequest;
import com.google.ads.datamanager.v1.DeletePartnerLinkRequest;
import com.google.ads.datamanager.v1.PartnerLink;
import com.google.ads.datamanager.v1.SearchPartnerLinksRequest;
import com.google.ads.datamanager.v1.SearchPartnerLinksResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the PartnerLinkService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPartnerLinkServiceStub extends PartnerLinkServiceStub {
  private static final MethodDescriptor<CreatePartnerLinkRequest, PartnerLink>
      createPartnerLinkMethodDescriptor =
          MethodDescriptor.<CreatePartnerLinkRequest, PartnerLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ads.datamanager.v1.PartnerLinkService/CreatePartnerLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePartnerLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PartnerLink.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeletePartnerLinkRequest, Empty>
      deletePartnerLinkMethodDescriptor =
          MethodDescriptor.<DeletePartnerLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ads.datamanager.v1.PartnerLinkService/DeletePartnerLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePartnerLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SearchPartnerLinksRequest, SearchPartnerLinksResponse>
      searchPartnerLinksMethodDescriptor =
          MethodDescriptor.<SearchPartnerLinksRequest, SearchPartnerLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ads.datamanager.v1.PartnerLinkService/SearchPartnerLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchPartnerLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchPartnerLinksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreatePartnerLinkRequest, PartnerLink> createPartnerLinkCallable;
  private final UnaryCallable<DeletePartnerLinkRequest, Empty> deletePartnerLinkCallable;
  private final UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksResponse>
      searchPartnerLinksCallable;
  private final UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksPagedResponse>
      searchPartnerLinksPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPartnerLinkServiceStub create(PartnerLinkServiceStubSettings settings)
      throws IOException {
    return new GrpcPartnerLinkServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPartnerLinkServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPartnerLinkServiceStub(
        PartnerLinkServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPartnerLinkServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPartnerLinkServiceStub(
        PartnerLinkServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPartnerLinkServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPartnerLinkServiceStub(
      PartnerLinkServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcPartnerLinkServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPartnerLinkServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPartnerLinkServiceStub(
      PartnerLinkServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreatePartnerLinkRequest, PartnerLink> createPartnerLinkTransportSettings =
        GrpcCallSettings.<CreatePartnerLinkRequest, PartnerLink>newBuilder()
            .setMethodDescriptor(createPartnerLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePartnerLinkRequest, Empty> deletePartnerLinkTransportSettings =
        GrpcCallSettings.<DeletePartnerLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePartnerLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchPartnerLinksRequest, SearchPartnerLinksResponse>
        searchPartnerLinksTransportSettings =
            GrpcCallSettings.<SearchPartnerLinksRequest, SearchPartnerLinksResponse>newBuilder()
                .setMethodDescriptor(searchPartnerLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createPartnerLinkCallable =
        callableFactory.createUnaryCallable(
            createPartnerLinkTransportSettings,
            settings.createPartnerLinkSettings(),
            clientContext);
    this.deletePartnerLinkCallable =
        callableFactory.createUnaryCallable(
            deletePartnerLinkTransportSettings,
            settings.deletePartnerLinkSettings(),
            clientContext);
    this.searchPartnerLinksCallable =
        callableFactory.createUnaryCallable(
            searchPartnerLinksTransportSettings,
            settings.searchPartnerLinksSettings(),
            clientContext);
    this.searchPartnerLinksPagedCallable =
        callableFactory.createPagedCallable(
            searchPartnerLinksTransportSettings,
            settings.searchPartnerLinksSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreatePartnerLinkRequest, PartnerLink> createPartnerLinkCallable() {
    return createPartnerLinkCallable;
  }

  @Override
  public UnaryCallable<DeletePartnerLinkRequest, Empty> deletePartnerLinkCallable() {
    return deletePartnerLinkCallable;
  }

  @Override
  public UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksResponse>
      searchPartnerLinksCallable() {
    return searchPartnerLinksCallable;
  }

  @Override
  public UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksPagedResponse>
      searchPartnerLinksPagedCallable() {
    return searchPartnerLinksPagedCallable;
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
