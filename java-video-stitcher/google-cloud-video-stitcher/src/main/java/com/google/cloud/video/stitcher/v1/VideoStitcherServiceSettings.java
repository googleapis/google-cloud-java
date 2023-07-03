/*
 * Copyright 2022 Google LLC
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
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListSlatesPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodAdTagDetailsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodStitchDetailsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.video.stitcher.v1.stub.VideoStitcherServiceStubSettings;
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
 * <p>For example, to set the total timeout of createCdnKey to 30 seconds:
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
 *     .createCdnKeySettings()
 *     .setRetrySettings(
 *         videoStitcherServiceSettingsBuilder
 *             .createCdnKeySettings()
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
  public UnaryCallSettings<CreateCdnKeyRequest, CdnKey> createCdnKeySettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).createCdnKeySettings();
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
  public UnaryCallSettings<DeleteCdnKeyRequest, Empty> deleteCdnKeySettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).deleteCdnKeySettings();
  }

  /** Returns the object with the settings used for calls to updateCdnKey. */
  public UnaryCallSettings<UpdateCdnKeyRequest, CdnKey> updateCdnKeySettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).updateCdnKeySettings();
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
  public UnaryCallSettings<CreateSlateRequest, Slate> createSlateSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).createSlateSettings();
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
  public UnaryCallSettings<UpdateSlateRequest, Slate> updateSlateSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).updateSlateSettings();
  }

  /** Returns the object with the settings used for calls to deleteSlate. */
  public UnaryCallSettings<DeleteSlateRequest, Empty> deleteSlateSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).deleteSlateSettings();
  }

  /** Returns the object with the settings used for calls to createLiveSession. */
  public UnaryCallSettings<CreateLiveSessionRequest, LiveSession> createLiveSessionSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).createLiveSessionSettings();
  }

  /** Returns the object with the settings used for calls to getLiveSession. */
  public UnaryCallSettings<GetLiveSessionRequest, LiveSession> getLiveSessionSettings() {
    return ((VideoStitcherServiceStubSettings) getStubSettings()).getLiveSessionSettings();
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
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
    public UnaryCallSettings.Builder<CreateCdnKeyRequest, CdnKey> createCdnKeySettings() {
      return getStubSettingsBuilder().createCdnKeySettings();
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
    public UnaryCallSettings.Builder<DeleteCdnKeyRequest, Empty> deleteCdnKeySettings() {
      return getStubSettingsBuilder().deleteCdnKeySettings();
    }

    /** Returns the builder for the settings used for calls to updateCdnKey. */
    public UnaryCallSettings.Builder<UpdateCdnKeyRequest, CdnKey> updateCdnKeySettings() {
      return getStubSettingsBuilder().updateCdnKeySettings();
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
    public UnaryCallSettings.Builder<CreateSlateRequest, Slate> createSlateSettings() {
      return getStubSettingsBuilder().createSlateSettings();
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
    public UnaryCallSettings.Builder<UpdateSlateRequest, Slate> updateSlateSettings() {
      return getStubSettingsBuilder().updateSlateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSlate. */
    public UnaryCallSettings.Builder<DeleteSlateRequest, Empty> deleteSlateSettings() {
      return getStubSettingsBuilder().deleteSlateSettings();
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

    @Override
    public VideoStitcherServiceSettings build() throws IOException {
      return new VideoStitcherServiceSettings(this);
    }
  }
}
