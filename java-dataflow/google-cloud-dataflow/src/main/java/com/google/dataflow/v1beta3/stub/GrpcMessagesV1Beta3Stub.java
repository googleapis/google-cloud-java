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

package com.google.dataflow.v1beta3.stub;

import static com.google.dataflow.v1beta3.MessagesV1Beta3Client.ListJobMessagesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.dataflow.v1beta3.ListJobMessagesRequest;
import com.google.dataflow.v1beta3.ListJobMessagesResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MessagesV1Beta3 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMessagesV1Beta3Stub extends MessagesV1Beta3Stub {
  private static final MethodDescriptor<ListJobMessagesRequest, ListJobMessagesResponse>
      listJobMessagesMethodDescriptor =
          MethodDescriptor.<ListJobMessagesRequest, ListJobMessagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.dataflow.v1beta3.MessagesV1Beta3/ListJobMessages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListJobMessagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListJobMessagesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListJobMessagesRequest, ListJobMessagesResponse>
      listJobMessagesCallable;
  private final UnaryCallable<ListJobMessagesRequest, ListJobMessagesPagedResponse>
      listJobMessagesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMessagesV1Beta3Stub create(MessagesV1Beta3StubSettings settings)
      throws IOException {
    return new GrpcMessagesV1Beta3Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcMessagesV1Beta3Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMessagesV1Beta3Stub(
        MessagesV1Beta3StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMessagesV1Beta3Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMessagesV1Beta3Stub(
        MessagesV1Beta3StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMessagesV1Beta3Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMessagesV1Beta3Stub(
      MessagesV1Beta3StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcMessagesV1Beta3CallableFactory());
  }

  /**
   * Constructs an instance of GrpcMessagesV1Beta3Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMessagesV1Beta3Stub(
      MessagesV1Beta3StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListJobMessagesRequest, ListJobMessagesResponse>
        listJobMessagesTransportSettings =
            GrpcCallSettings.<ListJobMessagesRequest, ListJobMessagesResponse>newBuilder()
                .setMethodDescriptor(listJobMessagesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("job_id", String.valueOf(request.getJobId()));
                      params.put("location", String.valueOf(request.getLocation()));
                      params.put("project_id", String.valueOf(request.getProjectId()));
                      return params.build();
                    })
                .build();

    this.listJobMessagesCallable =
        callableFactory.createUnaryCallable(
            listJobMessagesTransportSettings, settings.listJobMessagesSettings(), clientContext);
    this.listJobMessagesPagedCallable =
        callableFactory.createPagedCallable(
            listJobMessagesTransportSettings, settings.listJobMessagesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListJobMessagesRequest, ListJobMessagesResponse> listJobMessagesCallable() {
    return listJobMessagesCallable;
  }

  @Override
  public UnaryCallable<ListJobMessagesRequest, ListJobMessagesPagedResponse>
      listJobMessagesPagedCallable() {
    return listJobMessagesPagedCallable;
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
