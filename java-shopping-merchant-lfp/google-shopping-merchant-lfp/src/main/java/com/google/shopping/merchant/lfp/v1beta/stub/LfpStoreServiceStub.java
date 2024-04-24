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

package com.google.shopping.merchant.lfp.v1beta.stub;

import static com.google.shopping.merchant.lfp.v1beta.LfpStoreServiceClient.ListLfpStoresPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest;
import com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest;
import com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest;
import com.google.shopping.merchant.lfp.v1beta.LfpStore;
import com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest;
import com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LfpStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class LfpStoreServiceStub implements BackgroundResource {

  public UnaryCallable<GetLfpStoreRequest, LfpStore> getLfpStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: getLfpStoreCallable()");
  }

  public UnaryCallable<InsertLfpStoreRequest, LfpStore> insertLfpStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: insertLfpStoreCallable()");
  }

  public UnaryCallable<DeleteLfpStoreRequest, Empty> deleteLfpStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLfpStoreCallable()");
  }

  public UnaryCallable<ListLfpStoresRequest, ListLfpStoresPagedResponse>
      listLfpStoresPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLfpStoresPagedCallable()");
  }

  public UnaryCallable<ListLfpStoresRequest, ListLfpStoresResponse> listLfpStoresCallable() {
    throw new UnsupportedOperationException("Not implemented: listLfpStoresCallable()");
  }

  @Override
  public abstract void close();
}
