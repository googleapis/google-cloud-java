/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.storage.Storage.BucketField.IP_FILTER;
import static com.google.cloud.storage.Storage.BucketField.SOFT_DELETE_POLICY;
import static com.google.cloud.storage.Utils.bucketNameCodec;
import static com.google.cloud.storage.Utils.ifNonNull;
import static com.google.cloud.storage.Utils.lift;
import static com.google.cloud.storage.Utils.projectNumberResourceCodec;

import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.Binding;
import com.google.cloud.Condition;
import com.google.cloud.Policy;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.BlobInfo.CustomerEncryption;
import com.google.cloud.storage.BucketInfo.CustomPlacementConfig;
import com.google.cloud.storage.BucketInfo.CustomerManagedEncryptionEnforcementConfig;
import com.google.cloud.storage.BucketInfo.CustomerSuppliedEncryptionEnforcementConfig;
import com.google.cloud.storage.BucketInfo.EncryptionEnforcementRestrictionMode;
import com.google.cloud.storage.BucketInfo.GoogleManagedEncryptionEnforcementConfig;
import com.google.cloud.storage.BucketInfo.IpFilter;
import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule.AbortIncompleteMPUAction;
import com.google.cloud.storage.BucketInfo.Logging;
import com.google.cloud.storage.BucketInfo.PublicAccessPrevention;
import com.google.cloud.storage.Conversions.Codec;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.Timestamp;
import com.google.storage.v2.Bucket;
import com.google.storage.v2.Bucket.Billing;
import com.google.storage.v2.Bucket.Encryption;
import com.google.storage.v2.Bucket.IpFilter.PublicNetworkSource;
import com.google.storage.v2.Bucket.IpFilter.VpcNetworkSource;
import com.google.storage.v2.Bucket.Website;
import com.google.storage.v2.BucketAccessControl;
import com.google.storage.v2.CryptoKeyName;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectAccessControl;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.ObjectContexts;
import com.google.storage.v2.ObjectCustomContextPayload;
import com.google.storage.v2.Owner;
import com.google.type.Date;
import com.google.type.Expr;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.Nullable;

final class GrpcConversions {
  static final GrpcConversions INSTANCE = new GrpcConversions();

  private final Codec<Acl.Entity, String> entityCodec =
      Codec.of(this::entityEncode, this::entityDecode);
  private final Codec<Acl, ObjectAccessControl> objectAclCodec =
      Codec.of(this::objectAclEncode, this::objectAclDecode);
  private final Codec<Acl, BucketAccessControl> bucketAclCodec =
      Codec.of(this::bucketAclEncode, this::bucketAclDecode);
  private final Codec<Cors, Bucket.Cors> corsCodec = Codec.of(this::corsEncode, this::corsDecode);
  private final Codec<BucketInfo.Logging, Bucket.Logging> loggingCodec =
      Codec.of(this::loggingEncode, this::loggingDecode);
  private final Codec<BucketInfo.IamConfiguration, Bucket.IamConfig> iamConfigurationCodec =
      Codec.of(this::iamConfigEncode, this::iamConfigDecode);
  private final Codec<BucketInfo.Autoclass, Bucket.Autoclass> autoclassCodec =
      Codec.of(this::autoclassEncode, this::autoclassDecode);

  private final Codec<BucketInfo.SoftDeletePolicy, Bucket.SoftDeletePolicy> softDeletePolicyCodec =
      Codec.of(this::softDeletePolicyEncode, this::softDeletePolicyDecode);
  private final Codec<BucketInfo.LifecycleRule, Bucket.Lifecycle.Rule> lifecycleRuleCodec =
      Codec.of(this::lifecycleRuleEncode, this::lifecycleRuleDecode);
  private final Codec<BucketInfo, Bucket> bucketInfoCodec =
      Codec.of(this::bucketInfoEncode, this::bucketInfoDecode);
  private final Codec<CustomerEncryption, com.google.storage.v2.CustomerEncryption>
      customerEncryptionCodec =
          Codec.of(this::customerEncryptionEncode, this::customerEncryptionDecode);
  private final Codec<BlobId, Object> blobIdCodec =
      Codec.of(this::blobIdEncode, this::blobIdDecode);
  private final Codec<BlobInfo, Object> blobInfoCodec =
      Codec.of(this::blobInfoEncode, this::blobInfoDecode);
  private final Codec<Policy, com.google.iam.v1.Policy> policyCodec =
      Codec.of(this::policyEncode, this::policyDecode);
  private final Codec<Binding, com.google.iam.v1.Binding> bindingCodec =
      Codec.of(this::bindingEncode, this::bindingDecode);
  private final Codec<Condition, Expr> iamConditionCodec =
      Codec.of(this::conditionEncode, this::conditionDecode);

  private final Codec<BucketInfo.HierarchicalNamespace, Bucket.HierarchicalNamespace>
      hierarchicalNamespaceCodec =
          Codec.of(this::hierarchicalNamespaceEncode, this::hierarchicalNamespaceDecode);

  private final Codec<BucketInfo.IpFilter, Bucket.IpFilter> ipFilterCodec =
      Codec.of(this::ipFilterEncode, this::ipFilterDecode);
  private final Codec<BucketInfo.IpFilter.PublicNetworkSource, Bucket.IpFilter.PublicNetworkSource>
      publicNetworkSourceCodec =
          Codec.of(this::publicNetworkSourceEncode, this::publicNetworkSourceDecode);
  private final Codec<BucketInfo.IpFilter.VpcNetworkSource, Bucket.IpFilter.VpcNetworkSource>
      vpcNetworkSourceCodec = Codec.of(this::vpcNetworkSourceEncode, this::vpcNetworkSourceDecode);

