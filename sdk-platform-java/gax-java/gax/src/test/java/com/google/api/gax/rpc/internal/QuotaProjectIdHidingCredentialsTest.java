/*
 * Copyright 2020 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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
package com.google.api.gax.rpc.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class QuotaProjectIdHidingCredentialsTest {
  private static final String QUOTA_PROJECT_ID_KEY = "x-goog-user-project";
  private static final String QUOTA_PROJECT_ID_FROM_CREDENTIALS_VALUE =
      "quota_project_id_from_credentials";

  @Test
  void quotaProjectIdHidingCredentials_getRequestMetadata() throws IOException {
    // Credentials with quota project id
    Map<String, List<String>> metaDataWithQuota =
        ImmutableMap.of(
            "k1",
            Collections.singletonList("v1"),
            QUOTA_PROJECT_ID_KEY,
            Collections.singletonList(QUOTA_PROJECT_ID_FROM_CREDENTIALS_VALUE));
    Credentials credentialsWithQuotaProjectId = Mockito.mock(GoogleCredentials.class);
    Mockito.when(credentialsWithQuotaProjectId.getRequestMetadata(null))
        .thenReturn(metaDataWithQuota);
    QuotaProjectIdHidingCredentials quotaProjectIdHidingCredentials =
        new QuotaProjectIdHidingCredentials(credentialsWithQuotaProjectId);
    Map<String, List<String>> metaDataHidingQuota =
        quotaProjectIdHidingCredentials.getRequestMetadata();

    assertTrue(metaDataWithQuota.containsKey(QUOTA_PROJECT_ID_KEY));
    assertFalse(metaDataHidingQuota.containsKey(QUOTA_PROJECT_ID_KEY));
    assertEquals(metaDataWithQuota.size() - 1, metaDataHidingQuota.size());

    // Credentials without quota project id
    Map<String, List<String>> metaDataWithoutQuota =
        ImmutableMap.of("k1", Collections.singletonList("v1"));
    Credentials credentialsWithoutQuotaProjectId = Mockito.mock(GoogleCredentials.class);
    Mockito.when(credentialsWithoutQuotaProjectId.getRequestMetadata(null))
        .thenReturn(metaDataWithoutQuota);
    QuotaProjectIdHidingCredentials quotaProjectIdHidingCredentialsWithout =
        new QuotaProjectIdHidingCredentials(credentialsWithoutQuotaProjectId);
    Map<String, List<String>> metaDataHidingQuotaWithout =
        quotaProjectIdHidingCredentials.getRequestMetadata();

    assertEquals(quotaProjectIdHidingCredentialsWithout.getRequestMetadata(), metaDataWithoutQuota);
  }

  @Test
  void quotaProjectIdHidingCredentials_getAuthenticationType() throws IOException {
    final String mockType = "mock_type";
    Credentials credentials = Mockito.mock(GoogleCredentials.class);
    Mockito.when(credentials.getAuthenticationType()).thenReturn(mockType);
    Mockito.when(credentials.hasRequestMetadata()).thenReturn(true);
    Mockito.when(credentials.hasRequestMetadataOnly()).thenReturn(false);

    QuotaProjectIdHidingCredentials quotaProjectIdHidingCredentials =
        new QuotaProjectIdHidingCredentials(credentials);
    quotaProjectIdHidingCredentials.refresh();

    assertEquals(quotaProjectIdHidingCredentials.getAuthenticationType(), mockType);
    assertTrue(quotaProjectIdHidingCredentials.hasRequestMetadata());
    assertFalse(quotaProjectIdHidingCredentials.hasRequestMetadataOnly());

    Mockito.verify(credentials, Mockito.atLeastOnce()).refresh();
  }

  @Test
  void quotaProjectIdHidingCredentials_getUniverseDomain() throws IOException {
    Credentials credentials = Mockito.mock(GoogleCredentials.class);
    Mockito.when(credentials.getUniverseDomain()).thenReturn("example.com");

    QuotaProjectIdHidingCredentials quotaProjectIdHidingCredentials =
        new QuotaProjectIdHidingCredentials(credentials);

    assertEquals(quotaProjectIdHidingCredentials.getUniverseDomain(), "example.com");
  }
}
