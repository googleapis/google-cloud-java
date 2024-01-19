/*
 * Copyright 2023 Google LLC
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

package com.google.apps.meet.v2beta;

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
public class RecordingName implements ResourceName {
  private static final PathTemplate CONFERENCE_RECORD_RECORDING =
      PathTemplate.createWithoutUrlEncoding(
          "conferenceRecords/{conference_record}/recordings/{recording}");
  private volatile Map<String, String> fieldValuesMap;
  private final String conferenceRecord;
  private final String recording;

  @Deprecated
  protected RecordingName() {
    conferenceRecord = null;
    recording = null;
  }

  private RecordingName(Builder builder) {
    conferenceRecord = Preconditions.checkNotNull(builder.getConferenceRecord());
    recording = Preconditions.checkNotNull(builder.getRecording());
  }

  public String getConferenceRecord() {
    return conferenceRecord;
  }

  public String getRecording() {
    return recording;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RecordingName of(String conferenceRecord, String recording) {
    return newBuilder().setConferenceRecord(conferenceRecord).setRecording(recording).build();
  }

  public static String format(String conferenceRecord, String recording) {
    return newBuilder()
        .setConferenceRecord(conferenceRecord)
        .setRecording(recording)
        .build()
        .toString();
  }

  public static RecordingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        CONFERENCE_RECORD_RECORDING.validatedMatch(
            formattedString, "RecordingName.parse: formattedString not in valid format");
    return of(matchMap.get("conference_record"), matchMap.get("recording"));
  }

  public static List<RecordingName> parseList(List<String> formattedStrings) {
    List<RecordingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RecordingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RecordingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return CONFERENCE_RECORD_RECORDING.matches(formattedString);
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
          if (recording != null) {
            fieldMapBuilder.put("recording", recording);
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
    return CONFERENCE_RECORD_RECORDING.instantiate(
        "conference_record", conferenceRecord, "recording", recording);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RecordingName that = ((RecordingName) o);
      return Objects.equals(this.conferenceRecord, that.conferenceRecord)
          && Objects.equals(this.recording, that.recording);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(conferenceRecord);
    h *= 1000003;
    h ^= Objects.hashCode(recording);
    return h;
  }

  /** Builder for conferenceRecords/{conference_record}/recordings/{recording}. */
  public static class Builder {
    private String conferenceRecord;
    private String recording;

    protected Builder() {}

    public String getConferenceRecord() {
      return conferenceRecord;
    }

    public String getRecording() {
      return recording;
    }

    public Builder setConferenceRecord(String conferenceRecord) {
      this.conferenceRecord = conferenceRecord;
      return this;
    }

    public Builder setRecording(String recording) {
      this.recording = recording;
      return this;
    }

    private Builder(RecordingName recordingName) {
      this.conferenceRecord = recordingName.conferenceRecord;
      this.recording = recordingName.recording;
    }

    public RecordingName build() {
      return new RecordingName(this);
    }
  }
}
