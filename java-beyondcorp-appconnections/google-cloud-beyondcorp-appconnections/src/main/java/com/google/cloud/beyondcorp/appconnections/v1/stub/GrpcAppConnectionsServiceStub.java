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

package com.google.cloud.beyondcorp.appconnections.v1.stub;

import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ListAppConnectionsPagedResponse;
import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ResolveAppConnectionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.beyondcorp.appconnections.v1.AppConnection;
import com.google.cloud.beyondcorp.appconnections.v1.AppConnectionOperationMetadata;
import com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest;
import com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest;
import com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest;
import com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest;
import com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse;
import com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest;
import com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse;
import com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest;
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
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AppConnectionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAppConnectionsServiceStub extends AppConnectionsServiceStub {
  private static final MethodDescriptor<ListAppConnectionsRequest, ListAppConnectionsResponse>
      listAppConnectionsMethodDescriptor =
          MethodDescriptor.<ListAppConnectionsRequest, ListAppConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnections.v1.AppConnectionsService/ListAppConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAppConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAppConnectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAppConnectionRequest, AppConnection>
      getAppConnectionMethodDescriptor =
          MethodDescriptor.<GetAppConnectionRequest, AppConnection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnections.v1.AppConnectionsService/GetAppConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAppConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AppConnection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAppConnectionRequest, Operation>
      createAppConnectionMethodDescriptor =
          MethodDescriptor.<CreateAppConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnections.v1.AppConnectionsService/CreateAppConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAppConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAppConnectionRequest, Operation>
      updateAppConnectionMethodDescriptor =
          MethodDescriptor.<UpdateAppConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnections.v1.AppConnectionsService/UpdateAppConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAppConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAppConnectionRequest, Operation>
      deleteAppConnectionMethodDescriptor =
          MethodDescriptor.<DeleteAppConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnections.v1.AppConnectionsService/DeleteAppConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAppConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResolveAppConnectionsRequest, ResolveAppConnectionsResponse>
      resolveAppConnectionsMethodDescriptor =
          MethodDescriptor.<ResolveAppConnectionsRequest, ResolveAppConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnections.v1.AppConnectionsService/ResolveAppConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResolveAppConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ResolveAppConnectionsResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListAppConnectionsRequest, ListAppConnectionsResponse>
      listAppConnectionsCallable;
  private final UnaryCallable<ListAppConnectionsRequest, ListAppConnectionsPagedResponse>
      listAppConnectionsPagedCallable;
  private final UnaryCallable<GetAppConnectionRequest, AppConnection> getAppConnectionCallable;
  private final UnaryCallable<CreateAppConnectionRequest, Operation> createAppConnectionCallable;
  private final OperationCallable<
          CreateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      createAppConnectionOperationCallable;
  private final UnaryCallable<UpdateAppConnectionRequest, Operation> updateAppConnectionCallable;
  private final OperationCallable<
          UpdateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      updateAppConnectionOperationCallable;
  private final UnaryCallable<DeleteAppConnectionRequest, Operation> deleteAppConnectionCallable;
  private final OperationCallable<DeleteAppConnectionRequest, Empty, AppConnectionOperationMetadata>
      deleteAppConnectionOperationCallable;
  private final UnaryCallable<ResolveAppConnectionsRequest, ResolveAppConnectionsResponse>
      resolveAppConnectionsCallable;
  private final UnaryCallable<ResolveAppConnectionsRequest, ResolveAppConnectionsPagedResponse>
      resolveAppConnectionsPagedCallable;
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

  public static final GrpcAppConnectionsServiceStub create(
      AppConnectionsServiceStubSettings settings) throws IOException {
    return new GrpcAppConnectionsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAppConnectionsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAppConnectionsServiceStub(
        AppConnectionsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAppConnectionsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAppConnectionsServiceStub(
        AppConnectionsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAppConnectionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAppConnectionsServiceStub(
      AppConnectionsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAppConnectionsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAppConnectionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAppConnectionsServiceStub(
      AppConnectionsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAppConnectionsRequest, ListAppConnectionsResponse>
        listAppConnectionsTransportSettings =
            GrpcCallSettings.<ListAppConnectionsRequest, ListAppConnectionsResponse>newBuilder()
                .setMethodDescriptor(listAppConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAppConnectionRequest, AppConnection> getAppConnectionTransportSettings =
        GrpcCallSettings.<GetAppConnectionRequest, AppConnection>newBuilder()
            .setMethodDescriptor(getAppConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateAppConnectionRequest, Operation> createAppConnectionTransportSettings =
        GrpcCallSettings.<CreateAppConnectionRequest, Operation>newBuilder()
            .setMethodDescriptor(createAppConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateAppConnectionRequest, Operation> updateAppConnectionTransportSettings =
        GrpcCallSettings.<UpdateAppConnectionRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAppConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "app_connection.name", String.valueOf(request.getAppConnection().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteAppConnectionRequest, Operation> deleteAppConnectionTransportSettings =
        GrpcCallSettings.<DeleteAppConnectionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAppConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ResolveAppConnectionsRequest, ResolveAppConnectionsResponse>
        resolveAppConnectionsTransportSettings =
            GrpcCallSettings
                .<ResolveAppConnectionsRequest, ResolveAppConnectionsResponse>newBuilder()
                .setMethodDescriptor(resolveAppConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
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

    this.listAppConnectionsCallable =
        callableFactory.createUnaryCallable(
            listAppConnectionsTransportSettings,
            settings.listAppConnectionsSettings(),
            clientContext);
    this.listAppConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listAppConnectionsTransportSettings,
            settings.listAppConnectionsSettings(),
            clientContext);
    this.getAppConnectionCallable =
        callableFactory.createUnaryCallable(
            getAppConnectionTransportSettings, settings.getAppConnectionSettings(), clientContext);
    this.createAppConnectionCallable =
        callableFactory.createUnaryCallable(
            createAppConnectionTransportSettings,
            settings.createAppConnectionSettings(),
            clientContext);
    this.createAppConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createAppConnectionTransportSettings,
            settings.createAppConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAppConnectionCallable =
        callableFactory.createUnaryCallable(
            updateAppConnectionTransportSettings,
            settings.updateAppConnectionSettings(),
            clientContext);
    this.updateAppConnectionOperationCallable =
        callableFactory.createOperationCallable(
            updateAppConnectionTransportSettings,
            settings.updateAppConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAppConnectionCallable =
        callableFactory.createUnaryCallable(
            deleteAppConnectionTransportSettings,
            settings.deleteAppConnectionSettings(),
            clientContext);
    this.deleteAppConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deleteAppConnectionTransportSettings,
            settings.deleteAppConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.resolveAppConnectionsCallable =
        callableFactory.createUnaryCallable(
            resolveAppConnectionsTransportSettings,
            settings.resolveAppConnectionsSettings(),
            clientContext);
    this.resolveAppConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            resolveAppConnectionsTransportSettings,
            settings.resolveAppConnectionsSettings(),
            clientContext);
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
  public UnaryCallable<ListAppConnectionsRequest, ListAppConnectionsResponse>
      listAppConnectionsCallable() {
    return listAppConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListAppConnectionsRequest, ListAppConnectionsPagedResponse>
      listAppConnectionsPagedCallable() {
    return listAppConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAppConnectionRequest, AppConnection> getAppConnectionCallable() {
    return getAppConnectionCallable;
  }

  @Override
  public UnaryCallable<CreateAppConnectionRequest, Operation> createAppConnectionCallable() {
    return createAppConnectionCallable;
  }

  @Override
  public OperationCallable<
          CreateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      createAppConnectionOperationCallable() {
    return createAppConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAppConnectionRequest, Operation> updateAppConnectionCallable() {
    return updateAppConnectionCallable;
  }

  @Override
  public OperationCallable<
          UpdateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      updateAppConnectionOperationCallable() {
    return updateAppConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAppConnectionRequest, Operation> deleteAppConnectionCallable() {
    return deleteAppConnectionCallable;
  }

  @Override
  public OperationCallable<DeleteAppConnectionRequest, Empty, AppConnectionOperationMetadata>
      deleteAppConnectionOperationCallable() {
    return deleteAppConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<ResolveAppConnectionsRequest, ResolveAppConnectionsResponse>
      resolveAppConnectionsCallable() {
    return resolveAppConnectionsCallable;
  }

  @Override
  public UnaryCallable<ResolveAppConnectionsRequest, ResolveAppConnectionsPagedResponse>
      resolveAppConnectionsPagedCallable() {
    return resolveAppConnectionsPagedCallable;
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
