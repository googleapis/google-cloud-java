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

import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import java.util.*;
import org.mockito.ArgumentMatcher;

/** Shared Custom Argument Matchers for Tests w/ Mock Futures */
public class CustomArgumentMatchers {
  public static class AcknowledgeRequestMatcher implements ArgumentMatcher<AcknowledgeRequest> {
    private AcknowledgeRequest left;

    AcknowledgeRequestMatcher(AcknowledgeRequest acknowledgeRequest) {
      this.left = acknowledgeRequest;
    }

    @Override
    public boolean matches(AcknowledgeRequest right) {
      Set<String> leftAckIdSet = new HashSet<String>(this.left.getAckIdsList());
      Set<String> rightAckIdSet = new HashSet<String>(right.getAckIdsList());
      return this.left.getSubscription().equals(right.getSubscription())
          && leftAckIdSet.equals(rightAckIdSet);
    }
  }

  public static class ModifyAckDeadlineRequestMatcher
      implements ArgumentMatcher<ModifyAckDeadlineRequest> {
    private ModifyAckDeadlineRequest left;

    ModifyAckDeadlineRequestMatcher(ModifyAckDeadlineRequest modifyAckDeadlineRequest) {
      this.left = modifyAckDeadlineRequest;
    }

    @Override
    public boolean matches(ModifyAckDeadlineRequest right) {
      Set<String> leftAckIdSet = new HashSet<String>(this.left.getAckIdsList());
      Set<String> rightAckIdSet = new HashSet<String>(right.getAckIdsList());
      return this.left.getSubscription().equals(right.getSubscription())
          && this.left.getAckDeadlineSeconds() == right.getAckDeadlineSeconds()
          && leftAckIdSet.equals(rightAckIdSet);
    }
  }

  public static class AckRequestDataMatcher implements ArgumentMatcher<AckRequestData> {
    private AckRequestData left;

    private static Comparator<AckRequestData> comparator =
        new Comparator<AckRequestData>() {

          @Override
          public int compare(AckRequestData ackRequestData, AckRequestData t1) {
            return ackRequestData.getAckId().compareTo(t1.getAckId());
          }
        };

    AckRequestDataMatcher(AckRequestData left) {
      this.left = left;
    }

    @Override
    public boolean matches(AckRequestData right) {
      return this.left.getAckId() == right.getAckId();
    }
  }

  public static class AckRequestDataListMatcher implements ArgumentMatcher<List<AckRequestData>> {
    private List<AckRequestData> left;

    AckRequestDataListMatcher(List<AckRequestData> ackRequestDataList) {
      this.left = ackRequestDataList;
    }

    @Override
    public boolean matches(List<AckRequestData> right) {
      // We only really care about the ackIds, the futures will be mocked
      if (this.left.size() != right.size()) {
        return false;
      }

      // We just want to compare the ackIds not the futures and do not care about order (or
      // duplicates)
      this.left.sort(AckRequestDataMatcher.comparator);
      right.sort(AckRequestDataMatcher.comparator);

      Iterator<AckRequestData> iteratorLeft = this.left.iterator();
      Iterator<AckRequestData> iteratorRight = right.iterator();

      while (iteratorLeft.hasNext() && iteratorRight.hasNext()) {
        if (iteratorLeft.next().getAckId() != iteratorRight.next().getAckId()) {
          return false;
        }
      }
      return true;
    }
  }

  public static class ModackRequestDataMatcher implements ArgumentMatcher<ModackRequestData> {
    private ModackRequestData left;

    private static Comparator<ModackRequestData> comparator =
        new Comparator<ModackRequestData>() {

          @Override
          public int compare(ModackRequestData left, ModackRequestData right) {
            // Compare deadline extensions first
            int deadlineExtensionDifference =
                left.getDeadlineExtensionSeconds() - right.getDeadlineExtensionSeconds();
            if (deadlineExtensionDifference != 0) {
              return deadlineExtensionDifference;
            }

            // Then sort and compare ackIds
            List<AckRequestData> ackRequestDataListLeft = left.getAckRequestData();
            List<AckRequestData> ackRequestDataListRight = right.getAckRequestData();

            ackRequestDataListLeft.sort(AckRequestDataMatcher.comparator);
            ackRequestDataListRight.sort(AckRequestDataMatcher.comparator);

            Iterator<AckRequestData> iteratorLeft = ackRequestDataListLeft.iterator();
            Iterator<AckRequestData> iteratorRight = ackRequestDataListRight.iterator();
            int compareAcks;

            while (iteratorLeft.hasNext() && iteratorRight.hasNext()) {
              String ackIdLeft = iteratorLeft.next().getAckId();
              String ackIdRight = iteratorRight.next().getAckId();
              compareAcks = ackIdLeft.compareTo(ackIdRight);

              if (compareAcks != 0) {
                return compareAcks;
              }
            }

            if (iteratorLeft.hasNext()) {
              return 1;
            }
            if (iteratorRight.hasNext()) {
              return -1;
            } else {
              return 0;
            }
          }
        };

    ModackRequestDataMatcher(ModackRequestData left) {
      this.left = left;
    }

    @Override
    public boolean matches(ModackRequestData right) {
      return ModackRequestDataMatcher.comparator.compare(this.left, right) == 0;
    }
  }

  public static class ModackRequestDataListMatcher
      implements ArgumentMatcher<List<ModackRequestData>> {
    private List<ModackRequestData> left;

    ModackRequestDataListMatcher(List<ModackRequestData> modackRequestDataList) {
      this.left = modackRequestDataList;
    }

    @Override
    public boolean matches(List<ModackRequestData> right) {
      // First check size
      if (this.left.size() != right.size()) {
        return false;
      }

      // Sort first
      this.left.sort(ModackRequestDataMatcher.comparator);
      right.sort(ModackRequestDataMatcher.comparator);

      Iterator<ModackRequestData> iteratorLeft = this.left.iterator();
      Iterator<ModackRequestData> iteratorRight = right.iterator();

      ModackRequestData modackRequestDataLeft;
      ModackRequestData modackRequestDataRight;

      while (iteratorLeft.hasNext() && iteratorRight.hasNext()) {

        ModackRequestDataMatcher modackRequestDataMatcher =
            new ModackRequestDataMatcher(iteratorLeft.next());

        if (!modackRequestDataMatcher.matches(iteratorRight.next())) {
          return false;
        }
      }

      return true;
    }
  }
}
