/*
 * Copyright 2025 Google LLC
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

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.gson.GsonFactory;
import com.google.auth.oauth2.ExternalAccountSupplierContext;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.IdentityPoolCredentials;
import com.google.auth.oauth2.IdentityPoolSubjectTokenSupplier;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.time.Instant;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * This sample demonstrates how to use a custom subject token supplier to authenticate to Google
 * Cloud Storage, using Okta as the identity provider.
 */
public class CustomCredentialSupplierOktaWorkload {

  public static void main(String[] args) {
    // TODO(Developer): Replace these variables with your actual values.

    // 1. GCP_WORKLOAD_AUDIENCE:
    // The audience for the workload identity federation. This is the full resource name of the
    // Workload Identity Pool Provider, in the following format:
    // `//iam.googleapis.com/projects/<project-number>/locations/global/workloadIdentityPools/<pool-id>/providers/<provider-id>`
    String gcpWorkloadAudience = System.getenv("GCP_WORKLOAD_AUDIENCE");

    // 2. GCP_SERVICE_ACCOUNT_IMPERSONATION_URL (optional):
    // The service account impersonation URL.  In the following format:
    // https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/<service-account-email>:generateAccessToken
    // If not provided, you should grant access to the GCP bucket to the principal directly.
    String serviceAccountImpersonationUrl = System.getenv("GCP_SERVICE_ACCOUNT_IMPERSONATION_URL");

    // 3. GCS_BUCKET_NAME:
    // The name of the bucket that you wish to fetch data for.
    String gcsBucketName = System.getenv("GCS_BUCKET_NAME");

    // 4. Okta Configuration:
    // To set up the Okta application for this flow, refer:
    // https://developer.okta.com/docs/guides/implement-grant-type/clientcreds/main/
    // https://developer.okta.com/docs/guides/customize-authz-server/main/
    //
    // Steps:
    //   a. In your Okta developer console, create a new Application of type "Machine-to-Machine
    // (M2M)".
    //   b. Under the "General" tab, ensure that "Client Credentials" is an allowed grant type.
    //   c. Note the "Client ID" and "Client Secret" for your application.
    //   d. Navigate to "Security" > "API" and select your authorization server (e.g., "default").
    //   e. Under the "Scopes" tab, add a custom scope (e.g., "gcp.test.read").
    //   f. Ensure your M2M application is granted this scope.
    //
    // OKTA_DOMAIN: Your Okta organization URL (e.g., https://{yourOktaDomain}.okta.com)
    String oktaDomain = System.getenv("OKTA_DOMAIN");
    // OKTA_CLIENT_ID: The Client ID of your Okta M2M application.
    String oktaClientId = System.getenv("OKTA_CLIENT_ID");
    // OKTA_CLIENT_SECRET: The Client Secret of your Okta M2M application.
    String oktaClientSecret = System.getenv("OKTA_CLIENT_SECRET");

    if (gcpWorkloadAudience == null
        || gcsBucketName == null
        || oktaDomain == null
        || oktaClientId == null
        || oktaClientSecret == null) {
      System.out.println(
          "Missing required environment variables. Please check your environment settings. "
              + "Required: GCP_WORKLOAD_AUDIENCE, "
              + "GCS_BUCKET_NAME, OKTA_DOMAIN, OKTA_CLIENT_ID, OKTA_CLIENT_SECRET");
      return;
    }

    customCredentialSupplierOktaWorkload(
        gcpWorkloadAudience,
        serviceAccountImpersonationUrl,
        gcsBucketName,
        oktaDomain,
        oktaClientId,
        oktaClientSecret);
  }

  public static void customCredentialSupplierOktaWorkload(
      String gcpWorkloadAudience,
      String serviceAccountImpersonationUrl,
      String gcsBucketName,
      String oktaDomain,
      String oktaClientId,
      String oktaClientSecret) {
    // 1. Instantiate our custom supplier with Okta credentials.
    OktaClientCredentialsSupplier oktaSupplier =
        new OktaClientCredentialsSupplier(oktaDomain, oktaClientId, oktaClientSecret);

    // 2. Instantiate an IdentityPoolCredentials with the required configuration.
    IdentityPoolCredentials.Builder credentialsBuilder =
        IdentityPoolCredentials.newBuilder()
            .setAudience(gcpWorkloadAudience)
            // This token type indicates that the subject token is a JSON Web Token (JWT).
            // This is required for Workload Identity Federation with an OIDC provider like Okta.
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setTokenUrl("https://sts.googleapis.com/v1/token")
            .setSubjectTokenSupplier(oktaSupplier);

    if (serviceAccountImpersonationUrl != null) {
      credentialsBuilder.setServiceAccountImpersonationUrl(serviceAccountImpersonationUrl);
    }

    GoogleCredentials credentials = credentialsBuilder.build();

    // 3. Use the credentials to make an authenticated request.
    Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

    System.out.println("[Test] Getting metadata for bucket: " + gcsBucketName + "...");
    Bucket bucket = storage.get(gcsBucketName);
    System.out.println(" --- SUCCESS! ---");
    System.out.println("Successfully authenticated and retrieved bucket data:");
    System.out.println(bucket.toString());
  }

