/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.resourcesettings.v1.stub;

import static com.google.cloud.resourcesettings.v1.ResourceSettingsServiceClient.ListSettingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcesettings.v1.GetSettingRequest;
import com.google.cloud.resourcesettings.v1.ListSettingsRequest;
import com.google.cloud.resourcesettings.v1.ListSettingsResponse;
import com.google.cloud.resourcesettings.v1.Setting;
import com.google.cloud.resourcesettings.v1.UpdateSettingRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ResourceSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ResourceSettingsServiceStub implements BackgroundResource {

  public UnaryCallable<ListSettingsRequest, ListSettingsPagedResponse> listSettingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSettingsPagedCallable()");
  }

  public UnaryCallable<ListSettingsRequest, ListSettingsResponse> listSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSettingsCallable()");
  }

  public UnaryCallable<GetSettingRequest, Setting> getSettingCallable() {
    throw new UnsupportedOperationException("Not implemented: getSettingCallable()");
  }

  public UnaryCallable<UpdateSettingRequest, Setting> updateSettingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSettingCallable()");
  }

  @Override
  public abstract void close();
}
