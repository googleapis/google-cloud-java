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

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Configuration for performing Parallel Uploads with {@link TransferManager}.
 *
 * @see Builder
 */
public final class ParallelUploadConfig {

  private final boolean skipIfExists;
  @NonNull private final String bucketName;
  @NonNull private final UploadBlobInfoFactory uploadBlobInfoFactory;

  @NonNull private final List<BlobWriteOption> writeOptsPerRequest;

  private ParallelUploadConfig(
      boolean skipIfExists,
      @NonNull String bucketName,
      @NonNull UploadBlobInfoFactory uploadBlobInfoFactory,
      @NonNull List<BlobWriteOption> writeOptsPerRequest) {
    this.skipIfExists = skipIfExists;
    this.bucketName = bucketName;
    this.uploadBlobInfoFactory = uploadBlobInfoFactory;
    this.writeOptsPerRequest = applySkipIfExists(skipIfExists, writeOptsPerRequest);
  }

  /**
   * If set Transfer Manager will skip uploading an object if it already exists, equivalent to
   * providing {@link BlobWriteOption#doesNotExist()} in {@link #getWriteOptsPerRequest()}
   *
   * @see Builder#setSkipIfExists(boolean)
   */
  public boolean isSkipIfExists() {
    return skipIfExists;
  }

  /**
   * A common prefix that will be applied to all object paths in the destination bucket
   *
   * @see Builder#setPrefix(String)
   * @see Builder#setUploadBlobInfoFactory(UploadBlobInfoFactory)
   * @see UploadBlobInfoFactory#prefixObjectNames(String)
   */
  public @NonNull String getPrefix() {
    if (uploadBlobInfoFactory instanceof PrefixObjectNames) {
      PrefixObjectNames prefixObjectNames = (PrefixObjectNames) uploadBlobInfoFactory;
      return prefixObjectNames.prefix;
    }
    return "";
  }

  /**
   * The {@link UploadBlobInfoFactory} which will be used to produce a {@link BlobInfo}s based on a
   * provided bucket name and file name.
   *
   * @see Builder#setUploadBlobInfoFactory(UploadBlobInfoFactory)
   * @since 2.49.0
   */
  public @NonNull UploadBlobInfoFactory getUploadBlobInfoFactory() {
    return uploadBlobInfoFactory;
  }

  /**
   * The bucket objects are being uploaded from
   *
   * @see Builder#setBucketName(String)
   */
  public @NonNull String getBucketName() {
    return bucketName;
  }

