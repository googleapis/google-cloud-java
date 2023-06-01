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

import static com.google.cloud.aiplatform.v1beta1.IndexEndpointServiceClient.ListIndexEndpointsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.IndexEndpointServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployIndexRequest;
import com.google.cloud.aiplatform.v1beta1.DeployIndexResponse;
import com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.IndexEndpoint;
import com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest;
import com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexResponse;
import com.google.cloud.aiplatform.v1beta1.UndeployIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest;
import com.google.cloud.aiplatform.v1beta1.UndeployIndexResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the IndexEndpointService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcIndexEndpointServiceStub extends IndexEndpointServiceStub {
  private static final MethodDescriptor<CreateIndexEndpointRequest, Operation>
      createIndexEndpointMethodDescriptor =
          MethodDescriptor.<CreateIndexEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.IndexEndpointService/CreateIndexEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateIndexEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIndexEndpointRequest, IndexEndpoint>
      getIndexEndpointMethodDescriptor =
          MethodDescriptor.<GetIndexEndpointRequest, IndexEndpoint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.IndexEndpointService/GetIndexEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetIndexEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IndexEndpoint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsMethodDescriptor =
          MethodDescriptor.<ListIndexEndpointsRequest, ListIndexEndpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.IndexEndpointService/ListIndexEndpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListIndexEndpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIndexEndpointsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateIndexEndpointRequest, IndexEndpoint>
      updateIndexEndpointMethodDescriptor =
          MethodDescriptor.<UpdateIndexEndpointRequest, IndexEndpoint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.IndexEndpointService/UpdateIndexEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateIndexEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IndexEndpoint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteIndexEndpointRequest, Operation>
      deleteIndexEndpointMethodDescriptor =
          MethodDescriptor.<DeleteIndexEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.IndexEndpointService/DeleteIndexEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteIndexEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeployIndexRequest, Operation> deployIndexMethodDescriptor =
      MethodDescriptor.<DeployIndexRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.IndexEndpointService/DeployIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(DeployIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UndeployIndexRequest, Operation>
      undeployIndexMethodDescriptor =
          MethodDescriptor.<UndeployIndexRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.IndexEndpointService/UndeployIndex")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeployIndexRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MutateDeployedIndexRequest, Operation>
      mutateDeployedIndexMethodDescriptor =
          MethodDescriptor.<MutateDeployedIndexRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.IndexEndpointService/MutateDeployedIndex")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MutateDeployedIndexRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private final UnaryCallable<CreateIndexEndpointRequest, Operation> createIndexEndpointCallable;
  private final OperationCallable<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointOperationMetadata>
      createIndexEndpointOperationCallable;
  private final UnaryCallable<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointCallable;
  private final UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsCallable;
  private final UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsPagedResponse>
      listIndexEndpointsPagedCallable;
  private final UnaryCallable<UpdateIndexEndpointRequest, IndexEndpoint>
      updateIndexEndpointCallable;
  private final UnaryCallable<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointCallable;
  private final OperationCallable<DeleteIndexEndpointRequest, Empty, DeleteOperationMetadata>
      deleteIndexEndpointOperationCallable;
  private final UnaryCallable<DeployIndexRequest, Operation> deployIndexCallable;
  private final OperationCallable<
          DeployIndexRequest, DeployIndexResponse, DeployIndexOperationMetadata>
      deployIndexOperationCallable;
  private final UnaryCallable<UndeployIndexRequest, Operation> undeployIndexCallable;
  private final OperationCallable<
          UndeployIndexRequest, UndeployIndexResponse, UndeployIndexOperationMetadata>
      undeployIndexOperationCallable;
  private final UnaryCallable<MutateDeployedIndexRequest, Operation> mutateDeployedIndexCallable;
  private final OperationCallable<
          MutateDeployedIndexRequest,
          MutateDeployedIndexResponse,
          MutateDeployedIndexOperationMetadata>
      mutateDeployedIndexOperationCallable;
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

  public static final GrpcIndexEndpointServiceStub create(IndexEndpointServiceStubSettings settings)
      throws IOException {
    return new GrpcIndexEndpointServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIndexEndpointServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcIndexEndpointServiceStub(
        IndexEndpointServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcIndexEndpointServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcIndexEndpointServiceStub(
        IndexEndpointServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcIndexEndpointServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcIndexEndpointServiceStub(
      IndexEndpointServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcIndexEndpointServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcIndexEndpointServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcIndexEndpointServiceStub(
      IndexEndpointServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateIndexEndpointRequest, Operation> createIndexEndpointTransportSettings =
        GrpcCallSettings.<CreateIndexEndpointRequest, Operation>newBuilder()
            .setMethodDescriptor(createIndexEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointTransportSettings =
        GrpcCallSettings.<GetIndexEndpointRequest, IndexEndpoint>newBuilder()
            .setMethodDescriptor(getIndexEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
        listIndexEndpointsTransportSettings =
            GrpcCallSettings.<ListIndexEndpointsRequest, ListIndexEndpointsResponse>newBuilder()
                .setMethodDescriptor(listIndexEndpointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateIndexEndpointRequest, IndexEndpoint>
        updateIndexEndpointTransportSettings =
            GrpcCallSettings.<UpdateIndexEndpointRequest, IndexEndpoint>newBuilder()
                .setMethodDescriptor(updateIndexEndpointMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "index_endpoint.name",
                          String.valueOf(request.getIndexEndpoint().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointTransportSettings =
        GrpcCallSettings.<DeleteIndexEndpointRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIndexEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeployIndexRequest, Operation> deployIndexTransportSettings =
        GrpcCallSettings.<DeployIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(deployIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("index_endpoint", String.valueOf(request.getIndexEndpoint()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeployIndexRequest, Operation> undeployIndexTransportSettings =
        GrpcCallSettings.<UndeployIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("index_endpoint", String.valueOf(request.getIndexEndpoint()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<MutateDeployedIndexRequest, Operation> mutateDeployedIndexTransportSettings =
        GrpcCallSettings.<MutateDeployedIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(mutateDeployedIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("index_endpoint", String.valueOf(request.getIndexEndpoint()));
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

    this.createIndexEndpointCallable =
        callableFactory.createUnaryCallable(
            createIndexEndpointTransportSettings,
            settings.createIndexEndpointSettings(),
            clientContext);
    this.createIndexEndpointOperationCallable =
        callableFactory.createOperationCallable(
            createIndexEndpointTransportSettings,
            settings.createIndexEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.getIndexEndpointCallable =
        callableFactory.createUnaryCallable(
            getIndexEndpointTransportSettings, settings.getIndexEndpointSettings(), clientContext);
    this.listIndexEndpointsCallable =
        callableFactory.createUnaryCallable(
            listIndexEndpointsTransportSettings,
            settings.listIndexEndpointsSettings(),
            clientContext);
    this.listIndexEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listIndexEndpointsTransportSettings,
            settings.listIndexEndpointsSettings(),
            clientContext);
    this.updateIndexEndpointCallable =
        callableFactory.createUnaryCallable(
            updateIndexEndpointTransportSettings,
            settings.updateIndexEndpointSettings(),
            clientContext);
    this.deleteIndexEndpointCallable =
        callableFactory.createUnaryCallable(
            deleteIndexEndpointTransportSettings,
            settings.deleteIndexEndpointSettings(),
            clientContext);
    this.deleteIndexEndpointOperationCallable =
        callableFactory.createOperationCallable(
            deleteIndexEndpointTransportSettings,
            settings.deleteIndexEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.deployIndexCallable =
        callableFactory.createUnaryCallable(
            deployIndexTransportSettings, settings.deployIndexSettings(), clientContext);
    this.deployIndexOperationCallable =
        callableFactory.createOperationCallable(
            deployIndexTransportSettings,
            settings.deployIndexOperationSettings(),
            clientContext,
            operationsStub);
    this.undeployIndexCallable =
        callableFactory.createUnaryCallable(
            undeployIndexTransportSettings, settings.undeployIndexSettings(), clientContext);
    this.undeployIndexOperationCallable =
        callableFactory.createOperationCallable(
            undeployIndexTransportSettings,
            settings.undeployIndexOperationSettings(),
            clientContext,
            operationsStub);
    this.mutateDeployedIndexCallable =
        callableFactory.createUnaryCallable(
            mutateDeployedIndexTransportSettings,
            settings.mutateDeployedIndexSettings(),
            clientContext);
    this.mutateDeployedIndexOperationCallable =
        callableFactory.createOperationCallable(
            mutateDeployedIndexTransportSettings,
            settings.mutateDeployedIndexOperationSettings(),
            clientContext,
            operationsStub);
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
  public UnaryCallable<CreateIndexEndpointRequest, Operation> createIndexEndpointCallable() {
    return createIndexEndpointCallable;
  }

  @Override
  public OperationCallable<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointOperationMetadata>
      createIndexEndpointOperationCallable() {
    return createIndexEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointCallable() {
    return getIndexEndpointCallable;
  }

  @Override
  public UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsCallable() {
    return listIndexEndpointsCallable;
  }

  @Override
  public UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsPagedResponse>
      listIndexEndpointsPagedCallable() {
    return listIndexEndpointsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateIndexEndpointRequest, IndexEndpoint> updateIndexEndpointCallable() {
    return updateIndexEndpointCallable;
  }

  @Override
  public UnaryCallable<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointCallable() {
    return deleteIndexEndpointCallable;
  }

  @Override
  public OperationCallable<DeleteIndexEndpointRequest, Empty, DeleteOperationMetadata>
      deleteIndexEndpointOperationCallable() {
    return deleteIndexEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<DeployIndexRequest, Operation> deployIndexCallable() {
    return deployIndexCallable;
  }

  @Override
  public OperationCallable<DeployIndexRequest, DeployIndexResponse, DeployIndexOperationMetadata>
      deployIndexOperationCallable() {
    return deployIndexOperationCallable;
  }

  @Override
  public UnaryCallable<UndeployIndexRequest, Operation> undeployIndexCallable() {
    return undeployIndexCallable;
  }

  @Override
  public OperationCallable<
          UndeployIndexRequest, UndeployIndexResponse, UndeployIndexOperationMetadata>
      undeployIndexOperationCallable() {
    return undeployIndexOperationCallable;
  }

  @Override
  public UnaryCallable<MutateDeployedIndexRequest, Operation> mutateDeployedIndexCallable() {
    return mutateDeployedIndexCallable;
  }

  @Override
  public OperationCallable<
          MutateDeployedIndexRequest,
          MutateDeployedIndexResponse,
          MutateDeployedIndexOperationMetadata>
      mutateDeployedIndexOperationCallable() {
    return mutateDeployedIndexOperationCallable;
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
