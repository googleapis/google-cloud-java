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

package com.google.cloud.recommendationengine.v1beta1.stub;

import static com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistryClient.ListPredictionApiKeyRegistrationsPagedResponse;

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
import com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest;
import com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest;
import com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest;
import com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse;
import com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PredictionApiKeyRegistryStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (recommendationengine.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createPredictionApiKeyRegistration to 30 seconds:
 *
 * <pre>{@code
 * PredictionApiKeyRegistryStubSettings.Builder predictionApiKeyRegistrySettingsBuilder =
 *     PredictionApiKeyRegistryStubSettings.newBuilder();
 * predictionApiKeyRegistrySettingsBuilder
 *     .createPredictionApiKeyRegistrationSettings()
 *     .setRetrySettings(
 *         predictionApiKeyRegistrySettingsBuilder
 *             .createPredictionApiKeyRegistrationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PredictionApiKeyRegistryStubSettings predictionApiKeyRegistrySettings =
 *     predictionApiKeyRegistrySettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PredictionApiKeyRegistryStubSettings
    extends StubSettings<PredictionApiKeyRegistryStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<
          CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
      createPredictionApiKeyRegistrationSettings;
  private final PagedCallSettings<
          ListPredictionApiKeyRegistrationsRequest,
          ListPredictionApiKeyRegistrationsResponse,
          ListPredictionApiKeyRegistrationsPagedResponse>
      listPredictionApiKeyRegistrationsSettings;
  private final UnaryCallSettings<DeletePredictionApiKeyRegistrationRequest, Empty>
      deletePredictionApiKeyRegistrationSettings;

  private static final PagedListDescriptor<
          ListPredictionApiKeyRegistrationsRequest,
          ListPredictionApiKeyRegistrationsResponse,
          PredictionApiKeyRegistration>
      LIST_PREDICTION_API_KEY_REGISTRATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPredictionApiKeyRegistrationsRequest,
              ListPredictionApiKeyRegistrationsResponse,
              PredictionApiKeyRegistration>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPredictionApiKeyRegistrationsRequest injectToken(
                ListPredictionApiKeyRegistrationsRequest payload, String token) {
              return ListPredictionApiKeyRegistrationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListPredictionApiKeyRegistrationsRequest injectPageSize(
                ListPredictionApiKeyRegistrationsRequest payload, int pageSize) {
              return ListPredictionApiKeyRegistrationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPredictionApiKeyRegistrationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPredictionApiKeyRegistrationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PredictionApiKeyRegistration> extractResources(
                ListPredictionApiKeyRegistrationsResponse payload) {
              return payload.getPredictionApiKeyRegistrationsList() == null
                  ? ImmutableList.<PredictionApiKeyRegistration>of()
                  : payload.getPredictionApiKeyRegistrationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPredictionApiKeyRegistrationsRequest,
          ListPredictionApiKeyRegistrationsResponse,
          ListPredictionApiKeyRegistrationsPagedResponse>
      LIST_PREDICTION_API_KEY_REGISTRATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPredictionApiKeyRegistrationsRequest,
              ListPredictionApiKeyRegistrationsResponse,
              ListPredictionApiKeyRegistrationsPagedResponse>() {
            @Override
            public ApiFuture<ListPredictionApiKeyRegistrationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListPredictionApiKeyRegistrationsRequest,
                        ListPredictionApiKeyRegistrationsResponse>
                    callable,
                ListPredictionApiKeyRegistrationsRequest request,
                ApiCallContext context,
                ApiFuture<ListPredictionApiKeyRegistrationsResponse> futureResponse) {
              PageContext<
                      ListPredictionApiKeyRegistrationsRequest,
                      ListPredictionApiKeyRegistrationsResponse,
                      PredictionApiKeyRegistration>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_PREDICTION_API_KEY_REGISTRATIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListPredictionApiKeyRegistrationsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createPredictionApiKeyRegistration. */
  public UnaryCallSettings<CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
      createPredictionApiKeyRegistrationSettings() {
    return createPredictionApiKeyRegistrationSettings;
  }

  /** Returns the object with the settings used for calls to listPredictionApiKeyRegistrations. */
  public PagedCallSettings<
          ListPredictionApiKeyRegistrationsRequest,
          ListPredictionApiKeyRegistrationsResponse,
          ListPredictionApiKeyRegistrationsPagedResponse>
      listPredictionApiKeyRegistrationsSettings() {
    return listPredictionApiKeyRegistrationsSettings;
  }

  /** Returns the object with the settings used for calls to deletePredictionApiKeyRegistration. */
  public UnaryCallSettings<DeletePredictionApiKeyRegistrationRequest, Empty>
      deletePredictionApiKeyRegistrationSettings() {
    return deletePredictionApiKeyRegistrationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PredictionApiKeyRegistryStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPredictionApiKeyRegistryStub.create(this);
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
    return "recommendationengine.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(PredictionApiKeyRegistryStubSettings.class))
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

  protected PredictionApiKeyRegistryStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createPredictionApiKeyRegistrationSettings =
        settingsBuilder.createPredictionApiKeyRegistrationSettings().build();
    listPredictionApiKeyRegistrationsSettings =
        settingsBuilder.listPredictionApiKeyRegistrationsSettings().build();
    deletePredictionApiKeyRegistrationSettings =
        settingsBuilder.deletePredictionApiKeyRegistrationSettings().build();
  }

  /** Builder for PredictionApiKeyRegistryStubSettings. */
  public static class Builder
      extends StubSettings.Builder<PredictionApiKeyRegistryStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
        createPredictionApiKeyRegistrationSettings;
    private final PagedCallSettings.Builder<
            ListPredictionApiKeyRegistrationsRequest,
            ListPredictionApiKeyRegistrationsResponse,
            ListPredictionApiKeyRegistrationsPagedResponse>
        listPredictionApiKeyRegistrationsSettings;
    private final UnaryCallSettings.Builder<DeletePredictionApiKeyRegistrationRequest, Empty>
        deletePredictionApiKeyRegistrationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
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
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createPredictionApiKeyRegistrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPredictionApiKeyRegistrationsSettings =
          PagedCallSettings.newBuilder(LIST_PREDICTION_API_KEY_REGISTRATIONS_PAGE_STR_FACT);
      deletePredictionApiKeyRegistrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPredictionApiKeyRegistrationSettings,
              listPredictionApiKeyRegistrationsSettings,
              deletePredictionApiKeyRegistrationSettings);
      initDefaults(this);
    }

    protected Builder(PredictionApiKeyRegistryStubSettings settings) {
      super(settings);

      createPredictionApiKeyRegistrationSettings =
          settings.createPredictionApiKeyRegistrationSettings.toBuilder();
      listPredictionApiKeyRegistrationsSettings =
          settings.listPredictionApiKeyRegistrationsSettings.toBuilder();
      deletePredictionApiKeyRegistrationSettings =
          settings.deletePredictionApiKeyRegistrationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPredictionApiKeyRegistrationSettings,
              listPredictionApiKeyRegistrationsSettings,
              deletePredictionApiKeyRegistrationSettings);
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
          .createPredictionApiKeyRegistrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPredictionApiKeyRegistrationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deletePredictionApiKeyRegistrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /**
     * Returns the builder for the settings used for calls to createPredictionApiKeyRegistration.
     */
    public UnaryCallSettings.Builder<
            CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
        createPredictionApiKeyRegistrationSettings() {
      return createPredictionApiKeyRegistrationSettings;
    }

    /** Returns the builder for the settings used for calls to listPredictionApiKeyRegistrations. */
    public PagedCallSettings.Builder<
            ListPredictionApiKeyRegistrationsRequest,
            ListPredictionApiKeyRegistrationsResponse,
            ListPredictionApiKeyRegistrationsPagedResponse>
        listPredictionApiKeyRegistrationsSettings() {
      return listPredictionApiKeyRegistrationsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deletePredictionApiKeyRegistration.
     */
    public UnaryCallSettings.Builder<DeletePredictionApiKeyRegistrationRequest, Empty>
        deletePredictionApiKeyRegistrationSettings() {
      return deletePredictionApiKeyRegistrationSettings;
    }

    @Override
    public PredictionApiKeyRegistryStubSettings build() throws IOException {
      return new PredictionApiKeyRegistryStubSettings(this);
    }
  }
}
