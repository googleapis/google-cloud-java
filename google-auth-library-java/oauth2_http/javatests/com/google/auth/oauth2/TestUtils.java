/*
 * Copyright 2024, Google Inc. All rights reserved.
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
 *    * Neither the name of Google Inc. nor the names of its
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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

class TestUtils {
  static void validateMetricsHeader(
      Map<String, List<String>> headers, String requestType, String credentialType) {
    assertTrue(headers.containsKey(MetricsUtils.API_CLIENT_HEADER));
    String actualMetricsValue = headers.get(MetricsUtils.API_CLIENT_HEADER).get(0);
    String expectedMetricsValue;
    if (requestType.equals("untracked")) {
      expectedMetricsValue =
          String.format(
              "%s %s/%s",
              MetricsUtils.getLanguageAndAuthLibraryVersions(),
              MetricsUtils.CRED_TYPE,
              credentialType);
    } else if (credentialType.equals("untracked")) {
      expectedMetricsValue =
          String.format(
              "%s %s/%s",
              MetricsUtils.getLanguageAndAuthLibraryVersions(),
              MetricsUtils.AUTH_REQUEST_TYPE,
              requestType);
    } else {
      expectedMetricsValue =
          String.format(
              "%s %s/%s %s/%s",
              MetricsUtils.getLanguageAndAuthLibraryVersions(),
              MetricsUtils.AUTH_REQUEST_TYPE,
              requestType,
              MetricsUtils.CRED_TYPE,
              credentialType);
    }
    assertEquals(expectedMetricsValue, actualMetricsValue);
  }
}
