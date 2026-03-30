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

import static com.google.cloud.storage.Acl.Project.ProjectRole.VIEWERS;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.Bucket.Lifecycle;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.cloud.storage.Acl.Project;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BucketInfo.AgeDeleteRule;
import com.google.cloud.storage.BucketInfo.DeleteRule;
import com.google.cloud.storage.BucketInfo.IamConfiguration;
import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule.AbortIncompleteMPUAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.DeleteLifecycleAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleCondition;
import com.google.cloud.storage.BucketInfo.LifecycleRule.SetStorageClassLifecycleAction;
import com.google.cloud.storage.BucketInfo.PublicAccessPrevention;
import com.google.cloud.storage.Conversions.Codec;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class BucketInfoTest {

  private static final List<Acl> ACL =
      ImmutableList.of(
          Acl.of(User.ofAllAuthenticatedUsers(), Role.READER),
          Acl.of(new Project(VIEWERS, "p1"), Role.WRITER));
  private static final String ETAG = "0xFF00";
  private static final String GENERATED_ID = "B/N:1";
  private static final Long META_GENERATION = 10L;
  private static final User OWNER = new User("user@gmail.com");
  private static final String SELF_LINK = "http://storage/b/n";
  private static final Long CREATE_TIME = System.currentTimeMillis();
  private static final Long UPDATE_TIME = CREATE_TIME;
  private static final List<Cors> CORS = Collections.singletonList(Cors.newBuilder().build());
  private static final List<Acl> DEFAULT_ACL =
      Collections.singletonList(Acl.of(User.ofAllAuthenticatedUsers(), Role.WRITER));

  @SuppressWarnings({"unchecked", "deprecation"})
  private static final List<? extends DeleteRule> DELETE_RULES =
      Collections.singletonList(new AgeDeleteRule(5));

  private static final List<? extends BucketInfo.LifecycleRule> LIFECYCLE_RULES =
      Collections.singletonList(
          new BucketInfo.LifecycleRule(
              LifecycleAction.newDeleteAction(),
              LifecycleCondition.newBuilder().setAge(5).build()));
  private static final String INDEX_PAGE = "index.html";
  private static final BucketInfo.IamConfiguration IAM_CONFIGURATION =
      BucketInfo.IamConfiguration.newBuilder()
          .setIsUniformBucketLevelAccessEnabled(true)
          .setUniformBucketLevelAccessLockedTime(System.currentTimeMillis())
          .setPublicAccessPrevention(BucketInfo.PublicAccessPrevention.ENFORCED)
          .build();
  private static final BucketInfo.Logging LOGGING =
      BucketInfo.Logging.newBuilder()
          .setLogBucket("test-bucket")
          .setLogObjectPrefix("test-")
          .build();
  private static final String NOT_FOUND_PAGE = "error.html";
  private static final String LOCATION = "ASIA";
  private static final StorageClass STORAGE_CLASS = StorageClass.STANDARD;
  private static final StorageClass ARCHIVE_STORAGE_CLASS = StorageClass.ARCHIVE;
  private static final String DEFAULT_KMS_KEY_NAME =
      "projects/p/locations/kr-loc/keyRings/kr/cryptoKeys/key";
  private static final Boolean VERSIONING_ENABLED = true;
  private static final Map<String, String> BUCKET_LABELS =
      TestUtils.hashMapOf("label1", "value1", "label2", null);

  private static final Boolean REQUESTER_PAYS = true;
  private static final Boolean DEFAULT_EVENT_BASED_HOLD = true;
  private static final Long RETENTION_EFFECTIVE_TIME = 10L;
  private static final Long RETENTION_PERIOD = 10L;
  private static final Boolean RETENTION_POLICY_IS_LOCKED = false;
  private static final List<String> LOCATION_TYPES =
      ImmutableList.of("multi-region", "region", "dual-region");
  private static final String LOCATION_TYPE = "multi-region";

  @SuppressWarnings({"unchecked", "deprecation"})
  private static final BucketInfo BUCKET_INFO =
      BucketInfo.newBuilder("b")
          .setAcl(ACL)
          .setEtag(ETAG)
          .setGeneratedId(GENERATED_ID)
          .setMetageneration(META_GENERATION)
          .setOwner(OWNER)
          .setSelfLink(SELF_LINK)
          .setCors(CORS)
          .setCreateTime(CREATE_TIME)
          .setUpdateTime(UPDATE_TIME)
          .setDefaultAcl(DEFAULT_ACL)
          .setDeleteRules(DELETE_RULES)
          .setLifecycleRules(LIFECYCLE_RULES)
          .setIndexPage(INDEX_PAGE)
          .setIamConfiguration(IAM_CONFIGURATION)
          .setNotFoundPage(NOT_FOUND_PAGE)
          .setLocation(LOCATION)
          .setLocationType(LOCATION_TYPE)
          .setStorageClass(STORAGE_CLASS)
          .setVersioningEnabled(VERSIONING_ENABLED)
          .setLabels(BUCKET_LABELS)
          .setRequesterPays(REQUESTER_PAYS)
          .setDefaultKmsKeyName(DEFAULT_KMS_KEY_NAME)
          .setDefaultEventBasedHold(DEFAULT_EVENT_BASED_HOLD)
          .setRetentionEffectiveTime(RETENTION_EFFECTIVE_TIME)
          .setRetentionPeriod(RETENTION_PERIOD)
          .setRetentionPolicyIsLocked(RETENTION_POLICY_IS_LOCKED)
          .setLogging(LOGGING)
          .build();

  @SuppressWarnings({"unchecked", "deprecation"})
  private static final BucketInfo BUCKET_INFO_ARCHIVE =
      BucketInfo.newBuilder("b")
          .setAcl(ACL)
          .setEtag(ETAG)
          .setGeneratedId(GENERATED_ID)
          .setMetageneration(META_GENERATION)
          .setOwner(OWNER)
          .setSelfLink(SELF_LINK)
          .setCors(CORS)
          .setCreateTime(CREATE_TIME)
          .setUpdateTime(UPDATE_TIME)
          .setDefaultAcl(DEFAULT_ACL)
          .setDeleteRules(DELETE_RULES)
          .setLifecycleRules(LIFECYCLE_RULES)
          .setIndexPage(INDEX_PAGE)
          .setIamConfiguration(IAM_CONFIGURATION)
          .setNotFoundPage(NOT_FOUND_PAGE)
          .setLocation(LOCATION)
          .setLocationType(LOCATION_TYPE)
          .setStorageClass(ARCHIVE_STORAGE_CLASS)
          .setVersioningEnabled(VERSIONING_ENABLED)
          .setLabels(BUCKET_LABELS)
          .setRequesterPays(REQUESTER_PAYS)
          .setDefaultKmsKeyName(DEFAULT_KMS_KEY_NAME)
          .setDefaultEventBasedHold(DEFAULT_EVENT_BASED_HOLD)
          .setRetentionEffectiveTime(RETENTION_EFFECTIVE_TIME)
          .setRetentionPeriod(RETENTION_PERIOD)
          .setRetentionPolicyIsLocked(RETENTION_POLICY_IS_LOCKED)
          .setLogging(LOGGING)
          .build();

  private static final Lifecycle EMPTY_LIFECYCLE = lifecycle(Collections.emptyList());

  @Test
  public void testToBuilder() throws Exception {
    compareBuckets(BUCKET_INFO, BUCKET_INFO.toBuilder().build());
    BucketInfo bucketInfo = BUCKET_INFO.toBuilder().setName("B").setGeneratedId("id").build();
    assertEquals("B", bucketInfo.getName());
    assertEquals("id", bucketInfo.getGeneratedId());
    bucketInfo = bucketInfo.toBuilder().setName("b").setGeneratedId(GENERATED_ID).build();
    compareBuckets(BUCKET_INFO, bucketInfo);
    assertEquals(ARCHIVE_STORAGE_CLASS, BUCKET_INFO_ARCHIVE.getStorageClass());
  }

  @Test
  public void testToBuilderIncomplete() throws Exception {
    BucketInfo incompleteBucketInfo = BucketInfo.newBuilder("b").build();
    compareBuckets(incompleteBucketInfo, incompleteBucketInfo.toBuilder().build());
  }

  @Test
  public void testOf() {
    BucketInfo bucketInfo = BucketInfo.of("bucket");
    assertEquals("bucket", bucketInfo.getName());
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testBuilder() throws Exception {
    assertAll(
        () -> assertEquals("b", BUCKET_INFO.getName()),
        () -> assertEquals(ACL, BUCKET_INFO.getAcl()),
        () -> assertEquals(ETAG, BUCKET_INFO.getEtag()),
        () -> assertEquals(GENERATED_ID, BUCKET_INFO.getGeneratedId()),
        () -> assertEquals(META_GENERATION, BUCKET_INFO.getMetageneration()),
        () -> assertEquals(OWNER, BUCKET_INFO.getOwner()),
        () -> assertEquals(SELF_LINK, BUCKET_INFO.getSelfLink()),
        () -> assertEquals(CREATE_TIME, BUCKET_INFO.getCreateTime()),
        () -> assertEquals(UPDATE_TIME, BUCKET_INFO.getUpdateTime()),
        () -> assertEquals(CORS, BUCKET_INFO.getCors()),
        () -> assertEquals(DEFAULT_ACL, BUCKET_INFO.getDefaultAcl()),
        () -> assertEquals(DELETE_RULES, BUCKET_INFO.getDeleteRules()),
        () -> assertEquals(INDEX_PAGE, BUCKET_INFO.getIndexPage()),
        () -> assertEquals(IAM_CONFIGURATION, BUCKET_INFO.getIamConfiguration()),
        () -> assertEquals(NOT_FOUND_PAGE, BUCKET_INFO.getNotFoundPage()),
        () -> assertEquals(LOCATION, BUCKET_INFO.getLocation()),
        () -> assertEquals(STORAGE_CLASS, BUCKET_INFO.getStorageClass()),
        () -> assertEquals(DEFAULT_KMS_KEY_NAME, BUCKET_INFO.getDefaultKmsKeyName()),
        () -> assertEquals(VERSIONING_ENABLED, BUCKET_INFO.versioningEnabled()),
        () -> assertEquals(BUCKET_LABELS, BUCKET_INFO.getLabels()),
        () -> assertEquals(REQUESTER_PAYS, BUCKET_INFO.requesterPays()),
        () -> assertEquals(DEFAULT_EVENT_BASED_HOLD, BUCKET_INFO.getDefaultEventBasedHold()),
        () -> assertEquals(RETENTION_EFFECTIVE_TIME, BUCKET_INFO.getRetentionEffectiveTime()),
        () -> assertEquals(RETENTION_PERIOD, BUCKET_INFO.getRetentionPeriod()),
        () -> assertEquals(RETENTION_POLICY_IS_LOCKED, BUCKET_INFO.retentionPolicyIsLocked()),
        () -> assertTrue(LOCATION_TYPES.contains(BUCKET_INFO.getLocationType())),
        () -> assertEquals(LOGGING, BUCKET_INFO.getLogging()));
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testToPbAndFromPb() throws Exception {
    Codec<BucketInfo, Bucket> codec = Conversions.json().bucketInfo();

    Bucket encode1 = codec.encode(BUCKET_INFO);
    BucketInfo decode1 = codec.decode(encode1);
    compareBuckets(BUCKET_INFO, decode1);

    BucketInfo bucketInfo =
        BucketInfo.newBuilder("b")
            .setDeleteRules(DELETE_RULES)
            .setLifecycleRules(LIFECYCLE_RULES)
            .setLogging(LOGGING)
            .build();
    Bucket encode2 = codec.encode(bucketInfo);
    BucketInfo decode2 = codec.decode(encode2);
    compareBuckets(bucketInfo, decode2);
  }

  private void compareBuckets(BucketInfo expected, BucketInfo value) throws Exception {
    assertAll(
        () -> assertEquals(expected.getName(), value.getName()),
        () -> assertEquals(expected.getAcl(), value.getAcl()),
        () -> assertEquals(expected.getEtag(), value.getEtag()),
        () -> assertEquals(expected.getGeneratedId(), value.getGeneratedId()),
        () -> assertEquals(expected.getMetageneration(), value.getMetageneration()),
        () -> assertEquals(expected.getOwner(), value.getOwner()),
        () -> assertEquals(expected.getSelfLink(), value.getSelfLink()),
        () ->
            assertEquals(
                expected.getCreateTimeOffsetDateTime(), value.getCreateTimeOffsetDateTime()),
        () ->
            assertEquals(
                expected.getUpdateTimeOffsetDateTime(), value.getUpdateTimeOffsetDateTime()),
        () -> assertEquals(expected.getCors(), value.getCors()),
        () -> assertEquals(expected.getDefaultAcl(), value.getDefaultAcl()),
        () -> assertEquals(expected.getDeleteRules(), value.getDeleteRules()),
        () -> assertEquals(expected.getLifecycleRules(), value.getLifecycleRules()),
        () -> assertEquals(expected.getIndexPage(), value.getIndexPage()),
        () -> assertEquals(expected.getIamConfiguration(), value.getIamConfiguration()),
        () -> assertEquals(expected.getNotFoundPage(), value.getNotFoundPage()),
        () -> assertEquals(expected.getLocation(), value.getLocation()),
        () -> assertEquals(expected.getStorageClass(), value.getStorageClass()),
        () -> assertEquals(expected.getDefaultKmsKeyName(), value.getDefaultKmsKeyName()),
        () -> assertEquals(expected.versioningEnabled(), value.versioningEnabled()),
        () -> assertEquals(expected.getLabels(), value.getLabels()),
        () -> assertEquals(expected.requesterPays(), value.requesterPays()),
        () -> assertEquals(expected.getDefaultEventBasedHold(), value.getDefaultEventBasedHold()),
        () ->
            assertEquals(
                expected.getRetentionEffectiveTimeOffsetDateTime(),
                value.getRetentionEffectiveTimeOffsetDateTime()),
        () ->
            assertEquals(expected.getRetentionPeriodDuration(), value.getRetentionPeriodDuration()),
        () -> assertEquals(expected.retentionPolicyIsLocked(), value.retentionPolicyIsLocked()),
        () -> assertEquals(expected.getLogging(), value.getLogging()),
        () -> assertEquals(expected, value));
  }

  @Test
  public void testLifecycleRules() {
    Rule deleteLifecycleRule =
        Conversions.json()
            .lifecycleRule()
            .encode(
                new LifecycleRule(
                    LifecycleAction.newDeleteAction(),
                    LifecycleCondition.newBuilder()
                        .setAge(10)
                        .setMatchesPrefix(Arrays.asList("abc", "ijk"))
                        .setMatchesSuffix(Arrays.asList("xyz"))
                        .build()));

    assertEquals(
        LifecycleRule.DeleteLifecycleAction.TYPE, deleteLifecycleRule.getAction().getType());
    assertEquals(10, deleteLifecycleRule.getCondition().getAge().intValue());
    assertEquals(2, deleteLifecycleRule.getCondition().getMatchesPrefix().size());
    assertEquals("abc", (String) deleteLifecycleRule.getCondition().getMatchesPrefix().get(0));
    assertEquals("ijk", (String) deleteLifecycleRule.getCondition().getMatchesPrefix().get(1));
    assertEquals(1, deleteLifecycleRule.getCondition().getMatchesSuffix().size());
    assertEquals("xyz", deleteLifecycleRule.getCondition().getMatchesSuffix().get(0));

    LifecycleRule lcr = Conversions.json().lifecycleRule().decode(deleteLifecycleRule);
    assertEquals(LifecycleRule.DeleteLifecycleAction.TYPE, lcr.getAction().getActionType());
    assertEquals(10, lcr.getCondition().getAge().intValue());
    assertEquals(2, lcr.getCondition().getMatchesPrefix().size());
    assertEquals("abc", (String) lcr.getCondition().getMatchesPrefix().get(0));
    assertEquals("ijk", (String) lcr.getCondition().getMatchesPrefix().get(1));
    assertEquals(1, lcr.getCondition().getMatchesSuffix().size());
    assertEquals("xyz", lcr.getCondition().getMatchesSuffix().get(0));

    assertTrue(lcr.getAction() instanceof DeleteLifecycleAction);

    Rule setStorageClassLifecycleRule =
        Conversions.json()
            .lifecycleRule()
            .encode(
                new LifecycleRule(
                    LifecycleAction.newSetStorageClassAction(StorageClass.COLDLINE),
                    LifecycleCondition.newBuilder()
                        .setIsLive(true)
                        .setNumberOfNewerVersions(10)
                        .build()));

    assertEquals(
        StorageClass.COLDLINE.toString(),
        setStorageClassLifecycleRule.getAction().getStorageClass());
    assertTrue(setStorageClassLifecycleRule.getCondition().getIsLive());
    assertEquals(10, setStorageClassLifecycleRule.getCondition().getNumNewerVersions().intValue());
    assertTrue(
        Conversions.json().lifecycleRule().decode(setStorageClassLifecycleRule).getAction()
            instanceof SetStorageClassLifecycleAction);

    Rule lifecycleRule =
        Conversions.json()
            .lifecycleRule()
            .encode(
                new LifecycleRule(
                    LifecycleAction.newSetStorageClassAction(StorageClass.COLDLINE),
                    LifecycleCondition.newBuilder()
                        .setIsLive(true)
                        .setNumberOfNewerVersions(10)
                        .setDaysSinceNoncurrentTime(30)
                        .setNoncurrentTimeBefore(new DateTime(System.currentTimeMillis()))
                        .setCustomTimeBefore(new DateTime(System.currentTimeMillis()))
                        .setDaysSinceCustomTime(30)
                        .setMatchesSuffix(Collections.singletonList("-suffix"))
                        .setMatchesPrefix(Collections.singletonList("prefix-"))
                        .build()));
    assertEquals(StorageClass.COLDLINE.toString(), lifecycleRule.getAction().getStorageClass());
    assertTrue(lifecycleRule.getCondition().getIsLive());
    assertEquals(10, lifecycleRule.getCondition().getNumNewerVersions().intValue());
    assertEquals(30, lifecycleRule.getCondition().getDaysSinceNoncurrentTime().intValue());
    assertNotNull(lifecycleRule.getCondition().getNoncurrentTimeBefore());
    assertEquals(StorageClass.COLDLINE.toString(), lifecycleRule.getAction().getStorageClass());
    assertEquals(30, lifecycleRule.getCondition().getDaysSinceCustomTime().intValue());
    assertNotNull(lifecycleRule.getCondition().getCustomTimeBefore());
    assertEquals("prefix-", lifecycleRule.getCondition().getMatchesPrefix().get(0));
    assertEquals("-suffix", lifecycleRule.getCondition().getMatchesSuffix().get(0));
    assertTrue(
        Conversions.json().lifecycleRule().decode(lifecycleRule).getAction()
            instanceof SetStorageClassLifecycleAction);

    Rule abortMpuLifecycleRule =
        Conversions.json()
            .lifecycleRule()
            .encode(
                new LifecycleRule(
                    LifecycleAction.newAbortIncompleteMPUploadAction(),
                    LifecycleCondition.newBuilder().setAge(10).build()));
    assertEquals(AbortIncompleteMPUAction.TYPE, abortMpuLifecycleRule.getAction().getType());
    assertEquals(10, abortMpuLifecycleRule.getCondition().getAge().intValue());
    LifecycleRule decode = Conversions.json().lifecycleRule().decode(abortMpuLifecycleRule);
    assertThat(decode.getAction()).isInstanceOf(AbortIncompleteMPUAction.class);

    Rule unsupportedRule =
        Conversions.json()
            .lifecycleRule()
            .encode(
                new LifecycleRule(
                    LifecycleAction.newLifecycleAction("This action type doesn't exist"),
                    LifecycleCondition.newBuilder().setAge(10).build()));
    unsupportedRule.setAction(
        unsupportedRule.getAction().setType("This action type also doesn't exist"));

    Conversions.json()
        .lifecycleRule()
        .decode(
            unsupportedRule); // If this doesn't throw an exception, unsupported rules are working
  }

  @Test
  public void testIamConfiguration() {
    Bucket.IamConfiguration iamConfiguration =
        Conversions.json()
            .iamConfiguration()
            .encode(
                IamConfiguration.newBuilder()
                    .setIsUniformBucketLevelAccessEnabled(true)
                    .setUniformBucketLevelAccessLockedTime(System.currentTimeMillis())
                    .setPublicAccessPrevention(PublicAccessPrevention.ENFORCED)
                    .build());

    assertEquals(Boolean.TRUE, iamConfiguration.getUniformBucketLevelAccess().getEnabled());
    assertNotNull(iamConfiguration.getUniformBucketLevelAccess().getLockedTime());
    assertEquals(
        BucketInfo.PublicAccessPrevention.ENFORCED.getValue(),
        iamConfiguration.getPublicAccessPrevention());
  }

  @Test
  public void testPublicAccessPrevention_ensureAbsentWhenUnknown() throws IOException {
    StringWriter stringWriter = new StringWriter();
    JsonGenerator jsonGenerator =
        JacksonFactory.getDefaultInstance().createJsonGenerator(stringWriter);

    jsonGenerator.serialize(
        Conversions.json()
            .iamConfiguration()
            .encode(
                IamConfiguration.newBuilder()
                    .setIsUniformBucketLevelAccessEnabled(true)
                    .setUniformBucketLevelAccessLockedTime(System.currentTimeMillis())
                    .setPublicAccessPrevention(PublicAccessPrevention.UNKNOWN)
                    .build()));
    jsonGenerator.flush();

    assertFalse(stringWriter.getBuffer().toString().contains("publicAccessPrevention"));
  }

  @Test
  public void testPapValueOfIamConfiguration() {
    Bucket.IamConfiguration iamConfiguration = new Bucket.IamConfiguration();
    Bucket.IamConfiguration.UniformBucketLevelAccess uniformBucketLevelAccess =
        new Bucket.IamConfiguration.UniformBucketLevelAccess();
    iamConfiguration.setUniformBucketLevelAccess(uniformBucketLevelAccess);
    iamConfiguration.setPublicAccessPrevention("random-string");
    IamConfiguration fromPb = Conversions.json().iamConfiguration().decode(iamConfiguration);

    assertEquals(PublicAccessPrevention.UNKNOWN, fromPb.getPublicAccessPrevention());
  }

  @Test
  public void testLogging() {
    Bucket.Logging logging =
        Conversions.json()
            .logging()
            .encode(
                BucketInfo.Logging.newBuilder()
                    .setLogBucket("test-bucket")
                    .setLogObjectPrefix("test-")
                    .build());
    assertEquals("test-bucket", logging.getLogBucket());
    assertEquals("test-", logging.getLogObjectPrefix());
  }

  @Test
  public void testRuleMappingIsCorrect_noMutations() {
    Bucket bucket = Conversions.json().bucketInfo().encode(bi().build());
    assertNull(bucket.getLifecycle());
  }

  @Test
  public void testRuleMappingIsCorrect_deleteLifecycleRules() {
    Bucket bucket = Conversions.json().bucketInfo().encode(bi().deleteLifecycleRules().build());
    assertEquals(EMPTY_LIFECYCLE, bucket.getLifecycle());
  }

  @Test
  @SuppressWarnings({"deprecation"})
  public void testRuleMappingIsCorrect_setDeleteRules_null() {
    Bucket bucket = Conversions.json().bucketInfo().encode(bi().setDeleteRules(null).build());
    assertNull(bucket.getLifecycle());
  }

  @Test
  @SuppressWarnings({"deprecation"})
  public void testRuleMappingIsCorrect_setDeleteRules_empty() {
    Codec<BucketInfo, Bucket> codec = Conversions.json().bucketInfo();
    BucketInfo bucketInfo = bi().setDeleteRules(Collections.emptyList()).build();
    Bucket bucket = codec.encode(bucketInfo);
    Lifecycle actual = bucket.getLifecycle();
    assertThat(actual).isEqualTo(EMPTY_LIFECYCLE);
  }

  @Test
  public void testRuleMappingIsCorrect_setLifecycleRules_empty() {
    Bucket bucket =
        Conversions.json()
            .bucketInfo()
            .encode(bi().setLifecycleRules(Collections.<LifecycleRule>emptyList()).build());
    assertEquals(EMPTY_LIFECYCLE, bucket.getLifecycle());
  }

  @Test
  public void testRuleMappingIsCorrect_setLifeCycleRules_nonEmpty() {
    LifecycleRule lifecycleRule =
        new LifecycleRule(
            LifecycleAction.newDeleteAction(), LifecycleCondition.newBuilder().setAge(10).build());
    Rule lifecycleDeleteAfter10 = Conversions.json().lifecycleRule().encode(lifecycleRule);
    Bucket bucket =
        Conversions.json()
            .bucketInfo()
            .encode(bi().setLifecycleRules(ImmutableList.of(lifecycleRule)).build());
    assertEquals(lifecycle(lifecycleDeleteAfter10), bucket.getLifecycle());
  }

  private static Lifecycle lifecycle(Rule... rules) {
    return lifecycle(Arrays.asList(rules));
  }

  private static Lifecycle lifecycle(List<Rule> rules) {
    Lifecycle emptyLifecycle = new Lifecycle();
    emptyLifecycle.setRule(rules);
    return emptyLifecycle;
  }

  private static BucketInfo.Builder bi() {
    String bucketId = "bucketId";
    return BucketInfo.newBuilder(bucketId);
  }
}
