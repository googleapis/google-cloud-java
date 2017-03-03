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

package com.google.cloud.storage;

import static com.google.cloud.storage.Acl.Project.ProjectRole.VIEWERS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.cloud.storage.Acl.Project;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BucketInfo.AgeDeleteRule;
import com.google.cloud.storage.BucketInfo.CreatedBeforeDeleteRule;
import com.google.cloud.storage.BucketInfo.DeleteRule;
import com.google.cloud.storage.BucketInfo.DeleteRule.Type;
import com.google.cloud.storage.BucketInfo.IsLiveDeleteRule;
import com.google.cloud.storage.BucketInfo.NumNewerVersionsDeleteRule;
import com.google.cloud.storage.BucketInfo.RawDeleteRule;
import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class BucketInfoTest {

  private static final List<Acl> ACL = ImmutableList.of(
      Acl.of(User.ofAllAuthenticatedUsers(), Role.READER),
      Acl.of(new Project(VIEWERS, "p1"), Role.WRITER));
  private static final String ETAG = "0xFF00";
  private static final String GENERATED_ID = "B/N:1";
  private static final Long META_GENERATION = 10L;
  private static final User OWNER = new User("user@gmail.com");
  private static final String SELF_LINK = "http://storage/b/n";
  private static final Long CREATE_TIME = System.currentTimeMillis();
  private static final List<Cors> CORS = Collections.singletonList(Cors.newBuilder().build());
  private static final List<Acl> DEFAULT_ACL =
      Collections.singletonList(Acl.of(User.ofAllAuthenticatedUsers(), Role.WRITER));
  private static final List<? extends DeleteRule> DELETE_RULES =
      Collections.singletonList(new AgeDeleteRule(5));
  private static final String INDEX_PAGE = "index.html";
  private static final String NOT_FOUND_PAGE = "error.html";
  private static final String LOCATION = "ASIA";
  private static final StorageClass STORAGE_CLASS = StorageClass.STANDARD;
  private static final Boolean VERSIONING_ENABLED = true;
  private static final BucketInfo BUCKET_INFO = BucketInfo.newBuilder("b")
      .setAcl(ACL)
      .setEtag(ETAG)
      .setGeneratedId(GENERATED_ID)
      .setMetageneration(META_GENERATION)
      .setOwner(OWNER)
      .setSelfLink(SELF_LINK)
      .setCors(CORS)
      .setCreateTime(CREATE_TIME)
      .setDefaultAcl(DEFAULT_ACL)
      .setDeleteRules(DELETE_RULES)
      .setIndexPage(INDEX_PAGE)
      .setNotFoundPage(NOT_FOUND_PAGE)
      .setLocation(LOCATION)
      .setStorageClass(STORAGE_CLASS)
      .setVersioningEnabled(VERSIONING_ENABLED)
      .build();
  private static final BucketInfo DEPRECATED_BUCKET_INFO = BucketInfo.builder("b")
      .acl(ACL)
      .setEtag(ETAG)
      .setGeneratedId(GENERATED_ID)
      .setMetageneration(META_GENERATION)
      .setOwner(OWNER)
      .setSelfLink(SELF_LINK)
      .cors(CORS)
      .setCreateTime(CREATE_TIME)
      .defaultAcl(DEFAULT_ACL)
      .deleteRules(DELETE_RULES)
      .indexPage(INDEX_PAGE)
      .notFoundPage(NOT_FOUND_PAGE)
      .location(LOCATION)
      .storageClass(STORAGE_CLASS)
      .versioningEnabled(VERSIONING_ENABLED)
      .build();

  @Test
  public void testToBuilder() {
    compareBuckets(BUCKET_INFO, BUCKET_INFO.toBuilder().build());
    BucketInfo bucketInfo = BUCKET_INFO.toBuilder().setName("B").setGeneratedId("id").build();
    assertEquals("B", bucketInfo.getName());
    assertEquals("id", bucketInfo.getGeneratedId());
    bucketInfo = bucketInfo.toBuilder().setName("b").setGeneratedId(GENERATED_ID).build();
    compareBuckets(BUCKET_INFO, bucketInfo);
  }

  @Test
  public void testToBuilderDeprecated() {
    compareBuckets(BUCKET_INFO, BUCKET_INFO.toBuilder().build());
    BucketInfo bucketInfo = BUCKET_INFO.toBuilder().name("B").setGeneratedId("id").build();
    assertEquals("B", bucketInfo.name());
    assertEquals("id", bucketInfo.generatedId());
    bucketInfo = bucketInfo.toBuilder().name("b").setGeneratedId(GENERATED_ID).build();
    compareBuckets(BUCKET_INFO, bucketInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    BucketInfo incompleteBucketInfo = BucketInfo.newBuilder("b").build();
    compareBuckets(incompleteBucketInfo, incompleteBucketInfo.toBuilder().build());
  }

  @Test
  public void testToBuilderIncompleteDeprecated() {
    BucketInfo incompleteBucketInfo = BucketInfo.builder("b").build();
    compareBuckets(incompleteBucketInfo, incompleteBucketInfo.toBuilder().build());
  }

  @Test
  public void testOf() {
    BucketInfo bucketInfo = BucketInfo.of("bucket");
    assertEquals("bucket", bucketInfo.getName());
  }

  @Test
  public void testBuilder() {
    assertEquals("b", BUCKET_INFO.getName());
    assertEquals(ACL, BUCKET_INFO.getAcl());
    assertEquals(ETAG, BUCKET_INFO.getEtag());
    assertEquals(GENERATED_ID, BUCKET_INFO.getGeneratedId());
    assertEquals(META_GENERATION, BUCKET_INFO.getMetageneration());
    assertEquals(OWNER, BUCKET_INFO.getOwner());
    assertEquals(SELF_LINK, BUCKET_INFO.getSelfLink());
    assertEquals(CREATE_TIME, BUCKET_INFO.getCreateTime());
    assertEquals(CORS, BUCKET_INFO.getCors());
    assertEquals(DEFAULT_ACL, BUCKET_INFO.getDefaultAcl());
    assertEquals(DELETE_RULES, BUCKET_INFO.getDeleteRules());
    assertEquals(INDEX_PAGE, BUCKET_INFO.getIndexPage());
    assertEquals(NOT_FOUND_PAGE, BUCKET_INFO.getNotFoundPage());
    assertEquals(LOCATION, BUCKET_INFO.getLocation());
    assertEquals(STORAGE_CLASS, BUCKET_INFO.getStorageClass());
    assertEquals(VERSIONING_ENABLED, BUCKET_INFO.versioningEnabled());
  }

  @Test
  public void testBuilderDeprecated() {
    assertEquals("b", DEPRECATED_BUCKET_INFO.name());
    assertEquals(ACL, DEPRECATED_BUCKET_INFO.acl());
    assertEquals(ETAG, DEPRECATED_BUCKET_INFO.etag());
    assertEquals(GENERATED_ID, DEPRECATED_BUCKET_INFO.generatedId());
    assertEquals(META_GENERATION, DEPRECATED_BUCKET_INFO.metageneration());
    assertEquals(OWNER, DEPRECATED_BUCKET_INFO.owner());
    assertEquals(SELF_LINK, DEPRECATED_BUCKET_INFO.selfLink());
    assertEquals(CREATE_TIME, DEPRECATED_BUCKET_INFO.createTime());
    assertEquals(CORS, DEPRECATED_BUCKET_INFO.cors());
    assertEquals(DEFAULT_ACL, DEPRECATED_BUCKET_INFO.defaultAcl());
    assertEquals(DELETE_RULES, DEPRECATED_BUCKET_INFO.deleteRules());
    assertEquals(INDEX_PAGE, DEPRECATED_BUCKET_INFO.indexPage());
    assertEquals(NOT_FOUND_PAGE, DEPRECATED_BUCKET_INFO.notFoundPage());
    assertEquals(LOCATION, DEPRECATED_BUCKET_INFO.location());
    assertEquals(STORAGE_CLASS, DEPRECATED_BUCKET_INFO.storageClass());
    assertEquals(VERSIONING_ENABLED, DEPRECATED_BUCKET_INFO.versioningEnabled());
  }

  @Test
  public void testToPbAndFromPb() {
    compareBuckets(BUCKET_INFO, BucketInfo.fromPb(BUCKET_INFO.toPb()));
    BucketInfo bucketInfo = BucketInfo.of("b");
    compareBuckets(bucketInfo, BucketInfo.fromPb(bucketInfo.toPb()));
  }

  private void compareBuckets(BucketInfo expected, BucketInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getAcl(), value.getAcl());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getMetageneration(), value.getMetageneration());
    assertEquals(expected.getOwner(), value.getOwner());
    assertEquals(expected.getSelfLink(), value.getSelfLink());
    assertEquals(expected.getCreateTime(), value.getCreateTime());
    assertEquals(expected.getCors(), value.getCors());
    assertEquals(expected.getDefaultAcl(), value.getDefaultAcl());
    assertEquals(expected.getDeleteRules(), value.getDeleteRules());
    assertEquals(expected.getIndexPage(), value.getIndexPage());
    assertEquals(expected.getNotFoundPage(), value.getNotFoundPage());
    assertEquals(expected.getLocation(), value.getLocation());
    assertEquals(expected.getStorageClass(), value.getStorageClass());
    assertEquals(expected.versioningEnabled(), value.versioningEnabled());
  }

  @Test
  public void testDeleteRules() {
    AgeDeleteRule ageRule = new AgeDeleteRule(10);
    assertEquals(10, ageRule.getDaysToLive());
    assertEquals(10, ageRule.getDaysToLive());
    assertEquals(Type.AGE, ageRule.getType());
    assertEquals(Type.AGE, ageRule.getType());
    CreatedBeforeDeleteRule createBeforeRule = new CreatedBeforeDeleteRule(1);
    assertEquals(1, createBeforeRule.getTimeMillis());
    assertEquals(1, createBeforeRule.getTimeMillis());
    assertEquals(Type.CREATE_BEFORE, createBeforeRule.getType());
    NumNewerVersionsDeleteRule versionsRule = new NumNewerVersionsDeleteRule(2);
    assertEquals(2, versionsRule.getNumNewerVersions());
    assertEquals(2, versionsRule.getNumNewerVersions());
    assertEquals(Type.NUM_NEWER_VERSIONS, versionsRule.getType());
    IsLiveDeleteRule isLiveRule = new IsLiveDeleteRule(true);
    assertTrue(isLiveRule.isLive());
    assertEquals(Type.IS_LIVE, isLiveRule.getType());
    assertEquals(Type.IS_LIVE, isLiveRule.getType());
    Rule rule = new Rule().set("a", "b");
    RawDeleteRule rawRule = new RawDeleteRule(rule);
    assertEquals(Type.IS_LIVE, isLiveRule.getType());
    assertEquals(Type.IS_LIVE, isLiveRule.getType());
    ImmutableList<DeleteRule> rules = ImmutableList
        .of(ageRule, createBeforeRule, versionsRule, isLiveRule, rawRule);
    for (DeleteRule delRule : rules) {
      assertEquals(delRule, DeleteRule.fromPb(delRule.toPb()));
    }
  }

  @Test
  public void testDeleteRulesDeprecated() {
    AgeDeleteRule ageRule = new AgeDeleteRule(10);
    assertEquals(10, ageRule.daysToLive());
    assertEquals(10, ageRule.getDaysToLive());
    assertEquals(Type.AGE, ageRule.type());
    assertEquals(Type.AGE, ageRule.getType());
    CreatedBeforeDeleteRule createBeforeRule = new CreatedBeforeDeleteRule(1);
    assertEquals(1, createBeforeRule.timeMillis());
    assertEquals(1, createBeforeRule.getTimeMillis());
    assertEquals(Type.CREATE_BEFORE, createBeforeRule.type());
    NumNewerVersionsDeleteRule versionsRule = new NumNewerVersionsDeleteRule(2);
    assertEquals(2, versionsRule.numNewerVersions());
    assertEquals(2, versionsRule.getNumNewerVersions());
    assertEquals(Type.NUM_NEWER_VERSIONS, versionsRule.type());
    IsLiveDeleteRule isLiveRule = new IsLiveDeleteRule(true);
    assertTrue(isLiveRule.isLive());
    assertEquals(Type.IS_LIVE, isLiveRule.type());
    assertEquals(Type.IS_LIVE, isLiveRule.getType());
    Rule rule = new Rule().set("a", "b");
    RawDeleteRule rawRule = new RawDeleteRule(rule);
    assertEquals(Type.IS_LIVE, isLiveRule.type());
    assertEquals(Type.IS_LIVE, isLiveRule.getType());
    ImmutableList<DeleteRule> rules = ImmutableList
        .of(ageRule, createBeforeRule, versionsRule, isLiveRule, rawRule);
    for (DeleteRule delRule : rules) {
      assertEquals(delRule, DeleteRule.fromPb(delRule.toPb()));
    }
  }
}
