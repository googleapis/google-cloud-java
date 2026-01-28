/*
 * Copyright 2026 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ModelTest {

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

  private BigQuery bigquery;
  private BigQueryOptions mockOptions;
  private Model expectedModel;
  private Model model;

  @BeforeEach
  void setUp() {
    bigquery = mock(BigQuery.class);
    mockOptions = mock(BigQueryOptions.class);
    when(bigquery.getOptions()).thenReturn(mockOptions);
    expectedModel = new Model(bigquery, new ModelInfo.BuilderImpl(MODEL_INFO));
    model = new Model(bigquery, new ModelInfo.BuilderImpl(MODEL_INFO));
  }

  @Test
  void testBuilder() {
    Model builtModel =
        new Model.Builder(bigquery, MODEL_ID)
            .setEtag(ETAG)
            .setCreationTime(CREATION_TIME)
            .setExpirationTime(EXPIRATION_TIME)
            .setLastModifiedTime(LAST_MODIFIED_TIME)
            .setDescription(DESCRIPTION)
            .setFriendlyName(FRIENDLY_NAME)
            .build();
    assertEquals(ETAG, builtModel.getEtag());
    assertSame(bigquery, builtModel.getBigQuery());
  }

  @Test
  void testToBuilder() {
    compareModelInfo(expectedModel, expectedModel.toBuilder().build());
  }

  @Test
  void testExists_True() {
    BigQuery.ModelOption[] expectedOptions = {BigQuery.ModelOption.fields()};
    when(bigquery.getModel(MODEL_INFO.getModelId(), expectedOptions)).thenReturn(expectedModel);
    assertTrue(model.exists());
    verify(bigquery).getModel(MODEL_INFO.getModelId(), expectedOptions);
  }

  @Test
  void testExists_False() {
    BigQuery.ModelOption[] expectedOptions = {BigQuery.ModelOption.fields()};
    when(bigquery.getModel(MODEL_INFO.getModelId(), expectedOptions)).thenReturn(null);
    assertFalse(model.exists());
    verify(bigquery).getModel(MODEL_INFO.getModelId(), expectedOptions);
  }

  @Test
  void testReload() {
    ModelInfo updatedInfo = MODEL_INFO.toBuilder().setDescription("Description").build();
    Model expectedModel = new Model(bigquery, new ModelInfo.BuilderImpl(updatedInfo));
    when(bigquery.getModel(MODEL_INFO.getModelId())).thenReturn(expectedModel);
    Model updatedModel = model.reload();
    compareModel(expectedModel, updatedModel);
    verify(bigquery).getModel(MODEL_INFO.getModelId());
  }

  @Test
  void testReloadNull() {
    when(bigquery.getModel(MODEL_INFO.getModelId())).thenReturn(null);
    assertNull(model.reload());
    verify(bigquery).getModel(MODEL_INFO.getModelId());
  }

  @Test
  void testUpdate() {
    Model expectedUpdatedModel = expectedModel.toBuilder().setDescription("Description").build();
    when(bigquery.update(eq(expectedModel))).thenReturn(expectedUpdatedModel);
    Model actualUpdatedModel = model.update();
    compareModel(expectedUpdatedModel, actualUpdatedModel);
    verify(bigquery).update(eq(expectedModel));
  }

  @Test
  void testUpdateWithOptions() {
    Model expectedUpdatedModel = expectedModel.toBuilder().setDescription("Description").build();
    when(bigquery.update(eq(expectedModel), eq(BigQuery.ModelOption.fields())))
        .thenReturn(expectedUpdatedModel);
    Model actualUpdatedModel = model.update(BigQuery.ModelOption.fields());
    compareModel(expectedUpdatedModel, actualUpdatedModel);
    verify(bigquery).update(eq(expectedModel), eq(BigQuery.ModelOption.fields()));
  }

  @Test
  void testDeleteTrue() {
    when(bigquery.delete(MODEL_INFO.getModelId())).thenReturn(true);
    assertTrue(model.delete());
    verify(bigquery).delete(MODEL_INFO.getModelId());
  }

  @Test
  void testDeleteFalse() {
    when(bigquery.delete(MODEL_INFO.getModelId())).thenReturn(false);
    assertFalse(model.delete());
    verify(bigquery).delete(MODEL_INFO.getModelId());
  }

  private void compareModel(Model expected, Model value) {
    assertEquals(expected, value);
    compareModelInfo(expected, value);
    assertEquals(expected.getBigQuery().getOptions(), value.getBigQuery().getOptions());
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
