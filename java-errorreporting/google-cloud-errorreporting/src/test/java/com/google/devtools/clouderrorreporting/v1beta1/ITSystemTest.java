/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.devtools.clouderrorreporting.v1beta1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.ServiceOptions;
import com.google.common.collect.Lists;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static ErrorGroupServiceClient errorGroupServiceClient;
  private static ReportErrorsServiceClient reportErrorsServiceClient;
  private static ErrorStatsServiceClient errorStatsServiceClient;

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final ProjectName PROJECT_NAME = ProjectName.of(PROJECT_ID);
  private static final QueryTimeRange TIME_RANGE = QueryTimeRange.newBuilder().build();

  @BeforeClass
  public static void beforeClass() throws Exception {
    errorGroupServiceClient = ErrorGroupServiceClient.create();
    errorStatsServiceClient = ErrorStatsServiceClient.create();
    reportErrorsServiceClient = ReportErrorsServiceClient.create();
  }

  @AfterClass
  public static void afterClass() {
    errorGroupServiceClient.close();
    errorStatsServiceClient.close();
    reportErrorsServiceClient.close();
  }

  @Test
  public void listGroupStatsTest() {
    ErrorStatsServiceClient.ListGroupStatsPagedResponse pagedListResponse =
        errorStatsServiceClient.listGroupStats(PROJECT_NAME, TIME_RANGE);
    List<ErrorGroupStats> errorGroupStats = Lists.newArrayList(pagedListResponse.iterateAll());
    if (errorGroupStats.size() > 0) {
      ErrorGroup group =
          errorGroupServiceClient.getGroup(errorGroupStats.get(0).getGroup().getName());
      assertNotNull(group);
      assertEquals(errorGroupStats.get(0).getGroup(), group);
      assertEquals(errorGroupStats.get(0).getGroup().getGroupId(), group.getGroupId());
      assertEquals(errorGroupStats.get(0).getGroup().getName(), group.getName());
    }
  }

  @Test
  public void listEventsTest() {
    ErrorStatsServiceClient.ListGroupStatsPagedResponse pagedListResponse =
        errorStatsServiceClient.listGroupStats(PROJECT_NAME, TIME_RANGE);
    List<ErrorGroupStats> errorGroupStats = Lists.newArrayList(pagedListResponse.iterateAll());
    if (errorGroupStats.size() > 0) {
      Iterable<ErrorEvent> errorEvent =
          errorStatsServiceClient
              .listEvents(PROJECT_NAME, errorGroupStats.get(0).getGroup().getGroupId())
              .iterateAll();
      assertNotNull(errorEvent);
      assertTrue(errorEvent.iterator().hasNext());
      assertNotNull(errorEvent.iterator().next());
    }
  }

  @Test
  public void getGroupTest() {
    ErrorStatsServiceClient.ListGroupStatsPagedResponse pagedListResponse =
        errorStatsServiceClient.listGroupStats(PROJECT_NAME, TIME_RANGE);
    List<ErrorGroupStats> errorGroupStats = Lists.newArrayList(pagedListResponse.iterateAll());
    if (errorGroupStats.size() > 0) {
      ErrorGroup group =
          errorGroupServiceClient.getGroup(errorGroupStats.get(0).getGroup().getName());
      assertNotNull(group);
      assertEquals(errorGroupStats.get(0).getGroup(), group);
      assertEquals(errorGroupStats.get(0).getGroup().getGroupId(), group.getGroupId());
      assertEquals(errorGroupStats.get(0).getGroup().getName(), group.getName());
    }
  }

  @Test(expected = InvalidArgumentException.class)
  public void getGroupExceptionTest() {
    ErrorGroupName errorGroupName = ErrorGroupName.of(PROJECT_ID, "DUMMY-GROUP");
    errorGroupServiceClient.getGroup(errorGroupName);
  }

  @Test
  public void reportErrorEventTest() {
    String message =
        "{\n"
            + "  \"context\": {\n"
            + "    \"httpRequest\": {\n"
            + "      \"responseStatusCode\": 500,\n"
            + "      \"method\": \"GET\",\n"
            + "      \"url\": \"http://example.com/product\"\n"
            + "    },\n"
            + "    \"user\": \"2247177\"\n"
            + "  },\n"
            + "  \"message\": \"org.springframework.web.client.HttpServerErrorException:  500 Server Error\n"
            + "  at org.springframework.web.client.DefaultResponseErrorHandler.handleError(DefaultResponseErrorHandler.java: 94)\n"
            + "  \",\n"
            + "  \"serviceContext\": {\n"
            + "    \"service\": \"cart\",\n"
            + "    \"version\": \"\"\n"
            + "  }";
    ReportedErrorEvent event = ReportedErrorEvent.newBuilder().setMessage(message).build();
    ReportErrorEventResponse errorEventResponse =
        reportErrorsServiceClient.reportErrorEvent(PROJECT_NAME, event);
    assertNotNull(errorEventResponse);
    assertTrue(errorEventResponse.isInitialized());
  }

  @Test(expected = InvalidArgumentException.class)
  public void reportErrorEventExceptionTest() {
    ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();
    reportErrorsServiceClient.reportErrorEvent(PROJECT_NAME, event);
  }
}
