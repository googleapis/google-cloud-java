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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.EndpointServiceClient.ListEndpointsPagedResponse;
import static com.google.cloud.aiplatform.v1.EndpointServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CreateEndpointOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateEndpointRequest;
import com.google.cloud.aiplatform.v1.DeleteEndpointRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.DeployModelOperationMetadata;
import com.google.cloud.aiplatform.v1.DeployModelRequest;
import com.google.cloud.aiplatform.v1.DeployModelResponse;
import com.google.cloud.aiplatform.v1.Endpoint;
import com.google.cloud.aiplatform.v1.GetEndpointRequest;
import com.google.cloud.aiplatform.v1.ListEndpointsRequest;
import com.google.cloud.aiplatform.v1.ListEndpointsResponse;
import com.google.cloud.aiplatform.v1.UndeployModelOperationMetadata;
import com.google.cloud.aiplatform.v1.UndeployModelRequest;
import com.google.cloud.aiplatform.v1.UndeployModelResponse;
import com.google.cloud.aiplatform.v1.UpdateEndpointRequest;
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
 * gRPC stub implementation for the EndpointService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEndpointServiceStub extends EndpointServiceStub {
  private static final MethodDescriptor<CreateEndpointRequest, Operation>
      createEndpointMethodDescriptor =
          MethodDescriptor.<CreateEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.EndpointService/CreateEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEndpointRequest, Endpoint> getEndpointMethodDescriptor =
      MethodDescriptor.<GetEndpointRequest, Endpoint>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.EndpointService/GetEndpoint")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEndpointRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Endpoint.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListEndpointsRequest, ListEndpointsResponse>
      listEndpointsMethodDescriptor =
          MethodDescriptor.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.EndpointService/ListEndpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEndpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEndpointsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEndpointRequest, Endpoint>
      updateEndpointMethodDescriptor =
          MethodDescriptor.<UpdateEndpointRequest, Endpoint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.EndpointService/UpdateEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Endpoint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEndpointRequest, Operation>
      deleteEndpointMethodDescriptor =
          MethodDescriptor.<DeleteEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.EndpointService/DeleteEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeployModelRequest, Operation> deployModelMethodDescriptor =
      MethodDescriptor.<DeployModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.EndpointService/DeployModel")
          .setRequestMarshaller(ProtoUtils.marshaller(DeployModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UndeployModelRequest, Operation>
      undeployModelMethodDescriptor =
          MethodDescriptor.<UndeployModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.EndpointService/UndeployModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeployModelRequest.getDefaultInstance()))
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

  private final UnaryCallable<CreateEndpointRequest, Operation> createEndpointCallable;
  private final OperationCallable<CreateEndpointRequest, Endpoint, CreateEndpointOperationMetadata>
      createEndpointOperationCallable;
  private final UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable;
  private final UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable;
  private final UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable;
  private final UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable;
  private final UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable;
  private final OperationCallable<DeleteEndpointRequest, Empty, DeleteOperationMetadata>
      deleteEndpointOperationCallable;
  private final UnaryCallable<DeployModelRequest, Operation> deployModelCallable;
  private final OperationCallable<
          DeployModelRequest, DeployModelResponse, DeployModelOperationMetadata>
      deployModelOperationCallable;
  private final UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable;
  private final OperationCallable<
          UndeployModelRequest, UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelOperationCallable;
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

  public static final GrpcEndpointServiceStub create(EndpointServiceStubSettings settings)
      throws IOException {
    return new GrpcEndpointServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEndpointServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcEndpointServiceStub(
        EndpointServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEndpointServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEndpointServiceStub(
        EndpointServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEndpointServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEndpointServiceStub(
      EndpointServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcEndpointServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEndpointServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEndpointServiceStub(
      EndpointServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateEndpointRequest, Operation> createEndpointTransportSettings =
        GrpcCallSettings.<CreateEndpointRequest, Operation>newBuilder()
            .setMethodDescriptor(createEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetEndpointRequest, Endpoint> getEndpointTransportSettings =
        GrpcCallSettings.<GetEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(getEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListEndpointsRequest, ListEndpointsResponse> listEndpointsTransportSettings =
        GrpcCallSettings.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
            .setMethodDescriptor(listEndpointsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateEndpointRequest, Endpoint> updateEndpointTransportSettings =
        GrpcCallSettings.<UpdateEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(updateEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("endpoint.name", String.valueOf(request.getEndpoint().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteEndpointRequest, Operation> deleteEndpointTransportSettings =
        GrpcCallSettings.<DeleteEndpointRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeployModelRequest, Operation> deployModelTransportSettings =
        GrpcCallSettings.<DeployModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deployModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("endpoint", String.valueOf(request.getEndpoint()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeployModelRequest, Operation> undeployModelTransportSettings =
        GrpcCallSettings.<UndeployModelRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("endpoint", String.valueOf(request.getEndpoint()));
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

    this.createEndpointCallable =
        callableFactory.createUnaryCallable(
            createEndpointTransportSettings, settings.createEndpointSettings(), clientContext);
    this.createEndpointOperationCallable =
        callableFactory.createOperationCallable(
            createEndpointTransportSettings,
            settings.createEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.getEndpointCallable =
        callableFactory.createUnaryCallable(
            getEndpointTransportSettings, settings.getEndpointSettings(), clientContext);
    this.listEndpointsCallable =
        callableFactory.createUnaryCallable(
            listEndpointsTransportSettings, settings.listEndpointsSettings(), clientContext);
    this.listEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listEndpointsTransportSettings, settings.listEndpointsSettings(), clientContext);
    this.updateEndpointCallable =
        callableFactory.createUnaryCallable(
            updateEndpointTransportSettings, settings.updateEndpointSettings(), clientContext);
    this.deleteEndpointCallable =
        callableFactory.createUnaryCallable(
            deleteEndpointTransportSettings, settings.deleteEndpointSettings(), clientContext);
    this.deleteEndpointOperationCallable =
        callableFactory.createOperationCallable(
            deleteEndpointTransportSettings,
            settings.deleteEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.deployModelCallable =
        callableFactory.createUnaryCallable(
            deployModelTransportSettings, settings.deployModelSettings(), clientContext);
    this.deployModelOperationCallable =
        callableFactory.createOperationCallable(
            deployModelTransportSettings,
            settings.deployModelOperationSettings(),
            clientContext,
            operationsStub);
    this.undeployModelCallable =
        callableFactory.createUnaryCallable(
            undeployModelTransportSettings, settings.undeployModelSettings(), clientContext);
    this.undeployModelOperationCallable =
        callableFactory.createOperationCallable(
            undeployModelTransportSettings,
            settings.undeployModelOperationSettings(),
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
  public UnaryCallable<CreateEndpointRequest, Operation> createEndpointCallable() {
    return createEndpointCallable;
  }

  @Override
  public OperationCallable<CreateEndpointRequest, Endpoint, CreateEndpointOperationMetadata>
      createEndpointOperationCallable() {
    return createEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    return getEndpointCallable;
  }

  @Override
  public UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    return listEndpointsCallable;
  }

  @Override
  public UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    return listEndpointsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable() {
    return updateEndpointCallable;
  }

  @Override
  public UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable() {
    return deleteEndpointCallable;
  }

  @Override
  public OperationCallable<DeleteEndpointRequest, Empty, DeleteOperationMetadata>
      deleteEndpointOperationCallable() {
    return deleteEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<DeployModelRequest, Operation> deployModelCallable() {
    return deployModelCallable;
  }

  @Override
  public OperationCallable<DeployModelRequest, DeployModelResponse, DeployModelOperationMetadata>
      deployModelOperationCallable() {
    return deployModelOperationCallable;
  }

  @Override
  public UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable() {
    return undeployModelCallable;
  }

  @Override
  public OperationCallable<
          UndeployModelRequest, UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelOperationCallable() {
    return undeployModelOperationCallable;
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
