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
public class TranscriptName implements ResourceName {
  private static final PathTemplate CONFERENCE_RECORD_TRANSCRIPT =
      PathTemplate.createWithoutUrlEncoding(
          "conferenceRecords/{conference_record}/transcripts/{transcript}");
  private volatile Map<String, String> fieldValuesMap;
  private final String conferenceRecord;
  private final String transcript;

  @Deprecated
  protected TranscriptName() {
    conferenceRecord = null;
    transcript = null;
  }

  private TranscriptName(Builder builder) {
    conferenceRecord = Preconditions.checkNotNull(builder.getConferenceRecord());
    transcript = Preconditions.checkNotNull(builder.getTranscript());
  }

  public String getConferenceRecord() {
    return conferenceRecord;
  }

  public String getTranscript() {
    return transcript;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TranscriptName of(String conferenceRecord, String transcript) {
    return newBuilder().setConferenceRecord(conferenceRecord).setTranscript(transcript).build();
  }

  public static String format(String conferenceRecord, String transcript) {
    return newBuilder()
        .setConferenceRecord(conferenceRecord)
        .setTranscript(transcript)
        .build()
        .toString();
  }

  public static TranscriptName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        CONFERENCE_RECORD_TRANSCRIPT.validatedMatch(
            formattedString, "TranscriptName.parse: formattedString not in valid format");
    return of(matchMap.get("conference_record"), matchMap.get("transcript"));
  }

  public static List<TranscriptName> parseList(List<String> formattedStrings) {
    List<TranscriptName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TranscriptName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TranscriptName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return CONFERENCE_RECORD_TRANSCRIPT.matches(formattedString);
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
          if (transcript != null) {
            fieldMapBuilder.put("transcript", transcript);
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
    return CONFERENCE_RECORD_TRANSCRIPT.instantiate(
        "conference_record", conferenceRecord, "transcript", transcript);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TranscriptName that = ((TranscriptName) o);
      return Objects.equals(this.conferenceRecord, that.conferenceRecord)
          && Objects.equals(this.transcript, that.transcript);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(conferenceRecord);
    h *= 1000003;
    h ^= Objects.hashCode(transcript);
    return h;
  }

  /** Builder for conferenceRecords/{conference_record}/transcripts/{transcript}. */
  public static class Builder {
    private String conferenceRecord;
    private String transcript;

    protected Builder() {}

    public String getConferenceRecord() {
      return conferenceRecord;
    }

    public String getTranscript() {
      return transcript;
    }

    public Builder setConferenceRecord(String conferenceRecord) {
      this.conferenceRecord = conferenceRecord;
      return this;
    }

    public Builder setTranscript(String transcript) {
      this.transcript = transcript;
      return this;
    }

    private Builder(TranscriptName transcriptName) {
      this.conferenceRecord = transcriptName.conferenceRecord;
      this.transcript = transcriptName.transcript;
    }

    public TranscriptName build() {
      return new TranscriptName(this);
    }
  }
}
