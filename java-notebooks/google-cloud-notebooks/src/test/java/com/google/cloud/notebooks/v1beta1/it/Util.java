package com.google.cloud.notebooks.v1beta1.it;

import com.google.cloud.notebooks.v1beta1.DeleteInstanceRequest;
import com.google.cloud.notebooks.v1beta1.Instance;
import com.google.cloud.notebooks.v1beta1.ListInstancesRequest;
import com.google.cloud.notebooks.v1beta1.NotebookServiceClient;
import com.google.cloud.notebooks.v1beta1.NotebookServiceClient.ListInstancesPagedResponse;
import com.google.protobuf.util.Timestamps;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Util {
  // Cleans existing test resources if any.
  private static final int DELETION_THRESHOLD_TIME_HOURS = 24;

  /** tear down any clusters that are older than 24 hours **/
  public static void cleanUpNotebookInstances(NotebookServiceClient client){
    ListInstancesPagedResponse listInstancesPagedResponse = client.listInstances(ListInstancesRequest.getDefaultInstance());
    for (Instance instance : listInstancesPagedResponse.iterateAll()) {
      if (isCreatedBeforeThresholdTime(Instant.ofEpochMilli(Timestamps.toMillis(instance.getCreateTime())))) {
        client.deleteInstanceAsync(DeleteInstanceRequest.newBuilder().setName(instance.getName()).build());
      }
    }
  }

  private static boolean isCreatedBeforeThresholdTime(Instant instant) {
    return instant.isBefore(Instant.now().minus(DELETION_THRESHOLD_TIME_HOURS, ChronoUnit.HOURS));
  }
}