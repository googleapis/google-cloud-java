package com.google.cloud.compute.v1.integration;

import com.google.cloud.compute.v1.DeleteInstanceRequest;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.compute.v1.InstancesClient.ListPagedResponse;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Util {

  // Cleans existing test resources if any.
  private static final int DELETION_THRESHOLD_TIME_HOURS = 24;

  /**
   * Bring down any instances that are older than 24 hours
   **/
  public static void cleanUpComputeInstances(InstancesClient instancesClient, String project,
      String zone) {
    ListPagedResponse listPagedResponse = instancesClient.list(project, zone);
    for (Instance instance : listPagedResponse.iterateAll()) {
      if (isCreatedBeforeThresholdTime(
          ZonedDateTime.parse(instance.getCreationTimestamp()).toInstant()) &&
          instance.getName().startsWith(BaseTest.COMPUTE_PREFIX)) {
        instancesClient.deleteAsync(DeleteInstanceRequest.newBuilder()
            .setInstance(instance.getName())
            .setProject(project)
            .setZone(zone)
            .build());
      }
    }
  }

  private static boolean isCreatedBeforeThresholdTime(Instant instant) {
    return instant.isBefore(Instant.now().minus(DELETION_THRESHOLD_TIME_HOURS, ChronoUnit.HOURS));
  }
}
