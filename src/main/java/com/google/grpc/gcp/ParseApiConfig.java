/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.grpc.gcp;

import com.google.grpc.gcp.proto.AffinityConfig;
import com.google.grpc.gcp.proto.ApiConfig;
import com.google.grpc.gcp.proto.ChannelPoolConfig;
import com.google.grpc.gcp.proto.MethodConfig;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** Parse the JSON file defining API configuration and load it into a variable 'ApiConfig'. */
public class ParseApiConfig {

  private static final Logger logger = Logger.getLogger(ParseApiConfig.class.getName());

  private ParseApiConfig() {}

  public static ApiConfig parseJson(String filePath) {

    Object obj;
    try {
      obj = new JSONParser().parse(new FileReader(filePath));
      if (obj == null) {
        return null;
      }
    } catch (FileNotFoundException e) {
      logger.severe(e.getMessage());
      return null;
    } catch (IOException e) {
      logger.severe(e.getMessage());
      return null;
    } catch (ParseException e) {
      logger.severe(e.getMessage());
      return null;
    }
    JSONObject jsonFile = (JSONObject) obj;
    ApiConfig.Builder apiConfig = ApiConfig.newBuilder();

    // Get the ChannelPoolConfig.
    if (jsonFile.get("channelPool") != null) {
      ChannelPoolConfig.Builder channelPoolConfig = ChannelPoolConfig.newBuilder();
      JSONObject channelJson = (JSONObject) jsonFile.get("channelPool");
      if (channelJson.get("maxSize") != null) {
        channelPoolConfig.setMaxSize((int) (long) channelJson.get("maxSize"));
      }
      if (channelJson.get("maxConcurrentStreamsLowWatermark") != null) {
        channelPoolConfig.setMaxConcurrentStreamsLowWatermark(
            (int) (long) channelJson.get("maxConcurrentStreamsLowWatermark"));
      }
      if (channelJson.get("idleTimeout") != null) {
        channelPoolConfig.setIdleTimeout((long) channelJson.get("idleTimeout"));
      }
      apiConfig.setChannelPool(channelPoolConfig.build());
    }

    // Get methods. There can be multiple methods.
    if (jsonFile.get("method") == null) {
      return apiConfig.build();
    }
    JSONArray methodsJson = (JSONArray) jsonFile.get("method");
    Iterator iterMethods = methodsJson.iterator();
    while (iterMethods.hasNext()) {
      MethodConfig.Builder methodConfig = MethodConfig.newBuilder();
      JSONObject methodJson = (JSONObject) iterMethods.next();

      // For each method, there can be multiple names.
      if (methodJson.get("name") != null) {
        JSONArray namesJson = (JSONArray) methodJson.get("name");
        Iterator iterNames = namesJson.iterator();
        while (iterNames.hasNext()) {
          methodConfig.addName((String) iterNames.next());
        }
      }

      // Get the affinity config.
      if (methodJson.get("affinity") != null) {
        AffinityConfig.Builder affinityConfig = AffinityConfig.newBuilder();
        JSONObject affinityJson = (JSONObject) methodJson.get("affinity");
        if (affinityJson.get("affinityKey") != null) {
          affinityConfig.setAffinityKey((String) affinityJson.get("affinityKey"));
        }
        if (affinityJson.get("command") != null) {
          switch ((String) affinityJson.get("command")) {
            case "UNBIND":
              affinityConfig.setCommand(AffinityConfig.Command.UNBIND);
              break;
            case "BOUND":
              affinityConfig.setCommand(AffinityConfig.Command.BOUND);
              break;
            case "BIND":
              affinityConfig.setCommand(AffinityConfig.Command.BIND);
              break;
          }
        }
        methodConfig.setAffinity(affinityConfig.build());
      }
      apiConfig.addMethod(methodConfig.build());
    }
    return apiConfig.build();
  }
}
