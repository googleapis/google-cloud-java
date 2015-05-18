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
import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.collect.Lists.transform;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.Bucket.Lifecycle;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.api.services.storage.model.Bucket.Owner;
import com.google.api.services.storage.model.Bucket.Versioning;
import com.google.api.services.storage.model.Bucket.Website;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.storage.Acl.Entity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A Google Storage bucket.
 *
 * @see <a href="https://cloud.google.com/storage/docs/concepts-techniques#concepts">Concepts and Terminology</a>
 */
public final class Bucket implements Serializable {

  private static final long serialVersionUID = -3946094202176916586L;

  private final String id;
  private final String name;
  private final Acl.Entity owner;
  private final String selfLink;
  private final Boolean versioningEnabled;
  private final String indexPage;
  private final String notFoundPage;
  private final List<DeleteRule> deleteRules;
  private final String etag;
  private final Long createTime;
  private final Long metageneration;
  private final List<Cors> cors;
  private final List<Acl> acl;
  private final List<Acl> defaultAcl;
  private final Location location;
  private final StorageClass storageClass;

  static final Function<com.google.api.services.storage.model.Bucket, Bucket> FROM_PB_FUNCTION =
      new Function<com.google.api.services.storage.model.Bucket, Bucket>() {
        @Override
        public Bucket apply(com.google.api.services.storage.model.Bucket pb) {
          return Bucket.fromPb(pb);
        }
      };

  static final Function<Bucket, com.google.api.services.storage.model.Bucket> TO_PB_FUNCTION =
      new Function<Bucket, com.google.api.services.storage.model.Bucket>() {
        @Override
        public com.google.api.services.storage.model.Bucket apply(Bucket bucket) {
          return bucket.toPb();
        }
      };

  public static abstract class DeleteRule implements Serializable {

    private static final long serialVersionUID = 3137971668395933033L;
    private final Type type;
    private static final String SUPPORTED_ACTION = "Delete";

    public enum Type {
      AGE, CREATE_BEFORE, NUM_NEWER_VERSIONS, IS_LIVE, UNKNOWN
    }

    DeleteRule(Type type) {
      this.type = type;
    }

    public Type type() {
      return type;
    }

    @Override
    public int hashCode() {
      return Objects.hash(type);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      final DeleteRule other = (DeleteRule) obj;
      return Objects.equals(toPb(), other.toPb());
    }

    Rule toPb() {
      Rule rule = new Rule();
      rule.setAction(new Rule.Action().setType(SUPPORTED_ACTION));
      Rule.Condition condition = new Rule.Condition();
      populateCondition(condition);
      rule.setCondition(condition);
      return rule;
    }

    abstract void populateCondition(Rule.Condition condition);

    static DeleteRule fromPb(Rule rule) {
      if (rule.getAction() != null && SUPPORTED_ACTION.endsWith(rule.getAction().getType())) {
        Rule.Condition condition = rule.getCondition();
        Integer age = condition.getAge();
        if (age != null) {
          return new AgeDeleteRule(age);
        }
        DateTime dateTime = condition.getCreatedBefore();
        if (dateTime != null) {
          return new CreatedBeforeDeleteRule(dateTime.getValue());
        }
        Integer numNewerVersions = condition.getNumNewerVersions();
        if (numNewerVersions != null) {
          return new NumNewerVersionsDeleteRule(numNewerVersions);
        }
        Boolean isLive = condition.getIsLive();
        if (isLive != null) {
          return new IsLiveDeleteRule(isLive);
        }
      }
      return new RawDeleteRule(rule);
    }
  }

  public static class AgeDeleteRule extends DeleteRule {

    private static final long serialVersionUID = 5697166940712116380L;
    private final int daysToLive;

    public AgeDeleteRule(int daysToLive) {
      super(Type.AGE);
      this.daysToLive = daysToLive;
    }

    public int daysToLive() {
      return daysToLive;
    }

    void populateCondition(Rule.Condition condition) {
      condition.setAge(daysToLive);
    }
  }

  static class RawDeleteRule extends DeleteRule {

    private static final long serialVersionUID = -7166938278642301933L;

    private transient Rule rule;

    RawDeleteRule(Rule rule) {
      super(Type.UNKNOWN);
      this.rule = rule;
    }

    void populateCondition(Rule.Condition condition) {
      throw new UnsupportedOperationException();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeUTF(rule.toString());
    }

    private void readObject(ObjectInputStream in) throws IOException,
        ClassNotFoundException {
      in.defaultReadObject();
      rule = new JacksonFactory().fromString(in.readUTF(), Rule.class);
    }

    Rule toPb() {
      return rule;
    }
  }

  public static class CreatedBeforeDeleteRule extends DeleteRule {

    private static final long serialVersionUID = 881692650279195867L;
    private final long timeMillis;

    public CreatedBeforeDeleteRule(long timeMillis) {
      super(Type.CREATE_BEFORE);
      this.timeMillis = timeMillis;
    }

    public long timeMillis() {
      return timeMillis;
    }

    void populateCondition(Rule.Condition condition) {
      condition.setCreatedBefore(new DateTime(timeMillis));
    }
  }

