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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.SpecialistPoolServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.SpecialistPoolServiceClient.ListSpecialistPoolsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateSpecialistPoolOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateSpecialistPoolRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteSpecialistPoolRequest;
import com.google.cloud.aiplatform.v1beta1.GetSpecialistPoolRequest;
import com.google.cloud.aiplatform.v1beta1.ListSpecialistPoolsRequest;
import com.google.cloud.aiplatform.v1beta1.ListSpecialistPoolsResponse;
import com.google.cloud.aiplatform.v1beta1.SpecialistPool;
import com.google.cloud.aiplatform.v1beta1.UpdateSpecialistPoolOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateSpecialistPoolRequest;
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
 * gRPC stub implementation for the SpecialistPoolService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSpecialistPoolServiceStub extends SpecialistPoolServiceStub {
  private static final MethodDescriptor<CreateSpecialistPoolRequest, Operation>
      createSpecialistPoolMethodDescriptor =
          MethodDescriptor.<CreateSpecialistPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.SpecialistPoolService/CreateSpecialistPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSpecialistPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSpecialistPoolRequest, SpecialistPool>
      getSpecialistPoolMethodDescriptor =
          MethodDescriptor.<GetSpecialistPoolRequest, SpecialistPool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.SpecialistPoolService/GetSpecialistPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSpecialistPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SpecialistPool.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse>
      listSpecialistPoolsMethodDescriptor =
          MethodDescriptor.<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.SpecialistPoolService/ListSpecialistPools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSpecialistPoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSpecialistPoolsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSpecialistPoolRequest, Operation>
      deleteSpecialistPoolMethodDescriptor =
          MethodDescriptor.<DeleteSpecialistPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.SpecialistPoolService/DeleteSpecialistPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSpecialistPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateSpecialistPoolRequest, Operation>
      updateSpecialistPoolMethodDescriptor =
          MethodDescriptor.<UpdateSpecialistPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.SpecialistPoolService/UpdateSpecialistPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSpecialistPoolRequest.getDefaultInstance()))
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

  private final UnaryCallable<CreateSpecialistPoolRequest, Operation> createSpecialistPoolCallable;
  private final OperationCallable<
          CreateSpecialistPoolRequest, SpecialistPool, CreateSpecialistPoolOperationMetadata>
      createSpecialistPoolOperationCallable;
  private final UnaryCallable<GetSpecialistPoolRequest, SpecialistPool> getSpecialistPoolCallable;
  private final UnaryCallable<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse>
      listSpecialistPoolsCallable;
  private final UnaryCallable<ListSpecialistPoolsRequest, ListSpecialistPoolsPagedResponse>
      listSpecialistPoolsPagedCallable;
  private final UnaryCallable<DeleteSpecialistPoolRequest, Operation> deleteSpecialistPoolCallable;
  private final OperationCallable<DeleteSpecialistPoolRequest, Empty, DeleteOperationMetadata>
      deleteSpecialistPoolOperationCallable;
  private final UnaryCallable<UpdateSpecialistPoolRequest, Operation> updateSpecialistPoolCallable;
  private final OperationCallable<
          UpdateSpecialistPoolRequest, SpecialistPool, UpdateSpecialistPoolOperationMetadata>
      updateSpecialistPoolOperationCallable;
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

  public static final GrpcSpecialistPoolServiceStub create(
      SpecialistPoolServiceStubSettings settings) throws IOException {
    return new GrpcSpecialistPoolServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSpecialistPoolServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSpecialistPoolServiceStub(
        SpecialistPoolServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSpecialistPoolServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSpecialistPoolServiceStub(
        SpecialistPoolServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSpecialistPoolServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSpecialistPoolServiceStub(
      SpecialistPoolServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSpecialistPoolServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSpecialistPoolServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSpecialistPoolServiceStub(
      SpecialistPoolServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSpecialistPoolRequest, Operation> createSpecialistPoolTransportSettings =
        GrpcCallSettings.<CreateSpecialistPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createSpecialistPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSpecialistPoolRequest, SpecialistPool> getSpecialistPoolTransportSettings =
        GrpcCallSettings.<GetSpecialistPoolRequest, SpecialistPool>newBuilder()
            .setMethodDescriptor(getSpecialistPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse>
        listSpecialistPoolsTransportSettings =
            GrpcCallSettings.<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse>newBuilder()
                .setMethodDescriptor(listSpecialistPoolsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSpecialistPoolRequest, Operation> deleteSpecialistPoolTransportSettings =
        GrpcCallSettings.<DeleteSpecialistPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSpecialistPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSpecialistPoolRequest, Operation> updateSpecialistPoolTransportSettings =
        GrpcCallSettings.<UpdateSpecialistPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSpecialistPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "specialist_pool.name",
                      String.valueOf(request.getSpecialistPool().getName()));
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

    this.createSpecialistPoolCallable =
        callableFactory.createUnaryCallable(
            createSpecialistPoolTransportSettings,
            settings.createSpecialistPoolSettings(),
            clientContext);
    this.createSpecialistPoolOperationCallable =
        callableFactory.createOperationCallable(
            createSpecialistPoolTransportSettings,
            settings.createSpecialistPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.getSpecialistPoolCallable =
        callableFactory.createUnaryCallable(
            getSpecialistPoolTransportSettings,
            settings.getSpecialistPoolSettings(),
            clientContext);
    this.listSpecialistPoolsCallable =
        callableFactory.createUnaryCallable(
            listSpecialistPoolsTransportSettings,
            settings.listSpecialistPoolsSettings(),
            clientContext);
    this.listSpecialistPoolsPagedCallable =
        callableFactory.createPagedCallable(
            listSpecialistPoolsTransportSettings,
            settings.listSpecialistPoolsSettings(),
            clientContext);
    this.deleteSpecialistPoolCallable =
        callableFactory.createUnaryCallable(
            deleteSpecialistPoolTransportSettings,
            settings.deleteSpecialistPoolSettings(),
            clientContext);
    this.deleteSpecialistPoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteSpecialistPoolTransportSettings,
            settings.deleteSpecialistPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.updateSpecialistPoolCallable =
        callableFactory.createUnaryCallable(
            updateSpecialistPoolTransportSettings,
            settings.updateSpecialistPoolSettings(),
            clientContext);
    this.updateSpecialistPoolOperationCallable =
        callableFactory.createOperationCallable(
            updateSpecialistPoolTransportSettings,
            settings.updateSpecialistPoolOperationSettings(),
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
  public UnaryCallable<CreateSpecialistPoolRequest, Operation> createSpecialistPoolCallable() {
    return createSpecialistPoolCallable;
  }

  @Override
  public OperationCallable<
          CreateSpecialistPoolRequest, SpecialistPool, CreateSpecialistPoolOperationMetadata>
      createSpecialistPoolOperationCallable() {
    return createSpecialistPoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetSpecialistPoolRequest, SpecialistPool> getSpecialistPoolCallable() {
    return getSpecialistPoolCallable;
  }

  @Override
  public UnaryCallable<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse>
      listSpecialistPoolsCallable() {
    return listSpecialistPoolsCallable;
  }

  @Override
  public UnaryCallable<ListSpecialistPoolsRequest, ListSpecialistPoolsPagedResponse>
      listSpecialistPoolsPagedCallable() {
    return listSpecialistPoolsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSpecialistPoolRequest, Operation> deleteSpecialistPoolCallable() {
    return deleteSpecialistPoolCallable;
  }

  @Override
  public OperationCallable<DeleteSpecialistPoolRequest, Empty, DeleteOperationMetadata>
      deleteSpecialistPoolOperationCallable() {
    return deleteSpecialistPoolOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSpecialistPoolRequest, Operation> updateSpecialistPoolCallable() {
    return updateSpecialistPoolCallable;
  }

  @Override
  public OperationCallable<
          UpdateSpecialistPoolRequest, SpecialistPool, UpdateSpecialistPoolOperationMetadata>
      updateSpecialistPoolOperationCallable() {
    return updateSpecialistPoolOperationCallable;
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
