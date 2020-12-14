/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.phishingprotection.v1beta1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.phishingprotection.v1beta1.ReportPhishingRequest;
import com.google.phishingprotection.v1beta1.ReportPhishingResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the PhishingProtectionServiceV1Beta1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPhishingProtectionServiceV1Beta1Stub extends PhishingProtectionServiceV1Beta1Stub {
  private static final MethodDescriptor<ReportPhishingRequest, ReportPhishingResponse>
      reportPhishingMethodDescriptor =
          MethodDescriptor.<ReportPhishingRequest, ReportPhishingResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.phishingprotection.v1beta1.PhishingProtectionServiceV1Beta1/ReportPhishing")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReportPhishingRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReportPhishingResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ReportPhishingRequest, ReportPhishingResponse> reportPhishingCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPhishingProtectionServiceV1Beta1Stub create(
      PhishingProtectionServiceV1Beta1StubSettings settings) throws IOException {
    return new GrpcPhishingProtectionServiceV1Beta1Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcPhishingProtectionServiceV1Beta1Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPhishingProtectionServiceV1Beta1Stub(
        PhishingProtectionServiceV1Beta1StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPhishingProtectionServiceV1Beta1Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPhishingProtectionServiceV1Beta1Stub(
        PhishingProtectionServiceV1Beta1StubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcPhishingProtectionServiceV1Beta1Stub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcPhishingProtectionServiceV1Beta1Stub(
      PhishingProtectionServiceV1Beta1StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPhishingProtectionServiceV1Beta1CallableFactory());
  }

  /**
   * Constructs an instance of GrpcPhishingProtectionServiceV1Beta1Stub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcPhishingProtectionServiceV1Beta1Stub(
      PhishingProtectionServiceV1Beta1StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ReportPhishingRequest, ReportPhishingResponse>
        reportPhishingTransportSettings =
            GrpcCallSettings.<ReportPhishingRequest, ReportPhishingResponse>newBuilder()
                .setMethodDescriptor(reportPhishingMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ReportPhishingRequest>() {
                      @Override
                      public Map<String, String> extract(ReportPhishingRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.reportPhishingCallable =
        callableFactory.createUnaryCallable(
            reportPhishingTransportSettings, settings.reportPhishingSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ReportPhishingRequest, ReportPhishingResponse> reportPhishingCallable() {
    return reportPhishingCallable;
  }

  @Override
  public final void close() {
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
