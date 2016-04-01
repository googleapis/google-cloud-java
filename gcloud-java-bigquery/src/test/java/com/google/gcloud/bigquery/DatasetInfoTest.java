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

package com.google.gcloud.bigquery;

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
  private static final DatasetInfo DATASET_INFO = DatasetInfo.builder(DATASET_ID)
      .acl(ACCESS_RULES)
      .creationTime(CREATION_TIME)
      .defaultTableLifetime(DEFAULT_TABLE_EXPIRATION)
      .description(DESCRIPTION)
      .etag(ETAG)
      .friendlyName(FRIENDLY_NAME)
      .generatedId(GENERATED_ID)
      .lastModified(LAST_MODIFIED)
      .location(LOCATION)
      .selfLink(SELF_LINK)
      .build();
  private static final DatasetInfo DATASET_INFO_COMPLETE = DATASET_INFO.toBuilder()
      .datasetId(DATASET_ID_COMPLETE)
      .acl(ACCESS_RULES_COMPLETE)
      .build();

  @Test
  public void testToBuilder() {
    compareDatasets(DATASET_INFO, DATASET_INFO.toBuilder().build());
    DatasetInfo datasetInfo = DATASET_INFO.toBuilder()
        .datasetId(DatasetId.of("dataset2"))
        .description("description2")
        .build();
    assertEquals(DatasetId.of("dataset2"), datasetInfo.datasetId());
    assertEquals("description2", datasetInfo.description());
    datasetInfo = datasetInfo.toBuilder().datasetId(DATASET_ID).description("description").build();
    compareDatasets(DATASET_INFO, datasetInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    DatasetInfo datasetInfo = DatasetInfo.builder(DATASET_ID).build();
    assertEquals(datasetInfo, datasetInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertNull(DATASET_INFO.datasetId().project());
    assertEquals(DATASET_ID, DATASET_INFO.datasetId());
    assertEquals(ACCESS_RULES, DATASET_INFO.acl());
    assertEquals(CREATION_TIME, DATASET_INFO.creationTime());
    assertEquals(DEFAULT_TABLE_EXPIRATION, DATASET_INFO.defaultTableLifetime());
    assertEquals(DESCRIPTION, DATASET_INFO.description());
    assertEquals(ETAG, DATASET_INFO.etag());
    assertEquals(FRIENDLY_NAME, DATASET_INFO.friendlyName());
    assertEquals(GENERATED_ID, DATASET_INFO.generatedId());
    assertEquals(LAST_MODIFIED, DATASET_INFO.lastModified());
    assertEquals(LOCATION, DATASET_INFO.location());
    assertEquals(SELF_LINK, DATASET_INFO.selfLink());
    assertEquals(DATASET_ID_COMPLETE, DATASET_INFO_COMPLETE.datasetId());
    assertEquals(ACCESS_RULES_COMPLETE, DATASET_INFO_COMPLETE.acl());
    assertEquals(CREATION_TIME, DATASET_INFO_COMPLETE.creationTime());
    assertEquals(DEFAULT_TABLE_EXPIRATION, DATASET_INFO_COMPLETE.defaultTableLifetime());
    assertEquals(DESCRIPTION, DATASET_INFO_COMPLETE.description());
    assertEquals(ETAG, DATASET_INFO_COMPLETE.etag());
    assertEquals(FRIENDLY_NAME, DATASET_INFO_COMPLETE.friendlyName());
    assertEquals(GENERATED_ID, DATASET_INFO_COMPLETE.generatedId());
    assertEquals(LAST_MODIFIED, DATASET_INFO_COMPLETE.lastModified());
    assertEquals(LOCATION, DATASET_INFO_COMPLETE.location());
    assertEquals(SELF_LINK, DATASET_INFO_COMPLETE.selfLink());
  }

  @Test
  public void testToPbAndFromPb() {
    compareDatasets(DATASET_INFO_COMPLETE, DatasetInfo.fromPb(DATASET_INFO_COMPLETE.toPb()));
    DatasetInfo datasetInfo = DatasetInfo.builder("project", "dataset").build();
    compareDatasets(datasetInfo, DatasetInfo.fromPb(datasetInfo.toPb()));
  }

  @Test
  public void testSetProjectId() {
    assertEquals(DATASET_INFO_COMPLETE, DATASET_INFO.setProjectId("project"));
  }

  private void compareDatasets(DatasetInfo expected, DatasetInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.datasetId(), value.datasetId());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.friendlyName(), value.friendlyName());
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.location(), value.location());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.acl(), value.acl());
    assertEquals(expected.creationTime(), value.creationTime());
    assertEquals(expected.defaultTableLifetime(), value.defaultTableLifetime());
    assertEquals(expected.lastModified(), value.lastModified());
  }
}
