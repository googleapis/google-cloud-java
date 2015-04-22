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
import com.google.gcloud.storage.ListOptions;
import com.google.gcloud.storage.StorageService;
import com.google.gcloud.storage.StorageServiceFactory;
import com.google.gcloud.storage.StorageServiceOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
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
 * -Dexec.args="list [<bucket>]|info [<bucket> [<file>]]|get <bucket> <path>|upload <local_file> <bucket> [<path>]|delete <bucket> <path>"}</li>
 * </ol>
 */
public class StorageExample {

  private static final Map<String, StorageAction> ACTIONS = new HashMap<>();

  private static abstract class StorageAction<T> {

    abstract void run(StorageService storage, T request);

    abstract T parse(String... args);

    protected String params() {
      return "";
    }
  }

  private static abstract class BlobAction extends StorageAction<Blob> {

    @Override
    Blob parse(String... args) {
      if (args.length != 2) {
        throw new IllegalArgumentException();
      }
      return Blob.of(args[0], args[1]);
    }

    @Override
    public String params() {
      return "<bucket> <path>";
    }
  }

  private static class InfoAction extends BlobAction {
    @Override
    public void run(StorageService storage, Blob blob) {
      if (blob.name().isEmpty()) {
        System.out.println(storage.get(Bucket.of(blob.bucket())));
      } else {
        System.out.println(storage.get(blob));
      }
    }

    @Override
    Blob parse(String... args) {
      if (args.length < 2) {
        return Blob.of(args[0], "");
      }
      return super.parse(args);
    }

    @Override
    public String params() {
      return "<bucket> [<path>]";
    }
  }

  private static class DeleteAction extends BlobAction {
    @Override
    public void run(StorageService storage, Blob blob) {
      storage.delete(blob);
    }

    @Override
    public String params() {
      return "<bucket> <file>";
    }
  }

  private static class ListAction extends StorageAction<String> {

    @Override
    String parse(String... args) {
      if (args.length == 0) {
        return null;
      }
      if (args.length == 1) {
        return args[0];
      }
      throw new IllegalArgumentException();
    }

    @Override
    public void run(StorageService storage, String bucket) {
      if (bucket == null) {
        Iterator<Bucket> buckets = storage.list();
        while (buckets.hasNext()) {
          System.out.println(buckets.next());
        }
      } else {
        Iterator<Blob> blobs = storage.list(bucket, ListOptions.of());
        while (blobs.hasNext()) {
          System.out.println(blobs.next());
        }
      }
    }

    @Override
    public String params() {
      return "[<bucket>]";
    }
  }

  static {
    ACTIONS.put("info", new InfoAction());
    ACTIONS.put("delete", new DeleteAction());
    ACTIONS.put("list", new ListAction());
    //ACTIONS.put("upload", new UploadAction());
    // todo: implement get
  }

  public static void printUsage() {
    StringBuilder actionAndParams = new StringBuilder();
    for (Map.Entry<String, StorageAction> entry : ACTIONS.entrySet()) {
      actionAndParams.append(entry.getKey());

      String param = entry.getValue().params();
      if (param != null && !param.isEmpty()) {
        actionAndParams.append(' ').append(param);
      }
      actionAndParams.append('|');
    }
    actionAndParams.setLength(actionAndParams.length() - 1);
    System.out.printf("Usage: %s [%s]%n",
        StorageExample.class.getSimpleName(), actionAndParams);
  }
  public static void main(String... args) {
    if (args.length == 0) {
      System.out.println("Missing required action");
      printUsage();
      return;
    }
    StorageAction action = ACTIONS.get(args[0]);
    if (action == null) {
      System.out.println("Unrecognized action '" + args[0] + "'");
      printUsage();
      return;
    }
    StorageService storage =
        StorageServiceFactory.instance().get(StorageServiceOptions.builder().build());
    args = args.length > 1 ? Arrays.copyOfRange(args, 1, args.length): new String []{};
    Object request;
    try {
      request = action.parse(args);
    } catch (Exception ex) {
      System.out.println("Invalid input for action '" + args[0] + "'");
      System.out.println("Expected: " + action.params());
      return;
    }
    action.run(storage, request);
  }
}
