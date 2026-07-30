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

import static com.google.ads.admanager.v1.CustomTargetingValueServiceClient.ListCustomTargetingValuesPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.BatchActivateCustomTargetingValuesResponse;
import com.google.ads.admanager.v1.BatchCreateCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.BatchCreateCustomTargetingValuesResponse;
import com.google.ads.admanager.v1.BatchDeactivateCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.BatchDeactivateCustomTargetingValuesResponse;
import com.google.ads.admanager.v1.BatchUpdateCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.BatchUpdateCustomTargetingValuesResponse;
import com.google.ads.admanager.v1.CreateCustomTargetingValueRequest;
import com.google.ads.admanager.v1.CustomTargetingValue;
import com.google.ads.admanager.v1.GetCustomTargetingValueRequest;
import com.google.ads.admanager.v1.ListCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.ListCustomTargetingValuesResponse;
import com.google.ads.admanager.v1.UpdateCustomTargetingValueRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CustomTargetingValueService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
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

  public UnaryCallable<CreateCustomTargetingValueRequest, CustomTargetingValue>
      createCustomTargetingValueCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCustomTargetingValueCallable()");
  }

  public UnaryCallable<
          BatchCreateCustomTargetingValuesRequest, BatchCreateCustomTargetingValuesResponse>
      batchCreateCustomTargetingValuesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateCustomTargetingValuesCallable()");
  }

  public UnaryCallable<UpdateCustomTargetingValueRequest, CustomTargetingValue>
      updateCustomTargetingValueCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateCustomTargetingValueCallable()");
  }

  public UnaryCallable<
          BatchUpdateCustomTargetingValuesRequest, BatchUpdateCustomTargetingValuesResponse>
      batchUpdateCustomTargetingValuesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateCustomTargetingValuesCallable()");
  }

  public UnaryCallable<
          BatchActivateCustomTargetingValuesRequest, BatchActivateCustomTargetingValuesResponse>
      batchActivateCustomTargetingValuesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchActivateCustomTargetingValuesCallable()");
  }

  public UnaryCallable<
          BatchDeactivateCustomTargetingValuesRequest, BatchDeactivateCustomTargetingValuesResponse>
      batchDeactivateCustomTargetingValuesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeactivateCustomTargetingValuesCallable()");
  }

  @Override
  public abstract void close();
}
