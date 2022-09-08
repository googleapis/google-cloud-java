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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.OrganizationsClient.SearchOrganizationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.GetOrganizationRequest;
import com.google.cloud.resourcemanager.v3.Organization;
import com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest;
import com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Organizations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class OrganizationsStub implements BackgroundResource {

  public UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable() {
    throw new UnsupportedOperationException("Not implemented: getOrganizationCallable()");
  }

  public UnaryCallable<SearchOrganizationsRequest, SearchOrganizationsPagedResponse>
      searchOrganizationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchOrganizationsPagedCallable()");
  }

  public UnaryCallable<SearchOrganizationsRequest, SearchOrganizationsResponse>
      searchOrganizationsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchOrganizationsCallable()");
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
