/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1.samples;

// [START dialogflow_v3beta1_generated_Webhooks_UpdateWebhook_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateWebhookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Webhook;
import com.google.cloud.dialogflow.cx.v3beta1.WebhooksClient;
import com.google.protobuf.FieldMask;

public class AsyncUpdateWebhook {

  public static void main(String[] args) throws Exception {
    asyncUpdateWebhook();
  }

  public static void asyncUpdateWebhook() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WebhooksClient webhooksClient = WebhooksClient.create()) {
      UpdateWebhookRequest request =
          UpdateWebhookRequest.newBuilder()
              .setWebhook(Webhook.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<Webhook> future = webhooksClient.updateWebhookCallable().futureCall(request);
      // Do something.
      Webhook response = future.get();
    }
  }
}
// [END dialogflow_v3beta1_generated_Webhooks_UpdateWebhook_async]
