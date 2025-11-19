/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.vertexai.genai;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.BetaApi;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.ApiClient;
import com.google.genai.HttpApiClient;
import com.google.genai.ReplayApiClient;
import com.google.genai.errors.GenAiIOException;
import com.google.genai.types.ClientOptions;
import com.google.genai.types.HttpOptions;
import java.io.IOException;
import java.util.Optional;

/** Client class for GenAI. This class is thread-safe. */
public final class Client implements AutoCloseable {

  /** Async class for GenAI. */
  public final class Async {
    public final AsyncDatasets datasets;

    public Async(ApiClient apiClient) {
      this.datasets = new AsyncDatasets(apiClient);
    }
  }

  private final DebugConfig debugConfig;
  private final ApiClient apiClient;

  @BetaApi public final Datasets datasets;
  @BetaApi public final Evals evals;

  /** Builder for {@link Client}. */
  public static class Builder {
    private Optional<String> apiKey = Optional.empty();
    private Optional<String> project = Optional.empty();
    private Optional<String> location = Optional.empty();
    private Optional<GoogleCredentials> credentials = Optional.empty();
    private Optional<ClientOptions> clientOptions = Optional.empty();
    private Optional<HttpOptions> httpOptions = Optional.empty();
    private Optional<Boolean> vertexAI = Optional.empty();
    private Optional<DebugConfig> debugConfig = Optional.empty();

    /** Builds the {@link Client} instance. */
    public Client build() {
      return new Client(
          apiKey,
          project,
          location,
          credentials,
          httpOptions,
          clientOptions,
          vertexAI,
          debugConfig);
    }

    /** Sets the API key for Gemini API. */
    @CanIgnoreReturnValue
    public Builder apiKey(String apiKey) {
      checkNotNull(apiKey, "apiKey cannot be null");
      this.apiKey = Optional.of(apiKey);
      return this;
    }

    /** Sets the project ID for Vertex AI APIs. */
    @CanIgnoreReturnValue
    public Builder project(String project) {
      checkNotNull(project, "project cannot be null");
      this.project = Optional.of(project);
      return this;
    }

    /** Sets the location for Vertex AI APIs. */
    @CanIgnoreReturnValue
    public Builder location(String location) {
      checkNotNull(location, "location cannot be null");
      this.location = Optional.of(location);
      return this;
    }

    /** Sets the {@link GoogleCredentials} for Vertex AI APIs. */
    @CanIgnoreReturnValue
    public Builder credentials(GoogleCredentials credentials) {
      checkNotNull(credentials, "credentials cannot be null");
      this.credentials = Optional.of(credentials);
      return this;
    }

    /** Sets the {@link ClientOptions} for the API client. */
    @CanIgnoreReturnValue
    public Builder clientOptions(ClientOptions clientOptions) {
      checkNotNull(clientOptions, "clientOptions cannot be null");
      this.clientOptions = Optional.of(clientOptions);
      return this;
    }

    /** Sets the {@link HttpOptions} for the API client. */
    @CanIgnoreReturnValue
    public Builder httpOptions(HttpOptions httpOptions) {
      checkNotNull(httpOptions, "httpOptions cannot be null");
      this.httpOptions = Optional.of(httpOptions);
      return this;
    }

    /** Sets whether to use Vertex AI APIs. */
    @CanIgnoreReturnValue
    public Builder vertexAI(boolean vertexAI) {
      this.vertexAI = Optional.of(vertexAI);
      return this;
    }

    /**
     * Sets the {@link DebugConfig} for debugging or testing the Client. This is for internal use
     * only.
     */
    @CanIgnoreReturnValue
    Builder debugConfig(DebugConfig debugConfig) {
      checkNotNull(debugConfig, "debugConfig cannot be null");
      this.debugConfig = Optional.of(debugConfig);
      return this;
    }
  }

  /** Returns a {@link Builder} for {@link Client}. */
  public static Builder builder() {
    return new Builder();
  }

  /** Constructs a Client instance with environment variables. */
  public Client() {
    this(
        /* apiKey= */ Optional.empty(),
        /* project= */ Optional.empty(),
        /* location= */ Optional.empty(),
        /* credentials= */ Optional.empty(),
        /* httpOptions= */ Optional.empty(),
        /* clientOptions= */ Optional.empty(),
        /* vertexAI= */ Optional.empty(),
        /* debugConfig= */ Optional.empty());
  }

