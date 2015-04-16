/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.examples;

import com.google.gcloud.storage.Blob;
import com.google.gcloud.storage.Bucket;
import com.google.gcloud.storage.StorageService;
import com.google.gcloud.storage.StorageServiceFactory;
import com.google.gcloud.storage.StorageServiceOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * An example of using the Google Cloud Storage.
 * <p>
 * This example demonstrates a simple/typical usage.
 * <p>
 * Steps needed for running the example:<ol>
 * <li>login using gcloud SDK - {@code gcloud auth login}.</li>
 * <li>compile using maven - {@code mvn compile}</li>
 * <li>run using maven - {@code mvn exec:java
 * -Dexec.mainClass="com.google.gcloud.examples.StorageExample"
 * -Dexec.args="<bucket> [<folder>] [list|get <file>|put <file> [<from>]|delete <file>...]"}</li>
 * </ol>
 */
public class StorageExample {

  private static final String DEFAULT_FOLDER = "_STORAGE_EXAMPLE";
  private static final String DEFAULT_ACTION = "list";
  private static final Map<String, StorageAction> ACTIONS = new HashMap<>();

  private static abstract class StorageAction {

    abstract void run(StorageService storage, Bucket bucket, String folder, String... args);

    protected String getRequiredParams() {
      return "";
    }

    protected String fullPath(String folder, String file) {
      StringBuilder stringBuilder = new StringBuilder(folder);
      if (!folder.endsWith("/")) {
        stringBuilder.append('/');
      }
      return stringBuilder.append(file).toString();
    }
  }

  private static class DeleteAction extends StorageAction {
    @Override
    public void run(StorageService storage, Bucket bucket, String folder, String... args) {
      for (String file : args) {
        storage.delete(Blob.builder(bucket, fullPath(folder, file)).build());
      }
    }

    @Override
    public String getRequiredParams() {
      return "<file>...";
    }
  }

  static {
    ACTIONS.put("delete", new DeleteAction());
    // todo: implement list, get and put
  }

  public static void main(String... args) {
    StorageAction action = null;
    StorageService storage = null;
    Bucket bucket = null;
    String folder = DEFAULT_FOLDER;
    if (args.length > 0) {
      String bucketName = args[0];
      String actionName = DEFAULT_ACTION;
      if (args.length > 1) {
        folder = args[1];
        if (args.length > 2) {
          actionName = args[2].toLowerCase();
        }
        storage = StorageServiceFactory.getDefault(StorageServiceOptions.builder().build());
        bucket = storage.get(bucketName);
      }
      action = ACTIONS.get(actionName);
    }

    if (action == null) {
      StringBuilder actionAndParams = new StringBuilder();
      for (Map.Entry<String, StorageAction> entry : ACTIONS.entrySet()) {
        actionAndParams.append(entry.getKey());
        String param = entry.getValue().getRequiredParams();
        if (param != null && !param.isEmpty()) {
          actionAndParams.append(' ').append(param);
        }
        actionAndParams.append('|');
      }
      actionAndParams.setLength(actionAndParams.length() - 1);
      System.out.printf("Usage: %s bucket [<folder>] [%s]%n",
          StorageExample.class.getSimpleName(), actionAndParams);
      return;
    }

    args = args.length > 2 ? Arrays.copyOfRange(args, 2, args.length): new String []{};
    action.run(storage, bucket, folder, args);
  }
}
