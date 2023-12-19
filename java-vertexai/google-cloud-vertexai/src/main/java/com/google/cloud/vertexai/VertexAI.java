/*
 * Copyright 2023 Google LLC
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

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.api.PredictionServiceClient;
import com.google.cloud.vertexai.api.PredictionServiceSettings;
import com.google.cloud.vertexai.api.stub.PredictionServiceStubSettings;
import java.io.IOException;
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
  private final GoogleCredentials credentials;
  private Transport transport = Transport.GRPC;
  // The clients will be instantiated lazily
  private PredictionServiceClient predictionServiceClient = null;
  private PredictionServiceClient predictionServiceRestClient = null;

  /**
   * Construct a VertexAI instance with custom credentials.
   *
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   * @param credentials the custom credentials to use when making API calls
   */
  public VertexAI(String projectId, String location, GoogleCredentials credentials) {
    this.projectId = projectId;
    this.location = location;
    this.credentials = credentials;
  }

  /**
   * Construct a VertexAI instance with default transport layer and custom credentials.
   *
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   * @param transport the default {@link Transport} layer to use to send API requests
   * @param credentials the default custom credentials to use when making API calls
   */
  public VertexAI(
      String projectId, String location, Transport transport, GoogleCredentials credentials) {
    this(projectId, location, credentials);
    this.transport = transport;
  }

  /**
   * Construct a VertexAI instance with application default credentials.
   *
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   * @param scopes collection of scopes in the default credentials
   */
  public VertexAI(String projectId, String location, String... scopes) throws IOException {
    // Disable the warning message logged in getApplicationDefault
    Logger logger = Logger.getLogger("com.google.auth.oauth2.DefaultCredentialsProvider");
    Level previousLevel = logger.getLevel();
    logger.setLevel(Level.SEVERE);
    List<String> defaultScopes =
        PredictionServiceStubSettings.defaultCredentialsProviderBuilder().getScopesToApply();
    GoogleCredentials credentials =
        scopes.length == 0
            ? GoogleCredentials.getApplicationDefault().createScoped(defaultScopes)
            : GoogleCredentials.getApplicationDefault().createScoped(scopes);
    logger.setLevel(previousLevel);

    this.projectId = projectId;
    this.location = location;
    this.credentials = credentials;
  }

  /**
   * Construct a VertexAI instance with default transport layer and application default credentials.
   *
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   * @param transport the default {@link Transport} layer to use to send API requests
   * @param scopes collection of scopes in the default credentials
   */
  public VertexAI(String projectId, String location, Transport transport, String... scopes)
      throws IOException {
    this(projectId, location, scopes);
    this.transport = transport;
  }

  /** Returns the default {@link Transport} layer to use to send API requests. */
  public Transport getTransport() {
    return this.transport;
  }

  /** Returns the default project to use when making API calls. */
  public String getProjectId() {
    return this.projectId;
  }

  /** Returns the default location to use when making API calls. */
  public String getLocation() {
    return this.location;
  }

  /** Returns the default credentials to use when making API calls. */
  public GoogleCredentials getCredentials() {
    return credentials;
  }

  /** Sets the value for {@link #getTransport()}. */
  public void setTransport(Transport transport) {
    this.transport = transport;
  }

  /**
   * Returns the {@link PredictionServiceClient} with GRPC. The client will be instantiated when the
   * first prediction API call is made.
   */
  public PredictionServiceClient getPredictionServiceClient() throws IOException {
    if (predictionServiceClient == null) {
      PredictionServiceSettings settings =
          PredictionServiceSettings.newBuilder()
              .setEndpoint(String.format("%s-aiplatform.googleapis.com:443", this.location))
              .setCredentialsProvider(FixedCredentialsProvider.create(this.credentials))
              .build();
      predictionServiceClient = PredictionServiceClient.create(settings);
    }
    return predictionServiceClient;
  }

  /**
   * Returns the {@link PredictionServiceClient} with REST. The client will be instantiated when the
   * first prediction API call is made.
   */
  public PredictionServiceClient getPredictionServiceRestClient() throws IOException {
    if (predictionServiceRestClient == null) {
      PredictionServiceSettings settings =
          PredictionServiceSettings.newHttpJsonBuilder()
              .setEndpoint(String.format("%s-aiplatform.googleapis.com:443", this.location))
              .setCredentialsProvider(FixedCredentialsProvider.create(this.credentials))
              .build();
      predictionServiceRestClient = PredictionServiceClient.create(settings);
    }
    return predictionServiceRestClient;
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
  }
}
