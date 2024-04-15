/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.cloudcontrolspartner.v1.stub;

import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerMonitoringClient.ListViolationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudcontrolspartner.v1.GetViolationRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListViolationsRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListViolationsResponse;
import com.google.cloud.cloudcontrolspartner.v1.Violation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudControlsPartnerMonitoring service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCloudControlsPartnerMonitoringStub extends CloudControlsPartnerMonitoringStub {
  private static final MethodDescriptor<ListViolationsRequest, ListViolationsResponse>
      listViolationsMethodDescriptor =
          MethodDescriptor.<ListViolationsRequest, ListViolationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerMonitoring/ListViolations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListViolationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListViolationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetViolationRequest, Violation>
      getViolationMethodDescriptor =
          MethodDescriptor.<GetViolationRequest, Violation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerMonitoring/GetViolation")
              .setRequestMarshaller(ProtoUtils.marshaller(GetViolationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Violation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListViolationsRequest, ListViolationsResponse> listViolationsCallable;
  private final UnaryCallable<ListViolationsRequest, ListViolationsPagedResponse>
      listViolationsPagedCallable;
  private final UnaryCallable<GetViolationRequest, Violation> getViolationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudControlsPartnerMonitoringStub create(
      CloudControlsPartnerMonitoringStubSettings settings) throws IOException {
    return new GrpcCloudControlsPartnerMonitoringStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudControlsPartnerMonitoringStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudControlsPartnerMonitoringStub(
        CloudControlsPartnerMonitoringStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudControlsPartnerMonitoringStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudControlsPartnerMonitoringStub(
        CloudControlsPartnerMonitoringStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudControlsPartnerMonitoringStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcCloudControlsPartnerMonitoringStub(
      CloudControlsPartnerMonitoringStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCloudControlsPartnerMonitoringCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudControlsPartnerMonitoringStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcCloudControlsPartnerMonitoringStub(
      CloudControlsPartnerMonitoringStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListViolationsRequest, ListViolationsResponse>
        listViolationsTransportSettings =
            GrpcCallSettings.<ListViolationsRequest, ListViolationsResponse>newBuilder()
                .setMethodDescriptor(listViolationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetViolationRequest, Violation> getViolationTransportSettings =
        GrpcCallSettings.<GetViolationRequest, Violation>newBuilder()
            .setMethodDescriptor(getViolationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listViolationsCallable =
        callableFactory.createUnaryCallable(
            listViolationsTransportSettings, settings.listViolationsSettings(), clientContext);
    this.listViolationsPagedCallable =
        callableFactory.createPagedCallable(
            listViolationsTransportSettings, settings.listViolationsSettings(), clientContext);
    this.getViolationCallable =
        callableFactory.createUnaryCallable(
            getViolationTransportSettings, settings.getViolationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListViolationsRequest, ListViolationsResponse> listViolationsCallable() {
    return listViolationsCallable;
  }

  @Override
  public UnaryCallable<ListViolationsRequest, ListViolationsPagedResponse>
      listViolationsPagedCallable() {
    return listViolationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetViolationRequest, Violation> getViolationCallable() {
    return getViolationCallable;
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
