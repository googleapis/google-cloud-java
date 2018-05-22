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
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.ImageClient.ListImagesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.ImageStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ImageClient}.
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
 * example, to set the total timeout of deleteImage to 30 seconds:
 *
 * <pre>
 * <code>
 * ImageSettings.Builder imageSettingsBuilder =
 *     ImageSettings.newBuilder();
 * imageSettingsBuilder.deleteImageSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ImageSettings imageSettings = imageSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ImageSettings extends ClientSettings<ImageSettings> {
  /** Returns the object with the settings used for calls to deleteImage. */
  public UnaryCallSettings<DeleteImageHttpRequest, Operation> deleteImageSettings() {
    return ((ImageStubSettings) getStubSettings()).deleteImageSettings();
  }

  /** Returns the object with the settings used for calls to deprecateImage. */
  public UnaryCallSettings<DeprecateImageHttpRequest, Operation> deprecateImageSettings() {
    return ((ImageStubSettings) getStubSettings()).deprecateImageSettings();
  }

  /** Returns the object with the settings used for calls to getImage. */
  public UnaryCallSettings<GetImageHttpRequest, Image> getImageSettings() {
    return ((ImageStubSettings) getStubSettings()).getImageSettings();
  }

  /** Returns the object with the settings used for calls to getFromFamilyImage. */
  public UnaryCallSettings<GetFromFamilyImageHttpRequest, Image> getFromFamilyImageSettings() {
    return ((ImageStubSettings) getStubSettings()).getFromFamilyImageSettings();
  }

  /** Returns the object with the settings used for calls to insertImage. */
  public UnaryCallSettings<InsertImageHttpRequest, Operation> insertImageSettings() {
    return ((ImageStubSettings) getStubSettings()).insertImageSettings();
  }

  /** Returns the object with the settings used for calls to listImages. */
  public PagedCallSettings<ListImagesHttpRequest, ImageList, ListImagesPagedResponse>
      listImagesSettings() {
    return ((ImageStubSettings) getStubSettings()).listImagesSettings();
  }

  /** Returns the object with the settings used for calls to setLabelsImage. */
  public UnaryCallSettings<SetLabelsImageHttpRequest, Operation> setLabelsImageSettings() {
    return ((ImageStubSettings) getStubSettings()).setLabelsImageSettings();
  }

  public static final ImageSettings create(ImageStubSettings stub) throws IOException {
    return new ImageSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ImageStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ImageStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return ImageStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ImageStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ImageStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ImageStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ImageStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ImageStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ImageSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ImageSettings. */
  public static class Builder extends ClientSettings.Builder<ImageSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(ImageStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(ImageStubSettings.newBuilder());
    }

    protected Builder(ImageSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ImageStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public ImageStubSettings.Builder getStubSettingsBuilder() {
      return ((ImageStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to deleteImage. */
    public UnaryCallSettings.Builder<DeleteImageHttpRequest, Operation> deleteImageSettings() {
      return getStubSettingsBuilder().deleteImageSettings();
    }

    /** Returns the builder for the settings used for calls to deprecateImage. */
    public UnaryCallSettings.Builder<DeprecateImageHttpRequest, Operation>
        deprecateImageSettings() {
      return getStubSettingsBuilder().deprecateImageSettings();
    }

    /** Returns the builder for the settings used for calls to getImage. */
    public UnaryCallSettings.Builder<GetImageHttpRequest, Image> getImageSettings() {
      return getStubSettingsBuilder().getImageSettings();
    }

    /** Returns the builder for the settings used for calls to getFromFamilyImage. */
    public UnaryCallSettings.Builder<GetFromFamilyImageHttpRequest, Image>
        getFromFamilyImageSettings() {
      return getStubSettingsBuilder().getFromFamilyImageSettings();
    }

    /** Returns the builder for the settings used for calls to insertImage. */
    public UnaryCallSettings.Builder<InsertImageHttpRequest, Operation> insertImageSettings() {
      return getStubSettingsBuilder().insertImageSettings();
    }

    /** Returns the builder for the settings used for calls to listImages. */
    public PagedCallSettings.Builder<ListImagesHttpRequest, ImageList, ListImagesPagedResponse>
        listImagesSettings() {
      return getStubSettingsBuilder().listImagesSettings();
    }

    /** Returns the builder for the settings used for calls to setLabelsImage. */
    public UnaryCallSettings.Builder<SetLabelsImageHttpRequest, Operation>
        setLabelsImageSettings() {
      return getStubSettingsBuilder().setLabelsImageSettings();
    }

    @Override
    public ImageSettings build() throws IOException {
      return new ImageSettings(this);
    }
  }
}
