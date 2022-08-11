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

// [START essentialcontacts_v1_generated_essentialcontactsservicesettings_createcontact_sync]
import com.google.cloud.essentialcontacts.v1.EssentialContactsServiceSettings;
import java.time.Duration;

public class SyncCreateContact {

  public static void main(String[] args) throws Exception {
    syncCreateContact();
  }

  public static void syncCreateContact() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    EssentialContactsServiceSettings.Builder essentialContactsServiceSettingsBuilder =
        EssentialContactsServiceSettings.newBuilder();
    essentialContactsServiceSettingsBuilder
        .createContactSettings()
        .setRetrySettings(
            essentialContactsServiceSettingsBuilder
                .createContactSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    EssentialContactsServiceSettings essentialContactsServiceSettings =
        essentialContactsServiceSettingsBuilder.build();
  }
}
// [END essentialcontacts_v1_generated_essentialcontactsservicesettings_createcontact_sync]
