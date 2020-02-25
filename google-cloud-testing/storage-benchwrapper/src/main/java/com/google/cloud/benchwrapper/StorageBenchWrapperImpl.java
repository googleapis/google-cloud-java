/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.benchwrapper;

import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.nio.ByteBuffer;

import com.google.cloud.benchwrapper.StorageBenchWrapperGrpc.StorageBenchWrapperImplBase;
import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;

class StorageBenchWrapperImpl extends StorageBenchWrapperImplBase {
  private Storage client;

  public StorageBenchWrapperImpl(String storageEmulatorHost) {
    if (storageEmulatorHost == null || storageEmulatorHost.isEmpty()){
      System.out.println("Initializing client against live service...");
      client = StorageOptions.newBuilder()
          .build()
          .getService();
    } else {
      System.out.println("Initializing client against emulated service...");
      client = StorageOptions.newBuilder()
        .setHost("http://" + storageEmulatorHost)
        .build()
        .getService();
    }
  }

  public void write(ObjectWrite request, StreamObserver<EmptyResponse> responseObserver) {
    System.out.println("write has been called");
    EmptyResponse reply = EmptyResponse.newBuilder().build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }

  public void read(ObjectRead request, StreamObserver<EmptyResponse> responseObserver) {
    System.out.println("read has been called");

    Blob blob = client.get(BlobId.of(request.getBucketName(), request.getObjectName()));

    try (ReadChannel reader = blob.reader()) {
      ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
      while (reader.read(bytes) > 0) {
        bytes.flip();
        // do nothing with bytes
        bytes.clear();
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }

    EmptyResponse reply = EmptyResponse.newBuilder().build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}
