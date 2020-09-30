/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigquerydatatransfer;

// [START bigquerydatatransfer_schedule_backfill]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.ScheduleOptions;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.FieldMaskUtil;
import java.io.IOException;
import org.threeten.bp.Clock;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.ChronoUnit;

// Sample to update schedule back fill for transfer config
public class ScheduleBackFill {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String configId = "MY_CONFIG_ID";
    Clock clock = Clock.systemDefaultZone();
    Instant instant = clock.instant();
    Timestamp startDate =
        Timestamp.newBuilder()
            .setSeconds(instant.getEpochSecond())
            .setNanos(instant.getNano())
            .build();
    Timestamp endDate =
        Timestamp.newBuilder()
            .setSeconds(instant.plus(10, ChronoUnit.DAYS).getEpochSecond())
            .setNanos(instant.plus(10, ChronoUnit.DAYS).getNano())
            .build();
    TransferConfig transferConfig =
        TransferConfig.newBuilder()
            .setName(configId)
            .setScheduleOptions(
                ScheduleOptions.newBuilder().setStartTime(startDate).setEndTime(endDate).build())
            .build();
    FieldMask updateMask = FieldMaskUtil.fromStringList(ImmutableList.of("start_time", "end_time"));
    scheduleBackFill(transferConfig, updateMask);
  }

  public static void scheduleBackFill(TransferConfig transferConfig, FieldMask updateMask)
      throws IOException {
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      UpdateTransferConfigRequest request =
          UpdateTransferConfigRequest.newBuilder()
              .setTransferConfig(transferConfig)
              .setUpdateMask(updateMask)
              .build();
      TransferConfig updateConfig = dataTransferServiceClient.updateTransferConfig(request);
      System.out.println(
          "Schedule backfill updated successfully :" + updateConfig.getDisplayName());
    } catch (ApiException ex) {
      System.out.print("Schedule backfill was not updated." + ex.toString());
    }
  }
}
// [END bigquerydatatransfer_schedule_backfill]
