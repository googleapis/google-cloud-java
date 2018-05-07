/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.transform;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.*;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.Bucket.Encryption;
import com.google.api.services.storage.model.Bucket.Lifecycle;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.api.services.storage.model.Bucket.Owner;
import com.google.api.services.storage.model.Bucket.Versioning;
import com.google.api.services.storage.model.Bucket.Website;
import com.google.cloud.storage.Acl.Entity;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Google Storage bucket metadata;
 *
 * @see <a href="https://cloud.google.com/storage/docs/concepts-techniques#concepts">Concepts and
 *      Terminology</a>
 */
public class BucketInfo implements Serializable {

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
  private static final long serialVersionUID = -4712013629621638459L;
  private final String generatedId;
  private final String name;
  private final Acl.Entity owner;
  private final String selfLink;
  private final Boolean requesterPays;
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
  private final StorageClass storageClass;
  private final Map<String, String> labels;
  private final String defaultKmsKeyName;

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

    public Type getType() {
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

    public int getDaysToLive() {
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

    @Override
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

    public long getTimeMillis() {
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

    public int getNumNewerVersions() {
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

  /**
   * Builder for {@code BucketInfo}.
   */
  public abstract static class Builder {
    Builder() {
    }

    /**
     * Sets the bucket's name.
     */
    public abstract Builder setName(String name);

    abstract Builder setGeneratedId(String generatedId);

    abstract Builder setOwner(Acl.Entity owner);

    abstract Builder setSelfLink(String selfLink);

    /**
     * Sets whether a user accessing the bucket or an object it contains should assume the transit costs
     * related to the access.
     *
     * GcpLaunchStage.Alpha
     */
    public abstract Builder setRequesterPays(Boolean requesterPays);

    /**
     * Sets whether versioning should be enabled for this bucket. When set to true, versioning is
     * fully enabled.
     */
    public abstract Builder setVersioningEnabled(Boolean enable);

    /**
     * Sets the bucket's website index page. Behaves as the bucket's directory index where missing
     * blobs are treated as potential directories.
     */
    public abstract Builder setIndexPage(String indexPage);

    /**
     * Sets the custom object to return when a requested resource is not found.
     */
    public abstract Builder setNotFoundPage(String notFoundPage);

    /**
     * Sets the bucket's lifecycle configuration as a number of delete rules.
     *
     * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Lifecycle Management</a>
     */
    public abstract Builder setDeleteRules(Iterable<? extends DeleteRule> rules);

    /**
     * Sets the bucket's storage class. This defines how blobs in the bucket are stored and
     * determines the SLA and the cost of storage. A list of supported values is available
     * <a href="https://cloud.google.com/storage/docs/storage-classes">here</a>.
     */
    public abstract Builder setStorageClass(StorageClass storageClass);

    /**
     * Sets the bucket's location. Data for blobs in the bucket resides in physical storage within
     * this region. A list of supported values is available
     * <a href="https://cloud.google.com/storage/docs/bucket-locations">here</a>.
     */
    public abstract Builder setLocation(String location);

    abstract Builder setEtag(String etag);

    abstract Builder setCreateTime(Long createTime);

    abstract Builder setMetageneration(Long metageneration);

    /**
     * Sets the bucket's Cross-Origin Resource Sharing (CORS) configuration.
     *
     * @see <a href="https://cloud.google.com/storage/docs/cross-origin">
     *     Cross-Origin Resource Sharing (CORS)</a>
     */
    public abstract Builder setCors(Iterable<Cors> cors);

    /**
     * Sets the bucket's access control configuration.
     *
     * @see <a
     * href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
     *     About Access Control Lists</a>
     */
    public abstract Builder setAcl(Iterable<Acl> acl);

    /**
     * Sets the default access control configuration to apply to bucket's blobs when no other
     * configuration is specified.
     *
     * @see <a
     * href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
     *     About Access Control Lists</a>
     */
    public abstract Builder setDefaultAcl(Iterable<Acl> acl);

    /**
     * Sets the label of this bucket.
     */
    public abstract Builder setLabels(Map<String, String> labels);

    /**
     * Sets the default Cloud KMS key name for this bucket.
     */
    public abstract Builder setDefaultKmsKeyName(String defaultKmsKeyName);

    /**
     * Creates a {@code BucketInfo} object.
     */
    public abstract BucketInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String generatedId;
    private String name;
    private Acl.Entity owner;
    private String selfLink;
    private Boolean requesterPays;
    private Boolean versioningEnabled;
    private String indexPage;
    private String notFoundPage;
    private List<DeleteRule> deleteRules;
    private StorageClass storageClass;
    private String location;
    private String etag;
    private Long createTime;
    private Long metageneration;
    private List<Cors> cors;
    private List<Acl> acl;
    private List<Acl> defaultAcl;
    private Map<String, String> labels;
    private String defaultKmsKeyName;

    BuilderImpl(String name) {
      this.name = name;
    }

    BuilderImpl(BucketInfo bucketInfo) {
      generatedId = bucketInfo.generatedId;
      name = bucketInfo.name;
      etag = bucketInfo.etag;
      createTime = bucketInfo.createTime;
      metageneration = bucketInfo.metageneration;
      location = bucketInfo.location;
      storageClass = bucketInfo.storageClass;
      cors = bucketInfo.cors;
      acl = bucketInfo.acl;
      defaultAcl = bucketInfo.defaultAcl;
      owner = bucketInfo.owner;
      selfLink = bucketInfo.selfLink;
      versioningEnabled = bucketInfo.versioningEnabled;
      indexPage = bucketInfo.indexPage;
      notFoundPage = bucketInfo.notFoundPage;
      deleteRules = bucketInfo.deleteRules;
      labels = bucketInfo.labels;
      requesterPays = bucketInfo.requesterPays;
      defaultKmsKeyName = bucketInfo.defaultKmsKeyName;
    }

    @Override
    public Builder setName(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    Builder setOwner(Acl.Entity owner) {
      this.owner = owner;
      return this;
    }

    @Override
    Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    @Override
    public Builder setVersioningEnabled(Boolean enable) {
      this.versioningEnabled = firstNonNull(enable, Data.<Boolean>nullOf(Boolean.class));
      return this;
    }

    /** GcpLaunchStage.Alpha */
    @Override
    public Builder setRequesterPays(Boolean enable) {
      this.requesterPays = firstNonNull(enable, Data.<Boolean>nullOf(Boolean.class));
      return this;
    }

    @Override
    public Builder setIndexPage(String indexPage) {
      this.indexPage = indexPage;
      return this;
    }

    @Override
    public Builder setNotFoundPage(String notFoundPage) {
      this.notFoundPage = notFoundPage;
      return this;
    }

    @Override
    public Builder setDeleteRules(Iterable<? extends DeleteRule> rules) {
      this.deleteRules = rules != null ? ImmutableList.copyOf(rules) : null;
      return this;
    }

    @Override
    public Builder setStorageClass(StorageClass storageClass) {
      this.storageClass = storageClass;
      return this;
    }

    @Override
    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    @Override
    Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    @Override
    Builder setCreateTime(Long createTime) {
      this.createTime = createTime;
      return this;
    }

    @Override
    Builder setMetageneration(Long metageneration) {
      this.metageneration = metageneration;
      return this;
    }

    @Override
    public Builder setCors(Iterable<Cors> cors) {
      this.cors = cors != null ? ImmutableList.copyOf(cors) : null;
      return this;
    }

    @Override
    public Builder setAcl(Iterable<Acl> acl) {
      this.acl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
    }

    @Override
    public Builder setDefaultAcl(Iterable<Acl> acl) {
      this.defaultAcl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
    }

    @Override
    public Builder setLabels(Map<String, String> labels) {
      this.labels = labels != null ? ImmutableMap.copyOf(labels) : null;
      return this;
    }

    @Override
    public Builder setDefaultKmsKeyName(String defaultKmsKeyName) {
      this.defaultKmsKeyName = defaultKmsKeyName != null
              ? new String(defaultKmsKeyName) : Data.<String>nullOf(String.class);
      return this;
    }

    @Override
    public BucketInfo build() {
      checkNotNull(name);
      return new BucketInfo(this);
    }
  }

  BucketInfo(BuilderImpl builder) {
    generatedId = builder.generatedId;
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
    labels = builder.labels;
    requesterPays = builder.requesterPays;
    defaultKmsKeyName = builder.defaultKmsKeyName;
  }

  /**
   * Returns the service-generated id for the bucket.
   */
  public String getGeneratedId() {
    return generatedId;
  }

  /**
   * Returns the bucket's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the bucket's owner. This is always the project team's owner group.
   */
  public Entity getOwner() {
    return owner;
  }

  /**
   * Returns the URI of this bucket as a string.
   */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * Returns {@code true} if versioning is fully enabled for this bucket, {@code false} otherwise.
   */
  public Boolean versioningEnabled() {
    return Data.isNull(versioningEnabled) ? null : versioningEnabled;
  }


  /**
   * Returns {@code true} if a user accessing the bucket or an object it contains should assume the transit costs
   * related to the access, {@code false} otherwise.
   *
   * GcpLaunchStage.Alpha
   */
  public Boolean requesterPays() {
    return Data.isNull(requesterPays) ? null : requesterPays;
  }

  /**
   * Returns bucket's website index page. Behaves as the bucket's directory index where missing
   * blobs are treated as potential directories.
   */
  public String getIndexPage() {
    return indexPage;
  }

  /**
   * Returns the custom object to return when a requested resource is not found.
   */
  public String getNotFoundPage() {
    return notFoundPage;
  }

  /**
   * Returns bucket's lifecycle configuration as a number of delete rules.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Lifecycle Management</a>
   */
  public List<? extends DeleteRule> getDeleteRules() {
    return deleteRules;
  }

  /**
   * Returns HTTP 1.1 Entity tag for the bucket.
   *
   * @see <a href="http://tools.ietf.org/html/rfc2616#section-3.11">Entity Tags</a>
   */
  public String getEtag() {
    return etag;
  }

  /**
   * Returns the time at which the bucket was created.
   */
  public Long getCreateTime() {
    return createTime;
  }

  /**
   * Returns the metadata generation of this bucket.
   */
  public Long getMetageneration() {
    return metageneration;
  }

  /**
   * Returns the bucket's location. Data for blobs in the bucket resides in physical storage within
   * this region.
   *
   * @see <a href="https://cloud.google.com/storage/docs/bucket-locations">Bucket Locations</a>
   */
  public String getLocation() {
    return location;
  }

  /**
   * Returns the bucket's storage class. This defines how blobs in the bucket are stored and
   * determines the SLA and the cost of storage.
   *
   * @see <a href="https://cloud.google.com/storage/docs/storage-classes">Storage Classes</a>
   */
  public StorageClass getStorageClass() {
    return storageClass;
  }

  /**
   * Returns the bucket's Cross-Origin Resource Sharing (CORS) configuration.
   *
   * @see <a href="https://cloud.google.com/storage/docs/cross-origin">
   *     Cross-Origin Resource Sharing (CORS)</a>
   */
  public List<Cors> getCors() {
    return cors;
  }

  /**
   * Returns the bucket's access control configuration.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
   *     About Access Control Lists</a>
   */
  public List<Acl> getAcl() {
    return acl;
  }

  /**
   * Returns the default access control configuration for this bucket's blobs.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
   *     About Access Control Lists</a>
   */
  public List<Acl> getDefaultAcl() {
    return defaultAcl;
  }

  /**
   * Returns the labels for this bucket.
   */
  public Map<String, String> getLabels() {
    return labels;
  }

  /**
   * Returns the default Cloud KMS key to be applied to newly inserted objects in this bucket.
   */
  public String getDefaultKmsKeyName() {
    return defaultKmsKeyName;
  }

  /**
   * Returns a builder for the current bucket.
   */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(BucketInfo.class)
        && Objects.equals(toPb(), ((BucketInfo) obj).toPb());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .toString();
  }

  com.google.api.services.storage.model.Bucket toPb() {
    com.google.api.services.storage.model.Bucket bucketPb =
        new com.google.api.services.storage.model.Bucket();
    bucketPb.setId(generatedId);
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
      bucketPb.setStorageClass(storageClass.toString());
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
    if (requesterPays != null) {
      Bucket.Billing billing = new Bucket.Billing();
      billing.setRequesterPays(requesterPays);
      bucketPb.setBilling(billing);
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
    if (labels != null) {
      bucketPb.setLabels(labels);
    }
    if (defaultKmsKeyName != null) {
      bucketPb.setEncryption(new Encryption().setDefaultKmsKeyName(defaultKmsKeyName));
    }
    return bucketPb;
  }

  /**
   * Creates a {@code BucketInfo} object for the provided bucket name.
   */
  public static BucketInfo of(String name) {
    return newBuilder(name).build();
  }

  /**
   * Returns a {@code BucketInfo} builder where the bucket's name is set to the provided name.
   */
  public static Builder newBuilder(String name) {
    return new BuilderImpl(name);
  }

  static BucketInfo fromPb(com.google.api.services.storage.model.Bucket bucketPb) {
    Builder builder = new BuilderImpl(bucketPb.getName());
    if (bucketPb.getId() != null) {
      builder.setGeneratedId(bucketPb.getId());
    }
    if (bucketPb.getEtag() != null) {
      builder.setEtag(bucketPb.getEtag());
    }
    if (bucketPb.getMetageneration() != null) {
      builder.setMetageneration(bucketPb.getMetageneration());
    }
    if (bucketPb.getSelfLink() != null) {
      builder.setSelfLink(bucketPb.getSelfLink());
    }
    if (bucketPb.getTimeCreated() != null) {
      builder.setCreateTime(bucketPb.getTimeCreated().getValue());
    }
    if (bucketPb.getLocation() != null) {
      builder.setLocation(bucketPb.getLocation());
    }
    if (bucketPb.getStorageClass() != null) {
      builder.setStorageClass(StorageClass.valueOf(bucketPb.getStorageClass()));
    }
    if (bucketPb.getCors() != null) {
      builder.setCors(transform(bucketPb.getCors(), Cors.FROM_PB_FUNCTION));
    }
    if (bucketPb.getAcl() != null) {
      builder.setAcl(transform(bucketPb.getAcl(), new Function<BucketAccessControl, Acl>() {
        @Override
        public Acl apply(BucketAccessControl bucketAccessControl) {
          return Acl.fromPb(bucketAccessControl);
        }
      }));
    }
    if (bucketPb.getDefaultObjectAcl() != null) {
      builder.setDefaultAcl(transform(bucketPb.getDefaultObjectAcl(),
          new Function<ObjectAccessControl, Acl>() {
            @Override
            public Acl apply(ObjectAccessControl objectAccessControl) {
              return Acl.fromPb(objectAccessControl);
            }
          }));
    }
    if (bucketPb.getOwner() != null) {
      builder.setOwner(Entity.fromPb(bucketPb.getOwner().getEntity()));
    }
    if (bucketPb.getVersioning() != null) {
      builder.setVersioningEnabled(bucketPb.getVersioning().getEnabled());
    }
    Website website = bucketPb.getWebsite();
    if (website != null) {
      builder.setIndexPage(website.getMainPageSuffix());
      builder.setNotFoundPage(website.getNotFoundPage());
    }
    if (bucketPb.getLifecycle() != null && bucketPb.getLifecycle().getRule() != null) {
      builder.setDeleteRules(transform(bucketPb.getLifecycle().getRule(),
          new Function<Rule, DeleteRule>() {
            @Override
            public DeleteRule apply(Rule rule) {
              return DeleteRule.fromPb(rule);
            }
          }));
    }
    if (bucketPb.getLabels() != null) {
      builder.setLabels(bucketPb.getLabels());
    }
    Bucket.Billing billing = bucketPb.getBilling();
    if (billing != null) {
      builder.setRequesterPays(billing.getRequesterPays());
    }
    Encryption encryption = bucketPb.getEncryption();
    if (encryption != null && encryption.getDefaultKmsKeyName() != null && !encryption.getDefaultKmsKeyName().isEmpty()) {
      builder.setDefaultKmsKeyName(encryption.getDefaultKmsKeyName());
    }
    return builder.build();
  }
}
