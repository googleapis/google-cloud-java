/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.examples.storage.buckets;

// [START storage_set_client_endpoint]

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class SetClientEndpoint {

  public static void setClientEndpoint(String projectId, String endpoint) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The endpoint you wish to target
    // String endpoint = "https://storage.googleapis.com"

    Storage storage =
        StorageOptions.newBuilder().setProjectId(projectId).setHost(endpoint).build().getService();

    System.out.println(
        "Storage Client initialized with endpoint " + storage.getOptions().getHost());
  }
}

// [END storage_set_client_endpoint]
