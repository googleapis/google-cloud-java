/*
 * Copyright 2022 Google LLC
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

package com.google.auth.oauth2.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.api.client.json.GenericJson;
import com.google.auth.TestUtils;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.IOException;
import org.junit.jupiter.api.Test;

final class FTQuotaProjectId {

  @Test
  void validate_quota_from_environment_used() throws IOException {
    GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
    assertEquals("gcloud-devel", credentials.getQuotaProjectId());
  }

  @Test
  void validate_quota_from_environment_not_used() throws IOException {
    // Check the environment value for quota project
    assertEquals("gcloud-devel", System.getenv("GOOGLE_CLOUD_QUOTA_PROJECT"));

    GenericJson json = new GenericJson();
    json.put("client_id", "clientId");
    json.put("client_secret", "clientSecret");
    json.put("refresh_token", "refreshToken");
    json.put("quota_project_id", "quota_from_file");
    json.put("type", "authorized_user");
    GoogleCredentials credentials = GoogleCredentials.fromStream(TestUtils.jsonToInputStream(json));

    // Validate that the quota project from the json is used instead of environment value
    assertEquals("quota_from_file", credentials.getQuotaProjectId());
  }
}
