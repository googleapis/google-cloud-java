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

package com.google.ads.datamanager.v1.stub;

import static com.google.ads.datamanager.v1.UserListDirectLicenseServiceClient.ListUserListDirectLicensesPagedResponse;

import com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest;
import com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse;
import com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.UserListDirectLicense;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the UserListDirectLicenseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class UserListDirectLicenseServiceStub implements BackgroundResource {

  public UnaryCallable<CreateUserListDirectLicenseRequest, UserListDirectLicense>
      createUserListDirectLicenseCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createUserListDirectLicenseCallable()");
  }

  public UnaryCallable<GetUserListDirectLicenseRequest, UserListDirectLicense>
      getUserListDirectLicenseCallable() {
    throw new UnsupportedOperationException("Not implemented: getUserListDirectLicenseCallable()");
  }

  public UnaryCallable<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
      updateUserListDirectLicenseCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateUserListDirectLicenseCallable()");
  }

  public UnaryCallable<ListUserListDirectLicensesRequest, ListUserListDirectLicensesPagedResponse>
      listUserListDirectLicensesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUserListDirectLicensesPagedCallable()");
  }

  public UnaryCallable<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>
      listUserListDirectLicensesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUserListDirectLicensesCallable()");
  }

  @Override
  public abstract void close();
}