  public static class NumNewerVersionsDeleteRule extends DeleteRule {

    private static final long serialVersionUID = -1955554976528303894L;
    private final int numNewerVersions;

    public NumNewerVersionsDeleteRule(int numNewerVersions) {
      super(Type.NUM_NEWER_VERSIONS);
      this.numNewerVersions = numNewerVersions;
    }

    public int numNewerVersions() {
      return numNewerVersions;
    }

    void populateCondition(Rule.Condition condition) {
      condition.setNumNewerVersions(numNewerVersions);
    }
  }

  public static class IsLiveDeleteRule extends DeleteRule {

    private static final long serialVersionUID = -3502994563121313364L;
    private final boolean isLive;

    public IsLiveDeleteRule(boolean isLive) {
      super(Type.IS_LIVE);
      this.isLive = isLive;
    }

    public boolean isLive() {
      return isLive;
    }

    void populateCondition(Rule.Condition condition) {
      condition.setIsLive(isLive);
    }
  }

  public static final class StorageClass implements Serializable {

    private static final long serialVersionUID = 374002156285326563L;
    private static final ImmutableMap<String, Option> STRING_TO_OPTION;
    private static final StorageClass NULL_VALUE =
        new StorageClass(Data.<String>nullOf(String.class));

    private final String value;

    public enum Option {
      DURABLE_REDUCED_AVAILABILITY, STANDARD;

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
    private static final Location NULL_VALUE = new Location(Data.<String>nullOf(String.class));

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
    public int hashCode() {
      return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      final Location other = (Location) obj;
      return Objects.equals(this.value, other.value);
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

    private String id;
    private String name;
    private Acl.Entity owner;
    private String selfLink;
    private Boolean versioningEnabled;
    private String indexPage;
    private String notFoundPage;
    private ImmutableList<DeleteRule> deleteRules;
    private StorageClass storageClass;
    private Location location;
    private String etag;
    private Long createTime;
    private Long metageneration;
    private ImmutableList<Cors> cors;
    private ImmutableList<Acl> acl;
    private ImmutableList<Acl> defaultAcl;

    private Builder() {}

    public Builder name(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    Builder id(String id) {
      this.id = id;
      return this;
    }

    Builder owner(Acl.Entity owner) {
      this.owner = owner;
      return this;
    }

    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public Builder versioningEnabled(Boolean enable) {
      this.versioningEnabled = firstNonNull(enable, Data.<Boolean>nullOf(Boolean.class));
      return this;
    }

    public Builder indexPage(String indexPage) {
      this.indexPage = indexPage;
      return this;
    }

    public Builder notFoundPage(String notFoundPage) {
      this.notFoundPage = notFoundPage;
      return this;
    }

    public Builder deleteRules(Iterable<? extends DeleteRule> rules) {
      this.deleteRules = ImmutableList.copyOf(rules);
      return this;
    }

    public Builder storageClass(StorageClass storageClass) {
      this.storageClass = firstNonNull(storageClass, StorageClass.NULL_VALUE);
      return this;
    }

    public Builder location(Location location) {
      this.location = firstNonNull(location, Location.NULL_VALUE);
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

    public Builder cors(Iterable<Cors> cors) {
      this.cors = cors != null ? ImmutableList.copyOf(cors) : null;
      return this;
    }

    public Builder acl(Iterable<Acl> acl) {
      this.acl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
    }

    public Builder defaultAcl(Iterable<Acl> acl) {
      this.defaultAcl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
    }

    public Bucket build() {
      checkNotNull(name);
      return new Bucket(this);
    }
  }

  private Bucket(Builder builder) {
    id = builder.id;
    name = builder.name;
    etag = builder.etag;
    createTime = builder.createTime;
    metageneration = builder.metageneration;
    location = builder.location;
    storageClass = builder.storageClass;
    cors = builder.cors;
    acl = builder.acl;
    defaultAcl = builder.defaultAcl;
    owner = builder.owner;
    selfLink = builder.selfLink;
    versioningEnabled = builder.versioningEnabled;
    indexPage = builder.indexPage;
    notFoundPage = builder.notFoundPage;
    deleteRules = builder.deleteRules;
  }

  public String id() {
    return id;
  }

  public String name() {
    return name;
  }

  public Entity owner() {
    return owner;
  }

  public String selfLink() {
    return selfLink;
  }

  public Boolean versioningEnabled() {
    return Data.isNull(versioningEnabled) ? null : versioningEnabled;
  }

  public String indexPage() {
    return indexPage;
  }

  public String notFoundPage() {
    return notFoundPage;
  }

  public List<? extends DeleteRule> deleteRules() {
    return deleteRules;
  }

  public String etag() {
    return etag;
  }

  public Long createTime() {
    return createTime;
  }

  public Long metageneration() {
    return metageneration;
  }

  public Location location() {
    return location == null || Data.isNull(location.value) ? null : location;
  }

  public StorageClass storageClass() {
    return storageClass == null || Data.isNull(storageClass.value) ? null : storageClass;
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
    return new Builder()
        .name(name)
        .id(id)
        .createTime(createTime)
        .etag(etag)
        .metageneration(metageneration)
        .cors(cors)
        .acl(acl)
        .defaultAcl(defaultAcl)
        .location(location)
        .storageClass(storageClass)
        .owner(owner)
        .selfLink(selfLink)
        .versioningEnabled(versioningEnabled)
        .indexPage(indexPage)
        .notFoundPage(notFoundPage)
        .deleteRules(deleteRules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Bucket)) {
      return  false;
    }
    return Objects.equals(toPb(), ((Bucket) obj).toPb());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name())
        .toString();
  }

