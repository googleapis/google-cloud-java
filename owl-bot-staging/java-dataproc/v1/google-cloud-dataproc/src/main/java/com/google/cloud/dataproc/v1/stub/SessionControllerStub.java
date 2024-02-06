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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.SessionControllerClient.ListSessionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.CreateSessionRequest;
import com.google.cloud.dataproc.v1.DeleteSessionRequest;
import com.google.cloud.dataproc.v1.GetSessionRequest;
import com.google.cloud.dataproc.v1.ListSessionsRequest;
import com.google.cloud.dataproc.v1.ListSessionsResponse;
import com.google.cloud.dataproc.v1.Session;
import com.google.cloud.dataproc.v1.SessionOperationMetadata;
import com.google.cloud.dataproc.v1.TerminateSessionRequest;
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
 * Base stub class for the SessionController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SessionControllerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateSessionRequest, Session, SessionOperationMetadata>
      createSessionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSessionOperationCallable()");
  }

  public UnaryCallable<CreateSessionRequest, Operation> createSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: createSessionCallable()");
  }

  public UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: getSessionCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsPagedCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsCallable()");
  }

  public OperationCallable<TerminateSessionRequest, Session, SessionOperationMetadata>
      terminateSessionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: terminateSessionOperationCallable()");
  }

  public UnaryCallable<TerminateSessionRequest, Operation> terminateSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: terminateSessionCallable()");
  }

  public OperationCallable<DeleteSessionRequest, Session, SessionOperationMetadata>
      deleteSessionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSessionOperationCallable()");
  }

  public UnaryCallable<DeleteSessionRequest, Operation> deleteSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSessionCallable()");
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
