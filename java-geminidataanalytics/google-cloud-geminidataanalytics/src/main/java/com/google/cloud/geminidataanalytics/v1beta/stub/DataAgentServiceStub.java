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

package com.google.cloud.geminidataanalytics.v1beta.stub;

import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListAccessibleDataAgentsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListDataAgentsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest;
import com.google.cloud.geminidataanalytics.v1beta.DataAgent;
import com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest;
import com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse;
import com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse;
import com.google.cloud.geminidataanalytics.v1beta.OperationMetadata;
import com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataAgentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DataAgentServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListDataAgentsRequest, ListDataAgentsPagedResponse>
      listDataAgentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataAgentsPagedCallable()");
  }

  public UnaryCallable<ListDataAgentsRequest, ListDataAgentsResponse> listDataAgentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataAgentsCallable()");
  }

  public UnaryCallable<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsPagedResponse>
      listAccessibleDataAgentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAccessibleDataAgentsPagedCallable()");
  }

  public UnaryCallable<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse>
      listAccessibleDataAgentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccessibleDataAgentsCallable()");
  }

  public UnaryCallable<GetDataAgentRequest, DataAgent> getDataAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataAgentCallable()");
  }

  public OperationCallable<CreateDataAgentRequest, DataAgent, OperationMetadata>
      createDataAgentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataAgentOperationCallable()");
  }

  public UnaryCallable<CreateDataAgentRequest, Operation> createDataAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataAgentCallable()");
  }

  public OperationCallable<UpdateDataAgentRequest, DataAgent, OperationMetadata>
      updateDataAgentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataAgentOperationCallable()");
  }

  public UnaryCallable<UpdateDataAgentRequest, Operation> updateDataAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataAgentCallable()");
  }

  public OperationCallable<DeleteDataAgentRequest, Empty, OperationMetadata>
      deleteDataAgentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataAgentOperationCallable()");
  }

  public UnaryCallable<DeleteDataAgentRequest, Operation> deleteDataAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataAgentCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
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
