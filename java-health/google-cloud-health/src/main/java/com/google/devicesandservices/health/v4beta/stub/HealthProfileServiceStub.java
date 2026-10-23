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

package com.google.devicesandservices.health.v4beta.stub;

import static com.google.devicesandservices.health.v4beta.HealthProfileServiceClient.ListPairedDevicesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devicesandservices.health.v4beta.GetIdentityRequest;
import com.google.devicesandservices.health.v4beta.GetIrnProfileRequest;
import com.google.devicesandservices.health.v4beta.GetPairedDeviceRequest;
import com.google.devicesandservices.health.v4beta.GetProfileRequest;
import com.google.devicesandservices.health.v4beta.GetSettingsRequest;
import com.google.devicesandservices.health.v4beta.Identity;
import com.google.devicesandservices.health.v4beta.IrnProfile;
import com.google.devicesandservices.health.v4beta.ListPairedDevicesRequest;
import com.google.devicesandservices.health.v4beta.ListPairedDevicesResponse;
import com.google.devicesandservices.health.v4beta.PairedDevice;
import com.google.devicesandservices.health.v4beta.Profile;
import com.google.devicesandservices.health.v4beta.Settings;
import com.google.devicesandservices.health.v4beta.UpdateProfileRequest;
import com.google.devicesandservices.health.v4beta.UpdateSettingsRequest;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the HealthProfileService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class HealthProfileServiceStub implements BackgroundResource {

  public UnaryCallable<GetProfileRequest, Profile> getProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getProfileCallable()");
  }

  public UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProfileCallable()");
  }

  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getSettingsCallable()");
  }

  public UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSettingsCallable()");
  }

  public UnaryCallable<GetIdentityRequest, Identity> getIdentityCallable() {
    throw new UnsupportedOperationException("Not implemented: getIdentityCallable()");
  }

  public UnaryCallable<GetIrnProfileRequest, IrnProfile> getIrnProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getIrnProfileCallable()");
  }

  public UnaryCallable<GetPairedDeviceRequest, PairedDevice> getPairedDeviceCallable() {
    throw new UnsupportedOperationException("Not implemented: getPairedDeviceCallable()");
  }

  public UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesPagedResponse>
      listPairedDevicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPairedDevicesPagedCallable()");
  }

  public UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesResponse>
      listPairedDevicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPairedDevicesCallable()");
  }

  @Override
  public abstract void close();
}
