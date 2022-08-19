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

import static com.google.cloud.dialogflow.cx.v3beta1.SessionsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Sessions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SessionsStub implements BackgroundResource {

  public UnaryCallable<DetectIntentRequest, DetectIntentResponse> detectIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: detectIntentCallable()");
  }

  public BidiStreamingCallable<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
      streamingDetectIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: streamingDetectIntentCallable()");
  }

  public UnaryCallable<MatchIntentRequest, MatchIntentResponse> matchIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: matchIntentCallable()");
  }

  public UnaryCallable<FulfillIntentRequest, FulfillIntentResponse> fulfillIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: fulfillIntentCallable()");
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
