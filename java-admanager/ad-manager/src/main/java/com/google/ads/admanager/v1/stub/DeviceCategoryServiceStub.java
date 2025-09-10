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

import static com.google.ads.admanager.v1.DeviceCategoryServiceClient.ListDeviceCategoriesPagedResponse;

import com.google.ads.admanager.v1.DeviceCategory;
import com.google.ads.admanager.v1.GetDeviceCategoryRequest;
import com.google.ads.admanager.v1.ListDeviceCategoriesRequest;
import com.google.ads.admanager.v1.ListDeviceCategoriesResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DeviceCategoryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DeviceCategoryServiceStub implements BackgroundResource {

  public UnaryCallable<GetDeviceCategoryRequest, DeviceCategory> getDeviceCategoryCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeviceCategoryCallable()");
  }

  public UnaryCallable<ListDeviceCategoriesRequest, ListDeviceCategoriesPagedResponse>
      listDeviceCategoriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeviceCategoriesPagedCallable()");
  }

  public UnaryCallable<ListDeviceCategoriesRequest, ListDeviceCategoriesResponse>
      listDeviceCategoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeviceCategoriesCallable()");
  }

  @Override
  public abstract void close();
}
