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

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.auth.Credentials;
import com.google.cloud.vertexai.api.LlmUtilityServiceClient;
import com.google.cloud.vertexai.api.LlmUtilityServiceSettings;
import com.google.cloud.vertexai.api.PredictionServiceClient;
import com.google.cloud.vertexai.api.PredictionServiceSettings;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class holds default settings and credentials to make Vertex AI API calls.
 *
 * <p><b>Note:</b> The VertexAI instance will start a service client when the first API call is
 * made. Please close the VertexAI instance after making any API calls so that clients get closed as
 * well.
 *
 * <pre>{@code
 * try (VertexAI vertexAi = new VertexAI("my-project", "us-central1"); ) {
 *   GenerativeModel model = new GenerativeModel("gemini-pro", vertexAi)
 *   // Do something with the model.
 * }
 * }</pre>
 */
public class VertexAI implements AutoCloseable {

  private final String projectId;
  private final String location;
  private String apiEndpoint;
  private CredentialsProvider credentialsProvider = null;
  private Transport transport = Transport.GRPC;
  // The clients will be instantiated lazily
  private PredictionServiceClient predictionServiceClient = null;
  private PredictionServiceClient predictionServiceRestClient = null;
  private LlmUtilityServiceClient llmUtilityClient = null;
  private LlmUtilityServiceClient llmUtilityRestClient = null;

  /**
   * Construct a VertexAI instance.
   *
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   */
  public VertexAI(String projectId, String location) {
    this.projectId = projectId;
    this.location = location;
    this.apiEndpoint = String.format("%s-aiplatform.googleapis.com", this.location);
  }

  /**
   * Construct a VertexAI instance with default transport layer.
   *
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   * @param transport the default {@link Transport} layer to use to send API requests
   */
  public VertexAI(String projectId, String location, Transport transport) {
    this(projectId, location);
    this.transport = transport;
  }

  /**
   * Construct a VertexAI instance with custom credentials.
   *
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   * @param credentials the custom credentials to use when making API calls
   */
  public VertexAI(String projectId, String location, Credentials credentials) {
    this(projectId, location);
    this.credentialsProvider = FixedCredentialsProvider.create(credentials);
  }

  /**
   * Construct a VertexAI instance with default transport layer and custom credentials.
   *
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   * @param transport the default {@link Transport} layer to use to send API requests
   * @param credentials the default custom credentials to use when making API calls
   */
  public VertexAI(String projectId, String location, Transport transport, Credentials credentials) {
    this(projectId, location, credentials);
    this.transport = transport;
  }

  /**
   * Construct a VertexAI instance with application default credentials.
   *
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   * @param scopes List of scopes in the default credentials. Make sure you have specified
   *     "https://www.googleapis.com/auth/cloud-platform" scope to access resources on Vertex AI.
   */
  public VertexAI(String projectId, String location, List<String> scopes) throws IOException {
    this(projectId, location);

    CredentialsProvider credentialsProvider =
        scopes.size() == 0
            ? null
            : GoogleCredentialsProvider.newBuilder()
                .setScopesToApply(scopes)
                .setUseJwtAccessWithScope(true)
                .build();
    this.credentialsProvider = credentialsProvider;
  }

  /**
   * Construct a VertexAI instance with default transport layer and application default credentials.
   *
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   * @param transport the default {@link Transport} layer to use to send API requests
   * @param scopes List of scopes in the default credentials. Make sure you have specified
   *     "https://www.googleapis.com/auth/cloud-platform" scope to access resources on Vertex AI.
   */
  public VertexAI(String projectId, String location, Transport transport, List<String> scopes)
      throws IOException {
    this(projectId, location, scopes);
    this.transport = transport;
  }

  /**
   * Construct a VertexAI instance with application default credentials.
   *
   * @deprecated Use {@link #VertexAI(String, String, List<String>)} instead.
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   * @param scopes collection of scopes in the default credentials. Make sure you have specified
   *     "https://www.googleapis.com/auth/cloud-platform" scope to access resources on Vertex AI.
   */
  @Deprecated
  public VertexAI(String projectId, String location, String... scopes) throws IOException {
    CredentialsProvider credentialsProvider =
        scopes.length == 0
            ? null
            : GoogleCredentialsProvider.newBuilder()
                .setScopesToApply(Arrays.asList(scopes))
                .setUseJwtAccessWithScope(true)
                .build();

    this.projectId = projectId;
    this.location = location;
    this.apiEndpoint = String.format("%s-aiplatform.googleapis.com", this.location);
    this.credentialsProvider = credentialsProvider;
  }

