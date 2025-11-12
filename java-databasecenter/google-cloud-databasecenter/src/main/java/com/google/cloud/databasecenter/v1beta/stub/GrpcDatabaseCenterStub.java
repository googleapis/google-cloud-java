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

package com.google.cloud.databasecenter.v1beta.stub;

import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.QueryProductsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.databasecenter.v1beta.QueryProductsRequest;
import com.google.cloud.databasecenter.v1beta.QueryProductsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DatabaseCenter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDatabaseCenterStub extends DatabaseCenterStub {
  private static final MethodDescriptor<QueryProductsRequest, QueryProductsResponse>
      queryProductsMethodDescriptor =
          MethodDescriptor.<QueryProductsRequest, QueryProductsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.databasecenter.v1beta.DatabaseCenter/QueryProducts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryProductsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<QueryProductsRequest, QueryProductsResponse> queryProductsCallable;
  private final UnaryCallable<QueryProductsRequest, QueryProductsPagedResponse>
      queryProductsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDatabaseCenterStub create(DatabaseCenterStubSettings settings)
      throws IOException {
    return new GrpcDatabaseCenterStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDatabaseCenterStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDatabaseCenterStub(
        DatabaseCenterStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDatabaseCenterStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDatabaseCenterStub(
        DatabaseCenterStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDatabaseCenterStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatabaseCenterStub(DatabaseCenterStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDatabaseCenterCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDatabaseCenterStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatabaseCenterStub(
      DatabaseCenterStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<QueryProductsRequest, QueryProductsResponse> queryProductsTransportSettings =
        GrpcCallSettings.<QueryProductsRequest, QueryProductsResponse>newBuilder()
            .setMethodDescriptor(queryProductsMethodDescriptor)
            .build();

    this.queryProductsCallable =
        callableFactory.createUnaryCallable(
            queryProductsTransportSettings, settings.queryProductsSettings(), clientContext);
    this.queryProductsPagedCallable =
        callableFactory.createPagedCallable(
            queryProductsTransportSettings, settings.queryProductsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<QueryProductsRequest, QueryProductsResponse> queryProductsCallable() {
    return queryProductsCallable;
  }

  @Override
  public UnaryCallable<QueryProductsRequest, QueryProductsPagedResponse>
      queryProductsPagedCallable() {
    return queryProductsPagedCallable;
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
