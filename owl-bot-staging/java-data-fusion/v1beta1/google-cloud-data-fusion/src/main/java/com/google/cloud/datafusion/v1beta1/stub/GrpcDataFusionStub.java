/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.datafusion.v1beta1.stub;

import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListAvailableVersionsPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListDnsPeeringsPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListInstancesPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListNamespacesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datafusion.v1beta1.AddDnsPeeringRequest;
import com.google.cloud.datafusion.v1beta1.AddDnsPeeringResponse;
import com.google.cloud.datafusion.v1beta1.CreateInstanceRequest;
import com.google.cloud.datafusion.v1beta1.DeleteInstanceRequest;
import com.google.cloud.datafusion.v1beta1.GetInstanceRequest;
import com.google.cloud.datafusion.v1beta1.Instance;
import com.google.cloud.datafusion.v1beta1.ListAvailableVersionsRequest;
import com.google.cloud.datafusion.v1beta1.ListAvailableVersionsResponse;
import com.google.cloud.datafusion.v1beta1.ListDnsPeeringsRequest;
import com.google.cloud.datafusion.v1beta1.ListDnsPeeringsResponse;
import com.google.cloud.datafusion.v1beta1.ListInstancesRequest;
import com.google.cloud.datafusion.v1beta1.ListInstancesResponse;
import com.google.cloud.datafusion.v1beta1.ListNamespacesRequest;
import com.google.cloud.datafusion.v1beta1.ListNamespacesResponse;
import com.google.cloud.datafusion.v1beta1.OperationMetadata;
import com.google.cloud.datafusion.v1beta1.RemoveDnsPeeringRequest;
import com.google.cloud.datafusion.v1beta1.RemoveDnsPeeringResponse;
import com.google.cloud.datafusion.v1beta1.RemoveIamPolicyRequest;
import com.google.cloud.datafusion.v1beta1.RemoveIamPolicyResponse;
import com.google.cloud.datafusion.v1beta1.RestartInstanceRequest;
import com.google.cloud.datafusion.v1beta1.UpdateInstanceRequest;
import com.google.cloud.datafusion.v1beta1.UpgradeInstanceRequest;
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
 * gRPC stub implementation for the DataFusion service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDataFusionStub extends DataFusionStub {
  private static final MethodDescriptor<ListAvailableVersionsRequest, ListAvailableVersionsResponse>
      listAvailableVersionsMethodDescriptor =
          MethodDescriptor.<ListAvailableVersionsRequest, ListAvailableVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/ListAvailableVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAvailableVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAvailableVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          MethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/UpdateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RestartInstanceRequest, Operation>
      restartInstanceMethodDescriptor =
          MethodDescriptor.<RestartInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/RestartInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestartInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpgradeInstanceRequest, Operation>
      upgradeInstanceMethodDescriptor =
          MethodDescriptor.<UpgradeInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/UpgradeInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpgradeInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicyMethodDescriptor =
          MethodDescriptor.<RemoveIamPolicyRequest, RemoveIamPolicyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/RemoveIamPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RemoveIamPolicyResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNamespacesRequest, ListNamespacesResponse>
      listNamespacesMethodDescriptor =
          MethodDescriptor.<ListNamespacesRequest, ListNamespacesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/ListNamespaces")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNamespacesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNamespacesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AddDnsPeeringRequest, AddDnsPeeringResponse>
      addDnsPeeringMethodDescriptor =
          MethodDescriptor.<AddDnsPeeringRequest, AddDnsPeeringResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/AddDnsPeering")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddDnsPeeringRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AddDnsPeeringResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
      removeDnsPeeringMethodDescriptor =
          MethodDescriptor.<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/RemoveDnsPeering")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveDnsPeeringRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RemoveDnsPeeringResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDnsPeeringsRequest, ListDnsPeeringsResponse>
      listDnsPeeringsMethodDescriptor =
          MethodDescriptor.<ListDnsPeeringsRequest, ListDnsPeeringsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/ListDnsPeerings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDnsPeeringsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDnsPeeringsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsResponse>
      listAvailableVersionsCallable;
  private final UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsPagedResponse>
      listAvailableVersionsPagedCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<RestartInstanceRequest, Operation> restartInstanceCallable;
  private final OperationCallable<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationCallable;
  private final UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable;
  private final OperationCallable<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationCallable;
  private final UnaryCallable<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicyCallable;
  private final UnaryCallable<ListNamespacesRequest, ListNamespacesResponse> listNamespacesCallable;
  private final UnaryCallable<ListNamespacesRequest, ListNamespacesPagedResponse>
      listNamespacesPagedCallable;
  private final UnaryCallable<AddDnsPeeringRequest, AddDnsPeeringResponse> addDnsPeeringCallable;
  private final UnaryCallable<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
      removeDnsPeeringCallable;
  private final UnaryCallable<ListDnsPeeringsRequest, ListDnsPeeringsResponse>
      listDnsPeeringsCallable;
  private final UnaryCallable<ListDnsPeeringsRequest, ListDnsPeeringsPagedResponse>
      listDnsPeeringsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataFusionStub create(DataFusionStubSettings settings)
      throws IOException {
    return new GrpcDataFusionStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataFusionStub create(ClientContext clientContext) throws IOException {
    return new GrpcDataFusionStub(DataFusionStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataFusionStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataFusionStub(
        DataFusionStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataFusionStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataFusionStub(DataFusionStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDataFusionCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataFusionStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataFusionStub(
      DataFusionStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAvailableVersionsRequest, ListAvailableVersionsResponse>
        listAvailableVersionsTransportSettings =
            GrpcCallSettings
                .<ListAvailableVersionsRequest, ListAvailableVersionsResponse>newBuilder()
                .setMethodDescriptor(listAvailableVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        GrpcCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        GrpcCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("instance.name", String.valueOf(request.getInstance().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RestartInstanceRequest, Operation> restartInstanceTransportSettings =
        GrpcCallSettings.<RestartInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(restartInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceTransportSettings =
        GrpcCallSettings.<UpgradeInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(upgradeInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
        removeIamPolicyTransportSettings =
            GrpcCallSettings.<RemoveIamPolicyRequest, RemoveIamPolicyResponse>newBuilder()
                .setMethodDescriptor(removeIamPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListNamespacesRequest, ListNamespacesResponse>
        listNamespacesTransportSettings =
            GrpcCallSettings.<ListNamespacesRequest, ListNamespacesResponse>newBuilder()
                .setMethodDescriptor(listNamespacesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<AddDnsPeeringRequest, AddDnsPeeringResponse> addDnsPeeringTransportSettings =
        GrpcCallSettings.<AddDnsPeeringRequest, AddDnsPeeringResponse>newBuilder()
            .setMethodDescriptor(addDnsPeeringMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
        removeDnsPeeringTransportSettings =
            GrpcCallSettings.<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>newBuilder()
                .setMethodDescriptor(removeDnsPeeringMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListDnsPeeringsRequest, ListDnsPeeringsResponse>
        listDnsPeeringsTransportSettings =
            GrpcCallSettings.<ListDnsPeeringsRequest, ListDnsPeeringsResponse>newBuilder()
                .setMethodDescriptor(listDnsPeeringsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();

    this.listAvailableVersionsCallable =
        callableFactory.createUnaryCallable(
            listAvailableVersionsTransportSettings,
            settings.listAvailableVersionsSettings(),
            clientContext);
    this.listAvailableVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listAvailableVersionsTransportSettings,
            settings.listAvailableVersionsSettings(),
            clientContext);
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
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
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
    this.restartInstanceCallable =
        callableFactory.createUnaryCallable(
            restartInstanceTransportSettings, settings.restartInstanceSettings(), clientContext);
    this.restartInstanceOperationCallable =
        callableFactory.createOperationCallable(
            restartInstanceTransportSettings,
            settings.restartInstanceOperationSettings(),
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
    this.removeIamPolicyCallable =
        callableFactory.createUnaryCallable(
            removeIamPolicyTransportSettings, settings.removeIamPolicySettings(), clientContext);
    this.listNamespacesCallable =
        callableFactory.createUnaryCallable(
            listNamespacesTransportSettings, settings.listNamespacesSettings(), clientContext);
    this.listNamespacesPagedCallable =
        callableFactory.createPagedCallable(
            listNamespacesTransportSettings, settings.listNamespacesSettings(), clientContext);
    this.addDnsPeeringCallable =
        callableFactory.createUnaryCallable(
            addDnsPeeringTransportSettings, settings.addDnsPeeringSettings(), clientContext);
    this.removeDnsPeeringCallable =
        callableFactory.createUnaryCallable(
            removeDnsPeeringTransportSettings, settings.removeDnsPeeringSettings(), clientContext);
    this.listDnsPeeringsCallable =
        callableFactory.createUnaryCallable(
            listDnsPeeringsTransportSettings, settings.listDnsPeeringsSettings(), clientContext);
    this.listDnsPeeringsPagedCallable =
        callableFactory.createPagedCallable(
            listDnsPeeringsTransportSettings, settings.listDnsPeeringsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsResponse>
      listAvailableVersionsCallable() {
    return listAvailableVersionsCallable;
  }

  @Override
  public UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsPagedResponse>
      listAvailableVersionsPagedCallable() {
    return listAvailableVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  @Override
  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<RestartInstanceRequest, Operation> restartInstanceCallable() {
    return restartInstanceCallable;
  }

  @Override
  public OperationCallable<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationCallable() {
    return restartInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable() {
    return upgradeInstanceCallable;
  }

  @Override
  public OperationCallable<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationCallable() {
    return upgradeInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveIamPolicyRequest, RemoveIamPolicyResponse> removeIamPolicyCallable() {
    return removeIamPolicyCallable;
  }

  @Override
  public UnaryCallable<ListNamespacesRequest, ListNamespacesResponse> listNamespacesCallable() {
    return listNamespacesCallable;
  }

  @Override
  public UnaryCallable<ListNamespacesRequest, ListNamespacesPagedResponse>
      listNamespacesPagedCallable() {
    return listNamespacesPagedCallable;
  }

  @Override
  public UnaryCallable<AddDnsPeeringRequest, AddDnsPeeringResponse> addDnsPeeringCallable() {
    return addDnsPeeringCallable;
  }

  @Override
  public UnaryCallable<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
      removeDnsPeeringCallable() {
    return removeDnsPeeringCallable;
  }

  @Override
  public UnaryCallable<ListDnsPeeringsRequest, ListDnsPeeringsResponse> listDnsPeeringsCallable() {
    return listDnsPeeringsCallable;
  }

  @Override
  public UnaryCallable<ListDnsPeeringsRequest, ListDnsPeeringsPagedResponse>
      listDnsPeeringsPagedCallable() {
    return listDnsPeeringsPagedCallable;
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
