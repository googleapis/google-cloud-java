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

package com.google.cloud.devtools.cloudbuild.v1.stub;

import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildTriggersPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloudbuild.v1.Build;
import com.google.cloudbuild.v1.BuildOperationMetadata;
import com.google.cloudbuild.v1.BuildTrigger;
import com.google.cloudbuild.v1.CancelBuildRequest;
import com.google.cloudbuild.v1.CreateBuildRequest;
import com.google.cloudbuild.v1.CreateBuildTriggerRequest;
import com.google.cloudbuild.v1.CreateWorkerPoolRequest;
import com.google.cloudbuild.v1.DeleteBuildTriggerRequest;
import com.google.cloudbuild.v1.DeleteWorkerPoolRequest;
import com.google.cloudbuild.v1.GetBuildRequest;
import com.google.cloudbuild.v1.GetBuildTriggerRequest;
import com.google.cloudbuild.v1.GetWorkerPoolRequest;
import com.google.cloudbuild.v1.ListBuildTriggersRequest;
import com.google.cloudbuild.v1.ListBuildTriggersResponse;
import com.google.cloudbuild.v1.ListBuildsRequest;
import com.google.cloudbuild.v1.ListBuildsResponse;
import com.google.cloudbuild.v1.ListWorkerPoolsRequest;
import com.google.cloudbuild.v1.ListWorkerPoolsResponse;
import com.google.cloudbuild.v1.RetryBuildRequest;
import com.google.cloudbuild.v1.RunBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateWorkerPoolRequest;
import com.google.cloudbuild.v1.WorkerPool;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudBuild service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCloudBuildStub extends CloudBuildStub {
  private static final MethodDescriptor<CreateBuildRequest, Operation> createBuildMethodDescriptor =
      MethodDescriptor.<CreateBuildRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/CreateBuild")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateBuildRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetBuildRequest, Build> getBuildMethodDescriptor =
      MethodDescriptor.<GetBuildRequest, Build>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/GetBuild")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBuildRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Build.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListBuildsRequest, ListBuildsResponse>
      listBuildsMethodDescriptor =
          MethodDescriptor.<ListBuildsRequest, ListBuildsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/ListBuilds")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBuildsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListBuildsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelBuildRequest, Build> cancelBuildMethodDescriptor =
      MethodDescriptor.<CancelBuildRequest, Build>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/CancelBuild")
          .setRequestMarshaller(ProtoUtils.marshaller(CancelBuildRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Build.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<RetryBuildRequest, Operation> retryBuildMethodDescriptor =
      MethodDescriptor.<RetryBuildRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/RetryBuild")
          .setRequestMarshaller(ProtoUtils.marshaller(RetryBuildRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateBuildTriggerRequest, BuildTrigger>
      createBuildTriggerMethodDescriptor =
          MethodDescriptor.<CreateBuildTriggerRequest, BuildTrigger>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/CreateBuildTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBuildTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BuildTrigger.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBuildTriggerRequest, BuildTrigger>
      getBuildTriggerMethodDescriptor =
          MethodDescriptor.<GetBuildTriggerRequest, BuildTrigger>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/GetBuildTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBuildTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BuildTrigger.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBuildTriggersRequest, ListBuildTriggersResponse>
      listBuildTriggersMethodDescriptor =
          MethodDescriptor.<ListBuildTriggersRequest, ListBuildTriggersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/ListBuildTriggers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBuildTriggersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBuildTriggersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBuildTriggerRequest, Empty>
      deleteBuildTriggerMethodDescriptor =
          MethodDescriptor.<DeleteBuildTriggerRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/DeleteBuildTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBuildTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateBuildTriggerRequest, BuildTrigger>
      updateBuildTriggerMethodDescriptor =
          MethodDescriptor.<UpdateBuildTriggerRequest, BuildTrigger>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/UpdateBuildTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBuildTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BuildTrigger.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RunBuildTriggerRequest, Operation>
      runBuildTriggerMethodDescriptor =
          MethodDescriptor.<RunBuildTriggerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/RunBuildTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunBuildTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateWorkerPoolRequest, WorkerPool>
      createWorkerPoolMethodDescriptor =
          MethodDescriptor.<CreateWorkerPoolRequest, WorkerPool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/CreateWorkerPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkerPool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkerPoolRequest, WorkerPool>
      getWorkerPoolMethodDescriptor =
          MethodDescriptor.<GetWorkerPoolRequest, WorkerPool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/GetWorkerPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkerPool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkerPoolRequest, Empty>
      deleteWorkerPoolMethodDescriptor =
          MethodDescriptor.<DeleteWorkerPoolRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/DeleteWorkerPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateWorkerPoolRequest, WorkerPool>
      updateWorkerPoolMethodDescriptor =
          MethodDescriptor.<UpdateWorkerPoolRequest, WorkerPool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/UpdateWorkerPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkerPool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsMethodDescriptor =
          MethodDescriptor.<ListWorkerPoolsRequest, ListWorkerPoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudbuild.v1.CloudBuild/ListWorkerPools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkerPoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkerPoolsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateBuildRequest, Operation> createBuildCallable;
  private final OperationCallable<CreateBuildRequest, Build, BuildOperationMetadata>
      createBuildOperationCallable;
  private final UnaryCallable<GetBuildRequest, Build> getBuildCallable;
  private final UnaryCallable<ListBuildsRequest, ListBuildsResponse> listBuildsCallable;
  private final UnaryCallable<ListBuildsRequest, ListBuildsPagedResponse> listBuildsPagedCallable;
  private final UnaryCallable<CancelBuildRequest, Build> cancelBuildCallable;
  private final UnaryCallable<RetryBuildRequest, Operation> retryBuildCallable;
  private final OperationCallable<RetryBuildRequest, Build, BuildOperationMetadata>
      retryBuildOperationCallable;
  private final UnaryCallable<CreateBuildTriggerRequest, BuildTrigger> createBuildTriggerCallable;
  private final UnaryCallable<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerCallable;
  private final UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersResponse>
      listBuildTriggersCallable;
  private final UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersPagedResponse>
      listBuildTriggersPagedCallable;
  private final UnaryCallable<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerCallable;
  private final UnaryCallable<UpdateBuildTriggerRequest, BuildTrigger> updateBuildTriggerCallable;
  private final UnaryCallable<RunBuildTriggerRequest, Operation> runBuildTriggerCallable;
  private final OperationCallable<RunBuildTriggerRequest, Build, BuildOperationMetadata>
      runBuildTriggerOperationCallable;
  private final UnaryCallable<CreateWorkerPoolRequest, WorkerPool> createWorkerPoolCallable;
  private final UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable;
  private final UnaryCallable<DeleteWorkerPoolRequest, Empty> deleteWorkerPoolCallable;
  private final UnaryCallable<UpdateWorkerPoolRequest, WorkerPool> updateWorkerPoolCallable;
  private final UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudBuildStub create(CloudBuildStubSettings settings)
      throws IOException {
    return new GrpcCloudBuildStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudBuildStub create(ClientContext clientContext) throws IOException {
    return new GrpcCloudBuildStub(CloudBuildStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudBuildStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudBuildStub(
        CloudBuildStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudBuildStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudBuildStub(CloudBuildStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCloudBuildCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudBuildStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudBuildStub(
      CloudBuildStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateBuildRequest, Operation> createBuildTransportSettings =
        GrpcCallSettings.<CreateBuildRequest, Operation>newBuilder()
            .setMethodDescriptor(createBuildMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateBuildRequest>() {
                  @Override
                  public Map<String, String> extract(CreateBuildRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetBuildRequest, Build> getBuildTransportSettings =
        GrpcCallSettings.<GetBuildRequest, Build>newBuilder()
            .setMethodDescriptor(getBuildMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetBuildRequest>() {
                  @Override
                  public Map<String, String> extract(GetBuildRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("id", String.valueOf(request.getId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListBuildsRequest, ListBuildsResponse> listBuildsTransportSettings =
        GrpcCallSettings.<ListBuildsRequest, ListBuildsResponse>newBuilder()
            .setMethodDescriptor(listBuildsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListBuildsRequest>() {
                  @Override
                  public Map<String, String> extract(ListBuildsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CancelBuildRequest, Build> cancelBuildTransportSettings =
        GrpcCallSettings.<CancelBuildRequest, Build>newBuilder()
            .setMethodDescriptor(cancelBuildMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CancelBuildRequest>() {
                  @Override
                  public Map<String, String> extract(CancelBuildRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("id", String.valueOf(request.getId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<RetryBuildRequest, Operation> retryBuildTransportSettings =
        GrpcCallSettings.<RetryBuildRequest, Operation>newBuilder()
            .setMethodDescriptor(retryBuildMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<RetryBuildRequest>() {
                  @Override
                  public Map<String, String> extract(RetryBuildRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("id", String.valueOf(request.getId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateBuildTriggerRequest, BuildTrigger> createBuildTriggerTransportSettings =
        GrpcCallSettings.<CreateBuildTriggerRequest, BuildTrigger>newBuilder()
            .setMethodDescriptor(createBuildTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateBuildTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(CreateBuildTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerTransportSettings =
        GrpcCallSettings.<GetBuildTriggerRequest, BuildTrigger>newBuilder()
            .setMethodDescriptor(getBuildTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetBuildTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(GetBuildTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("trigger_id", String.valueOf(request.getTriggerId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListBuildTriggersRequest, ListBuildTriggersResponse>
        listBuildTriggersTransportSettings =
            GrpcCallSettings.<ListBuildTriggersRequest, ListBuildTriggersResponse>newBuilder()
                .setMethodDescriptor(listBuildTriggersMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListBuildTriggersRequest>() {
                      @Override
                      public Map<String, String> extract(ListBuildTriggersRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("project_id", String.valueOf(request.getProjectId()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerTransportSettings =
        GrpcCallSettings.<DeleteBuildTriggerRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBuildTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteBuildTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteBuildTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("trigger_id", String.valueOf(request.getTriggerId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateBuildTriggerRequest, BuildTrigger> updateBuildTriggerTransportSettings =
        GrpcCallSettings.<UpdateBuildTriggerRequest, BuildTrigger>newBuilder()
            .setMethodDescriptor(updateBuildTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateBuildTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateBuildTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("trigger_id", String.valueOf(request.getTriggerId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<RunBuildTriggerRequest, Operation> runBuildTriggerTransportSettings =
        GrpcCallSettings.<RunBuildTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(runBuildTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<RunBuildTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(RunBuildTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("trigger_id", String.valueOf(request.getTriggerId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateWorkerPoolRequest, WorkerPool> createWorkerPoolTransportSettings =
        GrpcCallSettings.<CreateWorkerPoolRequest, WorkerPool>newBuilder()
            .setMethodDescriptor(createWorkerPoolMethodDescriptor)
            .build();
    GrpcCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolTransportSettings =
        GrpcCallSettings.<GetWorkerPoolRequest, WorkerPool>newBuilder()
            .setMethodDescriptor(getWorkerPoolMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteWorkerPoolRequest, Empty> deleteWorkerPoolTransportSettings =
        GrpcCallSettings.<DeleteWorkerPoolRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWorkerPoolMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateWorkerPoolRequest, WorkerPool> updateWorkerPoolTransportSettings =
        GrpcCallSettings.<UpdateWorkerPoolRequest, WorkerPool>newBuilder()
            .setMethodDescriptor(updateWorkerPoolMethodDescriptor)
            .build();
    GrpcCallSettings<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
        listWorkerPoolsTransportSettings =
            GrpcCallSettings.<ListWorkerPoolsRequest, ListWorkerPoolsResponse>newBuilder()
                .setMethodDescriptor(listWorkerPoolsMethodDescriptor)
                .build();

    this.createBuildCallable =
        callableFactory.createUnaryCallable(
            createBuildTransportSettings, settings.createBuildSettings(), clientContext);
    this.createBuildOperationCallable =
        callableFactory.createOperationCallable(
            createBuildTransportSettings,
            settings.createBuildOperationSettings(),
            clientContext,
            operationsStub);
    this.getBuildCallable =
        callableFactory.createUnaryCallable(
            getBuildTransportSettings, settings.getBuildSettings(), clientContext);
    this.listBuildsCallable =
        callableFactory.createUnaryCallable(
            listBuildsTransportSettings, settings.listBuildsSettings(), clientContext);
    this.listBuildsPagedCallable =
        callableFactory.createPagedCallable(
            listBuildsTransportSettings, settings.listBuildsSettings(), clientContext);
    this.cancelBuildCallable =
        callableFactory.createUnaryCallable(
            cancelBuildTransportSettings, settings.cancelBuildSettings(), clientContext);
    this.retryBuildCallable =
        callableFactory.createUnaryCallable(
            retryBuildTransportSettings, settings.retryBuildSettings(), clientContext);
    this.retryBuildOperationCallable =
        callableFactory.createOperationCallable(
            retryBuildTransportSettings,
            settings.retryBuildOperationSettings(),
            clientContext,
            operationsStub);
    this.createBuildTriggerCallable =
        callableFactory.createUnaryCallable(
            createBuildTriggerTransportSettings,
            settings.createBuildTriggerSettings(),
            clientContext);
    this.getBuildTriggerCallable =
        callableFactory.createUnaryCallable(
            getBuildTriggerTransportSettings, settings.getBuildTriggerSettings(), clientContext);
    this.listBuildTriggersCallable =
        callableFactory.createUnaryCallable(
            listBuildTriggersTransportSettings,
            settings.listBuildTriggersSettings(),
            clientContext);
    this.listBuildTriggersPagedCallable =
        callableFactory.createPagedCallable(
            listBuildTriggersTransportSettings,
            settings.listBuildTriggersSettings(),
            clientContext);
    this.deleteBuildTriggerCallable =
        callableFactory.createUnaryCallable(
            deleteBuildTriggerTransportSettings,
            settings.deleteBuildTriggerSettings(),
            clientContext);
    this.updateBuildTriggerCallable =
        callableFactory.createUnaryCallable(
            updateBuildTriggerTransportSettings,
            settings.updateBuildTriggerSettings(),
            clientContext);
    this.runBuildTriggerCallable =
        callableFactory.createUnaryCallable(
            runBuildTriggerTransportSettings, settings.runBuildTriggerSettings(), clientContext);
    this.runBuildTriggerOperationCallable =
        callableFactory.createOperationCallable(
            runBuildTriggerTransportSettings,
            settings.runBuildTriggerOperationSettings(),
            clientContext,
            operationsStub);
    this.createWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            createWorkerPoolTransportSettings, settings.createWorkerPoolSettings(), clientContext);
    this.getWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            getWorkerPoolTransportSettings, settings.getWorkerPoolSettings(), clientContext);
    this.deleteWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            deleteWorkerPoolTransportSettings, settings.deleteWorkerPoolSettings(), clientContext);
    this.updateWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            updateWorkerPoolTransportSettings, settings.updateWorkerPoolSettings(), clientContext);
    this.listWorkerPoolsCallable =
        callableFactory.createUnaryCallable(
            listWorkerPoolsTransportSettings, settings.listWorkerPoolsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateBuildRequest, Operation> createBuildCallable() {
    return createBuildCallable;
  }

  @Override
  public OperationCallable<CreateBuildRequest, Build, BuildOperationMetadata>
      createBuildOperationCallable() {
    return createBuildOperationCallable;
  }

  @Override
  public UnaryCallable<GetBuildRequest, Build> getBuildCallable() {
    return getBuildCallable;
  }

  @Override
  public UnaryCallable<ListBuildsRequest, ListBuildsResponse> listBuildsCallable() {
    return listBuildsCallable;
  }

  @Override
  public UnaryCallable<ListBuildsRequest, ListBuildsPagedResponse> listBuildsPagedCallable() {
    return listBuildsPagedCallable;
  }

  @Override
  public UnaryCallable<CancelBuildRequest, Build> cancelBuildCallable() {
    return cancelBuildCallable;
  }

  @Override
  public UnaryCallable<RetryBuildRequest, Operation> retryBuildCallable() {
    return retryBuildCallable;
  }

  @Override
  public OperationCallable<RetryBuildRequest, Build, BuildOperationMetadata>
      retryBuildOperationCallable() {
    return retryBuildOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBuildTriggerRequest, BuildTrigger> createBuildTriggerCallable() {
    return createBuildTriggerCallable;
  }

  @Override
  public UnaryCallable<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerCallable() {
    return getBuildTriggerCallable;
  }

  @Override
  public UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersResponse>
      listBuildTriggersCallable() {
    return listBuildTriggersCallable;
  }

  @Override
  public UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersPagedResponse>
      listBuildTriggersPagedCallable() {
    return listBuildTriggersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerCallable() {
    return deleteBuildTriggerCallable;
  }

  @Override
  public UnaryCallable<UpdateBuildTriggerRequest, BuildTrigger> updateBuildTriggerCallable() {
    return updateBuildTriggerCallable;
  }

  @Override
  public UnaryCallable<RunBuildTriggerRequest, Operation> runBuildTriggerCallable() {
    return runBuildTriggerCallable;
  }

  @Override
  public OperationCallable<RunBuildTriggerRequest, Build, BuildOperationMetadata>
      runBuildTriggerOperationCallable() {
    return runBuildTriggerOperationCallable;
  }

  @Override
  public UnaryCallable<CreateWorkerPoolRequest, WorkerPool> createWorkerPoolCallable() {
    return createWorkerPoolCallable;
  }

  @Override
  public UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable() {
    return getWorkerPoolCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkerPoolRequest, Empty> deleteWorkerPoolCallable() {
    return deleteWorkerPoolCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkerPoolRequest, WorkerPool> updateWorkerPoolCallable() {
    return updateWorkerPoolCallable;
  }

  @Override
  public UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse> listWorkerPoolsCallable() {
    return listWorkerPoolsCallable;
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
