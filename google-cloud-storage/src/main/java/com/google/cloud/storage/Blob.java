/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

import static com.google.cloud.storage.Blob.BlobSourceOption.toGetOptions;
import static com.google.cloud.storage.Blob.BlobSourceOption.toSourceOptions;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.storage.model.StorageObject;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.ServiceAccountSigner.SigningException;
import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.spi.StorageRpc;
import com.google.cloud.storage.spi.StorageRpc.Tuple;
import com.google.common.base.Function;
import com.google.common.io.BaseEncoding;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.security.Key;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * A Google cloud storage object.
 *
 * <p>Objects of this class are immutable. Operations that modify the blob like {@link #update} and
 * {@link #copyTo} return a new object. To get a {@code Blob} object with the most recent
 * information use {@link #reload}. {@code Blob} adds a layer of service-related functionality over
 * {@link BlobInfo}.
 * </p>
 */
public class Blob extends BlobInfo {

  private static final long serialVersionUID = -6806832496717441434L;

  private final StorageOptions options;
  private transient Storage storage;

  static final Function<Tuple<Storage, StorageObject>, Blob> BLOB_FROM_PB_FUNCTION =
      new Function<Tuple<Storage, StorageObject>, Blob>() {
        @Override
        public Blob apply(Tuple<Storage, StorageObject> pb) {
          return Blob.fromPb(pb.x(), pb.y());
        }
      };

  /**
   * Class for specifying blob source options when {@code Blob} methods are used.
   */
  public static class BlobSourceOption extends Option {

    private static final long serialVersionUID = 214616862061934846L;

    private BlobSourceOption(StorageRpc.Option rpcOption) {
      super(rpcOption, null);
    }

    private BlobSourceOption(StorageRpc.Option rpcOption, Object value) {
      super(rpcOption, value);
    }

    private Storage.BlobSourceOption toSourceOptions(BlobInfo blobInfo) {
      switch (getRpcOption()) {
        case IF_GENERATION_MATCH:
          return Storage.BlobSourceOption.generationMatch(blobInfo.getGeneration());
        case IF_GENERATION_NOT_MATCH:
          return Storage.BlobSourceOption.generationNotMatch(blobInfo.getGeneration());
        case IF_METAGENERATION_MATCH:
          return Storage.BlobSourceOption.metagenerationMatch(blobInfo.getMetageneration());
        case IF_METAGENERATION_NOT_MATCH:
          return Storage.BlobSourceOption.metagenerationNotMatch(blobInfo.getMetageneration());
        case CUSTOMER_SUPPLIED_KEY:
          return Storage.BlobSourceOption.decryptionKey((String) getValue());
        default:
          throw new AssertionError("Unexpected enum value");
      }
    }

    private Storage.BlobGetOption toGetOption(BlobInfo blobInfo) {
      switch (getRpcOption()) {
        case IF_GENERATION_MATCH:
          return Storage.BlobGetOption.generationMatch(blobInfo.getGeneration());
        case IF_GENERATION_NOT_MATCH:
          return Storage.BlobGetOption.generationNotMatch(blobInfo.getGeneration());
        case IF_METAGENERATION_MATCH:
          return Storage.BlobGetOption.metagenerationMatch(blobInfo.getMetageneration());
        case IF_METAGENERATION_NOT_MATCH:
          return Storage.BlobGetOption.metagenerationNotMatch(blobInfo.getMetageneration());
        default:
          throw new AssertionError("Unexpected enum value");
      }
    }

    /**
     * Returns an option for blob's generation match. If this option is used the request will fail
     * if generation does not match.
     */
    public static BlobSourceOption generationMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_MATCH);
    }

    /**
     * Returns an option for blob's generation mismatch. If this option is used the request will
     * fail if generation matches.
     */
    public static BlobSourceOption generationNotMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_NOT_MATCH);
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    public static BlobSourceOption metagenerationMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH);
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if metageneration matches.
     */
    public static BlobSourceOption metagenerationNotMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH);
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     */
    public static BlobSourceOption decryptionKey(Key key) {
      String base64Key = BaseEncoding.base64().encode(key.getEncoded());
      return new BlobSourceOption(StorageRpc.Option.CUSTOMER_SUPPLIED_KEY, base64Key);
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     *
     * @param key the AES256 encoded in base64
     */
    public static BlobSourceOption decryptionKey(String key) {
      return new BlobSourceOption(StorageRpc.Option.CUSTOMER_SUPPLIED_KEY, key);
    }

    static Storage.BlobSourceOption[] toSourceOptions(BlobInfo blobInfo,
        BlobSourceOption... options) {
      Storage.BlobSourceOption[] convertedOptions = new Storage.BlobSourceOption[options.length];
      int index = 0;
      for (BlobSourceOption option : options) {
        convertedOptions[index++] = option.toSourceOptions(blobInfo);
      }
      return convertedOptions;
    }

    static Storage.BlobGetOption[] toGetOptions(BlobInfo blobInfo, BlobSourceOption... options) {
      Storage.BlobGetOption[] convertedOptions = new Storage.BlobGetOption[options.length];
      int index = 0;
      for (BlobSourceOption option : options) {
        convertedOptions[index++] = option.toGetOption(blobInfo);
      }
      return convertedOptions;
    }
  }

  /**
   * Builder for {@code Blob}.
   */
  public static class Builder extends BlobInfo.Builder {

    private final Storage storage;
    private final BlobInfo.BuilderImpl infoBuilder;

    Builder(Blob blob) {
      this.storage = blob.getStorage();
      this.infoBuilder = new BlobInfo.BuilderImpl(blob);
    }

    @Override
    @Deprecated
    public Builder blobId(BlobId blobId) {
      return setBlobId(blobId);
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
    public Builder contentType(String contentType) {
      return setContentType(contentType);
    }

    @Override
    public Builder setContentType(String contentType) {
      infoBuilder.setContentType(contentType);
      return this;
    }

    @Override
    @Deprecated
    public Builder contentDisposition(String contentDisposition) {
      return setContentDisposition(contentDisposition);
    }

    @Override
    public Builder setContentDisposition(String contentDisposition) {
      infoBuilder.setContentDisposition(contentDisposition);
      return this;
    }

    @Override
    @Deprecated
    public Builder contentLanguage(String contentLanguage) {
      return setContentLanguage(contentLanguage);
    }

    @Override
    public Builder setContentLanguage(String contentLanguage) {
      infoBuilder.setContentLanguage(contentLanguage);
      return this;
    }

    @Override
    @Deprecated
    public Builder contentEncoding(String contentEncoding) {
      return setContentEncoding(contentEncoding);
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
    @Deprecated
    public Builder cacheControl(String cacheControl) {
      return setCacheControl(cacheControl);
    }

    @Override
    public Builder setCacheControl(String cacheControl) {
      infoBuilder.setCacheControl(cacheControl);
      return this;
    }

    @Override
    @Deprecated
    public Builder acl(List<Acl> acl) {
      return setAcl(acl);
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
    @Deprecated
    public Builder md5(String md5) {
      return setMd5(md5);
    }

    @Override
    public Builder setMd5(String md5) {
      infoBuilder.setMd5(md5);
      return this;
    }

    @Override
    @Deprecated
    public Builder crc32c(String crc32c) {
      return setCrc32c(crc32c);
    }

    @Override
    public Builder setCrc32c(String crc32c) {
      infoBuilder.setCrc32c(crc32c);
      return this;
    }

    @Override
    Builder setMediaLink(String mediaLink) {
      infoBuilder.setMediaLink(mediaLink);
      return this;
    }

    @Override
    @Deprecated
    public Builder metadata(Map<String, String> metadata) {
      return setMetadata(metadata);
    }

    @Override
    public Builder setMetadata(Map<String, String> metadata) {
      infoBuilder.setMetadata(metadata);
      return this;
    }

    @Override
    Builder setMetageneration(Long metageneration) {
      infoBuilder.setMetageneration(metageneration);
      return this;
    }

    @Override
    Builder setDeleteTime(Long deleteTime) {
      infoBuilder.setDeleteTime(deleteTime);
      return this;
    }

    @Override
    Builder setUpdateTime(Long updateTime) {
      infoBuilder.setUpdateTime(updateTime);
      return this;
    }

    @Override
    Builder setCreateTime(Long createTime) {
      infoBuilder.setCreateTime(createTime);
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
    public Blob build() {
      return new Blob(storage, infoBuilder);
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
   * <pre> {@code
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
  public boolean exists(BlobSourceOption... options) {
    int length = options.length;
    Storage.BlobGetOption[] getOptions = Arrays.copyOf(toGetOptions(this, options), length + 1);
    getOptions[length] = Storage.BlobGetOption.fields();
    return storage.get(getBlobId(), getOptions) != null;
  }

  /**
   * Returns this blob's content.
   *
   * @param options blob read options
   * @throws StorageException upon failure
   */
  @Deprecated
  public byte[] content(BlobSourceOption... options) {
    return storage.readAllBytes(getBlobId(), toSourceOptions(this, options));
  }

  /**
   * Returns this blob's content.
   *
   * <p>Example of reading all bytes of the blob, if its generation matches the
   * {@link Blob#generation()} value, otherwise a {@link StorageException} is thrown.
   * <pre> {@code
   * byte[] content = blob.getContent(BlobSourceOption.generationMatch());
   * }</pre>
   *
   * @param options blob read options
   * @throws StorageException upon failure
   */
  public byte[] getContent(BlobSourceOption... options) {
    return storage.readAllBytes(getBlobId(), toSourceOptions(this, options));
  }

  /**
   * Fetches current blob's latest information. Returns {@code null} if the blob does not exist.
   *
   * <p>Example of getting the blob's latest information, if its generation does not match the
   * {@link Blob#generation()} value, otherwise a {@link StorageException} is thrown.
   * <pre> {@code
   * Blob latestBlob = blob.reload(BlobSourceOption.generationNotMatch());
   * if (latestBlob == null) {
   *   // the blob was not found
   * }
   * }</pre>
   *
   * @param options blob read options
   * @return a {@code Blob} object with latest information or {@code null} if not found
   * @throws StorageException upon failure
   */
  public Blob reload(BlobSourceOption... options) {
    return storage.get(getBlobId(), toGetOptions(this, options));
  }

  /**
   * Updates the blob's information. Bucket or blob's name cannot be changed by this method. If you
   * want to rename the blob or move it to a different bucket use the {@link #copyTo} and
   * {@link #delete} operations. A new {@code Blob} object is returned. By default no checks are
   * made on the metadata generation of the current blob. If you want to update the information only
   * if the current blob metadata are at their latest version use the {@code metagenerationMatch}
   * option: {@code newBlob.update(BlobTargetOption.metagenerationMatch())}.
   *
   * <p>Original metadata are merged with metadata in the provided in this {@code blob}. To replace
   * metadata instead you first have to unset them. Unsetting metadata can be done by setting this
   * {@code blob}'s metadata to {@code null}.
   * </p>
   *
   * <p>Example of replacing blob's metadata.
   * <pre> {@code
   * Map<String, String> newMetadata = new HashMap<>();
   * newMetadata.put("key", "value");
   * blob.toBuilder().setMetadata(null).build().update();
   * Blob updatedBlob = blob.toBuilder().setMetadata(newMetadata).build().update();
   * }</pre>
   *
   * @param options update options
   * @return a {@code Blob} object with updated information
   * @throws StorageException upon failure
   */
  public Blob update(BlobTargetOption... options) {
    return storage.update(this, options);
  }

  /**
   * Deletes this blob.
   *
   * <p>Example of deleting the blob, if its generation matches the {@link Blob#generation()} value,
   * otherwise a {@link StorageException} is thrown.
   * <pre> {@code
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
  public boolean delete(BlobSourceOption... options) {
    return storage.delete(getBlobId(), toSourceOptions(this, options));
  }

  /**
   * Sends a copy request for the current blob to the target blob. Possibly also some of the
   * metadata are copied (e.g. content-type).
   *
   * <p>Example of copying the blob to a different bucket with a different name.
   * <pre> {@code
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
  public CopyWriter copyTo(BlobId targetBlob, BlobSourceOption... options) {
    CopyRequest copyRequest = CopyRequest.newBuilder()
        .setSource(getBucket(), getName())
        .setSourceOptions(toSourceOptions(this, options))
        .setTarget(targetBlob)
        .build();
    return storage.copy(copyRequest);
  }

  /**
   * Sends a copy request for the current blob to the target bucket, preserving its name. Possibly
   * copying also some of the metadata (e.g. content-type).
   *
   * <p>Example of copying the blob to a different bucket, keeping the original name.
   * <pre> {@code
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
  public CopyWriter copyTo(String targetBucket, BlobSourceOption... options) {
    return copyTo(targetBucket, getName(), options);
  }

  /**
   * Sends a copy request for the current blob to the target blob. Possibly also some of the
   * metadata are copied (e.g. content-type).
   *
   * <p>Example of copying the blob to a different bucket with a different name.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "copy_blob_name";
   * CopyWriter copyWriter = blob.copyTo(bucketName, blobName);
   * Blob copiedBlob = copyWriter.getResult();
   * }</pre>
   *
   * @param targetBucket target bucket's name
   * @param targetBlob target blob's name
   * @param options source blob options
   * @return a {@link CopyWriter} object that can be used to get information on the newly created
   *     blob or to complete the copy if more than one RPC request is needed
   * @throws StorageException upon failure
   */
  public CopyWriter copyTo(String targetBucket, String targetBlob, BlobSourceOption... options) {
    return copyTo(BlobId.of(targetBucket, targetBlob), options);
  }

  /**
   * Returns a {@code ReadChannel} object for reading this blob's content.
   *
   * <p>Example of reading the blob's content through a reader.
   * <pre> {@code
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
   * <pre> {@code
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
  public ReadChannel reader(BlobSourceOption... options) {
    return storage.reader(getBlobId(), toSourceOptions(this, options));
  }

  /**
   * Returns a {@code WriteChannel} object for writing to this blob. By default any md5 and
   * crc32c values in the current blob are ignored unless requested via the
   * {@code BlobWriteOption.md5Match} and {@code BlobWriteOption.crc32cMatch} options.
   *
   * <p>Example of writing the blob's content through a writer.
   * <pre> {@code
   * byte[] content = "Hello, World!".getBytes(UTF_8);
   * try (WriteChannel writer = blob.writer()) {
   *   try {
   *     writer.write(ByteBuffer.wrap(content, 0, content.length));
   *   } catch (Exception ex) {
   *     // handle exception
   *   }
   * }
   * }</pre>
   *
   * @param options target blob options
   * @throws StorageException upon failure
   */
  public WriteChannel writer(BlobWriteOption... options) {
    return storage.writer(this, options);
  }

  /**
   * Generates a signed URL for this blob. If you want to allow access for a fixed amount of time to
   * this blob, you can use this method to generate a URL that is only valid within a certain time
   * period. This is particularly useful if you don't want publicly accessible blobs, but also don't
   * want to require users to explicitly log in. Signing a URL requires
   * a service account signer. If an instance of {@link com.google.auth.ServiceAccountSigner} was
   * passed to {@link StorageOptions}' builder via {@code setCredentials(Credentials)} or the
   * default credentials are being used and the environment variable
   * {@code GOOGLE_APPLICATION_CREDENTIALS} is set or your application is running in App Engine,
   * then {@code signUrl} will use that credentials to sign the URL. If the credentials passed to
   * {@link StorageOptions} do not implement {@link ServiceAccountSigner} (this is the case, for
   * instance, for Compute Engine credentials and Google Cloud SDK credentials) then {@code signUrl}
   * will throw an {@link IllegalStateException} unless an implementation of
   * {@link ServiceAccountSigner} is passed using the
   * {@link SignUrlOption#signWith(ServiceAccountSigner)} option.
   *
   * <p>A service account signer is looked for in the following order:
   * <ol>
   *   <li>The signer passed with the option {@link SignUrlOption#signWith(ServiceAccountSigner)}
   *   <li>The credentials passed to {@link StorageOptions}
   *   <li>The default credentials, if no credentials were passed to {@link StorageOptions}
   * </ol>
   *
   * <p>Example of creating a signed URL for the blob that is valid for 2 weeks, using the default
   * credentials for signing the URL.
   * <pre> {@code
   * URL signedUrl = blob.signUrl(14, TimeUnit.DAYS);
   * }</pre>
   *
   * <p>Example of creating a signed URL for the blob passing the
   * {@link SignUrlOption#signWith(ServiceAccountSigner)} option, that will be used to sign the URL.
   * <pre> {@code
   * String keyPath = "/path/to/key.json";
   * URL signedUrl = blob.signUrl(14, TimeUnit.DAYS, SignUrlOption.signWith(
   *     ServiceAccountCredentials.fromStream(new FileInputStream(keyPath))));
   * }</pre>
   *
   * @param duration time until the signed URL expires, expressed in {@code unit}. The finer
   *     granularity supported is 1 second, finer granularities will be truncated
   * @param unit time unit of the {@code duration} parameter
   * @param options optional URL signing options
   * @return a signed URL for this blob and the specified options
   * @throws IllegalStateException if {@link SignUrlOption#signWith(ServiceAccountSigner)} was not
   *     used and no implementation of {@link ServiceAccountSigner} was provided to
   *     {@link StorageOptions}
   * @throws IllegalArgumentException if {@code SignUrlOption.withMd5()} option is used and
   *     {@code blobInfo.md5()} is {@code null}
   * @throws IllegalArgumentException if {@code SignUrlOption.withContentType()} option is used and
   *     {@code blobInfo.contentType()} is {@code null}
   * @throws SigningException if the attempt to sign the URL failed
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed-URLs</a>
   */
  public URL signUrl(long duration, TimeUnit unit, SignUrlOption... options) {
    return storage.signUrl(this, duration, unit, options);
  }

  /**
   * Returns the ACL entry for the specified entity on this blob or {@code null} if not found.
   *
   * <p>Example of getting the ACL entry for an entity.
   * <pre> {@code
   * Acl acl = blob.getAcl(User.ofAllAuthenticatedUsers());
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  public Acl getAcl(Entity entity) {
    return storage.getAcl(getBlobId(), entity);
  }

  /**
   * Deletes the ACL entry for the specified entity on this blob.
   *
   * <p>Example of deleting the ACL entry for an entity.
   * <pre> {@code
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
  public boolean deleteAcl(Entity entity) {
    return storage.deleteAcl(getBlobId(), entity);
  }

  /**
   * Creates a new ACL entry on this blob.
   *
   * <p>Example of creating a new ACL entry.
   * <pre> {@code
   * Acl acl = blob.createAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.READER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  public Acl createAcl(Acl acl) {
    return storage.createAcl(getBlobId(), acl);
  }

  /**
   * Updates an ACL entry on this blob.
   *
   * <p>Example of updating a new ACL entry.
   * <pre> {@code
   * Acl acl = blob.updateAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.OWNER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  public Acl updateAcl(Acl acl) {
    return storage.updateAcl(getBlobId(), acl);
  }

  /**
   * Lists the ACL entries for this blob.
   *
   * <p>Example of listing the ACL entries.
   * <pre> {@code
   * List<Acl> acls = blob.listAcls();
   * for (Acl acl : acls) {
   *   // do something with ACL entry
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  public List<Acl> listAcls() {
    return storage.listAcls(getBlobId());
  }

  /**
   * Returns the blob's {@code Storage} object used to issue requests.
   */
  @Deprecated
  public Storage storage() {
    return getStorage();
  }

  /**
   * Returns the blob's {@code Storage} object used to issue requests.
   */
  public Storage getStorage() {
    return storage;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Blob.class)) {
      return false;
    }
    Blob other = (Blob) obj;
    return Objects.equals(toPb(), other.toPb())
        && Objects.equals(options, other.options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.storage = options.getService();
  }

  static Blob fromPb(Storage storage, StorageObject storageObject) {
    BlobInfo info = BlobInfo.fromPb(storageObject);
    return new Blob(storage, new BlobInfo.BuilderImpl(info));
  }
}
