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

package com.google.cloud.devtools.containeranalysis.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.containeranalysis.v1beta1.ExportSBOMRequest;
import com.google.containeranalysis.v1beta1.ExportSBOMResponse;
import com.google.containeranalysis.v1beta1.GeneratePackagesSummaryRequest;
import com.google.containeranalysis.v1beta1.PackagesSummaryResponse;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ContainerAnalysisV1Beta1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcContainerAnalysisV1Beta1Stub extends ContainerAnalysisV1Beta1Stub {
  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GeneratePackagesSummaryRequest, PackagesSummaryResponse>
      generatePackagesSummaryMethodDescriptor =
          MethodDescriptor.<GeneratePackagesSummaryRequest, PackagesSummaryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1/GeneratePackagesSummary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GeneratePackagesSummaryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PackagesSummaryResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportSBOMRequest, ExportSBOMResponse>
      exportSBOMMethodDescriptor =
          MethodDescriptor.<ExportSBOMRequest, ExportSBOMResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1/ExportSBOM")
              .setRequestMarshaller(ProtoUtils.marshaller(ExportSBOMRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExportSBOMResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<GeneratePackagesSummaryRequest, PackagesSummaryResponse>
      generatePackagesSummaryCallable;
  private final UnaryCallable<ExportSBOMRequest, ExportSBOMResponse> exportSBOMCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcContainerAnalysisV1Beta1Stub create(
      ContainerAnalysisV1Beta1StubSettings settings) throws IOException {
    return new GrpcContainerAnalysisV1Beta1Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcContainerAnalysisV1Beta1Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcContainerAnalysisV1Beta1Stub(
        ContainerAnalysisV1Beta1StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcContainerAnalysisV1Beta1Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcContainerAnalysisV1Beta1Stub(
        ContainerAnalysisV1Beta1StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcContainerAnalysisV1Beta1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcContainerAnalysisV1Beta1Stub(
      ContainerAnalysisV1Beta1StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcContainerAnalysisV1Beta1CallableFactory());
  }

  /**
   * Constructs an instance of GrpcContainerAnalysisV1Beta1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcContainerAnalysisV1Beta1Stub(
      ContainerAnalysisV1Beta1StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GeneratePackagesSummaryRequest, PackagesSummaryResponse>
        generatePackagesSummaryTransportSettings =
            GrpcCallSettings.<GeneratePackagesSummaryRequest, PackagesSummaryResponse>newBuilder()
                .setMethodDescriptor(generatePackagesSummaryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ExportSBOMRequest, ExportSBOMResponse> exportSBOMTransportSettings =
        GrpcCallSettings.<ExportSBOMRequest, ExportSBOMResponse>newBuilder()
            .setMethodDescriptor(exportSBOMMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.generatePackagesSummaryCallable =
        callableFactory.createUnaryCallable(
            generatePackagesSummaryTransportSettings,
            settings.generatePackagesSummarySettings(),
            clientContext);
    this.exportSBOMCallable =
        callableFactory.createUnaryCallable(
            exportSBOMTransportSettings, settings.exportSBOMSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<GeneratePackagesSummaryRequest, PackagesSummaryResponse>
      generatePackagesSummaryCallable() {
    return generatePackagesSummaryCallable;
  }

  @Override
  public UnaryCallable<ExportSBOMRequest, ExportSBOMResponse> exportSBOMCallable() {
    return exportSBOMCallable;
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
