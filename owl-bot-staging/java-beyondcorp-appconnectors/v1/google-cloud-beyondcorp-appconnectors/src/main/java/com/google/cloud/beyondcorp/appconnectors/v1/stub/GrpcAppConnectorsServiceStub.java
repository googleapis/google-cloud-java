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

package com.google.cloud.beyondcorp.appconnectors.v1.stub;

import static com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorsServiceClient.ListAppConnectorsPagedResponse;
import static com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorsServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.beyondcorp.appconnectors.v1.AppConnector;
import com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorOperationMetadata;
import com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse;
import com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest;
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
 * gRPC stub implementation for the AppConnectorsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAppConnectorsServiceStub extends AppConnectorsServiceStub {
  private static final MethodDescriptor<ListAppConnectorsRequest, ListAppConnectorsResponse>
      listAppConnectorsMethodDescriptor =
          MethodDescriptor.<ListAppConnectorsRequest, ListAppConnectorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnectors.v1.AppConnectorsService/ListAppConnectors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAppConnectorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAppConnectorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAppConnectorRequest, AppConnector>
      getAppConnectorMethodDescriptor =
          MethodDescriptor.<GetAppConnectorRequest, AppConnector>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnectors.v1.AppConnectorsService/GetAppConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAppConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AppConnector.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAppConnectorRequest, Operation>
      createAppConnectorMethodDescriptor =
          MethodDescriptor.<CreateAppConnectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnectors.v1.AppConnectorsService/CreateAppConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAppConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAppConnectorRequest, Operation>
      updateAppConnectorMethodDescriptor =
          MethodDescriptor.<UpdateAppConnectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnectors.v1.AppConnectorsService/UpdateAppConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAppConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAppConnectorRequest, Operation>
      deleteAppConnectorMethodDescriptor =
          MethodDescriptor.<DeleteAppConnectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnectors.v1.AppConnectorsService/DeleteAppConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAppConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReportStatusRequest, Operation>
      reportStatusMethodDescriptor =
          MethodDescriptor.<ReportStatusRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.beyondcorp.appconnectors.v1.AppConnectorsService/ReportStatus")
              .setRequestMarshaller(ProtoUtils.marshaller(ReportStatusRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListAppConnectorsRequest, ListAppConnectorsResponse>
      listAppConnectorsCallable;
  private final UnaryCallable<ListAppConnectorsRequest, ListAppConnectorsPagedResponse>
      listAppConnectorsPagedCallable;
  private final UnaryCallable<GetAppConnectorRequest, AppConnector> getAppConnectorCallable;
  private final UnaryCallable<CreateAppConnectorRequest, Operation> createAppConnectorCallable;
  private final OperationCallable<
          CreateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      createAppConnectorOperationCallable;
  private final UnaryCallable<UpdateAppConnectorRequest, Operation> updateAppConnectorCallable;
  private final OperationCallable<
          UpdateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      updateAppConnectorOperationCallable;
  private final UnaryCallable<DeleteAppConnectorRequest, Operation> deleteAppConnectorCallable;
  private final OperationCallable<DeleteAppConnectorRequest, Empty, AppConnectorOperationMetadata>
      deleteAppConnectorOperationCallable;
  private final UnaryCallable<ReportStatusRequest, Operation> reportStatusCallable;
  private final OperationCallable<ReportStatusRequest, AppConnector, AppConnectorOperationMetadata>
      reportStatusOperationCallable;
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

  public static final GrpcAppConnectorsServiceStub create(AppConnectorsServiceStubSettings settings)
      throws IOException {
    return new GrpcAppConnectorsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAppConnectorsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAppConnectorsServiceStub(
        AppConnectorsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAppConnectorsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAppConnectorsServiceStub(
        AppConnectorsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAppConnectorsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAppConnectorsServiceStub(
      AppConnectorsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAppConnectorsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAppConnectorsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAppConnectorsServiceStub(
      AppConnectorsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAppConnectorsRequest, ListAppConnectorsResponse>
        listAppConnectorsTransportSettings =
            GrpcCallSettings.<ListAppConnectorsRequest, ListAppConnectorsResponse>newBuilder()
                .setMethodDescriptor(listAppConnectorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAppConnectorRequest, AppConnector> getAppConnectorTransportSettings =
        GrpcCallSettings.<GetAppConnectorRequest, AppConnector>newBuilder()
            .setMethodDescriptor(getAppConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateAppConnectorRequest, Operation> createAppConnectorTransportSettings =
        GrpcCallSettings.<CreateAppConnectorRequest, Operation>newBuilder()
            .setMethodDescriptor(createAppConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateAppConnectorRequest, Operation> updateAppConnectorTransportSettings =
        GrpcCallSettings.<UpdateAppConnectorRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAppConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "app_connector.name", String.valueOf(request.getAppConnector().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteAppConnectorRequest, Operation> deleteAppConnectorTransportSettings =
        GrpcCallSettings.<DeleteAppConnectorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAppConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ReportStatusRequest, Operation> reportStatusTransportSettings =
        GrpcCallSettings.<ReportStatusRequest, Operation>newBuilder()
            .setMethodDescriptor(reportStatusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("app_connector", String.valueOf(request.getAppConnector()));
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

    this.listAppConnectorsCallable =
        callableFactory.createUnaryCallable(
            listAppConnectorsTransportSettings,
            settings.listAppConnectorsSettings(),
            clientContext);
    this.listAppConnectorsPagedCallable =
        callableFactory.createPagedCallable(
            listAppConnectorsTransportSettings,
            settings.listAppConnectorsSettings(),
            clientContext);
    this.getAppConnectorCallable =
        callableFactory.createUnaryCallable(
            getAppConnectorTransportSettings, settings.getAppConnectorSettings(), clientContext);
    this.createAppConnectorCallable =
        callableFactory.createUnaryCallable(
            createAppConnectorTransportSettings,
            settings.createAppConnectorSettings(),
            clientContext);
    this.createAppConnectorOperationCallable =
        callableFactory.createOperationCallable(
            createAppConnectorTransportSettings,
            settings.createAppConnectorOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAppConnectorCallable =
        callableFactory.createUnaryCallable(
            updateAppConnectorTransportSettings,
            settings.updateAppConnectorSettings(),
            clientContext);
    this.updateAppConnectorOperationCallable =
        callableFactory.createOperationCallable(
            updateAppConnectorTransportSettings,
            settings.updateAppConnectorOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAppConnectorCallable =
        callableFactory.createUnaryCallable(
            deleteAppConnectorTransportSettings,
            settings.deleteAppConnectorSettings(),
            clientContext);
    this.deleteAppConnectorOperationCallable =
        callableFactory.createOperationCallable(
            deleteAppConnectorTransportSettings,
            settings.deleteAppConnectorOperationSettings(),
            clientContext,
            operationsStub);
    this.reportStatusCallable =
        callableFactory.createUnaryCallable(
            reportStatusTransportSettings, settings.reportStatusSettings(), clientContext);
    this.reportStatusOperationCallable =
        callableFactory.createOperationCallable(
            reportStatusTransportSettings,
            settings.reportStatusOperationSettings(),
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
  public UnaryCallable<ListAppConnectorsRequest, ListAppConnectorsResponse>
      listAppConnectorsCallable() {
    return listAppConnectorsCallable;
  }

  @Override
  public UnaryCallable<ListAppConnectorsRequest, ListAppConnectorsPagedResponse>
      listAppConnectorsPagedCallable() {
    return listAppConnectorsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAppConnectorRequest, AppConnector> getAppConnectorCallable() {
    return getAppConnectorCallable;
  }

  @Override
  public UnaryCallable<CreateAppConnectorRequest, Operation> createAppConnectorCallable() {
    return createAppConnectorCallable;
  }

  @Override
  public OperationCallable<CreateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      createAppConnectorOperationCallable() {
    return createAppConnectorOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAppConnectorRequest, Operation> updateAppConnectorCallable() {
    return updateAppConnectorCallable;
  }

  @Override
  public OperationCallable<UpdateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      updateAppConnectorOperationCallable() {
    return updateAppConnectorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAppConnectorRequest, Operation> deleteAppConnectorCallable() {
    return deleteAppConnectorCallable;
  }

  @Override
  public OperationCallable<DeleteAppConnectorRequest, Empty, AppConnectorOperationMetadata>
      deleteAppConnectorOperationCallable() {
    return deleteAppConnectorOperationCallable;
  }

  @Override
  public UnaryCallable<ReportStatusRequest, Operation> reportStatusCallable() {
    return reportStatusCallable;
  }

  @Override
  public OperationCallable<ReportStatusRequest, AppConnector, AppConnectorOperationMetadata>
      reportStatusOperationCallable() {
    return reportStatusOperationCallable;
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
