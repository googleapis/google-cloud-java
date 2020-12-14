/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.talent.v4beta1.stub;

import static com.google.cloud.talent.v4beta1.TenantServiceClient.ListTenantsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4beta1.CreateTenantRequest;
import com.google.cloud.talent.v4beta1.DeleteTenantRequest;
import com.google.cloud.talent.v4beta1.GetTenantRequest;
import com.google.cloud.talent.v4beta1.ListTenantsRequest;
import com.google.cloud.talent.v4beta1.ListTenantsResponse;
import com.google.cloud.talent.v4beta1.Tenant;
import com.google.cloud.talent.v4beta1.UpdateTenantRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TenantService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class TenantServiceStub implements BackgroundResource {

  public UnaryCallable<CreateTenantRequest, Tenant> createTenantCallable() {
    throw new UnsupportedOperationException("Not implemented: createTenantCallable()");
  }

  public UnaryCallable<GetTenantRequest, Tenant> getTenantCallable() {
    throw new UnsupportedOperationException("Not implemented: getTenantCallable()");
  }

  public UnaryCallable<UpdateTenantRequest, Tenant> updateTenantCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTenantCallable()");
  }

  public UnaryCallable<DeleteTenantRequest, Empty> deleteTenantCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTenantCallable()");
  }

  public UnaryCallable<ListTenantsRequest, ListTenantsPagedResponse> listTenantsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTenantsPagedCallable()");
  }

  public UnaryCallable<ListTenantsRequest, ListTenantsResponse> listTenantsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTenantsCallable()");
  }

  @Override
  public abstract void close();
}
