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
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.transform;
import static com.google.gcloud.storage.Bucket.BucketSourceOption.toGetOptions;
import static com.google.gcloud.storage.Bucket.BucketSourceOption.toSourceOptions;

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
import com.google.gcloud.Page;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.spi.StorageRpc.Tuple;
import com.google.gcloud.storage.Acl.Entity;
import com.google.gcloud.storage.Storage.BlobGetOption;
import com.google.gcloud.storage.Storage.BlobTargetOption;
import com.google.gcloud.storage.Storage.BlobWriteOption;
import com.google.gcloud.storage.Storage.BucketTargetOption;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A Google cloud storage bucket.
 *
 * <p>Objects of this class are immutable. Operations that modify the bucket like {@link #update}
 * return a new object. To get a {@code Bucket} object with the most recent information use
 * {@link #reload}.
 * </p>
 */
public final class Bucket implements Serializable {

  private static final long serialVersionUID = -4052051461903992871L;

  static final Function<Tuple<Storage, com.google.api.services.storage.model.Bucket>, Bucket>
      FROM_PB_FUNCTION =
      new Function<Tuple<Storage, com.google.api.services.storage.model.Bucket>, Bucket>() {
        @Override
        public Bucket apply(Tuple<Storage, com.google.api.services.storage.model.Bucket> pb) {
          return Bucket.fromPb(pb.x(), pb.y());
        }
      };
  static final Function<Bucket, com.google.api.services.storage.model.Bucket> TO_PB_FUNCTION =
    new Function<Bucket, com.google.api.services.storage.model.Bucket>() {
        @Override
      public com.google.api.services.storage.model.Bucket apply(Bucket bucket) {
        return bucket.toPb();
        }
      };

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
  private final StorageOptions options;
  private transient Storage storage;

  /**
   * Base class for bucket's delete rules. Allows to configure automatic deletion of blobs and blobs
   * versions.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Object Lifecycle Management</a>
   */
  public abstract static class DeleteRule implements Serializable {

    private static final long serialVersionUID = -233553882888158723L;

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

    private static final long serialVersionUID = 4008399976841554647L;

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

    private static final long serialVersionUID = -5296731123363309473L;

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

    private static final long serialVersionUID = -2821235292289446045L;

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

    private static final long serialVersionUID = -5801983633758098154L;

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

    private static final long serialVersionUID = 6556002405077879041L;

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
   * Class for specifying bucket source options when {@code Bucket} methods are used.
   */
  public static class BucketSourceOption extends Option {

    private static final long serialVersionUID = 2256447327846232412L;

    private BucketSourceOption(StorageRpc.Option rpcOption) {
      super(rpcOption, null);
    }

    private Storage.BucketSourceOption toSourceOptions(Bucket bucket) {
      switch (rpcOption()) {
        case IF_METAGENERATION_MATCH:
          return Storage.BucketSourceOption.metagenerationMatch(bucket.metageneration());
        case IF_METAGENERATION_NOT_MATCH:
          return Storage.BucketSourceOption.metagenerationNotMatch(bucket.metageneration());
        default:
          throw new AssertionError("Unexpected enum value");
      }
    }

    private Storage.BucketGetOption toGetOption(Bucket bucket) {
      switch (rpcOption()) {
        case IF_METAGENERATION_MATCH:
          return Storage.BucketGetOption.metagenerationMatch(bucket.metageneration());
        case IF_METAGENERATION_NOT_MATCH:
          return Storage.BucketGetOption.metagenerationNotMatch(bucket.metageneration());
        default:
          throw new AssertionError("Unexpected enum value");
      }
    }

    /**
     * Returns an option for bucket's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    public static BucketSourceOption metagenerationMatch() {
      return new BucketSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH);
    }

    /**
     * Returns an option for bucket's metageneration mismatch. If this option is used the request
     * will fail if metageneration matches.
     */
    public static BucketSourceOption metagenerationNotMatch() {
      return new BucketSourceOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH);
    }

    static Storage.BucketSourceOption[] toSourceOptions(
        Bucket bucket, BucketSourceOption... options) {
      Storage.BucketSourceOption[] convertedOptions =
          new Storage.BucketSourceOption[options.length];
      int index = 0;
      for (BucketSourceOption option : options) {
        convertedOptions[index++] = option.toSourceOptions(bucket);
      }
      return convertedOptions;
    }

    static Storage.BucketGetOption[] toGetOptions(Bucket bucket, BucketSourceOption... options) {
      Storage.BucketGetOption[] convertedOptions = new Storage.BucketGetOption[options.length];
      int index = 0;
      for (BucketSourceOption option : options) {
        convertedOptions[index++] = option.toGetOption(bucket);
      }
      return convertedOptions;
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
    private List<DeleteRule> deleteRules;
    private String storageClass;
    private String location;
    private String etag;
    private Long createTime;
    private Long metageneration;
    private List<Cors> cors;
    private List<Acl> acl;
    private List<Acl> defaultAcl;
    private Storage storage;

    private Builder() {}

    private Builder(Bucket bucket) {
      id = bucket.id;
      name = bucket.name;
      etag = bucket.etag;
      createTime = bucket.createTime;
      metageneration = bucket.metageneration;
      location = bucket.location;
      storageClass = bucket.storageClass;
      cors = bucket.cors;
      acl = bucket.acl;
      defaultAcl = bucket.defaultAcl;
      owner = bucket.owner;
      selfLink = bucket.selfLink;
      versioningEnabled = bucket.versioningEnabled;
      indexPage = bucket.indexPage;
      notFoundPage = bucket.notFoundPage;
      deleteRules = bucket.deleteRules;
      storage = bucket.storage;
    }

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
     * Sets the storage service object used to send requests relevant to the bucket.
     */
    public Builder storage(Storage storage) {
      this.storage = storage;
      return this;
    }

    /**
     * Creates a {@code Bucket} object.
     */
    public Bucket build() {
      checkNotNull(name);
      checkNotNull(storage);
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
    options = builder.storage.options();
    storage = builder.storage;
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
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Bucket && Objects.equals(toPb(), ((Bucket) obj).toPb())
        && Objects.equals(options, ((Bucket) obj).options);
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

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.storage = options.service();
  }

  /**
   * Creates a {@code Bucket} object for the provided bucket name.
   */
  public static Bucket of(Storage storage, String name) {
    return builder(storage, name).build();
  }

  /**
   * Returns a {@code Bucket} builder where the bucket's name is set to the provided name.
   */
  public static Builder builder(Storage storage, String name) {
    return new Builder().name(name).storage(storage);
  }

  static Bucket fromPb(Storage storage, com.google.api.services.storage.model.Bucket bucketPb) {
    Builder builder = new Builder().name(bucketPb.getName()).storage(storage);
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

  /**
   * Performs an RPC to create this bucket.
   *
   * @return the {@code Bucket} object representing the newly-created bucket.
   * @throws StorageException upon failure
   */
  public Bucket create(BucketTargetOption... options) {
    return storage.create(this, options);
  }

  /**
   * Creates a {@code Bucket} object for the provided bucket name. Performs an RPC call to get the
   * latest bucket information.
   *
   * @param storage the storage service used for issuing requests
   * @param bucket bucket's name
   * @param options blob get options
   * @return the {@code Bucket} object or {@code null} if not found
   * @throws StorageException upon failure
   */
  public static Bucket get(Storage storage, String bucket, Storage.BucketGetOption... options) {
    return storage.get(bucket, options);
  }

  /**
   * Checks if this bucket exists.
   *
   * @return true if this bucket exists, false otherwise
   * @throws StorageException upon failure
   */
  public boolean exists(BucketSourceOption... options) {
    int length = options.length;
    Storage.BucketGetOption[] getOptions = Arrays.copyOf(toGetOptions(this, options), length + 1);
    getOptions[length] = Storage.BucketGetOption.fields();
    return storage.get(name(), getOptions) != null;
  }

  /**
   * Fetches current bucket's latest information. Returns {@code null} if the bucket does not exist.
   *
   * @param options bucket read options
   * @return a {@code Bucket} object with latest information or {@code null} if not found
   * @throws StorageException upon failure
   */
  public Bucket reload(BucketSourceOption... options) {
    return Bucket.get(storage, name(), toGetOptions(this, options));
  }

  /**
   * Updates the bucket's information. Bucket's name cannot be changed. A new {@code Bucket} object
   * is returned. By default no checks are made on the metadata generation of the current bucket.
   * If you want to update the information only if the current bucket metadata are at their latest
   * version use the {@code metagenerationMatch} option:
   * {@code bucket.update(newBucket, BucketTargetOption.metagenerationMatch())}
   *
   * @param bucket the new bucket. Name must match the one of the current bucket
   * @param options update options
   * @return a {@code Bucket} object with updated information
   * @throws StorageException upon failure
   */
  public Bucket update(Bucket bucket, BucketTargetOption... options) {
    checkArgument(Objects.equals(bucket.name(), name()), "Bucket name must match");
    return storage.update(bucket, options);
  }

  /**
   * Deletes this bucket.
   *
   * @param options bucket delete options
   * @return {@code true} if bucket was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  public boolean delete(BucketSourceOption... options) {
    return storage.delete(name(), toSourceOptions(this, options));
  }

  /**
   * Returns the paginated list of {@code Blob} in this bucket.
   *
   * @param options options for listing blobs
   * @throws StorageException upon failure
   */
  public Page<Blob> list(Storage.BlobListOption... options) {
    return storage.list(name, options);
  }

  /**
   * Returns the requested blob in this bucket or {@code null} if not found.
   *
   * @param blob name of the requested blob
   * @param options blob search options
   * @throws StorageException upon failure
   */
  public Blob get(String blob, BlobGetOption... options) {
    return storage.get(BlobId.of(name, blob), options);
  }

  /**
   * Returns a list of requested blobs in this bucket. Blobs that do not exist are null.
   *
   * @param blobName1 first blob to get
   * @param blobName2 second blob to get
   * @param blobNames other blobs to get
   * @return an immutable list of {@code Blob} objects
   * @throws StorageException upon failure
   */
  public List<Blob> get(String blobName1, String blobName2, String... blobNames) {
    BatchRequest.Builder batch = BatchRequest.builder();
    batch.get(name, blobName1);
    batch.get(name, blobName2);
    for (String blobName : blobNames) {
      batch.get(name, blobName);
    }
    List<Blob> blobs = new ArrayList<>(blobNames.length);
    BatchResponse response = storage.apply(batch.build());
    for (BatchResponse.Result<Blob> result : response.gets()) {
      blobs.add(result.get());
    }
    return Collections.unmodifiableList(blobs);
  }

  /**
   * Creates a new blob in this bucket. Direct upload is used to upload {@code content}.
   * For large content, {@link Blob#writer(com.google.gcloud.storage.Storage.BlobWriteOption...)}
   * is recommended as it uses resumable upload. MD5 and CRC32C hashes of {@code content} are
   * computed and used for validating transferred data.
   *
   * @param blobName a blob name
   * @param content the blob content
   * @param contentType the blob content type. If {@code null} then
   *     {@value com.google.gcloud.storage.Storage#DEFAULT_CONTENT_TYPE} is used.
   * @param options options for blob creation
   * @return a complete blob
   * @throws StorageException upon failure
   */
  public Blob create(
      String blobName, byte[] content, String contentType, BlobTargetOption... options) {
    Blob blob =
        Blob.builder(storage, BlobId.of(name, blobName))
        .contentType(MoreObjects.firstNonNull(contentType, Storage.DEFAULT_CONTENT_TYPE)).build();
    return storage.create(blob, content, options);
  }

  /**
   * Creates a new blob in this bucket. Direct upload is used to upload {@code content}.
   * For large content, {@link Blob#writer(com.google.gcloud.storage.Storage.BlobWriteOption...)}
   * is recommended as it uses resumable upload.
   *
   * @param blobName a blob name
   * @param content the blob content as a stream
   * @param contentType the blob content type. If {@code null} then
   *     {@value com.google.gcloud.storage.Storage#DEFAULT_CONTENT_TYPE} is used.
   * @param options options for blob creation
   * @return a complete blob
   * @throws StorageException upon failure
   */
  public Blob create(
      String blobName, InputStream content, String contentType,
      BlobWriteOption... options) {
    Blob blob =
        Blob.builder(storage, BlobId.of(name, blobName))
        .contentType(MoreObjects.firstNonNull(contentType, Storage.DEFAULT_CONTENT_TYPE)).build();
    return storage.create(blob, content, options);
  }

  /**
   * Returns the bucket's {@code Storage} object used to issue requests.
   */
  public Storage storage() {
    return storage;
  }
}
