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

package com.google.shopping.merchant.accounts.v1.stub;

import static com.google.shopping.merchant.accounts.v1.LfpProvidersServiceClient.FindLfpProvidersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest;
import com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse;
import com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest;
import com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the LfpProvidersService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcLfpProvidersServiceStub extends LfpProvidersServiceStub {
  private static final MethodDescriptor<FindLfpProvidersRequest, FindLfpProvidersResponse>
      findLfpProvidersMethodDescriptor =
          MethodDescriptor.<FindLfpProvidersRequest, FindLfpProvidersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.LfpProvidersService/FindLfpProviders")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FindLfpProvidersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FindLfpProvidersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<LinkLfpProviderRequest, LinkLfpProviderResponse>
      linkLfpProviderMethodDescriptor =
          MethodDescriptor.<LinkLfpProviderRequest, LinkLfpProviderResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.LfpProvidersService/LinkLfpProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(LinkLfpProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(LinkLfpProviderResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersResponse>
      findLfpProvidersCallable;
  private final UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersPagedResponse>
      findLfpProvidersPagedCallable;
  private final UnaryCallable<LinkLfpProviderRequest, LinkLfpProviderResponse>
      linkLfpProviderCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLfpProvidersServiceStub create(LfpProvidersServiceStubSettings settings)
      throws IOException {
    return new GrpcLfpProvidersServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLfpProvidersServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLfpProvidersServiceStub(
        LfpProvidersServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLfpProvidersServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLfpProvidersServiceStub(
        LfpProvidersServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLfpProvidersServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLfpProvidersServiceStub(
      LfpProvidersServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcLfpProvidersServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLfpProvidersServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLfpProvidersServiceStub(
      LfpProvidersServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<FindLfpProvidersRequest, FindLfpProvidersResponse>
        findLfpProvidersTransportSettings =
            GrpcCallSettings.<FindLfpProvidersRequest, FindLfpProvidersResponse>newBuilder()
                .setMethodDescriptor(findLfpProvidersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<LinkLfpProviderRequest, LinkLfpProviderResponse>
        linkLfpProviderTransportSettings =
            GrpcCallSettings.<LinkLfpProviderRequest, LinkLfpProviderResponse>newBuilder()
                .setMethodDescriptor(linkLfpProviderMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.findLfpProvidersCallable =
        callableFactory.createUnaryCallable(
            findLfpProvidersTransportSettings, settings.findLfpProvidersSettings(), clientContext);
    this.findLfpProvidersPagedCallable =
        callableFactory.createPagedCallable(
            findLfpProvidersTransportSettings, settings.findLfpProvidersSettings(), clientContext);
    this.linkLfpProviderCallable =
        callableFactory.createUnaryCallable(
            linkLfpProviderTransportSettings, settings.linkLfpProviderSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersResponse>
      findLfpProvidersCallable() {
    return findLfpProvidersCallable;
  }

  @Override
  public UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersPagedResponse>
      findLfpProvidersPagedCallable() {
    return findLfpProvidersPagedCallable;
  }

  @Override
  public UnaryCallable<LinkLfpProviderRequest, LinkLfpProviderResponse> linkLfpProviderCallable() {
    return linkLfpProviderCallable;
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
