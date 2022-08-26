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

// [START recaptcha_enterprise_migrate_site_key]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.recaptchaenterprise.v1.Key;
import com.google.recaptchaenterprise.v1.KeyName;
import com.google.recaptchaenterprise.v1.MigrateKeyRequest;
import java.io.IOException;

public class MigrateKey {

  public static void main(String[] args) throws IOException {
    String projectId = "project-id";
    String recaptchaSiteKey = "recaptcha-site-key";

    migrateKey(projectId, recaptchaSiteKey);
  }

  /**
   * Migrate a key from reCAPTCHA (non-Enterprise) to reCAPTCHA Enterprise. If you created the key
   * using Admin console: https://www.google.com/recaptcha/admin/site, then use this API to migrate
   * to reCAPTCHA Enterprise. For more info, see:
   * https://cloud.google.com/recaptcha-enterprise/docs/migrate-recaptcha
   *
   * @param projectId: Google Cloud Project Id.
   * @param recaptchaSiteKey: Specify the site key to migrate.
   */
  public static void migrateKey(String projectId, String recaptchaSiteKey) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `client.close()` method on the client to safely
    // clean up any remaining background resources.
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {

      // Specify the key name to migrate.
      MigrateKeyRequest migrateKeyRequest =
          MigrateKeyRequest.newBuilder()
              .setName(KeyName.of(projectId, recaptchaSiteKey).toString())
              .build();

      Key response = client.migrateKey(migrateKeyRequest);

      // To verify if the site key has been migrated, use 'ListSiteKeys' and check if the
      // key is present.
      for (Key key : recaptcha.ListSiteKeys.listSiteKeys(projectId).iterateAll()) {
        if (key.equals(response)) {
          System.out.printf("Key migrated successfully: %s", recaptchaSiteKey);
        }
      }
    }
  }
}
// [END recaptcha_enterprise_migrate_site_key]
