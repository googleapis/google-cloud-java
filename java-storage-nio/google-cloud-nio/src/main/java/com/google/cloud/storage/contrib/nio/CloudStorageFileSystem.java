/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.storage.contrib.nio;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.requireNonNull;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.common.base.Strings;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.WatchService;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Google Cloud Storage {@link FileSystem} implementation.
 *
 * @see <a href="https://developers.google.com/storage/docs/concepts-techniques#concepts">Concepts
 *     and Terminology</a>
 * @see <a href="https://developers.google.com/storage/docs/bucketnaming">Bucket and Object Naming
 *     Guidelines</a>
 */
@ThreadSafe
public final class CloudStorageFileSystem extends FileSystem {

  public static final String URI_SCHEME = "gs";
  public static final String GCS_VIEW = "gcs";
  public static final String BASIC_VIEW = "basic";
  public static final String POSIX_VIEW = "posix";
  public static final int BLOCK_SIZE_DEFAULT = 2 * 1024 * 1024;
  public static final FileTime FILE_TIME_UNKNOWN = FileTime.fromMillis(0);
  public static final Set<String> SUPPORTED_VIEWS =
      ImmutableSet.of(BASIC_VIEW, GCS_VIEW, POSIX_VIEW);
  private final CloudStorageFileSystemProvider provider;
  private final String bucket;
  private final CloudStorageConfiguration config;
  private static final LoadingCache<ProviderCacheKey, CloudStorageFileSystemProvider>
      PROVIDER_CACHE_BY_CONFIG =
          CacheBuilder.newBuilder()
              .build(
                  new CacheLoader<ProviderCacheKey, CloudStorageFileSystemProvider>() {
                    @Override
                    public CloudStorageFileSystemProvider load(ProviderCacheKey key) {
                      CloudStorageConfiguration config = key.cloudStorageConfiguration;
                      StorageOptions storageOptions = key.storageOptions;
                      String userProject = config.userProject();
                      return (storageOptions == null)
                          ? new CloudStorageFileSystemProvider(userProject)
                          : new CloudStorageFileSystemProvider(userProject, storageOptions);
                    }
                  });

  // Don't call this one, call the one in CloudStorageFileSystemProvider.
  static void setDefaultCloudStorageConfiguration(CloudStorageConfiguration config) {
    CloudStorageConfiguration.setUserSpecifiedDefault(config);
  }

  static CloudStorageConfiguration getDefaultCloudStorageConfiguration() {
    return CloudStorageConfiguration.getUserSpecifiedDefault();
  }

  /**
   * Lists the project's buckets. Pass "null" to use the default project.
   *
   * <p>Example of listing buckets, specifying the page size and a name prefix.
   *
   * <pre>{@code
   * String prefix = "bucket_";
   * Page<Bucket> buckets = CloudStorageFileSystem.listBuckets("my-project", BucketListOption.prefix(prefix));
   * Iterator<Bucket> bucketIterator = buckets.iterateAll();
   * while (bucketIterator.hasNext()) {
   *   Bucket bucket = bucketIterator.next();
   *   // do something with the bucket
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  public static Page<Bucket> listBuckets(
      @Nullable String project, Storage.BucketListOption... options) {
    CloudStorageFileSystemProvider provider =
        new CloudStorageFileSystemProvider(
            null, StorageOptions.newBuilder().setProjectId(project).build());
    return provider.listBuckets(options);
  }

  /**
   * Returns Google Cloud Storage {@link FileSystem} object for {@code bucket}.
   *
   * <p><b>NOTE:</b> You may prefer to use Java's standard API instead:
   *
   * <pre>{@code
   * FileSystem fs = FileSystems.getFileSystem(URI.create("gs://bucket"));
   * }</pre>
   *
   * <p>However some systems and build environments might be flaky when it comes to Java SPI. This
   * is because services are generally runtime dependencies and depend on a META-INF file being
   * present in your jar (generated by Google Auto at compile-time). In such cases, this method
   * provides a simpler alternative.
   *
   * @see #forBucket(String, CloudStorageConfiguration)
   * @see java.nio.file.FileSystems#getFileSystem(java.net.URI)
   */
  @CheckReturnValue
  public static CloudStorageFileSystem forBucket(String bucket) {
    return forBucket(bucket, CloudStorageConfiguration.getUserSpecifiedDefault());
  }

