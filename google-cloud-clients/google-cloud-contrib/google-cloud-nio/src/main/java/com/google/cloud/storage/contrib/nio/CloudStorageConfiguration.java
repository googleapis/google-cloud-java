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

import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Configuration for {@link CloudStorageFileSystem} instances.
 */
@AutoValue
public abstract class CloudStorageConfiguration {

  public static final CloudStorageConfiguration DEFAULT = builder().build();

  /**
   * Returns path of current working directory. This defaults to the root directory.
   */
  public abstract String workingDirectory();

  /**
   * Returns {@code true} if we <i>shouldn't</i> throw an exception when encountering object names
   * containing superfluous slashes, e.g. {@code a//b}.
   */
  public abstract boolean permitEmptyPathComponents();

  /**
   * Returns {@code true} if '/' prefix on absolute object names should be removed before I/O.
   *
   * <p>If you disable this feature, please take into consideration that all paths created from a
   * URI will have the leading slash.
   */
  public abstract boolean stripPrefixSlash();

  /**
   * Returns {@code true} if paths with a trailing slash should be treated as fake directories.
   */
  public abstract boolean usePseudoDirectories();

  /**
   * Returns block size (in bytes) used when talking to the Google Cloud Storage HTTP server.
   */
  public abstract int blockSize();

  /**
   * Returns the number of times we try re-opening a channel if it's closed unexpectedly
   * while reading.
   */
  public abstract int maxChannelReopens();

  /**
   * Returns the project to be billed when accessing buckets. Leave empty for normal semantics,
   * set to bill that project (project you own) for all accesses. This is required for accessing
   * requester-pays buckets. This value cannot be null.
   */
  public abstract @Nullable String userProject();

  /**
   * Returns whether userProject will be cleared for non-requester-pays buckets. That is,
   * if false (the default value), setting userProject causes that project to be billed
   * regardless of whether the bucket is requester-pays or not. If true, setting
   * userProject will only cause that project to be billed when the project is requester-pays.
   *
   * Setting this will cause the bucket to be accessed when the CloudStorageFileSystem object
   * is created.
   */
  public abstract boolean useUserProjectOnlyForRequesterPaysBuckets();


  /**
   * Creates a new builder, initialized with the following settings:
   *
   * <ul>
   * <li>Performing I/O on paths with extra slashes, e.g. {@code a//b} will throw an error.
   * <li>The prefix slash on absolute paths will be removed when converting to an object name.
   * <li>Pseudo-directories are enabled, so any path with a trailing slash is a fake directory.
   * <li>Channel re-opens are disabled.
   * </ul>
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder for {@link CloudStorageConfiguration}.
   */
  public static final class Builder {

    private String workingDirectory = UnixPath.ROOT;
    private boolean permitEmptyPathComponents;
    private boolean stripPrefixSlash = true;
    private boolean usePseudoDirectories = true;
    private int blockSize = CloudStorageFileSystem.BLOCK_SIZE_DEFAULT;
    private int maxChannelReopens = 0;
    private @Nullable String userProject = null;
    // This of this as "clear userProject if not RequesterPays"
    private boolean useUserProjectOnlyForRequesterPaysBuckets = false;

    /**
     * Changes current working directory for new filesystem. This defaults to the root directory.
     * The working directory cannot be changed once it's been set. You'll need to create another
     * {@link CloudStorageFileSystem} object.
     *
     * @throws IllegalArgumentException if {@code path} is not absolute.
     */
    public Builder workingDirectory(String path) {
      checkNotNull(path);
      checkArgument(UnixPath.getPath(false, path).isAbsolute(), "not absolute: %s", path);
      workingDirectory = path;
      return this;
    }

    /**
     * Configures whether or not we should throw an exception when encountering object names
     * containing superfluous slashes, e.g. {@code a//b}.
     */
    public Builder permitEmptyPathComponents(boolean value) {
      permitEmptyPathComponents = value;
      return this;
    }

    /**
     * Configures if the '/' prefix on absolute object names should be removed before I/O.
     *
     * <p>If you disable this feature, please take into consideration that all paths created from a
     * URI will have the leading slash.
     */
    public Builder stripPrefixSlash(boolean value) {
      stripPrefixSlash = value;
      return this;
    }

    /**
     * Configures if paths with a trailing slash should be treated as fake directories.
     */
    public Builder usePseudoDirectories(boolean value) {
      usePseudoDirectories = value;
      return this;
    }

    /**
     * Sets the block size in bytes that should be used for each HTTP request to the API.
     *
     * <p>The default is {@value CloudStorageFileSystem#BLOCK_SIZE_DEFAULT}.
     */
    public Builder blockSize(int value) {
      blockSize = value;
      return this;
    }

    public Builder maxChannelReopens(int value) {
      maxChannelReopens = value;
      return this;
    }

    public Builder userProject(String value) {
      userProject = value;
      return this;
    }

    public Builder autoDetectRequesterPays(boolean value) {
      useUserProjectOnlyForRequesterPaysBuckets = value;
      return this;
    }

    /**
     * Creates new instance without destroying builder.
     */
    public CloudStorageConfiguration build() {
      return new AutoValue_CloudStorageConfiguration(
          workingDirectory,
          permitEmptyPathComponents,
          stripPrefixSlash,
          usePseudoDirectories,
          blockSize,
          maxChannelReopens,
          userProject,
          useUserProjectOnlyForRequesterPaysBuckets);
    }

    Builder(CloudStorageConfiguration toModify) {
      workingDirectory = toModify.workingDirectory();
      permitEmptyPathComponents = toModify.permitEmptyPathComponents();
      stripPrefixSlash = toModify.stripPrefixSlash();
      usePseudoDirectories = toModify.usePseudoDirectories();
      blockSize = toModify.blockSize();
      maxChannelReopens = toModify.maxChannelReopens();
      userProject = toModify.userProject();
      useUserProjectOnlyForRequesterPaysBuckets = toModify.useUserProjectOnlyForRequesterPaysBuckets();
    }

    Builder() {}
  }

  static CloudStorageConfiguration fromMap(Map<String, ?> env) {
    return fromMap(builder(), env);
  }

  static CloudStorageConfiguration fromMap(CloudStorageConfiguration defaultValues, Map<String, ?> env) {
    return fromMap(new Builder(defaultValues), env);
  }

  static private CloudStorageConfiguration fromMap(Builder builder, Map<String, ?> env) {
    for (Map.Entry<String, ?> entry : env.entrySet()) {
      switch (entry.getKey()) {
        case "workingDirectory":
          builder.workingDirectory((String) entry.getValue());
          break;
        case "permitEmptyPathComponents":
          builder.permitEmptyPathComponents((Boolean) entry.getValue());
          break;
        case "stripPrefixSlash":
          builder.stripPrefixSlash((Boolean) entry.getValue());
          break;
        case "usePseudoDirectories":
          builder.usePseudoDirectories((Boolean) entry.getValue());
          break;
        case "blockSize":
          builder.blockSize((Integer) entry.getValue());
          break;
        case "maxChannelReopens":
          builder.maxChannelReopens((Integer) entry.getValue());
          break;
        case "userProject":
          builder.userProject((String) entry.getValue());
          break;
        case "useUserProjectOnlyForRequesterPaysBuckets":
          builder.autoDetectRequesterPays((Boolean) entry.getValue());
          break;
        default:
          throw new IllegalArgumentException(entry.getKey());
      }
    }
    return builder.build();
  }

  CloudStorageConfiguration() {}
}
