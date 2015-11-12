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
 * Google Storage bucket metadata;
 *
 * @see <a href="https://cloud.google.com/storage/docs/concepts-techniques#concepts">Concepts and
 *      Terminology</a>
 */
public final class BucketInfo implements Serializable {

  static final Function<com.google.api.services.storage.model.Bucket, BucketInfo> FROM_PB_FUNCTION =
      new Function<com.google.api.services.storage.model.Bucket, BucketInfo>() {
        @Override
        public BucketInfo apply(com.google.api.services.storage.model.Bucket pb) {
          return BucketInfo.fromPb(pb);
        }
      };
  static final Function<BucketInfo, com.google.api.services.storage.model.Bucket> TO_PB_FUNCTION =
      new Function<BucketInfo, com.google.api.services.storage.model.Bucket>() {
        @Override
        public com.google.api.services.storage.model.Bucket apply(BucketInfo bucketInfo) {
          return bucketInfo.toPb();
        }
      };
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
  private final String location;
  private final String storageClass;

  /**
   * Base class for bucket's delete rules. Allows to configure automatic deletion of blobs and blobs
   * versions.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Object Lifecycle Management</a>
   */
  public abstract static class DeleteRule implements Serializable {

    private static final long serialVersionUID = 3137971668395933033L;
    private static final String SUPPORTED_ACTION = "Delete";
    private final Type type;

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

  /**
   * Delete rule class that sets a Time To Live for blobs in the bucket.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Object Lifecycle Management</a>
   */
  public static class AgeDeleteRule extends DeleteRule {

    private static final long serialVersionUID = 5697166940712116380L;
    private final int daysToLive;

    /**
     * Creates an {@code AgeDeleteRule} object.
     *
     * @param daysToLive blobs' Time To Live expressed in days. The time when the age condition is
     *     considered to be satisfied is computed by adding {@code daysToLive} days to the
     *     midnight following blob's creation time in UTC.
     */
    public AgeDeleteRule(int daysToLive) {
      super(Type.AGE);
      this.daysToLive = daysToLive;
    }

    public int daysToLive() {
      return daysToLive;
    }

    @Override
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

    @Override
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

  /**
   * Delete rule class for blobs in the bucket that have been created before a certain date.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Object Lifecycle Management</a>
   */
  public static class CreatedBeforeDeleteRule extends DeleteRule {

    private static final long serialVersionUID = 881692650279195867L;
    private final long timeMillis;

    /**
     * Creates an {@code CreatedBeforeDeleteRule} object.
     *
     * @param timeMillis a date in UTC. Blobs that have been created before midnight of the provided
     *     date meet the delete condition
     */
    public CreatedBeforeDeleteRule(long timeMillis) {
      super(Type.CREATE_BEFORE);
      this.timeMillis = timeMillis;
    }

    public long timeMillis() {
      return timeMillis;
    }

    @Override
    void populateCondition(Rule.Condition condition) {
      condition.setCreatedBefore(new DateTime(timeMillis));
    }
  }

  /**
   * Delete rule class for versioned blobs. Specifies when to delete a blob's version according to
   * the number of available newer versions for that blob.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Object Lifecycle Management</a>
   */
  public static class NumNewerVersionsDeleteRule extends DeleteRule {

    private static final long serialVersionUID = -1955554976528303894L;
    private final int numNewerVersions;

    /**
     * Creates an {@code NumNewerVersionsDeleteRule} object.
     *
     * @param numNewerVersions the number of newer versions. A blob's version meets the delete
     *     condition when {@code numNewerVersions} newer versions are available.
     */
    public NumNewerVersionsDeleteRule(int numNewerVersions) {
      super(Type.NUM_NEWER_VERSIONS);
      this.numNewerVersions = numNewerVersions;
    }

    public int numNewerVersions() {
      return numNewerVersions;
    }

    @Override
    void populateCondition(Rule.Condition condition) {
      condition.setNumNewerVersions(numNewerVersions);
    }
  }

  /**
   * Delete rule class to distinguish between live and archived blobs.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Object Lifecycle Management</a>
   */
  public static class IsLiveDeleteRule extends DeleteRule {

