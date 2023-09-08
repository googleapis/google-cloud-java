/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.DescribeDatabaseEntitiesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.FetchStaticIpsPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConversionWorkspacesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMappingRulesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMigrationJobsPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListPrivateConnectionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.ConnectionProfile;
import com.google.cloud.clouddms.v1.ConversionWorkspace;
import com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.CreateConnectionProfileRequest;
import com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.CreateMappingRuleRequest;
import com.google.cloud.clouddms.v1.CreateMigrationJobRequest;
import com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest;
import com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest;
import com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.DeleteMappingRuleRequest;
import com.google.cloud.clouddms.v1.DeleteMigrationJobRequest;
import com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest;
import com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest;
import com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse;
import com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest;
import com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse;
import com.google.cloud.clouddms.v1.FetchStaticIpsRequest;
import com.google.cloud.clouddms.v1.FetchStaticIpsResponse;
import com.google.cloud.clouddms.v1.GenerateSshScriptRequest;
import com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest;
import com.google.cloud.clouddms.v1.GetConnectionProfileRequest;
import com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.GetMappingRuleRequest;
import com.google.cloud.clouddms.v1.GetMigrationJobRequest;
import com.google.cloud.clouddms.v1.GetPrivateConnectionRequest;
import com.google.cloud.clouddms.v1.ImportMappingRulesRequest;
import com.google.cloud.clouddms.v1.ListConnectionProfilesRequest;
import com.google.cloud.clouddms.v1.ListConnectionProfilesResponse;
import com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest;
import com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse;
import com.google.cloud.clouddms.v1.ListMappingRulesRequest;
import com.google.cloud.clouddms.v1.ListMappingRulesResponse;
import com.google.cloud.clouddms.v1.ListMigrationJobsRequest;
import com.google.cloud.clouddms.v1.ListMigrationJobsResponse;
import com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest;
import com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse;
import com.google.cloud.clouddms.v1.MappingRule;
import com.google.cloud.clouddms.v1.MigrationJob;
import com.google.cloud.clouddms.v1.OperationMetadata;
import com.google.cloud.clouddms.v1.PrivateConnection;
import com.google.cloud.clouddms.v1.PromoteMigrationJobRequest;
import com.google.cloud.clouddms.v1.RestartMigrationJobRequest;
import com.google.cloud.clouddms.v1.ResumeMigrationJobRequest;
import com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest;
import com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse;
import com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.SshScript;
import com.google.cloud.clouddms.v1.StartMigrationJobRequest;
import com.google.cloud.clouddms.v1.StopMigrationJobRequest;
import com.google.cloud.clouddms.v1.TcpProxyScript;
import com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest;
import com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.UpdateMigrationJobRequest;
import com.google.cloud.clouddms.v1.VerifyMigrationJobRequest;
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

  private static final MethodDescriptor<GenerateTcpProxyScriptRequest, TcpProxyScript>
      generateTcpProxyScriptMethodDescriptor =
          MethodDescriptor.<GenerateTcpProxyScriptRequest, TcpProxyScript>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/GenerateTcpProxyScript")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateTcpProxyScriptRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TcpProxyScript.getDefaultInstance()))
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

  private static final MethodDescriptor<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionMethodDescriptor =
          MethodDescriptor.<CreatePrivateConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/CreatePrivateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionMethodDescriptor =
          MethodDescriptor.<GetPrivateConnectionRequest, PrivateConnection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/GetPrivateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PrivateConnection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsMethodDescriptor =
          MethodDescriptor
              .<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/ListPrivateConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPrivateConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPrivateConnectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionMethodDescriptor =
          MethodDescriptor.<DeletePrivateConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/DeletePrivateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConversionWorkspaceRequest, ConversionWorkspace>
      getConversionWorkspaceMethodDescriptor =
          MethodDescriptor.<GetConversionWorkspaceRequest, ConversionWorkspace>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/GetConversionWorkspace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversionWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConversionWorkspace.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListConversionWorkspacesRequest, ListConversionWorkspacesResponse>
      listConversionWorkspacesMethodDescriptor =
          MethodDescriptor
              .<ListConversionWorkspacesRequest, ListConversionWorkspacesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/ListConversionWorkspaces")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversionWorkspacesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversionWorkspacesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConversionWorkspaceRequest, Operation>
      createConversionWorkspaceMethodDescriptor =
          MethodDescriptor.<CreateConversionWorkspaceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/CreateConversionWorkspace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConversionWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConversionWorkspaceRequest, Operation>
      updateConversionWorkspaceMethodDescriptor =
          MethodDescriptor.<UpdateConversionWorkspaceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/UpdateConversionWorkspace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConversionWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConversionWorkspaceRequest, Operation>
      deleteConversionWorkspaceMethodDescriptor =
          MethodDescriptor.<DeleteConversionWorkspaceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/DeleteConversionWorkspace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConversionWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMappingRuleRequest, MappingRule>
      createMappingRuleMethodDescriptor =
          MethodDescriptor.<CreateMappingRuleRequest, MappingRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/CreateMappingRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMappingRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MappingRule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMappingRuleRequest, Empty>
      deleteMappingRuleMethodDescriptor =
          MethodDescriptor.<DeleteMappingRuleRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/DeleteMappingRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMappingRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMappingRulesRequest, ListMappingRulesResponse>
      listMappingRulesMethodDescriptor =
          MethodDescriptor.<ListMappingRulesRequest, ListMappingRulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/ListMappingRules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMappingRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMappingRulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMappingRuleRequest, MappingRule>
      getMappingRuleMethodDescriptor =
          MethodDescriptor.<GetMappingRuleRequest, MappingRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/GetMappingRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMappingRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MappingRule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SeedConversionWorkspaceRequest, Operation>
      seedConversionWorkspaceMethodDescriptor =
          MethodDescriptor.<SeedConversionWorkspaceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/SeedConversionWorkspace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SeedConversionWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportMappingRulesRequest, Operation>
      importMappingRulesMethodDescriptor =
          MethodDescriptor.<ImportMappingRulesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/ImportMappingRules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportMappingRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ConvertConversionWorkspaceRequest, Operation>
      convertConversionWorkspaceMethodDescriptor =
          MethodDescriptor.<ConvertConversionWorkspaceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/ConvertConversionWorkspace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ConvertConversionWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CommitConversionWorkspaceRequest, Operation>
      commitConversionWorkspaceMethodDescriptor =
          MethodDescriptor.<CommitConversionWorkspaceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/CommitConversionWorkspace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CommitConversionWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RollbackConversionWorkspaceRequest, Operation>
      rollbackConversionWorkspaceMethodDescriptor =
          MethodDescriptor.<RollbackConversionWorkspaceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/RollbackConversionWorkspace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RollbackConversionWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ApplyConversionWorkspaceRequest, Operation>
      applyConversionWorkspaceMethodDescriptor =
          MethodDescriptor.<ApplyConversionWorkspaceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/ApplyConversionWorkspace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ApplyConversionWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesResponse>
      describeDatabaseEntitiesMethodDescriptor =
          MethodDescriptor
              .<DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/DescribeDatabaseEntities")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DescribeDatabaseEntitiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DescribeDatabaseEntitiesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>
      searchBackgroundJobsMethodDescriptor =
          MethodDescriptor.<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/SearchBackgroundJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchBackgroundJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchBackgroundJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          DescribeConversionWorkspaceRevisionsRequest, DescribeConversionWorkspaceRevisionsResponse>
      describeConversionWorkspaceRevisionsMethodDescriptor =
          MethodDescriptor
              .<DescribeConversionWorkspaceRevisionsRequest,
                  DescribeConversionWorkspaceRevisionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.clouddms.v1.DataMigrationService/DescribeConversionWorkspaceRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DescribeConversionWorkspaceRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      DescribeConversionWorkspaceRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchStaticIpsRequest, FetchStaticIpsResponse>
      fetchStaticIpsMethodDescriptor =
          MethodDescriptor.<FetchStaticIpsRequest, FetchStaticIpsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.clouddms.v1.DataMigrationService/FetchStaticIps")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchStaticIpsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchStaticIpsResponse.getDefaultInstance()))
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
  private final UnaryCallable<GenerateTcpProxyScriptRequest, TcpProxyScript>
      generateTcpProxyScriptCallable;
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
  private final UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable;
  private final OperationCallable<
          CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable;
  private final UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable;
  private final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable;
  private final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable;
  private final UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable;
  private final OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable;
  private final UnaryCallable<GetConversionWorkspaceRequest, ConversionWorkspace>
      getConversionWorkspaceCallable;
  private final UnaryCallable<ListConversionWorkspacesRequest, ListConversionWorkspacesResponse>
      listConversionWorkspacesCallable;
  private final UnaryCallable<
          ListConversionWorkspacesRequest, ListConversionWorkspacesPagedResponse>
      listConversionWorkspacesPagedCallable;
  private final UnaryCallable<CreateConversionWorkspaceRequest, Operation>
      createConversionWorkspaceCallable;
  private final OperationCallable<
          CreateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      createConversionWorkspaceOperationCallable;
  private final UnaryCallable<UpdateConversionWorkspaceRequest, Operation>
      updateConversionWorkspaceCallable;
  private final OperationCallable<
          UpdateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      updateConversionWorkspaceOperationCallable;
  private final UnaryCallable<DeleteConversionWorkspaceRequest, Operation>
      deleteConversionWorkspaceCallable;
  private final OperationCallable<DeleteConversionWorkspaceRequest, Empty, OperationMetadata>
      deleteConversionWorkspaceOperationCallable;
  private final UnaryCallable<CreateMappingRuleRequest, MappingRule> createMappingRuleCallable;
  private final UnaryCallable<DeleteMappingRuleRequest, Empty> deleteMappingRuleCallable;
  private final UnaryCallable<ListMappingRulesRequest, ListMappingRulesResponse>
      listMappingRulesCallable;
  private final UnaryCallable<ListMappingRulesRequest, ListMappingRulesPagedResponse>
      listMappingRulesPagedCallable;
  private final UnaryCallable<GetMappingRuleRequest, MappingRule> getMappingRuleCallable;
  private final UnaryCallable<SeedConversionWorkspaceRequest, Operation>
      seedConversionWorkspaceCallable;
  private final OperationCallable<
          SeedConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      seedConversionWorkspaceOperationCallable;
  private final UnaryCallable<ImportMappingRulesRequest, Operation> importMappingRulesCallable;
  private final OperationCallable<ImportMappingRulesRequest, ConversionWorkspace, OperationMetadata>
      importMappingRulesOperationCallable;
  private final UnaryCallable<ConvertConversionWorkspaceRequest, Operation>
      convertConversionWorkspaceCallable;
  private final OperationCallable<
          ConvertConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      convertConversionWorkspaceOperationCallable;
  private final UnaryCallable<CommitConversionWorkspaceRequest, Operation>
      commitConversionWorkspaceCallable;
  private final OperationCallable<
          CommitConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      commitConversionWorkspaceOperationCallable;
  private final UnaryCallable<RollbackConversionWorkspaceRequest, Operation>
      rollbackConversionWorkspaceCallable;
  private final OperationCallable<
          RollbackConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      rollbackConversionWorkspaceOperationCallable;
  private final UnaryCallable<ApplyConversionWorkspaceRequest, Operation>
      applyConversionWorkspaceCallable;
  private final OperationCallable<
          ApplyConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      applyConversionWorkspaceOperationCallable;
  private final UnaryCallable<DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesResponse>
      describeDatabaseEntitiesCallable;
  private final UnaryCallable<
          DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesPagedResponse>
      describeDatabaseEntitiesPagedCallable;
  private final UnaryCallable<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>
      searchBackgroundJobsCallable;
  private final UnaryCallable<
          DescribeConversionWorkspaceRevisionsRequest, DescribeConversionWorkspaceRevisionsResponse>
      describeConversionWorkspaceRevisionsCallable;
  private final UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsResponse> fetchStaticIpsCallable;
  private final UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsPagedResponse>
      fetchStaticIpsPagedCallable;

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
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMigrationJobRequest, MigrationJob> getMigrationJobTransportSettings =
        GrpcCallSettings.<GetMigrationJobRequest, MigrationJob>newBuilder()
            .setMethodDescriptor(getMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateMigrationJobRequest, Operation> createMigrationJobTransportSettings =
        GrpcCallSettings.<CreateMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(createMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateMigrationJobRequest, Operation> updateMigrationJobTransportSettings =
        GrpcCallSettings.<UpdateMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "migration_job.name", String.valueOf(request.getMigrationJob().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMigrationJobRequest, Operation> deleteMigrationJobTransportSettings =
        GrpcCallSettings.<DeleteMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<StartMigrationJobRequest, Operation> startMigrationJobTransportSettings =
        GrpcCallSettings.<StartMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(startMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<StopMigrationJobRequest, Operation> stopMigrationJobTransportSettings =
        GrpcCallSettings.<StopMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(stopMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResumeMigrationJobRequest, Operation> resumeMigrationJobTransportSettings =
        GrpcCallSettings.<ResumeMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PromoteMigrationJobRequest, Operation> promoteMigrationJobTransportSettings =
        GrpcCallSettings.<PromoteMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(promoteMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<VerifyMigrationJobRequest, Operation> verifyMigrationJobTransportSettings =
        GrpcCallSettings.<VerifyMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(verifyMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RestartMigrationJobRequest, Operation> restartMigrationJobTransportSettings =
        GrpcCallSettings.<RestartMigrationJobRequest, Operation>newBuilder()
            .setMethodDescriptor(restartMigrationJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GenerateSshScriptRequest, SshScript> generateSshScriptTransportSettings =
        GrpcCallSettings.<GenerateSshScriptRequest, SshScript>newBuilder()
            .setMethodDescriptor(generateSshScriptMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("migration_job", String.valueOf(request.getMigrationJob()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GenerateTcpProxyScriptRequest, TcpProxyScript>
        generateTcpProxyScriptTransportSettings =
            GrpcCallSettings.<GenerateTcpProxyScriptRequest, TcpProxyScript>newBuilder()
                .setMethodDescriptor(generateTcpProxyScriptMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("migration_job", String.valueOf(request.getMigrationJob()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
        listConnectionProfilesTransportSettings =
            GrpcCallSettings
                .<ListConnectionProfilesRequest, ListConnectionProfilesResponse>newBuilder()
                .setMethodDescriptor(listConnectionProfilesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConnectionProfileRequest, ConnectionProfile>
        getConnectionProfileTransportSettings =
            GrpcCallSettings.<GetConnectionProfileRequest, ConnectionProfile>newBuilder()
                .setMethodDescriptor(getConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateConnectionProfileRequest, Operation>
        createConnectionProfileTransportSettings =
            GrpcCallSettings.<CreateConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(createConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateConnectionProfileRequest, Operation>
        updateConnectionProfileTransportSettings =
            GrpcCallSettings.<UpdateConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "connection_profile.name",
                          String.valueOf(request.getConnectionProfile().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteConnectionProfileRequest, Operation>
        deleteConnectionProfileTransportSettings =
            GrpcCallSettings.<DeleteConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionTransportSettings =
            GrpcCallSettings.<CreatePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(createPrivateConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionTransportSettings =
            GrpcCallSettings.<GetPrivateConnectionRequest, PrivateConnection>newBuilder()
                .setMethodDescriptor(getPrivateConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
        listPrivateConnectionsTransportSettings =
            GrpcCallSettings
                .<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>newBuilder()
                .setMethodDescriptor(listPrivateConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionTransportSettings =
            GrpcCallSettings.<DeletePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePrivateConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConversionWorkspaceRequest, ConversionWorkspace>
        getConversionWorkspaceTransportSettings =
            GrpcCallSettings.<GetConversionWorkspaceRequest, ConversionWorkspace>newBuilder()
                .setMethodDescriptor(getConversionWorkspaceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListConversionWorkspacesRequest, ListConversionWorkspacesResponse>
        listConversionWorkspacesTransportSettings =
            GrpcCallSettings
                .<ListConversionWorkspacesRequest, ListConversionWorkspacesResponse>newBuilder()
                .setMethodDescriptor(listConversionWorkspacesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateConversionWorkspaceRequest, Operation>
        createConversionWorkspaceTransportSettings =
            GrpcCallSettings.<CreateConversionWorkspaceRequest, Operation>newBuilder()
                .setMethodDescriptor(createConversionWorkspaceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateConversionWorkspaceRequest, Operation>
        updateConversionWorkspaceTransportSettings =
            GrpcCallSettings.<UpdateConversionWorkspaceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConversionWorkspaceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "conversion_workspace.name",
                          String.valueOf(request.getConversionWorkspace().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteConversionWorkspaceRequest, Operation>
        deleteConversionWorkspaceTransportSettings =
            GrpcCallSettings.<DeleteConversionWorkspaceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConversionWorkspaceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateMappingRuleRequest, MappingRule> createMappingRuleTransportSettings =
        GrpcCallSettings.<CreateMappingRuleRequest, MappingRule>newBuilder()
            .setMethodDescriptor(createMappingRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMappingRuleRequest, Empty> deleteMappingRuleTransportSettings =
        GrpcCallSettings.<DeleteMappingRuleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMappingRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListMappingRulesRequest, ListMappingRulesResponse>
        listMappingRulesTransportSettings =
            GrpcCallSettings.<ListMappingRulesRequest, ListMappingRulesResponse>newBuilder()
                .setMethodDescriptor(listMappingRulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMappingRuleRequest, MappingRule> getMappingRuleTransportSettings =
        GrpcCallSettings.<GetMappingRuleRequest, MappingRule>newBuilder()
            .setMethodDescriptor(getMappingRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SeedConversionWorkspaceRequest, Operation>
        seedConversionWorkspaceTransportSettings =
            GrpcCallSettings.<SeedConversionWorkspaceRequest, Operation>newBuilder()
                .setMethodDescriptor(seedConversionWorkspaceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ImportMappingRulesRequest, Operation> importMappingRulesTransportSettings =
        GrpcCallSettings.<ImportMappingRulesRequest, Operation>newBuilder()
            .setMethodDescriptor(importMappingRulesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ConvertConversionWorkspaceRequest, Operation>
        convertConversionWorkspaceTransportSettings =
            GrpcCallSettings.<ConvertConversionWorkspaceRequest, Operation>newBuilder()
                .setMethodDescriptor(convertConversionWorkspaceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CommitConversionWorkspaceRequest, Operation>
        commitConversionWorkspaceTransportSettings =
            GrpcCallSettings.<CommitConversionWorkspaceRequest, Operation>newBuilder()
                .setMethodDescriptor(commitConversionWorkspaceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RollbackConversionWorkspaceRequest, Operation>
        rollbackConversionWorkspaceTransportSettings =
            GrpcCallSettings.<RollbackConversionWorkspaceRequest, Operation>newBuilder()
                .setMethodDescriptor(rollbackConversionWorkspaceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ApplyConversionWorkspaceRequest, Operation>
        applyConversionWorkspaceTransportSettings =
            GrpcCallSettings.<ApplyConversionWorkspaceRequest, Operation>newBuilder()
                .setMethodDescriptor(applyConversionWorkspaceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesResponse>
        describeDatabaseEntitiesTransportSettings =
            GrpcCallSettings
                .<DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesResponse>newBuilder()
                .setMethodDescriptor(describeDatabaseEntitiesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "conversion_workspace", String.valueOf(request.getConversionWorkspace()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>
        searchBackgroundJobsTransportSettings =
            GrpcCallSettings.<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>newBuilder()
                .setMethodDescriptor(searchBackgroundJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "conversion_workspace", String.valueOf(request.getConversionWorkspace()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            DescribeConversionWorkspaceRevisionsRequest,
            DescribeConversionWorkspaceRevisionsResponse>
        describeConversionWorkspaceRevisionsTransportSettings =
            GrpcCallSettings
                .<DescribeConversionWorkspaceRevisionsRequest,
                    DescribeConversionWorkspaceRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(describeConversionWorkspaceRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "conversion_workspace", String.valueOf(request.getConversionWorkspace()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchStaticIpsRequest, FetchStaticIpsResponse>
        fetchStaticIpsTransportSettings =
            GrpcCallSettings.<FetchStaticIpsRequest, FetchStaticIpsResponse>newBuilder()
                .setMethodDescriptor(fetchStaticIpsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
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
    this.generateTcpProxyScriptCallable =
        callableFactory.createUnaryCallable(
            generateTcpProxyScriptTransportSettings,
            settings.generateTcpProxyScriptSettings(),
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
    this.createPrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            createPrivateConnectionTransportSettings,
            settings.createPrivateConnectionSettings(),
            clientContext);
    this.createPrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createPrivateConnectionTransportSettings,
            settings.createPrivateConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.getPrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            getPrivateConnectionTransportSettings,
            settings.getPrivateConnectionSettings(),
            clientContext);
    this.listPrivateConnectionsCallable =
        callableFactory.createUnaryCallable(
            listPrivateConnectionsTransportSettings,
            settings.listPrivateConnectionsSettings(),
            clientContext);
    this.listPrivateConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateConnectionsTransportSettings,
            settings.listPrivateConnectionsSettings(),
            clientContext);
    this.deletePrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            deletePrivateConnectionTransportSettings,
            settings.deletePrivateConnectionSettings(),
            clientContext);
    this.deletePrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deletePrivateConnectionTransportSettings,
            settings.deletePrivateConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.getConversionWorkspaceCallable =
        callableFactory.createUnaryCallable(
            getConversionWorkspaceTransportSettings,
            settings.getConversionWorkspaceSettings(),
            clientContext);
    this.listConversionWorkspacesCallable =
        callableFactory.createUnaryCallable(
            listConversionWorkspacesTransportSettings,
            settings.listConversionWorkspacesSettings(),
            clientContext);
    this.listConversionWorkspacesPagedCallable =
        callableFactory.createPagedCallable(
            listConversionWorkspacesTransportSettings,
            settings.listConversionWorkspacesSettings(),
            clientContext);
    this.createConversionWorkspaceCallable =
        callableFactory.createUnaryCallable(
            createConversionWorkspaceTransportSettings,
            settings.createConversionWorkspaceSettings(),
            clientContext);
    this.createConversionWorkspaceOperationCallable =
        callableFactory.createOperationCallable(
            createConversionWorkspaceTransportSettings,
            settings.createConversionWorkspaceOperationSettings(),
            clientContext,
            operationsStub);
    this.updateConversionWorkspaceCallable =
        callableFactory.createUnaryCallable(
            updateConversionWorkspaceTransportSettings,
            settings.updateConversionWorkspaceSettings(),
            clientContext);
    this.updateConversionWorkspaceOperationCallable =
        callableFactory.createOperationCallable(
            updateConversionWorkspaceTransportSettings,
            settings.updateConversionWorkspaceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteConversionWorkspaceCallable =
        callableFactory.createUnaryCallable(
            deleteConversionWorkspaceTransportSettings,
            settings.deleteConversionWorkspaceSettings(),
            clientContext);
    this.deleteConversionWorkspaceOperationCallable =
        callableFactory.createOperationCallable(
            deleteConversionWorkspaceTransportSettings,
            settings.deleteConversionWorkspaceOperationSettings(),
            clientContext,
            operationsStub);
    this.createMappingRuleCallable =
        callableFactory.createUnaryCallable(
            createMappingRuleTransportSettings,
            settings.createMappingRuleSettings(),
            clientContext);
    this.deleteMappingRuleCallable =
        callableFactory.createUnaryCallable(
            deleteMappingRuleTransportSettings,
            settings.deleteMappingRuleSettings(),
            clientContext);
    this.listMappingRulesCallable =
        callableFactory.createUnaryCallable(
            listMappingRulesTransportSettings, settings.listMappingRulesSettings(), clientContext);
    this.listMappingRulesPagedCallable =
        callableFactory.createPagedCallable(
            listMappingRulesTransportSettings, settings.listMappingRulesSettings(), clientContext);
    this.getMappingRuleCallable =
        callableFactory.createUnaryCallable(
            getMappingRuleTransportSettings, settings.getMappingRuleSettings(), clientContext);
    this.seedConversionWorkspaceCallable =
        callableFactory.createUnaryCallable(
            seedConversionWorkspaceTransportSettings,
            settings.seedConversionWorkspaceSettings(),
            clientContext);
    this.seedConversionWorkspaceOperationCallable =
        callableFactory.createOperationCallable(
            seedConversionWorkspaceTransportSettings,
            settings.seedConversionWorkspaceOperationSettings(),
            clientContext,
            operationsStub);
    this.importMappingRulesCallable =
        callableFactory.createUnaryCallable(
            importMappingRulesTransportSettings,
            settings.importMappingRulesSettings(),
            clientContext);
    this.importMappingRulesOperationCallable =
        callableFactory.createOperationCallable(
            importMappingRulesTransportSettings,
            settings.importMappingRulesOperationSettings(),
            clientContext,
            operationsStub);
    this.convertConversionWorkspaceCallable =
        callableFactory.createUnaryCallable(
            convertConversionWorkspaceTransportSettings,
            settings.convertConversionWorkspaceSettings(),
            clientContext);
    this.convertConversionWorkspaceOperationCallable =
        callableFactory.createOperationCallable(
            convertConversionWorkspaceTransportSettings,
            settings.convertConversionWorkspaceOperationSettings(),
            clientContext,
            operationsStub);
    this.commitConversionWorkspaceCallable =
        callableFactory.createUnaryCallable(
            commitConversionWorkspaceTransportSettings,
            settings.commitConversionWorkspaceSettings(),
            clientContext);
    this.commitConversionWorkspaceOperationCallable =
        callableFactory.createOperationCallable(
            commitConversionWorkspaceTransportSettings,
            settings.commitConversionWorkspaceOperationSettings(),
            clientContext,
            operationsStub);
    this.rollbackConversionWorkspaceCallable =
        callableFactory.createUnaryCallable(
            rollbackConversionWorkspaceTransportSettings,
            settings.rollbackConversionWorkspaceSettings(),
            clientContext);
    this.rollbackConversionWorkspaceOperationCallable =
        callableFactory.createOperationCallable(
            rollbackConversionWorkspaceTransportSettings,
            settings.rollbackConversionWorkspaceOperationSettings(),
            clientContext,
            operationsStub);
    this.applyConversionWorkspaceCallable =
        callableFactory.createUnaryCallable(
            applyConversionWorkspaceTransportSettings,
            settings.applyConversionWorkspaceSettings(),
            clientContext);
    this.applyConversionWorkspaceOperationCallable =
        callableFactory.createOperationCallable(
            applyConversionWorkspaceTransportSettings,
            settings.applyConversionWorkspaceOperationSettings(),
            clientContext,
            operationsStub);
    this.describeDatabaseEntitiesCallable =
        callableFactory.createUnaryCallable(
            describeDatabaseEntitiesTransportSettings,
            settings.describeDatabaseEntitiesSettings(),
            clientContext);
    this.describeDatabaseEntitiesPagedCallable =
        callableFactory.createPagedCallable(
            describeDatabaseEntitiesTransportSettings,
            settings.describeDatabaseEntitiesSettings(),
            clientContext);
    this.searchBackgroundJobsCallable =
        callableFactory.createUnaryCallable(
            searchBackgroundJobsTransportSettings,
            settings.searchBackgroundJobsSettings(),
            clientContext);
    this.describeConversionWorkspaceRevisionsCallable =
        callableFactory.createUnaryCallable(
            describeConversionWorkspaceRevisionsTransportSettings,
            settings.describeConversionWorkspaceRevisionsSettings(),
            clientContext);
    this.fetchStaticIpsCallable =
        callableFactory.createUnaryCallable(
            fetchStaticIpsTransportSettings, settings.fetchStaticIpsSettings(), clientContext);
    this.fetchStaticIpsPagedCallable =
        callableFactory.createPagedCallable(
            fetchStaticIpsTransportSettings, settings.fetchStaticIpsSettings(), clientContext);

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
  public UnaryCallable<GenerateTcpProxyScriptRequest, TcpProxyScript>
      generateTcpProxyScriptCallable() {
    return generateTcpProxyScriptCallable;
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
  public UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable() {
    return createPrivateConnectionCallable;
  }

  @Override
  public OperationCallable<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable() {
    return createPrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable() {
    return getPrivateConnectionCallable;
  }

  @Override
  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable() {
    return listPrivateConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable() {
    return listPrivateConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable() {
    return deletePrivateConnectionCallable;
  }

  @Override
  public OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable() {
    return deletePrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<GetConversionWorkspaceRequest, ConversionWorkspace>
      getConversionWorkspaceCallable() {
    return getConversionWorkspaceCallable;
  }

  @Override
  public UnaryCallable<ListConversionWorkspacesRequest, ListConversionWorkspacesResponse>
      listConversionWorkspacesCallable() {
    return listConversionWorkspacesCallable;
  }

  @Override
  public UnaryCallable<ListConversionWorkspacesRequest, ListConversionWorkspacesPagedResponse>
      listConversionWorkspacesPagedCallable() {
    return listConversionWorkspacesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateConversionWorkspaceRequest, Operation>
      createConversionWorkspaceCallable() {
    return createConversionWorkspaceCallable;
  }

  @Override
  public OperationCallable<CreateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      createConversionWorkspaceOperationCallable() {
    return createConversionWorkspaceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConversionWorkspaceRequest, Operation>
      updateConversionWorkspaceCallable() {
    return updateConversionWorkspaceCallable;
  }

  @Override
  public OperationCallable<UpdateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      updateConversionWorkspaceOperationCallable() {
    return updateConversionWorkspaceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConversionWorkspaceRequest, Operation>
      deleteConversionWorkspaceCallable() {
    return deleteConversionWorkspaceCallable;
  }

  @Override
  public OperationCallable<DeleteConversionWorkspaceRequest, Empty, OperationMetadata>
      deleteConversionWorkspaceOperationCallable() {
    return deleteConversionWorkspaceOperationCallable;
  }

  @Override
  public UnaryCallable<CreateMappingRuleRequest, MappingRule> createMappingRuleCallable() {
    return createMappingRuleCallable;
  }

  @Override
  public UnaryCallable<DeleteMappingRuleRequest, Empty> deleteMappingRuleCallable() {
    return deleteMappingRuleCallable;
  }

  @Override
  public UnaryCallable<ListMappingRulesRequest, ListMappingRulesResponse>
      listMappingRulesCallable() {
    return listMappingRulesCallable;
  }

  @Override
  public UnaryCallable<ListMappingRulesRequest, ListMappingRulesPagedResponse>
      listMappingRulesPagedCallable() {
    return listMappingRulesPagedCallable;
  }

  @Override
  public UnaryCallable<GetMappingRuleRequest, MappingRule> getMappingRuleCallable() {
    return getMappingRuleCallable;
  }

  @Override
  public UnaryCallable<SeedConversionWorkspaceRequest, Operation>
      seedConversionWorkspaceCallable() {
    return seedConversionWorkspaceCallable;
  }

  @Override
  public OperationCallable<SeedConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      seedConversionWorkspaceOperationCallable() {
    return seedConversionWorkspaceOperationCallable;
  }

  @Override
  public UnaryCallable<ImportMappingRulesRequest, Operation> importMappingRulesCallable() {
    return importMappingRulesCallable;
  }

  @Override
  public OperationCallable<ImportMappingRulesRequest, ConversionWorkspace, OperationMetadata>
      importMappingRulesOperationCallable() {
    return importMappingRulesOperationCallable;
  }

  @Override
  public UnaryCallable<ConvertConversionWorkspaceRequest, Operation>
      convertConversionWorkspaceCallable() {
    return convertConversionWorkspaceCallable;
  }

  @Override
  public OperationCallable<
          ConvertConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      convertConversionWorkspaceOperationCallable() {
    return convertConversionWorkspaceOperationCallable;
  }

  @Override
  public UnaryCallable<CommitConversionWorkspaceRequest, Operation>
      commitConversionWorkspaceCallable() {
    return commitConversionWorkspaceCallable;
  }

  @Override
  public OperationCallable<CommitConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      commitConversionWorkspaceOperationCallable() {
    return commitConversionWorkspaceOperationCallable;
  }

  @Override
  public UnaryCallable<RollbackConversionWorkspaceRequest, Operation>
      rollbackConversionWorkspaceCallable() {
    return rollbackConversionWorkspaceCallable;
  }

  @Override
  public OperationCallable<
          RollbackConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      rollbackConversionWorkspaceOperationCallable() {
    return rollbackConversionWorkspaceOperationCallable;
  }

  @Override
  public UnaryCallable<ApplyConversionWorkspaceRequest, Operation>
      applyConversionWorkspaceCallable() {
    return applyConversionWorkspaceCallable;
  }

  @Override
  public OperationCallable<ApplyConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      applyConversionWorkspaceOperationCallable() {
    return applyConversionWorkspaceOperationCallable;
  }

  @Override
  public UnaryCallable<DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesResponse>
      describeDatabaseEntitiesCallable() {
    return describeDatabaseEntitiesCallable;
  }

  @Override
  public UnaryCallable<DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesPagedResponse>
      describeDatabaseEntitiesPagedCallable() {
    return describeDatabaseEntitiesPagedCallable;
  }

  @Override
  public UnaryCallable<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>
      searchBackgroundJobsCallable() {
    return searchBackgroundJobsCallable;
  }

  @Override
  public UnaryCallable<
          DescribeConversionWorkspaceRevisionsRequest, DescribeConversionWorkspaceRevisionsResponse>
      describeConversionWorkspaceRevisionsCallable() {
    return describeConversionWorkspaceRevisionsCallable;
  }

  @Override
  public UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsResponse> fetchStaticIpsCallable() {
    return fetchStaticIpsCallable;
  }

  @Override
  public UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsPagedResponse>
      fetchStaticIpsPagedCallable() {
    return fetchStaticIpsPagedCallable;
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
