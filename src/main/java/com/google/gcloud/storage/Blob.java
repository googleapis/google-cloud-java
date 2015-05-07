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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.StorageObject.Owner;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class Blob implements Serializable {

  private static final long serialVersionUID = 2228487739943277159L;

  static final Function<StorageObject, Blob> FROM_PB_FUNCTION =
      new Function<StorageObject, Blob>() {
        @Override
        public Blob apply(StorageObject pb) {
          return Blob.fromPb(pb);
        }
      };

  static final Function<Blob, StorageObject> TO_PB_FUNCTION = new Function<Blob, StorageObject>() {
    @Override
    public StorageObject apply(Blob blob) {
      return blob.toPb();
    }
  };

  private final String bucket;
  private final String id;
  private final String name;
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

  public static final class Builder {

    private String bucket;
    private String id;
    private String name;
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
    private ImmutableMap<String, String> metadata;
    private Long generation;
    private Long metageneration;
    private Long deleteTime;
    private Long updateTime;

    private Builder() {}

    public Builder bucket(String bucket) {
      this.bucket = checkNotNull(bucket);
      return this;
    }

    Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    Builder contentDisposition(String contentDisposition) {
      this.contentDisposition = contentDisposition;
      return this;
    }

    Builder contentLanguage(String contentLanguage) {
      this.contentLanguage = contentLanguage;
      return this;
    }

    public Builder contentEncoding(String contentEncoding) {
      this.contentEncoding = contentEncoding;
      return this;
    }

    Builder componentCount(Integer componentCount) {
      this.componentCount = componentCount;
      return this;
    }

    public Builder cacheControl(String cacheControl) {
      this.cacheControl = cacheControl;
      return this;
    }

    public Builder acl(List<Acl> acl) {
      this.acl = ImmutableList.copyOf(acl);
      return this;
    }

    public Builder owner(Acl.Entity owner) {
      this.owner = owner;
      return this;
    }

    public Builder size(Long size) {
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

    Builder md5(String md5) {
      this.md5 = md5;
      return this;
    }

    public Builder crc32c(String crc32c) {
      this.crc32c = crc32c;
      return this;
    }

    public Builder mediaLink(String mediaLink) {
      this.mediaLink = mediaLink;
      return this;
    }

    public Builder metadata(Map<String, String> metadata) {
      this.metadata = ImmutableMap.copyOf(metadata);
      return this;
    }

    public Builder generation(Long generation) {
      this.generation = generation;
      return this;
    }

    public Builder metageneration(Long metageneration) {
      this.metageneration = metageneration;
      return this;
    }

    public Builder deleteTime(Long deleteTime) {
      this.deleteTime = deleteTime;
      return this;
    }

    public Builder updateTime(Long updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    public Blob build() {
      checkNotNull(bucket);
      checkNotNull(name);
      return new Blob(this);
    }
  }

  private Blob(Builder builder) {
    bucket = builder.bucket;
    name = builder.name;
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

  public String bucket() {
    return bucket;
  }

  public String id() {
    return id;
  }

  public String name() {
    return name;
  }

  public String cacheControl() {
    return cacheControl;
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
    return contentType;
  }

  public String contentEncoding() {
    return contentEncoding;
  }

  public String contentDisposition() {
    return contentDisposition;
  }

  public String contentLanguage() {
    return contentEncoding;
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
    return md5;
  }

  public String crc32c() {
    return crc32c;
  }

  public String mediaLink() {
    return mediaLink;
  }

  public Map<String, String> metadata() {
    return metadata;
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
        .bucket(bucket)
        .name(name)
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
    return MoreObjects.toStringHelper(this).add("bucket", bucket).add("name", name).toString();
  }

  public static Blob of(String bucket, String name) {
    return builder(bucket, name).build();
  }

  public static Builder builder(Bucket bucket, String name) {
    return builder(bucket.name(), name);
  }

  public static Builder builder(String bucket, String name) {
    return new Builder().bucket(bucket).name(name);
  }

  StorageObject toPb() {
    StorageObject storageObject = new StorageObject();
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
    storageObject.setBucket(bucket);
    storageObject.setCacheControl(cacheControl);
    storageObject.setContentEncoding(contentEncoding);
    storageObject.setCrc32c(crc32c);
    storageObject.setContentType(contentType);
    storageObject.setGeneration(generation);
    storageObject.setMd5Hash(md5);
    storageObject.setMediaLink(mediaLink);
    storageObject.setMetadata(metadata);
    storageObject.setMetageneration(metageneration);
    storageObject.setName(name);
    storageObject.setContentDisposition(contentDisposition);
    storageObject.setComponentCount(componentCount);
    storageObject.setContentLanguage(contentLanguage);
    storageObject.setEtag(etag);
    storageObject.setId(id);
    storageObject.setSelfLink(selfLink);
    return storageObject;
  }

  static Blob fromPb(StorageObject storageObject) {
    Builder builder = new Builder()
        .bucket(storageObject.getBucket())
        .cacheControl(storageObject.getCacheControl())
        .contentEncoding(storageObject.getContentEncoding())
        .crc32c(storageObject.getCrc32c())
        .contentType(storageObject.getContentType())
        .generation(storageObject.getGeneration())
        .md5(storageObject.getMd5Hash())
        .mediaLink(storageObject.getMediaLink())
        .metageneration(storageObject.getMetageneration())
        .name(storageObject.getName())
        .contentDisposition(storageObject.getContentDisposition())
        .componentCount(storageObject.getComponentCount())
        .contentLanguage(storageObject.getContentLanguage())
        .etag(storageObject.getEtag())
        .id(storageObject.getId())
        .selfLink(storageObject.getSelfLink());
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