    private static final long serialVersionUID = -3502994563121313364L;
    private final boolean isLive;

    /**
     * Creates an {@code IsLiveDeleteRule} object.
     *
     * @param isLive if set to {@code true} live blobs meet the delete condition. If set to
     *     {@code false} delete condition is met by archived blobs.
     */
    public IsLiveDeleteRule(boolean isLive) {
      super(Type.IS_LIVE);
      this.isLive = isLive;
    }

    public boolean isLive() {
      return isLive;
    }

    @Override
    void populateCondition(Rule.Condition condition) {
      condition.setIsLive(isLive);
    }
  }

  public static final class Builder {

    private String id;
    private String name;
    private Acl.Entity owner;
    private String selfLink;
    private Boolean versioningEnabled;
    private String indexPage;
    private String notFoundPage;
    private ImmutableList<DeleteRule> deleteRules;
    private String storageClass;
    private String location;
    private String etag;
    private Long createTime;
    private Long metageneration;
    private ImmutableList<Cors> cors;
    private ImmutableList<Acl> acl;
    private ImmutableList<Acl> defaultAcl;

    private Builder() {}

    /**
     * Sets the bucket's name.
     */
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

    /**
     * Sets whether versioning should be enabled for this bucket. When set to true, versioning is
     * fully enabled.
     */
    public Builder versioningEnabled(Boolean enable) {
      this.versioningEnabled = firstNonNull(enable, Data.<Boolean>nullOf(Boolean.class));
      return this;
    }

    /**
     * Sets the bucket's website index page. Behaves as the bucket's directory index where missing
     * blobs are treated as potential directories.
     */
    public Builder indexPage(String indexPage) {
      this.indexPage = indexPage;
      return this;
    }

    /**
     * Sets the custom object to return when a requested resource is not found.
     */
    public Builder notFoundPage(String notFoundPage) {
      this.notFoundPage = notFoundPage;
      return this;
    }

    /**
     * Sets the bucket's lifecycle configuration as a number of delete rules.
     *
     * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Lifecycle Management</a>
     */
    public Builder deleteRules(Iterable<? extends DeleteRule> rules) {
      this.deleteRules = rules != null ? ImmutableList.copyOf(rules) : null;
      return this;
    }

    /**
     * Sets the bucket's storage class. This defines how blobs in the bucket are stored and
     * determines the SLA and the cost of storage. A list of supported values is available
     * <a href="https://cloud.google.com/storage/docs/storage-classes">here</a>.
     */
    public Builder storageClass(String storageClass) {
      this.storageClass = storageClass;
      return this;
    }

    /**
     * Sets the bucket's location. Data for blobs in the bucket resides in physical storage within
     * this region. A list of supported values is available
     * <a href="https://cloud.google.com/storage/docs/bucket-locations">here</a>.
     */
    public Builder location(String location) {
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

    /**
     * Sets the bucket's Cross-Origin Resource Sharing (CORS) configuration.
     *
     * @see <a href="https://cloud.google.com/storage/docs/cross-origin">
     *     Cross-Origin Resource Sharing (CORS)</a>
     */
    public Builder cors(Iterable<Cors> cors) {
      this.cors = cors != null ? ImmutableList.copyOf(cors) : null;
      return this;
    }

    /**
     * Sets the bucket's access control configuration.
     *
     * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
     *     About Access Control Lists</a>
     */
    public Builder acl(Iterable<Acl> acl) {
      this.acl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
    }

    /**
     * Sets the default access control configuration to apply to bucket's blobs when no other
     * configuration is specified.
     *
     * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
     *     About Access Control Lists</a>
     */
    public Builder defaultAcl(Iterable<Acl> acl) {
      this.defaultAcl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
    }

    /**
     * Creates a {@code BucketInfo} object.
     */
    public BucketInfo build() {
      checkNotNull(name);
      return new BucketInfo(this);
    }
  }

