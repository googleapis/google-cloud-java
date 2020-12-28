/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.dataproc.v1.AutoscalingPolicyServiceClient.ListAutoscalingPoliciesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.AutoscalingPolicy;
import com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest;
import com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse;
import com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AutoscalingPolicyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class AutoscalingPolicyServiceStub implements BackgroundResource {

  public UnaryCallable<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createAutoscalingPolicyCallable()");
  }

  public UnaryCallable<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAutoscalingPolicyCallable()");
  }

  public UnaryCallable<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getAutoscalingPolicyCallable()");
  }

  public UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesPagedResponse>
      listAutoscalingPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAutoscalingPoliciesPagedCallable()");
  }

  public UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
      listAutoscalingPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAutoscalingPoliciesCallable()");
  }

  public UnaryCallable<DeleteAutoscalingPolicyRequest, Empty> deleteAutoscalingPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAutoscalingPolicyCallable()");
  }

  @Override
  public abstract void close();
}
