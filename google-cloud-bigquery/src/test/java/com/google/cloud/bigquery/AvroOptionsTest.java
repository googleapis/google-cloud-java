/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
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

public class AvroOptionsTest {

  private static final Boolean USE_AVRO_LOGICAL_TYPES = true;
  private static final AvroOptions AVRO_OPTIONS =
      AvroOptions.newBuilder().setUseAvroLogicalTypes(USE_AVRO_LOGICAL_TYPES).build();

  @Test
  public void testToBuilder() {
    compareAvroOptions(AVRO_OPTIONS, AVRO_OPTIONS.toBuilder().build());
    AvroOptions avroOptions = AVRO_OPTIONS.toBuilder().setUseAvroLogicalTypes(false).build();
    assertEquals(false, avroOptions.useAvroLogicalTypes());
    avroOptions = avroOptions.toBuilder().setUseAvroLogicalTypes(true).build();
    compareAvroOptions(AVRO_OPTIONS, avroOptions);
  }

  @Test
  public void testBuilder() {
    assertEquals(FormatOptions.AVRO, AVRO_OPTIONS.getType());
    assertEquals(USE_AVRO_LOGICAL_TYPES, AVRO_OPTIONS.useAvroLogicalTypes());
  }

  @Test
  public void testToAndFromPb() {
    compareAvroOptions(AVRO_OPTIONS, AvroOptions.fromPb(AVRO_OPTIONS.toPb()));
    AvroOptions avroOptions =
        AvroOptions.newBuilder().setUseAvroLogicalTypes(USE_AVRO_LOGICAL_TYPES).build();
    compareAvroOptions(avroOptions, AvroOptions.fromPb(avroOptions.toPb()));
  }

  private void compareAvroOptions(AvroOptions expected, AvroOptions value) {
    assertEquals(expected, value);
    assertEquals(expected.useAvroLogicalTypes(), value.useAvroLogicalTypes());
  }
}
