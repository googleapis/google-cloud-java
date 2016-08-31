/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import static com.google.cloud.logging.Logging.EntryListOption;
import static com.google.cloud.logging.Logging.SortingField;
import static com.google.cloud.logging.Logging.SortingOrder;
import static com.google.cloud.logging.Logging.WriteOption;
import static org.junit.Assert.assertEquals;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.ListOption;
import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.util.Map;

public class LoggingTest {

  private static final int PAGE_SIZE = 42;
  private static final String PAGE_TOKEN = "page token";
  private static final String FILTER = "filter";
  private static final Map<String, String> LABELS = ImmutableMap.of("key", "value");
  private static final String LOG_NAME = "logName";
  private static final MonitoredResource RESOURCE =
      MonitoredResource.of("global", ImmutableMap.of("project_id", "p"));

  @Test
  public void testListOption() {
    // page token
    ListOption listOption = ListOption.pageToken(PAGE_TOKEN);
    assertEquals(PAGE_TOKEN, listOption.value());
    assertEquals(ListOption.OptionType.PAGE_TOKEN, listOption.optionType());
    // page size
    listOption = ListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, listOption.value());
    assertEquals(ListOption.OptionType.PAGE_SIZE, listOption.optionType());
  }

  @Test
  public void testEntryListOption() {
    EntryListOption listOption = EntryListOption.pageToken(PAGE_TOKEN);
    assertEquals(PAGE_TOKEN, listOption.value());
    assertEquals(EntryListOption.OptionType.PAGE_TOKEN, listOption.optionType());
    // page size
    listOption = EntryListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, listOption.value());
    assertEquals(EntryListOption.OptionType.PAGE_SIZE, listOption.optionType());
    // filter
    listOption = EntryListOption.filter(FILTER);
    assertEquals(FILTER, listOption.value());
    assertEquals(EntryListOption.OptionType.FILTER, listOption.optionType());
    // sort order
    listOption = EntryListOption.sortOrder(SortingField.TIMESTAMP, SortingOrder.ASCENDING);
    assertEquals("timestamp asc", listOption.value());
    assertEquals(EntryListOption.OptionType.ORDER_BY, listOption.optionType());
    listOption = EntryListOption.sortOrder(SortingField.TIMESTAMP, SortingOrder.DESCENDING);
    assertEquals("timestamp desc", listOption.value());
    assertEquals(EntryListOption.OptionType.ORDER_BY, listOption.optionType());
  }

  @Test
  public void testWriteOption() {
    WriteOption writeOption = WriteOption.labels(LABELS);
    assertEquals(LABELS, writeOption.value());
    assertEquals(WriteOption.OptionType.LABELS, writeOption.optionType());
    writeOption = WriteOption.logName(LOG_NAME);
    assertEquals(LOG_NAME, writeOption.value());
    assertEquals(WriteOption.OptionType.LOG_NAME, writeOption.optionType());
    writeOption = WriteOption.resource(RESOURCE);
    assertEquals(RESOURCE, writeOption.value());
    assertEquals(WriteOption.OptionType.RESOURCE, writeOption.optionType());
  }
}
