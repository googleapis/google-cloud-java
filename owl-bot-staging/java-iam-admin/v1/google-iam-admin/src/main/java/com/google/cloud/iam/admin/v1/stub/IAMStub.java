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

package com.google.cloud.iam.admin.v1.stub;

import static com.google.cloud.iam.admin.v1.IAMClient.ListRolesPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.ListServiceAccountsPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.QueryGrantableRolesPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.QueryTestablePermissionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.admin.v1.CreateRoleRequest;
import com.google.iam.admin.v1.CreateServiceAccountKeyRequest;
import com.google.iam.admin.v1.CreateServiceAccountRequest;
import com.google.iam.admin.v1.DeleteRoleRequest;
import com.google.iam.admin.v1.DeleteServiceAccountKeyRequest;
import com.google.iam.admin.v1.DeleteServiceAccountRequest;
import com.google.iam.admin.v1.DisableServiceAccountKeyRequest;
import com.google.iam.admin.v1.DisableServiceAccountRequest;
import com.google.iam.admin.v1.EnableServiceAccountKeyRequest;
import com.google.iam.admin.v1.EnableServiceAccountRequest;
import com.google.iam.admin.v1.GetRoleRequest;
import com.google.iam.admin.v1.GetServiceAccountKeyRequest;
import com.google.iam.admin.v1.GetServiceAccountRequest;
import com.google.iam.admin.v1.LintPolicyRequest;
import com.google.iam.admin.v1.LintPolicyResponse;
import com.google.iam.admin.v1.ListRolesRequest;
import com.google.iam.admin.v1.ListRolesResponse;
import com.google.iam.admin.v1.ListServiceAccountKeysRequest;
import com.google.iam.admin.v1.ListServiceAccountKeysResponse;
import com.google.iam.admin.v1.ListServiceAccountsRequest;
import com.google.iam.admin.v1.ListServiceAccountsResponse;
import com.google.iam.admin.v1.PatchServiceAccountRequest;
import com.google.iam.admin.v1.QueryAuditableServicesRequest;
import com.google.iam.admin.v1.QueryAuditableServicesResponse;
import com.google.iam.admin.v1.QueryGrantableRolesRequest;
import com.google.iam.admin.v1.QueryGrantableRolesResponse;
import com.google.iam.admin.v1.QueryTestablePermissionsRequest;
import com.google.iam.admin.v1.QueryTestablePermissionsResponse;
import com.google.iam.admin.v1.Role;
import com.google.iam.admin.v1.ServiceAccount;
import com.google.iam.admin.v1.ServiceAccountKey;
import com.google.iam.admin.v1.SignBlobRequest;
import com.google.iam.admin.v1.SignBlobResponse;
import com.google.iam.admin.v1.SignJwtRequest;
import com.google.iam.admin.v1.SignJwtResponse;
import com.google.iam.admin.v1.UndeleteRoleRequest;
import com.google.iam.admin.v1.UndeleteServiceAccountRequest;
import com.google.iam.admin.v1.UndeleteServiceAccountResponse;
import com.google.iam.admin.v1.UpdateRoleRequest;
import com.google.iam.admin.v1.UploadServiceAccountKeyRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the IAM service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class IAMStub implements BackgroundResource {

  public UnaryCallable<ListServiceAccountsRequest, ListServiceAccountsPagedResponse>
      listServiceAccountsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceAccountsPagedCallable()");
  }

  public UnaryCallable<ListServiceAccountsRequest, ListServiceAccountsResponse>
      listServiceAccountsCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceAccountsCallable()");
  }

  public UnaryCallable<GetServiceAccountRequest, ServiceAccount> getServiceAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceAccountCallable()");
  }

  public UnaryCallable<CreateServiceAccountRequest, ServiceAccount> createServiceAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceAccountCallable()");
  }

  public UnaryCallable<ServiceAccount, ServiceAccount> updateServiceAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServiceAccountCallable()");
  }

  public UnaryCallable<PatchServiceAccountRequest, ServiceAccount> patchServiceAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: patchServiceAccountCallable()");
  }

  public UnaryCallable<DeleteServiceAccountRequest, Empty> deleteServiceAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceAccountCallable()");
  }

  public UnaryCallable<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
      undeleteServiceAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteServiceAccountCallable()");
  }

  public UnaryCallable<EnableServiceAccountRequest, Empty> enableServiceAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: enableServiceAccountCallable()");
  }

  public UnaryCallable<DisableServiceAccountRequest, Empty> disableServiceAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: disableServiceAccountCallable()");
  }

  public UnaryCallable<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
      listServiceAccountKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceAccountKeysCallable()");
  }

  public UnaryCallable<GetServiceAccountKeyRequest, ServiceAccountKey>
      getServiceAccountKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceAccountKeyCallable()");
  }

  public UnaryCallable<CreateServiceAccountKeyRequest, ServiceAccountKey>
      createServiceAccountKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceAccountKeyCallable()");
  }

  public UnaryCallable<UploadServiceAccountKeyRequest, ServiceAccountKey>
      uploadServiceAccountKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: uploadServiceAccountKeyCallable()");
  }

  public UnaryCallable<DeleteServiceAccountKeyRequest, Empty> deleteServiceAccountKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceAccountKeyCallable()");
  }

  public UnaryCallable<DisableServiceAccountKeyRequest, Empty> disableServiceAccountKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: disableServiceAccountKeyCallable()");
  }

  public UnaryCallable<EnableServiceAccountKeyRequest, Empty> enableServiceAccountKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: enableServiceAccountKeyCallable()");
  }

  @Deprecated
  public UnaryCallable<SignBlobRequest, SignBlobResponse> signBlobCallable() {
    throw new UnsupportedOperationException("Not implemented: signBlobCallable()");
  }

  @Deprecated
  public UnaryCallable<SignJwtRequest, SignJwtResponse> signJwtCallable() {
    throw new UnsupportedOperationException("Not implemented: signJwtCallable()");
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

  public UnaryCallable<QueryGrantableRolesRequest, QueryGrantableRolesPagedResponse>
      queryGrantableRolesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: queryGrantableRolesPagedCallable()");
  }

  public UnaryCallable<QueryGrantableRolesRequest, QueryGrantableRolesResponse>
      queryGrantableRolesCallable() {
    throw new UnsupportedOperationException("Not implemented: queryGrantableRolesCallable()");
  }

  public UnaryCallable<ListRolesRequest, ListRolesPagedResponse> listRolesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRolesPagedCallable()");
  }

  public UnaryCallable<ListRolesRequest, ListRolesResponse> listRolesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRolesCallable()");
  }

  public UnaryCallable<GetRoleRequest, Role> getRoleCallable() {
    throw new UnsupportedOperationException("Not implemented: getRoleCallable()");
  }

  public UnaryCallable<CreateRoleRequest, Role> createRoleCallable() {
    throw new UnsupportedOperationException("Not implemented: createRoleCallable()");
  }

  public UnaryCallable<UpdateRoleRequest, Role> updateRoleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRoleCallable()");
  }

  public UnaryCallable<DeleteRoleRequest, Role> deleteRoleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRoleCallable()");
  }

  public UnaryCallable<UndeleteRoleRequest, Role> undeleteRoleCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteRoleCallable()");
  }

  public UnaryCallable<QueryTestablePermissionsRequest, QueryTestablePermissionsPagedResponse>
      queryTestablePermissionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryTestablePermissionsPagedCallable()");
  }

  public UnaryCallable<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse>
      queryTestablePermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: queryTestablePermissionsCallable()");
  }

  public UnaryCallable<QueryAuditableServicesRequest, QueryAuditableServicesResponse>
      queryAuditableServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: queryAuditableServicesCallable()");
  }

  public UnaryCallable<LintPolicyRequest, LintPolicyResponse> lintPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: lintPolicyCallable()");
  }

  @Override
  public abstract void close();
}
