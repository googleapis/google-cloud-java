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

// DO NOT MODIFY! AUTO-GENERATED!
// This file is auto-generated on 2019-05-03.

package com.google.cloud.monitoring.v3;

import com.google.api.*;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.monitoring.v3.*;
import com.google.protobuf.*;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by Google")
public class VPCServiceControlTest {
  private abstract class Delay {
    public abstract void eval();
  }

  private static boolean isRejected(Delay delayed) {
    try {
      delayed.eval();
    } catch (PermissionDeniedException e) {
      return e.getMessage().contains("Request is prohibited by organization's policy");
    } catch (Exception e) {
    }
    return false;
  }

  private static void doTest(Delay delayedInside, Delay delayedOutside) {
    if ((IS_INSIDE_VPCSC != null) && (IS_INSIDE_VPCSC.equalsIgnoreCase("true"))) {
      Assert.assertTrue(isRejected(delayedOutside));
      Assert.assertTrue(!(isRejected(delayedInside)));
    } else {
      Assert.assertTrue(!(isRejected(delayedOutside)));
      Assert.assertTrue(isRejected(delayedInside));
    }
  }

  static final String PROJECT_OUTSIDE =
      System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
  static final String PROJECT_INSIDE = System.getenv("PROJECT_ID");
  static final String IS_INSIDE_VPCSC = System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC");

  @BeforeClass
  public static void setUpClass() {
    Assume.assumeTrue(
        "GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT environment variable needs to be set to a GCP project that is outside the VPC perimeter",
        PROJECT_OUTSIDE != null && !PROJECT_OUTSIDE.isEmpty());
    Assume.assumeTrue(
        "PROJECT_ID environment variable needs to be set to a GCP project that is inside the VPC perimeter",
        PROJECT_INSIDE != null && !PROJECT_INSIDE.isEmpty());
  }

