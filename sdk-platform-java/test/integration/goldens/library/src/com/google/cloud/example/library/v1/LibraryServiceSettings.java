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

package com.google.cloud.example.library.v1;

import static com.google.cloud.example.library.v1.LibraryServiceClient.ListBooksPagedResponse;
import static com.google.cloud.example.library.v1.LibraryServiceClient.ListShelvesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.example.library.v1.stub.LibraryServiceStubSettings;
import com.google.example.library.v1.Book;
import com.google.example.library.v1.CreateBookRequest;
import com.google.example.library.v1.CreateShelfRequest;
import com.google.example.library.v1.DeleteBookRequest;
import com.google.example.library.v1.DeleteShelfRequest;
import com.google.example.library.v1.GetBookRequest;
import com.google.example.library.v1.GetShelfRequest;
import com.google.example.library.v1.ListBooksRequest;
import com.google.example.library.v1.ListBooksResponse;
import com.google.example.library.v1.ListShelvesRequest;
import com.google.example.library.v1.ListShelvesResponse;
import com.google.example.library.v1.MergeShelvesRequest;
import com.google.example.library.v1.MoveBookRequest;
import com.google.example.library.v1.Shelf;
import com.google.example.library.v1.UpdateBookRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LibraryServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (library-example.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createShelf:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LibraryServiceSettings.Builder libraryServiceSettingsBuilder =
 *     LibraryServiceSettings.newBuilder();
 * libraryServiceSettingsBuilder
 *     .createShelfSettings()
 *     .setRetrySettings(
 *         libraryServiceSettingsBuilder
 *             .createShelfSettings()
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
 * LibraryServiceSettings libraryServiceSettings = libraryServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class LibraryServiceSettings extends ClientSettings<LibraryServiceSettings> {

  /** Returns the object with the settings used for calls to createShelf. */
  public UnaryCallSettings<CreateShelfRequest, Shelf> createShelfSettings() {
    return ((LibraryServiceStubSettings) getStubSettings()).createShelfSettings();
  }

  /** Returns the object with the settings used for calls to getShelf. */
  public UnaryCallSettings<GetShelfRequest, Shelf> getShelfSettings() {
    return ((LibraryServiceStubSettings) getStubSettings()).getShelfSettings();
  }

  /** Returns the object with the settings used for calls to listShelves. */
  public PagedCallSettings<ListShelvesRequest, ListShelvesResponse, ListShelvesPagedResponse>
      listShelvesSettings() {
    return ((LibraryServiceStubSettings) getStubSettings()).listShelvesSettings();
  }

  /** Returns the object with the settings used for calls to deleteShelf. */
  public UnaryCallSettings<DeleteShelfRequest, Empty> deleteShelfSettings() {
    return ((LibraryServiceStubSettings) getStubSettings()).deleteShelfSettings();
  }

  /** Returns the object with the settings used for calls to mergeShelves. */
  public UnaryCallSettings<MergeShelvesRequest, Shelf> mergeShelvesSettings() {
    return ((LibraryServiceStubSettings) getStubSettings()).mergeShelvesSettings();
  }

  /** Returns the object with the settings used for calls to createBook. */
  public UnaryCallSettings<CreateBookRequest, Book> createBookSettings() {
    return ((LibraryServiceStubSettings) getStubSettings()).createBookSettings();
  }

  /** Returns the object with the settings used for calls to getBook. */
  public UnaryCallSettings<GetBookRequest, Book> getBookSettings() {
    return ((LibraryServiceStubSettings) getStubSettings()).getBookSettings();
  }

  /** Returns the object with the settings used for calls to listBooks. */
  public PagedCallSettings<ListBooksRequest, ListBooksResponse, ListBooksPagedResponse>
      listBooksSettings() {
    return ((LibraryServiceStubSettings) getStubSettings()).listBooksSettings();
  }

  /** Returns the object with the settings used for calls to deleteBook. */
  public UnaryCallSettings<DeleteBookRequest, Empty> deleteBookSettings() {
    return ((LibraryServiceStubSettings) getStubSettings()).deleteBookSettings();
  }

  /** Returns the object with the settings used for calls to updateBook. */
  public UnaryCallSettings<UpdateBookRequest, Book> updateBookSettings() {
    return ((LibraryServiceStubSettings) getStubSettings()).updateBookSettings();
  }

  /** Returns the object with the settings used for calls to moveBook. */
  public UnaryCallSettings<MoveBookRequest, Book> moveBookSettings() {
    return ((LibraryServiceStubSettings) getStubSettings()).moveBookSettings();
  }

  public static final LibraryServiceSettings create(LibraryServiceStubSettings stub)
      throws IOException {
    return new LibraryServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LibraryServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LibraryServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LibraryServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LibraryServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return LibraryServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LibraryServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LibraryServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LibraryServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected LibraryServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LibraryServiceSettings. */
  public static class Builder extends ClientSettings.Builder<LibraryServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(LibraryServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(LibraryServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LibraryServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LibraryServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(LibraryServiceStubSettings.newHttpJsonBuilder());
    }

    public LibraryServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((LibraryServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createShelf. */
    public UnaryCallSettings.Builder<CreateShelfRequest, Shelf> createShelfSettings() {
      return getStubSettingsBuilder().createShelfSettings();
    }

    /** Returns the builder for the settings used for calls to getShelf. */
    public UnaryCallSettings.Builder<GetShelfRequest, Shelf> getShelfSettings() {
      return getStubSettingsBuilder().getShelfSettings();
    }

    /** Returns the builder for the settings used for calls to listShelves. */
    public PagedCallSettings.Builder<
            ListShelvesRequest, ListShelvesResponse, ListShelvesPagedResponse>
        listShelvesSettings() {
      return getStubSettingsBuilder().listShelvesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteShelf. */
    public UnaryCallSettings.Builder<DeleteShelfRequest, Empty> deleteShelfSettings() {
      return getStubSettingsBuilder().deleteShelfSettings();
    }

    /** Returns the builder for the settings used for calls to mergeShelves. */
    public UnaryCallSettings.Builder<MergeShelvesRequest, Shelf> mergeShelvesSettings() {
      return getStubSettingsBuilder().mergeShelvesSettings();
    }

    /** Returns the builder for the settings used for calls to createBook. */
    public UnaryCallSettings.Builder<CreateBookRequest, Book> createBookSettings() {
      return getStubSettingsBuilder().createBookSettings();
    }

    /** Returns the builder for the settings used for calls to getBook. */
    public UnaryCallSettings.Builder<GetBookRequest, Book> getBookSettings() {
      return getStubSettingsBuilder().getBookSettings();
    }

    /** Returns the builder for the settings used for calls to listBooks. */
    public PagedCallSettings.Builder<ListBooksRequest, ListBooksResponse, ListBooksPagedResponse>
        listBooksSettings() {
      return getStubSettingsBuilder().listBooksSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBook. */
    public UnaryCallSettings.Builder<DeleteBookRequest, Empty> deleteBookSettings() {
      return getStubSettingsBuilder().deleteBookSettings();
    }

    /** Returns the builder for the settings used for calls to updateBook. */
    public UnaryCallSettings.Builder<UpdateBookRequest, Book> updateBookSettings() {
      return getStubSettingsBuilder().updateBookSettings();
    }

    /** Returns the builder for the settings used for calls to moveBook. */
    public UnaryCallSettings.Builder<MoveBookRequest, Book> moveBookSettings() {
      return getStubSettingsBuilder().moveBookSettings();
    }

    @Override
    public LibraryServiceSettings build() throws IOException {
      return new LibraryServiceSettings(this);
    }
  }
}
