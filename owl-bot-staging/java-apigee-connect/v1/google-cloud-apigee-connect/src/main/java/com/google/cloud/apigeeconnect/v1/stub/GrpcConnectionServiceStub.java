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

package com.google.cloud.apigeeconnect.v1.stub;

import static com.google.cloud.apigeeconnect.v1.ConnectionServiceClient.ListConnectionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apigeeconnect.v1.ListConnectionsRequest;
import com.google.cloud.apigeeconnect.v1.ListConnectionsResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ConnectionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcConnectionServiceStub extends ConnectionServiceStub {
  private static final MethodDescriptor<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsMethodDescriptor =
          MethodDescriptor.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeconnect.v1.ConnectionService/ListConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConnectionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsCallable;
  private final UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConnectionServiceStub create(ConnectionServiceStubSettings settings)
      throws IOException {
    return new GrpcConnectionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConnectionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConnectionServiceStub(
        ConnectionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConnectionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConnectionServiceStub(
        ConnectionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConnectionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConnectionServiceStub(
      ConnectionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcConnectionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConnectionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConnectionServiceStub(
      ConnectionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListConnectionsRequest, ListConnectionsResponse>
        listConnectionsTransportSettings =
            GrpcCallSettings.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
                .setMethodDescriptor(listConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();

    this.listConnectionsCallable =
        callableFactory.createUnaryCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.listConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListConnectionsRequest, ListConnectionsResponse> listConnectionsCallable() {
    return listConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable() {
    return listConnectionsPagedCallable;
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
