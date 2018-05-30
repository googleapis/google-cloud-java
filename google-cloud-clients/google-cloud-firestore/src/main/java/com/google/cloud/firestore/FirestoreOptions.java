/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.firestore;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.TransportOptions;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.cloud.firestore.spi.v1beta1.GrpcFirestoreRpc;
import com.google.cloud.firestore.v1beta1.FirestoreSettings;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;

/** A Factory class to create new Firestore instances. */
public final class FirestoreOptions extends ServiceOptions<Firestore, FirestoreOptions> {

  private static final String API_SHORT_NAME = "Firestore";
  private static final Set<String> SCOPES =
      ImmutableSet.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/datastore")
          .build();

  private static final long serialVersionUID = -5853552236134770089L;

  private final String databaseId;
  private final TransportChannelProvider channelProvider;
  private final CredentialsProvider credentialsProvider;

  public static class DefaultFirestoreFactory implements FirestoreFactory {

    private static final FirestoreFactory INSTANCE = new DefaultFirestoreFactory();

    @Nonnull
    @Override
    public Firestore create(@Nonnull FirestoreOptions options) {
      return new FirestoreImpl(options);
    }
  }

  /** Returns a default {@code FirestoreOptions} instance. */
  public static FirestoreOptions getDefaultInstance() {
    return newBuilder().build();
  }

  public static class DefaultFirestoreRpcFactory implements FirestoreRpcFactory {

    private static final FirestoreRpcFactory INSTANCE = new DefaultFirestoreRpcFactory();

    @Nonnull
    @Override
    public FirestoreRpc create(@Nonnull FirestoreOptions options) {
      try {
        return new GrpcFirestoreRpc(options);
      } catch (IOException e) {
        throw FirestoreException.networkException(e, false);
      }
    }
  }

  @Override
  protected boolean projectIdRequired() {
    return false;
  }

  @Override
  protected String getDefaultHost() {
    return FirestoreDefaults.INSTANCE.getHost();
  }

  public String getDatabaseId() {
    return databaseId;
  }

  public CredentialsProvider getCredentialsProvider() {
    return credentialsProvider;
  }

  public TransportChannelProvider getTransportChannelProvider() {
    return channelProvider;
  }

  public static class Builder extends ServiceOptions.Builder<Firestore, FirestoreOptions, Builder> {

    private String databaseId = FirestoreDefaults.INSTANCE.getDatabaseId();
    private TransportChannelProvider channelProvider =
        FirestoreDefaults.INSTANCE.getTransportChannelProvider();
    private CredentialsProvider credentialsProvider =
        FirestoreDefaults.INSTANCE.getCredentialsProvider();

    private Builder() {}

    private Builder(FirestoreOptions options) {
      super(options);
      this.databaseId = options.databaseId;
      this.channelProvider = options.channelProvider;
      this.credentialsProvider = options.credentialsProvider;
    }

    /**
     * Sets the {@link TransportOptions} to use with this Firestore client.
     *
     * @param transportOptions A GrpcTransportOptions object that defines the transport options for
     * this client.
     */
    @Nonnull
    @Override
    public Builder setTransportOptions(@Nonnull TransportOptions transportOptions) {
      if (!(transportOptions instanceof GrpcTransportOptions)) {
        throw new IllegalArgumentException(
            "Only GRPC transport is allowed for " + API_SHORT_NAME + ".");
      }
      return super.setTransportOptions(transportOptions);
    }

    /**
     * Sets the {@link TransportChannelProvider} to use with this Firestore client.
     *
     * @param channelProvider A InstantiatingGrpcChannelProvider object that defines the transport
     * provider for this client.
     */
    @Nonnull
    public Builder setChannelProvider(@Nonnull TransportChannelProvider channelProvider) {
      if (!(channelProvider instanceof InstantiatingGrpcChannelProvider)) {
        throw new IllegalArgumentException(
            "Only GRPC channels are allowed for " + API_SHORT_NAME + ".");
      }
      this.channelProvider = channelProvider;
      return this;
    }

