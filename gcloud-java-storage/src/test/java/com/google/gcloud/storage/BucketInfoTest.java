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

import static com.google.gcloud.storage.Acl.Project.ProjectRole.VIEWERS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.common.collect.ImmutableList;
import com.google.gcloud.storage.Acl.Project;
import com.google.gcloud.storage.Acl.Role;
import com.google.gcloud.storage.Acl.User;
import com.google.gcloud.storage.BucketInfo.AgeDeleteRule;
import com.google.gcloud.storage.BucketInfo.CreatedBeforeDeleteRule;
import com.google.gcloud.storage.BucketInfo.DeleteRule;
import com.google.gcloud.storage.BucketInfo.DeleteRule.Type;
import com.google.gcloud.storage.BucketInfo.IsLiveDeleteRule;
import com.google.gcloud.storage.BucketInfo.Location;
import com.google.gcloud.storage.BucketInfo.NumNewerVersionsDeleteRule;
import com.google.gcloud.storage.BucketInfo.RawDeleteRule;
import com.google.gcloud.storage.BucketInfo.StorageClass;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class BucketInfoTest {

  private static final List<Acl> ACL = ImmutableList.of(
      new Acl(User.ofAllAuthenticatedUsers(), Role.READER),
      new Acl(new Project(VIEWERS, "p1"), Role.WRITER));
  private static final String ETAG = "0xFF00";
  private static final String ID = "B/N:1";
  private static final Long META_GENERATION = 10L;
  private static final User OWNER = new User("user@gmail.com");
  private static final String SELF_LINK = "http://storage/b/n";
  private static final Long CREATE_TIME = System.currentTimeMillis();
  private static final List<Cors> CORS = Collections.singletonList(Cors.builder().build());
  private static final List<Acl> DEFAULT_ACL =
      Collections.singletonList(new Acl(User.ofAllAuthenticatedUsers(), Role.WRITER));
  private static final List<? extends DeleteRule> DELETE_RULES =
      Collections.singletonList(new AgeDeleteRule(5));
  private static final String INDEX_PAGE = "index.html";
  private static final String NOT_FOUND_PAGE = "error.html";
  private static final Location LOCATION = Location.asia();
  private static final StorageClass STORAGE_CLASS = StorageClass.standard();
  private static final Boolean VERSIONING_ENABLED = true;
  private static final BucketInfo BUCKET_INFO = BucketInfo.builder("b")
      .acl(ACL)
      .etag(ETAG)
      .id(ID)
      .metageneration(META_GENERATION)
      .owner(OWNER)
      .selfLink(SELF_LINK)
      .cors(CORS)
      .createTime(CREATE_TIME)
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
    BucketInfo bucketInfo = BUCKET_INFO.toBuilder().name("B").id("id").build();
    assertEquals("B", bucketInfo.name());
    assertEquals("id", bucketInfo.id());
    bucketInfo = bucketInfo.toBuilder().name("b").id(ID).build();
    compareBuckets(BUCKET_INFO, bucketInfo);
  }

  @Test
  public void testOf() {
    BucketInfo bucketInfo = BucketInfo.of("bucket");
    assertEquals("bucket", bucketInfo.name());
  }

  @Test
  public void testBuilder() {
    assertEquals("b", BUCKET_INFO.name());
    assertEquals(ACL, BUCKET_INFO.acl());
    assertEquals(ETAG, BUCKET_INFO.etag());
    assertEquals(ID, BUCKET_INFO.id());
    assertEquals(META_GENERATION, BUCKET_INFO.metageneration());
    assertEquals(OWNER, BUCKET_INFO.owner());
    assertEquals(SELF_LINK, BUCKET_INFO.selfLink());
    assertEquals(CREATE_TIME, BUCKET_INFO.createTime());
    assertEquals(CORS, BUCKET_INFO.cors());
    assertEquals(DEFAULT_ACL, BUCKET_INFO.defaultAcl());
    assertEquals(DELETE_RULES, BUCKET_INFO.deleteRules());
    assertEquals(INDEX_PAGE, BUCKET_INFO.indexPage());
    assertEquals(NOT_FOUND_PAGE, BUCKET_INFO.notFoundPage());
    assertEquals(LOCATION, BUCKET_INFO.location());
    assertEquals(STORAGE_CLASS, BUCKET_INFO.storageClass());
    assertEquals(VERSIONING_ENABLED, BUCKET_INFO.versioningEnabled());
  }

  @Test
  public void testToPbAndFromPb() {
    compareBuckets(BUCKET_INFO, BucketInfo.fromPb(BUCKET_INFO.toPb()));
  }

  private void compareBuckets(BucketInfo expected, BucketInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.name(), value.name());
    assertEquals(expected.acl(), value.acl());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.id(), value.id());
    assertEquals(expected.metageneration(), value.metageneration());
    assertEquals(expected.owner(), value.owner());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.createTime(), value.createTime());
    assertEquals(expected.cors(), value.cors());
    assertEquals(expected.defaultAcl(), value.defaultAcl());
    assertEquals(expected.deleteRules(), value.deleteRules());
    assertEquals(expected.indexPage(), value.indexPage());
    assertEquals(expected.notFoundPage(), value.notFoundPage());
    assertEquals(expected.location(), value.location());
    assertEquals(expected.storageClass(), value.storageClass());
    assertEquals(expected.versioningEnabled(), value.versioningEnabled());
  }

  public void testLocation() {
    assertEquals("ASIA", Location.asia().value());
    assertEquals("EN", Location.eu().value());
    assertEquals("US", Location.us().value());
    assertSame(Location.asia(), Location.of("asia"));
    assertSame(Location.asia(), Location.of("EU"));
    assertSame(Location.asia(), Location.of("uS"));
  }

  public void testDeleteRules() {
    AgeDeleteRule ageRule = new AgeDeleteRule(10);
    assertEquals(10, ageRule.daysToLive());
    assertEquals(Type.AGE, ageRule.type());
    CreatedBeforeDeleteRule createBeforeRule = new CreatedBeforeDeleteRule(1);
    assertEquals(10, createBeforeRule.timeMillis());
    assertEquals(Type.CREATE_BEFORE, createBeforeRule.type());
    NumNewerVersionsDeleteRule versionsRule = new NumNewerVersionsDeleteRule(2);
    assertEquals(2, versionsRule.numNewerVersions());
    assertEquals(Type.NUM_NEWER_VERSIONS, versionsRule.type());
    IsLiveDeleteRule isLiveRule = new IsLiveDeleteRule(true);
    assertTrue(isLiveRule.isLive());
    assertEquals(Type.IS_LIVE, isLiveRule.type());
    Rule rule = new Rule().set("a", "b");
    RawDeleteRule rawRule = new RawDeleteRule(rule);
    assertEquals(Type.UNKNOWN, isLiveRule.type());
    ImmutableList<DeleteRule> rules = ImmutableList
        .of(ageRule, createBeforeRule, versionsRule, isLiveRule, rawRule);
    for (DeleteRule delRule : rules) {
      assertEquals(delRule, DeleteRule.fromPb(delRule.toPb()));
    }
  }
}
