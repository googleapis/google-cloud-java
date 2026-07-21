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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.LicenseConfigServiceClient.ListLicenseConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse;
import com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.LicenseConfig;
import com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest;
import com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse;
import com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse;
import com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LicenseConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class LicenseConfigServiceStub implements BackgroundResource {

  public UnaryCallable<CreateLicenseConfigRequest, LicenseConfig> createLicenseConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createLicenseConfigCallable()");
  }

  public UnaryCallable<UpdateLicenseConfigRequest, LicenseConfig> updateLicenseConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLicenseConfigCallable()");
  }

  public UnaryCallable<GetLicenseConfigRequest, LicenseConfig> getLicenseConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getLicenseConfigCallable()");
  }

  public UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsPagedResponse>
      listLicenseConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLicenseConfigsPagedCallable()");
  }

  public UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsResponse>
      listLicenseConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLicenseConfigsCallable()");
  }

  public UnaryCallable<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
      distributeLicenseConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: distributeLicenseConfigCallable()");
  }

  public UnaryCallable<RetractLicenseConfigRequest, RetractLicenseConfigResponse>
      retractLicenseConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: retractLicenseConfigCallable()");
  }

  @Override
  public abstract void close();
}
