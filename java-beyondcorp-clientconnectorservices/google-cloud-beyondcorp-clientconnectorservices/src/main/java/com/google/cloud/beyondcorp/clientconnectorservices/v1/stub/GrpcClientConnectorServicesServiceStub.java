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

package com.google.cloud.beyondcorp.clientconnectorservices.v1.stub;

import static com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesServiceClient.ListClientConnectorServicesPagedResponse;
import static com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServiceOperationMetadata;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest;
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
 * gRPC stub implementation for the ClientConnectorServicesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcClientConnectorServicesServiceStub extends ClientConnectorServicesServiceStub {
  private static final MethodDescriptor<
          ListClientConnectorServicesRequest, ListClientConnectorServicesResponse>
      listClientConnectorServicesMethodDescriptor =
          MethodDescriptor
              .<ListClientConnectorServicesRequest, ListClientConnectorServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesService/ListClientConnectorServices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListClientConnectorServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClientConnectorServicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetClientConnectorServiceRequest, ClientConnectorService>
      getClientConnectorServiceMethodDescriptor =
          MethodDescriptor.<GetClientConnectorServiceRequest, ClientConnectorService>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesService/GetClientConnectorService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetClientConnectorServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ClientConnectorService.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateClientConnectorServiceRequest, Operation>
      createClientConnectorServiceMethodDescriptor =
          MethodDescriptor.<CreateClientConnectorServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesService/CreateClientConnectorService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClientConnectorServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateClientConnectorServiceRequest, Operation>
      updateClientConnectorServiceMethodDescriptor =
          MethodDescriptor.<UpdateClientConnectorServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesService/UpdateClientConnectorService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClientConnectorServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteClientConnectorServiceRequest, Operation>
      deleteClientConnectorServiceMethodDescriptor =
          MethodDescriptor.<DeleteClientConnectorServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesService/DeleteClientConnectorService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClientConnectorServiceRequest.getDefaultInstance()))
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

  private final UnaryCallable<
          ListClientConnectorServicesRequest, ListClientConnectorServicesResponse>
      listClientConnectorServicesCallable;
  private final UnaryCallable<
          ListClientConnectorServicesRequest, ListClientConnectorServicesPagedResponse>
      listClientConnectorServicesPagedCallable;
  private final UnaryCallable<GetClientConnectorServiceRequest, ClientConnectorService>
      getClientConnectorServiceCallable;
  private final UnaryCallable<CreateClientConnectorServiceRequest, Operation>
      createClientConnectorServiceCallable;
  private final OperationCallable<
          CreateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      createClientConnectorServiceOperationCallable;
  private final UnaryCallable<UpdateClientConnectorServiceRequest, Operation>
      updateClientConnectorServiceCallable;
  private final OperationCallable<
          UpdateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      updateClientConnectorServiceOperationCallable;
  private final UnaryCallable<DeleteClientConnectorServiceRequest, Operation>
      deleteClientConnectorServiceCallable;
  private final OperationCallable<
          DeleteClientConnectorServiceRequest, Empty, ClientConnectorServiceOperationMetadata>
      deleteClientConnectorServiceOperationCallable;
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

  public static final GrpcClientConnectorServicesServiceStub create(
      ClientConnectorServicesServiceStubSettings settings) throws IOException {
    return new GrpcClientConnectorServicesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcClientConnectorServicesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcClientConnectorServicesServiceStub(
        ClientConnectorServicesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcClientConnectorServicesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcClientConnectorServicesServiceStub(
        ClientConnectorServicesServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcClientConnectorServicesServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcClientConnectorServicesServiceStub(
      ClientConnectorServicesServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcClientConnectorServicesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcClientConnectorServicesServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcClientConnectorServicesServiceStub(
      ClientConnectorServicesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListClientConnectorServicesRequest, ListClientConnectorServicesResponse>
        listClientConnectorServicesTransportSettings =
            GrpcCallSettings
                .<ListClientConnectorServicesRequest, ListClientConnectorServicesResponse>
                    newBuilder()
                .setMethodDescriptor(listClientConnectorServicesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetClientConnectorServiceRequest, ClientConnectorService>
        getClientConnectorServiceTransportSettings =
            GrpcCallSettings.<GetClientConnectorServiceRequest, ClientConnectorService>newBuilder()
                .setMethodDescriptor(getClientConnectorServiceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateClientConnectorServiceRequest, Operation>
        createClientConnectorServiceTransportSettings =
            GrpcCallSettings.<CreateClientConnectorServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(createClientConnectorServiceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateClientConnectorServiceRequest, Operation>
        updateClientConnectorServiceTransportSettings =
            GrpcCallSettings.<UpdateClientConnectorServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateClientConnectorServiceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "client_connector_service.name",
                          String.valueOf(request.getClientConnectorService().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteClientConnectorServiceRequest, Operation>
        deleteClientConnectorServiceTransportSettings =
            GrpcCallSettings.<DeleteClientConnectorServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteClientConnectorServiceMethodDescriptor)
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

    this.listClientConnectorServicesCallable =
        callableFactory.createUnaryCallable(
            listClientConnectorServicesTransportSettings,
            settings.listClientConnectorServicesSettings(),
            clientContext);
    this.listClientConnectorServicesPagedCallable =
        callableFactory.createPagedCallable(
            listClientConnectorServicesTransportSettings,
            settings.listClientConnectorServicesSettings(),
            clientContext);
    this.getClientConnectorServiceCallable =
        callableFactory.createUnaryCallable(
            getClientConnectorServiceTransportSettings,
            settings.getClientConnectorServiceSettings(),
            clientContext);
    this.createClientConnectorServiceCallable =
        callableFactory.createUnaryCallable(
            createClientConnectorServiceTransportSettings,
            settings.createClientConnectorServiceSettings(),
            clientContext);
    this.createClientConnectorServiceOperationCallable =
        callableFactory.createOperationCallable(
            createClientConnectorServiceTransportSettings,
            settings.createClientConnectorServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.updateClientConnectorServiceCallable =
        callableFactory.createUnaryCallable(
            updateClientConnectorServiceTransportSettings,
            settings.updateClientConnectorServiceSettings(),
            clientContext);
    this.updateClientConnectorServiceOperationCallable =
        callableFactory.createOperationCallable(
            updateClientConnectorServiceTransportSettings,
            settings.updateClientConnectorServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteClientConnectorServiceCallable =
        callableFactory.createUnaryCallable(
            deleteClientConnectorServiceTransportSettings,
            settings.deleteClientConnectorServiceSettings(),
            clientContext);
    this.deleteClientConnectorServiceOperationCallable =
        callableFactory.createOperationCallable(
            deleteClientConnectorServiceTransportSettings,
            settings.deleteClientConnectorServiceOperationSettings(),
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
  public UnaryCallable<ListClientConnectorServicesRequest, ListClientConnectorServicesResponse>
      listClientConnectorServicesCallable() {
    return listClientConnectorServicesCallable;
  }

  @Override
  public UnaryCallable<ListClientConnectorServicesRequest, ListClientConnectorServicesPagedResponse>
      listClientConnectorServicesPagedCallable() {
    return listClientConnectorServicesPagedCallable;
  }

  @Override
  public UnaryCallable<GetClientConnectorServiceRequest, ClientConnectorService>
      getClientConnectorServiceCallable() {
    return getClientConnectorServiceCallable;
  }

  @Override
  public UnaryCallable<CreateClientConnectorServiceRequest, Operation>
      createClientConnectorServiceCallable() {
    return createClientConnectorServiceCallable;
  }

  @Override
  public OperationCallable<
          CreateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      createClientConnectorServiceOperationCallable() {
    return createClientConnectorServiceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateClientConnectorServiceRequest, Operation>
      updateClientConnectorServiceCallable() {
    return updateClientConnectorServiceCallable;
  }

  @Override
  public OperationCallable<
          UpdateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      updateClientConnectorServiceOperationCallable() {
    return updateClientConnectorServiceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteClientConnectorServiceRequest, Operation>
      deleteClientConnectorServiceCallable() {
    return deleteClientConnectorServiceCallable;
  }

  @Override
  public OperationCallable<
          DeleteClientConnectorServiceRequest, Empty, ClientConnectorServiceOperationMetadata>
      deleteClientConnectorServiceOperationCallable() {
    return deleteClientConnectorServiceOperationCallable;
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
