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

package com.google.cloud.logging.v2;

import static com.google.cloud.logging.v2.ConfigClient.ListBucketsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListExclusionsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListLinksPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListSinksPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListViewsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.logging.v2.stub.ConfigServiceV2StubSettings;
import com.google.logging.v2.BucketMetadata;
import com.google.logging.v2.CmekSettings;
import com.google.logging.v2.CopyLogEntriesMetadata;
import com.google.logging.v2.CopyLogEntriesRequest;
import com.google.logging.v2.CopyLogEntriesResponse;
import com.google.logging.v2.CreateBucketRequest;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateLinkRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.CreateViewRequest;
import com.google.logging.v2.DeleteBucketRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteLinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.DeleteViewRequest;
import com.google.logging.v2.GetBucketRequest;
import com.google.logging.v2.GetCmekSettingsRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetLinkRequest;
import com.google.logging.v2.GetSettingsRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.GetViewRequest;
import com.google.logging.v2.Link;
import com.google.logging.v2.LinkMetadata;
import com.google.logging.v2.ListBucketsRequest;
import com.google.logging.v2.ListBucketsResponse;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListLinksRequest;
import com.google.logging.v2.ListLinksResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.ListViewsRequest;
import com.google.logging.v2.ListViewsResponse;
import com.google.logging.v2.LogBucket;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.LogView;
import com.google.logging.v2.Settings;
import com.google.logging.v2.UndeleteBucketRequest;
import com.google.logging.v2.UpdateBucketRequest;
import com.google.logging.v2.UpdateCmekSettingsRequest;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSettingsRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.UpdateViewRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConfigClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (logging.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getBucket to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigSettings.Builder configSettingsBuilder = ConfigSettings.newBuilder();
 * configSettingsBuilder
 *     .getBucketSettings()
 *     .setRetrySettings(
 *         configSettingsBuilder
 *             .getBucketSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConfigSettings configSettings = configSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConfigSettings extends ClientSettings<ConfigSettings> {

  /** Returns the object with the settings used for calls to listBuckets. */
  public PagedCallSettings<ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
      listBucketsSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).listBucketsSettings();
  }

  /** Returns the object with the settings used for calls to getBucket. */
  public UnaryCallSettings<GetBucketRequest, LogBucket> getBucketSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).getBucketSettings();
  }

  /** Returns the object with the settings used for calls to createBucketAsync. */
  public UnaryCallSettings<CreateBucketRequest, Operation> createBucketAsyncSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).createBucketAsyncSettings();
  }

  /** Returns the object with the settings used for calls to createBucketAsync. */
  public OperationCallSettings<CreateBucketRequest, LogBucket, BucketMetadata>
      createBucketAsyncOperationSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).createBucketAsyncOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateBucketAsync. */
  public UnaryCallSettings<UpdateBucketRequest, Operation> updateBucketAsyncSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).updateBucketAsyncSettings();
  }

  /** Returns the object with the settings used for calls to updateBucketAsync. */
  public OperationCallSettings<UpdateBucketRequest, LogBucket, BucketMetadata>
      updateBucketAsyncOperationSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).updateBucketAsyncOperationSettings();
  }

  /** Returns the object with the settings used for calls to createBucket. */
  public UnaryCallSettings<CreateBucketRequest, LogBucket> createBucketSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).createBucketSettings();
  }

  /** Returns the object with the settings used for calls to updateBucket. */
  public UnaryCallSettings<UpdateBucketRequest, LogBucket> updateBucketSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).updateBucketSettings();
  }

  /** Returns the object with the settings used for calls to deleteBucket. */
  public UnaryCallSettings<DeleteBucketRequest, Empty> deleteBucketSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).deleteBucketSettings();
  }

  /** Returns the object with the settings used for calls to undeleteBucket. */
  public UnaryCallSettings<UndeleteBucketRequest, Empty> undeleteBucketSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).undeleteBucketSettings();
  }

  /** Returns the object with the settings used for calls to listViews. */
  public PagedCallSettings<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      listViewsSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).listViewsSettings();
  }

  /** Returns the object with the settings used for calls to getView. */
  public UnaryCallSettings<GetViewRequest, LogView> getViewSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).getViewSettings();
  }

  /** Returns the object with the settings used for calls to createView. */
  public UnaryCallSettings<CreateViewRequest, LogView> createViewSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).createViewSettings();
  }

  /** Returns the object with the settings used for calls to updateView. */
  public UnaryCallSettings<UpdateViewRequest, LogView> updateViewSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).updateViewSettings();
  }

  /** Returns the object with the settings used for calls to deleteView. */
  public UnaryCallSettings<DeleteViewRequest, Empty> deleteViewSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).deleteViewSettings();
  }

  /** Returns the object with the settings used for calls to listSinks. */
  public PagedCallSettings<ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
      listSinksSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).listSinksSettings();
  }

  /** Returns the object with the settings used for calls to getSink. */
  public UnaryCallSettings<GetSinkRequest, LogSink> getSinkSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).getSinkSettings();
  }

  /** Returns the object with the settings used for calls to createSink. */
  public UnaryCallSettings<CreateSinkRequest, LogSink> createSinkSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).createSinkSettings();
  }

  /** Returns the object with the settings used for calls to updateSink. */
  public UnaryCallSettings<UpdateSinkRequest, LogSink> updateSinkSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).updateSinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteSink. */
  public UnaryCallSettings<DeleteSinkRequest, Empty> deleteSinkSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).deleteSinkSettings();
  }

  /** Returns the object with the settings used for calls to createLink. */
  public UnaryCallSettings<CreateLinkRequest, Operation> createLinkSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).createLinkSettings();
  }

  /** Returns the object with the settings used for calls to createLink. */
  public OperationCallSettings<CreateLinkRequest, Link, LinkMetadata>
      createLinkOperationSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).createLinkOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteLink. */
  public UnaryCallSettings<DeleteLinkRequest, Operation> deleteLinkSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).deleteLinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteLink. */
  public OperationCallSettings<DeleteLinkRequest, Empty, LinkMetadata>
      deleteLinkOperationSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).deleteLinkOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLinks. */
  public PagedCallSettings<ListLinksRequest, ListLinksResponse, ListLinksPagedResponse>
      listLinksSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).listLinksSettings();
  }

  /** Returns the object with the settings used for calls to getLink. */
  public UnaryCallSettings<GetLinkRequest, Link> getLinkSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).getLinkSettings();
  }

  /** Returns the object with the settings used for calls to listExclusions. */
  public PagedCallSettings<
          ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
      listExclusionsSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).listExclusionsSettings();
  }

  /** Returns the object with the settings used for calls to getExclusion. */
  public UnaryCallSettings<GetExclusionRequest, LogExclusion> getExclusionSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).getExclusionSettings();
  }

  /** Returns the object with the settings used for calls to createExclusion. */
  public UnaryCallSettings<CreateExclusionRequest, LogExclusion> createExclusionSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).createExclusionSettings();
  }

  /** Returns the object with the settings used for calls to updateExclusion. */
  public UnaryCallSettings<UpdateExclusionRequest, LogExclusion> updateExclusionSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).updateExclusionSettings();
  }

  /** Returns the object with the settings used for calls to deleteExclusion. */
  public UnaryCallSettings<DeleteExclusionRequest, Empty> deleteExclusionSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).deleteExclusionSettings();
  }

  /** Returns the object with the settings used for calls to getCmekSettings. */
  public UnaryCallSettings<GetCmekSettingsRequest, CmekSettings> getCmekSettingsSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).getCmekSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateCmekSettings. */
  public UnaryCallSettings<UpdateCmekSettingsRequest, CmekSettings> updateCmekSettingsSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).updateCmekSettingsSettings();
  }

  /** Returns the object with the settings used for calls to getSettings. */
  public UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).getSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public UnaryCallSettings<UpdateSettingsRequest, Settings> updateSettingsSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).updateSettingsSettings();
  }

  /** Returns the object with the settings used for calls to copyLogEntries. */
  public UnaryCallSettings<CopyLogEntriesRequest, Operation> copyLogEntriesSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).copyLogEntriesSettings();
  }

  /** Returns the object with the settings used for calls to copyLogEntries. */
  public OperationCallSettings<
          CopyLogEntriesRequest, CopyLogEntriesResponse, CopyLogEntriesMetadata>
      copyLogEntriesOperationSettings() {
    return ((ConfigServiceV2StubSettings) getStubSettings()).copyLogEntriesOperationSettings();
  }

  public static final ConfigSettings create(ConfigServiceV2StubSettings stub) throws IOException {
    return new ConfigSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ConfigServiceV2StubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ConfigServiceV2StubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ConfigServiceV2StubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ConfigServiceV2StubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConfigServiceV2StubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConfigServiceV2StubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConfigServiceV2StubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ConfigSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ConfigSettings. */
  public static class Builder extends ClientSettings.Builder<ConfigSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ConfigServiceV2StubSettings.newBuilder(clientContext));
    }

    protected Builder(ConfigSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ConfigServiceV2StubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ConfigServiceV2StubSettings.newBuilder());
    }

    public ConfigServiceV2StubSettings.Builder getStubSettingsBuilder() {
      return ((ConfigServiceV2StubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listBuckets. */
    public PagedCallSettings.Builder<
            ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
        listBucketsSettings() {
      return getStubSettingsBuilder().listBucketsSettings();
    }

    /** Returns the builder for the settings used for calls to getBucket. */
    public UnaryCallSettings.Builder<GetBucketRequest, LogBucket> getBucketSettings() {
      return getStubSettingsBuilder().getBucketSettings();
    }

    /** Returns the builder for the settings used for calls to createBucketAsync. */
    public UnaryCallSettings.Builder<CreateBucketRequest, Operation> createBucketAsyncSettings() {
      return getStubSettingsBuilder().createBucketAsyncSettings();
    }

    /** Returns the builder for the settings used for calls to createBucketAsync. */
    public OperationCallSettings.Builder<CreateBucketRequest, LogBucket, BucketMetadata>
        createBucketAsyncOperationSettings() {
      return getStubSettingsBuilder().createBucketAsyncOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateBucketAsync. */
    public UnaryCallSettings.Builder<UpdateBucketRequest, Operation> updateBucketAsyncSettings() {
      return getStubSettingsBuilder().updateBucketAsyncSettings();
    }

    /** Returns the builder for the settings used for calls to updateBucketAsync. */
    public OperationCallSettings.Builder<UpdateBucketRequest, LogBucket, BucketMetadata>
        updateBucketAsyncOperationSettings() {
      return getStubSettingsBuilder().updateBucketAsyncOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createBucket. */
    public UnaryCallSettings.Builder<CreateBucketRequest, LogBucket> createBucketSettings() {
      return getStubSettingsBuilder().createBucketSettings();
    }

    /** Returns the builder for the settings used for calls to updateBucket. */
    public UnaryCallSettings.Builder<UpdateBucketRequest, LogBucket> updateBucketSettings() {
      return getStubSettingsBuilder().updateBucketSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBucket. */
    public UnaryCallSettings.Builder<DeleteBucketRequest, Empty> deleteBucketSettings() {
      return getStubSettingsBuilder().deleteBucketSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteBucket. */
    public UnaryCallSettings.Builder<UndeleteBucketRequest, Empty> undeleteBucketSettings() {
      return getStubSettingsBuilder().undeleteBucketSettings();
    }

    /** Returns the builder for the settings used for calls to listViews. */
    public PagedCallSettings.Builder<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
        listViewsSettings() {
      return getStubSettingsBuilder().listViewsSettings();
    }

    /** Returns the builder for the settings used for calls to getView. */
    public UnaryCallSettings.Builder<GetViewRequest, LogView> getViewSettings() {
      return getStubSettingsBuilder().getViewSettings();
    }

    /** Returns the builder for the settings used for calls to createView. */
    public UnaryCallSettings.Builder<CreateViewRequest, LogView> createViewSettings() {
      return getStubSettingsBuilder().createViewSettings();
    }

    /** Returns the builder for the settings used for calls to updateView. */
    public UnaryCallSettings.Builder<UpdateViewRequest, LogView> updateViewSettings() {
      return getStubSettingsBuilder().updateViewSettings();
    }

    /** Returns the builder for the settings used for calls to deleteView. */
    public UnaryCallSettings.Builder<DeleteViewRequest, Empty> deleteViewSettings() {
      return getStubSettingsBuilder().deleteViewSettings();
    }

    /** Returns the builder for the settings used for calls to listSinks. */
    public PagedCallSettings.Builder<ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
        listSinksSettings() {
      return getStubSettingsBuilder().listSinksSettings();
    }

    /** Returns the builder for the settings used for calls to getSink. */
    public UnaryCallSettings.Builder<GetSinkRequest, LogSink> getSinkSettings() {
      return getStubSettingsBuilder().getSinkSettings();
    }

    /** Returns the builder for the settings used for calls to createSink. */
    public UnaryCallSettings.Builder<CreateSinkRequest, LogSink> createSinkSettings() {
      return getStubSettingsBuilder().createSinkSettings();
    }

    /** Returns the builder for the settings used for calls to updateSink. */
    public UnaryCallSettings.Builder<UpdateSinkRequest, LogSink> updateSinkSettings() {
      return getStubSettingsBuilder().updateSinkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSink. */
    public UnaryCallSettings.Builder<DeleteSinkRequest, Empty> deleteSinkSettings() {
      return getStubSettingsBuilder().deleteSinkSettings();
    }

    /** Returns the builder for the settings used for calls to createLink. */
    public UnaryCallSettings.Builder<CreateLinkRequest, Operation> createLinkSettings() {
      return getStubSettingsBuilder().createLinkSettings();
    }

    /** Returns the builder for the settings used for calls to createLink. */
    public OperationCallSettings.Builder<CreateLinkRequest, Link, LinkMetadata>
        createLinkOperationSettings() {
      return getStubSettingsBuilder().createLinkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLink. */
    public UnaryCallSettings.Builder<DeleteLinkRequest, Operation> deleteLinkSettings() {
      return getStubSettingsBuilder().deleteLinkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLink. */
    public OperationCallSettings.Builder<DeleteLinkRequest, Empty, LinkMetadata>
        deleteLinkOperationSettings() {
      return getStubSettingsBuilder().deleteLinkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLinks. */
    public PagedCallSettings.Builder<ListLinksRequest, ListLinksResponse, ListLinksPagedResponse>
        listLinksSettings() {
      return getStubSettingsBuilder().listLinksSettings();
    }

    /** Returns the builder for the settings used for calls to getLink. */
    public UnaryCallSettings.Builder<GetLinkRequest, Link> getLinkSettings() {
      return getStubSettingsBuilder().getLinkSettings();
    }

    /** Returns the builder for the settings used for calls to listExclusions. */
    public PagedCallSettings.Builder<
            ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
        listExclusionsSettings() {
      return getStubSettingsBuilder().listExclusionsSettings();
    }

    /** Returns the builder for the settings used for calls to getExclusion. */
    public UnaryCallSettings.Builder<GetExclusionRequest, LogExclusion> getExclusionSettings() {
      return getStubSettingsBuilder().getExclusionSettings();
    }

    /** Returns the builder for the settings used for calls to createExclusion. */
    public UnaryCallSettings.Builder<CreateExclusionRequest, LogExclusion>
        createExclusionSettings() {
      return getStubSettingsBuilder().createExclusionSettings();
    }

    /** Returns the builder for the settings used for calls to updateExclusion. */
    public UnaryCallSettings.Builder<UpdateExclusionRequest, LogExclusion>
        updateExclusionSettings() {
      return getStubSettingsBuilder().updateExclusionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExclusion. */
    public UnaryCallSettings.Builder<DeleteExclusionRequest, Empty> deleteExclusionSettings() {
      return getStubSettingsBuilder().deleteExclusionSettings();
    }

    /** Returns the builder for the settings used for calls to getCmekSettings. */
    public UnaryCallSettings.Builder<GetCmekSettingsRequest, CmekSettings>
        getCmekSettingsSettings() {
      return getStubSettingsBuilder().getCmekSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateCmekSettings. */
    public UnaryCallSettings.Builder<UpdateCmekSettingsRequest, CmekSettings>
        updateCmekSettingsSettings() {
      return getStubSettingsBuilder().updateCmekSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to getSettings. */
    public UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings() {
      return getStubSettingsBuilder().getSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public UnaryCallSettings.Builder<UpdateSettingsRequest, Settings> updateSettingsSettings() {
      return getStubSettingsBuilder().updateSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to copyLogEntries. */
    public UnaryCallSettings.Builder<CopyLogEntriesRequest, Operation> copyLogEntriesSettings() {
      return getStubSettingsBuilder().copyLogEntriesSettings();
    }

    /** Returns the builder for the settings used for calls to copyLogEntries. */
    public OperationCallSettings.Builder<
            CopyLogEntriesRequest, CopyLogEntriesResponse, CopyLogEntriesMetadata>
        copyLogEntriesOperationSettings() {
      return getStubSettingsBuilder().copyLogEntriesOperationSettings();
    }

    @Override
    public ConfigSettings build() throws IOException {
      return new ConfigSettings(this);
    }
  }
}
