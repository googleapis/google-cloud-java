/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.securesourcemanager.v1.stub;

import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListInstancesPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListRepositoriesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securesourcemanager.v1.CreateInstanceRequest;
import com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest;
import com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest;
import com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest;
import com.google.cloud.securesourcemanager.v1.GetInstanceRequest;
import com.google.cloud.securesourcemanager.v1.GetRepositoryRequest;
import com.google.cloud.securesourcemanager.v1.Instance;
import com.google.cloud.securesourcemanager.v1.ListInstancesRequest;
import com.google.cloud.securesourcemanager.v1.ListInstancesResponse;
import com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest;
import com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse;
import com.google.cloud.securesourcemanager.v1.OperationMetadata;
import com.google.cloud.securesourcemanager.v1.Repository;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SecureSourceManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSecureSourceManagerStub extends SecureSourceManagerStub {
  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securesourcemanager.v1.SecureSourceManager/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesMethodDescriptor =
          MethodDescriptor.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/ListRepositories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRepositoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRepositoriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRepositoryRequest, Repository>
      getRepositoryMethodDescriptor =
          MethodDescriptor.<GetRepositoryRequest, Repository>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Repository.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRepositoryRequest, Operation>
      createRepositoryMethodDescriptor =
          MethodDescriptor.<CreateRepositoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/CreateRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRepositoryRequest, Operation>
      deleteRepositoryMethodDescriptor =
          MethodDescriptor.<DeleteRepositoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/DeleteRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyRepoMethodDescriptor =
          MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/GetIamPolicyRepo")
              .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyRepoMethodDescriptor =
          MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/SetIamPolicyRepo")
              .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securesourcemanager.v1.SecureSourceManager/TestIamPermissionsRepo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

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
  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable;
  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable;
  private final UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable;
  private final UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable;
  private final OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable;
  private final UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable;
  private final OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyRepoCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyRepoCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSecureSourceManagerStub create(SecureSourceManagerStubSettings settings)
      throws IOException {
    return new GrpcSecureSourceManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSecureSourceManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSecureSourceManagerStub(
        SecureSourceManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSecureSourceManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSecureSourceManagerStub(
        SecureSourceManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSecureSourceManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecureSourceManagerStub(
      SecureSourceManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSecureSourceManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSecureSourceManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecureSourceManagerStub(
      SecureSourceManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
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
            .build();
    GrpcCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRepositoriesRequest, ListRepositoriesResponse>
        listRepositoriesTransportSettings =
            GrpcCallSettings.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
                .setMethodDescriptor(listRepositoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetRepositoryRequest, Repository> getRepositoryTransportSettings =
        GrpcCallSettings.<GetRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(getRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateRepositoryRequest, Operation> createRepositoryTransportSettings =
        GrpcCallSettings.<CreateRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(createRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRepositoryRequest, Operation> deleteRepositoryTransportSettings =
        GrpcCallSettings.<DeleteRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyRepoTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyRepoMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyRepoTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyRepoMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsRepoTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsRepoMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
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
    this.listRepositoriesCallable =
        callableFactory.createUnaryCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.listRepositoriesPagedCallable =
        callableFactory.createPagedCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.getRepositoryCallable =
        callableFactory.createUnaryCallable(
            getRepositoryTransportSettings, settings.getRepositorySettings(), clientContext);
    this.createRepositoryCallable =
        callableFactory.createUnaryCallable(
            createRepositoryTransportSettings, settings.createRepositorySettings(), clientContext);
    this.createRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            createRepositoryTransportSettings,
            settings.createRepositoryOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteRepositoryCallable =
        callableFactory.createUnaryCallable(
            deleteRepositoryTransportSettings, settings.deleteRepositorySettings(), clientContext);
    this.deleteRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            deleteRepositoryTransportSettings,
            settings.deleteRepositoryOperationSettings(),
            clientContext,
            operationsStub);
    this.getIamPolicyRepoCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyRepoTransportSettings, settings.getIamPolicyRepoSettings(), clientContext);
    this.setIamPolicyRepoCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyRepoTransportSettings, settings.setIamPolicyRepoSettings(), clientContext);
    this.testIamPermissionsRepoCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsRepoTransportSettings,
            settings.testIamPermissionsRepoSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable() {
    return listRepositoriesCallable;
  }

  @Override
  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable() {
    return listRepositoriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable() {
    return getRepositoryCallable;
  }

  @Override
  public UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable() {
    return createRepositoryCallable;
  }

  @Override
  public OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable() {
    return createRepositoryOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable() {
    return deleteRepositoryCallable;
  }

  @Override
  public OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable() {
    return deleteRepositoryOperationCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyRepoCallable() {
    return getIamPolicyRepoCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyRepoCallable() {
    return setIamPolicyRepoCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsRepoCallable() {
    return testIamPermissionsRepoCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
