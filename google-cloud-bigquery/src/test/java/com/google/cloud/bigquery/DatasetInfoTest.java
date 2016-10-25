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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class DatasetInfoTest {

  private static final List<Acl> ACCESS_RULES = ImmutableList.of(
      Acl.of(Acl.Group.ofAllAuthenticatedUsers(), Acl.Role.READER),
      Acl.of(new Acl.View(TableId.of("dataset", "table"))));
  private static final List<Acl> ACCESS_RULES_COMPLETE = ImmutableList.of(
      Acl.of(Acl.Group.ofAllAuthenticatedUsers(), Acl.Role.READER),
      Acl.of(new Acl.View(TableId.of("project", "dataset", "table"))));
  private static final Long CREATION_TIME = System.currentTimeMillis();
  private static final Long DEFAULT_TABLE_EXPIRATION = CREATION_TIME + 100;
  private static final String DESCRIPTION = "description";
  private static final String ETAG = "0xFF00";
  private static final String FRIENDLY_NAME = "friendlyDataset";
  private static final String GENERATED_ID = "P/D:1";
  private static final Long LAST_MODIFIED = CREATION_TIME + 50;
  private static final String LOCATION = "";
  private static final String SELF_LINK = "http://bigquery/p/d";
  private static final DatasetId DATASET_ID = DatasetId.of("dataset");
  private static final DatasetId DATASET_ID_COMPLETE = DatasetId.of("project", "dataset");
  private static final DatasetInfo DATASET_INFO = DatasetInfo.newBuilder(DATASET_ID)
      .setAcl(ACCESS_RULES)
      .setCreationTime(CREATION_TIME)
      .setDefaultTableLifetime(DEFAULT_TABLE_EXPIRATION)
      .setDescription(DESCRIPTION)
      .setEtag(ETAG)
      .setFriendlyName(FRIENDLY_NAME)
      .setGeneratedId(GENERATED_ID)
      .setLastModified(LAST_MODIFIED)
      .setLocation(LOCATION)
      .setSelfLink(SELF_LINK)
      .build();
  private static final DatasetInfo DATASET_INFO_COMPLETE = DATASET_INFO.toBuilder()
      .setDatasetId(DATASET_ID_COMPLETE)
      .setAcl(ACCESS_RULES_COMPLETE)
      .build();
  private static final DatasetInfo DEPRECATED_DATASET_INFO = DatasetInfo.builder(DATASET_ID)
      .acl(ACCESS_RULES)
      .setCreationTime(CREATION_TIME)
      .defaultTableLifetime(DEFAULT_TABLE_EXPIRATION)
      .description(DESCRIPTION)
      .setEtag(ETAG)
      .friendlyName(FRIENDLY_NAME)
      .setGeneratedId(GENERATED_ID)
      .setLastModified(LAST_MODIFIED)
      .location(LOCATION)
      .setSelfLink(SELF_LINK)
      .build();
  private static final DatasetInfo DEPRECATED_DATASET_INFO_COMPLETE = DATASET_INFO.toBuilder()
      .datasetId(DATASET_ID_COMPLETE)
      .acl(ACCESS_RULES_COMPLETE)
      .build();

  @Test
  public void testToBuilder() {
    compareDatasets(DATASET_INFO, DATASET_INFO.toBuilder().build());
    DatasetInfo datasetInfo = DATASET_INFO.toBuilder()
        .setDatasetId(DatasetId.of("dataset2"))
        .setDescription("description2")
        .build();
    assertEquals(DatasetId.of("dataset2"), datasetInfo.getDatasetId());
    assertEquals("description2", datasetInfo.getDescription());
    datasetInfo = datasetInfo.toBuilder().setDatasetId(DATASET_ID).setDescription("description").build();
    compareDatasets(DATASET_INFO, datasetInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    DatasetInfo datasetInfo = DatasetInfo.newBuilder(DATASET_ID).build();
    assertEquals(datasetInfo, datasetInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertNull(DATASET_INFO.getDatasetId().getProject());
    assertEquals(DATASET_ID, DATASET_INFO.getDatasetId());
    assertEquals(ACCESS_RULES, DATASET_INFO.getAcl());
    assertEquals(CREATION_TIME, DATASET_INFO.getCreationTime());
    assertEquals(DEFAULT_TABLE_EXPIRATION, DATASET_INFO.getDefaultTableLifetime());
    assertEquals(DESCRIPTION, DATASET_INFO.getDescription());
    assertEquals(ETAG, DATASET_INFO.getEtag());
    assertEquals(FRIENDLY_NAME, DATASET_INFO.getFriendlyName());
    assertEquals(GENERATED_ID, DATASET_INFO.getGeneratedId());
    assertEquals(LAST_MODIFIED, DATASET_INFO.getLastModified());
    assertEquals(LOCATION, DATASET_INFO.getLocation());
    assertEquals(SELF_LINK, DATASET_INFO.getSelfLink());
    assertEquals(DATASET_ID_COMPLETE, DATASET_INFO_COMPLETE.getDatasetId());
    assertEquals(ACCESS_RULES_COMPLETE, DATASET_INFO_COMPLETE.getAcl());
    assertEquals(CREATION_TIME, DATASET_INFO_COMPLETE.getCreationTime());
    assertEquals(DEFAULT_TABLE_EXPIRATION, DATASET_INFO_COMPLETE.getDefaultTableLifetime());
    assertEquals(DESCRIPTION, DATASET_INFO_COMPLETE.getDescription());
    assertEquals(ETAG, DATASET_INFO_COMPLETE.getEtag());
    assertEquals(FRIENDLY_NAME, DATASET_INFO_COMPLETE.getFriendlyName());
    assertEquals(GENERATED_ID, DATASET_INFO_COMPLETE.getGeneratedId());
    assertEquals(LAST_MODIFIED, DATASET_INFO_COMPLETE.getLastModified());
    assertEquals(LOCATION, DATASET_INFO_COMPLETE.getLocation());
    assertEquals(SELF_LINK, DATASET_INFO_COMPLETE.getSelfLink());
  }

  @Test
  public void testBuilderDeprecated() {
    assertNull(DEPRECATED_DATASET_INFO.datasetId().getProject());
    assertEquals(DATASET_ID, DEPRECATED_DATASET_INFO.datasetId());
    assertEquals(ACCESS_RULES, DEPRECATED_DATASET_INFO.acl());
    assertEquals(CREATION_TIME, DEPRECATED_DATASET_INFO.creationTime());
    assertEquals(DEFAULT_TABLE_EXPIRATION, DEPRECATED_DATASET_INFO.defaultTableLifetime());
    assertEquals(DESCRIPTION, DEPRECATED_DATASET_INFO.description());
    assertEquals(ETAG, DEPRECATED_DATASET_INFO.etag());
    assertEquals(FRIENDLY_NAME, DEPRECATED_DATASET_INFO.friendlyName());
    assertEquals(GENERATED_ID, DEPRECATED_DATASET_INFO.generatedId());
    assertEquals(LAST_MODIFIED, DEPRECATED_DATASET_INFO.lastModified());
    assertEquals(LOCATION, DEPRECATED_DATASET_INFO.location());
    assertEquals(SELF_LINK, DEPRECATED_DATASET_INFO.selfLink());
    assertEquals(DATASET_ID_COMPLETE, DEPRECATED_DATASET_INFO_COMPLETE.datasetId());
    assertEquals(ACCESS_RULES_COMPLETE, DEPRECATED_DATASET_INFO_COMPLETE.acl());
    assertEquals(CREATION_TIME, DEPRECATED_DATASET_INFO_COMPLETE.creationTime());
    assertEquals(DEFAULT_TABLE_EXPIRATION, DEPRECATED_DATASET_INFO_COMPLETE.defaultTableLifetime());
    assertEquals(DESCRIPTION, DEPRECATED_DATASET_INFO_COMPLETE.description());
    assertEquals(ETAG, DEPRECATED_DATASET_INFO_COMPLETE.etag());
    assertEquals(FRIENDLY_NAME, DEPRECATED_DATASET_INFO_COMPLETE.friendlyName());
    assertEquals(GENERATED_ID, DEPRECATED_DATASET_INFO_COMPLETE.generatedId());
    assertEquals(LAST_MODIFIED, DEPRECATED_DATASET_INFO_COMPLETE.lastModified());
    assertEquals(LOCATION, DEPRECATED_DATASET_INFO_COMPLETE.location());
    assertEquals(SELF_LINK, DEPRECATED_DATASET_INFO_COMPLETE.selfLink());
  }

  @Test
  public void testOf() {
    DatasetInfo datasetInfo = DatasetInfo.of(DATASET_ID.getDataset());
    assertEquals(DATASET_ID, datasetInfo.getDatasetId());
    assertNull(datasetInfo.getAcl());
    assertNull(datasetInfo.getCreationTime());
    assertNull(datasetInfo.getDefaultTableLifetime());
    assertNull(datasetInfo.getDescription());
    assertNull(datasetInfo.getEtag());
    assertNull(datasetInfo.getFriendlyName());
    assertNull(datasetInfo.getGeneratedId());
    assertNull(datasetInfo.getLastModified());
    assertNull(datasetInfo.getLocation());
    assertNull(datasetInfo.getSelfLink());
    datasetInfo = DatasetInfo.of(DATASET_ID);
    assertEquals(DATASET_ID, datasetInfo.getDatasetId());
    assertNull(datasetInfo.getAcl());
    assertNull(datasetInfo.getCreationTime());
    assertNull(datasetInfo.getDefaultTableLifetime());
    assertNull(datasetInfo.getDescription());
    assertNull(datasetInfo.getEtag());
    assertNull(datasetInfo.getFriendlyName());
    assertNull(datasetInfo.getGeneratedId());
    assertNull(datasetInfo.getLastModified());
    assertNull(datasetInfo.getLocation());
    assertNull(datasetInfo.getSelfLink());
  }

  @Test
  public void testToPbAndFromPb() {
    compareDatasets(DATASET_INFO_COMPLETE, DatasetInfo.fromPb(DATASET_INFO_COMPLETE.toPb()));
    DatasetInfo datasetInfo = DatasetInfo.newBuilder("project", "dataset").build();
    compareDatasets(datasetInfo, DatasetInfo.fromPb(datasetInfo.toPb()));
  }

  @Test
  public void testSetProjectId() {
    assertEquals(DATASET_INFO_COMPLETE, DATASET_INFO.setProjectId("project"));
  }

  private void compareDatasets(DatasetInfo expected, DatasetInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getDatasetId(), value.getDatasetId());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getFriendlyName(), value.getFriendlyName());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getLocation(), value.getLocation());
    assertEquals(expected.getSelfLink(), value.getSelfLink());
    assertEquals(expected.getAcl(), value.getAcl());
    assertEquals(expected.getCreationTime(), value.getCreationTime());
    assertEquals(expected.getDefaultTableLifetime(), value.getDefaultTableLifetime());
    assertEquals(expected.getLastModified(), value.getLastModified());
  }
}
