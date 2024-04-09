/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.backupdr.v1.stub;

import static com.google.cloud.backupdr.v1.BackupDRClient.ListLocationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListManagementServersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.backupdr.v1.CreateManagementServerRequest;
import com.google.cloud.backupdr.v1.DeleteManagementServerRequest;
import com.google.cloud.backupdr.v1.GetManagementServerRequest;
import com.google.cloud.backupdr.v1.ListManagementServersRequest;
import com.google.cloud.backupdr.v1.ListManagementServersResponse;
import com.google.cloud.backupdr.v1.ManagementServer;
import com.google.cloud.backupdr.v1.OperationMetadata;
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
 * gRPC stub implementation for the BackupDR service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBackupDRStub extends BackupDRStub {
  private static final MethodDescriptor<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersMethodDescriptor =
          MethodDescriptor.<ListManagementServersRequest, ListManagementServersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/ListManagementServers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListManagementServersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListManagementServersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetManagementServerRequest, ManagementServer>
      getManagementServerMethodDescriptor =
          MethodDescriptor.<GetManagementServerRequest, ManagementServer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/GetManagementServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetManagementServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ManagementServer.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateManagementServerRequest, Operation>
      createManagementServerMethodDescriptor =
          MethodDescriptor.<CreateManagementServerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/CreateManagementServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateManagementServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteManagementServerRequest, Operation>
      deleteManagementServerMethodDescriptor =
          MethodDescriptor.<DeleteManagementServerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.backupdr.v1.BackupDR/DeleteManagementServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteManagementServerRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersCallable;
  private final UnaryCallable<ListManagementServersRequest, ListManagementServersPagedResponse>
      listManagementServersPagedCallable;
  private final UnaryCallable<GetManagementServerRequest, ManagementServer>
      getManagementServerCallable;
  private final UnaryCallable<CreateManagementServerRequest, Operation>
      createManagementServerCallable;
  private final OperationCallable<
          CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationCallable;
  private final UnaryCallable<DeleteManagementServerRequest, Operation>
      deleteManagementServerCallable;
  private final OperationCallable<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationCallable;
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

  public static final GrpcBackupDRStub create(BackupDRStubSettings settings) throws IOException {
    return new GrpcBackupDRStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBackupDRStub create(ClientContext clientContext) throws IOException {
    return new GrpcBackupDRStub(BackupDRStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBackupDRStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBackupDRStub(
        BackupDRStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBackupDRStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcBackupDRStub(BackupDRStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBackupDRCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBackupDRStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcBackupDRStub(
      BackupDRStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListManagementServersRequest, ListManagementServersResponse>
        listManagementServersTransportSettings =
            GrpcCallSettings
                .<ListManagementServersRequest, ListManagementServersResponse>newBuilder()
                .setMethodDescriptor(listManagementServersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetManagementServerRequest, ManagementServer>
        getManagementServerTransportSettings =
            GrpcCallSettings.<GetManagementServerRequest, ManagementServer>newBuilder()
                .setMethodDescriptor(getManagementServerMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateManagementServerRequest, Operation>
        createManagementServerTransportSettings =
            GrpcCallSettings.<CreateManagementServerRequest, Operation>newBuilder()
                .setMethodDescriptor(createManagementServerMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteManagementServerRequest, Operation>
        deleteManagementServerTransportSettings =
            GrpcCallSettings.<DeleteManagementServerRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteManagementServerMethodDescriptor)
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

    this.listManagementServersCallable =
        callableFactory.createUnaryCallable(
            listManagementServersTransportSettings,
            settings.listManagementServersSettings(),
            clientContext);
    this.listManagementServersPagedCallable =
        callableFactory.createPagedCallable(
            listManagementServersTransportSettings,
            settings.listManagementServersSettings(),
            clientContext);
    this.getManagementServerCallable =
        callableFactory.createUnaryCallable(
            getManagementServerTransportSettings,
            settings.getManagementServerSettings(),
            clientContext);
    this.createManagementServerCallable =
        callableFactory.createUnaryCallable(
            createManagementServerTransportSettings,
            settings.createManagementServerSettings(),
            clientContext);
    this.createManagementServerOperationCallable =
        callableFactory.createOperationCallable(
            createManagementServerTransportSettings,
            settings.createManagementServerOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteManagementServerCallable =
        callableFactory.createUnaryCallable(
            deleteManagementServerTransportSettings,
            settings.deleteManagementServerSettings(),
            clientContext);
    this.deleteManagementServerOperationCallable =
        callableFactory.createOperationCallable(
            deleteManagementServerTransportSettings,
            settings.deleteManagementServerOperationSettings(),
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
  public UnaryCallable<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersCallable() {
    return listManagementServersCallable;
  }

  @Override
  public UnaryCallable<ListManagementServersRequest, ListManagementServersPagedResponse>
      listManagementServersPagedCallable() {
    return listManagementServersPagedCallable;
  }

  @Override
  public UnaryCallable<GetManagementServerRequest, ManagementServer> getManagementServerCallable() {
    return getManagementServerCallable;
  }

  @Override
  public UnaryCallable<CreateManagementServerRequest, Operation> createManagementServerCallable() {
    return createManagementServerCallable;
  }

  @Override
  public OperationCallable<CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationCallable() {
    return createManagementServerOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteManagementServerRequest, Operation> deleteManagementServerCallable() {
    return deleteManagementServerCallable;
  }

  @Override
  public OperationCallable<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationCallable() {
    return deleteManagementServerOperationCallable;
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
