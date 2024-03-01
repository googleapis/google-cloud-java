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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.SessionTemplateControllerClient.ListSessionTemplatesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.CreateSessionTemplateRequest;
import com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest;
import com.google.cloud.dataproc.v1.GetSessionTemplateRequest;
import com.google.cloud.dataproc.v1.ListSessionTemplatesRequest;
import com.google.cloud.dataproc.v1.ListSessionTemplatesResponse;
import com.google.cloud.dataproc.v1.SessionTemplate;
import com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SessionTemplateController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SessionTemplateControllerStub implements BackgroundResource {

  public UnaryCallable<CreateSessionTemplateRequest, SessionTemplate>
      createSessionTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createSessionTemplateCallable()");
  }

  public UnaryCallable<UpdateSessionTemplateRequest, SessionTemplate>
      updateSessionTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSessionTemplateCallable()");
  }

  public UnaryCallable<GetSessionTemplateRequest, SessionTemplate> getSessionTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getSessionTemplateCallable()");
  }

  public UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesPagedResponse>
      listSessionTemplatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionTemplatesPagedCallable()");
  }

  public UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesResponse>
      listSessionTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionTemplatesCallable()");
  }

  public UnaryCallable<DeleteSessionTemplateRequest, Empty> deleteSessionTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSessionTemplateCallable()");
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
