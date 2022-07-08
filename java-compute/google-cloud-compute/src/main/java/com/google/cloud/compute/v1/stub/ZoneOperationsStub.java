/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ZoneOperationsClient.ListPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.LongRunningClient;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteZoneOperationRequest;
import com.google.cloud.compute.v1.DeleteZoneOperationResponse;
import com.google.cloud.compute.v1.GetZoneOperationRequest;
import com.google.cloud.compute.v1.ListZoneOperationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OperationList;
import com.google.cloud.compute.v1.WaitZoneOperationRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ZoneOperations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ZoneOperationsStub implements BackgroundResource {

  @BetaApi
  public LongRunningClient longRunningClient() {
    throw new UnsupportedOperationException("Not implemented: longRunningClient()");
  }

  public UnaryCallable<DeleteZoneOperationRequest, DeleteZoneOperationResponse> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetZoneOperationRequest, Operation> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<ListZoneOperationsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListZoneOperationsRequest, OperationList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<WaitZoneOperationRequest, Operation> waitCallable() {
    throw new UnsupportedOperationException("Not implemented: waitCallable()");
  }

  @Override
  public abstract void close();
}
