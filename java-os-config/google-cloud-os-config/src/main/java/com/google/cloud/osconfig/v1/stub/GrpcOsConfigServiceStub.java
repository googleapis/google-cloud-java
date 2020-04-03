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
package com.google.cloud.osconfig.v1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.osconfig.v1.PatchDeployments.CreatePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.DeletePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.GetPatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsResponse;
import com.google.cloud.osconfig.v1.PatchDeployments.PatchDeployment;
import com.google.cloud.osconfig.v1.PatchJobs.CancelPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ExecutePatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.GetPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.PatchJob;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Cloud OS Config API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcOsConfigServiceStub extends OsConfigServiceStub {

  private static final MethodDescriptor<ExecutePatchJobRequest, PatchJob>
      executePatchJobMethodDescriptor =
          MethodDescriptor.<ExecutePatchJobRequest, PatchJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1.OsConfigService/ExecutePatchJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExecutePatchJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PatchJob.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetPatchJobRequest, PatchJob> getPatchJobMethodDescriptor =
      MethodDescriptor.<GetPatchJobRequest, PatchJob>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.osconfig.v1.OsConfigService/GetPatchJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPatchJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(PatchJob.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<CancelPatchJobRequest, PatchJob>
      cancelPatchJobMethodDescriptor =
          MethodDescriptor.<CancelPatchJobRequest, PatchJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1.OsConfigService/CancelPatchJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelPatchJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PatchJob.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListPatchJobsRequest, ListPatchJobsResponse>
      listPatchJobsMethodDescriptor =
          MethodDescriptor.<ListPatchJobsRequest, ListPatchJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1.OsConfigService/ListPatchJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPatchJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPatchJobsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<
          ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsMethodDescriptor =
          MethodDescriptor
              .<ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigService/ListPatchJobInstanceDetails")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPatchJobInstanceDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPatchJobInstanceDetailsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreatePatchDeploymentRequest, PatchDeployment>
      createPatchDeploymentMethodDescriptor =
          MethodDescriptor.<CreatePatchDeploymentRequest, PatchDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1.OsConfigService/CreatePatchDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PatchDeployment.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetPatchDeploymentRequest, PatchDeployment>
      getPatchDeploymentMethodDescriptor =
          MethodDescriptor.<GetPatchDeploymentRequest, PatchDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1.OsConfigService/GetPatchDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PatchDeployment.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>
      listPatchDeploymentsMethodDescriptor =
          MethodDescriptor.<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1.OsConfigService/ListPatchDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPatchDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPatchDeploymentsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeletePatchDeploymentRequest, Empty>
      deletePatchDeploymentMethodDescriptor =
          MethodDescriptor.<DeletePatchDeploymentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1.OsConfigService/DeletePatchDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<ExecutePatchJobRequest, PatchJob> executePatchJobCallable;
  private final UnaryCallable<GetPatchJobRequest, PatchJob> getPatchJobCallable;
  private final UnaryCallable<CancelPatchJobRequest, PatchJob> cancelPatchJobCallable;
  private final UnaryCallable<ListPatchJobsRequest, ListPatchJobsResponse> listPatchJobsCallable;
  private final UnaryCallable<
          ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsCallable;
  private final UnaryCallable<CreatePatchDeploymentRequest, PatchDeployment>
      createPatchDeploymentCallable;
  private final UnaryCallable<GetPatchDeploymentRequest, PatchDeployment>
      getPatchDeploymentCallable;
  private final UnaryCallable<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>
      listPatchDeploymentsCallable;
  private final UnaryCallable<DeletePatchDeploymentRequest, Empty> deletePatchDeploymentCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcOsConfigServiceStub create(OsConfigServiceStubSettings settings)
      throws IOException {
    return new GrpcOsConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOsConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOsConfigServiceStub(
        OsConfigServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOsConfigServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOsConfigServiceStub(
        OsConfigServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcOsConfigServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcOsConfigServiceStub(
      OsConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcOsConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOsConfigServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcOsConfigServiceStub(
      OsConfigServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<ExecutePatchJobRequest, PatchJob> executePatchJobTransportSettings =
        GrpcCallSettings.<ExecutePatchJobRequest, PatchJob>newBuilder()
            .setMethodDescriptor(executePatchJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExecutePatchJobRequest>() {
                  @Override
                  public Map<String, String> extract(ExecutePatchJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetPatchJobRequest, PatchJob> getPatchJobTransportSettings =
        GrpcCallSettings.<GetPatchJobRequest, PatchJob>newBuilder()
            .setMethodDescriptor(getPatchJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetPatchJobRequest>() {
                  @Override
                  public Map<String, String> extract(GetPatchJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CancelPatchJobRequest, PatchJob> cancelPatchJobTransportSettings =
        GrpcCallSettings.<CancelPatchJobRequest, PatchJob>newBuilder()
            .setMethodDescriptor(cancelPatchJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CancelPatchJobRequest>() {
                  @Override
                  public Map<String, String> extract(CancelPatchJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListPatchJobsRequest, ListPatchJobsResponse> listPatchJobsTransportSettings =
        GrpcCallSettings.<ListPatchJobsRequest, ListPatchJobsResponse>newBuilder()
            .setMethodDescriptor(listPatchJobsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListPatchJobsRequest>() {
                  @Override
                  public Map<String, String> extract(ListPatchJobsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
        listPatchJobInstanceDetailsTransportSettings =
            GrpcCallSettings
                .<ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
                    newBuilder()
                .setMethodDescriptor(listPatchJobInstanceDetailsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListPatchJobInstanceDetailsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          ListPatchJobInstanceDetailsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreatePatchDeploymentRequest, PatchDeployment>
        createPatchDeploymentTransportSettings =
            GrpcCallSettings.<CreatePatchDeploymentRequest, PatchDeployment>newBuilder()
                .setMethodDescriptor(createPatchDeploymentMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreatePatchDeploymentRequest>() {
                      @Override
                      public Map<String, String> extract(CreatePatchDeploymentRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetPatchDeploymentRequest, PatchDeployment>
        getPatchDeploymentTransportSettings =
            GrpcCallSettings.<GetPatchDeploymentRequest, PatchDeployment>newBuilder()
                .setMethodDescriptor(getPatchDeploymentMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetPatchDeploymentRequest>() {
                      @Override
                      public Map<String, String> extract(GetPatchDeploymentRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>
        listPatchDeploymentsTransportSettings =
            GrpcCallSettings.<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listPatchDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListPatchDeploymentsRequest>() {
                      @Override
                      public Map<String, String> extract(ListPatchDeploymentsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeletePatchDeploymentRequest, Empty> deletePatchDeploymentTransportSettings =
        GrpcCallSettings.<DeletePatchDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePatchDeploymentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeletePatchDeploymentRequest>() {
                  @Override
                  public Map<String, String> extract(DeletePatchDeploymentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.executePatchJobCallable =
        callableFactory.createUnaryCallable(
            executePatchJobTransportSettings, settings.executePatchJobSettings(), clientContext);
    this.getPatchJobCallable =
        callableFactory.createUnaryCallable(
            getPatchJobTransportSettings, settings.getPatchJobSettings(), clientContext);
    this.cancelPatchJobCallable =
        callableFactory.createUnaryCallable(
            cancelPatchJobTransportSettings, settings.cancelPatchJobSettings(), clientContext);
    this.listPatchJobsCallable =
        callableFactory.createUnaryCallable(
            listPatchJobsTransportSettings, settings.listPatchJobsSettings(), clientContext);
    this.listPatchJobInstanceDetailsCallable =
        callableFactory.createUnaryCallable(
            listPatchJobInstanceDetailsTransportSettings,
            settings.listPatchJobInstanceDetailsSettings(),
            clientContext);
    this.createPatchDeploymentCallable =
        callableFactory.createUnaryCallable(
            createPatchDeploymentTransportSettings,
            settings.createPatchDeploymentSettings(),
            clientContext);
    this.getPatchDeploymentCallable =
        callableFactory.createUnaryCallable(
            getPatchDeploymentTransportSettings,
            settings.getPatchDeploymentSettings(),
            clientContext);
    this.listPatchDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listPatchDeploymentsTransportSettings,
            settings.listPatchDeploymentsSettings(),
            clientContext);
    this.deletePatchDeploymentCallable =
        callableFactory.createUnaryCallable(
            deletePatchDeploymentTransportSettings,
            settings.deletePatchDeploymentSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<ExecutePatchJobRequest, PatchJob> executePatchJobCallable() {
    return executePatchJobCallable;
  }

  public UnaryCallable<GetPatchJobRequest, PatchJob> getPatchJobCallable() {
    return getPatchJobCallable;
  }

  public UnaryCallable<CancelPatchJobRequest, PatchJob> cancelPatchJobCallable() {
    return cancelPatchJobCallable;
  }

  public UnaryCallable<ListPatchJobsRequest, ListPatchJobsResponse> listPatchJobsCallable() {
    return listPatchJobsCallable;
  }

  public UnaryCallable<ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsCallable() {
    return listPatchJobInstanceDetailsCallable;
  }

  public UnaryCallable<CreatePatchDeploymentRequest, PatchDeployment>
      createPatchDeploymentCallable() {
    return createPatchDeploymentCallable;
  }

  public UnaryCallable<GetPatchDeploymentRequest, PatchDeployment> getPatchDeploymentCallable() {
    return getPatchDeploymentCallable;
  }

  public UnaryCallable<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>
      listPatchDeploymentsCallable() {
    return listPatchDeploymentsCallable;
  }

  public UnaryCallable<DeletePatchDeploymentRequest, Empty> deletePatchDeploymentCallable() {
    return deletePatchDeploymentCallable;
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
