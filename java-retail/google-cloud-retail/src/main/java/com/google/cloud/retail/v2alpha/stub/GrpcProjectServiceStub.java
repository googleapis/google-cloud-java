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

package com.google.cloud.retail.v2alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.AcceptTermsRequest;
import com.google.cloud.retail.v2alpha.AlertConfig;
import com.google.cloud.retail.v2alpha.EnrollSolutionMetadata;
import com.google.cloud.retail.v2alpha.EnrollSolutionRequest;
import com.google.cloud.retail.v2alpha.EnrollSolutionResponse;
import com.google.cloud.retail.v2alpha.GetAlertConfigRequest;
import com.google.cloud.retail.v2alpha.GetLoggingConfigRequest;
import com.google.cloud.retail.v2alpha.GetProjectRequest;
import com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest;
import com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse;
import com.google.cloud.retail.v2alpha.LoggingConfig;
import com.google.cloud.retail.v2alpha.Project;
import com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest;
import com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest;
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
          .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/GetProject")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProjectRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Project.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<AcceptTermsRequest, Project> acceptTermsMethodDescriptor =
      MethodDescriptor.<AcceptTermsRequest, Project>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/AcceptTerms")
          .setRequestMarshaller(ProtoUtils.marshaller(AcceptTermsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Project.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<EnrollSolutionRequest, Operation>
      enrollSolutionMethodDescriptor =
          MethodDescriptor.<EnrollSolutionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/EnrollSolution")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnrollSolutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
      listEnrolledSolutionsMethodDescriptor =
          MethodDescriptor.<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/ListEnrolledSolutions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEnrolledSolutionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEnrolledSolutionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLoggingConfigRequest, LoggingConfig>
      getLoggingConfigMethodDescriptor =
          MethodDescriptor.<GetLoggingConfigRequest, LoggingConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/GetLoggingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLoggingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LoggingConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateLoggingConfigRequest, LoggingConfig>
      updateLoggingConfigMethodDescriptor =
          MethodDescriptor.<UpdateLoggingConfigRequest, LoggingConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/UpdateLoggingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateLoggingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LoggingConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAlertConfigRequest, AlertConfig>
      getAlertConfigMethodDescriptor =
          MethodDescriptor.<GetAlertConfigRequest, AlertConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/GetAlertConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAlertConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AlertConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAlertConfigRequest, AlertConfig>
      updateAlertConfigMethodDescriptor =
          MethodDescriptor.<UpdateAlertConfigRequest, AlertConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/UpdateAlertConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAlertConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AlertConfig.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetProjectRequest, Project> getProjectCallable;
  private final UnaryCallable<AcceptTermsRequest, Project> acceptTermsCallable;
  private final UnaryCallable<EnrollSolutionRequest, Operation> enrollSolutionCallable;
  private final OperationCallable<
          EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
      enrollSolutionOperationCallable;
  private final UnaryCallable<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
      listEnrolledSolutionsCallable;
  private final UnaryCallable<GetLoggingConfigRequest, LoggingConfig> getLoggingConfigCallable;
  private final UnaryCallable<UpdateLoggingConfigRequest, LoggingConfig>
      updateLoggingConfigCallable;
  private final UnaryCallable<GetAlertConfigRequest, AlertConfig> getAlertConfigCallable;
  private final UnaryCallable<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigCallable;

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
    GrpcCallSettings<AcceptTermsRequest, Project> acceptTermsTransportSettings =
        GrpcCallSettings.<AcceptTermsRequest, Project>newBuilder()
            .setMethodDescriptor(acceptTermsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EnrollSolutionRequest, Operation> enrollSolutionTransportSettings =
        GrpcCallSettings.<EnrollSolutionRequest, Operation>newBuilder()
            .setMethodDescriptor(enrollSolutionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
        listEnrolledSolutionsTransportSettings =
            GrpcCallSettings
                .<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>newBuilder()
                .setMethodDescriptor(listEnrolledSolutionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetLoggingConfigRequest, LoggingConfig> getLoggingConfigTransportSettings =
        GrpcCallSettings.<GetLoggingConfigRequest, LoggingConfig>newBuilder()
            .setMethodDescriptor(getLoggingConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateLoggingConfigRequest, LoggingConfig>
        updateLoggingConfigTransportSettings =
            GrpcCallSettings.<UpdateLoggingConfigRequest, LoggingConfig>newBuilder()
                .setMethodDescriptor(updateLoggingConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "logging_config.name",
                          String.valueOf(request.getLoggingConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAlertConfigRequest, AlertConfig> getAlertConfigTransportSettings =
        GrpcCallSettings.<GetAlertConfigRequest, AlertConfig>newBuilder()
            .setMethodDescriptor(getAlertConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigTransportSettings =
        GrpcCallSettings.<UpdateAlertConfigRequest, AlertConfig>newBuilder()
            .setMethodDescriptor(updateAlertConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "alert_config.name", String.valueOf(request.getAlertConfig().getName()));
                  return builder.build();
                })
            .build();

    this.getProjectCallable =
        callableFactory.createUnaryCallable(
            getProjectTransportSettings, settings.getProjectSettings(), clientContext);
    this.acceptTermsCallable =
        callableFactory.createUnaryCallable(
            acceptTermsTransportSettings, settings.acceptTermsSettings(), clientContext);
    this.enrollSolutionCallable =
        callableFactory.createUnaryCallable(
            enrollSolutionTransportSettings, settings.enrollSolutionSettings(), clientContext);
    this.enrollSolutionOperationCallable =
        callableFactory.createOperationCallable(
            enrollSolutionTransportSettings,
            settings.enrollSolutionOperationSettings(),
            clientContext,
            operationsStub);
    this.listEnrolledSolutionsCallable =
        callableFactory.createUnaryCallable(
            listEnrolledSolutionsTransportSettings,
            settings.listEnrolledSolutionsSettings(),
            clientContext);
    this.getLoggingConfigCallable =
        callableFactory.createUnaryCallable(
            getLoggingConfigTransportSettings, settings.getLoggingConfigSettings(), clientContext);
    this.updateLoggingConfigCallable =
        callableFactory.createUnaryCallable(
            updateLoggingConfigTransportSettings,
            settings.updateLoggingConfigSettings(),
            clientContext);
    this.getAlertConfigCallable =
        callableFactory.createUnaryCallable(
            getAlertConfigTransportSettings, settings.getAlertConfigSettings(), clientContext);
    this.updateAlertConfigCallable =
        callableFactory.createUnaryCallable(
            updateAlertConfigTransportSettings,
            settings.updateAlertConfigSettings(),
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
  public UnaryCallable<AcceptTermsRequest, Project> acceptTermsCallable() {
    return acceptTermsCallable;
  }

  @Override
  public UnaryCallable<EnrollSolutionRequest, Operation> enrollSolutionCallable() {
    return enrollSolutionCallable;
  }

  @Override
  public OperationCallable<EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
      enrollSolutionOperationCallable() {
    return enrollSolutionOperationCallable;
  }

  @Override
  public UnaryCallable<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
      listEnrolledSolutionsCallable() {
    return listEnrolledSolutionsCallable;
  }

  @Override
  public UnaryCallable<GetLoggingConfigRequest, LoggingConfig> getLoggingConfigCallable() {
    return getLoggingConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateLoggingConfigRequest, LoggingConfig> updateLoggingConfigCallable() {
    return updateLoggingConfigCallable;
  }

  @Override
  public UnaryCallable<GetAlertConfigRequest, AlertConfig> getAlertConfigCallable() {
    return getAlertConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigCallable() {
    return updateAlertConfigCallable;
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
