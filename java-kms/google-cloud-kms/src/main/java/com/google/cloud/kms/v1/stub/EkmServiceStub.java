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

package com.google.cloud.kms.v1.stub;

import static com.google.cloud.kms.v1.EkmServiceClient.ListEkmConnectionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.v1.CreateEkmConnectionRequest;
import com.google.cloud.kms.v1.EkmConnection;
import com.google.cloud.kms.v1.GetEkmConnectionRequest;
import com.google.cloud.kms.v1.ListEkmConnectionsRequest;
import com.google.cloud.kms.v1.ListEkmConnectionsResponse;
import com.google.cloud.kms.v1.UpdateEkmConnectionRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EkmService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class EkmServiceStub implements BackgroundResource {

  public UnaryCallable<ListEkmConnectionsRequest, ListEkmConnectionsPagedResponse>
      listEkmConnectionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEkmConnectionsPagedCallable()");
  }

  public UnaryCallable<ListEkmConnectionsRequest, ListEkmConnectionsResponse>
      listEkmConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEkmConnectionsCallable()");
  }

  public UnaryCallable<GetEkmConnectionRequest, EkmConnection> getEkmConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getEkmConnectionCallable()");
  }

  public UnaryCallable<CreateEkmConnectionRequest, EkmConnection> createEkmConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createEkmConnectionCallable()");
  }

  public UnaryCallable<UpdateEkmConnectionRequest, EkmConnection> updateEkmConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEkmConnectionCallable()");
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
