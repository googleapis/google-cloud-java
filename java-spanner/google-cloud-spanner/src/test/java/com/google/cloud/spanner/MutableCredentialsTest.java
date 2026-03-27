/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.oauth2.ServiceAccountCredentials;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MutableCredentialsTest {
  ServiceAccountCredentials initialCredentials = mock(ServiceAccountCredentials.class);
  ServiceAccountCredentials initialScopedCredentials = mock(ServiceAccountCredentials.class);
  ServiceAccountCredentials updatedCredentials = mock(ServiceAccountCredentials.class);
  ServiceAccountCredentials updatedScopedCredentials = mock(ServiceAccountCredentials.class);
  Set<String> scopes = new HashSet<>(Arrays.asList("scope-a", "scope-b"));
  Map<String, List<String>> initialMetadata =
      Collections.singletonMap("Authorization", Collections.singletonList("v1"));
  Map<String, List<String>> updatedMetadata =
      Collections.singletonMap("Authorization", Collections.singletonList("v2"));
  String initialAuthType = "auth-1";
  String updatedAuthType = "auth-2";
  String initialUniverseDomain = "googleapis.com";
  String updatedUniverseDomain = "abc.goog";
  CredentialTypeForMetrics initialMetricsCredentialType =
      CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_JWT;
  CredentialTypeForMetrics updatedMetricsCredentialType =
      CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT;

  @Test
  public void testCreateMutableCredentials() throws IOException {
    setupInitialCredentials();

    MutableCredentials credentials = new MutableCredentials(initialCredentials, scopes);
    URI testUri = URI.create("https://spanner.googleapis.com");
    Executor executor = mock(Executor.class);
    RequestMetadataCallback callback = mock(RequestMetadataCallback.class);

    validateInitialDelegatedCredentialsAreSet(credentials, testUri);

    credentials.getRequestMetadata(testUri, executor, callback);

    credentials.refresh();

    verify(initialScopedCredentials, times(1)).getRequestMetadata(testUri, executor, callback);
    verify(initialScopedCredentials, times(1)).refresh();
  }

  @Test
  public void testCreateMutableCredentialsWithDefaultScopes() throws IOException {
    Set<String> defaultScopes = SpannerOptions.SCOPES;
    when(initialCredentials.createScoped(defaultScopes)).thenReturn(initialScopedCredentials);
    when(initialScopedCredentials.getAuthenticationType()).thenReturn(initialAuthType);
    when(initialScopedCredentials.getRequestMetadata(any(URI.class))).thenReturn(initialMetadata);
    when(initialScopedCredentials.getUniverseDomain()).thenReturn(initialUniverseDomain);
    when(initialScopedCredentials.getMetricsCredentialType())
        .thenReturn(initialMetricsCredentialType);
    when(initialScopedCredentials.hasRequestMetadata()).thenReturn(true);
    when(initialScopedCredentials.hasRequestMetadataOnly()).thenReturn(true);

    MutableCredentials credentials = new MutableCredentials(initialCredentials);
    URI testUri = URI.create("https://spanner.googleapis.com");

    validateInitialDelegatedCredentialsAreSet(credentials, testUri);
    verify(initialCredentials).createScoped(defaultScopes);
  }

  @Test
  public void testUpdateMutableCredentials() throws IOException {
    setupInitialCredentials();
    setupUpdatedCredentials();

    MutableCredentials credentials = new MutableCredentials(initialCredentials, scopes);
    URI testUri = URI.create("https://example.com");
    Executor executor = mock(Executor.class);
    RequestMetadataCallback callback = mock(RequestMetadataCallback.class);

    validateInitialDelegatedCredentialsAreSet(credentials, testUri);

    credentials.updateCredentials(updatedCredentials);

    assertEquals(updatedAuthType, credentials.getAuthenticationType());
    assertFalse(credentials.hasRequestMetadata());
    assertFalse(credentials.hasRequestMetadataOnly());
    assertSame(updatedMetadata, credentials.getRequestMetadata(testUri));
    assertEquals(updatedUniverseDomain, credentials.getUniverseDomain());
    assertEquals(updatedMetricsCredentialType, credentials.getMetricsCredentialType());

    credentials.getRequestMetadata(testUri, executor, callback);

    credentials.refresh();

    verify(updatedScopedCredentials, times(1)).getRequestMetadata(testUri, executor, callback);
    verify(updatedScopedCredentials, times(1)).refresh();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateMutableCredentialsEmptyScopesThrowsError() {
    new MutableCredentials(initialCredentials, Collections.emptySet());
  }

  @Test
  public void testCreateMutableCredentialsNullCredentialsThrowsError() {
    NullPointerException exception =
        assertThrows(NullPointerException.class, () -> new MutableCredentials(null, scopes));
    assertEquals("credentials must not be null", exception.getMessage());
  }

  @Test
  public void testCreateMutableCredentialsNullScopesThrowsError() {
    NullPointerException exception =
        assertThrows(
            NullPointerException.class, () -> new MutableCredentials(initialCredentials, null));
    assertEquals("scopes must not be null", exception.getMessage());
  }

  @Test
  public void testUpdateMutableCredentialsNullCredentialsThrowsError() throws IOException {
    setupInitialCredentials();
    MutableCredentials credentials = new MutableCredentials(initialCredentials, scopes);

    NullPointerException exception =
        assertThrows(NullPointerException.class, () -> credentials.updateCredentials(null));
    assertEquals("credentials must not be null", exception.getMessage());
  }

  private void validateInitialDelegatedCredentialsAreSet(
      MutableCredentials credentials, URI testUri) throws IOException {
    assertEquals(initialAuthType, credentials.getAuthenticationType());
    assertTrue(credentials.hasRequestMetadata());
    assertTrue(credentials.hasRequestMetadataOnly());
    assertEquals(initialMetadata, credentials.getRequestMetadata(testUri));
    assertEquals(initialUniverseDomain, credentials.getUniverseDomain());
    assertEquals(initialMetricsCredentialType, credentials.getMetricsCredentialType());
  }

  private void setupInitialCredentials() throws IOException {
    when(initialCredentials.createScoped(scopes)).thenReturn(initialScopedCredentials);
    when(initialCredentials.createScoped(Collections.emptyList()))
        .thenReturn(initialScopedCredentials);
    when(initialScopedCredentials.getAuthenticationType()).thenReturn(initialAuthType);
    when(initialScopedCredentials.getRequestMetadata(any(URI.class))).thenReturn(initialMetadata);
    when(initialScopedCredentials.getUniverseDomain()).thenReturn(initialUniverseDomain);
    when(initialScopedCredentials.getMetricsCredentialType())
        .thenReturn(initialMetricsCredentialType);
    when(initialScopedCredentials.hasRequestMetadata()).thenReturn(true);
    when(initialScopedCredentials.hasRequestMetadataOnly()).thenReturn(true);
  }

  private void setupUpdatedCredentials() throws IOException {
    when(updatedCredentials.createScoped(scopes)).thenReturn(updatedScopedCredentials);
    when(updatedScopedCredentials.getAuthenticationType()).thenReturn(updatedAuthType);
    when(updatedScopedCredentials.getRequestMetadata(any(URI.class))).thenReturn(updatedMetadata);
    when(updatedScopedCredentials.getUniverseDomain()).thenReturn(updatedUniverseDomain);
    when(updatedScopedCredentials.getMetricsCredentialType())
        .thenReturn(updatedMetricsCredentialType);
    when(updatedScopedCredentials.hasRequestMetadata()).thenReturn(false);
    when(updatedScopedCredentials.hasRequestMetadataOnly()).thenReturn(false);
  }
}
