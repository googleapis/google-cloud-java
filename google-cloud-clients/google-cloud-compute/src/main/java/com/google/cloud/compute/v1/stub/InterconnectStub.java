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

import static com.google.cloud.compute.v1.InterconnectClient.ListInterconnectsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteInterconnectHttpRequest;
import com.google.cloud.compute.v1.GetInterconnectHttpRequest;
import com.google.cloud.compute.v1.InsertInterconnectHttpRequest;
import com.google.cloud.compute.v1.Interconnect;
import com.google.cloud.compute.v1.InterconnectList;
import com.google.cloud.compute.v1.ListInterconnectsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchInterconnectHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class InterconnectStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteInterconnectHttpRequest, Operation> deleteInterconnectCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInterconnectCallable()");
  }

  @BetaApi
  public UnaryCallable<GetInterconnectHttpRequest, Interconnect> getInterconnectCallable() {
    throw new UnsupportedOperationException("Not implemented: getInterconnectCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertInterconnectHttpRequest, Operation> insertInterconnectCallable() {
    throw new UnsupportedOperationException("Not implemented: insertInterconnectCallable()");
  }

  @BetaApi
  public UnaryCallable<ListInterconnectsHttpRequest, ListInterconnectsPagedResponse>
      listInterconnectsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInterconnectsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListInterconnectsHttpRequest, InterconnectList> listInterconnectsCallable() {
    throw new UnsupportedOperationException("Not implemented: listInterconnectsCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchInterconnectHttpRequest, Operation> patchInterconnectCallable() {
    throw new UnsupportedOperationException("Not implemented: patchInterconnectCallable()");
  }

  @Override
  public abstract void close();
}
