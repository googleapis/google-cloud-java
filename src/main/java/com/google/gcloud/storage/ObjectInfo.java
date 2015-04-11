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

import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class ObjectInfo implements Serializable {

  private static final long serialVersionUID = 2228487739943277159L;

  private final String bucket;
  private final String id;
  private final String name;
  private final String selfLink;
  private final String cacheControl;
  private final ImmutableList<Acl> acl;
  private final Acl.Entity owner;
  private final long size;
  private final String etag;
  private final String md5;
  private final String crc32c;
  private final String mediaLink;
  private final ImmutableMap<String, String> metadata;
  private final long generation;
  private final long metageneration;
  private final long deleteTime;
  private final long updateTime;
  private final String contentType;
  private final String contentEncoding;
  private final String contentDisposition;
  private final String contentLanguage;
  private final int componentCount;

  public static final class Builder {

    private String bucket;
    private String id;
    private String name;
    private String contentType;
    private String contentEncoding;
    private String contentDisposition;
    private  String contentLanguage;
    private int componentCount;
    private String cacheControl;
    private ImmutableList<Acl> acl;
    private Acl.Entity owner;
    private long size;
    private String etag;
    private String selfLink;
    private String md5;
    private String crc32c;
    private String mediaLink;
    private ImmutableMap<String, String> metadata;
    private long generation;
    private long metageneration;
    private long deleteTime;
    private long updateTime;

    private Builder() {
    }

    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
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

    Builder componentCount(int componentCount) {
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

    public Builder size(long size) {
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

    public Builder generation(long generation) {
      this.generation = generation;
      return this;
    }

    public Builder metageneration(long metageneration) {
      this.metageneration = metageneration;
      return this;
    }

    public Builder deleteTime(long deleteTime) {
      this.deleteTime = deleteTime;
      return this;
    }

    public Builder updateTime(long updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    public ObjectInfo build() {
      return new ObjectInfo(this);
    }
  }

  private ObjectInfo(Builder builder) {
    bucket = builder.bucket;
    id = builder.id;
    name = builder.name;
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

  public long size() {
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

  public int componentCount() {
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

  public long generation() {
    return generation;
  }

  public long metageneration() {
    return metageneration;
  }

  public long deleteTime() {
    return deleteTime;
  }

  public long updateTime() {
    return updateTime;
  }

  public Builder toBuilder() {
    return builder()
        .acl(acl)
        .bucket(bucket)
        .cacheControl(cacheControl)
        .contentEncoding(contentEncoding)
        .crc32c(crc32c)
        .contentType(contentType)
        .deleteTime(deleteTime)
        .generation(generation)
        .md5(md5)
        .mediaLink(mediaLink)
        .metadata(metadata)
        .metageneration(metageneration)
        .name(name)
        .owner(owner)
        .updateTime(updateTime)
        .size(size)
        .contentDisposition(contentDisposition)
        .componentCount(componentCount)
        .contentLanguage(contentLanguage)
        .etag(etag)
        .id(id)
        .selfLink(selfLink);
  }

  public static Builder builder() {
    return new Builder();
  }

  StorageObject toPb() {
    StorageObject storageObject = new StorageObject();
    storageObject.setAcl(Lists.transform(acl,
        new Function<Acl, ObjectAccessControl>() {
          @Override
          public ObjectAccessControl apply(Acl acl) {
            return acl.toObjectPb();
          }
        }));
    storageObject.setBucket(bucket);
    storageObject.setCacheControl(cacheControl);
    storageObject.setContentEncoding(contentEncoding);
    storageObject.setCrc32c(crc32c);
    storageObject.setContentType(contentType);
    storageObject.setTimeDeleted(new DateTime(deleteTime));
    storageObject.setGeneration(generation);
    storageObject.setMd5Hash(md5);
    storageObject.setMediaLink(mediaLink);
    storageObject.setMetadata(metadata);
    storageObject.setMetageneration(metageneration);
    storageObject.setName(name);
    storageObject.setOwner(new StorageObject.Owner().setEntity(owner.toPb()));
    storageObject.setUpdated(new DateTime(updateTime));
    storageObject.setSize(BigInteger.valueOf(size));
    storageObject.setContentDisposition(contentDisposition);
    storageObject.setComponentCount(componentCount);
    storageObject.setContentLanguage(contentLanguage);
    storageObject.setEtag(etag);
    storageObject.setId(id);
    storageObject.setSelfLink(selfLink);
    return storageObject;
  }

  static ObjectInfo fromPb(StorageObject storageObject) {
    return builder()
        .acl(Lists.transform(storageObject.getAcl(),
            new Function<ObjectAccessControl, Acl>() {
              @Override public Acl apply(ObjectAccessControl objectAccessControl) {
                return Acl.fromPb(objectAccessControl);
              }
            }))
        .bucket(storageObject.getBucket())
        .cacheControl(storageObject.getCacheControl())
        .contentEncoding(storageObject.getContentEncoding())
        .crc32c(storageObject.getCrc32c())
        .contentType(storageObject.getContentType())
        .deleteTime(storageObject.getTimeDeleted().getValue())
        .generation(storageObject.getGeneration())
        .md5(storageObject.getMd5Hash())
        .mediaLink(storageObject.getMediaLink())
        .metadata(storageObject.getMetadata())
        .metageneration(storageObject.getMetageneration())
        .name(storageObject.getName())
        .owner(Acl.Entity.fromPb(storageObject.getOwner().getEntity()))
        .updateTime(storageObject.getUpdated().getValue())
        .size(storageObject.getSize().longValue())
        .contentDisposition(storageObject.getContentDisposition())
        .componentCount(storageObject.getComponentCount())
        .contentLanguage(storageObject.getContentLanguage())
        .etag(storageObject.getEtag())
        .id(storageObject.getId())
        .selfLink(storageObject.getSelfLink())
        .build();
  }
}
