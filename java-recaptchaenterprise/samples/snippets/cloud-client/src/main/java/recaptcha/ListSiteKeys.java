/*
 * Copyright 2021 Google LLC
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

package recaptcha;

// [START recaptcha_enterprise_list_site_keys]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.recaptchaenterprise.v1.Key;
import com.google.recaptchaenterprise.v1.ListKeysRequest;
import com.google.recaptchaenterprise.v1.ProjectName;
import java.io.IOException;

public class ListSiteKeys {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectID = "your-project-id";

    listSiteKeys(projectID);
  }

  /**
   * List all keys present under the given project ID.
   *
   * @param projectID: GCloud Project ID.
   */
  public static void listSiteKeys(String projectID) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `client.close()` method on the client to safely
    // clean up any remaining background resources.
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {
      // Set the project ID to list the keys present in it.
      ListKeysRequest listKeysRequest =
          ListKeysRequest.newBuilder().setParent(ProjectName.of(projectID).toString()).build();

      System.out.println("Listing reCAPTCHA site keys: ");
      for (Key key : client.listKeys(listKeysRequest).iterateAll()) {
        System.out.println(key.getName());
      }
    }
  }
}
// [END recaptcha_enterprise_list_site_keys]
