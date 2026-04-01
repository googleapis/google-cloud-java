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

// [START auth_cloud_idtoken_metadata_server]

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.IdTokenCredentials;
import com.google.auth.oauth2.IdTokenProvider;
import com.google.auth.oauth2.IdTokenProvider.Option;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class IdTokenFromMetadataServer {

  public static void main(String[] args) throws IOException, GeneralSecurityException {
    // TODO(Developer): Replace the below variables before running the code.

    // The url or target audience to obtain the ID token for.
    String url = "https://example.com";

    getIdTokenFromMetadataServer(url);
  }

  // Use the Google Cloud metadata server to create an identity token and add it to the
  // HTTP request as part of an Authorization header.
  public static void getIdTokenFromMetadataServer(String url) throws IOException {
    // Construct the GoogleCredentials object which obtains the default configuration from your
    // working environment.
    GoogleCredentials googleCredentials = GoogleCredentials.getApplicationDefault();

    IdTokenCredentials idTokenCredentials =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider((IdTokenProvider) googleCredentials)
            .setTargetAudience(url)
            // Setting the ID token options.
            .setOptions(Arrays.asList(Option.FORMAT_FULL, Option.LICENSES_TRUE))
            .build();

    // Get the ID token.
    // Once you've obtained the ID token, you can use it to make an authenticated call to the
    // target audience.
    String idToken = idTokenCredentials.refreshAccessToken().getTokenValue();
    System.out.println("Generated ID token.");
  }
}
// [END auth_cloud_idtoken_metadata_server]
