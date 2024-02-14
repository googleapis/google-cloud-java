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

package com.google.cloud.clouddms.v1.stub;

import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.DescribeDatabaseEntitiesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.FetchStaticIpsPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConversionWorkspacesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMappingRulesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMigrationJobsPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListPrivateConnectionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataMigrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataMigrationServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListMigrationJobsRequest, ListMigrationJobsPagedResponse>
      listMigrationJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMigrationJobsPagedCallable()");
  }

  public UnaryCallable<ListMigrationJobsRequest, ListMigrationJobsResponse>
      listMigrationJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMigrationJobsCallable()");
  }

  public UnaryCallable<GetMigrationJobRequest, MigrationJob> getMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getMigrationJobCallable()");
  }

  public OperationCallable<CreateMigrationJobRequest, MigrationJob, OperationMetadata>
      createMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMigrationJobOperationCallable()");
  }

  public UnaryCallable<CreateMigrationJobRequest, Operation> createMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createMigrationJobCallable()");
  }

  public OperationCallable<UpdateMigrationJobRequest, MigrationJob, OperationMetadata>
      updateMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMigrationJobOperationCallable()");
  }

  public UnaryCallable<UpdateMigrationJobRequest, Operation> updateMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMigrationJobCallable()");
  }

  public OperationCallable<DeleteMigrationJobRequest, Empty, OperationMetadata>
      deleteMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMigrationJobOperationCallable()");
  }

  public UnaryCallable<DeleteMigrationJobRequest, Operation> deleteMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMigrationJobCallable()");
  }

  public OperationCallable<StartMigrationJobRequest, MigrationJob, OperationMetadata>
      startMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: startMigrationJobOperationCallable()");
  }

  public UnaryCallable<StartMigrationJobRequest, Operation> startMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: startMigrationJobCallable()");
  }

  public OperationCallable<StopMigrationJobRequest, MigrationJob, OperationMetadata>
      stopMigrationJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopMigrationJobOperationCallable()");
  }

  public UnaryCallable<StopMigrationJobRequest, Operation> stopMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: stopMigrationJobCallable()");
  }

  public OperationCallable<ResumeMigrationJobRequest, MigrationJob, OperationMetadata>
      resumeMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: resumeMigrationJobOperationCallable()");
  }

  public UnaryCallable<ResumeMigrationJobRequest, Operation> resumeMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeMigrationJobCallable()");
  }

  public OperationCallable<PromoteMigrationJobRequest, MigrationJob, OperationMetadata>
      promoteMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: promoteMigrationJobOperationCallable()");
  }

  public UnaryCallable<PromoteMigrationJobRequest, Operation> promoteMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: promoteMigrationJobCallable()");
  }

  public OperationCallable<VerifyMigrationJobRequest, MigrationJob, OperationMetadata>
      verifyMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: verifyMigrationJobOperationCallable()");
  }

  public UnaryCallable<VerifyMigrationJobRequest, Operation> verifyMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: verifyMigrationJobCallable()");
  }

  public OperationCallable<RestartMigrationJobRequest, MigrationJob, OperationMetadata>
      restartMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: restartMigrationJobOperationCallable()");
  }

  public UnaryCallable<RestartMigrationJobRequest, Operation> restartMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: restartMigrationJobCallable()");
  }

  public UnaryCallable<GenerateSshScriptRequest, SshScript> generateSshScriptCallable() {
    throw new UnsupportedOperationException("Not implemented: generateSshScriptCallable()");
  }

  public UnaryCallable<GenerateTcpProxyScriptRequest, TcpProxyScript>
      generateTcpProxyScriptCallable() {
    throw new UnsupportedOperationException("Not implemented: generateTcpProxyScriptCallable()");
  }

  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesPagedResponse>
      listConnectionProfilesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConnectionProfilesPagedCallable()");
  }

  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectionProfilesCallable()");
  }

  public UnaryCallable<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getConnectionProfileCallable()");
  }

  public OperationCallable<CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConnectionProfileOperationCallable()");
  }

  public UnaryCallable<CreateConnectionProfileRequest, Operation>
      createConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectionProfileCallable()");
  }

  public OperationCallable<UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateConnectionProfileOperationCallable()");
  }

  public UnaryCallable<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConnectionProfileCallable()");
  }

  public OperationCallable<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteConnectionProfileOperationCallable()");
  }

  public UnaryCallable<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectionProfileCallable()");
  }

  public OperationCallable<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPrivateConnectionOperationCallable()");
  }

  public UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createPrivateConnectionCallable()");
  }

  public UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getPrivateConnectionCallable()");
  }

  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPrivateConnectionsPagedCallable()");
  }

  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrivateConnectionsCallable()");
  }

  public OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePrivateConnectionOperationCallable()");
  }

  public UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePrivateConnectionCallable()");
  }

  public UnaryCallable<GetConversionWorkspaceRequest, ConversionWorkspace>
      getConversionWorkspaceCallable() {
    throw new UnsupportedOperationException("Not implemented: getConversionWorkspaceCallable()");
  }

  public UnaryCallable<ListConversionWorkspacesRequest, ListConversionWorkspacesPagedResponse>
      listConversionWorkspacesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConversionWorkspacesPagedCallable()");
  }

  public UnaryCallable<ListConversionWorkspacesRequest, ListConversionWorkspacesResponse>
      listConversionWorkspacesCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversionWorkspacesCallable()");
  }

  public OperationCallable<CreateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      createConversionWorkspaceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConversionWorkspaceOperationCallable()");
  }

  public UnaryCallable<CreateConversionWorkspaceRequest, Operation>
      createConversionWorkspaceCallable() {
    throw new UnsupportedOperationException("Not implemented: createConversionWorkspaceCallable()");
  }

  public OperationCallable<UpdateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      updateConversionWorkspaceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateConversionWorkspaceOperationCallable()");
  }

  public UnaryCallable<UpdateConversionWorkspaceRequest, Operation>
      updateConversionWorkspaceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConversionWorkspaceCallable()");
  }

  public OperationCallable<DeleteConversionWorkspaceRequest, Empty, OperationMetadata>
      deleteConversionWorkspaceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteConversionWorkspaceOperationCallable()");
  }

  public UnaryCallable<DeleteConversionWorkspaceRequest, Operation>
      deleteConversionWorkspaceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConversionWorkspaceCallable()");
  }

  public UnaryCallable<CreateMappingRuleRequest, MappingRule> createMappingRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: createMappingRuleCallable()");
  }

  public UnaryCallable<DeleteMappingRuleRequest, Empty> deleteMappingRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMappingRuleCallable()");
  }

  public UnaryCallable<ListMappingRulesRequest, ListMappingRulesPagedResponse>
      listMappingRulesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMappingRulesPagedCallable()");
  }

  public UnaryCallable<ListMappingRulesRequest, ListMappingRulesResponse>
      listMappingRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listMappingRulesCallable()");
  }

  public UnaryCallable<GetMappingRuleRequest, MappingRule> getMappingRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getMappingRuleCallable()");
  }

  public OperationCallable<SeedConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      seedConversionWorkspaceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: seedConversionWorkspaceOperationCallable()");
  }

  public UnaryCallable<SeedConversionWorkspaceRequest, Operation>
      seedConversionWorkspaceCallable() {
    throw new UnsupportedOperationException("Not implemented: seedConversionWorkspaceCallable()");
  }

  public OperationCallable<ImportMappingRulesRequest, ConversionWorkspace, OperationMetadata>
      importMappingRulesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importMappingRulesOperationCallable()");
  }

  public UnaryCallable<ImportMappingRulesRequest, Operation> importMappingRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: importMappingRulesCallable()");
  }

  public OperationCallable<
          ConvertConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      convertConversionWorkspaceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: convertConversionWorkspaceOperationCallable()");
  }

  public UnaryCallable<ConvertConversionWorkspaceRequest, Operation>
      convertConversionWorkspaceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: convertConversionWorkspaceCallable()");
  }

  public OperationCallable<CommitConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      commitConversionWorkspaceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: commitConversionWorkspaceOperationCallable()");
  }

  public UnaryCallable<CommitConversionWorkspaceRequest, Operation>
      commitConversionWorkspaceCallable() {
    throw new UnsupportedOperationException("Not implemented: commitConversionWorkspaceCallable()");
  }

  public OperationCallable<
          RollbackConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      rollbackConversionWorkspaceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: rollbackConversionWorkspaceOperationCallable()");
  }

  public UnaryCallable<RollbackConversionWorkspaceRequest, Operation>
      rollbackConversionWorkspaceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: rollbackConversionWorkspaceCallable()");
  }

  public OperationCallable<ApplyConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      applyConversionWorkspaceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: applyConversionWorkspaceOperationCallable()");
  }

  public UnaryCallable<ApplyConversionWorkspaceRequest, Operation>
      applyConversionWorkspaceCallable() {
    throw new UnsupportedOperationException("Not implemented: applyConversionWorkspaceCallable()");
  }

  public UnaryCallable<DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesPagedResponse>
      describeDatabaseEntitiesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: describeDatabaseEntitiesPagedCallable()");
  }

  public UnaryCallable<DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesResponse>
      describeDatabaseEntitiesCallable() {
    throw new UnsupportedOperationException("Not implemented: describeDatabaseEntitiesCallable()");
  }

  public UnaryCallable<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>
      searchBackgroundJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchBackgroundJobsCallable()");
  }

  public UnaryCallable<
          DescribeConversionWorkspaceRevisionsRequest, DescribeConversionWorkspaceRevisionsResponse>
      describeConversionWorkspaceRevisionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: describeConversionWorkspaceRevisionsCallable()");
  }

  public UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsPagedResponse>
      fetchStaticIpsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchStaticIpsPagedCallable()");
  }

  public UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsResponse> fetchStaticIpsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchStaticIpsCallable()");
  }

  @Override
  public abstract void close();
}
