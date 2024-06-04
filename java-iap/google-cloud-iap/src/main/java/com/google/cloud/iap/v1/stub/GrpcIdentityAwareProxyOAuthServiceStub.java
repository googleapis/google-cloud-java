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

package com.google.cloud.iap.v1.stub;

import static com.google.cloud.iap.v1.IdentityAwareProxyOAuthServiceClient.ListIdentityAwareProxyClientsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iap.v1.Brand;
import com.google.cloud.iap.v1.CreateBrandRequest;
import com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.GetBrandRequest;
import com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.IdentityAwareProxyClient;
import com.google.cloud.iap.v1.ListBrandsRequest;
import com.google.cloud.iap.v1.ListBrandsResponse;
import com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest;
import com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse;
import com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the IdentityAwareProxyOAuthService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcIdentityAwareProxyOAuthServiceStub extends IdentityAwareProxyOAuthServiceStub {
  private static final MethodDescriptor<ListBrandsRequest, ListBrandsResponse>
      listBrandsMethodDescriptor =
          MethodDescriptor.<ListBrandsRequest, ListBrandsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iap.v1.IdentityAwareProxyOAuthService/ListBrands")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBrandsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListBrandsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBrandRequest, Brand> createBrandMethodDescriptor =
      MethodDescriptor.<CreateBrandRequest, Brand>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.iap.v1.IdentityAwareProxyOAuthService/CreateBrand")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateBrandRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Brand.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetBrandRequest, Brand> getBrandMethodDescriptor =
      MethodDescriptor.<GetBrandRequest, Brand>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.iap.v1.IdentityAwareProxyOAuthService/GetBrand")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBrandRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Brand.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<
          CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      createIdentityAwareProxyClientMethodDescriptor =
          MethodDescriptor
              .<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyOAuthService/CreateIdentityAwareProxyClient")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateIdentityAwareProxyClientRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(IdentityAwareProxyClient.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
      listIdentityAwareProxyClientsMethodDescriptor =
          MethodDescriptor
              .<ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyOAuthService/ListIdentityAwareProxyClients")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListIdentityAwareProxyClientsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIdentityAwareProxyClientsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      getIdentityAwareProxyClientMethodDescriptor =
          MethodDescriptor
              .<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyOAuthService/GetIdentityAwareProxyClient")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetIdentityAwareProxyClientRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(IdentityAwareProxyClient.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
      resetIdentityAwareProxyClientSecretMethodDescriptor =
          MethodDescriptor
              .<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyOAuthService/ResetIdentityAwareProxyClientSecret")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ResetIdentityAwareProxyClientSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(IdentityAwareProxyClient.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteIdentityAwareProxyClientRequest, Empty>
      deleteIdentityAwareProxyClientMethodDescriptor =
          MethodDescriptor.<DeleteIdentityAwareProxyClientRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyOAuthService/DeleteIdentityAwareProxyClient")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteIdentityAwareProxyClientRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListBrandsRequest, ListBrandsResponse> listBrandsCallable;
  private final UnaryCallable<CreateBrandRequest, Brand> createBrandCallable;
  private final UnaryCallable<GetBrandRequest, Brand> getBrandCallable;
  private final UnaryCallable<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      createIdentityAwareProxyClientCallable;
  private final UnaryCallable<
          ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
      listIdentityAwareProxyClientsCallable;
  private final UnaryCallable<
          ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsPagedResponse>
      listIdentityAwareProxyClientsPagedCallable;
  private final UnaryCallable<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      getIdentityAwareProxyClientCallable;
  private final UnaryCallable<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
      resetIdentityAwareProxyClientSecretCallable;
  private final UnaryCallable<DeleteIdentityAwareProxyClientRequest, Empty>
      deleteIdentityAwareProxyClientCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcIdentityAwareProxyOAuthServiceStub create(
      IdentityAwareProxyOAuthServiceStubSettings settings) throws IOException {
    return new GrpcIdentityAwareProxyOAuthServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIdentityAwareProxyOAuthServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcIdentityAwareProxyOAuthServiceStub(
        IdentityAwareProxyOAuthServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcIdentityAwareProxyOAuthServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcIdentityAwareProxyOAuthServiceStub(
        IdentityAwareProxyOAuthServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcIdentityAwareProxyOAuthServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcIdentityAwareProxyOAuthServiceStub(
      IdentityAwareProxyOAuthServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcIdentityAwareProxyOAuthServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcIdentityAwareProxyOAuthServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcIdentityAwareProxyOAuthServiceStub(
      IdentityAwareProxyOAuthServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListBrandsRequest, ListBrandsResponse> listBrandsTransportSettings =
        GrpcCallSettings.<ListBrandsRequest, ListBrandsResponse>newBuilder()
            .setMethodDescriptor(listBrandsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBrandRequest, Brand> createBrandTransportSettings =
        GrpcCallSettings.<CreateBrandRequest, Brand>newBuilder()
            .setMethodDescriptor(createBrandMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBrandRequest, Brand> getBrandTransportSettings =
        GrpcCallSettings.<GetBrandRequest, Brand>newBuilder()
            .setMethodDescriptor(getBrandMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
        createIdentityAwareProxyClientTransportSettings =
            GrpcCallSettings
                .<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>newBuilder()
                .setMethodDescriptor(createIdentityAwareProxyClientMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
        listIdentityAwareProxyClientsTransportSettings =
            GrpcCallSettings
                .<ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
                    newBuilder()
                .setMethodDescriptor(listIdentityAwareProxyClientsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
        getIdentityAwareProxyClientTransportSettings =
            GrpcCallSettings
                .<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>newBuilder()
                .setMethodDescriptor(getIdentityAwareProxyClientMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
        resetIdentityAwareProxyClientSecretTransportSettings =
            GrpcCallSettings
                .<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>newBuilder()
                .setMethodDescriptor(resetIdentityAwareProxyClientSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteIdentityAwareProxyClientRequest, Empty>
        deleteIdentityAwareProxyClientTransportSettings =
            GrpcCallSettings.<DeleteIdentityAwareProxyClientRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteIdentityAwareProxyClientMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.listBrandsCallable =
        callableFactory.createUnaryCallable(
            listBrandsTransportSettings, settings.listBrandsSettings(), clientContext);
    this.createBrandCallable =
        callableFactory.createUnaryCallable(
            createBrandTransportSettings, settings.createBrandSettings(), clientContext);
    this.getBrandCallable =
        callableFactory.createUnaryCallable(
            getBrandTransportSettings, settings.getBrandSettings(), clientContext);
    this.createIdentityAwareProxyClientCallable =
        callableFactory.createUnaryCallable(
            createIdentityAwareProxyClientTransportSettings,
            settings.createIdentityAwareProxyClientSettings(),
            clientContext);
    this.listIdentityAwareProxyClientsCallable =
        callableFactory.createUnaryCallable(
            listIdentityAwareProxyClientsTransportSettings,
            settings.listIdentityAwareProxyClientsSettings(),
            clientContext);
    this.listIdentityAwareProxyClientsPagedCallable =
        callableFactory.createPagedCallable(
            listIdentityAwareProxyClientsTransportSettings,
            settings.listIdentityAwareProxyClientsSettings(),
            clientContext);
    this.getIdentityAwareProxyClientCallable =
        callableFactory.createUnaryCallable(
            getIdentityAwareProxyClientTransportSettings,
            settings.getIdentityAwareProxyClientSettings(),
            clientContext);
    this.resetIdentityAwareProxyClientSecretCallable =
        callableFactory.createUnaryCallable(
            resetIdentityAwareProxyClientSecretTransportSettings,
            settings.resetIdentityAwareProxyClientSecretSettings(),
            clientContext);
    this.deleteIdentityAwareProxyClientCallable =
        callableFactory.createUnaryCallable(
            deleteIdentityAwareProxyClientTransportSettings,
            settings.deleteIdentityAwareProxyClientSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListBrandsRequest, ListBrandsResponse> listBrandsCallable() {
    return listBrandsCallable;
  }

  @Override
  public UnaryCallable<CreateBrandRequest, Brand> createBrandCallable() {
    return createBrandCallable;
  }

  @Override
  public UnaryCallable<GetBrandRequest, Brand> getBrandCallable() {
    return getBrandCallable;
  }

  @Override
  public UnaryCallable<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      createIdentityAwareProxyClientCallable() {
    return createIdentityAwareProxyClientCallable;
  }

  @Override
  public UnaryCallable<ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
      listIdentityAwareProxyClientsCallable() {
    return listIdentityAwareProxyClientsCallable;
  }

  @Override
  public UnaryCallable<
          ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsPagedResponse>
      listIdentityAwareProxyClientsPagedCallable() {
    return listIdentityAwareProxyClientsPagedCallable;
  }

  @Override
  public UnaryCallable<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      getIdentityAwareProxyClientCallable() {
    return getIdentityAwareProxyClientCallable;
  }

  @Override
  public UnaryCallable<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
      resetIdentityAwareProxyClientSecretCallable() {
    return resetIdentityAwareProxyClientSecretCallable;
  }

  @Override
  public UnaryCallable<DeleteIdentityAwareProxyClientRequest, Empty>
      deleteIdentityAwareProxyClientCallable() {
    return deleteIdentityAwareProxyClientCallable;
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
