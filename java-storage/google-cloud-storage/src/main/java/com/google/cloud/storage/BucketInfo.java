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

import static com.google.cloud.storage.BackwardCompatibilityUtils.millisOffsetDateTimeCodec;
import static com.google.cloud.storage.BackwardCompatibilityUtils.millisUtcCodec;
import static com.google.cloud.storage.BackwardCompatibilityUtils.nullableDurationSecondsCodec;
import static com.google.cloud.storage.Utils.diffMaps;
import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.BlobInfo.ImmutableEmptyMap;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.NamedField;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Streams;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.annotation.concurrent.Immutable;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Google Storage bucket metadata;
 *
 * @see <a href="https://cloud.google.com/storage/docs/concepts-techniques#concepts">Concepts and
 *     Terminology</a>
 */
@TransportCompatibility({Transport.HTTP, Transport.GRPC})
public class BucketInfo implements Serializable {

  // this class reference (LifecycleRule.DeleteLifecycleAction) must be long form.
  // if it is not long form, and instead an import it creates a cycle of serializable classes
  // which breaks the compiler.
  //
  // The error message looks like the following:
  //     java: cannot find symbol
  //       symbol:   class Serializable
  //       location: class com.google.cloud.storage.BucketInfo
  private static final Predicate<LifecycleRule> IS_DELETE_LIFECYCLE_RULE =
      r -> r.getAction().getActionType().equals(LifecycleRule.DeleteLifecycleAction.TYPE);

  private static final long serialVersionUID = 4793572058456298945L;
  private final String generatedId;
  private final BigInteger project;
  private final String name;
  private final Acl.Entity owner;
  private final String selfLink;
  private final Boolean requesterPays;
  private final Boolean versioningEnabled;
  private final String indexPage;
  private final String notFoundPage;

  /**
   * The getter for this property never returns null, however null awareness is critical for
   * encoding to properly determine how to process rules conversion.
   *
   * @see JsonConversions#bucketInfo() encoder
   */
  final List<LifecycleRule> lifecycleRules;

  private final String etag;
  private final OffsetDateTime createTime;
  private final OffsetDateTime updateTime;
  private final Long metageneration;
  private final List<Cors> cors;
  private final List<Acl> acl;
  private final List<Acl> defaultAcl;
  private final String location;
  private final Rpo rpo;
  private final StorageClass storageClass;
  @Nullable private final Map<String, String> labels;
  private final String defaultKmsKeyName;
  private final Boolean defaultEventBasedHold;
  private final OffsetDateTime retentionEffectiveTime;
  private final Boolean retentionPolicyIsLocked;
  private final Duration retentionPeriod;
  private final IamConfiguration iamConfiguration;
  private final Autoclass autoclass;
  private final String locationType;
  private final Logging logging;
  private final CustomPlacementConfig customPlacementConfig;
  private final ObjectRetention objectRetention;
  private final HierarchicalNamespace hierarchicalNamespace;

  private final SoftDeletePolicy softDeletePolicy;
  private final @Nullable IpFilter ipFilter;
  private final @Nullable GoogleManagedEncryptionEnforcementConfig
      googleManagedEncryptionEnforcementConfig;
  private final @Nullable CustomerManagedEncryptionEnforcementConfig
      customerManagedEncryptionEnforcementConfig;
  private final @Nullable CustomerSuppliedEncryptionEnforcementConfig
      customerSuppliedEncryptionEnforcementConfig;
  private final Boolean isUnreachable;

  private final transient ImmutableSet<NamedField> modifiedFields;

  /**
   * non-private for backward compatibility on message class. log messages are now emitted from
   *
   * @see JsonConversions#lifecycleRule()
   */
  static final Logger log = Logger.getLogger(BucketInfo.class.getName());

  /**
   * Public Access Prevention enum with expected values.
   *
   * @see <a
   *     href="https://cloud.google.com/storage/docs/public-access-prevention">public-access-prevention</a>
   */
  public enum PublicAccessPrevention {
    ENFORCED("enforced"),
    /**
     * Default value for Public Access Prevention
     *
     * @deprecated use {@link #INHERITED}
     */
    @Deprecated
    UNSPECIFIED("inherited"),
    /**
     * If the api returns a value that isn't defined in {@link PublicAccessPrevention} this value
     * will be returned.
     */
    UNKNOWN(null),
    INHERITED("inherited");

    private final String value;

    PublicAccessPrevention(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    public static PublicAccessPrevention parse(String value) {
      String upper = value.toUpperCase();
      switch (upper) {
        case "ENFORCED":
          return ENFORCED;
        case "UNSPECIFIED":
        case "INHERITED":
          return INHERITED;
        default:
          return UNKNOWN;
      }
    }
  }

  /**
   * The Bucket's IAM Configuration.
   *
   * @see <a href="https://cloud.google.com/storage/docs/uniform-bucket-level-access">uniform
   *     bucket-level access</a>
   * @see <a
   *     href="https://cloud.google.com/storage/docs/public-access-prevention">public-access-prevention</a>
   */
  public static class IamConfiguration implements Serializable {
    private static final long serialVersionUID = -7564209362829587435L;

