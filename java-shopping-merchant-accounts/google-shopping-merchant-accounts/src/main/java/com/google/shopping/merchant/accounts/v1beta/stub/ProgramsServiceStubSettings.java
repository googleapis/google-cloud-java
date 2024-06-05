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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.ProgramsServiceClient.ListProgramsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
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
import com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest;
import com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest;
import com.google.shopping.merchant.accounts.v1beta.GetProgramRequest;
import com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse;
import com.google.shopping.merchant.accounts.v1beta.Program;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProgramsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (merchantapi.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getProgram to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProgramsServiceStubSettings.Builder programsServiceSettingsBuilder =
 *     ProgramsServiceStubSettings.newBuilder();
 * programsServiceSettingsBuilder
 *     .getProgramSettings()
 *     .setRetrySettings(
 *         programsServiceSettingsBuilder
 *             .getProgramSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProgramsServiceStubSettings programsServiceSettings = programsServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProgramsServiceStubSettings extends StubSettings<ProgramsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/content").build();

  private final UnaryCallSettings<GetProgramRequest, Program> getProgramSettings;
  private final PagedCallSettings<
          ListProgramsRequest, ListProgramsResponse, ListProgramsPagedResponse>
      listProgramsSettings;
  private final UnaryCallSettings<EnableProgramRequest, Program> enableProgramSettings;
  private final UnaryCallSettings<DisableProgramRequest, Program> disableProgramSettings;

  private static final PagedListDescriptor<ListProgramsRequest, ListProgramsResponse, Program>
      LIST_PROGRAMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListProgramsRequest, ListProgramsResponse, Program>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProgramsRequest injectToken(ListProgramsRequest payload, String token) {
              return ListProgramsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProgramsRequest injectPageSize(ListProgramsRequest payload, int pageSize) {
              return ListProgramsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProgramsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProgramsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Program> extractResources(ListProgramsResponse payload) {
              return payload.getProgramsList() == null
                  ? ImmutableList.<Program>of()
                  : payload.getProgramsList();
            }
          };

  private static final PagedListResponseFactory<
          ListProgramsRequest, ListProgramsResponse, ListProgramsPagedResponse>
      LIST_PROGRAMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProgramsRequest, ListProgramsResponse, ListProgramsPagedResponse>() {
            @Override
            public ApiFuture<ListProgramsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProgramsRequest, ListProgramsResponse> callable,
                ListProgramsRequest request,
                ApiCallContext context,
                ApiFuture<ListProgramsResponse> futureResponse) {
              PageContext<ListProgramsRequest, ListProgramsResponse, Program> pageContext =
                  PageContext.create(callable, LIST_PROGRAMS_PAGE_STR_DESC, request, context);
              return ListProgramsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getProgram. */
  public UnaryCallSettings<GetProgramRequest, Program> getProgramSettings() {
    return getProgramSettings;
  }

  /** Returns the object with the settings used for calls to listPrograms. */
  public PagedCallSettings<ListProgramsRequest, ListProgramsResponse, ListProgramsPagedResponse>
      listProgramsSettings() {
    return listProgramsSettings;
  }

  /** Returns the object with the settings used for calls to enableProgram. */
  public UnaryCallSettings<EnableProgramRequest, Program> enableProgramSettings() {
    return enableProgramSettings;
  }

  /** Returns the object with the settings used for calls to disableProgram. */
  public UnaryCallSettings<DisableProgramRequest, Program> disableProgramSettings() {
    return disableProgramSettings;
  }

  public ProgramsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcProgramsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonProgramsServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "merchantapi";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "merchantapi.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "merchantapi.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ProgramsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ProgramsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProgramsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ProgramsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getProgramSettings = settingsBuilder.getProgramSettings().build();
    listProgramsSettings = settingsBuilder.listProgramsSettings().build();
    enableProgramSettings = settingsBuilder.enableProgramSettings().build();
    disableProgramSettings = settingsBuilder.disableProgramSettings().build();
  }

  /** Builder for ProgramsServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ProgramsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetProgramRequest, Program> getProgramSettings;
    private final PagedCallSettings.Builder<
            ListProgramsRequest, ListProgramsResponse, ListProgramsPagedResponse>
        listProgramsSettings;
    private final UnaryCallSettings.Builder<EnableProgramRequest, Program> enableProgramSettings;
    private final UnaryCallSettings.Builder<DisableProgramRequest, Program> disableProgramSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getProgramSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listProgramsSettings = PagedCallSettings.newBuilder(LIST_PROGRAMS_PAGE_STR_FACT);
      enableProgramSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableProgramSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProgramSettings,
              listProgramsSettings,
              enableProgramSettings,
              disableProgramSettings);
      initDefaults(this);
    }

    protected Builder(ProgramsServiceStubSettings settings) {
      super(settings);

      getProgramSettings = settings.getProgramSettings.toBuilder();
      listProgramsSettings = settings.listProgramsSettings.toBuilder();
      enableProgramSettings = settings.enableProgramSettings.toBuilder();
      disableProgramSettings = settings.disableProgramSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProgramSettings,
              listProgramsSettings,
              enableProgramSettings,
              disableProgramSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getProgramSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listProgramsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .enableProgramSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .disableProgramSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to getProgram. */
    public UnaryCallSettings.Builder<GetProgramRequest, Program> getProgramSettings() {
      return getProgramSettings;
    }

    /** Returns the builder for the settings used for calls to listPrograms. */
    public PagedCallSettings.Builder<
            ListProgramsRequest, ListProgramsResponse, ListProgramsPagedResponse>
        listProgramsSettings() {
      return listProgramsSettings;
    }

    /** Returns the builder for the settings used for calls to enableProgram. */
    public UnaryCallSettings.Builder<EnableProgramRequest, Program> enableProgramSettings() {
      return enableProgramSettings;
    }

    /** Returns the builder for the settings used for calls to disableProgram. */
    public UnaryCallSettings.Builder<DisableProgramRequest, Program> disableProgramSettings() {
      return disableProgramSettings;
    }

    @Override
    public ProgramsServiceStubSettings build() throws IOException {
      return new ProgramsServiceStubSettings(this);
    }
  }
}