  /**
   * Construct a VertexAI instance with default transport layer and application default credentials.
   *
   * @deprecated Use {@link #VertexAI(String, String, Transport, List<String>)} instead.
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   * @param transport the default {@link Transport} layer to use to send API requests
   * @param scopes collection of scopes in the default credentials
   */
  @Deprecated
  public VertexAI(String projectId, String location, Transport transport, String... scopes)
      throws IOException {
    this(projectId, location, scopes);
    this.transport = transport;
  }

  /**
   * Returns the default {@link Transport} layer to use to send API requests.
   *
   * @return {@link Transport} layer used when sending API requests.
   */
  public Transport getTransport() {
    return this.transport;
  }

  /**
   * Returns the default project to use when making API calls.
   *
   * @return Project ID in string format.
   */
  public String getProjectId() {
    return this.projectId;
  }

  /**
   * Returns the default location to use when making API calls.
   *
   * @return Location in string format.
   */
  public String getLocation() {
    return this.location;
  }

  /**
   * Returns the default endpoint to use when making API calls.
   *
   * @return API endpoint in string format.
   */
  public String getApiEndpoint() {
    return this.apiEndpoint;
  }

  /**
   * Returns the default credentials to use when making API calls.
   *
   * @return {@link Credentials} if the user has provided either scopes or credentials to the
   *     VertexAI object.
   */
  public Credentials getCredentials() throws IOException {
    return credentialsProvider.getCredentials();
  }

  /** Sets the value for {@link #getTransport()}. */
  public void setTransport(Transport transport) {
    this.transport = transport;
  }

  /** Sets the value for {@link #getApiEndpoint()}. */
  public void setApiEndpoint(String apiEndpoint) {
    this.apiEndpoint = apiEndpoint;

    if (this.predictionServiceClient != null) {
      this.predictionServiceClient.close();
      this.predictionServiceClient = null;
    }

    if (this.predictionServiceRestClient != null) {
      this.predictionServiceRestClient.close();
      this.predictionServiceRestClient = null;
    }

    if (this.llmUtilityClient != null) {
      this.llmUtilityClient.close();
      this.llmUtilityClient = null;
    }

    if (this.llmUtilityRestClient != null) {
      this.llmUtilityRestClient.close();
      this.llmUtilityRestClient = null;
    }
  }

  /**
   * Returns the {@link PredictionServiceClient} with GRPC. The client will be instantiated when the
   * first prediction API call is made.
   */
  public PredictionServiceClient getPredictionServiceClient() throws IOException {
    if (predictionServiceClient == null) {
      PredictionServiceSettings.Builder settingsBuilder = PredictionServiceSettings.newBuilder();
      settingsBuilder.setEndpoint(String.format("%s:443", this.apiEndpoint));
      if (this.credentialsProvider != null) {
        settingsBuilder.setCredentialsProvider(this.credentialsProvider);
      }
      HeaderProvider headerProvider =
          FixedHeaderProvider.create(
              "user-agent",
              String.format(
                  "%s/%s",
                  Constants.USER_AGENT_HEADER,
                  GaxProperties.getLibraryVersion(PredictionServiceSettings.class)));
      settingsBuilder.setHeaderProvider(headerProvider);
      // Disable the warning message logged in getApplicationDefault
      Logger defaultCredentialsProviderLogger =
          Logger.getLogger("com.google.auth.oauth2.DefaultCredentialsProvider");
      Level previousLevel = defaultCredentialsProviderLogger.getLevel();
      defaultCredentialsProviderLogger.setLevel(Level.SEVERE);
      predictionServiceClient = PredictionServiceClient.create(settingsBuilder.build());
      defaultCredentialsProviderLogger.setLevel(previousLevel);
    }
    return predictionServiceClient;
  }

  /**
   * Returns the {@link PredictionServiceClient} with REST. The client will be instantiated when the
   * first prediction API call is made.
   *
   * @return {@link PredictionServiceClient} that send REST requests to the backing service through
   *     method calls that map to the API methods.
   */
  public PredictionServiceClient getPredictionServiceRestClient() throws IOException {
    if (predictionServiceRestClient == null) {
      PredictionServiceSettings.Builder settingsBuilder =
          PredictionServiceSettings.newHttpJsonBuilder();
      settingsBuilder.setEndpoint(String.format("%s:443", this.apiEndpoint));
      if (this.credentialsProvider != null) {
        settingsBuilder.setCredentialsProvider(this.credentialsProvider);
      }
      HeaderProvider headerProvider =
          FixedHeaderProvider.create(
              "user-agent",
              String.format(
                  "%s/%s",
                  Constants.USER_AGENT_HEADER,
                  GaxProperties.getLibraryVersion(PredictionServiceSettings.class)));
      settingsBuilder.setHeaderProvider(headerProvider);
      // Disable the warning message logged in getApplicationDefault
      Logger defaultCredentialsProviderLogger =
          Logger.getLogger("com.google.auth.oauth2.DefaultCredentialsProvider");
      Level previousLevel = defaultCredentialsProviderLogger.getLevel();
      defaultCredentialsProviderLogger.setLevel(Level.SEVERE);
      predictionServiceRestClient = PredictionServiceClient.create(settingsBuilder.build());
      defaultCredentialsProviderLogger.setLevel(previousLevel);
    }
    return predictionServiceRestClient;
  }

