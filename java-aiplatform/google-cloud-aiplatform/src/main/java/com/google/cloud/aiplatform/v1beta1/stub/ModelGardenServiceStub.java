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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.ModelGardenServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelGardenServiceClient.ListPublisherModelsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.DeployPublisherModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest;
import com.google.cloud.aiplatform.v1beta1.DeployPublisherModelResponse;
import com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest;
import com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest;
import com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse;
import com.google.cloud.aiplatform.v1beta1.PublisherModel;
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
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ModelGardenService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ModelGardenServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<GetPublisherModelRequest, PublisherModel> getPublisherModelCallable() {
    throw new UnsupportedOperationException("Not implemented: getPublisherModelCallable()");
  }

  public UnaryCallable<ListPublisherModelsRequest, ListPublisherModelsPagedResponse>
      listPublisherModelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPublisherModelsPagedCallable()");
  }

  public UnaryCallable<ListPublisherModelsRequest, ListPublisherModelsResponse>
      listPublisherModelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPublisherModelsCallable()");
  }

  public OperationCallable<
          DeployPublisherModelRequest,
          DeployPublisherModelResponse,
          DeployPublisherModelOperationMetadata>
      deployPublisherModelOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deployPublisherModelOperationCallable()");
  }

  public UnaryCallable<DeployPublisherModelRequest, Operation> deployPublisherModelCallable() {
    throw new UnsupportedOperationException("Not implemented: deployPublisherModelCallable()");
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
