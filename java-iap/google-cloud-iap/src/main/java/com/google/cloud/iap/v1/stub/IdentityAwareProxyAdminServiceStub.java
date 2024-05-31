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

package com.google.cloud.iap.v1.stub;

import static com.google.cloud.iap.v1.IdentityAwareProxyAdminServiceClient.ListTunnelDestGroupsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iap.v1.CreateTunnelDestGroupRequest;
import com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest;
import com.google.cloud.iap.v1.GetIapSettingsRequest;
import com.google.cloud.iap.v1.GetTunnelDestGroupRequest;
import com.google.cloud.iap.v1.IapSettings;
import com.google.cloud.iap.v1.ListTunnelDestGroupsRequest;
import com.google.cloud.iap.v1.ListTunnelDestGroupsResponse;
import com.google.cloud.iap.v1.TunnelDestGroup;
import com.google.cloud.iap.v1.UpdateIapSettingsRequest;
import com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the IdentityAwareProxyAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class IdentityAwareProxyAdminServiceStub implements BackgroundResource {

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

  public UnaryCallable<GetIapSettingsRequest, IapSettings> getIapSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getIapSettingsCallable()");
  }

  public UnaryCallable<UpdateIapSettingsRequest, IapSettings> updateIapSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIapSettingsCallable()");
  }

  public UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsPagedResponse>
      listTunnelDestGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTunnelDestGroupsPagedCallable()");
  }

  public UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>
      listTunnelDestGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTunnelDestGroupsCallable()");
  }

  public UnaryCallable<CreateTunnelDestGroupRequest, TunnelDestGroup>
      createTunnelDestGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createTunnelDestGroupCallable()");
  }

  public UnaryCallable<GetTunnelDestGroupRequest, TunnelDestGroup> getTunnelDestGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getTunnelDestGroupCallable()");
  }

  public UnaryCallable<DeleteTunnelDestGroupRequest, Empty> deleteTunnelDestGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTunnelDestGroupCallable()");
  }

  public UnaryCallable<UpdateTunnelDestGroupRequest, TunnelDestGroup>
      updateTunnelDestGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTunnelDestGroupCallable()");
  }

  @Override
  public abstract void close();
}
