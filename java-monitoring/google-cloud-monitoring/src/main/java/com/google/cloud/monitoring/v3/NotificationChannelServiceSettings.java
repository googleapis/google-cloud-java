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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelsPagedResponse;

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
import com.google.cloud.monitoring.v3.stub.NotificationChannelServiceStubSettings;
import com.google.monitoring.v3.CreateNotificationChannelRequest;
import com.google.monitoring.v3.DeleteNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelDescriptorRequest;
import com.google.monitoring.v3.GetNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse;
import com.google.monitoring.v3.ListNotificationChannelsRequest;
import com.google.monitoring.v3.ListNotificationChannelsResponse;
import com.google.monitoring.v3.NotificationChannel;
import com.google.monitoring.v3.NotificationChannelDescriptor;
import com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.UpdateNotificationChannelRequest;
import com.google.monitoring.v3.VerifyNotificationChannelRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NotificationChannelServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (monitoring.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getNotificationChannelDescriptor to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NotificationChannelServiceSettings.Builder notificationChannelServiceSettingsBuilder =
 *     NotificationChannelServiceSettings.newBuilder();
 * notificationChannelServiceSettingsBuilder
 *     .getNotificationChannelDescriptorSettings()
 *     .setRetrySettings(
 *         notificationChannelServiceSettingsBuilder
 *             .getNotificationChannelDescriptorSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NotificationChannelServiceSettings notificationChannelServiceSettings =
 *     notificationChannelServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NotificationChannelServiceSettings
    extends ClientSettings<NotificationChannelServiceSettings> {

  /** Returns the object with the settings used for calls to listNotificationChannelDescriptors. */
  public PagedCallSettings<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsResponse,
          ListNotificationChannelDescriptorsPagedResponse>
      listNotificationChannelDescriptorsSettings() {
    return ((NotificationChannelServiceStubSettings) getStubSettings())
        .listNotificationChannelDescriptorsSettings();
  }

  /** Returns the object with the settings used for calls to getNotificationChannelDescriptor. */
  public UnaryCallSettings<GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
      getNotificationChannelDescriptorSettings() {
    return ((NotificationChannelServiceStubSettings) getStubSettings())
        .getNotificationChannelDescriptorSettings();
  }

  /** Returns the object with the settings used for calls to listNotificationChannels. */
  public PagedCallSettings<
          ListNotificationChannelsRequest,
          ListNotificationChannelsResponse,
          ListNotificationChannelsPagedResponse>
      listNotificationChannelsSettings() {
    return ((NotificationChannelServiceStubSettings) getStubSettings())
        .listNotificationChannelsSettings();
  }

  /** Returns the object with the settings used for calls to getNotificationChannel. */
  public UnaryCallSettings<GetNotificationChannelRequest, NotificationChannel>
      getNotificationChannelSettings() {
    return ((NotificationChannelServiceStubSettings) getStubSettings())
        .getNotificationChannelSettings();
  }

  /** Returns the object with the settings used for calls to createNotificationChannel. */
  public UnaryCallSettings<CreateNotificationChannelRequest, NotificationChannel>
      createNotificationChannelSettings() {
    return ((NotificationChannelServiceStubSettings) getStubSettings())
        .createNotificationChannelSettings();
  }

  /** Returns the object with the settings used for calls to updateNotificationChannel. */
  public UnaryCallSettings<UpdateNotificationChannelRequest, NotificationChannel>
      updateNotificationChannelSettings() {
    return ((NotificationChannelServiceStubSettings) getStubSettings())
        .updateNotificationChannelSettings();
  }

  /** Returns the object with the settings used for calls to deleteNotificationChannel. */
  public UnaryCallSettings<DeleteNotificationChannelRequest, Empty>
      deleteNotificationChannelSettings() {
    return ((NotificationChannelServiceStubSettings) getStubSettings())
        .deleteNotificationChannelSettings();
  }

  /**
   * Returns the object with the settings used for calls to sendNotificationChannelVerificationCode.
   */
  public UnaryCallSettings<SendNotificationChannelVerificationCodeRequest, Empty>
      sendNotificationChannelVerificationCodeSettings() {
    return ((NotificationChannelServiceStubSettings) getStubSettings())
        .sendNotificationChannelVerificationCodeSettings();
  }

  /**
   * Returns the object with the settings used for calls to getNotificationChannelVerificationCode.
   */
  public UnaryCallSettings<
          GetNotificationChannelVerificationCodeRequest,
          GetNotificationChannelVerificationCodeResponse>
      getNotificationChannelVerificationCodeSettings() {
    return ((NotificationChannelServiceStubSettings) getStubSettings())
        .getNotificationChannelVerificationCodeSettings();
  }

  /** Returns the object with the settings used for calls to verifyNotificationChannel. */
  public UnaryCallSettings<VerifyNotificationChannelRequest, NotificationChannel>
      verifyNotificationChannelSettings() {
    return ((NotificationChannelServiceStubSettings) getStubSettings())
        .verifyNotificationChannelSettings();
  }

  public static final NotificationChannelServiceSettings create(
      NotificationChannelServiceStubSettings stub) throws IOException {
    return new NotificationChannelServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NotificationChannelServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NotificationChannelServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NotificationChannelServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NotificationChannelServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return NotificationChannelServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NotificationChannelServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NotificationChannelServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NotificationChannelServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NotificationChannelServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<NotificationChannelServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(NotificationChannelServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(NotificationChannelServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NotificationChannelServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NotificationChannelServiceStubSettings.newBuilder());
    }

    public NotificationChannelServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((NotificationChannelServiceStubSettings.Builder) getStubSettings());
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

    /**
     * Returns the builder for the settings used for calls to listNotificationChannelDescriptors.
     */
    public PagedCallSettings.Builder<
            ListNotificationChannelDescriptorsRequest,
            ListNotificationChannelDescriptorsResponse,
            ListNotificationChannelDescriptorsPagedResponse>
        listNotificationChannelDescriptorsSettings() {
      return getStubSettingsBuilder().listNotificationChannelDescriptorsSettings();
    }

    /** Returns the builder for the settings used for calls to getNotificationChannelDescriptor. */
    public UnaryCallSettings.Builder<
            GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
        getNotificationChannelDescriptorSettings() {
      return getStubSettingsBuilder().getNotificationChannelDescriptorSettings();
    }

    /** Returns the builder for the settings used for calls to listNotificationChannels. */
    public PagedCallSettings.Builder<
            ListNotificationChannelsRequest,
            ListNotificationChannelsResponse,
            ListNotificationChannelsPagedResponse>
        listNotificationChannelsSettings() {
      return getStubSettingsBuilder().listNotificationChannelsSettings();
    }

    /** Returns the builder for the settings used for calls to getNotificationChannel. */
    public UnaryCallSettings.Builder<GetNotificationChannelRequest, NotificationChannel>
        getNotificationChannelSettings() {
      return getStubSettingsBuilder().getNotificationChannelSettings();
    }

    /** Returns the builder for the settings used for calls to createNotificationChannel. */
    public UnaryCallSettings.Builder<CreateNotificationChannelRequest, NotificationChannel>
        createNotificationChannelSettings() {
      return getStubSettingsBuilder().createNotificationChannelSettings();
    }

    /** Returns the builder for the settings used for calls to updateNotificationChannel. */
    public UnaryCallSettings.Builder<UpdateNotificationChannelRequest, NotificationChannel>
        updateNotificationChannelSettings() {
      return getStubSettingsBuilder().updateNotificationChannelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNotificationChannel. */
    public UnaryCallSettings.Builder<DeleteNotificationChannelRequest, Empty>
        deleteNotificationChannelSettings() {
      return getStubSettingsBuilder().deleteNotificationChannelSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * sendNotificationChannelVerificationCode.
     */
    public UnaryCallSettings.Builder<SendNotificationChannelVerificationCodeRequest, Empty>
        sendNotificationChannelVerificationCodeSettings() {
      return getStubSettingsBuilder().sendNotificationChannelVerificationCodeSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * getNotificationChannelVerificationCode.
     */
    public UnaryCallSettings.Builder<
            GetNotificationChannelVerificationCodeRequest,
            GetNotificationChannelVerificationCodeResponse>
        getNotificationChannelVerificationCodeSettings() {
      return getStubSettingsBuilder().getNotificationChannelVerificationCodeSettings();
    }

    /** Returns the builder for the settings used for calls to verifyNotificationChannel. */
    public UnaryCallSettings.Builder<VerifyNotificationChannelRequest, NotificationChannel>
        verifyNotificationChannelSettings() {
      return getStubSettingsBuilder().verifyNotificationChannelSettings();
    }

    @Override
    public NotificationChannelServiceSettings build() throws IOException {
      return new NotificationChannelServiceSettings(this);
    }
  }
}
