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

import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartNamingStrategy;
import com.google.cloud.storage.StorageOptions;
import com.google.common.base.MoreObjects;
import java.util.Objects;

/**
 * Configuration for an instance of {@link TransferManager}
 *
 * @see Builder
 */
public final class TransferManagerConfig {
  private final int maxWorkers;
  private final int perWorkerBufferSize;
  private final boolean allowDivideAndConquerDownload;
  private final boolean allowParallelCompositeUpload;

  private final PartNamingStrategy partNamingStrategy;

  private final StorageOptions storageOptions;

  TransferManagerConfig(
      int maxWorkers,
      int perWorkerBufferSize,
      boolean allowDivideAndConquerDownload,
      boolean allowParallelCompositeUpload,
      PartNamingStrategy partNamingStrategy,
      StorageOptions storageOptions) {
    this.maxWorkers = maxWorkers;
    this.perWorkerBufferSize = perWorkerBufferSize;
    this.allowDivideAndConquerDownload = allowDivideAndConquerDownload;
    this.allowParallelCompositeUpload = allowParallelCompositeUpload;
    this.partNamingStrategy = partNamingStrategy;
    this.storageOptions = storageOptions;
  }

  /**
   * Maximum amount of workers to be allocated to perform work in Transfer Manager
   *
   * @see Builder#setMaxWorkers(int)
   */
  public int getMaxWorkers() {
    return maxWorkers;
  }

  /**
   * Buffer size allowed to each worker
   *
   * @see Builder#setPerWorkerBufferSize(int)
   */
  public int getPerWorkerBufferSize() {
    return perWorkerBufferSize;
  }

  /**
   * Whether to allow Transfer Manager to perform chunked Uploads/Downloads if it determines
   * chunking will be beneficial
   *
   * @see Builder#setAllowDivideAndConquerDownload(boolean)
   */
  public boolean isAllowDivideAndConquerDownload() {
    return allowDivideAndConquerDownload;
  }

  /**
   * Whether to allow Transfer Manager to perform Parallel Composite Uploads if it determines
   * chunking will be beneficial
   *
   * @see Builder#setAllowParallelCompositeUpload(boolean)
   *     <p>Note: Performing parallel composite uploads costs more money. <a
   *     href="https://cloud.google.com/storage/pricing#operations-by-class">Class A</a> operations
   *     are performed to create each part and to perform each compose. If a storage tier other than
   *     <a href="https://cloud.google.com/storage/docs/storage-classes"><code>STANDARD</code></a>
   *     is used, early deletion fees apply to deletion of the parts.
   *     <p>Please see the <a
   *     href="https://cloud.google.com/storage/docs/parallel-composite-uploads">Parallel composite
   *     uploads</a> documentation for a more in depth explanation of the limitations of Parallel
   *     composite uploads.
   */
  public boolean isAllowParallelCompositeUpload() {
    return allowParallelCompositeUpload;
  }

  /**
   * Storage options that Transfer Manager will use to interact with Google Cloud Storage
   *
   * @see Builder#setStorageOptions(StorageOptions)
   */
  public StorageOptions getStorageOptions() {
    return storageOptions;
  }

  /**
   * Part Naming Strategy to be used during Parallel Composite Uploads
   *
   * @see Builder#setParallelCompositeUploadPartNamingStrategy(PartNamingStrategy)
   */
  public PartNamingStrategy getParallelCompositeUploadPartNamingStrategy() {
    return partNamingStrategy;
  }

  /** The service object for {@link TransferManager} */
  public TransferManager getService() {
    return new TransferManagerImpl(this, DefaultQos.of(this));
  }

