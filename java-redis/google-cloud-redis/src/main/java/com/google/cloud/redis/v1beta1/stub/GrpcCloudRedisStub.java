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

package com.google.cloud.redis.v1beta1.stub;

import static com.google.cloud.redis.v1beta1.CloudRedisClient.ListInstancesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.redis.v1beta1.CreateInstanceRequest;
import com.google.cloud.redis.v1beta1.DeleteInstanceRequest;
import com.google.cloud.redis.v1beta1.ExportInstanceRequest;
import com.google.cloud.redis.v1beta1.FailoverInstanceRequest;
import com.google.cloud.redis.v1beta1.GetInstanceRequest;
import com.google.cloud.redis.v1beta1.ImportInstanceRequest;
import com.google.cloud.redis.v1beta1.Instance;
import com.google.cloud.redis.v1beta1.ListInstancesRequest;
import com.google.cloud.redis.v1beta1.ListInstancesResponse;
import com.google.cloud.redis.v1beta1.UpdateInstanceRequest;
import com.google.cloud.redis.v1beta1.UpgradeInstanceRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudRedis service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcCloudRedisStub extends CloudRedisStub {
  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.redis.v1beta1.CloudRedis/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.redis.v1beta1.CloudRedis/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.redis.v1beta1.CloudRedis/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          MethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.redis.v1beta1.CloudRedis/UpdateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpgradeInstanceRequest, Operation>
      upgradeInstanceMethodDescriptor =
          MethodDescriptor.<UpgradeInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.redis.v1beta1.CloudRedis/UpgradeInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpgradeInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportInstanceRequest, Operation>
      importInstanceMethodDescriptor =
          MethodDescriptor.<ImportInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.redis.v1beta1.CloudRedis/ImportInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportInstanceRequest, Operation>
      exportInstanceMethodDescriptor =
          MethodDescriptor.<ExportInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.redis.v1beta1.CloudRedis/ExportInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FailoverInstanceRequest, Operation>
      failoverInstanceMethodDescriptor =
          MethodDescriptor.<FailoverInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.redis.v1beta1.CloudRedis/FailoverInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FailoverInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.redis.v1beta1.CloudRedis/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, Any>
      createInstanceOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, Any>
      updateInstanceOperationCallable;
  private final UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable;
  private final OperationCallable<UpgradeInstanceRequest, Instance, Any>
      upgradeInstanceOperationCallable;
  private final UnaryCallable<ImportInstanceRequest, Operation> importInstanceCallable;
  private final OperationCallable<ImportInstanceRequest, Instance, Any>
      importInstanceOperationCallable;
  private final UnaryCallable<ExportInstanceRequest, Operation> exportInstanceCallable;
  private final OperationCallable<ExportInstanceRequest, Instance, Any>
      exportInstanceOperationCallable;
  private final UnaryCallable<FailoverInstanceRequest, Operation> failoverInstanceCallable;
  private final OperationCallable<FailoverInstanceRequest, Instance, Any>
      failoverInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, Any>
      deleteInstanceOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudRedisStub create(CloudRedisStubSettings settings)
      throws IOException {
    return new GrpcCloudRedisStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudRedisStub create(ClientContext clientContext) throws IOException {
    return new GrpcCloudRedisStub(CloudRedisStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudRedisStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudRedisStub(
        CloudRedisStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudRedisStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudRedisStub(CloudRedisStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCloudRedisCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudRedisStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudRedisStub(
      CloudRedisStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListInstancesRequest>() {
                  @Override
                  public Map<String, String> extract(ListInstancesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetInstanceRequest>() {
                  @Override
                  public Map<String, String> extract(GetInstanceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        GrpcCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateInstanceRequest>() {
                  @Override
                  public Map<String, String> extract(CreateInstanceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        GrpcCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateInstanceRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateInstanceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("instance.name", String.valueOf(request.getInstance().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceTransportSettings =
        GrpcCallSettings.<UpgradeInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(upgradeInstanceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpgradeInstanceRequest>() {
                  @Override
                  public Map<String, String> extract(UpgradeInstanceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ImportInstanceRequest, Operation> importInstanceTransportSettings =
        GrpcCallSettings.<ImportInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(importInstanceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ImportInstanceRequest>() {
                  @Override
                  public Map<String, String> extract(ImportInstanceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ExportInstanceRequest, Operation> exportInstanceTransportSettings =
        GrpcCallSettings.<ExportInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(exportInstanceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExportInstanceRequest>() {
                  @Override
                  public Map<String, String> extract(ExportInstanceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<FailoverInstanceRequest, Operation> failoverInstanceTransportSettings =
        GrpcCallSettings.<FailoverInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(failoverInstanceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<FailoverInstanceRequest>() {
                  @Override
                  public Map<String, String> extract(FailoverInstanceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteInstanceRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteInstanceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.upgradeInstanceCallable =
        callableFactory.createUnaryCallable(
            upgradeInstanceTransportSettings, settings.upgradeInstanceSettings(), clientContext);
    this.upgradeInstanceOperationCallable =
        callableFactory.createOperationCallable(
            upgradeInstanceTransportSettings,
            settings.upgradeInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.importInstanceCallable =
        callableFactory.createUnaryCallable(
            importInstanceTransportSettings, settings.importInstanceSettings(), clientContext);
    this.importInstanceOperationCallable =
        callableFactory.createOperationCallable(
            importInstanceTransportSettings,
            settings.importInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.exportInstanceCallable =
        callableFactory.createUnaryCallable(
            exportInstanceTransportSettings, settings.exportInstanceSettings(), clientContext);
    this.exportInstanceOperationCallable =
        callableFactory.createOperationCallable(
            exportInstanceTransportSettings,
            settings.exportInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.failoverInstanceCallable =
        callableFactory.createUnaryCallable(
            failoverInstanceTransportSettings, settings.failoverInstanceSettings(), clientContext);
    this.failoverInstanceOperationCallable =
        callableFactory.createOperationCallable(
            failoverInstanceTransportSettings,
            settings.failoverInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  public OperationCallable<CreateInstanceRequest, Instance, Any> createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  public OperationCallable<UpdateInstanceRequest, Instance, Any> updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  public UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable() {
    return upgradeInstanceCallable;
  }

  public OperationCallable<UpgradeInstanceRequest, Instance, Any>
      upgradeInstanceOperationCallable() {
    return upgradeInstanceOperationCallable;
  }

  public UnaryCallable<ImportInstanceRequest, Operation> importInstanceCallable() {
    return importInstanceCallable;
  }

  public OperationCallable<ImportInstanceRequest, Instance, Any> importInstanceOperationCallable() {
    return importInstanceOperationCallable;
  }

  public UnaryCallable<ExportInstanceRequest, Operation> exportInstanceCallable() {
    return exportInstanceCallable;
  }

  public OperationCallable<ExportInstanceRequest, Instance, Any> exportInstanceOperationCallable() {
    return exportInstanceOperationCallable;
  }

  public UnaryCallable<FailoverInstanceRequest, Operation> failoverInstanceCallable() {
    return failoverInstanceCallable;
  }

  public OperationCallable<FailoverInstanceRequest, Instance, Any>
      failoverInstanceOperationCallable() {
    return failoverInstanceOperationCallable;
  }

  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  public OperationCallable<DeleteInstanceRequest, Empty, Any> deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
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