  /**
   * Creates new file system instance for {@code bucket}, with customizable settings.
   *
   * @see #forBucket(String)
   */
  @CheckReturnValue
  public static CloudStorageFileSystem forBucket(String bucket, CloudStorageConfiguration config) {
    return forBucket(bucket, config, null);
  }

  /**
   * Returns Google Cloud Storage {@link FileSystem} object for {@code bucket}.
   *
   * <p>Google Cloud Storage file system objects are basically free. You can create as many as you
   * want, even if you have multiple instances for the same bucket. There's no actual system
   * resources associated with this object. Therefore calling {@link #close()} on the returned value
   * is optional.
   *
   * <p><b>Note:</b> It is also possible to instantiate this class via Java's {@code
   * FileSystems.getFileSystem(URI.create("gs://bucket"))}. We discourage you from using that if
   * possible, for the reasons documented in {@link
   * CloudStorageFileSystemProvider#newFileSystem(URI, java.util.Map)}
   *
   * @see java.nio.file.FileSystems#getFileSystem(URI)
   */
  @CheckReturnValue
  public static CloudStorageFileSystem forBucket(
      String bucket, CloudStorageConfiguration config, @Nullable StorageOptions storageOptions) {
    checkArgument(
        !bucket.startsWith(URI_SCHEME + ":"), "Bucket name must not have schema: %s", bucket);
    checkNotNull(config);
    CloudStorageFileSystemProvider result;
    ProviderCacheKey providerCacheKey = new ProviderCacheKey(config, storageOptions);
    try {
      result = PROVIDER_CACHE_BY_CONFIG.get(providerCacheKey);
    } catch (ExecutionException | UncheckedExecutionException e) {
      throw new IllegalStateException(
          "Unable to resolve CloudStorageFileSystemProvider for the provided configuration", e);
    }
    return new CloudStorageFileSystem(result, bucket, config);
  }

  CloudStorageFileSystem(
      CloudStorageFileSystemProvider provider, String bucket, CloudStorageConfiguration config) {
    checkArgument(!bucket.isEmpty(), "bucket");
    this.bucket = bucket;
    if (config.useUserProjectOnlyForRequesterPaysBuckets()) {
      if (Strings.isNullOrEmpty(config.userProject())) {
        throw new IllegalArgumentException(
            "If useUserProjectOnlyForRequesterPaysBuckets is set, then userProject must be set too.");
      }
      // detect whether we want to pay for these accesses or not.
      if (!provider.requesterPays(bucket)) {
        // update config (just to ease debugging, we're not actually using config.userProject later.
        HashMap<String, String> disableUserProject = new HashMap<>();
        disableUserProject.put("userProject", "");
        config = CloudStorageConfiguration.fromMap(config, disableUserProject);
        // update the provider (this is the most important bit)
        provider = provider.withNoUserProject();
      }
    }
    this.provider = provider;
    this.config = config;
  }

  @Override
  public CloudStorageFileSystemProvider provider() {
    return provider;
  }

  /** Returns Cloud Storage bucket name being served by this file system. */
  public String bucket() {
    return bucket;
  }

  /** Returns configuration object for this file system instance. */
  public CloudStorageConfiguration config() {
    return config;
  }

  /** Converts Cloud Storage object name to a {@link Path} object. */
  @Override
  public CloudStoragePath getPath(String first, String... more) {
    checkArgument(
        !first.startsWith(URI_SCHEME + ":"),
        "Google Cloud Storage FileSystem.getPath() must not have schema and bucket name: %s",
        first);
    return CloudStoragePath.getPath(this, first, more);
  }

