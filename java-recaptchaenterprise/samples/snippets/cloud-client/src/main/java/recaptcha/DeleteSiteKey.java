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

// [START recaptcha_enterprise_delete_site_key]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.recaptchaenterprise.v1.DeleteKeyRequest;
import com.google.recaptchaenterprise.v1.KeyName;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DeleteSiteKey {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectID = "your-project-id";
    String recaptchaSiteKey = "recaptcha-site-key";

    deleteSiteKey(projectID, recaptchaSiteKey);
  }

  /**
   * Delete the given reCAPTCHA site key present under the project ID.
   *
   * @param projectID: GCloud Project ID.
   * @param recaptchaSiteKey: Specify the site key to be deleted.
   */
  public static void deleteSiteKey(String projectID, String recaptchaSiteKey)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `client.close()` method on the client to safely
    // clean up any remaining background resources.
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {

      // Set the project ID and reCAPTCHA site key.
      DeleteKeyRequest deleteKeyRequest =
          DeleteKeyRequest.newBuilder()
              .setName(KeyName.of(projectID, recaptchaSiteKey).toString())
              .build();

      client.deleteKeyCallable().futureCall(deleteKeyRequest).get(5, TimeUnit.SECONDS);
      System.out.println("reCAPTCHA Site key successfully deleted !");
    }
  }
}
// [END recaptcha_enterprise_delete_site_key]
