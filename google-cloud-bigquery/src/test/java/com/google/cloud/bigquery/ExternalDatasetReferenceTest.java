/*
 * Copyright 2023 Google LLC
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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExternalDatasetReferenceTest {
  private static final String EXTERNAL_SOURCE = "test_source";
  private static final String CONNECTION = "test_connection";
  private static final ExternalDatasetReference EXTERNAL_DATASET_REFERENCE =
      ExternalDatasetReference.newBuilder()
          .setExternalSource(EXTERNAL_SOURCE)
          .setConnection(CONNECTION)
          .build();

  @Test
  public void testToBuilder() {
    compareExternalDatasetReference(
        EXTERNAL_DATASET_REFERENCE, EXTERNAL_DATASET_REFERENCE.toBuilder().build());
    ExternalDatasetReference externalDatasetReference =
        EXTERNAL_DATASET_REFERENCE.toBuilder().setExternalSource("test_source2").build();
    assertEquals("test_source2", externalDatasetReference.getExternalSource());
  }

  @Test
  public void testBuilder() {
    assertEquals(EXTERNAL_SOURCE, EXTERNAL_DATASET_REFERENCE.getExternalSource());
    assertEquals(CONNECTION, EXTERNAL_DATASET_REFERENCE.getConnection());
    ExternalDatasetReference externalDatasetReference =
        ExternalDatasetReference.newBuilder()
            .setExternalSource(EXTERNAL_SOURCE)
            .setConnection(CONNECTION)
            .build();
    assertEquals(EXTERNAL_DATASET_REFERENCE, externalDatasetReference);
  }

  @Test
  public void testToAndFromPb() {
    ExternalDatasetReference externalDatasetReference =
        EXTERNAL_DATASET_REFERENCE.toBuilder().build();
    assertTrue(
        ExternalDatasetReference.fromPb(externalDatasetReference.toPb())
            instanceof ExternalDatasetReference);
    compareExternalDatasetReference(
        externalDatasetReference, ExternalDatasetReference.fromPb(externalDatasetReference.toPb()));
  }

  private void compareExternalDatasetReference(
      ExternalDatasetReference expected, ExternalDatasetReference value) {
    assertEquals(expected.getExternalSource(), value.getExternalSource());
    assertEquals(expected.getConnection(), value.getConnection());
  }
}
