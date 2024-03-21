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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.InternalApi;
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
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
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
  private final String apiEndpoint;
  private final Transport transport;
  // Will be null if the user doesn't provide Credentials or scopes
  private final CredentialsProvider credentialsProvider;
  // The clients will be instantiated lazily
  private PredictionServiceClient predictionServiceClient = null;
  private LlmUtilityServiceClient llmUtilityClient = null;
  private final ReentrantLock lock = new ReentrantLock();

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
    this.transport = Transport.GRPC;
    this.credentialsProvider = null;
  }

  private VertexAI(
      String projectId,
      String location,
      String apiEndpoint,
      Transport transport,
      Credentials credentials,
      List<String> scopes) {
    if (!scopes.isEmpty() && credentials != null) {
      throw new IllegalArgumentException(
          "At most one of Credentials and scopes should be specified.");
    }
    checkArgument(!Strings.isNullOrEmpty(projectId), "projectId can't be null or empty");
    checkArgument(!Strings.isNullOrEmpty(location), "location can't be null or empty");
    checkArgument(!Strings.isNullOrEmpty(apiEndpoint), "apiEndpoint can't be null or empty");
    checkNotNull(transport, "transport can't be null");

    this.projectId = projectId;
    this.location = location;
    this.apiEndpoint = apiEndpoint;
    this.transport = transport;
    if (credentials != null) {
      this.credentialsProvider = FixedCredentialsProvider.create(credentials);
    } else {
      this.credentialsProvider =
          scopes.size() == 0
              ? null
              : GoogleCredentialsProvider.newBuilder()
                  .setScopesToApply(scopes)
                  .setUseJwtAccessWithScope(true)
                  .build();
    }
  }

  /** Builder for {@link VertexAI}. */
  public static class Builder {
    private String projectId;
    private String location;
    private Credentials credentials;
    private String apiEndpoint;
    private Transport transport = Transport.GRPC;
    private ImmutableList<String> scopes = ImmutableList.of();

    public VertexAI build() {
      checkNotNull(projectId, "projectId must be set.");
      checkNotNull(location, "location must be set.");
      // Default ApiEndpoint is set here as we need to make sure location is set.
      if (apiEndpoint == null) {
        apiEndpoint = String.format("%s-aiplatform.googleapis.com", location);
      }

      return new VertexAI(projectId, location, apiEndpoint, transport, credentials, scopes);
    }

    public Builder setProjectId(String projectId) {
      checkArgument(!Strings.isNullOrEmpty(projectId), "projectId can't be null or empty");

      this.projectId = projectId;
      return this;
    }

    public Builder setLocation(String location) {
      checkArgument(!Strings.isNullOrEmpty(location), "location can't be null or empty");

      this.location = location;
      return this;
    }

    public Builder setApiEndpoint(String apiEndpoint) {
      checkArgument(!Strings.isNullOrEmpty(apiEndpoint), "apiEndpoint can't be null or empty");

      this.apiEndpoint = apiEndpoint;
      return this;
    }

    public Builder setTransport(Transport transport) {
      checkNotNull(transport, "transport can't be null");

      this.transport = transport;
      return this;
    }

    public Builder setCredentials(Credentials credentials) {
      checkNotNull(credentials, "credentials can't be null");

      this.credentials = credentials;
      return this;
    }

    public Builder setScopes(List<String> scopes) {
      checkNotNull(scopes, "scopes can't be null");

      this.scopes = ImmutableList.copyOf(scopes);
      return this;
    }
  }

  /**
   * Returns the default {@link Transport} layer to use to send API requests.
   *
   * @return {@link Transport} layer used when sending API requests.
   */
  public Transport getTransport() {
    return transport;
  }

  /**
   * Returns the default project to use when making API calls.
   *
   * @return Project ID in string format.
   */
  public String getProjectId() {
    return projectId;
  }

  /**
   * Returns the default location to use when making API calls.
   *
   * @return Location in string format.
   */
  public String getLocation() {
    return location;
  }

  /**
   * Returns the default endpoint to use when making API calls.
   *
   * @return API endpoint in string format.
   */
  public String getApiEndpoint() {
    return apiEndpoint;
  }

  /**
   * Returns the default credentials to use when making API calls.
   *
   * @return {@link Credentials} if the user has provided either scopes or credentials to the
   *     VertexAI object.
   */
  public Credentials getCredentials() throws IOException {
    // TODO(b/330780087): support getCredentials() when default credentials (no user provided
    // credentials or scopes) are used.
    if (credentialsProvider == null) {
      throw new IllegalStateException(
          "Either Credentials or scopes needs to be provided while instantiating VertexAI.");
    }
    return credentialsProvider.getCredentials();
  }

  /**
   * Returns the {@link PredictionServiceClient} with GRPC or REST, based on the Transport type. The
   * client will be instantiated when the first prediction API call is made.
   *
   * @return {@link PredictionServiceClient} that send requests to the backing service through
   *     method calls that map to the API methods.
   */
  @InternalApi
  public PredictionServiceClient getPredictionServiceClient() throws IOException {
    if (predictionServiceClient != null) {
      return predictionServiceClient;
    }
    lock.lock();
    try {
      if (predictionServiceClient == null) {
        PredictionServiceSettings settings = getPredictionServiceSettings();
        // Disable the warning message logged in getApplicationDefault
        Logger defaultCredentialsProviderLogger =
            Logger.getLogger("com.google.auth.oauth2.DefaultCredentialsProvider");
        Level previousLevel = defaultCredentialsProviderLogger.getLevel();
        defaultCredentialsProviderLogger.setLevel(Level.SEVERE);
        predictionServiceClient = PredictionServiceClient.create(settings);
        defaultCredentialsProviderLogger.setLevel(previousLevel);
      }
      return predictionServiceClient;
    } finally {
      lock.unlock();
    }
  }

  private PredictionServiceSettings getPredictionServiceSettings() throws IOException {
    PredictionServiceSettings.Builder builder;
    if (transport == Transport.REST) {
      builder = PredictionServiceSettings.newHttpJsonBuilder();
    } else {
      builder = PredictionServiceSettings.newBuilder();
    }
    builder.setEndpoint(String.format("%s:443", this.apiEndpoint));
    if (this.credentialsProvider != null) {
      builder.setCredentialsProvider(this.credentialsProvider);
    }
    HeaderProvider headerProvider =
        FixedHeaderProvider.create(
            "user-agent",
            String.format(
                "%s/%s",
                Constants.USER_AGENT_HEADER,
                GaxProperties.getLibraryVersion(PredictionServiceSettings.class)));
    builder.setHeaderProvider(headerProvider);
    return builder.build();
  }

  /**
   * Returns the {@link LlmUtilityServiceClient} with GRPC or REST, based on the Transport type. The
   * client will be instantiated when the first API call is made.
   *
   * @return {@link LlmUtilityServiceClient} that makes calls to the backing service through method
   *     calls that map to the API methods.
   */
  @InternalApi
  public LlmUtilityServiceClient getLlmUtilityClient() throws IOException {
    if (llmUtilityClient != null) {
      return llmUtilityClient;
    }
    lock.lock();
    try {
      if (llmUtilityClient == null) {
        LlmUtilityServiceSettings settings = getLlmUtilityServiceClientSettings();
        // Disable the warning message logged in getApplicationDefault
        Logger defaultCredentialsProviderLogger =
            Logger.getLogger("com.google.auth.oauth2.DefaultCredentialsProvider");
        Level previousLevel = defaultCredentialsProviderLogger.getLevel();
        defaultCredentialsProviderLogger.setLevel(Level.SEVERE);
        llmUtilityClient = LlmUtilityServiceClient.create(settings);
        defaultCredentialsProviderLogger.setLevel(previousLevel);
      }
      return llmUtilityClient;
    } finally {
      lock.unlock();
    }
  }

  private LlmUtilityServiceSettings getLlmUtilityServiceClientSettings() throws IOException {
    LlmUtilityServiceSettings.Builder settingsBuilder;
    if (transport == Transport.REST) {
      settingsBuilder = LlmUtilityServiceSettings.newHttpJsonBuilder();
    } else {
      settingsBuilder = LlmUtilityServiceSettings.newBuilder();
    }
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
                GaxProperties.getLibraryVersion(LlmUtilityServiceSettings.class)));
    settingsBuilder.setHeaderProvider(headerProvider);
    return settingsBuilder.build();
  }

  /** Closes the VertexAI instance together with all its instantiated clients. */
  @Override
  public void close() {
    if (predictionServiceClient != null) {
      predictionServiceClient.close();
    }
    if (llmUtilityClient != null) {
      llmUtilityClient.close();
    }
  }
}
