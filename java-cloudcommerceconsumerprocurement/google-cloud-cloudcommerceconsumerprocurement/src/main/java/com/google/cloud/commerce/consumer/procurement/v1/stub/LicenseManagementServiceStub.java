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

package com.google.cloud.commerce.consumer.procurement.v1.stub;

import static com.google.cloud.commerce.consumer.procurement.v1.LicenseManagementServiceClient.EnumerateLicensedUsersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.commerce.consumer.procurement.v1.AssignRequest;
import com.google.cloud.commerce.consumer.procurement.v1.AssignResponse;
import com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest;
import com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse;
import com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest;
import com.google.cloud.commerce.consumer.procurement.v1.LicensePool;
import com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest;
import com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse;
import com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LicenseManagementService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LicenseManagementServiceStub implements BackgroundResource {

  public UnaryCallable<GetLicensePoolRequest, LicensePool> getLicensePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getLicensePoolCallable()");
  }

  public UnaryCallable<UpdateLicensePoolRequest, LicensePool> updateLicensePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLicensePoolCallable()");
  }

  public UnaryCallable<AssignRequest, AssignResponse> assignCallable() {
    throw new UnsupportedOperationException("Not implemented: assignCallable()");
  }

  public UnaryCallable<UnassignRequest, UnassignResponse> unassignCallable() {
    throw new UnsupportedOperationException("Not implemented: unassignCallable()");
  }

  public UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersPagedResponse>
      enumerateLicensedUsersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: enumerateLicensedUsersPagedCallable()");
  }

  public UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>
      enumerateLicensedUsersCallable() {
    throw new UnsupportedOperationException("Not implemented: enumerateLicensedUsersCallable()");
  }

  @Override
  public abstract void close();
}
