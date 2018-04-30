/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.RegionAutoscalerClient.ListRegionAutoscalersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.Autoscaler;
import com.google.cloud.compute.v1.DeleteRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.GetRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.InsertRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.ListRegionAutoscalersHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.RegionAutoscalerList;
import com.google.cloud.compute.v1.UpdateRegionAutoscalerHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RegionAutoscalerStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteRegionAutoscalerHttpRequest, Operation>
      deleteRegionAutoscalerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRegionAutoscalerCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRegionAutoscalerHttpRequest, Autoscaler> getRegionAutoscalerCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegionAutoscalerCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRegionAutoscalerHttpRequest, Operation>
      insertRegionAutoscalerCallable() {
    throw new UnsupportedOperationException("Not implemented: insertRegionAutoscalerCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionAutoscalersHttpRequest, ListRegionAutoscalersPagedResponse>
      listRegionAutoscalersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionAutoscalersPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionAutoscalersHttpRequest, RegionAutoscalerList>
      listRegionAutoscalersCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionAutoscalersCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchRegionAutoscalerHttpRequest, Operation>
      patchRegionAutoscalerCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRegionAutoscalerCallable()");
  }

  @BetaApi
  public UnaryCallable<UpdateRegionAutoscalerHttpRequest, Operation>
      updateRegionAutoscalerCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRegionAutoscalerCallable()");
  }

  @Override
  public abstract void close();
}
