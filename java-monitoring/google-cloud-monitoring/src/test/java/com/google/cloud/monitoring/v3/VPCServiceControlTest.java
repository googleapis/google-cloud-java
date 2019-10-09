/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// DO NOT MODIFY! THIS FILE IS AUTO-GENERATED.
// This file is auto-generated on 09 Oct 19 18:09 UTC.

package com.google.cloud.monitoring.v3;

import com.google.api.*;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.monitoring.v3.*;
import com.google.protobuf.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by Google")
public class VPCServiceControlTest {
  static final String PROJECT_INSIDE = System.getenv("PROJECT_ID");
  static final String PROJECT_OUTSIDE =
      System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
  static final String IS_INSIDE_VPCSC = System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC");

  private static boolean isRejected(Callable callable) {
    try {
      callable.call();
    } catch (PermissionDeniedException e) {
      System.out.println(e.getMessage());
      return e.getMessage().contains("Request is prohibited by organization's policy");
    } catch (Exception e) {
      System.out.println(e);
    }
    return false;
  }

  private static void doTest(Callable delayedInside, Callable delayedOutside) {
    if ((IS_INSIDE_VPCSC != null) && (IS_INSIDE_VPCSC.equalsIgnoreCase("true"))) {
      Assert.assertTrue(isRejected(delayedOutside));
      Assert.assertFalse(isRejected(delayedInside));
    } else {
      Assert.assertFalse(isRejected(delayedOutside));
      Assert.assertTrue(isRejected(delayedInside));
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

  @Test
  @SuppressWarnings("all")
  public void createAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            client.createAlertPolicy(
                CreateAlertPolicyRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            client.createAlertPolicy(
                CreateAlertPolicyRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            AlertPolicyName nameInside = AlertPolicyName.of(PROJECT_INSIDE, "MockAlertPolicy");
            client.deleteAlertPolicy(
                DeleteAlertPolicyRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            AlertPolicyName nameOutside = AlertPolicyName.of(PROJECT_OUTSIDE, "MockAlertPolicy");
            client.deleteAlertPolicy(
                DeleteAlertPolicyRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            AlertPolicyName nameInside = AlertPolicyName.of(PROJECT_INSIDE, "MockAlertPolicy");
            client.getAlertPolicy(
                GetAlertPolicyRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            AlertPolicyName nameOutside = AlertPolicyName.of(PROJECT_OUTSIDE, "MockAlertPolicy");
            client.getAlertPolicy(
                GetAlertPolicyRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void updateAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            AlertPolicyName nameInside = AlertPolicyName.of(PROJECT_INSIDE, "MockAlertPolicy");
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
            client.updateAlertPolicy(
                UpdateAlertPolicyRequest.newBuilder()
                    .setAlertPolicy(
                        AlertPolicy.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            client.createGroup(
                CreateGroupRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            client.createGroup(
                CreateGroupRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
            client.deleteGroup(
                DeleteGroupRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameOutside = GroupName.of(PROJECT_OUTSIDE, "MockGroup");
            client.deleteGroup(
                DeleteGroupRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
            client.getGroup(GetGroupRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameOutside = GroupName.of(PROJECT_OUTSIDE, "MockGroup");
            client.getGroup(GetGroupRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupMembersTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
            client.listGroupMembers(
                ListGroupMembersRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameOutside = GroupName.of(PROJECT_OUTSIDE, "MockGroup");
            client.listGroupMembers(
                ListGroupMembersRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupsTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            client.listGroups(
                ListGroupsRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            client.listGroups(
                ListGroupsRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void updateGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
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
            client.updateGroup(
                UpdateGroupRequest.newBuilder()
                    .setGroup(Group.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createMetricDescriptorTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            client.createMetricDescriptor(
                CreateMetricDescriptorRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            client.createMetricDescriptor(
                CreateMetricDescriptorRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listAlertPoliciesTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            client.listAlertPolicies(
                ListAlertPoliciesRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            client.listAlertPolicies(
                ListAlertPoliciesRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createTimeSeriesTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            client.createTimeSeries(nameInside, new ArrayList<TimeSeries>());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            client.createTimeSeries(nameOutside, new ArrayList<TimeSeries>());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
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
            client.deleteMetricDescriptor(
                DeleteMetricDescriptorRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
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
            client.getMetricDescriptor(
                GetMetricDescriptorRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
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
            client.getMonitoredResourceDescriptor(
                GetMonitoredResourceDescriptorRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listMetricDescriptorsTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            client.listMetricDescriptors(
                ListMetricDescriptorsRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            client.listMetricDescriptors(
                ListMetricDescriptorsRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listMonitoredResourceDescriptorsTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
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
            client.listMonitoredResourceDescriptors(
                ListMonitoredResourceDescriptorsRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createNotificationChannelTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
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
            client.createNotificationChannel(
                CreateNotificationChannelRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
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
            client.deleteNotificationChannel(
                DeleteNotificationChannelRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
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
            client.getNotificationChannel(
                GetNotificationChannelRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
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
            client.deleteUptimeCheckConfig(
                DeleteUptimeCheckConfigRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
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
            client.getNotificationChannelDescriptor(
                GetNotificationChannelDescriptorRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listNotificationChannelDescriptorsTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
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
            client.listNotificationChannelDescriptors(
                ListNotificationChannelDescriptorsRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listNotificationChannelsTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
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
            client.listNotificationChannels(
                ListNotificationChannelsRequest.newBuilder()
                    .setName(nameOutside.toString())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listTimeSeriesTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
            client.listTimeSeries(
                ListTimeSeriesRequest.newBuilder().setName(nameInside.toString()).build());
            return null;
          }
        };
    Callable<Object> delayedOutside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
            client.listTimeSeries(
                ListTimeSeriesRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
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
            client.updateNotificationChannel(
                UpdateNotificationChannelRequest.newBuilder()
                    .setNotificationChannel(
                        NotificationChannel.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createUptimeCheckConfigTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
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
            client.createUptimeCheckConfig(
                CreateUptimeCheckConfigRequest.newBuilder()
                    .setParent(nameOutside.toString())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
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
            client.getUptimeCheckConfig(
                GetUptimeCheckConfigRequest.newBuilder().setName(nameOutside.toString()).build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listUptimeCheckConfigsTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    Callable<Object> delayedInside =
        new Callable() {
          public Object call() throws Exception {
            ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
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
            client.listUptimeCheckConfigs(
                ListUptimeCheckConfigsRequest.newBuilder()
                    .setParent(nameOutside.toString())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
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
            client.updateUptimeCheckConfig(
                UpdateUptimeCheckConfigRequest.newBuilder()
                    .setUptimeCheckConfig(
                        UptimeCheckConfig.newBuilder().setName(nameOutside.toString()).build())
                    .build());
            return null;
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }
}
