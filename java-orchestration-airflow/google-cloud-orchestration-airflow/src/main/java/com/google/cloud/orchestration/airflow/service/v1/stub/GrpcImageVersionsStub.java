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

package com.google.cloud.orchestration.airflow.service.v1.stub;

import static com.google.cloud.orchestration.airflow.service.v1.ImageVersionsClient.ListImageVersionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.orchestration.airflow.service.v1.ListImageVersionsRequest;
import com.google.cloud.orchestration.airflow.service.v1.ListImageVersionsResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ImageVersions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcImageVersionsStub extends ImageVersionsStub {
  private static final MethodDescriptor<ListImageVersionsRequest, ListImageVersionsResponse>
      listImageVersionsMethodDescriptor =
          MethodDescriptor.<ListImageVersionsRequest, ListImageVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.ImageVersions/ListImageVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListImageVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListImageVersionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListImageVersionsRequest, ListImageVersionsResponse>
      listImageVersionsCallable;
  private final UnaryCallable<ListImageVersionsRequest, ListImageVersionsPagedResponse>
      listImageVersionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcImageVersionsStub create(ImageVersionsStubSettings settings)
      throws IOException {
    return new GrpcImageVersionsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcImageVersionsStub create(ClientContext clientContext) throws IOException {
    return new GrpcImageVersionsStub(ImageVersionsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcImageVersionsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcImageVersionsStub(
        ImageVersionsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcImageVersionsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcImageVersionsStub(ImageVersionsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcImageVersionsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcImageVersionsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcImageVersionsStub(
      ImageVersionsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListImageVersionsRequest, ListImageVersionsResponse>
        listImageVersionsTransportSettings =
            GrpcCallSettings.<ListImageVersionsRequest, ListImageVersionsResponse>newBuilder()
                .setMethodDescriptor(listImageVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();

    this.listImageVersionsCallable =
        callableFactory.createUnaryCallable(
            listImageVersionsTransportSettings,
            settings.listImageVersionsSettings(),
            clientContext);
    this.listImageVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listImageVersionsTransportSettings,
            settings.listImageVersionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListImageVersionsRequest, ListImageVersionsResponse>
      listImageVersionsCallable() {
    return listImageVersionsCallable;
  }

  @Override
  public UnaryCallable<ListImageVersionsRequest, ListImageVersionsPagedResponse>
      listImageVersionsPagedCallable() {
    return listImageVersionsPagedCallable;
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
