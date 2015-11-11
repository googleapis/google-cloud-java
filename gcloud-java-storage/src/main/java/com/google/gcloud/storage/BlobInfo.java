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
public final class BlobInfo implements Serializable {

  static final Function<StorageObject, BlobInfo> FROM_PB_FUNCTION =
      new Function<StorageObject, BlobInfo>() {
        @Override
        public BlobInfo apply(StorageObject pb) {
          return BlobInfo.fromPb(pb);
        }
      };
  static final Function<BlobInfo, StorageObject> TO_PB_FUNCTION =
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
  private final Long generation;
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

  public static final class Builder {

    private BlobId blobId;
    private String id;
    private String contentType;
    private String contentEncoding;
    private String contentDisposition;
    private String contentLanguage;
    private Integer componentCount;
    private String cacheControl;
    private ImmutableList<Acl> acl;
    private Acl.Entity owner;
    private Long size;
    private String etag;
    private String selfLink;
    private String md5;
    private String crc32c;
    private String mediaLink;
    private Map<String, String> metadata;
    private Long generation;
    private Long metageneration;
    private Long deleteTime;
    private Long updateTime;

    private Builder() {}

    /**
     * Sets the blob identity.
     */
    public Builder blobId(BlobId blobId) {
      this.blobId = checkNotNull(blobId);
      return this;
    }

    Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the blob's data content type.
     */
    public Builder contentType(String contentType) {
      this.contentType = firstNonNull(contentType, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the blob's data content disposition.
     */
    public Builder contentDisposition(String contentDisposition) {
      this.contentDisposition = firstNonNull(contentDisposition, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the blob's data content language.
     */
    public Builder contentLanguage(String contentLanguage) {
      this.contentLanguage = firstNonNull(contentLanguage, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the blob's data content encoding.
     */
    public Builder contentEncoding(String contentEncoding) {
      this.contentEncoding = firstNonNull(contentEncoding, Data.<String>nullOf(String.class));
      return this;
    }

    Builder componentCount(Integer componentCount) {
      this.componentCount = componentCount;
      return this;
    }

    /**
     * Sets the blob's data cache control.
     */
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
    public Builder acl(List<Acl> acl) {
      this.acl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
    }

    Builder owner(Acl.Entity owner) {
      this.owner = owner;
      return this;
    }

    Builder size(Long size) {
      this.size = size;
      return this;
    }

    Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * Sets the MD5 hash of blob's data. MD5 value must be encoded in base64.
     */
    public Builder md5(String md5) {
      this.md5 = firstNonNull(md5, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the CRC32C checksum of blob's data. CRC32C value must be encoded in base64 in big-endian
     * order.
     */
    public Builder crc32c(String crc32c) {
      this.crc32c = firstNonNull(crc32c, Data.<String>nullOf(String.class));
      return this;
    }

    Builder mediaLink(String mediaLink) {
      this.mediaLink = mediaLink;
      return this;
    }

    /**
     * Sets the blob's metadata.
     */
    public Builder metadata(Map<String, String> metadata) {
      this.metadata = metadata != null
          ? new HashMap(metadata) : Data.<Map>nullOf(ImmutableEmptyMap.class);
      return this;
    }

    Builder generation(Long generation) {
      this.generation = generation;
      return this;
    }

    Builder metageneration(Long metageneration) {
      this.metageneration = metageneration;
      return this;
    }

    Builder deleteTime(Long deleteTime) {
      this.deleteTime = deleteTime;
      return this;
    }

    Builder updateTime(Long updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    /**
     * Creates a {@code BlobInfo} object.
     */
    public BlobInfo build() {
      checkNotNull(blobId);
      return new BlobInfo(this);
    }
  }

  private BlobInfo(Builder builder) {
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
    generation = builder.generation;
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
   * Returns the blob's owner.
   */
  public Acl.Entity owner() {
    return owner;
  }

  /**
   * Returns the blob's data size in bytes.
   */
  public Long size() {
    return size;
  }

  /**
   * Returns the blob's data content type.
   */
  public String contentType() {
    return Data.isNull(contentType) ? null : contentType;
  }

  /**
   * Returns the blob's data content encoding.
   */
  public String contentEncoding() {
    return Data.isNull(contentEncoding) ? null : contentEncoding;
  }

  /**
   * Returns the blob's data content disposition.
   */
  public String contentDisposition() {
    return Data.isNull(contentDisposition) ? null : contentDisposition;
  }

  /**
   * Returns the blob's data content language.
   */
  public String contentLanguage() {
    return Data.isNull(contentLanguage) ? null : contentLanguage;
  }

  /**
   * Returns the number of components that make up this object. Components are accumulated through
   * the {@link Storage#compose(Storage.ComposeRequest)} operation.
   *
   * @see <a href="https://cloud.google.com/storage/docs/composite-objects#_Count">Component Count
   *     Property</a>
   */
  public Integer componentCount() {
    return componentCount;
  }

  /**
   * Returns blob resource's entity tag.
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
   */
  public String md5() {
    return Data.isNull(md5) ? null : md5;
  }

  /**
   * Returns the CRC32C checksum of blob's data encoded in base64 in big-endian order.
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
   * Returns blob's metadata.
   */
  public Map<String, String> metadata() {
    return metadata == null || Data.isNull(metadata) ? null : Collections.unmodifiableMap(metadata);
  }

  /**
   * Returns blob's data generation.
   */
  public Long generation() {
    return generation;
  }

  /**
   * Returns blob's metageneration.
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
    return new Builder()
        .blobId(blobId)
        .id(id)
        .generation(generation)
        .cacheControl(cacheControl)
        .contentEncoding(contentEncoding)
        .contentType(contentType)
        .contentDisposition(contentDisposition)
        .contentLanguage(contentLanguage)
        .componentCount(componentCount)
        .crc32c(crc32c)
        .md5(md5)
        .deleteTime(deleteTime)
        .updateTime(updateTime)
        .mediaLink(mediaLink)
        .metadata(metadata)
        .metageneration(metageneration)
        .acl(acl)
        .owner(owner)
        .size(size)
        .etag(etag)
        .selfLink(selfLink);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bucket", bucket())
        .add("name", name())
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
    return obj instanceof BlobInfo && Objects.equals(toPb(), ((BlobInfo) obj).toPb());
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
      for (String key : metadata.keySet()) {
        pbMetadata.put(key, firstNonNull(metadata.get(key), Data.<String>nullOf(String.class)));
      }
    }
    storageObject.setMetadata(pbMetadata);
    storageObject.setCacheControl(cacheControl);
    storageObject.setContentEncoding(contentEncoding);
    storageObject.setCrc32c(crc32c);
    storageObject.setContentType(contentType);
    storageObject.setGeneration(generation);
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
    return new Builder().blobId(BlobId.of(bucket, name));
  }

  /**
   * Returns a {@code BlobInfo} builder where blob identity is set to the provided value.
   */
  public static Builder builder(BlobId blobId) {
    return new Builder().blobId(blobId);
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
    if (storageObject.getGeneration() != null) {
      builder.generation(storageObject.getGeneration());
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
