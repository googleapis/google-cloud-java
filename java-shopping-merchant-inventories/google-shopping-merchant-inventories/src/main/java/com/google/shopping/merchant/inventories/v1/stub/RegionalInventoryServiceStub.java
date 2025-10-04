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

package com.google.shopping.merchant.inventories.v1.stub;

import static com.google.shopping.merchant.inventories.v1.RegionalInventoryServiceClient.ListRegionalInventoriesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.inventories.v1.DeleteRegionalInventoryRequest;
import com.google.shopping.merchant.inventories.v1.InsertRegionalInventoryRequest;
import com.google.shopping.merchant.inventories.v1.ListRegionalInventoriesRequest;
import com.google.shopping.merchant.inventories.v1.ListRegionalInventoriesResponse;
import com.google.shopping.merchant.inventories.v1.RegionalInventory;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionalInventoryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionalInventoryServiceStub implements BackgroundResource {

  public UnaryCallable<ListRegionalInventoriesRequest, ListRegionalInventoriesPagedResponse>
      listRegionalInventoriesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionalInventoriesPagedCallable()");
  }

  public UnaryCallable<ListRegionalInventoriesRequest, ListRegionalInventoriesResponse>
      listRegionalInventoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionalInventoriesCallable()");
  }

  public UnaryCallable<InsertRegionalInventoryRequest, RegionalInventory>
      insertRegionalInventoryCallable() {
    throw new UnsupportedOperationException("Not implemented: insertRegionalInventoryCallable()");
  }

  public UnaryCallable<DeleteRegionalInventoryRequest, Empty> deleteRegionalInventoryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRegionalInventoryCallable()");
  }

  @Override
  public abstract void close();
}
