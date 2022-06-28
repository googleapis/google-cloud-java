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

package com.google.cloud.eventarc.v1.samples;

// [START eventarc_v1_generated_eventarcclient_deletetrigger_stringboolean_sync]
import com.google.cloud.eventarc.v1.EventarcClient;
import com.google.cloud.eventarc.v1.Trigger;
import com.google.cloud.eventarc.v1.TriggerName;

public class SyncDeleteTriggerStringBoolean {

  public static void main(String[] args) throws Exception {
    syncDeleteTriggerStringBoolean();
  }

  public static void syncDeleteTriggerStringBoolean() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (EventarcClient eventarcClient = EventarcClient.create()) {
      String name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString();
      boolean allowMissing = true;
      Trigger response = eventarcClient.deleteTriggerAsync(name, allowMissing).get();
    }
  }
}
// [END eventarc_v1_generated_eventarcclient_deletetrigger_stringboolean_sync]
