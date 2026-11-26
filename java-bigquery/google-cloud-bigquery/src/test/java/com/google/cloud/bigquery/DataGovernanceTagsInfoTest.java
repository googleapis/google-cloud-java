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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.Data;
import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.common.collect.ImmutableMap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class DataGovernanceTagsInfoTest {

  private static final Map<String, String> TAGS = ImmutableMap.of("myProject/pii", "sensitive");
  private static final DataGovernanceTagsInfo TAGS_INFO =
      DataGovernanceTagsInfo.newBuilder().setDataGovernanceTags(TAGS).build();

  @Test
  void testBuilderAndOf() {
    assertEquals(TAGS, TAGS_INFO.getDataGovernanceTags());
    assertEquals(TAGS_INFO, DataGovernanceTagsInfo.of(TAGS));
    compareDataGovernanceTagsInfo(TAGS_INFO, TAGS_INFO.toBuilder().build());
  }

  @Test
  void testDefensiveCopyAndImmutability() {
    Map<String, String> mutableInput = new HashMap<>();
    mutableInput.put("myProject/pii", "sensitive");
    DataGovernanceTagsInfo info = DataGovernanceTagsInfo.of(mutableInput);
    mutableInput.put("myProject/other", "public");

    assertEquals(TAGS, info.getDataGovernanceTags());
    assertThrows(
        UnsupportedOperationException.class,
        () -> info.getDataGovernanceTags().put("another/key", "value"));
  }

  @Test
  void testEmptyBuilderAndPatchClearingSemantics() throws Exception {
    DataGovernanceTagsInfo emptyFromBuilder = DataGovernanceTagsInfo.newBuilder().build();
    DataGovernanceTagsInfo emptyFromMap = DataGovernanceTagsInfo.of(Collections.emptyMap());

    assertTrue(emptyFromBuilder.getDataGovernanceTags().isEmpty());
    compareDataGovernanceTagsInfo(emptyFromBuilder, emptyFromMap);
    compareDataGovernanceTagsInfo(
        emptyFromBuilder, DataGovernanceTagsInfo.fromPb(emptyFromBuilder.toPb()));

    GsonFactory gsonFactory = GsonFactory.getDefaultInstance();

    // Unset on Field: dataGovernanceTagsInfo must be omitted from JSON to preserve tags on patch.
    Field unsetField = Field.of("col", StandardSQLTypeName.STRING);
    String unsetJson = gsonFactory.toString(unsetField.toPb());
    assertFalse(unsetJson.contains("dataGovernanceTagsInfo"));

    // Empty DataGovernanceTagsInfo on Field: emits `"dataGovernanceTagsInfo":{}` to clear tags.
    Field clearField =
        Field.newBuilder("col", StandardSQLTypeName.STRING)
            .setDataGovernanceTagsInfo(emptyFromBuilder)
            .build();
    String clearJson = gsonFactory.toString(clearField.toPb());
    assertTrue(clearJson.contains("\"dataGovernanceTagsInfo\":{}"));

    TableFieldSchema parsedClearPb = gsonFactory.fromString(clearJson, TableFieldSchema.class);
    Field roundTrippedClearField = Field.fromPb(parsedClearPb);
    assertEquals(clearField, roundTrippedClearField);
    assertEquals(emptyFromBuilder, roundTrippedClearField.getDataGovernanceTagsInfo());
  }

  @Test
  void testPopulatedJsonRoundTrip() throws Exception {
    GsonFactory gsonFactory = GsonFactory.getDefaultInstance();
    Field taggedField =
        Field.newBuilder("ssn", StandardSQLTypeName.STRING)
            .setDataGovernanceTagsInfo(TAGS_INFO)
            .build();

    String json = gsonFactory.toString(taggedField.toPb());
    assertTrue(
        json.contains(
            "\"dataGovernanceTagsInfo\":{\"dataGovernanceTags\":{\"myProject/pii\":\"sensitive\"}}"));

    TableFieldSchema parsedPb = gsonFactory.fromString(json, TableFieldSchema.class);
    Field roundTripped = Field.fromPb(parsedPb);
    assertEquals(taggedField, roundTripped);
    assertEquals(TAGS_INFO, roundTripped.getDataGovernanceTagsInfo());
  }

  @Test
  void testFromPbNullHandling() {
    assertNull(DataGovernanceTagsInfo.fromPb(null));
    assertNull(
        DataGovernanceTagsInfo.fromPb(Data.nullOf(TableFieldSchema.DataGovernanceTagsInfo.class)));

    TableFieldSchema.DataGovernanceTagsInfo pbWithJsonNullMap =
        new TableFieldSchema.DataGovernanceTagsInfo()
            .setDataGovernanceTags(Data.nullOf(HashMap.class));
    DataGovernanceTagsInfo parsed = DataGovernanceTagsInfo.fromPb(pbWithJsonNullMap);
    assertEquals(DataGovernanceTagsInfo.newBuilder().build(), parsed);
  }

  @Test
  void testNullInputRejected() {
    assertThrows(NullPointerException.class, () -> DataGovernanceTagsInfo.of(null));
    assertThrows(
        NullPointerException.class,
        () -> DataGovernanceTagsInfo.newBuilder().setDataGovernanceTags(null));
  }

  @Test
  void testJavaSerialization() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(TAGS_INFO);
    }
    DataGovernanceTagsInfo deserialized;
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      deserialized = (DataGovernanceTagsInfo) ois.readObject();
    }
    compareDataGovernanceTagsInfo(TAGS_INFO, deserialized);
  }

  private void compareDataGovernanceTagsInfo(
      DataGovernanceTagsInfo expected, DataGovernanceTagsInfo actual) {
    assertEquals(expected, actual);
    assertEquals(expected.getDataGovernanceTags(), actual.getDataGovernanceTags());
    assertEquals(expected.hashCode(), actual.hashCode());
    assertEquals(expected.toString(), actual.toString());
  }
}