  public static Bucket of(String name) {
    return builder(name).build();
  }

  public static Builder builder(String name) {
    return new Builder().name(name);
  }

  com.google.api.services.storage.model.Bucket toPb() {
    com.google.api.services.storage.model.Bucket bucketPb =
        new com.google.api.services.storage.model.Bucket();
    bucketPb.setId(id);
    bucketPb.setName(name);
    bucketPb.setEtag(etag);
    if (createTime != null) {
      bucketPb.setTimeCreated(new DateTime(createTime));
    }
    if (metageneration != null) {
      bucketPb.setMetageneration(metageneration);
    }
    if (location != null) {
      bucketPb.setLocation(location.value());
    }
    if (storageClass != null) {
      bucketPb.setStorageClass(storageClass.value());
    }
    if (cors != null) {
      bucketPb.setCors(transform(cors, Cors.TO_PB_FUNCTION));
    }
    if (acl != null) {
      bucketPb.setAcl(transform(acl, new Function<Acl, BucketAccessControl>() {
        @Override
        public BucketAccessControl apply(Acl acl) {
          return acl.toBucketPb();
        }
      }));
    }
    if (defaultAcl != null) {
      bucketPb.setDefaultObjectAcl(transform(defaultAcl, new Function<Acl, ObjectAccessControl>() {
        @Override
        public ObjectAccessControl apply(Acl acl) {
          return acl.toObjectPb();
        }
      }));
    }
    if (owner != null) {
      bucketPb.setOwner(new Owner().setEntity(owner.toPb()));
    }
    bucketPb.setSelfLink(selfLink);
    if (versioningEnabled != null) {
      bucketPb.setVersioning(new Versioning().setEnabled(versioningEnabled));
    }
    if (indexPage != null || notFoundPage != null) {
      Website website = new Website();
      website.setMainPageSuffix(indexPage);
      website.setNotFoundPage(notFoundPage);
      bucketPb.setWebsite(website);
    }
    if (deleteRules != null) {
      Lifecycle lifecycle = new Lifecycle();
      lifecycle.setRule(transform(deleteRules, new Function<DeleteRule, Rule>() {
        @Override
        public Rule apply(DeleteRule deleteRule) {
          return deleteRule.toPb();
        }
      }));
      bucketPb.setLifecycle(lifecycle);
    }
    return bucketPb;
  }

  static Bucket fromPb(com.google.api.services.storage.model.Bucket bucketPb) {
    Builder builder = new Builder()
        .name(bucketPb.getName())
        .id(bucketPb.getId())
        .etag(bucketPb.getEtag())
        .metageneration(bucketPb.getMetageneration())
        .createTime(bucketPb.getTimeCreated().getValue())
        .location(Location.of(bucketPb.getLocation()))
        .selfLink(bucketPb.getSelfLink());
    if (bucketPb.getStorageClass() != null) {
      builder.storageClass(StorageClass.of(bucketPb.getStorageClass()));
    }
    if (bucketPb.getCors() != null) {
      builder.cors(transform(bucketPb.getCors(), Cors.FROM_PB_FUNCTION));
    }
    if (bucketPb.getAcl() != null) {
      builder.acl(transform(bucketPb.getAcl(), new Function<BucketAccessControl, Acl>() {
        @Override
        public Acl apply(BucketAccessControl bucketAccessControl) {
          return Acl.fromPb(bucketAccessControl);
        }
      }));
    }
    if (bucketPb.getDefaultObjectAcl() != null) {
      builder.defaultAcl(transform(bucketPb.getDefaultObjectAcl(),
          new Function<ObjectAccessControl, Acl>() {
            @Override
            public Acl apply(ObjectAccessControl objectAccessControl) {
              return Acl.fromPb(objectAccessControl);
            }
          }));
    }
    if (bucketPb.getOwner() != null) {
      builder.owner(Entity.fromPb(bucketPb.getOwner().getEntity()));
    }
    if (bucketPb.getVersioning() != null) {
      builder.versioningEnabled(bucketPb.getVersioning().getEnabled());
    }
    Website website = bucketPb.getWebsite();
    if (website != null) {
      builder.indexPage(website.getMainPageSuffix());
      builder.notFoundPage(website.getNotFoundPage());
    }
    if (bucketPb.getLifecycle() != null && bucketPb.getLifecycle().getRule() != null) {
      builder.deleteRules(transform(bucketPb.getLifecycle().getRule(),
          new Function<Rule, DeleteRule>() {
            @Override
            public DeleteRule apply(Rule rule) {
              return DeleteRule.fromPb(rule);
            }
          }));
    }
    return builder.build();
  }
}
