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

package com.google.cloud.networkconnectivity.v1beta.stub;

import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListRemoteTransportProfilesPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListTransportsPagedResponse;

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
import com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest;
import com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest;
import com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest;
import com.google.cloud.networkconnectivity.v1beta.GetStatusRequest;
import com.google.cloud.networkconnectivity.v1beta.GetStatusResponse;
import com.google.cloud.networkconnectivity.v1beta.GetTransportRequest;
import com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest;
import com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse;
import com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest;
import com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse;
import com.google.cloud.networkconnectivity.v1beta.OperationMetadata;
import com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile;
import com.google.cloud.networkconnectivity.v1beta.Transport;
import com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest;
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
 * gRPC stub implementation for the TransportManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcTransportManagerStub extends TransportManagerStub {
  private static final MethodDescriptor<
          ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesResponse>
      listRemoteTransportProfilesMethodDescriptor =
          MethodDescriptor
              .<ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.TransportManager/ListRemoteTransportProfiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRemoteTransportProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRemoteTransportProfilesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetRemoteTransportProfileRequest, RemoteTransportProfile>
      getRemoteTransportProfileMethodDescriptor =
          MethodDescriptor.<GetRemoteTransportProfileRequest, RemoteTransportProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.TransportManager/GetRemoteTransportProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRemoteTransportProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RemoteTransportProfile.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListTransportsRequest, ListTransportsResponse>
      listTransportsMethodDescriptor =
          MethodDescriptor.<ListTransportsRequest, ListTransportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.TransportManager/ListTransports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTransportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTransportsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetTransportRequest, Transport>
      getTransportMethodDescriptor =
          MethodDescriptor.<GetTransportRequest, Transport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.TransportManager/GetTransport")
              .setRequestMarshaller(ProtoUtils.marshaller(GetTransportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Transport.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetStatusRequest, GetStatusResponse>
      getStatusMethodDescriptor =
          MethodDescriptor.<GetStatusRequest, GetStatusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.TransportManager/GetStatus")
              .setRequestMarshaller(ProtoUtils.marshaller(GetStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GetStatusResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateTransportRequest, Operation>
      createTransportMethodDescriptor =
          MethodDescriptor.<CreateTransportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.TransportManager/CreateTransport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTransportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateTransportRequest, Operation>
      updateTransportMethodDescriptor =
          MethodDescriptor.<UpdateTransportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.TransportManager/UpdateTransport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTransportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteTransportRequest, Operation>
      deleteTransportMethodDescriptor =
          MethodDescriptor.<DeleteTransportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.TransportManager/DeleteTransport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTransportRequest.getDefaultInstance()))
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

  private final UnaryCallable<
          ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesResponse>
      listRemoteTransportProfilesCallable;
  private final UnaryCallable<
          ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesPagedResponse>
      listRemoteTransportProfilesPagedCallable;
  private final UnaryCallable<GetRemoteTransportProfileRequest, RemoteTransportProfile>
      getRemoteTransportProfileCallable;
  private final UnaryCallable<ListTransportsRequest, ListTransportsResponse> listTransportsCallable;
  private final UnaryCallable<ListTransportsRequest, ListTransportsPagedResponse>
      listTransportsPagedCallable;
  private final UnaryCallable<GetTransportRequest, Transport> getTransportCallable;
  private final UnaryCallable<GetStatusRequest, GetStatusResponse> getStatusCallable;
  private final UnaryCallable<CreateTransportRequest, Operation> createTransportCallable;
  private final OperationCallable<CreateTransportRequest, Transport, OperationMetadata>
      createTransportOperationCallable;
  private final UnaryCallable<UpdateTransportRequest, Operation> updateTransportCallable;
  private final OperationCallable<UpdateTransportRequest, Transport, OperationMetadata>
      updateTransportOperationCallable;
  private final UnaryCallable<DeleteTransportRequest, Operation> deleteTransportCallable;
  private final OperationCallable<DeleteTransportRequest, Empty, OperationMetadata>
      deleteTransportOperationCallable;
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

  public static final GrpcTransportManagerStub create(TransportManagerStubSettings settings)
      throws IOException {
    return new GrpcTransportManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTransportManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcTransportManagerStub(
        TransportManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTransportManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTransportManagerStub(
        TransportManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTransportManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTransportManagerStub(
      TransportManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcTransportManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTransportManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTransportManagerStub(
      TransportManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesResponse>
        listRemoteTransportProfilesTransportSettings =
            GrpcCallSettings
                .<ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesResponse>
                    newBuilder()
                .setMethodDescriptor(listRemoteTransportProfilesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetRemoteTransportProfileRequest, RemoteTransportProfile>
        getRemoteTransportProfileTransportSettings =
            GrpcCallSettings.<GetRemoteTransportProfileRequest, RemoteTransportProfile>newBuilder()
                .setMethodDescriptor(getRemoteTransportProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListTransportsRequest, ListTransportsResponse>
        listTransportsTransportSettings =
            GrpcCallSettings.<ListTransportsRequest, ListTransportsResponse>newBuilder()
                .setMethodDescriptor(listTransportsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetTransportRequest, Transport> getTransportTransportSettings =
        GrpcCallSettings.<GetTransportRequest, Transport>newBuilder()
            .setMethodDescriptor(getTransportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetStatusRequest, GetStatusResponse> getStatusTransportSettings =
        GrpcCallSettings.<GetStatusRequest, GetStatusResponse>newBuilder()
            .setMethodDescriptor(getStatusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateTransportRequest, Operation> createTransportTransportSettings =
        GrpcCallSettings.<CreateTransportRequest, Operation>newBuilder()
            .setMethodDescriptor(createTransportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateTransportRequest, Operation> updateTransportTransportSettings =
        GrpcCallSettings.<UpdateTransportRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTransportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("transport.name", String.valueOf(request.getTransport().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTransportRequest, Operation> deleteTransportTransportSettings =
        GrpcCallSettings.<DeleteTransportRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTransportMethodDescriptor)
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

    this.listRemoteTransportProfilesCallable =
        callableFactory.createUnaryCallable(
            listRemoteTransportProfilesTransportSettings,
            settings.listRemoteTransportProfilesSettings(),
            clientContext);
    this.listRemoteTransportProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listRemoteTransportProfilesTransportSettings,
            settings.listRemoteTransportProfilesSettings(),
            clientContext);
    this.getRemoteTransportProfileCallable =
        callableFactory.createUnaryCallable(
            getRemoteTransportProfileTransportSettings,
            settings.getRemoteTransportProfileSettings(),
            clientContext);
    this.listTransportsCallable =
        callableFactory.createUnaryCallable(
            listTransportsTransportSettings, settings.listTransportsSettings(), clientContext);
    this.listTransportsPagedCallable =
        callableFactory.createPagedCallable(
            listTransportsTransportSettings, settings.listTransportsSettings(), clientContext);
    this.getTransportCallable =
        callableFactory.createUnaryCallable(
            getTransportTransportSettings, settings.getTransportSettings(), clientContext);
    this.getStatusCallable =
        callableFactory.createUnaryCallable(
            getStatusTransportSettings, settings.getStatusSettings(), clientContext);
    this.createTransportCallable =
        callableFactory.createUnaryCallable(
            createTransportTransportSettings, settings.createTransportSettings(), clientContext);
    this.createTransportOperationCallable =
        callableFactory.createOperationCallable(
            createTransportTransportSettings,
            settings.createTransportOperationSettings(),
            clientContext,
            operationsStub);
    this.updateTransportCallable =
        callableFactory.createUnaryCallable(
            updateTransportTransportSettings, settings.updateTransportSettings(), clientContext);
    this.updateTransportOperationCallable =
        callableFactory.createOperationCallable(
            updateTransportTransportSettings,
            settings.updateTransportOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTransportCallable =
        callableFactory.createUnaryCallable(
            deleteTransportTransportSettings, settings.deleteTransportSettings(), clientContext);
    this.deleteTransportOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportTransportSettings,
            settings.deleteTransportOperationSettings(),
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
  public UnaryCallable<ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesResponse>
      listRemoteTransportProfilesCallable() {
    return listRemoteTransportProfilesCallable;
  }

  @Override
  public UnaryCallable<ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesPagedResponse>
      listRemoteTransportProfilesPagedCallable() {
    return listRemoteTransportProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<GetRemoteTransportProfileRequest, RemoteTransportProfile>
      getRemoteTransportProfileCallable() {
    return getRemoteTransportProfileCallable;
  }

  @Override
  public UnaryCallable<ListTransportsRequest, ListTransportsResponse> listTransportsCallable() {
    return listTransportsCallable;
  }

  @Override
  public UnaryCallable<ListTransportsRequest, ListTransportsPagedResponse>
      listTransportsPagedCallable() {
    return listTransportsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTransportRequest, Transport> getTransportCallable() {
    return getTransportCallable;
  }

  @Override
  public UnaryCallable<GetStatusRequest, GetStatusResponse> getStatusCallable() {
    return getStatusCallable;
  }

  @Override
  public UnaryCallable<CreateTransportRequest, Operation> createTransportCallable() {
    return createTransportCallable;
  }

  @Override
  public OperationCallable<CreateTransportRequest, Transport, OperationMetadata>
      createTransportOperationCallable() {
    return createTransportOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTransportRequest, Operation> updateTransportCallable() {
    return updateTransportCallable;
  }

  @Override
  public OperationCallable<UpdateTransportRequest, Transport, OperationMetadata>
      updateTransportOperationCallable() {
    return updateTransportOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTransportRequest, Operation> deleteTransportCallable() {
    return deleteTransportCallable;
  }

  @Override
  public OperationCallable<DeleteTransportRequest, Empty, OperationMetadata>
      deleteTransportOperationCallable() {
    return deleteTransportOperationCallable;
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
