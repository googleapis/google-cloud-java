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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ClientSettings;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.OperationCallSettings;
import com.google.api.gax.grpc.OperationTimedPollAlgorithm;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.api.gax.grpc.UnaryCallSettings;
import com.google.api.gax.retrying.RetrySettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
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

  private static final io.grpc.MethodDescriptor<InspectContentRequest, InspectContentResponse>
      METHOD_INSPECT_CONTENT =
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.privacy.dlp.v2beta1.DlpService/InspectContent",
              io.grpc.protobuf.ProtoUtils.marshaller(InspectContentRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(InspectContentResponse.getDefaultInstance()));
  private static final io.grpc.MethodDescriptor<RedactContentRequest, RedactContentResponse>
      METHOD_REDACT_CONTENT =
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.privacy.dlp.v2beta1.DlpService/RedactContent",
              io.grpc.protobuf.ProtoUtils.marshaller(RedactContentRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(RedactContentResponse.getDefaultInstance()));
  private static final io.grpc.MethodDescriptor<CreateInspectOperationRequest, Operation>
      METHOD_CREATE_INSPECT_OPERATION =
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.privacy.dlp.v2beta1.DlpService/CreateInspectOperation",
              io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateInspectOperationRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Operation.getDefaultInstance()));
  private static final io.grpc.MethodDescriptor<
          ListInspectFindingsRequest, ListInspectFindingsResponse>
      METHOD_LIST_INSPECT_FINDINGS =
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.privacy.dlp.v2beta1.DlpService/ListInspectFindings",
              io.grpc.protobuf.ProtoUtils.marshaller(
                  ListInspectFindingsRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(
                  ListInspectFindingsResponse.getDefaultInstance()));
  private static final io.grpc.MethodDescriptor<ListInfoTypesRequest, ListInfoTypesResponse>
      METHOD_LIST_INFO_TYPES =
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.privacy.dlp.v2beta1.DlpService/ListInfoTypes",
              io.grpc.protobuf.ProtoUtils.marshaller(ListInfoTypesRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(ListInfoTypesResponse.getDefaultInstance()));
  private static final io.grpc.MethodDescriptor<
          ListRootCategoriesRequest, ListRootCategoriesResponse>
      METHOD_LIST_ROOT_CATEGORIES =
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.privacy.dlp.v2beta1.DlpService/ListRootCategories",
              io.grpc.protobuf.ProtoUtils.marshaller(
                  ListRootCategoriesRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(
                  ListRootCategoriesResponse.getDefaultInstance()));

  private final SimpleCallSettings<InspectContentRequest, InspectContentResponse>
      inspectContentSettings;
  private final SimpleCallSettings<RedactContentRequest, RedactContentResponse>
      redactContentSettings;
  private final OperationCallSettings<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
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
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
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
  public static InstantiatingChannelProvider.Builder defaultChannelProviderBuilder() {
    return InstantiatingChannelProvider.newBuilder()
        .setEndpoint(getDefaultEndpoint())
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion());
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

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private DlpServiceSettings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getChannelProvider(),
        settingsBuilder.getCredentialsProvider());

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
            CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
        createInspectOperationSettings;
    private final SimpleCallSettings.Builder<
            ListInspectFindingsRequest, ListInspectFindingsResponse>
        listInspectFindingsSettings;
    private final SimpleCallSettings.Builder<ListInfoTypesRequest, ListInfoTypesResponse>
        listInfoTypesSettings;
    private final SimpleCallSettings.Builder<ListRootCategoriesRequest, ListRootCategoriesResponse>
        listRootCategoriesSettings;

    private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          Sets.immutableEnumSet(
              Lists.<Status.Code>newArrayList(
                  Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", Sets.immutableEnumSet(Lists.<Status.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings.Builder> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings.Builder> definitions = ImmutableMap.builder();
      RetrySettings.Builder settingsBuilder = null;
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L));
      definitions.put("default", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(defaultChannelProviderBuilder().build());
      setCredentialsProvider(defaultCredentialsProviderBuilder().build());

      inspectContentSettings = SimpleCallSettings.newBuilder(METHOD_INSPECT_CONTENT);

      redactContentSettings = SimpleCallSettings.newBuilder(METHOD_REDACT_CONTENT);

      createInspectOperationSettings = OperationCallSettings.newBuilder();

      listInspectFindingsSettings = SimpleCallSettings.newBuilder(METHOD_LIST_INSPECT_FINDINGS);

      listInfoTypesSettings = SimpleCallSettings.newBuilder(METHOD_LIST_INFO_TYPES);

      listRootCategoriesSettings = SimpleCallSettings.newBuilder(METHOD_LIST_ROOT_CATEGORIES);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              inspectContentSettings,
              redactContentSettings,
              listInspectFindingsSettings,
              listInfoTypesSettings,
              listRootCategoriesSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder
          .inspectContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .redactContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInspectFindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInfoTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRootCategoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));
      builder
          .createInspectOperationSettings()
          .setInitialCallSettings(
              SimpleCallSettings.newBuilder(METHOD_CREATE_INSPECT_OPERATION)
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"))
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
    public Builder setChannelProvider(ChannelProvider channelProvider) {
      super.setChannelProvider(channelProvider);
      return this;
    }

    @Override
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      super.setCredentialsProvider(credentialsProvider);
      return this;
    }

    /**
     * Applies the given settings to all of the unary API methods in this service. Only values that
     * are non-null will be applied, so this method is not capable of un-setting any values.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(UnaryCallSettings.Builder unaryCallSettings)
        throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, unaryCallSettings);
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
            CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
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
