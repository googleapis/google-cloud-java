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

package com.google.cloud.networkconnectivity.v1.stub;

import static com.google.cloud.networkconnectivity.v1.InternalRangeServiceClient.ListInternalRangesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.InternalRangeServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest;
import com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest;
import com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest;
import com.google.cloud.networkconnectivity.v1.InternalRange;
import com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest;
import com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest;
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
 * gRPC stub implementation for the InternalRangeService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcInternalRangeServiceStub extends InternalRangeServiceStub {
  private static final MethodDescriptor<ListInternalRangesRequest, ListInternalRangesResponse>
      listInternalRangesMethodDescriptor =
          MethodDescriptor.<ListInternalRangesRequest, ListInternalRangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.InternalRangeService/ListInternalRanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInternalRangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInternalRangesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInternalRangeRequest, InternalRange>
      getInternalRangeMethodDescriptor =
          MethodDescriptor.<GetInternalRangeRequest, InternalRange>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.InternalRangeService/GetInternalRange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInternalRangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(InternalRange.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateInternalRangeRequest, Operation>
      createInternalRangeMethodDescriptor =
          MethodDescriptor.<CreateInternalRangeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.InternalRangeService/CreateInternalRange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInternalRangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateInternalRangeRequest, Operation>
      updateInternalRangeMethodDescriptor =
          MethodDescriptor.<UpdateInternalRangeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.InternalRangeService/UpdateInternalRange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInternalRangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteInternalRangeRequest, Operation>
      deleteInternalRangeMethodDescriptor =
          MethodDescriptor.<DeleteInternalRangeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.InternalRangeService/DeleteInternalRange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInternalRangeRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListInternalRangesRequest, ListInternalRangesResponse>
      listInternalRangesCallable;
  private final UnaryCallable<ListInternalRangesRequest, ListInternalRangesPagedResponse>
      listInternalRangesPagedCallable;
  private final UnaryCallable<GetInternalRangeRequest, InternalRange> getInternalRangeCallable;
  private final UnaryCallable<CreateInternalRangeRequest, Operation> createInternalRangeCallable;
  private final OperationCallable<CreateInternalRangeRequest, InternalRange, OperationMetadata>
      createInternalRangeOperationCallable;
  private final UnaryCallable<UpdateInternalRangeRequest, Operation> updateInternalRangeCallable;
  private final OperationCallable<UpdateInternalRangeRequest, InternalRange, OperationMetadata>
      updateInternalRangeOperationCallable;
  private final UnaryCallable<DeleteInternalRangeRequest, Operation> deleteInternalRangeCallable;
  private final OperationCallable<DeleteInternalRangeRequest, Empty, OperationMetadata>
      deleteInternalRangeOperationCallable;
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

  public static final GrpcInternalRangeServiceStub create(InternalRangeServiceStubSettings settings)
      throws IOException {
    return new GrpcInternalRangeServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcInternalRangeServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcInternalRangeServiceStub(
        InternalRangeServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcInternalRangeServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcInternalRangeServiceStub(
        InternalRangeServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcInternalRangeServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcInternalRangeServiceStub(
      InternalRangeServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcInternalRangeServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcInternalRangeServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcInternalRangeServiceStub(
      InternalRangeServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInternalRangesRequest, ListInternalRangesResponse>
        listInternalRangesTransportSettings =
            GrpcCallSettings.<ListInternalRangesRequest, ListInternalRangesResponse>newBuilder()
                .setMethodDescriptor(listInternalRangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetInternalRangeRequest, InternalRange> getInternalRangeTransportSettings =
        GrpcCallSettings.<GetInternalRangeRequest, InternalRange>newBuilder()
            .setMethodDescriptor(getInternalRangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateInternalRangeRequest, Operation> createInternalRangeTransportSettings =
        GrpcCallSettings.<CreateInternalRangeRequest, Operation>newBuilder()
            .setMethodDescriptor(createInternalRangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateInternalRangeRequest, Operation> updateInternalRangeTransportSettings =
        GrpcCallSettings.<UpdateInternalRangeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInternalRangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "internal_range.name", String.valueOf(request.getInternalRange().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteInternalRangeRequest, Operation> deleteInternalRangeTransportSettings =
        GrpcCallSettings.<DeleteInternalRangeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInternalRangeMethodDescriptor)
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

    this.listInternalRangesCallable =
        callableFactory.createUnaryCallable(
            listInternalRangesTransportSettings,
            settings.listInternalRangesSettings(),
            clientContext);
    this.listInternalRangesPagedCallable =
        callableFactory.createPagedCallable(
            listInternalRangesTransportSettings,
            settings.listInternalRangesSettings(),
            clientContext);
    this.getInternalRangeCallable =
        callableFactory.createUnaryCallable(
            getInternalRangeTransportSettings, settings.getInternalRangeSettings(), clientContext);
    this.createInternalRangeCallable =
        callableFactory.createUnaryCallable(
            createInternalRangeTransportSettings,
            settings.createInternalRangeSettings(),
            clientContext);
    this.createInternalRangeOperationCallable =
        callableFactory.createOperationCallable(
            createInternalRangeTransportSettings,
            settings.createInternalRangeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInternalRangeCallable =
        callableFactory.createUnaryCallable(
            updateInternalRangeTransportSettings,
            settings.updateInternalRangeSettings(),
            clientContext);
    this.updateInternalRangeOperationCallable =
        callableFactory.createOperationCallable(
            updateInternalRangeTransportSettings,
            settings.updateInternalRangeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInternalRangeCallable =
        callableFactory.createUnaryCallable(
            deleteInternalRangeTransportSettings,
            settings.deleteInternalRangeSettings(),
            clientContext);
    this.deleteInternalRangeOperationCallable =
        callableFactory.createOperationCallable(
            deleteInternalRangeTransportSettings,
            settings.deleteInternalRangeOperationSettings(),
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
  public UnaryCallable<ListInternalRangesRequest, ListInternalRangesResponse>
      listInternalRangesCallable() {
    return listInternalRangesCallable;
  }

  @Override
  public UnaryCallable<ListInternalRangesRequest, ListInternalRangesPagedResponse>
      listInternalRangesPagedCallable() {
    return listInternalRangesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInternalRangeRequest, InternalRange> getInternalRangeCallable() {
    return getInternalRangeCallable;
  }

  @Override
  public UnaryCallable<CreateInternalRangeRequest, Operation> createInternalRangeCallable() {
    return createInternalRangeCallable;
  }

  @Override
  public OperationCallable<CreateInternalRangeRequest, InternalRange, OperationMetadata>
      createInternalRangeOperationCallable() {
    return createInternalRangeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInternalRangeRequest, Operation> updateInternalRangeCallable() {
    return updateInternalRangeCallable;
  }

  @Override
  public OperationCallable<UpdateInternalRangeRequest, InternalRange, OperationMetadata>
      updateInternalRangeOperationCallable() {
    return updateInternalRangeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInternalRangeRequest, Operation> deleteInternalRangeCallable() {
    return deleteInternalRangeCallable;
  }

  @Override
  public OperationCallable<DeleteInternalRangeRequest, Empty, OperationMetadata>
      deleteInternalRangeOperationCallable() {
    return deleteInternalRangeOperationCallable;
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
