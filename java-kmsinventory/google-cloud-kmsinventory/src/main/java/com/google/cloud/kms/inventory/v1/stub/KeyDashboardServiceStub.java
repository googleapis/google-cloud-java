/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.kms.inventory.v1.stub;

import static com.google.cloud.kms.inventory.v1.KeyDashboardServiceClient.ListCryptoKeysPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest;
import com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the KeyDashboardService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class KeyDashboardServiceStub implements BackgroundResource {

  public UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysPagedResponse>
      listCryptoKeysPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCryptoKeysPagedCallable()");
  }

  public UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysResponse> listCryptoKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: listCryptoKeysCallable()");
  }

  @Override
  public abstract void close();
}
