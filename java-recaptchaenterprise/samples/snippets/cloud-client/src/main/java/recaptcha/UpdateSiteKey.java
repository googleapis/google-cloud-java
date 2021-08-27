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

// [START recaptcha_enterprise_update_site_key]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.recaptchaenterprise.v1.GetKeyRequest;
import com.google.recaptchaenterprise.v1.Key;
import com.google.recaptchaenterprise.v1.KeyName;
import com.google.recaptchaenterprise.v1.UpdateKeyRequest;
import com.google.recaptchaenterprise.v1.WebKeySettings;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class UpdateSiteKey {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectID = "your-project-id";
    String recaptchaSiteKeyID = "recaptcha-site-key-id";
    String domainName = "domain-name";

    updateSiteKey(projectID, recaptchaSiteKeyID, domainName);
  }

  /**
   * Update the properties of the given site key present under the project id.
   *
   * @param projectID: GCloud Project ID.
   * @param recaptchaSiteKeyID: Specify the site key.
   * @param domainName: Specify the domain name for which the settings should be updated.
   */
  public static void updateSiteKey(String projectID, String recaptchaSiteKeyID, String domainName)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `client.close()` method on the client to safely
    // clean up any remaining background resources.
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {

      // Set the name and the new settings for the key.
      UpdateKeyRequest updateKeyRequest =
          UpdateKeyRequest.newBuilder()
              .setKey(
                  Key.newBuilder()
                      .setName(KeyName.of(projectID, recaptchaSiteKeyID).toString())
                      .setWebSettings(
                          WebKeySettings.newBuilder()
                              .setAllowAmpTraffic(true)
                              .addAllowedDomains(domainName)
                              .build())
                      .build())
              .build();

      client.updateKeyCallable().futureCall(updateKeyRequest).get();

      // Check if the key has been updated.
      GetKeyRequest getKeyRequest =
          GetKeyRequest.newBuilder()
              .setName(KeyName.of(projectID, recaptchaSiteKeyID).toString())
              .build();
      Key response = client.getKey(getKeyRequest);

      // Get the changed property.
      boolean allowedAmpTraffic = response.getWebSettings().getAllowAmpTraffic();
      if (!allowedAmpTraffic) {
        System.out.println(
            "Error! reCAPTCHA Site key property hasn't been updated. Please try again !");
        return;
      }
      System.out.println("reCAPTCHA Site key successfully updated !");
    }
  }
}
// [END recaptcha_enterprise_update_site_key]
