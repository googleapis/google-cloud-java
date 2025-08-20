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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.issueresolution.v1beta.RenderAccountIssuesRequest;
import com.google.shopping.merchant.issueresolution.v1beta.RenderAccountIssuesResponse;
import com.google.shopping.merchant.issueresolution.v1beta.RenderProductIssuesRequest;
import com.google.shopping.merchant.issueresolution.v1beta.RenderProductIssuesResponse;
import com.google.shopping.merchant.issueresolution.v1beta.TriggerActionRequest;
import com.google.shopping.merchant.issueresolution.v1beta.TriggerActionResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the IssueResolutionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcIssueResolutionServiceStub extends IssueResolutionServiceStub {
  private static final MethodDescriptor<RenderAccountIssuesRequest, RenderAccountIssuesResponse>
      renderAccountIssuesMethodDescriptor =
          MethodDescriptor.<RenderAccountIssuesRequest, RenderAccountIssuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.issueresolution.v1beta.IssueResolutionService/RenderAccountIssues")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RenderAccountIssuesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RenderAccountIssuesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RenderProductIssuesRequest, RenderProductIssuesResponse>
      renderProductIssuesMethodDescriptor =
          MethodDescriptor.<RenderProductIssuesRequest, RenderProductIssuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.issueresolution.v1beta.IssueResolutionService/RenderProductIssues")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RenderProductIssuesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RenderProductIssuesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<TriggerActionRequest, TriggerActionResponse>
      triggerActionMethodDescriptor =
          MethodDescriptor.<TriggerActionRequest, TriggerActionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.issueresolution.v1beta.IssueResolutionService/TriggerAction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TriggerActionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TriggerActionResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<RenderAccountIssuesRequest, RenderAccountIssuesResponse>
      renderAccountIssuesCallable;
  private final UnaryCallable<RenderProductIssuesRequest, RenderProductIssuesResponse>
      renderProductIssuesCallable;
  private final UnaryCallable<TriggerActionRequest, TriggerActionResponse> triggerActionCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcIssueResolutionServiceStub create(
      IssueResolutionServiceStubSettings settings) throws IOException {
    return new GrpcIssueResolutionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIssueResolutionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcIssueResolutionServiceStub(
        IssueResolutionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcIssueResolutionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcIssueResolutionServiceStub(
        IssueResolutionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcIssueResolutionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcIssueResolutionServiceStub(
      IssueResolutionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcIssueResolutionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcIssueResolutionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcIssueResolutionServiceStub(
      IssueResolutionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<RenderAccountIssuesRequest, RenderAccountIssuesResponse>
        renderAccountIssuesTransportSettings =
            GrpcCallSettings.<RenderAccountIssuesRequest, RenderAccountIssuesResponse>newBuilder()
                .setMethodDescriptor(renderAccountIssuesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RenderProductIssuesRequest, RenderProductIssuesResponse>
        renderProductIssuesTransportSettings =
            GrpcCallSettings.<RenderProductIssuesRequest, RenderProductIssuesResponse>newBuilder()
                .setMethodDescriptor(renderProductIssuesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<TriggerActionRequest, TriggerActionResponse> triggerActionTransportSettings =
        GrpcCallSettings.<TriggerActionRequest, TriggerActionResponse>newBuilder()
            .setMethodDescriptor(triggerActionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.renderAccountIssuesCallable =
        callableFactory.createUnaryCallable(
            renderAccountIssuesTransportSettings,
            settings.renderAccountIssuesSettings(),
            clientContext);
    this.renderProductIssuesCallable =
        callableFactory.createUnaryCallable(
            renderProductIssuesTransportSettings,
            settings.renderProductIssuesSettings(),
            clientContext);
    this.triggerActionCallable =
        callableFactory.createUnaryCallable(
            triggerActionTransportSettings, settings.triggerActionSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<RenderAccountIssuesRequest, RenderAccountIssuesResponse>
      renderAccountIssuesCallable() {
    return renderAccountIssuesCallable;
  }

  @Override
  public UnaryCallable<RenderProductIssuesRequest, RenderProductIssuesResponse>
      renderProductIssuesCallable() {
    return renderProductIssuesCallable;
  }

  @Override
  public UnaryCallable<TriggerActionRequest, TriggerActionResponse> triggerActionCallable() {
    return triggerActionCallable;
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
