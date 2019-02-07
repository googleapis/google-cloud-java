/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigtable.admin.v2.stub;

import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.AppProfile;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.CreateAppProfileRequest;
import com.google.bigtable.admin.v2.CreateClusterMetadata;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceMetadata;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.DeleteAppProfileRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.GetAppProfileRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.ListAppProfilesRequest;
import com.google.bigtable.admin.v2.ListAppProfilesResponse;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.bigtable.admin.v2.UpdateAppProfileMetadata;
import com.google.bigtable.admin.v2.UpdateAppProfileRequest;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.bigtable.admin.v2.UpdateInstanceMetadata;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Cloud Bigtable Admin API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcBigtableInstanceAdminStub extends BigtableInstanceAdminStub {

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<PartialUpdateInstanceRequest, Operation>
      partialUpdateInstanceMethodDescriptor =
          MethodDescriptor.<PartialUpdateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin/PartialUpdateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PartialUpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteInstanceRequest, Empty>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          MethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/CreateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      MethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/GetCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(GetClusterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Cluster.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          MethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/ListClusters")
              .setRequestMarshaller(ProtoUtils.marshaller(ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClustersResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<Cluster, Operation> updateClusterMethodDescriptor =
      MethodDescriptor.<Cluster, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/UpdateCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(Cluster.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<DeleteClusterRequest, Empty> deleteClusterMethodDescriptor =
      MethodDescriptor.<DeleteClusterRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/DeleteCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteClusterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<CreateAppProfileRequest, AppProfile>
      createAppProfileMethodDescriptor =
          MethodDescriptor.<CreateAppProfileRequest, AppProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/CreateAppProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAppProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AppProfile.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetAppProfileRequest, AppProfile>
      getAppProfileMethodDescriptor =
          MethodDescriptor.<GetAppProfileRequest, AppProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/GetAppProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAppProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AppProfile.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListAppProfilesRequest, ListAppProfilesResponse>
      listAppProfilesMethodDescriptor =
          MethodDescriptor.<ListAppProfilesRequest, ListAppProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/ListAppProfiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAppProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAppProfilesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateAppProfileRequest, Operation>
      updateAppProfileMethodDescriptor =
          MethodDescriptor.<UpdateAppProfileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/UpdateAppProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAppProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteAppProfileRequest, Empty>
      deleteAppProfileMethodDescriptor =
          MethodDescriptor.<DeleteAppProfileRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/DeleteAppProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAppProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableInstanceAdmin/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<PartialUpdateInstanceRequest, Operation>
      partialUpdateInstanceCallable;
  private final OperationCallable<PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      partialUpdateInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Empty> deleteInstanceCallable;
  private final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable;
  private final OperationCallable<CreateClusterRequest, Cluster, CreateClusterMetadata>
      createClusterOperationCallable;
  private final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable;
  private final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable;
  private final UnaryCallable<Cluster, Operation> updateClusterCallable;
  private final OperationCallable<Cluster, Cluster, UpdateClusterMetadata>
      updateClusterOperationCallable;
  private final UnaryCallable<DeleteClusterRequest, Empty> deleteClusterCallable;
  private final UnaryCallable<CreateAppProfileRequest, AppProfile> createAppProfileCallable;
  private final UnaryCallable<GetAppProfileRequest, AppProfile> getAppProfileCallable;
  private final UnaryCallable<ListAppProfilesRequest, ListAppProfilesResponse>
      listAppProfilesCallable;
  private final UnaryCallable<ListAppProfilesRequest, ListAppProfilesPagedResponse>
      listAppProfilesPagedCallable;
  private final UnaryCallable<UpdateAppProfileRequest, Operation> updateAppProfileCallable;
  private final OperationCallable<UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
      updateAppProfileOperationCallable;
  private final UnaryCallable<DeleteAppProfileRequest, Empty> deleteAppProfileCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBigtableInstanceAdminStub create(
      BigtableInstanceAdminStubSettings settings) throws IOException {
    return new GrpcBigtableInstanceAdminStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBigtableInstanceAdminStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBigtableInstanceAdminStub(
        BigtableInstanceAdminStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBigtableInstanceAdminStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBigtableInstanceAdminStub(
        BigtableInstanceAdminStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBigtableInstanceAdminStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBigtableInstanceAdminStub(
      BigtableInstanceAdminStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcBigtableInstanceAdminCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBigtableInstanceAdminStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBigtableInstanceAdminStub(
      BigtableInstanceAdminStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

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
    GrpcCallSettings<PartialUpdateInstanceRequest, Operation>
        partialUpdateInstanceTransportSettings =
            GrpcCallSettings.<PartialUpdateInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(partialUpdateInstanceMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PartialUpdateInstanceRequest>() {
                      @Override
                      public Map<String, String> extract(PartialUpdateInstanceRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "instance.name", String.valueOf(request.getInstance().getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteInstanceRequest, Empty> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Empty>newBuilder()
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
    GrpcCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        GrpcCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateClusterRequest>() {
                  @Override
                  public Map<String, String> extract(CreateClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        GrpcCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetClusterRequest>() {
                  @Override
                  public Map<String, String> extract(GetClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        GrpcCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListClustersRequest>() {
                  @Override
                  public Map<String, String> extract(ListClustersRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<Cluster, Operation> updateClusterTransportSettings =
        GrpcCallSettings.<Cluster, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<Cluster>() {
                  @Override
                  public Map<String, String> extract(Cluster request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteClusterRequest, Empty> deleteClusterTransportSettings =
        GrpcCallSettings.<DeleteClusterRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteClusterRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateAppProfileRequest, AppProfile> createAppProfileTransportSettings =
        GrpcCallSettings.<CreateAppProfileRequest, AppProfile>newBuilder()
            .setMethodDescriptor(createAppProfileMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateAppProfileRequest>() {
                  @Override
                  public Map<String, String> extract(CreateAppProfileRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetAppProfileRequest, AppProfile> getAppProfileTransportSettings =
        GrpcCallSettings.<GetAppProfileRequest, AppProfile>newBuilder()
            .setMethodDescriptor(getAppProfileMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetAppProfileRequest>() {
                  @Override
                  public Map<String, String> extract(GetAppProfileRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListAppProfilesRequest, ListAppProfilesResponse>
        listAppProfilesTransportSettings =
            GrpcCallSettings.<ListAppProfilesRequest, ListAppProfilesResponse>newBuilder()
                .setMethodDescriptor(listAppProfilesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListAppProfilesRequest>() {
                      @Override
                      public Map<String, String> extract(ListAppProfilesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateAppProfileRequest, Operation> updateAppProfileTransportSettings =
        GrpcCallSettings.<UpdateAppProfileRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAppProfileMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateAppProfileRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateAppProfileRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "app_profile.name", String.valueOf(request.getAppProfile().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteAppProfileRequest, Empty> deleteAppProfileTransportSettings =
        GrpcCallSettings.<DeleteAppProfileRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAppProfileMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteAppProfileRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteAppProfileRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
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

    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            this.operationsStub);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.partialUpdateInstanceCallable =
        callableFactory.createUnaryCallable(
            partialUpdateInstanceTransportSettings,
            settings.partialUpdateInstanceSettings(),
            clientContext);
    this.partialUpdateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            partialUpdateInstanceTransportSettings,
            settings.partialUpdateInstanceOperationSettings(),
            clientContext,
            this.operationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.createClusterCallable =
        callableFactory.createUnaryCallable(
            createClusterTransportSettings, settings.createClusterSettings(), clientContext);
    this.createClusterOperationCallable =
        callableFactory.createOperationCallable(
            createClusterTransportSettings,
            settings.createClusterOperationSettings(),
            clientContext,
            this.operationsStub);
    this.getClusterCallable =
        callableFactory.createUnaryCallable(
            getClusterTransportSettings, settings.getClusterSettings(), clientContext);
    this.listClustersCallable =
        callableFactory.createUnaryCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.updateClusterCallable =
        callableFactory.createUnaryCallable(
            updateClusterTransportSettings, settings.updateClusterSettings(), clientContext);
    this.updateClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateClusterTransportSettings,
            settings.updateClusterOperationSettings(),
            clientContext,
            this.operationsStub);
    this.deleteClusterCallable =
        callableFactory.createUnaryCallable(
            deleteClusterTransportSettings, settings.deleteClusterSettings(), clientContext);
    this.createAppProfileCallable =
        callableFactory.createUnaryCallable(
            createAppProfileTransportSettings, settings.createAppProfileSettings(), clientContext);
    this.getAppProfileCallable =
        callableFactory.createUnaryCallable(
            getAppProfileTransportSettings, settings.getAppProfileSettings(), clientContext);
    this.listAppProfilesCallable =
        callableFactory.createUnaryCallable(
            listAppProfilesTransportSettings, settings.listAppProfilesSettings(), clientContext);
    this.listAppProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listAppProfilesTransportSettings, settings.listAppProfilesSettings(), clientContext);
    this.updateAppProfileCallable =
        callableFactory.createUnaryCallable(
            updateAppProfileTransportSettings, settings.updateAppProfileSettings(), clientContext);
    this.updateAppProfileOperationCallable =
        callableFactory.createOperationCallable(
            updateAppProfileTransportSettings,
            settings.updateAppProfileOperationSettings(),
            clientContext,
            this.operationsStub);
    this.deleteAppProfileCallable =
        callableFactory.createUnaryCallable(
            deleteAppProfileTransportSettings, settings.deleteAppProfileSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      partialUpdateInstanceOperationCallable() {
    return partialUpdateInstanceOperationCallable;
  }

  public UnaryCallable<PartialUpdateInstanceRequest, Operation> partialUpdateInstanceCallable() {
    return partialUpdateInstanceCallable;
  }

  public UnaryCallable<DeleteInstanceRequest, Empty> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateClusterRequest, Cluster, CreateClusterMetadata>
      createClusterOperationCallable() {
    return createClusterOperationCallable;
  }

  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return createClusterCallable;
  }

  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return getClusterCallable;
  }

  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return listClustersCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<Cluster, Cluster, UpdateClusterMetadata>
      updateClusterOperationCallable() {
    return updateClusterOperationCallable;
  }

  public UnaryCallable<Cluster, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  public UnaryCallable<DeleteClusterRequest, Empty> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  public UnaryCallable<CreateAppProfileRequest, AppProfile> createAppProfileCallable() {
    return createAppProfileCallable;
  }

  public UnaryCallable<GetAppProfileRequest, AppProfile> getAppProfileCallable() {
    return getAppProfileCallable;
  }

  public UnaryCallable<ListAppProfilesRequest, ListAppProfilesPagedResponse>
      listAppProfilesPagedCallable() {
    return listAppProfilesPagedCallable;
  }

  public UnaryCallable<ListAppProfilesRequest, ListAppProfilesResponse> listAppProfilesCallable() {
    return listAppProfilesCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
      updateAppProfileOperationCallable() {
    return updateAppProfileOperationCallable;
  }

  public UnaryCallable<UpdateAppProfileRequest, Operation> updateAppProfileCallable() {
    return updateAppProfileCallable;
  }

  public UnaryCallable<DeleteAppProfileRequest, Empty> deleteAppProfileCallable() {
    return deleteAppProfileCallable;
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
