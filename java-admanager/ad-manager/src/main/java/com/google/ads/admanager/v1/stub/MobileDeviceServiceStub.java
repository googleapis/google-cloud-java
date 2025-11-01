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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.MobileDeviceServiceClient.ListMobileDevicesPagedResponse;

import com.google.ads.admanager.v1.GetMobileDeviceRequest;
import com.google.ads.admanager.v1.ListMobileDevicesRequest;
import com.google.ads.admanager.v1.ListMobileDevicesResponse;
import com.google.ads.admanager.v1.MobileDevice;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MobileDeviceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class MobileDeviceServiceStub implements BackgroundResource {

  public UnaryCallable<GetMobileDeviceRequest, MobileDevice> getMobileDeviceCallable() {
    throw new UnsupportedOperationException("Not implemented: getMobileDeviceCallable()");
  }

  public UnaryCallable<ListMobileDevicesRequest, ListMobileDevicesPagedResponse>
      listMobileDevicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMobileDevicesPagedCallable()");
  }

  public UnaryCallable<ListMobileDevicesRequest, ListMobileDevicesResponse>
      listMobileDevicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listMobileDevicesCallable()");
  }

  @Override
  public abstract void close();
}