    /**
     * Sets the {@link CredentialsProvider} to use with this Firestore client.
     *
     * @param credentialsProvider A CredentialsProvider object that defines the credential provider
     * for this client.
     */
    @Nonnull
    public Builder setCredentialsProvider(@Nonnull CredentialsProvider credentialsProvider) {
      this.credentialsProvider = credentialsProvider;
      return this;
    }

    /**
     * Sets the database ID to use with this Firestore client.
     *
     * @param databaseId The Firestore database ID to use with this client.
     */
    public Builder setDatabaseId(String databaseId) {
      this.databaseId = databaseId;
      return this;
    }

    @Override
    @Nonnull
    public FirestoreOptions build() {
      return new FirestoreOptions(this);
    }
  }

  @InternalApi("This class should only be extended within google-cloud-java")
  protected FirestoreOptions(Builder builder) {
    super(FirestoreFactory.class, FirestoreRpcFactory.class, builder, new FirestoreDefaults());

    this.databaseId = builder.databaseId;
    this.channelProvider = builder.channelProvider;
    this.credentialsProvider = builder.credentialsProvider;
  }

  private static class FirestoreDefaults implements ServiceDefaults<Firestore, FirestoreOptions> {
    private static final FirestoreDefaults INSTANCE = new FirestoreDefaults();

    private final String HOST = FirestoreSettings.getDefaultEndpoint();
    private final String DATABASE_ID = "(default)";
    private final TransportOptions TRANSPORT_OPTIONS =
        getDefaultTransportOptionsBuilder().build();
    private final TransportChannelProvider CHANNEL_PROVIDER =
        getDefaultTransportChannelProviderBuilder().build();
    private final CredentialsProvider CREDENTIALS_PROVIDER =
        getDefaultCredentialsProviderBuilder().build();

    @Nonnull
    @Override
    public FirestoreFactory getDefaultServiceFactory() {
      return DefaultFirestoreFactory.INSTANCE;
    }

    @Nonnull
    @Override
    public FirestoreRpcFactory getDefaultRpcFactory() {
      return DefaultFirestoreRpcFactory.INSTANCE;
    }

    @Nonnull
    @Override
    public TransportOptions getDefaultTransportOptions() {
      return TRANSPORT_OPTIONS;
    }

    @Nonnull
    TransportChannelProvider getTransportChannelProvider() {
      return CHANNEL_PROVIDER;
    }

    @Nonnull
    String getHost() {
      return HOST;
    }

    @Nonnull
    String getDatabaseId() {
      return DATABASE_ID;
    }

    @Nonnull
    CredentialsProvider getCredentialsProvider() {
      return CREDENTIALS_PROVIDER;
    }
  }

  @Nonnull
  public static GrpcTransportOptions.Builder getDefaultTransportOptionsBuilder() {
    return GrpcTransportOptions.newBuilder();
  }

  @Nonnull
  public static InstantiatingGrpcChannelProvider.Builder
      getDefaultTransportChannelProviderBuilder() {
    return FirestoreSettings.defaultGrpcTransportProviderBuilder();
  }

  @Nonnull
  public static GoogleCredentialsProvider.Builder getDefaultCredentialsProviderBuilder() {
    return FirestoreSettings.defaultCredentialsProviderBuilder();
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  FirestoreRpc getFirestoreRpc() {
    return (FirestoreRpc) getRpc();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FirestoreOptions that = (FirestoreOptions) o;
    return Objects.equals(databaseId, that.databaseId)
        && Objects.equals(channelProvider, that.channelProvider)
        && baseEquals(that);
  }

  @Override
  public int hashCode() {
    return Objects.hash(databaseId, channelProvider, baseHashCode());
  }

  @Nonnull
  @SuppressWarnings("unchecked")
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Nonnull
  public static Builder newBuilder() {
    return new Builder();
  }
}
