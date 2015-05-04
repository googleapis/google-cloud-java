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

import com.google.gcloud.spi.StorageRpc.Tuple;
import com.google.gcloud.storage.BatchRequest;
import com.google.gcloud.storage.BatchResponse;
import com.google.gcloud.storage.Blob;
import com.google.gcloud.storage.Bucket;
import com.google.gcloud.storage.StorageService;
import com.google.gcloud.storage.StorageService.ComposeRequest;
import com.google.gcloud.storage.StorageService.CopyRequest;
import com.google.gcloud.storage.StorageServiceFactory;
import com.google.gcloud.storage.StorageServiceOptions;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * An example of using the Google Cloud Storage.
 * <p>
 * This example demonstrates a simple/typical usage.
 * <p>
 * Steps needed for running the example:
 * <ol>
 * <li>login using gcloud SDK - {@code gcloud auth login}.</li>
 * <li>compile using maven - {@code mvn compile}</li>
 * <li>run using maven -
 * {@code mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.StorageExample"
 * -Dexec.args="[<project_id>] list [<bucket>]| info [<bucket> [<file>]]| get <bucket> <path>|
 *  upload <local_file> <bucket> [<path>]| delete <bucket> <path>+|
 *  cp <from_bucket> <from_path> <to_bucket> <to_path>| compose <bucket> <from_path>+ <to_path>"}
 * </li>
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

  private static abstract class BlobsAction extends StorageAction<Blob[]> {

    @Override
    Blob[] parse(String... args) {
      if (args.length < 2) {
        throw new IllegalArgumentException();
      }
      Blob[] blobs = new Blob[args.length - 1];
      for (int i = 1; i < args.length; i++) {
        blobs[i - 1] = Blob.of(args[0], args[i]);
      }
      return blobs;
    }

    @Override
    public String params() {
      return "<bucket> <path>+";
    }
  }

  private static class InfoAction extends BlobsAction {
    @Override
    public void run(StorageService storage, Blob... blobs) {
      if (blobs.length == 1) {
        if (blobs[0].name().isEmpty()) {
          System.out.println(storage.get(Bucket.of(blobs[0].bucket())));
        } else {
          System.out.println(storage.get(blobs[0]));
        }
      } else {
        BatchRequest.Builder batch = BatchRequest.builder();
        for (Blob blob : blobs) {
          batch.get(blob);
        }
        BatchResponse response = storage.apply(batch.build());
        System.out.println(response.gets());
      }
    }

    @Override
    Blob[] parse(String... args) {
      if (args.length < 2) {
        return new Blob[] {Blob.of(args[0], "")};
      }
      return super.parse(args);
    }

    @Override
    public String params() {
      return "<bucket> [<path>+]";
    }
  }

  private static class DeleteAction extends BlobsAction {
    @Override
    public void run(StorageService storage, Blob... blobs) {
      if (blobs.length == 1) {
        System.out.println(storage.delete(blobs[0]));
      } else {
        BatchRequest.Builder batch = BatchRequest.builder();
        for (Blob blob : blobs) {
          batch.delete(blob);
        }
        BatchResponse response = storage.apply(batch.build());
        System.out.println(response.deletes());
      }
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
        for (Bucket b : storage.list()) {
          System.out.println(b);
        }
      } else {
        for (Blob b : storage.list(bucket)) {
          System.out.println(b);
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
      if (Files.size(tuple.x()) > 1_000_000) {
        // todo: upload via streaming API
        throw new IllegalArgumentException("file is too big");
      } else {
        byte[] bytes = Files.readAllBytes(tuple.x());
        System.out.println(storage.create(tuple.y(), bytes));
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

  private static class GetAction extends BlobAction {
    @Override
    public void run(StorageService storage, Blob blob) {
      blob = storage.get(blob);
      if (blob == null) {
        System.out.println("No such object");
        return;
      }
      if (blob.size() < 1_000_000) {
        System.out.println(new String(storage.load(blob), StandardCharsets.UTF_8));
      } else {
        // todo: download via streaming API
        throw new IllegalArgumentException("file is too big");
      }
    }
  }

  private static class CopyAction extends StorageAction<CopyRequest> {
    @Override
    public void run(StorageService storage, CopyRequest request) {
      System.out.println(storage.copy(request));
    }

    @Override
    CopyRequest parse(String... args) {
      if (args.length != 4) {
        throw new IllegalArgumentException();
      }
      return CopyRequest.of(Blob.of(args[0], args[1]), Blob.of(args[2], args[3]));
    }

    @Override
    public String params() {
      return "<from_bucket> <from_path> <to_bucket> <to_path>";
    }
  }

  private static class ComposeAction extends StorageAction<ComposeRequest> {
    @Override
    public void run(StorageService storage, ComposeRequest request) {
      System.out.println(storage.compose(request));
    }

    @Override
    ComposeRequest parse(String... args) {
      if (args.length < 3) {
        throw new IllegalArgumentException();
      }
      ComposeRequest.Builder request = ComposeRequest.builder();
      request.target(Blob.of(args[0], args[args.length - 1]));
      for (int i = 1; i < args.length - 1; i++) {
        request.addSource(args[i]);
      }
      return request.build();
    }

    @Override
    public String params() {
      return "<bucket> <from_path>+ <to_path>";
    }
  }

  static {
    ACTIONS.put("info", new InfoAction());
    ACTIONS.put("delete", new DeleteAction());
    ACTIONS.put("list", new ListAction());
    ACTIONS.put("upload", new UploadAction());
    ACTIONS.put("get", new GetAction());
    ACTIONS.put("cp", new CopyAction());
    ACTIONS.put("compose", new ComposeAction());
  }

  public static void printUsage() {
    StringBuilder actionAndParams = new StringBuilder("");
    for (Map.Entry<String, StorageAction> entry : ACTIONS.entrySet()) {
      actionAndParams.append("\n\t").append(entry.getKey());

      String param = entry.getValue().params();
      if (param != null && !param.isEmpty()) {
        actionAndParams.append(' ').append(param);
      }
    }
    System.out.printf("Usage: %s <project_id> <operation> <args>*%s%n",
        StorageExample.class.getSimpleName(), actionAndParams);
  }

  @SuppressWarnings("unchecked")
  public static void main(String... args) throws Exception {
    if (args.length < 1) {
      System.out.println("Missing required project id and action");
      printUsage();
      return;
    }
    StorageServiceOptions.Builder optionsBuilder = StorageServiceOptions.builder();
    StorageAction action;
    if (args.length >= 2 && !ACTIONS.containsKey(args[0])) {
      optionsBuilder.project(args[0]);
      action = ACTIONS.get(args[1]);
      args = Arrays.copyOfRange(args, 2, args.length);
    } else {
      action = ACTIONS.get(args[0]);
      args = Arrays.copyOfRange(args, 1, args.length);
    }
    if (action == null) {
      System.out.println("Unrecognized action '" + args[1] + "'");
      printUsage();
      return;
    }
    StorageService storage = StorageServiceFactory.instance().get(optionsBuilder.build());
    Object request;
    try {
      request = action.parse(args);
    } catch (IllegalArgumentException ex) {
      System.out.println("Invalid input for action '" + args[1] + "'");
      System.out.println("Expected: " + action.params());
      return;
    } catch (Exception ex) {
      System.out.println("Failed to parse request.");
      ex.printStackTrace();
      return;
    }
    action.run(storage, request);
  }
}
