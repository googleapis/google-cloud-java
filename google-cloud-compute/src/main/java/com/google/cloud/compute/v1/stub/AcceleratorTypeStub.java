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

import static com.google.cloud.compute.v1.AcceleratorTypeClient.AggregatedListAcceleratorTypesPagedResponse;
import static com.google.cloud.compute.v1.AcceleratorTypeClient.ListAcceleratorTypesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AcceleratorType;
import com.google.cloud.compute.v1.AcceleratorTypeAggregatedList;
import com.google.cloud.compute.v1.AcceleratorTypeList;
import com.google.cloud.compute.v1.AggregatedListAcceleratorTypesHttpRequest;
import com.google.cloud.compute.v1.GetAcceleratorTypeHttpRequest;
import com.google.cloud.compute.v1.ListAcceleratorTypesHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class AcceleratorTypeStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<
          AggregatedListAcceleratorTypesHttpRequest, AggregatedListAcceleratorTypesPagedResponse>
      aggregatedListAcceleratorTypesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListAcceleratorTypesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListAcceleratorTypesHttpRequest, AcceleratorTypeAggregatedList>
      aggregatedListAcceleratorTypesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListAcceleratorTypesCallable()");
  }

  @BetaApi
  public UnaryCallable<GetAcceleratorTypeHttpRequest, AcceleratorType>
      getAcceleratorTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: getAcceleratorTypeCallable()");
  }

  @BetaApi
  public UnaryCallable<ListAcceleratorTypesHttpRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAcceleratorTypesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListAcceleratorTypesHttpRequest, AcceleratorTypeList>
      listAcceleratorTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAcceleratorTypesCallable()");
  }

  @Override
  public abstract void close();
}
