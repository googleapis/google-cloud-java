/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.RuleExecutionErrorServiceClient.ListRuleExecutionErrorsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest;
import com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the RuleExecutionErrorService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcRuleExecutionErrorServiceStub extends RuleExecutionErrorServiceStub {
  private static final MethodDescriptor<
          ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>
      listRuleExecutionErrorsMethodDescriptor =
          MethodDescriptor
              .<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.RuleExecutionErrorService/ListRuleExecutionErrors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRuleExecutionErrorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRuleExecutionErrorsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>
      listRuleExecutionErrorsCallable;
  private final UnaryCallable<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsPagedResponse>
      listRuleExecutionErrorsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRuleExecutionErrorServiceStub create(
      RuleExecutionErrorServiceStubSettings settings) throws IOException {
    return new GrpcRuleExecutionErrorServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRuleExecutionErrorServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcRuleExecutionErrorServiceStub(
        RuleExecutionErrorServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRuleExecutionErrorServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRuleExecutionErrorServiceStub(
        RuleExecutionErrorServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRuleExecutionErrorServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRuleExecutionErrorServiceStub(
      RuleExecutionErrorServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRuleExecutionErrorServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRuleExecutionErrorServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRuleExecutionErrorServiceStub(
      RuleExecutionErrorServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>
        listRuleExecutionErrorsTransportSettings =
            GrpcCallSettings
                .<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>newBuilder()
                .setMethodDescriptor(listRuleExecutionErrorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.listRuleExecutionErrorsCallable =
        callableFactory.createUnaryCallable(
            listRuleExecutionErrorsTransportSettings,
            settings.listRuleExecutionErrorsSettings(),
            clientContext);
    this.listRuleExecutionErrorsPagedCallable =
        callableFactory.createPagedCallable(
            listRuleExecutionErrorsTransportSettings,
            settings.listRuleExecutionErrorsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>
      listRuleExecutionErrorsCallable() {
    return listRuleExecutionErrorsCallable;
  }

  @Override
  public UnaryCallable<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsPagedResponse>
      listRuleExecutionErrorsPagedCallable() {
    return listRuleExecutionErrorsPagedCallable;
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
