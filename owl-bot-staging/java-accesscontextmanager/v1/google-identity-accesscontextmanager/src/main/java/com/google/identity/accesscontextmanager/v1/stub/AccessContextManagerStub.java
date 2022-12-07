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

package com.google.identity.accesscontextmanager.v1.stub;

import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessLevelsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessPoliciesPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListGcpUserAccessBindingsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListServicePerimetersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.identity.accesscontextmanager.v1.AccessContextManagerOperationMetadata;
import com.google.identity.accesscontextmanager.v1.AccessLevel;
import com.google.identity.accesscontextmanager.v1.AccessPolicy;
import com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.CommitServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding;
import com.google.identity.accesscontextmanager.v1.GcpUserAccessBindingOperationMetadata;
import com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse;
import com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse;
import com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest;
import com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse;
import com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest;
import com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsResponse;
import com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.ServicePerimeter;
import com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AccessContextManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AccessContextManagerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesPagedResponse>
      listAccessPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccessPoliciesPagedCallable()");
  }

  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccessPoliciesCallable()");
  }

  public UnaryCallable<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccessPolicyCallable()");
  }

  public OperationCallable<AccessPolicy, AccessPolicy, AccessContextManagerOperationMetadata>
      createAccessPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAccessPolicyOperationCallable()");
  }

  public UnaryCallable<AccessPolicy, Operation> createAccessPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createAccessPolicyCallable()");
  }

  public OperationCallable<
          UpdateAccessPolicyRequest, AccessPolicy, AccessContextManagerOperationMetadata>
      updateAccessPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAccessPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateAccessPolicyRequest, Operation> updateAccessPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAccessPolicyCallable()");
  }

  public OperationCallable<DeleteAccessPolicyRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAccessPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAccessPolicyCallable()");
  }

  public UnaryCallable<ListAccessLevelsRequest, ListAccessLevelsPagedResponse>
      listAccessLevelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccessLevelsPagedCallable()");
  }

  public UnaryCallable<ListAccessLevelsRequest, ListAccessLevelsResponse>
      listAccessLevelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccessLevelsCallable()");
  }

  public UnaryCallable<GetAccessLevelRequest, AccessLevel> getAccessLevelCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccessLevelCallable()");
  }

  public OperationCallable<
          CreateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      createAccessLevelOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAccessLevelOperationCallable()");
  }

  public UnaryCallable<CreateAccessLevelRequest, Operation> createAccessLevelCallable() {
    throw new UnsupportedOperationException("Not implemented: createAccessLevelCallable()");
  }

  public OperationCallable<
          UpdateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      updateAccessLevelOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAccessLevelOperationCallable()");
  }

  public UnaryCallable<UpdateAccessLevelRequest, Operation> updateAccessLevelCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAccessLevelCallable()");
  }

  public OperationCallable<DeleteAccessLevelRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessLevelOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAccessLevelOperationCallable()");
  }

  public UnaryCallable<DeleteAccessLevelRequest, Operation> deleteAccessLevelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAccessLevelCallable()");
  }

  public OperationCallable<
          ReplaceAccessLevelsRequest,
          ReplaceAccessLevelsResponse,
          AccessContextManagerOperationMetadata>
      replaceAccessLevelsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: replaceAccessLevelsOperationCallable()");
  }

  public UnaryCallable<ReplaceAccessLevelsRequest, Operation> replaceAccessLevelsCallable() {
    throw new UnsupportedOperationException("Not implemented: replaceAccessLevelsCallable()");
  }

  public UnaryCallable<ListServicePerimetersRequest, ListServicePerimetersPagedResponse>
      listServicePerimetersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServicePerimetersPagedCallable()");
  }

  public UnaryCallable<ListServicePerimetersRequest, ListServicePerimetersResponse>
      listServicePerimetersCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicePerimetersCallable()");
  }

  public UnaryCallable<GetServicePerimeterRequest, ServicePerimeter> getServicePerimeterCallable() {
    throw new UnsupportedOperationException("Not implemented: getServicePerimeterCallable()");
  }

  public OperationCallable<
          CreateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      createServicePerimeterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServicePerimeterOperationCallable()");
  }

  public UnaryCallable<CreateServicePerimeterRequest, Operation> createServicePerimeterCallable() {
    throw new UnsupportedOperationException("Not implemented: createServicePerimeterCallable()");
  }

  public OperationCallable<
          UpdateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      updateServicePerimeterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateServicePerimeterOperationCallable()");
  }

  public UnaryCallable<UpdateServicePerimeterRequest, Operation> updateServicePerimeterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServicePerimeterCallable()");
  }

  public OperationCallable<
          DeleteServicePerimeterRequest, Empty, AccessContextManagerOperationMetadata>
      deleteServicePerimeterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServicePerimeterOperationCallable()");
  }

  public UnaryCallable<DeleteServicePerimeterRequest, Operation> deleteServicePerimeterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServicePerimeterCallable()");
  }

  public OperationCallable<
          ReplaceServicePerimetersRequest,
          ReplaceServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      replaceServicePerimetersOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: replaceServicePerimetersOperationCallable()");
  }

  public UnaryCallable<ReplaceServicePerimetersRequest, Operation>
      replaceServicePerimetersCallable() {
    throw new UnsupportedOperationException("Not implemented: replaceServicePerimetersCallable()");
  }

  public OperationCallable<
          CommitServicePerimetersRequest,
          CommitServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      commitServicePerimetersOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: commitServicePerimetersOperationCallable()");
  }

  public UnaryCallable<CommitServicePerimetersRequest, Operation>
      commitServicePerimetersCallable() {
    throw new UnsupportedOperationException("Not implemented: commitServicePerimetersCallable()");
  }

  public UnaryCallable<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsPagedResponse>
      listGcpUserAccessBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGcpUserAccessBindingsPagedCallable()");
  }

  public UnaryCallable<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>
      listGcpUserAccessBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGcpUserAccessBindingsCallable()");
  }

  public UnaryCallable<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
      getGcpUserAccessBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: getGcpUserAccessBindingCallable()");
  }

  public OperationCallable<
          CreateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      createGcpUserAccessBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGcpUserAccessBindingOperationCallable()");
  }

  public UnaryCallable<CreateGcpUserAccessBindingRequest, Operation>
      createGcpUserAccessBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGcpUserAccessBindingCallable()");
  }

  public OperationCallable<
          UpdateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      updateGcpUserAccessBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGcpUserAccessBindingOperationCallable()");
  }

  public UnaryCallable<UpdateGcpUserAccessBindingRequest, Operation>
      updateGcpUserAccessBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGcpUserAccessBindingCallable()");
  }

  public OperationCallable<
          DeleteGcpUserAccessBindingRequest, Empty, GcpUserAccessBindingOperationMetadata>
      deleteGcpUserAccessBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGcpUserAccessBindingOperationCallable()");
  }

  public UnaryCallable<DeleteGcpUserAccessBindingRequest, Operation>
      deleteGcpUserAccessBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGcpUserAccessBindingCallable()");
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
