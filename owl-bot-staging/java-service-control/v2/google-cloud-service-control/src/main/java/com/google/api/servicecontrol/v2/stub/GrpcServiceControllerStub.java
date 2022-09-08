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

package com.google.api.servicecontrol.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.servicecontrol.v2.CheckRequest;
import com.google.api.servicecontrol.v2.CheckResponse;
import com.google.api.servicecontrol.v2.ReportRequest;
import com.google.api.servicecontrol.v2.ReportResponse;
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
 * gRPC stub implementation for the ServiceController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcServiceControllerStub extends ServiceControllerStub {
  private static final MethodDescriptor<CheckRequest, CheckResponse> checkMethodDescriptor =
      MethodDescriptor.<CheckRequest, CheckResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.api.servicecontrol.v2.ServiceController/Check")
          .setRequestMarshaller(ProtoUtils.marshaller(CheckRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(CheckResponse.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ReportRequest, ReportResponse> reportMethodDescriptor =
      MethodDescriptor.<ReportRequest, ReportResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.api.servicecontrol.v2.ServiceController/Report")
          .setRequestMarshaller(ProtoUtils.marshaller(ReportRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ReportResponse.getDefaultInstance()))
          .build();

  private final UnaryCallable<CheckRequest, CheckResponse> checkCallable;
  private final UnaryCallable<ReportRequest, ReportResponse> reportCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcServiceControllerStub create(ServiceControllerStubSettings settings)
      throws IOException {
    return new GrpcServiceControllerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcServiceControllerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcServiceControllerStub(
        ServiceControllerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcServiceControllerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcServiceControllerStub(
        ServiceControllerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcServiceControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcServiceControllerStub(
      ServiceControllerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcServiceControllerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcServiceControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcServiceControllerStub(
      ServiceControllerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CheckRequest, CheckResponse> checkTransportSettings =
        GrpcCallSettings.<CheckRequest, CheckResponse>newBuilder()
            .setMethodDescriptor(checkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("service_name", String.valueOf(request.getServiceName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ReportRequest, ReportResponse> reportTransportSettings =
        GrpcCallSettings.<ReportRequest, ReportResponse>newBuilder()
            .setMethodDescriptor(reportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("service_name", String.valueOf(request.getServiceName()));
                  return params.build();
                })
            .build();

    this.checkCallable =
        callableFactory.createUnaryCallable(
            checkTransportSettings, settings.checkSettings(), clientContext);
    this.reportCallable =
        callableFactory.createUnaryCallable(
            reportTransportSettings, settings.reportSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CheckRequest, CheckResponse> checkCallable() {
    return checkCallable;
  }

  @Override
  public UnaryCallable<ReportRequest, ReportResponse> reportCallable() {
    return reportCallable;
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
