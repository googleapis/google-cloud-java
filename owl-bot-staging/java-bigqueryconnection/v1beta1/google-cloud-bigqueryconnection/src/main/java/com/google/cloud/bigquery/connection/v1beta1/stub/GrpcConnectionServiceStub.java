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

package com.google.cloud.bigquery.connection.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.connection.v1beta1.ConnectionProto;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * gRPC stub implementation for the ConnectionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcConnectionServiceStub extends ConnectionServiceStub {
  private static final MethodDescriptor<
          ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>
      createConnectionMethodDescriptor =
          MethodDescriptor
              .<ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/CreateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ConnectionProto.CreateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConnectionProto.Connection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>
      getConnectionMethodDescriptor =
          MethodDescriptor
              .<ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/GetConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ConnectionProto.GetConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConnectionProto.Connection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
      listConnectionsMethodDescriptor =
          MethodDescriptor
              .<ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/ListConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ConnectionProto.ListConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ConnectionProto.ListConnectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>
      updateConnectionMethodDescriptor =
          MethodDescriptor
              .<ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/UpdateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ConnectionProto.UpdateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConnectionProto.Connection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ConnectionProto.UpdateConnectionCredentialRequest, Empty>
      updateConnectionCredentialMethodDescriptor =
          MethodDescriptor.<ConnectionProto.UpdateConnectionCredentialRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/UpdateConnectionCredential")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ConnectionProto.UpdateConnectionCredentialRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ConnectionProto.DeleteConnectionRequest, Empty>
      deleteConnectionMethodDescriptor =
          MethodDescriptor.<ConnectionProto.DeleteConnectionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/DeleteConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ConnectionProto.DeleteConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.bigquery.connection.v1beta1.ConnectionService/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.bigquery.connection.v1beta1.ConnectionService/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.connection.v1beta1.ConnectionService/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>
      createConnectionCallable;
  private final UnaryCallable<ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>
      getConnectionCallable;
  private final UnaryCallable<
          ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
      listConnectionsCallable;
  private final UnaryCallable<ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>
      updateConnectionCallable;
  private final UnaryCallable<ConnectionProto.UpdateConnectionCredentialRequest, Empty>
      updateConnectionCredentialCallable;
  private final UnaryCallable<ConnectionProto.DeleteConnectionRequest, Empty>
      deleteConnectionCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConnectionServiceStub create(ConnectionServiceStubSettings settings)
      throws IOException {
    return new GrpcConnectionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConnectionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConnectionServiceStub(
        ConnectionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConnectionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConnectionServiceStub(
        ConnectionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConnectionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConnectionServiceStub(
      ConnectionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcConnectionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConnectionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConnectionServiceStub(
      ConnectionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>
        createConnectionTransportSettings =
            GrpcCallSettings
                .<ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>newBuilder()
                .setMethodDescriptor(createConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>
        getConnectionTransportSettings =
            GrpcCallSettings
                .<ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>newBuilder()
                .setMethodDescriptor(getConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<
            ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
        listConnectionsTransportSettings =
            GrpcCallSettings
                .<ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
                    newBuilder()
                .setMethodDescriptor(listConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>
        updateConnectionTransportSettings =
            GrpcCallSettings
                .<ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>newBuilder()
                .setMethodDescriptor(updateConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ConnectionProto.UpdateConnectionCredentialRequest, Empty>
        updateConnectionCredentialTransportSettings =
            GrpcCallSettings.<ConnectionProto.UpdateConnectionCredentialRequest, Empty>newBuilder()
                .setMethodDescriptor(updateConnectionCredentialMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ConnectionProto.DeleteConnectionRequest, Empty>
        deleteConnectionTransportSettings =
            GrpcCallSettings.<ConnectionProto.DeleteConnectionRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
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

    this.createConnectionCallable =
        callableFactory.createUnaryCallable(
            createConnectionTransportSettings, settings.createConnectionSettings(), clientContext);
    this.getConnectionCallable =
        callableFactory.createUnaryCallable(
            getConnectionTransportSettings, settings.getConnectionSettings(), clientContext);
    this.listConnectionsCallable =
        callableFactory.createUnaryCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.updateConnectionCallable =
        callableFactory.createUnaryCallable(
            updateConnectionTransportSettings, settings.updateConnectionSettings(), clientContext);
    this.updateConnectionCredentialCallable =
        callableFactory.createUnaryCallable(
            updateConnectionCredentialTransportSettings,
            settings.updateConnectionCredentialSettings(),
            clientContext);
    this.deleteConnectionCallable =
        callableFactory.createUnaryCallable(
            deleteConnectionTransportSettings, settings.deleteConnectionSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
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
  public UnaryCallable<ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>
      createConnectionCallable() {
    return createConnectionCallable;
  }

  @Override
  public UnaryCallable<ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>
      getConnectionCallable() {
    return getConnectionCallable;
  }

  @Override
  public UnaryCallable<
          ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
      listConnectionsCallable() {
    return listConnectionsCallable;
  }

  @Override
  public UnaryCallable<ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>
      updateConnectionCallable() {
    return updateConnectionCallable;
  }

  @Override
  public UnaryCallable<ConnectionProto.UpdateConnectionCredentialRequest, Empty>
      updateConnectionCredentialCallable() {
    return updateConnectionCredentialCallable;
  }

  @Override
  public UnaryCallable<ConnectionProto.DeleteConnectionRequest, Empty> deleteConnectionCallable() {
    return deleteConnectionCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
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