  @Test
  @SuppressWarnings("all")
  public void createAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    final AlertPolicy resourceInside = AlertPolicy.newBuilder().build();
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.createAlertPolicy(nameInside, resourceInside);
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    final AlertPolicy resourceOutside = AlertPolicy.newBuilder().build();
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.createAlertPolicy(nameOutside, resourceOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    final AlertPolicyName nameInside = AlertPolicyName.of(PROJECT_INSIDE, "MockAlertPolicy");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.deleteAlertPolicy(nameInside);
          }
        };
    final AlertPolicyName nameOutside = AlertPolicyName.of(PROJECT_OUTSIDE, "MockAlertPolicy");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.deleteAlertPolicy(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    final AlertPolicyName nameInside = AlertPolicyName.of(PROJECT_INSIDE, "MockAlertPolicy");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.getAlertPolicy(nameInside);
          }
        };
    final AlertPolicyName nameOutside = AlertPolicyName.of(PROJECT_OUTSIDE, "MockAlertPolicy");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.getAlertPolicy(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listAlertPoliciesTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.listAlertPolicies(nameInside);
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.listAlertPolicies(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void updateAlertPolicyTest() throws Exception {
    final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
    AlertPolicyName nameInside = AlertPolicyName.of(PROJECT_INSIDE, "MockAlertPolicy");
    final AlertPolicy resourceInside =
        AlertPolicy.newBuilder().setName(nameInside.toString()).build();
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.updateAlertPolicy(FieldMask.newBuilder().build(), resourceInside);
          }
        };
    AlertPolicyName nameOutside = AlertPolicyName.of(PROJECT_OUTSIDE, "MockAlertPolicy");
    final AlertPolicy resourceOutside =
        AlertPolicy.newBuilder().setName(nameOutside.toString()).build();
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.updateAlertPolicy(FieldMask.newBuilder().build(), resourceOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    final Group resourceInside = Group.newBuilder().build();
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.createGroup(nameInside, resourceInside);
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    final Group resourceOutside = Group.newBuilder().build();
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.createGroup(nameOutside, resourceOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    final GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.deleteGroup(nameInside);
          }
        };
    final GroupName nameOutside = GroupName.of(PROJECT_OUTSIDE, "MockGroup");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.deleteGroup(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    final GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.getGroup(nameInside);
          }
        };
    final GroupName nameOutside = GroupName.of(PROJECT_OUTSIDE, "MockGroup");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.getGroup(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupMembersTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    final GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.listGroupMembers(nameInside);
          }
        };
    final GroupName nameOutside = GroupName.of(PROJECT_OUTSIDE, "MockGroup");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.listGroupMembers(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listGroupsTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    final ListGroupsRequest requestInside =
        ListGroupsRequest.newBuilder().setName(nameInside.toString()).build();
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.listGroups(requestInside);
          }
        };
    ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    final ListGroupsRequest requestOutside =
        ListGroupsRequest.newBuilder().setName(nameOutside.toString()).build();
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.listGroups(requestOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void updateGroupTest() throws Exception {
    final GroupServiceClient client = GroupServiceClient.create();
    GroupName nameInside = GroupName.of(PROJECT_INSIDE, "MockGroup");
    final Group resourceInside = Group.newBuilder().setName(nameInside.toString()).build();
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.updateGroup(resourceInside);
          }
        };
    GroupName nameOutside = GroupName.of(PROJECT_OUTSIDE, "MockGroup");
    final Group resourceOutside = Group.newBuilder().setName(nameOutside.toString()).build();
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.updateGroup(resourceOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createMetricDescriptorTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    final MetricDescriptor resourceInside = MetricDescriptor.newBuilder().build();
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.createMetricDescriptor(nameInside, resourceInside);
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    final MetricDescriptor resourceOutside = MetricDescriptor.newBuilder().build();
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.createMetricDescriptor(nameOutside, resourceOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createTimeSeriesTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.createTimeSeries(nameInside, new ArrayList<TimeSeries>());
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.createTimeSeries(nameOutside, new ArrayList<TimeSeries>());
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deleteMetricDescriptorTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    final MetricDescriptorName nameInside =
        MetricDescriptorName.of(PROJECT_INSIDE, "MockMetricDescriptor");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.deleteMetricDescriptor(nameInside);
          }
        };
    final MetricDescriptorName nameOutside =
        MetricDescriptorName.of(PROJECT_OUTSIDE, "MockMetricDescriptor");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.deleteMetricDescriptor(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getMetricDescriptorTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    final MetricDescriptorName nameInside =
        MetricDescriptorName.of(PROJECT_INSIDE, "MockMetricDescriptor");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.getMetricDescriptor(nameInside);
          }
        };
    final MetricDescriptorName nameOutside =
        MetricDescriptorName.of(PROJECT_OUTSIDE, "MockMetricDescriptor");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.getMetricDescriptor(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getMonitoredResourceDescriptorTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    final MonitoredResourceDescriptorName nameInside =
        MonitoredResourceDescriptorName.of(PROJECT_INSIDE, "MockMonitoredResourceDescriptor");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.getMonitoredResourceDescriptor(nameInside);
          }
        };
    final MonitoredResourceDescriptorName nameOutside =
        MonitoredResourceDescriptorName.of(PROJECT_OUTSIDE, "MockMonitoredResourceDescriptor");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.getMonitoredResourceDescriptor(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listMetricDescriptorsTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.listMetricDescriptors(nameInside);
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.listMetricDescriptors(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listMonitoredResourceDescriptorsTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.listMonitoredResourceDescriptors(nameInside);
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.listMonitoredResourceDescriptors(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listTimeSeriesTest() throws Exception {
    final MetricServiceClient client = MetricServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    final TimeInterval intervalInside = TimeInterval.newBuilder().build();
    final ListTimeSeriesRequest.TimeSeriesView viewInside =
        ListTimeSeriesRequest.TimeSeriesView.FULL;
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.listTimeSeries(nameInside, "", intervalInside, viewInside);
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    final TimeInterval intervalOutside = TimeInterval.newBuilder().build();
    final ListTimeSeriesRequest.TimeSeriesView viewOutside =
        ListTimeSeriesRequest.TimeSeriesView.FULL;
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.listTimeSeries(nameOutside, "", intervalOutside, viewOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createNotificationChannelTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    final NotificationChannel resourceInside = NotificationChannel.newBuilder().build();
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.createNotificationChannel(nameInside, resourceInside);
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    final NotificationChannel resourceOutside = NotificationChannel.newBuilder().build();
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.createNotificationChannel(nameOutside, resourceOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNotificationChannelTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    final NotificationChannelName nameInside =
        NotificationChannelName.of(PROJECT_INSIDE, "MockNotificationChannel");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.deleteNotificationChannel(nameInside, true);
          }
        };
    final NotificationChannelName nameOutside =
        NotificationChannelName.of(PROJECT_OUTSIDE, "MockNotificationChannel");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.deleteNotificationChannel(nameOutside, true);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getNotificationChannelTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    final NotificationChannelName nameInside =
        NotificationChannelName.of(PROJECT_INSIDE, "MockNotificationChannel");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.getNotificationChannel(nameInside);
          }
        };
    final NotificationChannelName nameOutside =
        NotificationChannelName.of(PROJECT_OUTSIDE, "MockNotificationChannel");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.getNotificationChannel(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getNotificationChannelDescriptorTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    final NotificationChannelDescriptorName nameInside =
        NotificationChannelDescriptorName.of(PROJECT_INSIDE, "MockNotificationChannelDescriptor");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.getNotificationChannelDescriptor(nameInside);
          }
        };
    final NotificationChannelDescriptorName nameOutside =
        NotificationChannelDescriptorName.of(PROJECT_OUTSIDE, "MockNotificationChannelDescriptor");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.getNotificationChannelDescriptor(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listNotificationChannelDescriptorsTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.listNotificationChannelDescriptors(nameInside);
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.listNotificationChannelDescriptors(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listNotificationChannelsTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.listNotificationChannels(nameInside);
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.listNotificationChannels(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void updateNotificationChannelTest() throws Exception {
    final NotificationChannelServiceClient client = NotificationChannelServiceClient.create();
    NotificationChannelName nameInside =
        NotificationChannelName.of(PROJECT_INSIDE, "MockNotificationChannel");
    final NotificationChannel resourceInside =
        NotificationChannel.newBuilder().setName(nameInside.toString()).build();
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.updateNotificationChannel(FieldMask.newBuilder().build(), resourceInside);
          }
        };
    NotificationChannelName nameOutside =
        NotificationChannelName.of(PROJECT_OUTSIDE, "MockNotificationChannel");
    final NotificationChannel resourceOutside =
        NotificationChannel.newBuilder().setName(nameOutside.toString()).build();
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.updateNotificationChannel(FieldMask.newBuilder().build(), resourceOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createUptimeCheckConfigTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    final UptimeCheckConfig resourceInside = UptimeCheckConfig.newBuilder().build();
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.createUptimeCheckConfig(nameInside.toString(), resourceInside);
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    final UptimeCheckConfig resourceOutside = UptimeCheckConfig.newBuilder().build();
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.createUptimeCheckConfig(nameOutside.toString(), resourceOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deleteUptimeCheckConfigTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    final UptimeCheckConfigName nameInside =
        UptimeCheckConfigName.of(PROJECT_INSIDE, "MockUptimeCheckConfig");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.deleteUptimeCheckConfig(nameInside);
          }
        };
    final UptimeCheckConfigName nameOutside =
        UptimeCheckConfigName.of(PROJECT_OUTSIDE, "MockUptimeCheckConfig");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.deleteUptimeCheckConfig(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getUptimeCheckConfigTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    final UptimeCheckConfigName nameInside =
        UptimeCheckConfigName.of(PROJECT_INSIDE, "MockUptimeCheckConfig");
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.getUptimeCheckConfig(nameInside);
          }
        };
    final UptimeCheckConfigName nameOutside =
        UptimeCheckConfigName.of(PROJECT_OUTSIDE, "MockUptimeCheckConfig");
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.getUptimeCheckConfig(nameOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listUptimeCheckConfigsTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.listUptimeCheckConfigs(nameInside.toString());
          }
        };
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.listUptimeCheckConfigs(nameOutside.toString());
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void updateUptimeCheckConfigTest() throws Exception {
    final UptimeCheckServiceClient client = UptimeCheckServiceClient.create();
    UptimeCheckConfigName nameInside =
        UptimeCheckConfigName.of(PROJECT_INSIDE, "MockUptimeCheckConfig");
    final UptimeCheckConfig resourceInside =
        UptimeCheckConfig.newBuilder().setName(nameInside.toString()).build();
    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.updateUptimeCheckConfig(resourceInside);
          }
        };
    UptimeCheckConfigName nameOutside =
        UptimeCheckConfigName.of(PROJECT_OUTSIDE, "MockUptimeCheckConfig");
    final UptimeCheckConfig resourceOutside =
        UptimeCheckConfig.newBuilder().setName(nameOutside.toString()).build();
    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.updateUptimeCheckConfig(resourceOutside);
          }
        };
    doTest(delayedInside, delayedOutside);
    client.close();
  }
}
