/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.vertexai;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.api.PredictionServiceClient;
import com.google.cloud.vertexai.api.PredictionServiceSettings;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public final class VertexAITest {
  private static final String TEST_PROJECT = "test_project";
  private static final String TEST_LOCATION = "test_location";
  private static final String TEST_ENDPOINT = "test_endpoint";
  private static final String TEST_DEFAULT_ENDPOINT =
      String.format("%s-aiplatform.googleapis.com", TEST_LOCATION);
  private static final Optional<String> EMPTY_ENV_VAR_OPTIONAL = Optional.ofNullable(null);

  private VertexAI vertexAi;
  @Rule public final MockitoRule mocksRule = MockitoJUnit.rule();

  @Mock private GoogleCredentials mockGoogleCredentials;

  @Mock private PredictionServiceClient mockPredictionServiceClient;

  @Mock private GoogleCredentialsProvider.Builder mockCredentialsProviderBuilder;

  @Mock private GoogleCredentialsProvider mockCredentialsProvider;

  @Test
  public void testInstantiateVertexAI_usingConstructor_shouldContainRightFields()
      throws IOException {
    vertexAi = new VertexAI(TEST_PROJECT, TEST_LOCATION);

    assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
    assertThat(vertexAi.getLocation()).isEqualTo(TEST_LOCATION);
    assertThat(vertexAi.getTransport()).isEqualTo(Transport.GRPC);
    assertThat(vertexAi.getApiEndpoint()).isEqualTo(TEST_DEFAULT_ENDPOINT);
  }

  @Test
  public void
      testInstantiateVertexAI_usingConstructorNoArgsProjectEnvVarSet_shouldContainRightFields()
          throws IOException {
    try (MockedStatic mockStaticVertexAI = mockStatic(VertexAI.class)) {
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_REGION"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("CLOUD_ML_REGION"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_PROJECT"))
          .thenReturn(Optional.of(TEST_PROJECT));

      vertexAi = new VertexAI();

      assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
      assertThat(vertexAi.getLocation()).isEqualTo("us-central1");
      assertThat(vertexAi.getTransport()).isEqualTo(Transport.GRPC);
      assertThat(vertexAi.getApiEndpoint()).isEqualTo("us-central1-aiplatform.googleapis.com");
    }
  }

  @Test
  public void
      testInstantiateVertexAI_usingConstructorNoArgsProjectEnvVarNotSet_shouldContainRightFields()
          throws IOException {
    try (MockedStatic mockStaticVertexAI = mockStatic(VertexAI.class);
        MockedStatic mockStaticPredictionServiceSettings =
            mockStatic(PredictionServiceSettings.class); ) {
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_REGION"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("CLOUD_ML_REGION"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_PROJECT"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticPredictionServiceSettings
          .when(() -> PredictionServiceSettings.defaultCredentialsProviderBuilder())
          .thenReturn(mockCredentialsProviderBuilder);
      when(mockCredentialsProviderBuilder.build()).thenReturn(mockCredentialsProvider);
      when(mockCredentialsProvider.getCredentials()).thenReturn(mockGoogleCredentials);
      when(mockGoogleCredentials.getQuotaProjectId()).thenReturn(TEST_PROJECT);

      vertexAi = new VertexAI();

      assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
      assertThat(vertexAi.getLocation()).isEqualTo("us-central1");
      assertThat(vertexAi.getTransport()).isEqualTo(Transport.GRPC);
      assertThat(vertexAi.getApiEndpoint()).isEqualTo("us-central1-aiplatform.googleapis.com");
    }
  }

  @Test
  public void
      testConstructor_noArgsCredentialsProviderThrowsIOException_shouldThrowIllegalArgumentException()
          throws IOException {
    try (MockedStatic mockStatic = mockStatic(PredictionServiceSettings.class)) {
      final String expectedErrorMessage =
          ("Unable to infer your project. Please provide a project Id by one of the following:"
              + "\n- Passing a constructor argument by using new VertexAI(String projectId, String"
              + " location)"
              + "\n- Setting project using 'gcloud config set project my-project'");
      mockStatic
          .when(() -> PredictionServiceSettings.defaultCredentialsProviderBuilder())
          .thenReturn(mockCredentialsProviderBuilder);
      when(mockCredentialsProviderBuilder.build()).thenReturn(mockCredentialsProvider);
      when(mockCredentialsProvider.getCredentials()).thenThrow(new IOException(""));

      IllegalArgumentException thrown =
          assertThrows(IllegalArgumentException.class, () -> new VertexAI());
      assertThat(thrown).hasMessageThat().contains(expectedErrorMessage);
    }
  }

  @Test
  public void
      testInstantiateVertexAI_usingConstructorLocationFromGOOGLE_CLOUD_REGION_shouldContainRightFields()
          throws IOException {
    try (MockedStatic mockStaticVertexAI = mockStatic(VertexAI.class)) {
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_REGION"))
          .thenReturn(Optional.of("us-central2"));
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("CLOUD_ML_REGION"))
          .thenReturn(Optional.of("us-central3"));
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_PROJECT"))
          .thenReturn(Optional.of(TEST_PROJECT));

      vertexAi = new VertexAI();

      assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
      assertThat(vertexAi.getLocation()).isEqualTo("us-central2");
      assertThat(vertexAi.getTransport()).isEqualTo(Transport.GRPC);
      assertThat(vertexAi.getApiEndpoint()).isEqualTo("us-central2-aiplatform.googleapis.com");
    }
  }

  @Test
  public void
      testInstantiateVertexAI_usingConstructorLocationFromCLOUD_ML_REGION_shouldContainRightFields()
          throws IOException {
    try (MockedStatic mockStaticVertexAI = mockStatic(VertexAI.class)) {
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_REGION"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("CLOUD_ML_REGION"))
          .thenReturn(Optional.of("us-central2"));
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_PROJECT"))
          .thenReturn(Optional.of(TEST_PROJECT));

      vertexAi = new VertexAI();

      assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
      assertThat(vertexAi.getLocation()).isEqualTo("us-central2");
      assertThat(vertexAi.getTransport()).isEqualTo(Transport.GRPC);
      assertThat(vertexAi.getApiEndpoint()).isEqualTo("us-central2-aiplatform.googleapis.com");
    }
  }

  @Test
  public void testInstantiateVertexAI_builderWithCredentials_shouldContainRightFields()
      throws IOException {
    vertexAi =
        new VertexAI.Builder()
            .setProjectId(TEST_PROJECT)
            .setLocation(TEST_LOCATION)
            .setCredentials(mockGoogleCredentials)
            .build();

    assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
    assertThat(vertexAi.getLocation()).isEqualTo(TEST_LOCATION);
    assertThat(vertexAi.getTransport()).isEqualTo(Transport.GRPC);
    assertThat(vertexAi.getApiEndpoint()).isEqualTo(TEST_DEFAULT_ENDPOINT);
    assertThat(vertexAi.getCredentials()).isEqualTo(mockGoogleCredentials);
  }

  @Test
  public void testInstantiateVertexAI_builderNoArgsProjectEnvVarSet_shouldContainRightFields()
      throws IOException {
    try (MockedStatic mockStaticVertexAI = mockStatic(VertexAI.class)) {
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_REGION"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("CLOUD_ML_REGION"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_PROJECT"))
          .thenReturn(Optional.of(TEST_PROJECT));

      vertexAi = new VertexAI.Builder().build();

      assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
      assertThat(vertexAi.getLocation()).isEqualTo("us-central1");
      assertThat(vertexAi.getTransport()).isEqualTo(Transport.GRPC);
      assertThat(vertexAi.getApiEndpoint()).isEqualTo("us-central1-aiplatform.googleapis.com");
    }
  }

  @Test
  public void testInstantiateVertexAI_builderNoArgsProjectEnvVarNotSet_shouldContainRightFields()
      throws IOException {
    try (MockedStatic mockStaticVertexAI = mockStatic(VertexAI.class);
        MockedStatic mockStaticPredictionServiceSettings =
            mockStatic(PredictionServiceSettings.class); ) {
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_REGION"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("CLOUD_ML_REGION"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_PROJECT"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticPredictionServiceSettings
          .when(() -> PredictionServiceSettings.defaultCredentialsProviderBuilder())
          .thenReturn(mockCredentialsProviderBuilder);
      when(mockCredentialsProviderBuilder.build()).thenReturn(mockCredentialsProvider);
      when(mockCredentialsProvider.getCredentials()).thenReturn(mockGoogleCredentials);
      when(mockGoogleCredentials.getQuotaProjectId()).thenReturn(TEST_PROJECT);

      vertexAi = new VertexAI.Builder().build();

      assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
      assertThat(vertexAi.getLocation()).isEqualTo("us-central1");
      assertThat(vertexAi.getTransport()).isEqualTo(Transport.GRPC);
      assertThat(vertexAi.getApiEndpoint()).isEqualTo("us-central1-aiplatform.googleapis.com");
    }
  }

  @Test
  public void
      testBuilder_noArgsCredentialsProviderThrowsIOException_shouldThrowIllegalArgumentException()
          throws IOException {
    try (MockedStatic mockStaticPredictionServiceSettings =
        mockStatic(PredictionServiceSettings.class)) {
      final String expectedErrorMessage =
          ("Unable to infer your project. Please provide a project Id by one of the following:"
              + "\n- Passing a constructor argument by using new VertexAI(String projectId, String"
              + " location)"
              + "\n- Setting project using 'gcloud config set project my-project'");
      mockStaticPredictionServiceSettings
          .when(() -> PredictionServiceSettings.defaultCredentialsProviderBuilder())
          .thenReturn(mockCredentialsProviderBuilder);
      when(mockCredentialsProviderBuilder.build()).thenReturn(mockCredentialsProvider);
      when(mockCredentialsProvider.getCredentials()).thenThrow(new IOException(""));

      IllegalArgumentException thrown =
          assertThrows(IllegalArgumentException.class, () -> new VertexAI.Builder().build());
      assertThat(thrown).hasMessageThat().contains(expectedErrorMessage);
    }
  }

  @Test
  public void
      testInstantiateVertexAI_builderLocationFromGOOGLE_CLOUD_REGION_shouldContainRightFields()
          throws IOException {
    try (MockedStatic mockStaticVertexAI = mockStatic(VertexAI.class)) {
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_REGION"))
          .thenReturn(Optional.of("us-central2"));
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("CLOUD_ML_REGION"))
          .thenReturn(Optional.of("us-central3"));
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_PROJECT"))
          .thenReturn(Optional.of(TEST_PROJECT));

      vertexAi = new VertexAI.Builder().build();

      assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
      assertThat(vertexAi.getLocation()).isEqualTo("us-central2");
      assertThat(vertexAi.getTransport()).isEqualTo(Transport.GRPC);
      assertThat(vertexAi.getApiEndpoint()).isEqualTo("us-central2-aiplatform.googleapis.com");
    }
  }

  @Test
  public void testInstantiateVertexAI_builderLocationFromCLOUD_ML_REGION_shouldContainRightFields()
      throws IOException {
    try (MockedStatic mockStaticVertexAI = mockStatic(VertexAI.class)) {
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_REGION"))
          .thenReturn(EMPTY_ENV_VAR_OPTIONAL);
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("CLOUD_ML_REGION"))
          .thenReturn(Optional.of("us-central2"));
      mockStaticVertexAI
          .when(() -> VertexAI.getEnvironmentVariable("GOOGLE_CLOUD_PROJECT"))
          .thenReturn(Optional.of(TEST_PROJECT));

      vertexAi = new VertexAI.Builder().build();

      assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
      assertThat(vertexAi.getLocation()).isEqualTo("us-central2");
      assertThat(vertexAi.getTransport()).isEqualTo(Transport.GRPC);
      assertThat(vertexAi.getApiEndpoint()).isEqualTo("us-central2-aiplatform.googleapis.com");
    }
  }

  @Test
  public void testInstantiateVertexAI_builderWithScopes_throwsIlegalArgumentException()
      throws IllegalArgumentException {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                new VertexAI.Builder()
                    .setProjectId(TEST_PROJECT)
                    .setLocation(TEST_LOCATION)
                    .setCredentials(mockGoogleCredentials)
                    .setScopes(ImmutableList.of("test_scope"))
                    .build());
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo("At most one of Credentials and scopes should be specified.");
  }

  @Test
  public void testInstantiateVertexAI_builderWithEndpoint_shouldContainRightFields()
      throws IOException {
    try (MockedStatic mockStatic = mockStatic(PredictionServiceClient.class)) {
      mockStatic
          .when(() -> PredictionServiceClient.create(any(PredictionServiceSettings.class)))
          .thenReturn(mockPredictionServiceClient);

      vertexAi =
          new VertexAI.Builder()
              .setApiEndpoint(TEST_ENDPOINT)
              .setProjectId(TEST_PROJECT)
              .setLocation(TEST_LOCATION)
              .build();

      PredictionServiceClient unused = vertexAi.getPredictionServiceClient();

      ArgumentCaptor<PredictionServiceSettings> settings =
          ArgumentCaptor.forClass(PredictionServiceSettings.class);
      mockStatic.verify(() -> PredictionServiceClient.create(settings.capture()));

      assertThat(settings.getValue().getEndpoint())
          .isEqualTo(String.format("%s:443", TEST_ENDPOINT));
    }
  }

  @Test
  public void testInstantiateVertexAI_builderWithTransport_shouldContainRightFields()
      throws IOException {

    vertexAi =
        new VertexAI.Builder()
            .setProjectId(TEST_PROJECT)
            .setLocation(TEST_LOCATION)
            .setTransport(Transport.REST)
            .build();

    assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
    assertThat(vertexAi.getLocation()).isEqualTo(TEST_LOCATION);
    assertThat(vertexAi.getTransport()).isEqualTo(Transport.REST);
    assertThat(vertexAi.getApiEndpoint()).isEqualTo(TEST_DEFAULT_ENDPOINT);
  }

  @Test
  public void testInstantiateVertexAI_builderWithCustomHeaders_shouldContainRightFields()
      throws IOException {
    Map<String, String> customHeaders = new HashMap<>();
    customHeaders.put("test_key", "test_value");

    vertexAi =
        new VertexAI.Builder()
            .setProjectId(TEST_PROJECT)
            .setLocation(TEST_LOCATION)
            .setCustomHeaders(customHeaders)
            .build();

    assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
    assertThat(vertexAi.getLocation()).isEqualTo(TEST_LOCATION);
    // headers should include both the sdk header and the custom headers
    Map<String, String> expectedHeaders = new HashMap<>(customHeaders);
    expectedHeaders.put(
        "user-agent",
        String.format(
            "%s/%s",
            Constants.USER_AGENT_HEADER,
            GaxProperties.getLibraryVersion(PredictionServiceSettings.class)));
    assertThat(vertexAi.getHeaders()).isEqualTo(expectedHeaders);
  }

  @Test
  public void
      testInstantiateVertexAI_builderWithCustomHeadersWithSdkReservedKey_shouldContainRightFields()
          throws IOException {
    Map<String, String> customHeadersWithSdkReservedKey = new HashMap<>();
    customHeadersWithSdkReservedKey.put("user-agent", "test_value");

    vertexAi =
        new VertexAI.Builder()
            .setProjectId(TEST_PROJECT)
            .setLocation(TEST_LOCATION)
            .setCustomHeaders(customHeadersWithSdkReservedKey)
            .build();

    assertThat(vertexAi.getProjectId()).isEqualTo(TEST_PROJECT);
    assertThat(vertexAi.getLocation()).isEqualTo(TEST_LOCATION);
    // headers should include sdk reserved key with value of both the sdk header and the custom
    // headers
    Map<String, String> expectedHeaders = new HashMap<>();
    expectedHeaders.put(
        "user-agent",
        String.format(
            "%s/%s %s",
            Constants.USER_AGENT_HEADER,
            GaxProperties.getLibraryVersion(PredictionServiceSettings.class),
            "test_value"));
    assertThat(vertexAi.getHeaders()).isEqualTo(expectedHeaders);
  }
}
