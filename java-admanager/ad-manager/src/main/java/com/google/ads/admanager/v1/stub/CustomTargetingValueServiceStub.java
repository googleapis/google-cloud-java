/*
 * Copyright 2024 Google LLC
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

import static com.google.ads.admanager.v1.CustomTargetingValueServiceClient.ListCustomTargetingValuesPagedResponse;

import com.google.ads.admanager.v1.CustomTargetingValue;
import com.google.ads.admanager.v1.GetCustomTargetingValueRequest;
import com.google.ads.admanager.v1.ListCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.ListCustomTargetingValuesResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CustomTargetingValueService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CustomTargetingValueServiceStub implements BackgroundResource {

  public UnaryCallable<GetCustomTargetingValueRequest, CustomTargetingValue>
      getCustomTargetingValueCallable() {
    throw new UnsupportedOperationException("Not implemented: getCustomTargetingValueCallable()");
  }

  public UnaryCallable<ListCustomTargetingValuesRequest, ListCustomTargetingValuesPagedResponse>
      listCustomTargetingValuesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCustomTargetingValuesPagedCallable()");
  }

  public UnaryCallable<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>
      listCustomTargetingValuesCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomTargetingValuesCallable()");
  }

  @Override
  public abstract void close();
}
