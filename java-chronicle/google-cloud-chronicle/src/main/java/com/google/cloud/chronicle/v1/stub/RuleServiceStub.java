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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRetrohuntsPagedResponse;
import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRuleDeploymentsPagedResponse;
import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRuleRevisionsPagedResponse;
import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRulesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.CreateRetrohuntRequest;
import com.google.cloud.chronicle.v1.CreateRuleRequest;
import com.google.cloud.chronicle.v1.DeleteRuleRequest;
import com.google.cloud.chronicle.v1.GetRetrohuntRequest;
import com.google.cloud.chronicle.v1.GetRuleDeploymentRequest;
import com.google.cloud.chronicle.v1.GetRuleRequest;
import com.google.cloud.chronicle.v1.ListRetrohuntsRequest;
import com.google.cloud.chronicle.v1.ListRetrohuntsResponse;
import com.google.cloud.chronicle.v1.ListRuleDeploymentsRequest;
import com.google.cloud.chronicle.v1.ListRuleDeploymentsResponse;
import com.google.cloud.chronicle.v1.ListRuleRevisionsRequest;
import com.google.cloud.chronicle.v1.ListRuleRevisionsResponse;
import com.google.cloud.chronicle.v1.ListRulesRequest;
import com.google.cloud.chronicle.v1.ListRulesResponse;
import com.google.cloud.chronicle.v1.Retrohunt;
import com.google.cloud.chronicle.v1.RetrohuntMetadata;
import com.google.cloud.chronicle.v1.Rule;
import com.google.cloud.chronicle.v1.RuleDeployment;
import com.google.cloud.chronicle.v1.UpdateRuleDeploymentRequest;
import com.google.cloud.chronicle.v1.UpdateRuleRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RuleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RuleServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreateRuleRequest, Rule> createRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: createRuleCallable()");
  }

  public UnaryCallable<GetRuleRequest, Rule> getRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getRuleCallable()");
  }

  public UnaryCallable<ListRulesRequest, ListRulesPagedResponse> listRulesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRulesPagedCallable()");
  }

  public UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRulesCallable()");
  }

  public UnaryCallable<UpdateRuleRequest, Rule> updateRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRuleCallable()");
  }

  public UnaryCallable<DeleteRuleRequest, Empty> deleteRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRuleCallable()");
  }

  public UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsPagedResponse>
      listRuleRevisionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRuleRevisionsPagedCallable()");
  }

  public UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsResponse>
      listRuleRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRuleRevisionsCallable()");
  }

  public OperationCallable<CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
      createRetrohuntOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRetrohuntOperationCallable()");
  }

  public UnaryCallable<CreateRetrohuntRequest, Operation> createRetrohuntCallable() {
    throw new UnsupportedOperationException("Not implemented: createRetrohuntCallable()");
  }

  public UnaryCallable<GetRetrohuntRequest, Retrohunt> getRetrohuntCallable() {
    throw new UnsupportedOperationException("Not implemented: getRetrohuntCallable()");
  }

  public UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsPagedResponse>
      listRetrohuntsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRetrohuntsPagedCallable()");
  }

  public UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsResponse> listRetrohuntsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRetrohuntsCallable()");
  }

  public UnaryCallable<GetRuleDeploymentRequest, RuleDeployment> getRuleDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getRuleDeploymentCallable()");
  }

  public UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsPagedResponse>
      listRuleDeploymentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRuleDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>
      listRuleDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRuleDeploymentsCallable()");
  }

  public UnaryCallable<UpdateRuleDeploymentRequest, RuleDeployment> updateRuleDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRuleDeploymentCallable()");
  }

  @Override
  public abstract void close();
}
