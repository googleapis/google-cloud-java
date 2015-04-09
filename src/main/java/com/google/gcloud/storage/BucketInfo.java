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

import static com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;

import java.io.Serializable;
import java.util.List;

public final class BucketInfo implements Serializable {

  private static final long serialVersionUID = -3946094202176916586L;

  private final String id;
  private final String name;
  private final String etag;
  private final long createTime;
  private final long metageneration;
  private final ImmutableList<Cors> cors;
  private final ImmutableList<Acl> acl;
  private final ImmutableList<Acl> defaultAcl;
  private final Location location;
  private final StorageClass storageClass;


  public static final class StorageClass implements Serializable {

    private static final long serialVersionUID = 374002156285326563L;
    private static final ImmutableMap<String, Option> STRING_TO_OPTION;
    private final String value;

    public enum Option {
      DURABLE_REDUCED_AVAILABILITY,
      STANDARD;

      private final StorageClass storageClass;

      Option() {
        storageClass = new StorageClass(name());
      }
    }

    static {
      ImmutableMap.Builder<String, Option> map = ImmutableMap.builder();
      for (Option option : Option.values()) {
        map.put(option.name(), option);
      }
      STRING_TO_OPTION = map.build();
    }

    private StorageClass(String value) {
      this.value = checkNotNull(value);
    }

    public static StorageClass standard() {
      return Option.STANDARD.storageClass;
    }

    public static StorageClass durableReducedAvailability() {
      return Option.DURABLE_REDUCED_AVAILABILITY.storageClass;
    }

    public static StorageClass of(String value) {
      Option option = STRING_TO_OPTION.get(value.toUpperCase());
      return option == null ? new StorageClass(value) : option.storageClass;
    }

    @Override
    public String toString() {
      return value();
    }

    public String value() {
      return value;
    }
  }

  public static final class Location implements Serializable {

    private static final long serialVersionUID = 9073107666838637662L;
    private static final ImmutableMap<String, Option> STRING_TO_OPTION;
    private final String value;

    public enum Option {
      US, EU, ASIA;

      private final Location location;

      Option() {
        location = new Location(name());
      }
    }

    static {
      ImmutableMap.Builder<String, Option> map = ImmutableMap.builder();
      for (Option option : Option.values()) {
        map.put(option.name(), option);
      }
      STRING_TO_OPTION = map.build();
    }

    private Location(String value) {
      this.value = checkNotNull(value);
    }

    public static Location us() {
      return Option.US.location;
    }

    public static Location eu() {
      return Option.EU.location;
    }

    public static Location asia() {
      return Option.ASIA.location;
    }

    public static Location of(String value) {
      Option option = STRING_TO_OPTION.get(value.toUpperCase());
      return option == null ? new Location(value) : option.location;
    }

    @Override
    public String toString() {
      return value();
    }

    public String value() {
      return value;
    }
  }

  public final static class Builder {

    private final String id;
    private final String name;
    private StorageClass storageClass;
    private Location location;
    private String etag;
    private Long createTime;
    private Long metageneration;
    private Iterable<Cors> cors = ImmutableList.of();
    private Iterable<Acl> acl = ImmutableList.of();
    private Iterable<Acl> defaultAcl = ImmutableList.of();

    Builder(String id, String name) {
      this.id = id;
      this.name = name;
    }

    public Builder storageClass(StorageClass storageClass) {
      this.storageClass = storageClass;
      return this;
    }

    public Builder location(Location location) {
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

    Builder cors(Iterable<Cors> cors) {
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
    cors = ImmutableList.copyOf(builder.cors);
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

  public Location location() {
    return location;
  }

  public StorageClass storageClass() {
    return storageClass;
  }

  public List<Cors> cors() {
    return cors;
  }

  public List<Acl> acl() {
    return acl;
  }

  public List<Acl> defaultAcl() {
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

  BucketInfo fromPb(Bucket bucket) {
    Builder builder = new Builder(bucket.getId(), bucket.getName())
        .createTime(bucket.getTimeCreated().getValue())
        .etag(bucket.getEtag())
        .metageneration(bucket.getMetageneration())
        .location(Location.of(bucket.getLocation()))
        .storageClass(StorageClass.of(bucket.getStorageClass()))
        .cors(transform(bucket.getCors(), new Function<Bucket.Cors, Cors>() {
          @Override public Cors apply(Bucket.Cors cors) {
            return Cors.fromPb(cors);
          }
        }))
        .acl(transform(bucket.getAcl(), new Function<BucketAccessControl, Acl>() {
          @Override public Acl apply(BucketAccessControl bucketAccessControl) {
            return Acl.fromPb(bucketAccessControl);
          }
        }))
        .defaultAcl(transform(bucket.getDefaultObjectAcl(), new Function<ObjectAccessControl, Acl>() {
          @Override public Acl apply(ObjectAccessControl objectAccessControl) {
            return Acl.fromPb(objectAccessControl);
          }
        }));
    return builder.build();
  }

  Bucket toPb() {
    Bucket bucket = new Bucket();
    bucket.setId(id);
    bucket.setName(name);
    bucket.setEtag(etag);
    if (createTime > 0) {
      bucket.setTimeCreated(new DateTime(createTime));
    }
    if (metageneration > 0) {
      bucket.setMetageneration(metageneration);
    }
    if (location != null) {
      bucket.setLocation(location.value());
    }
    if (storageClass != null) {
      bucket.setStorageClass(storageClass.value());
    }
    bucket.setCors(newArrayList(Iterables.transform(cors, new Function<Cors, Bucket.Cors>() {
      @Override public Bucket.Cors apply(Cors cors) {
        return cors.toPb();
      }
    })));
    bucket.setAcl(newArrayList(Iterables.transform(acl, new Function<Acl, BucketAccessControl>() {
      @Override public BucketAccessControl apply(Acl acl) {
        return acl.toBucketPb();
      }
    })));
    bucket.setDefaultObjectAcl(
        newArrayList(Iterables.transform(defaultAcl, new Function<Acl, ObjectAccessControl>() {
          @Override public ObjectAccessControl apply(Acl acl) {
            return acl.toObjectPb();
          }
        })));
    return bucket;
  }
}
