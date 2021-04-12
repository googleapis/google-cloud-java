/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.AnswerRecordsClient.ListAnswerRecordsPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.AnswerRecord;
import com.google.cloud.dialogflow.v2beta1.GetAnswerRecordRequest;
import com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsRequest;
import com.google.cloud.dialogflow.v2beta1.ListAnswerRecordsResponse;
import com.google.cloud.dialogflow.v2beta1.UpdateAnswerRecordRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AnswerRecordsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAnswerRecord to 30 seconds:
 *
 * <pre>{@code
 * AnswerRecordsStubSettings.Builder answerRecordsSettingsBuilder =
 *     AnswerRecordsStubSettings.newBuilder();
 * answerRecordsSettingsBuilder
 *     .getAnswerRecordSettings()
 *     .setRetrySettings(
 *         answerRecordsSettingsBuilder
 *             .getAnswerRecordSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AnswerRecordsStubSettings answerRecordsSettings = answerRecordsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AnswerRecordsStubSettings extends StubSettings<AnswerRecordsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final UnaryCallSettings<GetAnswerRecordRequest, AnswerRecord> getAnswerRecordSettings;
  private final PagedCallSettings<
          ListAnswerRecordsRequest, ListAnswerRecordsResponse, ListAnswerRecordsPagedResponse>
      listAnswerRecordsSettings;
  private final UnaryCallSettings<UpdateAnswerRecordRequest, AnswerRecord>
      updateAnswerRecordSettings;

  private static final PagedListDescriptor<
          ListAnswerRecordsRequest, ListAnswerRecordsResponse, AnswerRecord>
      LIST_ANSWER_RECORDS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAnswerRecordsRequest, ListAnswerRecordsResponse, AnswerRecord>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnswerRecordsRequest injectToken(
                ListAnswerRecordsRequest payload, String token) {
              return ListAnswerRecordsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAnswerRecordsRequest injectPageSize(
                ListAnswerRecordsRequest payload, int pageSize) {
              return ListAnswerRecordsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAnswerRecordsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnswerRecordsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AnswerRecord> extractResources(ListAnswerRecordsResponse payload) {
              return payload.getAnswerRecordsList() == null
                  ? ImmutableList.<AnswerRecord>of()
                  : payload.getAnswerRecordsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAnswerRecordsRequest, ListAnswerRecordsResponse, ListAnswerRecordsPagedResponse>
      LIST_ANSWER_RECORDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnswerRecordsRequest,
              ListAnswerRecordsResponse,
              ListAnswerRecordsPagedResponse>() {
            @Override
            public ApiFuture<ListAnswerRecordsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnswerRecordsRequest, ListAnswerRecordsResponse> callable,
                ListAnswerRecordsRequest request,
                ApiCallContext context,
                ApiFuture<ListAnswerRecordsResponse> futureResponse) {
              PageContext<ListAnswerRecordsRequest, ListAnswerRecordsResponse, AnswerRecord>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ANSWER_RECORDS_PAGE_STR_DESC, request, context);
              return ListAnswerRecordsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /**
   * Returns the object with the settings used for calls to getAnswerRecord.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetAnswerRecordRequest, AnswerRecord> getAnswerRecordSettings() {
    return getAnswerRecordSettings;
  }

  /** Returns the object with the settings used for calls to listAnswerRecords. */
  public PagedCallSettings<
          ListAnswerRecordsRequest, ListAnswerRecordsResponse, ListAnswerRecordsPagedResponse>
      listAnswerRecordsSettings() {
    return listAnswerRecordsSettings;
  }

  /** Returns the object with the settings used for calls to updateAnswerRecord. */
  public UnaryCallSettings<UpdateAnswerRecordRequest, AnswerRecord> updateAnswerRecordSettings() {
    return updateAnswerRecordSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AnswerRecordsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAnswerRecordsStub.create(this);
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
    return "dialogflow.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AnswerRecordsStubSettings.class))
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

  protected AnswerRecordsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getAnswerRecordSettings = settingsBuilder.getAnswerRecordSettings().build();
    listAnswerRecordsSettings = settingsBuilder.listAnswerRecordsSettings().build();
    updateAnswerRecordSettings = settingsBuilder.updateAnswerRecordSettings().build();
  }

  /** Builder for AnswerRecordsStubSettings. */
  public static class Builder extends StubSettings.Builder<AnswerRecordsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetAnswerRecordRequest, AnswerRecord>
        getAnswerRecordSettings;
    private final PagedCallSettings.Builder<
            ListAnswerRecordsRequest, ListAnswerRecordsResponse, ListAnswerRecordsPagedResponse>
        listAnswerRecordsSettings;
    private final UnaryCallSettings.Builder<UpdateAnswerRecordRequest, AnswerRecord>
        updateAnswerRecordSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getAnswerRecordSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAnswerRecordsSettings = PagedCallSettings.newBuilder(LIST_ANSWER_RECORDS_PAGE_STR_FACT);
      updateAnswerRecordSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAnswerRecordSettings, listAnswerRecordsSettings, updateAnswerRecordSettings);
      initDefaults(this);
    }

    protected Builder(AnswerRecordsStubSettings settings) {
      super(settings);

      getAnswerRecordSettings = settings.getAnswerRecordSettings.toBuilder();
      listAnswerRecordsSettings = settings.listAnswerRecordsSettings.toBuilder();
      updateAnswerRecordSettings = settings.updateAnswerRecordSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAnswerRecordSettings, listAnswerRecordsSettings, updateAnswerRecordSettings);
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
          .getAnswerRecordSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAnswerRecordsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAnswerRecordSettings()
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
     * Returns the builder for the settings used for calls to getAnswerRecord.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetAnswerRecordRequest, AnswerRecord>
        getAnswerRecordSettings() {
      return getAnswerRecordSettings;
    }

    /** Returns the builder for the settings used for calls to listAnswerRecords. */
    public PagedCallSettings.Builder<
            ListAnswerRecordsRequest, ListAnswerRecordsResponse, ListAnswerRecordsPagedResponse>
        listAnswerRecordsSettings() {
      return listAnswerRecordsSettings;
    }

    /** Returns the builder for the settings used for calls to updateAnswerRecord. */
    public UnaryCallSettings.Builder<UpdateAnswerRecordRequest, AnswerRecord>
        updateAnswerRecordSettings() {
      return updateAnswerRecordSettings;
    }

    @Override
    public AnswerRecordsStubSettings build() throws IOException {
      return new AnswerRecordsStubSettings(this);
    }
  }
}