  private BucketInfo(Builder builder) {
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

  /**
   * Returns the bucket's id.
   */
  public String id() {
    return id;
  }

  /**
   * Returns the bucket's name.
   */
  public String name() {
    return name;
  }

  /**
   * Returns the bucket's owner. This is always the project team's owner group.
   */
  public Entity owner() {
    return owner;
  }

  /**
   * Returns the URI of this bucket as a string.
   */
  public String selfLink() {
    return selfLink;
  }

  /**
   * Returns {@code true} if versioning is fully enabled for this bucket, {@code false} otherwise.
   */
  public Boolean versioningEnabled() {
    return Data.isNull(versioningEnabled) ? null : versioningEnabled;
  }

  /**
   * Returns bucket's website index page. Behaves as the bucket's directory index where missing
   * blobs are treated as potential directories.
   */
  public String indexPage() {
    return indexPage;
  }

  /**
   * Returns the custom object to return when a requested resource is not found.
   */
  public String notFoundPage() {
    return notFoundPage;
  }

  /**
   * Returns bucket's lifecycle configuration as a number of delete rules.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Lifecycle Management</a>
   */
  public List<? extends DeleteRule> deleteRules() {
    return deleteRules;
  }

  /**
   * Returns HTTP 1.1 Entity tag for the bucket.
   *
   * @see <a href="http://tools.ietf.org/html/rfc2616#section-3.11">Entity Tags</a>
   */
  public String etag() {
    return etag;
  }

  /**
   * Returns the time at which the bucket was created.
   */
  public Long createTime() {
    return createTime;
  }

  /**
   * Returns the metadata generation of this bucket.
   */
  public Long metageneration() {
    return metageneration;
  }

  /**
   * Returns the bucket's location. Data for blobs in the bucket resides in physical storage within
   * this region.
   *
   * @see <a href="https://cloud.google.com/storage/docs/bucket-locations">Bucket Locations</a>
   */
  public String location() {
    return location;
  }

  /**
   * Returns the bucket's storage class. This defines how blobs in the bucket are stored and
   * determines the SLA and the cost of storage.
   *
   * @see <a href="https://cloud.google.com/storage/docs/storage-classes">Storage Classes</a>
   */
  public String storageClass() {
    return storageClass;
  }

  /**
   * Returns the bucket's Cross-Origin Resource Sharing (CORS) configuration.
   *
   * @see <a href="https://cloud.google.com/storage/docs/cross-origin">
   *     Cross-Origin Resource Sharing (CORS)</a>
   */
  public List<Cors> cors() {
    return cors;
  }

  /**
   * Returns the bucket's access control configuration.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
   *     About Access Control Lists</a>
   */
  public List<Acl> acl() {
    return acl;
  }

  /**
   * Returns the default access control configuration for this bucket's blobs.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
   *     About Access Control Lists</a>
   */
  public List<Acl> defaultAcl() {
    return defaultAcl;
  }

  /**
   * Returns a builder for the current bucket.
   */
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
    return obj instanceof BucketInfo && Objects.equals(toPb(), ((BucketInfo) obj).toPb());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name())
        .toString();
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
      bucketPb.setLocation(location);
    }
    if (storageClass != null) {
      bucketPb.setStorageClass(storageClass);
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

  /**
   * Creates a {@code BucketInfo} object for the provided bucket name.
   */
  public static BucketInfo of(String name) {
    return builder(name).build();
  }

  /**
   * Returns a {@code BucketInfo} builder where the bucket's name is set to the provided name.
   */
  public static Builder builder(String name) {
    return new Builder().name(name);
  }

  static BucketInfo fromPb(com.google.api.services.storage.model.Bucket bucketPb) {
    Builder builder = new Builder().name(bucketPb.getName());
    if (bucketPb.getId() != null) {
      builder.id(bucketPb.getId());
    }
    if (bucketPb.getEtag() != null) {
      builder.etag(bucketPb.getEtag());
    }
    if (bucketPb.getMetageneration() != null) {
      builder.metageneration(bucketPb.getMetageneration());
    }
    if (bucketPb.getSelfLink() != null) {
      builder.selfLink(bucketPb.getSelfLink());
    }
    if (bucketPb.getTimeCreated() != null) {
      builder.createTime(bucketPb.getTimeCreated().getValue());
    }
    if (bucketPb.getLocation() != null) {
      builder.location(bucketPb.getLocation());
    }
    if (bucketPb.getStorageClass() != null) {
      builder.storageClass(bucketPb.getStorageClass());
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
