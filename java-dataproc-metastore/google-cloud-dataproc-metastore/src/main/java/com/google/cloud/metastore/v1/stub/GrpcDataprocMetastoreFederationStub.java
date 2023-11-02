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

package com.google.cloud.metastore.v1.stub;

import static com.google.cloud.metastore.v1.DataprocMetastoreFederationClient.ListFederationsPagedResponse;
import static com.google.cloud.metastore.v1.DataprocMetastoreFederationClient.ListLocationsPagedResponse;

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
import com.google.cloud.metastore.v1.CreateFederationRequest;
import com.google.cloud.metastore.v1.DeleteFederationRequest;
import com.google.cloud.metastore.v1.Federation;
import com.google.cloud.metastore.v1.GetFederationRequest;
import com.google.cloud.metastore.v1.ListFederationsRequest;
import com.google.cloud.metastore.v1.ListFederationsResponse;
import com.google.cloud.metastore.v1.OperationMetadata;
import com.google.cloud.metastore.v1.UpdateFederationRequest;
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
 * gRPC stub implementation for the DataprocMetastoreFederation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataprocMetastoreFederationStub extends DataprocMetastoreFederationStub {
  private static final MethodDescriptor<ListFederationsRequest, ListFederationsResponse>
      listFederationsMethodDescriptor =
          MethodDescriptor.<ListFederationsRequest, ListFederationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1.DataprocMetastoreFederation/ListFederations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFederationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFederationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFederationRequest, Federation>
      getFederationMethodDescriptor =
          MethodDescriptor.<GetFederationRequest, Federation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1.DataprocMetastoreFederation/GetFederation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFederationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Federation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFederationRequest, Operation>
      createFederationMethodDescriptor =
          MethodDescriptor.<CreateFederationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1.DataprocMetastoreFederation/CreateFederation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFederationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFederationRequest, Operation>
      updateFederationMethodDescriptor =
          MethodDescriptor.<UpdateFederationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1.DataprocMetastoreFederation/UpdateFederation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFederationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFederationRequest, Operation>
      deleteFederationMethodDescriptor =
          MethodDescriptor.<DeleteFederationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1.DataprocMetastoreFederation/DeleteFederation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFederationRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListFederationsRequest, ListFederationsResponse>
      listFederationsCallable;
  private final UnaryCallable<ListFederationsRequest, ListFederationsPagedResponse>
      listFederationsPagedCallable;
  private final UnaryCallable<GetFederationRequest, Federation> getFederationCallable;
  private final UnaryCallable<CreateFederationRequest, Operation> createFederationCallable;
  private final OperationCallable<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationCallable;
  private final UnaryCallable<UpdateFederationRequest, Operation> updateFederationCallable;
  private final OperationCallable<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationCallable;
  private final UnaryCallable<DeleteFederationRequest, Operation> deleteFederationCallable;
  private final OperationCallable<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationCallable;
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

  public static final GrpcDataprocMetastoreFederationStub create(
      DataprocMetastoreFederationStubSettings settings) throws IOException {
    return new GrpcDataprocMetastoreFederationStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataprocMetastoreFederationStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataprocMetastoreFederationStub(
        DataprocMetastoreFederationStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataprocMetastoreFederationStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataprocMetastoreFederationStub(
        DataprocMetastoreFederationStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataprocMetastoreFederationStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataprocMetastoreFederationStub(
      DataprocMetastoreFederationStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDataprocMetastoreFederationCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataprocMetastoreFederationStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataprocMetastoreFederationStub(
      DataprocMetastoreFederationStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListFederationsRequest, ListFederationsResponse>
        listFederationsTransportSettings =
            GrpcCallSettings.<ListFederationsRequest, ListFederationsResponse>newBuilder()
                .setMethodDescriptor(listFederationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetFederationRequest, Federation> getFederationTransportSettings =
        GrpcCallSettings.<GetFederationRequest, Federation>newBuilder()
            .setMethodDescriptor(getFederationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateFederationRequest, Operation> createFederationTransportSettings =
        GrpcCallSettings.<CreateFederationRequest, Operation>newBuilder()
            .setMethodDescriptor(createFederationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateFederationRequest, Operation> updateFederationTransportSettings =
        GrpcCallSettings.<UpdateFederationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFederationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("federation.name", String.valueOf(request.getFederation().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteFederationRequest, Operation> deleteFederationTransportSettings =
        GrpcCallSettings.<DeleteFederationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFederationMethodDescriptor)
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

    this.listFederationsCallable =
        callableFactory.createUnaryCallable(
            listFederationsTransportSettings, settings.listFederationsSettings(), clientContext);
    this.listFederationsPagedCallable =
        callableFactory.createPagedCallable(
            listFederationsTransportSettings, settings.listFederationsSettings(), clientContext);
    this.getFederationCallable =
        callableFactory.createUnaryCallable(
            getFederationTransportSettings, settings.getFederationSettings(), clientContext);
    this.createFederationCallable =
        callableFactory.createUnaryCallable(
            createFederationTransportSettings, settings.createFederationSettings(), clientContext);
    this.createFederationOperationCallable =
        callableFactory.createOperationCallable(
            createFederationTransportSettings,
            settings.createFederationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateFederationCallable =
        callableFactory.createUnaryCallable(
            updateFederationTransportSettings, settings.updateFederationSettings(), clientContext);
    this.updateFederationOperationCallable =
        callableFactory.createOperationCallable(
            updateFederationTransportSettings,
            settings.updateFederationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFederationCallable =
        callableFactory.createUnaryCallable(
            deleteFederationTransportSettings, settings.deleteFederationSettings(), clientContext);
    this.deleteFederationOperationCallable =
        callableFactory.createOperationCallable(
            deleteFederationTransportSettings,
            settings.deleteFederationOperationSettings(),
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
  public UnaryCallable<ListFederationsRequest, ListFederationsResponse> listFederationsCallable() {
    return listFederationsCallable;
  }

  @Override
  public UnaryCallable<ListFederationsRequest, ListFederationsPagedResponse>
      listFederationsPagedCallable() {
    return listFederationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFederationRequest, Federation> getFederationCallable() {
    return getFederationCallable;
  }

  @Override
  public UnaryCallable<CreateFederationRequest, Operation> createFederationCallable() {
    return createFederationCallable;
  }

  @Override
  public OperationCallable<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationCallable() {
    return createFederationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFederationRequest, Operation> updateFederationCallable() {
    return updateFederationCallable;
  }

  @Override
  public OperationCallable<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationCallable() {
    return updateFederationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFederationRequest, Operation> deleteFederationCallable() {
    return deleteFederationCallable;
  }

  @Override
  public OperationCallable<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationCallable() {
    return deleteFederationOperationCallable;
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
