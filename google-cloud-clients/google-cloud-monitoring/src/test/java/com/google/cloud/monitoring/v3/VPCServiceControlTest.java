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
// This file is auto-generated on 2019-04-23.

package com.google.cloud.monitoring.v3;
import com.google.api.*;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.protobuf.*;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import com.google.monitoring.v3.*;

@javax.annotation.Generated("by Google")
public class VPCServiceControlTest {
    private abstract class Delay {
        public abstract void eval();
    }

    private static boolean isRejected(Delay delayed) {
        try {
          delayed.eval();
        } catch (PermissionDeniedException e) {
          return e.getMessage()
                  .contains("Request is prohibited by organization's policy");
        } catch (Exception e) {}
        return false;
    }

    private static void doTest(Delay delayedInside, Delay delayedOutside) {
        if ((System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC") != null) && (System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC").equalsIgnoreCase("True"))) {
            Assert.assertTrue(isRejected(delayedOutside));
            Assert.assertTrue(!(isRejected(delayedInside)));
        } else {
            Assert.assertTrue(!(isRejected(delayedOutside)));
            Assert.assertTrue(isRejected(delayedInside));
        }
    }

    @Test
    @SuppressWarnings("all")
    public void createAlertPolicyTest() throws Exception {
        final AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final ProjectName nameInside = ProjectName.of(projectInside);
        final AlertPolicy resourceInside = AlertPolicy.newBuilder().build();
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.createAlertPolicy(nameInside, resourceInside);
          }
        };
        final ProjectName nameOutside = ProjectName.of(projectOutside);
        final AlertPolicy resourceOutside = AlertPolicy.newBuilder().build();
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final AlertPolicyName nameInside = AlertPolicyName.of(projectInside, "MockAlertPolicy");
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.deleteAlertPolicy(nameInside);
          }
        };
        final AlertPolicyName nameOutside = AlertPolicyName.of(projectOutside, "MockAlertPolicy");
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final AlertPolicyName nameInside = AlertPolicyName.of(projectInside, "MockAlertPolicy");
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.getAlertPolicy(nameInside);
          }
        };
        final AlertPolicyName nameOutside = AlertPolicyName.of(projectOutside, "MockAlertPolicy");
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final ProjectName nameInside = ProjectName.of(projectInside);
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.listAlertPolicies(nameInside);
          }
        };
        final ProjectName nameOutside = ProjectName.of(projectOutside);
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        AlertPolicyName nameInside = AlertPolicyName.of(projectInside, "MockAlertPolicy");
        final AlertPolicy resourceInside = AlertPolicy.newBuilder().setName(nameInside.toString()).build();
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.updateAlertPolicy(FieldMask.newBuilder().build(), resourceInside);
          }
        };
        AlertPolicyName nameOutside = AlertPolicyName.of(projectOutside, "MockAlertPolicy");
        final AlertPolicy resourceOutside = AlertPolicy.newBuilder().setName(nameOutside.toString()).build();
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final ProjectName nameInside = ProjectName.of(projectInside);
        final Group resourceInside = Group.newBuilder().build();
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.createGroup(nameInside, resourceInside);
          }
        };
        final ProjectName nameOutside = ProjectName.of(projectOutside);
        final Group resourceOutside = Group.newBuilder().build();
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final GroupName nameInside = GroupName.of(projectInside, "MockGroup");
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.deleteGroup(nameInside);
          }
        };
        final GroupName nameOutside = GroupName.of(projectOutside, "MockGroup");
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final GroupName nameInside = GroupName.of(projectInside, "MockGroup");
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.getGroup(nameInside);
          }
        };
        final GroupName nameOutside = GroupName.of(projectOutside, "MockGroup");
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final GroupName nameInside = GroupName.of(projectInside, "MockGroup");
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.listGroupMembers(nameInside);
          }
        };
        final GroupName nameOutside = GroupName.of(projectOutside, "MockGroup");
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        ProjectName nameInside = ProjectName.of(projectInside);
        final ListGroupsRequest requestInside = ListGroupsRequest.newBuilder().setName(nameInside.toString()).build();
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.listGroups(requestInside);
          }
        };
        ProjectName nameOutside = ProjectName.of(projectOutside);
        final ListGroupsRequest requestOutside = ListGroupsRequest.newBuilder().setName(nameOutside.toString()).build();
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        GroupName nameInside = GroupName.of(projectInside, "MockGroup");
        final Group resourceInside = Group.newBuilder().setName(nameInside.toString()).build();
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.updateGroup(resourceInside);
          }
        };
        GroupName nameOutside = GroupName.of(projectOutside, "MockGroup");
        final Group resourceOutside = Group.newBuilder().setName(nameOutside.toString()).build();
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final ProjectName nameInside = ProjectName.of(projectInside);
        final MetricDescriptor resourceInside = MetricDescriptor.newBuilder().build();
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.createMetricDescriptor(nameInside, resourceInside);
          }
        };
        final ProjectName nameOutside = ProjectName.of(projectOutside);
        final MetricDescriptor resourceOutside = MetricDescriptor.newBuilder().build();
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final ProjectName nameInside = ProjectName.of(projectInside);
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.createTimeSeries(nameInside, new ArrayList<TimeSeries>());
          }
        };
        final ProjectName nameOutside = ProjectName.of(projectOutside);
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final MetricDescriptorName nameInside = MetricDescriptorName.of(projectInside, "MockMetricDescriptor");
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.deleteMetricDescriptor(nameInside);
          }
        };
        final MetricDescriptorName nameOutside = MetricDescriptorName.of(projectOutside, "MockMetricDescriptor");
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final MetricDescriptorName nameInside = MetricDescriptorName.of(projectInside, "MockMetricDescriptor");
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.getMetricDescriptor(nameInside);
          }
        };
        final MetricDescriptorName nameOutside = MetricDescriptorName.of(projectOutside, "MockMetricDescriptor");
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final MonitoredResourceDescriptorName nameInside = MonitoredResourceDescriptorName.of(projectInside, "MockMonitoredResourceDescriptor");
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.getMonitoredResourceDescriptor(nameInside);
          }
        };
        final MonitoredResourceDescriptorName nameOutside = MonitoredResourceDescriptorName.of(projectOutside, "MockMonitoredResourceDescriptor");
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final ProjectName nameInside = ProjectName.of(projectInside);
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.listMetricDescriptors(nameInside);
          }
        };
        final ProjectName nameOutside = ProjectName.of(projectOutside);
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final ProjectName nameInside = ProjectName.of(projectInside);
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.listMonitoredResourceDescriptors(nameInside);
          }
        };
        final ProjectName nameOutside = ProjectName.of(projectOutside);
        Delay delayedOutside = new Delay() {
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
        final String projectInside = System.getenv("PROJECT_ID");
        final String projectOutside = System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
        final ProjectName nameInside = ProjectName.of(projectInside);
        final TimeInterval intervalInside = TimeInterval.newBuilder().build();
        final ListTimeSeriesRequest.TimeSeriesView viewInside = ListTimeSeriesRequest.TimeSeriesView.FULL;
        Delay delayedInside = new Delay() {
          @Override
          public void eval() {
                client.listTimeSeries(nameInside, "", intervalInside, viewInside);
          }
        };
        final ProjectName nameOutside = ProjectName.of(projectOutside);
        final TimeInterval intervalOutside = TimeInterval.newBuilder().build();
        final ListTimeSeriesRequest.TimeSeriesView viewOutside = ListTimeSeriesRequest.TimeSeriesView.FULL;
        Delay delayedOutside = new Delay() {
          @Override
          public void eval() {
                client.listTimeSeries(nameOutside, "", intervalOutside, viewOutside);
          }
        };
        doTest(delayedInside, delayedOutside);
        client.close();
    }
}
