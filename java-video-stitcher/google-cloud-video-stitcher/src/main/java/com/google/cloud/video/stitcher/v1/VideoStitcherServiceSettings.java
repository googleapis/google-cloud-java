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

package com.google.cloud.video.stitcher.v1;

import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListCdnKeysPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListLiveAdTagDetailsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListLiveConfigsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListSlatesPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodAdTagDetailsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodConfigsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodStitchDetailsPagedResponse;

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
import com.google.cloud.video.stitcher.v1.stub.VideoStitcherServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VideoStitcherServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (videostitcher.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCdnKey to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VideoStitcherServiceSettings.Builder videoStitcherServiceSettingsBuilder =
 *     VideoStitcherServiceSettings.newBuilder();
 * videoStitcherServiceSettingsBuilder
 *     .getCdnKeySettings()
 *     .setRetrySettings(
 *         videoStitcherServiceSettingsBuilder
 *             .getCdnKeySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VideoStitcherServiceSettings videoStitcherServiceSettings =
 *     videoStitcherServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VideoStitcherServiceSettings extends ClientSettings<VideoStitcherServiceSettings> {

  /** Returns the object with the settings used for calls to createCdnKey. */
  public UnaryCallSettings<CreateCdnKeyRequest, Operation> createCdnKeySettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).createCdnKeySettings();
  }

  /** Returns the object with the settings used for calls to createCdnKey. */
  public OperationCallSettings<CreateCdnKeyRequest, CdnKey, OperationMetadata>
      createCdnKeyOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).createCdnKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listCdnKeys. */
  public PagedCallSettings<ListCdnKeysRequest, ListCdnKeysResponse, ListCdnKeysPagedResponse>
      listCdnKeysSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).listCdnKeysSettings();
  }

  /** Returns the object with the settings used for calls to getCdnKey. */
  public UnaryCallSettings<GetCdnKeyRequest, CdnKey> getCdnKeySettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).getCdnKeySettings();
  }

  /** Returns the object with the settings used for calls to deleteCdnKey. */
  public UnaryCallSettings<DeleteCdnKeyRequest, Operation> deleteCdnKeySettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).deleteCdnKeySettings();
  }

  /** Returns the object with the settings used for calls to deleteCdnKey. */
  public OperationCallSettings<DeleteCdnKeyRequest, Empty, OperationMetadata>
      deleteCdnKeyOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).deleteCdnKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCdnKey. */
  public UnaryCallSettings<UpdateCdnKeyRequest, Operation> updateCdnKeySettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).updateCdnKeySettings();
  }

  /** Returns the object with the settings used for calls to updateCdnKey. */
  public OperationCallSettings<UpdateCdnKeyRequest, CdnKey, OperationMetadata>
      updateCdnKeyOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).updateCdnKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to createVodSession. */
  public UnaryCallSettings<CreateVodSessionRequest, VodSession> createVodSessionSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).createVodSessionSettings();
  }

  /** Returns the object with the settings used for calls to getVodSession. */
  public UnaryCallSettings<GetVodSessionRequest, VodSession> getVodSessionSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).getVodSessionSettings();
  }

  /** Returns the object with the settings used for calls to listVodStitchDetails. */
  public PagedCallSettings<
          ListVodStitchDetailsRequest,
          ListVodStitchDetailsResponse,
          ListVodStitchDetailsPagedResponse>
      listVodStitchDetailsSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).listVodStitchDetailsSettings();
  }

  /** Returns the object with the settings used for calls to getVodStitchDetail. */
  public UnaryCallSettings<GetVodStitchDetailRequest, VodStitchDetail>
      getVodStitchDetailSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).getVodStitchDetailSettings();
  }

  /** Returns the object with the settings used for calls to listVodAdTagDetails. */
  public PagedCallSettings<
          ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, ListVodAdTagDetailsPagedResponse>
      listVodAdTagDetailsSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).listVodAdTagDetailsSettings();
  }

  /** Returns the object with the settings used for calls to getVodAdTagDetail. */
  public UnaryCallSettings<GetVodAdTagDetailRequest, VodAdTagDetail> getVodAdTagDetailSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).getVodAdTagDetailSettings();
  }

  /** Returns the object with the settings used for calls to listLiveAdTagDetails. */
  public PagedCallSettings<
          ListLiveAdTagDetailsRequest,
          ListLiveAdTagDetailsResponse,
          ListLiveAdTagDetailsPagedResponse>
      listLiveAdTagDetailsSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).listLiveAdTagDetailsSettings();
  }

  /** Returns the object with the settings used for calls to getLiveAdTagDetail. */
  public UnaryCallSettings<GetLiveAdTagDetailRequest, LiveAdTagDetail>
      getLiveAdTagDetailSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).getLiveAdTagDetailSettings();
  }

  /** Returns the object with the settings used for calls to createSlate. */
  public UnaryCallSettings<CreateSlateRequest, Operation> createSlateSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).createSlateSettings();
  }

  /** Returns the object with the settings used for calls to createSlate. */
  public OperationCallSettings<CreateSlateRequest, Slate, OperationMetadata>
      createSlateOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).createSlateOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSlates. */
  public PagedCallSettings<ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
      listSlatesSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).listSlatesSettings();
  }

  /** Returns the object with the settings used for calls to getSlate. */
  public UnaryCallSettings<GetSlateRequest, Slate> getSlateSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).getSlateSettings();
  }

  /** Returns the object with the settings used for calls to updateSlate. */
  public UnaryCallSettings<UpdateSlateRequest, Operation> updateSlateSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).updateSlateSettings();
  }

  /** Returns the object with the settings used for calls to updateSlate. */
  public OperationCallSettings<UpdateSlateRequest, Slate, OperationMetadata>
      updateSlateOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).updateSlateOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSlate. */
  public UnaryCallSettings<DeleteSlateRequest, Operation> deleteSlateSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).deleteSlateSettings();
  }

  /** Returns the object with the settings used for calls to deleteSlate. */
  public OperationCallSettings<DeleteSlateRequest, Empty, OperationMetadata>
      deleteSlateOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).deleteSlateOperationSettings();
  }

  /** Returns the object with the settings used for calls to createLiveSession. */
  public UnaryCallSettings<CreateLiveSessionRequest, LiveSession> createLiveSessionSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).createLiveSessionSettings();
  }

  /** Returns the object with the settings used for calls to getLiveSession. */
  public UnaryCallSettings<GetLiveSessionRequest, LiveSession> getLiveSessionSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).getLiveSessionSettings();
  }

  /** Returns the object with the settings used for calls to createLiveConfig. */
  public UnaryCallSettings<CreateLiveConfigRequest, Operation> createLiveConfigSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).createLiveConfigSettings();
  }

  /** Returns the object with the settings used for calls to createLiveConfig. */
  public OperationCallSettings<CreateLiveConfigRequest, LiveConfig, OperationMetadata>
      createLiveConfigOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings())
        .createLiveConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLiveConfigs. */
  public PagedCallSettings<
          ListLiveConfigsRequest, ListLiveConfigsResponse, ListLiveConfigsPagedResponse>
      listLiveConfigsSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).listLiveConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getLiveConfig. */
  public UnaryCallSettings<GetLiveConfigRequest, LiveConfig> getLiveConfigSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).getLiveConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteLiveConfig. */
  public UnaryCallSettings<DeleteLiveConfigRequest, Operation> deleteLiveConfigSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).deleteLiveConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteLiveConfig. */
  public OperationCallSettings<DeleteLiveConfigRequest, Empty, OperationMetadata>
      deleteLiveConfigOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings())
        .deleteLiveConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateLiveConfig. */
  public UnaryCallSettings<UpdateLiveConfigRequest, Operation> updateLiveConfigSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).updateLiveConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateLiveConfig. */
  public OperationCallSettings<UpdateLiveConfigRequest, LiveConfig, OperationMetadata>
      updateLiveConfigOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings())
        .updateLiveConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to createVodConfig. */
  public UnaryCallSettings<CreateVodConfigRequest, Operation> createVodConfigSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).createVodConfigSettings();
  }

  /** Returns the object with the settings used for calls to createVodConfig. */
  public OperationCallSettings<CreateVodConfigRequest, VodConfig, OperationMetadata>
      createVodConfigOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings())
        .createVodConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to listVodConfigs. */
  public PagedCallSettings<
          ListVodConfigsRequest, ListVodConfigsResponse, ListVodConfigsPagedResponse>
      listVodConfigsSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).listVodConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getVodConfig. */
  public UnaryCallSettings<GetVodConfigRequest, VodConfig> getVodConfigSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).getVodConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteVodConfig. */
  public UnaryCallSettings<DeleteVodConfigRequest, Operation> deleteVodConfigSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).deleteVodConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteVodConfig. */
  public OperationCallSettings<DeleteVodConfigRequest, Empty, OperationMetadata>
      deleteVodConfigOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings())
        .deleteVodConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateVodConfig. */
  public UnaryCallSettings<UpdateVodConfigRequest, Operation> updateVodConfigSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).updateVodConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateVodConfig. */
  public OperationCallSettings<UpdateVodConfigRequest, VodConfig, OperationMetadata>
      updateVodConfigOperationSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings())
        .updateVodConfigOperationSettings();
  }

  public static final VideoStitcherServiceSettings create(VideoStitcherServiceStubSettings stub)
      throws IOException {
    return new VideoStitcherServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VideoStitcherServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VideoStitcherServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VideoStitcherServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VideoStitcherServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VideoStitcherServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VideoStitcherServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VideoStitcherServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VideoStitcherServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VideoStitcherServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<VideoStitcherServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VideoStitcherServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(VideoStitcherServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VideoStitcherServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VideoStitcherServiceStubSettings.newBuilder());
    }

    public VideoStitcherServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((VideoStitcherServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createCdnKey. */
    public UnaryCallSettings.Builder<CreateCdnKeyRequest, Operation> createCdnKeySettings() {
      return getStubSettingsBuilder().createCdnKeySettings();
    }

    /** Returns the builder for the settings used for calls to createCdnKey. */
    public OperationCallSettings.Builder<CreateCdnKeyRequest, CdnKey, OperationMetadata>
        createCdnKeyOperationSettings() {
      return getStubSettingsBuilder().createCdnKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listCdnKeys. */
    public PagedCallSettings.Builder<
            ListCdnKeysRequest, ListCdnKeysResponse, ListCdnKeysPagedResponse>
        listCdnKeysSettings() {
      return getStubSettingsBuilder().listCdnKeysSettings();
    }

    /** Returns the builder for the settings used for calls to getCdnKey. */
    public UnaryCallSettings.Builder<GetCdnKeyRequest, CdnKey> getCdnKeySettings() {
      return getStubSettingsBuilder().getCdnKeySettings();
    }

    /** Returns the builder for the settings used for calls to deleteCdnKey. */
    public UnaryCallSettings.Builder<DeleteCdnKeyRequest, Operation> deleteCdnKeySettings() {
      return getStubSettingsBuilder().deleteCdnKeySettings();
    }

    /** Returns the builder for the settings used for calls to deleteCdnKey. */
    public OperationCallSettings.Builder<DeleteCdnKeyRequest, Empty, OperationMetadata>
        deleteCdnKeyOperationSettings() {
      return getStubSettingsBuilder().deleteCdnKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCdnKey. */
    public UnaryCallSettings.Builder<UpdateCdnKeyRequest, Operation> updateCdnKeySettings() {
      return getStubSettingsBuilder().updateCdnKeySettings();
    }

    /** Returns the builder for the settings used for calls to updateCdnKey. */
    public OperationCallSettings.Builder<UpdateCdnKeyRequest, CdnKey, OperationMetadata>
        updateCdnKeyOperationSettings() {
      return getStubSettingsBuilder().updateCdnKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createVodSession. */
    public UnaryCallSettings.Builder<CreateVodSessionRequest, VodSession>
        createVodSessionSettings() {
      return getStubSettingsBuilder().createVodSessionSettings();
    }

    /** Returns the builder for the settings used for calls to getVodSession. */
    public UnaryCallSettings.Builder<GetVodSessionRequest, VodSession> getVodSessionSettings() {
      return getStubSettingsBuilder().getVodSessionSettings();
    }

    /** Returns the builder for the settings used for calls to listVodStitchDetails. */
    public PagedCallSettings.Builder<
            ListVodStitchDetailsRequest,
            ListVodStitchDetailsResponse,
            ListVodStitchDetailsPagedResponse>
        listVodStitchDetailsSettings() {
      return getStubSettingsBuilder().listVodStitchDetailsSettings();
    }

    /** Returns the builder for the settings used for calls to getVodStitchDetail. */
    public UnaryCallSettings.Builder<GetVodStitchDetailRequest, VodStitchDetail>
        getVodStitchDetailSettings() {
      return getStubSettingsBuilder().getVodStitchDetailSettings();
    }

    /** Returns the builder for the settings used for calls to listVodAdTagDetails. */
    public PagedCallSettings.Builder<
            ListVodAdTagDetailsRequest,
            ListVodAdTagDetailsResponse,
            ListVodAdTagDetailsPagedResponse>
        listVodAdTagDetailsSettings() {
      return getStubSettingsBuilder().listVodAdTagDetailsSettings();
    }

    /** Returns the builder for the settings used for calls to getVodAdTagDetail. */
    public UnaryCallSettings.Builder<GetVodAdTagDetailRequest, VodAdTagDetail>
        getVodAdTagDetailSettings() {
      return getStubSettingsBuilder().getVodAdTagDetailSettings();
    }

    /** Returns the builder for the settings used for calls to listLiveAdTagDetails. */
    public PagedCallSettings.Builder<
            ListLiveAdTagDetailsRequest,
            ListLiveAdTagDetailsResponse,
            ListLiveAdTagDetailsPagedResponse>
        listLiveAdTagDetailsSettings() {
      return getStubSettingsBuilder().listLiveAdTagDetailsSettings();
    }

    /** Returns the builder for the settings used for calls to getLiveAdTagDetail. */
    public UnaryCallSettings.Builder<GetLiveAdTagDetailRequest, LiveAdTagDetail>
        getLiveAdTagDetailSettings() {
      return getStubSettingsBuilder().getLiveAdTagDetailSettings();
    }

    /** Returns the builder for the settings used for calls to createSlate. */
    public UnaryCallSettings.Builder<CreateSlateRequest, Operation> createSlateSettings() {
      return getStubSettingsBuilder().createSlateSettings();
    }

    /** Returns the builder for the settings used for calls to createSlate. */
    public OperationCallSettings.Builder<CreateSlateRequest, Slate, OperationMetadata>
        createSlateOperationSettings() {
      return getStubSettingsBuilder().createSlateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSlates. */
    public PagedCallSettings.Builder<ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
        listSlatesSettings() {
      return getStubSettingsBuilder().listSlatesSettings();
    }

    /** Returns the builder for the settings used for calls to getSlate. */
    public UnaryCallSettings.Builder<GetSlateRequest, Slate> getSlateSettings() {
      return getStubSettingsBuilder().getSlateSettings();
    }

    /** Returns the builder for the settings used for calls to updateSlate. */
    public UnaryCallSettings.Builder<UpdateSlateRequest, Operation> updateSlateSettings() {
      return getStubSettingsBuilder().updateSlateSettings();
    }

    /** Returns the builder for the settings used for calls to updateSlate. */
    public OperationCallSettings.Builder<UpdateSlateRequest, Slate, OperationMetadata>
        updateSlateOperationSettings() {
      return getStubSettingsBuilder().updateSlateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSlate. */
    public UnaryCallSettings.Builder<DeleteSlateRequest, Operation> deleteSlateSettings() {
      return getStubSettingsBuilder().deleteSlateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSlate. */
    public OperationCallSettings.Builder<DeleteSlateRequest, Empty, OperationMetadata>
        deleteSlateOperationSettings() {
      return getStubSettingsBuilder().deleteSlateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createLiveSession. */
    public UnaryCallSettings.Builder<CreateLiveSessionRequest, LiveSession>
        createLiveSessionSettings() {
      return getStubSettingsBuilder().createLiveSessionSettings();
    }

    /** Returns the builder for the settings used for calls to getLiveSession. */
    public UnaryCallSettings.Builder<GetLiveSessionRequest, LiveSession> getLiveSessionSettings() {
      return getStubSettingsBuilder().getLiveSessionSettings();
    }

    /** Returns the builder for the settings used for calls to createLiveConfig. */
    public UnaryCallSettings.Builder<CreateLiveConfigRequest, Operation>
        createLiveConfigSettings() {
      return getStubSettingsBuilder().createLiveConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createLiveConfig. */
    public OperationCallSettings.Builder<CreateLiveConfigRequest, LiveConfig, OperationMetadata>
        createLiveConfigOperationSettings() {
      return getStubSettingsBuilder().createLiveConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLiveConfigs. */
    public PagedCallSettings.Builder<
            ListLiveConfigsRequest, ListLiveConfigsResponse, ListLiveConfigsPagedResponse>
        listLiveConfigsSettings() {
      return getStubSettingsBuilder().listLiveConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getLiveConfig. */
    public UnaryCallSettings.Builder<GetLiveConfigRequest, LiveConfig> getLiveConfigSettings() {
      return getStubSettingsBuilder().getLiveConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLiveConfig. */
    public UnaryCallSettings.Builder<DeleteLiveConfigRequest, Operation>
        deleteLiveConfigSettings() {
      return getStubSettingsBuilder().deleteLiveConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLiveConfig. */
    public OperationCallSettings.Builder<DeleteLiveConfigRequest, Empty, OperationMetadata>
        deleteLiveConfigOperationSettings() {
      return getStubSettingsBuilder().deleteLiveConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateLiveConfig. */
    public UnaryCallSettings.Builder<UpdateLiveConfigRequest, Operation>
        updateLiveConfigSettings() {
      return getStubSettingsBuilder().updateLiveConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateLiveConfig. */
    public OperationCallSettings.Builder<UpdateLiveConfigRequest, LiveConfig, OperationMetadata>
        updateLiveConfigOperationSettings() {
      return getStubSettingsBuilder().updateLiveConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createVodConfig. */
    public UnaryCallSettings.Builder<CreateVodConfigRequest, Operation> createVodConfigSettings() {
      return getStubSettingsBuilder().createVodConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createVodConfig. */
    public OperationCallSettings.Builder<CreateVodConfigRequest, VodConfig, OperationMetadata>
        createVodConfigOperationSettings() {
      return getStubSettingsBuilder().createVodConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listVodConfigs. */
    public PagedCallSettings.Builder<
            ListVodConfigsRequest, ListVodConfigsResponse, ListVodConfigsPagedResponse>
        listVodConfigsSettings() {
      return getStubSettingsBuilder().listVodConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getVodConfig. */
    public UnaryCallSettings.Builder<GetVodConfigRequest, VodConfig> getVodConfigSettings() {
      return getStubSettingsBuilder().getVodConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVodConfig. */
    public UnaryCallSettings.Builder<DeleteVodConfigRequest, Operation> deleteVodConfigSettings() {
      return getStubSettingsBuilder().deleteVodConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVodConfig. */
    public OperationCallSettings.Builder<DeleteVodConfigRequest, Empty, OperationMetadata>
        deleteVodConfigOperationSettings() {
      return getStubSettingsBuilder().deleteVodConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateVodConfig. */
    public UnaryCallSettings.Builder<UpdateVodConfigRequest, Operation> updateVodConfigSettings() {
      return getStubSettingsBuilder().updateVodConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateVodConfig. */
    public OperationCallSettings.Builder<UpdateVodConfigRequest, VodConfig, OperationMetadata>
        updateVodConfigOperationSettings() {
      return getStubSettingsBuilder().updateVodConfigOperationSettings();
    }

    @Override
    public VideoStitcherServiceSettings build() throws IOException {
      return new VideoStitcherServiceSettings(this);
    }
  }
}
