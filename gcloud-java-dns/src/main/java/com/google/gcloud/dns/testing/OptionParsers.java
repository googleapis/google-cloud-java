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

package com.google.gcloud.dns.testing;

import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility helpers for LocalDnsHelper.
 */
class OptionParsers {

  private OptionParsers() {
  }

  static Map<String, Object> parseListZonesOptions(String query) {
    Map<String, Object> options = new HashMap<>();
    if (query != null) {
      String[] args = query.split("&");
      for (String arg : args) {
        String[] argEntry = arg.split("=");
        switch (argEntry[0]) {
          case "fields":
            // List fields are in the form "managedZones(field1, field2, ...),nextPageToken"
            String replaced = argEntry[1].replace("managedZones(", ",");
            replaced = replaced.replace(")", ",");
            // we will get empty strings, but it does not matter, they will be ignored
            options.put("fields", replaced.split(","));
            break;
          case "dnsName":
            options.put("dnsName", argEntry[1]);
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
    return new String[0];
  }

  static ManagedZone extractFields(ManagedZone fullZone, String... fields) {
    if (fields == null || fields.length == 0) {
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

  static Change extractFields(Change fullChange, String... fields) {
    if (fields == null || fields.length == 0) {
      return fullChange;
    }
    Change change = new Change();
    for (String field : fields) {
      switch (field) {
        case "additions":
          change.setAdditions(fullChange.getAdditions());
          break;
        case "deletions":
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

  static Project extractFields(Project fullProject, String... fields) {
    if (fields == null || fields.length == 0) {
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

  static ResourceRecordSet extractFields(ResourceRecordSet fullRecord, String... fields) {
    if (fields == null || fields.length == 0) {
      return fullRecord;
    }
    ResourceRecordSet recordSet = new ResourceRecordSet();
    for (String field : fields) {
      switch (field) {
        case "name":
          recordSet.setName(fullRecord.getName());
          break;
        case "rrdatas":
          recordSet.setRrdatas(fullRecord.getRrdatas());
          break;
        case "type":
          recordSet.setType(fullRecord.getType());
          break;
        case "ttl":
          recordSet.setTtl(fullRecord.getTtl());
          break;
        default:
          break;
      }
    }
    return recordSet;
  }

  static Map<String, Object> parseListChangesOptions(String query) {
    Map<String, Object> options = new HashMap<>();
    if (query != null) {
      String[] args = query.split("&");
      for (String arg : args) {
        String[] argEntry = arg.split("=");
        switch (argEntry[0]) {
          case "fields":
            String replaced = argEntry[1].replace("changes(", ",").replace(")", ",");
            options.put("fields", replaced.split(",")); // empty strings will be ignored
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