  /**
   * Does nothing currently. This method <i>might</i> be updated in the future to close all channels
   * associated with this file system object. However it's unlikely that even then, calling this
   * method will become mandatory.
   */
  @Override
  public void close() throws IOException {
    // TODO(#809): Synchronously close all channels associated with this FileSystem instance.
  }

  /** Returns {@code true}, even if you previously called the {@link #close()} method. */
  @Override
  public boolean isOpen() {
    return true;
  }

  /** Returns {@code false}. */
  @Override
  public boolean isReadOnly() {
    return false;
  }

  /** Returns {@value UnixPath#SEPARATOR}. */
  @Override
  public String getSeparator() {
    return Character.toString(UnixPath.SEPARATOR);
  }

  @Override
  public Iterable<Path> getRootDirectories() {
    return ImmutableSet.<Path>of(CloudStoragePath.getPath(this, UnixPath.ROOT));
  }

  /**
   * Returns nothing because Google Cloud Storage doesn't have disk partitions of limited size, or
   * anything similar.
   */
  @Override
  public Iterable<FileStore> getFileStores() {
    return ImmutableSet.of();
  }

  @Override
  public Set<String> supportedFileAttributeViews() {
    return SUPPORTED_VIEWS;
  }

  @Override
  public PathMatcher getPathMatcher(String syntaxAndPattern) {
    return FileSystems.getDefault().getPathMatcher(syntaxAndPattern);
  }

  /**
   * Throws {@link UnsupportedOperationException} because this feature hasn't been implemented yet.
   */
  @Override
  public UserPrincipalLookupService getUserPrincipalLookupService() {
    // TODO: Implement me.
    throw new UnsupportedOperationException();
  }

  /**
   * Throws {@link UnsupportedOperationException} because this feature hasn't been implemented yet.
   */
  @Override
  public WatchService newWatchService() throws IOException {
    // TODO: Implement me.
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean equals(Object other) {
    return this == other
        || other instanceof CloudStorageFileSystem
            && Objects.equals(config, ((CloudStorageFileSystem) other).config)
            && Objects.equals(bucket, ((CloudStorageFileSystem) other).bucket);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucket);
  }

  @Override
  public String toString() {
    try {
      // Store GCS bucket name in the URI authority, see
      // https://github.com/googleapis/java-storage-nio/issues/1218
      return new URI(URI_SCHEME, bucket, null, null, null).toString();
    } catch (URISyntaxException e) {
      throw new AssertionError(e);
    }
  }

  /**
   * In order to cache a {@link CloudStorageFileSystemProvider} we track the config used to
   * instantiate that provider. This class creates an immutable key encapsulating the config to
   * allow reliable resolution from the cache.
   */
  private static final class ProviderCacheKey {
    private final CloudStorageConfiguration cloudStorageConfiguration;
    @Nullable private final StorageOptions storageOptions;

    public ProviderCacheKey(
        CloudStorageConfiguration cloudStorageConfiguration,
        @Nullable StorageOptions storageOptions) {
      this.cloudStorageConfiguration =
          requireNonNull(cloudStorageConfiguration, "cloudStorageConfiguration must be non null");
      this.storageOptions = storageOptions;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof ProviderCacheKey)) {
        return false;
      }
      ProviderCacheKey that = (ProviderCacheKey) o;
      return cloudStorageConfiguration.equals(that.cloudStorageConfiguration)
          && Objects.equals(storageOptions, that.storageOptions);
    }

    @Override
    public int hashCode() {
      return Objects.hash(cloudStorageConfiguration, storageOptions);
    }

    @Override
    public String toString() {
      return "ConfigTuple{"
          + "cloudStorageConfiguration="
          + cloudStorageConfiguration
          + ", storageOptions="
          + storageOptions
          + '}';
    }
  }
}
