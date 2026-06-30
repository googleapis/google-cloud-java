/*
 * Copyright 2021 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.auth.Credentials;
import com.google.auth.http.HttpCredentialsAdapter;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * Integration tests for Downscoping with Credential Access Boundaries via {@link
 * DownscopedCredentials}.
 *
 * <p>The only requirements for this test suite to run is to set the environment variable
 * GOOGLE_APPLICATION_CREDENTIALS to point to the same service account configured in the setup
 * script (downscoping-with-cab-setup.sh).
 */
final class ITDownscopingTest {

  // Output copied from the setup script (downscoping-with-cab-setup.sh).
  private static final String GCS_BUCKET_NAME = "cab-int-bucket-cbi3qrv5";
  private static final String GCS_OBJECT_NAME_WITH_PERMISSION = "cab-first-cbi3qrv5.txt";
  private static final String GCS_OBJECT_NAME_WITHOUT_PERMISSION = "cab-second-cbi3qrv5.txt";

  // This Credential Access Boundary enables the objectViewer permission to the specified object in
  // the specified bucket.
  private static final CredentialAccessBoundary CREDENTIAL_ACCESS_BOUNDARY =
      CredentialAccessBoundary.newBuilder()
          .addRule(
              CredentialAccessBoundary.AccessBoundaryRule.newBuilder()
                  .setAvailableResource(
                      String.format(
                          "//storage.googleapis.com/projects/_/buckets/%s", GCS_BUCKET_NAME))
                  .addAvailablePermission("inRole:roles/storage.objectViewer")
                  .setAvailabilityCondition(
                      CredentialAccessBoundary.AccessBoundaryRule.AvailabilityCondition.newBuilder()
                          .setExpression(
                              String.format(
                                  "resource.name.startsWith('projects/_/buckets/%s/objects/%s')",
                                  GCS_BUCKET_NAME, GCS_OBJECT_NAME_WITH_PERMISSION))
                          .build())
                  .build())
          .build();

  /**
   * A downscoped credential is obtained from a service account credential with permissions to
   * access an object in the GCS bucket configured. We should only have access to retrieve this
   * object.
   *
   * <p>We confirm this by: 1. Validating that we can successfully retrieve this object with the
   * downscoped token. 2. Validating that we do not have permission to retrieve a different object
   * in the same bucket.
   */
  @Test
  void downscoping_serviceAccountSourceWithRefresh() throws IOException {
    OAuth2CredentialsWithRefresh.OAuth2RefreshHandler refreshHandler =
        new OAuth2CredentialsWithRefresh.OAuth2RefreshHandler() {
          @Override
          public AccessToken refreshAccessToken() throws IOException {

            ServiceAccountCredentials credentials =
                (ServiceAccountCredentials)
                    GoogleCredentials.getApplicationDefault()
                        .createScoped(OAuth2Utils.CLOUD_PLATFORM_SCOPE);

            DownscopedCredentials downscopedCredentials =
                DownscopedCredentials.newBuilder()
                    .setSourceCredential(credentials)
                    .setCredentialAccessBoundary(CREDENTIAL_ACCESS_BOUNDARY)
                    .build();

            return downscopedCredentials.refreshAccessToken();
          }
        };

    OAuth2CredentialsWithRefresh credentials =
        OAuth2CredentialsWithRefresh.newBuilder().setRefreshHandler(refreshHandler).build();

    // Attempt to retrieve the object that the downscoped token has access to.
    retrieveObjectFromGcs(credentials, GCS_OBJECT_NAME_WITH_PERMISSION);

    // Attempt to retrieve the object that the downscoped token does not have access to. This should
    // fail.
    HttpResponseException e =
        assertThrows(
            HttpResponseException.class,
            () -> retrieveObjectFromGcs(credentials, GCS_OBJECT_NAME_WITHOUT_PERMISSION));
    assertEquals(403, e.getStatusCode());
  }

  private void retrieveObjectFromGcs(Credentials credentials, String objectName)
      throws IOException {
    String url =
        String.format(
            "https://storage.googleapis.com/storage/v1/b/%s/o/%s", GCS_BUCKET_NAME, objectName);

    HttpCredentialsAdapter credentialsAdapter = new HttpCredentialsAdapter(credentials);
    HttpRequestFactory requestFactory =
        new NetHttpTransport().createRequestFactory(credentialsAdapter);
    HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(url));

    JsonObjectParser parser = new JsonObjectParser(GsonFactory.getDefaultInstance());
    request.setParser(parser);

    HttpResponse response = request.execute();
    assertTrue(response.isSuccessStatusCode());
  }
}
