/*
 * Copyright 2016 Google LLC
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
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.ListOption;
import com.google.common.collect.ImmutableMap;
import com.google.logging.v2.ListLogEntriesRequest;
import java.util.Map;
import org.junit.Test;

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
    assertEquals(PAGE_TOKEN, listOption.getValue());
    assertEquals(ListOption.OptionType.PAGE_TOKEN, listOption.getOptionType());
    // page size
    listOption = ListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, listOption.getValue());
    assertEquals(ListOption.OptionType.PAGE_SIZE, listOption.getOptionType());
  }

  @Test
  public void testEntryListOption() {
    EntryListOption listOption = EntryListOption.pageToken(PAGE_TOKEN);
    assertEquals(PAGE_TOKEN, listOption.getValue());
    assertEquals(ListOption.OptionType.PAGE_TOKEN, listOption.getOptionType());
    // page size
    listOption = EntryListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, listOption.getValue());
    assertEquals(ListOption.OptionType.PAGE_SIZE, listOption.getOptionType());
    // filter
    listOption = EntryListOption.filter(FILTER);
    assertEquals(FILTER, listOption.getValue());
    assertEquals(EntryListOption.OptionType.FILTER, listOption.getOptionType());
    // sort order
    listOption = EntryListOption.sortOrder(SortingField.TIMESTAMP, SortingOrder.ASCENDING);
    assertEquals("timestamp asc", listOption.getValue());
    assertEquals(EntryListOption.OptionType.ORDER_BY, listOption.getOptionType());
    listOption = EntryListOption.sortOrder(SortingField.TIMESTAMP, SortingOrder.DESCENDING);
    assertEquals("timestamp desc", listOption.getValue());
    assertEquals(EntryListOption.OptionType.ORDER_BY, listOption.getOptionType());

    ListLogEntriesRequest request =
        LoggingImpl.listLogEntriesRequest(
            "some-project-id",
            LoggingImpl.optionMap(
                EntryListOption.pageToken(PAGE_TOKEN),
                EntryListOption.pageSize(PAGE_SIZE),
                EntryListOption.organization("test-org"),
                EntryListOption.billingAccount("test-account"),
                EntryListOption.folder("test-folder")));
    assertThat(request.getPageToken()).isEqualTo(PAGE_TOKEN);
    assertThat(request.getPageSize()).isEqualTo(PAGE_SIZE);
    assertThat(request.getResourceNamesList())
        .containsExactly(
            "projects/some-project-id",
            "organizations/test-org",
            "billingAccounts/test-account",
            "folders/test-folder");
  }

  @Test
  public void testWriteOption() {
    WriteOption writeOption = WriteOption.labels(LABELS);
    assertEquals(LABELS, writeOption.getValue());
    assertEquals(WriteOption.OptionType.LABELS, writeOption.getOptionType());
    writeOption = WriteOption.logName(LOG_NAME);
    assertEquals(LOG_NAME, writeOption.getValue());
    assertEquals(WriteOption.OptionType.LOG_NAME, writeOption.getOptionType());
    writeOption = WriteOption.resource(RESOURCE);
    assertEquals(RESOURCE, writeOption.getValue());
    assertEquals(WriteOption.OptionType.RESOURCE, writeOption.getOptionType());
  }
}
