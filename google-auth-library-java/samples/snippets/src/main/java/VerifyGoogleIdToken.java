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

// [START auth_cloud_verify_google_idtoken]

import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.auth.oauth2.TokenVerifier;

public class VerifyGoogleIdToken {

  public static void main(String[] args) {
    // TODO(Developer): Replace the below variables before running the code.
    // The Google ID token to verify.
    String idToken = "id-token";

    // The service name for which the id token was requested.
    String targetAudience = "https://example.com";

    // To verify id tokens, get the Json Web Key endpoint (jwk).
    // OpenID Connect allows the use of a "Discovery document," a JSON document found at a
    // well-known location containing key-value pairs which provide details about the
    // OpenID Connect provider's configuration.
    // For more information on validating the jwt, see:
    // https://developers.google.com/identity/protocols/oauth2/openid-connect#validatinganidtoken
    //
    // Here, we validate Google's token using Google's OpenID Connect service (jwkUrl).
    // For more information on jwk,see:
    // https://auth0.com/docs/secure/tokens/json-web-tokens/json-web-key-sets
    String jwkUrl = "https://www.googleapis.com/oauth2/v3/certs";

    verifyGoogleIdToken(idToken, targetAudience, jwkUrl);
  }

  // Verifies the obtained Google id token. This is done at the receiving end of the OIDC endpoint.
  // The most common use case for verifying the ID token is when you are protecting
  // your own APIs with IAP. Google services already verify credentials as a platform,
  // so verifying ID tokens before making Google API calls is usually unnecessary.
  public static void verifyGoogleIdToken(String idToken, String audience, String jwkUrl) {
    // Initialize the Token verifier and set the audience.
    TokenVerifier tokenVerifier =
        TokenVerifier.newBuilder()
            .setAudience(audience)
            // Optional, when verifying a Google ID token, the jwk url is set by default.
            .setIssuer(jwkUrl)
            .build();

    try {
      // Verify the token.
      JsonWebToken jsonWebToken = tokenVerifier.verify(idToken);

      // Verify that the token contains subject and email claims.
      JsonWebToken.Payload payload = jsonWebToken.getPayload();
      // Get the user id.
      String userId = payload.getSubject();
      System.out.println("User ID: " + userId);

      // Optionally, if "INCLUDE_EMAIL" was set in the token options, check if the
      // email was verified.
      if (payload.get("email") != null) {
        System.out.printf("Email verified: %s", payload.get("email"));
      }
    } catch (TokenVerifier.VerificationException e) {
      System.out.printf("Unable to verify the token: %s", e.getMessage());
    }
  }
}
// [END auth_cloud_verify_google_idtoken]
