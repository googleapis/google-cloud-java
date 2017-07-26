/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.errorreporting.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.errorreporting.v1beta1.ReportErrorsServiceSettings;
import com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Stackdriver Error Reporting API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcReportErrorsServiceStub extends ReportErrorsServiceStub {
  private static final UnaryCallable<ReportErrorEventRequest, ReportErrorEventResponse>
      directReportErrorEventCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.devtools.clouderrorreporting.v1beta1.ReportErrorsService/ReportErrorEvent",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ReportErrorEventRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ReportErrorEventResponse.getDefaultInstance())));

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<ReportErrorEventRequest, ReportErrorEventResponse>
      reportErrorEventCallable;

  public static final GrpcReportErrorsServiceStub create(ReportErrorsServiceSettings settings)
      throws IOException {
    return new GrpcReportErrorsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcReportErrorsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcReportErrorsServiceStub(
        ReportErrorsServiceSettings.defaultBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcReportErrorsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcReportErrorsServiceStub(
      ReportErrorsServiceSettings settings, ClientContext clientContext) throws IOException {

    this.reportErrorEventCallable =
        GrpcCallableFactory.create(
            directReportErrorEventCallable, settings.reportErrorEventSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<ReportErrorEventRequest, ReportErrorEventResponse>
      reportErrorEventCallable() {
    return reportErrorEventCallable;
  }

  @Override
  public final void close() throws Exception {
    shutdown();
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
