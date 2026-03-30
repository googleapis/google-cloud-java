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

// [START storage_delete_hmac_key]

import com.google.cloud.storage.HmacKey;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;

public class DeleteHmacKey {
  public static void deleteHmacKey(String accessId, String projectId) throws StorageException {

    // The access ID of the HMAC key.
    // String accessId = "GOOG0234230X00";

    // The ID of the project to which the service account belongs.
    // String projectId = "project-id";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    HmacKey.HmacKeyMetadata metadata =
        storage.getHmacKey(accessId, Storage.GetHmacKeyOption.projectId(projectId));
    storage.deleteHmacKey(metadata);

    System.out.println(
        "The key is deleted, though it will still appear in "
            + "getHmacKeys() results if called with showDeletedKey.");
  }
}
// [END storage_delete_hmac_key]
