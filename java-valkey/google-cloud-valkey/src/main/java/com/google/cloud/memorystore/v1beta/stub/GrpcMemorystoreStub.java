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

package com.google.cloud.memorystore.v1beta.stub;

import static com.google.cloud.memorystore.v1beta.MemorystoreClient.ListAuthTokensPagedResponse;
import static com.google.cloud.memorystore.v1beta.MemorystoreClient.ListBackupCollectionsPagedResponse;
import static com.google.cloud.memorystore.v1beta.MemorystoreClient.ListBackupsPagedResponse;
import static com.google.cloud.memorystore.v1beta.MemorystoreClient.ListInstancesPagedResponse;
import static com.google.cloud.memorystore.v1beta.MemorystoreClient.ListLocationsPagedResponse;
import static com.google.cloud.memorystore.v1beta.MemorystoreClient.ListTokenAuthUsersPagedResponse;

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
import com.google.cloud.memorystore.v1beta.AddAuthTokenRequest;
import com.google.cloud.memorystore.v1beta.AddTokenAuthUserRequest;
import com.google.cloud.memorystore.v1beta.AuthToken;
import com.google.cloud.memorystore.v1beta.Backup;
import com.google.cloud.memorystore.v1beta.BackupCollection;
import com.google.cloud.memorystore.v1beta.BackupInstanceRequest;
import com.google.cloud.memorystore.v1beta.CertificateAuthority;
import com.google.cloud.memorystore.v1beta.CreateInstanceRequest;
import com.google.cloud.memorystore.v1beta.DeleteAuthTokenRequest;
import com.google.cloud.memorystore.v1beta.DeleteBackupRequest;
import com.google.cloud.memorystore.v1beta.DeleteInstanceRequest;
import com.google.cloud.memorystore.v1beta.DeleteTokenAuthUserRequest;
import com.google.cloud.memorystore.v1beta.ExportBackupRequest;
import com.google.cloud.memorystore.v1beta.FinishMigrationRequest;
import com.google.cloud.memorystore.v1beta.GetAuthTokenRequest;
import com.google.cloud.memorystore.v1beta.GetBackupCollectionRequest;
import com.google.cloud.memorystore.v1beta.GetBackupRequest;
import com.google.cloud.memorystore.v1beta.GetCertificateAuthorityRequest;
import com.google.cloud.memorystore.v1beta.GetInstanceRequest;
import com.google.cloud.memorystore.v1beta.GetSharedRegionalCertificateAuthorityRequest;
import com.google.cloud.memorystore.v1beta.GetTokenAuthUserRequest;
import com.google.cloud.memorystore.v1beta.Instance;
import com.google.cloud.memorystore.v1beta.ListAuthTokensRequest;
import com.google.cloud.memorystore.v1beta.ListAuthTokensResponse;
import com.google.cloud.memorystore.v1beta.ListBackupCollectionsRequest;
import com.google.cloud.memorystore.v1beta.ListBackupCollectionsResponse;
import com.google.cloud.memorystore.v1beta.ListBackupsRequest;
import com.google.cloud.memorystore.v1beta.ListBackupsResponse;
import com.google.cloud.memorystore.v1beta.ListInstancesRequest;
import com.google.cloud.memorystore.v1beta.ListInstancesResponse;
import com.google.cloud.memorystore.v1beta.ListTokenAuthUsersRequest;
import com.google.cloud.memorystore.v1beta.ListTokenAuthUsersResponse;
import com.google.cloud.memorystore.v1beta.OperationMetadata;
import com.google.cloud.memorystore.v1beta.RescheduleMaintenanceRequest;
import com.google.cloud.memorystore.v1beta.SharedRegionalCertificateAuthority;
import com.google.cloud.memorystore.v1beta.StartMigrationRequest;
import com.google.cloud.memorystore.v1beta.TokenAuthUser;
import com.google.cloud.memorystore.v1beta.UpdateInstanceRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Memorystore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMemorystoreStub extends MemorystoreStub {
  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          MethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/UpdateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<GetCertificateAuthorityRequest, CertificateAuthority>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.memorystore.v1beta.Memorystore/GetCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CertificateAuthority.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetSharedRegionalCertificateAuthorityRequest, SharedRegionalCertificateAuthority>
      getSharedRegionalCertificateAuthorityMethodDescriptor =
          MethodDescriptor
              .<GetSharedRegionalCertificateAuthorityRequest, SharedRegionalCertificateAuthority>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.memorystore.v1beta.Memorystore/GetSharedRegionalCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetSharedRegionalCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SharedRegionalCertificateAuthority.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceMethodDescriptor =
          MethodDescriptor.<RescheduleMaintenanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.memorystore.v1beta.Memorystore/RescheduleMaintenance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RescheduleMaintenanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBackupCollectionsRequest, ListBackupCollectionsResponse>
      listBackupCollectionsMethodDescriptor =
          MethodDescriptor.<ListBackupCollectionsRequest, ListBackupCollectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.memorystore.v1beta.Memorystore/ListBackupCollections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupCollectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupCollectionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupCollectionRequest, BackupCollection>
      getBackupCollectionMethodDescriptor =
          MethodDescriptor.<GetBackupCollectionRequest, BackupCollection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/GetBackupCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupCollection.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          MethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/ListBackups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      MethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/GetBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteBackupRequest, Operation>
      deleteBackupMethodDescriptor =
          MethodDescriptor.<DeleteBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/DeleteBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportBackupRequest, Operation>
      exportBackupMethodDescriptor =
          MethodDescriptor.<ExportBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/ExportBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(ExportBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BackupInstanceRequest, Operation>
      backupInstanceMethodDescriptor =
          MethodDescriptor.<BackupInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/BackupInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BackupInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<StartMigrationRequest, Operation>
      startMigrationMethodDescriptor =
          MethodDescriptor.<StartMigrationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/StartMigration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartMigrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<FinishMigrationRequest, Operation>
      finishMigrationMethodDescriptor =
          MethodDescriptor.<FinishMigrationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/FinishMigration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FinishMigrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListTokenAuthUsersRequest, ListTokenAuthUsersResponse>
      listTokenAuthUsersMethodDescriptor =
          MethodDescriptor.<ListTokenAuthUsersRequest, ListTokenAuthUsersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/ListTokenAuthUsers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTokenAuthUsersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTokenAuthUsersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetTokenAuthUserRequest, TokenAuthUser>
      getTokenAuthUserMethodDescriptor =
          MethodDescriptor.<GetTokenAuthUserRequest, TokenAuthUser>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/GetTokenAuthUser")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTokenAuthUserRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TokenAuthUser.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAuthTokensRequest, ListAuthTokensResponse>
      listAuthTokensMethodDescriptor =
          MethodDescriptor.<ListAuthTokensRequest, ListAuthTokensResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/ListAuthTokens")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAuthTokensRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAuthTokensResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAuthTokenRequest, AuthToken>
      getAuthTokenMethodDescriptor =
          MethodDescriptor.<GetAuthTokenRequest, AuthToken>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/GetAuthToken")
              .setRequestMarshaller(ProtoUtils.marshaller(GetAuthTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuthToken.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AddTokenAuthUserRequest, Operation>
      addTokenAuthUserMethodDescriptor =
          MethodDescriptor.<AddTokenAuthUserRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/AddTokenAuthUser")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddTokenAuthUserRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteTokenAuthUserRequest, Operation>
      deleteTokenAuthUserMethodDescriptor =
          MethodDescriptor.<DeleteTokenAuthUserRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/DeleteTokenAuthUser")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTokenAuthUserRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AddAuthTokenRequest, Operation>
      addAuthTokenMethodDescriptor =
          MethodDescriptor.<AddAuthTokenRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/AddAuthToken")
              .setRequestMarshaller(ProtoUtils.marshaller(AddAuthTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAuthTokenRequest, Operation>
      deleteAuthTokenMethodDescriptor =
          MethodDescriptor.<DeleteAuthTokenRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.memorystore.v1beta.Memorystore/DeleteAuthToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAuthTokenRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthorityCallable;
  private final UnaryCallable<
          GetSharedRegionalCertificateAuthorityRequest, SharedRegionalCertificateAuthority>
      getSharedRegionalCertificateAuthorityCallable;
  private final UnaryCallable<RescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceCallable;
  private final OperationCallable<RescheduleMaintenanceRequest, Instance, OperationMetadata>
      rescheduleMaintenanceOperationCallable;
  private final UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsResponse>
      listBackupCollectionsCallable;
  private final UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsPagedResponse>
      listBackupCollectionsPagedCallable;
  private final UnaryCallable<GetBackupCollectionRequest, BackupCollection>
      getBackupCollectionCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable;
  private final UnaryCallable<ExportBackupRequest, Operation> exportBackupCallable;
  private final OperationCallable<ExportBackupRequest, Backup, OperationMetadata>
      exportBackupOperationCallable;
  private final UnaryCallable<BackupInstanceRequest, Operation> backupInstanceCallable;
  private final OperationCallable<BackupInstanceRequest, Instance, OperationMetadata>
      backupInstanceOperationCallable;
  private final UnaryCallable<StartMigrationRequest, Operation> startMigrationCallable;
  private final OperationCallable<StartMigrationRequest, Instance, OperationMetadata>
      startMigrationOperationCallable;
  private final UnaryCallable<FinishMigrationRequest, Operation> finishMigrationCallable;
  private final OperationCallable<FinishMigrationRequest, Instance, OperationMetadata>
      finishMigrationOperationCallable;
  private final UnaryCallable<ListTokenAuthUsersRequest, ListTokenAuthUsersResponse>
      listTokenAuthUsersCallable;
  private final UnaryCallable<ListTokenAuthUsersRequest, ListTokenAuthUsersPagedResponse>
      listTokenAuthUsersPagedCallable;
  private final UnaryCallable<GetTokenAuthUserRequest, TokenAuthUser> getTokenAuthUserCallable;
  private final UnaryCallable<ListAuthTokensRequest, ListAuthTokensResponse> listAuthTokensCallable;
  private final UnaryCallable<ListAuthTokensRequest, ListAuthTokensPagedResponse>
      listAuthTokensPagedCallable;
  private final UnaryCallable<GetAuthTokenRequest, AuthToken> getAuthTokenCallable;
  private final UnaryCallable<AddTokenAuthUserRequest, Operation> addTokenAuthUserCallable;
  private final OperationCallable<AddTokenAuthUserRequest, Instance, OperationMetadata>
      addTokenAuthUserOperationCallable;
  private final UnaryCallable<DeleteTokenAuthUserRequest, Operation> deleteTokenAuthUserCallable;
  private final OperationCallable<DeleteTokenAuthUserRequest, Empty, OperationMetadata>
      deleteTokenAuthUserOperationCallable;
  private final UnaryCallable<AddAuthTokenRequest, Operation> addAuthTokenCallable;
  private final OperationCallable<AddAuthTokenRequest, TokenAuthUser, OperationMetadata>
      addAuthTokenOperationCallable;
  private final UnaryCallable<DeleteAuthTokenRequest, Operation> deleteAuthTokenCallable;
  private final OperationCallable<DeleteAuthTokenRequest, Empty, OperationMetadata>
      deleteAuthTokenOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMemorystoreStub create(MemorystoreStubSettings settings)
      throws IOException {
    return new GrpcMemorystoreStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMemorystoreStub create(ClientContext clientContext) throws IOException {
    return new GrpcMemorystoreStub(MemorystoreStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMemorystoreStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMemorystoreStub(
        MemorystoreStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMemorystoreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMemorystoreStub(MemorystoreStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMemorystoreCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMemorystoreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMemorystoreStub(
      MemorystoreStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        GrpcCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        GrpcCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance.name", String.valueOf(request.getInstance().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetCertificateAuthorityRequest, CertificateAuthority>
        getCertificateAuthorityTransportSettings =
            GrpcCallSettings.<GetCertificateAuthorityRequest, CertificateAuthority>newBuilder()
                .setMethodDescriptor(getCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<
            GetSharedRegionalCertificateAuthorityRequest, SharedRegionalCertificateAuthority>
        getSharedRegionalCertificateAuthorityTransportSettings =
            GrpcCallSettings
                .<GetSharedRegionalCertificateAuthorityRequest, SharedRegionalCertificateAuthority>
                    newBuilder()
                .setMethodDescriptor(getSharedRegionalCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<RescheduleMaintenanceRequest, Operation>
        rescheduleMaintenanceTransportSettings =
            GrpcCallSettings.<RescheduleMaintenanceRequest, Operation>newBuilder()
                .setMethodDescriptor(rescheduleMaintenanceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListBackupCollectionsRequest, ListBackupCollectionsResponse>
        listBackupCollectionsTransportSettings =
            GrpcCallSettings
                .<ListBackupCollectionsRequest, ListBackupCollectionsResponse>newBuilder()
                .setMethodDescriptor(listBackupCollectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetBackupCollectionRequest, BackupCollection>
        getBackupCollectionTransportSettings =
            GrpcCallSettings.<GetBackupCollectionRequest, BackupCollection>newBuilder()
                .setMethodDescriptor(getBackupCollectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsTransportSettings =
        GrpcCallSettings.<ListBackupsRequest, ListBackupsResponse>newBuilder()
            .setMethodDescriptor(listBackupsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetBackupRequest, Backup> getBackupTransportSettings =
        GrpcCallSettings.<GetBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(getBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DeleteBackupRequest, Operation> deleteBackupTransportSettings =
        GrpcCallSettings.<DeleteBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ExportBackupRequest, Operation> exportBackupTransportSettings =
        GrpcCallSettings.<ExportBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(exportBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<BackupInstanceRequest, Operation> backupInstanceTransportSettings =
        GrpcCallSettings.<BackupInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(backupInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<StartMigrationRequest, Operation> startMigrationTransportSettings =
        GrpcCallSettings.<StartMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(startMigrationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<FinishMigrationRequest, Operation> finishMigrationTransportSettings =
        GrpcCallSettings.<FinishMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(finishMigrationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListTokenAuthUsersRequest, ListTokenAuthUsersResponse>
        listTokenAuthUsersTransportSettings =
            GrpcCallSettings.<ListTokenAuthUsersRequest, ListTokenAuthUsersResponse>newBuilder()
                .setMethodDescriptor(listTokenAuthUsersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetTokenAuthUserRequest, TokenAuthUser> getTokenAuthUserTransportSettings =
        GrpcCallSettings.<GetTokenAuthUserRequest, TokenAuthUser>newBuilder()
            .setMethodDescriptor(getTokenAuthUserMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListAuthTokensRequest, ListAuthTokensResponse>
        listAuthTokensTransportSettings =
            GrpcCallSettings.<ListAuthTokensRequest, ListAuthTokensResponse>newBuilder()
                .setMethodDescriptor(listAuthTokensMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAuthTokenRequest, AuthToken> getAuthTokenTransportSettings =
        GrpcCallSettings.<GetAuthTokenRequest, AuthToken>newBuilder()
            .setMethodDescriptor(getAuthTokenMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<AddTokenAuthUserRequest, Operation> addTokenAuthUserTransportSettings =
        GrpcCallSettings.<AddTokenAuthUserRequest, Operation>newBuilder()
            .setMethodDescriptor(addTokenAuthUserMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getInstance())
            .build();
    GrpcCallSettings<DeleteTokenAuthUserRequest, Operation> deleteTokenAuthUserTransportSettings =
        GrpcCallSettings.<DeleteTokenAuthUserRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTokenAuthUserMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<AddAuthTokenRequest, Operation> addAuthTokenTransportSettings =
        GrpcCallSettings.<AddAuthTokenRequest, Operation>newBuilder()
            .setMethodDescriptor(addAuthTokenMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("token_auth_user", String.valueOf(request.getTokenAuthUser()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getTokenAuthUser())
            .build();
    GrpcCallSettings<DeleteAuthTokenRequest, Operation> deleteAuthTokenTransportSettings =
        GrpcCallSettings.<DeleteAuthTokenRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAuthTokenMethodDescriptor)
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

    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.getCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            getCertificateAuthorityTransportSettings,
            settings.getCertificateAuthoritySettings(),
            clientContext);
    this.getSharedRegionalCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            getSharedRegionalCertificateAuthorityTransportSettings,
            settings.getSharedRegionalCertificateAuthoritySettings(),
            clientContext);
    this.rescheduleMaintenanceCallable =
        callableFactory.createUnaryCallable(
            rescheduleMaintenanceTransportSettings,
            settings.rescheduleMaintenanceSettings(),
            clientContext);
    this.rescheduleMaintenanceOperationCallable =
        callableFactory.createOperationCallable(
            rescheduleMaintenanceTransportSettings,
            settings.rescheduleMaintenanceOperationSettings(),
            clientContext,
            operationsStub);
    this.listBackupCollectionsCallable =
        callableFactory.createUnaryCallable(
            listBackupCollectionsTransportSettings,
            settings.listBackupCollectionsSettings(),
            clientContext);
    this.listBackupCollectionsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupCollectionsTransportSettings,
            settings.listBackupCollectionsSettings(),
            clientContext);
    this.getBackupCollectionCallable =
        callableFactory.createUnaryCallable(
            getBackupCollectionTransportSettings,
            settings.getBackupCollectionSettings(),
            clientContext);
    this.listBackupsCallable =
        callableFactory.createUnaryCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.listBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.getBackupCallable =
        callableFactory.createUnaryCallable(
            getBackupTransportSettings, settings.getBackupSettings(), clientContext);
    this.deleteBackupCallable =
        callableFactory.createUnaryCallable(
            deleteBackupTransportSettings, settings.deleteBackupSettings(), clientContext);
    this.deleteBackupOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupTransportSettings,
            settings.deleteBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.exportBackupCallable =
        callableFactory.createUnaryCallable(
            exportBackupTransportSettings, settings.exportBackupSettings(), clientContext);
    this.exportBackupOperationCallable =
        callableFactory.createOperationCallable(
            exportBackupTransportSettings,
            settings.exportBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.backupInstanceCallable =
        callableFactory.createUnaryCallable(
            backupInstanceTransportSettings, settings.backupInstanceSettings(), clientContext);
    this.backupInstanceOperationCallable =
        callableFactory.createOperationCallable(
            backupInstanceTransportSettings,
            settings.backupInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.startMigrationCallable =
        callableFactory.createUnaryCallable(
            startMigrationTransportSettings, settings.startMigrationSettings(), clientContext);
    this.startMigrationOperationCallable =
        callableFactory.createOperationCallable(
            startMigrationTransportSettings,
            settings.startMigrationOperationSettings(),
            clientContext,
            operationsStub);
    this.finishMigrationCallable =
        callableFactory.createUnaryCallable(
            finishMigrationTransportSettings, settings.finishMigrationSettings(), clientContext);
    this.finishMigrationOperationCallable =
        callableFactory.createOperationCallable(
            finishMigrationTransportSettings,
            settings.finishMigrationOperationSettings(),
            clientContext,
            operationsStub);
    this.listTokenAuthUsersCallable =
        callableFactory.createUnaryCallable(
            listTokenAuthUsersTransportSettings,
            settings.listTokenAuthUsersSettings(),
            clientContext);
    this.listTokenAuthUsersPagedCallable =
        callableFactory.createPagedCallable(
            listTokenAuthUsersTransportSettings,
            settings.listTokenAuthUsersSettings(),
            clientContext);
    this.getTokenAuthUserCallable =
        callableFactory.createUnaryCallable(
            getTokenAuthUserTransportSettings, settings.getTokenAuthUserSettings(), clientContext);
    this.listAuthTokensCallable =
        callableFactory.createUnaryCallable(
            listAuthTokensTransportSettings, settings.listAuthTokensSettings(), clientContext);
    this.listAuthTokensPagedCallable =
        callableFactory.createPagedCallable(
            listAuthTokensTransportSettings, settings.listAuthTokensSettings(), clientContext);
    this.getAuthTokenCallable =
        callableFactory.createUnaryCallable(
            getAuthTokenTransportSettings, settings.getAuthTokenSettings(), clientContext);
    this.addTokenAuthUserCallable =
        callableFactory.createUnaryCallable(
            addTokenAuthUserTransportSettings, settings.addTokenAuthUserSettings(), clientContext);
    this.addTokenAuthUserOperationCallable =
        callableFactory.createOperationCallable(
            addTokenAuthUserTransportSettings,
            settings.addTokenAuthUserOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTokenAuthUserCallable =
        callableFactory.createUnaryCallable(
            deleteTokenAuthUserTransportSettings,
            settings.deleteTokenAuthUserSettings(),
            clientContext);
    this.deleteTokenAuthUserOperationCallable =
        callableFactory.createOperationCallable(
            deleteTokenAuthUserTransportSettings,
            settings.deleteTokenAuthUserOperationSettings(),
            clientContext,
            operationsStub);
    this.addAuthTokenCallable =
        callableFactory.createUnaryCallable(
            addAuthTokenTransportSettings, settings.addAuthTokenSettings(), clientContext);
    this.addAuthTokenOperationCallable =
        callableFactory.createOperationCallable(
            addAuthTokenTransportSettings,
            settings.addAuthTokenOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAuthTokenCallable =
        callableFactory.createUnaryCallable(
            deleteAuthTokenTransportSettings, settings.deleteAuthTokenSettings(), clientContext);
    this.deleteAuthTokenOperationCallable =
        callableFactory.createOperationCallable(
            deleteAuthTokenTransportSettings,
            settings.deleteAuthTokenOperationSettings(),
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  @Override
  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthorityCallable() {
    return getCertificateAuthorityCallable;
  }

  @Override
  public UnaryCallable<
          GetSharedRegionalCertificateAuthorityRequest, SharedRegionalCertificateAuthority>
      getSharedRegionalCertificateAuthorityCallable() {
    return getSharedRegionalCertificateAuthorityCallable;
  }

  @Override
  public UnaryCallable<RescheduleMaintenanceRequest, Operation> rescheduleMaintenanceCallable() {
    return rescheduleMaintenanceCallable;
  }

  @Override
  public OperationCallable<RescheduleMaintenanceRequest, Instance, OperationMetadata>
      rescheduleMaintenanceOperationCallable() {
    return rescheduleMaintenanceOperationCallable;
  }

  @Override
  public UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsResponse>
      listBackupCollectionsCallable() {
    return listBackupCollectionsCallable;
  }

  @Override
  public UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsPagedResponse>
      listBackupCollectionsPagedCallable() {
    return listBackupCollectionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackupCollectionRequest, BackupCollection> getBackupCollectionCallable() {
    return getBackupCollectionCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return listBackupsCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> listBackupsPagedCallable() {
    return listBackupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return getBackupCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return deleteBackupCallable;
  }

  @Override
  public OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    return deleteBackupOperationCallable;
  }

  @Override
  public UnaryCallable<ExportBackupRequest, Operation> exportBackupCallable() {
    return exportBackupCallable;
  }

  @Override
  public OperationCallable<ExportBackupRequest, Backup, OperationMetadata>
      exportBackupOperationCallable() {
    return exportBackupOperationCallable;
  }

  @Override
  public UnaryCallable<BackupInstanceRequest, Operation> backupInstanceCallable() {
    return backupInstanceCallable;
  }

  @Override
  public OperationCallable<BackupInstanceRequest, Instance, OperationMetadata>
      backupInstanceOperationCallable() {
    return backupInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<StartMigrationRequest, Operation> startMigrationCallable() {
    return startMigrationCallable;
  }

  @Override
  public OperationCallable<StartMigrationRequest, Instance, OperationMetadata>
      startMigrationOperationCallable() {
    return startMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<FinishMigrationRequest, Operation> finishMigrationCallable() {
    return finishMigrationCallable;
  }

  @Override
  public OperationCallable<FinishMigrationRequest, Instance, OperationMetadata>
      finishMigrationOperationCallable() {
    return finishMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<ListTokenAuthUsersRequest, ListTokenAuthUsersResponse>
      listTokenAuthUsersCallable() {
    return listTokenAuthUsersCallable;
  }

  @Override
  public UnaryCallable<ListTokenAuthUsersRequest, ListTokenAuthUsersPagedResponse>
      listTokenAuthUsersPagedCallable() {
    return listTokenAuthUsersPagedCallable;
  }

  @Override
  public UnaryCallable<GetTokenAuthUserRequest, TokenAuthUser> getTokenAuthUserCallable() {
    return getTokenAuthUserCallable;
  }

  @Override
  public UnaryCallable<ListAuthTokensRequest, ListAuthTokensResponse> listAuthTokensCallable() {
    return listAuthTokensCallable;
  }

  @Override
  public UnaryCallable<ListAuthTokensRequest, ListAuthTokensPagedResponse>
      listAuthTokensPagedCallable() {
    return listAuthTokensPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuthTokenRequest, AuthToken> getAuthTokenCallable() {
    return getAuthTokenCallable;
  }

  @Override
  public UnaryCallable<AddTokenAuthUserRequest, Operation> addTokenAuthUserCallable() {
    return addTokenAuthUserCallable;
  }

  @Override
  public OperationCallable<AddTokenAuthUserRequest, Instance, OperationMetadata>
      addTokenAuthUserOperationCallable() {
    return addTokenAuthUserOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTokenAuthUserRequest, Operation> deleteTokenAuthUserCallable() {
    return deleteTokenAuthUserCallable;
  }

  @Override
  public OperationCallable<DeleteTokenAuthUserRequest, Empty, OperationMetadata>
      deleteTokenAuthUserOperationCallable() {
    return deleteTokenAuthUserOperationCallable;
  }

  @Override
  public UnaryCallable<AddAuthTokenRequest, Operation> addAuthTokenCallable() {
    return addAuthTokenCallable;
  }

  @Override
  public OperationCallable<AddAuthTokenRequest, TokenAuthUser, OperationMetadata>
      addAuthTokenOperationCallable() {
    return addAuthTokenOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAuthTokenRequest, Operation> deleteAuthTokenCallable() {
    return deleteAuthTokenCallable;
  }

  @Override
  public OperationCallable<DeleteAuthTokenRequest, Empty, OperationMetadata>
      deleteAuthTokenOperationCallable() {
    return deleteAuthTokenOperationCallable;
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
