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

package com.example.storage.hmac;

// [START storage_list_hmac_keys]

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.HmacKey;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;

public class ListHmacKeys {
  public static void listHmacKeys(String projectId) throws StorageException {
    // The ID of the project to which the service account belongs.
    // String projectId = "project-id";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    Page<HmacKey.HmacKeyMetadata> page =
        storage.listHmacKeys(Storage.ListHmacKeysOption.projectId(projectId));

    for (HmacKey.HmacKeyMetadata metadata : page.iterateAll()) {
      System.out.println("Service Account Email: " + metadata.getServiceAccount().getEmail());
      System.out.println("Access ID: " + metadata.getAccessId());
    }
  }
}
// [END storage_list_hmac_keys]
