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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.BucketOptExtractor;
import com.google.cloud.storage.UnifiedOpts.BucketSourceOpt;
import com.google.cloud.storage.UnifiedOpts.ObjectOptExtractor;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.Key;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * A Google cloud storage bucket.
 *
 * <p>Objects of this class are immutable. Operations that modify the bucket like {@link #update}
 * return a new object. To get a {@code Bucket} object with the most recent information use {@link
 * #reload}. {@code Bucket} adds a layer of service-related functionality over {@link BucketInfo}.
 */
@TransportCompatibility({Transport.HTTP, Transport.GRPC})
public class Bucket extends BucketInfo {

  private static final long serialVersionUID = 3599706574671671516L;

  private final StorageOptions options;
  private transient Storage storage;

  /** Class for specifying bucket source options when {@code Bucket} methods are used. */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public static class BucketSourceOption extends Option<BucketSourceOpt> {

    private static final long serialVersionUID = 6765489853972162215L;

    private BucketSourceOption(BucketSourceOpt opt) {
      super(opt);
    }

    /**
     * Returns an option for bucket's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketSourceOption metagenerationMatch() {
      return new BucketSourceOption(UnifiedOpts.metagenerationMatchExtractor());
    }

    /**
     * Returns an option for bucket's metageneration mismatch. If this option is used the request
     * will fail if metageneration matches.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketSourceOption metagenerationNotMatch() {
      return new BucketSourceOption(UnifiedOpts.metagenerationNotMatchExtractor());
    }

    /**
     * Returns an option for blob's billing user project. This option is only used by the buckets
     * with 'requester_pays' flag.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketSourceOption userProject(@NonNull String userProject) {
      return new BucketSourceOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BucketSourceOption[] dedupe(BucketSourceOption... os) {
      return Option.dedupe(BucketSourceOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BucketSourceOption[] dedupe(
        Collection<BucketSourceOption> collection, BucketSourceOption... os) {
      return Option.dedupe(BucketSourceOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BucketSourceOption[] dedupe(
        BucketSourceOption[] array, BucketSourceOption... os) {
      return Option.dedupe(BucketSourceOption[]::new, array, os);
    }

    static Storage.BucketSourceOption[] toSourceOptions(
        BucketInfo bucketInfo, BucketSourceOption... options) {
      Storage.BucketSourceOption[] convertedOptions =
          new Storage.BucketSourceOption[options.length];
      for (int i = 0; i < options.length; i++) {
        BucketSourceOpt opt = options[i].getOpt();
        if (opt instanceof BucketOptExtractor) {
          BucketOptExtractor<BucketSourceOpt> ex = (BucketOptExtractor<BucketSourceOpt>) opt;
          BucketSourceOpt bucketSourceOpt = ex.extractFromBucketInfo(bucketInfo);
          convertedOptions[i] = new Storage.BucketSourceOption(bucketSourceOpt);
        } else {
          convertedOptions[i] = new Storage.BucketSourceOption(options[i].getOpt());
        }
      }
      return convertedOptions;
    }

    static Storage.BucketGetOption[] toGetOptions(
        BucketInfo bucketInfo, BucketSourceOption... options) {
      Storage.BucketGetOption[] convertedOptions = new Storage.BucketGetOption[options.length];
      for (int i = 0; i < options.length; i++) {
        BucketSourceOpt opt = options[i].getOpt();
        if (opt instanceof BucketOptExtractor) {
          BucketOptExtractor<BucketSourceOpt> ex = (BucketOptExtractor<BucketSourceOpt>) opt;
          BucketSourceOpt bucketSourceOpt = ex.extractFromBucketInfo(bucketInfo);
          convertedOptions[i] = new BucketGetOption(bucketSourceOpt);
        } else {
          convertedOptions[i] = new BucketGetOption(options[i].getOpt());
        }
      }
      return convertedOptions;
    }
  }

  /** Class for specifying blob target options when {@code Bucket} methods are used. */
  public static class BlobTargetOption extends Option<ObjectTargetOpt> {

    private static final long serialVersionUID = -7203767045761758606L;

    private BlobTargetOption(ObjectTargetOpt opt) {
      super(opt);
    }

    /** Returns an option for specifying blob's predefined ACL configuration. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption predefinedAcl(Storage.@NonNull PredefinedAcl acl) {
      return new BlobTargetOption(UnifiedOpts.predefinedAcl(acl));
    }

    /**
     * Returns an option that causes an operation to succeed only if the target blob does not exist.
     * This option can not be provided together with {@link #generationMatch(long)} or {@link
     * #generationNotMatch(long)}.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption doesNotExist() {
      return new BlobTargetOption(UnifiedOpts.doesNotExist());
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if generation does not match the provided value. This option can not be provided
     * together with {@link #generationNotMatch(long)} or {@link #doesNotExist()}.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption generationMatch(long generation) {
      return new BlobTargetOption(UnifiedOpts.generationMatch(generation));
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if blob's generation matches the provided value. This option can not be provided
     * together with {@link #generationMatch(long)} or {@link #doesNotExist()}.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption generationNotMatch(long generation) {
      return new BlobTargetOption(UnifiedOpts.generationNotMatch(generation));
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if metageneration does not match the provided value. This option can not be provided
     * together with {@link #metagenerationNotMatch(long)}.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption metagenerationMatch(long metageneration) {
      return new BlobTargetOption(UnifiedOpts.metagenerationMatch(metageneration));
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if metageneration matches the provided value. This option can not be provided together
     * with {@link #metagenerationMatch(long)}.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption metagenerationNotMatch(long metageneration) {
      return new BlobTargetOption(UnifiedOpts.metagenerationNotMatch(metageneration));
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption encryptionKey(@NonNull Key key) {
      return new BlobTargetOption(UnifiedOpts.encryptionKey(key));
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     *
     * @param key the AES256 encoded in base64
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption encryptionKey(@NonNull String key) {
      return new BlobTargetOption(UnifiedOpts.encryptionKey(key));
    }

    /**
     * Returns an option to set a customer-managed KMS key for server-side encryption of the blob.
     *
     * @param kmsKeyName the KMS key resource id
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption kmsKeyName(@NonNull String kmsKeyName) {
      return new BlobTargetOption(UnifiedOpts.kmsKeyName(kmsKeyName));
    }

    /**
     * Returns an option for blob's billing user project. This option is only used by the buckets
     * with 'requester_pays' flag.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption userProject(@NonNull String userProject) {
      return new BlobTargetOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option for overriding an Unlocked Retention policy. This must be set to true in
     * order to change a policy from Unlocked to Locked, to set it to null, or to reduce its
     * retainUntilTime attribute.
     */
    @TransportCompatibility({Transport.HTTP})
    public static BlobTargetOption overrideUnlockedRetention(boolean overrideUnlockedRetention) {
      return new BlobTargetOption(UnifiedOpts.overrideUnlockedRetention(overrideUnlockedRetention));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BlobTargetOption[] dedupe(BlobTargetOption... os) {
      return Option.dedupe(BlobTargetOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobTargetOption[] dedupe(
        Collection<BlobTargetOption> collection, BlobTargetOption... os) {
      return Option.dedupe(BlobTargetOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobTargetOption[] dedupe(BlobTargetOption[] array, BlobTargetOption... os) {
      return Option.dedupe(BlobTargetOption[]::new, array, os);
    }

    static Storage.BlobTargetOption[] toTargetOptions(
        BlobInfo blobInfo, BlobTargetOption... options) {
      Storage.BlobTargetOption[] targetOptions = new Storage.BlobTargetOption[options.length];
      for (int i = 0; i < options.length; i++) {
        ObjectTargetOpt opt = options[i].getOpt();
        if (opt instanceof ObjectOptExtractor) {
          ObjectOptExtractor<ObjectTargetOpt> ex = (ObjectOptExtractor<ObjectTargetOpt>) opt;
          ObjectTargetOpt objectTargetOpt = ex.extractFromBlobInfo(blobInfo);
          targetOptions[i] = new Storage.BlobTargetOption(objectTargetOpt);
        } else {
          targetOptions[i] = new Storage.BlobTargetOption(options[i].getOpt());
        }
      }
      return targetOptions;
    }
  }

  /** Class for specifying blob write options when {@code Bucket} methods are used. */
  public static class BlobWriteOption extends Option<ObjectTargetOpt> implements Serializable {

    private static final long serialVersionUID = 59762268190041584L;

    private BlobWriteOption(ObjectTargetOpt opt) {
      super(opt);
    }

    /** Returns an option for specifying blob's predefined ACL configuration. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption predefinedAcl(Storage.@NonNull PredefinedAcl acl) {
      return new BlobWriteOption(UnifiedOpts.predefinedAcl(acl));
    }

    /**
     * Returns an option that causes an operation to succeed only if the target blob does not exist.
     * This option can not be provided together with {@link #generationMatch(long)} or {@link
     * #generationNotMatch(long)}.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption doesNotExist() {
      return new BlobWriteOption(UnifiedOpts.doesNotExist());
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if generation does not match the provided value. This option can not be provided
     * together with {@link #generationNotMatch(long)} or {@link #doesNotExist()}.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption generationMatch(long generation) {
      return new BlobWriteOption(UnifiedOpts.generationMatch(generation));
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if generation matches the provided value. This option can not be provided together
     * with {@link #generationMatch(long)} or {@link #doesNotExist()}.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption generationNotMatch(long generation) {
      return new BlobWriteOption(UnifiedOpts.generationNotMatch(generation));
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if metageneration does not match the provided value. This option can not be provided
     * together with {@link #metagenerationNotMatch(long)}.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption metagenerationMatch(long metageneration) {
      return new BlobWriteOption(UnifiedOpts.metagenerationMatch(metageneration));
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if metageneration matches the provided value. This option can not be provided together
     * with {@link #metagenerationMatch(long)}.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption metagenerationNotMatch(long metageneration) {
      return new BlobWriteOption(UnifiedOpts.metagenerationNotMatch(metageneration));
    }

    /**
     * Returns an option for blob's data MD5 hash match. If this option is used the request will
     * fail if blobs' data MD5 hash does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption md5Match(@NonNull String md5) {
      return new BlobWriteOption(UnifiedOpts.md5Match(md5));
    }

    /**
     * Returns an option for blob's data CRC32C checksum match. If this option is used the request
     * will fail if blobs' data CRC32C checksum does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption crc32cMatch(@NonNull String crc32c) {
      return new BlobWriteOption(UnifiedOpts.crc32cMatch(crc32c));
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption encryptionKey(@NonNull Key key) {
      return new BlobWriteOption(UnifiedOpts.encryptionKey(key));
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     *
     * @param key the AES256 encoded in base64
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption encryptionKey(@NonNull String key) {
      return new BlobWriteOption(UnifiedOpts.encryptionKey(key));
    }

    /**
     * Returns an option for blob's billing user project. This option is only used by the buckets
     * with 'requester_pays' flag.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption userProject(@NonNull String userProject) {
      return new BlobWriteOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BlobWriteOption[] dedupe(BlobWriteOption... os) {
      return Option.dedupe(BlobWriteOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobWriteOption[] dedupe(
        Collection<BlobWriteOption> collection, BlobWriteOption... os) {
      return Option.dedupe(BlobWriteOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobWriteOption[] dedupe(BlobWriteOption[] array, BlobWriteOption... os) {
      return Option.dedupe(BlobWriteOption[]::new, array, os);
    }

    static Storage.BlobWriteOption[] toWriteOptions(BlobInfo blobInfo, BlobWriteOption... options) {
      Storage.BlobWriteOption[] convertedOptions = new Storage.BlobWriteOption[options.length];
      for (int i = 0; i < options.length; i++) {
        ObjectTargetOpt opt = options[i].getOpt();
        if (opt instanceof ObjectOptExtractor) {
          ObjectOptExtractor<ObjectTargetOpt> ex = (ObjectOptExtractor<ObjectTargetOpt>) opt;
          ObjectTargetOpt objectTargetOpt = ex.extractFromBlobInfo(blobInfo);
          convertedOptions[i] = new Storage.BlobWriteOption(objectTargetOpt);
        } else {
          convertedOptions[i] = new Storage.BlobWriteOption(options[i].getOpt());
        }
      }
      return convertedOptions;
    }
  }

  /** Builder for {@code Bucket}. */
  public static class Builder extends BucketInfo.Builder {
    private final Storage storage;
    private final BucketInfo.BuilderImpl infoBuilder;

    Builder(Bucket bucket) {
      this.storage = bucket.storage;
      this.infoBuilder = new BucketInfo.BuilderImpl(bucket);
    }

    @Override
    public Builder setName(String name) {
      infoBuilder.setName(name);
      return this;
    }

    @Override
    Builder setProject(BigInteger project) {
      infoBuilder.setProject(project);
      return this;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      infoBuilder.setGeneratedId(generatedId);
      return this;
    }

    @Override
    Builder setOwner(Entity owner) {
      infoBuilder.setOwner(owner);
      return this;
    }

    @Override
    Builder setSelfLink(String selfLink) {
      infoBuilder.setSelfLink(selfLink);
      return this;
    }

    @Override
    public Builder setVersioningEnabled(Boolean enable) {
      infoBuilder.setVersioningEnabled(enable);
      return this;
    }

    @Override
    public Builder setRequesterPays(Boolean requesterPays) {
      infoBuilder.setRequesterPays(requesterPays);
      return this;
    }

    @Override
    public Builder setIndexPage(String indexPage) {
      infoBuilder.setIndexPage(indexPage);
      return this;
    }

    @Override
    public Builder setNotFoundPage(String notFoundPage) {
      infoBuilder.setNotFoundPage(notFoundPage);
      return this;
    }

    /**
     * @deprecated Use {@link #setLifecycleRules(Iterable)} instead, as in {@code
     *     setLifecycleRules(Collections.singletonList( new BucketInfo.LifecycleRule(
     *     LifecycleAction.newDeleteAction(), LifecycleCondition.newBuilder().setAge(5).build())));}
     */
    @Override
    @Deprecated
    public Builder setDeleteRules(Iterable<? extends DeleteRule> rules) {
      infoBuilder.setDeleteRules(rules);
      return this;
    }

    @Override
    public Builder setLifecycleRules(Iterable<? extends LifecycleRule> rules) {
      infoBuilder.setLifecycleRules(rules);
      return this;
    }

    @Override
    public Builder deleteLifecycleRules() {
      infoBuilder.deleteLifecycleRules();
      return this;
    }

    @Override
    public Builder setRpo(Rpo rpo) {
      infoBuilder.setRpo(rpo);
      return this;
    }

    @Override
    public Builder setStorageClass(StorageClass storageClass) {
      infoBuilder.setStorageClass(storageClass);
      return this;
    }

    @Override
    public Builder setLocation(String location) {
      infoBuilder.setLocation(location);
      return this;
    }

    @Override
    Builder setEtag(String etag) {
      infoBuilder.setEtag(etag);
      return this;
    }

    /**
     * @deprecated Use {@link #setCreateTimeOffsetDateTime(OffsetDateTime)}
     */
    @Override
    @Deprecated
    Builder setCreateTime(Long createTime) {
      infoBuilder.setCreateTime(createTime);
      return this;
    }

    @Override
    BucketInfo.Builder setCreateTimeOffsetDateTime(OffsetDateTime createTime) {
      infoBuilder.setCreateTimeOffsetDateTime(createTime);
      return this;
    }

    /**
     * @deprecated Use {@link #setUpdateTimeOffsetDateTime(OffsetDateTime)}
     */
    @Override
    @Deprecated
    Builder setUpdateTime(Long updateTime) {
      infoBuilder.setUpdateTime(updateTime);
      return this;
    }

    @Override
    BucketInfo.Builder setUpdateTimeOffsetDateTime(OffsetDateTime updateTime) {
      infoBuilder.setUpdateTimeOffsetDateTime(updateTime);
      return this;
    }

    @Override
    Builder setMetageneration(Long metageneration) {
      infoBuilder.setMetageneration(metageneration);
      return this;
    }

    @Override
    public Builder setCors(Iterable<Cors> cors) {
      infoBuilder.setCors(cors);
      return this;
    }

    @Override
    public Builder setAcl(Iterable<Acl> acl) {
      infoBuilder.setAcl(acl);
      return this;
    }

    @Override
    public Builder setDefaultAcl(Iterable<Acl> acl) {
      infoBuilder.setDefaultAcl(acl);
      return this;
    }

    @Override
    public Builder setLabels(@Nullable Map<@NonNull String, @Nullable String> labels) {
      infoBuilder.setLabels(labels);
      return this;
    }

    @Override
    public Builder setDefaultKmsKeyName(String defaultKmsKeyName) {
      infoBuilder.setDefaultKmsKeyName(defaultKmsKeyName);
      return this;
    }

    @Override
    public Builder setDefaultEventBasedHold(Boolean defaultEventBasedHold) {
      infoBuilder.setDefaultEventBasedHold(defaultEventBasedHold);
      return this;
    }

    /**
     * @deprecated {@link #setRetentionEffectiveTimeOffsetDateTime(OffsetDateTime)}
     */
    @Override
    @Deprecated
    Builder setRetentionEffectiveTime(Long retentionEffectiveTime) {
      infoBuilder.setRetentionEffectiveTime(retentionEffectiveTime);
      return this;
    }

    @Override
    BucketInfo.Builder setRetentionEffectiveTimeOffsetDateTime(
        OffsetDateTime retentionEffectiveTime) {
      infoBuilder.setRetentionEffectiveTimeOffsetDateTime(retentionEffectiveTime);
      return this;
    }

    @Override
    Builder setRetentionPolicyIsLocked(Boolean retentionIsLocked) {
      infoBuilder.setRetentionPolicyIsLocked(retentionIsLocked);
      return this;
    }

    /**
     * @deprecated Use {@link #setRetentionPeriodDuration(Duration)}
     */
    @Override
    @Deprecated
    public Builder setRetentionPeriod(Long retentionPeriod) {
      infoBuilder.setRetentionPeriod(retentionPeriod);
      return this;
    }

    @Override
    public BucketInfo.Builder setRetentionPeriodDuration(Duration retentionPeriod) {
      infoBuilder.setRetentionPeriodDuration(retentionPeriod);
      return this;
    }

    @Override
    public Builder setIamConfiguration(IamConfiguration iamConfiguration) {
      infoBuilder.setIamConfiguration(iamConfiguration);
      return this;
    }

    @Override
    public Builder setAutoclass(Autoclass autoclass) {
      infoBuilder.setAutoclass(autoclass);
      return this;
    }

    @Override
    public Builder setLogging(Logging logging) {
      infoBuilder.setLogging(logging);
      return this;
    }

    @Override
    Builder setLocationType(String locationType) {
      infoBuilder.setLocationType(locationType);
      return this;
    }

    @Override
    public Builder setCustomPlacementConfig(CustomPlacementConfig customPlacementConfig) {
      infoBuilder.setCustomPlacementConfig(customPlacementConfig);
      return this;
    }

    @Override
    Builder setObjectRetention(ObjectRetention objectRetention) {
      infoBuilder.setObjectRetention(objectRetention);
      return this;
    }

    @Override
    public Builder setSoftDeletePolicy(SoftDeletePolicy softDeletePolicy) {
      infoBuilder.setSoftDeletePolicy(softDeletePolicy);
      return this;
    }

    @Override
    public Builder setHierarchicalNamespace(HierarchicalNamespace hierarchicalNamespace) {
      infoBuilder.setHierarchicalNamespace(hierarchicalNamespace);
      return this;
    }

    @Override
    public Builder setIpFilter(IpFilter ipFilter) {
      infoBuilder.setIpFilter(ipFilter);
      return this;
    }

    @Override
    public Builder setGoogleManagedEncryptionEnforcementConfig(
        GoogleManagedEncryptionEnforcementConfig googleManagedEncryptionEnforcementConfig) {
      infoBuilder.setGoogleManagedEncryptionEnforcementConfig(
          googleManagedEncryptionEnforcementConfig);
      return this;
    }

    @Override
    public Builder setCustomerManagedEncryptionEnforcementConfig(
        CustomerManagedEncryptionEnforcementConfig customerManagedEncryptionEnforcementConfig) {
      infoBuilder.setCustomerManagedEncryptionEnforcementConfig(
          customerManagedEncryptionEnforcementConfig);
      return this;
    }

    @Override
    public Builder setCustomerSuppliedEncryptionEnforcementConfig(
        CustomerSuppliedEncryptionEnforcementConfig customerSuppliedEncryptionEnforcementConfig) {
      infoBuilder.setCustomerSuppliedEncryptionEnforcementConfig(
          customerSuppliedEncryptionEnforcementConfig);
      return this;
    }

    @Override
    public Builder setIsUnreachable(Boolean isUnreachable) {
      infoBuilder.setIsUnreachable(isUnreachable);
      return this;
    }

    @Override
    public Bucket build() {
      return new Bucket(storage, infoBuilder);
    }

    @Override
    Builder clearGeneratedId() {
      infoBuilder.clearGeneratedId();
      return this;
    }

    @Override
    Builder clearProject() {
      infoBuilder.clearProject();
      return this;
    }

    @Override
    Builder clearName() {
      infoBuilder.clearName();
      return this;
    }

    @Override
    Builder clearOwner() {
      infoBuilder.clearOwner();
      return this;
    }

    @Override
    Builder clearSelfLink() {
      infoBuilder.clearSelfLink();
      return this;
    }

    @Override
    Builder clearRequesterPays() {
      infoBuilder.clearRequesterPays();
      return this;
    }

    @Override
    Builder clearVersioningEnabled() {
      infoBuilder.clearVersioningEnabled();
      return this;
    }

    @Override
    Builder clearIndexPage() {
      infoBuilder.clearIndexPage();
      return this;
    }

    @Override
    Builder clearNotFoundPage() {
      infoBuilder.clearNotFoundPage();
      return this;
    }

    @Override
    Builder clearLifecycleRules() {
      infoBuilder.clearLifecycleRules();
      return this;
    }

    @Override
    Builder clearRpo() {
      infoBuilder.clearRpo();
      return this;
    }

    @Override
    Builder clearStorageClass() {
      infoBuilder.clearStorageClass();
      return this;
    }

    @Override
    Builder clearLocation() {
      infoBuilder.clearLocation();
      return this;
    }

    @Override
    Builder clearEtag() {
      infoBuilder.clearEtag();
      return this;
    }

    @Override
    Builder clearCreateTime() {
      infoBuilder.clearCreateTime();
      return this;
    }

    @Override
    Builder clearUpdateTime() {
      infoBuilder.clearUpdateTime();
      return this;
    }

    @Override
    Builder clearMetageneration() {
      infoBuilder.clearMetageneration();
      return this;
    }

    @Override
    Builder clearCors() {
      infoBuilder.clearCors();
      return this;
    }

    @Override
    Builder clearAcl() {
      infoBuilder.clearAcl();
      return this;
    }

    @Override
    Builder clearDefaultAcl() {
      infoBuilder.clearDefaultAcl();
      return this;
    }

    @Override
    Builder clearLabels() {
      infoBuilder.clearLabels();
      return this;
    }

    @Override
    Builder clearDefaultKmsKeyName() {
      infoBuilder.clearDefaultKmsKeyName();
      return this;
    }

    @Override
    Builder clearDefaultEventBasedHold() {
      infoBuilder.clearDefaultEventBasedHold();
      return this;
    }

    @Override
    Builder clearRetentionEffectiveTime() {
      infoBuilder.clearRetentionEffectiveTime();
      return this;
    }

    @Override
    Builder clearRetentionPolicyIsLocked() {
      infoBuilder.clearRetentionPolicyIsLocked();
      return this;
    }

    @Override
    Builder clearRetentionPeriod() {
      infoBuilder.clearRetentionPeriod();
      return this;
    }

    @Override
    Builder clearIamConfiguration() {
      infoBuilder.clearIamConfiguration();
      return this;
    }

    @Override
    Builder clearLocationType() {
      infoBuilder.clearLocationType();
      return this;
    }

    @Override
    Builder clearLogging() {
      infoBuilder.clearLogging();
      return this;
    }

    @Override
    Builder clearCustomPlacementConfig() {
      infoBuilder.clearCustomPlacementConfig();
      return this;
    }

    @Override
    Builder clearIpFilter() {
      infoBuilder.clearIpFilter();
      return this;
    }

    @Override
    public Builder clearGoogleManagedEncryptionEnforcementConfig() {
      infoBuilder.clearGoogleManagedEncryptionEnforcementConfig();
      return this;
    }

    @Override
    public Builder clearCustomerManagedEncryptionEnforcementConfig() {
      infoBuilder.clearCustomerManagedEncryptionEnforcementConfig();
      return this;
    }

    @Override
    public Builder clearCustomerSuppliedEncryptionEnforcementConfig() {
      infoBuilder.clearCustomerSuppliedEncryptionEnforcementConfig();
      return this;
    }

    @Override
    Builder clearIsUnreachable() {
      infoBuilder.clearIsUnreachable();
      return this;
    }
  }

  Bucket(Storage storage, BucketInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.storage = checkNotNull(storage);
    this.options = storage.getOptions();
  }

  /**
   * Checks if this bucket exists.
   *
   * <p>Example of checking if the bucket exists.
   *
   * <pre>{@code
   * boolean exists = bucket.exists();
   * if (exists) {
   *   // the bucket exists
   * } else {
   *   // the bucket was not found
   * }
   * }</pre>
   *
   * @return true if this bucket exists, false otherwise
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public boolean exists(BucketSourceOption... options) {
    int length = options.length;
    // Don't use static imports of BlobSourceOption, it causes import resolution issues
    // with the new UnifiedOpts shim interfaces
    Storage.BucketGetOption[] getOptions =
        Arrays.copyOf(BucketSourceOption.toGetOptions(this, options), length + 1);
    getOptions[length] = Storage.BucketGetOption.fields();
    return storage.get(getName(), getOptions) != null;
  }

  /**
   * Fetches current bucket's latest information. Returns {@code null} if the bucket does not exist.
   *
   * <p>Example of getting the bucket's latest information, if its generation does not match the
   * {@link Bucket#getMetageneration()} value, otherwise a {@link StorageException} is thrown.
   *
   * <pre>{@code
   * Bucket latestBucket = bucket.reload(BucketSourceOption.metagenerationMatch());
   * if (latestBucket == null) {
   *   // the bucket was not found
   * }
   * }</pre>
   *
   * @param options bucket read options
   * @return a {@code Bucket} object with latest information or {@code null} if not found
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Bucket reload(BucketSourceOption... options) {
    // Don't use static imports of BlobSourceOption, it causes import resolution issues
    // with the new UnifiedOpts shim interfaces
    return storage.get(getName(), BucketSourceOption.toGetOptions(this, options));
  }

  /**
   * Updates the bucket's information. Bucket's name cannot be changed. A new {@code Bucket} object
   * is returned. By default no checks are made on the metadata generation of the current bucket. If
   * you want to update the information only if the current bucket metadata are at their latest
   * version use the {@code metagenerationMatch} option: {@code
   * bucket.update(BucketTargetOption.metagenerationMatch())}
   *
   * <p>Example of updating the bucket's information.
   *
   * <pre>{@code
   * Bucket updatedBucket = bucket.toBuilder().setVersioningEnabled(true).build().update();
   * }</pre>
   *
   * @param options update options
   * @return a {@code Bucket} object with updated information
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Bucket update(BucketTargetOption... options) {
    return storage.update(this, options);
  }

  /**
   * Deletes this bucket.
   *
   * <p>Example of deleting the bucket, if its metageneration matches the {@link
   * Bucket#getMetageneration()} value, otherwise a {@link StorageException} is thrown.
   *
   * <pre>{@code
   * boolean deleted = bucket.delete(BucketSourceOption.metagenerationMatch());
   * if (deleted) {
   *   // the bucket was deleted
   * } else {
   *   // the bucket was not found
   * }
   * }</pre>
   *
   * @param options bucket delete options
   * @return {@code true} if bucket was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public boolean delete(BucketSourceOption... options) {
    // Don't use static imports of BlobSourceOption, it causes import resolution issues
    // with the new UnifiedOpts shim interfaces
    return storage.delete(getName(), BucketSourceOption.toSourceOptions(this, options));
  }

  /**
   * Returns the paginated list of {@code Blob} in this bucket.
   *
   * <p>Example of listing the blobs in the bucket.
   *
   * <pre>{@code
   * Page<Blob> blobs = bucket.list();
   * Iterator<Blob> blobIterator = blobs.iterateAll();
   * while (blobIterator.hasNext()) {
   *   Blob blob = blobIterator.next();
   *   // do something with the blob
   * }
   * }</pre>
   *
   * @param options options for listing blobs
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Page<Blob> list(BlobListOption... options) {
    return storage.list(getName(), options);
  }

  /**
   * Returns the requested blob in this bucket or {@code null} if not found.
   *
   * <p>Example of getting a blob in the bucket, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   *
   * <pre>{@code
   * String blobName = "my_blob_name";
   * long generation = 42;
   * Blob blob = bucket.get(blobName, BlobGetOption.generationMatch(generation));
   * }</pre>
   *
   * @param blob name of the requested blob
   * @param options blob search options
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Blob get(String blob, BlobGetOption... options) {
    return storage.get(BlobId.of(getName(), blob), options);
  }

  /**
   * Returns the requested blob in this bucket of a specific generation or {@code null} if not
   * found.
   *
   * <p>Example of getting a blob of a specific in the bucket.
   *
   * <pre>{@code
   * String blobName = "my_blob_name";
   * long generation = 42;
   * Blob blob = bucket.get(blobName, generation);
   * }</pre>
   *
   * @param blob name of the requested blob
   * @param generation the generation to get
   * @param options blob search options
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Blob get(String blob, Long generation, BlobGetOption... options) {
    return storage.get(BlobId.of(getName(), blob, generation), options);
  }

  /**
   * Returns a list of requested blobs in this bucket. Blobs that do not exist are null.
   *
   * <p>Example of getting some blobs in the bucket, using a batch request.
   *
   * <pre>{@code
   * String blobName1 = "my_blob_name1";
   * String blobName2 = "my_blob_name2";
   * List<Blob> blobs = bucket.get(blobName1, blobName2);
   * for (Blob blob : blobs) {
   *   if (blob == null) {
   *     // the blob was not found
   *   }
   * }
   * }</pre>
   *
   * @param blobName1 first blob to get
   * @param blobName2 second blob to get
   * @param blobNames other blobs to get
   * @return an immutable list of {@code Blob} objects
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  public List<Blob> get(String blobName1, String blobName2, String... blobNames) {
    List<BlobId> blobIds = Lists.newArrayListWithCapacity(blobNames.length + 2);
    blobIds.add(BlobId.of(getName(), blobName1));
    blobIds.add(BlobId.of(getName(), blobName2));
    for (String blobName : blobNames) {
      blobIds.add(BlobId.of(getName(), blobName));
    }
    return storage.get(blobIds);
  }

  /**
   * Returns a list of requested blobs in this bucket. Blobs that do not exist are null.
   *
   * <p>Example of getting some blobs in the bucket, using a batch request.
   *
   * <pre>{@code
   * String blobName1 = "my_blob_name1";
   * String blobName2 = "my_blob_name2";
   * List<String> blobNames = new LinkedList<>();
   * blobNames.add(blobName1);
   * blobNames.add(blobName2);
   * List<Blob> blobs = bucket.get(blobNames);
   * for (Blob blob : blobs) {
   *   if (blob == null) {
   *     // the blob was not found
   *   }
   * }
   * }</pre>
   *
   * @param blobNames blobs to get
   * @return an immutable list of {@code Blob} objects
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  public List<Blob> get(Iterable<String> blobNames) {
    ImmutableList.Builder<BlobId> builder = ImmutableList.builder();
    for (String blobName : blobNames) {
      builder.add(BlobId.of(getName(), blobName));
    }
    return storage.get(builder.build());
  }

  /**
   * Creates a new blob in this bucket. Direct upload is used to upload {@code content}. For large
   * content, {@link Blob#writer(com.google.cloud.storage.Storage.BlobWriteOption...)} is
   * recommended as it uses resumable upload. MD5 and CRC32C hashes of {@code content} are computed
   * and used for validating transferred data.
   *
   * <p>Example of creating a blob in the bucket from a byte array with a content type.
   *
   * <pre>{@code
   * String blobName = "my_blob_name";
   * Blob blob = bucket.create(blobName, "Hello, World!".getBytes(UTF_8), "text/plain");
   * }</pre>
   *
   * @param blob a blob name
   * @param content the blob content
   * @param contentType the blob content type
   * @param options options for blob creation
   * @return a complete blob information
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Blob create(String blob, byte[] content, String contentType, BlobTargetOption... options) {
    BlobInfo blobInfo =
        BlobInfo.newBuilder(BlobId.of(getName(), blob)).setContentType(contentType).build();
    Storage.BlobTargetOption[] targetOptions = BlobTargetOption.toTargetOptions(blobInfo, options);
    return storage.create(blobInfo, content, targetOptions);
  }

  /**
   * Creates a new blob in this bucket. Direct upload is used to upload {@code content}. For large
   * content, {@link Blob#writer(com.google.cloud.storage.Storage.BlobWriteOption...)} is
   * recommended as it uses resumable upload.
   *
   * <p>Example of creating a blob in the bucket from an input stream with a content type.
   *
   * <pre>{@code
   * String blobName = "my_blob_name";
   * InputStream content = new ByteArrayInputStream("Hello, World!".getBytes(UTF_8));
   * Blob blob = bucket.create(blobName, content, "text/plain");
   * }</pre>
   *
   * @param blob a blob name
   * @param content the blob content as a stream
   * @param contentType the blob content type
   * @param options options for blob creation
   * @return a complete blob information
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Blob create(
      String blob, InputStream content, String contentType, BlobWriteOption... options) {
    BlobInfo blobInfo =
        BlobInfo.newBuilder(BlobId.of(getName(), blob)).setContentType(contentType).build();
    Storage.BlobWriteOption[] writeOptions = BlobWriteOption.toWriteOptions(blobInfo, options);
    return storage.create(blobInfo, content, writeOptions);
  }

  /**
   * Creates a new blob in this bucket. Direct upload is used to upload {@code content}. For large
   * content, {@link Blob#writer(com.google.cloud.storage.Storage.BlobWriteOption...)} is
   * recommended as it uses resumable upload. MD5 and CRC32C hashes of {@code content} are computed
   * and used for validating transferred data.
   *
   * <p>Example of creating a blob in the bucket from a byte array.
   *
   * <pre>{@code
   * String blobName = "my_blob_name";
   * Blob blob = bucket.create(blobName, "Hello, World!".getBytes(UTF_8));
   * }</pre>
   *
   * @param blob a blob name
   * @param content the blob content
   * @param options options for blob creation
   * @return a complete blob information
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Blob create(String blob, byte[] content, BlobTargetOption... options) {
    BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(getName(), blob)).build();
    Storage.BlobTargetOption[] targetOptions = BlobTargetOption.toTargetOptions(blobInfo, options);
    return storage.create(blobInfo, content, targetOptions);
  }

  /**
   * Creates a new blob in this bucket. Direct upload is used to upload {@code content}. For large
   * content, {@link Blob#writer(com.google.cloud.storage.Storage.BlobWriteOption...)} is
   * recommended as it uses resumable upload.
   *
   * <p>Example of creating a blob in the bucket from an input stream.
   *
   * <pre>{@code
   * String blobName = "my_blob_name";
   * InputStream content = new ByteArrayInputStream("Hello, World!".getBytes(UTF_8));
   * Blob blob = bucket.create(blobName, content);
   * }</pre>
   *
   * @param blob a blob name
   * @param content the blob content as a stream
   * @param options options for blob creation
   * @return a complete blob information
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Blob create(String blob, InputStream content, BlobWriteOption... options) {
    BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(getName(), blob)).build();
    Storage.BlobWriteOption[] write = BlobWriteOption.toWriteOptions(blobInfo, options);
    return storage.create(blobInfo, content, write);
  }

  /**
   * Returns the ACL entry for the specified entity on this bucket or {@code null} if not found.
   *
   * <p>Example of getting the ACL entry for an entity.
   *
   * <pre>{@code
   * Acl acl = bucket.getAcl(User.ofAllAuthenticatedUsers());
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Acl getAcl(Entity entity) {
    return storage.getAcl(getName(), entity);
  }

  /**
   * Deletes the ACL entry for the specified entity on this bucket.
   *
   * <p>Example of deleting the ACL entry for an entity.
   *
   * <pre>{@code
   * boolean deleted = bucket.deleteAcl(User.ofAllAuthenticatedUsers());
   * if (deleted) {
   *   // the acl entry was deleted
   * } else {
   *   // the acl entry was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the ACL was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public boolean deleteAcl(Entity entity) {
    return storage.deleteAcl(getName(), entity);
  }

  /**
   * Creates a new ACL entry on this bucket.
   *
   * <p>Example of creating a new ACL entry.
   *
   * <pre>{@code
   * Acl acl = bucket.createAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.READER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Acl createAcl(Acl acl) {
    return storage.createAcl(getName(), acl);
  }

  /**
   * Updates an ACL entry on this bucket.
   *
   * <p>Example of updating a new ACL entry.
   *
   * <pre>{@code
   * Acl acl = bucket.updateAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.OWNER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Acl updateAcl(Acl acl) {
    return storage.updateAcl(getName(), acl);
  }

  /**
   * Lists the ACL entries for this bucket.
   *
   * <p>Example of listing the ACL entries.
   *
   * <pre>{@code
   * List<Acl> acls = bucket.listAcls();
   * for (Acl acl : acls) {
   *   // do something with ACL entry
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public List<Acl> listAcls() {
    return storage.listAcls(getName());
  }

  /**
   * Returns the default object ACL entry for the specified entity on this bucket or {@code null} if
   * not found.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of getting the default ACL entry for an entity.
   *
   * <pre>{@code
   * Acl acl = bucket.getDefaultAcl(User.ofAllAuthenticatedUsers());
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Acl getDefaultAcl(Entity entity) {
    return storage.getDefaultAcl(getName(), entity);
  }

  /**
   * Deletes the default object ACL entry for the specified entity on this bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of deleting the default ACL entry for an entity.
   *
   * <pre>{@code
   * boolean deleted = bucket.deleteDefaultAcl(User.ofAllAuthenticatedUsers());
   * if (deleted) {
   *   // the acl entry was deleted
   * } else {
   *   // the acl entry was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the ACL was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public boolean deleteDefaultAcl(Entity entity) {
    return storage.deleteDefaultAcl(getName(), entity);
  }

  /**
   * Creates a new default blob ACL entry on this bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of creating a new default ACL entry.
   *
   * <pre>{@code
   * Acl acl = bucket.createDefaultAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.READER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Acl createDefaultAcl(Acl acl) {
    return storage.createDefaultAcl(getName(), acl);
  }

  /**
   * Updates a default blob ACL entry on this bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of updating a new default ACL entry.
   *
   * <pre>{@code
   * Acl acl = bucket.updateDefaultAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.OWNER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Acl updateDefaultAcl(Acl acl) {
    return storage.updateDefaultAcl(getName(), acl);
  }

  /**
   * Lists the default blob ACL entries for this bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of listing the default ACL entries.
   *
   * <pre>{@code
   * List<Acl> acls = bucket.listDefaultAcls();
   * for (Acl acl : acls) {
   *   // do something with ACL entry
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public List<Acl> listDefaultAcls() {
    return storage.listDefaultAcls(getName());
  }

  /**
   * Locks bucket retention policy. Requires a local metageneration value in the request. Review
   * example below.
   *
   * <p>Accepts an optional userProject {@link BucketTargetOption} option which defines the project
   * id to assign operational costs.
   *
   * <p>Warning: Once a retention policy is locked, it can't be unlocked, removed, or shortened.
   *
   * <p>Example of locking a retention policy on a bucket, only if its local metageneration value
   * matches the bucket's service metageneration otherwise a {@link StorageException} is thrown.
   *
   * <pre>{@code
   * String bucketName = "my_unique_bucket";
   * Bucket bucket = storage.get(bucketName, BucketGetOption.fields(BucketField.METAGENERATION));
   * storage.lockRetentionPolicy(bucket, BucketTargetOption.metagenerationMatch());
   * }</pre>
   *
   * @return a {@code Bucket} object of the locked bucket
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  public Bucket lockRetentionPolicy(BucketTargetOption... options) {
    return storage.lockRetentionPolicy(this, options);
  }

  /** Returns the bucket's {@code Storage} object used to issue requests. */
  public Storage getStorage() {
    return storage;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Bucket.class)) {
      return false;
    }
    Bucket other = (Bucket) obj;
    return super.equals(other) && Objects.equals(options, other.options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  /**
   * Drop the held {@link Storage} instance.
   *
   * @since 2.14.0
   */
  public BucketInfo asBucketInfo() {
    return this.toBuilder().infoBuilder.build();
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.storage = options.getService();
  }
}
