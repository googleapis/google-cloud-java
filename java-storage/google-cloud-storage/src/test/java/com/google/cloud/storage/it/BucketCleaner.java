/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.it;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BucketSourceOption;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.DeleteFolderRequest;
import com.google.storage.control.v2.DeleteManagedFolderRequest;
import com.google.storage.control.v2.Folder;
import com.google.storage.control.v2.GetStorageLayoutRequest;
import com.google.storage.control.v2.ListFoldersRequest;
import com.google.storage.control.v2.ListManagedFoldersRequest;
import com.google.storage.control.v2.StorageControlClient;
import com.google.storage.control.v2.StorageLayout;
import com.google.storage.control.v2.StorageLayoutName;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BucketCleaner {

  private static final Logger LOGGER = LoggerFactory.getLogger(BucketCleaner.class);

  public static void doCleanup(String bucketName, Storage s) {
    LOGGER.trace("Starting bucket cleanup...");
    String projectId = s.getOptions().getProjectId();
    try {
      // TODO: probe bucket existence, a bad test could have deleted the bucket
      Page<Blob> page1 =
          s.list(bucketName, BlobListOption.userProject(projectId), BlobListOption.versions(true));

      List<DeleteResult> deleteResults =
          StreamSupport.stream(page1.iterateAll().spliterator(), false)
              .map(
                  b ->
                      new DeleteResult(
                          b.getName(),
                          s.delete(b.getBlobId(), BlobSourceOption.userProject(projectId))))
              .collect(Collectors.toList());
      boolean anyFailedObjectDeletes = getIfAnyFailedAndReport(bucketName, deleteResults, "object");

      if (!anyFailedObjectDeletes) {
        s.delete(bucketName, BucketSourceOption.userProject(projectId));
      } else {
        LOGGER.warn("Unable to delete bucket due to previous failed object deletes");
      }
      LOGGER.trace("Bucket cleanup complete");
    } catch (Exception e) {
      LOGGER.error("Error during bucket cleanup.");
    }
  }

  public static void doCleanup(String bucketName, Storage s, StorageControlClient ctrl) {
    LOGGER.warn("Starting bucket cleanup: {}", bucketName);
    String projectId = s.getOptions().getProjectId();
    try {
      // TODO: probe bucket existence, a bad test could have deleted the bucket
      Page<Blob> page1 =
          s.list(
              bucketName,
              BlobListOption.userProject(projectId),
              BlobListOption.versions(true),
              BlobListOption.fields(BlobField.NAME));

      List<DeleteResult> objectResults =
          StreamSupport.stream(page1.iterateAll().spliterator(), false)
              .map(
                  b ->
                      new DeleteResult(
                          b.getName(),
                          s.delete(b.getBlobId(), BlobSourceOption.userProject(projectId))))
              .collect(Collectors.toList());
      boolean anyFailedObjectDelete = getIfAnyFailedAndReport(bucketName, objectResults, "object");
      boolean anyFailedFolderDelete = false;
      boolean anyFailedManagedFolderDelete = false;

      GrpcCallContext grpcCallContext =
          GrpcCallContext.createDefault()
              .withExtraHeaders(
                  ImmutableMap.of("x-goog-user-project", ImmutableList.of(projectId)));
      if (!anyFailedObjectDelete) {
        BucketName parent = BucketName.of("_", bucketName);
        StorageLayout storageLayout =
            ctrl.getStorageLayoutCallable()
                .call(
                    GetStorageLayoutRequest.newBuilder()
                        .setName(
                            StorageLayoutName.of(parent.getProject(), parent.getBucket())
                                .toString())
                        .build(),
                    grpcCallContext);

        List<DeleteResult> folderDeletes;
        if (storageLayout.hasHierarchicalNamespace()
            && storageLayout.getHierarchicalNamespace().getEnabled()) {
          folderDeletes =
              StreamSupport.stream(
                      ctrl.listFoldersPagedCallable()
                          .call(
                              ListFoldersRequest.newBuilder().setParent(parent.toString()).build(),
                              grpcCallContext)
                          .iterateAll()
                          .spliterator(),
                      false)
                  .collect(Collectors.toList())
                  .stream()
                  .sorted(Collections.reverseOrder(Comparator.comparing(Folder::getName)))
                  .map(
                      folder -> {
                        String formatted =
                            String.format(Locale.US, "folder = %s", folder.getName());
                        LOGGER.warn(formatted);
                        boolean success = true;
                        try {
                          ctrl.deleteFolderCallable()
                              .call(
                                  DeleteFolderRequest.newBuilder()
                                      .setName(folder.getName())
                                      .build(),
                                  grpcCallContext);
                        } catch (ApiException e) {
                          success = false;
                        }
                        return new DeleteResult(folder.getName(), success);
                      })
                  .collect(Collectors.toList());
        } else {
          folderDeletes = ImmutableList.of();
        }

        List<DeleteResult> managedFolderDeletes;
        try {
          managedFolderDeletes =
              StreamSupport.stream(
                      ctrl.listManagedFoldersPagedCallable()
                          .call(
                              ListManagedFoldersRequest.newBuilder()
                                  .setParent(parent.toString())
                                  .build(),
                              grpcCallContext)
                          .iterateAll()
                          .spliterator(),
                      false)
                  .map(
                      managedFolder -> {
                        String formatted =
                            String.format(Locale.US, "managedFolder = %s", managedFolder.getName());
                        LOGGER.warn(formatted);
                        boolean success = true;
                        try {
                          ctrl.deleteManagedFolderCallable()
                              .call(
                                  DeleteManagedFolderRequest.newBuilder()
                                      .setName(managedFolder.getName())
                                      .build(),
                                  grpcCallContext);
                        } catch (ApiException e) {
                          success = false;
                        }
                        return new DeleteResult(managedFolder.getName(), success);
                      })
                  .collect(Collectors.toList());
        } catch (FailedPreconditionException fpe) {
          // FAILED_PRECONDITION: Uniform bucket-level access is required to be enabled on the
          //   bucket in order to perform this operation. Read more at
          //   https://cloud.google.com/storage/docs/uniform-bucket-level-access
          managedFolderDeletes = ImmutableList.of();
        }

        anyFailedFolderDelete = getIfAnyFailedAndReport(bucketName, folderDeletes, "folder");
        anyFailedManagedFolderDelete =
            getIfAnyFailedAndReport(bucketName, managedFolderDeletes, "managed folder");
      }

      List<String> failed =
          Stream.of(
                  anyFailedObjectDelete ? "object" : "",
                  anyFailedFolderDelete ? "folder" : "",
                  anyFailedManagedFolderDelete ? "managed folder" : "")
              .filter(ss -> !ss.isEmpty())
              .collect(Collectors.toList());

      if (!anyFailedObjectDelete && !anyFailedFolderDelete && !anyFailedManagedFolderDelete) {
        s.delete(bucketName, BucketSourceOption.userProject(projectId));
      } else {
        LOGGER.warn(
            String.format(
                Locale.US,
                "Unable to delete bucket %s due to previous failed %s deletes",
                bucketName,
                failed));
      }

      LOGGER.warn("Bucket cleanup complete: {}", bucketName);
    } catch (Exception e) {
      LOGGER.error("Error during bucket cleanup.");
    }
  }

  private static boolean getIfAnyFailedAndReport(
      String bucketName, List<DeleteResult> deleteResults, String resourceType) {
    List<DeleteResult> failedDeletes =
        deleteResults.stream().filter(r -> !r.success).collect(Collectors.toList());
    failedDeletes.forEach(
        r ->
            LOGGER.warn(
                String.format(
                    Locale.US, "Failed to delete %s %s/%s", resourceType, bucketName, r.name)));
    return !failedDeletes.isEmpty();
  }

  private static final class DeleteResult {
    private final String name;
    private final boolean success;

    DeleteResult(String name, boolean success) {
      this.name = name;
      this.success = success;
    }
  }
}
