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

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.api.PredictionServiceClient;
import com.google.cloud.vertexai.api.PredictionServiceSettings;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
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

  private VertexAI vertexAi;

  @Rule public final MockitoRule mocksRule = MockitoJUnit.rule();

  @Mock private GoogleCredentials mockGoogleCredentials;

  @Mock private PredictionServiceClient mockPredictionServiceClient;

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
  public void testInstantiateVertexAI_builderWithScopes_throwsIlegalArgumentException()
      throws IOException {
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
}
