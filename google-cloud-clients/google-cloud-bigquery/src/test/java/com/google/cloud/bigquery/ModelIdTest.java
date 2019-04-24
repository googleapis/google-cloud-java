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

import org.junit.Test;

public class ModelIdTest {

  public static final ModelId MODEL = ModelId.of("dataset", "model");
  public static final ModelId MODEL_COMPLETE = ModelId.of("project", "dataset", "model");

  @Test
  public void testOf() {
    assertEquals(null, MODEL.getProject());
    assertEquals("dataset", MODEL.getDataset());
    assertEquals("model", MODEL.getModel());

    assertEquals("project", MODEL_COMPLETE.getProject());
    assertEquals("dataset", MODEL_COMPLETE.getDataset());
    assertEquals("model", MODEL_COMPLETE.getModel());
  }

  @Test
  public void testEquals() {
    compareModelIds(MODEL, ModelId.of("dataset", "model"));
    compareModelIds(MODEL_COMPLETE, ModelId.of("project", "dataset", "model"));
  }

  @Test
  public void testToPbAndFromPb() {
    compareModelIds(MODEL, ModelId.fromPb(MODEL.toPb()));
    compareModelIds(MODEL_COMPLETE, ModelId.fromPb(MODEL_COMPLETE.toPb()));
  }

  @Test
  public void testSetProjectId() {
    ModelId differentProjectTable = ModelId.of("differentProject", "dataset", "model");
    assertEquals(differentProjectTable, MODEL.setProjectId("differentProject"));
  }

  private void compareModelIds(ModelId expected, ModelId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), value.getProject());
    assertEquals(expected.getDataset(), value.getDataset());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
