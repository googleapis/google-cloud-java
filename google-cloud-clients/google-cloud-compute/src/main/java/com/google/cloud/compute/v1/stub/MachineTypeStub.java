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

import static com.google.cloud.compute.v1.MachineTypeClient.AggregatedListMachineTypesPagedResponse;
import static com.google.cloud.compute.v1.MachineTypeClient.ListMachineTypesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListMachineTypesHttpRequest;
import com.google.cloud.compute.v1.GetMachineTypeHttpRequest;
import com.google.cloud.compute.v1.ListMachineTypesHttpRequest;
import com.google.cloud.compute.v1.MachineType;
import com.google.cloud.compute.v1.MachineTypeAggregatedList;
import com.google.cloud.compute.v1.MachineTypeList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class MachineTypeStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<
          AggregatedListMachineTypesHttpRequest, AggregatedListMachineTypesPagedResponse>
      aggregatedListMachineTypesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListMachineTypesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListMachineTypesHttpRequest, MachineTypeAggregatedList>
      aggregatedListMachineTypesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListMachineTypesCallable()");
  }

  @BetaApi
  public UnaryCallable<GetMachineTypeHttpRequest, MachineType> getMachineTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: getMachineTypeCallable()");
  }

  @BetaApi
  public UnaryCallable<ListMachineTypesHttpRequest, ListMachineTypesPagedResponse>
      listMachineTypesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMachineTypesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListMachineTypesHttpRequest, MachineTypeList> listMachineTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listMachineTypesCallable()");
  }

  @Override
  public abstract void close();
}
