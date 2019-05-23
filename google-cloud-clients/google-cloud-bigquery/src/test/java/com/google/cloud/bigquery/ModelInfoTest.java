/*
 * Copyright 2019 Google LLC
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

import org.junit.Test;

public class ModelInfoTest {

  private static final ModelId MODEL_ID = ModelId.of("dataset", "model");
  private static final String ETAG = "etag";
  private static final Long CREATION_TIME = 10L;
  private static final Long LAST_MODIFIED_TIME = 20L;
  private static final Long EXPIRATION_TIME = 30L;
  private static final String DESCRIPTION = "description";
  private static final String FRIENDLY_NAME = "friendlyname";

  private static final ModelInfo MODEL_INFO =
      ModelInfo.newBuilder(MODEL_ID)
          .setEtag(ETAG)
          .setCreationTime(CREATION_TIME)
          .setExpirationTime(EXPIRATION_TIME)
          .setLastModifiedTime(LAST_MODIFIED_TIME)
          .setDescription(DESCRIPTION)
          .setFriendlyName(FRIENDLY_NAME)
          .build();

  @Test
  public void testToBuilder() {
    compareModelInfo(MODEL_INFO, MODEL_INFO.toBuilder().build());
  }

  @Test
  public void testToBuilderIncomplete() {
    ModelInfo modelInfo = ModelInfo.of(MODEL_ID);
    assertEquals(modelInfo, modelInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ETAG, MODEL_INFO.getEtag());
    assertEquals(CREATION_TIME, MODEL_INFO.getCreationTime());
    assertEquals(LAST_MODIFIED_TIME, MODEL_INFO.getLastModifiedTime());
    assertEquals(EXPIRATION_TIME, MODEL_INFO.getExpirationTime());
    assertEquals(DESCRIPTION, MODEL_INFO.getDescription());
    assertEquals(FRIENDLY_NAME, MODEL_INFO.getFriendlyName());
  }

  @Test
  public void testOf() {
    ModelInfo modelInfo = ModelInfo.of(MODEL_ID);
    assertEquals(MODEL_ID, modelInfo.getModelId());
    assertNull(modelInfo.getEtag());
    assertNull(modelInfo.getCreationTime());
    assertNull(modelInfo.getLastModifiedTime());
    assertNull(modelInfo.getExpirationTime());
    assertNull(modelInfo.getDescription());
    assertNull(modelInfo.getFriendlyName());
  }

  @Test
  public void testToAndFromPb() {
    compareModelInfo(MODEL_INFO, ModelInfo.fromPb(MODEL_INFO.toPb()));
  }

  @Test
  public void testSetProjectId() {
    assertEquals("project", MODEL_INFO.setProjectId("project").getModelId().getProject());
  }

  private void compareModelInfo(ModelInfo expected, ModelInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getModelId(), value.getModelId());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getCreationTime(), value.getCreationTime());
    assertEquals(expected.getLastModifiedTime(), value.getLastModifiedTime());
    assertEquals(expected.getExpirationTime(), value.getExpirationTime());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getFriendlyName(), value.getFriendlyName());
    assertEquals(expected.getLabels(), value.getLabels());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
