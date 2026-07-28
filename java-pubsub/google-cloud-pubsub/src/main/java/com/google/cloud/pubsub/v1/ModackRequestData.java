/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.pubsub.v1;

import java.util.*;

class ModackRequestData {
  private final int deadlineExtensionSeconds;
  private List<AckRequestData> ackRequestData;
  private boolean isReceiptModack;

  ModackRequestData(int deadlineExtensionSeconds) {
    this.deadlineExtensionSeconds = deadlineExtensionSeconds;
    this.ackRequestData = new ArrayList<AckRequestData>();
  }

  ModackRequestData(int deadlineExtensionSeconds, AckRequestData... ackRequestData) {
    this.deadlineExtensionSeconds = deadlineExtensionSeconds;
    this.ackRequestData = Arrays.asList(ackRequestData);
  }

  ModackRequestData(int deadlineExtensionSeconds, List<AckRequestData> ackRequestData) {
    this.deadlineExtensionSeconds = deadlineExtensionSeconds;
    this.ackRequestData = ackRequestData;
  }

  public int getDeadlineExtensionSeconds() {
    return deadlineExtensionSeconds;
  }

  public List<AckRequestData> getAckRequestData() {
    return ackRequestData;
  }

  public boolean getIsReceiptModack() {
    return isReceiptModack;
  }

  public ModackRequestData addAckRequestData(AckRequestData ackRequestData) {
    this.ackRequestData.add(ackRequestData);
    return this;
  }

  public ModackRequestData setIsReceiptModack(boolean isReceiptModack) {
    this.isReceiptModack = isReceiptModack;
    return this;
  }
}
