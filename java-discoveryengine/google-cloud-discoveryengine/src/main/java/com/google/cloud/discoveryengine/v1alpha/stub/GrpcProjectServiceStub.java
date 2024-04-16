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

package com.google.cloud.discoveryengine.v1alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.GetProjectRequest;
import com.google.cloud.discoveryengine.v1alpha.Project;
import com.google.cloud.discoveryengine.v1alpha.ProvisionProjectMetadata;
import com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest;
import com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ProjectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcProjectServiceStub extends ProjectServiceStub {
  private static final MethodDescriptor<GetProjectRequest, Project> getProjectMethodDescriptor =
      MethodDescriptor.<GetProjectRequest, Project>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1alpha.ProjectService/GetProject")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProjectRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Project.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ProvisionProjectRequest, Operation>
      provisionProjectMethodDescriptor =
          MethodDescriptor.<ProvisionProjectRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.ProjectService/ProvisionProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ProvisionProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReportConsentChangeRequest, Project>
      reportConsentChangeMethodDescriptor =
          MethodDescriptor.<ReportConsentChangeRequest, Project>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.ProjectService/ReportConsentChange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReportConsentChangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Project.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetProjectRequest, Project> getProjectCallable;
  private final UnaryCallable<ProvisionProjectRequest, Operation> provisionProjectCallable;
  private final OperationCallable<ProvisionProjectRequest, Project, ProvisionProjectMetadata>
      provisionProjectOperationCallable;
  private final UnaryCallable<ReportConsentChangeRequest, Project> reportConsentChangeCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcProjectServiceStub create(ProjectServiceStubSettings settings)
      throws IOException {
    return new GrpcProjectServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcProjectServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcProjectServiceStub(
        ProjectServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcProjectServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcProjectServiceStub(
        ProjectServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcProjectServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProjectServiceStub(ProjectServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcProjectServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcProjectServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProjectServiceStub(
      ProjectServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetProjectRequest, Project> getProjectTransportSettings =
        GrpcCallSettings.<GetProjectRequest, Project>newBuilder()
            .setMethodDescriptor(getProjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ProvisionProjectRequest, Operation> provisionProjectTransportSettings =
        GrpcCallSettings.<ProvisionProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(provisionProjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ReportConsentChangeRequest, Project> reportConsentChangeTransportSettings =
        GrpcCallSettings.<ReportConsentChangeRequest, Project>newBuilder()
            .setMethodDescriptor(reportConsentChangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();

    this.getProjectCallable =
        callableFactory.createUnaryCallable(
            getProjectTransportSettings, settings.getProjectSettings(), clientContext);
    this.provisionProjectCallable =
        callableFactory.createUnaryCallable(
            provisionProjectTransportSettings, settings.provisionProjectSettings(), clientContext);
    this.provisionProjectOperationCallable =
        callableFactory.createOperationCallable(
            provisionProjectTransportSettings,
            settings.provisionProjectOperationSettings(),
            clientContext,
            operationsStub);
    this.reportConsentChangeCallable =
        callableFactory.createUnaryCallable(
            reportConsentChangeTransportSettings,
            settings.reportConsentChangeSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetProjectRequest, Project> getProjectCallable() {
    return getProjectCallable;
  }

  @Override
  public UnaryCallable<ProvisionProjectRequest, Operation> provisionProjectCallable() {
    return provisionProjectCallable;
  }

  @Override
  public OperationCallable<ProvisionProjectRequest, Project, ProvisionProjectMetadata>
      provisionProjectOperationCallable() {
    return provisionProjectOperationCallable;
  }

  @Override
  public UnaryCallable<ReportConsentChangeRequest, Project> reportConsentChangeCallable() {
    return reportConsentChangeCallable;
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
