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

import static com.google.cloud.dialogflow.cx.v3beta1.WebhooksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.WebhooksClient.ListWebhooksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreateWebhookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteWebhookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetWebhookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListWebhooksResponse;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Webhook;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Webhooks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class WebhooksStub implements BackgroundResource {

  public UnaryCallable<ListWebhooksRequest, ListWebhooksPagedResponse> listWebhooksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listWebhooksPagedCallable()");
  }

  public UnaryCallable<ListWebhooksRequest, ListWebhooksResponse> listWebhooksCallable() {
    throw new UnsupportedOperationException("Not implemented: listWebhooksCallable()");
  }

  public UnaryCallable<GetWebhookRequest, Webhook> getWebhookCallable() {
    throw new UnsupportedOperationException("Not implemented: getWebhookCallable()");
  }

  public UnaryCallable<CreateWebhookRequest, Webhook> createWebhookCallable() {
    throw new UnsupportedOperationException("Not implemented: createWebhookCallable()");
  }

  public UnaryCallable<UpdateWebhookRequest, Webhook> updateWebhookCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWebhookCallable()");
  }

  public UnaryCallable<DeleteWebhookRequest, Empty> deleteWebhookCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWebhookCallable()");
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
