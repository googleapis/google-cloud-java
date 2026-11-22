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

package com.google.cloud.agentregistry.v1.stub;

import static com.google.cloud.agentregistry.v1.AgentRegistryClient.FetchAvailableBindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationEndpointsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListBindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListEndpointsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListFindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListLocationsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListPublishersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListServicesPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListSkillRevisionsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListSkillsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchSkillsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.agentregistry.v1.Agent;
import com.google.cloud.agentregistry.v1.AiApplication;
import com.google.cloud.agentregistry.v1.Binding;
import com.google.cloud.agentregistry.v1.CreateBindingRequest;
import com.google.cloud.agentregistry.v1.CreateServiceRequest;
import com.google.cloud.agentregistry.v1.CreateSkillRequest;
import com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest;
import com.google.cloud.agentregistry.v1.DeleteBindingRequest;
import com.google.cloud.agentregistry.v1.DeleteServiceRequest;
import com.google.cloud.agentregistry.v1.DeleteSkillRequest;
import com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest;
import com.google.cloud.agentregistry.v1.Endpoint;
import com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest;
import com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse;
import com.google.cloud.agentregistry.v1.Finding;
import com.google.cloud.agentregistry.v1.GetAgentRequest;
import com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest;
import com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest;
import com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest;
import com.google.cloud.agentregistry.v1.GetAiApplicationRequest;
import com.google.cloud.agentregistry.v1.GetBindingRequest;
import com.google.cloud.agentregistry.v1.GetEndpointRequest;
import com.google.cloud.agentregistry.v1.GetFindingRequest;
import com.google.cloud.agentregistry.v1.GetMcpServerRequest;
import com.google.cloud.agentregistry.v1.GetPublisherRequest;
import com.google.cloud.agentregistry.v1.GetServiceRequest;
import com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest;
import com.google.cloud.agentregistry.v1.GetSkillRequest;
import com.google.cloud.agentregistry.v1.GetSkillRevisionRequest;
import com.google.cloud.agentregistry.v1.ListAgentsRequest;
import com.google.cloud.agentregistry.v1.ListAgentsResponse;
import com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest;
import com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse;
import com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest;
import com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse;
import com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest;
import com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse;
import com.google.cloud.agentregistry.v1.ListAiApplicationsRequest;
import com.google.cloud.agentregistry.v1.ListAiApplicationsResponse;
import com.google.cloud.agentregistry.v1.ListBindingsRequest;
import com.google.cloud.agentregistry.v1.ListBindingsResponse;
import com.google.cloud.agentregistry.v1.ListEndpointsRequest;
import com.google.cloud.agentregistry.v1.ListEndpointsResponse;
import com.google.cloud.agentregistry.v1.ListFindingsRequest;
import com.google.cloud.agentregistry.v1.ListFindingsResponse;
import com.google.cloud.agentregistry.v1.ListMcpServersRequest;
import com.google.cloud.agentregistry.v1.ListMcpServersResponse;
import com.google.cloud.agentregistry.v1.ListPublishersRequest;
import com.google.cloud.agentregistry.v1.ListPublishersResponse;
import com.google.cloud.agentregistry.v1.ListServicesRequest;
import com.google.cloud.agentregistry.v1.ListServicesResponse;
import com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest;
import com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse;
import com.google.cloud.agentregistry.v1.ListSkillsRequest;
import com.google.cloud.agentregistry.v1.ListSkillsResponse;
import com.google.cloud.agentregistry.v1.McpServer;
import com.google.cloud.agentregistry.v1.OperationMetadata;
import com.google.cloud.agentregistry.v1.Publisher;
import com.google.cloud.agentregistry.v1.SearchAgentsRequest;
import com.google.cloud.agentregistry.v1.SearchAgentsResponse;
import com.google.cloud.agentregistry.v1.SearchMcpServersRequest;
import com.google.cloud.agentregistry.v1.SearchMcpServersResponse;
import com.google.cloud.agentregistry.v1.SearchSkillsRequest;
import com.google.cloud.agentregistry.v1.SearchSkillsResponse;
import com.google.cloud.agentregistry.v1.Service;
import com.google.cloud.agentregistry.v1.Skill;
import com.google.cloud.agentregistry.v1.SkillEncryptionSpec;
import com.google.cloud.agentregistry.v1.SkillRevision;
import com.google.cloud.agentregistry.v1.UpdateBindingRequest;
import com.google.cloud.agentregistry.v1.UpdateServiceRequest;
import com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest;
import com.google.cloud.agentregistry.v1.UpdateSkillRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AgentRegistry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class AgentRegistryStub implements BackgroundResource {

  public @Nullable OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.@Nullable OperationsStub
      getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListAgentsRequest, ListAgentsPagedResponse> listAgentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAgentsPagedCallable()");
  }

  public UnaryCallable<ListAgentsRequest, ListAgentsResponse> listAgentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAgentsCallable()");
  }

  public UnaryCallable<SearchAgentsRequest, SearchAgentsPagedResponse> searchAgentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAgentsPagedCallable()");
  }

  public UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> searchAgentsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAgentsCallable()");
  }

  public UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: getAgentCallable()");
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointsPagedCallable()");
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointsCallable()");
  }

  public UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: getEndpointCallable()");
  }

  public UnaryCallable<ListMcpServersRequest, ListMcpServersPagedResponse>
      listMcpServersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMcpServersPagedCallable()");
  }

  public UnaryCallable<ListMcpServersRequest, ListMcpServersResponse> listMcpServersCallable() {
    throw new UnsupportedOperationException("Not implemented: listMcpServersCallable()");
  }

  public UnaryCallable<SearchMcpServersRequest, SearchMcpServersPagedResponse>
      searchMcpServersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchMcpServersPagedCallable()");
  }

  public UnaryCallable<SearchMcpServersRequest, SearchMcpServersResponse>
      searchMcpServersCallable() {
    throw new UnsupportedOperationException("Not implemented: searchMcpServersCallable()");
  }

  public UnaryCallable<GetMcpServerRequest, McpServer> getMcpServerCallable() {
    throw new UnsupportedOperationException("Not implemented: getMcpServerCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesPagedCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesCallable()");
  }

  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceCallable()");
  }

  public OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceOperationCallable()");
  }

  public UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceCallable()");
  }

  public OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServiceOperationCallable()");
  }

  public UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServiceCallable()");
  }

  public OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceOperationCallable()");
  }

  public UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceCallable()");
  }

  public UnaryCallable<ListBindingsRequest, ListBindingsPagedResponse> listBindingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBindingsPagedCallable()");
  }

  public UnaryCallable<ListBindingsRequest, ListBindingsResponse> listBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBindingsCallable()");
  }

  public UnaryCallable<GetBindingRequest, Binding> getBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: getBindingCallable()");
  }

  public OperationCallable<CreateBindingRequest, Binding, OperationMetadata>
      createBindingOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createBindingOperationCallable()");
  }

  public UnaryCallable<CreateBindingRequest, Operation> createBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: createBindingCallable()");
  }

  public OperationCallable<UpdateBindingRequest, Binding, OperationMetadata>
      updateBindingOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBindingOperationCallable()");
  }

  public UnaryCallable<UpdateBindingRequest, Operation> updateBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBindingCallable()");
  }

  public OperationCallable<DeleteBindingRequest, Empty, OperationMetadata>
      deleteBindingOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBindingOperationCallable()");
  }

  public UnaryCallable<DeleteBindingRequest, Operation> deleteBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBindingCallable()");
  }

  public UnaryCallable<FetchAvailableBindingsRequest, FetchAvailableBindingsPagedResponse>
      fetchAvailableBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchAvailableBindingsPagedCallable()");
  }

  public UnaryCallable<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>
      fetchAvailableBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchAvailableBindingsCallable()");
  }

  public OperationCallable<CreateSkillRequest, Skill, OperationMetadata>
      createSkillOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSkillOperationCallable()");
  }

  public UnaryCallable<CreateSkillRequest, Operation> createSkillCallable() {
    throw new UnsupportedOperationException("Not implemented: createSkillCallable()");
  }

  public UnaryCallable<GetSkillRequest, Skill> getSkillCallable() {
    throw new UnsupportedOperationException("Not implemented: getSkillCallable()");
  }

  public OperationCallable<UpdateSkillRequest, Skill, OperationMetadata>
      updateSkillOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSkillOperationCallable()");
  }

  public UnaryCallable<UpdateSkillRequest, Operation> updateSkillCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSkillCallable()");
  }

  public OperationCallable<DeleteSkillRequest, Empty, OperationMetadata>
      deleteSkillOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSkillOperationCallable()");
  }

  public UnaryCallable<DeleteSkillRequest, Operation> deleteSkillCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSkillCallable()");
  }

  public UnaryCallable<ListSkillsRequest, ListSkillsPagedResponse> listSkillsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkillsPagedCallable()");
  }

  public UnaryCallable<ListSkillsRequest, ListSkillsResponse> listSkillsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkillsCallable()");
  }

  public UnaryCallable<SearchSkillsRequest, SearchSkillsPagedResponse> searchSkillsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchSkillsPagedCallable()");
  }

  public UnaryCallable<SearchSkillsRequest, SearchSkillsResponse> searchSkillsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchSkillsCallable()");
  }

  public OperationCallable<CreateSkillRevisionRequest, SkillRevision, OperationMetadata>
      createSkillRevisionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSkillRevisionOperationCallable()");
  }

  public UnaryCallable<CreateSkillRevisionRequest, Operation> createSkillRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: createSkillRevisionCallable()");
  }

  public UnaryCallable<GetSkillRevisionRequest, SkillRevision> getSkillRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: getSkillRevisionCallable()");
  }

  public OperationCallable<DeleteSkillRevisionRequest, Empty, OperationMetadata>
      deleteSkillRevisionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSkillRevisionOperationCallable()");
  }

  public UnaryCallable<DeleteSkillRevisionRequest, Operation> deleteSkillRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSkillRevisionCallable()");
  }

  public UnaryCallable<ListSkillRevisionsRequest, ListSkillRevisionsPagedResponse>
      listSkillRevisionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkillRevisionsPagedCallable()");
  }

  public UnaryCallable<ListSkillRevisionsRequest, ListSkillRevisionsResponse>
      listSkillRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkillRevisionsCallable()");
  }

  public UnaryCallable<GetPublisherRequest, Publisher> getPublisherCallable() {
    throw new UnsupportedOperationException("Not implemented: getPublisherCallable()");
  }

  public UnaryCallable<ListPublishersRequest, ListPublishersPagedResponse>
      listPublishersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPublishersPagedCallable()");
  }

  public UnaryCallable<ListPublishersRequest, ListPublishersResponse> listPublishersCallable() {
    throw new UnsupportedOperationException("Not implemented: listPublishersCallable()");
  }

  public UnaryCallable<GetAiApplicationRequest, AiApplication> getAiApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: getAiApplicationCallable()");
  }

  public UnaryCallable<ListAiApplicationsRequest, ListAiApplicationsPagedResponse>
      listAiApplicationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAiApplicationsPagedCallable()");
  }

  public UnaryCallable<ListAiApplicationsRequest, ListAiApplicationsResponse>
      listAiApplicationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAiApplicationsCallable()");
  }

  public UnaryCallable<GetAiApplicationAgentRequest, Agent> getAiApplicationAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: getAiApplicationAgentCallable()");
  }

  public UnaryCallable<ListAiApplicationAgentsRequest, ListAiApplicationAgentsPagedResponse>
      listAiApplicationAgentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAiApplicationAgentsPagedCallable()");
  }

  public UnaryCallable<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>
      listAiApplicationAgentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAiApplicationAgentsCallable()");
  }

  public UnaryCallable<GetAiApplicationMcpServerRequest, McpServer>
      getAiApplicationMcpServerCallable() {
    throw new UnsupportedOperationException("Not implemented: getAiApplicationMcpServerCallable()");
  }

  public UnaryCallable<ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersPagedResponse>
      listAiApplicationMcpServersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAiApplicationMcpServersPagedCallable()");
  }

  public UnaryCallable<ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>
      listAiApplicationMcpServersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAiApplicationMcpServersCallable()");
  }

  public UnaryCallable<GetFindingRequest, Finding> getFindingCallable() {
    throw new UnsupportedOperationException("Not implemented: getFindingCallable()");
  }

  public UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse> listFindingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingsPagedCallable()");
  }

  public UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingsCallable()");
  }

  public UnaryCallable<GetAiApplicationEndpointRequest, Endpoint>
      getAiApplicationEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: getAiApplicationEndpointCallable()");
  }

  public UnaryCallable<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsPagedResponse>
      listAiApplicationEndpointsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAiApplicationEndpointsPagedCallable()");
  }

  public UnaryCallable<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>
      listAiApplicationEndpointsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAiApplicationEndpointsCallable()");
  }

  public UnaryCallable<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>
      getSkillEncryptionSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: getSkillEncryptionSpecCallable()");
  }

  public OperationCallable<UpdateSkillEncryptionSpecRequest, SkillEncryptionSpec, OperationMetadata>
      updateSkillEncryptionSpecOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSkillEncryptionSpecOperationCallable()");
  }

  public UnaryCallable<UpdateSkillEncryptionSpecRequest, Operation>
      updateSkillEncryptionSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSkillEncryptionSpecCallable()");
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
