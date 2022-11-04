/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.logging;

import static org.junit.Assert.assertSame;

import com.google.api.client.util.Lists;
import com.google.cloud.Tuple;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InstrumentationTest {
  private static final StringPayload STRING_PAYLOAD = StringPayload.of("payload");
  private static final LogEntry STRING_ENTRY = LogEntry.newBuilder(STRING_PAYLOAD).build();
  private static final String JAVA_OTHER_NAME = "java-other";
  private static final String JAVA_INVALID_NAME = "no-java-name";
  private static final String JAVA_OTHER_VERSION = "0.0.0";

  @Test
  public void testInstrumentationGenerated() {
    Instrumentation.setInstrumentationStatus(false);
    verifyEntries(
        Instrumentation.populateInstrumentationInfo(ImmutableList.of(STRING_ENTRY)),
        1,
        2,
        new HashSet<>(Arrays.asList(Instrumentation.JAVA_LIBRARY_NAME_PREFIX)),
        new HashSet<>(Arrays.asList(Instrumentation.getLibraryVersion(Instrumentation.class))));
  }

  @Test
  public void testNoInstrumentationGenerated() {
    Instrumentation.setInstrumentationStatus(true);
    Tuple<Boolean, Iterable<LogEntry>> pair =
        Instrumentation.populateInstrumentationInfo(ImmutableList.of(STRING_ENTRY));
    ArrayList<LogEntry> entries = Lists.newArrayList(pair.y());
    Assert.assertFalse(pair.x());
    Assert.assertEquals(1, entries.size());
    assertSame(Payload.Type.STRING, entries.get(0).getPayload().getType());
  }

  @Test
  public void testInstrumentationUpdated() {
    Instrumentation.setInstrumentationStatus(false);
    LogEntry jsonEntry =
        LogEntry.newBuilder(generateInstrumentationPayload(JAVA_OTHER_NAME, JAVA_OTHER_VERSION))
            .build();
    verifyEntries(
        Instrumentation.populateInstrumentationInfo(ImmutableList.of(jsonEntry)),
        0,
        1,
        new HashSet<>(Arrays.asList(Instrumentation.JAVA_LIBRARY_NAME_PREFIX, JAVA_OTHER_NAME)),
        new HashSet<>(
            Arrays.asList(
                Instrumentation.getLibraryVersion(Instrumentation.class), JAVA_OTHER_VERSION)));
  }

  @Test
  public void testInvalidInstrumentationRemoved() {
    Instrumentation.setInstrumentationStatus(false);
    LogEntry jsonEntry =
        LogEntry.newBuilder(generateInstrumentationPayload(JAVA_INVALID_NAME, JAVA_OTHER_VERSION))
            .build();
    verifyEntries(
        Instrumentation.populateInstrumentationInfo(ImmutableList.of(jsonEntry)),
        0,
        1,
        new HashSet<>(Arrays.asList(Instrumentation.JAVA_LIBRARY_NAME_PREFIX)),
        new HashSet<>(Arrays.asList(Instrumentation.getLibraryVersion(Instrumentation.class))));
  }

  public static JsonPayload generateInstrumentationPayload(
      String libraryName, String libraryVersion) {
    Map<String, Object> jsonData = new HashMap<>();
    Map<String, Object> instrumentationData = new HashMap<>();
    Map<String, Object> info = new HashMap<>();
    info.put(Instrumentation.INSTRUMENTATION_NAME_KEY, libraryName);
    info.put(Instrumentation.INSTRUMENTATION_VERSION_KEY, libraryVersion);
    ImmutableList<Object> list = ImmutableList.<Object>of(info);
    instrumentationData.put(Instrumentation.INSTRUMENTATION_SOURCE_KEY, list);
    jsonData.put(Instrumentation.DIAGNOSTIC_INFO_KEY, instrumentationData);
    return JsonPayload.of(jsonData);
  }

  private static void verifyEntries(
      Tuple<Boolean, Iterable<LogEntry>> pair,
      int index,
      int expected,
      HashSet<String> names,
      HashSet<String> versions) {
    ArrayList<LogEntry> entries = Lists.newArrayList(pair.y());
    Assert.assertTrue(pair.x());
    Assert.assertEquals(expected, entries.size());
    assertSame(Payload.Type.JSON, entries.get(index).getPayload().getType());
    ListValue infoList =
        entries
            .get(index)
            .<Payload.JsonPayload>getPayload()
            .getData()
            .getFieldsOrThrow(Instrumentation.DIAGNOSTIC_INFO_KEY)
            .getStructValue()
            .getFieldsOrThrow(Instrumentation.INSTRUMENTATION_SOURCE_KEY)
            .getListValue();
    for (Value val : infoList.getValuesList()) {
      Assert.assertTrue(
          names.remove(
              val.getStructValue()
                  .getFieldsOrThrow(Instrumentation.INSTRUMENTATION_NAME_KEY)
                  .getStringValue()));
      Assert.assertTrue(
          versions.remove(
              val.getStructValue()
                  .getFieldsOrThrow(Instrumentation.INSTRUMENTATION_VERSION_KEY)
                  .getStringValue()));
    }
    Assert.assertEquals(0, names.size());
    Assert.assertEquals(0, versions.size());
  }
}
