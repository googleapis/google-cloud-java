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

package com.google.shopping.merchant.issueresolution.v1beta.stub;

import static com.google.shopping.merchant.issueresolution.v1beta.AggregateProductStatusesServiceClient.ListAggregateProductStatusesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesRequest;
import com.google.shopping.merchant.issueresolution.v1beta.ListAggregateProductStatusesResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AggregateProductStatusesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAggregateProductStatusesServiceStub extends AggregateProductStatusesServiceStub {
  private static final MethodDescriptor<
          ListAggregateProductStatusesRequest, ListAggregateProductStatusesResponse>
      listAggregateProductStatusesMethodDescriptor =
          MethodDescriptor
              .<ListAggregateProductStatusesRequest, ListAggregateProductStatusesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.issueresolution.v1beta.AggregateProductStatusesService/ListAggregateProductStatuses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAggregateProductStatusesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAggregateProductStatusesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<
          ListAggregateProductStatusesRequest, ListAggregateProductStatusesResponse>
      listAggregateProductStatusesCallable;
  private final UnaryCallable<
          ListAggregateProductStatusesRequest, ListAggregateProductStatusesPagedResponse>
      listAggregateProductStatusesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAggregateProductStatusesServiceStub create(
      AggregateProductStatusesServiceStubSettings settings) throws IOException {
    return new GrpcAggregateProductStatusesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAggregateProductStatusesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAggregateProductStatusesServiceStub(
        AggregateProductStatusesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAggregateProductStatusesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAggregateProductStatusesServiceStub(
        AggregateProductStatusesServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcAggregateProductStatusesServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcAggregateProductStatusesServiceStub(
      AggregateProductStatusesServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAggregateProductStatusesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAggregateProductStatusesServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcAggregateProductStatusesServiceStub(
      AggregateProductStatusesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAggregateProductStatusesRequest, ListAggregateProductStatusesResponse>
        listAggregateProductStatusesTransportSettings =
            GrpcCallSettings
                .<ListAggregateProductStatusesRequest, ListAggregateProductStatusesResponse>
                    newBuilder()
                .setMethodDescriptor(listAggregateProductStatusesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listAggregateProductStatusesCallable =
        callableFactory.createUnaryCallable(
            listAggregateProductStatusesTransportSettings,
            settings.listAggregateProductStatusesSettings(),
            clientContext);
    this.listAggregateProductStatusesPagedCallable =
        callableFactory.createPagedCallable(
            listAggregateProductStatusesTransportSettings,
            settings.listAggregateProductStatusesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListAggregateProductStatusesRequest, ListAggregateProductStatusesResponse>
      listAggregateProductStatusesCallable() {
    return listAggregateProductStatusesCallable;
  }

  @Override
  public UnaryCallable<
          ListAggregateProductStatusesRequest, ListAggregateProductStatusesPagedResponse>
      listAggregateProductStatusesPagedCallable() {
    return listAggregateProductStatusesPagedCallable;
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
