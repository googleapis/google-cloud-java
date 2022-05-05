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

package com.google.cloud.billing.v1.stub;

import static com.google.cloud.billing.v1.CloudBillingClient.ListBillingAccountsPagedResponse;
import static com.google.cloud.billing.v1.CloudBillingClient.ListProjectBillingInfoPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.billing.v1.BillingAccount;
import com.google.cloud.billing.v1.CreateBillingAccountRequest;
import com.google.cloud.billing.v1.GetBillingAccountRequest;
import com.google.cloud.billing.v1.GetProjectBillingInfoRequest;
import com.google.cloud.billing.v1.ListBillingAccountsRequest;
import com.google.cloud.billing.v1.ListBillingAccountsResponse;
import com.google.cloud.billing.v1.ListProjectBillingInfoRequest;
import com.google.cloud.billing.v1.ListProjectBillingInfoResponse;
import com.google.cloud.billing.v1.ProjectBillingInfo;
import com.google.cloud.billing.v1.UpdateBillingAccountRequest;
import com.google.cloud.billing.v1.UpdateProjectBillingInfoRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudBilling service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudBillingStub implements BackgroundResource {

  public UnaryCallable<GetBillingAccountRequest, BillingAccount> getBillingAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: getBillingAccountCallable()");
  }

  public UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsPagedResponse>
      listBillingAccountsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBillingAccountsPagedCallable()");
  }

  public UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsResponse>
      listBillingAccountsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBillingAccountsCallable()");
  }

  public UnaryCallable<UpdateBillingAccountRequest, BillingAccount> updateBillingAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBillingAccountCallable()");
  }

  public UnaryCallable<CreateBillingAccountRequest, BillingAccount> createBillingAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: createBillingAccountCallable()");
  }

  public UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoPagedResponse>
      listProjectBillingInfoPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listProjectBillingInfoPagedCallable()");
  }

  public UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>
      listProjectBillingInfoCallable() {
    throw new UnsupportedOperationException("Not implemented: listProjectBillingInfoCallable()");
  }

  public UnaryCallable<GetProjectBillingInfoRequest, ProjectBillingInfo>
      getProjectBillingInfoCallable() {
    throw new UnsupportedOperationException("Not implemented: getProjectBillingInfoCallable()");
  }

  public UnaryCallable<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
      updateProjectBillingInfoCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProjectBillingInfoCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
