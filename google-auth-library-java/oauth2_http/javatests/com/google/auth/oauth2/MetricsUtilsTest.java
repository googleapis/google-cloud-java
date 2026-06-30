/*
 * Copyright 2023, Google LLC
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.oauth2.MetricsUtils.RequestType;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class MetricsUtilsTest {
  static final String VERSION_PATTERN =
      "gl-java/[\\d\\._-]+ auth/\\d+\\.\\d+\\.\\d+(-sp\\.\\d+)?(-SNAPSHOT)?";
  static final String AUTH_REQUEST_TYPE_PATTERN =
      String.format(" %s/[\\w]+", MetricsUtils.AUTH_REQUEST_TYPE);
  static final String CRED_TYPE_PATTERN = String.format(" %s/[\\w]+", MetricsUtils.CRED_TYPE);
  static final String METRICS_PATTERN_FULL =
      VERSION_PATTERN + AUTH_REQUEST_TYPE_PATTERN + CRED_TYPE_PATTERN;
  static final String METRICS_PATTERN_NO_REQUEST_TYPE = VERSION_PATTERN + CRED_TYPE_PATTERN;
  static final String METRICS_PATTERN_NO_CRED_TYPE = VERSION_PATTERN + AUTH_REQUEST_TYPE_PATTERN;

  private static void assertPatterns(String contentToTest, String patternString) {
    assertNotNull(contentToTest, "metric header string should not be null");
    Pattern pattern = Pattern.compile(patternString);
    assertTrue(pattern.matcher(contentToTest).matches());
  }

  @Test
  void getLanguageAndAuthLibraryVersionsTest() {
    String version = MetricsUtils.getLanguageAndAuthLibraryVersions();
    assertPatterns(version, VERSION_PATTERN);
  }

  @Test
  void getGoogleCredentialsMetricsHeaderTest() {
    String metricsStringNoRequestType =
        MetricsUtils.getGoogleCredentialsMetricsHeader(
            RequestType.UNTRACKED, CredentialTypeForMetrics.USER_CREDENTIALS);
    assertPatterns(metricsStringNoRequestType, METRICS_PATTERN_NO_REQUEST_TYPE);

    String metricsStringNoCredType =
        MetricsUtils.getGoogleCredentialsMetricsHeader(
            RequestType.METADATA_SERVER_PING, CredentialTypeForMetrics.DO_NOT_SEND);
    assertPatterns(metricsStringNoCredType, METRICS_PATTERN_NO_CRED_TYPE);

    String metricsString =
        MetricsUtils.getGoogleCredentialsMetricsHeader(
            RequestType.ID_TOKEN_REQUEST, CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT);
    assertPatterns(metricsString, METRICS_PATTERN_FULL);

    String metricsStringNoTypes =
        MetricsUtils.getGoogleCredentialsMetricsHeader(
            RequestType.UNTRACKED, CredentialTypeForMetrics.DO_NOT_SEND);
    assertPatterns(metricsStringNoTypes, VERSION_PATTERN);
  }
}
