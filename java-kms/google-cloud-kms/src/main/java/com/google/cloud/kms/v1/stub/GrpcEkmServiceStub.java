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

package com.google.cloud.kms.v1.stub;

import static com.google.cloud.kms.v1.EkmServiceClient.ListEkmConnectionsPagedResponse;
import static com.google.cloud.kms.v1.EkmServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.v1.CreateEkmConnectionRequest;
import com.google.cloud.kms.v1.EkmConfig;
import com.google.cloud.kms.v1.EkmConnection;
import com.google.cloud.kms.v1.GetEkmConfigRequest;
import com.google.cloud.kms.v1.GetEkmConnectionRequest;
import com.google.cloud.kms.v1.ListEkmConnectionsRequest;
import com.google.cloud.kms.v1.ListEkmConnectionsResponse;
import com.google.cloud.kms.v1.UpdateEkmConfigRequest;
import com.google.cloud.kms.v1.UpdateEkmConnectionRequest;
import com.google.cloud.kms.v1.VerifyConnectivityRequest;
import com.google.cloud.kms.v1.VerifyConnectivityResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the EkmService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEkmServiceStub extends EkmServiceStub {
  private static final MethodDescriptor<ListEkmConnectionsRequest, ListEkmConnectionsResponse>
      listEkmConnectionsMethodDescriptor =
          MethodDescriptor.<ListEkmConnectionsRequest, ListEkmConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.EkmService/ListEkmConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEkmConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEkmConnectionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEkmConnectionRequest, EkmConnection>
      getEkmConnectionMethodDescriptor =
          MethodDescriptor.<GetEkmConnectionRequest, EkmConnection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.EkmService/GetEkmConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEkmConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EkmConnection.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateEkmConnectionRequest, EkmConnection>
      createEkmConnectionMethodDescriptor =
          MethodDescriptor.<CreateEkmConnectionRequest, EkmConnection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.EkmService/CreateEkmConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEkmConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EkmConnection.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateEkmConnectionRequest, EkmConnection>
      updateEkmConnectionMethodDescriptor =
          MethodDescriptor.<UpdateEkmConnectionRequest, EkmConnection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.EkmService/UpdateEkmConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEkmConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EkmConnection.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEkmConfigRequest, EkmConfig>
      getEkmConfigMethodDescriptor =
          MethodDescriptor.<GetEkmConfigRequest, EkmConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.EkmService/GetEkmConfig")
              .setRequestMarshaller(ProtoUtils.marshaller(GetEkmConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EkmConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateEkmConfigRequest, EkmConfig>
      updateEkmConfigMethodDescriptor =
          MethodDescriptor.<UpdateEkmConfigRequest, EkmConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.EkmService/UpdateEkmConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEkmConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EkmConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<VerifyConnectivityRequest, VerifyConnectivityResponse>
      verifyConnectivityMethodDescriptor =
          MethodDescriptor.<VerifyConnectivityRequest, VerifyConnectivityResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.EkmService/VerifyConnectivity")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(VerifyConnectivityRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(VerifyConnectivityResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListEkmConnectionsRequest, ListEkmConnectionsResponse>
      listEkmConnectionsCallable;
  private final UnaryCallable<ListEkmConnectionsRequest, ListEkmConnectionsPagedResponse>
      listEkmConnectionsPagedCallable;
  private final UnaryCallable<GetEkmConnectionRequest, EkmConnection> getEkmConnectionCallable;
  private final UnaryCallable<CreateEkmConnectionRequest, EkmConnection>
      createEkmConnectionCallable;
  private final UnaryCallable<UpdateEkmConnectionRequest, EkmConnection>
      updateEkmConnectionCallable;
  private final UnaryCallable<GetEkmConfigRequest, EkmConfig> getEkmConfigCallable;
  private final UnaryCallable<UpdateEkmConfigRequest, EkmConfig> updateEkmConfigCallable;
  private final UnaryCallable<VerifyConnectivityRequest, VerifyConnectivityResponse>
      verifyConnectivityCallable;
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

  public static final GrpcEkmServiceStub create(EkmServiceStubSettings settings)
      throws IOException {
    return new GrpcEkmServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEkmServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcEkmServiceStub(EkmServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEkmServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEkmServiceStub(
        EkmServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEkmServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEkmServiceStub(EkmServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEkmServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEkmServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEkmServiceStub(
      EkmServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListEkmConnectionsRequest, ListEkmConnectionsResponse>
        listEkmConnectionsTransportSettings =
            GrpcCallSettings.<ListEkmConnectionsRequest, ListEkmConnectionsResponse>newBuilder()
                .setMethodDescriptor(listEkmConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEkmConnectionRequest, EkmConnection> getEkmConnectionTransportSettings =
        GrpcCallSettings.<GetEkmConnectionRequest, EkmConnection>newBuilder()
            .setMethodDescriptor(getEkmConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateEkmConnectionRequest, EkmConnection>
        createEkmConnectionTransportSettings =
            GrpcCallSettings.<CreateEkmConnectionRequest, EkmConnection>newBuilder()
                .setMethodDescriptor(createEkmConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateEkmConnectionRequest, EkmConnection>
        updateEkmConnectionTransportSettings =
            GrpcCallSettings.<UpdateEkmConnectionRequest, EkmConnection>newBuilder()
                .setMethodDescriptor(updateEkmConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "ekm_connection.name",
                          String.valueOf(request.getEkmConnection().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEkmConfigRequest, EkmConfig> getEkmConfigTransportSettings =
        GrpcCallSettings.<GetEkmConfigRequest, EkmConfig>newBuilder()
            .setMethodDescriptor(getEkmConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEkmConfigRequest, EkmConfig> updateEkmConfigTransportSettings =
        GrpcCallSettings.<UpdateEkmConfigRequest, EkmConfig>newBuilder()
            .setMethodDescriptor(updateEkmConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("ekm_config.name", String.valueOf(request.getEkmConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<VerifyConnectivityRequest, VerifyConnectivityResponse>
        verifyConnectivityTransportSettings =
            GrpcCallSettings.<VerifyConnectivityRequest, VerifyConnectivityResponse>newBuilder()
                .setMethodDescriptor(verifyConnectivityMethodDescriptor)
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

    this.listEkmConnectionsCallable =
        callableFactory.createUnaryCallable(
            listEkmConnectionsTransportSettings,
            settings.listEkmConnectionsSettings(),
            clientContext);
    this.listEkmConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listEkmConnectionsTransportSettings,
            settings.listEkmConnectionsSettings(),
            clientContext);
    this.getEkmConnectionCallable =
        callableFactory.createUnaryCallable(
            getEkmConnectionTransportSettings, settings.getEkmConnectionSettings(), clientContext);
    this.createEkmConnectionCallable =
        callableFactory.createUnaryCallable(
            createEkmConnectionTransportSettings,
            settings.createEkmConnectionSettings(),
            clientContext);
    this.updateEkmConnectionCallable =
        callableFactory.createUnaryCallable(
            updateEkmConnectionTransportSettings,
            settings.updateEkmConnectionSettings(),
            clientContext);
    this.getEkmConfigCallable =
        callableFactory.createUnaryCallable(
            getEkmConfigTransportSettings, settings.getEkmConfigSettings(), clientContext);
    this.updateEkmConfigCallable =
        callableFactory.createUnaryCallable(
            updateEkmConfigTransportSettings, settings.updateEkmConfigSettings(), clientContext);
    this.verifyConnectivityCallable =
        callableFactory.createUnaryCallable(
            verifyConnectivityTransportSettings,
            settings.verifyConnectivitySettings(),
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
  public UnaryCallable<ListEkmConnectionsRequest, ListEkmConnectionsResponse>
      listEkmConnectionsCallable() {
    return listEkmConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListEkmConnectionsRequest, ListEkmConnectionsPagedResponse>
      listEkmConnectionsPagedCallable() {
    return listEkmConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEkmConnectionRequest, EkmConnection> getEkmConnectionCallable() {
    return getEkmConnectionCallable;
  }

  @Override
  public UnaryCallable<CreateEkmConnectionRequest, EkmConnection> createEkmConnectionCallable() {
    return createEkmConnectionCallable;
  }

  @Override
  public UnaryCallable<UpdateEkmConnectionRequest, EkmConnection> updateEkmConnectionCallable() {
    return updateEkmConnectionCallable;
  }

  @Override
  public UnaryCallable<GetEkmConfigRequest, EkmConfig> getEkmConfigCallable() {
    return getEkmConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateEkmConfigRequest, EkmConfig> updateEkmConfigCallable() {
    return updateEkmConfigCallable;
  }

  @Override
  public UnaryCallable<VerifyConnectivityRequest, VerifyConnectivityResponse>
      verifyConnectivityCallable() {
    return verifyConnectivityCallable;
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
