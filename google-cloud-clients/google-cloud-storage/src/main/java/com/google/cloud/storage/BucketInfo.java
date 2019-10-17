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
import com.google.api.core.BetaApi;
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
import com.google.common.base.Functions;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Google Storage bucket metadata;
 *
 * @see <a href="https://cloud.google.com/storage/docs/concepts-techniques#concepts">Concepts and
 *     Terminology</a>
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
  private final List<LifecycleRule> lifecycleRules;
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
  private final Boolean defaultEventBasedHold;
  private final Long retentionEffectiveTime;
  private final Boolean retentionPolicyIsLocked;
  private final Long retentionPeriod;
  private final IamConfiguration iamConfiguration;
  private final String locationType;
  private final Logging logging;

  /**
   * The Bucket's IAM Configuration.
   *
   * @see <a href="https://cloud.google.com/storage/docs/bucket-policy-only">Bucket Policy Only</a>
   */
  public static class IamConfiguration implements Serializable {
    private static final long serialVersionUID = -8671736104909424616L;

    private Boolean isBucketPolicyOnlyEnabled;
    private Long bucketPolicyOnlyLockedTime;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      IamConfiguration other = (IamConfiguration) o;
      return Objects.equals(toPb(), other.toPb());
    }

    @Override
    public int hashCode() {
      return Objects.hash(isBucketPolicyOnlyEnabled, bucketPolicyOnlyLockedTime);
    }

    private IamConfiguration(Builder builder) {
      this.isBucketPolicyOnlyEnabled = builder.isBucketPolicyOnlyEnabled;
      this.bucketPolicyOnlyLockedTime = builder.bucketPolicyOnlyLockedTime;
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.isBucketPolicyOnlyEnabled = isBucketPolicyOnlyEnabled;
      builder.bucketPolicyOnlyLockedTime = bucketPolicyOnlyLockedTime;
      return builder;
    }

    public Boolean isBucketPolicyOnlyEnabled() {
      return isBucketPolicyOnlyEnabled;
    }

    public Long getBucketPolicyOnlyLockedTime() {
      return bucketPolicyOnlyLockedTime;
    }

    Bucket.IamConfiguration toPb() {
      Bucket.IamConfiguration iamConfiguration = new Bucket.IamConfiguration();

      Bucket.IamConfiguration.BucketPolicyOnly bucketPolicyOnly =
          new Bucket.IamConfiguration.BucketPolicyOnly();
      bucketPolicyOnly.setEnabled(isBucketPolicyOnlyEnabled);
      bucketPolicyOnly.setLockedTime(
          bucketPolicyOnlyLockedTime == null ? null : new DateTime(bucketPolicyOnlyLockedTime));

      iamConfiguration.setBucketPolicyOnly(bucketPolicyOnly);
      return iamConfiguration;
    }

    static IamConfiguration fromPb(Bucket.IamConfiguration iamConfiguration) {
      Bucket.IamConfiguration.BucketPolicyOnly bucketPolicyOnly =
          iamConfiguration.getBucketPolicyOnly();
      DateTime lockedTime = bucketPolicyOnly.getLockedTime();

      return newBuilder()
          .setIsBucketPolicyOnlyEnabled(bucketPolicyOnly.getEnabled())
          .setBucketPolicyOnlyLockedTime(lockedTime == null ? null : lockedTime.getValue())
          .build();
    }

    /** Builder for {@code IamConfiguration} */
    public static class Builder {
      private Boolean isBucketPolicyOnlyEnabled;
      private Long bucketPolicyOnlyLockedTime;

      /**
       * Sets whether BucketPolicyOnly is enabled for this bucket. When this is enabled, access to
       * the bucket will be configured through IAM, and legacy ACL policies will not work. When this
       * is first enabled, {@code bucketPolicyOnly.lockedTime} will be set by the API automatically.
       * This field can then be disabled until the time specified, after which it will become
       * immutable and calls to change it will fail. If this is enabled, calls to access legacy ACL
       * information will fail.
       */
      public Builder setIsBucketPolicyOnlyEnabled(Boolean isBucketPolicyOnlyEnabled) {
        this.isBucketPolicyOnlyEnabled = isBucketPolicyOnlyEnabled;
        return this;
      }

      /**
       * Sets the deadline for switching {@code bucketPolicyOnly.enabled} back to false. After this
       * time passes, calls to do so will fail. This is package-private, since in general this field
       * should never be set by a user--it's automatically set by the backend when {@code enabled}
       * is set to true.
       */
      Builder setBucketPolicyOnlyLockedTime(Long bucketPolicyOnlyLockedTime) {
        this.bucketPolicyOnlyLockedTime = bucketPolicyOnlyLockedTime;
        return this;
      }

      /** Builds an {@code IamConfiguration} object */
      public IamConfiguration build() {
        return new IamConfiguration(this);
      }
    }
  }

  /**
   * The bucket's logging configuration, which defines the destination bucket and optional name
   * prefix for the current bucket's logs.
   */
  public static class Logging implements Serializable {

    private static final long serialVersionUID = -708892101216778492L;
    private String logBucket;
    private String logObjectPrefix;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Logging other = (Logging) o;
      return Objects.equals(toPb(), other.toPb());
    }

    @Override
    public int hashCode() {
      return Objects.hash(logBucket, logObjectPrefix);
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.logBucket = logBucket;
      builder.logObjectPrefix = logObjectPrefix;
      return builder;
    }

    public String getLogBucket() {
      return logBucket;
    }

    public String getLogObjectPrefix() {
      return logObjectPrefix;
    }

    Bucket.Logging toPb() {
      Bucket.Logging logging = new Bucket.Logging();
      logging.setLogBucket(logBucket);
      logging.setLogObjectPrefix(logObjectPrefix);
      return logging;
    }

    static Logging fromPb(Bucket.Logging logging) {
      return newBuilder()
          .setLogBucket(logging.getLogBucket())
          .setLogObjectPrefix(logging.getLogObjectPrefix())
          .build();
    }

    private Logging(Builder builder) {
      this.logBucket = builder.logBucket;
      this.logObjectPrefix = builder.logObjectPrefix;
    }

    public static class Builder {
      private String logBucket;
      private String logObjectPrefix;

      /** The destination bucket where the current bucket's logs should be placed. */
      public Builder setLogBucket(String logBucket) {
        this.logBucket = logBucket;
        return this;
      }

      /** A prefix for log object names. */
      public Builder setLogObjectPrefix(String logObjectPrefix) {
        this.logObjectPrefix = logObjectPrefix;
        return this;
      }

      /** Builds an {@code Logging} object */
      public Logging build() {
        return new Logging(this);
      }
    }
  }

  /**
   * Lifecycle rule for a bucket. Allows supported Actions, such as deleting and changing storage
   * class, to be executed when certain Conditions are met.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle#actions">Object Lifecycle
   *     Management</a>
   */
  public static class LifecycleRule implements Serializable {

    private static final long serialVersionUID = -5739807320148748613L;
    private final LifecycleAction lifecycleAction;
    private final LifecycleCondition lifecycleCondition;

    public LifecycleRule(LifecycleAction action, LifecycleCondition condition) {
      if (condition.getIsLive() == null
          && condition.getAge() == null
          && condition.getCreatedBefore() == null
          && condition.getMatchesStorageClass() == null
          && condition.getNumberOfNewerVersions() == null) {
        throw new IllegalArgumentException(
            "You must specify at least one condition to use object lifecycle "
                + "management. Please see https://cloud.google.com/storage/docs/lifecycle for details.");
      }

      this.lifecycleAction = action;
      this.lifecycleCondition = condition;
    }

    public LifecycleAction getAction() {
      return lifecycleAction;
    }

    public LifecycleCondition getCondition() {
      return lifecycleCondition;
    }

    @Override
    public int hashCode() {
      return Objects.hash(lifecycleAction, lifecycleCondition);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      final LifecycleRule other = (LifecycleRule) obj;
      return Objects.equals(toPb(), other.toPb());
    }

    Rule toPb() {
      Rule rule = new Rule();

      Rule.Action action = new Rule.Action().setType(lifecycleAction.getActionType());
      if (lifecycleAction.getActionType().equals(SetStorageClassLifecycleAction.TYPE)) {
        action.setStorageClass(
            ((SetStorageClassLifecycleAction) lifecycleAction).getStorageClass().toString());
      }

      rule.setAction(action);

      Rule.Condition condition =
          new Rule.Condition()
              .setAge(lifecycleCondition.getAge())
              .setCreatedBefore(
                  lifecycleCondition.getCreatedBefore() == null
                      ? null
                      : new DateTime(true, lifecycleCondition.getCreatedBefore().getValue(), 0))
              .setIsLive(lifecycleCondition.getIsLive())
              .setNumNewerVersions(lifecycleCondition.getNumberOfNewerVersions())
              .setMatchesStorageClass(
                  lifecycleCondition.getMatchesStorageClass() == null
                      ? null
                      : transform(
                          lifecycleCondition.getMatchesStorageClass(),
                          Functions.toStringFunction()));

      rule.setCondition(condition);

      return rule;
    }

    static LifecycleRule fromPb(Rule rule) {
      LifecycleAction lifecycleAction;

      Rule.Action action = rule.getAction();

      switch (action.getType()) {
        case DeleteLifecycleAction.TYPE:
          lifecycleAction = LifecycleAction.newDeleteAction();
          break;
        case SetStorageClassLifecycleAction.TYPE:
          lifecycleAction =
              LifecycleAction.newSetStorageClassAction(
                  StorageClass.valueOf(action.getStorageClass()));
          break;
        default:
          throw new UnsupportedOperationException(
              "The specified lifecycle action " + action.getType() + " is not currently supported");
      }

      Rule.Condition condition = rule.getCondition();

      LifecycleCondition.Builder conditionBuilder =
          LifecycleCondition.newBuilder()
              .setAge(condition.getAge())
              .setCreatedBefore(condition.getCreatedBefore())
              .setIsLive(condition.getIsLive())
              .setNumberOfNewerVersions(condition.getNumNewerVersions())
              .setMatchesStorageClass(
                  condition.getMatchesStorageClass() == null
                      ? null
                      : transform(
                          condition.getMatchesStorageClass(),
                          new Function<String, StorageClass>() {
                            public StorageClass apply(String storageClass) {
                              return StorageClass.valueOf(storageClass);
                            }
                          }));

      return new LifecycleRule(lifecycleAction, conditionBuilder.build());
    }

    /**
     * Condition for a Lifecycle rule, specifies under what criteria an Action should be executed.
     *
     * @see <a href="https://cloud.google.com/storage/docs/lifecycle#conditions">Object Lifecycle
     *     Management</a>
     */
    public static class LifecycleCondition implements Serializable {
      private static final long serialVersionUID = -6482314338394768785L;
      private final Integer age;
      private final DateTime createdBefore;
      private final Integer numberOfNewerVersions;
      private final Boolean isLive;
      private final List<StorageClass> matchesStorageClass;

      private LifecycleCondition(Builder builder) {
        this.age = builder.age;
        this.createdBefore = builder.createdBefore;
        this.numberOfNewerVersions = builder.numberOfNewerVersions;
        this.isLive = builder.isLive;
        this.matchesStorageClass = builder.matchesStorageClass;
      }

      public Builder toBuilder() {
        return newBuilder()
            .setAge(this.age)
            .setCreatedBefore(this.createdBefore)
            .setNumberOfNewerVersions(this.numberOfNewerVersions)
            .setIsLive(this.isLive)
            .setMatchesStorageClass(this.matchesStorageClass);
      }

      public static Builder newBuilder() {
        return new Builder();
      }

      public Integer getAge() {
        return age;
      }

      public DateTime getCreatedBefore() {
        return createdBefore;
      }

      public Integer getNumberOfNewerVersions() {
        return numberOfNewerVersions;
      }

      public Boolean getIsLive() {
        return isLive;
      }

      public List<StorageClass> getMatchesStorageClass() {
        return matchesStorageClass;
      }

      /** Builder for {@code LifecycleCondition}. */
      public static class Builder {
        private Integer age;
        private DateTime createdBefore;
        private Integer numberOfNewerVersions;
        private Boolean isLive;
        private List<StorageClass> matchesStorageClass;

        private Builder() {}

        /**
         * Sets the age in days. This condition is satisfied when a Blob reaches the specified age
         * (in days). When you specify the Age condition, you are specifying a Time to Live (TTL)
         * for objects in a bucket with lifecycle management configured. The time when the Age
         * condition is considered to be satisfied is calculated by adding the specified value to
         * the object creation time.
         */
        public Builder setAge(Integer age) {
          this.age = age;
          return this;
        }

        /**
         * Sets the date a Blob should be created before for an Action to be executed. Note that
         * only the date will be considered, if the time is specified it will be truncated. This
         * condition is satisfied when an object is created before midnight of the specified date in
         * UTC. *
         */
        public Builder setCreatedBefore(DateTime createdBefore) {
          this.createdBefore = createdBefore;
          return this;
        }

        /**
         * Sets the number of newer versions a Blob should have for an Action to be executed.
         * Relevant only when versioning is enabled on a bucket. *
         */
        public Builder setNumberOfNewerVersions(Integer numberOfNewerVersions) {
          this.numberOfNewerVersions = numberOfNewerVersions;
          return this;
        }

        /**
         * Sets an isLive Boolean condition. If the value is true, this lifecycle condition matches
         * only live Blobs; if the value is false, it matches only archived objects. For the
         * purposes of this condition, Blobs in non-versioned buckets are considered live.
         */
        public Builder setIsLive(Boolean live) {
          this.isLive = live;
          return this;
        }

        /**
         * Sets a list of Storage Classes for a objects that satisfy the condition to execute the
         * Action. *
         */
        public Builder setMatchesStorageClass(List<StorageClass> matchesStorageClass) {
          this.matchesStorageClass = matchesStorageClass;
          return this;
        }

        /** Builds a {@code LifecycleCondition} object. * */
        public LifecycleCondition build() {
          return new LifecycleCondition(this);
        }
      }
    }

    /**
     * Base class for the Action to take when a Lifecycle Condition is met. Specific Actions are
     * expressed as subclasses of this class, accessed by static factory methods.
     */
    public abstract static class LifecycleAction implements Serializable {
      private static final long serialVersionUID = 5801228724709173284L;

      public abstract String getActionType();

      /**
       * Creates a new {@code DeleteLifecycleAction}. Blobs that meet the Condition associated with
       * this action will be deleted.
       */
      public static DeleteLifecycleAction newDeleteAction() {
        return new DeleteLifecycleAction();
      }

      /**
       * Creates a new {@code SetStorageClassLifecycleAction}. A Blob's storage class that meets the
       * action's conditions will be changed to the specified storage class.
       *
       * @param storageClass The new storage class to use when conditions are met for this action.
       */
      public static SetStorageClassLifecycleAction newSetStorageClassAction(
          StorageClass storageClass) {
        return new SetStorageClassLifecycleAction(storageClass);
      }
    }

    public static class DeleteLifecycleAction extends LifecycleAction {
      public static final String TYPE = "Delete";
      private static final long serialVersionUID = -2050986302222644873L;

      private DeleteLifecycleAction() {}

      @Override
      public String getActionType() {
        return TYPE;
      }
    }

    public static class SetStorageClassLifecycleAction extends LifecycleAction {
      public static final String TYPE = "SetStorageClass";
      private static final long serialVersionUID = -62615467186000899L;

      private final StorageClass storageClass;

      private SetStorageClassLifecycleAction(StorageClass storageClass) {
        this.storageClass = storageClass;
      }

      @Override
      public String getActionType() {
        return TYPE;
      }

      StorageClass getStorageClass() {
        return storageClass;
      }
    }
  }

  /**
   * Base class for bucket's delete rules. Allows to configure automatic deletion of blobs and blobs
   * versions.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Object Lifecycle Management</a>
   * @deprecated Use a {@code LifecycleRule} with a {@code DeleteLifecycleAction} and a {@code
   *     LifecycleCondition} which is equivalent to a subclass of DeleteRule instead.
   */
  @Deprecated
  public abstract static class DeleteRule implements Serializable {

    private static final long serialVersionUID = 3137971668395933033L;
    private static final String SUPPORTED_ACTION = "Delete";
    private final Type type;

    public enum Type {
      AGE,
      CREATE_BEFORE,
      NUM_NEWER_VERSIONS,
      IS_LIVE,
      UNKNOWN
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
   * @deprecated Use a {@code LifecycleRule} with a {@code DeleteLifecycleAction} and use {@code
   *     LifecycleCondition.Builder.setAge} instead.
   *     <p>For example, {@code new DeleteLifecycleAction(1)} is equivalent to {@code new
   *     LifecycleRule( LifecycleAction.newDeleteAction(),
   *     LifecycleCondition.newBuilder().setAge(1).build()))}
   */
  @Deprecated
  public static class AgeDeleteRule extends DeleteRule {

    private static final long serialVersionUID = 5697166940712116380L;
    private final int daysToLive;

    /**
     * Creates an {@code AgeDeleteRule} object.
     *
     * @param daysToLive blobs' Time To Live expressed in days. The time when the age condition is
     *     considered to be satisfied is computed by adding {@code daysToLive} days to the midnight
     *     following blob's creation time in UTC.
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

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
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
   * @deprecated Use a {@code LifecycleRule} with an action {@code DeleteLifecycleAction} and a
   *     condition {@code LifecycleCondition.Builder.setCreatedBefore} instead.
   */
  @Deprecated
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
      condition.setCreatedBefore(new DateTime(true, timeMillis, 0));
    }
  }

  /**
   * Delete rule class for versioned blobs. Specifies when to delete a blob's version according to
   * the number of available newer versions for that blob.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Object Lifecycle Management</a>
   * @deprecated Use a {@code LifecycleRule} with a {@code DeleteLifecycleAction} and a condition
   *     {@code LifecycleCondition.Builder.setNumberOfNewerVersions} instead.
   */
  @Deprecated
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
   * @deprecated Use a {@code LifecycleRule} with a {@code DeleteLifecycleAction} and a condition
   *     {@code LifecycleCondition.Builder.setIsLive} instead.
   */
  @Deprecated
  public static class IsLiveDeleteRule extends DeleteRule {

    private static final long serialVersionUID = -3502994563121313364L;
    private final boolean isLive;

    /**
     * Creates an {@code IsLiveDeleteRule} object.
     *
     * @param isLive if set to {@code true} live blobs meet the delete condition. If set to {@code
     *     false} delete condition is met by archived blobs.
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

  /** Builder for {@code BucketInfo}. */
  public abstract static class Builder {
    Builder() {}

    /** Sets the bucket's name. */
    public abstract Builder setName(String name);

    abstract Builder setGeneratedId(String generatedId);

    abstract Builder setOwner(Acl.Entity owner);

    abstract Builder setSelfLink(String selfLink);

    /**
     * Sets whether a user accessing the bucket or an object it contains should assume the transit
     * costs related to the access.
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

    /** Sets the custom object to return when a requested resource is not found. */
    public abstract Builder setNotFoundPage(String notFoundPage);

    /**
     * Sets the bucket's lifecycle configuration as a number of delete rules.
     *
     * @deprecated Use {@code setLifecycleRules} instead, as in {@code
     *     setLifecycleRules(Collections.singletonList( new BucketInfo.LifecycleRule(
     *     LifecycleAction.newDeleteAction(), LifecycleCondition.newBuilder().setAge(5).build())));}
     */
    @Deprecated
    public abstract Builder setDeleteRules(Iterable<? extends DeleteRule> rules);

    /**
     * Sets the bucket's lifecycle configuration as a number of lifecycle rules, consisting of an
     * action and a condition.
     *
     * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Object Lifecycle
     *     Management</a>
     */
    public abstract Builder setLifecycleRules(Iterable<? extends LifecycleRule> rules);

    /**
     * Sets the bucket's storage class. This defines how blobs in the bucket are stored and
     * determines the SLA and the cost of storage. A list of supported values is available <a
     * href="https://cloud.google.com/storage/docs/storage-classes">here</a>.
     */
    public abstract Builder setStorageClass(StorageClass storageClass);

    /**
     * Sets the bucket's location. Data for blobs in the bucket resides in physical storage within
     * this region. A list of supported values is available <a
     * href="https://cloud.google.com/storage/docs/bucket-locations">here</a>.
     */
    public abstract Builder setLocation(String location);

    abstract Builder setEtag(String etag);

    abstract Builder setCreateTime(Long createTime);

    abstract Builder setMetageneration(Long metageneration);

    abstract Builder setLocationType(String locationType);

    /**
     * Sets the bucket's Cross-Origin Resource Sharing (CORS) configuration.
     *
     * @see <a href="https://cloud.google.com/storage/docs/cross-origin">Cross-Origin Resource
     *     Sharing (CORS)</a>
     */
    public abstract Builder setCors(Iterable<Cors> cors);

    /**
     * Sets the bucket's access control configuration.
     *
     * @see <a
     *     href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
     *     About Access Control Lists</a>
     */
    public abstract Builder setAcl(Iterable<Acl> acl);

    /**
     * Sets the default access control configuration to apply to bucket's blobs when no other
     * configuration is specified.
     *
     * @see <a
     *     href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
     *     About Access Control Lists</a>
     */
    public abstract Builder setDefaultAcl(Iterable<Acl> acl);

    /** Sets the label of this bucket. */
    public abstract Builder setLabels(Map<String, String> labels);

    /** Sets the default Cloud KMS key name for this bucket. */
    public abstract Builder setDefaultKmsKeyName(String defaultKmsKeyName);

    /** Sets the default event-based hold for this bucket. */
    @BetaApi
    public abstract Builder setDefaultEventBasedHold(Boolean defaultEventBasedHold);

    @BetaApi
    abstract Builder setRetentionEffectiveTime(Long retentionEffectiveTime);

    @BetaApi
    abstract Builder setRetentionPolicyIsLocked(Boolean retentionPolicyIsLocked);

    /**
     * If policy is not locked this value can be cleared, increased, and decreased. If policy is
     * locked the retention period can only be increased.
     */
    @BetaApi
    public abstract Builder setRetentionPeriod(Long retentionPeriod);

    /**
     * Sets the IamConfiguration to specify whether IAM access should be enabled.
     *
     * @see <a href="https://cloud.google.com/storage/docs/bucket-policy-only">Bucket Policy
     *     Only</a>
     */
    @BetaApi
    public abstract Builder setIamConfiguration(IamConfiguration iamConfiguration);

    public abstract Builder setLogging(Logging logging);

    /** Creates a {@code BucketInfo} object. */
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
    private List<LifecycleRule> lifecycleRules;
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
    private Boolean defaultEventBasedHold;
    private Long retentionEffectiveTime;
    private Boolean retentionPolicyIsLocked;
    private Long retentionPeriod;
    private IamConfiguration iamConfiguration;
    private String locationType;
    private Logging logging;

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
      lifecycleRules = bucketInfo.lifecycleRules;
      labels = bucketInfo.labels;
      requesterPays = bucketInfo.requesterPays;
      defaultKmsKeyName = bucketInfo.defaultKmsKeyName;
      defaultEventBasedHold = bucketInfo.defaultEventBasedHold;
      retentionEffectiveTime = bucketInfo.retentionEffectiveTime;
      retentionPolicyIsLocked = bucketInfo.retentionPolicyIsLocked;
      retentionPeriod = bucketInfo.retentionPeriod;
      iamConfiguration = bucketInfo.iamConfiguration;
      locationType = bucketInfo.locationType;
      logging = bucketInfo.logging;
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

    /** @deprecated Use {@code setLifecycleRules} method instead. * */
    @Override
    @Deprecated
    public Builder setDeleteRules(Iterable<? extends DeleteRule> rules) {
      this.deleteRules = rules != null ? ImmutableList.copyOf(rules) : null;
      return this;
    }

    @Override
    public Builder setLifecycleRules(Iterable<? extends LifecycleRule> rules) {
      this.lifecycleRules = rules != null ? ImmutableList.copyOf(rules) : null;
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
      this.defaultKmsKeyName =
          defaultKmsKeyName != null ? defaultKmsKeyName : Data.<String>nullOf(String.class);
      return this;
    }

    @Override
    public Builder setDefaultEventBasedHold(Boolean defaultEventBasedHold) {
      this.defaultEventBasedHold =
          firstNonNull(defaultEventBasedHold, Data.<Boolean>nullOf(Boolean.class));
      return this;
    }

    @Override
    Builder setRetentionEffectiveTime(Long retentionEffectiveTime) {
      this.retentionEffectiveTime =
          firstNonNull(retentionEffectiveTime, Data.<Long>nullOf(Long.class));
      return this;
    }

    @Override
    Builder setRetentionPolicyIsLocked(Boolean retentionPolicyIsLocked) {
      this.retentionPolicyIsLocked =
          firstNonNull(retentionPolicyIsLocked, Data.<Boolean>nullOf(Boolean.class));
      return this;
    }

    @Override
    public Builder setRetentionPeriod(Long retentionPeriod) {
      this.retentionPeriod = firstNonNull(retentionPeriod, Data.<Long>nullOf(Long.class));
      return this;
    }

    @Override
    public Builder setIamConfiguration(IamConfiguration iamConfiguration) {
      this.iamConfiguration = iamConfiguration;
      return this;
    }

    @Override
    public Builder setLogging(Logging logging) {
      this.logging = logging;
      return this;
    }

    @Override
    Builder setLocationType(String locationType) {
      this.locationType = locationType;
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
    lifecycleRules = builder.lifecycleRules;
    labels = builder.labels;
    requesterPays = builder.requesterPays;
    defaultKmsKeyName = builder.defaultKmsKeyName;
    defaultEventBasedHold = builder.defaultEventBasedHold;
    retentionEffectiveTime = builder.retentionEffectiveTime;
    retentionPolicyIsLocked = builder.retentionPolicyIsLocked;
    retentionPeriod = builder.retentionPeriod;
    iamConfiguration = builder.iamConfiguration;
    locationType = builder.locationType;
    logging = builder.logging;
  }

  /** Returns the service-generated id for the bucket. */
  public String getGeneratedId() {
    return generatedId;
  }

  /** Returns the bucket's name. */
  public String getName() {
    return name;
  }

  /** Returns the bucket's owner. This is always the project team's owner group. */
  public Entity getOwner() {
    return owner;
  }

  /** Returns the URI of this bucket as a string. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * Returns a {@code Boolean} with either {@code true}, {@code null} and in certain cases {@code
   * false}.
   *
   * <p>Case 1: {@code true} the field {@link
   * com.google.cloud.storage.Storage.BucketField#VERSIONING} is selected in a {@link
   * Storage#get(String, Storage.BucketGetOption...)} and versions for the bucket is enabled.
   *
   * <p>Case 2.1: {@code null} the field {@link
   * com.google.cloud.storage.Storage.BucketField#VERSIONING} is selected in a {@link
   * Storage#get(String, Storage.BucketGetOption...)}, but versions for the bucket is not enabled.
   * This case can be considered implicitly {@code false}.
   *
   * <p>Case 2.2: {@code null} the field {@link
   * com.google.cloud.storage.Storage.BucketField#VERSIONING} is not selected in a {@link
   * Storage#get(String, Storage.BucketGetOption...)}, and the state for this field is unknown.
   *
   * <p>Case 3: {@code false} versions is explicitly set to false client side for a follow-up
   * request for example {@link Storage#update(BucketInfo, Storage.BucketTargetOption...)} in which
   * case the value of versions will remain {@code false} for for the given instance.
   */
  public Boolean versioningEnabled() {
    return Data.isNull(versioningEnabled) ? null : versioningEnabled;
  }

  /**
   * Returns a {@code Boolean} with either {@code true}, {@code false}, and in a specific case
   * {@code null}.
   *
   * <p>Case 1: {@code true} the field {@link com.google.cloud.storage.Storage.BucketField#BILLING}
   * is selected in a {@link Storage#get(String, Storage.BucketGetOption...)} and requester pays for
   * the bucket is enabled.
   *
   * <p>Case 2: {@code false} the field {@link com.google.cloud.storage.Storage.BucketField#BILLING}
   * in a {@link Storage#get(String, Storage.BucketGetOption...)} is selected and requester pays for
   * the bucket is disable.
   *
   * <p>Case 3: {@code null} the field {@link com.google.cloud.storage.Storage.BucketField#BILLING}
   * in a {@link Storage#get(String, Storage.BucketGetOption...)} is not selected, the value is
   * unknown.
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

  /** Returns the custom object to return when a requested resource is not found. */
  public String getNotFoundPage() {
    return notFoundPage;
  }

  /**
   * Returns bucket's lifecycle configuration as a number of delete rules.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle">Lifecycle Management</a>
   */
  @Deprecated
  public List<? extends DeleteRule> getDeleteRules() {
    return deleteRules;
  }

  public List<? extends LifecycleRule> getLifecycleRules() {
    return lifecycleRules;
  }

  /**
   * Returns HTTP 1.1 Entity tag for the bucket.
   *
   * @see <a href="http://tools.ietf.org/html/rfc2616#section-3.11">Entity Tags</a>
   */
  public String getEtag() {
    return etag;
  }

  /** Returns the time at which the bucket was created. */
  public Long getCreateTime() {
    return createTime;
  }

  /** Returns the metadata generation of this bucket. */
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
   * Returns the bucket's locationType.
   *
   * @see <a href="https://cloud.google.com/storage/docs/bucket-locations">Bucket LocationType</a>
   */
  public String getLocationType() {
    return locationType;
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
   * @see <a href="https://cloud.google.com/storage/docs/cross-origin">Cross-Origin Resource Sharing
   *     (CORS)</a>
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

  /** Returns the labels for this bucket. */
  public Map<String, String> getLabels() {
    return labels;
  }

  /** Returns the default Cloud KMS key to be applied to newly inserted objects in this bucket. */
  public String getDefaultKmsKeyName() {
    return defaultKmsKeyName;
  }

  /**
   * Returns a {@code Boolean} with either {@code true}, {@code null} and in certain cases {@code
   * false}.
   *
   * <p>Case 1: {@code true} the field {@link
   * com.google.cloud.storage.Storage.BucketField#DEFAULT_EVENT_BASED_HOLD} is selected in a {@link
   * Storage#get(String, Storage.BucketGetOption...)} and default event-based hold for the bucket is
   * enabled.
   *
   * <p>Case 2.1: {@code null} the field {@link
   * com.google.cloud.storage.Storage.BucketField#DEFAULT_EVENT_BASED_HOLD} is selected in a {@link
   * Storage#get(String, Storage.BucketGetOption...)}, but default event-based hold for the bucket
   * is not enabled. This case can be considered implicitly {@code false}.
   *
   * <p>Case 2.2: {@code null} the field {@link
   * com.google.cloud.storage.Storage.BucketField#DEFAULT_EVENT_BASED_HOLD} is not selected in a
   * {@link Storage#get(String, Storage.BucketGetOption...)}, and the state for this field is
   * unknown.
   *
   * <p>Case 3: {@code false} default event-based hold is explicitly set to false using in a {@link
   * Builder#setDefaultEventBasedHold(Boolean)} client side for a follow-up request e.g. {@link
   * Storage#update(BucketInfo, Storage.BucketTargetOption...)} in which case the value of default
   * event-based hold will remain {@code false} for the given instance.
   */
  @BetaApi
  public Boolean getDefaultEventBasedHold() {
    return Data.isNull(defaultEventBasedHold) ? null : defaultEventBasedHold;
  }

  /**
   * Returns the retention effective time a policy took effect if a retention policy is defined as a
   * {@code Long}.
   */
  @BetaApi
  public Long getRetentionEffectiveTime() {
    return retentionEffectiveTime;
  }

  /**
   * Returns a {@code Boolean} with either {@code true} or {@code null}.
   *
   * <p>Case 1: {@code true} the field {@link
   * com.google.cloud.storage.Storage.BucketField#RETENTION_POLICY} is selected in a {@link
   * Storage#get(String, Storage.BucketGetOption...)} and retention policy for the bucket is locked.
   *
   * <p>Case 2.1: {@code null} the field {@link
   * com.google.cloud.storage.Storage.BucketField#RETENTION_POLICY} is selected in a {@link
   * Storage#get(String, Storage.BucketGetOption...)}, but retention policy for the bucket is not
   * locked. This case can be considered implicitly {@code false}.
   *
   * <p>Case 2.2: {@code null} the field {@link
   * com.google.cloud.storage.Storage.BucketField#RETENTION_POLICY} is not selected in a {@link
   * Storage#get(String, Storage.BucketGetOption...)}, and the state for this field is unknown.
   */
  @BetaApi
  public Boolean retentionPolicyIsLocked() {
    return Data.isNull(retentionPolicyIsLocked) ? null : retentionPolicyIsLocked;
  }

  /** Returns the retention policy retention period. */
  @BetaApi
  public Long getRetentionPeriod() {
    return retentionPeriod;
  }

  /** Returns the IAM configuration */
  @BetaApi
  public IamConfiguration getIamConfiguration() {
    return iamConfiguration;
  }

  /** Returns the Logging */
  public Logging getLogging() {
    return logging;
  }

  /** Returns a builder for the current bucket. */
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
    return MoreObjects.toStringHelper(this).add("name", name).toString();
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
    if (locationType != null) {
      bucketPb.setLocationType(locationType);
    }
    if (storageClass != null) {
      bucketPb.setStorageClass(storageClass.toString());
    }
    if (cors != null) {
      bucketPb.setCors(transform(cors, Cors.TO_PB_FUNCTION));
    }
    if (acl != null) {
      bucketPb.setAcl(
          transform(
              acl,
              new Function<Acl, BucketAccessControl>() {
                @Override
                public BucketAccessControl apply(Acl acl) {
                  return acl.toBucketPb();
                }
              }));
    }
    if (defaultAcl != null) {
      bucketPb.setDefaultObjectAcl(
          transform(
              defaultAcl,
              new Function<Acl, ObjectAccessControl>() {
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
    Set<Rule> rules = new HashSet<>();
    if (deleteRules != null) {
      rules.addAll(
          transform(
              deleteRules,
              new Function<DeleteRule, Rule>() {
                @Override
                public Rule apply(DeleteRule deleteRule) {
                  return deleteRule.toPb();
                }
              }));
    }
    if (lifecycleRules != null) {
      rules.addAll(
          transform(
              lifecycleRules,
              new Function<LifecycleRule, Rule>() {
                @Override
                public Rule apply(LifecycleRule lifecycleRule) {
                  return lifecycleRule.toPb();
                }
              }));
    }
    if (!rules.isEmpty()) {
      Lifecycle lifecycle = new Lifecycle();
      lifecycle.setRule(ImmutableList.copyOf(rules));
      bucketPb.setLifecycle(lifecycle);
    }
    if (labels != null) {
      bucketPb.setLabels(labels);
    }
    if (defaultKmsKeyName != null) {
      bucketPb.setEncryption(new Encryption().setDefaultKmsKeyName(defaultKmsKeyName));
    }
    if (defaultEventBasedHold != null) {
      bucketPb.setDefaultEventBasedHold(defaultEventBasedHold);
    }
    if (retentionPeriod != null) {
      if (Data.isNull(retentionPeriod)) {
        bucketPb.setRetentionPolicy(
            Data.<Bucket.RetentionPolicy>nullOf(Bucket.RetentionPolicy.class));
      } else {
        Bucket.RetentionPolicy retentionPolicy = new Bucket.RetentionPolicy();
        retentionPolicy.setRetentionPeriod(retentionPeriod);
        if (retentionEffectiveTime != null) {
          retentionPolicy.setEffectiveTime(new DateTime(retentionEffectiveTime));
        }
        if (retentionPolicyIsLocked != null) {
          retentionPolicy.setIsLocked(retentionPolicyIsLocked);
        }
        bucketPb.setRetentionPolicy(retentionPolicy);
      }
    }
    if (iamConfiguration != null) {
      bucketPb.setIamConfiguration(iamConfiguration.toPb());
    }
    if (logging != null) {
      bucketPb.setLogging(logging.toPb());
    }
    return bucketPb;
  }

  /** Creates a {@code BucketInfo} object for the provided bucket name. */
  public static BucketInfo of(String name) {
    return newBuilder(name).build();
  }

  /** Returns a {@code BucketInfo} builder where the bucket's name is set to the provided name. */
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
      builder.setAcl(
          transform(
              bucketPb.getAcl(),
              new Function<BucketAccessControl, Acl>() {
                @Override
                public Acl apply(BucketAccessControl bucketAccessControl) {
                  return Acl.fromPb(bucketAccessControl);
                }
              }));
    }
    if (bucketPb.getDefaultObjectAcl() != null) {
      builder.setDefaultAcl(
          transform(
              bucketPb.getDefaultObjectAcl(),
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
      builder.setLifecycleRules(
          transform(
              bucketPb.getLifecycle().getRule(),
              new Function<Rule, LifecycleRule>() {
                @Override
                public LifecycleRule apply(Rule rule) {
                  return LifecycleRule.fromPb(rule);
                }
              }));
      builder.setDeleteRules(
          transform(
              bucketPb.getLifecycle().getRule(),
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
    if (encryption != null
        && encryption.getDefaultKmsKeyName() != null
        && !encryption.getDefaultKmsKeyName().isEmpty()) {
      builder.setDefaultKmsKeyName(encryption.getDefaultKmsKeyName());
    }
    if (bucketPb.getDefaultEventBasedHold() != null) {
      builder.setDefaultEventBasedHold(bucketPb.getDefaultEventBasedHold());
    }
    Bucket.RetentionPolicy retentionPolicy = bucketPb.getRetentionPolicy();
    if (retentionPolicy != null) {
      if (retentionPolicy.getEffectiveTime() != null) {
        builder.setRetentionEffectiveTime(retentionPolicy.getEffectiveTime().getValue());
      }
      if (retentionPolicy.getIsLocked() != null) {
        builder.setRetentionPolicyIsLocked(retentionPolicy.getIsLocked());
      }
      if (retentionPolicy.getRetentionPeriod() != null) {
        builder.setRetentionPeriod(retentionPolicy.getRetentionPeriod());
      }
    }
    Bucket.IamConfiguration iamConfiguration = bucketPb.getIamConfiguration();

    if (bucketPb.getLocationType() != null) {
      builder.setLocationType(bucketPb.getLocationType());
    }

    if (iamConfiguration != null) {
      builder.setIamConfiguration(IamConfiguration.fromPb(iamConfiguration));
    }
    Bucket.Logging logging = bucketPb.getLogging();
    if (logging != null) {
      builder.setLogging(Logging.fromPb(logging));
    }
    return builder.build();
  }
}
