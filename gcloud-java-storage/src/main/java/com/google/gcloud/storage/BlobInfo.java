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

package com.google.gcloud.storage;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.StorageObject.Owner;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Google Storage object metadata.
 *
 * @see <a href="https://cloud.google.com/storage/docs/concepts-techniques#concepts">Concepts and
 *      Terminology</a>
 */
public class BlobInfo implements Serializable {

  static final Function<StorageObject, BlobInfo> INFO_FROM_PB_FUNCTION =
      new Function<StorageObject, BlobInfo>() {
        @Override
        public BlobInfo apply(StorageObject pb) {
          return BlobInfo.fromPb(pb);
        }
      };
  static final Function<BlobInfo, StorageObject> INFO_TO_PB_FUNCTION =
      new Function<BlobInfo, StorageObject>() {
        @Override
        public StorageObject apply(BlobInfo blobInfo) {
          return blobInfo.toPb();
        }
      };

  private static final long serialVersionUID = 2228487739943277159L;
  private final BlobId blobId;
  private final String id;
  private final String selfLink;
  private final String cacheControl;
  private final List<Acl> acl;
  private final Acl.Entity owner;
  private final Long size;
  private final String etag;
  private final String md5;
  private final String crc32c;
  private final String mediaLink;
  private final Map<String, String> metadata;
  private final Long metageneration;
  private final Long deleteTime;
  private final Long updateTime;
  private final String contentType;
  private final String contentEncoding;
  private final String contentDisposition;
  private final String contentLanguage;
  private final Integer componentCount;

  /**
   * This class is meant for internal use only. Users are discouraged from using this class.
   */
  public static final class ImmutableEmptyMap<K, V> extends AbstractMap<K, V> {

    @Override
    public Set<Entry<K, V>> entrySet() {
      return ImmutableSet.of();
    }
  }

  public static abstract class Builder {

    /**
     * Sets the blob identity.
     */
    public abstract Builder blobId(BlobId blobId);

    abstract Builder id(String id);

    /**
     * Sets the blob's data content type.
     *
     * @see <a href="https://tools.ietf.org/html/rfc2616#section-14.17">Content-Type</a>
     */
    public abstract Builder contentType(String contentType);

    /**
     * Sets the blob's data content disposition.
     *
     * @see <a href="https://tools.ietf.org/html/rfc6266">Content-Disposition</a>
     */
    public abstract Builder contentDisposition(String contentDisposition);

    /**
     * Sets the blob's data content language.
     *
     * @see <a href="http://tools.ietf.org/html/bcp47">Content-Language</a>
     */
    public abstract Builder contentLanguage(String contentLanguage);

    /**
     * Sets the blob's data content encoding.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-3.1.2.2">Content-Encoding</a>
     */
    public abstract Builder contentEncoding(String contentEncoding);

    abstract Builder componentCount(Integer componentCount);

    /**
     * Sets the blob's data cache control.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7234#section-5.2">Cache-Control</a>
     */
    public abstract Builder cacheControl(String cacheControl);

    /**
     * Sets the blob's access control configuration.
     *
     * @see <a
     * href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
     *     About Access Control Lists</a>
     */
    public abstract Builder acl(List<Acl> acl);

    abstract Builder owner(Acl.Entity owner);

    abstract Builder size(Long size);

    abstract Builder etag(String etag);

    abstract Builder selfLink(String selfLink);

    /**
     * Sets the MD5 hash of blob's data. MD5 value must be encoded in base64.
     *
     * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">
     *     Hashes and ETags: Best Practices</a>
     */
    public abstract Builder md5(String md5);

    /**
     * Sets the CRC32C checksum of blob's data as described in
     * <a href="http://tools.ietf.org/html/rfc4960#appendix-B">RFC 4960, Appendix B;</a> encoded in
     * base64 in big-endian order.
     *
     * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">
     *     Hashes and ETags: Best Practices</a>
     */
    public abstract Builder crc32c(String crc32c);

    abstract Builder mediaLink(String mediaLink);

    /**
     * Sets the blob's user provided metadata.
     */
    public abstract Builder metadata(Map<String, String> metadata);

