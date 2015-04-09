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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ObjectInfo implements Serializable {

  private static final long serialVersionUID = 2228487739943277159L;

  private final String bucket;
  private final String name;
  private final String contentType;
  private final String cacheControl;
  private final ImmutableList<Acl> acl;
  private final String owner;
  private final long size;
  private final String contentEncoding;
  private final HashCode md5;
  private final long crc32;
  private final String mediaLink;
  private final ImmutableMap<String, String> metadata;
  private final long generation;
  private final long metageneration;
  private final long deleteTime;
  private final long updateTime;


  public static final class Builder {

    private String bucket;
    private String name;
    private String contentType;
    private String cacheControl;
    private ImmutableList<Acl> acl;
    private String owner;
    private long size;
    private String contentEncoding;
    private HashCode md5;
    private long crc32;
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

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder contentType(String contentType) {
      this.contentType = contentType;
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

    public Builder owner(String owner) {
      this.owner = owner;
      return this;
    }

    public Builder size(long size) {
      this.size = size;
      return this;
    }

    public Builder contentEncoding(String contentEncoding) {
      this.contentEncoding = contentEncoding;
      return this;
    }

    Builder md5(HashCode md5) {
      this.md5 = md5;
      return this;
    }

    public Builder md5(byte[] bytes) {
      this.md5 = bytes == null ? null : Hashing.md5().hashBytes(bytes);
      return this;
    }

    public Builder crc32(long crc32) {
      this.crc32 = crc32;
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
    name = builder.name;
    contentType = builder.contentType;
    cacheControl = builder.cacheControl;
    acl = builder.acl;
    owner = builder.owner;
    size = builder.size;
    contentEncoding = builder.contentEncoding;
    md5 = builder.md5;
    crc32 = builder.crc32;
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

  public String name() {
    return name;
  }

  public String contentType() {
    return contentType;
  }

  public String cacheControl() {
    return cacheControl;
  }

  public List<Acl> acl() {
    return acl;
  }

  public String owner() {
    return owner;
  }

  public long size() {
    return size;
  }

  public String contentEncoding() {
    return contentEncoding;
  }

  public byte[] md5() {
    return md5 == null ? null : md5.asBytes();
  }

  public long crc32() {
    return crc32;
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
        .crc32(crc32)
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
        .size(size);

  }

  public static Builder builder() {
    return new Builder();
  }
}
