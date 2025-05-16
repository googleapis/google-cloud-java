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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.GbpAccountsServiceClient.ListGbpAccountsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest;
import com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse;
import com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the GbpAccountsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcGbpAccountsServiceStub extends GbpAccountsServiceStub {
  private static final MethodDescriptor<ListGbpAccountsRequest, ListGbpAccountsResponse>
      listGbpAccountsMethodDescriptor =
          MethodDescriptor.<ListGbpAccountsRequest, ListGbpAccountsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.GbpAccountsService/ListGbpAccounts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGbpAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGbpAccountsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<LinkGbpAccountRequest, LinkGbpAccountResponse>
      linkGbpAccountMethodDescriptor =
          MethodDescriptor.<LinkGbpAccountRequest, LinkGbpAccountResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.GbpAccountsService/LinkGbpAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(LinkGbpAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(LinkGbpAccountResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsResponse>
      listGbpAccountsCallable;
  private final UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsPagedResponse>
      listGbpAccountsPagedCallable;
  private final UnaryCallable<LinkGbpAccountRequest, LinkGbpAccountResponse> linkGbpAccountCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGbpAccountsServiceStub create(GbpAccountsServiceStubSettings settings)
      throws IOException {
    return new GrpcGbpAccountsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGbpAccountsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcGbpAccountsServiceStub(
        GbpAccountsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGbpAccountsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGbpAccountsServiceStub(
        GbpAccountsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGbpAccountsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGbpAccountsServiceStub(
      GbpAccountsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcGbpAccountsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGbpAccountsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGbpAccountsServiceStub(
      GbpAccountsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListGbpAccountsRequest, ListGbpAccountsResponse>
        listGbpAccountsTransportSettings =
            GrpcCallSettings.<ListGbpAccountsRequest, ListGbpAccountsResponse>newBuilder()
                .setMethodDescriptor(listGbpAccountsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<LinkGbpAccountRequest, LinkGbpAccountResponse>
        linkGbpAccountTransportSettings =
            GrpcCallSettings.<LinkGbpAccountRequest, LinkGbpAccountResponse>newBuilder()
                .setMethodDescriptor(linkGbpAccountMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listGbpAccountsCallable =
        callableFactory.createUnaryCallable(
            listGbpAccountsTransportSettings, settings.listGbpAccountsSettings(), clientContext);
    this.listGbpAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listGbpAccountsTransportSettings, settings.listGbpAccountsSettings(), clientContext);
    this.linkGbpAccountCallable =
        callableFactory.createUnaryCallable(
            linkGbpAccountTransportSettings, settings.linkGbpAccountSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsResponse> listGbpAccountsCallable() {
    return listGbpAccountsCallable;
  }

  @Override
  public UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsPagedResponse>
      listGbpAccountsPagedCallable() {
    return listGbpAccountsPagedCallable;
  }

  @Override
  public UnaryCallable<LinkGbpAccountRequest, LinkGbpAccountResponse> linkGbpAccountCallable() {
    return linkGbpAccountCallable;
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
