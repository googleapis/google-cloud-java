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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

public class ModelTest {

  private BigQuery serviceMockReturnsOptions = createStrictMock(BigQuery.class);
  private BigQueryOptions mockOptions = createMock(BigQueryOptions.class);

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
  private Model expectedModel;
  private Model model;

  private void initializeExpectedModel(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    bigquery = createStrictMock(BigQuery.class);
    expectedModel = new Model(serviceMockReturnsOptions, new ModelInfo.BuilderImpl(MODEL_INFO));
  }

  private void initializeModel() {
    model = new Model(bigquery, new ModelInfo.BuilderImpl(MODEL_INFO));
  }

  @After
  public void tearDown() throws Exception {
    verify(bigquery, serviceMockReturnsOptions);
  }

  @Test
  public void testBuilder() {
    initializeExpectedModel(2);
    replay(bigquery);
    Model builtModel =
        new Model.Builder(serviceMockReturnsOptions, MODEL_ID)
            .setEtag(ETAG)
            .setCreationTime(CREATION_TIME)
            .setExpirationTime(EXPIRATION_TIME)
            .setLastModifiedTime(LAST_MODIFIED_TIME)
            .setDescription(DESCRIPTION)
            .setFriendlyName(FRIENDLY_NAME)
            .build();
    assertEquals(ETAG, builtModel.getEtag());
    assertSame(serviceMockReturnsOptions, builtModel.getBigQuery());
  }

  @Test
  public void testToBuilder() {
    initializeExpectedModel(2);
    replay(bigquery);
    compareModelInfo(expectedModel, expectedModel.toBuilder().build());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedModel(1);
    BigQuery.ModelOption[] expectedOptions = {BigQuery.ModelOption.fields()};
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getModel(MODEL_INFO.getModelId(), expectedOptions)).andReturn(expectedModel);
    replay(bigquery);
    initializeModel();
    assertTrue(model.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedModel(1);
    BigQuery.ModelOption[] expectedOptions = {BigQuery.ModelOption.fields()};
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getModel(MODEL_INFO.getModelId(), expectedOptions)).andReturn(null);
    replay(bigquery);
    initializeModel();
    assertFalse(model.exists());
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedModel(4);
    ModelInfo updatedInfo = MODEL_INFO.toBuilder().setDescription("Description").build();
    Model expectedModel =
        new Model(serviceMockReturnsOptions, new ModelInfo.BuilderImpl(updatedInfo));
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getModel(MODEL_INFO.getModelId())).andReturn(expectedModel);
    replay(bigquery);
    initializeModel();
    Model updatedModel = model.reload();
    compareModel(expectedModel, updatedModel);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedModel(1);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getModel(MODEL_INFO.getModelId())).andReturn(null);
    replay(bigquery);
    initializeModel();
    assertNull(model.reload());
  }

  @Test
  public void testUpdate() {
    initializeExpectedModel(4);
    Model expectedUpdatedModel = expectedModel.toBuilder().setDescription("Description").build();
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.update(eq(expectedModel))).andReturn(expectedUpdatedModel);
    replay(bigquery);
    initializeModel();
    Model actualUpdatedModel = model.update();
    compareModel(expectedUpdatedModel, actualUpdatedModel);
  }

  @Test
  public void testUpdateWithOptions() {
    initializeExpectedModel(4);
    Model expectedUpdatedModel = expectedModel.toBuilder().setDescription("Description").build();
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.update(eq(expectedModel), eq(BigQuery.ModelOption.fields())))
        .andReturn(expectedUpdatedModel);
    replay(bigquery);
    initializeModel();
    Model actualUpdatedModel = model.update(BigQuery.ModelOption.fields());
    compareModel(expectedUpdatedModel, actualUpdatedModel);
  }

  @Test
  public void testDeleteTrue() {
    initializeExpectedModel(1);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.delete(MODEL_INFO.getModelId())).andReturn(true);
    replay(bigquery);
    initializeModel();
    assertTrue(model.delete());
  }

  @Test
  public void testDeleteFalse() {
    initializeExpectedModel(1);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.delete(MODEL_INFO.getModelId())).andReturn(false);
    replay(bigquery);
    initializeModel();
    assertFalse(model.delete());
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
