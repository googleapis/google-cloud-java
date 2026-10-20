/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.LineItemServiceClient.ListLineItemsPagedResponse;

import com.google.ads.admanager.v1.stub.LineItemServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LineItemServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getLineItem:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LineItemServiceSettings.Builder lineItemServiceSettingsBuilder =
 *     LineItemServiceSettings.newBuilder();
 * lineItemServiceSettingsBuilder
 *     .getLineItemSettings()
 *     .setRetrySettings(
 *         lineItemServiceSettingsBuilder
 *             .getLineItemSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * LineItemServiceSettings lineItemServiceSettings = lineItemServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class LineItemServiceSettings extends ClientSettings<LineItemServiceSettings> {

  /** Returns the object with the settings used for calls to getLineItem. */
  public UnaryCallSettings<GetLineItemRequest, LineItem> getLineItemSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).getLineItemSettings();
  }

  /** Returns the object with the settings used for calls to listLineItems. */
  public PagedCallSettings<ListLineItemsRequest, ListLineItemsResponse, ListLineItemsPagedResponse>
      listLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).listLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to createLineItem. */
  public UnaryCallSettings<CreateLineItemRequest, LineItem> createLineItemSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).createLineItemSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateLineItems. */
  public UnaryCallSettings<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
      batchCreateLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).batchCreateLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to updateLineItem. */
  public UnaryCallSettings<UpdateLineItemRequest, LineItem> updateLineItemSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).updateLineItemSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateLineItems. */
  public UnaryCallSettings<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
      batchUpdateLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).batchUpdateLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to batchActivateLineItems. */
  public UnaryCallSettings<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
      batchActivateLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).batchActivateLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to batchPauseLineItems. */
  public UnaryCallSettings<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
      batchPauseLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).batchPauseLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to batchResumeLineItems. */
  public UnaryCallSettings<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
      batchResumeLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).batchResumeLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to batchResumeAndOverbookLineItems. */
  public UnaryCallSettings<
          BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
      batchResumeAndOverbookLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings())
        .batchResumeAndOverbookLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteLineItems. */
  public UnaryCallSettings<BatchDeleteLineItemsRequest, Empty> batchDeleteLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).batchDeleteLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to batchReserveLineItems. */
  public UnaryCallSettings<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
      batchReserveLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).batchReserveLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to batchReserveAndOverbookLineItems. */
  public UnaryCallSettings<
          BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
      batchReserveAndOverbookLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings())
        .batchReserveAndOverbookLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to batchReleaseLineItems. */
  public UnaryCallSettings<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
      batchReleaseLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).batchReleaseLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to batchArchiveLineItems. */
  public UnaryCallSettings<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
      batchArchiveLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).batchArchiveLineItemsSettings();
  }

  /** Returns the object with the settings used for calls to batchUnarchiveLineItems. */
  public UnaryCallSettings<BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
      batchUnarchiveLineItemsSettings() {
    return ((LineItemServiceStubSettings) getStubSettings()).batchUnarchiveLineItemsSettings();
  }

  public static final LineItemServiceSettings create(LineItemServiceStubSettings stub)
      throws IOException {
    return new LineItemServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LineItemServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LineItemServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LineItemServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LineItemServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LineItemServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LineItemServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LineItemServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected LineItemServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LineItemServiceSettings. */
  public static class Builder extends ClientSettings.Builder<LineItemServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(LineItemServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(LineItemServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LineItemServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LineItemServiceStubSettings.newBuilder());
    }

    public LineItemServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((LineItemServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to getLineItem. */
    public UnaryCallSettings.Builder<GetLineItemRequest, LineItem> getLineItemSettings() {
      return getStubSettingsBuilder().getLineItemSettings();
    }

    /** Returns the builder for the settings used for calls to listLineItems. */
    public PagedCallSettings.Builder<
            ListLineItemsRequest, ListLineItemsResponse, ListLineItemsPagedResponse>
        listLineItemsSettings() {
      return getStubSettingsBuilder().listLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to createLineItem. */
    public UnaryCallSettings.Builder<CreateLineItemRequest, LineItem> createLineItemSettings() {
      return getStubSettingsBuilder().createLineItemSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateLineItems. */
    public UnaryCallSettings.Builder<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
        batchCreateLineItemsSettings() {
      return getStubSettingsBuilder().batchCreateLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to updateLineItem. */
    public UnaryCallSettings.Builder<UpdateLineItemRequest, LineItem> updateLineItemSettings() {
      return getStubSettingsBuilder().updateLineItemSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateLineItems. */
    public UnaryCallSettings.Builder<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
        batchUpdateLineItemsSettings() {
      return getStubSettingsBuilder().batchUpdateLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to batchActivateLineItems. */
    public UnaryCallSettings.Builder<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
        batchActivateLineItemsSettings() {
      return getStubSettingsBuilder().batchActivateLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to batchPauseLineItems. */
    public UnaryCallSettings.Builder<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
        batchPauseLineItemsSettings() {
      return getStubSettingsBuilder().batchPauseLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to batchResumeLineItems. */
    public UnaryCallSettings.Builder<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
        batchResumeLineItemsSettings() {
      return getStubSettingsBuilder().batchResumeLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to batchResumeAndOverbookLineItems. */
    public UnaryCallSettings.Builder<
            BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
        batchResumeAndOverbookLineItemsSettings() {
      return getStubSettingsBuilder().batchResumeAndOverbookLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteLineItems. */
    public UnaryCallSettings.Builder<BatchDeleteLineItemsRequest, Empty>
        batchDeleteLineItemsSettings() {
      return getStubSettingsBuilder().batchDeleteLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to batchReserveLineItems. */
    public UnaryCallSettings.Builder<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
        batchReserveLineItemsSettings() {
      return getStubSettingsBuilder().batchReserveLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to batchReserveAndOverbookLineItems. */
    public UnaryCallSettings.Builder<
            BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
        batchReserveAndOverbookLineItemsSettings() {
      return getStubSettingsBuilder().batchReserveAndOverbookLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to batchReleaseLineItems. */
    public UnaryCallSettings.Builder<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
        batchReleaseLineItemsSettings() {
      return getStubSettingsBuilder().batchReleaseLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to batchArchiveLineItems. */
    public UnaryCallSettings.Builder<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
        batchArchiveLineItemsSettings() {
      return getStubSettingsBuilder().batchArchiveLineItemsSettings();
    }

    /** Returns the builder for the settings used for calls to batchUnarchiveLineItems. */
    public UnaryCallSettings.Builder<
            BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
        batchUnarchiveLineItemsSettings() {
      return getStubSettingsBuilder().batchUnarchiveLineItemsSettings();
    }

    @Override
    public LineItemServiceSettings build() throws IOException {
      return new LineItemServiceSettings(this);
    }
  }
}