    abstract Builder metageneration(Long metageneration);

    abstract Builder deleteTime(Long deleteTime);

    abstract Builder updateTime(Long updateTime);

    /**
     * Creates a {@code BlobInfo} object.
     */
    public abstract BlobInfo build();
  }

  static final class BuilderImpl extends Builder {

    private BlobId blobId;
    private String id;
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
    private String mediaLink;
    private Map<String, String> metadata;
    private Long metageneration;
    private Long deleteTime;
    private Long updateTime;

    BuilderImpl() {}

    BuilderImpl(BlobInfo blobInfo) {
      blobId = blobInfo.blobId;
      id = blobInfo.id;
      cacheControl = blobInfo.cacheControl;
      contentEncoding = blobInfo.contentEncoding;
      contentType = blobInfo.contentType;
      contentDisposition = blobInfo.contentDisposition;
      contentLanguage = blobInfo.contentLanguage;
      componentCount = blobInfo.componentCount;
      acl = blobInfo.acl;
      owner = blobInfo.owner;
      size = blobInfo.size;
      etag = blobInfo.etag;
      selfLink = blobInfo.selfLink;
      md5 = blobInfo.md5;
      crc32c = blobInfo.crc32c;
      mediaLink = blobInfo.mediaLink;
      metadata = blobInfo.metadata;
      metageneration = blobInfo.metageneration;
      deleteTime = blobInfo.deleteTime;
      updateTime = blobInfo.updateTime;
    }

    /**
     * Sets the blob identity.
     */
    @Override
    public Builder blobId(BlobId blobId) {
      this.blobId = checkNotNull(blobId);
      return this;
    }

