/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.TransportOptions;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.cloud.firestore.spi.v1beta1.GrpcFirestoreRpc;
import com.google.cloud.firestore.v1beta1.FirestoreSettings;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
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
  private static final String DEFAULT_HOST = FirestoreSettings.getDefaultEndpoint();
  private static final String DEFAULT_DATABASE_ID = "(default)";
  private static final long serialVersionUID = -5853552236134770088L;

  private final String databaseId;

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
    return DEFAULT_HOST;
  }

  public String getDatabaseId() {
    return databaseId;
  }

  public static class Builder extends ServiceOptions.Builder<Firestore, FirestoreOptions, Builder> {

    private String databaseId = DEFAULT_DATABASE_ID;

    private Builder() {}

    private Builder(FirestoreOptions options) {
      super(options);
    }

    @Nonnull
    @Override
    public Builder setTransportOptions(@Nonnull TransportOptions transportOptions) {
      if (!(transportOptions instanceof GrpcTransportOptions)) {
        throw new IllegalArgumentException(
            "Only grpc transport is allowed for " + API_SHORT_NAME + ".");
      }
      return super.setTransportOptions(transportOptions);
    }

    @Override
    @Nonnull
    public FirestoreOptions build() {
      return new FirestoreOptions(this);
    }

    public Builder setDatabaseId(String databaseId) {
      this.databaseId = databaseId;
      return this;
    }
  }

  @InternalApi("This class should only be extended within google-cloud-java")
  protected FirestoreOptions(Builder builder) {
    super(FirestoreFactory.class, FirestoreRpcFactory.class, builder, new FirestoreDefaults());

    this.databaseId = builder.databaseId;
  }

  private static class FirestoreDefaults implements ServiceDefaults<Firestore, FirestoreOptions> {

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
      return getDefaultGrpcTransportOptions();
    }
  }

  @Nonnull
  public static GrpcTransportOptions getDefaultGrpcTransportOptions() {
    return GrpcTransportOptions.newBuilder().build();
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  FirestoreRpc getFirestoreRpc() {
    return (FirestoreRpc) getRpc();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof FirestoreOptions && baseEquals((FirestoreOptions) obj);
  }

  @Override
  public int hashCode() {
    return baseHashCode();
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
