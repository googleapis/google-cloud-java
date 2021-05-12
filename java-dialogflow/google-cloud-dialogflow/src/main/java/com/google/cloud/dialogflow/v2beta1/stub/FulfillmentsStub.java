/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dialogflow.v2beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.Fulfillment;
import com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest;
import com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Fulfillments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class FulfillmentsStub implements BackgroundResource {

  public UnaryCallable<GetFulfillmentRequest, Fulfillment> getFulfillmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getFulfillmentCallable()");
  }

  public UnaryCallable<UpdateFulfillmentRequest, Fulfillment> updateFulfillmentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFulfillmentCallable()");
  }

  @Override
  public abstract void close();
}
