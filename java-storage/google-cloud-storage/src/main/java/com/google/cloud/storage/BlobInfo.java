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

import static com.google.cloud.storage.BackwardCompatibilityUtils.millisOffsetDateTimeCodec;
import static com.google.cloud.storage.Utils.diffMaps;
import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Data;
import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.NamedField;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.BaseEncoding;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.time.OffsetDateTime;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Information about an object in Google Cloud Storage. A {@code BlobInfo} object includes the
 * {@code BlobId} instance and the set of properties, such as the blob's access control
 * configuration, user provided metadata, the CRC32C checksum, etc. Instances of this class are used
 * to create a new object in Google Cloud Storage or update the properties of an existing object. To
 * deal with existing Storage objects the API includes the {@link Blob} class which extends {@code
 * BlobInfo} and declares methods to perform operations on the object. Neither {@code BlobInfo} nor
 * {@code Blob} instances keep the object content, just the object properties.
 *
 * <p>Example of usage {@code BlobInfo} to create an object in Google Cloud Storage:
 *
 * <pre>{@code
 * BlobId blobId = BlobId.of(bucketName, blobName);
 * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
 * Blob blob = storage.create(blobInfo, "Hello, world".getBytes(StandardCharsets.UTF_8));
 * }</pre>
 *
 * @see <a href="https://cloud.google.com/storage/docs/concepts-techniques#concepts">Concepts and
 *     Terminology</a>
 */
@TransportCompatibility({Transport.HTTP, Transport.GRPC})
public class BlobInfo implements Serializable {

  private static final long serialVersionUID = -2490471217826624578L;
  private final BlobId blobId;
  private final String generatedId;
  private final String selfLink;
  private final String cacheControl;
  private final List<Acl> acl;
  private final Acl.Entity owner;
  private final Long size;
  private final String etag;
  private final String md5;
  private final String crc32c;
  private final OffsetDateTime customTime;
  private final String mediaLink;

  /**
   * The getter for this property never returns null, however null awareness is critical for
   * encoding
   *
   * @see JsonConversions#blobInfo() encoder
   */
  final Map<String, String> metadata;

  private final Long metageneration;
  private final OffsetDateTime deleteTime;
  private final OffsetDateTime updateTime;
  private final OffsetDateTime createTime;
  private final String contentType;
  private final String contentEncoding;
  private final String contentDisposition;
  private final String contentLanguage;
  private final StorageClass storageClass;
  private final OffsetDateTime timeStorageClassUpdated;
  private final Integer componentCount;
  private final boolean isDirectory;
  private final CustomerEncryption customerEncryption;
  private final String kmsKeyName;
  private final Boolean eventBasedHold;
  private final Boolean temporaryHold;
  private final OffsetDateTime retentionExpirationTime;
  private final Retention retention;
  private final OffsetDateTime softDeleteTime;
  private final OffsetDateTime hardDeleteTime;
  private final ObjectContexts contexts;
  private final transient ImmutableSet<NamedField> modifiedFields;

  /** This class is meant for internal use only. Users are discouraged from using this class. */
  public static final class ImmutableEmptyMap<K, V> extends AbstractMap<K, V> {

    @Override
    public Set<Entry<K, V>> entrySet() {
      return ImmutableSet.of();
    }
  }

  /**
   * Objects of this class hold information on the customer-supplied encryption key, if the blob is
   * encrypted using such a key.
   */
  public static class CustomerEncryption implements Serializable {

    private static final long serialVersionUID = -7427738060808591323L;

    private final String encryptionAlgorithm;
    private final String keySha256;

    CustomerEncryption(String encryptionAlgorithm, String keySha256) {
      this.encryptionAlgorithm = encryptionAlgorithm;
      this.keySha256 = keySha256;
    }

    /** Returns the algorithm used to encrypt the blob. */
    public String getEncryptionAlgorithm() {
      return encryptionAlgorithm;
    }

    /** Returns the SHA256 hash of the encryption key. */
    public String getKeySha256() {
      return keySha256;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("encryptionAlgorithm", getEncryptionAlgorithm())
          .add("keySha256", getKeySha256())
          .toString();
    }

    @Override
    public final int hashCode() {
      return Objects.hash(encryptionAlgorithm, keySha256);
    }

