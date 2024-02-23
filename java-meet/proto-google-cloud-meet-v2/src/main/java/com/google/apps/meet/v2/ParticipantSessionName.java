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
public class ParticipantSessionName implements ResourceName {
  private static final PathTemplate CONFERENCE_RECORD_PARTICIPANT_PARTICIPANT_SESSION =
      PathTemplate.createWithoutUrlEncoding(
          "conferenceRecords/{conference_record}/participants/{participant}/participantSessions/{participant_session}");
  private volatile Map<String, String> fieldValuesMap;
  private final String conferenceRecord;
  private final String participant;
  private final String participantSession;

  @Deprecated
  protected ParticipantSessionName() {
    conferenceRecord = null;
    participant = null;
    participantSession = null;
  }

  private ParticipantSessionName(Builder builder) {
    conferenceRecord = Preconditions.checkNotNull(builder.getConferenceRecord());
    participant = Preconditions.checkNotNull(builder.getParticipant());
    participantSession = Preconditions.checkNotNull(builder.getParticipantSession());
  }

  public String getConferenceRecord() {
    return conferenceRecord;
  }

  public String getParticipant() {
    return participant;
  }

  public String getParticipantSession() {
    return participantSession;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ParticipantSessionName of(
      String conferenceRecord, String participant, String participantSession) {
    return newBuilder()
        .setConferenceRecord(conferenceRecord)
        .setParticipant(participant)
        .setParticipantSession(participantSession)
        .build();
  }

  public static String format(
      String conferenceRecord, String participant, String participantSession) {
    return newBuilder()
        .setConferenceRecord(conferenceRecord)
        .setParticipant(participant)
        .setParticipantSession(participantSession)
        .build()
        .toString();
  }

  public static ParticipantSessionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        CONFERENCE_RECORD_PARTICIPANT_PARTICIPANT_SESSION.validatedMatch(
            formattedString, "ParticipantSessionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("conference_record"),
        matchMap.get("participant"),
        matchMap.get("participant_session"));
  }

  public static List<ParticipantSessionName> parseList(List<String> formattedStrings) {
    List<ParticipantSessionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ParticipantSessionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ParticipantSessionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return CONFERENCE_RECORD_PARTICIPANT_PARTICIPANT_SESSION.matches(formattedString);
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
          if (participantSession != null) {
            fieldMapBuilder.put("participant_session", participantSession);
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
    return CONFERENCE_RECORD_PARTICIPANT_PARTICIPANT_SESSION.instantiate(
        "conference_record",
        conferenceRecord,
        "participant",
        participant,
        "participant_session",
        participantSession);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ParticipantSessionName that = ((ParticipantSessionName) o);
      return Objects.equals(this.conferenceRecord, that.conferenceRecord)
          && Objects.equals(this.participant, that.participant)
          && Objects.equals(this.participantSession, that.participantSession);
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
    h *= 1000003;
    h ^= Objects.hashCode(participantSession);
    return h;
  }

  /**
   * Builder for
   * conferenceRecords/{conference_record}/participants/{participant}/participantSessions/{participant_session}.
   */
  public static class Builder {
    private String conferenceRecord;
    private String participant;
    private String participantSession;

    protected Builder() {}

    public String getConferenceRecord() {
      return conferenceRecord;
    }

    public String getParticipant() {
      return participant;
    }

    public String getParticipantSession() {
      return participantSession;
    }

    public Builder setConferenceRecord(String conferenceRecord) {
      this.conferenceRecord = conferenceRecord;
      return this;
    }

    public Builder setParticipant(String participant) {
      this.participant = participant;
      return this;
    }

    public Builder setParticipantSession(String participantSession) {
      this.participantSession = participantSession;
      return this;
    }

    private Builder(ParticipantSessionName participantSessionName) {
      this.conferenceRecord = participantSessionName.conferenceRecord;
      this.participant = participantSessionName.participant;
      this.participantSession = participantSessionName.participantSession;
    }

    public ParticipantSessionName build() {
      return new ParticipantSessionName(this);
    }
  }
}
