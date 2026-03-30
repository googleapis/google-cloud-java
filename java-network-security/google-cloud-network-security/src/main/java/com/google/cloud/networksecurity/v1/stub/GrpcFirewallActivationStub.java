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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListFirewallEndpointAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListFirewallEndpointsPagedResponse;
import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListLocationsPagedResponse;

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
import com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest;
import com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest;
import com.google.cloud.networksecurity.v1.FirewallEndpoint;
import com.google.cloud.networksecurity.v1.FirewallEndpointAssociation;
import com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest;
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
 * gRPC stub implementation for the FirewallActivation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcFirewallActivationStub extends FirewallActivationStub {
  private static final MethodDescriptor<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse>
      listFirewallEndpointsMethodDescriptor =
          MethodDescriptor.<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.FirewallActivation/ListFirewallEndpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFirewallEndpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFirewallEndpointsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetFirewallEndpointRequest, FirewallEndpoint>
      getFirewallEndpointMethodDescriptor =
          MethodDescriptor.<GetFirewallEndpointRequest, FirewallEndpoint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.FirewallActivation/GetFirewallEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFirewallEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FirewallEndpoint.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateFirewallEndpointRequest, Operation>
      createFirewallEndpointMethodDescriptor =
          MethodDescriptor.<CreateFirewallEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.FirewallActivation/CreateFirewallEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFirewallEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteFirewallEndpointRequest, Operation>
      deleteFirewallEndpointMethodDescriptor =
          MethodDescriptor.<DeleteFirewallEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.FirewallActivation/DeleteFirewallEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFirewallEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateFirewallEndpointRequest, Operation>
      updateFirewallEndpointMethodDescriptor =
          MethodDescriptor.<UpdateFirewallEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.FirewallActivation/UpdateFirewallEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFirewallEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsResponse>
      listFirewallEndpointAssociationsMethodDescriptor =
          MethodDescriptor
              .<ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.FirewallActivation/ListFirewallEndpointAssociations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListFirewallEndpointAssociationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListFirewallEndpointAssociationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
      getFirewallEndpointAssociationMethodDescriptor =
          MethodDescriptor
              .<GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.FirewallActivation/GetFirewallEndpointAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFirewallEndpointAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FirewallEndpointAssociation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateFirewallEndpointAssociationRequest, Operation>
      createFirewallEndpointAssociationMethodDescriptor =
          MethodDescriptor.<CreateFirewallEndpointAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.FirewallActivation/CreateFirewallEndpointAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateFirewallEndpointAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteFirewallEndpointAssociationRequest, Operation>
      deleteFirewallEndpointAssociationMethodDescriptor =
          MethodDescriptor.<DeleteFirewallEndpointAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.FirewallActivation/DeleteFirewallEndpointAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteFirewallEndpointAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateFirewallEndpointAssociationRequest, Operation>
      updateFirewallEndpointAssociationMethodDescriptor =
          MethodDescriptor.<UpdateFirewallEndpointAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.FirewallActivation/UpdateFirewallEndpointAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateFirewallEndpointAssociationRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse>
      listFirewallEndpointsCallable;
  private final UnaryCallable<ListFirewallEndpointsRequest, ListFirewallEndpointsPagedResponse>
      listFirewallEndpointsPagedCallable;
  private final UnaryCallable<GetFirewallEndpointRequest, FirewallEndpoint>
      getFirewallEndpointCallable;
  private final UnaryCallable<CreateFirewallEndpointRequest, Operation>
      createFirewallEndpointCallable;
  private final OperationCallable<
          CreateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      createFirewallEndpointOperationCallable;
  private final UnaryCallable<DeleteFirewallEndpointRequest, Operation>
      deleteFirewallEndpointCallable;
  private final OperationCallable<DeleteFirewallEndpointRequest, Empty, OperationMetadata>
      deleteFirewallEndpointOperationCallable;
  private final UnaryCallable<UpdateFirewallEndpointRequest, Operation>
      updateFirewallEndpointCallable;
  private final OperationCallable<
          UpdateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      updateFirewallEndpointOperationCallable;
  private final UnaryCallable<
          ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsResponse>
      listFirewallEndpointAssociationsCallable;
  private final UnaryCallable<
          ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsPagedResponse>
      listFirewallEndpointAssociationsPagedCallable;
  private final UnaryCallable<GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
      getFirewallEndpointAssociationCallable;
  private final UnaryCallable<CreateFirewallEndpointAssociationRequest, Operation>
      createFirewallEndpointAssociationCallable;
  private final OperationCallable<
          CreateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      createFirewallEndpointAssociationOperationCallable;
  private final UnaryCallable<DeleteFirewallEndpointAssociationRequest, Operation>
      deleteFirewallEndpointAssociationCallable;
  private final OperationCallable<
          DeleteFirewallEndpointAssociationRequest, Empty, OperationMetadata>
      deleteFirewallEndpointAssociationOperationCallable;
  private final UnaryCallable<UpdateFirewallEndpointAssociationRequest, Operation>
      updateFirewallEndpointAssociationCallable;
  private final OperationCallable<
          UpdateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      updateFirewallEndpointAssociationOperationCallable;
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

  public static final GrpcFirewallActivationStub create(FirewallActivationStubSettings settings)
      throws IOException {
    return new GrpcFirewallActivationStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFirewallActivationStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcFirewallActivationStub(
        FirewallActivationStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFirewallActivationStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFirewallActivationStub(
        FirewallActivationStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFirewallActivationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcFirewallActivationStub(
      FirewallActivationStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcFirewallActivationCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFirewallActivationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcFirewallActivationStub(
      FirewallActivationStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse>
        listFirewallEndpointsTransportSettings =
            GrpcCallSettings
                .<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse>newBuilder()
                .setMethodDescriptor(listFirewallEndpointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetFirewallEndpointRequest, FirewallEndpoint>
        getFirewallEndpointTransportSettings =
            GrpcCallSettings.<GetFirewallEndpointRequest, FirewallEndpoint>newBuilder()
                .setMethodDescriptor(getFirewallEndpointMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateFirewallEndpointRequest, Operation>
        createFirewallEndpointTransportSettings =
            GrpcCallSettings.<CreateFirewallEndpointRequest, Operation>newBuilder()
                .setMethodDescriptor(createFirewallEndpointMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<DeleteFirewallEndpointRequest, Operation>
        deleteFirewallEndpointTransportSettings =
            GrpcCallSettings.<DeleteFirewallEndpointRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteFirewallEndpointMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<UpdateFirewallEndpointRequest, Operation>
        updateFirewallEndpointTransportSettings =
            GrpcCallSettings.<UpdateFirewallEndpointRequest, Operation>newBuilder()
                .setMethodDescriptor(updateFirewallEndpointMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "firewall_endpoint.name",
                          String.valueOf(request.getFirewallEndpoint().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsResponse>
        listFirewallEndpointAssociationsTransportSettings =
            GrpcCallSettings
                .<ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsResponse>
                    newBuilder()
                .setMethodDescriptor(listFirewallEndpointAssociationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
        getFirewallEndpointAssociationTransportSettings =
            GrpcCallSettings
                .<GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>newBuilder()
                .setMethodDescriptor(getFirewallEndpointAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateFirewallEndpointAssociationRequest, Operation>
        createFirewallEndpointAssociationTransportSettings =
            GrpcCallSettings.<CreateFirewallEndpointAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(createFirewallEndpointAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<DeleteFirewallEndpointAssociationRequest, Operation>
        deleteFirewallEndpointAssociationTransportSettings =
            GrpcCallSettings.<DeleteFirewallEndpointAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteFirewallEndpointAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<UpdateFirewallEndpointAssociationRequest, Operation>
        updateFirewallEndpointAssociationTransportSettings =
            GrpcCallSettings.<UpdateFirewallEndpointAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(updateFirewallEndpointAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "firewall_endpoint_association.name",
                          String.valueOf(request.getFirewallEndpointAssociation().getName()));
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

    this.listFirewallEndpointsCallable =
        callableFactory.createUnaryCallable(
            listFirewallEndpointsTransportSettings,
            settings.listFirewallEndpointsSettings(),
            clientContext);
    this.listFirewallEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listFirewallEndpointsTransportSettings,
            settings.listFirewallEndpointsSettings(),
            clientContext);
    this.getFirewallEndpointCallable =
        callableFactory.createUnaryCallable(
            getFirewallEndpointTransportSettings,
            settings.getFirewallEndpointSettings(),
            clientContext);
    this.createFirewallEndpointCallable =
        callableFactory.createUnaryCallable(
            createFirewallEndpointTransportSettings,
            settings.createFirewallEndpointSettings(),
            clientContext);
    this.createFirewallEndpointOperationCallable =
        callableFactory.createOperationCallable(
            createFirewallEndpointTransportSettings,
            settings.createFirewallEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFirewallEndpointCallable =
        callableFactory.createUnaryCallable(
            deleteFirewallEndpointTransportSettings,
            settings.deleteFirewallEndpointSettings(),
            clientContext);
    this.deleteFirewallEndpointOperationCallable =
        callableFactory.createOperationCallable(
            deleteFirewallEndpointTransportSettings,
            settings.deleteFirewallEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.updateFirewallEndpointCallable =
        callableFactory.createUnaryCallable(
            updateFirewallEndpointTransportSettings,
            settings.updateFirewallEndpointSettings(),
            clientContext);
    this.updateFirewallEndpointOperationCallable =
        callableFactory.createOperationCallable(
            updateFirewallEndpointTransportSettings,
            settings.updateFirewallEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.listFirewallEndpointAssociationsCallable =
        callableFactory.createUnaryCallable(
            listFirewallEndpointAssociationsTransportSettings,
            settings.listFirewallEndpointAssociationsSettings(),
            clientContext);
    this.listFirewallEndpointAssociationsPagedCallable =
        callableFactory.createPagedCallable(
            listFirewallEndpointAssociationsTransportSettings,
            settings.listFirewallEndpointAssociationsSettings(),
            clientContext);
    this.getFirewallEndpointAssociationCallable =
        callableFactory.createUnaryCallable(
            getFirewallEndpointAssociationTransportSettings,
            settings.getFirewallEndpointAssociationSettings(),
            clientContext);
    this.createFirewallEndpointAssociationCallable =
        callableFactory.createUnaryCallable(
            createFirewallEndpointAssociationTransportSettings,
            settings.createFirewallEndpointAssociationSettings(),
            clientContext);
    this.createFirewallEndpointAssociationOperationCallable =
        callableFactory.createOperationCallable(
            createFirewallEndpointAssociationTransportSettings,
            settings.createFirewallEndpointAssociationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFirewallEndpointAssociationCallable =
        callableFactory.createUnaryCallable(
            deleteFirewallEndpointAssociationTransportSettings,
            settings.deleteFirewallEndpointAssociationSettings(),
            clientContext);
    this.deleteFirewallEndpointAssociationOperationCallable =
        callableFactory.createOperationCallable(
            deleteFirewallEndpointAssociationTransportSettings,
            settings.deleteFirewallEndpointAssociationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateFirewallEndpointAssociationCallable =
        callableFactory.createUnaryCallable(
            updateFirewallEndpointAssociationTransportSettings,
            settings.updateFirewallEndpointAssociationSettings(),
            clientContext);
    this.updateFirewallEndpointAssociationOperationCallable =
        callableFactory.createOperationCallable(
            updateFirewallEndpointAssociationTransportSettings,
            settings.updateFirewallEndpointAssociationOperationSettings(),
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
  public UnaryCallable<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse>
      listFirewallEndpointsCallable() {
    return listFirewallEndpointsCallable;
  }

  @Override
  public UnaryCallable<ListFirewallEndpointsRequest, ListFirewallEndpointsPagedResponse>
      listFirewallEndpointsPagedCallable() {
    return listFirewallEndpointsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFirewallEndpointRequest, FirewallEndpoint> getFirewallEndpointCallable() {
    return getFirewallEndpointCallable;
  }

  @Override
  public UnaryCallable<CreateFirewallEndpointRequest, Operation> createFirewallEndpointCallable() {
    return createFirewallEndpointCallable;
  }

  @Override
  public OperationCallable<CreateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      createFirewallEndpointOperationCallable() {
    return createFirewallEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFirewallEndpointRequest, Operation> deleteFirewallEndpointCallable() {
    return deleteFirewallEndpointCallable;
  }

  @Override
  public OperationCallable<DeleteFirewallEndpointRequest, Empty, OperationMetadata>
      deleteFirewallEndpointOperationCallable() {
    return deleteFirewallEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFirewallEndpointRequest, Operation> updateFirewallEndpointCallable() {
    return updateFirewallEndpointCallable;
  }

  @Override
  public OperationCallable<UpdateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      updateFirewallEndpointOperationCallable() {
    return updateFirewallEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsResponse>
      listFirewallEndpointAssociationsCallable() {
    return listFirewallEndpointAssociationsCallable;
  }

  @Override
  public UnaryCallable<
          ListFirewallEndpointAssociationsRequest, ListFirewallEndpointAssociationsPagedResponse>
      listFirewallEndpointAssociationsPagedCallable() {
    return listFirewallEndpointAssociationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
      getFirewallEndpointAssociationCallable() {
    return getFirewallEndpointAssociationCallable;
  }

  @Override
  public UnaryCallable<CreateFirewallEndpointAssociationRequest, Operation>
      createFirewallEndpointAssociationCallable() {
    return createFirewallEndpointAssociationCallable;
  }

  @Override
  public OperationCallable<
          CreateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      createFirewallEndpointAssociationOperationCallable() {
    return createFirewallEndpointAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFirewallEndpointAssociationRequest, Operation>
      deleteFirewallEndpointAssociationCallable() {
    return deleteFirewallEndpointAssociationCallable;
  }

  @Override
  public OperationCallable<DeleteFirewallEndpointAssociationRequest, Empty, OperationMetadata>
      deleteFirewallEndpointAssociationOperationCallable() {
    return deleteFirewallEndpointAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFirewallEndpointAssociationRequest, Operation>
      updateFirewallEndpointAssociationCallable() {
    return updateFirewallEndpointAssociationCallable;
  }

  @Override
  public OperationCallable<
          UpdateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      updateFirewallEndpointAssociationOperationCallable() {
    return updateFirewallEndpointAssociationOperationCallable;
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
