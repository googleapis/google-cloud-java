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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.ListDeploymentResourcePoolsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.QueryDeployedModelsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool;
import com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest;
import com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse;
import com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest;
import com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DeploymentResourcePoolService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDeploymentResourcePoolServiceStub extends DeploymentResourcePoolServiceStub {
  private static final MethodDescriptor<CreateDeploymentResourcePoolRequest, Operation>
      createDeploymentResourcePoolMethodDescriptor =
          MethodDescriptor.<CreateDeploymentResourcePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.DeploymentResourcePoolService/CreateDeploymentResourcePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDeploymentResourcePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDeploymentResourcePoolRequest, DeploymentResourcePool>
      getDeploymentResourcePoolMethodDescriptor =
          MethodDescriptor.<GetDeploymentResourcePoolRequest, DeploymentResourcePool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.DeploymentResourcePoolService/GetDeploymentResourcePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDeploymentResourcePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DeploymentResourcePool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsResponse>
      listDeploymentResourcePoolsMethodDescriptor =
          MethodDescriptor
              .<ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.DeploymentResourcePoolService/ListDeploymentResourcePools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeploymentResourcePoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeploymentResourcePoolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDeploymentResourcePoolRequest, Operation>
      deleteDeploymentResourcePoolMethodDescriptor =
          MethodDescriptor.<DeleteDeploymentResourcePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.DeploymentResourcePoolService/DeleteDeploymentResourcePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDeploymentResourcePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<QueryDeployedModelsRequest, QueryDeployedModelsResponse>
      queryDeployedModelsMethodDescriptor =
          MethodDescriptor.<QueryDeployedModelsRequest, QueryDeployedModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.DeploymentResourcePoolService/QueryDeployedModels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryDeployedModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryDeployedModelsResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateDeploymentResourcePoolRequest, Operation>
      createDeploymentResourcePoolCallable;
  private final OperationCallable<
          CreateDeploymentResourcePoolRequest,
          DeploymentResourcePool,
          CreateDeploymentResourcePoolOperationMetadata>
      createDeploymentResourcePoolOperationCallable;
  private final UnaryCallable<GetDeploymentResourcePoolRequest, DeploymentResourcePool>
      getDeploymentResourcePoolCallable;
  private final UnaryCallable<
          ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsResponse>
      listDeploymentResourcePoolsCallable;
  private final UnaryCallable<
          ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsPagedResponse>
      listDeploymentResourcePoolsPagedCallable;
  private final UnaryCallable<DeleteDeploymentResourcePoolRequest, Operation>
      deleteDeploymentResourcePoolCallable;
  private final OperationCallable<
          DeleteDeploymentResourcePoolRequest, Empty, DeleteOperationMetadata>
      deleteDeploymentResourcePoolOperationCallable;
  private final UnaryCallable<QueryDeployedModelsRequest, QueryDeployedModelsResponse>
      queryDeployedModelsCallable;
  private final UnaryCallable<QueryDeployedModelsRequest, QueryDeployedModelsPagedResponse>
      queryDeployedModelsPagedCallable;
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

  public static final GrpcDeploymentResourcePoolServiceStub create(
      DeploymentResourcePoolServiceStubSettings settings) throws IOException {
    return new GrpcDeploymentResourcePoolServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDeploymentResourcePoolServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDeploymentResourcePoolServiceStub(
        DeploymentResourcePoolServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDeploymentResourcePoolServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDeploymentResourcePoolServiceStub(
        DeploymentResourcePoolServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcDeploymentResourcePoolServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDeploymentResourcePoolServiceStub(
      DeploymentResourcePoolServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDeploymentResourcePoolServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDeploymentResourcePoolServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDeploymentResourcePoolServiceStub(
      DeploymentResourcePoolServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDeploymentResourcePoolRequest, Operation>
        createDeploymentResourcePoolTransportSettings =
            GrpcCallSettings.<CreateDeploymentResourcePoolRequest, Operation>newBuilder()
                .setMethodDescriptor(createDeploymentResourcePoolMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetDeploymentResourcePoolRequest, DeploymentResourcePool>
        getDeploymentResourcePoolTransportSettings =
            GrpcCallSettings.<GetDeploymentResourcePoolRequest, DeploymentResourcePool>newBuilder()
                .setMethodDescriptor(getDeploymentResourcePoolMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsResponse>
        listDeploymentResourcePoolsTransportSettings =
            GrpcCallSettings
                .<ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsResponse>
                    newBuilder()
                .setMethodDescriptor(listDeploymentResourcePoolsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteDeploymentResourcePoolRequest, Operation>
        deleteDeploymentResourcePoolTransportSettings =
            GrpcCallSettings.<DeleteDeploymentResourcePoolRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDeploymentResourcePoolMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<QueryDeployedModelsRequest, QueryDeployedModelsResponse>
        queryDeployedModelsTransportSettings =
            GrpcCallSettings.<QueryDeployedModelsRequest, QueryDeployedModelsResponse>newBuilder()
                .setMethodDescriptor(queryDeployedModelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "deployment_resource_pool",
                          String.valueOf(request.getDeploymentResourcePool()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();

    this.createDeploymentResourcePoolCallable =
        callableFactory.createUnaryCallable(
            createDeploymentResourcePoolTransportSettings,
            settings.createDeploymentResourcePoolSettings(),
            clientContext);
    this.createDeploymentResourcePoolOperationCallable =
        callableFactory.createOperationCallable(
            createDeploymentResourcePoolTransportSettings,
            settings.createDeploymentResourcePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.getDeploymentResourcePoolCallable =
        callableFactory.createUnaryCallable(
            getDeploymentResourcePoolTransportSettings,
            settings.getDeploymentResourcePoolSettings(),
            clientContext);
    this.listDeploymentResourcePoolsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentResourcePoolsTransportSettings,
            settings.listDeploymentResourcePoolsSettings(),
            clientContext);
    this.listDeploymentResourcePoolsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentResourcePoolsTransportSettings,
            settings.listDeploymentResourcePoolsSettings(),
            clientContext);
    this.deleteDeploymentResourcePoolCallable =
        callableFactory.createUnaryCallable(
            deleteDeploymentResourcePoolTransportSettings,
            settings.deleteDeploymentResourcePoolSettings(),
            clientContext);
    this.deleteDeploymentResourcePoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteDeploymentResourcePoolTransportSettings,
            settings.deleteDeploymentResourcePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.queryDeployedModelsCallable =
        callableFactory.createUnaryCallable(
            queryDeployedModelsTransportSettings,
            settings.queryDeployedModelsSettings(),
            clientContext);
    this.queryDeployedModelsPagedCallable =
        callableFactory.createPagedCallable(
            queryDeployedModelsTransportSettings,
            settings.queryDeployedModelsSettings(),
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
  public UnaryCallable<CreateDeploymentResourcePoolRequest, Operation>
      createDeploymentResourcePoolCallable() {
    return createDeploymentResourcePoolCallable;
  }

  @Override
  public OperationCallable<
          CreateDeploymentResourcePoolRequest,
          DeploymentResourcePool,
          CreateDeploymentResourcePoolOperationMetadata>
      createDeploymentResourcePoolOperationCallable() {
    return createDeploymentResourcePoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetDeploymentResourcePoolRequest, DeploymentResourcePool>
      getDeploymentResourcePoolCallable() {
    return getDeploymentResourcePoolCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsResponse>
      listDeploymentResourcePoolsCallable() {
    return listDeploymentResourcePoolsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsPagedResponse>
      listDeploymentResourcePoolsPagedCallable() {
    return listDeploymentResourcePoolsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDeploymentResourcePoolRequest, Operation>
      deleteDeploymentResourcePoolCallable() {
    return deleteDeploymentResourcePoolCallable;
  }

  @Override
  public OperationCallable<DeleteDeploymentResourcePoolRequest, Empty, DeleteOperationMetadata>
      deleteDeploymentResourcePoolOperationCallable() {
    return deleteDeploymentResourcePoolOperationCallable;
  }

  @Override
  public UnaryCallable<QueryDeployedModelsRequest, QueryDeployedModelsResponse>
      queryDeployedModelsCallable() {
    return queryDeployedModelsCallable;
  }

  @Override
  public UnaryCallable<QueryDeployedModelsRequest, QueryDeployedModelsPagedResponse>
      queryDeployedModelsPagedCallable() {
    return queryDeployedModelsPagedCallable;
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
