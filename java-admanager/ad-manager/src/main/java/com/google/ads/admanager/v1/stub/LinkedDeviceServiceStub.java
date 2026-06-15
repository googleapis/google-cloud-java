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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.LinkedDeviceServiceClient.ListLinkedDevicesPagedResponse;

import com.google.ads.admanager.v1.GetLinkedDeviceRequest;
import com.google.ads.admanager.v1.LinkedDevice;
import com.google.ads.admanager.v1.ListLinkedDevicesRequest;
import com.google.ads.admanager.v1.ListLinkedDevicesResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LinkedDeviceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LinkedDeviceServiceStub implements BackgroundResource {

  public UnaryCallable<GetLinkedDeviceRequest, LinkedDevice> getLinkedDeviceCallable() {
    throw new UnsupportedOperationException("Not implemented: getLinkedDeviceCallable()");
  }

  public UnaryCallable<ListLinkedDevicesRequest, ListLinkedDevicesPagedResponse>
      listLinkedDevicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLinkedDevicesPagedCallable()");
  }

  public UnaryCallable<ListLinkedDevicesRequest, ListLinkedDevicesResponse>
      listLinkedDevicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listLinkedDevicesCallable()");
  }

  @Override
  public abstract void close();
}
