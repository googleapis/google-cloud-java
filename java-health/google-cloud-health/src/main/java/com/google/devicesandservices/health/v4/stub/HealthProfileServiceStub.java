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

package com.google.devicesandservices.health.v4.stub;

import static com.google.devicesandservices.health.v4.HealthProfileServiceClient.ListPairedDevicesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devicesandservices.health.v4.GetIdentityRequest;
import com.google.devicesandservices.health.v4.GetIrnProfileRequest;
import com.google.devicesandservices.health.v4.GetPairedDeviceRequest;
import com.google.devicesandservices.health.v4.GetProfileRequest;
import com.google.devicesandservices.health.v4.GetSettingsRequest;
import com.google.devicesandservices.health.v4.Identity;
import com.google.devicesandservices.health.v4.IrnProfile;
import com.google.devicesandservices.health.v4.ListPairedDevicesRequest;
import com.google.devicesandservices.health.v4.ListPairedDevicesResponse;
import com.google.devicesandservices.health.v4.PairedDevice;
import com.google.devicesandservices.health.v4.Profile;
import com.google.devicesandservices.health.v4.Settings;
import com.google.devicesandservices.health.v4.UpdateProfileRequest;
import com.google.devicesandservices.health.v4.UpdateSettingsRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the HealthProfileService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
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
