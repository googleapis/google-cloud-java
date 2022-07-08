/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.devtools.containeranalysis.v1beta1.stub;

import static com.google.cloud.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1Client.ListScanConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.containeranalysis.v1beta1.GetScanConfigRequest;
import com.google.containeranalysis.v1beta1.ListScanConfigsRequest;
import com.google.containeranalysis.v1beta1.ListScanConfigsResponse;
import com.google.containeranalysis.v1beta1.ScanConfig;
import com.google.containeranalysis.v1beta1.UpdateScanConfigRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Container Analysis API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
  private static final MethodDescriptor<GetScanConfigRequest, ScanConfig>
      getScanConfigMethodDescriptor =
          MethodDescriptor.<GetScanConfigRequest, ScanConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1/GetScanConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetScanConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ScanConfig.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListScanConfigsRequest, ListScanConfigsResponse>
      listScanConfigsMethodDescriptor =
          MethodDescriptor.<ListScanConfigsRequest, ListScanConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1/ListScanConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListScanConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListScanConfigsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateScanConfigRequest, ScanConfig>
      updateScanConfigMethodDescriptor =
          MethodDescriptor.<UpdateScanConfigRequest, ScanConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1/UpdateScanConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateScanConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ScanConfig.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<GetScanConfigRequest, ScanConfig> getScanConfigCallable;
  private final UnaryCallable<ListScanConfigsRequest, ListScanConfigsResponse>
      listScanConfigsCallable;
  private final UnaryCallable<ListScanConfigsRequest, ListScanConfigsPagedResponse>
      listScanConfigsPagedCallable;
  private final UnaryCallable<UpdateScanConfigRequest, ScanConfig> updateScanConfigCallable;

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

    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(SetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(GetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<TestIamPermissionsRequest>() {
                      @Override
                      public Map<String, String> extract(TestIamPermissionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("resource", String.valueOf(request.getResource()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetScanConfigRequest, ScanConfig> getScanConfigTransportSettings =
        GrpcCallSettings.<GetScanConfigRequest, ScanConfig>newBuilder()
            .setMethodDescriptor(getScanConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetScanConfigRequest>() {
                  @Override
                  public Map<String, String> extract(GetScanConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListScanConfigsRequest, ListScanConfigsResponse>
        listScanConfigsTransportSettings =
            GrpcCallSettings.<ListScanConfigsRequest, ListScanConfigsResponse>newBuilder()
                .setMethodDescriptor(listScanConfigsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListScanConfigsRequest>() {
                      @Override
                      public Map<String, String> extract(ListScanConfigsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateScanConfigRequest, ScanConfig> updateScanConfigTransportSettings =
        GrpcCallSettings.<UpdateScanConfigRequest, ScanConfig>newBuilder()
            .setMethodDescriptor(updateScanConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateScanConfigRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateScanConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
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
    this.getScanConfigCallable =
        callableFactory.createUnaryCallable(
            getScanConfigTransportSettings, settings.getScanConfigSettings(), clientContext);
    this.listScanConfigsCallable =
        callableFactory.createUnaryCallable(
            listScanConfigsTransportSettings, settings.listScanConfigsSettings(), clientContext);
    this.listScanConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listScanConfigsTransportSettings, settings.listScanConfigsSettings(), clientContext);
    this.updateScanConfigCallable =
        callableFactory.createUnaryCallable(
            updateScanConfigTransportSettings, settings.updateScanConfigSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  public UnaryCallable<GetScanConfigRequest, ScanConfig> getScanConfigCallable() {
    return getScanConfigCallable;
  }

  public UnaryCallable<ListScanConfigsRequest, ListScanConfigsPagedResponse>
      listScanConfigsPagedCallable() {
    return listScanConfigsPagedCallable;
  }

  public UnaryCallable<ListScanConfigsRequest, ListScanConfigsResponse> listScanConfigsCallable() {
    return listScanConfigsCallable;
  }

  public UnaryCallable<UpdateScanConfigRequest, ScanConfig> updateScanConfigCallable() {
    return updateScanConfigCallable;
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
