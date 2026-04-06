/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage.transfermanager;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Configuration for performing Parallel Downloads with {@link TransferManager}.
 *
 * @see Builder
 */
public final class ParallelDownloadConfig {

  @NonNull private final String stripPrefix;
  @NonNull private final Path downloadDirectory;
  @NonNull private final String bucketName;
  @NonNull private final List<BlobSourceOption> optionsPerRequest;

  private ParallelDownloadConfig(
      @NonNull String stripPrefix,
      @NonNull Path downloadDirectory,
      @NonNull String bucketName,
      @NonNull List<BlobSourceOption> optionsPerRequest) {
    this.stripPrefix = stripPrefix;
    this.downloadDirectory = downloadDirectory;
    this.bucketName = bucketName;
    this.optionsPerRequest = optionsPerRequest;
  }

  /**
   * A common prefix removed from an object's name before being written to the filesystem.
   *
   * @see Builder#setStripPrefix(String)
   */
  public @NonNull String getStripPrefix() {
    return stripPrefix;
  }

  /**
   * The base directory in which all objects will be placed when downloaded.
   *
   * @see Builder#setDownloadDirectory(Path)
   */
  public @NonNull Path getDownloadDirectory() {
    return downloadDirectory;
  }

  /**
   * The bucket objects are being downloaded from.
   *
   * @see Builder#setBucketName(String)
   */
  public @NonNull String getBucketName() {
    return bucketName;
  }

  /**
   * A list of common BlobSourceOptions that are used for each download request. Note this list of
   * options will be applied to every single request.
   *
   * @see Builder#setOptionsPerRequest(List)
   */
  public @NonNull List<BlobSourceOption> getOptionsPerRequest() {
    return optionsPerRequest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ParallelDownloadConfig)) {
      return false;
    }
    ParallelDownloadConfig that = (ParallelDownloadConfig) o;
    return stripPrefix.equals(that.stripPrefix)
        && downloadDirectory.equals(that.downloadDirectory)
        && bucketName.equals(that.bucketName)
        && optionsPerRequest.equals(that.optionsPerRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stripPrefix, downloadDirectory, bucketName, optionsPerRequest);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("stripPrefix", stripPrefix)
        .add("downloadDirectory", downloadDirectory)
        .add("bucketName", bucketName)
        .add("optionsPerRequest", optionsPerRequest)
        .toString();
  }

  /**
   * Builds an instance of ParallelDownloadConfig.
   *
   * @see ParallelDownloadConfig
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    @NonNull private String stripPrefix;
    @NonNull private Path downloadDirectory;
    @NonNull private String bucketName;
    @NonNull private List<BlobSourceOption> optionsPerRequest;

    private Builder() {
      this.stripPrefix = "";
      this.downloadDirectory = Paths.get("");
      this.bucketName = "";
      this.optionsPerRequest = ImmutableList.of();
    }

    /**
     * Sets the value for stripPrefix. This string will be removed from the beginning of all object
     * names before they are written to the filesystem.
     *
     * @return the builder instance with the value for stripPrefix modified.
     * @see ParallelDownloadConfig#getStripPrefix()
     */
    public Builder setStripPrefix(String stripPrefix) {
      this.stripPrefix = stripPrefix;
      return this;
    }

    /**
     * Sets the base directory on the filesystem that all objects will be written to.
     *
     * @return the builder instance with the value for downloadDirectory modified.
     * @see ParallelDownloadConfig#getDownloadDirectory()
     */
    public Builder setDownloadDirectory(Path downloadDirectory) {
      this.downloadDirectory = downloadDirectory.toAbsolutePath().normalize();
      return this;
    }

    /**
     * Sets the bucketName that Transfer Manager will download from. This field is required.
     *
     * @return the builder instance with the value for bucketName modified.
     * @see ParallelDownloadConfig#getBucketName()
     */
    public Builder setBucketName(String bucketName) {
      this.bucketName = bucketName;
      return this;
    }

    /**
     * Sets the BlobSourceOptions that will be applied to each download request. Note these options
     * will be applied to every single download request.
     *
     * @return the builder instance with the value for OptionsPerRequest modified.
     * @see ParallelDownloadConfig#getOptionsPerRequest()
     */
    public Builder setOptionsPerRequest(List<BlobSourceOption> optionsPerRequest) {
      this.optionsPerRequest = ImmutableList.copyOf(optionsPerRequest);
      return this;
    }

    /**
     * Creates a ParallelDownloadConfig object.
     *
     * @return {@link ParallelDownloadConfig}
     */
    public ParallelDownloadConfig build() {
      checkNotNull(bucketName);
      checkNotNull(stripPrefix);
      checkNotNull(downloadDirectory);
      checkNotNull(optionsPerRequest);
      return new ParallelDownloadConfig(
          stripPrefix, downloadDirectory, bucketName, optionsPerRequest);
    }
  }
}
