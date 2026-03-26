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

// [auth_cloud_idtoken_impersonated_credentials]

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.IdTokenCredentials;
import com.google.auth.oauth2.IdTokenProvider.Option;
import com.google.auth.oauth2.ImpersonatedCredentials;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class IdTokenFromImpersonatedCredentials {

  public static void main(String[] args) throws IOException {
    // TODO(Developer): Replace the below variables before running the code.

    // Provide the scopes that you might need to request to access Google APIs,
    // depending on the level of access you need.
    // This example uses the cloud-wide scope and uses IAM to narrow the permissions.
    // https://cloud.google.com/docs/authentication/external/authorization-gcp
    // For more information, see: https://developers.google.com/identity/protocols/oauth2/scopes
    String scope = "https://www.googleapis.com/auth/cloud-platform";

    // The service name for which the id token is requested.
    String targetAudience = "https://example.com";

    // The name of the privilege-bearing service account for whom the credential is created.
    String impersonatedServiceAccount = "name@project.service.gserviceaccount.com";

    getIdTokenUsingOAuth2(impersonatedServiceAccount, scope, targetAudience);
  }

  // Use a service account (SA1) to impersonate as another service account (SA2) and obtain id token
  // for the impersonated account.
  // To obtain token for SA2, SA1 should have the "roles/iam.serviceAccountTokenCreator" permission
  // on SA2.
  public static void getIdTokenUsingOAuth2(
      String impersonatedServiceAccount, String scope, String targetAudience) throws IOException {

    // Construct the GoogleCredentials object which obtains the default configuration from your
    // working environment.
    GoogleCredentials googleCredentials = GoogleCredentials.getApplicationDefault();

    // delegates: The chained list of delegates required to grant the final accessToken.
    // For more information, see:
    // https://cloud.google.com/iam/docs/create-short-lived-credentials-direct#sa-credentials-permissions
    // Delegate is NOT USED here.
    List<String> delegates = null;

    // Create the impersonated credential.
    ImpersonatedCredentials impersonatedCredentials =
        ImpersonatedCredentials.create(
            googleCredentials, impersonatedServiceAccount, delegates, Arrays.asList(scope), 300);

    // Set the impersonated credential, target audience and token options.
    IdTokenCredentials idTokenCredentials =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(impersonatedCredentials)
            .setTargetAudience(targetAudience)
            // Setting this will include email in the id token.
            .setOptions(Arrays.asList(Option.INCLUDE_EMAIL))
            .build();

    // Get the ID token.
    // Once you've obtained the ID token, you can use it to make an authenticated call to the
    // target audience.
    String idToken = idTokenCredentials.refreshAccessToken().getTokenValue();
    System.out.println("Generated ID token.");
  }
}
// [auth_cloud_idtoken_impersonated_credentials]
