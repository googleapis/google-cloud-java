/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.LicenseClient.ListLicensesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteLicenseHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyLicenseHttpRequest;
import com.google.cloud.compute.v1.GetLicenseHttpRequest;
import com.google.cloud.compute.v1.InsertLicenseHttpRequest;
import com.google.cloud.compute.v1.License;
import com.google.cloud.compute.v1.LicensesListResponse;
import com.google.cloud.compute.v1.ListLicensesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyLicenseHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsLicenseHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class LicenseStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteLicenseHttpRequest, Operation> deleteLicenseCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLicenseCallable()");
  }

  @BetaApi
  public UnaryCallable<GetLicenseHttpRequest, License> getLicenseCallable() {
    throw new UnsupportedOperationException("Not implemented: getLicenseCallable()");
  }

  @BetaApi
  public UnaryCallable<GetIamPolicyLicenseHttpRequest, Policy> getIamPolicyLicenseCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyLicenseCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertLicenseHttpRequest, Operation> insertLicenseCallable() {
    throw new UnsupportedOperationException("Not implemented: insertLicenseCallable()");
  }

  @BetaApi
  public UnaryCallable<ListLicensesHttpRequest, ListLicensesPagedResponse>
      listLicensesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLicensesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListLicensesHttpRequest, LicensesListResponse> listLicensesCallable() {
    throw new UnsupportedOperationException("Not implemented: listLicensesCallable()");
  }

  @BetaApi
  public UnaryCallable<SetIamPolicyLicenseHttpRequest, Policy> setIamPolicyLicenseCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyLicenseCallable()");
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsLicenseHttpRequest, TestPermissionsResponse>
      testIamPermissionsLicenseCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsLicenseCallable()");
  }

  @Override
  public abstract void close();
}
