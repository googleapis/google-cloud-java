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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.AlertPolicyServiceClient.ListAlertPoliciesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.monitoring.v3.AlertPolicy;
import com.google.monitoring.v3.CreateAlertPolicyRequest;
import com.google.monitoring.v3.DeleteAlertPolicyRequest;
import com.google.monitoring.v3.GetAlertPolicyRequest;
import com.google.monitoring.v3.ListAlertPoliciesRequest;
import com.google.monitoring.v3.ListAlertPoliciesResponse;
import com.google.monitoring.v3.UpdateAlertPolicyRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AlertPolicyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AlertPolicyServiceStub implements BackgroundResource {

  public UnaryCallable<ListAlertPoliciesRequest, ListAlertPoliciesPagedResponse>
      listAlertPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAlertPoliciesPagedCallable()");
  }

  public UnaryCallable<ListAlertPoliciesRequest, ListAlertPoliciesResponse>
      listAlertPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAlertPoliciesCallable()");
  }

  public UnaryCallable<GetAlertPolicyRequest, AlertPolicy> getAlertPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getAlertPolicyCallable()");
  }

  public UnaryCallable<CreateAlertPolicyRequest, AlertPolicy> createAlertPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createAlertPolicyCallable()");
  }

  public UnaryCallable<DeleteAlertPolicyRequest, Empty> deleteAlertPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAlertPolicyCallable()");
  }

  public UnaryCallable<UpdateAlertPolicyRequest, AlertPolicy> updateAlertPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAlertPolicyCallable()");
  }

  @Override
  public abstract void close();
}
