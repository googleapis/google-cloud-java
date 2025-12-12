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

import static com.google.ads.admanager.v1.CustomTargetingKeyServiceClient.ListCustomTargetingKeysPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchActivateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.BatchCreateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchCreateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.BatchDeactivateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchDeactivateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.BatchUpdateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchUpdateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.CreateCustomTargetingKeyRequest;
import com.google.ads.admanager.v1.CustomTargetingKey;
import com.google.ads.admanager.v1.GetCustomTargetingKeyRequest;
import com.google.ads.admanager.v1.ListCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.ListCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.UpdateCustomTargetingKeyRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CustomTargetingKeyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CustomTargetingKeyServiceStub implements BackgroundResource {

  public UnaryCallable<GetCustomTargetingKeyRequest, CustomTargetingKey>
      getCustomTargetingKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: getCustomTargetingKeyCallable()");
  }

  public UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysPagedResponse>
      listCustomTargetingKeysPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCustomTargetingKeysPagedCallable()");
  }

  public UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
      listCustomTargetingKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomTargetingKeysCallable()");
  }

  public UnaryCallable<CreateCustomTargetingKeyRequest, CustomTargetingKey>
      createCustomTargetingKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: createCustomTargetingKeyCallable()");
  }

  public UnaryCallable<
          BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
      batchCreateCustomTargetingKeysCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateCustomTargetingKeysCallable()");
  }

  public UnaryCallable<UpdateCustomTargetingKeyRequest, CustomTargetingKey>
      updateCustomTargetingKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCustomTargetingKeyCallable()");
  }

  public UnaryCallable<
          BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
      batchUpdateCustomTargetingKeysCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateCustomTargetingKeysCallable()");
  }

  public UnaryCallable<
          BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
      batchActivateCustomTargetingKeysCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchActivateCustomTargetingKeysCallable()");
  }

  public UnaryCallable<
          BatchDeactivateCustomTargetingKeysRequest, BatchDeactivateCustomTargetingKeysResponse>
      batchDeactivateCustomTargetingKeysCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeactivateCustomTargetingKeysCallable()");
  }

  @Override
  public abstract void close();
}
