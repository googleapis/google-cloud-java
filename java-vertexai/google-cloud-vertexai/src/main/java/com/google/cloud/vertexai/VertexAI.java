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
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
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
  private final CredentialsProvider credentialsProvider;

  private final transient Supplier<PredictionServiceClient> predictionClientSupplier;
  private final transient Supplier<LlmUtilityServiceClient> llmClientSupplier;

  /**
   * Constructs a VertexAI instance.
   *
   * @param projectId the default project to use when making API calls
   * @param location the default location to use when making API calls
   */
  public VertexAI(String projectId, String location) {
    this(
        projectId,
        location,
        Transport.GRPC,
        ImmutableList.of(),
        /* credentials= */ Optional.empty(),
        /* apiEndpoint= */ Optional.empty(),
        /* predictionClientSupplierOpt= */ Optional.empty(),
        /* llmClientSupplierOpt= */ Optional.empty());
  }

  private VertexAI(
      String projectId,
      String location,
      Transport transport,
      List<String> scopes,
      Optional<Credentials> credentials,
      Optional<String> apiEndpoint,
      Optional<Supplier<PredictionServiceClient>> predictionClientSupplierOpt,
      Optional<Supplier<LlmUtilityServiceClient>> llmClientSupplierOpt) {
    if (!scopes.isEmpty() && credentials.isPresent()) {
      throw new IllegalArgumentException(
          "At most one of Credentials and scopes should be specified.");
    }
    checkArgument(!Strings.isNullOrEmpty(projectId), "projectId can't be null or empty");
    checkArgument(!Strings.isNullOrEmpty(location), "location can't be null or empty");
    checkNotNull(transport, "transport can't be null");

    this.projectId = projectId;
    this.location = location;
    this.transport = transport;

    if (credentials.isPresent()) {
      this.credentialsProvider = FixedCredentialsProvider.create(credentials.get());
    } else {
      this.credentialsProvider =
          scopes.isEmpty()
              ? PredictionServiceSettings.defaultCredentialsProviderBuilder().build()
              : GoogleCredentialsProvider.newBuilder()
                  .setScopesToApply(scopes)
                  .setUseJwtAccessWithScope(true)
                  .build();
    }

    this.predictionClientSupplier =
        Suppliers.memoize(predictionClientSupplierOpt.orElse(this::newPredictionServiceClient));

    this.llmClientSupplier =
        Suppliers.memoize(llmClientSupplierOpt.orElse(this::newLlmUtilityClient));

    this.apiEndpoint = apiEndpoint.orElse(String.format("%s-aiplatform.googleapis.com", location));
  }

  /** Builder for {@link VertexAI}. */
  public static class Builder {
    private String projectId;
    private String location;
    private Transport transport = Transport.GRPC;
    private ImmutableList<String> scopes = ImmutableList.of();
    private Optional<Credentials> credentials = Optional.empty();
    private Optional<String> apiEndpoint = Optional.empty();

    private Supplier<PredictionServiceClient> predictionClientSupplier;

    private Supplier<LlmUtilityServiceClient> llmClientSupplier;

    public VertexAI build() {
      checkNotNull(projectId, "projectId must be set.");
      checkNotNull(location, "location must be set.");

      return new VertexAI(
          projectId,
          location,
          transport,
          scopes,
          credentials,
          apiEndpoint,
          Optional.ofNullable(predictionClientSupplier),
          Optional.ofNullable(llmClientSupplier));
    }

    @CanIgnoreReturnValue
    public Builder setProjectId(String projectId) {
      checkArgument(!Strings.isNullOrEmpty(projectId), "projectId can't be null or empty");

      this.projectId = projectId;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setLocation(String location) {
      checkArgument(!Strings.isNullOrEmpty(location), "location can't be null or empty");

      this.location = location;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setApiEndpoint(String apiEndpoint) {
      checkArgument(!Strings.isNullOrEmpty(apiEndpoint), "apiEndpoint can't be null or empty");

      this.apiEndpoint = Optional.of(apiEndpoint);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setTransport(Transport transport) {
      checkNotNull(transport, "transport can't be null");

      this.transport = transport;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setCredentials(Credentials credentials) {
      checkNotNull(credentials, "credentials can't be null");

      this.credentials = Optional.of(credentials);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setPredictionClientSupplier(
        Supplier<PredictionServiceClient> predictionClientSupplier) {
      this.predictionClientSupplier = predictionClientSupplier;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setLlmClientSupplier(Supplier<LlmUtilityServiceClient> llmClientSupplier) {
      this.llmClientSupplier = llmClientSupplier;
      return this;
    }

    @CanIgnoreReturnValue
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
   * @return {@link Credentials} to use when making API calls.
   */
  public Credentials getCredentials() throws IOException {
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
  public PredictionServiceClient getPredictionServiceClient() {
    return predictionClientSupplier.get();
  }

  private PredictionServiceClient newPredictionServiceClient() {
    // Disable the warning message logged in getApplicationDefault
    Logger defaultCredentialsProviderLogger =
        Logger.getLogger("com.google.auth.oauth2.DefaultCredentialsProvider");
    Level previousLevel = defaultCredentialsProviderLogger.getLevel();
    defaultCredentialsProviderLogger.setLevel(Level.SEVERE);

    try {
      return PredictionServiceClient.create(getPredictionServiceSettings());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    } finally {
      defaultCredentialsProviderLogger.setLevel(previousLevel);
    }
  }

  private PredictionServiceSettings getPredictionServiceSettings() throws IOException {
    PredictionServiceSettings.Builder builder;
    if (transport == Transport.REST) {
      builder = PredictionServiceSettings.newHttpJsonBuilder();
    } else {
      builder = PredictionServiceSettings.newBuilder();
    }
    builder.setEndpoint(String.format("%s:443", apiEndpoint));
    builder.setCredentialsProvider(credentialsProvider);

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
  public LlmUtilityServiceClient getLlmUtilityClient() {
    return llmClientSupplier.get();
  }

  private LlmUtilityServiceClient newLlmUtilityClient() {
    // Disable the warning message logged in getApplicationDefault
    Logger defaultCredentialsProviderLogger =
        Logger.getLogger("com.google.auth.oauth2.DefaultCredentialsProvider");
    Level previousLevel = defaultCredentialsProviderLogger.getLevel();
    defaultCredentialsProviderLogger.setLevel(Level.SEVERE);

    try {
      return LlmUtilityServiceClient.create(getLlmUtilityServiceClientSettings());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    } finally {
      defaultCredentialsProviderLogger.setLevel(previousLevel);
    }
  }

  private LlmUtilityServiceSettings getLlmUtilityServiceClientSettings() throws IOException {
    LlmUtilityServiceSettings.Builder settingsBuilder;
    if (transport == Transport.REST) {
      settingsBuilder = LlmUtilityServiceSettings.newHttpJsonBuilder();
    } else {
      settingsBuilder = LlmUtilityServiceSettings.newBuilder();
    }
    settingsBuilder.setEndpoint(String.format("%s:443", apiEndpoint));
    settingsBuilder.setCredentialsProvider(credentialsProvider);

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
    predictionClientSupplier.get().close();
    llmClientSupplier.get().close();
  }
}
