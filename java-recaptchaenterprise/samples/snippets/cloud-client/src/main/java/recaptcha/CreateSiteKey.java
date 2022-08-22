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

// [START recaptcha_enterprise_create_site_key]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.recaptchaenterprise.v1.CreateKeyRequest;
import com.google.recaptchaenterprise.v1.Key;
import com.google.recaptchaenterprise.v1.ProjectName;
import com.google.recaptchaenterprise.v1.WebKeySettings;
import com.google.recaptchaenterprise.v1.WebKeySettings.IntegrationType;
import java.io.IOException;

public class CreateSiteKey {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectID = "your-project-id";
    String domainName = "domain-name";

    createSiteKey(projectID, domainName);
  }

  /**
   * Create reCAPTCHA Site key which binds a domain name to a unique key.
   *
   * @param projectID : GCloud Project ID.
   * @param domainName : Specify the domain name in which the reCAPTCHA should be activated.
   */
  public static String createSiteKey(String projectID, String domainName) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `client.close()` method on the client to safely
    // clean up any remaining background resources.
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {

      // Set the type of reCAPTCHA to be displayed.
      // For different types, see: https://cloud.google.com/recaptcha-enterprise/docs/keys
      Key scoreKey =
          Key.newBuilder()
              .setDisplayName("any_descriptive_name_for_the_key")
              .setWebSettings(
                  WebKeySettings.newBuilder()
                      .addAllowedDomains(domainName)
                      .setAllowAmpTraffic(false)
                      .setIntegrationType(IntegrationType.SCORE)
                      .build())
              .build();

      CreateKeyRequest createKeyRequest =
          CreateKeyRequest.newBuilder()
              .setParent(ProjectName.of(projectID).toString())
              .setKey(scoreKey)
              .build();

      // Get the name of the created reCAPTCHA site key.
      Key response = client.createKey(createKeyRequest);
      String keyName = response.getName();
      String recaptchaSiteKey = keyName.substring(keyName.lastIndexOf("/") + 1);
      System.out.println("reCAPTCHA Site key created successfully. Site Key: " + recaptchaSiteKey);
      return recaptchaSiteKey;
    }
  }
}
// [END recaptcha_enterprise_create_site_key]
