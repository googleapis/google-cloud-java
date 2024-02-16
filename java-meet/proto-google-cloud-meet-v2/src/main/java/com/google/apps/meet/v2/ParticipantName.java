/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.apps.meet.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class ParticipantName implements ResourceName {
  private static final PathTemplate CONFERENCE_RECORD_PARTICIPANT =
      PathTemplate.createWithoutUrlEncoding(
          "conferenceRecords/{conference_record}/participants/{participant}");
  private volatile Map<String, String> fieldValuesMap;
  private final String conferenceRecord;
  private final String participant;

  @Deprecated
  protected ParticipantName() {
    conferenceRecord = null;
    participant = null;
  }

  private ParticipantName(Builder builder) {
    conferenceRecord = Preconditions.checkNotNull(builder.getConferenceRecord());
    participant = Preconditions.checkNotNull(builder.getParticipant());
  }

  public String getConferenceRecord() {
    return conferenceRecord;
  }

  public String getParticipant() {
    return participant;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ParticipantName of(String conferenceRecord, String participant) {
    return newBuilder().setConferenceRecord(conferenceRecord).setParticipant(participant).build();
  }

  public static String format(String conferenceRecord, String participant) {
    return newBuilder()
        .setConferenceRecord(conferenceRecord)
        .setParticipant(participant)
        .build()
        .toString();
  }

  public static ParticipantName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        CONFERENCE_RECORD_PARTICIPANT.validatedMatch(
            formattedString, "ParticipantName.parse: formattedString not in valid format");
    return of(matchMap.get("conference_record"), matchMap.get("participant"));
  }

  public static List<ParticipantName> parseList(List<String> formattedStrings) {
    List<ParticipantName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ParticipantName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ParticipantName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return CONFERENCE_RECORD_PARTICIPANT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (conferenceRecord != null) {
            fieldMapBuilder.put("conference_record", conferenceRecord);
          }
          if (participant != null) {
            fieldMapBuilder.put("participant", participant);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return CONFERENCE_RECORD_PARTICIPANT.instantiate(
        "conference_record", conferenceRecord, "participant", participant);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ParticipantName that = ((ParticipantName) o);
      return Objects.equals(this.conferenceRecord, that.conferenceRecord)
          && Objects.equals(this.participant, that.participant);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(conferenceRecord);
    h *= 1000003;
    h ^= Objects.hashCode(participant);
    return h;
  }

  /** Builder for conferenceRecords/{conference_record}/participants/{participant}. */
  public static class Builder {
    private String conferenceRecord;
    private String participant;

    protected Builder() {}

    public String getConferenceRecord() {
      return conferenceRecord;
    }

    public String getParticipant() {
      return participant;
    }

    public Builder setConferenceRecord(String conferenceRecord) {
      this.conferenceRecord = conferenceRecord;
      return this;
    }

    public Builder setParticipant(String participant) {
      this.participant = participant;
      return this;
    }

    private Builder(ParticipantName participantName) {
      this.conferenceRecord = participantName.conferenceRecord;
      this.participant = participantName.participant;
    }

    public ParticipantName build() {
      return new ParticipantName(this);
    }
  }
}
