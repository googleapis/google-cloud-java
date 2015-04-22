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

import com.google.gcloud.storage.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
 * -Dexec.args="project_id list [<bucket>]|info [<bucket> [<file>]]|get <bucket> <path>|upload <local_file> <bucket> [<path>]|delete <bucket> <path>"}</li>
 * </ol>
 */
public class StorageExample {

  private static final Map<String, StorageAction> ACTIONS = new HashMap<>();

  private static abstract class StorageAction<T> {

    abstract void run(StorageService storage, T request) throws Exception;

    abstract T parse(String... args) throws IllegalArgumentException;

    protected String params() {
      return "";
    }
  }

  private static class Tuple<X, Y> {

    private final X x;
    private final Y y;

    private Tuple(X x, Y y) {
      this.x = x;
      this.y = y;
    }

    static <X, Y> Tuple<X, Y> of(X x, Y y) {
      return new Tuple<>(x, y);
    }

    X first() {
      return x;
    }

    Y second() {
      return y;
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

  private static class UploadAction extends StorageAction<Tuple<Path, Blob>> {
    @Override
    public void run(StorageService storage, Tuple<Path, Blob> tuple) throws Exception {
      if (Files.size(tuple.first()) > 1_000_000) {
        // todo upload via streaming API
        throw new IllegalArgumentException("file is too big");
      } else {
        byte[] bytes = Files.readAllBytes(tuple.first());
        System.out.println(storage.create(tuple.second(), bytes));
      }
    }

    @Override
    Tuple<Path, Blob> parse(String... args) {
      if (args.length < 2 || args.length > 3) {
        throw new IllegalArgumentException();
      }
      Path path = Paths.get(args[0]);
      String blob = args.length < 3 ? path.getFileName().toString() : args[2];
      return Tuple.of(path, Blob.of(args[1], blob));
    }

    @Override
    public String params() {
      return "<local_file> <bucket> [<path>]";
    }
  }

  static {
    ACTIONS.put("info", new InfoAction());
    ACTIONS.put("delete", new DeleteAction());
    ACTIONS.put("list", new ListAction());
    ACTIONS.put("upload", new UploadAction());
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

  @SuppressWarnings("unchecked")
  public static void main(String... args) throws Exception {
    if (args.length < 2) {
      System.out.println("Missing required project id and action");
      printUsage();
      return;
    }
    String projectId = args[0];
    StorageAction action = ACTIONS.get(args[1]);
    if (action == null) {
      System.out.println("Unrecognized action '" + args[1] + "'");
      printUsage();
      return;
    }
    StorageServiceOptions options = StorageServiceOptions.builder().project(args[0]).build();
    StorageService storage = StorageServiceFactory.instance().get(options);
    args = args.length > 2 ? Arrays.copyOfRange(args, 2, args.length): new String []{};
    Object request;
    try {
      request = action.parse(args);
    } catch (Exception ex) {
      System.out.println("Invalid input for action '" + args[1] + "'");
      System.out.println("Expected: " + action.params());
      return;
    }
    action.run(storage, request);
  }
}