  /**
   * A list of common BlobWriteOptions, note these options will be applied to each upload request.
   *
   * @see Builder#setWriteOptsPerRequest(List)
   */
  public @NonNull List<BlobWriteOption> getWriteOptsPerRequest() {
    return writeOptsPerRequest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParallelUploadConfig that = (ParallelUploadConfig) o;
    return skipIfExists == that.skipIfExists
        && bucketName.equals(that.bucketName)
        && uploadBlobInfoFactory.equals(that.uploadBlobInfoFactory)
        && writeOptsPerRequest.equals(that.writeOptsPerRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(skipIfExists, bucketName, uploadBlobInfoFactory, writeOptsPerRequest);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("skipIfExists", skipIfExists)
        .add("bucketName", bucketName)
        .add("uploadBlobInfoFactory", uploadBlobInfoFactory)
        .add("writeOptsPerRequest", writeOptsPerRequest)
        .toString();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  private static List<BlobWriteOption> applySkipIfExists(
      boolean skipIfExists, List<BlobWriteOption> writeOptsPerRequest) {
    if (skipIfExists) {
      return ImmutableList.copyOf(
          BlobWriteOption.dedupe(writeOptsPerRequest, BlobWriteOption.doesNotExist()));
    }
    return writeOptsPerRequest;
  }

  /**
   * Builds an instance of ParallelUploadConfig.
   *
   * @see ParallelUploadConfig
   */
  public static final class Builder {

    private boolean skipIfExists;
    private @NonNull String bucketName;
    private @NonNull UploadBlobInfoFactory uploadBlobInfoFactory;
    private @NonNull List<BlobWriteOption> writeOptsPerRequest;

    private Builder() {
      this.bucketName = "";
      this.uploadBlobInfoFactory = UploadBlobInfoFactory.defaultInstance();
      this.writeOptsPerRequest = ImmutableList.of();
    }

    /**
     * Sets the parameter for skipIfExists. When set to true Transfer Manager will skip uploading an
     * object if it already exists.
     *
     * @return the builder instance with the value for skipIfExists modified.
     * @see ParallelUploadConfig#isSkipIfExists()
     */
    public Builder setSkipIfExists(boolean skipIfExists) {
      this.skipIfExists = skipIfExists;
      return this;
    }

    /**
     * Sets a common prefix that will be applied to all object paths in the destination bucket.
     *
     * <p><i>NOTE</i>: this method and {@link #setUploadBlobInfoFactory(UploadBlobInfoFactory)} are
     * mutually exclusive, and last invocation "wins".
     *
     * @return the builder instance with the value for prefix modified.
     * @see ParallelUploadConfig#getPrefix()
     * @see ParallelUploadConfig.Builder#setUploadBlobInfoFactory(UploadBlobInfoFactory)
     * @see UploadBlobInfoFactory#prefixObjectNames(String)
     */
    public Builder setPrefix(@NonNull String prefix) {
      this.uploadBlobInfoFactory = UploadBlobInfoFactory.prefixObjectNames(prefix);
      return this;
    }

    /**
     * Sets a {@link UploadBlobInfoFactory} which can be used to produce a custom BlobInfo based on
     * a provided bucket name and file name.
     *
     * <p>The bucket name in the returned BlobInfo MUST be equal to the value provided to {@link
     * #setBucketName(String)}, if not that upload will fail with a {@link
     * TransferStatus#FAILED_TO_START} and a {@link BucketNameMismatchException}.
     *
     * <p><i>NOTE</i>: this method and {@link #setPrefix(String)} are mutually exclusive, and last
     * invocation "wins".
     *
     * @return the builder instance with the value for uploadBlobInfoFactory modified.
     * @see ParallelUploadConfig#getPrefix()
     * @see ParallelUploadConfig#getUploadBlobInfoFactory()
     * @since 2.49.0
     */
    public Builder setUploadBlobInfoFactory(@NonNull UploadBlobInfoFactory uploadBlobInfoFactory) {
      this.uploadBlobInfoFactory = uploadBlobInfoFactory;
      return this;
    }

    /**
     * Sets the bucketName that Transfer Manager will upload to. This field is required.
     *
     * @return the builder instance with the value for bucketName modified.
     * @see ParallelUploadConfig#getBucketName()
     */
    public Builder setBucketName(@NonNull String bucketName) {
      this.bucketName = bucketName;
      return this;
    }

    /**
     * Sets the BlobWriteOptions that will be applied to each upload request. Note these options
     * will be applied to every single upload request.
     *
     * @return the builder instance with the value for WriteOptsPerRequest modified.
     * @see ParallelUploadConfig#getWriteOptsPerRequest()
     */
    public Builder setWriteOptsPerRequest(@NonNull List<BlobWriteOption> writeOptsPerRequest) {
      this.writeOptsPerRequest = writeOptsPerRequest;
      return this;
    }

    /**
     * Creates a ParallelUploadConfig object.
     *
     * @return {@link ParallelUploadConfig}
     */
    public ParallelUploadConfig build() {
      checkNotNull(bucketName);
      checkNotNull(uploadBlobInfoFactory);
      checkNotNull(writeOptsPerRequest);
      return new ParallelUploadConfig(
          skipIfExists, bucketName, uploadBlobInfoFactory, writeOptsPerRequest);
    }
  }

  public interface UploadBlobInfoFactory {

    /**
     * Method to produce a {@link BlobInfo} to be used for the upload to Cloud Storage.
     *
     * <p>The bucket name in the returned BlobInfo MUST be equal to the value provided to the {@link
     * ParallelUploadConfig.Builder#setBucketName(String)}, if not that upload will fail with a
     * {@link TransferStatus#FAILED_TO_START} and a {@link BucketNameMismatchException}.
     *
     * @param bucketName The name of the bucket to be uploaded to. The value provided here will be
     *     the value from {@link ParallelUploadConfig#getBucketName()}.
     * @param fileName The String representation of the absolute path of the file to be uploaded
     * @return The instance of {@link BlobInfo} that should be used to upload the file to Cloud
     *     Storage.
     */
    BlobInfo apply(String bucketName, String fileName);

    /**
     * Adapter factory to provide the same semantics as if using {@link Builder#setPrefix(String)}
     */
    static UploadBlobInfoFactory prefixObjectNames(String prefix) {
      return new PrefixObjectNames(prefix);
    }

    /** The default instance which applies not modification to the provided {@code fileName} */
    static UploadBlobInfoFactory defaultInstance() {
      return DefaultUploadBlobInfoFactory.INSTANCE;
    }

    /**
     * Convenience method to "lift" a {@link Function} that transforms the file name to an {@link
     * UploadBlobInfoFactory}
     */
    static UploadBlobInfoFactory transformFileName(Function<String, String> fileNameTransformer) {
      return (b, f) -> BlobInfo.newBuilder(b, fileNameTransformer.apply(f)).build();
    }
  }

  private static final class DefaultUploadBlobInfoFactory implements UploadBlobInfoFactory {
    private static final DefaultUploadBlobInfoFactory INSTANCE = new DefaultUploadBlobInfoFactory();

    private DefaultUploadBlobInfoFactory() {}

    @Override
    public BlobInfo apply(String bucketName, String fileName) {
      return BlobInfo.newBuilder(bucketName, fileName).build();
    }
  }

  private static final class PrefixObjectNames implements UploadBlobInfoFactory {
    private final String prefix;

    private PrefixObjectNames(String prefix) {
      this.prefix = prefix;
    }

    @Override
    public BlobInfo apply(String bucketName, String fileName) {
      String separator = "";
      if (!fileName.startsWith("/")) {
        separator = "/";
      }
      return BlobInfo.newBuilder(bucketName, prefix + separator + fileName).build();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof PrefixObjectNames)) {
        return false;
      }
      PrefixObjectNames that = (PrefixObjectNames) o;
      return Objects.equals(prefix, that.prefix);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(prefix);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("prefix", prefix).toString();
    }
  }
}
