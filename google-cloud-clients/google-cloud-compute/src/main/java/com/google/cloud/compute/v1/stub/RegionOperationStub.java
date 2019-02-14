/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionOperationClient.ListRegionOperationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionOperationHttpRequest;
import com.google.cloud.compute.v1.GetRegionOperationHttpRequest;
import com.google.cloud.compute.v1.ListRegionOperationsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OperationList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RegionOperationStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteRegionOperationHttpRequest, Void> deleteRegionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRegionOperationCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRegionOperationHttpRequest, Operation> getRegionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegionOperationCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionOperationsHttpRequest, ListRegionOperationsPagedResponse>
      listRegionOperationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionOperationsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionOperationsHttpRequest, OperationList>
      listRegionOperationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionOperationsCallable()");
  }

  @Override
  public abstract void close();
}
