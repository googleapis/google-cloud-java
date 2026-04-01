/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.auth.ServiceAccountSigner;
import com.google.auth.ServiceAccountSigner.SigningException;
import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.ObjectOptExtractor;
import com.google.cloud.storage.UnifiedOpts.ObjectSourceOpt;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.security.Key;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * An object in Google Cloud Storage. A {@code Blob} object includes the {@code BlobId} instance,
 * the set of properties inherited from the {@link BlobInfo} class and the {@code Storage} instance.
 * The class provides methods to perform operations on the object. Reading a property value does not
 * issue any RPC calls. The object content is not stored within the {@code Blob} instance.
 * Operations that access the content issue one or multiple RPC calls, depending on the content
 * size.
 *
 * <p>Objects of this class are immutable. Operations that modify the blob like {@link #update} and
 * {@link #copyTo} return a new object. Any changes to the object in Google Cloud Storage made after
 * creation of the {@code Blob} are not visible in the {@code Blob}. To get a {@code Blob} object
 * with the most recent information use {@link #reload}.
 *
 * <p>Example of getting the content of the object in Google Cloud Storage:
 *
 * <pre>{@code
 * BlobId blobId = BlobId.of(bucketName, blobName);
 * Blob blob = storage.get(blobId);
 * long size = blob.getSize(); // no RPC call is required
 * byte[] content = blob.getContent(); // one or multiple RPC calls will be issued
 * }</pre>
 */
@TransportCompatibility({Transport.HTTP, Transport.GRPC})
public class Blob extends BlobInfo {

  private static final long serialVersionUID = 5007541696912440917L;

  private final StorageOptions options;
  private transient Storage storage;

  /** Class for specifying blob source options when {@code Blob} methods are used. */
  public static class BlobSourceOption extends Option<ObjectSourceOpt> {

    private static final long serialVersionUID = 8205000496563385634L;

    private BlobSourceOption(ObjectSourceOpt opt) {
      super(opt);
    }

    /**
     * Returns an option for blob's generation match. If this option is used the request will fail
     * if generation does not match.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption generationMatch() {
      return new BlobSourceOption(UnifiedOpts.generationMatchExtractor());
    }

    /**
     * Returns an option for blob's generation mismatch. If this option is used the request will
     * fail if generation matches.
     *
     * @deprecated This option is invalid, and can never result in a valid response from the server.
     */
    @Deprecated
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption generationNotMatch() {
      return new BlobSourceOption(UnifiedOpts.generationNotMatchExtractor());
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption metagenerationMatch() {
      return new BlobSourceOption(UnifiedOpts.metagenerationMatchExtractor());
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if metageneration matches.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption metagenerationNotMatch() {
      return new BlobSourceOption(UnifiedOpts.metagenerationNotMatchExtractor());
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption decryptionKey(@NonNull Key key) {
      return new BlobSourceOption(UnifiedOpts.decryptionKey(key));
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     *
     * @param key the AES256 encoded in base64
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption decryptionKey(@NonNull String key) {
      return new BlobSourceOption(UnifiedOpts.decryptionKey(key));
    }

    /**
     * Returns an option for blob's billing user project. This option is used only if the blob's
     * bucket has requester_pays flag enabled.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption userProject(@NonNull String userProject) {
      return new BlobSourceOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option for whether the request should return the raw input stream, instead of
     * automatically decompressing the content. By default, this is false for Blob.downloadTo(), but
     * true for ReadChannel.read().
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption shouldReturnRawInputStream(boolean shouldReturnRawInputStream) {
      return new BlobSourceOption(UnifiedOpts.returnRawInputStream(shouldReturnRawInputStream));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BlobSourceOption[] dedupe(BlobSourceOption... os) {
      return Option.dedupe(BlobSourceOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobSourceOption[] dedupe(
        Collection<BlobSourceOption> collection, BlobSourceOption... os) {
      return Option.dedupe(BlobSourceOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobSourceOption[] dedupe(BlobSourceOption[] array, BlobSourceOption... os) {
      return Option.dedupe(BlobSourceOption[]::new, array, os);
    }

    static Storage.BlobSourceOption[] toSourceOptions(
        BlobInfo blobInfo, BlobSourceOption... options) {
      Storage.BlobSourceOption[] convertedOptions = new Storage.BlobSourceOption[options.length];
      for (int i = 0; i < options.length; i++) {
        ObjectSourceOpt opt = options[i].getOpt();
        if (opt instanceof ObjectOptExtractor) {
          ObjectOptExtractor<ObjectSourceOpt> ex = (ObjectOptExtractor<ObjectSourceOpt>) opt;
          ObjectSourceOpt objectSourceOpt = ex.extractFromBlobInfo(blobInfo);
          convertedOptions[i] = new Storage.BlobSourceOption(objectSourceOpt);
        } else {
          convertedOptions[i] = new Storage.BlobSourceOption(opt);
        }
      }
      return convertedOptions;
    }

    static Storage.BlobGetOption[] toGetOptions(BlobInfo blobInfo, BlobSourceOption... options) {
      Storage.BlobGetOption[] convertedOptions = new Storage.BlobGetOption[options.length];
      for (int i = 0; i < options.length; i++) {
        ObjectSourceOpt opt = options[i].getOpt();
        if (opt instanceof ObjectOptExtractor) {
          ObjectOptExtractor<ObjectSourceOpt> ex = (ObjectOptExtractor<ObjectSourceOpt>) opt;
          ObjectSourceOpt objectSourceOpt = ex.extractFromBlobInfo(blobInfo);
          convertedOptions[i] = new BlobGetOption(objectSourceOpt);
        } else {
          convertedOptions[i] = new BlobGetOption(options[i].getOpt());
        }
      }
      return convertedOptions;
    }
  }

  /**
   * Downloads this blob to the given file path using specified blob read options.
   *
   * @param path destination
   * @param options blob read options
   * @throws StorageException upon failure
   * @see Storage#downloadTo(BlobId, Path, Storage.BlobSourceOption...)
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public void downloadTo(Path path, BlobSourceOption... options) {
    // Don't use static imports of BlobSourceOption, it causes import resolution issues
    // with the new UnifiedOpts shim interfaces
    storage.downloadTo(this.getBlobId(), path, BlobSourceOption.toSourceOptions(this, options));
  }

  /**
   * Downloads this blob to the given output stream using specified blob read options.
   *
   * @param outputStream
   * @param options
   * @throws StorageException upon failure
   * @see Storage#downloadTo(BlobId, OutputStream, Storage.BlobSourceOption...)
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public void downloadTo(OutputStream outputStream, BlobSourceOption... options) {
    // Don't use static imports of BlobSourceOption, it causes import resolution issues
    // with the new UnifiedOpts shim interfaces
    storage.downloadTo(
        this.getBlobId(), outputStream, BlobSourceOption.toSourceOptions(this, options));
  }

  /**
   * Downloads this blob to the given file path.
   *
   * <p>This method is replaced with {@link #downloadTo(Path, BlobSourceOption...)}, but is kept
   * here for binary compatibility with the older versions of the client library.
   *
   * @param path destination
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public void downloadTo(Path path) {
    downloadTo(path, new BlobSourceOption[0]);
  }

  /** Builder for {@code Blob}. */
  public static class Builder extends BlobInfo.Builder {

    private final Storage storage;
    private final BlobInfo.BuilderImpl infoBuilder;

    Builder(Blob blob) {
      this.storage = blob.getStorage();
      this.infoBuilder = new BlobInfo.BuilderImpl(blob);
    }

    @Override
    public Builder setBlobId(BlobId blobId) {
      infoBuilder.setBlobId(blobId);
      return this;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      infoBuilder.setGeneratedId(generatedId);
      return this;
    }

    @Override
    public Builder setContentType(String contentType) {
      infoBuilder.setContentType(contentType);
      return this;
    }

    @Override
    public Builder setContentDisposition(String contentDisposition) {
      infoBuilder.setContentDisposition(contentDisposition);
      return this;
    }

    @Override
    public Builder setContentLanguage(String contentLanguage) {
      infoBuilder.setContentLanguage(contentLanguage);
      return this;
    }

    @Override
    public Builder setContentEncoding(String contentEncoding) {
      infoBuilder.setContentEncoding(contentEncoding);
      return this;
    }

    @Override
    Builder setComponentCount(Integer componentCount) {
      infoBuilder.setComponentCount(componentCount);
      return this;
    }

    @Override
    public Builder setCacheControl(String cacheControl) {
      infoBuilder.setCacheControl(cacheControl);
      return this;
    }

    @Override
    public Builder setAcl(List<Acl> acl) {
      infoBuilder.setAcl(acl);
      return this;
    }

    @Override
    Builder setOwner(Entity owner) {
      infoBuilder.setOwner(owner);
      return this;
    }

    @Override
    Builder setSize(Long size) {
      infoBuilder.setSize(size);
      return this;
    }

    @Override
    Builder setEtag(String etag) {
      infoBuilder.setEtag(etag);
      return this;
    }

    @Override
    Builder setSelfLink(String selfLink) {
      infoBuilder.setSelfLink(selfLink);
      return this;
    }

    @Override
    public Builder setMd5(String md5) {
      infoBuilder.setMd5(md5);
      return this;
    }

    @Override
    public Builder setMd5FromHexString(String md5HexString) {
      infoBuilder.setMd5FromHexString(md5HexString);
      return this;
    }

    @Override
    public Builder setCrc32c(String crc32c) {
      infoBuilder.setCrc32c(crc32c);
      return this;
    }

    @Override
    public Builder setCrc32cFromHexString(String crc32cHexString) {
      infoBuilder.setCrc32cFromHexString(crc32cHexString);
      return this;
    }

    @Override
    Builder setMediaLink(String mediaLink) {
      infoBuilder.setMediaLink(mediaLink);
      return this;
    }

    @Override
    public Builder setMetadata(Map<String, String> metadata) {
      infoBuilder.setMetadata(metadata);
      return this;
    }

    @Override
    public Builder setStorageClass(StorageClass storageClass) {
      infoBuilder.setStorageClass(storageClass);
      return this;
    }

    /**
     * @deprecated Use {@link #setTimeStorageClassUpdatedOffsetDateTime(OffsetDateTime)}
     */
    @Override
    @Deprecated
    public Builder setTimeStorageClassUpdated(Long timeStorageClassUpdated) {
      infoBuilder.setTimeStorageClassUpdated(timeStorageClassUpdated);
      return this;
    }

    @Override
    public BlobInfo.Builder setTimeStorageClassUpdatedOffsetDateTime(
        OffsetDateTime timeStorageClassUpdated) {
      infoBuilder.setTimeStorageClassUpdatedOffsetDateTime(timeStorageClassUpdated);
      return this;
    }

    @Override
    Builder setMetageneration(Long metageneration) {
      infoBuilder.setMetageneration(metageneration);
      return this;
    }

    /**
     * @deprecated Use {@link #setDeleteTimeOffsetDateTime(OffsetDateTime)}
     */
    @Override
    @Deprecated
    Builder setDeleteTime(Long deleteTime) {
      infoBuilder.setDeleteTime(deleteTime);
      return this;
    }

    @Override
    BlobInfo.Builder setDeleteTimeOffsetDateTime(OffsetDateTime deleteTime) {
      infoBuilder.setDeleteTimeOffsetDateTime(deleteTime);
      return this;
    }

    /**
     * @deprecated Use {@link #setUpdateTimeOffsetDateTime(OffsetDateTime)}
     */
    @Override
    @Deprecated
    Builder setUpdateTime(Long updateTime) {
      infoBuilder.setUpdateTime(updateTime);
      return this;
    }

    @Override
    BlobInfo.Builder setUpdateTimeOffsetDateTime(OffsetDateTime updateTime) {
      infoBuilder.setUpdateTimeOffsetDateTime(updateTime);
      return this;
    }

    @Override
    @Deprecated
    Builder setCreateTime(Long createTime) {
      infoBuilder.setCreateTime(createTime);
      return this;
    }

    @Override
    BlobInfo.Builder setCreateTimeOffsetDateTime(OffsetDateTime createTime) {
      infoBuilder.setCreateTimeOffsetDateTime(createTime);
      return this;
    }

    /**
     * @deprecated Use {@link #setCustomTimeOffsetDateTime(OffsetDateTime)}
     */
    @Override
    @Deprecated
    public Builder setCustomTime(Long customTime) {
      infoBuilder.setCustomTime(customTime);
      return this;
    }

    @Override
    public BlobInfo.Builder setCustomTimeOffsetDateTime(OffsetDateTime customTime) {
      infoBuilder.setCustomTimeOffsetDateTime(customTime);
      return this;
    }

    @Override
    Builder setIsDirectory(boolean isDirectory) {
      infoBuilder.setIsDirectory(isDirectory);
      return this;
    }

    @Override
    Builder setCustomerEncryption(CustomerEncryption customerEncryption) {
      infoBuilder.setCustomerEncryption(customerEncryption);
      return this;
    }

    @Override
    Builder setKmsKeyName(String kmsKeyName) {
      infoBuilder.setKmsKeyName(kmsKeyName);
      return this;
    }

    @Override
    public Builder setEventBasedHold(Boolean eventBasedHold) {
      infoBuilder.setEventBasedHold(eventBasedHold);
      return this;
    }

    @Override
    public Builder setTemporaryHold(Boolean temporaryHold) {
      infoBuilder.setTemporaryHold(temporaryHold);
      return this;
    }

    /**
     * @deprecated Use {@link #setRetentionExpirationTimeOffsetDateTime(OffsetDateTime)}
     */
    @Override
    @Deprecated
    Builder setRetentionExpirationTime(Long retentionExpirationTime) {
      infoBuilder.setRetentionExpirationTime(retentionExpirationTime);
      return this;
    }

    @Override
    Builder setRetentionExpirationTimeOffsetDateTime(OffsetDateTime retentionExpirationTime) {
      infoBuilder.setRetentionExpirationTimeOffsetDateTime(retentionExpirationTime);
      return this;
    }

    @Override
    Builder setSoftDeleteTime(OffsetDateTime softDeleteTime) {
      infoBuilder.setSoftDeleteTime(softDeleteTime);
      return this;
    }

    @Override
    Builder setHardDeleteTime(OffsetDateTime hardDeleteTime) {
      infoBuilder.setHardDeleteTime(hardDeleteTime);
      return this;
    }

    @Override
    public Builder setRetention(Retention retention) {
      infoBuilder.setRetention(retention);
      return this;
    }

    @Override
    public Builder setContexts(ObjectContexts contexts) {
      infoBuilder.setContexts(contexts);
      return this;
    }

    @Override
    public Blob build() {
      return new Blob(storage, infoBuilder);
    }

    @Override
    BlobId getBlobId() {
      return infoBuilder.getBlobId();
    }

    @Override
    Builder clearBlobId() {
      infoBuilder.clearBlobId();
      return this;
    }

    @Override
    Builder clearGeneratedId() {
      infoBuilder.clearGeneratedId();
      return this;
    }

    @Override
    Builder clearContentType() {
      infoBuilder.clearContentType();
      return this;
    }

    @Override
    Builder clearContentEncoding() {
      infoBuilder.clearContentEncoding();
      return this;
    }

    @Override
    Builder clearContentDisposition() {
      infoBuilder.clearContentDisposition();
      return this;
    }

    @Override
    Builder clearContentLanguage() {
      infoBuilder.clearContentLanguage();
      return this;
    }

    @Override
    Builder clearComponentCount() {
      infoBuilder.clearComponentCount();
      return this;
    }

    @Override
    Builder clearCacheControl() {
      infoBuilder.clearCacheControl();
      return this;
    }

    @Override
    Builder clearAcl() {
      infoBuilder.clearAcl();
      return this;
    }

    @Override
    Builder clearOwner() {
      infoBuilder.clearOwner();
      return this;
    }

    @Override
    Builder clearSize() {
      infoBuilder.clearSize();
      return this;
    }

    @Override
    Builder clearEtag() {
      infoBuilder.clearEtag();
      return this;
    }

    @Override
    Builder clearSelfLink() {
      infoBuilder.clearSelfLink();
      return this;
    }

    @Override
    Builder clearMd5() {
      infoBuilder.clearMd5();
      return this;
    }

    @Override
    Builder clearCrc32c() {
      infoBuilder.clearCrc32c();
      return this;
    }

    @Override
    Builder clearCustomTime() {
      infoBuilder.clearCustomTime();
      return this;
    }

    @Override
    Builder clearMediaLink() {
      infoBuilder.clearMediaLink();
      return this;
    }

    @Override
    Builder clearMetadata() {
      infoBuilder.clearMetadata();
      return this;
    }

    @Override
    Builder clearMetageneration() {
      infoBuilder.clearMetageneration();
      return this;
    }

    @Override
    Builder clearDeleteTime() {
      infoBuilder.clearDeleteTime();
      return this;
    }

    @Override
    Builder clearUpdateTime() {
      infoBuilder.clearUpdateTime();
      return this;
    }

    @Override
    Builder clearCreateTime() {
      infoBuilder.clearCreateTime();
      return this;
    }

    @Override
    Builder clearIsDirectory() {
      infoBuilder.clearIsDirectory();
      return this;
    }

    @Override
    Builder clearCustomerEncryption() {
      infoBuilder.clearCustomerEncryption();
      return this;
    }

    @Override
    Builder clearStorageClass() {
      infoBuilder.clearStorageClass();
      return this;
    }

    @Override
    Builder clearTimeStorageClassUpdated() {
      infoBuilder.clearTimeStorageClassUpdated();
      return this;
    }

    @Override
    Builder clearKmsKeyName() {
      infoBuilder.clearKmsKeyName();
      return this;
    }

    @Override
    Builder clearEventBasedHold() {
      infoBuilder.clearEventBasedHold();
      return this;
    }

    @Override
    Builder clearTemporaryHold() {
      infoBuilder.clearTemporaryHold();
      return this;
    }

    @Override
    Builder clearRetentionExpirationTime() {
      infoBuilder.clearRetentionExpirationTime();
      return this;
    }

    @Override
    Builder clearContexts() {
      infoBuilder.clearContexts();
      return this;
    }
  }

  Blob(Storage storage, BlobInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.storage = checkNotNull(storage);
    this.options = storage.getOptions();
  }

  /**
   * Checks if this blob exists.
   *
   * <p>Example of checking if the blob exists.
   *
   * <pre>{@code
   * boolean exists = blob.exists();
   * if (exists) {
   *   // the blob exists
   * } else {
   *   // the blob was not found
   * }
   * }</pre>
   *
   * @param options blob read options
   * @return true if this blob exists, false otherwise
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public boolean exists(BlobSourceOption... options) {
    int length = options.length;
    // Don't use static imports of BlobSourceOption, it causes import resolution issues
    // with the new UnifiedOpts shim interfaces
    Storage.BlobGetOption[] getOptions =
        Arrays.copyOf(BlobSourceOption.toGetOptions(this, options), length + 1);
    getOptions[length] = Storage.BlobGetOption.fields();
    return storage.get(getBlobId(), getOptions) != null;
  }

  /**
   * Returns this blob's content.
   *
   * <p>Example of reading all bytes of the blob, if its generation matches the {@link
   * Blob#getGeneration()} value, otherwise a {@link StorageException} is thrown.
   *
   * <pre>{@code
   * byte[] content = blob.getContent(BlobSourceOption.generationMatch());
   * }</pre>
   *
   * @param options blob read options
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public byte[] getContent(BlobSourceOption... options) {
    // Don't use static imports of BlobSourceOption, it causes import resolution issues
    // with the new UnifiedOpts shim interfaces
    return storage.readAllBytes(getBlobId(), BlobSourceOption.toSourceOptions(this, options));
  }

  /**
   * Fetches the latest blob properties. Returns {@code null} if the blob no longer exists.
   *
   * <p>{@code options} parameter can contain the preconditions. For example, the user might want to
   * get the blob properties only if the content has not been updated externally. {@code
   * StorageException} with the code {@code 412} is thrown if preconditions fail.
   *
   * <p>Example of retrieving the blob's latest information only if the content is not updated
   * externally:
   *
   * <pre>{@code
   * Blob blob = storage.get(BlobId.of(bucketName, blobName));
   *
   * doSomething();
   *
   * try {
   *   blob = blob.reload(Blob.BlobSourceOption.generationMatch());
   * } catch (StorageException e) {
   *   if (e.getCode() == 412) {
   *     // the content was updated externally
   *   } else {
   *     throw e;
   *   }
   * }
   * }</pre>
   *
   * @param options preconditions to use on reload, see <a
   *     href="https://cloud.google.com/storage/docs/json_api/v1/objects/get">https://cloud.google.com/storage/docs/json_api/v1/objects/get</a>
   *     for more information.
   * @return a {@code Blob} object with latest information or {@code null} if no longer exists.
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Blob reload(BlobSourceOption... options) {
    // BlobId with generation unset is needed to retrieve the latest version of the Blob
    BlobId idWithoutGeneration = BlobId.of(getBucket(), getName());
    // Don't use static imports of BlobSourceOption, it causes import resolution issues
    // with the new UnifiedOpts shim interfaces
    return storage.get(idWithoutGeneration, BlobSourceOption.toGetOptions(this, options));
  }

  /**
   * Updates the blob properties. The {@code options} parameter contains the preconditions for
   * applying the update. To update the properties call {@link #toBuilder()}, set the properties you
   * want to change, build the new {@code Blob} instance, and then call {@link
   * #update(BlobTargetOption...)}.
   *
   * <p>The property update details are described in {@link Storage#update(BlobInfo)}. {@link
   * Storage#update(BlobInfo, BlobTargetOption...)} describes how to specify preconditions.
   *
   * <p>Example of updating the content type:
   *
   * <pre>{@code
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * Blob blob = storage.get(blobId);
   * blob.toBuilder().setContentType("text/plain").build().update();
   * }</pre>
   *
   * @param options preconditions to apply the update
   * @return the updated {@code Blob}
   * @throws StorageException upon failure
   * @see <a
   *     href="https://cloud.google.com/storage/docs/json_api/v1/objects/update">https://cloud.google.com/storage/docs/json_api/v1/objects/update</a>
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Blob update(BlobTargetOption... options) {
    return storage.update(this, options);
  }

  /**
   * Deletes this blob.
   *
   * <p>Example of deleting the blob, if its generation matches the {@link Blob#getGeneration()}
   * value, otherwise a {@link StorageException} is thrown.
   *
   * <pre>{@code
   * boolean deleted = blob.delete(BlobSourceOption.generationMatch());
   * if (deleted) {
   *   // the blob was deleted
   * } else {
   *   // the blob was not found
   * }
   * }</pre>
   *
   * @param options blob delete options
   * @return {@code true} if blob was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public boolean delete(BlobSourceOption... options) {
    // Don't use static imports of BlobSourceOption, it causes import resolution issues
    // with the new UnifiedOpts shim interfaces
    return storage.delete(getBlobId(), BlobSourceOption.toSourceOptions(this, options));
  }

  /**
   * Sends a copy request for the current blob to the target blob. Possibly also some of the
   * metadata are copied (e.g. content-type).
   *
   * <p>Example of copying the blob to a different bucket with a different name.
   *
   * <pre>{@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "copy_blob_name";
   * CopyWriter copyWriter = blob.copyTo(BlobId.of(bucketName, blobName));
   * Blob copiedBlob = copyWriter.getResult();
   * }</pre>
   *
   * @param targetBlob target blob's id
   * @param options source blob options
   * @return a {@link CopyWriter} object that can be used to get information on the newly created
   *     blob or to complete the copy if more than one RPC request is needed
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public CopyWriter copyTo(BlobId targetBlob, BlobSourceOption... options) {
    CopyRequest copyRequest =
        CopyRequest.newBuilder()
            .setSource(getBucket(), getName())
            // Don't use static imports of BlobSourceOption, it causes import resolution issues
            // with the new UnifiedOpts shim interfaces
            .setSourceOptions(BlobSourceOption.toSourceOptions(this, options))
            .setTarget(targetBlob)
            .build();
    return storage.copy(copyRequest);
  }

  /**
   * Sends a copy request for the current blob to the target bucket, preserving its name. Possibly
   * copying also some of the metadata (e.g. content-type).
   *
   * <p>Example of copying the blob to a different bucket, keeping the original name.
   *
   * <pre>{@code
   * String bucketName = "my_unique_bucket";
   * CopyWriter copyWriter = blob.copyTo(bucketName);
   * Blob copiedBlob = copyWriter.getResult();
   * }</pre>
   *
   * @param targetBucket target bucket's name
   * @param options source blob options
   * @return a {@link CopyWriter} object that can be used to get information on the newly created
   *     blob or to complete the copy if more than one RPC request is needed
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public CopyWriter copyTo(String targetBucket, BlobSourceOption... options) {
    return copyTo(targetBucket, getName(), options);
  }

  /**
   * Sends a copy request for the current blob to the target blob. Possibly also some of the
   * metadata are copied (e.g. content-type).
   *
   * <p>Example of copying the blob to a different bucket with a different name.
   *
   * <pre>{@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "copy_blob_name";
   * CopyWriter copyWriter = blob.copyTo(bucketName, blobName);
   * Blob copiedBlob = copyWriter.getResult();
   * }</pre>
   *
   * <p>Example of moving a blob to a different bucket with a different name.
   *
   * <pre>{@code
   * String destBucket = "my_unique_bucket";
   * String destBlob = "move_blob_name";
   * CopyWriter copyWriter = blob.copyTo(destBucket, destBlob);
   * Blob copiedBlob = copyWriter.getResult();
   * boolean deleted = blob.delete();
   * }</pre>
   *
   * @param targetBucket target bucket's name
   * @param targetBlob target blob's name
   * @param options source blob options
   * @return a {@link CopyWriter} object that can be used to get information on the newly created
   *     blob or to complete the copy if more than one RPC request is needed
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public CopyWriter copyTo(String targetBucket, String targetBlob, BlobSourceOption... options) {
    return copyTo(BlobId.of(targetBucket, targetBlob), options);
  }

  /**
   * Returns a {@code ReadChannel} object for reading this blob's content.
   *
   * <p>Example of reading the blob's content through a reader.
   *
   * <pre>{@code
   * try (ReadChannel reader = blob.reader()) {
   *   ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
   *   while (reader.read(bytes) > 0) {
   *     bytes.flip();
   *     // do something with bytes
   *     bytes.clear();
   *   }
   * }
   * }</pre>
   *
   * <p>Example of reading just a portion of the blob's content.
   *
   * <pre>{@code
   * int start = 1;
   * int end = 8;
   * try (ReadChannel reader = blob.reader()) {
   *   reader.seek(start);
   *   ByteBuffer bytes = ByteBuffer.allocate(end - start);
   *   reader.read(bytes);
   *   return bytes.array();
   * }
   * }</pre>
   *
   * @param options blob read options
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public ReadChannel reader(BlobSourceOption... options) {
    // Don't use static imports of BlobSourceOption, it causes import resolution issues
    // with the new UnifiedOpts shim interfaces
    return storage.reader(getBlobId(), BlobSourceOption.toSourceOptions(this, options));
  }

  /**
   * Returns a {@code WriteChannel} object for writing to this blob. By default any md5 and crc32c
   * values in the current blob are ignored unless requested via the {@code
   * BlobWriteOption.md5Match} and {@code BlobWriteOption.crc32cMatch} options.
   *
   * <p>Example of writing the blob's content through a writer.
   *
   * <pre>{@code
   * byte[] content = "Hello, World!".getBytes(UTF_8);
   * try (WriteChannel writer = blob.writer()) {
   *     writer.write(ByteBuffer.wrap(content, 0, content.length));
   * } catch (IOException ex) {
   *   // handle exception
   * }
   * blob = blob.reload();
   * }</pre>
   *
   * @param options target blob options
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public WriteChannel writer(BlobWriteOption... options) {
    return storage.writer(this, options);
  }

  /**
   * Generates a signed URL for this blob. If you want to allow access for a fixed amount of time to
   * this blob, you can use this method to generate a URL that is only valid within a certain time
   * period. This is particularly useful if you don't want publicly accessible blobs, but also don't
   * want to require users to explicitly log in. Signing a URL requires a service account signer. If
   * an instance of {@link com.google.auth.ServiceAccountSigner} was passed to {@link
   * StorageOptions}' builder via {@code setCredentials(Credentials)} or the default credentials are
   * being used and the environment variable {@code GOOGLE_APPLICATION_CREDENTIALS} is set or your
   * application is running in App Engine, then {@code signUrl} will use that credentials to sign
   * the URL. If the credentials passed to {@link StorageOptions} do not implement {@link
   * ServiceAccountSigner} (this is the case, for instance, for Compute Engine credentials and
   * Google Cloud SDK credentials) then {@code signUrl} will throw an {@link IllegalStateException}
   * unless an implementation of {@link ServiceAccountSigner} is passed using the {@link
   * SignUrlOption#signWith(ServiceAccountSigner)} option.
   *
   * <p>A service account signer is looked for in the following order:
   *
   * <ol>
   *   <li>The signer passed with the option {@link SignUrlOption#signWith(ServiceAccountSigner)}
   *   <li>The credentials passed to {@link StorageOptions}
   *   <li>The default credentials, if no credentials were passed to {@link StorageOptions}
   * </ol>
   *
   * <p>Example of creating a signed URL for the blob that is valid for 2 weeks, using the default
   * credentials for signing the URL:
   *
   * <pre>{@code
   * URL signedUrl = blob.signUrl(14, TimeUnit.DAYS);
   * }</pre>
   *
   * <p>Example of creating a signed URL for the blob passing the {@link
   * SignUrlOption#signWith(ServiceAccountSigner)} option, that will be used to sign the URL:
   *
   * <pre>{@code
   * String keyPath = "/path/to/key.json";
   * URL signedUrl = blob.signUrl(14, TimeUnit.DAYS, SignUrlOption.signWith(
   *     ServiceAccountCredentials.fromStream(new FileInputStream(keyPath))));
   * }</pre>
   *
   * <p>Example of creating a signed URL for a blob generation:
   *
   * <pre>{@code
   * URL signedUrl = blob.signUrl(1, TimeUnit.HOURS,
   *     SignUrlOption.withQueryParams(ImmutableMap.of("generation", "1576656755290328")));
   * }</pre>
   *
   * @param duration time until the signed URL expires, expressed in {@code unit}. The finer
   *     granularity supported is 1 second, finer granularities will be truncated
   * @param unit time unit of the {@code duration} parameter
   * @param options optional URL signing options
   * @return a signed URL for this blob and the specified options
   * @throws IllegalStateException if {@link SignUrlOption#signWith(ServiceAccountSigner)} was not
   *     used and no implementation of {@link ServiceAccountSigner} was provided to {@link
   *     StorageOptions}
   * @throws IllegalArgumentException if {@code SignUrlOption.withMd5()} option is used and {@code
   *     blobInfo.md5()} is {@code null}
   * @throws IllegalArgumentException if {@code SignUrlOption.withContentType()} option is used and
   *     {@code blobInfo.contentType()} is {@code null}
   * @throws SigningException if the attempt to sign the URL failed
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed-URLs</a>
   */
  @TransportCompatibility(Transport.HTTP)
  public URL signUrl(long duration, TimeUnit unit, SignUrlOption... options) {
    return storage.signUrl(this, duration, unit, options);
  }

  /**
   * Returns the ACL entry for the specified entity on this blob or {@code null} if not found.
   *
   * <p>Example of getting the ACL entry for an entity.
   *
   * <pre>{@code
   * Acl acl = blob.getAcl(User.ofAllAuthenticatedUsers());
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Acl getAcl(Entity entity) {
    return storage.getAcl(getBlobId(), entity);
  }

  /**
   * Deletes the ACL entry for the specified entity on this blob.
   *
   * <p>Example of deleting the ACL entry for an entity.
   *
   * <pre>{@code
   * boolean deleted = blob.deleteAcl(User.ofAllAuthenticatedUsers());
   * if (deleted) {
   *   // the acl entry was deleted
   * } else {
   *   // the acl entry was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the ACL was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public boolean deleteAcl(Entity entity) {
    return storage.deleteAcl(getBlobId(), entity);
  }

  /**
   * Creates a new ACL entry on this blob.
   *
   * <p>Example of creating a new ACL entry.
   *
   * <pre>{@code
   * Acl acl = blob.createAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.READER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Acl createAcl(Acl acl) {
    return storage.createAcl(getBlobId(), acl);
  }

  /**
   * Updates an ACL entry on this blob.
   *
   * <p>Example of updating a new ACL entry.
   *
   * <pre>{@code
   * Acl acl = blob.updateAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.OWNER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Acl updateAcl(Acl acl) {
    return storage.updateAcl(getBlobId(), acl);
  }

  /**
   * Lists the ACL entries for this blob.
   *
   * <p>Example of listing the ACL entries.
   *
   * <pre>{@code
   * List<Acl> acls = blob.listAcls();
   * for (Acl acl : acls) {
   *   // do something with ACL entry
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public List<Acl> listAcls() {
    return storage.listAcls(getBlobId());
  }

  /** Returns the blob's {@code Storage} object used to issue requests. */
  public Storage getStorage() {
    return storage;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Returns true if obj instance {@code Blob.toPb()} metadata representation and {@code
   * Blob.options} instance of StorageOptions are both equal.
   */
  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Blob.class)) {
      return false;
    }
    Blob other = (Blob) obj;
    return super.equals(other) && Objects.equals(options, other.options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  /**
   * Drop the held {@link Storage} instance.
   *
   * @since 2.14.0
   */
  public BlobInfo asBlobInfo() {
    return this.toBuilder().infoBuilder.build();
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.storage = options.getService();
  }
}
