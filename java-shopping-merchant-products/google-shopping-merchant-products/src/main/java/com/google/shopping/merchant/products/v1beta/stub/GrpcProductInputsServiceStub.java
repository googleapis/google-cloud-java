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

package com.google.shopping.merchant.products.v1beta.stub;

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
import com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest;
import com.google.shopping.merchant.products.v1beta.InsertProductInputRequest;
import com.google.shopping.merchant.products.v1beta.ProductInput;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ProductInputsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcProductInputsServiceStub extends ProductInputsServiceStub {
  private static final MethodDescriptor<InsertProductInputRequest, ProductInput>
      insertProductInputMethodDescriptor =
          MethodDescriptor.<InsertProductInputRequest, ProductInput>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.products.v1beta.ProductInputsService/InsertProductInput")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InsertProductInputRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProductInput.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteProductInputRequest, Empty>
      deleteProductInputMethodDescriptor =
          MethodDescriptor.<DeleteProductInputRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.products.v1beta.ProductInputsService/DeleteProductInput")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteProductInputRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<InsertProductInputRequest, ProductInput> insertProductInputCallable;
  private final UnaryCallable<DeleteProductInputRequest, Empty> deleteProductInputCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcProductInputsServiceStub create(ProductInputsServiceStubSettings settings)
      throws IOException {
    return new GrpcProductInputsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcProductInputsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcProductInputsServiceStub(
        ProductInputsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcProductInputsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcProductInputsServiceStub(
        ProductInputsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcProductInputsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcProductInputsServiceStub(
      ProductInputsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcProductInputsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcProductInputsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcProductInputsServiceStub(
      ProductInputsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<InsertProductInputRequest, ProductInput> insertProductInputTransportSettings =
        GrpcCallSettings.<InsertProductInputRequest, ProductInput>newBuilder()
            .setMethodDescriptor(insertProductInputMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteProductInputRequest, Empty> deleteProductInputTransportSettings =
        GrpcCallSettings.<DeleteProductInputRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteProductInputMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.insertProductInputCallable =
        callableFactory.createUnaryCallable(
            insertProductInputTransportSettings,
            settings.insertProductInputSettings(),
            clientContext);
    this.deleteProductInputCallable =
        callableFactory.createUnaryCallable(
            deleteProductInputTransportSettings,
            settings.deleteProductInputSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<InsertProductInputRequest, ProductInput> insertProductInputCallable() {
    return insertProductInputCallable;
  }

  @Override
  public UnaryCallable<DeleteProductInputRequest, Empty> deleteProductInputCallable() {
    return deleteProductInputCallable;
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
