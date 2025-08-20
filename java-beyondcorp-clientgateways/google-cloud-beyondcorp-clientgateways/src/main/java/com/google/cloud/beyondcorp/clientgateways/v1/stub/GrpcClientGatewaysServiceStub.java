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

package com.google.cloud.beyondcorp.clientgateways.v1.stub;

import static com.google.cloud.beyondcorp.clientgateways.v1.ClientGatewaysServiceClient.ListClientGatewaysPagedResponse;
import static com.google.cloud.beyondcorp.clientgateways.v1.ClientGatewaysServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway;
import com.google.cloud.beyondcorp.clientgateways.v1.ClientGatewayOperationMetadata;
import com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest;
import com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest;
import com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest;
import com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest;
import com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse;
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
 * gRPC stub implementation for the ClientGatewaysService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcClientGatewaysServiceStub extends ClientGatewaysServiceStub {
  private static final MethodDescriptor<ListClientGatewaysRequest, ListClientGatewaysResponse>
      listClientGatewaysMethodDescriptor =
          MethodDescriptor.<ListClientGatewaysRequest, ListClientGatewaysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.clientgateways.v1.ClientGatewaysService/ListClientGateways")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListClientGatewaysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClientGatewaysResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetClientGatewayRequest, ClientGateway>
      getClientGatewayMethodDescriptor =
          MethodDescriptor.<GetClientGatewayRequest, ClientGateway>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.clientgateways.v1.ClientGatewaysService/GetClientGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetClientGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ClientGateway.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateClientGatewayRequest, Operation>
      createClientGatewayMethodDescriptor =
          MethodDescriptor.<CreateClientGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.clientgateways.v1.ClientGatewaysService/CreateClientGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClientGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteClientGatewayRequest, Operation>
      deleteClientGatewayMethodDescriptor =
          MethodDescriptor.<DeleteClientGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.clientgateways.v1.ClientGatewaysService/DeleteClientGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClientGatewayRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListClientGatewaysRequest, ListClientGatewaysResponse>
      listClientGatewaysCallable;
  private final UnaryCallable<ListClientGatewaysRequest, ListClientGatewaysPagedResponse>
      listClientGatewaysPagedCallable;
  private final UnaryCallable<GetClientGatewayRequest, ClientGateway> getClientGatewayCallable;
  private final UnaryCallable<CreateClientGatewayRequest, Operation> createClientGatewayCallable;
  private final OperationCallable<
          CreateClientGatewayRequest, ClientGateway, ClientGatewayOperationMetadata>
      createClientGatewayOperationCallable;
  private final UnaryCallable<DeleteClientGatewayRequest, Operation> deleteClientGatewayCallable;
  private final OperationCallable<DeleteClientGatewayRequest, Empty, ClientGatewayOperationMetadata>
      deleteClientGatewayOperationCallable;
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

  public static final GrpcClientGatewaysServiceStub create(
      ClientGatewaysServiceStubSettings settings) throws IOException {
    return new GrpcClientGatewaysServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcClientGatewaysServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcClientGatewaysServiceStub(
        ClientGatewaysServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcClientGatewaysServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcClientGatewaysServiceStub(
        ClientGatewaysServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcClientGatewaysServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcClientGatewaysServiceStub(
      ClientGatewaysServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcClientGatewaysServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcClientGatewaysServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcClientGatewaysServiceStub(
      ClientGatewaysServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListClientGatewaysRequest, ListClientGatewaysResponse>
        listClientGatewaysTransportSettings =
            GrpcCallSettings.<ListClientGatewaysRequest, ListClientGatewaysResponse>newBuilder()
                .setMethodDescriptor(listClientGatewaysMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetClientGatewayRequest, ClientGateway> getClientGatewayTransportSettings =
        GrpcCallSettings.<GetClientGatewayRequest, ClientGateway>newBuilder()
            .setMethodDescriptor(getClientGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateClientGatewayRequest, Operation> createClientGatewayTransportSettings =
        GrpcCallSettings.<CreateClientGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(createClientGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteClientGatewayRequest, Operation> deleteClientGatewayTransportSettings =
        GrpcCallSettings.<DeleteClientGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClientGatewayMethodDescriptor)
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

    this.listClientGatewaysCallable =
        callableFactory.createUnaryCallable(
            listClientGatewaysTransportSettings,
            settings.listClientGatewaysSettings(),
            clientContext);
    this.listClientGatewaysPagedCallable =
        callableFactory.createPagedCallable(
            listClientGatewaysTransportSettings,
            settings.listClientGatewaysSettings(),
            clientContext);
    this.getClientGatewayCallable =
        callableFactory.createUnaryCallable(
            getClientGatewayTransportSettings, settings.getClientGatewaySettings(), clientContext);
    this.createClientGatewayCallable =
        callableFactory.createUnaryCallable(
            createClientGatewayTransportSettings,
            settings.createClientGatewaySettings(),
            clientContext);
    this.createClientGatewayOperationCallable =
        callableFactory.createOperationCallable(
            createClientGatewayTransportSettings,
            settings.createClientGatewayOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteClientGatewayCallable =
        callableFactory.createUnaryCallable(
            deleteClientGatewayTransportSettings,
            settings.deleteClientGatewaySettings(),
            clientContext);
    this.deleteClientGatewayOperationCallable =
        callableFactory.createOperationCallable(
            deleteClientGatewayTransportSettings,
            settings.deleteClientGatewayOperationSettings(),
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
  public UnaryCallable<ListClientGatewaysRequest, ListClientGatewaysResponse>
      listClientGatewaysCallable() {
    return listClientGatewaysCallable;
  }

  @Override
  public UnaryCallable<ListClientGatewaysRequest, ListClientGatewaysPagedResponse>
      listClientGatewaysPagedCallable() {
    return listClientGatewaysPagedCallable;
  }

  @Override
  public UnaryCallable<GetClientGatewayRequest, ClientGateway> getClientGatewayCallable() {
    return getClientGatewayCallable;
  }

  @Override
  public UnaryCallable<CreateClientGatewayRequest, Operation> createClientGatewayCallable() {
    return createClientGatewayCallable;
  }

  @Override
  public OperationCallable<
          CreateClientGatewayRequest, ClientGateway, ClientGatewayOperationMetadata>
      createClientGatewayOperationCallable() {
    return createClientGatewayOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteClientGatewayRequest, Operation> deleteClientGatewayCallable() {
    return deleteClientGatewayCallable;
  }

  @Override
  public OperationCallable<DeleteClientGatewayRequest, Empty, ClientGatewayOperationMetadata>
      deleteClientGatewayOperationCallable() {
    return deleteClientGatewayOperationCallable;
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
