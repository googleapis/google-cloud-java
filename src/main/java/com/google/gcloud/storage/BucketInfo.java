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

import com.google.api.services.storage.model.Bucket;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.List;

public final class BucketInfo implements Serializable {

  private static final long serialVersionUID = -3946094202176916586L;

  private final String id;
  private final String name;
  private final String etag;
  private final long createTime;
  private final long metageneration;
  private final Cors cors;
  private final ImmutableList<Acl> acl;
  private final ImmutableList<Acl> defaultAcl;
  private final String location;
  private final String storageClass;


  public static final class StorageClass implements Serializable {

    private static final long serialVersionUID = 374002156285326563L;

    private final String value;

    public enum Type {
      DURABLE_REDUCED_AVAILABILITY,
      STANDARD,
      OTHER
    }

    private StorageClass(Type type) {
      value = type.name();
    }

    private StorageClass(String value) {
      this.value = value;
    }

    public static StorageClass standard() {
      return new StorageClass(Type.STANDARD);
    }

    public static StorageClass durableReducedAvailability() {
      return new StorageClass(Type.DURABLE_REDUCED_AVAILABILITY);
    }

    public static StorageClass other(String other) {
      return new StorageClass(other);
    }
  }

  public enum Location {
    US, EU, ASIA
  }

  public final static class Builder {

    private final String id;
    private final String name;
    private String storageClass;
    private String location;
    private String etag;
    private Long createTime;
    private Long metageneration;
    private Cors cors;
    private Iterable<Acl> acl;
    private Iterable<Acl> defaultAcl;

    Builder(String id, String name) {
      this.id = id;
      this.name = name;
    }

    public Builder storageClass(StorageClass storageClass) {
      return storageClass(storageClass.name());
    }

    Builder storageClass(String storageClass) {
      this.storageClass = storageClass;
      return this;
    }

    public Builder location(Location location) {
      return location(location.name());
    }

    Builder location(String location) {
      this.location = location;
      return this;
    }

    Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    Builder createTime(Long createTime) {
      this.createTime = createTime;
      return this;
    }

    Builder metageneration(Long metageneration) {
      this.metageneration = metageneration;
      return this;
    }

    Builder cors(Cors cors) {
      this.cors = cors;
      return this;
    }

    public Builder acl(Iterable<Acl> acl) {
      this.acl = ImmutableList.copyOf(acl);
      return this;
    }

    public Builder defaultAcl(Iterable<Acl> acl) {
      this.defaultAcl = ImmutableList.copyOf(acl);
      return this;
    }

    public BucketInfo build() {
      return new BucketInfo(this);
    }
  }

  private BucketInfo(Builder builder) {
    id = builder.id;
    name = builder.name;
    etag = builder.etag;
    createTime = MoreObjects.firstNonNull(builder.createTime, 0L);
    metageneration = MoreObjects.firstNonNull(builder.metageneration, 0L);
    location = builder.location;
    storageClass = builder.storageClass;
    cors = builder.cors;
    acl = ImmutableList.copyOf(builder.acl);
    defaultAcl = ImmutableList.copyOf(builder.defaultAcl);
  }

  public String id() {
    return id;
  }

  public String name() {
    return name;
  }

  public String etag() {
    return etag;
  }

  public long createTime() {
    return createTime;
  }

  public long metageneration() {
    return metageneration;
  }

  public String lLocation() {
    return location;
  }

  public String storageClass() {
    return storageClass;
  }

  public Cors cors() {
    return cors;
  }

  public List<Acl> acl() {
    return acl;
  }

  public List<Acl> defaultObjectAcl() {
    return defaultAcl;
  }

  public Builder toBuilder() {
    return new Builder(id, name)
        .createTime(createTime)
        .etag(etag)
        .metageneration(metageneration)
        .cors(cors)
        .acl(acl)
        .defaultAcl(defaultAcl)
        .location(location)
        .storageClass(storageClass);
  }

  void fromPb(Bucket bucket) {
    Builder builder = new Builder(bucket.getId(), bucket.getName())
        .createTime(bucket.getTimeCreated().getValue())
        .etag(bucket.getEtag())
        .metageneration(bucket.getMetageneration())
        .location(bucket.getLocation())
        .storageClass(bucket.getStorageClass());

    cors = builder.cors;
    acl = ImmutableList.copyOf(builder.acl);
    defaultAcl = ImmutableList.copyOf(builder.defaultAcl);


  }

  Bucket toPb() {
    id = builder.id;
    name = builder.name;
    etag = builder.etag;
    createTime = MoreObjects.firstNonNull(builder.createTime, 0L);
    metageneration = MoreObjects.firstNonNull(builder.metageneration, 0L);
    location = builder.location;
    storageClass = builder.storageClass;
    cors = builder.cors;
    acl = ImmutableList.copyOf(builder.acl);
    defaultAcl = ImmutableList.copyOf(builder.defaultAcl);
  }
}
