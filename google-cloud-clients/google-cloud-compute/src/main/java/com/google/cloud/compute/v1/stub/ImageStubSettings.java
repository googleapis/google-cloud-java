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

import static com.google.cloud.compute.v1.ImageClient.ListImagesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteImageHttpRequest;
import com.google.cloud.compute.v1.DeprecateImageHttpRequest;
import com.google.cloud.compute.v1.GetFromFamilyImageHttpRequest;
import com.google.cloud.compute.v1.GetImageHttpRequest;
import com.google.cloud.compute.v1.Image;
import com.google.cloud.compute.v1.ImageList;
import com.google.cloud.compute.v1.InsertImageHttpRequest;
import com.google.cloud.compute.v1.ListImagesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetLabelsImageHttpRequest;
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
 * Settings class to configure an instance of {@link ImageStub}.
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
 * ImageStubSettings.Builder imageSettingsBuilder =
 *     ImageStubSettings.newBuilder();
 * imageSettingsBuilder.deleteImageSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ImageStubSettings imageSettings = imageSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ImageStubSettings extends StubSettings<ImageStubSettings> {
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

  private final UnaryCallSettings<DeleteImageHttpRequest, Operation> deleteImageSettings;
  private final UnaryCallSettings<DeprecateImageHttpRequest, Operation> deprecateImageSettings;
  private final UnaryCallSettings<GetImageHttpRequest, Image> getImageSettings;
  private final UnaryCallSettings<GetFromFamilyImageHttpRequest, Image> getFromFamilyImageSettings;
  private final UnaryCallSettings<InsertImageHttpRequest, Operation> insertImageSettings;
  private final PagedCallSettings<ListImagesHttpRequest, ImageList, ListImagesPagedResponse>
      listImagesSettings;
  private final UnaryCallSettings<SetLabelsImageHttpRequest, Operation> setLabelsImageSettings;

  /** Returns the object with the settings used for calls to deleteImage. */
  public UnaryCallSettings<DeleteImageHttpRequest, Operation> deleteImageSettings() {
    return deleteImageSettings;
  }

  /** Returns the object with the settings used for calls to deprecateImage. */
  public UnaryCallSettings<DeprecateImageHttpRequest, Operation> deprecateImageSettings() {
    return deprecateImageSettings;
  }

  /** Returns the object with the settings used for calls to getImage. */
  public UnaryCallSettings<GetImageHttpRequest, Image> getImageSettings() {
    return getImageSettings;
  }

  /** Returns the object with the settings used for calls to getFromFamilyImage. */
  public UnaryCallSettings<GetFromFamilyImageHttpRequest, Image> getFromFamilyImageSettings() {
    return getFromFamilyImageSettings;
  }

  /** Returns the object with the settings used for calls to insertImage. */
  public UnaryCallSettings<InsertImageHttpRequest, Operation> insertImageSettings() {
    return insertImageSettings;
  }

  /** Returns the object with the settings used for calls to listImages. */
  public PagedCallSettings<ListImagesHttpRequest, ImageList, ListImagesPagedResponse>
      listImagesSettings() {
    return listImagesSettings;
  }

  /** Returns the object with the settings used for calls to setLabelsImage. */
  public UnaryCallSettings<SetLabelsImageHttpRequest, Operation> setLabelsImageSettings() {
    return setLabelsImageSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ImageStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonImageStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ImageStubSettings.class))
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

  protected ImageStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteImageSettings = settingsBuilder.deleteImageSettings().build();
    deprecateImageSettings = settingsBuilder.deprecateImageSettings().build();
    getImageSettings = settingsBuilder.getImageSettings().build();
    getFromFamilyImageSettings = settingsBuilder.getFromFamilyImageSettings().build();
    insertImageSettings = settingsBuilder.insertImageSettings().build();
    listImagesSettings = settingsBuilder.listImagesSettings().build();
    setLabelsImageSettings = settingsBuilder.setLabelsImageSettings().build();
  }

  private static final PagedListDescriptor<ListImagesHttpRequest, ImageList, Image>
      LIST_IMAGES_PAGE_STR_DESC =
          new PagedListDescriptor<ListImagesHttpRequest, ImageList, Image>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListImagesHttpRequest injectToken(ListImagesHttpRequest payload, String token) {
              return ListImagesHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListImagesHttpRequest injectPageSize(
                ListImagesHttpRequest payload, int pageSize) {
              return ListImagesHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListImagesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(ImageList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Image> extractResources(ImageList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Image>of();
            }
          };

  private static final PagedListResponseFactory<
          ListImagesHttpRequest, ImageList, ListImagesPagedResponse>
      LIST_IMAGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListImagesHttpRequest, ImageList, ListImagesPagedResponse>() {
            @Override
            public ApiFuture<ListImagesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListImagesHttpRequest, ImageList> callable,
                ListImagesHttpRequest request,
                ApiCallContext context,
                ApiFuture<ImageList> futureResponse) {
              PageContext<ListImagesHttpRequest, ImageList, Image> pageContext =
                  PageContext.create(callable, LIST_IMAGES_PAGE_STR_DESC, request, context);
              return ListImagesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for ImageStubSettings. */
  public static class Builder extends StubSettings.Builder<ImageStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteImageHttpRequest, Operation> deleteImageSettings;
    private final UnaryCallSettings.Builder<DeprecateImageHttpRequest, Operation>
        deprecateImageSettings;
    private final UnaryCallSettings.Builder<GetImageHttpRequest, Image> getImageSettings;
    private final UnaryCallSettings.Builder<GetFromFamilyImageHttpRequest, Image>
        getFromFamilyImageSettings;
    private final UnaryCallSettings.Builder<InsertImageHttpRequest, Operation> insertImageSettings;
    private final PagedCallSettings.Builder<
            ListImagesHttpRequest, ImageList, ListImagesPagedResponse>
        listImagesSettings;
    private final UnaryCallSettings.Builder<SetLabelsImageHttpRequest, Operation>
        setLabelsImageSettings;

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

      deleteImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deprecateImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getFromFamilyImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listImagesSettings = PagedCallSettings.newBuilder(LIST_IMAGES_PAGE_STR_FACT);

      setLabelsImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteImageSettings,
              deprecateImageSettings,
              getImageSettings,
              getFromFamilyImageSettings,
              insertImageSettings,
              listImagesSettings,
              setLabelsImageSettings);

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
          .deleteImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deprecateImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getFromFamilyImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listImagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setLabelsImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(ImageStubSettings settings) {
      super(settings);

      deleteImageSettings = settings.deleteImageSettings.toBuilder();
      deprecateImageSettings = settings.deprecateImageSettings.toBuilder();
      getImageSettings = settings.getImageSettings.toBuilder();
      getFromFamilyImageSettings = settings.getFromFamilyImageSettings.toBuilder();
      insertImageSettings = settings.insertImageSettings.toBuilder();
      listImagesSettings = settings.listImagesSettings.toBuilder();
      setLabelsImageSettings = settings.setLabelsImageSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteImageSettings,
              deprecateImageSettings,
              getImageSettings,
              getFromFamilyImageSettings,
              insertImageSettings,
              listImagesSettings,
              setLabelsImageSettings);
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

    /** Returns the builder for the settings used for calls to deleteImage. */
    public UnaryCallSettings.Builder<DeleteImageHttpRequest, Operation> deleteImageSettings() {
      return deleteImageSettings;
    }

    /** Returns the builder for the settings used for calls to deprecateImage. */
    public UnaryCallSettings.Builder<DeprecateImageHttpRequest, Operation>
        deprecateImageSettings() {
      return deprecateImageSettings;
    }

    /** Returns the builder for the settings used for calls to getImage. */
    public UnaryCallSettings.Builder<GetImageHttpRequest, Image> getImageSettings() {
      return getImageSettings;
    }

    /** Returns the builder for the settings used for calls to getFromFamilyImage. */
    public UnaryCallSettings.Builder<GetFromFamilyImageHttpRequest, Image>
        getFromFamilyImageSettings() {
      return getFromFamilyImageSettings;
    }

    /** Returns the builder for the settings used for calls to insertImage. */
    public UnaryCallSettings.Builder<InsertImageHttpRequest, Operation> insertImageSettings() {
      return insertImageSettings;
    }

    /** Returns the builder for the settings used for calls to listImages. */
    public PagedCallSettings.Builder<ListImagesHttpRequest, ImageList, ListImagesPagedResponse>
        listImagesSettings() {
      return listImagesSettings;
    }

    /** Returns the builder for the settings used for calls to setLabelsImage. */
    public UnaryCallSettings.Builder<SetLabelsImageHttpRequest, Operation>
        setLabelsImageSettings() {
      return setLabelsImageSettings;
    }

    @Override
    public ImageStubSettings build() throws IOException {
      return new ImageStubSettings(this);
    }
  }
}