  /**
   * A custom SubjectTokenSupplier that authenticates with Okta using the Client Credentials grant
   * flow.
   */
  private static class OktaClientCredentialsSupplier implements IdentityPoolSubjectTokenSupplier {

    private static final long TOKEN_REFRESH_BUFFER_SECONDS = 60;

    private final String oktaTokenUrl;
    private final String clientId;
    private final String clientSecret;
    private String accessToken;
    private Instant expiryTime;

    public OktaClientCredentialsSupplier(String domain, String clientId, String clientSecret) {
      this.oktaTokenUrl = domain + "/oauth2/default/v1/token";
      this.clientId = clientId;
      this.clientSecret = clientSecret;
      System.out.println("OktaClientCredentialsSupplier initialized.");
    }

    /**
     * Main method called by the auth library. It will fetch a new token if one is not already
     * cached.
     */
    @Override
    public String getSubjectToken(ExternalAccountSupplierContext context) throws IOException {
      // Check if the current token is still valid (with a 60-second buffer).
      boolean isTokenValid =
          this.accessToken != null
              && Instant.now().isBefore(this.expiryTime.minusSeconds(TOKEN_REFRESH_BUFFER_SECONDS));

      if (isTokenValid) {
        System.out.println("[Supplier] Returning cached Okta Access token.");
        return this.accessToken;
      }

      System.out.println(
          "[Supplier] Token is missing or expired. Fetching new Okta Access token via Client "
              + "Credentials grant...");
      fetchOktaAccessToken();
      return this.accessToken;
    }

    /**
     * Performs the Client Credentials grant flow by making a POST request to Okta's token endpoint.
     */
    private void fetchOktaAccessToken() throws IOException {
      URL url = new URL(this.oktaTokenUrl);
      HttpURLConnection conn = null;
      try {
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // The client_id and client_secret are sent in a Basic Auth header, as required by the
        // OAuth 2.0 Client Credentials grant specification. The credentials are Base64 encoded.
        String auth = this.clientId + ":" + this.clientSecret;
        String encodedAuth =
            Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        conn.setRequestProperty("Authorization", "Basic " + encodedAuth);

        conn.setDoOutput(true);
        try (DataOutputStream out = new DataOutputStream(conn.getOutputStream())) {
          // For the Client Credentials grant, scopes are optional and define the permissions
          // the access token will have. Replace "gcp.test.read" with the scopes defined in your
          // Okta authorization server. Multiple scopes can be requested by space-separating them.
          // In application/x-www-form-urlencoded, a space is represented by '+' or '%20'.
          // e.g., "scope1%20scope2" or "scope1+scope2".
          String params = "grant_type=client_credentials&scope=gcp.test.read%20gcp.bucket.read";
          out.writeBytes(params);
          out.flush();
        }

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
          try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
              response.append(line);
            }

            GenericJson jsonObject =
                GsonFactory.getDefaultInstance()
                    .createJsonParser(response.toString())
                    .parse(GenericJson.class);

            if (jsonObject.containsKey("access_token") && jsonObject.containsKey("expires_in")) {
              this.accessToken = (String) jsonObject.get("access_token");
              Number expiresInNumber = (Number) jsonObject.get("expires_in");
              int expiresIn = expiresInNumber.intValue();
              this.expiryTime = Instant.now().plusSeconds(expiresIn);
              System.out.println(
                  "[Supplier] Successfully received Access Token from Okta. Expires in "
                      + expiresIn
                      + " seconds.");
            } else {
              throw new IOException("Access token or expires_in not found in Okta response.");
            }
          }
        } else {
          throw new IOException(
              "Failed to authenticate with Okta using Client Credentials grant. Response code: "
                  + responseCode);
        }
      } finally {
        if (conn != null) {
          conn.disconnect();
        }
      }
    }
  }
}
