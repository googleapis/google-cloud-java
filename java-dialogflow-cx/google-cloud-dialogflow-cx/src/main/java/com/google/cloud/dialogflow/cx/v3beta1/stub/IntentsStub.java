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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.IntentsClient.ListIntentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.IntentsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreateIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Intent;
import com.google.cloud.dialogflow.cx.v3beta1.ListIntentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListIntentsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateIntentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Intents service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class IntentsStub implements BackgroundResource {

  public UnaryCallable<ListIntentsRequest, ListIntentsPagedResponse> listIntentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIntentsPagedCallable()");
  }

  public UnaryCallable<ListIntentsRequest, ListIntentsResponse> listIntentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listIntentsCallable()");
  }

  public UnaryCallable<GetIntentRequest, Intent> getIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: getIntentCallable()");
  }

  public UnaryCallable<CreateIntentRequest, Intent> createIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: createIntentCallable()");
  }

  public UnaryCallable<UpdateIntentRequest, Intent> updateIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIntentCallable()");
  }

  public UnaryCallable<DeleteIntentRequest, Empty> deleteIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIntentCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
