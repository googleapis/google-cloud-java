/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package org.slf4j.impl;

import com.google.cloud.logging.Severity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.Marker;
import org.slf4j.impl.config.ConfigLoader;

class LogDetailsTuple {

  private static final String DEFAULT_LABEL_VALUE = "true";
  private Map<String, String> labels;
  private Severity level;

  LogDetailsTuple(Marker marker, Map<String, String> labels, Severity level) {
    this.level = level;
    this.labels = new HashMap<>();
    if (marker != null) {
      Iterator<Marker> markerIterator = marker.iterator();
      if (!markerIterator.hasNext()) {
        String[] labelWithValue = getMarkerLabelWithValue(marker);
        add(labelWithValue[0], labelWithValue[1]);
      } else {
        while (markerIterator.hasNext()) {
          Marker m = markerIterator.next();
          String[] labelWithValue = getMarkerLabelWithValue(m);
          add(labelWithValue[0], labelWithValue[1]);
        }
      }
      if (labels != null) {
        for (Map.Entry<String, String> label : labels.entrySet()) {
          add(label.getKey(), label.getValue());
        }
      }
    }
  }

  private String[] getMarkerLabelWithValue(Marker marker) {
    String name = marker.getName();
    String value = DEFAULT_LABEL_VALUE;
    int colonIndex = marker.getName().indexOf(':');
    if (colonIndex >= 0) {
      value = marker.getName().substring(colonIndex + 1, name.length());
      name = marker.getName().substring(0, colonIndex);
    }
    return new String[] {name, value};
  }

  private void add(String labelName, String labelValue) {
    //label value from system property/environment
    if (labelValue != null) {
      if (labelValue.charAt(0) == '$' && labelValue.length() > 1) {
        labelValue = ConfigLoader.getValue(labelValue.substring(1), DEFAULT_LABEL_VALUE);
      }
    }
    // level label with higher severity overrides existing level, else gets added as label
    if (labelName.toLowerCase().equals("level")) {
      if (!overrideLevel(labelValue)) {
        labels.put(labelName, labelValue);
      }
    } else if (!overrideLevel(labelName)) {
      labels.put(labelName, labelValue);
    }
  }

  Map<String, String> getLabels() {
    return labels;
  }

  Severity getLevel() {
    return level;
  }

  private boolean overrideLevel(String s) {
    try {
      Severity override = Severity.valueOf(s.toUpperCase());
      //If current severity is higher than marker severity, do not update
      if (level == null || level.compareTo(override) < 0) {
        level = override;
        return true;
      }
    } catch (Exception e) {
      return false;
    }
    return false;
  }
}
