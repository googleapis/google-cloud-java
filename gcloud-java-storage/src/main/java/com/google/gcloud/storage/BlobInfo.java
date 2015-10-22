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
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.AbstractMap;
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

    public Builder blobId(BlobId blobId) {
      this.blobId = checkNotNull(blobId);
      return this;
    }

    Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder contentType(String contentType) {
      this.contentType = firstNonNull(contentType, Data.<String>nullOf(String.class));
      return this;
    }

    public Builder contentDisposition(String contentDisposition) {
      this.contentDisposition = firstNonNull(contentDisposition, Data.<String>nullOf(String.class));
      return this;
    }

    public Builder contentLanguage(String contentLanguage) {
      this.contentLanguage = firstNonNull(contentLanguage, Data.<String>nullOf(String.class));
      return this;
    }

    public Builder contentEncoding(String contentEncoding) {
      this.contentEncoding = firstNonNull(contentEncoding, Data.<String>nullOf(String.class));
      return this;
    }

    Builder componentCount(Integer componentCount) {
      this.componentCount = componentCount;
      return this;
    }

    public Builder cacheControl(String cacheControl) {
      this.cacheControl = firstNonNull(cacheControl, Data.<String>nullOf(String.class));
      return this;
    }

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

    public Builder md5(String md5) {
      this.md5 = firstNonNull(md5, Data.<String>nullOf(String.class));
      return this;
    }

    public Builder crc32c(String crc32c) {
      this.crc32c = firstNonNull(crc32c, Data.<String>nullOf(String.class));
      return this;
    }

    Builder mediaLink(String mediaLink) {
      this.mediaLink = mediaLink;
      return this;
    }

    public Builder metadata(Map<String, String> metadata) {
      this.metadata = metadata != null ?
          ImmutableMap.copyOf(metadata) : Data.<Map>nullOf(ImmutableEmptyMap.class);
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

  public BlobId blobId() {
    return blobId;
  }

  public String bucket() {
    return blobId().bucket();
  }

  public String id() {
    return id;
  }

  public String name() {
    return blobId().name();
  }

  public String cacheControl() {
    return Data.isNull(cacheControl) ? null : cacheControl;
  }

  public List<Acl> acl() {
    return acl;
  }

  public Acl.Entity owner() {
    return owner;
  }

  public Long size() {
    return size;
  }

  public String contentType() {
    return Data.isNull(contentType) ? null : contentType;
  }

  public String contentEncoding() {
    return Data.isNull(contentEncoding) ? null : contentEncoding;
  }

  public String contentDisposition() {
    return Data.isNull(contentDisposition) ? null : contentDisposition;
  }

  public String contentLanguage() {
    return Data.isNull(contentLanguage) ? null : contentLanguage;
  }

  public Integer componentCount() {
    return componentCount;
  }

  public String etag() {
    return etag;
  }

  public String selfLink() {
    return selfLink;
  }

  public String md5() {
    return Data.isNull(md5) ? null : md5;
  }

  public String crc32c() {
    return Data.isNull(crc32c) ? null : crc32c;
  }

  public String mediaLink() {
    return mediaLink;
  }

  public Map<String, String> metadata() {
    return Data.isNull(metadata) ? null : metadata;
  }

  public Long generation() {
    return generation;
  }

  public Long metageneration() {
    return metageneration;
  }

  public Long deleteTime() {
    return deleteTime;
  }

  public Long updateTime() {
    return updateTime;
  }

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
    storageObject.setCacheControl(cacheControl);
    storageObject.setContentEncoding(contentEncoding);
    storageObject.setCrc32c(crc32c);
    storageObject.setContentType(contentType);
    storageObject.setGeneration(generation);
    storageObject.setMd5Hash(md5);
    storageObject.setMediaLink(mediaLink);
    storageObject.setMetadata(metadata);
    storageObject.setMetageneration(metageneration);
    storageObject.setContentDisposition(contentDisposition);
    storageObject.setComponentCount(componentCount);
    storageObject.setContentLanguage(contentLanguage);
    storageObject.setEtag(etag);
    storageObject.setId(id);
    storageObject.setSelfLink(selfLink);
    return storageObject;
  }

  public static Builder builder(BucketInfo bucketInfo, String name) {
    return builder(bucketInfo.name(), name);
  }

  public static Builder builder(String bucket, String name) {
    return new Builder().blobId(BlobId.of(bucket, name));
  }

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