    @Override
    Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the blob's data content type.
     *
     * @see <a href="https://tools.ietf.org/html/rfc2616#section-14.17">Content-Type</a>
     */
    @Override
    public Builder contentType(String contentType) {
      this.contentType = firstNonNull(contentType, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the blob's data content disposition.
     *
     * @see <a href="https://tools.ietf.org/html/rfc6266">Content-Disposition</a>
     */
    @Override
    public Builder contentDisposition(String contentDisposition) {
      this.contentDisposition = firstNonNull(contentDisposition, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the blob's data content language.
     *
     * @see <a href="http://tools.ietf.org/html/bcp47">Content-Language</a>
     */
    @Override
    public Builder contentLanguage(String contentLanguage) {
      this.contentLanguage = firstNonNull(contentLanguage, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the blob's data content encoding.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-3.1.2.2">Content-Encoding</a>
     */
    @Override
    public Builder contentEncoding(String contentEncoding) {
      this.contentEncoding = firstNonNull(contentEncoding, Data.<String>nullOf(String.class));
      return this;
    }

    @Override
    Builder componentCount(Integer componentCount) {
      this.componentCount = componentCount;
      return this;
    }

    /**
     * Sets the blob's data cache control.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7234#section-5.2">Cache-Control</a>
     */
    @Override
    public Builder cacheControl(String cacheControl) {
      this.cacheControl = firstNonNull(cacheControl, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the blob's access control configuration.
     *
     * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
     *     About Access Control Lists</a>
     */
    @Override
    public Builder acl(List<Acl> acl) {
      this.acl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
    }

    @Override
    Builder owner(Acl.Entity owner) {
      this.owner = owner;
      return this;
    }

    @Override
    Builder size(Long size) {
      this.size = size;
      return this;
    }

    @Override
    Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    @Override
    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * Sets the MD5 hash of blob's data. MD5 value must be encoded in base64.
     *
     * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">
     *     Hashes and ETags: Best Practices</a>
     */
    @Override
    public Builder md5(String md5) {
      this.md5 = firstNonNull(md5, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the CRC32C checksum of blob's data as described in
     * <a href="http://tools.ietf.org/html/rfc4960#appendix-B">RFC 4960, Appendix B;</a> encoded in
     * base64 in big-endian order.
     *
     * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">
     *     Hashes and ETags: Best Practices</a>
     */
    @Override
    public Builder crc32c(String crc32c) {
      this.crc32c = firstNonNull(crc32c, Data.<String>nullOf(String.class));
      return this;
    }

    @Override
    Builder mediaLink(String mediaLink) {
      this.mediaLink = mediaLink;
      return this;
    }

    /**
     * Sets the blob's user provided metadata.
     */
    @Override
    public Builder metadata(Map<String, String> metadata) {
      this.metadata = metadata != null
          ? new HashMap<>(metadata) : Data.<Map<String, String>>nullOf(ImmutableEmptyMap.class);
      return this;
    }

    @Override
    Builder metageneration(Long metageneration) {
      this.metageneration = metageneration;
      return this;
    }

    @Override
    Builder deleteTime(Long deleteTime) {
      this.deleteTime = deleteTime;
      return this;
    }

    @Override
    Builder updateTime(Long updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    /**
     * Creates a {@code BlobInfo} object.
     */
    @Override
    public BlobInfo build() {
      checkNotNull(blobId);
      return new BlobInfo(this);
    }
  }

  BlobInfo(BuilderImpl builder) {
    blobId = builder.blobId;
    id = builder.id;
    cacheControl = builder.cacheControl;
    contentEncoding = builder.contentEncoding;
    contentType = builder.contentType;
    contentDisposition = builder.contentDisposition;
    contentLanguage = builder.contentLanguage;
    componentCount = builder.componentCount;
    acl = builder.acl;
    owner = builder.owner;
    size = builder.size;
    etag = builder.etag;
    selfLink = builder.selfLink;
    md5 = builder.md5;
    crc32c = builder.crc32c;
    mediaLink = builder.mediaLink;
    metadata = builder.metadata;
    metageneration = builder.metageneration;
    deleteTime = builder.deleteTime;
    updateTime = builder.updateTime;
  }

  /**
   * Returns the blob's identity.
   */
  public BlobId blobId() {
    return blobId;
  }

  /**
   * Returns the name of the containing bucket.
   */
  public String bucket() {
    return blobId().bucket();
  }

  /**
   * Returns the blob's id.
   */
  public String id() {
    return id;
  }

  /**
   * Returns the blob's name.
   */
  public String name() {
    return blobId().name();
  }

  /**
   * Returns the blob's data cache control.
   *
   * @see <a href="https://tools.ietf.org/html/rfc7234#section-5.2">Cache-Control</a>
   */
  public String cacheControl() {
    return Data.isNull(cacheControl) ? null : cacheControl;
  }

  /**
   * Returns the blob's access control configuration.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
   *     About Access Control Lists</a>
   */
  public List<Acl> acl() {
    return acl;
  }

  /**
   * Returns the blob's owner. This will always be the uploader of the blob.
   */
  public Acl.Entity owner() {
    return owner;
  }

  /**
   * Returns the content length of the data in bytes.
   *
   * @see <a href="https://tools.ietf.org/html/rfc2616#section-14.13">Content-Length</a>
   */
  public Long size() {
    return size;
  }

  /**
   * Returns the blob's data content type.
   *
   * @see <a href="https://tools.ietf.org/html/rfc2616#section-14.17">Content-Type</a>
   */
  public String contentType() {
    return Data.isNull(contentType) ? null : contentType;
  }

  /**
   * Returns the blob's data content encoding.
   *
   * @see <a href="https://tools.ietf.org/html/rfc7231#section-3.1.2.2">Content-Encoding</a>
   */
  public String contentEncoding() {
    return Data.isNull(contentEncoding) ? null : contentEncoding;
  }

  /**
   * Returns the blob's data content disposition.
   *
   * @see <a href="https://tools.ietf.org/html/rfc6266">Content-Disposition</a>
   */
  public String contentDisposition() {
    return Data.isNull(contentDisposition) ? null : contentDisposition;
  }

  /**
   * Returns the blob's data content language.
   *
   * @see <a href="http://tools.ietf.org/html/bcp47">Content-Language</a>
   */
  public String contentLanguage() {
    return Data.isNull(contentLanguage) ? null : contentLanguage;
  }

  /**
   * Returns the number of components that make up this blob. Components are accumulated through
   * the {@link Storage#compose(Storage.ComposeRequest)} operation and are limited to a count of
   * 1024, counting 1 for each non-composite component blob and componentCount for each composite
   * component blob. This value is set only for composite blobs.
   *
   * @see <a href="https://cloud.google.com/storage/docs/composite-objects#_Count">Component Count
   *     Property</a>
   */
  public Integer componentCount() {
    return componentCount;
  }

  /**
   * Returns HTTP 1.1 Entity tag for the blob.
   *
   * @see <a href="http://tools.ietf.org/html/rfc2616#section-3.11">Entity Tags</a>
   */
  public String etag() {
    return etag;
  }

  /**
   * Returns the URI of this blob as a string.
   */
  public String selfLink() {
    return selfLink;
  }

  /**
   * Returns the MD5 hash of blob's data encoded in base64.
   *
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">
   *     Hashes and ETags: Best Practices</a>
   */
  public String md5() {
    return Data.isNull(md5) ? null : md5;
  }

  /**
   * Returns the CRC32C checksum of blob's data as described in
   * <a href="http://tools.ietf.org/html/rfc4960#appendix-B">RFC 4960, Appendix B;</a> encoded in
   * base64 in big-endian order.
   *
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">
   *     Hashes and ETags: Best Practices</a>
   */
  public String crc32c() {
    return Data.isNull(crc32c) ? null : crc32c;
  }

  /**
   * Returns the blob's media download link.
   */
  public String mediaLink() {
    return mediaLink;
  }

  /**
   * Returns blob's user provided metadata.
   */
  public Map<String, String> metadata() {
    return metadata == null || Data.isNull(metadata) ? null : Collections.unmodifiableMap(metadata);
  }

  /**
   * Returns blob's data generation. Used for blob versioning.
   */
  public Long generation() {
    return blobId().generation();
  }

  /**
   * Returns blob's metageneration. Used for preconditions and for detecting changes in metadata.
   * A metageneration number is only meaningful in the context of a particular generation of a
   * particular blob.
   */
  public Long metageneration() {
    return metageneration;
  }

  /**
   * Returns the deletion time of the blob.
   */
  public Long deleteTime() {
    return deleteTime;
  }

  /**
   * Returns the last modification time of the blob's metadata.
   */
  public Long updateTime() {
    return updateTime;
  }

  /**
   * Returns a builder for the current blob.
   */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bucket", bucket())
        .add("name", name())
        .add("generation", generation())
        .add("size", size())
        .add("content-type", contentType())
        .add("metadata", metadata())
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(blobId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj.getClass().equals(BlobInfo.class) && Objects.equals(toPb(), ((BlobInfo) obj).toPb());
  }

  StorageObject toPb() {
    StorageObject storageObject = blobId.toPb();
    if (acl != null) {
      storageObject.setAcl(Lists.transform(acl, new Function<Acl, ObjectAccessControl>() {
        @Override
        public ObjectAccessControl apply(Acl acl) {
          return acl.toObjectPb();
        }
      }));
    }
    if (deleteTime != null) {
      storageObject.setTimeDeleted(new DateTime(deleteTime));
    }
    if (updateTime != null) {
      storageObject.setUpdated(new DateTime(updateTime));
    }
    if (size != null) {
      storageObject.setSize(BigInteger.valueOf(size));
    }
    if (owner != null) {
      storageObject.setOwner(new Owner().setEntity(owner.toPb()));
    }
    Map<String, String> pbMetadata = metadata;
    if (metadata != null && !Data.isNull(metadata)) {
      pbMetadata = Maps.newHashMapWithExpectedSize(metadata.size());
      for (Map.Entry<String, String> entry : metadata.entrySet()) {
        pbMetadata.put(entry.getKey(),
            firstNonNull(entry.getValue(), Data.<String>nullOf(String.class)));
      }
    }
    storageObject.setMetadata(pbMetadata);
    storageObject.setCacheControl(cacheControl);
    storageObject.setContentEncoding(contentEncoding);
    storageObject.setCrc32c(crc32c);
    storageObject.setContentType(contentType);
    storageObject.setMd5Hash(md5);
    storageObject.setMediaLink(mediaLink);
    storageObject.setMetageneration(metageneration);
    storageObject.setContentDisposition(contentDisposition);
    storageObject.setComponentCount(componentCount);
    storageObject.setContentLanguage(contentLanguage);
    storageObject.setEtag(etag);
    storageObject.setId(id);
    storageObject.setSelfLink(selfLink);
    return storageObject;
  }

  /**
   * Returns a {@code BlobInfo} builder where blob identity is set using the provided values.
   */
  public static Builder builder(BucketInfo bucketInfo, String name) {
    return builder(bucketInfo.name(), name);
  }

  /**
   * Returns a {@code BlobInfo} builder where blob identity is set using the provided values.
   */
  public static Builder builder(String bucket, String name) {
    return new BuilderImpl().blobId(BlobId.of(bucket, name));
  }

  /**
   * Returns a {@code BlobInfo} builder where blob identity is set using the provided values.
   */
  public static Builder builder(BucketInfo bucketInfo, String name, Long generation) {
    return builder(bucketInfo.name(), name, generation);
  }

  /**
   * Returns a {@code BlobInfo} builder where blob identity is set using the provided values.
   */
  public static Builder builder(String bucket, String name, Long generation) {
    return new BuilderImpl().blobId(BlobId.of(bucket, name, generation));
  }

  public static Builder builder(BlobId blobId) {
    return new BuilderImpl().blobId(blobId);
  }

  static BlobInfo fromPb(StorageObject storageObject) {
    Builder builder = builder(BlobId.fromPb(storageObject));
    if (storageObject.getCacheControl() != null) {
      builder.cacheControl(storageObject.getCacheControl());
    }
    if (storageObject.getContentEncoding() != null) {
      builder.contentEncoding(storageObject.getContentEncoding());
    }
    if (storageObject.getCrc32c() != null) {
      builder.crc32c(storageObject.getCrc32c());
    }
    if (storageObject.getContentType() != null) {
      builder.contentType(storageObject.getContentType());
    }
    if (storageObject.getMd5Hash() != null) {
      builder.md5(storageObject.getMd5Hash());
    }
    if (storageObject.getMediaLink() != null) {
      builder.mediaLink(storageObject.getMediaLink());
    }
    if (storageObject.getMetageneration() != null) {
      builder.metageneration(storageObject.getMetageneration());
    }
    if (storageObject.getContentDisposition() != null) {
      builder.contentDisposition(storageObject.getContentDisposition());
    }
    if (storageObject.getComponentCount() != null) {
      builder.componentCount(storageObject.getComponentCount());
    }
    if (storageObject.getContentLanguage() != null) {
      builder.contentLanguage(storageObject.getContentLanguage());
    }
    if (storageObject.getEtag() != null) {
      builder.etag(storageObject.getEtag());
    }
    if (storageObject.getId() != null) {
      builder.id(storageObject.getId());
    }
    if (storageObject.getSelfLink() != null) {
      builder.selfLink(storageObject.getSelfLink());
    }
    if (storageObject.getMetadata() != null) {
      builder.metadata(storageObject.getMetadata());
    }
    if (storageObject.getTimeDeleted() != null) {
      builder.deleteTime(storageObject.getTimeDeleted().getValue());
    }
    if (storageObject.getUpdated() != null) {
      builder.updateTime(storageObject.getUpdated().getValue());
    }
    if (storageObject.getSize() != null) {
      builder.size(storageObject.getSize().longValue());
    }
    if (storageObject.getOwner() != null) {
      builder.owner(Acl.Entity.fromPb(storageObject.getOwner().getEntity()));
    }
    if (storageObject.getAcl() != null) {
      builder.acl(Lists.transform(storageObject.getAcl(), new Function<ObjectAccessControl, Acl>() {
        @Override
        public Acl apply(ObjectAccessControl objectAccessControl) {
          return Acl.fromPb(objectAccessControl);
        }
      }));
    }
    return builder.build();
  }
}
