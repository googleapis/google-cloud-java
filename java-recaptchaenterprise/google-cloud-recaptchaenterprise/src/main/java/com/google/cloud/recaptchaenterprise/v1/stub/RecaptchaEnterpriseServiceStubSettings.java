/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.recaptchaenterprise.v1.stub;

import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListKeysPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1.Assessment;
import com.google.recaptchaenterprise.v1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1.CreateKeyRequest;
import com.google.recaptchaenterprise.v1.DeleteKeyRequest;
import com.google.recaptchaenterprise.v1.GetKeyRequest;
import com.google.recaptchaenterprise.v1.Key;
import com.google.recaptchaenterprise.v1.ListKeysRequest;
import com.google.recaptchaenterprise.v1.ListKeysResponse;
import com.google.recaptchaenterprise.v1.UpdateKeyRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RecaptchaEnterpriseServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (recaptchaenterprise.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createAssessment to 30 seconds:
 *
 * <pre>{@code
 * RecaptchaEnterpriseServiceStubSettings.Builder recaptchaEnterpriseServiceSettingsBuilder =
 *     RecaptchaEnterpriseServiceStubSettings.newBuilder();
 * recaptchaEnterpriseServiceSettingsBuilder
 *     .createAssessmentSettings()
 *     .setRetrySettings(
 *         recaptchaEnterpriseServiceSettingsBuilder
 *             .createAssessmentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RecaptchaEnterpriseServiceStubSettings recaptchaEnterpriseServiceSettings =
 *     recaptchaEnterpriseServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class RecaptchaEnterpriseServiceStubSettings
    extends StubSettings<RecaptchaEnterpriseServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateAssessmentRequest, Assessment> createAssessmentSettings;
  private final UnaryCallSettings<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentSettings;
  private final UnaryCallSettings<CreateKeyRequest, Key> createKeySettings;
  private final PagedCallSettings<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
      listKeysSettings;
  private final UnaryCallSettings<GetKeyRequest, Key> getKeySettings;
  private final UnaryCallSettings<UpdateKeyRequest, Key> updateKeySettings;
  private final UnaryCallSettings<DeleteKeyRequest, Empty> deleteKeySettings;

  private static final PagedListDescriptor<ListKeysRequest, ListKeysResponse, Key>
      LIST_KEYS_PAGE_STR_DESC =
          new PagedListDescriptor<ListKeysRequest, ListKeysResponse, Key>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListKeysRequest injectToken(ListKeysRequest payload, String token) {
              return ListKeysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListKeysRequest injectPageSize(ListKeysRequest payload, int pageSize) {
              return ListKeysRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListKeysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListKeysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Key> extractResources(ListKeysResponse payload) {
              return payload.getKeysList() == null
                  ? ImmutableList.<Key>of()
                  : payload.getKeysList();
            }
          };

  private static final PagedListResponseFactory<
          ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
      LIST_KEYS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>() {
            @Override
            public ApiFuture<ListKeysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListKeysRequest, ListKeysResponse> callable,
                ListKeysRequest request,
                ApiCallContext context,
                ApiFuture<ListKeysResponse> futureResponse) {
              PageContext<ListKeysRequest, ListKeysResponse, Key> pageContext =
                  PageContext.create(callable, LIST_KEYS_PAGE_STR_DESC, request, context);
              return ListKeysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createAssessment. */
  public UnaryCallSettings<CreateAssessmentRequest, Assessment> createAssessmentSettings() {
    return createAssessmentSettings;
  }

  /** Returns the object with the settings used for calls to annotateAssessment. */
  public UnaryCallSettings<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentSettings() {
    return annotateAssessmentSettings;
  }

  /** Returns the object with the settings used for calls to createKey. */
  public UnaryCallSettings<CreateKeyRequest, Key> createKeySettings() {
    return createKeySettings;
  }

  /** Returns the object with the settings used for calls to listKeys. */
  public PagedCallSettings<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
      listKeysSettings() {
    return listKeysSettings;
  }

  /** Returns the object with the settings used for calls to getKey. */
  public UnaryCallSettings<GetKeyRequest, Key> getKeySettings() {
    return getKeySettings;
  }

  /** Returns the object with the settings used for calls to updateKey. */
  public UnaryCallSettings<UpdateKeyRequest, Key> updateKeySettings() {
    return updateKeySettings;
  }

  /** Returns the object with the settings used for calls to deleteKey. */
  public UnaryCallSettings<DeleteKeyRequest, Empty> deleteKeySettings() {
    return deleteKeySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RecaptchaEnterpriseServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcRecaptchaEnterpriseServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "recaptchaenterprise.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(RecaptchaEnterpriseServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected RecaptchaEnterpriseServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createAssessmentSettings = settingsBuilder.createAssessmentSettings().build();
    annotateAssessmentSettings = settingsBuilder.annotateAssessmentSettings().build();
    createKeySettings = settingsBuilder.createKeySettings().build();
    listKeysSettings = settingsBuilder.listKeysSettings().build();
    getKeySettings = settingsBuilder.getKeySettings().build();
    updateKeySettings = settingsBuilder.updateKeySettings().build();
    deleteKeySettings = settingsBuilder.deleteKeySettings().build();
  }

  /** Builder for RecaptchaEnterpriseServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RecaptchaEnterpriseServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateAssessmentRequest, Assessment>
        createAssessmentSettings;
    private final UnaryCallSettings.Builder<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
        annotateAssessmentSettings;
    private final UnaryCallSettings.Builder<CreateKeyRequest, Key> createKeySettings;
    private final PagedCallSettings.Builder<
            ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
        listKeysSettings;
    private final UnaryCallSettings.Builder<GetKeyRequest, Key> getKeySettings;
    private final UnaryCallSettings.Builder<UpdateKeyRequest, Key> updateKeySettings;
    private final UnaryCallSettings.Builder<DeleteKeyRequest, Empty> deleteKeySettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createAssessmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      annotateAssessmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listKeysSettings = PagedCallSettings.newBuilder(LIST_KEYS_PAGE_STR_FACT);
      getKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAssessmentSettings,
              annotateAssessmentSettings,
              createKeySettings,
              listKeysSettings,
              getKeySettings,
              updateKeySettings,
              deleteKeySettings);
      initDefaults(this);
    }

    protected Builder(RecaptchaEnterpriseServiceStubSettings settings) {
      super(settings);

      createAssessmentSettings = settings.createAssessmentSettings.toBuilder();
      annotateAssessmentSettings = settings.annotateAssessmentSettings.toBuilder();
      createKeySettings = settings.createKeySettings.toBuilder();
      listKeysSettings = settings.listKeysSettings.toBuilder();
      getKeySettings = settings.getKeySettings.toBuilder();
      updateKeySettings = settings.updateKeySettings.toBuilder();
      deleteKeySettings = settings.deleteKeySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAssessmentSettings,
              annotateAssessmentSettings,
              createKeySettings,
              listKeysSettings,
              getKeySettings,
              updateKeySettings,
              deleteKeySettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createAssessmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .annotateAssessmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createAssessment. */
    public UnaryCallSettings.Builder<CreateAssessmentRequest, Assessment>
        createAssessmentSettings() {
      return createAssessmentSettings;
    }

    /** Returns the builder for the settings used for calls to annotateAssessment. */
    public UnaryCallSettings.Builder<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
        annotateAssessmentSettings() {
      return annotateAssessmentSettings;
    }

    /** Returns the builder for the settings used for calls to createKey. */
    public UnaryCallSettings.Builder<CreateKeyRequest, Key> createKeySettings() {
      return createKeySettings;
    }

    /** Returns the builder for the settings used for calls to listKeys. */
    public PagedCallSettings.Builder<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
        listKeysSettings() {
      return listKeysSettings;
    }

    /** Returns the builder for the settings used for calls to getKey. */
    public UnaryCallSettings.Builder<GetKeyRequest, Key> getKeySettings() {
      return getKeySettings;
    }

    /** Returns the builder for the settings used for calls to updateKey. */
    public UnaryCallSettings.Builder<UpdateKeyRequest, Key> updateKeySettings() {
      return updateKeySettings;
    }

    /** Returns the builder for the settings used for calls to deleteKey. */
    public UnaryCallSettings.Builder<DeleteKeyRequest, Empty> deleteKeySettings() {
      return deleteKeySettings;
    }

    @Override
    public RecaptchaEnterpriseServiceStubSettings build() throws IOException {
      return new RecaptchaEnterpriseServiceStubSettings(this);
    }
  }
}
