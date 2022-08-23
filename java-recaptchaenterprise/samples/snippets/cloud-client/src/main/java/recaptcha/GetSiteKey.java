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

// [START recaptcha_enterprise_get_site_key]

import com.google.api.core.ApiFuture;
import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.recaptchaenterprise.v1.GetKeyRequest;
import com.google.recaptchaenterprise.v1.Key;
import com.google.recaptchaenterprise.v1.KeyName;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GetSiteKey {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectID = "your-project-id";
    String recaptchaSiteKey = "recaptcha-site-key";

    getSiteKey(projectID, recaptchaSiteKey);
  }

  /**
   * Get the reCAPTCHA site key present under the project ID.
   *
   * @param projectID: GCloud Project ID.
   * @param recaptchaSiteKey: Specify the site key to get the details.
   */
  public static void getSiteKey(String projectID, String recaptchaSiteKey)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `client.close()` method on the client to safely
    // clean up any remaining background resources.
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {

      // Construct the "GetSiteKey" request.
      GetKeyRequest getKeyRequest =
          GetKeyRequest.newBuilder()
              .setName(KeyName.of(projectID, recaptchaSiteKey).toString())
              .build();

      // Wait for the operation to complete.
      ApiFuture<Key> futureCall = client.getKeyCallable().futureCall(getKeyRequest);
      Key key = futureCall.get(5, TimeUnit.SECONDS);

      System.out.println("Successfully obtained the key !" + key.getName());
    }
  }
}
// [END recaptcha_enterprise_get_site_key]