    private final Boolean isUniformBucketLevelAccessEnabled;
    private final OffsetDateTime uniformBucketLevelAccessLockedTime;
    private final PublicAccessPrevention publicAccessPrevention;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof IamConfiguration)) {
        return false;
      }
      IamConfiguration that = (IamConfiguration) o;
      return Objects.equals(
              isUniformBucketLevelAccessEnabled, that.isUniformBucketLevelAccessEnabled)
          && Objects.equals(
              uniformBucketLevelAccessLockedTime, that.uniformBucketLevelAccessLockedTime)
          && publicAccessPrevention == that.publicAccessPrevention;
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          isUniformBucketLevelAccessEnabled,
          uniformBucketLevelAccessLockedTime,
          publicAccessPrevention);
    }

    private IamConfiguration(Builder builder) {
      this.isUniformBucketLevelAccessEnabled = builder.isUniformBucketLevelAccessEnabled;
      this.uniformBucketLevelAccessLockedTime = builder.uniformBucketLevelAccessLockedTime;
      this.publicAccessPrevention = builder.publicAccessPrevention;
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.isUniformBucketLevelAccessEnabled = isUniformBucketLevelAccessEnabled;
      builder.uniformBucketLevelAccessLockedTime = uniformBucketLevelAccessLockedTime;
      builder.publicAccessPrevention = publicAccessPrevention;
      return builder;
    }

    /** Deprecated in favor of isUniformBucketLevelAccessEnabled(). */
    @Deprecated
    public Boolean isBucketPolicyOnlyEnabled() {
      return isUniformBucketLevelAccessEnabled;
    }

    /** Deprecated in favor of uniformBucketLevelAccessLockedTime(). */
    @Deprecated
    public Long getBucketPolicyOnlyLockedTime() {
      return getUniformBucketLevelAccessLockedTime();
    }

    public Boolean isUniformBucketLevelAccessEnabled() {
      return isUniformBucketLevelAccessEnabled;
    }

    /**
     * @deprecated {@link #getUniformBucketLevelAccessLockedTimeOffsetDateTime()}
     */
    @Deprecated
    public Long getUniformBucketLevelAccessLockedTime() {
      return millisOffsetDateTimeCodec.decode(uniformBucketLevelAccessLockedTime);
    }

    public OffsetDateTime getUniformBucketLevelAccessLockedTimeOffsetDateTime() {
      return uniformBucketLevelAccessLockedTime;
    }

    /** Returns the Public Access Prevention. * */
    public PublicAccessPrevention getPublicAccessPrevention() {
      return publicAccessPrevention;
    }

    /** Builder for {@code IamConfiguration} */
    public static class Builder {
      private Boolean isUniformBucketLevelAccessEnabled;
      private OffsetDateTime uniformBucketLevelAccessLockedTime;
      private PublicAccessPrevention publicAccessPrevention;

      /** Deprecated in favor of setIsUniformBucketLevelAccessEnabled(). */
      @Deprecated
      public Builder setIsBucketPolicyOnlyEnabled(Boolean isBucketPolicyOnlyEnabled) {
        this.isUniformBucketLevelAccessEnabled = isBucketPolicyOnlyEnabled;
        return this;
      }

      /**
       * @deprecated in favor of {@link #setUniformBucketLevelAccessLockedTime(Long)}.
       */
      @Deprecated
      Builder setBucketPolicyOnlyLockedTime(Long bucketPolicyOnlyLockedTime) {
        return setUniformBucketLevelAccessLockedTime(bucketPolicyOnlyLockedTime);
      }

      /**
       * Sets whether uniform bucket-level access is enabled for this bucket. When this is enabled,
       * access to the bucket will be configured through IAM, and legacy ACL policies will not work.
       * When this is first enabled, {@code uniformBucketLevelAccess.lockedTime} will be set by the
       * API automatically. This field can then be disabled until the time specified, after which it
       * will become immutable and calls to change it will fail. If this is enabled, calls to access
       * legacy ACL information will fail.
       */
      public Builder setIsUniformBucketLevelAccessEnabled(
          Boolean isUniformBucketLevelAccessEnabled) {
        this.isUniformBucketLevelAccessEnabled = isUniformBucketLevelAccessEnabled;
        return this;
      }

      /**
       * Sets the deadline for switching {@code uniformBucketLevelAccess.enabled} back to false.
       * After this time passes, calls to do so will fail. This is package-private, since in general
       * this field should never be set by a user--it's automatically set by the backend when {@code
       * enabled} is set to true.
       *
       * @deprecated {@link #setUniformBucketLevelAccessLockedTimeOffsetDateTime(OffsetDateTime)}
       */
      @Deprecated
      Builder setUniformBucketLevelAccessLockedTime(Long uniformBucketLevelAccessLockedTime) {
        return setUniformBucketLevelAccessLockedTimeOffsetDateTime(
            millisOffsetDateTimeCodec.encode(uniformBucketLevelAccessLockedTime));
      }

      /**
       * Sets the deadline for switching {@code uniformBucketLevelAccess.enabled} back to false.
       * After this time passes, calls to do so will fail. This is package-private, since in general
       * this field should never be set by a user--it's automatically set by the backend when {@code
       * enabled} is set to true.
       */
      Builder setUniformBucketLevelAccessLockedTimeOffsetDateTime(
          OffsetDateTime uniformBucketLevelAccessLockedTime) {
        this.uniformBucketLevelAccessLockedTime = uniformBucketLevelAccessLockedTime;
        return this;
      }

      /**
       * Sets the bucket's Public Access Prevention configuration. Currently supported options are
       * {@link PublicAccessPrevention#INHERITED} or {@link PublicAccessPrevention#ENFORCED}
       *
       * @see <a
       *     href="https://cloud.google.com/storage/docs/public-access-prevention">public-access-prevention</a>
       */
      public Builder setPublicAccessPrevention(PublicAccessPrevention publicAccessPrevention) {
        this.publicAccessPrevention = publicAccessPrevention;
        return this;
      }

      /** Builds an {@code IamConfiguration} object */
      public IamConfiguration build() {
        return new IamConfiguration(this);
      }
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("isUniformBucketLevelAccessEnabled", isUniformBucketLevelAccessEnabled)
          .add("uniformBucketLevelAccessLockedTime", uniformBucketLevelAccessLockedTime)
          .add("publicAccessPrevention", publicAccessPrevention)
          .toString();
    }
  }

  /**
   * The bucket's soft delete policy. If this policy is set, any deleted objects will be
   * soft-deleted according to the time specified in the policy
   */
  public static class SoftDeletePolicy implements Serializable {

    private static final long serialVersionUID = -8100190443052242908L;
    private Duration retentionDuration;
    private OffsetDateTime effectiveTime;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof SoftDeletePolicy)) {
        return false;
      }
      SoftDeletePolicy that = (SoftDeletePolicy) o;
      return Objects.equals(retentionDuration, that.retentionDuration)
          && Objects.equals(effectiveTime, that.effectiveTime);
    }

    @Override
    public int hashCode() {
      return Objects.hash(retentionDuration, effectiveTime);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("retentionDuration", retentionDuration)
          .add("effectiveTime", effectiveTime)
          .toString();
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder toBuilder() {
      return new Builder().setRetentionDuration(retentionDuration).setEffectiveTime(effectiveTime);
    }

    private SoftDeletePolicy() {}

    public SoftDeletePolicy(Builder builder) {
      this.retentionDuration = builder.retentionDuration;
      this.effectiveTime = builder.effectiveTime;
    }

    public Duration getRetentionDuration() {
      return retentionDuration;
    }

    public OffsetDateTime getEffectiveTime() {
      return effectiveTime;
    }

    public static final class Builder {
      private Duration retentionDuration;
      private OffsetDateTime effectiveTime;

      /** Sets the length of time to retain soft-deleted objects for, expressed as a Duration */
      public Builder setRetentionDuration(Duration retentionDuration) {
        this.retentionDuration = retentionDuration;
        return this;
      }

      /**
       * Sets the time from which this soft-delete policy is effective. This is package-private
       * because it can only be set by the backend.
       */
      Builder setEffectiveTime(OffsetDateTime effectiveTime) {
        this.effectiveTime = effectiveTime;
        return this;
      }

      public SoftDeletePolicy build() {
        return new SoftDeletePolicy(this);
      }
    }
  }

  /**
   * Configuration for the Autoclass settings of a bucket.
   *
   * @see <a
   *     href="https://cloud.google.com/storage/docs/autoclass">https://cloud.google.com/storage/docs/autoclass</a>
   */
  public static final class Autoclass implements Serializable {

    private static final long serialVersionUID = -2378172222188072439L;
    private final Boolean enabled;
    private final OffsetDateTime toggleTime;
    private final StorageClass terminalStorageClass;
    private final OffsetDateTime terminalStorageClassUpdateTime;

    private Autoclass(Builder builder) {
      this.enabled = builder.enabled;
      this.toggleTime = builder.toggleTime;
      this.terminalStorageClass = builder.terminalStorageClass;
      this.terminalStorageClassUpdateTime = builder.terminalStorageClassUpdateTime;
    }

    public Boolean getEnabled() {
      return enabled;
    }

    public OffsetDateTime getToggleTime() {
      return toggleTime;
    }

    public StorageClass getTerminalStorageClass() {
      return terminalStorageClass;
    }

    public OffsetDateTime getTerminalStorageClassUpdateTime() {
      return terminalStorageClassUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Autoclass)) {
        return false;
      }
      Autoclass autoclass = (Autoclass) o;
      return Objects.equals(enabled, autoclass.enabled)
          && Objects.equals(toggleTime, autoclass.toggleTime)
          && Objects.equals(terminalStorageClass, autoclass.terminalStorageClass)
          && Objects.equals(
              terminalStorageClassUpdateTime, autoclass.terminalStorageClassUpdateTime);
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          enabled, toggleTime, terminalStorageClass, terminalStorageClassUpdateTime);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("enabled", enabled)
          .add("toggleTime", toggleTime)
          .add("terminalStorageClass", terminalStorageClass)
          .add("terminalStorageClassUpdateTime", terminalStorageClassUpdateTime)
          .toString();
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder toBuilder() {
      return newBuilder()
          .setEnabled(enabled)
          .setToggleTime(toggleTime)
          .setTerminalStorageClass(terminalStorageClass)
          .setTerminalStorageClassUpdateTime(terminalStorageClassUpdateTime);
    }

    public static final class Builder {
      private Boolean enabled;
      private OffsetDateTime toggleTime;
      private StorageClass terminalStorageClass;
      private OffsetDateTime terminalStorageClassUpdateTime;

      /**
       * Sets whether Autoclass is enabled for this bucket. Currently, autoclass can only be enabled
       * at bucket create time. Any calls to update an existing Autoclass configuration must be to
       * disable it, calls to enable Autoclass on an existing bucket will fail.
       */
      public Builder setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
      }

      /**
       * Sets the last time autoclass was toggled on or off. Set to package private because this
       * should only be set by the backend.
       */
      Builder setToggleTime(OffsetDateTime toggleTime) {
        this.toggleTime = toggleTime;
        return this;
      }

      /**
       * When set to {@link StorageClass#NEARLINE}, Autoclass restricts transitions between Standard
       * and Nearline storage classes only.
       *
       * <p>When set to {@link StorageClass#ARCHIVE}, Autoclass allows transitions to Coldline and
       * Archive as well.
       *
       * <p>Only valid values are {@code NEARLINE} and {@code ARCHIVE}.
       */
      public Builder setTerminalStorageClass(StorageClass terminalStorageClass) {
        this.terminalStorageClass = terminalStorageClass;
        return this;
      }

      /**
       * The time at which Autoclass terminal storage class was last updated for this bucket.
       *
       * <p>This is auto populated when the feature is enabled.
       */
      Builder setTerminalStorageClassUpdateTime(OffsetDateTime terminalStorageClassUpdateTime) {
        this.terminalStorageClassUpdateTime = terminalStorageClassUpdateTime;
        return this;
      }

      public Autoclass build() {
        return new Autoclass(this);
      }
    }
  }

  public static final class ObjectRetention implements Serializable {

    private static final long serialVersionUID = 3948199339534287669L;
    private Mode mode;

    public Mode getMode() {
      return mode;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof ObjectRetention)) {
        return false;
      }
      ObjectRetention that = (ObjectRetention) o;
      return Objects.equals(mode, that.mode);
    }

    @Override
    public int hashCode() {
      return Objects.hash(mode);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("mode", mode).toString();
    }

    private ObjectRetention() {}

    private ObjectRetention(Builder builder) {
      this.mode = builder.mode;
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder toBuilder() {
      return new Builder().setMode(this.mode);
    }

    public static final class Builder {
      private Mode mode;

      /** Sets the object retention mode. Can be Enabled or Disabled. */
      public Builder setMode(Mode mode) {
        this.mode = mode;
        return this;
      }

      public ObjectRetention build() {
        return new ObjectRetention(this);
      }
    }

    public static final class Mode extends StringEnumValue {
      private static final long serialVersionUID = 1973143582659557184L;

      private Mode(String constant) {
        super(constant);
      }

      private static final ApiFunction<String, Mode> CONSTRUCTOR = Mode::new;

      private static final StringEnumType<Mode> type =
          new StringEnumType<>(Mode.class, CONSTRUCTOR);

      public static final Mode ENABLED = type.createAndRegister("Enabled");

      public static final Mode DISABLED = type.createAndRegister("Disabled");

      public static Mode valueOfStrict(String constant) {
        return type.valueOfStrict(constant);
      }

      public static Mode valueOf(String constant) {
        return type.valueOf(constant);
      }

      public static Mode[] values() {
        return type.values();
      }
    }
  }

  /**
   * The bucket's custom placement configuration for Custom Dual Regions. If using `location` is
   * also required.
   */
  public static class CustomPlacementConfig implements Serializable {

    private static final long serialVersionUID = 7284488308696895602L;
    private List<String> dataLocations;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof CustomPlacementConfig)) {
        return false;
      }
      CustomPlacementConfig that = (CustomPlacementConfig) o;
      return Objects.equals(dataLocations, that.dataLocations);
    }

    @Override
    public int hashCode() {
      return Objects.hash(dataLocations);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("dataLocations", dataLocations).toString();
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.dataLocations = dataLocations;
      return builder;
    }

    public List<String> getDataLocations() {
      return dataLocations;
    }

    private CustomPlacementConfig(Builder builder) {
      this.dataLocations = builder.dataLocations;
    }

    public static class Builder {
      private List<String> dataLocations;

      /** A list of regions for custom placement configurations. */
      public Builder setDataLocations(List<String> dataLocations) {
        this.dataLocations = dataLocations != null ? ImmutableList.copyOf(dataLocations) : null;
        return this;
      }

      public CustomPlacementConfig build() {
        return new CustomPlacementConfig(this);
      }
    }
  }

  /**
   * The bucket's logging configuration, which defines the destination bucket and optional name
   * prefix for the current bucket's logs.
   */
  public static class Logging implements Serializable {

    private static final long serialVersionUID = 5213268072569764596L;
    private final String logBucket;
    private final String logObjectPrefix;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Logging)) {
        return false;
      }
      Logging logging = (Logging) o;
      return Objects.equals(logBucket, logging.logBucket)
          && Objects.equals(logObjectPrefix, logging.logObjectPrefix);
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

  /** The bucket's hierarchical namespace (Folders) configuration. Enable this to use HNS. */
  public static final class HierarchicalNamespace implements Serializable {

    private static final long serialVersionUID = 5932926691444613101L;
    private Boolean enabled;

    public Boolean getEnabled() {
      return enabled;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof HierarchicalNamespace)) {
        return false;
      }
      HierarchicalNamespace that = (HierarchicalNamespace) o;
      return Objects.equals(enabled, that.enabled);
    }

    @Override
    public int hashCode() {
      return Objects.hash(enabled);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("enabled", enabled).toString();
    }

    private HierarchicalNamespace() {}

    private HierarchicalNamespace(Builder builder) {
      this.enabled = builder.enabled;
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder toBuilder() {
      return newBuilder().setEnabled(enabled);
    }

    public static final class Builder {
      private Boolean enabled;

      /**
       * Sets whether Hierarchical Namespace (Folders) is enabled for this bucket. This can only be
       * enabled at bucket create time. If this is enabled, Uniform Bucket-Level Access must also be
       * enabled.
       */
      public Builder setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
      }

      public HierarchicalNamespace build() {
        return new HierarchicalNamespace(this);
      }
    }
  }

  /**
   * Lifecycle rule for a bucket. Allows supported Actions, such as deleting and changing storage
   * class, to be executed when certain Conditions are met.
   *
   * <p>Versions 1.50.0-1.111.2 of this library don’t support the CustomTimeBefore,
   * DaysSinceCustomTime, DaysSinceNoncurrentTime and NoncurrentTimeBefore lifecycle conditions. To
   * read GCS objects with those lifecycle conditions, update your Java client library to the latest
   * version.
   *
   * @see <a href="https://cloud.google.com/storage/docs/lifecycle#actions">Object Lifecycle
   *     Management</a>
   */
  public static class LifecycleRule implements Serializable {

    private static final long serialVersionUID = 8685745573894069326L;
    private final LifecycleAction lifecycleAction;
    private final LifecycleCondition lifecycleCondition;

    public LifecycleRule(LifecycleAction action, LifecycleCondition condition) {
      if (condition.getIsLive() == null
          && condition.getAge() == null
          && condition.getCreatedBefore() == null
          && condition.getMatchesStorageClass() == null
          && condition.getNumberOfNewerVersions() == null
          && condition.getDaysSinceNoncurrentTime() == null
          && condition.getNoncurrentTimeBefore() == null
          && condition.getCustomTimeBefore() == null
          && condition.getDaysSinceCustomTime() == null
          && condition.getMatchesPrefix() == null
          && condition.getMatchesSuffix() == null) {
        log.warning(
            "Creating a lifecycle condition with no supported conditions:\n"
                + this
                + "\nAttempting to update with this rule may cause errors. Please update "
                + " to the latest version of google-cloud-storage");
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
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("lifecycleAction", lifecycleAction)
          .add("lifecycleCondition", lifecycleCondition)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(lifecycleAction, lifecycleCondition);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof LifecycleRule)) {
        return false;
      }
      LifecycleRule that = (LifecycleRule) o;
      return Objects.equals(lifecycleAction, that.lifecycleAction)
          && Objects.equals(lifecycleCondition, that.lifecycleCondition);
    }

    /**
     * Condition for a Lifecycle rule, specifies under what criteria an Action should be executed.
     *
     * @see <a href="https://cloud.google.com/storage/docs/lifecycle#conditions">Object Lifecycle
     *     Management</a>
     */
    public static class LifecycleCondition implements Serializable {
      private static final long serialVersionUID = 7127585850045827932L;
      private final Integer age;
      private final OffsetDateTime createdBefore;
      private final Integer numberOfNewerVersions;
      private final Boolean isLive;
      private final List<StorageClass> matchesStorageClass;
      private final Integer daysSinceNoncurrentTime;
      private final OffsetDateTime noncurrentTimeBefore;
      private final OffsetDateTime customTimeBefore;
      private final Integer daysSinceCustomTime;
      private final List<String> matchesPrefix;
      private final List<String> matchesSuffix;

      private LifecycleCondition(Builder builder) {
        this.age = builder.age;
        this.createdBefore = builder.createdBefore;
        this.numberOfNewerVersions = builder.numberOfNewerVersions;
        this.isLive = builder.isLive;
        this.matchesStorageClass = builder.matchesStorageClass;
        this.daysSinceNoncurrentTime = builder.daysSinceNoncurrentTime;
        this.noncurrentTimeBefore = builder.noncurrentTimeBefore;
        this.customTimeBefore = builder.customTimeBefore;
        this.daysSinceCustomTime = builder.daysSinceCustomTime;
        this.matchesPrefix = builder.matchesPrefix;
        this.matchesSuffix = builder.matchesSuffix;
      }

      public Builder toBuilder() {
        return newBuilder()
            .setAge(this.age)
            .setCreatedBeforeOffsetDateTime(this.createdBefore)
            .setNumberOfNewerVersions(this.numberOfNewerVersions)
            .setIsLive(this.isLive)
            .setMatchesStorageClass(this.matchesStorageClass)
            .setDaysSinceNoncurrentTime(this.daysSinceNoncurrentTime)
            .setNoncurrentTimeBeforeOffsetDateTime(this.noncurrentTimeBefore)
            .setCustomTimeBeforeOffsetDateTime(this.customTimeBefore)
            .setDaysSinceCustomTime(this.daysSinceCustomTime)
            .setMatchesPrefix(this.matchesPrefix)
            .setMatchesSuffix(this.matchesSuffix);
      }

      public static Builder newBuilder() {
        return new Builder();
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("age", age)
            .add("createBefore", createdBefore)
            .add("numberofNewerVersions", numberOfNewerVersions)
            .add("isLive", isLive)
            .add("matchesStorageClass", matchesStorageClass)
            .add("daysSinceNoncurrentTime", daysSinceNoncurrentTime)
            .add("noncurrentTimeBefore", noncurrentTimeBefore)
            .add("customTimeBefore", customTimeBefore)
            .add("daysSinceCustomTime", daysSinceCustomTime)
            .add("matchesPrefix", matchesPrefix)
            .add("matchesSuffix", matchesSuffix)
            .toString();
      }

      public Integer getAge() {
        return age;
      }

      /**
       * @deprecated Use {@link #getCreatedBeforeOffsetDateTime()}
       */
      @Deprecated
      public DateTime getCreatedBefore() {
        return Utils.dateTimeCodec.nullable().encode(createdBefore);
      }

      /**
       * Returns the date and offset from UTC for this condition. If a time other than 00:00:00.000
       * is present in the value, GCS will truncate to 00:00:00.000.
       */
      public OffsetDateTime getCreatedBeforeOffsetDateTime() {
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

      /** Returns the number of days elapsed since the noncurrent timestamp of an object. */
      public Integer getDaysSinceNoncurrentTime() {
        return daysSinceNoncurrentTime;
      }

      /**
       * Returns the date in RFC 3339 format with only the date part (for instance, "2013-01-15").
       *
       * @deprecated Use {@link #getNoncurrentTimeBeforeOffsetDateTime()}
       */
      @Deprecated
      public DateTime getNoncurrentTimeBefore() {
        return Utils.dateTimeCodec.nullable().encode(noncurrentTimeBefore);
      }

      /**
       * Returns the date and offset from UTC for this condition. If a time other than 00:00:00.000
       * is present in the value, GCS will truncate to 00:00:00.000.
       */
      public OffsetDateTime getNoncurrentTimeBeforeOffsetDateTime() {
        return noncurrentTimeBefore;
      }

      /**
       * Returns the date in RFC 3339 format with only the date part (for instance, "2013-01-15").
       *
       * @deprecated Use {@link #getCustomTimeBeforeOffsetDateTime()}
       */
      @Deprecated
      public DateTime getCustomTimeBefore() {
        return Utils.dateTimeCodec.nullable().encode(customTimeBefore);
      }

      /**
       * Returns the date and offset from UTC for this condition. If a time other than 00:00:00.000
       * is present in the value, GCS will truncate to 00:00:00.000.
       */
      public OffsetDateTime getCustomTimeBeforeOffsetDateTime() {
        return customTimeBefore;
      }

      /** Returns the number of days elapsed since the user-specified timestamp set on an object. */
      public Integer getDaysSinceCustomTime() {
        return daysSinceCustomTime;
      }

      public List<String> getMatchesPrefix() {
        return matchesPrefix;
      }

      public List<String> getMatchesSuffix() {
        return matchesSuffix;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof LifecycleCondition)) {
          return false;
        }
        LifecycleCondition that = (LifecycleCondition) o;
        return Objects.equals(age, that.age)
            && Objects.equals(createdBefore, that.createdBefore)
            && Objects.equals(numberOfNewerVersions, that.numberOfNewerVersions)
            && Objects.equals(isLive, that.isLive)
            && Objects.equals(matchesStorageClass, that.matchesStorageClass)
            && Objects.equals(daysSinceNoncurrentTime, that.daysSinceNoncurrentTime)
            && Objects.equals(noncurrentTimeBefore, that.noncurrentTimeBefore)
            && Objects.equals(customTimeBefore, that.customTimeBefore)
            && Objects.equals(daysSinceCustomTime, that.daysSinceCustomTime)
            && Objects.equals(matchesPrefix, that.matchesPrefix)
            && Objects.equals(matchesSuffix, that.matchesSuffix);
      }

      @Override
      public int hashCode() {
        return Objects.hash(
            age,
            createdBefore,
            numberOfNewerVersions,
            isLive,
            matchesStorageClass,
            daysSinceNoncurrentTime,
            noncurrentTimeBefore,
            customTimeBefore,
            daysSinceCustomTime,
            matchesPrefix,
            matchesSuffix);
      }

      /** Builder for {@code LifecycleCondition}. */
      public static class Builder {
        private Integer age;
        private OffsetDateTime createdBefore;
        private Integer numberOfNewerVersions;
        private Boolean isLive;
        private List<StorageClass> matchesStorageClass;
        private Integer daysSinceNoncurrentTime;
        private OffsetDateTime noncurrentTimeBefore;
        private OffsetDateTime customTimeBefore;
        private Integer daysSinceCustomTime;
        private List<String> matchesPrefix;
        private List<String> matchesSuffix;

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
         * UTC.
         *
         * @deprecated Use {@link #setCreatedBeforeOffsetDateTime(OffsetDateTime)}
         */
        @Deprecated
        public Builder setCreatedBefore(DateTime createdBefore) {
          return setCreatedBeforeOffsetDateTime(
              Utils.dateTimeCodec.nullable().decode(createdBefore));
        }

        /**
         * Sets the date a Blob should be created before for an Action to be executed. Note that
         * only the date will be considered, if the time is specified it will be truncated. This
         * condition is satisfied when an object is created before midnight of the specified date in
         * UTC.
         */
        public Builder setCreatedBeforeOffsetDateTime(OffsetDateTime createdBefore) {
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

        /**
         * Sets the number of days elapsed since the noncurrent timestamp of an object. The
         * condition is satisfied if the days elapsed is at least this number. This condition is
         * relevant only for versioned objects. The value of the field must be a nonnegative
         * integer. If it's zero, the object version will become eligible for Lifecycle action as
         * soon as it becomes noncurrent.
         */
        public Builder setDaysSinceNoncurrentTime(Integer daysSinceNoncurrentTime) {
          this.daysSinceNoncurrentTime = daysSinceNoncurrentTime;
          return this;
        }

        /**
         * Sets the date in RFC 3339 format with only the date part (for instance, "2013-01-15").
         * Note that only date part will be considered, if the time is specified it will be
         * truncated. This condition is satisfied when the noncurrent time on an object is before
         * this date. This condition is relevant only for versioned objects.
         *
         * @deprecated Use {@link #setNoncurrentTimeBeforeOffsetDateTime(OffsetDateTime)}
         */
        @Deprecated
        public Builder setNoncurrentTimeBefore(DateTime noncurrentTimeBefore) {
          return setNoncurrentTimeBeforeOffsetDateTime(
              Utils.dateTimeCodec.nullable().decode(noncurrentTimeBefore));
        }

        /**
         * Sets the date with only the date part (for instance, "2013-01-15"). Note that only date
         * part will be considered, if the time is specified it will be truncated. This condition is
         * satisfied when the noncurrent time on an object is before this date. This condition is
         * relevant only for versioned objects.
         */
        public Builder setNoncurrentTimeBeforeOffsetDateTime(OffsetDateTime noncurrentTimeBefore) {
          this.noncurrentTimeBefore = noncurrentTimeBefore;
          return this;
        }

        /**
         * Sets the date in RFC 3339 format with only the date part (for instance, "2013-01-15").
         * Note that only date part will be considered, if the time is specified it will be
         * truncated. This condition is satisfied when the custom time on an object is before this
         * date in UTC.
         *
         * @deprecated Use {@link #setCustomTimeBeforeOffsetDateTime(OffsetDateTime)}
         */
        @Deprecated
        public Builder setCustomTimeBefore(DateTime customTimeBefore) {
          return setCustomTimeBeforeOffsetDateTime(
              Utils.dateTimeCodec.nullable().decode(customTimeBefore));
        }

        /**
         * Sets the date with only the date part (for instance, "2013-01-15"). Note that only date
         * part will be considered, if the time is specified it will be truncated. This condition is
         * satisfied when the custom time on an object is before this date in UTC.
         */
        public Builder setCustomTimeBeforeOffsetDateTime(OffsetDateTime customTimeBefore) {
          this.customTimeBefore = customTimeBefore;
          return this;
        }

        /**
         * Sets the number of days elapsed since the user-specified timestamp set on an object. The
         * condition is satisfied if the days elapsed is at least this number. If no custom
         * timestamp is specified on an object, the condition does not apply.
         */
        public Builder setDaysSinceCustomTime(Integer daysSinceCustomTime) {
          this.daysSinceCustomTime = daysSinceCustomTime;
          return this;
        }

        /**
         * Sets the list of prefixes. If any prefix matches the beginning of the object’s name, this
         * portion of the condition is satisfied for that object.
         */
        public Builder setMatchesPrefix(List<String> matchesPrefix) {
          this.matchesPrefix = matchesPrefix != null ? ImmutableList.copyOf(matchesPrefix) : null;
          return this;
        }

        /**
         * Sets the list of suffixes. If any suffix matches the end of the object’s name, this
         * portion of the condition is satisfied for that object.
         */
        public Builder setMatchesSuffix(List<String> matchesSuffix) {
          this.matchesSuffix = matchesSuffix != null ? ImmutableList.copyOf(matchesSuffix) : null;
          return this;
        }

        /** Builds a {@code LifecycleCondition} object. * */
        public LifecycleCondition build() {
          return new LifecycleCondition(this);
        }
      }
    }

    /**
     * Base class for the Action to take when a Lifecycle Condition is met. Supported Actions are
     * expressed as subclasses of this class, accessed by static factory methods.
     */
    public static class LifecycleAction implements Serializable {
      private static final long serialVersionUID = -816170697779323819L;

      private final String actionType;

      public LifecycleAction(String actionType) {
        this.actionType = actionType;
      }

      public String getActionType() {
        return actionType;
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this).add("actionType", getActionType()).toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof LifecycleAction)) {
          return false;
        }
        LifecycleAction that = (LifecycleAction) o;
        return Objects.equals(actionType, that.actionType);
      }

      @Override
      public int hashCode() {
        return Objects.hash(actionType);
      }

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
          @NonNull StorageClass storageClass) {
        return new SetStorageClassLifecycleAction(storageClass);
      }

      /**
       * Create a new {@code AbortIncompleteMPUAction}. An incomplete multipart upload will be
       * aborted when the multipart upload meets the specified condition. Age is the only condition
       * supported for this action. See: https://cloud.google.com/storage/docs/lifecycle##abort-mpu
       */
      public static LifecycleAction newAbortIncompleteMPUploadAction() {
        return new AbortIncompleteMPUAction();
      }

      /**
       * Creates a new {@code LifecycleAction}, with no specific supported action associated with
       * it. This is only intended as a "backup" for when the library doesn't recognize the type,
       * and should generally not be used, instead use the supported actions, and upgrade the
       * library if necessary to get new supported actions.
       */
      public static LifecycleAction newLifecycleAction(@NonNull String actionType) {
        return new LifecycleAction(actionType);
      }
    }

    public static class DeleteLifecycleAction extends LifecycleAction {
      public static final String TYPE = "Delete";
      private static final long serialVersionUID = 4235058923106460876L;

      private DeleteLifecycleAction() {
        super(TYPE);
      }
    }

    public static class SetStorageClassLifecycleAction extends LifecycleAction {
      public static final String TYPE = "SetStorageClass";
      private static final long serialVersionUID = 1235008830965208895L;

      private final StorageClass storageClass;

      private SetStorageClassLifecycleAction(StorageClass storageClass) {
        super(TYPE);
        this.storageClass = storageClass;
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("actionType", getActionType())
            .add("storageClass", storageClass.name())
            .toString();
      }

      public StorageClass getStorageClass() {
        return storageClass;
      }
    }

    public static class AbortIncompleteMPUAction extends LifecycleAction {
      public static final String TYPE = "AbortIncompleteMultipartUpload";
      private static final long serialVersionUID = 8158049841366366988L;

      private AbortIncompleteMPUAction() {
        super(TYPE);
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

    private static final long serialVersionUID = -2831684017163653163L;
    static final String SUPPORTED_ACTION = "Delete";
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
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof DeleteRule)) {
        return false;
      }
      DeleteRule that = (DeleteRule) o;
      return type == that.type;
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

    private static final long serialVersionUID = 8655342969048652720L;
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
  }

  static class RawDeleteRule extends DeleteRule {

    private static final long serialVersionUID = -3490275955461147025L;

    private transient Rule rule;

    RawDeleteRule(Rule rule) {
      super(Type.UNKNOWN);
      this.rule = rule;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeUTF(rule.toString());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      rule = new JacksonFactory().fromString(in.readUTF(), Rule.class);
    }

    Rule getRule() {
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

    private static final long serialVersionUID = -2941931783781989505L;
    private final OffsetDateTime time;

    /**
     * Creates an {@code CreatedBeforeDeleteRule} object.
     *
     * @param timeMillis a date in UTC. Blobs that have been created before midnight of the provided
     *     date meet the delete condition
     * @deprecated Use {@link #CreatedBeforeDeleteRule(OffsetDateTime)} instead
     */
    @Deprecated
    public CreatedBeforeDeleteRule(long timeMillis) {
      this(millisUtcCodec.encode(timeMillis));
    }

    /**
     * Creates an {@code CreatedBeforeDeleteRule} object.
     *
     * @param time Blobs that have been created before midnight of the provided date meet the delete
     *     condition
     */
    public CreatedBeforeDeleteRule(OffsetDateTime time) {
      super(Type.CREATE_BEFORE);
      this.time = time;
    }

    /**
     * @deprecated {@link #getTime()}
     */
    @Deprecated
    public long getTimeMillis() {
      return millisUtcCodec.decode(time);
    }

    public OffsetDateTime getTime() {
      return time;
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

    private static final long serialVersionUID = 8984956956307794724L;
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

    private static final long serialVersionUID = 6769701586197631153L;
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
  }

  /**
   * A buckets <a href="https://cloud.google.com/storage/docs/ip-filtering-overview">IP
   * filtering</a> configuration. Specifies the network sources that can access the bucket, as well
   * as its underlying objects.
   *
   * @since 2.54.0
   */
  @Immutable
  public static final class IpFilter implements Serializable {
    private static final long serialVersionUID = 3883696370256011372L;
    private final @Nullable String mode;
    private final @Nullable PublicNetworkSource publicNetworkSource;
    private final @Nullable List<VpcNetworkSource> vpcNetworkSources;
    private final @Nullable Boolean allowCrossOrgVpcs;
    private final @Nullable Boolean allowAllServiceAgentAccess;

    private IpFilter(
        @Nullable String mode,
        @Nullable PublicNetworkSource publicNetworkSource,
        @Nullable List<VpcNetworkSource> vpcNetworkSources,
        @Nullable Boolean allowCrossOrgVpcs,
        @Nullable Boolean allowAllServiceAgentAccess) {
      this.mode = mode;
      this.publicNetworkSource = publicNetworkSource;
      this.vpcNetworkSources = vpcNetworkSources;
      this.allowCrossOrgVpcs = allowCrossOrgVpcs;
      this.allowAllServiceAgentAccess = allowAllServiceAgentAccess;
    }

    /**
     * The state of the IP filter configuration. Valid values are `Enabled` and `Disabled`. When set
     * to `Enabled`, IP filtering rules are applied to a bucket and all incoming requests to the
     * bucket are evaluated against these rules. When set to `Disabled`, IP filtering rules are not
     * applied to a bucket.
     *
     * @since 2.54.0
     * @see Builder#setMode
     */
    public @Nullable String getMode() {
      return mode;
    }

    /**
     * Optional. Public IPs allowed to operate or access the bucket.
     *
     * @since 2.54.0
     * @see Builder#setPublicNetworkSource(PublicNetworkSource)
     */
    public @Nullable PublicNetworkSource getPublicNetworkSource() {
      return publicNetworkSource;
    }

    /**
     * Optional. The list of network sources that are allowed to access operations on the bucket or
     * the underlying objects.
     *
     * @since 2.54.0
     * @see Builder#setVpcNetworkSources(List)
     */
    public @Nullable List<VpcNetworkSource> getVpcNetworkSources() {
      return vpcNetworkSources;
    }

    /**
     * Optional. Whether or not to allow VPCs from orgs different than the bucket's parent org to
     * access the bucket. When set to true, validations on the existence of the VPCs won't be
     * performed. If set to false, each VPC network source will be checked to belong to the same org
     * as the bucket as well as validated for existence.
     *
     * @since 2.54.0
     * @see Builder#setAllowCrossOrgVpcs(Boolean)
     */
    public @Nullable Boolean getAllowCrossOrgVpcs() {
      return allowCrossOrgVpcs;
    }

    /**
     * Whether or not to allow all P4SA access to the bucket. When set to true, IP filter config
     * validation will not apply.
     *
     * @since 2.54.0
     * @see Builder#setAllowAllServiceAgentAccess(Boolean)
     */
    public @Nullable Boolean getAllowAllServiceAgentAccess() {
      return allowAllServiceAgentAccess;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof IpFilter)) {
        return false;
      }
      IpFilter ipFilter = (IpFilter) o;
      return Objects.equals(mode, ipFilter.mode)
          && Objects.equals(publicNetworkSource, ipFilter.publicNetworkSource)
          && Objects.equals(vpcNetworkSources, ipFilter.vpcNetworkSources)
          && Objects.equals(allowCrossOrgVpcs, ipFilter.allowCrossOrgVpcs)
          && Objects.equals(allowAllServiceAgentAccess, ipFilter.allowAllServiceAgentAccess);
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          mode,
          publicNetworkSource,
          vpcNetworkSources,
          allowCrossOrgVpcs,
          allowAllServiceAgentAccess);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("mode", mode)
          .add("publicNetworkSource", publicNetworkSource)
          .add("vpcNetworkSources", vpcNetworkSources)
          .add("allowCrossOrgVpcs", allowCrossOrgVpcs)
          .add("allowAllServiceAgentAccess", allowAllServiceAgentAccess)
          .toString();
    }

    /**
     * @since 2.54.0
     */
    public Builder toBuilder() {
      return new Builder(this);
    }

    /**
     * @since 2.54.0
     */
    public static Builder newBuilder() {
      return new Builder();
    }

    /**
     * @since 2.54.0
     */
    public static final class Builder {
      private @Nullable String mode;
      private @Nullable PublicNetworkSource publicNetworkSource;
      private @Nullable List<VpcNetworkSource> vpcNetworkSources;
      private @Nullable Boolean allowCrossOrgVpcs;
      private @Nullable Boolean allowAllServiceAgentAccess;

      private Builder() {}

      private Builder(IpFilter ipFilter) {
        this.mode = ipFilter.mode;
        this.publicNetworkSource = ipFilter.publicNetworkSource;
        this.vpcNetworkSources = ipFilter.vpcNetworkSources;
        this.allowCrossOrgVpcs = ipFilter.allowCrossOrgVpcs;
        this.allowAllServiceAgentAccess = ipFilter.allowAllServiceAgentAccess;
      }

      /**
       * The state of the IP filter configuration. Valid values are `Enabled` and `Disabled`. When
       * set to `Enabled`, IP filtering rules are applied to a bucket and all incoming requests to
       * the bucket are evaluated against these rules. When set to `Disabled`, IP filtering rules
       * are not applied to a bucket.
       *
       * @since 2.54.0
       * @see IpFilter#getMode
       */
      public Builder setMode(@Nullable String mode) {
        this.mode = mode;
        return this;
      }

      /**
       * Optional. Public IPs allowed to operate or access the bucket.
       *
       * @since 2.54.0
       * @see IpFilter#getPublicNetworkSource()
       */
      public Builder setPublicNetworkSource(@Nullable PublicNetworkSource publicNetworkSource) {
        this.publicNetworkSource = publicNetworkSource;
        return this;
      }

      /**
       * Optional. The list of network sources that are allowed to access operations on the bucket
       * or the underlying objects.
       *
       * @since 2.54.0
       * @see IpFilter#getVpcNetworkSources()
       */
      public Builder setVpcNetworkSources(@Nullable List<VpcNetworkSource> vpcNetworkSources) {
        this.vpcNetworkSources = vpcNetworkSources;
        return this;
      }

      /**
       * Optional. Whether or not to allow VPCs from orgs different than the bucket's parent org to
       * access the bucket. When set to true, validations on the existence of the VPCs won't be
       * performed. If set to false, each VPC network source will be checked to belong to the same
       * org as the bucket as well as validated for existence.
       *
       * @since 2.54.0
       * @see IpFilter#getAllowCrossOrgVpcs()
       */
      public Builder setAllowCrossOrgVpcs(@Nullable Boolean allowCrossOrgVpcs) {
        this.allowCrossOrgVpcs = allowCrossOrgVpcs;
        return this;
      }

      /**
       * Whether or not to allow all P4SA access to the bucket. When set to true, IP filter config
       * validation will not apply.
       *
       * @since 2.54.0
       * @see IpFilter#getAllowAllServiceAgentAccess()
       */
      public Builder setAllowAllServiceAgentAccess(@Nullable Boolean allowAllServiceAgentAccess) {
        this.allowAllServiceAgentAccess = allowAllServiceAgentAccess;
        return this;
      }

      /**
       * @since 2.54.0
       */
      public IpFilter build() {
        return new IpFilter(
            mode,
            publicNetworkSource,
            vpcNetworkSources,
            allowCrossOrgVpcs,
            allowAllServiceAgentAccess);
      }
    }

    /**
     * The public network IP address ranges that can access the bucket and its data.
     *
     * @since 2.54.0
     */
    @Immutable
    public static final class PublicNetworkSource implements Serializable {
      private static final long serialVersionUID = -5597599591237060501L;

      private final List<String> allowedIpCidrRanges;

      private PublicNetworkSource(List<String> allowedIpCidrRanges) {
        this.allowedIpCidrRanges = allowedIpCidrRanges;
      }

      /**
       * Optional. The list of IPv4 and IPv6 cidr blocks that are allowed to operate or access the
       * bucket and its underlying objects.
       *
       * @since 2.54.0
       */
      public List<String> getAllowedIpCidrRanges() {
        return allowedIpCidrRanges;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof PublicNetworkSource)) {
          return false;
        }
        PublicNetworkSource that = (PublicNetworkSource) o;
        return Objects.equals(allowedIpCidrRanges, that.allowedIpCidrRanges);
      }

      @Override
      public int hashCode() {
        return Objects.hashCode(allowedIpCidrRanges);
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("allowedIpCidrRanges", allowedIpCidrRanges)
            .toString();
      }

      /**
       * @since 2.54.0
       */
      public static PublicNetworkSource of(List<String> allowedIpCidrRanges) {
        return new PublicNetworkSource(allowedIpCidrRanges);
      }
    }

    /**
     * The list of VPC networks that can access the bucket.
     *
     * @since 2.54.0
     */
    @Immutable
    public static final class VpcNetworkSource implements Serializable {
      private static final long serialVersionUID = 9075759536253054803L;
      private final @Nullable String network;
      private final @Nullable List<String> allowedIpCidrRanges;

      private VpcNetworkSource(
          @Nullable String network, @Nullable List<String> allowedIpCidrRanges) {
        this.network = network;
        this.allowedIpCidrRanges = allowedIpCidrRanges;
      }

      /**
       * Name of the network.
       *
       * <p>Format: `projects/PROJECT_ID/global/networks/NETWORK_NAME`
       *
       * @since 2.54.0
       * @see Builder#setNetwork(String)
       */
      public @Nullable String getNetwork() {
        return network;
      }

      /**
       * Optional. The list of public or private IPv4 and IPv6 CIDR ranges that can access the
       * bucket. In the CIDR IP address block, the specified IP address must be properly truncated,
       * meaning all the host bits must be zero or else the input is considered malformed. For
       * example, `192.0.2.0/24` is accepted but `192.0.2.1/24` is not. Similarly, for IPv6,
       * `2001:db8::/32` is accepted whereas `2001:db8::1/32` is not.
       *
       * @since 2.54.0
       * @see Builder#setAllowedIpCidrRanges(List)
       */
      public @Nullable List<String> getAllowedIpCidrRanges() {
        return allowedIpCidrRanges;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof VpcNetworkSource)) {
          return false;
        }
        VpcNetworkSource that = (VpcNetworkSource) o;
        return Objects.equals(network, that.network)
            && Objects.equals(allowedIpCidrRanges, that.allowedIpCidrRanges);
      }

      @Override
      public int hashCode() {
        return Objects.hash(network, allowedIpCidrRanges);
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("network", network)
            .add("allowedIpCidrRanges", allowedIpCidrRanges)
            .toString();
      }

      /**
       * @since 2.54.0
       */
      public Builder toBuilder() {
        return new Builder(this);
      }

      /**
       * @since 2.54.0
       */
      public static Builder newBuilder() {
        return new Builder();
      }

      /**
       * @since 2.54.0
       */
      public static final class Builder {
        private @Nullable String network;
        private @Nullable List<String> allowedIpCidrRanges;

        private Builder() {}

        public Builder(VpcNetworkSource vpcNetworksource) {
          this.network = vpcNetworksource.network;
          this.allowedIpCidrRanges = vpcNetworksource.allowedIpCidrRanges;
        }

        /**
         * Name of the network.
         *
         * <p>Format: `projects/PROJECT_ID/global/networks/NETWORK_NAME`
         *
         * @since 2.54.0
         * @see VpcNetworkSource#getNetwork()
         */
        public Builder setNetwork(@Nullable String network) {
          this.network = network;
          return this;
        }

        /**
         * Optional. The list of public or private IPv4 and IPv6 CIDR ranges that can access the
         * bucket. In the CIDR IP address block, the specified IP address must be properly
         * truncated, meaning all the host bits must be zero or else the input is considered
         * malformed. For example, `192.0.2.0/24` is accepted but `192.0.2.1/24` is not. Similarly,
         * for IPv6, `2001:db8::/32` is accepted whereas `2001:db8::1/32` is not.
         *
         * @since 2.54.0
         * @see VpcNetworkSource#getAllowedIpCidrRanges()
         */
        public Builder setAllowedIpCidrRanges(@Nullable List<String> allowedIpCidrRanges) {
          this.allowedIpCidrRanges = allowedIpCidrRanges;
          return this;
        }

        /**
         * @since 2.54.0
         */
        public VpcNetworkSource build() {
          return new VpcNetworkSource(network, allowedIpCidrRanges);
        }
      }
    }
  }

  /**
   * Google Managed Encryption (GMEK) enforcement config of a bucket.
   *
   * @since 2.55.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static final class GoogleManagedEncryptionEnforcementConfig {
    @Nullable private final EncryptionEnforcementRestrictionMode restrictionMode;
    @Nullable private final OffsetDateTime effectiveTime;

    private GoogleManagedEncryptionEnforcementConfig(
        @Nullable EncryptionEnforcementRestrictionMode restrictionMode,
        @Nullable OffsetDateTime effectiveTime) {
      this.restrictionMode = restrictionMode;
      this.effectiveTime = effectiveTime;
    }

    /**
     * Restriction mode for new objects within the bucket. If {@link
     * EncryptionEnforcementRestrictionMode#NOT_RESTRICTED NotRestricted} or {@code null}, creation
     * of new objects with google-managed encryption is allowed. If `FullyRestricted`, new objects
     * can not be created using google-managed encryption.
     *
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public @Nullable EncryptionEnforcementRestrictionMode getRestrictionMode() {
      return restrictionMode;
    }

    /**
     * Output only. Time from which the config was effective.
     *
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public @Nullable OffsetDateTime getEffectiveTime() {
      return effectiveTime;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof GoogleManagedEncryptionEnforcementConfig)) {
        return false;
      }
      GoogleManagedEncryptionEnforcementConfig that = (GoogleManagedEncryptionEnforcementConfig) o;
      return Objects.equals(restrictionMode, that.restrictionMode)
          && Objects.equals(effectiveTime, that.effectiveTime);
    }

    @Override
    public int hashCode() {
      return Objects.hash(restrictionMode, effectiveTime);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("restrictionMode", restrictionMode)
          .add("effectiveTime", effectiveTime)
          .toString();
    }

    /**
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static GoogleManagedEncryptionEnforcementConfig of(
        @Nullable EncryptionEnforcementRestrictionMode restrictionMode) {
      return new GoogleManagedEncryptionEnforcementConfig(restrictionMode, null);
    }

    /**
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static GoogleManagedEncryptionEnforcementConfig of(
        @Nullable EncryptionEnforcementRestrictionMode restrictionMode,
        @Nullable OffsetDateTime effectiveTime) {
      return new GoogleManagedEncryptionEnforcementConfig(restrictionMode, effectiveTime);
    }
  }

  /**
   * Customer Managed Encryption (CMEK) enforcement config of a bucket.
   *
   * @since 2.55.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static final class CustomerManagedEncryptionEnforcementConfig {
    @Nullable private final EncryptionEnforcementRestrictionMode restrictionMode;
    @Nullable private final OffsetDateTime effectiveTime;

    private CustomerManagedEncryptionEnforcementConfig(
        @Nullable EncryptionEnforcementRestrictionMode restrictionMode,
        @Nullable OffsetDateTime effectiveTime) {
      this.restrictionMode = restrictionMode;
      this.effectiveTime = effectiveTime;
    }

    /**
     * Restriction mode for new objects within the bucket. If {@link
     * EncryptionEnforcementRestrictionMode#NOT_RESTRICTED NotRestricted} or {@code null}, creation
     * of new objects with customer-managed encryption is allowed. If `FullyRestricted`, new objects
     * can not be created using customer-managed encryption.
     *
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public @Nullable EncryptionEnforcementRestrictionMode getRestrictionMode() {
      return restrictionMode;
    }

    /**
     * Output only. Time from which the config was effective.
     *
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public @Nullable OffsetDateTime getEffectiveTime() {
      return effectiveTime;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof CustomerManagedEncryptionEnforcementConfig)) {
        return false;
      }
      CustomerManagedEncryptionEnforcementConfig that =
          (CustomerManagedEncryptionEnforcementConfig) o;
      return Objects.equals(restrictionMode, that.restrictionMode)
          && Objects.equals(effectiveTime, that.effectiveTime);
    }

    @Override
    public int hashCode() {
      return Objects.hash(restrictionMode, effectiveTime);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("restrictionMode", restrictionMode)
          .add("effectiveTime", effectiveTime)
          .toString();
    }

    /**
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static CustomerManagedEncryptionEnforcementConfig of(
        @Nullable EncryptionEnforcementRestrictionMode restrictionMode) {
      return new CustomerManagedEncryptionEnforcementConfig(restrictionMode, null);
    }

    /**
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static CustomerManagedEncryptionEnforcementConfig of(
        @Nullable EncryptionEnforcementRestrictionMode restrictionMode,
        @Nullable OffsetDateTime effectiveTime) {
      return new CustomerManagedEncryptionEnforcementConfig(restrictionMode, effectiveTime);
    }
  }

  /**
   * Customer Supplied Encryption (CSEK) enforcement config of a bucket.
   *
   * @since 2.55.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static final class CustomerSuppliedEncryptionEnforcementConfig {
    @Nullable private final EncryptionEnforcementRestrictionMode restrictionMode;
    @Nullable private final OffsetDateTime effectiveTime;

    private CustomerSuppliedEncryptionEnforcementConfig(
        @Nullable EncryptionEnforcementRestrictionMode restrictionMode,
        @Nullable OffsetDateTime effectiveTime) {
      this.restrictionMode = restrictionMode;
      this.effectiveTime = effectiveTime;
    }

    /**
     * Restriction mode for new objects within the bucket. If {@link
     * EncryptionEnforcementRestrictionMode#NOT_RESTRICTED NotRestricted} or {@code null}, creation
     * of new objects with customer-supplied encryption is allowed. If `FullyRestricted`, new
     * objects can not be created using customer-supplied encryption.
     *
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public @Nullable EncryptionEnforcementRestrictionMode getRestrictionMode() {
      return restrictionMode;
    }

    /**
     * Output only. Time from which the config was effective.
     *
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public @Nullable OffsetDateTime getEffectiveTime() {
      return effectiveTime;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof CustomerSuppliedEncryptionEnforcementConfig)) {
        return false;
      }
      CustomerSuppliedEncryptionEnforcementConfig that =
          (CustomerSuppliedEncryptionEnforcementConfig) o;
      return Objects.equals(restrictionMode, that.restrictionMode)
          && Objects.equals(effectiveTime, that.effectiveTime);
    }

    @Override
    public int hashCode() {
      return Objects.hash(restrictionMode, effectiveTime);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("restrictionMode", restrictionMode)
          .add("effectiveTime", effectiveTime)
          .toString();
    }

    /**
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static CustomerSuppliedEncryptionEnforcementConfig of(
        @Nullable EncryptionEnforcementRestrictionMode restrictionMode) {
      return new CustomerSuppliedEncryptionEnforcementConfig(restrictionMode, null);
    }

    /**
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static CustomerSuppliedEncryptionEnforcementConfig of(
        @Nullable EncryptionEnforcementRestrictionMode restrictionMode,
        @Nullable OffsetDateTime effectiveTime) {
      return new CustomerSuppliedEncryptionEnforcementConfig(restrictionMode, effectiveTime);
    }
  }

  /**
   * @since 2.55.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public static final class EncryptionEnforcementRestrictionMode extends StringEnumValue {

    /**
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static final EncryptionEnforcementRestrictionMode NOT_RESTRICTED =
        new EncryptionEnforcementRestrictionMode("NotRestricted");

    /**
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static final EncryptionEnforcementRestrictionMode FULLY_RESTRICTED =
        new EncryptionEnforcementRestrictionMode("FullyRestricted");

    private static final StringEnumType<EncryptionEnforcementRestrictionMode> type =
        new StringEnumType<>(
            EncryptionEnforcementRestrictionMode.class, EncryptionEnforcementRestrictionMode::new);

    private EncryptionEnforcementRestrictionMode(String constant) {
      super(constant);
    }

    /**
     * Get the {@link EncryptionEnforcementRestrictionMode} for the given String constant, and throw
     * an exception if the constant is not recognized.
     *
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static EncryptionEnforcementRestrictionMode valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /**
     * Get the {@link EncryptionEnforcementRestrictionMode} for the given String constant, and allow
     * unrecognized values.
     *
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static EncryptionEnforcementRestrictionMode valueOf(String constant) {
      return type.valueOf(constant);
    }

    /**
     * Return the known values
     *
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static EncryptionEnforcementRestrictionMode[] values() {
      return type.values();
    }
  }

  /** Builder for {@code BucketInfo}. */
  public abstract static class Builder {
    Builder() {}

    abstract Builder setProject(BigInteger project);

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
     * @deprecated Use {@link #setLifecycleRules(Iterable)} instead, as in {@code
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

    /** Deletes the lifecycle rules of this bucket. */
    public abstract Builder deleteLifecycleRules();

    /**
     * Sets the bucket's Recovery Point Objective (RPO). This can only be set for a dual-region
     * bucket, and determines the speed at which data will be replicated between regions. See the
     * {@code Rpo} class for supported values, and <a
     * href="https://cloud.google.com/storage/docs/turbo-replication">here</a> for additional
     * details.
     */
    public abstract Builder setRpo(Rpo rpo);

    /**
     * Sets the bucket's storage class. This defines how blobs in the bucket are stored and
     * determines the SLA and the cost of storage. A list of supported values is available <a
     * href="https://cloud.google.com/storage/docs/storage-classes">here</a>.
     */
    public abstract Builder setStorageClass(StorageClass storageClass);

    /**
     * Sets the bucket's location. Data for blobs in the bucket resides in physical storage within
     * this region or regions. A list of supported values is available <a
     * href="https://cloud.google.com/storage/docs/bucket-locations">here</a>.
     */
    public abstract Builder setLocation(String location);

    abstract Builder setEtag(String etag);

    /**
     * @deprecated {@link #setCreateTimeOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    abstract Builder setCreateTime(Long createTime);

    Builder setCreateTimeOffsetDateTime(OffsetDateTime createTime) {
      // provide an implementation for source and binary compatibility which we override ourselves
      setCreateTime(millisOffsetDateTimeCodec.decode(createTime));
      return this;
    }

    /**
     * @deprecated {@link #setUpdateTimeOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    abstract Builder setUpdateTime(Long updateTime);

    Builder setUpdateTimeOffsetDateTime(OffsetDateTime updateTime) {
      // provide an implementation for source and binary compatibility which we override ourselves
      setCreateTime(millisOffsetDateTimeCodec.decode(updateTime));
      return this;
    }

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
    public abstract Builder setLabels(@Nullable Map<@NonNull String, @Nullable String> labels);

    /** Sets the default Cloud KMS key name for this bucket. */
    public abstract Builder setDefaultKmsKeyName(String defaultKmsKeyName);

    /**
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public abstract Builder setGoogleManagedEncryptionEnforcementConfig(
        GoogleManagedEncryptionEnforcementConfig config);

    /**
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public abstract Builder setCustomerManagedEncryptionEnforcementConfig(
        CustomerManagedEncryptionEnforcementConfig config);

    /**
     * @since 2.55.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public abstract Builder setCustomerSuppliedEncryptionEnforcementConfig(
        CustomerSuppliedEncryptionEnforcementConfig config);

    /** Sets the default event-based hold for this bucket. */
    @BetaApi
    public abstract Builder setDefaultEventBasedHold(Boolean defaultEventBasedHold);

    /**
     * @deprecated {@link #setRetentionEffectiveTimeOffsetDateTime(OffsetDateTime)}
     */
    @BetaApi
    @Deprecated
    abstract Builder setRetentionEffectiveTime(Long retentionEffectiveTime);

    @BetaApi
    Builder setRetentionEffectiveTimeOffsetDateTime(OffsetDateTime retentionEffectiveTime) {
      return setRetentionEffectiveTime(millisOffsetDateTimeCodec.decode(retentionEffectiveTime));
    }

    @BetaApi
    abstract Builder setRetentionPolicyIsLocked(Boolean retentionPolicyIsLocked);

    /**
     * If policy is not locked this value can be cleared, increased, and decreased. If policy is
     * locked the retention period can only be increased.
     *
     * @deprecated Use {@link #setRetentionPeriodDuration(Duration)}
     */
    @BetaApi
    @Deprecated
    public abstract Builder setRetentionPeriod(Long retentionPeriod);

    /**
     * If policy is not locked this value can be cleared, increased, and decreased. If policy is
     * locked the retention period can only be increased.
     */
    @BetaApi
    public Builder setRetentionPeriodDuration(Duration retentionPeriod) {
      return setRetentionPeriod(nullableDurationSecondsCodec.encode(retentionPeriod));
    }

    /**
     * Sets the IamConfiguration to specify whether IAM access should be enabled.
     *
     * @see <a href="https://cloud.google.com/storage/docs/bucket-policy-only">Bucket Policy
     *     Only</a>
     */
    @BetaApi
    public abstract Builder setIamConfiguration(IamConfiguration iamConfiguration);

    public abstract Builder setAutoclass(Autoclass autoclass);

    public abstract Builder setLogging(Logging logging);

    public abstract Builder setCustomPlacementConfig(CustomPlacementConfig customPlacementConfig);

    public abstract Builder setHierarchicalNamespace(HierarchicalNamespace hierarchicalNamespace);

    abstract Builder setObjectRetention(ObjectRetention objectRetention);

    public abstract Builder setSoftDeletePolicy(SoftDeletePolicy softDeletePolicy);

    /**
     * @since 2.54.0
     */
    public abstract Builder setIpFilter(IpFilter ipFilter);

    public abstract Builder setIsUnreachable(Boolean isUnreachable);

    /** Creates a {@code BucketInfo} object. */
    public abstract BucketInfo build();

    abstract Builder clearGeneratedId();

    abstract Builder clearProject();

    abstract Builder clearName();

    abstract Builder clearOwner();

    abstract Builder clearSelfLink();

    abstract Builder clearRequesterPays();

    abstract Builder clearVersioningEnabled();

    abstract Builder clearIndexPage();

    abstract Builder clearNotFoundPage();

    abstract Builder clearLifecycleRules();

    abstract Builder clearRpo();

    abstract Builder clearStorageClass();

    abstract Builder clearLocation();

    abstract Builder clearEtag();

    abstract Builder clearCreateTime();

    abstract Builder clearUpdateTime();

    abstract Builder clearMetageneration();

    abstract Builder clearCors();

    abstract Builder clearAcl();

    abstract Builder clearDefaultAcl();

    abstract Builder clearLabels();

    abstract Builder clearDefaultKmsKeyName();

    abstract Builder clearDefaultEventBasedHold();

    abstract Builder clearRetentionEffectiveTime();

    abstract Builder clearRetentionPolicyIsLocked();

    abstract Builder clearRetentionPeriod();

    abstract Builder clearIamConfiguration();

    abstract Builder clearLocationType();

    abstract Builder clearLogging();

    abstract Builder clearCustomPlacementConfig();

    abstract Builder clearIpFilter();

    abstract Builder clearGoogleManagedEncryptionEnforcementConfig();

    abstract Builder clearCustomerManagedEncryptionEnforcementConfig();

    abstract Builder clearCustomerSuppliedEncryptionEnforcementConfig();

    abstract Builder clearIsUnreachable();
  }

  static final class BuilderImpl extends Builder {

    private String generatedId;
    private BigInteger project;
    private String name;
    private Acl.Entity owner;
    private String selfLink;
    private Boolean requesterPays;
    private Boolean versioningEnabled;
    private String indexPage;
    private String notFoundPage;
    @Nullable private List<LifecycleRule> lifecycleRules;
    private Rpo rpo;
    private StorageClass storageClass;
    private String location;
    private String etag;
    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;
    private Long metageneration;
    private List<Cors> cors;
    private List<Acl> acl;
    private List<Acl> defaultAcl;
    private Map<String, String> labels;
    private String defaultKmsKeyName;
    private Boolean defaultEventBasedHold;
    private OffsetDateTime retentionEffectiveTime;
    private Boolean retentionPolicyIsLocked;
    private Duration retentionPeriod;
    private IamConfiguration iamConfiguration;
    private Autoclass autoclass;
    private String locationType;
    private Logging logging;
    private CustomPlacementConfig customPlacementConfig;
    private ObjectRetention objectRetention;

    private SoftDeletePolicy softDeletePolicy;
    private HierarchicalNamespace hierarchicalNamespace;
    private IpFilter ipFilter;
    private GoogleManagedEncryptionEnforcementConfig googleManagedEncryptionEnforcementConfig;
    private CustomerManagedEncryptionEnforcementConfig customerManagedEncryptionEnforcementConfig;
    private CustomerSuppliedEncryptionEnforcementConfig customerSuppliedEncryptionEnforcementConfig;
    private Boolean isUnreachable;
    private final ImmutableSet.Builder<NamedField> modifiedFields = ImmutableSet.builder();

    BuilderImpl(String name) {
      this.name = name;
    }

    BuilderImpl(BucketInfo bucketInfo) {
      generatedId = bucketInfo.generatedId;
      project = bucketInfo.project;
      name = bucketInfo.name;
      etag = bucketInfo.etag;
      createTime = bucketInfo.createTime;
      updateTime = bucketInfo.updateTime;
      metageneration = bucketInfo.metageneration;
      location = bucketInfo.location;
      rpo = bucketInfo.rpo;
      storageClass = bucketInfo.storageClass;
      cors = bucketInfo.cors;
      acl = bucketInfo.acl;
      defaultAcl = bucketInfo.defaultAcl;
      owner = bucketInfo.owner;
      selfLink = bucketInfo.selfLink;
      versioningEnabled = bucketInfo.versioningEnabled;
      indexPage = bucketInfo.indexPage;
      notFoundPage = bucketInfo.notFoundPage;
      lifecycleRules = bucketInfo.lifecycleRules;
      labels = bucketInfo.labels;
      requesterPays = bucketInfo.requesterPays;
      defaultKmsKeyName = bucketInfo.defaultKmsKeyName;
      defaultEventBasedHold = bucketInfo.defaultEventBasedHold;
      retentionEffectiveTime = bucketInfo.retentionEffectiveTime;
      retentionPolicyIsLocked = bucketInfo.retentionPolicyIsLocked;
      retentionPeriod = bucketInfo.retentionPeriod;
      iamConfiguration = bucketInfo.iamConfiguration;
      autoclass = bucketInfo.autoclass;
      locationType = bucketInfo.locationType;
      logging = bucketInfo.logging;
      customPlacementConfig = bucketInfo.customPlacementConfig;
      objectRetention = bucketInfo.objectRetention;
      softDeletePolicy = bucketInfo.softDeletePolicy;
      hierarchicalNamespace = bucketInfo.hierarchicalNamespace;
      ipFilter = bucketInfo.ipFilter;
      googleManagedEncryptionEnforcementConfig =
          bucketInfo.googleManagedEncryptionEnforcementConfig;
      customerManagedEncryptionEnforcementConfig =
          bucketInfo.customerManagedEncryptionEnforcementConfig;
      customerSuppliedEncryptionEnforcementConfig =
          bucketInfo.customerSuppliedEncryptionEnforcementConfig;
      isUnreachable = bucketInfo.isUnreachable;
    }

    @Override
    public Builder setName(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    @Override
    Builder setProject(BigInteger project) {
      if (!Objects.equals(this.project, project)) {
        modifiedFields.add(BucketField.PROJECT);
      }
      this.project = project;
      return this;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    Builder setOwner(Acl.Entity owner) {
      if (!Objects.equals(this.owner, owner)) {
        modifiedFields.add(BucketField.OWNER);
      }
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
      Boolean tmp = firstNonNull(enable, Data.<Boolean>nullOf(Boolean.class));
      if (!Objects.equals(this.versioningEnabled, tmp)) {
        modifiedFields.add(BucketField.VERSIONING);
      }
      this.versioningEnabled = tmp;
      return this;
    }

    @Override
    public Builder setRequesterPays(Boolean enable) {
      Boolean tmp = firstNonNull(enable, Data.<Boolean>nullOf(Boolean.class));
      if (!Objects.equals(this.requesterPays, tmp)) {
        modifiedFields.add(BucketField.BILLING);
      }
      this.requesterPays = tmp;
      return this;
    }

    @Override
    public Builder setIndexPage(String indexPage) {
      if (!Objects.equals(this.indexPage, indexPage)) {
        modifiedFields.add(BucketField.WEBSITE);
      }
      this.indexPage = indexPage;
      return this;
    }

    @Override
    public Builder setNotFoundPage(String notFoundPage) {
      if (!Objects.equals(this.notFoundPage, notFoundPage)) {
        modifiedFields.add(BucketField.WEBSITE);
      }
      this.notFoundPage = notFoundPage;
      return this;
    }

    /**
     * @deprecated Use {@code setLifecycleRules} method instead. *
     */
    @Override
    @Deprecated
    public Builder setDeleteRules(Iterable<? extends DeleteRule> rules) {
      // if the provided rules are null or empty clear all current delete rules
      if (rules == null) {
        return clearDeleteLifecycleRules();
      } else {
        ArrayList<? extends DeleteRule> deleteRules = newArrayList(rules);
        if (deleteRules.isEmpty()) {
          if (lifecycleRules != null) {
            return clearDeleteLifecycleRules();
          } else {
            lifecycleRules = ImmutableList.of();
            return this;
          }
        } else {
          // if the provided rules are non-empty, replace all existing delete rules

          Stream<LifecycleRule> newDeleteRules =
              deleteRules.stream().map(BackwardCompatibilityUtils.deleteRuleCodec::encode);

          // if our current lifecycleRules are null, set to the newDeleteRules
          if (lifecycleRules == null) {
            return setLifecycleRules(newDeleteRules.collect(ImmutableList.toImmutableList()));
          } else {
            // if lifecycleRules is non-null, filter out existing delete rules, then add our new
            // ones
            ImmutableList<LifecycleRule> newLifecycleRules =
                Streams.concat(
                        lifecycleRules.stream().filter(IS_DELETE_LIFECYCLE_RULE.negate()),
                        newDeleteRules)
                    .collect(ImmutableList.toImmutableList());
            return setLifecycleRules(newLifecycleRules);
          }
        }
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder setLifecycleRules(Iterable<? extends LifecycleRule> rules) {
      final ImmutableList<LifecycleRule> tmp;
      if (rules != null) {
        if (rules instanceof ImmutableList) {
          tmp = (ImmutableList<LifecycleRule>) rules;
        } else {
          tmp = ImmutableList.copyOf(rules);
        }
      } else {
        tmp = ImmutableList.of();
      }
      if (!Objects.equals(this.lifecycleRules, tmp)) {
        modifiedFields.add(BucketField.LIFECYCLE);
      }
      this.lifecycleRules = tmp;
      return this;
    }

    @Override
    public Builder deleteLifecycleRules() {
      return setLifecycleRules(null);
    }

    @Override
    public Builder setRpo(Rpo rpo) {
      if (!Objects.equals(this.rpo, rpo)) {
        modifiedFields.add(BucketField.RPO);
      }
      this.rpo = rpo;
      return this;
    }

    @Override
    public Builder setStorageClass(StorageClass storageClass) {
      if (!Objects.equals(this.storageClass, storageClass)) {
        modifiedFields.add(BucketField.STORAGE_CLASS);
      }
      this.storageClass = storageClass;
      return this;
    }

    @Override
    public Builder setLocation(String location) {
      if (!Objects.equals(this.location, location)) {
        modifiedFields.add(BucketField.LOCATION);
      }
      this.location = location;
      return this;
    }

    @Override
    Builder setEtag(String etag) {
      if (!Objects.equals(this.etag, etag)) {
        modifiedFields.add(BucketField.ETAG);
      }
      this.etag = etag;
      return this;
    }

    /**
     * @deprecated {@link #setCreateTimeOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    @Override
    Builder setCreateTime(Long createTime) {
      return setCreateTimeOffsetDateTime(millisOffsetDateTimeCodec.encode(createTime));
    }

    @Override
    Builder setCreateTimeOffsetDateTime(OffsetDateTime createTime) {
      if (!Objects.equals(this.createTime, createTime)) {
        modifiedFields.add(BucketField.TIME_CREATED);
      }
      this.createTime = createTime;
      return this;
    }

    /**
     * @deprecated {@link #setUpdateTimeOffsetDateTime(OffsetDateTime)}
     */
    @Deprecated
    @Override
    Builder setUpdateTime(Long updateTime) {
      return setUpdateTimeOffsetDateTime(millisOffsetDateTimeCodec.encode(updateTime));
    }

    @Override
    Builder setUpdateTimeOffsetDateTime(OffsetDateTime updateTime) {
      if (!Objects.equals(this.updateTime, updateTime)) {
        modifiedFields.add(BucketField.UPDATED);
      }
      this.updateTime = updateTime;
      return this;
    }

    @Override
    Builder setMetageneration(Long metageneration) {
      this.metageneration = metageneration;
      return this;
    }

    @Override
    public Builder setCors(Iterable<Cors> cors) {
      ImmutableList<Cors> tmp = cors != null ? ImmutableList.copyOf(cors) : ImmutableList.of();
      if (!Objects.equals(this.cors, tmp)) {
        modifiedFields.add(BucketField.CORS);
      }
      this.cors = tmp;
      return this;
    }

    @Override
    public Builder setAcl(Iterable<Acl> acl) {
      List<Acl> tmp = acl != null ? ImmutableList.copyOf(acl) : null;
      if (!Objects.equals(this.acl, tmp)) {
        modifiedFields.add(BucketField.ACL);
      }
      this.acl = tmp;
      return this;
    }

    @Override
    public Builder setDefaultAcl(Iterable<Acl> acl) {
      List<Acl> tmp = acl != null ? ImmutableList.copyOf(acl) : null;
      if (!Objects.equals(this.defaultAcl, tmp)) {
        modifiedFields.add(BucketField.DEFAULT_OBJECT_ACL);
      }
      this.defaultAcl = tmp;
      return this;
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    @Override
    public Builder setLabels(@Nullable Map<@NonNull String, @Nullable String> labels) {
      Map<String, String> left = this.labels;
      Map<String, String> right = labels;
      if (!Objects.equals(left, right)) {
        diffMaps(BucketField.LABELS, left, right, modifiedFields::add);
        if (right != null) {
          this.labels = new HashMap<>(right);
        } else {
          this.labels = (Map<String, String>) Data.nullOf(ImmutableEmptyMap.class);
        }
      }
      return this;
    }

    @Override
    public Builder setDefaultKmsKeyName(String defaultKmsKeyName) {
      String tmp = defaultKmsKeyName != null ? defaultKmsKeyName : Data.nullOf(String.class);
      if (!Objects.equals(this.defaultKmsKeyName, tmp)) {
        modifiedFields.add(BucketField.ENCRYPTION);
      }
      this.defaultKmsKeyName = tmp;
      return this;
    }

    @Override
    public BuilderImpl setGoogleManagedEncryptionEnforcementConfig(
        GoogleManagedEncryptionEnforcementConfig googleManagedEncryptionEnforcementConfig) {
      if (!Objects.equals(
          this.googleManagedEncryptionEnforcementConfig,
          googleManagedEncryptionEnforcementConfig)) {
        modifiedFields.add(BucketField.ENCRYPTION);
      }
      this.googleManagedEncryptionEnforcementConfig = googleManagedEncryptionEnforcementConfig;
      return this;
    }

    @Override
    public BuilderImpl setCustomerManagedEncryptionEnforcementConfig(
        CustomerManagedEncryptionEnforcementConfig customerManagedEncryptionEnforcementConfig) {
      if (!Objects.equals(
          this.customerManagedEncryptionEnforcementConfig,
          customerManagedEncryptionEnforcementConfig)) {
        modifiedFields.add(BucketField.ENCRYPTION);
      }
      this.customerManagedEncryptionEnforcementConfig = customerManagedEncryptionEnforcementConfig;
      return this;
    }

    @Override
    public BuilderImpl setCustomerSuppliedEncryptionEnforcementConfig(
        CustomerSuppliedEncryptionEnforcementConfig customerSuppliedEncryptionEnforcementConfig) {
      if (!Objects.equals(
          this.customerSuppliedEncryptionEnforcementConfig,
          customerSuppliedEncryptionEnforcementConfig)) {
        modifiedFields.add(BucketField.ENCRYPTION);
      }
      this.customerSuppliedEncryptionEnforcementConfig =
          customerSuppliedEncryptionEnforcementConfig;
      return this;
    }

    @Override
    public Builder setDefaultEventBasedHold(Boolean defaultEventBasedHold) {
      Boolean tmp = firstNonNull(defaultEventBasedHold, Data.<Boolean>nullOf(Boolean.class));
      if (!Objects.equals(this.defaultEventBasedHold, tmp)) {
        modifiedFields.add(BucketField.DEFAULT_EVENT_BASED_HOLD);
      }
      this.defaultEventBasedHold = tmp;
      return this;
    }

    /**
     * @deprecated Use {@link #setRetentionEffectiveTimeOffsetDateTime(OffsetDateTime)}
     */
    @Override
    @Deprecated
    Builder setRetentionEffectiveTime(Long retentionEffectiveTime) {
      return setRetentionEffectiveTimeOffsetDateTime(
          millisOffsetDateTimeCodec.encode(retentionEffectiveTime));
    }

    @Override
    Builder setRetentionEffectiveTimeOffsetDateTime(OffsetDateTime retentionEffectiveTime) {
      if (!Objects.equals(this.retentionEffectiveTime, retentionEffectiveTime)) {
        modifiedFields.add(BucketField.RETENTION_POLICY);
      }
      this.retentionEffectiveTime = retentionEffectiveTime;
      return this;
    }

    @Override
    Builder setRetentionPolicyIsLocked(Boolean retentionPolicyIsLocked) {
      Boolean tmp = firstNonNull(retentionPolicyIsLocked, Data.<Boolean>nullOf(Boolean.class));
      if (!Objects.equals(this.retentionPolicyIsLocked, retentionPolicyIsLocked)) {
        modifiedFields.add(BucketField.RETENTION_POLICY);
      }
      this.retentionPolicyIsLocked = tmp;
      return this;
    }

    /**
     * @deprecated Use {@link #setRetentionPeriodDuration(Duration)}
     */
    @Override
    public Builder setRetentionPeriod(Long retentionPeriod) {
      return setRetentionPeriodDuration(nullableDurationSecondsCodec.decode(retentionPeriod));
    }

    @Override
    public Builder setRetentionPeriodDuration(Duration retentionPeriod) {
      if (!Objects.equals(this.retentionPeriod, retentionPeriod)) {
        modifiedFields.add(BucketField.RETENTION_POLICY);
      }
      this.retentionPeriod = retentionPeriod;
      return this;
    }

    @Override
    public Builder setIamConfiguration(IamConfiguration iamConfiguration) {
      if (!Objects.equals(this.iamConfiguration, iamConfiguration)) {
        modifiedFields.add(BucketField.IAMCONFIGURATION);
      }
      this.iamConfiguration = iamConfiguration;
      return this;
    }

    @Override
    public Builder setAutoclass(Autoclass autoclass) {
      if (!Objects.equals(this.autoclass, autoclass)) {
        modifiedFields.add(BucketField.AUTOCLASS);
      }
      this.autoclass = autoclass;
      return this;
    }

    @Override
    public Builder setLogging(Logging logging) {
      Logging tmp = logging != null ? logging : Logging.newBuilder().build();
      if (!Objects.equals(this.logging, tmp)) {
        modifiedFields.add(BucketField.LOGGING);
      }
      this.logging = tmp;
      return this;
    }

    @Override
    public Builder setCustomPlacementConfig(CustomPlacementConfig customPlacementConfig) {
      if (!Objects.equals(this.customPlacementConfig, customPlacementConfig)) {
        modifiedFields.add(BucketField.CUSTOM_PLACEMENT_CONFIG);
      }
      this.customPlacementConfig = customPlacementConfig;
      return this;
    }

    @Override
    Builder setObjectRetention(ObjectRetention objectRetention) {
      if (!Objects.equals(this.objectRetention, objectRetention)) {
        modifiedFields.add(BucketField.OBJECT_RETENTION);
      }
      this.objectRetention = objectRetention;
      return this;
    }

    @Override
    public Builder setSoftDeletePolicy(SoftDeletePolicy softDeletePolicy) {
      if (!Objects.equals(this.softDeletePolicy, softDeletePolicy)) {
        modifiedFields.add(BucketField.SOFT_DELETE_POLICY);
      }
      this.softDeletePolicy = softDeletePolicy;
      return this;
    }

    @Override
    public Builder setHierarchicalNamespace(HierarchicalNamespace hierarchicalNamespace) {
      if (!Objects.equals(this.hierarchicalNamespace, hierarchicalNamespace)) {
        modifiedFields.add(BucketField.HIERARCHICAL_NAMESPACE);
      }
      this.hierarchicalNamespace = hierarchicalNamespace;
      return this;
    }

    @Override
    Builder setLocationType(String locationType) {
      if (!Objects.equals(this.locationType, locationType)) {
        modifiedFields.add(BucketField.LOCATION_TYPE);
      }
      this.locationType = locationType;
      return this;
    }

    @Override
    public Builder setIpFilter(IpFilter ipFilter) {
      if (!Objects.equals(this.ipFilter, ipFilter)) {
        modifiedFields.add(BucketField.IP_FILTER);
      }
      this.ipFilter = ipFilter;
      return this;
    }

    @Override
    public Builder setIsUnreachable(Boolean isUnreachable) {
      Boolean tmp = firstNonNull(isUnreachable, Data.<Boolean>nullOf(Boolean.class));
      this.isUnreachable = tmp;
      return this;
    }

    @Override
    public BucketInfo build() {
      checkNotNull(name);
      return new BucketInfo(this);
    }

    @Override
    BuilderImpl clearGeneratedId() {
      this.generatedId = null;
      return this;
    }

    @Override
    BuilderImpl clearProject() {
      this.project = null;
      return this;
    }

    @Override
    BuilderImpl clearName() {
      this.name = null;
      return this;
    }

    @Override
    BuilderImpl clearOwner() {
      this.owner = null;
      return this;
    }

    @Override
    BuilderImpl clearSelfLink() {
      this.selfLink = null;
      return this;
    }

    @Override
    BuilderImpl clearRequesterPays() {
      this.requesterPays = null;
      return this;
    }

    @Override
    BuilderImpl clearVersioningEnabled() {
      this.versioningEnabled = null;
      return this;
    }

    @Override
    BuilderImpl clearIndexPage() {
      this.indexPage = null;
      return this;
    }

    @Override
    BuilderImpl clearNotFoundPage() {
      this.notFoundPage = null;
      return this;
    }

    @Override
    BuilderImpl clearLifecycleRules() {
      this.lifecycleRules = null;
      return this;
    }

    @Override
    BuilderImpl clearRpo() {
      this.rpo = null;
      return this;
    }

    @Override
    BuilderImpl clearStorageClass() {
      this.storageClass = null;
      return this;
    }

    @Override
    BuilderImpl clearLocation() {
      this.location = null;
      return this;
    }

    @Override
    BuilderImpl clearEtag() {
      this.etag = null;
      return this;
    }

    @Override
    BuilderImpl clearCreateTime() {
      this.createTime = null;
      return this;
    }

    @Override
    BuilderImpl clearUpdateTime() {
      this.updateTime = null;
      return this;
    }

    @Override
    BuilderImpl clearMetageneration() {
      this.metageneration = null;
      return this;
    }

    @Override
    BuilderImpl clearCors() {
      this.cors = null;
      return this;
    }

    @Override
    BuilderImpl clearAcl() {
      this.acl = null;
      return this;
    }

    @Override
    BuilderImpl clearDefaultAcl() {
      this.defaultAcl = null;
      return this;
    }

    @Override
    BuilderImpl clearLabels() {
      this.labels = null;
      return this;
    }

    @Override
    BuilderImpl clearDefaultKmsKeyName() {
      this.defaultKmsKeyName = null;
      return this;
    }

    @Override
    BuilderImpl clearDefaultEventBasedHold() {
      this.defaultEventBasedHold = null;
      return this;
    }

    @Override
    BuilderImpl clearRetentionEffectiveTime() {
      this.retentionEffectiveTime = null;
      return this;
    }

    @Override
    BuilderImpl clearRetentionPolicyIsLocked() {
      this.retentionPolicyIsLocked = null;
      return this;
    }

    @Override
    BuilderImpl clearRetentionPeriod() {
      this.retentionPeriod = null;
      return this;
    }

    @Override
    BuilderImpl clearIamConfiguration() {
      this.iamConfiguration = null;
      return this;
    }

    @Override
    BuilderImpl clearLocationType() {
      this.locationType = null;
      return this;
    }

    @Override
    BuilderImpl clearLogging() {
      this.logging = null;
      return this;
    }

    @Override
    BuilderImpl clearCustomPlacementConfig() {
      this.customPlacementConfig = null;
      return this;
    }

    @Override
    BuilderImpl clearIpFilter() {
      this.ipFilter = null;
      return this;
    }

    @Override
    BuilderImpl clearGoogleManagedEncryptionEnforcementConfig() {
      this.googleManagedEncryptionEnforcementConfig = null;
      return this;
    }

    @Override
    BuilderImpl clearCustomerManagedEncryptionEnforcementConfig() {
      this.customerManagedEncryptionEnforcementConfig = null;
      return this;
    }

    @Override
    BuilderImpl clearCustomerSuppliedEncryptionEnforcementConfig() {
      this.customerSuppliedEncryptionEnforcementConfig = null;
      return this;
    }

    @Override
    BuilderImpl clearIsUnreachable() {
      this.isUnreachable = null;
      return this;
    }

    private Builder clearDeleteLifecycleRules() {
      if (lifecycleRules != null && !lifecycleRules.isEmpty()) {
        ImmutableList<LifecycleRule> nonDeleteRules =
            lifecycleRules.stream()
                .filter(IS_DELETE_LIFECYCLE_RULE.negate())
                .collect(ImmutableList.toImmutableList());
        return setLifecycleRules(nonDeleteRules);
      } else {
        return this;
      }
    }
  }

  BucketInfo(BuilderImpl builder) {
    generatedId = builder.generatedId;
    project = builder.project;
    name = builder.name;
    etag = builder.etag;
    createTime = builder.createTime;
    updateTime = builder.updateTime;
    metageneration = builder.metageneration;
    location = builder.location;
    rpo = builder.rpo;
    storageClass = builder.storageClass;
    cors = builder.cors;
    acl = builder.acl;
    defaultAcl = builder.defaultAcl;
    owner = builder.owner;
    selfLink = builder.selfLink;
    versioningEnabled = builder.versioningEnabled;
    indexPage = builder.indexPage;
    notFoundPage = builder.notFoundPage;
    lifecycleRules = builder.lifecycleRules;
    labels = builder.labels;
    requesterPays = builder.requesterPays;
    defaultKmsKeyName = builder.defaultKmsKeyName;
    defaultEventBasedHold = builder.defaultEventBasedHold;
    retentionEffectiveTime = builder.retentionEffectiveTime;
    retentionPolicyIsLocked = builder.retentionPolicyIsLocked;
    retentionPeriod = builder.retentionPeriod;
    iamConfiguration = builder.iamConfiguration;
    autoclass = builder.autoclass;
    locationType = builder.locationType;
    logging = builder.logging;
    customPlacementConfig = builder.customPlacementConfig;
    objectRetention = builder.objectRetention;
    softDeletePolicy = builder.softDeletePolicy;
    hierarchicalNamespace = builder.hierarchicalNamespace;
    ipFilter = builder.ipFilter;
    googleManagedEncryptionEnforcementConfig = builder.googleManagedEncryptionEnforcementConfig;
    customerManagedEncryptionEnforcementConfig = builder.customerManagedEncryptionEnforcementConfig;
    customerSuppliedEncryptionEnforcementConfig =
        builder.customerSuppliedEncryptionEnforcementConfig;
    isUnreachable = builder.isUnreachable;
    modifiedFields = builder.modifiedFields.build();
  }

  /** The project number of the project the bucket belongs to */
  public BigInteger getProject() {
    return project;
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
    return getLifecycleRules().stream()
        .filter(IS_DELETE_LIFECYCLE_RULE)
        .map(BackwardCompatibilityUtils.deleteRuleCodec::decode)
        .collect(ImmutableList.toImmutableList());
  }

  @NonNull
  public List<? extends LifecycleRule> getLifecycleRules() {
    return lifecycleRules != null ? lifecycleRules : ImmutableList.<LifecycleRule>of();
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
   *
   * @deprecated {@link #getCreateTimeOffsetDateTime()}
   */
  @Deprecated
  public Long getCreateTime() {
    return millisOffsetDateTimeCodec.decode(createTime);
  }

  public OffsetDateTime getCreateTimeOffsetDateTime() {
    return createTime;
  }

  /**
   * Returns the last modification time of the bucket's metadata expressed as the number of
   * milliseconds since the Unix epoch.
   *
   * @deprecated {@link #getUpdateTimeOffsetDateTime()}
   */
  @Deprecated
  public Long getUpdateTime() {
    return millisOffsetDateTimeCodec.decode(updateTime);
  }

  public OffsetDateTime getUpdateTimeOffsetDateTime() {
    return updateTime;
  }

  /** Returns the metadata generation of this bucket. */
  public Long getMetageneration() {
    return metageneration;
  }

  /**
   * Returns the bucket's location. Data for blobs in the bucket resides in physical storage within
   * this region or regions. If specifying more than one region `customPlacementConfig` should be
   * set in conjunction.
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
   * Returns the bucket's recovery point objective (RPO). This defines how quickly data is
   * replicated between regions in a dual-region bucket. Not defined for single-region buckets.
   *
   * @see <a href="https://cloud.google.com/storage/docs/turbo-replication">Turbo Replication"</a>
   */
  public Rpo getRpo() {
    return rpo;
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
  @Nullable
  public Map<@NonNull String, @Nullable String> getLabels() {
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
   *
   * @deprecated Use {@link #getRetentionPeriodDuration()}
   */
  @BetaApi
  @Deprecated
  public Long getRetentionEffectiveTime() {
    return Data.isNull(retentionEffectiveTime)
        ? null
        : millisOffsetDateTimeCodec.decode(retentionEffectiveTime);
  }

  /** Returns the retention effective time a policy took effect if a retention policy is defined. */
  @BetaApi
  public OffsetDateTime getRetentionEffectiveTimeOffsetDateTime() {
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

  /**
   * Returns the retention policy retention period.
   *
   * @deprecated Use {@link #getRetentionPeriodDuration()}
   */
  @BetaApi
  @Deprecated
  public Long getRetentionPeriod() {
    return nullableDurationSecondsCodec.encode(retentionPeriod);
  }

  /** Returns the retention policy retention period. */
  @BetaApi
  public Duration getRetentionPeriodDuration() {
    return retentionPeriod;
  }

  /** Returns the IAM configuration */
  @BetaApi
  public IamConfiguration getIamConfiguration() {
    return iamConfiguration;
  }

  /** Returns the Autoclass configuration */
  public Autoclass getAutoclass() {
    return autoclass;
  }

  /** Returns the Logging */
  public Logging getLogging() {
    return logging;
  }

  /** Returns the Custom Placement Configuration */
  public CustomPlacementConfig getCustomPlacementConfig() {
    return customPlacementConfig;
  }

  /** returns the Object Retention configuration */
  public ObjectRetention getObjectRetention() {
    return objectRetention;
  }

  /** returns the Soft Delete policy */
  public SoftDeletePolicy getSoftDeletePolicy() {
    return softDeletePolicy;
  }

  /** Returns the Hierarchical Namespace (Folders) Configuration */
  public HierarchicalNamespace getHierarchicalNamespace() {
    return hierarchicalNamespace;
  }

  /**
   * @since 2.54.0
   */
  public @Nullable IpFilter getIpFilter() {
    return ipFilter;
  }

  public @Nullable GoogleManagedEncryptionEnforcementConfig
      getGoogleManagedEncryptionEnforcementConfig() {
    return googleManagedEncryptionEnforcementConfig;
  }

  public @Nullable CustomerManagedEncryptionEnforcementConfig
      getCustomerManagedEncryptionEnforcementConfig() {
    return customerManagedEncryptionEnforcementConfig;
  }

  public @Nullable CustomerSuppliedEncryptionEnforcementConfig
      getCustomerSuppliedEncryptionEnforcementConfig() {
    return customerSuppliedEncryptionEnforcementConfig;
  }

  /**
   * Returns a {@code Boolean} with {@code true} if the bucket is unreachable, else {@code null}
   *
   * <p>A bucket may be unreachable if the region in which it resides is experiencing an outage or
   * if there are other temporary access issues.
   */
  public Boolean isUnreachable() {
    return Data.isNull(isUnreachable) ? null : isUnreachable;
  }

  /** Returns a builder for the current bucket. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        generatedId,
        project,
        name,
        owner,
        selfLink,
        requesterPays,
        versioningEnabled,
        indexPage,
        notFoundPage,
        lifecycleRules,
        etag,
        createTime,
        updateTime,
        metageneration,
        cors,
        acl,
        defaultAcl,
        location,
        rpo,
        storageClass,
        labels,
        defaultKmsKeyName,
        defaultEventBasedHold,
        retentionEffectiveTime,
        retentionPolicyIsLocked,
        retentionPeriod,
        iamConfiguration,
        autoclass,
        locationType,
        objectRetention,
        softDeletePolicy,
        customPlacementConfig,
        hierarchicalNamespace,
        logging,
        ipFilter,
        googleManagedEncryptionEnforcementConfig,
        customerManagedEncryptionEnforcementConfig,
        customerSuppliedEncryptionEnforcementConfig,
        isUnreachable);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BucketInfo)) {
      return false;
    }
    BucketInfo that = (BucketInfo) o;
    return Objects.equals(generatedId, that.generatedId)
        && Objects.equals(project, that.project)
        && Objects.equals(name, that.name)
        && Objects.equals(owner, that.owner)
        && Objects.equals(selfLink, that.selfLink)
        && Objects.equals(requesterPays, that.requesterPays)
        && Objects.equals(versioningEnabled, that.versioningEnabled)
        && Objects.equals(indexPage, that.indexPage)
        && Objects.equals(notFoundPage, that.notFoundPage)
        && Objects.equals(lifecycleRules, that.lifecycleRules)
        && Objects.equals(etag, that.etag)
        && Objects.equals(createTime, that.createTime)
        && Objects.equals(updateTime, that.updateTime)
        && Objects.equals(metageneration, that.metageneration)
        && Objects.equals(cors, that.cors)
        && Objects.equals(acl, that.acl)
        && Objects.equals(defaultAcl, that.defaultAcl)
        && Objects.equals(location, that.location)
        && Objects.equals(rpo, that.rpo)
        && Objects.equals(storageClass, that.storageClass)
        && Objects.equals(labels, that.labels)
        && Objects.equals(defaultKmsKeyName, that.defaultKmsKeyName)
        && Objects.equals(defaultEventBasedHold, that.defaultEventBasedHold)
        && Objects.equals(retentionEffectiveTime, that.retentionEffectiveTime)
        && Objects.equals(retentionPolicyIsLocked, that.retentionPolicyIsLocked)
        && Objects.equals(retentionPeriod, that.retentionPeriod)
        && Objects.equals(iamConfiguration, that.iamConfiguration)
        && Objects.equals(autoclass, that.autoclass)
        && Objects.equals(locationType, that.locationType)
        && Objects.equals(customPlacementConfig, that.customPlacementConfig)
        && Objects.equals(objectRetention, that.objectRetention)
        && Objects.equals(softDeletePolicy, that.softDeletePolicy)
        && Objects.equals(hierarchicalNamespace, that.hierarchicalNamespace)
        && Objects.equals(logging, that.logging)
        && Objects.equals(ipFilter, that.ipFilter)
        && Objects.equals(
            googleManagedEncryptionEnforcementConfig, that.googleManagedEncryptionEnforcementConfig)
        && Objects.equals(
            customerManagedEncryptionEnforcementConfig,
            that.customerManagedEncryptionEnforcementConfig)
        && Objects.equals(
            customerSuppliedEncryptionEnforcementConfig,
            that.customerSuppliedEncryptionEnforcementConfig)
        && Objects.equals(isUnreachable, that.isUnreachable);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("name", name).toString();
  }

  /**
   * Attach this instance to an instance of {@link Storage} thereby allowing RPCs to be performed
   * using the methods from the resulting {@link Bucket}
   */
  Bucket asBucket(Storage storage) {
    return new Bucket(storage, new BucketInfo.BuilderImpl(this));
  }

  ImmutableSet<NamedField> getModifiedFields() {
    return modifiedFields;
  }

  /** Creates a {@code BucketInfo} object for the provided bucket name. */
  public static BucketInfo of(String name) {
    return newBuilder(name).build();
  }

  /** Returns a {@code BucketInfo} builder where the bucket's name is set to the provided name. */
  public static Builder newBuilder(String name) {
    return new BuilderImpl(name);
  }
}