  public Builder toBuilder() {
    return new Builder()
        .setAllowDivideAndConquerDownload(allowDivideAndConquerDownload)
        .setAllowParallelCompositeUpload(allowParallelCompositeUpload)
        .setMaxWorkers(maxWorkers)
        .setPerWorkerBufferSize(perWorkerBufferSize)
        .setStorageOptions(storageOptions);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TransferManagerConfig)) {
      return false;
    }
    TransferManagerConfig that = (TransferManagerConfig) o;
    return maxWorkers == that.maxWorkers
        && perWorkerBufferSize == that.perWorkerBufferSize
        && allowDivideAndConquerDownload == that.allowDivideAndConquerDownload
        && allowParallelCompositeUpload == that.allowParallelCompositeUpload
        && Objects.equals(storageOptions, that.storageOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        maxWorkers,
        perWorkerBufferSize,
        allowDivideAndConquerDownload,
        allowParallelCompositeUpload,
        storageOptions);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("maxWorkers", maxWorkers)
        .add("perWorkerBufferSize", perWorkerBufferSize)
        .add("allowDivideAndConquerDownload", allowDivideAndConquerDownload)
        .add("allowParallelCompositeUpload", allowParallelCompositeUpload)
        .add("storageOptions", storageOptions)
        .toString();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Builds an instance of TransferManagerConfig
   *
   * @see TransferManagerConfig
   */
  public static class Builder {

    private int maxWorkers;
    private int perWorkerBufferSize;
    private boolean allowDivideAndConquerDownload;
    private boolean allowParallelCompositeUpload;

    private StorageOptions storageOptions;
    private PartNamingStrategy partNamingStrategy;

    private Builder() {
      this.perWorkerBufferSize = 16 * 1024 * 1024;
      this.maxWorkers = 2 * Runtime.getRuntime().availableProcessors();
      this.allowDivideAndConquerDownload = false;
      this.allowParallelCompositeUpload = false;
      this.storageOptions = StorageOptions.getDefaultInstance();
      this.partNamingStrategy = PartNamingStrategy.noPrefix();
    }

    /**
     * Maximum amount of workers to be allocated to perform work in Transfer Manager
     *
     * <p><i>Default Value:</i> {@code 2 * }{@link Runtime#getRuntime()}{@code .}{@link
     * Runtime#availableProcessors() availableProcessors()}
     *
     * @return the instance of Builder with the value for maxWorkers modified.
     * @see TransferManagerConfig#getMaxWorkers()
     */
    public Builder setMaxWorkers(int maxWorkers) {
      this.maxWorkers = maxWorkers;
      return this;
    }

    /**
     * Buffer size allowed to each worker
     *
     * <p><i>Default Value:</i> 16MiB
     *
     * @return the instance of Builder with the value for maxWorkers modified.
     * @see TransferManagerConfig#getPerWorkerBufferSize()
     */
    public Builder setPerWorkerBufferSize(int perWorkerBufferSize) {
      this.perWorkerBufferSize = perWorkerBufferSize;
      return this;
    }

    /**
     * Whether to allow Transfer Manager to perform chunked Uploads/Downloads if it determines
     * chunking will be beneficial
     *
     * <p><i>Default Value:</i> false
     *
     * @return the instance of Builder with the value for allowDivideAndConquerDownload modified.
     * @see TransferManagerConfig#isAllowDivideAndConquerDownload()
     */
    public Builder setAllowDivideAndConquerDownload(boolean allowDivideAndConquerDownload) {
      this.allowDivideAndConquerDownload = allowDivideAndConquerDownload;
      return this;
    }

    /**
     * Whether to allow Transfer Manager to perform Parallel Composite Uploads if it determines
     * chunking will be beneficial
     *
     * <p><i>Default Value:</i> false
     *
     * @return the instance of Builder with the value for allowDivideAndConquerDownload modified.
     * @see TransferManagerConfig#isAllowDivideAndConquerDownload()
     */
    public Builder setAllowParallelCompositeUpload(boolean allowParallelCompositeUpload) {
      this.allowParallelCompositeUpload = allowParallelCompositeUpload;
      return this;
    }

    /**
     * Storage options that Transfer Manager will use to interact with Google Cloud Storage
     *
     * <p><i>Default Value:</i> {@link StorageOptions#getDefaultInstance()}
     *
     * @return the instance of Builder with the value for storageOptions modified.
     * @see TransferManagerConfig#getStorageOptions()
     */
    public Builder setStorageOptions(StorageOptions storageOptions) {
      this.storageOptions = storageOptions;
      return this;
    }

    /**
     * Part Naming Strategy that Transfer Manager will use during Parallel Composite Upload
     *
     * <p><i>Default Value:</i> {@link PartNamingStrategy#noPrefix()}
     *
     * @return the instance of Builder with the value for PartNamingStrategy modified.
     * @see TransferManagerConfig#getParallelCompositeUploadPartNamingStrategy()
     */
    public Builder setParallelCompositeUploadPartNamingStrategy(
        PartNamingStrategy partNamingStrategy) {
      checkNotNull(partNamingStrategy);
      this.partNamingStrategy = partNamingStrategy;
      return this;
    }

    /**
     * Creates a TransferManagerConfig object.
     *
     * @return {@link TransferManagerConfig}
     */
    public TransferManagerConfig build() {
      return new TransferManagerConfig(
          maxWorkers,
          perWorkerBufferSize,
          allowDivideAndConquerDownload,
          allowParallelCompositeUpload,
          partNamingStrategy,
          storageOptions);
    }
  }
}
