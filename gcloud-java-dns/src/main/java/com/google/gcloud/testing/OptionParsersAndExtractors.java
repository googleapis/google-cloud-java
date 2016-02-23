/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.testing;

import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility helpers for LocalDnsHelper.
 */
class OptionParsersAndExtractors {

  /**
   * Makes a map of list options. Expects query to be only query part of the url (i.e., what follows
   * the '?').
   */
  static Map<String, Object> parseListZonesOptions(String query) {
    Map<String, Object> options = new HashMap<>();
    if (query != null) {
      String[] args = query.split("&");
      for (String arg : args) {
        String[] argEntry = arg.split("=");
        switch (argEntry[0]) {
          case "fields":
            // List fields are in the form "managedZones(field1, field2, ...)"
            String replaced = argEntry[1].replace("managedZones(", ",");
            replaced = replaced.replace(")", ",");
            // we will get empty strings, but it does not matter, they will be ignored
            options.put(
                "fields",
                replaced.split(","));
            break;
          case "dnsName":
            options.put("dnsName", argEntry[1]);
            break;
          case "nextPageToken":
            options.put("nextPageToken", argEntry[1]);
            break;
          case "pageToken":
            options.put("pageToken", argEntry[1]);
            break;
          case "maxResults":
            // parsing to int is done while handling
            options.put("maxResults", argEntry[1]);
            break;
          default:
            break;
        }
      }
    }
    return options;
  }

  /**
   * Makes a map of list options. Expects query to be only query part of the url (i.e., what follows
   * the '?'). This format is common for all of zone, change and project.
   */
  static String[] parseGetOptions(String query) {
    if (query != null) {
      String[] args = query.split("&");
      for (String arg : args) {
        String[] argEntry = arg.split("=");
        if (argEntry[0].equals("fields")) {
          // List fields are in the form "fields=field1, field2,..."
          return argEntry[1].split(",");
        }
      }
    }
    return null;
  }

  /**
   * Extracts only request fields.
   */
  static ManagedZone extractFields(ManagedZone fullZone, String[] fields) {
    if (fields == null) {
      return fullZone;
    }
    ManagedZone managedZone = new ManagedZone();
    for (String field : fields) {
      switch (field) {
        case "creationTime":
          managedZone.setCreationTime(fullZone.getCreationTime());
          break;
        case "description":
          managedZone.setDescription(fullZone.getDescription());
          break;
        case "dnsName":
          managedZone.setDnsName(fullZone.getDnsName());
          break;
        case "id":
          managedZone.setId(fullZone.getId());
          break;
        case "name":
          managedZone.setName(fullZone.getName());
          break;
        case "nameServerSet":
          managedZone.setNameServerSet(fullZone.getNameServerSet());
          break;
        case "nameServers":
          managedZone.setNameServers(fullZone.getNameServers());
          break;
        default:
          break;
      }
    }
    return managedZone;
  }

  /**
   * Extracts only request fields.
   */
  static Change extractFields(Change fullChange, String[] fields) {
    if (fields == null) {
      return fullChange;
    }
    Change change = new Change();
    for (String field : fields) {
      switch (field) {
        case "additions":
          // todo the fragmentation is ignored here as our api does not support it
          change.setAdditions(fullChange.getAdditions());
          break;
        case "deletions":
          // todo the fragmentation is ignored here as our api does not support it
          change.setDeletions(fullChange.getDeletions());
          break;
        case "id":
          change.setId(fullChange.getId());
          break;
        case "startTime":
          change.setStartTime(fullChange.getStartTime());
          break;
        case "status":
          change.setStatus(fullChange.getStatus());
          break;
        default:
          break;
      }
    }
    return change;
  }

  /**
   * Extracts only request fields.
   */
  static Project extractFields(Project fullProject, String[] fields) {
    if (fields == null) {
      return fullProject;
    }
    Project project = new Project();
    for (String field : fields) {
      switch (field) {
        case "id":
          project.setId(fullProject.getId());
          break;
        case "number":
          project.setNumber(fullProject.getNumber());
          break;
        case "quota":
          project.setQuota(fullProject.getQuota());
          break;
        default:
          break;
      }
    }
    return project;
  }

  /**
   * Extracts only request fields.
   */
  static ResourceRecordSet extractFields(ResourceRecordSet fullRecord, String[] fields) {
    if (fields == null) {
      return fullRecord;
    }
    ResourceRecordSet record = new ResourceRecordSet();
    for (String field : fields) {
      switch (field) {
        case "name":
          record.setName(fullRecord.getName());
          break;
        case "rrdatas":
          record.setRrdatas(fullRecord.getRrdatas());
          break;
        case "type":
          record.setType(fullRecord.getType());
          break;
        case "ttl":
          record.setTtl(fullRecord.getTtl());
          break;
        default:
          break;
      }
    }
    return record;
  }

  static Map<String, Object> parseListChangesOptions(String query) {
    Map<String, Object> options = new HashMap<>();
    if (query != null) {
      String[] args = query.split("&");
      for (String arg : args) {
        String[] argEntry = arg.split("=");
        switch (argEntry[0]) {
          case "fields":
            // todo we do not support fragmentation in deletions and additions in the library
            String replaced = argEntry[1].replace("changes(", ",").replace(")", ",");
            options.put("fields", replaced.split(",")); // empty strings will be ignored
            break;
          case "name":
            options.put("name", argEntry[1]);
            break;
          case "nextPageToken":
            options.put("nextPageToken", argEntry[1]);
            break;
          case "pageToken":
            options.put("pageToken", argEntry[1]);
            break;
          case "sortBy":
            options.put("sortBy", argEntry[1]);
            break;
          case "sortOrder":
            options.put("sortOrder", argEntry[1]);
            break;
          case "maxResults":
            // parsing to int is done while handling
            options.put("maxResults", argEntry[1]);
            break;
          default:
            break;
        }
      }
    }
    return options;
  }

  static Map<String, Object> parseListDnsRecordsOptions(String query) {
    Map<String, Object> options = new HashMap<>();
    if (query != null) {
      String[] args = query.split("&");
      for (String arg : args) {
        String[] argEntry = arg.split("=");
        switch (argEntry[0]) {
          case "fields":
            String replace = argEntry[1].replace("rrsets(", ",");
            replace = replace.replace(")", ",");
            options.put("fields", replace.split(",")); // empty strings do not matter
            break;
          case "name":
            options.put("name", argEntry[1]);
            break;
          case "type":
            options.put("type", argEntry[1]);
            break;
          case "pageToken":
            options.put("pageToken", argEntry[1]);
            break;
          case "nextPageToken":
            options.put("nextPageToken", argEntry[1]);
            break;
          case "maxResults":
            // parsing to int is done while handling
            options.put("maxResults", argEntry[1]);
            break;
          default:
            break;
        }
      }
    }
    return options;
  }
}
