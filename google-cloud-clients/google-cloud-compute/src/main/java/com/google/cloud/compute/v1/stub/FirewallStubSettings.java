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

import static com.google.cloud.compute.v1.FirewallClient.ListFirewallsPagedResponse;

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
import com.google.cloud.compute.v1.DeleteFirewallHttpRequest;
import com.google.cloud.compute.v1.Firewall;
import com.google.cloud.compute.v1.FirewallList;
import com.google.cloud.compute.v1.GetFirewallHttpRequest;
import com.google.cloud.compute.v1.InsertFirewallHttpRequest;
import com.google.cloud.compute.v1.ListFirewallsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchFirewallHttpRequest;
import com.google.cloud.compute.v1.UpdateFirewallHttpRequest;
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
 * Settings class to configure an instance of {@link FirewallStub}.
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
 * example, to set the total timeout of deleteFirewall to 30 seconds:
 *
 * <pre>
 * <code>
 * FirewallStubSettings.Builder firewallSettingsBuilder =
 *     FirewallStubSettings.newBuilder();
 * firewallSettingsBuilder.deleteFirewallSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * FirewallStubSettings firewallSettings = firewallSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class FirewallStubSettings extends StubSettings<FirewallStubSettings> {
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

  private final UnaryCallSettings<DeleteFirewallHttpRequest, Operation> deleteFirewallSettings;
  private final UnaryCallSettings<GetFirewallHttpRequest, Firewall> getFirewallSettings;
  private final UnaryCallSettings<InsertFirewallHttpRequest, Operation> insertFirewallSettings;
  private final PagedCallSettings<
          ListFirewallsHttpRequest, FirewallList, ListFirewallsPagedResponse>
      listFirewallsSettings;
  private final UnaryCallSettings<PatchFirewallHttpRequest, Operation> patchFirewallSettings;
  private final UnaryCallSettings<UpdateFirewallHttpRequest, Operation> updateFirewallSettings;

  /** Returns the object with the settings used for calls to deleteFirewall. */
  public UnaryCallSettings<DeleteFirewallHttpRequest, Operation> deleteFirewallSettings() {
    return deleteFirewallSettings;
  }

  /** Returns the object with the settings used for calls to getFirewall. */
  public UnaryCallSettings<GetFirewallHttpRequest, Firewall> getFirewallSettings() {
    return getFirewallSettings;
  }

  /** Returns the object with the settings used for calls to insertFirewall. */
  public UnaryCallSettings<InsertFirewallHttpRequest, Operation> insertFirewallSettings() {
    return insertFirewallSettings;
  }

  /** Returns the object with the settings used for calls to listFirewalls. */
  public PagedCallSettings<ListFirewallsHttpRequest, FirewallList, ListFirewallsPagedResponse>
      listFirewallsSettings() {
    return listFirewallsSettings;
  }

  /** Returns the object with the settings used for calls to patchFirewall. */
  public UnaryCallSettings<PatchFirewallHttpRequest, Operation> patchFirewallSettings() {
    return patchFirewallSettings;
  }

  /** Returns the object with the settings used for calls to updateFirewall. */
  public UnaryCallSettings<UpdateFirewallHttpRequest, Operation> updateFirewallSettings() {
    return updateFirewallSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FirewallStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonFirewallStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(FirewallStubSettings.class))
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

  protected FirewallStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteFirewallSettings = settingsBuilder.deleteFirewallSettings().build();
    getFirewallSettings = settingsBuilder.getFirewallSettings().build();
    insertFirewallSettings = settingsBuilder.insertFirewallSettings().build();
    listFirewallsSettings = settingsBuilder.listFirewallsSettings().build();
    patchFirewallSettings = settingsBuilder.patchFirewallSettings().build();
    updateFirewallSettings = settingsBuilder.updateFirewallSettings().build();
  }

  private static final PagedListDescriptor<ListFirewallsHttpRequest, FirewallList, Firewall>
      LIST_FIREWALLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFirewallsHttpRequest, FirewallList, Firewall>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFirewallsHttpRequest injectToken(
                ListFirewallsHttpRequest payload, String token) {
              return ListFirewallsHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFirewallsHttpRequest injectPageSize(
                ListFirewallsHttpRequest payload, int pageSize) {
              return ListFirewallsHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFirewallsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(FirewallList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Firewall> extractResources(FirewallList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Firewall>of();
            }
          };

  private static final PagedListResponseFactory<
          ListFirewallsHttpRequest, FirewallList, ListFirewallsPagedResponse>
      LIST_FIREWALLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFirewallsHttpRequest, FirewallList, ListFirewallsPagedResponse>() {
            @Override
            public ApiFuture<ListFirewallsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFirewallsHttpRequest, FirewallList> callable,
                ListFirewallsHttpRequest request,
                ApiCallContext context,
                ApiFuture<FirewallList> futureResponse) {
              PageContext<ListFirewallsHttpRequest, FirewallList, Firewall> pageContext =
                  PageContext.create(callable, LIST_FIREWALLS_PAGE_STR_DESC, request, context);
              return ListFirewallsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for FirewallStubSettings. */
  public static class Builder extends StubSettings.Builder<FirewallStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteFirewallHttpRequest, Operation>
        deleteFirewallSettings;
    private final UnaryCallSettings.Builder<GetFirewallHttpRequest, Firewall> getFirewallSettings;
    private final UnaryCallSettings.Builder<InsertFirewallHttpRequest, Operation>
        insertFirewallSettings;
    private final PagedCallSettings.Builder<
            ListFirewallsHttpRequest, FirewallList, ListFirewallsPagedResponse>
        listFirewallsSettings;
    private final UnaryCallSettings.Builder<PatchFirewallHttpRequest, Operation>
        patchFirewallSettings;
    private final UnaryCallSettings.Builder<UpdateFirewallHttpRequest, Operation>
        updateFirewallSettings;

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

      deleteFirewallSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getFirewallSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertFirewallSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listFirewallsSettings = PagedCallSettings.newBuilder(LIST_FIREWALLS_PAGE_STR_FACT);

      patchFirewallSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateFirewallSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteFirewallSettings,
              getFirewallSettings,
              insertFirewallSettings,
              listFirewallsSettings,
              patchFirewallSettings,
              updateFirewallSettings);

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
          .deleteFirewallSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getFirewallSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertFirewallSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listFirewallsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchFirewallSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateFirewallSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(FirewallStubSettings settings) {
      super(settings);

      deleteFirewallSettings = settings.deleteFirewallSettings.toBuilder();
      getFirewallSettings = settings.getFirewallSettings.toBuilder();
      insertFirewallSettings = settings.insertFirewallSettings.toBuilder();
      listFirewallsSettings = settings.listFirewallsSettings.toBuilder();
      patchFirewallSettings = settings.patchFirewallSettings.toBuilder();
      updateFirewallSettings = settings.updateFirewallSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteFirewallSettings,
              getFirewallSettings,
              insertFirewallSettings,
              listFirewallsSettings,
              patchFirewallSettings,
              updateFirewallSettings);
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

    /** Returns the builder for the settings used for calls to deleteFirewall. */
    public UnaryCallSettings.Builder<DeleteFirewallHttpRequest, Operation>
        deleteFirewallSettings() {
      return deleteFirewallSettings;
    }

    /** Returns the builder for the settings used for calls to getFirewall. */
    public UnaryCallSettings.Builder<GetFirewallHttpRequest, Firewall> getFirewallSettings() {
      return getFirewallSettings;
    }

    /** Returns the builder for the settings used for calls to insertFirewall. */
    public UnaryCallSettings.Builder<InsertFirewallHttpRequest, Operation>
        insertFirewallSettings() {
      return insertFirewallSettings;
    }

    /** Returns the builder for the settings used for calls to listFirewalls. */
    public PagedCallSettings.Builder<
            ListFirewallsHttpRequest, FirewallList, ListFirewallsPagedResponse>
        listFirewallsSettings() {
      return listFirewallsSettings;
    }

    /** Returns the builder for the settings used for calls to patchFirewall. */
    public UnaryCallSettings.Builder<PatchFirewallHttpRequest, Operation> patchFirewallSettings() {
      return patchFirewallSettings;
    }

    /** Returns the builder for the settings used for calls to updateFirewall. */
    public UnaryCallSettings.Builder<UpdateFirewallHttpRequest, Operation>
        updateFirewallSettings() {
      return updateFirewallSettings;
    }

    @Override
    public FirewallStubSettings build() throws IOException {
      return new FirewallStubSettings(this);
    }
  }
}
