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

package com.google.shopping.merchant.inventories.v1beta.stub;

import static com.google.shopping.merchant.inventories.v1beta.LocalInventoryServiceClient.ListLocalInventoriesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.inventories.v1beta.DeleteLocalInventoryRequest;
import com.google.shopping.merchant.inventories.v1beta.InsertLocalInventoryRequest;
import com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesRequest;
import com.google.shopping.merchant.inventories.v1beta.ListLocalInventoriesResponse;
import com.google.shopping.merchant.inventories.v1beta.LocalInventory;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LocalInventoryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class LocalInventoryServiceStub implements BackgroundResource {

  public UnaryCallable<ListLocalInventoriesRequest, ListLocalInventoriesPagedResponse>
      listLocalInventoriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocalInventoriesPagedCallable()");
  }

  public UnaryCallable<ListLocalInventoriesRequest, ListLocalInventoriesResponse>
      listLocalInventoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocalInventoriesCallable()");
  }

  public UnaryCallable<InsertLocalInventoryRequest, LocalInventory> insertLocalInventoryCallable() {
    throw new UnsupportedOperationException("Not implemented: insertLocalInventoryCallable()");
  }

  public UnaryCallable<DeleteLocalInventoryRequest, Empty> deleteLocalInventoryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLocalInventoryCallable()");
  }

  @Override
  public abstract void close();
}
