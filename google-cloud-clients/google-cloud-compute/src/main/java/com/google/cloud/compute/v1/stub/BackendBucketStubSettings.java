/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.BackendBucketClient.ListBackendBucketsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
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
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendBucketHttpRequest;
import com.google.cloud.compute.v1.BackendBucket;
import com.google.cloud.compute.v1.BackendBucketList;
import com.google.cloud.compute.v1.DeleteBackendBucketHttpRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendBucketHttpRequest;
import com.google.cloud.compute.v1.GetBackendBucketHttpRequest;
import com.google.cloud.compute.v1.InsertBackendBucketHttpRequest;
import com.google.cloud.compute.v1.ListBackendBucketsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchBackendBucketHttpRequest;
import com.google.cloud.compute.v1.UpdateBackendBucketHttpRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link BackendBucketStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of addSignedUrlKeyBackendBucket to 30 seconds:
 *
 * <pre>
 * <code>
 * BackendBucketStubSettings.Builder backendBucketSettingsBuilder =
 *     BackendBucketStubSettings.newBuilder();
 * backendBucketSettingsBuilder.addSignedUrlKeyBackendBucketSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * BackendBucketStubSettings backendBucketSettings = backendBucketSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class BackendBucketStubSettings extends StubSettings<BackendBucketStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .add("https://www.googleapis.com/auth/devstorage.read_only")
          .add("https://www.googleapis.com/auth/devstorage.read_write")
          .build();

  private final UnaryCallSettings<AddSignedUrlKeyBackendBucketHttpRequest, Operation>
      addSignedUrlKeyBackendBucketSettings;
  private final UnaryCallSettings<DeleteBackendBucketHttpRequest, Operation>
      deleteBackendBucketSettings;
  private final UnaryCallSettings<DeleteSignedUrlKeyBackendBucketHttpRequest, Operation>
      deleteSignedUrlKeyBackendBucketSettings;
  private final UnaryCallSettings<GetBackendBucketHttpRequest, BackendBucket>
      getBackendBucketSettings;
  private final UnaryCallSettings<InsertBackendBucketHttpRequest, Operation>
      insertBackendBucketSettings;
  private final PagedCallSettings<
          ListBackendBucketsHttpRequest, BackendBucketList, ListBackendBucketsPagedResponse>
      listBackendBucketsSettings;
  private final UnaryCallSettings<PatchBackendBucketHttpRequest, Operation>
      patchBackendBucketSettings;
  private final UnaryCallSettings<UpdateBackendBucketHttpRequest, Operation>
      updateBackendBucketSettings;

  /** Returns the object with the settings used for calls to addSignedUrlKeyBackendBucket. */
  public UnaryCallSettings<AddSignedUrlKeyBackendBucketHttpRequest, Operation>
      addSignedUrlKeyBackendBucketSettings() {
    return addSignedUrlKeyBackendBucketSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackendBucket. */
  public UnaryCallSettings<DeleteBackendBucketHttpRequest, Operation>
      deleteBackendBucketSettings() {
    return deleteBackendBucketSettings;
  }

  /** Returns the object with the settings used for calls to deleteSignedUrlKeyBackendBucket. */
  public UnaryCallSettings<DeleteSignedUrlKeyBackendBucketHttpRequest, Operation>
      deleteSignedUrlKeyBackendBucketSettings() {
    return deleteSignedUrlKeyBackendBucketSettings;
  }

  /** Returns the object with the settings used for calls to getBackendBucket. */
  public UnaryCallSettings<GetBackendBucketHttpRequest, BackendBucket> getBackendBucketSettings() {
    return getBackendBucketSettings;
  }

  /** Returns the object with the settings used for calls to insertBackendBucket. */
  public UnaryCallSettings<InsertBackendBucketHttpRequest, Operation>
      insertBackendBucketSettings() {
    return insertBackendBucketSettings;
  }

  /** Returns the object with the settings used for calls to listBackendBuckets. */
  public PagedCallSettings<
          ListBackendBucketsHttpRequest, BackendBucketList, ListBackendBucketsPagedResponse>
      listBackendBucketsSettings() {
    return listBackendBucketsSettings;
  }

  /** Returns the object with the settings used for calls to patchBackendBucket. */
  public UnaryCallSettings<PatchBackendBucketHttpRequest, Operation> patchBackendBucketSettings() {
    return patchBackendBucketSettings;
  }

  /** Returns the object with the settings used for calls to updateBackendBucket. */
  public UnaryCallSettings<UpdateBackendBucketHttpRequest, Operation>
      updateBackendBucketSettings() {
    return updateBackendBucketSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BackendBucketStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBackendBucketStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "https://www.googleapis.com/compute/v1/projects/";
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return 443;
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BackendBucketStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected BackendBucketStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addSignedUrlKeyBackendBucketSettings =
        settingsBuilder.addSignedUrlKeyBackendBucketSettings().build();
    deleteBackendBucketSettings = settingsBuilder.deleteBackendBucketSettings().build();
    deleteSignedUrlKeyBackendBucketSettings =
        settingsBuilder.deleteSignedUrlKeyBackendBucketSettings().build();
    getBackendBucketSettings = settingsBuilder.getBackendBucketSettings().build();
    insertBackendBucketSettings = settingsBuilder.insertBackendBucketSettings().build();
    listBackendBucketsSettings = settingsBuilder.listBackendBucketsSettings().build();
    patchBackendBucketSettings = settingsBuilder.patchBackendBucketSettings().build();
    updateBackendBucketSettings = settingsBuilder.updateBackendBucketSettings().build();
  }

  private static final PagedListDescriptor<
          ListBackendBucketsHttpRequest, BackendBucketList, BackendBucket>
      LIST_BACKEND_BUCKETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackendBucketsHttpRequest, BackendBucketList, BackendBucket>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackendBucketsHttpRequest injectToken(
                ListBackendBucketsHttpRequest payload, String token) {
              return ListBackendBucketsHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackendBucketsHttpRequest injectPageSize(
                ListBackendBucketsHttpRequest payload, int pageSize) {
              return ListBackendBucketsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListBackendBucketsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(BackendBucketList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackendBucket> extractResources(BackendBucketList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<BackendBucket>of();
            }
          };

  private static final PagedListResponseFactory<
          ListBackendBucketsHttpRequest, BackendBucketList, ListBackendBucketsPagedResponse>
      LIST_BACKEND_BUCKETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackendBucketsHttpRequest, BackendBucketList, ListBackendBucketsPagedResponse>() {
            @Override
            public ApiFuture<ListBackendBucketsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackendBucketsHttpRequest, BackendBucketList> callable,
                ListBackendBucketsHttpRequest request,
                ApiCallContext context,
                ApiFuture<BackendBucketList> futureResponse) {
              PageContext<ListBackendBucketsHttpRequest, BackendBucketList, BackendBucket>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BACKEND_BUCKETS_PAGE_STR_DESC, request, context);
              return ListBackendBucketsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for BackendBucketStubSettings. */
  public static class Builder extends StubSettings.Builder<BackendBucketStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<AddSignedUrlKeyBackendBucketHttpRequest, Operation>
        addSignedUrlKeyBackendBucketSettings;
    private final UnaryCallSettings.Builder<DeleteBackendBucketHttpRequest, Operation>
        deleteBackendBucketSettings;
    private final UnaryCallSettings.Builder<DeleteSignedUrlKeyBackendBucketHttpRequest, Operation>
        deleteSignedUrlKeyBackendBucketSettings;
    private final UnaryCallSettings.Builder<GetBackendBucketHttpRequest, BackendBucket>
        getBackendBucketSettings;
    private final UnaryCallSettings.Builder<InsertBackendBucketHttpRequest, Operation>
        insertBackendBucketSettings;
    private final PagedCallSettings.Builder<
            ListBackendBucketsHttpRequest, BackendBucketList, ListBackendBucketsPagedResponse>
        listBackendBucketsSettings;
    private final UnaryCallSettings.Builder<PatchBackendBucketHttpRequest, Operation>
        patchBackendBucketSettings;
    private final UnaryCallSettings.Builder<UpdateBackendBucketHttpRequest, Operation>
        updateBackendBucketSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      addSignedUrlKeyBackendBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteBackendBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteSignedUrlKeyBackendBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getBackendBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertBackendBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listBackendBucketsSettings = PagedCallSettings.newBuilder(LIST_BACKEND_BUCKETS_PAGE_STR_FACT);

      patchBackendBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateBackendBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addSignedUrlKeyBackendBucketSettings,
              deleteBackendBucketSettings,
              deleteSignedUrlKeyBackendBucketSettings,
              getBackendBucketSettings,
              insertBackendBucketSettings,
              listBackendBucketsSettings,
              patchBackendBucketSettings,
              updateBackendBucketSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .addSignedUrlKeyBackendBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteBackendBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSignedUrlKeyBackendBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getBackendBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertBackendBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listBackendBucketsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchBackendBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateBackendBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(BackendBucketStubSettings settings) {
      super(settings);

      addSignedUrlKeyBackendBucketSettings =
          settings.addSignedUrlKeyBackendBucketSettings.toBuilder();
      deleteBackendBucketSettings = settings.deleteBackendBucketSettings.toBuilder();
      deleteSignedUrlKeyBackendBucketSettings =
          settings.deleteSignedUrlKeyBackendBucketSettings.toBuilder();
      getBackendBucketSettings = settings.getBackendBucketSettings.toBuilder();
      insertBackendBucketSettings = settings.insertBackendBucketSettings.toBuilder();
      listBackendBucketsSettings = settings.listBackendBucketsSettings.toBuilder();
      patchBackendBucketSettings = settings.patchBackendBucketSettings.toBuilder();
      updateBackendBucketSettings = settings.updateBackendBucketSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addSignedUrlKeyBackendBucketSettings,
              deleteBackendBucketSettings,
              deleteSignedUrlKeyBackendBucketSettings,
              getBackendBucketSettings,
              insertBackendBucketSettings,
              listBackendBucketsSettings,
              patchBackendBucketSettings,
              updateBackendBucketSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    /** Returns the builder for the settings used for calls to addSignedUrlKeyBackendBucket. */
    public UnaryCallSettings.Builder<AddSignedUrlKeyBackendBucketHttpRequest, Operation>
        addSignedUrlKeyBackendBucketSettings() {
      return addSignedUrlKeyBackendBucketSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackendBucket. */
    public UnaryCallSettings.Builder<DeleteBackendBucketHttpRequest, Operation>
        deleteBackendBucketSettings() {
      return deleteBackendBucketSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSignedUrlKeyBackendBucket. */
    public UnaryCallSettings.Builder<DeleteSignedUrlKeyBackendBucketHttpRequest, Operation>
        deleteSignedUrlKeyBackendBucketSettings() {
      return deleteSignedUrlKeyBackendBucketSettings;
    }

    /** Returns the builder for the settings used for calls to getBackendBucket. */
    public UnaryCallSettings.Builder<GetBackendBucketHttpRequest, BackendBucket>
        getBackendBucketSettings() {
      return getBackendBucketSettings;
    }

    /** Returns the builder for the settings used for calls to insertBackendBucket. */
    public UnaryCallSettings.Builder<InsertBackendBucketHttpRequest, Operation>
        insertBackendBucketSettings() {
      return insertBackendBucketSettings;
    }

    /** Returns the builder for the settings used for calls to listBackendBuckets. */
    public PagedCallSettings.Builder<
            ListBackendBucketsHttpRequest, BackendBucketList, ListBackendBucketsPagedResponse>
        listBackendBucketsSettings() {
      return listBackendBucketsSettings;
    }

    /** Returns the builder for the settings used for calls to patchBackendBucket. */
    public UnaryCallSettings.Builder<PatchBackendBucketHttpRequest, Operation>
        patchBackendBucketSettings() {
      return patchBackendBucketSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackendBucket. */
    public UnaryCallSettings.Builder<UpdateBackendBucketHttpRequest, Operation>
        updateBackendBucketSettings() {
      return updateBackendBucketSettings;
    }

    @Override
    public BackendBucketStubSettings build() throws IOException {
      return new BackendBucketStubSettings(this);
    }
  }
}
