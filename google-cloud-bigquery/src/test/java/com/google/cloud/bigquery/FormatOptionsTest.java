/*
 * Copyright 2015 Google LLC
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

public class FormatOptionsTest {

  @Test
  public void testConstructor() {
    FormatOptions options = new FormatOptions(FormatOptions.CSV);
    assertEquals(FormatOptions.CSV, options.getType());
    options = new FormatOptions(FormatOptions.JSON);
    assertEquals(FormatOptions.JSON, options.getType());
    options = new FormatOptions(FormatOptions.DATASTORE_BACKUP);
    assertEquals(FormatOptions.DATASTORE_BACKUP, options.getType());
    options = new FormatOptions(FormatOptions.AVRO);
    assertEquals(FormatOptions.AVRO, options.getType());
  }

  @Test
  public void testFactoryMethods() {
    assertEquals(FormatOptions.CSV, FormatOptions.csv().getType());
    assertEquals(FormatOptions.JSON, FormatOptions.json().getType());
    assertEquals(FormatOptions.DATASTORE_BACKUP, FormatOptions.datastoreBackup().getType());
    assertEquals(FormatOptions.AVRO, FormatOptions.avro().getType());
    assertEquals(FormatOptions.GOOGLE_SHEETS, FormatOptions.googleSheets().getType());
    assertEquals(FormatOptions.ICEBERG, FormatOptions.iceberg().getType());
  }

  @Test
  public void testEquals() {
    assertEquals(FormatOptions.csv(), FormatOptions.csv());
    assertEquals(FormatOptions.csv().hashCode(), FormatOptions.csv().hashCode());
    assertEquals(FormatOptions.json(), FormatOptions.json());
    assertEquals(FormatOptions.json().hashCode(), FormatOptions.json().hashCode());
    assertEquals(FormatOptions.datastoreBackup(), FormatOptions.datastoreBackup());
    assertEquals(
        FormatOptions.datastoreBackup().hashCode(), FormatOptions.datastoreBackup().hashCode());
    assertEquals(FormatOptions.googleSheets(), FormatOptions.googleSheets());
    assertEquals(FormatOptions.iceberg(), FormatOptions.iceberg());
  }
}
