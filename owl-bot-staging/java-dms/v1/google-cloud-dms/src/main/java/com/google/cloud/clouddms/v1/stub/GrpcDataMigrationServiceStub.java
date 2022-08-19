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

package com.google.cloud.clouddms.v1.stub;

import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMigrationJobsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.clouddms.v1.ConnectionProfile;
import com.google.cloud.clouddms.v1.CreateConnectionProfileRequest;
import com.google.cloud.clouddms.v1.CreateMigrationJobRequest;
import com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest;
import com.google.cloud.clouddms.v1.DeleteMigrationJobRequest;
import com.google.cloud.clouddms.v1.GenerateSshScriptRequest;
import com.google.cloud.clouddms.v1.GetConnectionProfileRequest;
import com.google.cloud.clouddms.v1.GetMigrationJobRequest;
import com.google.cloud.clouddms.v1.ListConnectionProfilesRequest;
import com.google.cloud.clouddms.v1.ListConnectionProfilesResponse;
import com.google.cloud.clouddms.v1.ListMigrationJobsRequest;
import com.google.cloud.clouddms.v1.ListMigrationJobsResponse;
import com.google.cloud.clouddms.v1.MigrationJob;
import com.google.cloud.clouddms.v1.OperationMetadata;
import com.google.cloud.clouddms.v1.PromoteMigrationJobRequest;
import com.google.cloud.clouddms.v1.RestartMigrationJobRequest;
import com.google.cloud.clouddms.v1.ResumeMigrationJobRequest;
import com.google.cloud.clouddms.v1.SshScript;
import com.google.cloud.clouddms.v1.StartMigrationJobRequest;
import com.google.cloud.clouddms.v1.StopMigrationJobRequest;
import com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest;
import com.google.cloud.clouddms.v1.UpdateMigrationJobRequest;
import com.google.cloud.clouddms.v1.VerifyMigrationJobRequest;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the DataMigrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataMigrationServiceStub extends DataMigrationServiceStub {
  private static final MethodDescriptor<ListMigrationJobsRequest, ListMigrationJobsResponse>
      listMigrationJobsMethodDescriptor =
          MethodDescriptor.<ListMigrationJobsRequest, ListMigrationJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/ListMigrationJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMigrationJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMigrationJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMigrationJobRequest, MigrationJob>
      getMigrationJobMethodDescriptor =
          MethodDescriptor.<GetMigrationJobRequest, MigrationJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/GetMigrationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMigrationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MigrationJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMigrationJobRequest, Operation>
      createMigrationJobMethodDescriptor =
          MethodDescriptor.<CreateMigrationJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/CreateMigrationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMigrationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateMigrationJobRequest, Operation>
      updateMigrationJobMethodDescriptor =
          MethodDescriptor.<UpdateMigrationJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/UpdateMigrationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMigrationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMigrationJobRequest, Operation>
      deleteMigrationJobMethodDescriptor =
          MethodDescriptor.<DeleteMigrationJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/DeleteMigrationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMigrationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartMigrationJobRequest, Operation>
      startMigrationJobMethodDescriptor =
          MethodDescriptor.<StartMigrationJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/StartMigrationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartMigrationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopMigrationJobRequest, Operation>
      stopMigrationJobMethodDescriptor =
          MethodDescriptor.<StopMigrationJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/StopMigrationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StopMigrationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResumeMigrationJobRequest, Operation>
      resumeMigrationJobMethodDescriptor =
          MethodDescriptor.<ResumeMigrationJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/ResumeMigrationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResumeMigrationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PromoteMigrationJobRequest, Operation>
      promoteMigrationJobMethodDescriptor =
          MethodDescriptor.<PromoteMigrationJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/PromoteMigrationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PromoteMigrationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<VerifyMigrationJobRequest, Operation>
      verifyMigrationJobMethodDescriptor =
          MethodDescriptor.<VerifyMigrationJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/VerifyMigrationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(VerifyMigrationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RestartMigrationJobRequest, Operation>
      restartMigrationJobMethodDescriptor =
          MethodDescriptor.<RestartMigrationJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/RestartMigrationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestartMigrationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateSshScriptRequest, SshScript>
      generateSshScriptMethodDescriptor =
          MethodDescriptor.<GenerateSshScriptRequest, SshScript>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/GenerateSshScript")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateSshScriptRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SshScript.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesMethodDescriptor =
          MethodDescriptor
              .<ListConnectionProfilesRequest, ListConnectionProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/ListConnectionProfiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConnectionProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConnectionProfilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileMethodDescriptor =
          MethodDescriptor.<GetConnectionProfileRequest, ConnectionProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/GetConnectionProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConnectionProfile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConnectionProfileRequest, Operation>
      createConnectionProfileMethodDescriptor =
          MethodDescriptor.<CreateConnectionProfileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/CreateConnectionProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileMethodDescriptor =
          MethodDescriptor.<UpdateConnectionProfileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/UpdateConnectionProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileMethodDescriptor =
          MethodDescriptor.<DeleteConnectionProfileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/DeleteConnectionProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListMigrationJobsRequest, ListMigrationJobsResponse>
      listMigrationJobsCallable;
  private final UnaryCallable<ListMigrationJobsRequest, ListMigrationJobsPagedResponse>
      listMigrationJobsPagedCallable;
  private final UnaryCallable<GetMigrationJobRequest, MigrationJob> getMigrationJobCallable;
  private final UnaryCallable<CreateMigrationJobRequest, Operation> createMigrationJobCallable;
  private final OperationCallable<CreateMigrationJobRequest, MigrationJob, OperationMetadata>
      createMigrationJobOperationCallable;
  private final UnaryCallable<UpdateMigrationJobRequest, Operation> updateMigrationJobCallable;
  private final OperationCallable<UpdateMigrationJobRequest, MigrationJob, OperationMetadata>
      updateMigrationJobOperationCallable;
  private final UnaryCallable<DeleteMigrationJobRequest, Operation> deleteMigrationJobCallable;
  private final OperationCallable<DeleteMigrationJobRequest, Empty, OperationMetadata>
      deleteMigrationJobOperationCallable;
  private final UnaryCallable<StartMigrationJobRequest, Operation> startMigrationJobCallable;
  private final OperationCallable<StartMigrationJobRequest, MigrationJob, OperationMetadata>
      startMigrationJobOperationCallable;
  private final UnaryCallable<StopMigrationJobRequest, Operation> stopMigrationJobCallable;
  private final OperationCallable<StopMigrationJobRequest, MigrationJob, OperationMetadata>
      stopMigrationJobOperationCallable;
  private final UnaryCallable<ResumeMigrationJobRequest, Operation> resumeMigrationJobCallable;
  private final OperationCallable<ResumeMigrationJobRequest, MigrationJob, OperationMetadata>
      resumeMigrationJobOperationCallable;
  private final UnaryCallable<PromoteMigrationJobRequest, Operation> promoteMigrationJobCallable;
  private final OperationCallable<PromoteMigrationJobRequest, MigrationJob, OperationMetadata>
      promoteMigrationJobOperationCallable;
  private final UnaryCallable<VerifyMigrationJobRequest, Operation> verifyMigrationJobCallable;
  private final OperationCallable<VerifyMigrationJobRequest, MigrationJob, OperationMetadata>
      verifyMigrationJobOperationCallable;
  private final UnaryCallable<RestartMigrationJobRequest, Operation> restartMigrationJobCallable;
  private final OperationCallable<RestartMigrationJobRequest, MigrationJob, OperationMetadata>
      restartMigrationJobOperationCallable;
  private final UnaryCallable<GenerateSshScriptRequest, SshScript> generateSshScriptCallable;
  private final UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesCallable;
  private final UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesPagedResponse>
      listConnectionProfilesPagedCallable;
  private final UnaryCallable<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileCallable;
  private final UnaryCallable<CreateConnectionProfileRequest, Operation>
      createConnectionProfileCallable;
  private final OperationCallable<
          CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationCallable;
  private final UnaryCallable<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileCallable;
  private final OperationCallable<
          UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationCallable;
  private final UnaryCallable<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileCallable;
  private final OperationCallable<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataMigrationServiceStub create(DataMigrationServiceStubSettings settings)
      throws IOException {
    return new GrpcDataMigrationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataMigrationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataMigrationServiceStub(
        DataMigrationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataMigrationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataMigrationServiceStub(
        DataMigrationServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataMigrationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataMigrationServiceStub(
      DataMigrationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataMigrationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataMigrationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataMigrationServiceStub(
      DataMigrationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListMigrationJobsRequest, ListMigrationJobsResponse>
        listMigrationJobsTransportSettings =
            GrpcCallSettings.<ListMigrationJobsRequest, ListMigrationJobsResponse>newBuilder()
                .setMethodDescriptor(listMigrationJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetMigrationJobRequest, MigrationJob> getMigrationJobTransportSettings =
        GrpcCallSettings.<GetMigrationJobRequest, MigrationJob>newBuilder()
            .setMethodDescriptor(getMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateMigrationJobRequest, Operation> createMigrationJobTransportSettings =
        GrpcCallSettings.<CreateMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(createMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateMigrationJobRequest, Operation> updateMigrationJobTransportSettings =
        GrpcCallSettings.<UpdateMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "migration_job.name", String.valueOf(request.getMigrationJob().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteMigrationJobRequest, Operation> deleteMigrationJobTransportSettings =
        GrpcCallSettings.<DeleteMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StartMigrationJobRequest, Operation> startMigrationJobTransportSettings =
        GrpcCallSettings.<StartMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(startMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StopMigrationJobRequest, Operation> stopMigrationJobTransportSettings =
        GrpcCallSettings.<StopMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(stopMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ResumeMigrationJobRequest, Operation> resumeMigrationJobTransportSettings =
        GrpcCallSettings.<ResumeMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<PromoteMigrationJobRequest, Operation> promoteMigrationJobTransportSettings =
        GrpcCallSettings.<PromoteMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(promoteMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<VerifyMigrationJobRequest, Operation> verifyMigrationJobTransportSettings =
        GrpcCallSettings.<VerifyMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(verifyMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RestartMigrationJobRequest, Operation> restartMigrationJobTransportSettings =
        GrpcCallSettings.<RestartMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(restartMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GenerateSshScriptRequest, SshScript> generateSshScriptTransportSettings =
        GrpcCallSettings.<GenerateSshScriptRequest, SshScript>newBuilder()
            .setMethodDescriptor(generateSshScriptMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("migration_job", String.valueOf(request.getMigrationJob()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
        listConnectionProfilesTransportSettings =
            GrpcCallSettings
                .<ListConnectionProfilesRequest, ListConnectionProfilesResponse>newBuilder()
                .setMethodDescriptor(listConnectionProfilesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetConnectionProfileRequest, ConnectionProfile>
        getConnectionProfileTransportSettings =
            GrpcCallSettings.<GetConnectionProfileRequest, ConnectionProfile>newBuilder()
                .setMethodDescriptor(getConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateConnectionProfileRequest, Operation>
        createConnectionProfileTransportSettings =
            GrpcCallSettings.<CreateConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(createConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateConnectionProfileRequest, Operation>
        updateConnectionProfileTransportSettings =
            GrpcCallSettings.<UpdateConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "connection_profile.name",
                          String.valueOf(request.getConnectionProfile().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteConnectionProfileRequest, Operation>
        deleteConnectionProfileTransportSettings =
            GrpcCallSettings.<DeleteConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.listMigrationJobsCallable =
        callableFactory.createUnaryCallable(
            listMigrationJobsTransportSettings,
            settings.listMigrationJobsSettings(),
            clientContext);
    this.listMigrationJobsPagedCallable =
        callableFactory.createPagedCallable(
            listMigrationJobsTransportSettings,
            settings.listMigrationJobsSettings(),
            clientContext);
    this.getMigrationJobCallable =
        callableFactory.createUnaryCallable(
            getMigrationJobTransportSettings, settings.getMigrationJobSettings(), clientContext);
    this.createMigrationJobCallable =
        callableFactory.createUnaryCallable(
            createMigrationJobTransportSettings,
            settings.createMigrationJobSettings(),
            clientContext);
    this.createMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            createMigrationJobTransportSettings,
            settings.createMigrationJobOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMigrationJobCallable =
        callableFactory.createUnaryCallable(
            updateMigrationJobTransportSettings,
            settings.updateMigrationJobSettings(),
            clientContext);
    this.updateMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            updateMigrationJobTransportSettings,
            settings.updateMigrationJobOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMigrationJobCallable =
        callableFactory.createUnaryCallable(
            deleteMigrationJobTransportSettings,
            settings.deleteMigrationJobSettings(),
            clientContext);
    this.deleteMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteMigrationJobTransportSettings,
            settings.deleteMigrationJobOperationSettings(),
            clientContext,
            operationsStub);
    this.startMigrationJobCallable =
        callableFactory.createUnaryCallable(
            startMigrationJobTransportSettings,
            settings.startMigrationJobSettings(),
            clientContext);
    this.startMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            startMigrationJobTransportSettings,
            settings.startMigrationJobOperationSettings(),
            clientContext,
            operationsStub);
    this.stopMigrationJobCallable =
        callableFactory.createUnaryCallable(
            stopMigrationJobTransportSettings, settings.stopMigrationJobSettings(), clientContext);
    this.stopMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            stopMigrationJobTransportSettings,
            settings.stopMigrationJobOperationSettings(),
            clientContext,
            operationsStub);
    this.resumeMigrationJobCallable =
        callableFactory.createUnaryCallable(
            resumeMigrationJobTransportSettings,
            settings.resumeMigrationJobSettings(),
            clientContext);
    this.resumeMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            resumeMigrationJobTransportSettings,
            settings.resumeMigrationJobOperationSettings(),
            clientContext,
            operationsStub);
    this.promoteMigrationJobCallable =
        callableFactory.createUnaryCallable(
            promoteMigrationJobTransportSettings,
            settings.promoteMigrationJobSettings(),
            clientContext);
    this.promoteMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            promoteMigrationJobTransportSettings,
            settings.promoteMigrationJobOperationSettings(),
            clientContext,
            operationsStub);
    this.verifyMigrationJobCallable =
        callableFactory.createUnaryCallable(
            verifyMigrationJobTransportSettings,
            settings.verifyMigrationJobSettings(),
            clientContext);
    this.verifyMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            verifyMigrationJobTransportSettings,
            settings.verifyMigrationJobOperationSettings(),
            clientContext,
            operationsStub);
    this.restartMigrationJobCallable =
        callableFactory.createUnaryCallable(
            restartMigrationJobTransportSettings,
            settings.restartMigrationJobSettings(),
            clientContext);
    this.restartMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            restartMigrationJobTransportSettings,
            settings.restartMigrationJobOperationSettings(),
            clientContext,
            operationsStub);
    this.generateSshScriptCallable =
        callableFactory.createUnaryCallable(
            generateSshScriptTransportSettings,
            settings.generateSshScriptSettings(),
            clientContext);
    this.listConnectionProfilesCallable =
        callableFactory.createUnaryCallable(
            listConnectionProfilesTransportSettings,
            settings.listConnectionProfilesSettings(),
            clientContext);
    this.listConnectionProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listConnectionProfilesTransportSettings,
            settings.listConnectionProfilesSettings(),
            clientContext);
    this.getConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            getConnectionProfileTransportSettings,
            settings.getConnectionProfileSettings(),
            clientContext);
    this.createConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            createConnectionProfileTransportSettings,
            settings.createConnectionProfileSettings(),
            clientContext);
    this.createConnectionProfileOperationCallable =
        callableFactory.createOperationCallable(
            createConnectionProfileTransportSettings,
            settings.createConnectionProfileOperationSettings(),
            clientContext,
            operationsStub);
    this.updateConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            updateConnectionProfileTransportSettings,
            settings.updateConnectionProfileSettings(),
            clientContext);
    this.updateConnectionProfileOperationCallable =
        callableFactory.createOperationCallable(
            updateConnectionProfileTransportSettings,
            settings.updateConnectionProfileOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            deleteConnectionProfileTransportSettings,
            settings.deleteConnectionProfileSettings(),
            clientContext);
    this.deleteConnectionProfileOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectionProfileTransportSettings,
            settings.deleteConnectionProfileOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListMigrationJobsRequest, ListMigrationJobsResponse>
      listMigrationJobsCallable() {
    return listMigrationJobsCallable;
  }

  @Override
  public UnaryCallable<ListMigrationJobsRequest, ListMigrationJobsPagedResponse>
      listMigrationJobsPagedCallable() {
    return listMigrationJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMigrationJobRequest, MigrationJob> getMigrationJobCallable() {
    return getMigrationJobCallable;
  }

  @Override
  public UnaryCallable<CreateMigrationJobRequest, Operation> createMigrationJobCallable() {
    return createMigrationJobCallable;
  }

  @Override
  public OperationCallable<CreateMigrationJobRequest, MigrationJob, OperationMetadata>
      createMigrationJobOperationCallable() {
    return createMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMigrationJobRequest, Operation> updateMigrationJobCallable() {
    return updateMigrationJobCallable;
  }

  @Override
  public OperationCallable<UpdateMigrationJobRequest, MigrationJob, OperationMetadata>
      updateMigrationJobOperationCallable() {
    return updateMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMigrationJobRequest, Operation> deleteMigrationJobCallable() {
    return deleteMigrationJobCallable;
  }

  @Override
  public OperationCallable<DeleteMigrationJobRequest, Empty, OperationMetadata>
      deleteMigrationJobOperationCallable() {
    return deleteMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<StartMigrationJobRequest, Operation> startMigrationJobCallable() {
    return startMigrationJobCallable;
  }

  @Override
  public OperationCallable<StartMigrationJobRequest, MigrationJob, OperationMetadata>
      startMigrationJobOperationCallable() {
    return startMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<StopMigrationJobRequest, Operation> stopMigrationJobCallable() {
    return stopMigrationJobCallable;
  }

  @Override
  public OperationCallable<StopMigrationJobRequest, MigrationJob, OperationMetadata>
      stopMigrationJobOperationCallable() {
    return stopMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<ResumeMigrationJobRequest, Operation> resumeMigrationJobCallable() {
    return resumeMigrationJobCallable;
  }

  @Override
  public OperationCallable<ResumeMigrationJobRequest, MigrationJob, OperationMetadata>
      resumeMigrationJobOperationCallable() {
    return resumeMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<PromoteMigrationJobRequest, Operation> promoteMigrationJobCallable() {
    return promoteMigrationJobCallable;
  }

  @Override
  public OperationCallable<PromoteMigrationJobRequest, MigrationJob, OperationMetadata>
      promoteMigrationJobOperationCallable() {
    return promoteMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<VerifyMigrationJobRequest, Operation> verifyMigrationJobCallable() {
    return verifyMigrationJobCallable;
  }

  @Override
  public OperationCallable<VerifyMigrationJobRequest, MigrationJob, OperationMetadata>
      verifyMigrationJobOperationCallable() {
    return verifyMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<RestartMigrationJobRequest, Operation> restartMigrationJobCallable() {
    return restartMigrationJobCallable;
  }

  @Override
  public OperationCallable<RestartMigrationJobRequest, MigrationJob, OperationMetadata>
      restartMigrationJobOperationCallable() {
    return restartMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateSshScriptRequest, SshScript> generateSshScriptCallable() {
    return generateSshScriptCallable;
  }

  @Override
  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesCallable() {
    return listConnectionProfilesCallable;
  }

  @Override
  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesPagedResponse>
      listConnectionProfilesPagedCallable() {
    return listConnectionProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileCallable() {
    return getConnectionProfileCallable;
  }

  @Override
  public UnaryCallable<CreateConnectionProfileRequest, Operation>
      createConnectionProfileCallable() {
    return createConnectionProfileCallable;
  }

  @Override
  public OperationCallable<CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationCallable() {
    return createConnectionProfileOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileCallable() {
    return updateConnectionProfileCallable;
  }

  @Override
  public OperationCallable<UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationCallable() {
    return updateConnectionProfileOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileCallable() {
    return deleteConnectionProfileCallable;
  }

  @Override
  public OperationCallable<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationCallable() {
    return deleteConnectionProfileOperationCallable;
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
