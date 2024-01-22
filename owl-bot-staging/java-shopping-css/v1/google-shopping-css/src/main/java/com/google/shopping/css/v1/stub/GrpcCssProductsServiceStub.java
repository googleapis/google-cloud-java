/*
 * Copyright 2023 Google LLC
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

package com.google.shopping.css.v1.stub;

import static com.google.shopping.css.v1.CssProductsServiceClient.ListCssProductsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.css.v1.CssProduct;
import com.google.shopping.css.v1.GetCssProductRequest;
import com.google.shopping.css.v1.ListCssProductsRequest;
import com.google.shopping.css.v1.ListCssProductsResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CssProductsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCssProductsServiceStub extends CssProductsServiceStub {
  private static final MethodDescriptor<GetCssProductRequest, CssProduct>
      getCssProductMethodDescriptor =
          MethodDescriptor.<GetCssProductRequest, CssProduct>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.shopping.css.v1.CssProductsService/GetCssProduct")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCssProductRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CssProduct.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCssProductsRequest, ListCssProductsResponse>
      listCssProductsMethodDescriptor =
          MethodDescriptor.<ListCssProductsRequest, ListCssProductsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.shopping.css.v1.CssProductsService/ListCssProducts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCssProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCssProductsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetCssProductRequest, CssProduct> getCssProductCallable;
  private final UnaryCallable<ListCssProductsRequest, ListCssProductsResponse>
      listCssProductsCallable;
  private final UnaryCallable<ListCssProductsRequest, ListCssProductsPagedResponse>
      listCssProductsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCssProductsServiceStub create(CssProductsServiceStubSettings settings)
      throws IOException {
    return new GrpcCssProductsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCssProductsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCssProductsServiceStub(
        CssProductsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCssProductsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCssProductsServiceStub(
        CssProductsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCssProductsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCssProductsServiceStub(
      CssProductsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCssProductsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCssProductsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCssProductsServiceStub(
      CssProductsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetCssProductRequest, CssProduct> getCssProductTransportSettings =
        GrpcCallSettings.<GetCssProductRequest, CssProduct>newBuilder()
            .setMethodDescriptor(getCssProductMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCssProductsRequest, ListCssProductsResponse>
        listCssProductsTransportSettings =
            GrpcCallSettings.<ListCssProductsRequest, ListCssProductsResponse>newBuilder()
                .setMethodDescriptor(listCssProductsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getCssProductCallable =
        callableFactory.createUnaryCallable(
            getCssProductTransportSettings, settings.getCssProductSettings(), clientContext);
    this.listCssProductsCallable =
        callableFactory.createUnaryCallable(
            listCssProductsTransportSettings, settings.listCssProductsSettings(), clientContext);
    this.listCssProductsPagedCallable =
        callableFactory.createPagedCallable(
            listCssProductsTransportSettings, settings.listCssProductsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetCssProductRequest, CssProduct> getCssProductCallable() {
    return getCssProductCallable;
  }

  @Override
  public UnaryCallable<ListCssProductsRequest, ListCssProductsResponse> listCssProductsCallable() {
    return listCssProductsCallable;
  }

  @Override
  public UnaryCallable<ListCssProductsRequest, ListCssProductsPagedResponse>
      listCssProductsPagedCallable() {
    return listCssProductsPagedCallable;
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
