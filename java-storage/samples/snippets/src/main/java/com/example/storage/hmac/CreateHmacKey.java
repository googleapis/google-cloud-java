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

// [START storage_create_hmac_key]

import com.google.cloud.storage.HmacKey;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import java.util.Date;

public class CreateHmacKey {
  public static void createHmacKey(String serviceAccountEmail, String projectId)
      throws StorageException {

    // The service account email for which the new HMAC key will be created.
    // String serviceAccountEmail = "service-account@iam.gserviceaccount.com";

    // The ID of the project to which the service account belongs.
    // String projectId = "project-id";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    ServiceAccount account = ServiceAccount.of(serviceAccountEmail);
    HmacKey hmacKey =
        storage.createHmacKey(account, Storage.CreateHmacKeyOption.projectId(projectId));

    String secret = hmacKey.getSecretKey();
    HmacKey.HmacKeyMetadata metadata = hmacKey.getMetadata();

    System.out.println("The Base64 encoded secret is: " + secret);
    System.out.println("Do not lose that secret, there is no API to recover it.");
    System.out.println("The HMAC key metadata is:");
    System.out.println("ID: " + metadata.getId());
    System.out.println("Access ID: " + metadata.getAccessId());
    System.out.println("Project ID: " + metadata.getProjectId());
    System.out.println("Service Account Email: " + metadata.getServiceAccount().getEmail());
    System.out.println("State: " + metadata.getState().toString());
    System.out.println("Time Created: " + new Date(metadata.getCreateTime()).toString());
    System.out.println("Time Updated: " + new Date(metadata.getUpdateTime()).toString());
    System.out.println("ETag: " + metadata.getEtag());
  }
}
// [END storage_create_hmac_key]
