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

package com.google.cloud.beyondcorp.appgateways.v1.stub;

import static com.google.cloud.beyondcorp.appgateways.v1.AppGatewaysServiceClient.ListAppGatewaysPagedResponse;
import static com.google.cloud.beyondcorp.appgateways.v1.AppGatewaysServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.beyondcorp.appgateways.v1.AppGateway;
import com.google.cloud.beyondcorp.appgateways.v1.AppGatewayOperationMetadata;
import com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest;
import com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest;
import com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest;
import com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest;
import com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse;
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
 * gRPC stub implementation for the AppGatewaysService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAppGatewaysServiceStub extends AppGatewaysServiceStub {
  private static final MethodDescriptor<ListAppGatewaysRequest, ListAppGatewaysResponse>
      listAppGatewaysMethodDescriptor =
          MethodDescriptor.<ListAppGatewaysRequest, ListAppGatewaysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appgateways.v1.AppGatewaysService/ListAppGateways")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAppGatewaysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAppGatewaysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAppGatewayRequest, AppGateway>
      getAppGatewayMethodDescriptor =
          MethodDescriptor.<GetAppGatewayRequest, AppGateway>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appgateways.v1.AppGatewaysService/GetAppGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAppGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AppGateway.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAppGatewayRequest, Operation>
      createAppGatewayMethodDescriptor =
          MethodDescriptor.<CreateAppGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appgateways.v1.AppGatewaysService/CreateAppGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAppGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAppGatewayRequest, Operation>
      deleteAppGatewayMethodDescriptor =
          MethodDescriptor.<DeleteAppGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appgateways.v1.AppGatewaysService/DeleteAppGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAppGatewayRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListAppGatewaysRequest, ListAppGatewaysResponse>
      listAppGatewaysCallable;
  private final UnaryCallable<ListAppGatewaysRequest, ListAppGatewaysPagedResponse>
      listAppGatewaysPagedCallable;
  private final UnaryCallable<GetAppGatewayRequest, AppGateway> getAppGatewayCallable;
  private final UnaryCallable<CreateAppGatewayRequest, Operation> createAppGatewayCallable;
  private final OperationCallable<CreateAppGatewayRequest, AppGateway, AppGatewayOperationMetadata>
      createAppGatewayOperationCallable;
  private final UnaryCallable<DeleteAppGatewayRequest, Operation> deleteAppGatewayCallable;
  private final OperationCallable<DeleteAppGatewayRequest, Empty, AppGatewayOperationMetadata>
      deleteAppGatewayOperationCallable;
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

  public static final GrpcAppGatewaysServiceStub create(AppGatewaysServiceStubSettings settings)
      throws IOException {
    return new GrpcAppGatewaysServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAppGatewaysServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAppGatewaysServiceStub(
        AppGatewaysServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAppGatewaysServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAppGatewaysServiceStub(
        AppGatewaysServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAppGatewaysServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAppGatewaysServiceStub(
      AppGatewaysServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAppGatewaysServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAppGatewaysServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAppGatewaysServiceStub(
      AppGatewaysServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAppGatewaysRequest, ListAppGatewaysResponse>
        listAppGatewaysTransportSettings =
            GrpcCallSettings.<ListAppGatewaysRequest, ListAppGatewaysResponse>newBuilder()
                .setMethodDescriptor(listAppGatewaysMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAppGatewayRequest, AppGateway> getAppGatewayTransportSettings =
        GrpcCallSettings.<GetAppGatewayRequest, AppGateway>newBuilder()
            .setMethodDescriptor(getAppGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateAppGatewayRequest, Operation> createAppGatewayTransportSettings =
        GrpcCallSettings.<CreateAppGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(createAppGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteAppGatewayRequest, Operation> deleteAppGatewayTransportSettings =
        GrpcCallSettings.<DeleteAppGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAppGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
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

    this.listAppGatewaysCallable =
        callableFactory.createUnaryCallable(
            listAppGatewaysTransportSettings, settings.listAppGatewaysSettings(), clientContext);
    this.listAppGatewaysPagedCallable =
        callableFactory.createPagedCallable(
            listAppGatewaysTransportSettings, settings.listAppGatewaysSettings(), clientContext);
    this.getAppGatewayCallable =
        callableFactory.createUnaryCallable(
            getAppGatewayTransportSettings, settings.getAppGatewaySettings(), clientContext);
    this.createAppGatewayCallable =
        callableFactory.createUnaryCallable(
            createAppGatewayTransportSettings, settings.createAppGatewaySettings(), clientContext);
    this.createAppGatewayOperationCallable =
        callableFactory.createOperationCallable(
            createAppGatewayTransportSettings,
            settings.createAppGatewayOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAppGatewayCallable =
        callableFactory.createUnaryCallable(
            deleteAppGatewayTransportSettings, settings.deleteAppGatewaySettings(), clientContext);
    this.deleteAppGatewayOperationCallable =
        callableFactory.createOperationCallable(
            deleteAppGatewayTransportSettings,
            settings.deleteAppGatewayOperationSettings(),
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
  public UnaryCallable<ListAppGatewaysRequest, ListAppGatewaysResponse> listAppGatewaysCallable() {
    return listAppGatewaysCallable;
  }

  @Override
  public UnaryCallable<ListAppGatewaysRequest, ListAppGatewaysPagedResponse>
      listAppGatewaysPagedCallable() {
    return listAppGatewaysPagedCallable;
  }

  @Override
  public UnaryCallable<GetAppGatewayRequest, AppGateway> getAppGatewayCallable() {
    return getAppGatewayCallable;
  }

  @Override
  public UnaryCallable<CreateAppGatewayRequest, Operation> createAppGatewayCallable() {
    return createAppGatewayCallable;
  }

  @Override
  public OperationCallable<CreateAppGatewayRequest, AppGateway, AppGatewayOperationMetadata>
      createAppGatewayOperationCallable() {
    return createAppGatewayOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAppGatewayRequest, Operation> deleteAppGatewayCallable() {
    return deleteAppGatewayCallable;
  }

  @Override
  public OperationCallable<DeleteAppGatewayRequest, Empty, AppGatewayOperationMetadata>
      deleteAppGatewayOperationCallable() {
    return deleteAppGatewayOperationCallable;
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
