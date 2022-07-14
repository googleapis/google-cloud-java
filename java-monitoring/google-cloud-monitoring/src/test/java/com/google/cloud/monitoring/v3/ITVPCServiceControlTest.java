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

// DO NOT MODIFY! THIS FILE IS AUTO-GENERATED.
// This file is auto-generated on 28 Jan 20 00:11 UTC.

package com.google.cloud.monitoring.v3;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.ImmutableList;
import com.google.monitoring.v3.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by Google")
public class ITVPCServiceControlTest {
  static final String PROJECT_INSIDE = System.getenv("PROJECT_ID");
  static final String PROJECT_OUTSIDE =
      System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
  static final String IS_INSIDE_VPCSC = System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC");
  static final String COLLECTD_TIME_SERIES_REQUEST_TEMPLATE = "{ \"name\": \"%s\" }";
  private static final Logger logger = Logger.getLogger(ITVPCServiceControlTest.class.getName());

  private static Exception getError(Callable callable) {
    try {
      callable.call();
    } catch (Exception e) {
      logger.log(Level.INFO, e.getMessage());
      return e;
    }
    return null;
  }

  private static void doTest(Callable delayedInside, Callable delayedOutside) {
    if ((IS_INSIDE_VPCSC != null) && (IS_INSIDE_VPCSC.equalsIgnoreCase("true"))) {
      logger.log(Level.INFO, "inside perimeter");
      Exception e = getError(delayedOutside);
      Assert.assertTrue(
          PermissionDeniedException.class.isInstance(e)
              && e.getMessage().contains("Request is prohibited by organization's policy"));
      e = getError(delayedInside);
      Assert.assertFalse(
          PermissionDeniedException.class.isInstance(e)
              && e.getMessage().contains("Request is prohibited by organization's policy"));
    } else {
      logger.log(Level.INFO, "outside perimeter");
      Exception e = getError(delayedOutside);
      Assert.assertFalse(
          PermissionDeniedException.class.isInstance(e)
              && e.getMessage().contains("Request is prohibited by organization's policy"));
      e = getError(delayedInside);
      Assert.assertTrue(
          PermissionDeniedException.class.isInstance(e)
              && e.getMessage().contains("Request is prohibited by organization's policy"));
    }
  }

  @BeforeClass
  public static void setUpClass() {
    Assume.assumeTrue(
        "Missing environment variable: PROJECT_ID",
        PROJECT_INSIDE != null && !PROJECT_INSIDE.isEmpty());
    Assume.assumeTrue(
        "Missing environment variable: GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT",
        PROJECT_OUTSIDE != null && !PROJECT_OUTSIDE.isEmpty());
  }

  private static void postJSON(URL url, String payload) throws Exception {
    GoogleCredentials adc =
        GoogleCredentials.getApplicationDefault()
            .createScoped(
                ImmutableList.of(
                    "https://www.googleapis.com/auth/monitoring",
                    "https://www.googleapis.com/auth/monitoring.write",
                    "https://www.googleapis.com/auth/cloud-platform"));
    adc.refresh();

    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Authorization", "Bearer " + adc.getAccessToken().getTokenValue());
    conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    conn.setRequestProperty("Accept", "application/json, */*");
    conn.setDoOutput(true);

    OutputStream body = conn.getOutputStream();
    body.write(payload.getBytes("UTF-8"));
    body.close();

    conn.getResponseMessage();

    BufferedReader reader =
        new BufferedReader(new InputStreamReader((InputStream) conn.getErrorStream()));
    StringBuilder response = new StringBuilder();

    for (String line; (line = reader.readLine()) != null; ) {
      response.append(line).append("\n");
    }

    if (conn.getResponseCode() == 403) {
      throw new PermissionDeniedException(
          response.toString(),
          null,
          GrpcStatusCode.of(io.grpc.Status.Code.PERMISSION_DENIED),
          false);
    } else if (conn.getResponseCode() != 200) {
      throw new RuntimeException(response.toString());
    }
    return;
  }

