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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.OnlineEvaluatorServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.OnlineEvaluatorServiceClient.ListOnlineEvaluatorsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest;
import com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse;
import com.google.cloud.aiplatform.v1beta1.OnlineEvaluator;
import com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * gRPC stub implementation for the OnlineEvaluatorService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcOnlineEvaluatorServiceStub extends OnlineEvaluatorServiceStub {
  private static final MethodDescriptor<CreateOnlineEvaluatorRequest, Operation>
      createOnlineEvaluatorMethodDescriptor =
          MethodDescriptor.<CreateOnlineEvaluatorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.OnlineEvaluatorService/CreateOnlineEvaluator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOnlineEvaluatorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetOnlineEvaluatorRequest, OnlineEvaluator>
      getOnlineEvaluatorMethodDescriptor =
          MethodDescriptor.<GetOnlineEvaluatorRequest, OnlineEvaluator>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.OnlineEvaluatorService/GetOnlineEvaluator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOnlineEvaluatorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(OnlineEvaluator.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateOnlineEvaluatorRequest, Operation>
      updateOnlineEvaluatorMethodDescriptor =
          MethodDescriptor.<UpdateOnlineEvaluatorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.OnlineEvaluatorService/UpdateOnlineEvaluator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateOnlineEvaluatorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteOnlineEvaluatorRequest, Operation>
      deleteOnlineEvaluatorMethodDescriptor =
          MethodDescriptor.<DeleteOnlineEvaluatorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.OnlineEvaluatorService/DeleteOnlineEvaluator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteOnlineEvaluatorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsResponse>
      listOnlineEvaluatorsMethodDescriptor =
          MethodDescriptor.<ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.OnlineEvaluatorService/ListOnlineEvaluators")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOnlineEvaluatorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOnlineEvaluatorsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ActivateOnlineEvaluatorRequest, Operation>
      activateOnlineEvaluatorMethodDescriptor =
          MethodDescriptor.<ActivateOnlineEvaluatorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.OnlineEvaluatorService/ActivateOnlineEvaluator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ActivateOnlineEvaluatorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SuspendOnlineEvaluatorRequest, Operation>
      suspendOnlineEvaluatorMethodDescriptor =
          MethodDescriptor.<SuspendOnlineEvaluatorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.OnlineEvaluatorService/SuspendOnlineEvaluator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SuspendOnlineEvaluatorRequest.getDefaultInstance()))
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

  private final UnaryCallable<CreateOnlineEvaluatorRequest, Operation>
      createOnlineEvaluatorCallable;
  private final OperationCallable<
          CreateOnlineEvaluatorRequest, OnlineEvaluator, CreateOnlineEvaluatorOperationMetadata>
      createOnlineEvaluatorOperationCallable;
  private final UnaryCallable<GetOnlineEvaluatorRequest, OnlineEvaluator>
      getOnlineEvaluatorCallable;
  private final UnaryCallable<UpdateOnlineEvaluatorRequest, Operation>
      updateOnlineEvaluatorCallable;
  private final OperationCallable<
          UpdateOnlineEvaluatorRequest, OnlineEvaluator, UpdateOnlineEvaluatorOperationMetadata>
      updateOnlineEvaluatorOperationCallable;
  private final UnaryCallable<DeleteOnlineEvaluatorRequest, Operation>
      deleteOnlineEvaluatorCallable;
  private final OperationCallable<
          DeleteOnlineEvaluatorRequest, Empty, DeleteOnlineEvaluatorOperationMetadata>
      deleteOnlineEvaluatorOperationCallable;
  private final UnaryCallable<ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsResponse>
      listOnlineEvaluatorsCallable;
  private final UnaryCallable<ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsPagedResponse>
      listOnlineEvaluatorsPagedCallable;
  private final UnaryCallable<ActivateOnlineEvaluatorRequest, Operation>
      activateOnlineEvaluatorCallable;
  private final OperationCallable<
          ActivateOnlineEvaluatorRequest, OnlineEvaluator, ActivateOnlineEvaluatorOperationMetadata>
      activateOnlineEvaluatorOperationCallable;
  private final UnaryCallable<SuspendOnlineEvaluatorRequest, Operation>
      suspendOnlineEvaluatorCallable;
  private final OperationCallable<
          SuspendOnlineEvaluatorRequest, OnlineEvaluator, SuspendOnlineEvaluatorOperationMetadata>
      suspendOnlineEvaluatorOperationCallable;
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

  public static final GrpcOnlineEvaluatorServiceStub create(
      OnlineEvaluatorServiceStubSettings settings) throws IOException {
    return new GrpcOnlineEvaluatorServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOnlineEvaluatorServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOnlineEvaluatorServiceStub(
        OnlineEvaluatorServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOnlineEvaluatorServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOnlineEvaluatorServiceStub(
        OnlineEvaluatorServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcOnlineEvaluatorServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcOnlineEvaluatorServiceStub(
      OnlineEvaluatorServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcOnlineEvaluatorServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOnlineEvaluatorServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcOnlineEvaluatorServiceStub(
      OnlineEvaluatorServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateOnlineEvaluatorRequest, Operation>
        createOnlineEvaluatorTransportSettings =
            GrpcCallSettings.<CreateOnlineEvaluatorRequest, Operation>newBuilder()
                .setMethodDescriptor(createOnlineEvaluatorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetOnlineEvaluatorRequest, OnlineEvaluator>
        getOnlineEvaluatorTransportSettings =
            GrpcCallSettings.<GetOnlineEvaluatorRequest, OnlineEvaluator>newBuilder()
                .setMethodDescriptor(getOnlineEvaluatorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<UpdateOnlineEvaluatorRequest, Operation>
        updateOnlineEvaluatorTransportSettings =
            GrpcCallSettings.<UpdateOnlineEvaluatorRequest, Operation>newBuilder()
                .setMethodDescriptor(updateOnlineEvaluatorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "online_evaluator.name",
                          String.valueOf(request.getOnlineEvaluator().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteOnlineEvaluatorRequest, Operation>
        deleteOnlineEvaluatorTransportSettings =
            GrpcCallSettings.<DeleteOnlineEvaluatorRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteOnlineEvaluatorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsResponse>
        listOnlineEvaluatorsTransportSettings =
            GrpcCallSettings.<ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsResponse>newBuilder()
                .setMethodDescriptor(listOnlineEvaluatorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ActivateOnlineEvaluatorRequest, Operation>
        activateOnlineEvaluatorTransportSettings =
            GrpcCallSettings.<ActivateOnlineEvaluatorRequest, Operation>newBuilder()
                .setMethodDescriptor(activateOnlineEvaluatorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<SuspendOnlineEvaluatorRequest, Operation>
        suspendOnlineEvaluatorTransportSettings =
            GrpcCallSettings.<SuspendOnlineEvaluatorRequest, Operation>newBuilder()
                .setMethodDescriptor(suspendOnlineEvaluatorMethodDescriptor)
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

    this.createOnlineEvaluatorCallable =
        callableFactory.createUnaryCallable(
            createOnlineEvaluatorTransportSettings,
            settings.createOnlineEvaluatorSettings(),
            clientContext);
    this.createOnlineEvaluatorOperationCallable =
        callableFactory.createOperationCallable(
            createOnlineEvaluatorTransportSettings,
            settings.createOnlineEvaluatorOperationSettings(),
            clientContext,
            operationsStub);
    this.getOnlineEvaluatorCallable =
        callableFactory.createUnaryCallable(
            getOnlineEvaluatorTransportSettings,
            settings.getOnlineEvaluatorSettings(),
            clientContext);
    this.updateOnlineEvaluatorCallable =
        callableFactory.createUnaryCallable(
            updateOnlineEvaluatorTransportSettings,
            settings.updateOnlineEvaluatorSettings(),
            clientContext);
    this.updateOnlineEvaluatorOperationCallable =
        callableFactory.createOperationCallable(
            updateOnlineEvaluatorTransportSettings,
            settings.updateOnlineEvaluatorOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteOnlineEvaluatorCallable =
        callableFactory.createUnaryCallable(
            deleteOnlineEvaluatorTransportSettings,
            settings.deleteOnlineEvaluatorSettings(),
            clientContext);
    this.deleteOnlineEvaluatorOperationCallable =
        callableFactory.createOperationCallable(
            deleteOnlineEvaluatorTransportSettings,
            settings.deleteOnlineEvaluatorOperationSettings(),
            clientContext,
            operationsStub);
    this.listOnlineEvaluatorsCallable =
        callableFactory.createUnaryCallable(
            listOnlineEvaluatorsTransportSettings,
            settings.listOnlineEvaluatorsSettings(),
            clientContext);
    this.listOnlineEvaluatorsPagedCallable =
        callableFactory.createPagedCallable(
            listOnlineEvaluatorsTransportSettings,
            settings.listOnlineEvaluatorsSettings(),
            clientContext);
    this.activateOnlineEvaluatorCallable =
        callableFactory.createUnaryCallable(
            activateOnlineEvaluatorTransportSettings,
            settings.activateOnlineEvaluatorSettings(),
            clientContext);
    this.activateOnlineEvaluatorOperationCallable =
        callableFactory.createOperationCallable(
            activateOnlineEvaluatorTransportSettings,
            settings.activateOnlineEvaluatorOperationSettings(),
            clientContext,
            operationsStub);
    this.suspendOnlineEvaluatorCallable =
        callableFactory.createUnaryCallable(
            suspendOnlineEvaluatorTransportSettings,
            settings.suspendOnlineEvaluatorSettings(),
            clientContext);
    this.suspendOnlineEvaluatorOperationCallable =
        callableFactory.createOperationCallable(
            suspendOnlineEvaluatorTransportSettings,
            settings.suspendOnlineEvaluatorOperationSettings(),
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
  public UnaryCallable<CreateOnlineEvaluatorRequest, Operation> createOnlineEvaluatorCallable() {
    return createOnlineEvaluatorCallable;
  }

  @Override
  public OperationCallable<
          CreateOnlineEvaluatorRequest, OnlineEvaluator, CreateOnlineEvaluatorOperationMetadata>
      createOnlineEvaluatorOperationCallable() {
    return createOnlineEvaluatorOperationCallable;
  }

  @Override
  public UnaryCallable<GetOnlineEvaluatorRequest, OnlineEvaluator> getOnlineEvaluatorCallable() {
    return getOnlineEvaluatorCallable;
  }

  @Override
  public UnaryCallable<UpdateOnlineEvaluatorRequest, Operation> updateOnlineEvaluatorCallable() {
    return updateOnlineEvaluatorCallable;
  }

  @Override
  public OperationCallable<
          UpdateOnlineEvaluatorRequest, OnlineEvaluator, UpdateOnlineEvaluatorOperationMetadata>
      updateOnlineEvaluatorOperationCallable() {
    return updateOnlineEvaluatorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOnlineEvaluatorRequest, Operation> deleteOnlineEvaluatorCallable() {
    return deleteOnlineEvaluatorCallable;
  }

  @Override
  public OperationCallable<
          DeleteOnlineEvaluatorRequest, Empty, DeleteOnlineEvaluatorOperationMetadata>
      deleteOnlineEvaluatorOperationCallable() {
    return deleteOnlineEvaluatorOperationCallable;
  }

  @Override
  public UnaryCallable<ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsResponse>
      listOnlineEvaluatorsCallable() {
    return listOnlineEvaluatorsCallable;
  }

  @Override
  public UnaryCallable<ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsPagedResponse>
      listOnlineEvaluatorsPagedCallable() {
    return listOnlineEvaluatorsPagedCallable;
  }

  @Override
  public UnaryCallable<ActivateOnlineEvaluatorRequest, Operation>
      activateOnlineEvaluatorCallable() {
    return activateOnlineEvaluatorCallable;
  }

  @Override
  public OperationCallable<
          ActivateOnlineEvaluatorRequest, OnlineEvaluator, ActivateOnlineEvaluatorOperationMetadata>
      activateOnlineEvaluatorOperationCallable() {
    return activateOnlineEvaluatorOperationCallable;
  }

  @Override
  public UnaryCallable<SuspendOnlineEvaluatorRequest, Operation> suspendOnlineEvaluatorCallable() {
    return suspendOnlineEvaluatorCallable;
  }

  @Override
  public OperationCallable<
          SuspendOnlineEvaluatorRequest, OnlineEvaluator, SuspendOnlineEvaluatorOperationMetadata>
      suspendOnlineEvaluatorOperationCallable() {
    return suspendOnlineEvaluatorOperationCallable;
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
