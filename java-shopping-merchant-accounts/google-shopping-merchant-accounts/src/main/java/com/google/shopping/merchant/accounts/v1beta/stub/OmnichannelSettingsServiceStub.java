/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.OmnichannelSettingsServiceClient.ListOmnichannelSettingsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest;
import com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest;
import com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse;
import com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting;
import com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest;
import com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationResponse;
import com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the OmnichannelSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class OmnichannelSettingsServiceStub implements BackgroundResource {

  public UnaryCallable<GetOmnichannelSettingRequest, OmnichannelSetting>
      getOmnichannelSettingCallable() {
    throw new UnsupportedOperationException("Not implemented: getOmnichannelSettingCallable()");
  }

  public UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsPagedResponse>
      listOmnichannelSettingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOmnichannelSettingsPagedCallable()");
  }

  public UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>
      listOmnichannelSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listOmnichannelSettingsCallable()");
  }

  public UnaryCallable<CreateOmnichannelSettingRequest, OmnichannelSetting>
      createOmnichannelSettingCallable() {
    throw new UnsupportedOperationException("Not implemented: createOmnichannelSettingCallable()");
  }

  public UnaryCallable<UpdateOmnichannelSettingRequest, OmnichannelSetting>
      updateOmnichannelSettingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOmnichannelSettingCallable()");
  }

  public UnaryCallable<RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
      requestInventoryVerificationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: requestInventoryVerificationCallable()");
  }

  @Override
  public abstract void close();
}