  private final Codec<ByteString, String> byteStringB64StringCodec =
      Codec.of(
          bs -> Base64.getEncoder().encodeToString(bs.toByteArray()),
          s -> ByteString.copyFrom(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))));

  private final Codec<BlobInfo.ObjectContexts, ObjectContexts> objectContextsCodec =
      Codec.of(this::objectContextsEncode, this::objectContextsDecode);
  private final Codec<BlobInfo.ObjectCustomContextPayload, ObjectCustomContextPayload>
      customContextPayloadCodec =
          Codec.of(this::objectCustomContextPayloadEncode, this::objectCustomContextPayloadDecode);

  @VisibleForTesting
  final Codec<OffsetDateTime, Timestamp> timestampCodec =
      Codec.of(
          odt ->
              Timestamp.newBuilder()
                  .setSeconds(odt.toEpochSecond())
                  .setNanos(odt.getNano())
                  .build(),
          t ->
              Instant.ofEpochSecond(t.getSeconds())
                  .plusNanos(t.getNanos())
                  .atOffset(ZoneOffset.UTC));

  @VisibleForTesting
  final Codec<Duration, com.google.protobuf.Duration> durationCodec =
      Codec.of(
          javaDuration ->
              com.google.protobuf.Duration.newBuilder()
                  .setSeconds(javaDuration.getSeconds())
                  .setNanos(javaDuration.getNano())
                  .build(),
          protoDuration ->
              Duration.ofSeconds(protoDuration.getSeconds()).plusNanos(protoDuration.getNanos()));

  @VisibleForTesting
  final Codec<OffsetDateTime, Date> odtDateCodec =
      Codec.of(
          odt -> {
            OffsetDateTime utc = odt.withOffsetSameInstant(ZoneOffset.UTC);
            return Date.newBuilder()
                .setYear(utc.getYear())
                .setMonth(utc.getMonthValue())
                .setDay(utc.getDayOfMonth())
                .build();
          },
          d ->
              LocalDate.of(d.getYear(), d.getMonth(), d.getDay())
                  .atStartOfDay()
                  .atOffset(ZoneOffset.UTC));

  private final Codec<EncryptionEnforcementRestrictionMode, String>
      encryptionEnforcementRestrictionModeCodec =
          Codec.of(
              EncryptionEnforcementRestrictionMode::toString,
              EncryptionEnforcementRestrictionMode::valueOf);
  private final Codec<
          GoogleManagedEncryptionEnforcementConfig,
          Encryption.GoogleManagedEncryptionEnforcementConfig>
      googleManagedEncryptionEnforcementConfigCodec =
          Codec.of(
              from -> {
                Encryption.GoogleManagedEncryptionEnforcementConfig.Builder to =
                    Encryption.GoogleManagedEncryptionEnforcementConfig.newBuilder();
                ifNonNull(
                    from.getRestrictionMode(),
                    encryptionEnforcementRestrictionModeCodec::encode,
                    to::setRestrictionMode);
                ifNonNull(from.getEffectiveTime(), timestampCodec::encode, to::setEffectiveTime);
                return to.build();
              },
              from -> {
                @Nullable EncryptionEnforcementRestrictionMode mode = null;
                if (from.hasRestrictionMode()) {
                  mode =
                      encryptionEnforcementRestrictionModeCodec.decode(from.getRestrictionMode());
                }
                if (from.hasEffectiveTime()) {
                  return GoogleManagedEncryptionEnforcementConfig.of(
                      mode, timestampCodec.decode(from.getEffectiveTime()));
                }
                return GoogleManagedEncryptionEnforcementConfig.of(mode);
              });
  private final Codec<
          CustomerManagedEncryptionEnforcementConfig,
          Encryption.CustomerManagedEncryptionEnforcementConfig>
      customerManagedEncryptionEnforcementConfigCodec =
          Codec.of(
              from -> {
                Encryption.CustomerManagedEncryptionEnforcementConfig.Builder to =
                    Encryption.CustomerManagedEncryptionEnforcementConfig.newBuilder();
                ifNonNull(
                    from.getRestrictionMode(),
                    encryptionEnforcementRestrictionModeCodec::encode,
                    to::setRestrictionMode);
                ifNonNull(from.getEffectiveTime(), timestampCodec::encode, to::setEffectiveTime);
                return to.build();
              },
              from -> {
                @Nullable EncryptionEnforcementRestrictionMode mode = null;
                if (from.hasRestrictionMode()) {
                  mode =
                      encryptionEnforcementRestrictionModeCodec.decode(from.getRestrictionMode());
                }
                if (from.hasEffectiveTime()) {
                  return CustomerManagedEncryptionEnforcementConfig.of(
                      mode, timestampCodec.decode(from.getEffectiveTime()));
                }
                return CustomerManagedEncryptionEnforcementConfig.of(mode);
              });
  private final Codec<
          CustomerSuppliedEncryptionEnforcementConfig,
          Encryption.CustomerSuppliedEncryptionEnforcementConfig>
      customerSuppliedEncryptionEnforcementConfigCodec =
          Codec.of(
              from -> {
                Encryption.CustomerSuppliedEncryptionEnforcementConfig.Builder to =
                    Encryption.CustomerSuppliedEncryptionEnforcementConfig.newBuilder();
                ifNonNull(
                    from.getRestrictionMode(),
                    encryptionEnforcementRestrictionModeCodec::encode,
                    to::setRestrictionMode);
                ifNonNull(from.getEffectiveTime(), timestampCodec::encode, to::setEffectiveTime);
                return to.build();
              },
              from -> {
                @Nullable EncryptionEnforcementRestrictionMode mode = null;
                if (from.hasRestrictionMode()) {
                  mode =
                      encryptionEnforcementRestrictionModeCodec.decode(from.getRestrictionMode());
                }
                if (from.hasEffectiveTime()) {
                  return CustomerSuppliedEncryptionEnforcementConfig.of(
                      mode, timestampCodec.decode(from.getEffectiveTime()));
                }
                return CustomerSuppliedEncryptionEnforcementConfig.of(mode);
              });

  private GrpcConversions() {}

  Codec<Acl.Entity, String> entity() {
    return entityCodec;
  }

  Codec<Acl, ObjectAccessControl> objectAcl() {
    return objectAclCodec;
  }

  Codec<Acl, BucketAccessControl> bucketAcl() {
    return bucketAclCodec;
  }

  Codec<Cors, Bucket.Cors> cors() {
    return corsCodec;
  }

  Codec<BucketInfo.Logging, Bucket.Logging> logging() {
    return loggingCodec;
  }

  Codec<BucketInfo.IamConfiguration, Bucket.IamConfig> iamConfiguration() {
    return iamConfigurationCodec;
  }

  Codec<BucketInfo.LifecycleRule, Bucket.Lifecycle.Rule> lifecycleRule() {
    return lifecycleRuleCodec;
  }

  Codec<BucketInfo, Bucket> bucketInfo() {
    return bucketInfoCodec;
  }

  Codec<CustomerEncryption, com.google.storage.v2.CustomerEncryption> customerEncryption() {
    return customerEncryptionCodec;
  }

  Codec<BlobId, Object> blobId() {
    return blobIdCodec;
  }

  Codec<BlobInfo, Object> blobInfo() {
    return blobInfoCodec;
  }

  Codec<Policy, com.google.iam.v1.Policy> policyCodec() {
    return policyCodec;
  }

  private BucketInfo bucketInfoDecode(Bucket from) {
    BucketInfo.Builder to = new BucketInfo.BuilderImpl(bucketNameCodec.decode(from.getName()));
    if (!from.getProject().isEmpty()) {
      to.setProject(projectNumberResourceCodec.decode(from.getProject()));
    }
    to.setGeneratedId(from.getBucketId());
    maybeDecodeRetentionPolicy(from, to);
    ifNonNull(from.getLocation(), to::setLocation);
    ifNonNull(from.getLocationType(), to::setLocationType);
    ifNonNull(from.getMetageneration(), to::setMetageneration);
    if (from.hasBilling()) {
      Billing billing = from.getBilling();
      to.setRequesterPays(billing.getRequesterPays());
    }
    if (from.hasCreateTime()) {
      to.setCreateTimeOffsetDateTime(timestampCodec.decode(from.getCreateTime()));
    }
    if (from.hasUpdateTime()) {
      to.setUpdateTimeOffsetDateTime(timestampCodec.decode(from.getUpdateTime()));
    }
    if (from.hasEncryption()) {
      Encryption e = from.getEncryption();
      if (!e.getDefaultKmsKey().isEmpty()) {
        to.setDefaultKmsKeyName(e.getDefaultKmsKey());
      }
      if (e.hasGoogleManagedEncryptionEnforcementConfig()) {
        to.setGoogleManagedEncryptionEnforcementConfig(
            googleManagedEncryptionEnforcementConfigCodec.decode(
                e.getGoogleManagedEncryptionEnforcementConfig()));
      }
      if (e.hasCustomerManagedEncryptionEnforcementConfig()) {
        to.setCustomerManagedEncryptionEnforcementConfig(
            customerManagedEncryptionEnforcementConfigCodec.decode(
                e.getCustomerManagedEncryptionEnforcementConfig()));
      }
      if (e.hasCustomerSuppliedEncryptionEnforcementConfig()) {
        to.setCustomerSuppliedEncryptionEnforcementConfig(
            customerSuppliedEncryptionEnforcementConfigCodec.decode(
                e.getCustomerSuppliedEncryptionEnforcementConfig()));
      }
    }
    if (!from.getRpo().isEmpty()) {
      to.setRpo(Rpo.valueOf(from.getRpo()));
    }
    if (!from.getStorageClass().isEmpty()) {
      to.setStorageClass(StorageClass.valueOf(from.getStorageClass()));
    }
    if (from.hasVersioning()) {
      to.setVersioningEnabled(from.getVersioning().getEnabled());
    }
    ifNonNull(from.getDefaultEventBasedHold(), to::setDefaultEventBasedHold);
    Map<String, String> labelsMap = from.getLabelsMap();
    if (!labelsMap.isEmpty()) {
      to.setLabels(labelsMap);
    }
    if (from.hasWebsite()) {
      Website website = from.getWebsite();
      String mainPageSuffix = website.getMainPageSuffix();
      if (!mainPageSuffix.isEmpty()) {
        to.setIndexPage(mainPageSuffix);
      }
      String notFoundPage = website.getNotFoundPage();
      if (!notFoundPage.isEmpty()) {
        to.setNotFoundPage(notFoundPage);
      }
    }
    if (from.hasLifecycle()) {
      to.setLifecycleRules(
          toImmutableListOf(lifecycleRuleCodec::decode).apply(from.getLifecycle().getRuleList()));
    }
    List<Bucket.Cors> corsList = from.getCorsList();
    if (!corsList.isEmpty()) {
      to.setCors(toImmutableListOf(corsCodec::decode).apply(corsList));
    }
    if (from.hasLogging()) {
      Bucket.Logging logging = from.getLogging();
      if (!logging.getLogBucket().isEmpty() || !logging.getLogObjectPrefix().isEmpty()) {
        to.setLogging(loggingCodec.decode(logging));
      }
    }
    if (from.hasOwner()) {
      to.setOwner(entityCodec.decode(from.getOwner().getEntity()));
    }

    List<ObjectAccessControl> defaultObjectAclList = from.getDefaultObjectAclList();
    if (!defaultObjectAclList.isEmpty()) {
      to.setDefaultAcl(toImmutableListOf(objectAclCodec::decode).apply(defaultObjectAclList));
    }
    List<BucketAccessControl> bucketAclList = from.getAclList();
    if (!bucketAclList.isEmpty()) {
      to.setAcl(toImmutableListOf(bucketAclCodec::decode).apply(bucketAclList));
    }
    if (from.hasIamConfig()) {
      to.setIamConfiguration(iamConfigurationCodec.decode(from.getIamConfig()));
    }
    if (from.hasAutoclass()) {
      to.setAutoclass(autoclassCodec.decode(from.getAutoclass()));
    }
    if (from.hasSoftDeletePolicy()) {
      to.setSoftDeletePolicy(softDeletePolicyCodec.decode(from.getSoftDeletePolicy()));
    }
    if (from.hasCustomPlacementConfig()) {
      Bucket.CustomPlacementConfig customPlacementConfig = from.getCustomPlacementConfig();
      to.setCustomPlacementConfig(
          CustomPlacementConfig.newBuilder()
              .setDataLocations(customPlacementConfig.getDataLocationsList())
              .build());
    }
    if (from.hasHierarchicalNamespace()) {
      to.setHierarchicalNamespace(
          hierarchicalNamespaceCodec.decode(from.getHierarchicalNamespace()));
    }
    if (from.hasIpFilter()) {
      to.setIpFilter(ipFilterCodec.decode(from.getIpFilter()));
    }
    if (!from.getEtag().isEmpty()) {
      to.setEtag(from.getEtag());
    }
    return to.build();
  }

  private Bucket bucketInfoEncode(BucketInfo from) {
    Bucket.Builder to = Bucket.newBuilder();
    to.setName(bucketNameCodec.encode(from.getName()));
    ifNonNull(from.getProject(), projectNumberResourceCodec::encode, to::setProject);
    ifNonNull(from.getGeneratedId(), to::setBucketId);
    maybeEncodeRetentionPolicy(from, to);
    ifNonNull(from.getLocation(), to::setLocation);
    ifNonNull(from.getLocationType(), to::setLocationType);
    ifNonNull(from.getMetageneration(), to::setMetageneration);
    if (from.requesterPays() != null) {
      Bucket.Billing.Builder billingBuilder = Billing.newBuilder();
      ifNonNull(from.requesterPays(), billingBuilder::setRequesterPays);
      to.setBilling(billingBuilder.build());
    }
    ifNonNull(from.getCreateTimeOffsetDateTime(), timestampCodec::encode, to::setCreateTime);
    ifNonNull(from.getUpdateTimeOffsetDateTime(), timestampCodec::encode, to::setUpdateTime);
    if (Stream.of(
            from.getDefaultKmsKeyName(),
            from.getGoogleManagedEncryptionEnforcementConfig(),
            from.getCustomerManagedEncryptionEnforcementConfig(),
            from.getCustomerSuppliedEncryptionEnforcementConfig())
        .anyMatch(Objects::nonNull)) {
      Bucket.Encryption.Builder encryptionBuilder = Bucket.Encryption.newBuilder();
      ifNonNull(from.getDefaultKmsKeyName(), encryptionBuilder::setDefaultKmsKey);
      ifNonNull(
          from.getGoogleManagedEncryptionEnforcementConfig(),
          googleManagedEncryptionEnforcementConfigCodec::encode,
          encryptionBuilder::setGoogleManagedEncryptionEnforcementConfig);
      ifNonNull(
          from.getCustomerManagedEncryptionEnforcementConfig(),
          customerManagedEncryptionEnforcementConfigCodec::encode,
          encryptionBuilder::setCustomerManagedEncryptionEnforcementConfig);
      ifNonNull(
          from.getCustomerSuppliedEncryptionEnforcementConfig(),
          customerSuppliedEncryptionEnforcementConfigCodec::encode,
          encryptionBuilder::setCustomerSuppliedEncryptionEnforcementConfig);
      to.setEncryption(encryptionBuilder.build());
    }
    if (from.getIndexPage() != null || from.getNotFoundPage() != null) {
      Bucket.Website.Builder websiteBuilder = Bucket.Website.newBuilder();
      ifNonNull(from.getIndexPage(), websiteBuilder::setMainPageSuffix);
      ifNonNull(from.getNotFoundPage(), websiteBuilder::setNotFoundPage);
      to.setWebsite(websiteBuilder.build());
    }
    ifNonNull(from.getRpo(), Rpo::toString, to::setRpo);
    ifNonNull(from.getStorageClass(), StorageClass::toString, to::setStorageClass);
    if (from.versioningEnabled() != null) {
      Bucket.Versioning.Builder versioningBuilder = Bucket.Versioning.newBuilder();
      ifNonNull(from.versioningEnabled(), versioningBuilder::setEnabled);
      to.setVersioning(versioningBuilder.build());
    }
    ifNonNull(from.getDefaultEventBasedHold(), to::setDefaultEventBasedHold);
    ifNonNull(from.getLabels(), this::removeNullValues, to::putAllLabels);
    // Do not use, #getLifecycleRules, it can not return null, which is important to our logic here
    List<? extends LifecycleRule> lifecycleRules = from.lifecycleRules;
    if (lifecycleRules != null) {
      Bucket.Lifecycle.Builder lifecycleBuilder = Bucket.Lifecycle.newBuilder();
      if (!lifecycleRules.isEmpty()) {
        ImmutableSet<Bucket.Lifecycle.Rule> set =
            from.getLifecycleRules().stream()
                .map(lifecycleRuleCodec::encode)
                .collect(ImmutableSet.toImmutableSet());
        lifecycleBuilder.addAllRule(ImmutableList.copyOf(set));
      }
      to.setLifecycle(lifecycleBuilder.build());
    }

    Logging logging = from.getLogging();
    if (logging != null) {
      // an empty bucket name is invalid, don't even attempt to encode if neither name or prefix
      // are both empty
      if ((logging.getLogBucket() != null && !logging.getLogBucket().isEmpty())
          || (logging.getLogObjectPrefix() != null && !logging.getLogObjectPrefix().isEmpty())) {
        to.setLogging(loggingCodec.encode(logging));
      }
    }
    ifNonNull(from.getCors(), toImmutableListOf(corsCodec::encode), to::addAllCors);
    ifNonNull(
        from.getOwner(),
        lift(entity()::encode).andThen(o -> Owner.newBuilder().setEntity(o).build()),
        to::setOwner);
    ifNonNull(
        from.getDefaultAcl(),
        toImmutableListOf(objectAclCodec::encode),
        to::addAllDefaultObjectAcl);
    ifNonNull(from.getAcl(), toImmutableListOf(bucketAclCodec::encode), to::addAllAcl);
    ifNonNull(from.getIamConfiguration(), iamConfigurationCodec::encode, to::setIamConfig);
    ifNonNull(from.getAutoclass(), autoclassCodec::encode, to::setAutoclass);
    ifNonNull(from.getSoftDeletePolicy(), softDeletePolicyCodec::encode, to::setSoftDeletePolicy);
    if (from.getModifiedFields().contains(SOFT_DELETE_POLICY)
        && from.getSoftDeletePolicy() == null) {
      to.clearSoftDeletePolicy();
    }
    CustomPlacementConfig customPlacementConfig = from.getCustomPlacementConfig();
    if (customPlacementConfig != null && customPlacementConfig.getDataLocations() != null) {
      to.setCustomPlacementConfig(
          Bucket.CustomPlacementConfig.newBuilder()
              .addAllDataLocations(customPlacementConfig.getDataLocations())
              .build());
    }
    ifNonNull(
        from.getHierarchicalNamespace(),
        hierarchicalNamespaceCodec::encode,
        to::setHierarchicalNamespace);
    ifNonNull(from.getIpFilter(), ipFilterCodec::encode, to::setIpFilter);
    if (from.getModifiedFields().contains(IP_FILTER) && from.getIpFilter() == null) {
      to.clearIpFilter();
    }
    ifNonNull(from.getEtag(), to::setEtag);
    return to.build();
  }

  private void maybeEncodeRetentionPolicy(BucketInfo from, Bucket.Builder to) {
    if (from.getRetentionPeriodDuration() != null
        || from.retentionPolicyIsLocked() != null
        || from.getRetentionEffectiveTimeOffsetDateTime() != null) {
      Bucket.RetentionPolicy.Builder retentionPolicyBuilder = to.getRetentionPolicyBuilder();
      ifNonNull(
          from.getRetentionPeriodDuration(),
          durationCodec::encode,
          retentionPolicyBuilder::setRetentionDuration);
      ifNonNull(from.retentionPolicyIsLocked(), retentionPolicyBuilder::setIsLocked);
      ifNonNull(
          from.getRetentionEffectiveTimeOffsetDateTime(),
          timestampCodec::encode,
          retentionPolicyBuilder::setEffectiveTime);
      to.setRetentionPolicy(retentionPolicyBuilder.build());
    }
  }

  private void maybeDecodeRetentionPolicy(Bucket from, BucketInfo.Builder to) {
    if (from.hasRetentionPolicy()) {
      Bucket.RetentionPolicy retentionPolicy = from.getRetentionPolicy();
      to.setRetentionPolicyIsLocked(retentionPolicy.getIsLocked());
      if (retentionPolicy.hasRetentionDuration()) {
        to.setRetentionPeriodDuration(durationCodec.decode(retentionPolicy.getRetentionDuration()));
      }
      if (retentionPolicy.hasEffectiveTime()) {
        to.setRetentionEffectiveTimeOffsetDateTime(
            timestampCodec.decode(retentionPolicy.getEffectiveTime()));
      }
    }
  }

  private Bucket.Logging loggingEncode(BucketInfo.Logging from) {
    Bucket.Logging.Builder to = Bucket.Logging.newBuilder();
    if (from.getLogObjectPrefix() != null && !from.getLogObjectPrefix().isEmpty()) {
      to.setLogObjectPrefix(from.getLogObjectPrefix());
    }
    ifNonNull(from.getLogBucket(), bucketNameCodec::encode, to::setLogBucket);
    return to.build();
  }

  private BucketInfo.Logging loggingDecode(Bucket.Logging from) {
    BucketInfo.Logging.Builder to = BucketInfo.Logging.newBuilder();
    String logObjectPrefix = from.getLogObjectPrefix();
    if (!logObjectPrefix.isEmpty()) {
      to.setLogObjectPrefix(logObjectPrefix);
    }
    String logBucket = from.getLogBucket();
    if (!logBucket.isEmpty()) {
      to.setLogBucket(bucketNameCodec.decode(logBucket));
    }
    return to.build();
  }

  private Bucket.Cors corsEncode(Cors from) {
    Bucket.Cors.Builder to = Bucket.Cors.newBuilder();
    to.setMaxAgeSeconds(from.getMaxAgeSeconds());
    to.addAllResponseHeader(from.getResponseHeaders());
    ifNonNull(from.getMethods(), toImmutableListOf(java.lang.Object::toString), to::addAllMethod);
    ifNonNull(from.getOrigins(), toImmutableListOf(java.lang.Object::toString), to::addAllOrigin);
    return to.build();
  }

  private Cors corsDecode(Bucket.Cors from) {
    Cors.Builder to = Cors.newBuilder().setMaxAgeSeconds(from.getMaxAgeSeconds());
    ifNonNull(
        from.getMethodList(),
        m ->
            m.stream()
                .map(String::toUpperCase)
                .map(HttpMethod::valueOf)
                .collect(ImmutableList.toImmutableList()),
        to::setMethods);
    ifNonNull(from.getOriginList(), toImmutableListOf(Cors.Origin::of), to::setOrigins);
    to.setResponseHeaders(from.getResponseHeaderList());
    return to.build();
  }

  private String entityEncode(Acl.Entity from) {
    if (from instanceof Acl.RawEntity) {
      return from.getValue();
    } else if (from instanceof Acl.User) {
      switch (from.getValue()) {
        case Acl.User.ALL_AUTHENTICATED_USERS:
          return Acl.User.ALL_AUTHENTICATED_USERS;
        case Acl.User.ALL_USERS:
          return Acl.User.ALL_USERS;
        default:
          break;
      }
    }
    // intentionally not an else so that if the default is hit above it will fall through to here
    return from.getType().name().toLowerCase() + "-" + from.getValue();
  }

  private Acl.Entity entityDecode(String from) {
    if (from.startsWith("user-")) {
      return new Acl.User(from.substring(5));
    }
    if (from.equals(Acl.User.ALL_USERS)) {
      return Acl.User.ofAllUsers();
    }
    if (from.equals(Acl.User.ALL_AUTHENTICATED_USERS)) {
      return Acl.User.ofAllAuthenticatedUsers();
    }
    if (from.startsWith("group-")) {
      return new Acl.Group(from.substring(6));
    }
    if (from.startsWith("domain-")) {
      return new Acl.Domain(from.substring(7));
    }
    if (from.startsWith("project-")) {
      int idx = from.indexOf('-', 8);
      String team = from.substring(8, idx);
      String projectId = from.substring(idx + 1);
      return new Acl.Project(Acl.Project.ProjectRole.valueOf(team.toUpperCase()), projectId);
    }
    return new Acl.RawEntity(from);
  }

  private Acl objectAclDecode(ObjectAccessControl from) {
    Acl.Role role = Acl.Role.valueOf(from.getRole());
    Acl.Entity entity = entityCodec.decode(from.getEntity());
    Acl.Builder to = Acl.newBuilder(entity, role);
    if (!from.getId().isEmpty()) {
      to.setId(from.getId());
    }
    if (!from.getEtag().isEmpty()) {
      to.setEtag(from.getEtag());
    }
    return to.build();
  }

  private ObjectAccessControl objectAclEncode(Acl from) {
    ObjectAccessControl.Builder to = ObjectAccessControl.newBuilder();
    ifNonNull(from.getEntity(), entityCodec::encode, to::setEntity);
    ifNonNull(from.getRole(), Role::name, to::setRole);
    ifNonNull(from.getId(), to::setId);
    ifNonNull(from.getEtag(), to::setEtag);
    return to.build();
  }

  private Acl bucketAclDecode(com.google.storage.v2.BucketAccessControl from) {
    Role role = Role.valueOf(from.getRole());
    Entity entity = entityDecode(from.getEntity());
    Acl.Builder to = Acl.newBuilder(entity, role).setId(from.getId());
    if (!from.getEtag().isEmpty()) {
      to.setEtag(from.getEtag());
    }
    return to.build();
  }

  private com.google.storage.v2.BucketAccessControl bucketAclEncode(Acl from) {
    BucketAccessControl.Builder to = BucketAccessControl.newBuilder();
    ifNonNull(from.getEntity(), entityCodec::encode, to::setEntity);
    ifNonNull(from.getRole(), Role::toString, to::setRole);
    ifNonNull(from.getId(), to::setId);
    ifNonNull(from.getEtag(), to::setEtag);
    return to.build();
  }

  private Bucket.IamConfig.UniformBucketLevelAccess ublaEncode(BucketInfo.IamConfiguration from) {
    Bucket.IamConfig.UniformBucketLevelAccess.Builder to =
        Bucket.IamConfig.UniformBucketLevelAccess.newBuilder();
    ifNonNull(from.isUniformBucketLevelAccessEnabled(), to::setEnabled);
    if (from.isUniformBucketLevelAccessEnabled() == Boolean.TRUE) {
      ifNonNull(
          from.getUniformBucketLevelAccessLockedTimeOffsetDateTime(),
          timestampCodec::encode,
          to::setLockTime);
    }
    return to.build();
  }

  private BucketInfo.Autoclass autoclassDecode(Bucket.Autoclass from) {
    BucketInfo.Autoclass.Builder to = BucketInfo.Autoclass.newBuilder();
    to.setEnabled(from.getEnabled());
    ifNonNull(from.getToggleTime(), timestampCodec::decode, to::setToggleTime);

    String terminalStorageClass = from.getTerminalStorageClass();
    if (!terminalStorageClass.isEmpty()) {
      to.setTerminalStorageClass(StorageClass.valueOf(terminalStorageClass));
    }
    ifNonNull(
        from.getTerminalStorageClassUpdateTime(),
        timestampCodec::decode,
        to::setTerminalStorageClassUpdateTime);
    return to.build();
  }

  private Bucket.Autoclass autoclassEncode(BucketInfo.Autoclass from) {
    Bucket.Autoclass.Builder to = Bucket.Autoclass.newBuilder();
    ifNonNull(from.getEnabled(), to::setEnabled);
    ifNonNull(from.getToggleTime(), timestampCodec::encode, to::setToggleTime);
    ifNonNull(from.getTerminalStorageClass(), StorageClass::toString, to::setTerminalStorageClass);
    ifNonNull(
        from.getTerminalStorageClassUpdateTime(),
        timestampCodec::encode,
        to::setTerminalStorageClassUpdateTime);
    return to.build();
  }

  private BucketInfo.SoftDeletePolicy softDeletePolicyDecode(Bucket.SoftDeletePolicy from) {
    BucketInfo.SoftDeletePolicy.Builder to = BucketInfo.SoftDeletePolicy.newBuilder();
    ifNonNull(from.getRetentionDuration(), durationCodec::decode, to::setRetentionDuration);
    ifNonNull(from.getEffectiveTime(), timestampCodec::decode, to::setEffectiveTime);
    return to.build();
  }

  private Bucket.SoftDeletePolicy softDeletePolicyEncode(BucketInfo.SoftDeletePolicy from) {
    Bucket.SoftDeletePolicy.Builder to = Bucket.SoftDeletePolicy.newBuilder();
    ifNonNull(from.getRetentionDuration(), durationCodec::encode, to::setRetentionDuration);
    return to.build();
  }

  private Bucket.HierarchicalNamespace hierarchicalNamespaceEncode(
      BucketInfo.HierarchicalNamespace from) {
    Bucket.HierarchicalNamespace.Builder to = Bucket.HierarchicalNamespace.newBuilder();
    ifNonNull(from.getEnabled(), to::setEnabled);
    return to.build();
  }

  private BucketInfo.HierarchicalNamespace hierarchicalNamespaceDecode(
      Bucket.HierarchicalNamespace from) {
    BucketInfo.HierarchicalNamespace.Builder to = BucketInfo.HierarchicalNamespace.newBuilder();
    to.setEnabled(from.getEnabled());
    return to.build();
  }

  private Bucket.IamConfig iamConfigEncode(BucketInfo.IamConfiguration from) {
    Bucket.IamConfig.Builder to = Bucket.IamConfig.newBuilder();
    to.setUniformBucketLevelAccess(ublaEncode(from));
    if (from.getPublicAccessPrevention() != null) {
      ifNonNull(from.getPublicAccessPrevention().getValue(), to::setPublicAccessPrevention);
    }
    return to.build();
  }

  private BucketInfo.IamConfiguration iamConfigDecode(Bucket.IamConfig from) {
    Bucket.IamConfig.UniformBucketLevelAccess ubla = from.getUniformBucketLevelAccess();

    BucketInfo.IamConfiguration.Builder to = BucketInfo.IamConfiguration.newBuilder();
    ifNonNull(ubla.getEnabled(), to::setIsUniformBucketLevelAccessEnabled);
    if (ubla.hasLockTime()) {
      to.setUniformBucketLevelAccessLockedTimeOffsetDateTime(
          timestampCodec.decode(ubla.getLockTime()));
    }
    if (!from.getPublicAccessPrevention().isEmpty()) {
      to.setPublicAccessPrevention(PublicAccessPrevention.parse(from.getPublicAccessPrevention()));
    }
    return to.build();
  }

  private Bucket.Lifecycle.Rule lifecycleRuleEncode(BucketInfo.LifecycleRule from) {
    Bucket.Lifecycle.Rule.Builder to = Bucket.Lifecycle.Rule.newBuilder();
    to.setAction(ruleActionEncode(from.getAction()));
    to.setCondition(ruleConditionEncode(from.getCondition()));
    return to.build();
  }

  private Bucket.Lifecycle.Rule.Condition ruleConditionEncode(
      BucketInfo.LifecycleRule.LifecycleCondition from) {
    Bucket.Lifecycle.Rule.Condition.Builder to = Bucket.Lifecycle.Rule.Condition.newBuilder();
    if (from.getAge() != null) {
      to.setAgeDays(from.getAge());
    }
    if (from.getIsLive() != null) {
      to.setIsLive(from.getIsLive());
    }
    if (from.getNumberOfNewerVersions() != null) {
      to.setNumNewerVersions(from.getNumberOfNewerVersions());
    }
    if (from.getDaysSinceNoncurrentTime() != null) {
      to.setDaysSinceNoncurrentTime(from.getDaysSinceNoncurrentTime());
    }
    if (from.getDaysSinceCustomTime() != null) {
      to.setDaysSinceCustomTime(from.getDaysSinceCustomTime());
    }
    ifNonNull(from.getCreatedBeforeOffsetDateTime(), odtDateCodec::encode, to::setCreatedBefore);
    ifNonNull(
        from.getNoncurrentTimeBeforeOffsetDateTime(),
        odtDateCodec::encode,
        to::setNoncurrentTimeBefore);
    ifNonNull(
        from.getCustomTimeBeforeOffsetDateTime(), odtDateCodec::encode, to::setCustomTimeBefore);
    ifNonNull(
        from.getMatchesStorageClass(),
        toImmutableListOf(StorageClass::toString),
        to::addAllMatchesStorageClass);
    ifNonNull(from.getMatchesPrefix(), to::addAllMatchesPrefix);
    ifNonNull(from.getMatchesSuffix(), to::addAllMatchesSuffix);
    return to.build();
  }

  private Bucket.Lifecycle.Rule.Action ruleActionEncode(
      BucketInfo.LifecycleRule.LifecycleAction from) {
    Bucket.Lifecycle.Rule.Action.Builder to =
        Bucket.Lifecycle.Rule.Action.newBuilder().setType(from.getActionType());
    if (from.getActionType().equals(BucketInfo.LifecycleRule.SetStorageClassLifecycleAction.TYPE)) {
      to.setStorageClass(
          ((BucketInfo.LifecycleRule.SetStorageClassLifecycleAction) from)
              .getStorageClass()
              .toString());
    }
    return to.build();
  }

  private BucketInfo.LifecycleRule lifecycleRuleDecode(Bucket.Lifecycle.Rule from) {
    BucketInfo.LifecycleRule.LifecycleAction lifecycleAction;

    Bucket.Lifecycle.Rule.Action action = from.getAction();

    switch (action.getType()) {
      case BucketInfo.LifecycleRule.DeleteLifecycleAction.TYPE:
        lifecycleAction = BucketInfo.LifecycleRule.LifecycleAction.newDeleteAction();
        break;
      case BucketInfo.LifecycleRule.SetStorageClassLifecycleAction.TYPE:
        lifecycleAction =
            BucketInfo.LifecycleRule.LifecycleAction.newSetStorageClassAction(
                StorageClass.valueOf(action.getStorageClass()));
        break;
      case AbortIncompleteMPUAction.TYPE:
        lifecycleAction =
            BucketInfo.LifecycleRule.LifecycleAction.newAbortIncompleteMPUploadAction();
        break;
      default:
        BucketInfo.log.warning(
            "The lifecycle action "
                + action.getType()
                + " is not supported by this version of the library. "
                + "Attempting to update with this rule may cause errors. Please "
                + "update to the latest version of google-cloud-storage.");
        lifecycleAction =
            BucketInfo.LifecycleRule.LifecycleAction.newLifecycleAction("Unknown action");
    }

    Bucket.Lifecycle.Rule.Condition condition = from.getCondition();

    BucketInfo.LifecycleRule.LifecycleCondition.Builder conditionBuilder =
        BucketInfo.LifecycleRule.LifecycleCondition.newBuilder();
    if (condition.hasAgeDays()) {
      conditionBuilder.setAge(condition.getAgeDays());
    }
    if (condition.hasCreatedBefore()) {
      conditionBuilder.setCreatedBeforeOffsetDateTime(
          odtDateCodec.nullable().decode(condition.getCreatedBefore()));
    }
    if (condition.hasIsLive()) {
      conditionBuilder.setIsLive(condition.getIsLive());
    }
    if (condition.hasNumNewerVersions()) {
      conditionBuilder.setNumberOfNewerVersions(condition.getNumNewerVersions());
    }
    if (condition.hasDaysSinceNoncurrentTime()) {
      conditionBuilder.setDaysSinceNoncurrentTime(condition.getDaysSinceNoncurrentTime());
    }
    if (condition.hasNoncurrentTimeBefore()) {
      conditionBuilder.setNoncurrentTimeBeforeOffsetDateTime(
          odtDateCodec.decode(condition.getNoncurrentTimeBefore()));
    }
    if (condition.hasCustomTimeBefore()) {
      conditionBuilder.setCustomTimeBeforeOffsetDateTime(
          odtDateCodec.decode(condition.getCustomTimeBefore()));
    }
    if (condition.hasDaysSinceCustomTime()) {
      conditionBuilder.setDaysSinceCustomTime(condition.getDaysSinceCustomTime());
    }
    if (!condition.getMatchesStorageClassList().isEmpty()) {
      ImmutableList<StorageClass> collect =
          condition.getMatchesStorageClassList().stream()
              .map(StorageClass::valueOf)
              .collect(ImmutableList.toImmutableList());
      conditionBuilder.setMatchesStorageClass(collect);
    }
    if (!condition.getMatchesPrefixList().isEmpty()) {
      conditionBuilder.setMatchesPrefix(condition.getMatchesPrefixList());
    }
    if (!condition.getMatchesSuffixList().isEmpty()) {
      conditionBuilder.setMatchesSuffix(condition.getMatchesSuffixList());
    }
    return new BucketInfo.LifecycleRule(lifecycleAction, conditionBuilder.build());
  }

  private com.google.storage.v2.CustomerEncryption customerEncryptionEncode(
      CustomerEncryption from) {
    return com.google.storage.v2.CustomerEncryption.newBuilder()
        .setEncryptionAlgorithm(from.getEncryptionAlgorithm())
        .setKeySha256Bytes(ByteString.copyFrom(BaseEncoding.base64().decode(from.getKeySha256())))
        .build();
  }

  private CustomerEncryption customerEncryptionDecode(
      com.google.storage.v2.CustomerEncryption from) {
    return new CustomerEncryption(
        from.getEncryptionAlgorithm(),
        BaseEncoding.base64().encode(from.getKeySha256Bytes().toByteArray()));
  }

  private Object blobIdEncode(BlobId from) {
    Object.Builder to = Object.newBuilder();
    ifNonNull(from.getBucket(), bucketNameCodec::encode, to::setBucket);
    ifNonNull(from.getName(), to::setName);
    ifNonNull(from.getGeneration(), to::setGeneration);
    return to.build();
  }

  private BlobId blobIdDecode(Object from) {
    String bucketName = bucketNameCodec.decode(from.getBucket());
    return BlobId.of(bucketName, from.getName(), from.getGeneration());
  }

  private Object blobInfoEncode(BlobInfo from) {
    Object.Builder toBuilder = Object.newBuilder();
    ifNonNull(from.getBucket(), bucketNameCodec::encode, toBuilder::setBucket);
    ifNonNull(from.getName(), toBuilder::setName);
    ifNonNull(from.getGeneration(), toBuilder::setGeneration);
    ifNonNull(from.getCacheControl(), toBuilder::setCacheControl);
    ifNonNull(from.getSize(), toBuilder::setSize);
    ifNonNull(from.getContentType(), toBuilder::setContentType);
    ifNonNull(from.getContentEncoding(), toBuilder::setContentEncoding);
    ifNonNull(from.getContentDisposition(), toBuilder::setContentDisposition);
    ifNonNull(from.getContentLanguage(), toBuilder::setContentLanguage);
    ifNonNull(from.getComponentCount(), toBuilder::setComponentCount);
    if (from.getMd5() != null || from.getCrc32c() != null) {
      ObjectChecksums.Builder objectChecksums = ObjectChecksums.newBuilder();
      if (from.getMd5() != null) {
        objectChecksums.setMd5Hash(
            ByteString.copyFrom(BaseEncoding.base64().decode(from.getMd5())));
      }
      if (from.getCrc32c() != null) {
        objectChecksums.setCrc32C(Utils.crc32cCodec.decode(from.getCrc32c()));
      }
      toBuilder.setChecksums(objectChecksums.build());
    }
    ifNonNull(from.getMetageneration(), toBuilder::setMetageneration);
    ifNonNull(from.getDeleteTimeOffsetDateTime(), timestampCodec::encode, toBuilder::setDeleteTime);
    ifNonNull(from.getUpdateTimeOffsetDateTime(), timestampCodec::encode, toBuilder::setUpdateTime);
    ifNonNull(from.getCreateTimeOffsetDateTime(), timestampCodec::encode, toBuilder::setCreateTime);
    ifNonNull(from.getCustomTimeOffsetDateTime(), timestampCodec::encode, toBuilder::setCustomTime);
    ifNonNull(from.getSoftDeleteTime(), timestampCodec::encode, toBuilder::setSoftDeleteTime);
    ifNonNull(from.getHardDeleteTime(), timestampCodec::encode, toBuilder::setHardDeleteTime);
    ifNonNull(
        from.getCustomerEncryption(),
        customerEncryptionCodec::encode,
        toBuilder::setCustomerEncryption);
    ifNonNull(from.getStorageClass(), StorageClass::toString, toBuilder::setStorageClass);
    ifNonNull(
        from.getTimeStorageClassUpdatedOffsetDateTime(),
        timestampCodec::encode,
        toBuilder::setUpdateStorageClassTime);
    ifNonNull(from.getKmsKeyName(), this::removeKmsVersion, toBuilder::setKmsKey);
    ifNonNull(from.getEventBasedHold(), toBuilder::setEventBasedHold);
    ifNonNull(from.getTemporaryHold(), toBuilder::setTemporaryHold);
    ifNonNull(
        from.getRetentionExpirationTimeOffsetDateTime(),
        timestampCodec::encode,
        toBuilder::setRetentionExpireTime);
    // TODO(sydmunro): Add Selflink when available
    ifNonNull(from.getEtag(), toBuilder::setEtag);
    Entity entity = from.getOwner();
    if (entity != null) {
      toBuilder.setOwner(Owner.newBuilder().setEntity(entityEncode(entity)).build());
    }
    ifNonNull(from.getMetadata(), this::removeNullValues, toBuilder::putAllMetadata);
    ifNonNull(from.getAcl(), toImmutableListOf(objectAcl()::encode), toBuilder::addAllAcl);
    ifNonNull(from.getContexts(), objectContextsCodec::encode, toBuilder::setContexts);
    return toBuilder.build();
  }

  private BlobInfo blobInfoDecode(Object from) {
    BlobInfo.Builder toBuilder =
        BlobInfo.newBuilder(
            BlobId.of(
                bucketNameCodec.decode(from.getBucket()), from.getName(), from.getGeneration()));
    ifNonNull(from.getCacheControl(), toBuilder::setCacheControl);
    ifNonNull(from.getSize(), toBuilder::setSize);
    ifNonNull(from.getContentType(), toBuilder::setContentType);
    ifNonNull(from.getContentEncoding(), toBuilder::setContentEncoding);
    ifNonNull(from.getContentDisposition(), toBuilder::setContentDisposition);
    ifNonNull(from.getContentLanguage(), toBuilder::setContentLanguage);
    ifNonNull(from.getComponentCount(), toBuilder::setComponentCount);
    if (from.hasChecksums()) {
      ObjectChecksums checksums = from.getChecksums();
      if (checksums.hasCrc32C()) {
        toBuilder.setCrc32c(Utils.crc32cCodec.encode(checksums.getCrc32C()));
      }
      ByteString md5Hash = checksums.getMd5Hash();
      if (!md5Hash.isEmpty()) {
        toBuilder.setMd5(BaseEncoding.base64().encode(md5Hash.toByteArray()));
      }
    }
    ifNonNull(from.getMetageneration(), toBuilder::setMetageneration);
    if (from.hasDeleteTime()) {
      toBuilder.setDeleteTimeOffsetDateTime(timestampCodec.decode(from.getDeleteTime()));
    }
    if (from.hasUpdateTime()) {
      toBuilder.setUpdateTimeOffsetDateTime(timestampCodec.decode(from.getUpdateTime()));
    }
    if (from.hasCreateTime()) {
      toBuilder.setCreateTimeOffsetDateTime(timestampCodec.decode(from.getCreateTime()));
    }
    if (from.hasCustomTime()) {
      toBuilder.setCustomTimeOffsetDateTime(timestampCodec.decode(from.getCustomTime()));
    }
    if (from.hasCustomerEncryption()) {
      toBuilder.setCustomerEncryption(customerEncryptionCodec.decode(from.getCustomerEncryption()));
    }
    if (from.hasSoftDeleteTime()) {
      toBuilder.setSoftDeleteTime(timestampCodec.decode(from.getSoftDeleteTime()));
    }
    if (from.hasHardDeleteTime()) {
      toBuilder.setHardDeleteTime(timestampCodec.decode(from.getHardDeleteTime()));
    }
    String storageClass = from.getStorageClass();
    if (!storageClass.isEmpty()) {
      toBuilder.setStorageClass(StorageClass.valueOf(storageClass));
    }
    if (from.hasUpdateStorageClassTime()) {
      toBuilder.setTimeStorageClassUpdatedOffsetDateTime(
          timestampCodec.decode(from.getUpdateStorageClassTime()));
    }
    if (!from.getKmsKey().isEmpty()) {
      toBuilder.setKmsKeyName(from.getKmsKey());
    }
    if (from.hasEventBasedHold()) {
      toBuilder.setEventBasedHold(from.getEventBasedHold());
    }
    toBuilder.setTemporaryHold(from.getTemporaryHold());
    if (from.hasRetentionExpireTime()) {
      toBuilder.setRetentionExpirationTimeOffsetDateTime(
          timestampCodec.decode(from.getRetentionExpireTime()));
    }
    if (!from.getMetadataMap().isEmpty()) {
      toBuilder.setMetadata(from.getMetadataMap());
    }
    if (from.hasOwner()) {
      Owner owner = from.getOwner();
      if (!owner.getEntity().isEmpty()) {
        toBuilder.setOwner(entityDecode(owner.getEntity()));
      }
    }
    if (!from.getEtag().isEmpty()) {
      toBuilder.setEtag(from.getEtag());
    }
    ifNonNull(from.getAclList(), toImmutableListOf(objectAcl()::decode), toBuilder::setAcl);
    if (from.hasContexts()) {
      toBuilder.setContexts(objectContextsCodec.decode(from.getContexts()));
    }
    return toBuilder.build();
  }

  private com.google.iam.v1.Policy policyEncode(Policy from) {
    com.google.iam.v1.Policy.Builder to = com.google.iam.v1.Policy.newBuilder();
    ifNonNull(from.getEtag(), byteStringB64StringCodec::decode, to::setEtag);
    ifNonNull(from.getVersion(), to::setVersion);
    from.getBindingsList().stream().map(bindingCodec::encode).forEach(to::addBindings);
    return to.build();
  }

  private Policy policyDecode(com.google.iam.v1.Policy from) {
    Policy.Builder to = Policy.newBuilder();
    ByteString etag = from.getEtag();
    if (!etag.isEmpty()) {
      to.setEtag(byteStringB64StringCodec.encode(etag));
    }
    to.setVersion(from.getVersion());
    List<com.google.iam.v1.Binding> bindingsList = from.getBindingsList();
    if (!bindingsList.isEmpty()) {
      ImmutableList<Binding> bindings =
          bindingsList.stream().map(bindingCodec::decode).collect(ImmutableList.toImmutableList());
      to.setBindings(bindings);
    }
    return to.build();
  }

  private com.google.iam.v1.Binding bindingEncode(Binding from) {
    com.google.iam.v1.Binding.Builder to = com.google.iam.v1.Binding.newBuilder();
    ifNonNull(from.getRole(), to::setRole);
    ImmutableList<String> members = from.getMembers();
    if (!members.isEmpty()) {
      to.addAllMembers(members);
    }
    ifNonNull(from.getCondition(), iamConditionCodec::encode, to::setCondition);
    return to.build();
  }

  private Binding bindingDecode(com.google.iam.v1.Binding from) {
    Binding.Builder to = Binding.newBuilder();
    String role = from.getRole();
    if (!role.isEmpty()) {
      to.setRole(role);
    }
    ProtocolStringList membersList = from.getMembersList();
    if (!membersList.isEmpty()) {
      to.setMembers(membersList);
    }
    if (from.hasCondition()) {
      to.setCondition(iamConditionCodec.decode(from.getCondition()));
    }
    return to.build();
  }

  private Expr conditionEncode(Condition from) {
    Expr.Builder to = Expr.newBuilder();
    ifNonNull(from.getExpression(), to::setExpression);
    ifNonNull(from.getTitle(), to::setTitle);
    ifNonNull(from.getDescription(), to::setDescription);
    // apiary doesn't have a "location" field like grpc does
    return to.build();
  }

  private Condition conditionDecode(Expr from) {
    Condition.Builder to = Condition.newBuilder();
    String expression = from.getExpression();
    if (!expression.isEmpty()) {
      to.setExpression(expression);
    }
    String title = from.getTitle();
    if (!title.isEmpty()) {
      to.setTitle(title);
    }
    String description = from.getDescription();
    if (!description.isEmpty()) {
      to.setDescription(description);
    }
    return to.build();
  }

  private Map<String, String> removeNullValues(Map<String, String> from) {
    Map<String, String> to = new HashMap<>(from);
    to.values().removeAll(Collections.singleton(null));
    return to;
  }

  private String removeKmsVersion(String from) {
    PathTemplate versionedKmsTemplate =
        PathTemplate.createWithoutUrlEncoding(
            "projects/{project}/locations/{location}/keyRings/{key_ring}/cryptoKeys/{crypto_key}/cryptoKeyVersions/{version}");
    if (versionedKmsTemplate.matches(from)) {
      Map<String, String> res = versionedKmsTemplate.match(from);
      return CryptoKeyName.format(
          res.get("project"), res.get("location"), res.get("key_ring"), res.get("crypto_key"));
    }
    return from;
  }

  private Bucket.IpFilter ipFilterEncode(IpFilter from) {
    Bucket.IpFilter.Builder to = Bucket.IpFilter.newBuilder();
    ifNonNull(from.getMode(), to::setMode);
    ifNonNull(
        from.getPublicNetworkSource(),
        publicNetworkSourceCodec::encode,
        to::setPublicNetworkSource);
    ifNonNull(
        from.getVpcNetworkSources(),
        toImmutableListOf(vpcNetworkSourceCodec::encode),
        to::addAllVpcNetworkSources);
    ifNonNull(from.getAllowCrossOrgVpcs(), to::setAllowCrossOrgVpcs);
    ifNonNull(from.getAllowAllServiceAgentAccess(), to::setAllowAllServiceAgentAccess);
    return to.build();
  }

  private IpFilter ipFilterDecode(Bucket.IpFilter from) {
    IpFilter.Builder to = IpFilter.newBuilder();
    if (!from.getMode().isEmpty()) {
      to.setMode(from.getMode());
    }
    ifNonNull(
        from.getPublicNetworkSource(),
        publicNetworkSourceCodec::decode,
        to::setPublicNetworkSource);
    ifNonNull(
        from.getVpcNetworkSourcesList(),
        toImmutableListOf(vpcNetworkSourceCodec::decode),
        to::setVpcNetworkSources);
    ifNonNull(from.getAllowCrossOrgVpcs(), to::setAllowCrossOrgVpcs);
    if (from.hasAllowAllServiceAgentAccess()) {
      to.setAllowAllServiceAgentAccess(from.getAllowAllServiceAgentAccess());
    }
    return to.build();
  }

  private PublicNetworkSource publicNetworkSourceEncode(IpFilter.PublicNetworkSource from) {
    PublicNetworkSource.Builder to = PublicNetworkSource.newBuilder();
    ifNonNull(from.getAllowedIpCidrRanges(), to::addAllAllowedIpCidrRanges);
    return to.build();
  }

  private IpFilter.PublicNetworkSource publicNetworkSourceDecode(PublicNetworkSource from) {
    return IpFilter.PublicNetworkSource.of(from.getAllowedIpCidrRangesList());
  }

  private VpcNetworkSource vpcNetworkSourceEncode(IpFilter.VpcNetworkSource from) {
    VpcNetworkSource.Builder to = VpcNetworkSource.newBuilder();
    ifNonNull(from.getNetwork(), to::setNetwork);
    ifNonNull(from.getAllowedIpCidrRanges(), to::addAllAllowedIpCidrRanges);
    return to.build();
  }

  private IpFilter.VpcNetworkSource vpcNetworkSourceDecode(VpcNetworkSource from) {
    IpFilter.VpcNetworkSource.Builder to = IpFilter.VpcNetworkSource.newBuilder();
    if (from.hasNetwork()) {
      to.setNetwork(from.getNetwork());
    }
    if (!from.getAllowedIpCidrRangesList().isEmpty()) {
      to.setAllowedIpCidrRanges(from.getAllowedIpCidrRangesList());
    }
    return to.build();
  }

  private ObjectContexts objectContextsEncode(BlobInfo.ObjectContexts from) {
    if (from == null) {
      return null;
    }
    ObjectContexts.Builder to = ObjectContexts.newBuilder();
    if (from.getCustom() != null) {
      to.putAllCustom(
          Maps.transformValues(
              Maps.filterValues(from.getCustom(), Objects::nonNull),
              customContextPayloadCodec::encode));
    }
    return to.build();
  }

  private BlobInfo.ObjectContexts objectContextsDecode(ObjectContexts from) {
    return BlobInfo.ObjectContexts.newBuilder()
        .setCustom(Maps.transformValues(from.getCustomMap(), customContextPayloadCodec::decode))
        .build();
  }

  private ObjectCustomContextPayload objectCustomContextPayloadEncode(
      BlobInfo.ObjectCustomContextPayload from) {
    ObjectCustomContextPayload.Builder to = ObjectCustomContextPayload.newBuilder();
    ifNonNull(from.getValue(), to::setValue);
    ifNonNull(from.getCreateTime(), timestampCodec::encode, to::setCreateTime);
    ifNonNull(from.getUpdateTime(), timestampCodec::encode, to::setUpdateTime);
    return to.build();
  }

  private BlobInfo.ObjectCustomContextPayload objectCustomContextPayloadDecode(
      ObjectCustomContextPayload from) {
    BlobInfo.ObjectCustomContextPayload.Builder to =
        BlobInfo.ObjectCustomContextPayload.newBuilder();
    to.setValue(from.getValue());

    if (from.hasCreateTime()) {
      to.setCreateTime(timestampCodec.decode(from.getCreateTime()));
    }
    if (from.hasUpdateTime()) {
      to.setUpdateTime(timestampCodec.decode(from.getUpdateTime()));
    }
    return to.build();
  }

  /**
   * Several properties are translating lists of one type to another. This convenience method allows
   * specifying a mapping function and composing as part of an {@code #isNonNull} definition.
   */
  private static <T1, T2> Function<List<T1>, ImmutableList<T2>> toImmutableListOf(
      Function<T1, T2> f) {
    return l -> l.stream().map(f).collect(ImmutableList.toImmutableList());
  }
}
