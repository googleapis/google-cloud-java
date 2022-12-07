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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.EntryListOption;
import com.google.cloud.logging.Logging.ListOption;
import com.google.cloud.logging.Logging.SortingField;
import com.google.cloud.logging.Logging.SortingOrder;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.common.collect.ImmutableMap;
import com.google.logging.v2.ListLogEntriesRequest;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LoggingTest {

  private static final int PAGE_SIZE = 42;
  private static final String PAGE_TOKEN = "page token";
  private static final String FILTER = "filter";
  private static final ImmutableMap<String, String> LABELS = ImmutableMap.of("key", "value");
  private static final String LOG_NAME = "logName";
  private static final MonitoredResource RESOURCE =
      MonitoredResource.of("global", ImmutableMap.of("project_id", "p"));
  private static final String PROJECT_NAME = "project";
  private static final String FOLDER_NAME = "folder";
  private static final String ORGANIZATION_NAME = "organization";
  private static final String BILLING_NAME = "billing";
  private static final Boolean DONT_AUTO_POPULATE_METADATA = false;
  private static final Boolean DO_PARTIAL_SUCCESS = false;

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
  public void testFilterUpdate() {
    Map<Option.OptionType, ?> options = LoggingImpl.optionMap(EntryListOption.filter(FILTER));
    assertThat((String) EntryListOption.OptionType.FILTER.get(options)).isEqualTo(FILTER);
    Map<Option.OptionType, ?> updated = LoggingImpl.updateFilter(options);
    assertTrue(((String) EntryListOption.OptionType.FILTER.get(updated)).contains("timestamp"));
    assertFalse(options == updated);
    assertNotEquals(EntryListOption.OptionType.FILTER.get(updated), FILTER);
    Map<Option.OptionType, ?> anotherUpdated = LoggingImpl.updateFilter(updated);
    assertTrue(anotherUpdated == updated);
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

    writeOption = WriteOption.autoPopulateMetadata(DONT_AUTO_POPULATE_METADATA);
    assertEquals(DONT_AUTO_POPULATE_METADATA, writeOption.getValue());
    assertEquals(WriteOption.OptionType.AUTO_POPULATE_METADATA, writeOption.getOptionType());

    writeOption = WriteOption.partialSuccess(DO_PARTIAL_SUCCESS);
    assertEquals(DO_PARTIAL_SUCCESS, writeOption.getValue());
    assertEquals(WriteOption.OptionType.PARTIAL_SUCCESS, writeOption.getOptionType());
  }

  @Test
  public void testWriteOptionWithDestination() {
    WriteOption writeOption = WriteOption.destination(LogDestinationName.project(PROJECT_NAME));
    LogDestinationName resource = (LogDestinationName) writeOption.getValue();
    assertEquals(WriteOption.OptionType.LOG_DESTINATION, writeOption.getOptionType());
    assertEquals(LogDestinationName.DestinationType.PROJECT, resource.getDestinationType());
    assertEquals(PROJECT_NAME, resource.getDestinationId());

    writeOption = WriteOption.destination(LogDestinationName.billingAccount(BILLING_NAME));
    resource = (LogDestinationName) writeOption.getValue();
    assertEquals(WriteOption.OptionType.LOG_DESTINATION, writeOption.getOptionType());
    assertEquals(LogDestinationName.DestinationType.BILLINGACCOUNT, resource.getDestinationType());
    assertEquals(BILLING_NAME, resource.getDestinationId());

    writeOption = WriteOption.destination(LogDestinationName.folder(FOLDER_NAME));
    resource = (LogDestinationName) writeOption.getValue();
    assertEquals(WriteOption.OptionType.LOG_DESTINATION, writeOption.getOptionType());
    assertEquals(LogDestinationName.DestinationType.FOLDER, resource.getDestinationType());
    assertEquals(FOLDER_NAME, resource.getDestinationId());

    writeOption = WriteOption.destination(LogDestinationName.organization(ORGANIZATION_NAME));
    resource = (LogDestinationName) writeOption.getValue();
    assertEquals(WriteOption.OptionType.LOG_DESTINATION, writeOption.getOptionType());
    assertEquals(LogDestinationName.DestinationType.ORGANIZATION, resource.getDestinationType());
    assertEquals(ORGANIZATION_NAME, resource.getDestinationId());
  }
}
