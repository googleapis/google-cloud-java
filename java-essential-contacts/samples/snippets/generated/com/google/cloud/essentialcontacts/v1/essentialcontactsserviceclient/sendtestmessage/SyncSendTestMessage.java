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

package com.google.cloud.essentialcontacts.v1.samples;

// [START essentialcontacts_v1_generated_essentialcontactsserviceclient_sendtestmessage_sync]
import com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient;
import com.google.cloud.essentialcontacts.v1.NotificationCategory;
import com.google.cloud.essentialcontacts.v1.ProjectName;
import com.google.cloud.essentialcontacts.v1.SendTestMessageRequest;
import java.util.ArrayList;

public class SyncSendTestMessage {

  public static void main(String[] args) throws Exception {
    syncSendTestMessage();
  }

  public static void syncSendTestMessage() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (EssentialContactsServiceClient essentialContactsServiceClient =
        EssentialContactsServiceClient.create()) {
      SendTestMessageRequest request =
          SendTestMessageRequest.newBuilder()
              .addAllContacts(new ArrayList<String>())
              .setResource(ProjectName.of("[PROJECT]").toString())
              .setNotificationCategory(NotificationCategory.forNumber(0))
              .build();
      essentialContactsServiceClient.sendTestMessage(request);
    }
  }
}
// [END essentialcontacts_v1_generated_essentialcontactsserviceclient_sendtestmessage_sync]
