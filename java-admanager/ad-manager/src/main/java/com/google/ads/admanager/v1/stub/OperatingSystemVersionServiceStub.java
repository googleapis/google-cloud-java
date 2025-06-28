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

import static com.google.ads.admanager.v1.OperatingSystemVersionServiceClient.ListOperatingSystemVersionsPagedResponse;

import com.google.ads.admanager.v1.GetOperatingSystemVersionRequest;
import com.google.ads.admanager.v1.ListOperatingSystemVersionsRequest;
import com.google.ads.admanager.v1.ListOperatingSystemVersionsResponse;
import com.google.ads.admanager.v1.OperatingSystemVersion;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the OperatingSystemVersionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class OperatingSystemVersionServiceStub implements BackgroundResource {

  public UnaryCallable<GetOperatingSystemVersionRequest, OperatingSystemVersion>
      getOperatingSystemVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getOperatingSystemVersionCallable()");
  }

  public UnaryCallable<ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsPagedResponse>
      listOperatingSystemVersionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOperatingSystemVersionsPagedCallable()");
  }

  public UnaryCallable<ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsResponse>
      listOperatingSystemVersionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOperatingSystemVersionsCallable()");
  }

  @Override
  public abstract void close();
}
