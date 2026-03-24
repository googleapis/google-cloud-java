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

package com.google.storage.v2;

import static com.google.storage.v2.StorageClient.ListBucketsPagedResponse;
import static com.google.storage.v2.StorageClient.ListHmacKeysPagedResponse;
import static com.google.storage.v2.StorageClient.ListNotificationsPagedResponse;
import static com.google.storage.v2.StorageClient.ListObjectsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.storage.v2.stub.StorageStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link StorageClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (storage.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of deleteBucket:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageSettings.Builder storageSettingsBuilder = StorageSettings.newBuilder();
 * storageSettingsBuilder
 *     .deleteBucketSettings()
 *     .setRetrySettings(
 *         storageSettingsBuilder
 *             .deleteBucketSettings()
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
 * StorageSettings storageSettings = storageSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class StorageSettings extends ClientSettings<StorageSettings> {

  /** Returns the object with the settings used for calls to deleteBucket. */
  public UnaryCallSettings<DeleteBucketRequest, Empty> deleteBucketSettings() {
    return ((StorageStubSettings) getStubSettings()).deleteBucketSettings();
  }

  /** Returns the object with the settings used for calls to getBucket. */
  public UnaryCallSettings<GetBucketRequest, Bucket> getBucketSettings() {
    return ((StorageStubSettings) getStubSettings()).getBucketSettings();
  }

  /** Returns the object with the settings used for calls to createBucket. */
  public UnaryCallSettings<CreateBucketRequest, Bucket> createBucketSettings() {
    return ((StorageStubSettings) getStubSettings()).createBucketSettings();
  }

  /** Returns the object with the settings used for calls to listBuckets. */
  public PagedCallSettings<ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
      listBucketsSettings() {
    return ((StorageStubSettings) getStubSettings()).listBucketsSettings();
  }

  /** Returns the object with the settings used for calls to lockBucketRetentionPolicy. */
  public UnaryCallSettings<LockBucketRetentionPolicyRequest, Bucket>
      lockBucketRetentionPolicySettings() {
    return ((StorageStubSettings) getStubSettings()).lockBucketRetentionPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((StorageStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((StorageStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((StorageStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to updateBucket. */
  public UnaryCallSettings<UpdateBucketRequest, Bucket> updateBucketSettings() {
    return ((StorageStubSettings) getStubSettings()).updateBucketSettings();
  }

  /** Returns the object with the settings used for calls to deleteNotification. */
  public UnaryCallSettings<DeleteNotificationRequest, Empty> deleteNotificationSettings() {
    return ((StorageStubSettings) getStubSettings()).deleteNotificationSettings();
  }

  /** Returns the object with the settings used for calls to getNotification. */
  public UnaryCallSettings<GetNotificationRequest, Notification> getNotificationSettings() {
    return ((StorageStubSettings) getStubSettings()).getNotificationSettings();
  }

  /** Returns the object with the settings used for calls to createNotification. */
  public UnaryCallSettings<CreateNotificationRequest, Notification> createNotificationSettings() {
    return ((StorageStubSettings) getStubSettings()).createNotificationSettings();
  }

  /** Returns the object with the settings used for calls to listNotifications. */
  public PagedCallSettings<
          ListNotificationsRequest, ListNotificationsResponse, ListNotificationsPagedResponse>
      listNotificationsSettings() {
    return ((StorageStubSettings) getStubSettings()).listNotificationsSettings();
  }

  /** Returns the object with the settings used for calls to composeObject. */
  public UnaryCallSettings<ComposeObjectRequest, Object> composeObjectSettings() {
    return ((StorageStubSettings) getStubSettings()).composeObjectSettings();
  }

  /** Returns the object with the settings used for calls to deleteObject. */
  public UnaryCallSettings<DeleteObjectRequest, Empty> deleteObjectSettings() {
    return ((StorageStubSettings) getStubSettings()).deleteObjectSettings();
  }

  /** Returns the object with the settings used for calls to cancelResumableWrite. */
  public UnaryCallSettings<CancelResumableWriteRequest, CancelResumableWriteResponse>
      cancelResumableWriteSettings() {
    return ((StorageStubSettings) getStubSettings()).cancelResumableWriteSettings();
  }

  /** Returns the object with the settings used for calls to getObject. */
  public UnaryCallSettings<GetObjectRequest, Object> getObjectSettings() {
    return ((StorageStubSettings) getStubSettings()).getObjectSettings();
  }

  /** Returns the object with the settings used for calls to readObject. */
  public ServerStreamingCallSettings<ReadObjectRequest, ReadObjectResponse> readObjectSettings() {
    return ((StorageStubSettings) getStubSettings()).readObjectSettings();
  }

  /** Returns the object with the settings used for calls to updateObject. */
  public UnaryCallSettings<UpdateObjectRequest, Object> updateObjectSettings() {
    return ((StorageStubSettings) getStubSettings()).updateObjectSettings();
  }

  /** Returns the object with the settings used for calls to writeObject. */
  public StreamingCallSettings<WriteObjectRequest, WriteObjectResponse> writeObjectSettings() {
    return ((StorageStubSettings) getStubSettings()).writeObjectSettings();
  }

  /** Returns the object with the settings used for calls to listObjects. */
  public PagedCallSettings<ListObjectsRequest, ListObjectsResponse, ListObjectsPagedResponse>
      listObjectsSettings() {
    return ((StorageStubSettings) getStubSettings()).listObjectsSettings();
  }

  /** Returns the object with the settings used for calls to rewriteObject. */
  public UnaryCallSettings<RewriteObjectRequest, RewriteResponse> rewriteObjectSettings() {
    return ((StorageStubSettings) getStubSettings()).rewriteObjectSettings();
  }

  /** Returns the object with the settings used for calls to startResumableWrite. */
  public UnaryCallSettings<StartResumableWriteRequest, StartResumableWriteResponse>
      startResumableWriteSettings() {
    return ((StorageStubSettings) getStubSettings()).startResumableWriteSettings();
  }

  /** Returns the object with the settings used for calls to queryWriteStatus. */
  public UnaryCallSettings<QueryWriteStatusRequest, QueryWriteStatusResponse>
      queryWriteStatusSettings() {
    return ((StorageStubSettings) getStubSettings()).queryWriteStatusSettings();
  }

  /** Returns the object with the settings used for calls to getServiceAccount. */
  public UnaryCallSettings<GetServiceAccountRequest, ServiceAccount> getServiceAccountSettings() {
    return ((StorageStubSettings) getStubSettings()).getServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to createHmacKey. */
  public UnaryCallSettings<CreateHmacKeyRequest, CreateHmacKeyResponse> createHmacKeySettings() {
    return ((StorageStubSettings) getStubSettings()).createHmacKeySettings();
  }

  /** Returns the object with the settings used for calls to deleteHmacKey. */
  public UnaryCallSettings<DeleteHmacKeyRequest, Empty> deleteHmacKeySettings() {
    return ((StorageStubSettings) getStubSettings()).deleteHmacKeySettings();
  }

  /** Returns the object with the settings used for calls to getHmacKey. */
  public UnaryCallSettings<GetHmacKeyRequest, HmacKeyMetadata> getHmacKeySettings() {
    return ((StorageStubSettings) getStubSettings()).getHmacKeySettings();
  }

  /** Returns the object with the settings used for calls to listHmacKeys. */
  public PagedCallSettings<ListHmacKeysRequest, ListHmacKeysResponse, ListHmacKeysPagedResponse>
      listHmacKeysSettings() {
    return ((StorageStubSettings) getStubSettings()).listHmacKeysSettings();
  }

  /** Returns the object with the settings used for calls to updateHmacKey. */
  public UnaryCallSettings<UpdateHmacKeyRequest, HmacKeyMetadata> updateHmacKeySettings() {
    return ((StorageStubSettings) getStubSettings()).updateHmacKeySettings();
  }

  public static final StorageSettings create(StorageStubSettings stub) throws IOException {
    return new StorageSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return StorageStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return StorageStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return StorageStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return StorageStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return StorageStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return StorageStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return StorageStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected StorageSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for StorageSettings. */
  public static class Builder extends ClientSettings.Builder<StorageSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(StorageStubSettings.newBuilder(clientContext));
    }

    protected Builder(StorageSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(StorageStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(StorageStubSettings.newBuilder());
    }

    public StorageStubSettings.Builder getStubSettingsBuilder() {
      return ((StorageStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteBucket. */
    public UnaryCallSettings.Builder<DeleteBucketRequest, Empty> deleteBucketSettings() {
      return getStubSettingsBuilder().deleteBucketSettings();
    }

    /** Returns the builder for the settings used for calls to getBucket. */
    public UnaryCallSettings.Builder<GetBucketRequest, Bucket> getBucketSettings() {
      return getStubSettingsBuilder().getBucketSettings();
    }

    /** Returns the builder for the settings used for calls to createBucket. */
    public UnaryCallSettings.Builder<CreateBucketRequest, Bucket> createBucketSettings() {
      return getStubSettingsBuilder().createBucketSettings();
    }

    /** Returns the builder for the settings used for calls to listBuckets. */
    public PagedCallSettings.Builder<
            ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
        listBucketsSettings() {
      return getStubSettingsBuilder().listBucketsSettings();
    }

    /** Returns the builder for the settings used for calls to lockBucketRetentionPolicy. */
    public UnaryCallSettings.Builder<LockBucketRetentionPolicyRequest, Bucket>
        lockBucketRetentionPolicySettings() {
      return getStubSettingsBuilder().lockBucketRetentionPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to updateBucket. */
    public UnaryCallSettings.Builder<UpdateBucketRequest, Bucket> updateBucketSettings() {
      return getStubSettingsBuilder().updateBucketSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNotification. */
    public UnaryCallSettings.Builder<DeleteNotificationRequest, Empty>
        deleteNotificationSettings() {
      return getStubSettingsBuilder().deleteNotificationSettings();
    }

    /** Returns the builder for the settings used for calls to getNotification. */
    public UnaryCallSettings.Builder<GetNotificationRequest, Notification>
        getNotificationSettings() {
      return getStubSettingsBuilder().getNotificationSettings();
    }

    /** Returns the builder for the settings used for calls to createNotification. */
    public UnaryCallSettings.Builder<CreateNotificationRequest, Notification>
        createNotificationSettings() {
      return getStubSettingsBuilder().createNotificationSettings();
    }

    /** Returns the builder for the settings used for calls to listNotifications. */
    public PagedCallSettings.Builder<
            ListNotificationsRequest, ListNotificationsResponse, ListNotificationsPagedResponse>
        listNotificationsSettings() {
      return getStubSettingsBuilder().listNotificationsSettings();
    }

    /** Returns the builder for the settings used for calls to composeObject. */
    public UnaryCallSettings.Builder<ComposeObjectRequest, Object> composeObjectSettings() {
      return getStubSettingsBuilder().composeObjectSettings();
    }

    /** Returns the builder for the settings used for calls to deleteObject. */
    public UnaryCallSettings.Builder<DeleteObjectRequest, Empty> deleteObjectSettings() {
      return getStubSettingsBuilder().deleteObjectSettings();
    }

    /** Returns the builder for the settings used for calls to cancelResumableWrite. */
    public UnaryCallSettings.Builder<CancelResumableWriteRequest, CancelResumableWriteResponse>
        cancelResumableWriteSettings() {
      return getStubSettingsBuilder().cancelResumableWriteSettings();
    }

    /** Returns the builder for the settings used for calls to getObject. */
    public UnaryCallSettings.Builder<GetObjectRequest, Object> getObjectSettings() {
      return getStubSettingsBuilder().getObjectSettings();
    }

    /** Returns the builder for the settings used for calls to readObject. */
    public ServerStreamingCallSettings.Builder<ReadObjectRequest, ReadObjectResponse>
        readObjectSettings() {
      return getStubSettingsBuilder().readObjectSettings();
    }

    /** Returns the builder for the settings used for calls to updateObject. */
    public UnaryCallSettings.Builder<UpdateObjectRequest, Object> updateObjectSettings() {
      return getStubSettingsBuilder().updateObjectSettings();
    }

    /** Returns the builder for the settings used for calls to writeObject. */
    public StreamingCallSettings.Builder<WriteObjectRequest, WriteObjectResponse>
        writeObjectSettings() {
      return getStubSettingsBuilder().writeObjectSettings();
    }

    /** Returns the builder for the settings used for calls to listObjects. */
    public PagedCallSettings.Builder<
            ListObjectsRequest, ListObjectsResponse, ListObjectsPagedResponse>
        listObjectsSettings() {
      return getStubSettingsBuilder().listObjectsSettings();
    }

    /** Returns the builder for the settings used for calls to rewriteObject. */
    public UnaryCallSettings.Builder<RewriteObjectRequest, RewriteResponse>
        rewriteObjectSettings() {
      return getStubSettingsBuilder().rewriteObjectSettings();
    }

    /** Returns the builder for the settings used for calls to startResumableWrite. */
    public UnaryCallSettings.Builder<StartResumableWriteRequest, StartResumableWriteResponse>
        startResumableWriteSettings() {
      return getStubSettingsBuilder().startResumableWriteSettings();
    }

    /** Returns the builder for the settings used for calls to queryWriteStatus. */
    public UnaryCallSettings.Builder<QueryWriteStatusRequest, QueryWriteStatusResponse>
        queryWriteStatusSettings() {
      return getStubSettingsBuilder().queryWriteStatusSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceAccount. */
    public UnaryCallSettings.Builder<GetServiceAccountRequest, ServiceAccount>
        getServiceAccountSettings() {
      return getStubSettingsBuilder().getServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to createHmacKey. */
    public UnaryCallSettings.Builder<CreateHmacKeyRequest, CreateHmacKeyResponse>
        createHmacKeySettings() {
      return getStubSettingsBuilder().createHmacKeySettings();
    }

    /** Returns the builder for the settings used for calls to deleteHmacKey. */
    public UnaryCallSettings.Builder<DeleteHmacKeyRequest, Empty> deleteHmacKeySettings() {
      return getStubSettingsBuilder().deleteHmacKeySettings();
    }

    /** Returns the builder for the settings used for calls to getHmacKey. */
    public UnaryCallSettings.Builder<GetHmacKeyRequest, HmacKeyMetadata> getHmacKeySettings() {
      return getStubSettingsBuilder().getHmacKeySettings();
    }

    /** Returns the builder for the settings used for calls to listHmacKeys. */
    public PagedCallSettings.Builder<
            ListHmacKeysRequest, ListHmacKeysResponse, ListHmacKeysPagedResponse>
        listHmacKeysSettings() {
      return getStubSettingsBuilder().listHmacKeysSettings();
    }

    /** Returns the builder for the settings used for calls to updateHmacKey. */
    public UnaryCallSettings.Builder<UpdateHmacKeyRequest, HmacKeyMetadata>
        updateHmacKeySettings() {
      return getStubSettingsBuilder().updateHmacKeySettings();
    }

    @Override
    public StorageSettings build() throws IOException {
      return new StorageSettings(this);
    }
  }
}
