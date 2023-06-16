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

package com.google.cloud.kms.inventory.v1.stub;

import static com.google.cloud.kms.inventory.v1.KeyDashboardServiceClient.ListCryptoKeysPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest;
import com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the KeyDashboardService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcKeyDashboardServiceStub extends KeyDashboardServiceStub {
  private static final MethodDescriptor<ListCryptoKeysRequest, ListCryptoKeysResponse>
      listCryptoKeysMethodDescriptor =
          MethodDescriptor.<ListCryptoKeysRequest, ListCryptoKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.inventory.v1.KeyDashboardService/ListCryptoKeys")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCryptoKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCryptoKeysResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysResponse> listCryptoKeysCallable;
  private final UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysPagedResponse>
      listCryptoKeysPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcKeyDashboardServiceStub create(KeyDashboardServiceStubSettings settings)
      throws IOException {
    return new GrpcKeyDashboardServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcKeyDashboardServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcKeyDashboardServiceStub(
        KeyDashboardServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcKeyDashboardServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcKeyDashboardServiceStub(
        KeyDashboardServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcKeyDashboardServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcKeyDashboardServiceStub(
      KeyDashboardServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcKeyDashboardServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcKeyDashboardServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcKeyDashboardServiceStub(
      KeyDashboardServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListCryptoKeysRequest, ListCryptoKeysResponse>
        listCryptoKeysTransportSettings =
            GrpcCallSettings.<ListCryptoKeysRequest, ListCryptoKeysResponse>newBuilder()
                .setMethodDescriptor(listCryptoKeysMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listCryptoKeysCallable =
        callableFactory.createUnaryCallable(
            listCryptoKeysTransportSettings, settings.listCryptoKeysSettings(), clientContext);
    this.listCryptoKeysPagedCallable =
        callableFactory.createPagedCallable(
            listCryptoKeysTransportSettings, settings.listCryptoKeysSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysResponse> listCryptoKeysCallable() {
    return listCryptoKeysCallable;
  }

  @Override
  public UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysPagedResponse>
      listCryptoKeysPagedCallable() {
    return listCryptoKeysPagedCallable;
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
