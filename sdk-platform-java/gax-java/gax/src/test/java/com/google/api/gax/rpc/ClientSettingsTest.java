/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.rpc;

import static com.google.api.gax.util.TimeConversionTestUtils.testDurationMethod;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.core.ApiClock;
import com.google.api.core.NanoClock;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeClientSettings;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientSettingsTest {
  private static final String QUOTA_PROJECT_ID_KEY = "x-goog-user-project";
  private static final String QUOTA_PROJECT_ID_FROM_HEADER_VALUE = "quota_project_id_from_headers";
  private static final String QUOTA_PROJECT_ID_FROM_BUILDERS = "quota_project_id_from_builders";
  private static final String QUOTA_PROJECT_ID_FROM_INTERNAL_HEADER_VALUE =
      "quota_project_id_from_internal_headers";
  private static final String QUOTA_PROJECT_ID_FROM_CREDENTIALS_VALUE =
      "quota_project_id_from_credentials";
  private static final String QUOTA_PROJECT_ID_FROM_CONTEXT =
      "quota_project_id_from_client_context";
  private static final String SA_JSON_KEY_QUOTA_PROJECT_ID =
      "{\n"
          + "  \"private_key_id\": \"somekeyid\",\n"
          + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggS"
          + "kAgEAAoIBAQC+K2hSuFpAdrJI\\nnCgcDz2M7t7bjdlsadsasad+fvRSW6TjNQZ3p5LLQY1kSZRqBqylRkzteMOyHg"
          + "aR\\n0Pmxh3ILCND5men43j3h4eDbrhQBuxfEMalkG92sL+PNQSETY2tnvXryOvmBRwa/\\nQP/9dJfIkIDJ9Fw9N4"
          + "Bhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nknddadwkwewcVxHFhcZJO+XWf6ofLUXpRwiTZakGMn8EE1uVa2"
          + "LgczOjwWHGi99MFjxSer5m9\\n1tCa3/KEGKiS/YL71JvjwX3mb+cewlkcmweBKZHM2JPTk0ZednFSpVZMtycjkbLa"
          + "\\ndYOS8V85AgMBewECggEBAKksaldajfDZDV6nGqbFjMiizAKJolr/M3OQw16K6o3/\\n0S31xIe3sSlgW0+UbYlF"
          + "4U8KifhManD1apVSC3csafaspP4RZUHFhtBywLO9pR5c\\nr6S5aLp+gPWFyIp1pfXbWGvc5VY/v9x7ya1VEa6rXvL"
          + "sKupSeWAW4tMj3eo/64ge\\nsdaceaLYw52KeBYiT6+vpsnYrEkAHO1fF/LavbLLOFJmFTMxmsNaG0tuiJHgjshB\\"
          + "n82DpMCbXG9YcCgI/DbzuIjsdj2JC1cascSP//3PmefWysucBQe7Jryb6NQtASmnv\\nCdDw/0jmZTEjpe4S1lxfHp"
          + "lAhHFtdgYTvyYtaLZiVVkCgYEA8eVpof2rceecw/I6\\n5ng1q3Hl2usdWV/4mZMvR0fOemacLLfocX6IYxT1zA1FF"
          + "JlbXSRsJMf/Qq39mOR2\\nSpW+hr4jCoHeRVYLgsbggtrevGmILAlNoqCMpGZ6vDmJpq6ECV9olliDvpPgWOP+\\nm"
          + "YPDreFBGxWvQrADNbRt2dmGsrsCgYEAyUHqB2wvJHFqdmeBsaacewzV8x9WgmeX\\ngUIi9REwXlGDW0Mz50dxpxcK"
          + "CAYn65+7TCnY5O/jmL0VRxU1J2mSWyWTo1C+17L0\\n3fUqjxL1pkefwecxwecvC+gFFYdJ4CQ/MHHXU81Lwl1iWdF"
          + "Cd2UoGddYaOF+KNeM\\nHC7cmqra+JsCgYEAlUNywzq8nUg7282E+uICfCB0LfwejuymR93CtsFgb7cRd6ak\\nECR"
          + "8FGfCpH8ruWJINllbQfcHVCX47ndLZwqv3oVFKh6pAS/vVI4dpOepP8++7y1u\\ncoOvtreXCX6XqfrWDtKIvv0vjl"
          + "HBhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nkndj5uNl5SiuVxHFhcZJO+XWf6ofLUregtevZakGMn8EE1uVa"
          + "2AY7eafmoU/nZPT\\n00YB0TBATdCbn/nBSuKDESkhSg9s2GEKQZG5hBmL5uCMfo09z3SfxZIhJdlerreP\\nJ7gSi"
          + "dI12N+EZxYd4xIJh/HFDgp7RRO87f+WJkofMQKBgGTnClK1VMaCRbJZPriw\\nEfeFCoOX75MxKwXs6xgrw4W//AYG"
          + "GUjDt83lD6AZP6tws7gJ2IwY/qP7+lyhjEqN\\nHtfPZRGFkGZsdaksdlaksd323423d+15/UvrlRSFPNj1tWQmNKk"
          + "XyRDW4IG1Oa2p\\nrALStNBx5Y9t0/LQnFI4w3aG\\n-----END PRIVATE KEY-----\\n\",\n"
          + "  \"project_id\": \"someprojectid\",\n"
          + "  \"client_email\": \"someclientid@developer.gserviceaccount.com\",\n"
          + "  \"client_id\": \"someclientid.apps.googleusercontent.com\",\n"
          + "  \"type\": \"service_account\",\n"
          + "  \"quota_project_id\": \""
          + QUOTA_PROJECT_ID_FROM_CREDENTIALS_VALUE
          + "\"\n"
          + "}";

  private static final GoogleCredentials credentialsWithQuotaProject =
      loadServiceAccountCredentials(SA_JSON_KEY_QUOTA_PROJECT_ID);

  @Test
  void testEmptyBuilder() throws Exception {
    FakeClientSettings.Builder builder = new FakeClientSettings.Builder();
    Truth.assertThat(builder.getExecutorProvider()).isNull();
    Truth.assertThat(builder.getBackgroundExecutorProvider())
        .isInstanceOf(InstantiatingExecutorProvider.class);
    Truth.assertThat(builder.getTransportChannelProvider()).isNull();
    Truth.assertThat(builder.getCredentialsProvider()).isInstanceOf(NoCredentialsProvider.class);
    Truth.assertThat(builder.getClock()).isInstanceOf(NanoClock.class);
    Truth.assertThat(builder.getHeaderProvider()).isInstanceOf(NoHeaderProvider.class);
    Truth.assertThat(builder.getInternalHeaderProvider()).isInstanceOf(NoHeaderProvider.class);
    Truth.assertThat(builder.getWatchdogProvider())
        .isInstanceOf(InstantiatingWatchdogProvider.class);
    Truth.assertThat(builder.getWatchdogCheckIntervalDuration())
        .isGreaterThan(java.time.Duration.ZERO);
    Truth.assertThat(builder.getQuotaProjectId()).isNull();
    Truth.assertThat(builder.getApiKey()).isNull();

    FakeClientSettings settings = builder.build();
    Truth.assertThat(settings.getExecutorProvider())
        .isSameInstanceAs(builder.getExecutorProvider());
    Truth.assertThat(settings.getBackgroundExecutorProvider())
        .isSameInstanceAs(builder.getBackgroundExecutorProvider());
    Truth.assertThat(settings.getTransportChannelProvider())
        .isSameInstanceAs(builder.getTransportChannelProvider());
    Truth.assertThat(settings.getCredentialsProvider())
        .isSameInstanceAs(builder.getCredentialsProvider());
    Truth.assertThat(settings.getClock()).isSameInstanceAs(builder.getClock());
    Truth.assertThat(settings.getHeaderProvider()).isSameInstanceAs(builder.getHeaderProvider());
    Truth.assertThat(settings.getInternalHeaderProvider())
        .isSameInstanceAs(builder.getInternalHeaderProvider());
    Truth.assertThat(settings.getWatchdogProvider())
        .isInstanceOf(InstantiatingWatchdogProvider.class);
    Truth.assertThat(settings.getWatchdogCheckIntervalDuration())
        .isGreaterThan(java.time.Duration.ZERO);
    Truth.assertThat((settings.getQuotaProjectId())).isSameInstanceAs(builder.getQuotaProjectId());

    String settingsString = settings.toString();
    Truth.assertThat(settingsString).contains("executorProvider");
    Truth.assertThat(settingsString).contains("backgroundExecutorProvider");
    Truth.assertThat(settingsString).contains("transportChannelProvider");
    Truth.assertThat(settingsString).contains("credentialsProvider");
    Truth.assertThat(settingsString).contains("clock");
    Truth.assertThat(settingsString).contains("headerProvider");
    Truth.assertThat(settingsString).contains("watchdogProvider");
    Truth.assertThat(settingsString).contains("watchdogCheckInterval");
    Truth.assertThat(settingsString).contains(("quotaProjectId"));
    Truth.assertThat(settingsString).contains(("apiKey"));
  }

  @Test
  void testBuilder() throws Exception {
    FakeClientSettings.Builder builder = new FakeClientSettings.Builder();

    ExecutorProvider executorProvider = Mockito.mock(ExecutorProvider.class);
    TransportChannelProvider transportProvider = Mockito.mock(TransportChannelProvider.class);
    CredentialsProvider credentialsProvider = Mockito.mock(CredentialsProvider.class);
    ApiClock clock = Mockito.mock(ApiClock.class);
    HeaderProvider headerProvider = Mockito.mock(HeaderProvider.class);
    HeaderProvider internalHeaderProvider = Mockito.mock(HeaderProvider.class);
    WatchdogProvider watchdogProvider = Mockito.mock(WatchdogProvider.class);
    java.time.Duration watchdogCheckInterval = java.time.Duration.ofSeconds(13);
    String quotaProjectId = "test_quota_project_id";
    String apiKey = "api_key";

    builder.setExecutorProvider(executorProvider);
    builder.setTransportChannelProvider(transportProvider);
    builder.setCredentialsProvider(credentialsProvider);
    builder.setHeaderProvider(headerProvider);
    builder.setInternalHeaderProvider(internalHeaderProvider);
    builder.setClock(clock);
    builder.setWatchdogProvider(watchdogProvider);
    builder.setWatchdogCheckIntervalDuration(watchdogCheckInterval);
    builder.setQuotaProjectId(quotaProjectId);
    builder.setApiKey(apiKey);

    // For backward compatibility, backgroundExecutorProvider is set to executorProvider
    Truth.assertThat(builder.getExecutorProvider()).isSameInstanceAs(executorProvider);
    Truth.assertThat(builder.getBackgroundExecutorProvider()).isSameInstanceAs(executorProvider);
    Truth.assertThat(builder.getTransportChannelProvider()).isSameInstanceAs(transportProvider);
    Truth.assertThat(builder.getCredentialsProvider()).isSameInstanceAs(credentialsProvider);
    Truth.assertThat(builder.getClock()).isSameInstanceAs(clock);
    Truth.assertThat(builder.getHeaderProvider()).isSameInstanceAs(headerProvider);
    Truth.assertThat(builder.getInternalHeaderProvider()).isSameInstanceAs(internalHeaderProvider);
    Truth.assertThat(builder.getWatchdogProvider()).isSameInstanceAs(watchdogProvider);
    Truth.assertThat(builder.getWatchdogCheckIntervalDuration())
        .isSameInstanceAs(watchdogCheckInterval);
    Truth.assertThat(builder.getQuotaProjectId()).isEqualTo(quotaProjectId);
    Truth.assertThat(builder.getApiKey()).isEqualTo(apiKey);

    String builderString = builder.toString();
    Truth.assertThat(builderString).contains("executorProvider");
    Truth.assertThat(builderString).contains("backgroundExecutorProvider");
    Truth.assertThat(builderString).contains("transportChannelProvider");
    Truth.assertThat(builderString).contains("credentialsProvider");
    Truth.assertThat(builderString).contains("clock");
    Truth.assertThat(builderString).contains("headerProvider");
    Truth.assertThat(builderString).contains("internalHeaderProvider");
    Truth.assertThat(builderString).contains("watchdogProvider");
    Truth.assertThat(builderString).contains("watchdogCheckInterval");
    Truth.assertThat(builderString).contains("quotaProjectId");
    Truth.assertThat(builderString).contains("apiKey");
  }

  @Test
  void testBuilderFromClientContext() throws Exception {
    final String QUOTA_PROJECT_ID_FROM_CONTEXT = "some_quota_project_id_from_context";
    ApiClock clock = Mockito.mock(ApiClock.class);
    EndpointContext endpointContext = Mockito.mock(EndpointContext.class);
    ApiCallContext callContext =
        FakeCallContext.createDefault().withEndpointContext(endpointContext);
    Map<String, String> headers = Collections.singletonMap("spiffykey", "spiffyvalue");
    Watchdog watchdog =
        Watchdog.createDuration(
            Mockito.mock(ApiClock.class),
            java.time.Duration.ZERO,
            Mockito.mock(ScheduledExecutorService.class));
    java.time.Duration watchdogCheckInterval = java.time.Duration.ofSeconds(12);

    ClientContext clientContext =
        ClientContext.newBuilder()
            .setExecutor(Mockito.mock(ScheduledExecutorService.class))
            .setTransportChannel(Mockito.mock(TransportChannel.class))
            .setCredentials(Mockito.mock(Credentials.class))
            .setClock(clock)
            .setDefaultCallContext(callContext)
            .setHeaders(headers)
            .setStreamWatchdog(watchdog)
            .setStreamWatchdogCheckIntervalDuration(watchdogCheckInterval)
            .setQuotaProjectId(QUOTA_PROJECT_ID_FROM_CONTEXT)
            .build();

    FakeClientSettings.Builder builder = new FakeClientSettings.Builder(clientContext);

    Truth.assertThat(builder.getExecutorProvider()).isInstanceOf(FixedExecutorProvider.class);
    Truth.assertThat(builder.getBackgroundExecutorProvider())
        .isInstanceOf(FixedExecutorProvider.class);
    Truth.assertThat(builder.getExecutorProvider())
        .isSameInstanceAs(builder.getBackgroundExecutorProvider());
    Truth.assertThat(builder.getTransportChannelProvider())
        .isInstanceOf(FixedTransportChannelProvider.class);
    Truth.assertThat(builder.getCredentialsProvider()).isInstanceOf(FixedCredentialsProvider.class);
    Truth.assertThat(builder.getClock()).isSameInstanceAs(clock);
    Truth.assertThat(builder.getHeaderProvider().getHeaders())
        .containsEntry("spiffykey", "spiffyvalue");
    Truth.assertThat(builder.getWatchdogProvider()).isInstanceOf(FixedWatchdogProvider.class);
    Truth.assertThat(builder.getWatchdogProvider().getWatchdog()).isSameInstanceAs(watchdog);
    Truth.assertThat(builder.getWatchdogCheckIntervalDuration()).isEqualTo(watchdogCheckInterval);
    Truth.assertThat(builder.getQuotaProjectId()).isEqualTo(QUOTA_PROJECT_ID_FROM_CONTEXT);
  }

  @Test
  void testBuilderFromSettings() throws Exception {
    FakeClientSettings.Builder builder = new FakeClientSettings.Builder();

    ExecutorProvider executorProvider = Mockito.mock(ExecutorProvider.class);
    TransportChannelProvider transportProvider = Mockito.mock(TransportChannelProvider.class);
    CredentialsProvider credentialsProvider = Mockito.mock(CredentialsProvider.class);
    ApiClock clock = Mockito.mock(ApiClock.class);
    HeaderProvider headerProvider = Mockito.mock(HeaderProvider.class);
    HeaderProvider internalHeaderProvider = Mockito.mock(HeaderProvider.class);
    WatchdogProvider watchdogProvider = Mockito.mock(WatchdogProvider.class);
    java.time.Duration watchdogCheckInterval = java.time.Duration.ofSeconds(14);
    String quotaProjectId = "test_builder_from_settings_quotaProjectId";

    builder.setExecutorProvider(executorProvider);
    builder.setTransportChannelProvider(transportProvider);
    builder.setCredentialsProvider(credentialsProvider);
    builder.setClock(clock);
    builder.setHeaderProvider(headerProvider);
    builder.setInternalHeaderProvider(internalHeaderProvider);
    builder.setWatchdogProvider(watchdogProvider);
    builder.setWatchdogCheckIntervalDuration(watchdogCheckInterval);
    builder.setQuotaProjectId(quotaProjectId);

    FakeClientSettings settings = builder.build();
    FakeClientSettings.Builder newBuilder = new FakeClientSettings.Builder(settings);

    Truth.assertThat(newBuilder.getExecutorProvider()).isSameInstanceAs(executorProvider);
    Truth.assertThat(newBuilder.getBackgroundExecutorProvider()).isSameInstanceAs(executorProvider);
    Truth.assertThat(newBuilder.getTransportChannelProvider()).isSameInstanceAs(transportProvider);
    Truth.assertThat(newBuilder.getCredentialsProvider()).isSameInstanceAs(credentialsProvider);
    Truth.assertThat(newBuilder.getClock()).isSameInstanceAs(clock);
    Truth.assertThat(newBuilder.getHeaderProvider()).isSameInstanceAs(headerProvider);
    Truth.assertThat(newBuilder.getInternalHeaderProvider())
        .isSameInstanceAs(internalHeaderProvider);
    Truth.assertThat(newBuilder.getWatchdogProvider()).isSameInstanceAs(watchdogProvider);
    Truth.assertThat(newBuilder.getWatchdogCheckIntervalDuration())
        .isEqualTo(watchdogCheckInterval);
    Truth.assertThat(newBuilder.getQuotaProjectId()).isEqualTo(quotaProjectId);
  }

  @Test
  void testApplyToAllUnaryMethods() throws Exception {
    List<UnaryCallSettings.Builder<?, ?>> builders = new ArrayList<>();
    builders.add(UnaryCallSettings.newUnaryCallSettingsBuilder());
    builders.add(UnaryCallSettings.newUnaryCallSettingsBuilder());
    // using an array to have a mutable integer
    final int[] count = {0};
    ClientSettings.Builder.applyToAllUnaryMethods(
        builders,
        input -> {
          if (count[0] == 0) {
            input.setRetryableCodes(StatusCode.Code.UNAVAILABLE);
          } else {
            input.setRetryableCodes(StatusCode.Code.DEADLINE_EXCEEDED);
          }
          count[0] += 1;
          return null;
        });

    Truth.assertThat(builders.get(0).getRetryableCodes())
        .containsExactly(StatusCode.Code.UNAVAILABLE);
    Truth.assertThat(builders.get(1).getRetryableCodes())
        .containsExactly(StatusCode.Code.DEADLINE_EXCEEDED);
  }

  static GoogleCredentials loadServiceAccountCredentials(String serviceAccountCredentialFile) {
    try {
      InputStream keyStream = new ByteArrayInputStream(serviceAccountCredentialFile.getBytes());
      return ServiceAccountCredentials.fromStream(keyStream);
    } catch (IOException e) {
      fail("Couldn't create fake JSON credentials.");
    }
    return null;
  }

  @Test
  void testBuilderFromSettings_QuotaProjectId() {

    CredentialsProvider credentialsProvider_no_quota = Mockito.mock(CredentialsProvider.class);
    HeaderProvider headerProvider_no_quota = Mockito.mock(HeaderProvider.class);
    HeaderProvider internalHeaderProvider_no_quota = Mockito.mock(HeaderProvider.class);
    HeaderProvider headerProvider_with_quota =
        new HeaderProvider() {
          @Override
          public Map<String, String> getHeaders() {
            return Collections.singletonMap(
                QUOTA_PROJECT_ID_KEY, QUOTA_PROJECT_ID_FROM_HEADER_VALUE);
          }
        };
    HeaderProvider internalHeaderProvider_with_quota =
        new HeaderProvider() {
          @Override
          public Map<String, String> getHeaders() {
            return Collections.singletonMap(
                QUOTA_PROJECT_ID_KEY, QUOTA_PROJECT_ID_FROM_INTERNAL_HEADER_VALUE);
          }
        };
    CredentialsProvider credentialsProvider_with_quota =
        new CredentialsProvider() {
          @Override
          public Credentials getCredentials() throws IOException {
            return credentialsWithQuotaProject;
          }
        };

    // Case for setting quota_project_id from builder only
    // expect value is from builders
    FakeClientSettings.Builder builder_setQuotaOnly = new FakeClientSettings.Builder();
    builder_setQuotaOnly.setCredentialsProvider(credentialsProvider_no_quota);
    builder_setQuotaOnly.setHeaderProvider(headerProvider_no_quota);
    builder_setQuotaOnly.setInternalHeaderProvider(internalHeaderProvider_no_quota);
    builder_setQuotaOnly.setQuotaProjectId(QUOTA_PROJECT_ID_FROM_BUILDERS);

    // Case for setting quota_project_id from HeaderProvider Only
    // expect value is from HeaderProvider
    FakeClientSettings.Builder builder_setQuotaFromHeadersOnly = new FakeClientSettings.Builder();
    builder_setQuotaFromHeadersOnly.setHeaderProvider(headerProvider_with_quota);

    // Case for setting quota_project_id from HeaderProvider and set from builders
    // expect value is from builders
    FakeClientSettings.Builder builder_setQuotaFromHeadersAndBuilders =
        new FakeClientSettings.Builder();
    builder_setQuotaFromHeadersOnly.setHeaderProvider(headerProvider_with_quota);
    builder_setQuotaFromHeadersAndBuilders.setQuotaProjectId(QUOTA_PROJECT_ID_FROM_BUILDERS);

    // Case for setting quota_project_id from InternalHeaderProvider and set from builders
    // expect value is from InternalHeaderProvider
    FakeClientSettings.Builder builder_setQuotaFromInternalHeadersOnly =
        new FakeClientSettings.Builder();
    builder_setQuotaFromInternalHeadersOnly.setInternalHeaderProvider(
        internalHeaderProvider_with_quota);

    // Case for setting quota_project_id from InternalHeaderProvider and set from builders
    // expect value is from builders
    FakeClientSettings.Builder builder_setQuotaFromInternalHeadersAndBuilders =
        new FakeClientSettings.Builder();
    builder_setQuotaFromInternalHeadersAndBuilders.setInternalHeaderProvider(
        internalHeaderProvider_with_quota);
    builder_setQuotaFromInternalHeadersAndBuilders.setQuotaProjectId(
        QUOTA_PROJECT_ID_FROM_BUILDERS);

    // Case for setting quota_project_id from CredentialProvider Only
    // expect value is from CredentialProvider
    FakeClientSettings.Builder builder_setQuotaFromCredentialsProvider =
        new FakeClientSettings.Builder();
    builder_setQuotaFromCredentialsProvider.setCredentialsProvider(credentialsProvider_with_quota);

    // Case for setting quota_project_id from CredentialProvider and Builders
    // expect value is from builders
    FakeClientSettings.Builder builder_setQuotaFromCredentialsProviderAndBuilder =
        new FakeClientSettings.Builder();
    builder_setQuotaFromCredentialsProviderAndBuilder.setCredentialsProvider(
        credentialsProvider_with_quota);
    builder_setQuotaFromCredentialsProviderAndBuilder.setQuotaProjectId(
        QUOTA_PROJECT_ID_FROM_BUILDERS);

    // Case for setting quota_project_id from All three sources
    // expect value is from builders
    FakeClientSettings.Builder builder_setQuotaFromAllSources = new FakeClientSettings.Builder();
    builder_setQuotaFromAllSources.setHeaderProvider(headerProvider_with_quota);
    builder_setQuotaFromAllSources.setInternalHeaderProvider(headerProvider_with_quota);
    builder_setQuotaFromAllSources.setCredentialsProvider(credentialsProvider_with_quota);
    builder_setQuotaFromAllSources.setQuotaProjectId(QUOTA_PROJECT_ID_FROM_BUILDERS);

    // Case for setting quota_project_id from All three sources but set from builders first
    // expect value is from builders
    FakeClientSettings.Builder builder_setQuotaFromAllSourcesOrder =
        new FakeClientSettings.Builder();
    builder_setQuotaFromAllSourcesOrder.setQuotaProjectId(QUOTA_PROJECT_ID_FROM_BUILDERS);
    builder_setQuotaFromAllSourcesOrder.setHeaderProvider(headerProvider_with_quota);
    builder_setQuotaFromAllSourcesOrder.setInternalHeaderProvider(headerProvider_with_quota);
    builder_setQuotaFromAllSourcesOrder.setCredentialsProvider(credentialsProvider_with_quota);

    Truth.assertThat(builder_setQuotaOnly.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_BUILDERS);
    Truth.assertThat(builder_setQuotaFromHeadersOnly.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_HEADER_VALUE);
    Truth.assertThat(builder_setQuotaFromHeadersAndBuilders.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_BUILDERS);
    Truth.assertThat((builder_setQuotaFromInternalHeadersOnly).getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_INTERNAL_HEADER_VALUE);
    Truth.assertThat(builder_setQuotaFromInternalHeadersAndBuilders.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_BUILDERS);
    Truth.assertThat(builder_setQuotaFromCredentialsProviderAndBuilder.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_BUILDERS);
    Truth.assertThat(builder_setQuotaFromAllSources.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_BUILDERS);
    Truth.assertThat(builder_setQuotaFromAllSourcesOrder.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_BUILDERS);
  }

  @Test
  void testBuilderFromClientContext_QuotaProjectId() {
    EndpointContext endpointContext = Mockito.mock(EndpointContext.class);
    ApiCallContext callContext =
        FakeCallContext.createDefault().withEndpointContext(endpointContext);

    ClientContext clientContextQuotaOnly =
        ClientContext.newBuilder()
            .setTransportChannel(Mockito.mock(TransportChannel.class))
            .setDefaultCallContext(callContext)
            .setQuotaProjectId(QUOTA_PROJECT_ID_FROM_CONTEXT)
            .build();
    FakeClientSettings.Builder builderQuotaOnly =
        new FakeClientSettings.Builder(clientContextQuotaOnly);

    ClientContext clientContextCredentialOnly =
        ClientContext.newBuilder()
            .setTransportChannel(Mockito.mock(TransportChannel.class))
            .setDefaultCallContext(callContext)
            .setCredentials(credentialsWithQuotaProject)
            .build();
    FakeClientSettings.Builder builderCredentialOnly =
        new FakeClientSettings.Builder(clientContextCredentialOnly);

    ClientContext clientContextCredentialAndQuota =
        ClientContext.newBuilder()
            .setTransportChannel(Mockito.mock(TransportChannel.class))
            .setDefaultCallContext(callContext)
            .setCredentials(credentialsWithQuotaProject)
            .setQuotaProjectId(QUOTA_PROJECT_ID_FROM_CONTEXT)
            .build();
    FakeClientSettings.Builder builderCredentialAndQuota =
        new FakeClientSettings.Builder(clientContextCredentialAndQuota);

    ClientContext clientContextHeadersOnly =
        ClientContext.newBuilder()
            .setTransportChannel(Mockito.mock(TransportChannel.class))
            .setDefaultCallContext(callContext)
            .setHeaders(ImmutableMap.of(QUOTA_PROJECT_ID_KEY, QUOTA_PROJECT_ID_FROM_HEADER_VALUE))
            .build();
    FakeClientSettings.Builder builderHeadersOnly =
        new FakeClientSettings.Builder(clientContextHeadersOnly);

    ClientContext clientContextHeadersAndQuota =
        ClientContext.newBuilder()
            .setTransportChannel(Mockito.mock(TransportChannel.class))
            .setDefaultCallContext(callContext)
            .setQuotaProjectId(QUOTA_PROJECT_ID_FROM_CONTEXT)
            .setHeaders(ImmutableMap.of(QUOTA_PROJECT_ID_KEY, QUOTA_PROJECT_ID_FROM_HEADER_VALUE))
            .build();
    FakeClientSettings.Builder builderHeadersAndQuota =
        new FakeClientSettings.Builder(clientContextHeadersAndQuota);

    ClientContext clientContextInternalHeadersOnly =
        ClientContext.newBuilder()
            .setTransportChannel(Mockito.mock(TransportChannel.class))
            .setDefaultCallContext(callContext)
            .setInternalHeaders(
                ImmutableMap.of(QUOTA_PROJECT_ID_KEY, QUOTA_PROJECT_ID_FROM_INTERNAL_HEADER_VALUE))
            .build();
    FakeClientSettings.Builder builderInternalHeadersOnly =
        new FakeClientSettings.Builder(clientContextInternalHeadersOnly);

    ClientContext clientContextInternalHeadersAndQuota =
        ClientContext.newBuilder()
            .setTransportChannel(Mockito.mock(TransportChannel.class))
            .setDefaultCallContext(callContext)
            .setInternalHeaders(
                ImmutableMap.of(QUOTA_PROJECT_ID_KEY, QUOTA_PROJECT_ID_FROM_INTERNAL_HEADER_VALUE))
            .setQuotaProjectId(QUOTA_PROJECT_ID_FROM_CONTEXT)
            .build();
    FakeClientSettings.Builder builderInternalHeadersAndQuota =
        new FakeClientSettings.Builder(clientContextInternalHeadersAndQuota);

    ClientContext clientContextQuotaFromAllSources =
        ClientContext.newBuilder()
            .setTransportChannel(Mockito.mock(TransportChannel.class))
            .setDefaultCallContext(callContext)
            .setHeaders(
                ImmutableMap.of(QUOTA_PROJECT_ID_KEY, QUOTA_PROJECT_ID_FROM_INTERNAL_HEADER_VALUE))
            .setCredentials(credentialsWithQuotaProject)
            .setQuotaProjectId(QUOTA_PROJECT_ID_FROM_CONTEXT)
            .setInternalHeaders(
                ImmutableMap.of(QUOTA_PROJECT_ID_KEY, QUOTA_PROJECT_ID_FROM_INTERNAL_HEADER_VALUE))
            .build();
    FakeClientSettings.Builder builderQuotaFromAllSources =
        new FakeClientSettings.Builder(clientContextQuotaFromAllSources);

    Truth.assertThat(builderQuotaOnly.getQuotaProjectId()).isEqualTo(QUOTA_PROJECT_ID_FROM_CONTEXT);
    Truth.assertThat(builderCredentialOnly.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_CREDENTIALS_VALUE);
    Truth.assertThat(builderCredentialAndQuota.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_CONTEXT);
    Truth.assertThat(builderHeadersOnly.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_HEADER_VALUE);
    Truth.assertThat(builderHeadersAndQuota.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_CONTEXT);
    Truth.assertThat(builderInternalHeadersOnly.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_INTERNAL_HEADER_VALUE);
    Truth.assertThat(builderInternalHeadersAndQuota.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_CONTEXT);
    Truth.assertThat(builderQuotaFromAllSources.getQuotaProjectId())
        .isEqualTo(QUOTA_PROJECT_ID_FROM_CONTEXT);
  }

  @Test
  public void testWatchdogCheckInterval_backportMethodsBehaveCorrectly() {
    final ClientSettings.Builder builder = new FakeClientSettings.Builder();
    // this helper lambda goes around the possible IOException thrown by
    // ClientSettings.Builder.build()
    final Function<Supplier<ClientSettings.Builder>, ClientSettings> createClientSettings =
        fn -> {
          try {
            return fn.get().build();
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        };
    testDurationMethod(
        123l,
        jt -> createClientSettings.apply(() -> builder.setWatchdogCheckIntervalDuration(jt)),
        tt -> createClientSettings.apply(() -> builder.setWatchdogCheckInterval(tt)),
        cs -> cs.getWatchdogCheckIntervalDuration(),
        cs -> cs.getWatchdogCheckInterval());
  }
}