  @Test
  @SuppressWarnings("all")
  public void collectdTimeSeriesTest() throws Exception {
    final String prefix = "https://monitoring.googleapis.com/v3/";
    final String endpoint = "/collectdTimeSeries";

    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            URL url = new URL(prefix + nameInside.toString() + endpoint);
            logger.log(Level.INFO, "collectdTimeSeriesTest: requesting {0}", url.toString());
            postJSON(
                url, String.format(COLLECTD_TIME_SERIES_REQUEST_TEMPLATE, nameInside.toString()));
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            URL url = new URL(prefix + nameOutside.toString() + endpoint);
            logger.log(Level.INFO, "collectdTimeSeriesTest: requesting {0}", url.toString());
            postJSON(
                url, String.format(COLLECTD_TIME_SERIES_REQUEST_TEMPLATE, nameOutside.toString()));
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      // no clean up
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "createAlertPolicyTest: requesting {0}", nameInside);
            client.createAlertPolicy(
                CreateAlertPolicyRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "createAlertPolicyTest: requesting {0}", nameOutside);
            client.createAlertPolicy(
                CreateAlertPolicyRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            AlertPolicyName nameInside = AlertPolicyName.of(PROJECT_INSIDE, "MockAlertPolicy");
            logger.log(Level.INFO, "deleteAlertPolicyTest: requesting {0}", nameInside);
            client.deleteAlertPolicy(
                DeleteAlertPolicyRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            AlertPolicyName nameOutside = AlertPolicyName.of(PROJECT_OUTSIDE, "MockAlertPolicy");
            logger.log(Level.INFO, "deleteAlertPolicyTest: requesting {0}", nameOutside);
            client.deleteAlertPolicy(
                DeleteAlertPolicyRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            AlertPolicyName nameInside = AlertPolicyName.of(PROJECT_INSIDE, "MockAlertPolicy");
            logger.log(Level.INFO, "getAlertPolicyTest: requesting {0}", nameInside);
            client.getAlertPolicy(
                GetAlertPolicyRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            AlertPolicyName nameOutside = AlertPolicyName.of(PROJECT_OUTSIDE, "MockAlertPolicy");
            logger.log(Level.INFO, "getAlertPolicyTest: requesting {0}", nameOutside);
            client.getAlertPolicy(
                GetAlertPolicyRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAlertPoliciesTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "listAlertPoliciesTest: requesting {0}", nameInside);
            client.listAlertPolicies(
                ListAlertPoliciesRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "listAlertPoliciesTest: requesting {0}", nameOutside);
            client.listAlertPolicies(
                ListAlertPoliciesRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            AlertPolicyName nameInside = AlertPolicyName.of(PROJECT_INSIDE, "MockAlertPolicy");
            logger.log(Level.INFO, "updateAlertPolicyTest: requesting {0}", nameInside);
            client.updateAlertPolicy(
                UpdateAlertPolicyRequest.newBuilder()
                    .setAlertPolicy(AlertPolicy.newBuilder().setName(nameInside.toString()).build())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            AlertPolicyName nameOutside = AlertPolicyName.of(PROJECT_OUTSIDE, "MockAlertPolicy");
            logger.log(Level.INFO, "updateAlertPolicyTest: requesting {0}", nameOutside);
            client.updateAlertPolicy(
                UpdateAlertPolicyRequest.newBuilder()
                    .setAlertPolicy(
                        AlertPolicy.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "createGroupTest: requesting {0}", nameInside);
            client.createGroup(
                CreateGroupRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "createGroupTest: requesting {0}", nameOutside);
            client.createGroup(
                CreateGroupRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
            logger.log(Level.INFO, "deleteGroupTest: requesting {0}", nameInside);
            client.deleteGroup(
                DeleteGroupRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameOutside = GroupName.of(PROJECT_OUTSIDE, "MockGroup");
            logger.log(Level.INFO, "deleteGroupTest: requesting {0}", nameOutside);
            client.deleteGroup(
                DeleteGroupRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
            logger.log(Level.INFO, "getGroupTest: requesting {0}", nameInside);
            client.getGroup(GetGroupRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameOutside = GroupName.of(PROJECT_OUTSIDE, "MockGroup");
            logger.log(Level.INFO, "getGroupTest: requesting {0}", nameOutside);
            client.getGroup(GetGroupRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupMembersTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
            logger.log(Level.INFO, "listGroupMembersTest: requesting {0}", nameInside);
            client.listGroupMembers(
                ListGroupMembersRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameOutside = GroupName.of(PROJECT_OUTSIDE, "MockGroup");
            logger.log(Level.INFO, "listGroupMembersTest: requesting {0}", nameOutside);
            client.listGroupMembers(
                ListGroupMembersRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupsTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "listGroupsTest: requesting {0}", nameInside);
            client.listGroups(
                ListGroupsRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "listGroupsTest: requesting {0}", nameOutside);
            client.listGroups(
                ListGroupsRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
            logger.log(Level.INFO, "updateGroupTest: requesting {0}", nameInside);
            client.updateGroup(
                UpdateGroupRequest.newBuilder()
                    .setGroup(Group.newBuilder().setName(nameInside.toString()).build())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameOutside = GroupName.of(PROJECT_OUTSIDE, "MockGroup");
            logger.log(Level.INFO, "updateGroupTest: requesting {0}", nameOutside);
            client.updateGroup(
                UpdateGroupRequest.newBuilder()
                    .setGroup(Group.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createMetricDescriptorTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "createMetricDescriptorTest: requesting {0}", nameInside);
            client.createMetricDescriptor(
                CreateMetricDescriptorRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "createMetricDescriptorTest: requesting {0}", nameOutside);
            client.createMetricDescriptor(
                CreateMetricDescriptorRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createTimeSeriesTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "createTimeSeriesTest: requesting {0}", nameInside);
            client.createTimeSeries(nameInside, new ArrayList<TimeSeries>());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "createTimeSeriesTest: requesting {0}", nameOutside);
            client.createTimeSeries(nameOutside, new ArrayList<TimeSeries>());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteMetricDescriptorTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            MetricDescriptorName nameInside =
                MetricDescriptorName.of(PROJECT_INSIDE, "MockMetricDescriptor");
            logger.log(Level.INFO, "deleteMetricDescriptorTest: requesting {0}", nameInside);
            client.deleteMetricDescriptor(
                DeleteMetricDescriptorRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            MetricDescriptorName nameOutside =
                MetricDescriptorName.of(PROJECT_OUTSIDE, "MockMetricDescriptor");
            logger.log(Level.INFO, "deleteMetricDescriptorTest: requesting {0}", nameOutside);
            client.deleteMetricDescriptor(
                DeleteMetricDescriptorRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getMetricDescriptorTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            MetricDescriptorName nameInside =
                MetricDescriptorName.of(PROJECT_INSIDE, "MockMetricDescriptor");
            logger.log(Level.INFO, "getMetricDescriptorTest: requesting {0}", nameInside);
            client.getMetricDescriptor(
                GetMetricDescriptorRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            MetricDescriptorName nameOutside =
                MetricDescriptorName.of(PROJECT_OUTSIDE, "MockMetricDescriptor");
            logger.log(Level.INFO, "getMetricDescriptorTest: requesting {0}", nameOutside);
            client.getMetricDescriptor(
                GetMetricDescriptorRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getMonitoredResourceDescriptorTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            MonitoredResourceDescriptorName nameInside =
                MonitoredResourceDescriptorName.of(
                    PROJECT_INSIDE, "MockMonitoredResourceDescriptor");
            logger.log(
                Level.INFO, "getMonitoredResourceDescriptorTest: requesting {0}", nameInside);
            client.getMonitoredResourceDescriptor(
                GetMonitoredResourceDescriptorRequest.newBuilder()
                    .setName(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            MonitoredResourceDescriptorName nameOutside =
                MonitoredResourceDescriptorName.of(
                    PROJECT_OUTSIDE, "MockMonitoredResourceDescriptor");
            logger.log(
                Level.INFO, "getMonitoredResourceDescriptorTest: requesting {0}", nameOutside);
            client.getMonitoredResourceDescriptor(
                GetMonitoredResourceDescriptorRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listMetricDescriptorsTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "listMetricDescriptorsTest: requesting {0}", nameInside);
            client.listMetricDescriptors(
                ListMetricDescriptorsRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "listMetricDescriptorsTest: requesting {0}", nameOutside);
            client.listMetricDescriptors(
                ListMetricDescriptorsRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listMonitoredResourceDescriptorsTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(
                Level.INFO, "listMonitoredResourceDescriptorsTest: requesting {0}", nameInside);
            client.listMonitoredResourceDescriptors(
                ListMonitoredResourceDescriptorsRequest.newBuilder()
                    .setName(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(
                Level.INFO, "listMonitoredResourceDescriptorsTest: requesting {0}", nameOutside);
            client.listMonitoredResourceDescriptors(
                ListMonitoredResourceDescriptorsRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTimeSeriesTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "listTimeSeriesTest: requesting {0}", nameInside);
            client.listTimeSeries(
                ListTimeSeriesRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "listTimeSeriesTest: requesting {0}", nameOutside);
            client.listTimeSeries(
                ListTimeSeriesRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createNotificationChannelTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "createNotificationChannelTest: requesting {0}", nameInside);
            client.createNotificationChannel(
                CreateNotificationChannelRequest.newBuilder()
                    .setName(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "createNotificationChannelTest: requesting {0}", nameOutside);
            client.createNotificationChannel(
                CreateNotificationChannelRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNotificationChannelTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            NotificationChannelName nameInside =
                NotificationChannelName.of(PROJECT_INSIDE, "MockNotificationChannel");
            logger.log(Level.INFO, "deleteNotificationChannelTest: requesting {0}", nameInside);
            client.deleteNotificationChannel(
                DeleteNotificationChannelRequest.newBuilder()
                    .setName(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            NotificationChannelName nameOutside =
                NotificationChannelName.of(PROJECT_OUTSIDE, "MockNotificationChannel");
            logger.log(Level.INFO, "deleteNotificationChannelTest: requesting {0}", nameOutside);
            client.deleteNotificationChannel(
                DeleteNotificationChannelRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getNotificationChannelTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            NotificationChannelName nameInside =
                NotificationChannelName.of(PROJECT_INSIDE, "MockNotificationChannel");
            logger.log(Level.INFO, "getNotificationChannelTest: requesting {0}", nameInside);
            client.getNotificationChannel(
                GetNotificationChannelRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            NotificationChannelName nameOutside =
                NotificationChannelName.of(PROJECT_OUTSIDE, "MockNotificationChannel");
            logger.log(Level.INFO, "getNotificationChannelTest: requesting {0}", nameOutside);
            client.getNotificationChannel(
                GetNotificationChannelRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getNotificationChannelDescriptorTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            NotificationChannelDescriptorName nameInside =
                NotificationChannelDescriptorName.of(
                    PROJECT_INSIDE, "MockNotificationChannelDescriptor");
            logger.log(
                Level.INFO, "getNotificationChannelDescriptorTest: requesting {0}", nameInside);
            client.getNotificationChannelDescriptor(
                GetNotificationChannelDescriptorRequest.newBuilder()
                    .setName(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            NotificationChannelDescriptorName nameOutside =
                NotificationChannelDescriptorName.of(
                    PROJECT_OUTSIDE, "MockNotificationChannelDescriptor");
            logger.log(
                Level.INFO, "getNotificationChannelDescriptorTest: requesting {0}", nameOutside);
            client.getNotificationChannelDescriptor(
                GetNotificationChannelDescriptorRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listNotificationChannelDescriptorsTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(
                Level.INFO, "listNotificationChannelDescriptorsTest: requesting {0}", nameInside);
            client.listNotificationChannelDescriptors(
                ListNotificationChannelDescriptorsRequest.newBuilder()
                    .setName(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(
                Level.INFO, "listNotificationChannelDescriptorsTest: requesting {0}", nameOutside);
            client.listNotificationChannelDescriptors(
                ListNotificationChannelDescriptorsRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listNotificationChannelsTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "listNotificationChannelsTest: requesting {0}", nameInside);
            client.listNotificationChannels(
                ListNotificationChannelsRequest.newBuilder()
                    .setName(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "listNotificationChannelsTest: requesting {0}", nameOutside);
            client.listNotificationChannels(
                ListNotificationChannelsRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateNotificationChannelTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            NotificationChannelName nameInside =
                NotificationChannelName.of(PROJECT_INSIDE, "MockNotificationChannel");
            logger.log(Level.INFO, "updateNotificationChannelTest: requesting {0}", nameInside);
            client.updateNotificationChannel(
                UpdateNotificationChannelRequest.newBuilder()
                    .setNotificationChannel(
                        NotificationChannel.newBuilder().setName(nameInside.toString()).build())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            NotificationChannelName nameOutside =
                NotificationChannelName.of(PROJECT_OUTSIDE, "MockNotificationChannel");
            logger.log(Level.INFO, "updateNotificationChannelTest: requesting {0}", nameOutside);
            client.updateNotificationChannel(
                UpdateNotificationChannelRequest.newBuilder()
                    .setNotificationChannel(
                        NotificationChannel.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createServiceTest() throws Exception {
    final ServiceMonitoringServiceClient client = ServiceMonitoringServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "createServiceTest: requesting {0}", nameInside);
            client.createService(
                CreateServiceRequest.newBuilder().setParent(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "createServiceTest: requesting {0}", nameOutside);
            client.createService(
                CreateServiceRequest.newBuilder().setParent(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createServiceLevelObjectiveTest() throws Exception {
    final ServiceMonitoringServiceClient client = ServiceMonitoringServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ServiceName nameInside = ServiceName.of(PROJECT_INSIDE, "MockService");
            logger.log(Level.INFO, "createServiceLevelObjectiveTest: requesting {0}", nameInside);
            client.createServiceLevelObjective(
                CreateServiceLevelObjectiveRequest.newBuilder()
                    .setParent(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ServiceName nameOutside = ServiceName.of(PROJECT_OUTSIDE, "MockService");
            logger.log(Level.INFO, "createServiceLevelObjectiveTest: requesting {0}", nameOutside);
            client.createServiceLevelObjective(
                CreateServiceLevelObjectiveRequest.newBuilder()
                    .setParent(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteServiceTest() throws Exception {
    final ServiceMonitoringServiceClient client = ServiceMonitoringServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ServiceName nameInside = ServiceName.of(PROJECT_INSIDE, "MockService");
            logger.log(Level.INFO, "deleteServiceTest: requesting {0}", nameInside);
            client.deleteService(
                DeleteServiceRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ServiceName nameOutside = ServiceName.of(PROJECT_OUTSIDE, "MockService");
            logger.log(Level.INFO, "deleteServiceTest: requesting {0}", nameOutside);
            client.deleteService(
                DeleteServiceRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteServiceLevelObjectiveTest() throws Exception {
    final ServiceMonitoringServiceClient client = ServiceMonitoringServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ServiceLevelObjectiveName nameInside =
                ServiceLevelObjectiveName.of(
                    PROJECT_INSIDE, "MockService", "MockServiceLevelObjective");
            logger.log(Level.INFO, "deleteServiceLevelObjectiveTest: requesting {0}", nameInside);
            client.deleteServiceLevelObjective(
                DeleteServiceLevelObjectiveRequest.newBuilder()
                    .setName(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ServiceLevelObjectiveName nameOutside =
                ServiceLevelObjectiveName.of(
                    PROJECT_OUTSIDE, "MockService", "MockServiceLevelObjective");
            logger.log(Level.INFO, "deleteServiceLevelObjectiveTest: requesting {0}", nameOutside);
            client.deleteServiceLevelObjective(
                DeleteServiceLevelObjectiveRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getServiceTest() throws Exception {
    final ServiceMonitoringServiceClient client = ServiceMonitoringServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ServiceName nameInside = ServiceName.of(PROJECT_INSIDE, "MockService");
            logger.log(Level.INFO, "getServiceTest: requesting {0}", nameInside);
            client.getService(
                GetServiceRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ServiceName nameOutside = ServiceName.of(PROJECT_OUTSIDE, "MockService");
            logger.log(Level.INFO, "getServiceTest: requesting {0}", nameOutside);
            client.getService(
                GetServiceRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getServiceLevelObjectiveTest() throws Exception {
    final ServiceMonitoringServiceClient client = ServiceMonitoringServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ServiceLevelObjectiveName nameInside =
                ServiceLevelObjectiveName.of(
                    PROJECT_INSIDE, "MockService", "MockServiceLevelObjective");
            logger.log(Level.INFO, "getServiceLevelObjectiveTest: requesting {0}", nameInside);
            client.getServiceLevelObjective(
                GetServiceLevelObjectiveRequest.newBuilder()
                    .setName(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ServiceLevelObjectiveName nameOutside =
                ServiceLevelObjectiveName.of(
                    PROJECT_OUTSIDE, "MockService", "MockServiceLevelObjective");
            logger.log(Level.INFO, "getServiceLevelObjectiveTest: requesting {0}", nameOutside);
            client.getServiceLevelObjective(
                GetServiceLevelObjectiveRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listServiceLevelObjectivesTest() throws Exception {
    final ServiceMonitoringServiceClient client = ServiceMonitoringServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ServiceName nameInside = ServiceName.of(PROJECT_INSIDE, "MockService");
            logger.log(Level.INFO, "listServiceLevelObjectivesTest: requesting {0}", nameInside);
            client.listServiceLevelObjectives(
                ListServiceLevelObjectivesRequest.newBuilder()
                    .setParent(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ServiceName nameOutside = ServiceName.of(PROJECT_OUTSIDE, "MockService");
            logger.log(Level.INFO, "listServiceLevelObjectivesTest: requesting {0}", nameOutside);
            client.listServiceLevelObjectives(
                ListServiceLevelObjectivesRequest.newBuilder()
                    .setParent(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listServicesTest() throws Exception {
    final ServiceMonitoringServiceClient client = ServiceMonitoringServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "listServicesTest: requesting {0}", nameInside);
            client.listServices(
                ListServicesRequest.newBuilder().setParent(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "listServicesTest: requesting {0}", nameOutside);
            client.listServices(
                ListServicesRequest.newBuilder().setParent(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateServiceTest() throws Exception {
    final ServiceMonitoringServiceClient client = ServiceMonitoringServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ServiceName nameInside = ServiceName.of(PROJECT_INSIDE, "MockService");
            logger.log(Level.INFO, "updateServiceTest: requesting {0}", nameInside);
            client.updateService(
                UpdateServiceRequest.newBuilder()
                    .setService(Service.newBuilder().setName(nameInside.toString()).build())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ServiceName nameOutside = ServiceName.of(PROJECT_OUTSIDE, "MockService");
            logger.log(Level.INFO, "updateServiceTest: requesting {0}", nameOutside);
            client.updateService(
                UpdateServiceRequest.newBuilder()
                    .setService(Service.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateServiceLevelObjectiveTest() throws Exception {
    final ServiceMonitoringServiceClient client = ServiceMonitoringServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ServiceLevelObjectiveName nameInside =
                ServiceLevelObjectiveName.of(
                    PROJECT_INSIDE, "MockService", "MockServiceLevelObjective");
            logger.log(Level.INFO, "updateServiceLevelObjectiveTest: requesting {0}", nameInside);
            client.updateServiceLevelObjective(
                UpdateServiceLevelObjectiveRequest.newBuilder()
                    .setServiceLevelObjective(
                        ServiceLevelObjective.newBuilder().setName(nameInside.toString()).build())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ServiceLevelObjectiveName nameOutside =
                ServiceLevelObjectiveName.of(
                    PROJECT_OUTSIDE, "MockService", "MockServiceLevelObjective");
            logger.log(Level.INFO, "updateServiceLevelObjectiveTest: requesting {0}", nameOutside);
            client.updateServiceLevelObjective(
                UpdateServiceLevelObjectiveRequest.newBuilder()
                    .setServiceLevelObjective(
                        ServiceLevelObjective.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createUptimeCheckConfigTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "createUptimeCheckConfigTest: requesting {0}", nameInside);
            client.createUptimeCheckConfig(
                CreateUptimeCheckConfigRequest.newBuilder()
                    .setParent(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "createUptimeCheckConfigTest: requesting {0}", nameOutside);
            client.createUptimeCheckConfig(
                CreateUptimeCheckConfigRequest.newBuilder()
                    .setParent(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteUptimeCheckConfigTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            UptimeCheckConfigName nameInside =
                UptimeCheckConfigName.of(PROJECT_INSIDE, "MockUptimeCheckConfig");
            logger.log(Level.INFO, "deleteUptimeCheckConfigTest: requesting {0}", nameInside);
            client.deleteUptimeCheckConfig(
                DeleteUptimeCheckConfigRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            UptimeCheckConfigName nameOutside =
                UptimeCheckConfigName.of(PROJECT_OUTSIDE, "MockUptimeCheckConfig");
            logger.log(Level.INFO, "deleteUptimeCheckConfigTest: requesting {0}", nameOutside);
            client.deleteUptimeCheckConfig(
                DeleteUptimeCheckConfigRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getUptimeCheckConfigTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            UptimeCheckConfigName nameInside =
                UptimeCheckConfigName.of(PROJECT_INSIDE, "MockUptimeCheckConfig");
            logger.log(Level.INFO, "getUptimeCheckConfigTest: requesting {0}", nameInside);
            client.getUptimeCheckConfig(
                GetUptimeCheckConfigRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            UptimeCheckConfigName nameOutside =
                UptimeCheckConfigName.of(PROJECT_OUTSIDE, "MockUptimeCheckConfig");
            logger.log(Level.INFO, "getUptimeCheckConfigTest: requesting {0}", nameOutside);
            client.getUptimeCheckConfig(
                GetUptimeCheckConfigRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listUptimeCheckConfigsTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            logger.log(Level.INFO, "listUptimeCheckConfigsTest: requesting {0}", nameInside);
            client.listUptimeCheckConfigs(
                ListUptimeCheckConfigsRequest.newBuilder()
                    .setParent(nameInside.toString())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            logger.log(Level.INFO, "listUptimeCheckConfigsTest: requesting {0}", nameOutside);
            client.listUptimeCheckConfigs(
                ListUptimeCheckConfigsRequest.newBuilder()
                    .setParent(nameOutside.toString())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateUptimeCheckConfigTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            UptimeCheckConfigName nameInside =
                UptimeCheckConfigName.of(PROJECT_INSIDE, "MockUptimeCheckConfig");
            logger.log(Level.INFO, "updateUptimeCheckConfigTest: requesting {0}", nameInside);
            client.updateUptimeCheckConfig(
                UpdateUptimeCheckConfigRequest.newBuilder()
                    .setUptimeCheckConfig(
                        UptimeCheckConfig.newBuilder().setName(nameInside.toString()).build())
                    .build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            UptimeCheckConfigName nameOutside =
                UptimeCheckConfigName.of(PROJECT_OUTSIDE, "MockUptimeCheckConfig");
            logger.log(Level.INFO, "updateUptimeCheckConfigTest: requesting {0}", nameOutside);
            client.updateUptimeCheckConfig(
                UpdateUptimeCheckConfigRequest.newBuilder()
                    .setUptimeCheckConfig(
                        UptimeCheckConfig.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    try {
      doTest(delayedInside, delayedOutside);
    } finally {
      client.close();
    }
  }
}
