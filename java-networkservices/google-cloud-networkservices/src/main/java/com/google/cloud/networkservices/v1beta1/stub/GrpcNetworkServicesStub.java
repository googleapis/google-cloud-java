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

package com.google.cloud.networkservices.v1beta1.stub;

import static com.google.cloud.networkservices.v1beta1.NetworkServicesClient.ListEndpointPoliciesPagedResponse;
import static com.google.cloud.networkservices.v1beta1.NetworkServicesClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest;
import com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest;
import com.google.cloud.networkservices.v1beta1.EndpointPolicy;
import com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest;
import com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest;
import com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse;
import com.google.cloud.networkservices.v1beta1.OperationMetadata;
import com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the NetworkServices service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcNetworkServicesStub extends NetworkServicesStub {
  private static final MethodDescriptor<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
      listEndpointPoliciesMethodDescriptor =
          MethodDescriptor.<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1beta1.NetworkServices/ListEndpointPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEndpointPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEndpointPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEndpointPolicyRequest, EndpointPolicy>
      getEndpointPolicyMethodDescriptor =
          MethodDescriptor.<GetEndpointPolicyRequest, EndpointPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1beta1.NetworkServices/GetEndpointPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEndpointPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EndpointPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateEndpointPolicyRequest, Operation>
      createEndpointPolicyMethodDescriptor =
          MethodDescriptor.<CreateEndpointPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1beta1.NetworkServices/CreateEndpointPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEndpointPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateEndpointPolicyRequest, Operation>
      updateEndpointPolicyMethodDescriptor =
          MethodDescriptor.<UpdateEndpointPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1beta1.NetworkServices/UpdateEndpointPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEndpointPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteEndpointPolicyRequest, Operation>
      deleteEndpointPolicyMethodDescriptor =
          MethodDescriptor.<DeleteEndpointPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1beta1.NetworkServices/DeleteEndpointPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEndpointPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
      listEndpointPoliciesCallable;
  private final UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesPagedCallable;
  private final UnaryCallable<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicyCallable;
  private final UnaryCallable<CreateEndpointPolicyRequest, Operation> createEndpointPolicyCallable;
  private final OperationCallable<CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationCallable;
  private final UnaryCallable<UpdateEndpointPolicyRequest, Operation> updateEndpointPolicyCallable;
  private final OperationCallable<UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationCallable;
  private final UnaryCallable<DeleteEndpointPolicyRequest, Operation> deleteEndpointPolicyCallable;
  private final OperationCallable<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationCallable;
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

  public static final GrpcNetworkServicesStub create(NetworkServicesStubSettings settings)
      throws IOException {
    return new GrpcNetworkServicesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNetworkServicesStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcNetworkServicesStub(
        NetworkServicesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNetworkServicesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNetworkServicesStub(
        NetworkServicesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNetworkServicesStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNetworkServicesStub(
      NetworkServicesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcNetworkServicesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNetworkServicesStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNetworkServicesStub(
      NetworkServicesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
        listEndpointPoliciesTransportSettings =
            GrpcCallSettings.<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>newBuilder()
                .setMethodDescriptor(listEndpointPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicyTransportSettings =
        GrpcCallSettings.<GetEndpointPolicyRequest, EndpointPolicy>newBuilder()
            .setMethodDescriptor(getEndpointPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateEndpointPolicyRequest, Operation> createEndpointPolicyTransportSettings =
        GrpcCallSettings.<CreateEndpointPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(createEndpointPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateEndpointPolicyRequest, Operation> updateEndpointPolicyTransportSettings =
        GrpcCallSettings.<UpdateEndpointPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEndpointPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "endpoint_policy.name",
                      String.valueOf(request.getEndpointPolicy().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEndpointPolicyRequest, Operation> deleteEndpointPolicyTransportSettings =
        GrpcCallSettings.<DeleteEndpointPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEndpointPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
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

    this.listEndpointPoliciesCallable =
        callableFactory.createUnaryCallable(
            listEndpointPoliciesTransportSettings,
            settings.listEndpointPoliciesSettings(),
            clientContext);
    this.listEndpointPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listEndpointPoliciesTransportSettings,
            settings.listEndpointPoliciesSettings(),
            clientContext);
    this.getEndpointPolicyCallable =
        callableFactory.createUnaryCallable(
            getEndpointPolicyTransportSettings,
            settings.getEndpointPolicySettings(),
            clientContext);
    this.createEndpointPolicyCallable =
        callableFactory.createUnaryCallable(
            createEndpointPolicyTransportSettings,
            settings.createEndpointPolicySettings(),
            clientContext);
    this.createEndpointPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createEndpointPolicyTransportSettings,
            settings.createEndpointPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateEndpointPolicyCallable =
        callableFactory.createUnaryCallable(
            updateEndpointPolicyTransportSettings,
            settings.updateEndpointPolicySettings(),
            clientContext);
    this.updateEndpointPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateEndpointPolicyTransportSettings,
            settings.updateEndpointPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEndpointPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteEndpointPolicyTransportSettings,
            settings.deleteEndpointPolicySettings(),
            clientContext);
    this.deleteEndpointPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteEndpointPolicyTransportSettings,
            settings.deleteEndpointPolicyOperationSettings(),
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
  public UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
      listEndpointPoliciesCallable() {
    return listEndpointPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesPagedCallable() {
    return listEndpointPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicyCallable() {
    return getEndpointPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateEndpointPolicyRequest, Operation> createEndpointPolicyCallable() {
    return createEndpointPolicyCallable;
  }

  @Override
  public OperationCallable<CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationCallable() {
    return createEndpointPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEndpointPolicyRequest, Operation> updateEndpointPolicyCallable() {
    return updateEndpointPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationCallable() {
    return updateEndpointPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEndpointPolicyRequest, Operation> deleteEndpointPolicyCallable() {
    return deleteEndpointPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationCallable() {
    return deleteEndpointPolicyOperationCallable;
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
