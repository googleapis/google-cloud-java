/*
 * Copyright 2022 Google Inc.
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

// [START auth_cloud_explicit_adc]

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class AuthenticateExplicit {

  public static void main(String[] args) throws IOException, GeneralSecurityException {
    // TODO(Developer):
    //  1. Replace the project variable below.
    //  2. Make sure you have the necessary permission to list storage buckets
    // "storage.buckets.list"

    String projectId = "your-google-cloud-project-id";

    authenticateExplicit(projectId);
  }

  // List storage buckets by authenticating with ADC.
  public static void authenticateExplicit(String projectId) throws IOException {
    // Construct the GoogleCredentials object which obtains the default configuration from your
    // working environment.
    // GoogleCredentials.getApplicationDefault() will give you ComputeEngineCredentials
    // if you are on a GCE (or other metadata server supported environments).
    GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
    // If you are authenticating to a Cloud API, you can let the library include the default scope,
    // https://www.googleapis.com/auth/cloud-platform, because IAM is used to provide fine-grained
    // permissions for Cloud.
    // If you need to provide a scope, specify it as follows:
    // GoogleCredentials credentials = GoogleCredentials.getApplicationDefault()
    //     .createScoped(scope);
    // For more information on scopes to use,
    // see: https://developers.google.com/identity/protocols/oauth2/scopes

    // Construct the Storage client.
    Storage storage =
        StorageOptions.newBuilder()
            .setCredentials(credentials)
            .setProjectId(projectId)
            .build()
            .getService();

    System.out.println("Buckets:");
    Page<Bucket> buckets = storage.list();
    for (Bucket bucket : buckets.iterateAll()) {
      System.out.println(bucket.toString());
    }
    System.out.println("Listed all storage buckets.");
  }
}
// [END auth_cloud_explicit_adc]