    @Override
    public final boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof CustomerEncryption)) {
        return false;
      }
      CustomerEncryption that = (CustomerEncryption) o;
      return Objects.equals(encryptionAlgorithm, that.encryptionAlgorithm)
          && Objects.equals(keySha256, that.keySha256);
    }
  }

  /**
   * Defines a blob's Retention policy. Can only be used on objects in a retention-enabled bucket.
   */
  public static final class Retention implements Serializable {

    private static final long serialVersionUID = 5046718464542688444L;

    private Mode mode;

    private OffsetDateTime retainUntilTime;

    /** Returns the retention policy's Mode. Can be Locked or Unlocked. */
    public Mode getMode() {
      return mode;
    }

    /** Returns what time this object will be retained until, if the mode is Locked. */
    public OffsetDateTime getRetainUntilTime() {
      return retainUntilTime;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Retention)) {
        return false;
      }
      Retention that = (Retention) o;
      return Objects.equals(mode, that.mode)
          && Objects.equals(retainUntilTime, that.retainUntilTime);
    }

    @Override
    public int hashCode() {
      return Objects.hash(mode, retainUntilTime);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("mode", mode)
          .add("retainUntilTime", retainUntilTime)
          .toString();
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder toBuilder() {
      return new Builder().setMode(this.mode).setRetainUntilTime(this.retainUntilTime);
    }

    private Retention() {}

    public Retention(Builder builder) {
      this.mode = builder.mode;
      this.retainUntilTime = builder.retainUntilTime;
    }

    public static final class Builder {
      private Mode mode;
      private OffsetDateTime retainUntilTime;

      /** Sets the retention policy's Mode. Can be Locked or Unlocked. */
      public Builder setMode(Mode mode) {
        this.mode = mode;
        return this;
      }

      /** Sets what time this object will be retained until, if the mode is Locked. */
      public Builder setRetainUntilTime(OffsetDateTime retainUntilTime) {
        this.retainUntilTime = retainUntilTime;
        return this;
      }

      public Retention build() {
        return new Retention(this);
      }
    }

    public static final class Mode extends StringEnumValue {
      private static final long serialVersionUID = 1973143582659557184L;

      private Mode(String constant) {
        super(constant);
      }

      private static final ApiFunction<String, Mode> CONSTRUCTOR = Mode::new;

      private static final StringEnumType<Mode> type =
          new StringEnumType<>(Mode.class, CONSTRUCTOR);

      public static final Mode UNLOCKED = type.createAndRegister("Unlocked");

      public static final Mode LOCKED = type.createAndRegister("Locked");

      public static Mode valueOfStrict(String constant) {
        return type.valueOfStrict(constant);
      }

      public static Mode valueOf(String constant) {
        return type.valueOf(constant);
      }

      public static Mode[] values() {
        return type.values();
      }
    }
  }

  public static final class ObjectContexts implements Serializable {

    private static final long serialVersionUID = -5993852233545224424L;

    private final Map<String, ObjectCustomContextPayload> custom;

    private ObjectContexts(Builder builder) {
      this.custom = builder.custom;
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder toBuilder() {
      return new Builder().setCustom(this.custom);
    }

    /** Returns the map of user-defined object contexts. */
    public Map<String, ObjectCustomContextPayload> getCustom() {
      return custom;
    }

    @Override
    public int hashCode() {
      return Objects.hash(custom);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      final ObjectContexts other = (ObjectContexts) obj;
      return Objects.equals(this.custom, other.custom);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("custom", custom).toString();
    }

    public static final class Builder {

      private Map<String, ObjectCustomContextPayload> custom;

      private Builder() {}

      public Builder setCustom(Map<String, ObjectCustomContextPayload> custom) {
        this.custom =
            custom == null ? ImmutableMap.of() : Collections.unmodifiableMap(new HashMap<>(custom));
        return this;
      }

      public ObjectContexts build() {
        return new ObjectContexts(this);
      }
    }
  }

  /** Represents the payload of a user-defined object context. */
  public static final class ObjectCustomContextPayload implements Serializable {

    private static final long serialVersionUID = 557621132294323214L;

    private final String value;
    private final OffsetDateTime createTime;
    private final OffsetDateTime updateTime;

    private ObjectCustomContextPayload(Builder builder) {
      this.value = builder.value;
      this.createTime = builder.createTime;
      this.updateTime = builder.updateTime;
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder toBuilder() {
      return new Builder()
          .setValue(this.value)
          .setCreateTime(this.createTime)
          .setUpdateTime(this.updateTime);
    }

    public String getValue() {
      return value;
    }

    public OffsetDateTime getCreateTime() {
      return createTime;
    }

    public OffsetDateTime getUpdateTime() {
      return updateTime;
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, createTime, updateTime);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      ObjectCustomContextPayload other = (ObjectCustomContextPayload) obj;
      return Objects.equals(value, other.value)
          && Objects.equals(createTime, other.createTime)
          && Objects.equals(updateTime, other.updateTime);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("value", value)
          .add("createTime", createTime)
          .add("updateTime", updateTime)
          .toString();
    }

    public static final class Builder {

      private String value;
      private OffsetDateTime createTime;
      private OffsetDateTime updateTime;

      private Builder() {}

      public Builder(String value) {
        setValue(value);
      }

      public Builder setValue(String value) {
        this.value = value;
        return this;
      }

      public Builder setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
        return this;
      }

      public Builder setUpdateTime(OffsetDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
      }

      public ObjectCustomContextPayload build() {
        return new ObjectCustomContextPayload(this);
      }
    }
  }

  /** Builder for {@code BlobInfo}. */
  public abstract static class Builder {

    /** Sets the blob identity. */
    public abstract Builder setBlobId(BlobId blobId);

    abstract Builder setGeneratedId(String generatedId);

    /**
     * Sets the blob's data content type.
     *
     * @see <a href="https://tools.ietf.org/html/rfc2616#section-14.17">Content-Type</a>
     */
    public abstract Builder setContentType(String contentType);

    /**
     * Sets the blob's data content disposition.
     *
     * @see <a href="https://tools.ietf.org/html/rfc6266">Content-Disposition</a>
     */
    public abstract Builder setContentDisposition(String contentDisposition);

    /**
     * Sets the blob's data content language.
     *
     * @see <a href="http://tools.ietf.org/html/bcp47">Content-Language</a>
     */
    public abstract Builder setContentLanguage(String contentLanguage);

    /**
     * Sets the blob's data content encoding.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-3.1.2.2">Content-Encoding</a>
     */
    public abstract Builder setContentEncoding(String contentEncoding);

    abstract Builder setComponentCount(Integer componentCount);

    /**
     * Sets the blob's data cache control.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7234#section-5.2">Cache-Control</a>
     */
    public abstract Builder setCacheControl(String cacheControl);

    /**
     * Sets the blob's access control configuration.
     *
     * @see <a
     *     href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
     *     About Access Control Lists</a>
     */
    public abstract Builder setAcl(List<Acl> acl);

    abstract Builder setOwner(Acl.Entity owner);

    abstract Builder setSize(Long size);

    abstract Builder setEtag(String etag);

    abstract Builder setSelfLink(String selfLink);

    /**
     * Sets the MD5 hash of blob's data. MD5 value must be encoded in base64.
     *
     * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">Hashes and ETags:
     *     Best Practices</a>
     */
    public abstract Builder setMd5(String md5);

    /**
     * Sets the MD5 hash of blob's data from hex string.
     *
     * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">Hashes and ETags:
     *     Best Practices</a>
     * @throws IllegalArgumentException when given an invalid hexadecimal value.
     */
    public abstract Builder setMd5FromHexString(String md5HexString);

    /**
     * Sets the CRC32C checksum of blob's data as described in <a
     * href="http://tools.ietf.org/html/rfc4960#appendix-B">RFC 4960, Appendix B;</a> encoded in
     * base64 in big-endian order.
     *
     * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">Hashes and ETags:
     *     Best Practices</a>
     */
    public abstract Builder setCrc32c(String crc32c);

    /**
     * Sets the custom time for an object. Once set it can't be unset and only changed to a custom
     * datetime in the future. To unset the custom time, you must either perform a rewrite operation
     * or upload the data again.
     *
     * <p>Example of setting the custom time.
     *
     * <pre>{@code
     * String bucketName = "my-unique-bucket";
     * String blobName = "my-blob-name";
     * long customTime = 1598423868301L;
     * BlobInfo blob = BlobInfo.newBuilder(bucketName, blobName).setCustomTime(customTime).build();
     * }</pre>
     *
     * @deprecated Use {@link #setCustomTimeOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    public Builder setCustomTime(Long customTime) {
      throw new UnsupportedOperationException(
          "Override setCustomTime with your own implementation,"
              + " or use com.google.cloud.storage.Blob.");
    }

    /**
     * Sets the custom time for an object. Once set it can't be unset and only changed to a custom
     * datetime in the future. To unset the custom time, you must either perform a rewrite operation
     * or upload the data again.
     *
     * <p>Example of setting the custom time.
     *
     * <pre>{@code
     * String bucketName = "my-unique-bucket";
     * String blobName = "my-blob-name";
     * OffsetDateTime customTime = Instant.ofEpochMilli(1598423868301L).atOffset(0); // UTC
     * BlobInfo blob = BlobInfo.newBuilder(bucketName, blobName).setCustomTime(customTime).build();
     * }</pre>
     */
    public Builder setCustomTimeOffsetDateTime(OffsetDateTime customTime) {
      // provide an implementation for source and binary compatibility which we override ourselves
      return setCustomTime(millisOffsetDateTimeCodec.decode(customTime));
    }

    /**
     * Sets the CRC32C checksum of blob's data as described in <a
     * href="http://tools.ietf.org/html/rfc4960#appendix-B">RFC 4960, Appendix B;</a> from hex
     * string.
     *
     * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">Hashes and ETags:
     *     Best Practices</a>
     * @throws IllegalArgumentException when given an invalid hexadecimal value.
     */
    public abstract Builder setCrc32cFromHexString(String crc32cHexString);

    abstract Builder setMediaLink(String mediaLink);

    /** Sets the blob's storage class. */
    public abstract Builder setStorageClass(StorageClass storageClass);

    /**
     * Sets the modification time of an object's storage class. Once set it can't be unset directly,
     * the only way is to rewrite the object with the desired storage class.
     *
     * @deprecated Use {@link #setTimeStorageClassUpdatedOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    public Builder setTimeStorageClassUpdated(Long timeStorageClassUpdated) {
      throw new UnsupportedOperationException(
          "Override setTimeStorageClassUpdated with your own implementation,"
              + " or use com.google.cloud.storage.Blob.");
    }

    public Builder setTimeStorageClassUpdatedOffsetDateTime(
        OffsetDateTime timeStorageClassUpdated) {
      // provide an implementation for source and binary compatibility which we override ourselves
      return setTimeStorageClassUpdated(millisOffsetDateTimeCodec.decode(timeStorageClassUpdated));
    }

    /** Sets the blob's user provided metadata. */
    public abstract Builder setMetadata(@Nullable Map<@NonNull String, @Nullable String> metadata);

    abstract Builder setMetageneration(Long metageneration);

    /**
     * @deprecated Use {@link #setDeleteTimeOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    abstract Builder setDeleteTime(Long deleteTime);

    Builder setDeleteTimeOffsetDateTime(OffsetDateTime deleteTime) {
      // provide an implementation for source and binary compatibility which we override ourselves
      return setDeleteTime(millisOffsetDateTimeCodec.decode(deleteTime));
    }

    /**
     * @deprecated Use {@link #setUpdateTimeOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    abstract Builder setUpdateTime(Long updateTime);

    Builder setUpdateTimeOffsetDateTime(OffsetDateTime updateTime) {
      // provide an implementation for source and binary compatibility which we override ourselves
      return setUpdateTime(millisOffsetDateTimeCodec.decode(updateTime));
    }

    /**
     * @deprecated Use {@link #setCreateTimeOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    abstract Builder setCreateTime(Long createTime);

    Builder setCreateTimeOffsetDateTime(OffsetDateTime createTime) {
      // provide an implementation for source and binary compatibility which we override ourselves
      return setCreateTime(millisOffsetDateTimeCodec.decode(createTime));
    }

    abstract Builder setIsDirectory(boolean isDirectory);

    abstract Builder setCustomerEncryption(CustomerEncryption customerEncryption);

    /**
     * Sets a customer-managed key for server-side encryption of the blob. Note that when a KMS key
     * is used to encrypt Cloud Storage object, object resource metadata will store the version of
     * the KMS cryptographic. If a {@code Blob} with KMS Key metadata is used to upload a new
     * version of the object then the existing kmsKeyName version value can't be used in the upload
     * request and the client instead ignores it.
     *
     * <p>Example of setting the KMS key name
     *
     * <pre>{@code
     * String bucketName = "my-unique-bucket";
     * String blobName = "my-blob-name";
     * String kmsKeyName = "projects/project-id/locations/us/keyRings/lab1/cryptoKeys/test-key"
     * BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, blobName).build();
     * Blob blob = storage.create(blobInfo, Storage.BlobTargetOption.kmsKeyName(kmsKeyName));
     * }</pre>
     */
    abstract Builder setKmsKeyName(String kmsKeyName);

    /** Sets the blob's event-based hold. */
    @BetaApi
    public abstract Builder setEventBasedHold(Boolean eventBasedHold);

    /** Sets the blob's temporary hold. */
    @BetaApi
    public abstract Builder setTemporaryHold(Boolean temporaryHold);

    /**
     * @deprecated {@link #setRetentionExpirationTimeOffsetDateTime(OffsetDateTime)}
     */
    @BetaApi
    @Deprecated
    abstract Builder setRetentionExpirationTime(Long retentionExpirationTime);

    @BetaApi
    Builder setRetentionExpirationTimeOffsetDateTime(OffsetDateTime retentionExpirationTime) {
      // provide an implementation for source and binary compatibility which we override ourselves
      return setRetentionExpirationTime(millisOffsetDateTimeCodec.decode(retentionExpirationTime));
    }

    abstract Builder setSoftDeleteTime(OffsetDateTime offsetDateTime);

    abstract Builder setHardDeleteTime(OffsetDateTime hardDeleteTIme);

    public abstract Builder setRetention(Retention retention);

    public abstract Builder setContexts(ObjectContexts contexts);

    /** Creates a {@code BlobInfo} object. */
    public abstract BlobInfo build();

    abstract BlobId getBlobId();

    abstract Builder clearBlobId();

    abstract Builder clearGeneratedId();

    abstract Builder clearContentType();

    abstract Builder clearContentEncoding();

    abstract Builder clearContentDisposition();

    abstract Builder clearContentLanguage();

    abstract Builder clearComponentCount();

    abstract Builder clearCacheControl();

    abstract Builder clearAcl();

    abstract Builder clearOwner();

    abstract Builder clearSize();

    abstract Builder clearEtag();

    abstract Builder clearSelfLink();

    abstract Builder clearMd5();

    abstract Builder clearCrc32c();

    abstract Builder clearCustomTime();

    abstract Builder clearMediaLink();

    abstract Builder clearMetadata();

    abstract Builder clearMetageneration();

    abstract Builder clearDeleteTime();

    abstract Builder clearUpdateTime();

    abstract Builder clearCreateTime();

    abstract Builder clearIsDirectory();

    abstract Builder clearCustomerEncryption();

    abstract Builder clearStorageClass();

    abstract Builder clearTimeStorageClassUpdated();

    abstract Builder clearKmsKeyName();

    abstract Builder clearEventBasedHold();

    abstract Builder clearTemporaryHold();

    abstract Builder clearRetentionExpirationTime();

    abstract Builder clearContexts();
  }

  static final class BuilderImpl extends Builder {
    private static final String hexDecimalValues = "0123456789abcdef";
    public static final NamedField NAMED_FIELD_LITERAL_VALUE = NamedField.literal("value");
    private BlobId blobId;
    private String generatedId;
    private String contentType;
    private String contentEncoding;
    private String contentDisposition;
    private String contentLanguage;
    private Integer componentCount;
    private String cacheControl;
    private List<Acl> acl;
    private Acl.Entity owner;
    private Long size;
    private String etag;
    private String selfLink;
    private String md5;
    private String crc32c;
    private OffsetDateTime customTime;
    private String mediaLink;
    private Map<String, String> metadata;
    private Long metageneration;
    private OffsetDateTime deleteTime;
    private OffsetDateTime updateTime;
    private OffsetDateTime createTime;
    private Boolean isDirectory;
    private CustomerEncryption customerEncryption;
    private StorageClass storageClass;
    private OffsetDateTime timeStorageClassUpdated;
    private String kmsKeyName;
    private Boolean eventBasedHold;
    private Boolean temporaryHold;
    private OffsetDateTime retentionExpirationTime;
    private Retention retention;
    private OffsetDateTime softDeleteTime;
    private OffsetDateTime hardDeleteTime;
    private ObjectContexts contexts;
    private final ImmutableSet.Builder<NamedField> modifiedFields = ImmutableSet.builder();

    BuilderImpl(BlobId blobId) {
      this.blobId = blobId;
    }

    BuilderImpl(BlobInfo blobInfo) {
      blobId = blobInfo.blobId;
      generatedId = blobInfo.generatedId;
      cacheControl = blobInfo.cacheControl;
      contentEncoding = blobInfo.contentEncoding;
      contentType = blobInfo.contentType;
      contentDisposition = blobInfo.contentDisposition;
      contentLanguage = blobInfo.contentLanguage;
      componentCount = blobInfo.componentCount;
      customerEncryption = blobInfo.customerEncryption;
      acl = blobInfo.acl;
      owner = blobInfo.owner;
      size = blobInfo.size;
      etag = blobInfo.etag;
      selfLink = blobInfo.selfLink;
      md5 = blobInfo.md5;
      crc32c = blobInfo.crc32c;
      customTime = blobInfo.customTime;
      mediaLink = blobInfo.mediaLink;
      metadata = blobInfo.metadata;
      metageneration = blobInfo.metageneration;
      deleteTime = blobInfo.deleteTime;
      updateTime = blobInfo.updateTime;
      createTime = blobInfo.createTime;
      isDirectory = blobInfo.isDirectory;
      storageClass = blobInfo.storageClass;
      timeStorageClassUpdated = blobInfo.timeStorageClassUpdated;
      kmsKeyName = blobInfo.kmsKeyName;
      eventBasedHold = blobInfo.eventBasedHold;
      temporaryHold = blobInfo.temporaryHold;
      retentionExpirationTime = blobInfo.retentionExpirationTime;
      retention = blobInfo.retention;
      softDeleteTime = blobInfo.softDeleteTime;
      hardDeleteTime = blobInfo.hardDeleteTime;
      contexts = blobInfo.contexts;
    }

    @Override
    public Builder setBlobId(BlobId blobId) {
      checkNotNull(blobId);
      if (!Objects.equals(this.blobId, blobId)) {
        if (!Objects.equals(this.blobId.getBucket(), blobId.getBucket())) {
          modifiedFields.add(BlobField.BUCKET);
        }
        if (!Objects.equals(this.blobId.getName(), blobId.getName())) {
          modifiedFields.add(BlobField.NAME);
        }
        if (!Objects.equals(this.blobId.getGeneration(), blobId.getGeneration())) {
          modifiedFields.add(BlobField.GENERATION);
        }
      }
      this.blobId = blobId;
      return this;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    public Builder setContentType(String contentType) {
      String tmp = firstNonNull(contentType, Data.nullOf(String.class));
      if (!Objects.equals(this.contentType, tmp)) {
        modifiedFields.add(BlobField.CONTENT_TYPE);
      }
      this.contentType = tmp;
      return this;
    }

    @Override
    public Builder setContentDisposition(String contentDisposition) {
      String tmp = firstNonNull(contentDisposition, Data.nullOf(String.class));
      if (!Objects.equals(this.contentDisposition, tmp)) {
        modifiedFields.add(BlobField.CONTENT_DISPOSITION);
      }
      this.contentDisposition = tmp;
      return this;
    }

    @Override
    public Builder setContentLanguage(String contentLanguage) {
      String tmp = firstNonNull(contentLanguage, Data.nullOf(String.class));
      if (!Objects.equals(this.contentLanguage, tmp)) {
        modifiedFields.add(BlobField.CONTENT_LANGUAGE);
      }
      this.contentLanguage = tmp;
      return this;
    }

    @Override
    public Builder setContentEncoding(String contentEncoding) {
      String tmp = firstNonNull(contentEncoding, Data.nullOf(String.class));
      if (!Objects.equals(this.contentEncoding, tmp)) {
        modifiedFields.add(BlobField.CONTENT_ENCODING);
      }
      this.contentEncoding = tmp;
      return this;
    }

    @Override
    Builder setComponentCount(Integer componentCount) {
      this.componentCount = componentCount;
      return this;
    }

    @Override
    public Builder setCacheControl(String cacheControl) {
      String tmp = firstNonNull(cacheControl, Data.nullOf(String.class));
      if (!Objects.equals(this.cacheControl, tmp)) {
        modifiedFields.add(BlobField.CACHE_CONTROL);
      }
      this.cacheControl = tmp;
      return this;
    }

    @Override
    public Builder setAcl(List<Acl> acl) {
      if (!Objects.equals(this.acl, acl)) {
        modifiedFields.add(BlobField.ACL);
      }
      if (acl != null) {
        if (acl instanceof ImmutableList) {
          this.acl = acl;
        } else {
          this.acl = ImmutableList.copyOf(acl);
        }
      } else {
        this.acl = null;
      }
      return this;
    }

    @Override
    Builder setOwner(Acl.Entity owner) {
      if (!Objects.equals(this.owner, owner)) {
        modifiedFields.add(BlobField.OWNER);
      }
      this.owner = owner;
      return this;
    }

    @Override
    Builder setSize(Long size) {
      this.size = size;
      return this;
    }

    @Override
    Builder setEtag(String etag) {
      if (!Objects.equals(this.etag, etag)) {
        modifiedFields.add(BlobField.ETAG);
      }
      this.etag = etag;
      return this;
    }

    @Override
    Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    @Override
    public Builder setMd5(String md5) {
      String tmp = firstNonNull(md5, Data.nullOf(String.class));
      if (!Objects.equals(this.md5, tmp)) {
        modifiedFields.add(BlobField.MD5HASH);
      }
      this.md5 = tmp;
      return this;
    }

    @Override
    public Builder setMd5FromHexString(String md5HexString) {
      if (md5HexString == null) {
        return this;
      }
      if (md5HexString.length() % 2 != 0) {
        throw new IllegalArgumentException(
            "each byte must be represented by 2 valid hexadecimal characters");
      }
      String md5HexStringLower = md5HexString.toLowerCase();
      ByteBuffer md5ByteBuffer = ByteBuffer.allocate(md5HexStringLower.length() / 2);
      for (int charIndex = 0; charIndex < md5HexStringLower.length(); charIndex += 2) {
        int higherOrderBits = this.hexDecimalValues.indexOf(md5HexStringLower.charAt(charIndex));
        int lowerOrderBits = this.hexDecimalValues.indexOf(md5HexStringLower.charAt(charIndex + 1));
        if (higherOrderBits == -1 || lowerOrderBits == -1) {
          throw new IllegalArgumentException(
              "each byte must be represented by 2 valid hexadecimal characters");
        }
        md5ByteBuffer.put((byte) (higherOrderBits << 4 | lowerOrderBits));
      }
      return setMd5(BaseEncoding.base64().encode(md5ByteBuffer.array()));
    }

    @Override
    public Builder setCrc32c(String crc32c) {
      String tmp = firstNonNull(crc32c, Data.nullOf(String.class));
      if (!Objects.equals(this.crc32c, tmp)) {
        modifiedFields.add(BlobField.CRC32C);
      }
      this.crc32c = tmp;
      return this;
    }

    /**
     * @deprecated {@link #setCustomTimeOffsetDateTime(OffsetDateTime)}
     */
    @Override
    @Deprecated
    public Builder setCustomTime(Long customTime) {
      return setCustomTimeOffsetDateTime(millisOffsetDateTimeCodec.encode(customTime));
    }

    @Override
    public Builder setCustomTimeOffsetDateTime(OffsetDateTime customTime) {
      if (!Objects.equals(this.customTime, customTime)) {
        modifiedFields.add(BlobField.CUSTOM_TIME);
      }
      this.customTime = customTime;
      return this;
    }

    @Override
    public Builder setCrc32cFromHexString(String crc32cHexString) {
      if (crc32cHexString == null) {
        return this;
      }
      if (crc32cHexString.length() % 2 != 0) {
        throw new IllegalArgumentException(
            "each byte must be represented by 2 valid hexadecimal characters");
      }
      String crc32cHexStringLower = crc32cHexString.toLowerCase();
      ByteBuffer crc32cByteBuffer = ByteBuffer.allocate(crc32cHexStringLower.length() / 2);
      for (int charIndex = 0; charIndex < crc32cHexStringLower.length(); charIndex += 2) {
        int higherOrderBits = this.hexDecimalValues.indexOf(crc32cHexStringLower.charAt(charIndex));
        int lowerOrderBits =
            this.hexDecimalValues.indexOf(crc32cHexStringLower.charAt(charIndex + 1));
        if (higherOrderBits == -1 || lowerOrderBits == -1) {
          throw new IllegalArgumentException(
              "each byte must be represented by 2 valid hexadecimal characters");
        }
        crc32cByteBuffer.put((byte) (higherOrderBits << 4 | lowerOrderBits));
      }
      return setCrc32c(BaseEncoding.base64().encode(crc32cByteBuffer.array()));
    }

    @Override
    Builder setMediaLink(String mediaLink) {
      this.mediaLink = mediaLink;
      return this;
    }

    @SuppressWarnings({"UnnecessaryLocalVariable"})
    @Override
    public Builder setMetadata(@Nullable Map<@NonNull String, @Nullable String> metadata) {
      Map<String, String> left = this.metadata;
      Map<String, String> right = metadata;
      if (!Objects.equals(left, right)) {
        diffMaps(BlobField.METADATA, left, right, modifiedFields::add);
        if (right != null) {
          this.metadata = new HashMap<>(right);
        } else {
          this.metadata = (Map<String, String>) Data.nullOf(ImmutableEmptyMap.class);
        }
      }
      return this;
    }

    @Override
    public Builder setStorageClass(StorageClass storageClass) {
      if (!Objects.equals(this.storageClass, storageClass)) {
        modifiedFields.add(BlobField.STORAGE_CLASS);
      }
      this.storageClass = storageClass;
      return this;
    }

    /**
     * @deprecated Use {@link #setTimeStorageClassUpdatedOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    @Override
    public Builder setTimeStorageClassUpdated(Long timeStorageClassUpdated) {
      return setTimeStorageClassUpdatedOffsetDateTime(
          millisOffsetDateTimeCodec.encode(timeStorageClassUpdated));
    }

    @Override
    public Builder setTimeStorageClassUpdatedOffsetDateTime(
        OffsetDateTime timeStorageClassUpdated) {
      if (!Objects.equals(this.timeStorageClassUpdated, timeStorageClassUpdated)) {
        modifiedFields.add(BlobField.TIME_STORAGE_CLASS_UPDATED);
      }
      this.timeStorageClassUpdated = timeStorageClassUpdated;
      return this;
    }

    @Override
    Builder setMetageneration(Long metageneration) {
      this.metageneration = metageneration;
      return this;
    }

    /**
     * @deprecated Use {@link #setDeleteTimeOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    @Override
    Builder setDeleteTime(Long deleteTime) {
      return setDeleteTimeOffsetDateTime(millisOffsetDateTimeCodec.encode(deleteTime));
    }

    @Override
    Builder setDeleteTimeOffsetDateTime(OffsetDateTime deleteTime) {
      if (!Objects.equals(this.deleteTime, deleteTime)) {
        modifiedFields.add(BlobField.TIME_DELETED);
      }
      this.deleteTime = deleteTime;
      return this;
    }

    /**
     * @deprecated Use {@link #setUpdateTimeOffsetDateTime(OffsetDateTime)}
     */
    @Override
    Builder setUpdateTime(Long updateTime) {
      return setUpdateTimeOffsetDateTime(millisOffsetDateTimeCodec.encode(updateTime));
    }

    @Override
    Builder setUpdateTimeOffsetDateTime(OffsetDateTime updateTime) {
      if (!Objects.equals(this.updateTime, updateTime)) {
        modifiedFields.add(BlobField.UPDATED);
      }
      this.updateTime = updateTime;
      return this;
    }

    /**
     * @deprecated Use {@link #setCreateTimeOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    @Override
    Builder setCreateTime(Long createTime) {
      return setCreateTimeOffsetDateTime(millisOffsetDateTimeCodec.encode(createTime));
    }

    @Override
    Builder setCreateTimeOffsetDateTime(OffsetDateTime createTime) {
      if (!Objects.equals(this.createTime, createTime)) {
        modifiedFields.add(BlobField.TIME_CREATED);
      }
      this.createTime = createTime;
      return this;
    }

    @Override
    Builder setIsDirectory(boolean isDirectory) {
      this.isDirectory = isDirectory;
      return this;
    }

    @Override
    Builder setCustomerEncryption(CustomerEncryption customerEncryption) {
      if (!Objects.equals(this.customerEncryption, customerEncryption)) {
        modifiedFields.add(BlobField.CUSTOMER_ENCRYPTION);
      }
      this.customerEncryption = customerEncryption;
      return this;
    }

    @Override
    Builder setKmsKeyName(String kmsKeyName) {
      if (!Objects.equals(this.kmsKeyName, kmsKeyName)) {
        modifiedFields.add(BlobField.KMS_KEY_NAME);
      }
      this.kmsKeyName = kmsKeyName;
      return this;
    }

    @Override
    public Builder setEventBasedHold(Boolean eventBasedHold) {
      if (!Objects.equals(this.eventBasedHold, eventBasedHold)) {
        modifiedFields.add(BlobField.EVENT_BASED_HOLD);
      }
      this.eventBasedHold = eventBasedHold;
      return this;
    }

    @Override
    public Builder setTemporaryHold(Boolean temporaryHold) {
      if (!Objects.equals(this.temporaryHold, temporaryHold)) {
        modifiedFields.add(BlobField.TEMPORARY_HOLD);
      }
      this.temporaryHold = temporaryHold;
      return this;
    }

    /**
     * @deprecated {@link #setRetentionExpirationTimeOffsetDateTime(OffsetDateTime)}
     */
    @Override
    @Deprecated
    Builder setRetentionExpirationTime(Long retentionExpirationTime) {
      return setRetentionExpirationTimeOffsetDateTime(
          millisOffsetDateTimeCodec.encode(retentionExpirationTime));
    }

    @Override
    Builder setRetentionExpirationTimeOffsetDateTime(OffsetDateTime retentionExpirationTime) {
      if (!Objects.equals(this.retentionExpirationTime, retentionExpirationTime)) {
        modifiedFields.add(BlobField.RETENTION_EXPIRATION_TIME);
      }
      this.retentionExpirationTime = retentionExpirationTime;
      return this;
    }

    @Override
    Builder setSoftDeleteTime(OffsetDateTime softDeleteTime) {
      if (!Objects.equals(this.softDeleteTime, softDeleteTime)) {
        modifiedFields.add(BlobField.SOFT_DELETE_TIME);
      }
      this.softDeleteTime = softDeleteTime;
      return this;
    }

    @Override
    Builder setHardDeleteTime(OffsetDateTime hardDeleteTime) {
      if (!Objects.equals(this.hardDeleteTime, hardDeleteTime)) {
        modifiedFields.add(BlobField.HARD_DELETE_TIME);
      }
      this.hardDeleteTime = hardDeleteTime;
      return this;
    }

    @Override
    public Builder setRetention(Retention retention) {
      // todo: b/308194853
      modifiedFields.add(BlobField.RETENTION);
      this.retention = retention;
      return this;
    }

    @Override
    public Builder setContexts(ObjectContexts contexts) {
      // Maps.difference uses object equality to determine if a value is the same. We don't care
      // about the timestamps when determining if a value needs to be patched. Create a new map
      // where we remove the timestamps so equals is usable.
      Map<String, ObjectCustomContextPayload> left =
          this.contexts == null ? null : this.contexts.getCustom();
      Map<String, ObjectCustomContextPayload> right =
          contexts == null ? null : contexts.getCustom();
      if (!Objects.equals(left, right)) {
        if (right != null) {
          diffMaps(
              NamedField.nested(BlobField.OBJECT_CONTEXTS, NamedField.literal("custom")),
              left,
              right,
              modifiedFields::add);
          this.contexts = contexts;
        } else {
          modifiedFields.add(BlobField.OBJECT_CONTEXTS);
          this.contexts = null;
        }
      }
      return this;
    }

    @Override
    public BlobInfo build() {
      checkNotNull(blobId);
      return new BlobInfo(this);
    }

    @Override
    BlobId getBlobId() {
      return blobId;
    }

    @Override
    Builder clearBlobId() {
      this.blobId = null;
      return this;
    }

    @Override
    Builder clearGeneratedId() {
      this.generatedId = null;
      return this;
    }

    @Override
    Builder clearContentType() {
      this.contentType = null;
      return this;
    }

    @Override
    Builder clearContentEncoding() {
      this.contentEncoding = null;
      return this;
    }

    @Override
    Builder clearContentDisposition() {
      this.contentDisposition = null;
      return this;
    }

    @Override
    Builder clearContentLanguage() {
      this.contentLanguage = null;
      return this;
    }

    @Override
    Builder clearComponentCount() {
      this.componentCount = null;
      return this;
    }

    @Override
    Builder clearCacheControl() {
      this.cacheControl = null;
      return this;
    }

    @Override
    Builder clearAcl() {
      this.acl = null;
      return this;
    }

    @Override
    Builder clearOwner() {
      this.owner = null;
      return this;
    }

    @Override
    Builder clearSize() {
      this.size = null;
      return this;
    }

    @Override
    Builder clearEtag() {
      this.etag = null;
      return this;
    }

    @Override
    Builder clearSelfLink() {
      this.selfLink = null;
      return this;
    }

    @Override
    Builder clearMd5() {
      this.md5 = null;
      return this;
    }

    @Override
    Builder clearCrc32c() {
      this.crc32c = null;
      return this;
    }

    @Override
    Builder clearCustomTime() {
      this.customTime = null;
      return this;
    }

    @Override
    Builder clearMediaLink() {
      this.mediaLink = null;
      return this;
    }

    @Override
    Builder clearMetadata() {
      this.metadata = null;
      return this;
    }

    @Override
    Builder clearMetageneration() {
      this.metageneration = null;
      return this;
    }

    @Override
    Builder clearDeleteTime() {
      this.deleteTime = null;
      return this;
    }

    @Override
    Builder clearUpdateTime() {
      this.updateTime = null;
      return this;
    }

    @Override
    Builder clearCreateTime() {
      this.createTime = null;
      return this;
    }

    @Override
    Builder clearIsDirectory() {
      this.isDirectory = null;
      return this;
    }

    @Override
    Builder clearCustomerEncryption() {
      this.customerEncryption = null;
      return this;
    }

    @Override
    Builder clearStorageClass() {
      this.storageClass = null;
      return this;
    }

    @Override
    Builder clearTimeStorageClassUpdated() {
      this.timeStorageClassUpdated = null;
      return this;
    }

    @Override
    Builder clearKmsKeyName() {
      this.kmsKeyName = null;
      return this;
    }

    @Override
    Builder clearEventBasedHold() {
      this.eventBasedHold = null;
      return this;
    }

    @Override
    Builder clearTemporaryHold() {
      this.temporaryHold = null;
      return this;
    }

    @Override
    Builder clearRetentionExpirationTime() {
      this.retentionExpirationTime = null;
      return this;
    }

    @Override
    Builder clearContexts() {
      this.contexts = null;
      return this;
    }
  }

  BlobInfo(BuilderImpl builder) {
    blobId = builder.blobId;
    generatedId = builder.generatedId;
    cacheControl = builder.cacheControl;
    contentEncoding = builder.contentEncoding;
    contentType = builder.contentType;
    contentDisposition = builder.contentDisposition;
    contentLanguage = builder.contentLanguage;
    componentCount = builder.componentCount;
    customerEncryption = builder.customerEncryption;
    acl = builder.acl;
    owner = builder.owner;
    size = builder.size;
    etag = builder.etag;
    selfLink = builder.selfLink;
    md5 = builder.md5;
    crc32c = builder.crc32c;
    customTime = builder.customTime;
    mediaLink = builder.mediaLink;
    metadata = builder.metadata;
    metageneration = builder.metageneration;
    deleteTime = builder.deleteTime;
    updateTime = builder.updateTime;
    createTime = builder.createTime;
    isDirectory = firstNonNull(builder.isDirectory, Boolean.FALSE);
    storageClass = builder.storageClass;
    timeStorageClassUpdated = builder.timeStorageClassUpdated;
    kmsKeyName = builder.kmsKeyName;
    eventBasedHold = builder.eventBasedHold;
    temporaryHold = builder.temporaryHold;
    retentionExpirationTime = builder.retentionExpirationTime;
    retention = builder.retention;
    softDeleteTime = builder.softDeleteTime;
    hardDeleteTime = builder.hardDeleteTime;
    contexts = builder.contexts;
    modifiedFields = builder.modifiedFields.build();
  }

  /** Returns the blob's identity. */
  public BlobId getBlobId() {
    return blobId;
  }

  /** Returns the name of the containing bucket. */
  public String getBucket() {
    return getBlobId().getBucket();
  }

  /** Returns the service-generated for the blob. */
  public String getGeneratedId() {
    return generatedId;
  }

  /** Returns the blob's name. */
  public String getName() {
    return getBlobId().getName();
  }

  /**
   * Returns the blob's data cache control.
   *
   * @see <a href="https://tools.ietf.org/html/rfc7234#section-5.2">Cache-Control</a>
   */
  public String getCacheControl() {
    return Data.isNull(cacheControl) ? null : cacheControl;
  }

  /**
   * Returns the blob's access control configuration.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
   *     About Access Control Lists</a>
   */
  public List<Acl> getAcl() {
    return acl;
  }

  /** Returns the blob's owner. This will always be the uploader of the blob. */
  public Acl.Entity getOwner() {
    return owner;
  }

  /**
   * Returns the content length of the data in bytes.
   *
   * @see <a href="https://tools.ietf.org/html/rfc2616#section-14.13">Content-Length</a>
   */
  public Long getSize() {
    return size;
  }

  /**
   * Returns the blob's data content type.
   *
   * @see <a href="https://tools.ietf.org/html/rfc2616#section-14.17">Content-Type</a>
   */
  public String getContentType() {
    return Data.isNull(contentType) ? null : contentType;
  }

  /**
   * Returns the blob's data content encoding.
   *
   * @see <a href="https://tools.ietf.org/html/rfc7231#section-3.1.2.2">Content-Encoding</a>
   */
  public String getContentEncoding() {
    return Data.isNull(contentEncoding) ? null : contentEncoding;
  }

  /**
   * Returns the blob's data content disposition.
   *
   * @see <a href="https://tools.ietf.org/html/rfc6266">Content-Disposition</a>
   */
  public String getContentDisposition() {
    return Data.isNull(contentDisposition) ? null : contentDisposition;
  }

  /**
   * Returns the blob's data content language.
   *
   * @see <a href="http://tools.ietf.org/html/bcp47">Content-Language</a>
   */
  public String getContentLanguage() {
    return Data.isNull(contentLanguage) ? null : contentLanguage;
  }

  /**
   * Returns the number of components that make up this blob. Components are accumulated through the
   * {@link Storage#compose(Storage.ComposeRequest)} operation and are limited to a count of 1024,
   * counting 1 for each non-composite component blob and componentCount for each composite
   * component blob. This value is set only for composite blobs.
   *
   * @see <a href="https://cloud.google.com/storage/docs/composite-objects#_Count">Component Count
   *     Property</a>
   */
  public Integer getComponentCount() {
    return componentCount;
  }

  /**
   * Returns HTTP 1.1 Entity tag for the blob.
   *
   * @see <a href="http://tools.ietf.org/html/rfc2616#section-3.11">Entity Tags</a>
   */
  public String getEtag() {
    return etag;
  }

  /** Returns the URI of this blob as a string. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * Returns the MD5 hash of blob's data encoded in base64.
   *
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">Hashes and ETags:
   *     Best Practices</a>
   */
  public String getMd5() {
    return Data.isNull(md5) ? null : md5;
  }

  /**
   * Returns the MD5 hash of blob's data decoded to string.
   *
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">Hashes and ETags:
   *     Best Practices</a>
   */
  public String getMd5ToHexString() {
    if (md5 == null) {
      return null;
    }
    byte[] decodedMd5 = BaseEncoding.base64().decode(md5);
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b : decodedMd5) {
      stringBuilder.append(String.format(Locale.US, "%02x", b & 0xff));
    }
    return stringBuilder.toString();
  }

  /**
   * Returns the CRC32C checksum of blob's data as described in <a
   * href="http://tools.ietf.org/html/rfc4960#appendix-B">RFC 4960, Appendix B;</a> encoded in
   * base64 in big-endian order.
   *
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">Hashes and ETags:
   *     Best Practices</a>
   */
  public String getCrc32c() {
    return Data.isNull(crc32c) ? null : crc32c;
  }

  /**
   * Returns the CRC32C checksum of blob's data as described in <a
   * href="http://tools.ietf.org/html/rfc4960#appendix-B">RFC 4960, Appendix B;</a> decoded to
   * string.
   *
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">Hashes and ETags:
   *     Best Practices</a>
   */
  public String getCrc32cToHexString() {
    if (crc32c == null) {
      return null;
    }
    byte[] decodeCrc32c = BaseEncoding.base64().decode(crc32c);
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b : decodeCrc32c) {
      stringBuilder.append(String.format(Locale.US, "%02x", b & 0xff));
    }
    return stringBuilder.toString();
  }

  /** Returns the blob's media download link. */
  public String getMediaLink() {
    return mediaLink;
  }

  /** Returns blob's user provided metadata. */
  @Nullable
  public Map<@NonNull String, @Nullable String> getMetadata() {
    return metadata == null || Data.isNull(metadata) ? null : Collections.unmodifiableMap(metadata);
  }

  /** Returns blob's data generation. Used for blob versioning. */
  public Long getGeneration() {
    return getBlobId().getGeneration();
  }

  /**
   * Returns blob's metageneration. Used for preconditions and for detecting changes in metadata. A
   * metageneration number is only meaningful in the context of a particular generation of a
   * particular blob.
   */
  public Long getMetageneration() {
    return metageneration;
  }

  /**
   * Returns the deletion time of the blob expressed as the number of milliseconds since the Unix
   * epoch.
   *
   * @deprecated Use {@link #getDeleteTimeOffsetDateTime()}
   */
  @Deprecated
  public Long getDeleteTime() {
    return millisOffsetDateTimeCodec.decode(deleteTime);
  }

  /** Returns the deletion time of the blob. */
  public OffsetDateTime getDeleteTimeOffsetDateTime() {
    return deleteTime;
  }

  /**
   * Returns the last modification time of the blob's metadata expressed as the number of
   * milliseconds since the Unix epoch.
   *
   * @deprecated Use {@link #getUpdateTimeOffsetDateTime()}
   */
  @Deprecated
  public Long getUpdateTime() {
    return millisOffsetDateTimeCodec.decode(updateTime);
  }

  /** Returns the last modification time of the blob's metadata. */
  public OffsetDateTime getUpdateTimeOffsetDateTime() {
    return updateTime;
  }

  /**
   * Returns the creation time of the blob expressed as the number of milliseconds since the Unix
   * epoch.
   *
   * @deprecated Use {@link #getCreateTimeOffsetDateTime()}
   */
  @Deprecated
  public Long getCreateTime() {
    return millisOffsetDateTimeCodec.decode(createTime);
  }

  /** Returns the creation time of the blob. */
  public OffsetDateTime getCreateTimeOffsetDateTime() {
    return createTime;
  }

  /**
   * Returns the custom time specified by the user for an object.
   *
   * @deprecated Use {@link #getCustomTimeOffsetDateTime()}
   */
  @Deprecated
  public Long getCustomTime() {
    return millisOffsetDateTimeCodec.decode(customTime);
  }

  /** Returns the custom time specified by the user for an object. */
  public OffsetDateTime getCustomTimeOffsetDateTime() {
    return customTime;
  }

  /**
   * Returns {@code true} if the current blob represents a directory. This can only happen if the
   * blob is returned by {@link Storage#list(String, Storage.BlobListOption...)} when the {@link
   * Storage.BlobListOption#currentDirectory()} option is used. When this is the case only {@link
   * #getBlobId()} and {@link #getSize()} are set for the current blob: {@link BlobId#getName()}
   * ends with the '/' character, {@link BlobId#getGeneration()} returns {@code null} and {@link
   * #getSize()} is {@code 0}.
   */
  public boolean isDirectory() {
    return isDirectory;
  }

  /**
   * Returns information on the customer-supplied encryption key, if the blob is encrypted using
   * such a key.
   */
  public CustomerEncryption getCustomerEncryption() {
    return customerEncryption;
  }

  /** Returns the storage class of the blob. */
  public StorageClass getStorageClass() {
    return storageClass;
  }

  /**
   * Returns the time that the object's storage class was last changed or the time of the object
   * creation.
   *
   * @deprecated Use {@link #getTimeStorageClassUpdatedOffsetDateTime()}
   */
  @Deprecated
  public Long getTimeStorageClassUpdated() {
    return millisOffsetDateTimeCodec.decode(timeStorageClassUpdated);
  }

  /**
   * Returns the time that the object's storage class was last changed or the time of the object
   * creation.
   */
  public OffsetDateTime getTimeStorageClassUpdatedOffsetDateTime() {
    return timeStorageClassUpdated;
  }

  /** Returns the Cloud KMS key used to encrypt the blob, if any. */
  public String getKmsKeyName() {
    return kmsKeyName;
  }

  /**
   * Returns a {@code Boolean} with either {@code true}, {@code null} and in certain cases {@code
   * false}.
   *
   * <p>Case 1: {@code true} the field {@link
   * com.google.cloud.storage.Storage.BlobField#EVENT_BASED_HOLD} is selected in a {@link
   * Storage#get(BlobId, Storage.BlobGetOption...)} and event-based hold for the blob is enabled.
   *
   * <p>Case 2.1: {@code null} the field {@link
   * com.google.cloud.storage.Storage.BlobField#EVENT_BASED_HOLD} is selected in a {@link
   * Storage#get(BlobId, Storage.BlobGetOption...)}, but event-based hold for the blob is not
   * enabled. This case can be considered implicitly {@code false}.
   *
   * <p>Case 2.2: {@code null} the field {@link
   * com.google.cloud.storage.Storage.BlobField#EVENT_BASED_HOLD} is not selected in a {@link
   * Storage#get(BlobId, Storage.BlobGetOption...)}, and the state for this field is unknown.
   *
   * <p>Case 3: {@code false} event-based hold is explicitly set to false using in a {@link
   * Builder#setEventBasedHold(Boolean)} client side for a follow-up request e.g. {@link
   * Storage#update(BlobInfo, Storage.BlobTargetOption...)} in which case the value of event-based
   * hold will remain {@code false} for the given instance.
   */
  @BetaApi
  public Boolean getEventBasedHold() {
    return Data.isNull(eventBasedHold) ? null : eventBasedHold;
  }

  /**
   * Returns a {@code Boolean} with either {@code true}, {@code null} and in certain cases {@code
   * false}.
   *
   * <p>Case 1: {@code true} the field {@link
   * com.google.cloud.storage.Storage.BlobField#TEMPORARY_HOLD} is selected in a {@link
   * Storage#get(BlobId, Storage.BlobGetOption...)} and temporary hold for the blob is enabled.
   *
   * <p>Case 2.1: {@code null} the field {@link
   * com.google.cloud.storage.Storage.BlobField#TEMPORARY_HOLD} is selected in a {@link
   * Storage#get(BlobId, Storage.BlobGetOption...)}, but temporary hold for the blob is not enabled.
   * This case can be considered implicitly {@code false}.
   *
   * <p>Case 2.2: {@code null} the field {@link
   * com.google.cloud.storage.Storage.BlobField#TEMPORARY_HOLD} is not selected in a {@link
   * Storage#get(BlobId, Storage.BlobGetOption...)}, and the state for this field is unknown.
   *
   * <p>Case 3: {@code false} event-based hold is explicitly set to false using in a {@link
   * Builder#setEventBasedHold(Boolean)} client side for a follow-up request e.g. {@link
   * Storage#update(BlobInfo, Storage.BlobTargetOption...)} in which case the value of temporary
   * hold will remain {@code false} for the given instance.
   */
  @BetaApi
  public Boolean getTemporaryHold() {
    return Data.isNull(temporaryHold) ? null : temporaryHold;
  }

  /**
   * Returns the retention expiration time of the blob as {@code Long}, if a retention period is
   * defined. If retention period is not defined this value returns {@code null}
   *
   * @deprecated Use {@link #getRetentionExpirationTimeOffsetDateTime()}
   */
  @BetaApi
  @Deprecated
  public Long getRetentionExpirationTime() {
    return Data.isNull(retentionExpirationTime)
        ? null
        : millisOffsetDateTimeCodec.decode(retentionExpirationTime);
  }

  /**
   * Returns the retention expiration time of the blob, if a retention period is defined. If
   * retention period is not defined this value returns {@code null}
   */
  @BetaApi
  public OffsetDateTime getRetentionExpirationTimeOffsetDateTime() {
    return retentionExpirationTime;
  }

  /** If this object has been soft-deleted, returns the time it was soft-deleted. */
  public OffsetDateTime getSoftDeleteTime() {
    return softDeleteTime;
  }

  /**
   * If this object has been soft-deleted, returns the time at which it will be permanently deleted.
   */
  public OffsetDateTime getHardDeleteTime() {
    return hardDeleteTime;
  }

  /** Returns the object's Retention policy. */
  public Retention getRetention() {
    return retention;
  }

  public ObjectContexts getContexts() {
    return contexts;
  }

  /** Returns a builder for the current blob. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bucket", getBucket())
        .add("name", getName())
        .add("generation", getGeneration())
        .add("size", getSize())
        .add("content-type", getContentType())
        .add("metadata", getMetadata())
        .add("contexts", getContexts())
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        blobId,
        generatedId,
        selfLink,
        cacheControl,
        acl,
        owner,
        size,
        etag,
        md5,
        crc32c,
        customTime,
        mediaLink,
        metadata,
        metageneration,
        deleteTime,
        updateTime,
        createTime,
        contentType,
        contentEncoding,
        contentDisposition,
        contentLanguage,
        storageClass,
        timeStorageClassUpdated,
        componentCount,
        isDirectory,
        customerEncryption,
        kmsKeyName,
        eventBasedHold,
        temporaryHold,
        retention,
        retentionExpirationTime,
        softDeleteTime,
        hardDeleteTime,
        contexts);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BlobInfo)) {
      return false;
    }
    BlobInfo blobInfo = (BlobInfo) o;
    return isDirectory == blobInfo.isDirectory
        && Objects.equals(blobId, blobInfo.blobId)
        && Objects.equals(generatedId, blobInfo.generatedId)
        && Objects.equals(selfLink, blobInfo.selfLink)
        && Objects.equals(cacheControl, blobInfo.cacheControl)
        && Objects.equals(acl, blobInfo.acl)
        && Objects.equals(owner, blobInfo.owner)
        && Objects.equals(size, blobInfo.size)
        && Objects.equals(etag, blobInfo.etag)
        && Objects.equals(md5, blobInfo.md5)
        && Objects.equals(crc32c, blobInfo.crc32c)
        && Objects.equals(customTime, blobInfo.customTime)
        && Objects.equals(mediaLink, blobInfo.mediaLink)
        && Objects.equals(metadata, blobInfo.metadata)
        && Objects.equals(metageneration, blobInfo.metageneration)
        && Objects.equals(deleteTime, blobInfo.deleteTime)
        && Objects.equals(updateTime, blobInfo.updateTime)
        && Objects.equals(createTime, blobInfo.createTime)
        && Objects.equals(contentType, blobInfo.contentType)
        && Objects.equals(contentEncoding, blobInfo.contentEncoding)
        && Objects.equals(contentDisposition, blobInfo.contentDisposition)
        && Objects.equals(contentLanguage, blobInfo.contentLanguage)
        && Objects.equals(storageClass, blobInfo.storageClass)
        && Objects.equals(timeStorageClassUpdated, blobInfo.timeStorageClassUpdated)
        && Objects.equals(componentCount, blobInfo.componentCount)
        && Objects.equals(customerEncryption, blobInfo.customerEncryption)
        && Objects.equals(kmsKeyName, blobInfo.kmsKeyName)
        && Objects.equals(eventBasedHold, blobInfo.eventBasedHold)
        && Objects.equals(temporaryHold, blobInfo.temporaryHold)
        && Objects.equals(retentionExpirationTime, blobInfo.retentionExpirationTime)
        && Objects.equals(retention, blobInfo.retention)
        && Objects.equals(softDeleteTime, blobInfo.softDeleteTime)
        && Objects.equals(hardDeleteTime, blobInfo.hardDeleteTime)
        && Objects.equals(contexts, blobInfo.contexts);
  }

  ImmutableSet<NamedField> getModifiedFields() {
    return modifiedFields;
  }

  /**
   * Attach this instance to an instance of {@link Storage} thereby allowing RPCs to be performed
   * using the methods from the resulting {@link Blob}
   */
  Blob asBlob(Storage storage) {
    return new Blob(storage, new BuilderImpl(this));
  }

  /** Returns a {@code BlobInfo} builder where blob identity is set using the provided values. */
  public static Builder newBuilder(BucketInfo bucketInfo, String name) {
    return newBuilder(bucketInfo.getName(), name);
  }

  /** Returns a {@code BlobInfo} builder where blob identity is set using the provided values. */
  public static Builder newBuilder(String bucket, String name) {
    return newBuilder(BlobId.of(bucket, name));
  }

  /** Returns a {@code BlobInfo} builder where blob identity is set using the provided values. */
  public static Builder newBuilder(BucketInfo bucketInfo, String name, Long generation) {
    return newBuilder(bucketInfo.getName(), name, generation);
  }

  /** Returns a {@code BlobInfo} builder where blob identity is set using the provided values. */
  public static Builder newBuilder(String bucket, String name, Long generation) {
    return newBuilder(BlobId.of(bucket, name, generation));
  }

  /** Returns a {@code BlobInfo} builder where blob identity is set using the provided value. */
  public static Builder newBuilder(BlobId blobId) {
    return new BuilderImpl(blobId);
  }
}
