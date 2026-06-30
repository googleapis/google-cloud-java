/*
 * Copyright 2026 Google LLC
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

package com.google.showcase.v1beta1.stub;

import static com.google.showcase.v1beta1.IdentityClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.IdentityClient.ListUsersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.showcase.v1beta1.CreateUserRequest;
import com.google.showcase.v1beta1.DeleteUserRequest;
import com.google.showcase.v1beta1.GetUserRequest;
import com.google.showcase.v1beta1.ListUsersRequest;
import com.google.showcase.v1beta1.ListUsersResponse;
import com.google.showcase.v1beta1.UpdateUserRequest;
import com.google.showcase.v1beta1.User;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Identity service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class IdentityStub implements BackgroundResource {

  public UnaryCallable<CreateUserRequest, User> createUserCallable() {
    throw new UnsupportedOperationException("Not implemented: createUserCallable()");
  }

  public UnaryCallable<GetUserRequest, User> getUserCallable() {
    throw new UnsupportedOperationException("Not implemented: getUserCallable()");
  }

  public UnaryCallable<UpdateUserRequest, User> updateUserCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUserCallable()");
  }

  public UnaryCallable<DeleteUserRequest, Empty> deleteUserCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUserCallable()");
  }

  public UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsersPagedCallable()");
  }

  public UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsersCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
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
