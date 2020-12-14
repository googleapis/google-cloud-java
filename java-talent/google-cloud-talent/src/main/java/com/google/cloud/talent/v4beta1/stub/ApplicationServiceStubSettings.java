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

package com.google.cloud.talent.v4beta1.stub;

import static com.google.cloud.talent.v4beta1.ApplicationServiceClient.ListApplicationsPagedResponse;

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
import com.google.cloud.talent.v4beta1.Application;
import com.google.cloud.talent.v4beta1.CreateApplicationRequest;
import com.google.cloud.talent.v4beta1.DeleteApplicationRequest;
import com.google.cloud.talent.v4beta1.GetApplicationRequest;
import com.google.cloud.talent.v4beta1.ListApplicationsRequest;
import com.google.cloud.talent.v4beta1.ListApplicationsResponse;
import com.google.cloud.talent.v4beta1.UpdateApplicationRequest;
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
 * Settings class to configure an instance of {@link ApplicationServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (jobs.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createApplication to 30 seconds:
 *
 * <pre>{@code
 * ApplicationServiceStubSettings.Builder applicationServiceSettingsBuilder =
 *     ApplicationServiceStubSettings.newBuilder();
 * applicationServiceSettingsBuilder
 *     .createApplicationSettings()
 *     .setRetrySettings(
 *         applicationServiceSettingsBuilder
 *             .createApplicationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ApplicationServiceStubSettings applicationServiceSettings =
 *     applicationServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ApplicationServiceStubSettings extends StubSettings<ApplicationServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/jobs")
          .build();

  private final UnaryCallSettings<CreateApplicationRequest, Application> createApplicationSettings;
  private final UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings;
  private final UnaryCallSettings<UpdateApplicationRequest, Application> updateApplicationSettings;
  private final UnaryCallSettings<DeleteApplicationRequest, Empty> deleteApplicationSettings;
  private final PagedCallSettings<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      listApplicationsSettings;

  private static final PagedListDescriptor<
          ListApplicationsRequest, ListApplicationsResponse, Application>
      LIST_APPLICATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListApplicationsRequest, ListApplicationsResponse, Application>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApplicationsRequest injectToken(
                ListApplicationsRequest payload, String token) {
              return ListApplicationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApplicationsRequest injectPageSize(
                ListApplicationsRequest payload, int pageSize) {
              return ListApplicationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApplicationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApplicationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Application> extractResources(ListApplicationsResponse payload) {
              return payload.getApplicationsList() == null
                  ? ImmutableList.<Application>of()
                  : payload.getApplicationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      LIST_APPLICATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>() {
            @Override
            public ApiFuture<ListApplicationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApplicationsRequest, ListApplicationsResponse> callable,
                ListApplicationsRequest request,
                ApiCallContext context,
                ApiFuture<ListApplicationsResponse> futureResponse) {
              PageContext<ListApplicationsRequest, ListApplicationsResponse, Application>
                  pageContext =
                      PageContext.create(
                          callable, LIST_APPLICATIONS_PAGE_STR_DESC, request, context);
              return ListApplicationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createApplication. */
  public UnaryCallSettings<CreateApplicationRequest, Application> createApplicationSettings() {
    return createApplicationSettings;
  }

  /** Returns the object with the settings used for calls to getApplication. */
  public UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings() {
    return getApplicationSettings;
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public UnaryCallSettings<UpdateApplicationRequest, Application> updateApplicationSettings() {
    return updateApplicationSettings;
  }

  /** Returns the object with the settings used for calls to deleteApplication. */
  public UnaryCallSettings<DeleteApplicationRequest, Empty> deleteApplicationSettings() {
    return deleteApplicationSettings;
  }

  /** Returns the object with the settings used for calls to listApplications. */
  public PagedCallSettings<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      listApplicationsSettings() {
    return listApplicationsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ApplicationServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcApplicationServiceStub.create(this);
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
    return "jobs.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ApplicationServiceStubSettings.class))
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

  protected ApplicationServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createApplicationSettings = settingsBuilder.createApplicationSettings().build();
    getApplicationSettings = settingsBuilder.getApplicationSettings().build();
    updateApplicationSettings = settingsBuilder.updateApplicationSettings().build();
    deleteApplicationSettings = settingsBuilder.deleteApplicationSettings().build();
    listApplicationsSettings = settingsBuilder.listApplicationsSettings().build();
  }

  /** Builder for ApplicationServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ApplicationServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateApplicationRequest, Application>
        createApplicationSettings;
    private final UnaryCallSettings.Builder<GetApplicationRequest, Application>
        getApplicationSettings;
    private final UnaryCallSettings.Builder<UpdateApplicationRequest, Application>
        updateApplicationSettings;
    private final UnaryCallSettings.Builder<DeleteApplicationRequest, Empty>
        deleteApplicationSettings;
    private final PagedCallSettings.Builder<
            ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
        listApplicationsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_8_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_8_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listApplicationsSettings = PagedCallSettings.newBuilder(LIST_APPLICATIONS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createApplicationSettings,
              getApplicationSettings,
              updateApplicationSettings,
              deleteApplicationSettings,
              listApplicationsSettings);
      initDefaults(this);
    }

    protected Builder(ApplicationServiceStubSettings settings) {
      super(settings);

      createApplicationSettings = settings.createApplicationSettings.toBuilder();
      getApplicationSettings = settings.getApplicationSettings.toBuilder();
      updateApplicationSettings = settings.updateApplicationSettings.toBuilder();
      deleteApplicationSettings = settings.deleteApplicationSettings.toBuilder();
      listApplicationsSettings = settings.listApplicationsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createApplicationSettings,
              getApplicationSettings,
              updateApplicationSettings,
              deleteApplicationSettings,
              listApplicationsSettings);
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
          .createApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"));

      builder
          .getApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"));

      builder
          .deleteApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listApplicationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

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

    /** Returns the builder for the settings used for calls to createApplication. */
    public UnaryCallSettings.Builder<CreateApplicationRequest, Application>
        createApplicationSettings() {
      return createApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to getApplication. */
    public UnaryCallSettings.Builder<GetApplicationRequest, Application> getApplicationSettings() {
      return getApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to updateApplication. */
    public UnaryCallSettings.Builder<UpdateApplicationRequest, Application>
        updateApplicationSettings() {
      return updateApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApplication. */
    public UnaryCallSettings.Builder<DeleteApplicationRequest, Empty> deleteApplicationSettings() {
      return deleteApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to listApplications. */
    public PagedCallSettings.Builder<
            ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
        listApplicationsSettings() {
      return listApplicationsSettings;
    }

    @Override
    public ApplicationServiceStubSettings build() throws IOException {
      return new ApplicationServiceStubSettings(this);
    }
  }
}
