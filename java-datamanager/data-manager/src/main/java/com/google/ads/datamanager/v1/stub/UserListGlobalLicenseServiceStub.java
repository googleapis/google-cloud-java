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

import static com.google.ads.datamanager.v1.UserListGlobalLicenseServiceClient.ListUserListGlobalLicenseCustomerInfosPagedResponse;
import static com.google.ads.datamanager.v1.UserListGlobalLicenseServiceClient.ListUserListGlobalLicensesPagedResponse;

import com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse;
import com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse;
import com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.UserListGlobalLicense;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the UserListGlobalLicenseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class UserListGlobalLicenseServiceStub implements BackgroundResource {

  public UnaryCallable<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
      createUserListGlobalLicenseCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createUserListGlobalLicenseCallable()");
  }

  public UnaryCallable<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
      updateUserListGlobalLicenseCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateUserListGlobalLicenseCallable()");
  }

  public UnaryCallable<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
      getUserListGlobalLicenseCallable() {
    throw new UnsupportedOperationException("Not implemented: getUserListGlobalLicenseCallable()");
  }

  public UnaryCallable<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesPagedResponse>
      listUserListGlobalLicensesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUserListGlobalLicensesPagedCallable()");
  }

  public UnaryCallable<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>
      listUserListGlobalLicensesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUserListGlobalLicensesCallable()");
  }

  public UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosPagedResponse>
      listUserListGlobalLicenseCustomerInfosPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUserListGlobalLicenseCustomerInfosPagedCallable()");
  }

  public UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse>
      listUserListGlobalLicenseCustomerInfosCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUserListGlobalLicenseCustomerInfosCallable()");
  }

  @Override
  public abstract void close();
}
