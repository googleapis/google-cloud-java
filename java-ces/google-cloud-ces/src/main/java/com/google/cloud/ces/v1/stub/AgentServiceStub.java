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

package com.google.cloud.ces.v1.stub;

import static com.google.cloud.ces.v1.AgentServiceClient.ListAgentsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListAppVersionsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListAppsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListChangelogsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListDeploymentsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListExamplesPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListGuardrailsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListToolsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListToolsetsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ces.v1.Agent;
import com.google.cloud.ces.v1.App;
import com.google.cloud.ces.v1.AppVersion;
import com.google.cloud.ces.v1.BatchDeleteConversationsRequest;
import com.google.cloud.ces.v1.BatchDeleteConversationsResponse;
import com.google.cloud.ces.v1.Changelog;
import com.google.cloud.ces.v1.Conversation;
import com.google.cloud.ces.v1.CreateAgentRequest;
import com.google.cloud.ces.v1.CreateAppRequest;
import com.google.cloud.ces.v1.CreateAppVersionRequest;
import com.google.cloud.ces.v1.CreateDeploymentRequest;
import com.google.cloud.ces.v1.CreateExampleRequest;
import com.google.cloud.ces.v1.CreateGuardrailRequest;
import com.google.cloud.ces.v1.CreateToolRequest;
import com.google.cloud.ces.v1.CreateToolsetRequest;
import com.google.cloud.ces.v1.DeleteAgentRequest;
import com.google.cloud.ces.v1.DeleteAppRequest;
import com.google.cloud.ces.v1.DeleteAppVersionRequest;
import com.google.cloud.ces.v1.DeleteConversationRequest;
import com.google.cloud.ces.v1.DeleteDeploymentRequest;
import com.google.cloud.ces.v1.DeleteExampleRequest;
import com.google.cloud.ces.v1.DeleteGuardrailRequest;
import com.google.cloud.ces.v1.DeleteToolRequest;
import com.google.cloud.ces.v1.DeleteToolsetRequest;
import com.google.cloud.ces.v1.Deployment;
import com.google.cloud.ces.v1.Example;
import com.google.cloud.ces.v1.ExportAppRequest;
import com.google.cloud.ces.v1.ExportAppResponse;
import com.google.cloud.ces.v1.GetAgentRequest;
import com.google.cloud.ces.v1.GetAppRequest;
import com.google.cloud.ces.v1.GetAppVersionRequest;
import com.google.cloud.ces.v1.GetChangelogRequest;
import com.google.cloud.ces.v1.GetConversationRequest;
import com.google.cloud.ces.v1.GetDeploymentRequest;
import com.google.cloud.ces.v1.GetExampleRequest;
import com.google.cloud.ces.v1.GetGuardrailRequest;
import com.google.cloud.ces.v1.GetToolRequest;
import com.google.cloud.ces.v1.GetToolsetRequest;
import com.google.cloud.ces.v1.Guardrail;
import com.google.cloud.ces.v1.ImportAppRequest;
import com.google.cloud.ces.v1.ImportAppResponse;
import com.google.cloud.ces.v1.ListAgentsRequest;
import com.google.cloud.ces.v1.ListAgentsResponse;
import com.google.cloud.ces.v1.ListAppVersionsRequest;
import com.google.cloud.ces.v1.ListAppVersionsResponse;
import com.google.cloud.ces.v1.ListAppsRequest;
import com.google.cloud.ces.v1.ListAppsResponse;
import com.google.cloud.ces.v1.ListChangelogsRequest;
import com.google.cloud.ces.v1.ListChangelogsResponse;
import com.google.cloud.ces.v1.ListConversationsRequest;
import com.google.cloud.ces.v1.ListConversationsResponse;
import com.google.cloud.ces.v1.ListDeploymentsRequest;
import com.google.cloud.ces.v1.ListDeploymentsResponse;
import com.google.cloud.ces.v1.ListExamplesRequest;
import com.google.cloud.ces.v1.ListExamplesResponse;
import com.google.cloud.ces.v1.ListGuardrailsRequest;
import com.google.cloud.ces.v1.ListGuardrailsResponse;
import com.google.cloud.ces.v1.ListToolsRequest;
import com.google.cloud.ces.v1.ListToolsResponse;
import com.google.cloud.ces.v1.ListToolsetsRequest;
import com.google.cloud.ces.v1.ListToolsetsResponse;
import com.google.cloud.ces.v1.OperationMetadata;
import com.google.cloud.ces.v1.RestoreAppVersionRequest;
import com.google.cloud.ces.v1.RestoreAppVersionResponse;
import com.google.cloud.ces.v1.Tool;
import com.google.cloud.ces.v1.Toolset;
import com.google.cloud.ces.v1.UpdateAgentRequest;
import com.google.cloud.ces.v1.UpdateAppRequest;
import com.google.cloud.ces.v1.UpdateDeploymentRequest;
import com.google.cloud.ces.v1.UpdateExampleRequest;
import com.google.cloud.ces.v1.UpdateGuardrailRequest;
import com.google.cloud.ces.v1.UpdateToolRequest;
import com.google.cloud.ces.v1.UpdateToolsetRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AgentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AgentServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListAppsRequest, ListAppsPagedResponse> listAppsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppsPagedCallable()");
  }

  public UnaryCallable<ListAppsRequest, ListAppsResponse> listAppsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppsCallable()");
  }

  public UnaryCallable<GetAppRequest, App> getAppCallable() {
    throw new UnsupportedOperationException("Not implemented: getAppCallable()");
  }

  public OperationCallable<CreateAppRequest, App, OperationMetadata> createAppOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAppOperationCallable()");
  }

  public UnaryCallable<CreateAppRequest, Operation> createAppCallable() {
    throw new UnsupportedOperationException("Not implemented: createAppCallable()");
  }

  public UnaryCallable<UpdateAppRequest, App> updateAppCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAppCallable()");
  }

  public OperationCallable<DeleteAppRequest, Empty, OperationMetadata>
      deleteAppOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAppOperationCallable()");
  }

  public UnaryCallable<DeleteAppRequest, Operation> deleteAppCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAppCallable()");
  }

  public OperationCallable<ExportAppRequest, ExportAppResponse, OperationMetadata>
      exportAppOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportAppOperationCallable()");
  }

  public UnaryCallable<ExportAppRequest, Operation> exportAppCallable() {
    throw new UnsupportedOperationException("Not implemented: exportAppCallable()");
  }

  public OperationCallable<ImportAppRequest, ImportAppResponse, OperationMetadata>
      importAppOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importAppOperationCallable()");
  }

  public UnaryCallable<ImportAppRequest, Operation> importAppCallable() {
    throw new UnsupportedOperationException("Not implemented: importAppCallable()");
  }

  public UnaryCallable<ListAgentsRequest, ListAgentsPagedResponse> listAgentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAgentsPagedCallable()");
  }

  public UnaryCallable<ListAgentsRequest, ListAgentsResponse> listAgentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAgentsCallable()");
  }

  public UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: getAgentCallable()");
  }

  public UnaryCallable<CreateAgentRequest, Agent> createAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: createAgentCallable()");
  }

  public UnaryCallable<UpdateAgentRequest, Agent> updateAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAgentCallable()");
  }

  public UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAgentCallable()");
  }

  public UnaryCallable<ListExamplesRequest, ListExamplesPagedResponse> listExamplesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExamplesPagedCallable()");
  }

  public UnaryCallable<ListExamplesRequest, ListExamplesResponse> listExamplesCallable() {
    throw new UnsupportedOperationException("Not implemented: listExamplesCallable()");
  }

  public UnaryCallable<GetExampleRequest, Example> getExampleCallable() {
    throw new UnsupportedOperationException("Not implemented: getExampleCallable()");
  }

  public UnaryCallable<CreateExampleRequest, Example> createExampleCallable() {
    throw new UnsupportedOperationException("Not implemented: createExampleCallable()");
  }

  public UnaryCallable<UpdateExampleRequest, Example> updateExampleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExampleCallable()");
  }

  public UnaryCallable<DeleteExampleRequest, Empty> deleteExampleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExampleCallable()");
  }

  public UnaryCallable<ListToolsRequest, ListToolsPagedResponse> listToolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listToolsPagedCallable()");
  }

  public UnaryCallable<ListToolsRequest, ListToolsResponse> listToolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listToolsCallable()");
  }

  public UnaryCallable<GetToolRequest, Tool> getToolCallable() {
    throw new UnsupportedOperationException("Not implemented: getToolCallable()");
  }

  public UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversationsPagedCallable()");
  }

  public UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversationsCallable()");
  }

  public UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: getConversationCallable()");
  }

  public UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConversationCallable()");
  }

  public OperationCallable<
          BatchDeleteConversationsRequest, BatchDeleteConversationsResponse, OperationMetadata>
      batchDeleteConversationsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeleteConversationsOperationCallable()");
  }

  public UnaryCallable<BatchDeleteConversationsRequest, Operation>
      batchDeleteConversationsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteConversationsCallable()");
  }

  public UnaryCallable<CreateToolRequest, Tool> createToolCallable() {
    throw new UnsupportedOperationException("Not implemented: createToolCallable()");
  }

  public UnaryCallable<UpdateToolRequest, Tool> updateToolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateToolCallable()");
  }

  public UnaryCallable<DeleteToolRequest, Empty> deleteToolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteToolCallable()");
  }

  public UnaryCallable<ListGuardrailsRequest, ListGuardrailsPagedResponse>
      listGuardrailsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGuardrailsPagedCallable()");
  }

  public UnaryCallable<ListGuardrailsRequest, ListGuardrailsResponse> listGuardrailsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGuardrailsCallable()");
  }

  public UnaryCallable<GetGuardrailRequest, Guardrail> getGuardrailCallable() {
    throw new UnsupportedOperationException("Not implemented: getGuardrailCallable()");
  }

  public UnaryCallable<CreateGuardrailRequest, Guardrail> createGuardrailCallable() {
    throw new UnsupportedOperationException("Not implemented: createGuardrailCallable()");
  }

  public UnaryCallable<UpdateGuardrailRequest, Guardrail> updateGuardrailCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGuardrailCallable()");
  }

  public UnaryCallable<DeleteGuardrailRequest, Empty> deleteGuardrailCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGuardrailCallable()");
  }

  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeploymentsCallable()");
  }

  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeploymentCallable()");
  }

  public UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeploymentCallable()");
  }

  public UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDeploymentCallable()");
  }

  public UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDeploymentCallable()");
  }

  public UnaryCallable<ListToolsetsRequest, ListToolsetsPagedResponse> listToolsetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listToolsetsPagedCallable()");
  }

  public UnaryCallable<ListToolsetsRequest, ListToolsetsResponse> listToolsetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listToolsetsCallable()");
  }

  public UnaryCallable<GetToolsetRequest, Toolset> getToolsetCallable() {
    throw new UnsupportedOperationException("Not implemented: getToolsetCallable()");
  }

  public UnaryCallable<CreateToolsetRequest, Toolset> createToolsetCallable() {
    throw new UnsupportedOperationException("Not implemented: createToolsetCallable()");
  }

  public UnaryCallable<UpdateToolsetRequest, Toolset> updateToolsetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateToolsetCallable()");
  }

  public UnaryCallable<DeleteToolsetRequest, Empty> deleteToolsetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteToolsetCallable()");
  }

  public UnaryCallable<ListAppVersionsRequest, ListAppVersionsPagedResponse>
      listAppVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppVersionsPagedCallable()");
  }

  public UnaryCallable<ListAppVersionsRequest, ListAppVersionsResponse> listAppVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppVersionsCallable()");
  }

  public UnaryCallable<GetAppVersionRequest, AppVersion> getAppVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getAppVersionCallable()");
  }

  public UnaryCallable<CreateAppVersionRequest, AppVersion> createAppVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: createAppVersionCallable()");
  }

  public UnaryCallable<DeleteAppVersionRequest, Empty> deleteAppVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAppVersionCallable()");
  }

  public OperationCallable<RestoreAppVersionRequest, RestoreAppVersionResponse, OperationMetadata>
      restoreAppVersionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: restoreAppVersionOperationCallable()");
  }

  public UnaryCallable<RestoreAppVersionRequest, Operation> restoreAppVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreAppVersionCallable()");
  }

  public UnaryCallable<ListChangelogsRequest, ListChangelogsPagedResponse>
      listChangelogsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listChangelogsPagedCallable()");
  }

  public UnaryCallable<ListChangelogsRequest, ListChangelogsResponse> listChangelogsCallable() {
    throw new UnsupportedOperationException("Not implemented: listChangelogsCallable()");
  }

  public UnaryCallable<GetChangelogRequest, Changelog> getChangelogCallable() {
    throw new UnsupportedOperationException("Not implemented: getChangelogCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