  /**
   * Constructs a Client instance with the given parameters.
   *
   * @param apiKey Optional String for the <a
   *     href="https://ai.google.dev/gemini-api/docs/api-key">API key</a>. Gemini API only.
   * @param project Optional String for the project ID. Vertex AI APIs only. Find your <a
   *     href="https://cloud.google.com/resource-manager/docs/creating-managing-projects#identifying_projects">project
   *     ID</a>
   * @param location Optional String for the <a
   *     href="https://cloud.google.com/vertex-ai/generative-ai/docs/learn/locations">location</a>.
   *     Vertex AI APIs only.
   * @param credentials Optional {@link GoogleCredentials}. Vertex AI APIs only.
   * @param httpOptions Optional {@link HttpOptions} for sending HTTP requests.
   * @param clientOptions Optional {@link ClientOptions} for the API client.
   * @param vertexAI Optional Boolean for whether to use Vertex AI APIs. If not specified here nor
   *     in the environment variable, default to false.
   * @param debugConfig Optional {@link DebugConfig} for debugging or testing the Client.
   * @throws IllegalArgumentException if the project/location and API key are set together.
   */
  private Client(
      Optional<String> apiKey,
      Optional<String> project,
      Optional<String> location,
      Optional<GoogleCredentials> credentials,
      Optional<HttpOptions> httpOptions,
      Optional<ClientOptions> clientOptions,
      Optional<Boolean> vertexAI,
      Optional<DebugConfig> debugConfig) {
    checkNotNull(vertexAI, "vertexAI cannot be null");
    checkNotNull(debugConfig, "debugConfig cannot be null");

    boolean useVertexAI;
    if (vertexAI.isPresent()) {
      useVertexAI = vertexAI.get();
    } else {
      String envVar = ApiClient.defaultEnvironmentVariables().get("vertexAI");
      useVertexAI = envVar != null && envVar.equalsIgnoreCase("true");
    }

    if (project.isPresent() || location.isPresent()) {
      if (apiKey.isPresent()) {
        throw new IllegalArgumentException(
            "Project/location and API key are mutually exclusive in the client initializer.");
      }
      if (!useVertexAI) {
        throw new IllegalArgumentException("Gemini API do not support project/location.");
      }
    }

    this.debugConfig = debugConfig.orElse(new DebugConfig());
    if (this.debugConfig.clientMode().equals("replay")) {
      if (!useVertexAI) {
        this.apiClient =
            new ReplayApiClient(
                /* apiKey= */ apiKey,
                /* httpOptions= */ httpOptions,
                /* clientOptions= */ clientOptions,
                this.debugConfig.replaysDirectory(),
                this.debugConfig.replayId(),
                this.debugConfig.clientMode());
      } else {
        this.apiClient =
            new ReplayApiClient(
                /* apiKey= */ apiKey,
                /* project= */ project,
                /* location= */ location,
                /* credentials= */ credentials,
                /* httpOptions= */ httpOptions,
                /* clientOptions= */ clientOptions,
                this.debugConfig.replaysDirectory(),
                this.debugConfig.replayId(),
                this.debugConfig.clientMode());
      }
    } else {
      if (!useVertexAI) {
        this.apiClient =
            new HttpApiClient(
                /* apiKey= */ apiKey,
                /* httpOptions= */ httpOptions,
                /* clientOptions= */ clientOptions);
      } else {
        this.apiClient =
            new HttpApiClient(
                /* apiKey= */ apiKey,
                /* project= */ project,
                /* location= */ location,
                /* credentials= */ credentials,
                /* httpOptions= */ httpOptions,
                /* clientOptions= */ clientOptions);
      }
    }

    datasets = new Datasets(this.apiClient);
    evals = new Evals(this.apiClient);
  }

  /** Returns whether the client is using Vertex AI APIs. */
  public boolean vertexAI() {
    return apiClient.vertexAI();
  }

  /** Returns the project ID for Vertex AI APIs. */
  public String project() {
    return apiClient.project();
  }

  /** Returns the location for Vertex AI APIs. */
  public String location() {
    return apiClient.location();
  }

  /** Returns the API key for Gemini API. */
  public String apiKey() {
    return apiClient.apiKey();
  }

  /** Sets the replay ID for the replay client. For internal testing only. */
  void setReplayId(String replayId) {
    if (this.apiClient instanceof ReplayApiClient) {
      ((ReplayApiClient) this.apiClient).initializeReplaySession(replayId);
    }
  }

  /** Returns the debug config for the client. */
  DebugConfig debugConfig() {
    return debugConfig;
  }

  /** Returns the client mode. If it's "replay", then the client is in testing mode. */
  String clientMode() {
    return debugConfig.clientMode();
  }

  /** Returns the base URL for the API client. */
  Optional<String> baseUrl() {
    if (apiClient.httpOptions().baseUrl().isPresent()) {
      return apiClient.httpOptions().baseUrl();
    }
    return Optional.empty();
  }

  /** Closes the Client instance together with its instantiated http client. */
  @Override
  public void close() {
    try {
      apiClient.httpClient().dispatcher().executorService().shutdown();
      apiClient.httpClient().connectionPool().evictAll();
      if (apiClient.httpClient().cache() != null) {
        apiClient.httpClient().cache().close();
      }
    } catch (IOException e) {
      throw new GenAiIOException("Failed to close the client.", e);
    }
  }

  /**
   * Overrides the base URLs for the Gemini API and/or Vertex AI API.
   *
   * <p>Note: This function should be called before initializing the SDK. If the base URLs are set
   * after initializing the SDK, the base URLs will not be updated.
   *
   * <p>Precedence rule for base URL:
   *
   * <p>1. Base URL set via HttpOptions.
   *
   * <p>2. Base URL set via the latest call to setDefaultBaseUrls.
   *
   * <p>3. Base URL set via environment variables GOOGLE_GEMINI_BASE_URL or GOOGLE_VERTEX_BASE_URL.
   */
  public static void setDefaultBaseUrls(
      Optional<String> geminiBaseUrl, Optional<String> vertexBaseUrl) {
    ApiClient.setDefaultBaseUrls(geminiBaseUrl, vertexBaseUrl);
  }
}
