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

package com.google.cloud.retail.v2alpha.stub;

import static com.google.cloud.retail.v2alpha.ControlServiceClient.ListControlsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.Control;
import com.google.cloud.retail.v2alpha.CreateControlRequest;
import com.google.cloud.retail.v2alpha.DeleteControlRequest;
import com.google.cloud.retail.v2alpha.GetControlRequest;
import com.google.cloud.retail.v2alpha.ListControlsRequest;
import com.google.cloud.retail.v2alpha.ListControlsResponse;
import com.google.cloud.retail.v2alpha.UpdateControlRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ControlService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ControlServiceStub implements BackgroundResource {

  public UnaryCallable<CreateControlRequest, Control> createControlCallable() {
    throw new UnsupportedOperationException("Not implemented: createControlCallable()");
  }

  public UnaryCallable<DeleteControlRequest, Empty> deleteControlCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteControlCallable()");
  }

  public UnaryCallable<UpdateControlRequest, Control> updateControlCallable() {
    throw new UnsupportedOperationException("Not implemented: updateControlCallable()");
  }

  public UnaryCallable<GetControlRequest, Control> getControlCallable() {
    throw new UnsupportedOperationException("Not implemented: getControlCallable()");
  }

  public UnaryCallable<ListControlsRequest, ListControlsPagedResponse> listControlsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listControlsPagedCallable()");
  }

  public UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable() {
    throw new UnsupportedOperationException("Not implemented: listControlsCallable()");
  }

  @Override
  public abstract void close();
}
