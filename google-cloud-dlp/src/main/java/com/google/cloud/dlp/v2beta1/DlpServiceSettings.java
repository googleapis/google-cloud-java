/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dlp.v2beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.GrpcTransport;
import com.google.api.gax.grpc.GrpcTransportProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.api.gax.grpc.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.SimpleCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dlp.v2beta1.stub.DlpServiceStub;
import com.google.cloud.dlp.v2beta1.stub.GrpcDlpServiceStub;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest;
import com.google.privacy.dlp.v2beta1.InspectContentRequest;
import com.google.privacy.dlp.v2beta1.InspectContentResponse;
import com.google.privacy.dlp.v2beta1.InspectOperationMetadata;
import com.google.privacy.dlp.v2beta1.InspectOperationResult;
import com.google.privacy.dlp.v2beta1.ListInfoTypesRequest;
import com.google.privacy.dlp.v2beta1.ListInfoTypesResponse;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse;
import com.google.privacy.dlp.v2beta1.RedactContentRequest;
import com.google.privacy.dlp.v2beta1.RedactContentResponse;
import io.grpc.Status;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link DlpServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dlp.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of inspectContent to 30 seconds:
 *
 * <pre>
 * <code>
 * DlpServiceSettings.Builder dlpServiceSettingsBuilder =
 *     DlpServiceSettings.defaultBuilder();
 * dlpServiceSettingsBuilder.inspectContentSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DlpServiceSettings dlpServiceSettings = dlpServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class DlpServiceSettings extends ClientSettings {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "/com/google/cloud/dlp/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final SimpleCallSettings<InspectContentRequest, InspectContentResponse>
      inspectContentSettings;
  private final SimpleCallSettings<RedactContentRequest, RedactContentResponse>
      redactContentSettings;
  private final OperationCallSettings<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata,
          Operation>
      createInspectOperationSettings;
  private final SimpleCallSettings<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsSettings;
  private final SimpleCallSettings<ListInfoTypesRequest, ListInfoTypesResponse>
      listInfoTypesSettings;
  private final SimpleCallSettings<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesSettings;

  /** Returns the object with the settings used for calls to inspectContent. */
  public SimpleCallSettings<InspectContentRequest, InspectContentResponse>
      inspectContentSettings() {
    return inspectContentSettings;
  }

  /** Returns the object with the settings used for calls to redactContent. */
  public SimpleCallSettings<RedactContentRequest, RedactContentResponse> redactContentSettings() {
    return redactContentSettings;
  }

  /** Returns the object with the settings used for calls to createInspectOperation. */
  public OperationCallSettings<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata,
          Operation>
      createInspectOperationSettings() {
    return createInspectOperationSettings;
  }

  /** Returns the object with the settings used for calls to listInspectFindings. */
  public SimpleCallSettings<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsSettings() {
    return listInspectFindingsSettings;
  }

  /** Returns the object with the settings used for calls to listInfoTypes. */
  public SimpleCallSettings<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesSettings() {
    return listInfoTypesSettings;
  }

  /** Returns the object with the settings used for calls to listRootCategories. */
  public SimpleCallSettings<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesSettings() {
    return listRootCategoriesSettings;
  }

  public DlpServiceStub createStub() throws IOException {
    if (getTransportProvider().getTransportName().equals(GrpcTransport.getGrpcTransportName())) {
      return GrpcDlpServiceStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "dlp.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingChannelProvider.Builder defaultGrpcChannelProviderBuilder() {
    return InstantiatingChannelProvider.newBuilder()
        .setEndpoint(getDefaultEndpoint())
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion());
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static GrpcTransportProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GrpcTransportProvider.newBuilder()
        .setChannelProvider(defaultGrpcChannelProviderBuilder().build());
  }

  public static TransportProvider defaultTransportProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  private static String getGapicVersion() {
    if (gapicVersion == null) {
      gapicVersion =
          PropertiesProvider.loadProperty(
              DlpServiceSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
      gapicVersion = gapicVersion == null ? DEFAULT_GAPIC_VERSION : gapicVersion;
    }
    return gapicVersion;
  }

  /** Returns a builder for this class with recommended defaults. */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /**
   * Returns a builder for this class with recommended defaults for API methods, and the given
   * ClientContext used for executor/transport/credentials.
   */
  public static Builder defaultBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private DlpServiceSettings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getTransportProvider(),
        settingsBuilder.getCredentialsProvider(),
        settingsBuilder.getClock());

    inspectContentSettings = settingsBuilder.inspectContentSettings().build();
    redactContentSettings = settingsBuilder.redactContentSettings().build();
    createInspectOperationSettings = settingsBuilder.createInspectOperationSettings().build();
    listInspectFindingsSettings = settingsBuilder.listInspectFindingsSettings().build();
    listInfoTypesSettings = settingsBuilder.listInfoTypesSettings().build();
    listRootCategoriesSettings = settingsBuilder.listRootCategoriesSettings().build();
  }

  /** Builder for DlpServiceSettings. */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder> unaryMethodSettingsBuilders;

    private final SimpleCallSettings.Builder<InspectContentRequest, InspectContentResponse>
        inspectContentSettings;
    private final SimpleCallSettings.Builder<RedactContentRequest, RedactContentResponse>
        redactContentSettings;
    private final OperationCallSettings.Builder<
            CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata,
            Operation>
        createInspectOperationSettings;
    private final SimpleCallSettings.Builder<
            ListInspectFindingsRequest, ListInspectFindingsResponse>
        listInspectFindingsSettings;
    private final SimpleCallSettings.Builder<ListInfoTypesRequest, ListInfoTypesResponse>
        listInfoTypesSettings;
    private final SimpleCallSettings.Builder<ListRootCategoriesRequest, ListRootCategoriesResponse>
        listRootCategoriesSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode>newArrayList(
                  GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED),
                  GrpcStatusCode.of(Status.Code.UNAVAILABLE))));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      this((ClientContext) null);
    }

    private Builder(ClientContext clientContext) {
      super(clientContext);

      inspectContentSettings = SimpleCallSettings.newBuilder();

      redactContentSettings = SimpleCallSettings.newBuilder();

      createInspectOperationSettings = OperationCallSettings.newBuilder();

      listInspectFindingsSettings = SimpleCallSettings.newBuilder();

      listInfoTypesSettings = SimpleCallSettings.newBuilder();

      listRootCategoriesSettings = SimpleCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              inspectContentSettings,
              redactContentSettings,
              listInspectFindingsSettings,
              listInfoTypesSettings,
              listRootCategoriesSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportProvider(defaultTransportProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .inspectContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .redactContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInspectFindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInfoTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRootCategoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));
      builder
          .createInspectOperationSettings()
          .setInitialCallSettings(
              SimpleCallSettings.<CreateInspectOperationRequest, Operation>newBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseClass(InspectOperationResult.class)
          .setMetadataClass(InspectOperationMetadata.class)
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(20000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(86400000L))
                      .build()));

      return builder;
    }

    private Builder(DlpServiceSettings settings) {
      super(settings);

      inspectContentSettings = settings.inspectContentSettings.toBuilder();
      redactContentSettings = settings.redactContentSettings.toBuilder();
      createInspectOperationSettings = settings.createInspectOperationSettings.toBuilder();
      listInspectFindingsSettings = settings.listInspectFindingsSettings.toBuilder();
      listInfoTypesSettings = settings.listInfoTypesSettings.toBuilder();
      listRootCategoriesSettings = settings.listRootCategoriesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              inspectContentSettings,
              redactContentSettings,
              listInspectFindingsSettings,
              listInfoTypesSettings,
              listRootCategoriesSettings);
    }

    @Override
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      super.setExecutorProvider(executorProvider);
      return this;
    }

    @Override
    public Builder setTransportProvider(TransportProvider transportProvider) {
      super.setTransportProvider(transportProvider);
      return this;
    }

    @Override
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      super.setCredentialsProvider(credentialsProvider);
      return this;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to inspectContent. */
    public SimpleCallSettings.Builder<InspectContentRequest, InspectContentResponse>
        inspectContentSettings() {
      return inspectContentSettings;
    }

    /** Returns the builder for the settings used for calls to redactContent. */
    public SimpleCallSettings.Builder<RedactContentRequest, RedactContentResponse>
        redactContentSettings() {
      return redactContentSettings;
    }

    /** Returns the builder for the settings used for calls to createInspectOperation. */
    public OperationCallSettings.Builder<
            CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata,
            Operation>
        createInspectOperationSettings() {
      return createInspectOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listInspectFindings. */
    public SimpleCallSettings.Builder<ListInspectFindingsRequest, ListInspectFindingsResponse>
        listInspectFindingsSettings() {
      return listInspectFindingsSettings;
    }

    /** Returns the builder for the settings used for calls to listInfoTypes. */
    public SimpleCallSettings.Builder<ListInfoTypesRequest, ListInfoTypesResponse>
        listInfoTypesSettings() {
      return listInfoTypesSettings;
    }

    /** Returns the builder for the settings used for calls to listRootCategories. */
    public SimpleCallSettings.Builder<ListRootCategoriesRequest, ListRootCategoriesResponse>
        listRootCategoriesSettings() {
      return listRootCategoriesSettings;
    }

    @Override
    public DlpServiceSettings build() throws IOException {
      return new DlpServiceSettings(this);
    }
  }
}
