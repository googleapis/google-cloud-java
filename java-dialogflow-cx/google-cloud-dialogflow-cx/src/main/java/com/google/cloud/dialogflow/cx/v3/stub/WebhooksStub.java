/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.WebhooksClient.ListWebhooksPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateWebhookRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteWebhookRequest;
import com.google.cloud.dialogflow.cx.v3.GetWebhookRequest;
import com.google.cloud.dialogflow.cx.v3.ListWebhooksRequest;
import com.google.cloud.dialogflow.cx.v3.ListWebhooksResponse;
import com.google.cloud.dialogflow.cx.v3.UpdateWebhookRequest;
import com.google.cloud.dialogflow.cx.v3.Webhook;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Webhooks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
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

  @Override
  public abstract void close();
}
