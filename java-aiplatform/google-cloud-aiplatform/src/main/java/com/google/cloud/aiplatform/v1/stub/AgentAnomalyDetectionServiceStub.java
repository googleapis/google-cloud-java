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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.AggregateAnalyzedSessionsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAgentAnomalyDetectionScopesPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAnalyzedInvocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAnalyzedSessionsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListMonitoredAgentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope;
import com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest;
import com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse;
import com.google.cloud.aiplatform.v1.AnalyzedInvocation;
import com.google.cloud.aiplatform.v1.AnalyzedSession;
import com.google.cloud.aiplatform.v1.ClearTrainingDataOperationMetadata;
import com.google.cloud.aiplatform.v1.ClearTrainingDataRequest;
import com.google.cloud.aiplatform.v1.ClearTrainingDataResponse;
import com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest;
import com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeOperationMetadata;
import com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest;
import com.google.cloud.aiplatform.v1.DisableMonitoredAgentOperationMetadata;
import com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest;
import com.google.cloud.aiplatform.v1.EnableMonitoredAgentOperationMetadata;
import com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest;
import com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest;
import com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest;
import com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest;
import com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest;
import com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest;
import com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse;
import com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest;
import com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse;
import com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest;
import com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse;
import com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest;
import com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse;
import com.google.cloud.aiplatform.v1.MonitoredAgent;
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
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AgentAnomalyDetectionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class AgentAnomalyDetectionServiceStub implements BackgroundResource {

  public @Nullable OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
      getAgentAnomalyDetectionScopeCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getAgentAnomalyDetectionScopeCallable()");
  }

  public UnaryCallable<GetMonitoredAgentRequest, MonitoredAgent> getMonitoredAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: getMonitoredAgentCallable()");
  }

  public UnaryCallable<ListMonitoredAgentsRequest, ListMonitoredAgentsPagedResponse>
      listMonitoredAgentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMonitoredAgentsPagedCallable()");
  }

  public UnaryCallable<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse>
      listMonitoredAgentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMonitoredAgentsCallable()");
  }

  public OperationCallable<
          EnableMonitoredAgentRequest, MonitoredAgent, EnableMonitoredAgentOperationMetadata>
      enableMonitoredAgentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: enableMonitoredAgentOperationCallable()");
  }

  public UnaryCallable<EnableMonitoredAgentRequest, Operation> enableMonitoredAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: enableMonitoredAgentCallable()");
  }

  public OperationCallable<
          DisableMonitoredAgentRequest, MonitoredAgent, DisableMonitoredAgentOperationMetadata>
      disableMonitoredAgentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disableMonitoredAgentOperationCallable()");
  }

  public UnaryCallable<DisableMonitoredAgentRequest, Operation> disableMonitoredAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: disableMonitoredAgentCallable()");
  }

  public OperationCallable<
          DeleteAgentAnomalyDetectionScopeRequest,
          Empty,
          DeleteAgentAnomalyDetectionScopeOperationMetadata>
      deleteAgentAnomalyDetectionScopeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAgentAnomalyDetectionScopeOperationCallable()");
  }

  public UnaryCallable<DeleteAgentAnomalyDetectionScopeRequest, Operation>
      deleteAgentAnomalyDetectionScopeCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAgentAnomalyDetectionScopeCallable()");
  }

  public OperationCallable<
          CreateAgentAnomalyDetectionScopeRequest,
          AgentAnomalyDetectionScope,
          CreateAgentAnomalyDetectionScopeOperationMetadata>
      createAgentAnomalyDetectionScopeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAgentAnomalyDetectionScopeOperationCallable()");
  }

  public UnaryCallable<CreateAgentAnomalyDetectionScopeRequest, Operation>
      createAgentAnomalyDetectionScopeCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAgentAnomalyDetectionScopeCallable()");
  }

  public UnaryCallable<
          ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesPagedResponse>
      listAgentAnomalyDetectionScopesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAgentAnomalyDetectionScopesPagedCallable()");
  }

  public UnaryCallable<
          ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesResponse>
      listAgentAnomalyDetectionScopesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAgentAnomalyDetectionScopesCallable()");
  }

  public UnaryCallable<ListAnalyzedSessionsRequest, ListAnalyzedSessionsPagedResponse>
      listAnalyzedSessionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnalyzedSessionsPagedCallable()");
  }

  public UnaryCallable<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse>
      listAnalyzedSessionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnalyzedSessionsCallable()");
  }

  public UnaryCallable<GetAnalyzedSessionRequest, AnalyzedSession> getAnalyzedSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: getAnalyzedSessionCallable()");
  }

  public UnaryCallable<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsPagedResponse>
      listAnalyzedInvocationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAnalyzedInvocationsPagedCallable()");
  }

  public UnaryCallable<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse>
      listAnalyzedInvocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnalyzedInvocationsCallable()");
  }

  public UnaryCallable<GetAnalyzedInvocationRequest, AnalyzedInvocation>
      getAnalyzedInvocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getAnalyzedInvocationCallable()");
  }

  public UnaryCallable<AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsPagedResponse>
      aggregateAnalyzedSessionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregateAnalyzedSessionsPagedCallable()");
  }

  public UnaryCallable<AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsResponse>
      aggregateAnalyzedSessionsCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregateAnalyzedSessionsCallable()");
  }

  public OperationCallable<
          ClearTrainingDataRequest, ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
      clearTrainingDataOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: clearTrainingDataOperationCallable()");
  }

  public UnaryCallable<ClearTrainingDataRequest, Operation> clearTrainingDataCallable() {
    throw new UnsupportedOperationException("Not implemented: clearTrainingDataCallable()");
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

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
