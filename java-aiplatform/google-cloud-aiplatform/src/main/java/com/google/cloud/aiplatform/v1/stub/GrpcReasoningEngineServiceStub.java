/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.aiplatform.v1.ReasoningEngineServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.ReasoningEngineServiceClient.ListReasoningEnginesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CreateReasoningEngineOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateReasoningEngineRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.DeleteReasoningEngineRequest;
import com.google.cloud.aiplatform.v1.GetReasoningEngineRequest;
import com.google.cloud.aiplatform.v1.ListReasoningEnginesRequest;
import com.google.cloud.aiplatform.v1.ListReasoningEnginesResponse;
import com.google.cloud.aiplatform.v1.ReasoningEngine;
import com.google.cloud.aiplatform.v1.UpdateReasoningEngineOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateReasoningEngineRequest;
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
 * gRPC stub implementation for the ReasoningEngineService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcReasoningEngineServiceStub extends ReasoningEngineServiceStub {
  private static final MethodDescriptor<CreateReasoningEngineRequest, Operation>
      createReasoningEngineMethodDescriptor =
          MethodDescriptor.<CreateReasoningEngineRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.ReasoningEngineService/CreateReasoningEngine")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReasoningEngineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetReasoningEngineRequest, ReasoningEngine>
      getReasoningEngineMethodDescriptor =
          MethodDescriptor.<GetReasoningEngineRequest, ReasoningEngine>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.ReasoningEngineService/GetReasoningEngine")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReasoningEngineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReasoningEngine.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListReasoningEnginesRequest, ListReasoningEnginesResponse>
      listReasoningEnginesMethodDescriptor =
          MethodDescriptor.<ListReasoningEnginesRequest, ListReasoningEnginesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.ReasoningEngineService/ListReasoningEngines")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReasoningEnginesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReasoningEnginesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateReasoningEngineRequest, Operation>
      updateReasoningEngineMethodDescriptor =
          MethodDescriptor.<UpdateReasoningEngineRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.ReasoningEngineService/UpdateReasoningEngine")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateReasoningEngineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteReasoningEngineRequest, Operation>
      deleteReasoningEngineMethodDescriptor =
          MethodDescriptor.<DeleteReasoningEngineRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.ReasoningEngineService/DeleteReasoningEngine")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteReasoningEngineRequest.getDefaultInstance()))
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

  private final UnaryCallable<CreateReasoningEngineRequest, Operation>
      createReasoningEngineCallable;
  private final OperationCallable<
          CreateReasoningEngineRequest, ReasoningEngine, CreateReasoningEngineOperationMetadata>
      createReasoningEngineOperationCallable;
  private final UnaryCallable<GetReasoningEngineRequest, ReasoningEngine>
      getReasoningEngineCallable;
  private final UnaryCallable<ListReasoningEnginesRequest, ListReasoningEnginesResponse>
      listReasoningEnginesCallable;
  private final UnaryCallable<ListReasoningEnginesRequest, ListReasoningEnginesPagedResponse>
      listReasoningEnginesPagedCallable;
  private final UnaryCallable<UpdateReasoningEngineRequest, Operation>
      updateReasoningEngineCallable;
  private final OperationCallable<
          UpdateReasoningEngineRequest, ReasoningEngine, UpdateReasoningEngineOperationMetadata>
      updateReasoningEngineOperationCallable;
  private final UnaryCallable<DeleteReasoningEngineRequest, Operation>
      deleteReasoningEngineCallable;
  private final OperationCallable<DeleteReasoningEngineRequest, Empty, DeleteOperationMetadata>
      deleteReasoningEngineOperationCallable;
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

  public static final GrpcReasoningEngineServiceStub create(
      ReasoningEngineServiceStubSettings settings) throws IOException {
    return new GrpcReasoningEngineServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcReasoningEngineServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcReasoningEngineServiceStub(
        ReasoningEngineServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcReasoningEngineServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcReasoningEngineServiceStub(
        ReasoningEngineServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcReasoningEngineServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcReasoningEngineServiceStub(
      ReasoningEngineServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcReasoningEngineServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcReasoningEngineServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcReasoningEngineServiceStub(
      ReasoningEngineServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateReasoningEngineRequest, Operation>
        createReasoningEngineTransportSettings =
            GrpcCallSettings.<CreateReasoningEngineRequest, Operation>newBuilder()
                .setMethodDescriptor(createReasoningEngineMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetReasoningEngineRequest, ReasoningEngine>
        getReasoningEngineTransportSettings =
            GrpcCallSettings.<GetReasoningEngineRequest, ReasoningEngine>newBuilder()
                .setMethodDescriptor(getReasoningEngineMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListReasoningEnginesRequest, ListReasoningEnginesResponse>
        listReasoningEnginesTransportSettings =
            GrpcCallSettings.<ListReasoningEnginesRequest, ListReasoningEnginesResponse>newBuilder()
                .setMethodDescriptor(listReasoningEnginesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateReasoningEngineRequest, Operation>
        updateReasoningEngineTransportSettings =
            GrpcCallSettings.<UpdateReasoningEngineRequest, Operation>newBuilder()
                .setMethodDescriptor(updateReasoningEngineMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "reasoning_engine.name",
                          String.valueOf(request.getReasoningEngine().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteReasoningEngineRequest, Operation>
        deleteReasoningEngineTransportSettings =
            GrpcCallSettings.<DeleteReasoningEngineRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteReasoningEngineMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
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

    this.createReasoningEngineCallable =
        callableFactory.createUnaryCallable(
            createReasoningEngineTransportSettings,
            settings.createReasoningEngineSettings(),
            clientContext);
    this.createReasoningEngineOperationCallable =
        callableFactory.createOperationCallable(
            createReasoningEngineTransportSettings,
            settings.createReasoningEngineOperationSettings(),
            clientContext,
            operationsStub);
    this.getReasoningEngineCallable =
        callableFactory.createUnaryCallable(
            getReasoningEngineTransportSettings,
            settings.getReasoningEngineSettings(),
            clientContext);
    this.listReasoningEnginesCallable =
        callableFactory.createUnaryCallable(
            listReasoningEnginesTransportSettings,
            settings.listReasoningEnginesSettings(),
            clientContext);
    this.listReasoningEnginesPagedCallable =
        callableFactory.createPagedCallable(
            listReasoningEnginesTransportSettings,
            settings.listReasoningEnginesSettings(),
            clientContext);
    this.updateReasoningEngineCallable =
        callableFactory.createUnaryCallable(
            updateReasoningEngineTransportSettings,
            settings.updateReasoningEngineSettings(),
            clientContext);
    this.updateReasoningEngineOperationCallable =
        callableFactory.createOperationCallable(
            updateReasoningEngineTransportSettings,
            settings.updateReasoningEngineOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteReasoningEngineCallable =
        callableFactory.createUnaryCallable(
            deleteReasoningEngineTransportSettings,
            settings.deleteReasoningEngineSettings(),
            clientContext);
    this.deleteReasoningEngineOperationCallable =
        callableFactory.createOperationCallable(
            deleteReasoningEngineTransportSettings,
            settings.deleteReasoningEngineOperationSettings(),
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
  public UnaryCallable<CreateReasoningEngineRequest, Operation> createReasoningEngineCallable() {
    return createReasoningEngineCallable;
  }

  @Override
  public OperationCallable<
          CreateReasoningEngineRequest, ReasoningEngine, CreateReasoningEngineOperationMetadata>
      createReasoningEngineOperationCallable() {
    return createReasoningEngineOperationCallable;
  }

  @Override
  public UnaryCallable<GetReasoningEngineRequest, ReasoningEngine> getReasoningEngineCallable() {
    return getReasoningEngineCallable;
  }

  @Override
  public UnaryCallable<ListReasoningEnginesRequest, ListReasoningEnginesResponse>
      listReasoningEnginesCallable() {
    return listReasoningEnginesCallable;
  }

  @Override
  public UnaryCallable<ListReasoningEnginesRequest, ListReasoningEnginesPagedResponse>
      listReasoningEnginesPagedCallable() {
    return listReasoningEnginesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateReasoningEngineRequest, Operation> updateReasoningEngineCallable() {
    return updateReasoningEngineCallable;
  }

  @Override
  public OperationCallable<
          UpdateReasoningEngineRequest, ReasoningEngine, UpdateReasoningEngineOperationMetadata>
      updateReasoningEngineOperationCallable() {
    return updateReasoningEngineOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteReasoningEngineRequest, Operation> deleteReasoningEngineCallable() {
    return deleteReasoningEngineCallable;
  }

  @Override
  public OperationCallable<DeleteReasoningEngineRequest, Empty, DeleteOperationMetadata>
      deleteReasoningEngineOperationCallable() {
    return deleteReasoningEngineOperationCallable;
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