  /**
   * Returns the {@link LlmUtilityServiceClient} with GRPC. The client will be instantiated when the
   * first prediction API call is made.
   *
   * @return {@link LlmUtilityServiceClient} that makes gRPC calls to the backing service through
   *     method calls that map to the API methods.
   */
  public LlmUtilityServiceClient getLlmUtilityClient() throws IOException {
    if (llmUtilityClient == null) {
      LlmUtilityServiceSettings.Builder settingsBuilder = LlmUtilityServiceSettings.newBuilder();
      settingsBuilder.setEndpoint(String.format("%s-aiplatform.googleapis.com:443", this.location));
      if (this.credentialsProvider != null) {
        settingsBuilder.setCredentialsProvider(this.credentialsProvider);
      }
      HeaderProvider headerProvider =
          FixedHeaderProvider.create(
              "user-agent",
              String.format(
                  "%s/%s",
                  Constants.USER_AGENT_HEADER,
                  GaxProperties.getLibraryVersion(LlmUtilityServiceSettings.class)));
      settingsBuilder.setHeaderProvider(headerProvider);
      // Disable the warning message logged in getApplicationDefault
      Logger defaultCredentialsProviderLogger =
          Logger.getLogger("com.google.auth.oauth2.DefaultCredentialsProvider");
      Level previousLevel = defaultCredentialsProviderLogger.getLevel();
      defaultCredentialsProviderLogger.setLevel(Level.SEVERE);
      llmUtilityClient = LlmUtilityServiceClient.create(settingsBuilder.build());
      defaultCredentialsProviderLogger.setLevel(previousLevel);
    }
    return llmUtilityClient;
  }

  /**
   * Returns the {@link LlmUtilityServiceClient} with REST. The client will be instantiated when the
   * first prediction API call is made.
   *
   * @return {@link LlmUtilityServiceClient} that makes REST requests to the backing service through
   *     method calls that map to the API methods.
   */
  public LlmUtilityServiceClient getLlmUtilityRestClient() throws IOException {
    if (llmUtilityRestClient == null) {
      LlmUtilityServiceSettings.Builder settingsBuilder =
          LlmUtilityServiceSettings.newHttpJsonBuilder();
      settingsBuilder.setEndpoint(String.format("%s-aiplatform.googleapis.com:443", this.location));
      if (this.credentialsProvider != null) {
        settingsBuilder.setCredentialsProvider(this.credentialsProvider);
      }
      HeaderProvider headerProvider =
          FixedHeaderProvider.create(
              "user-agent",
              String.format(
                  "%s/%s",
                  Constants.USER_AGENT_HEADER,
                  GaxProperties.getLibraryVersion(LlmUtilityServiceSettings.class)));
      settingsBuilder.setHeaderProvider(headerProvider);
      // Disable the warning message logged in getApplicationDefault
      Logger defaultCredentialsProviderLogger =
          Logger.getLogger("com.google.auth.oauth2.DefaultCredentialsProvider");
      Level previousLevel = defaultCredentialsProviderLogger.getLevel();
      defaultCredentialsProviderLogger.setLevel(Level.SEVERE);
      llmUtilityRestClient = LlmUtilityServiceClient.create(settingsBuilder.build());
      defaultCredentialsProviderLogger.setLevel(previousLevel);
    }
    return llmUtilityRestClient;
  }

  /** Closes the VertexAI instance together with all its instantiated clients. */
  @Override
  public void close() {
    if (predictionServiceClient != null) {
      predictionServiceClient.close();
    }
    if (predictionServiceRestClient != null) {
      predictionServiceRestClient.close();
    }
    if (llmUtilityClient != null) {
      llmUtilityClient.close();
    }
    if (llmUtilityRestClient != null) {
      llmUtilityRestClient.close();
    }
  }
}
