/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.admin.instance.v1.stub;

import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstanceConfigOperationsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstanceConfigsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancePartitionOperationsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancePartitionsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.spanner.admin.instance.v1.CreateInstanceConfigMetadata;
import com.google.spanner.admin.instance.v1.CreateInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.CreateInstancePartitionMetadata;
import com.google.spanner.admin.instance.v1.CreateInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.DeleteInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceRequest;
import com.google.spanner.admin.instance.v1.GetInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.GetInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.GetInstanceRequest;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.InstancePartition;
import com.google.spanner.admin.instance.v1.ListInstanceConfigOperationsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigOperationsResponse;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse;
import com.google.spanner.admin.instance.v1.ListInstancePartitionOperationsRequest;
import com.google.spanner.admin.instance.v1.ListInstancePartitionOperationsResponse;
import com.google.spanner.admin.instance.v1.ListInstancePartitionsRequest;
import com.google.spanner.admin.instance.v1.ListInstancePartitionsResponse;
import com.google.spanner.admin.instance.v1.ListInstancesRequest;
import com.google.spanner.admin.instance.v1.ListInstancesResponse;
import com.google.spanner.admin.instance.v1.MoveInstanceMetadata;
import com.google.spanner.admin.instance.v1.MoveInstanceRequest;
import com.google.spanner.admin.instance.v1.MoveInstanceResponse;
import com.google.spanner.admin.instance.v1.UpdateInstanceConfigMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstancePartitionMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.UpdateInstanceRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the InstanceAdmin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcInstanceAdminStub extends InstanceAdminStub {
  private static final MethodDescriptor<ListInstanceConfigsRequest, ListInstanceConfigsResponse>
      listInstanceConfigsMethodDescriptor =
          MethodDescriptor.<ListInstanceConfigsRequest, ListInstanceConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/ListInstanceConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstanceConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstanceConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetInstanceConfigRequest, InstanceConfig>
      getInstanceConfigMethodDescriptor =
          MethodDescriptor.<GetInstanceConfigRequest, InstanceConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.instance.v1.InstanceAdmin/GetInstanceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInstanceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(InstanceConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateInstanceConfigRequest, Operation>
      createInstanceConfigMethodDescriptor =
          MethodDescriptor.<CreateInstanceConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/CreateInstanceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInstanceConfigRequest, Operation>
      updateInstanceConfigMethodDescriptor =
          MethodDescriptor.<UpdateInstanceConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/UpdateInstanceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInstanceConfigRequest, Empty>
      deleteInstanceConfigMethodDescriptor =
          MethodDescriptor.<DeleteInstanceConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/DeleteInstanceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsResponse>
      listInstanceConfigOperationsMethodDescriptor =
          MethodDescriptor
              .<ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/ListInstanceConfigOperations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstanceConfigOperationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstanceConfigOperationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.instance.v1.InstanceAdmin/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListInstancePartitionsRequest, ListInstancePartitionsResponse>
      listInstancePartitionsMethodDescriptor =
          MethodDescriptor
              .<ListInstancePartitionsRequest, ListInstancePartitionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/ListInstancePartitions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancePartitionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancePartitionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.admin.instance.v1.InstanceAdmin/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.instance.v1.InstanceAdmin/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          MethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.instance.v1.InstanceAdmin/UpdateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInstanceRequest, Empty>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.instance.v1.InstanceAdmin/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.admin.instance.v1.InstanceAdmin/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.admin.instance.v1.InstanceAdmin/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetInstancePartitionRequest, InstancePartition>
      getInstancePartitionMethodDescriptor =
          MethodDescriptor.<GetInstancePartitionRequest, InstancePartition>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/GetInstancePartition")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInstancePartitionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(InstancePartition.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateInstancePartitionRequest, Operation>
      createInstancePartitionMethodDescriptor =
          MethodDescriptor.<CreateInstancePartitionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/CreateInstancePartition")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstancePartitionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInstancePartitionRequest, Empty>
      deleteInstancePartitionMethodDescriptor =
          MethodDescriptor.<DeleteInstancePartitionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/DeleteInstancePartition")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstancePartitionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInstancePartitionRequest, Operation>
      updateInstancePartitionMethodDescriptor =
          MethodDescriptor.<UpdateInstancePartitionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/UpdateInstancePartition")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstancePartitionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListInstancePartitionOperationsRequest, ListInstancePartitionOperationsResponse>
      listInstancePartitionOperationsMethodDescriptor =
          MethodDescriptor
              .<ListInstancePartitionOperationsRequest, ListInstancePartitionOperationsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin/ListInstancePartitionOperations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListInstancePartitionOperationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListInstancePartitionOperationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<MoveInstanceRequest, Operation>
      moveInstanceMethodDescriptor =
          MethodDescriptor.<MoveInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.instance.v1.InstanceAdmin/MoveInstance")
              .setRequestMarshaller(ProtoUtils.marshaller(MoveInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListInstanceConfigsRequest, ListInstanceConfigsResponse>
      listInstanceConfigsCallable;
  private final UnaryCallable<ListInstanceConfigsRequest, ListInstanceConfigsPagedResponse>
      listInstanceConfigsPagedCallable;
  private final UnaryCallable<GetInstanceConfigRequest, InstanceConfig> getInstanceConfigCallable;
  private final UnaryCallable<CreateInstanceConfigRequest, Operation> createInstanceConfigCallable;
  private final OperationCallable<
          CreateInstanceConfigRequest, InstanceConfig, CreateInstanceConfigMetadata>
      createInstanceConfigOperationCallable;
  private final UnaryCallable<UpdateInstanceConfigRequest, Operation> updateInstanceConfigCallable;
  private final OperationCallable<
          UpdateInstanceConfigRequest, InstanceConfig, UpdateInstanceConfigMetadata>
      updateInstanceConfigOperationCallable;
  private final UnaryCallable<DeleteInstanceConfigRequest, Empty> deleteInstanceConfigCallable;
  private final UnaryCallable<
          ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsResponse>
      listInstanceConfigOperationsCallable;
  private final UnaryCallable<
          ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsPagedResponse>
      listInstanceConfigOperationsPagedCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<ListInstancePartitionsRequest, ListInstancePartitionsResponse>
      listInstancePartitionsCallable;
  private final UnaryCallable<ListInstancePartitionsRequest, ListInstancePartitionsPagedResponse>
      listInstancePartitionsPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Empty> deleteInstanceCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<GetInstancePartitionRequest, InstancePartition>
      getInstancePartitionCallable;
  private final UnaryCallable<CreateInstancePartitionRequest, Operation>
      createInstancePartitionCallable;
  private final OperationCallable<
          CreateInstancePartitionRequest, InstancePartition, CreateInstancePartitionMetadata>
      createInstancePartitionOperationCallable;
  private final UnaryCallable<DeleteInstancePartitionRequest, Empty>
      deleteInstancePartitionCallable;
  private final UnaryCallable<UpdateInstancePartitionRequest, Operation>
      updateInstancePartitionCallable;
  private final OperationCallable<
          UpdateInstancePartitionRequest, InstancePartition, UpdateInstancePartitionMetadata>
      updateInstancePartitionOperationCallable;
  private final UnaryCallable<
          ListInstancePartitionOperationsRequest, ListInstancePartitionOperationsResponse>
      listInstancePartitionOperationsCallable;
  private final UnaryCallable<
          ListInstancePartitionOperationsRequest, ListInstancePartitionOperationsPagedResponse>
      listInstancePartitionOperationsPagedCallable;
  private final UnaryCallable<MoveInstanceRequest, Operation> moveInstanceCallable;
  private final OperationCallable<MoveInstanceRequest, MoveInstanceResponse, MoveInstanceMetadata>
      moveInstanceOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcInstanceAdminStub create(InstanceAdminStubSettings settings)
      throws IOException {
    return new GrpcInstanceAdminStub(settings, ClientContext.create(settings));
  }

  public static final GrpcInstanceAdminStub create(ClientContext clientContext) throws IOException {
    return new GrpcInstanceAdminStub(InstanceAdminStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcInstanceAdminStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcInstanceAdminStub(
        InstanceAdminStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcInstanceAdminStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcInstanceAdminStub(InstanceAdminStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcInstanceAdminCallableFactory());
  }

  /**
   * Constructs an instance of GrpcInstanceAdminStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcInstanceAdminStub(
      InstanceAdminStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInstanceConfigsRequest, ListInstanceConfigsResponse>
        listInstanceConfigsTransportSettings =
            GrpcCallSettings.<ListInstanceConfigsRequest, ListInstanceConfigsResponse>newBuilder()
                .setMethodDescriptor(listInstanceConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetInstanceConfigRequest, InstanceConfig> getInstanceConfigTransportSettings =
        GrpcCallSettings.<GetInstanceConfigRequest, InstanceConfig>newBuilder()
            .setMethodDescriptor(getInstanceConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateInstanceConfigRequest, Operation> createInstanceConfigTransportSettings =
        GrpcCallSettings.<CreateInstanceConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateInstanceConfigRequest, Operation> updateInstanceConfigTransportSettings =
        GrpcCallSettings.<UpdateInstanceConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "instance_config.name",
                      String.valueOf(request.getInstanceConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteInstanceConfigRequest, Empty> deleteInstanceConfigTransportSettings =
        GrpcCallSettings.<DeleteInstanceConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteInstanceConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsResponse>
        listInstanceConfigOperationsTransportSettings =
            GrpcCallSettings
                .<ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsResponse>
                    newBuilder()
                .setMethodDescriptor(listInstanceConfigOperationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<ListInstancePartitionsRequest, ListInstancePartitionsResponse>
        listInstancePartitionsTransportSettings =
            GrpcCallSettings
                .<ListInstancePartitionsRequest, ListInstancePartitionsResponse>newBuilder()
                .setMethodDescriptor(listInstancePartitionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        GrpcCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        GrpcCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance.name", String.valueOf(request.getInstance().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteInstanceRequest, Empty> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
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
            .setResourceNameExtractor(request -> request.getResource())
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
                .setResourceNameExtractor(request -> request.getResource())
                .build();
    GrpcCallSettings<GetInstancePartitionRequest, InstancePartition>
        getInstancePartitionTransportSettings =
            GrpcCallSettings.<GetInstancePartitionRequest, InstancePartition>newBuilder()
                .setMethodDescriptor(getInstancePartitionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateInstancePartitionRequest, Operation>
        createInstancePartitionTransportSettings =
            GrpcCallSettings.<CreateInstancePartitionRequest, Operation>newBuilder()
                .setMethodDescriptor(createInstancePartitionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<DeleteInstancePartitionRequest, Empty>
        deleteInstancePartitionTransportSettings =
            GrpcCallSettings.<DeleteInstancePartitionRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteInstancePartitionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<UpdateInstancePartitionRequest, Operation>
        updateInstancePartitionTransportSettings =
            GrpcCallSettings.<UpdateInstancePartitionRequest, Operation>newBuilder()
                .setMethodDescriptor(updateInstancePartitionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "instance_partition.name",
                          String.valueOf(request.getInstancePartition().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListInstancePartitionOperationsRequest, ListInstancePartitionOperationsResponse>
        listInstancePartitionOperationsTransportSettings =
            GrpcCallSettings
                .<ListInstancePartitionOperationsRequest, ListInstancePartitionOperationsResponse>
                    newBuilder()
                .setMethodDescriptor(listInstancePartitionOperationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<MoveInstanceRequest, Operation> moveInstanceTransportSettings =
        GrpcCallSettings.<MoveInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(moveInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();

    this.listInstanceConfigsCallable =
        callableFactory.createUnaryCallable(
            listInstanceConfigsTransportSettings,
            settings.listInstanceConfigsSettings(),
            clientContext);
    this.listInstanceConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listInstanceConfigsTransportSettings,
            settings.listInstanceConfigsSettings(),
            clientContext);
    this.getInstanceConfigCallable =
        callableFactory.createUnaryCallable(
            getInstanceConfigTransportSettings,
            settings.getInstanceConfigSettings(),
            clientContext);
    this.createInstanceConfigCallable =
        callableFactory.createUnaryCallable(
            createInstanceConfigTransportSettings,
            settings.createInstanceConfigSettings(),
            clientContext);
    this.createInstanceConfigOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceConfigTransportSettings,
            settings.createInstanceConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInstanceConfigCallable =
        callableFactory.createUnaryCallable(
            updateInstanceConfigTransportSettings,
            settings.updateInstanceConfigSettings(),
            clientContext);
    this.updateInstanceConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceConfigTransportSettings,
            settings.updateInstanceConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInstanceConfigCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceConfigTransportSettings,
            settings.deleteInstanceConfigSettings(),
            clientContext);
    this.listInstanceConfigOperationsCallable =
        callableFactory.createUnaryCallable(
            listInstanceConfigOperationsTransportSettings,
            settings.listInstanceConfigOperationsSettings(),
            clientContext);
    this.listInstanceConfigOperationsPagedCallable =
        callableFactory.createPagedCallable(
            listInstanceConfigOperationsTransportSettings,
            settings.listInstanceConfigOperationsSettings(),
            clientContext);
    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancePartitionsCallable =
        callableFactory.createUnaryCallable(
            listInstancePartitionsTransportSettings,
            settings.listInstancePartitionsSettings(),
            clientContext);
    this.listInstancePartitionsPagedCallable =
        callableFactory.createPagedCallable(
            listInstancePartitionsTransportSettings,
            settings.listInstancePartitionsSettings(),
            clientContext);
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
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
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
    this.getInstancePartitionCallable =
        callableFactory.createUnaryCallable(
            getInstancePartitionTransportSettings,
            settings.getInstancePartitionSettings(),
            clientContext);
    this.createInstancePartitionCallable =
        callableFactory.createUnaryCallable(
            createInstancePartitionTransportSettings,
            settings.createInstancePartitionSettings(),
            clientContext);
    this.createInstancePartitionOperationCallable =
        callableFactory.createOperationCallable(
            createInstancePartitionTransportSettings,
            settings.createInstancePartitionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInstancePartitionCallable =
        callableFactory.createUnaryCallable(
            deleteInstancePartitionTransportSettings,
            settings.deleteInstancePartitionSettings(),
            clientContext);
    this.updateInstancePartitionCallable =
        callableFactory.createUnaryCallable(
            updateInstancePartitionTransportSettings,
            settings.updateInstancePartitionSettings(),
            clientContext);
    this.updateInstancePartitionOperationCallable =
        callableFactory.createOperationCallable(
            updateInstancePartitionTransportSettings,
            settings.updateInstancePartitionOperationSettings(),
            clientContext,
            operationsStub);
    this.listInstancePartitionOperationsCallable =
        callableFactory.createUnaryCallable(
            listInstancePartitionOperationsTransportSettings,
            settings.listInstancePartitionOperationsSettings(),
            clientContext);
    this.listInstancePartitionOperationsPagedCallable =
        callableFactory.createPagedCallable(
            listInstancePartitionOperationsTransportSettings,
            settings.listInstancePartitionOperationsSettings(),
            clientContext);
    this.moveInstanceCallable =
        callableFactory.createUnaryCallable(
            moveInstanceTransportSettings, settings.moveInstanceSettings(), clientContext);
    this.moveInstanceOperationCallable =
        callableFactory.createOperationCallable(
            moveInstanceTransportSettings,
            settings.moveInstanceOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListInstanceConfigsRequest, ListInstanceConfigsResponse>
      listInstanceConfigsCallable() {
    return listInstanceConfigsCallable;
  }

  @Override
  public UnaryCallable<ListInstanceConfigsRequest, ListInstanceConfigsPagedResponse>
      listInstanceConfigsPagedCallable() {
    return listInstanceConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceConfigRequest, InstanceConfig> getInstanceConfigCallable() {
    return getInstanceConfigCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceConfigRequest, Operation> createInstanceConfigCallable() {
    return createInstanceConfigCallable;
  }

  @Override
  public OperationCallable<
          CreateInstanceConfigRequest, InstanceConfig, CreateInstanceConfigMetadata>
      createInstanceConfigOperationCallable() {
    return createInstanceConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceConfigRequest, Operation> updateInstanceConfigCallable() {
    return updateInstanceConfigCallable;
  }

  @Override
  public OperationCallable<
          UpdateInstanceConfigRequest, InstanceConfig, UpdateInstanceConfigMetadata>
      updateInstanceConfigOperationCallable() {
    return updateInstanceConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceConfigRequest, Empty> deleteInstanceConfigCallable() {
    return deleteInstanceConfigCallable;
  }

  @Override
  public UnaryCallable<ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsResponse>
      listInstanceConfigOperationsCallable() {
    return listInstanceConfigOperationsCallable;
  }

  @Override
  public UnaryCallable<
          ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsPagedResponse>
      listInstanceConfigOperationsPagedCallable() {
    return listInstanceConfigOperationsPagedCallable;
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
  public UnaryCallable<ListInstancePartitionsRequest, ListInstancePartitionsResponse>
      listInstancePartitionsCallable() {
    return listInstancePartitionsCallable;
  }

  @Override
  public UnaryCallable<ListInstancePartitionsRequest, ListInstancePartitionsPagedResponse>
      listInstancePartitionsPagedCallable() {
    return listInstancePartitionsPagedCallable;
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
  public OperationCallable<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Empty> deleteInstanceCallable() {
    return deleteInstanceCallable;
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
  public UnaryCallable<GetInstancePartitionRequest, InstancePartition>
      getInstancePartitionCallable() {
    return getInstancePartitionCallable;
  }

  @Override
  public UnaryCallable<CreateInstancePartitionRequest, Operation>
      createInstancePartitionCallable() {
    return createInstancePartitionCallable;
  }

  @Override
  public OperationCallable<
          CreateInstancePartitionRequest, InstancePartition, CreateInstancePartitionMetadata>
      createInstancePartitionOperationCallable() {
    return createInstancePartitionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstancePartitionRequest, Empty> deleteInstancePartitionCallable() {
    return deleteInstancePartitionCallable;
  }

  @Override
  public UnaryCallable<UpdateInstancePartitionRequest, Operation>
      updateInstancePartitionCallable() {
    return updateInstancePartitionCallable;
  }

  @Override
  public OperationCallable<
          UpdateInstancePartitionRequest, InstancePartition, UpdateInstancePartitionMetadata>
      updateInstancePartitionOperationCallable() {
    return updateInstancePartitionOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListInstancePartitionOperationsRequest, ListInstancePartitionOperationsResponse>
      listInstancePartitionOperationsCallable() {
    return listInstancePartitionOperationsCallable;
  }

  @Override
  public UnaryCallable<
          ListInstancePartitionOperationsRequest, ListInstancePartitionOperationsPagedResponse>
      listInstancePartitionOperationsPagedCallable() {
    return listInstancePartitionOperationsPagedCallable;
  }

  @Override
  public UnaryCallable<MoveInstanceRequest, Operation> moveInstanceCallable() {
    return moveInstanceCallable;
  }

  @Override
  public OperationCallable<MoveInstanceRequest, MoveInstanceResponse, MoveInstanceMetadata>
      moveInstanceOperationCallable() {
    return moveInstanceOperationCallable;
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
