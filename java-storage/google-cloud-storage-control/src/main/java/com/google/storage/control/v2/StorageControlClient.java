/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.storage.control.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.storage.control.v2.stub.StorageControlStub;
import com.google.storage.control.v2.stub.StorageControlStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: StorageControl service includes selected control plane operations.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
 *   BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");
 *   Folder folder = Folder.newBuilder().build();
 *   String folderId = "folderId294109737";
 *   Folder response = storageControlClient.createFolder(parent, folder, folderId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the StorageControlClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFolder</td>
 *      <td><p> Creates a new folder. This operation is only applicable to a hierarchical namespace enabled bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFolder(CreateFolderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createFolder(BucketName parent, Folder folder, String folderId)
 *           <li><p> createFolder(String parent, Folder folder, String folderId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFolderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFolder</td>
 *      <td><p> Permanently deletes an empty folder. This operation is only applicable to a hierarchical namespace enabled bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFolder(DeleteFolderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteFolder(FolderName name)
 *           <li><p> deleteFolder(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFolderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFolder</td>
 *      <td><p> Returns metadata for the specified folder. This operation is only applicable to a hierarchical namespace enabled bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFolder(GetFolderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFolder(FolderName name)
 *           <li><p> getFolder(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFolderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFolders</td>
 *      <td><p> Retrieves a list of folders. This operation is only applicable to a hierarchical namespace enabled bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFolders(ListFoldersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFolders(BucketName parent)
 *           <li><p> listFolders(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFoldersPagedCallable()
 *           <li><p> listFoldersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenameFolder</td>
 *      <td><p> Renames a source folder to a destination folder. This operation is only applicable to a hierarchical namespace enabled bucket. During a rename, the source and destination folders are locked until the long running operation completes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renameFolderAsync(RenameFolderRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> renameFolderAsync(FolderName name, String destinationFolderId)
 *           <li><p> renameFolderAsync(String name, String destinationFolderId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renameFolderOperationCallable()
 *           <li><p> renameFolderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFolderRecursive</td>
 *      <td><p> Deletes a folder recursively. This operation is only applicable to a hierarchical namespace enabled bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFolderRecursiveAsync(DeleteFolderRecursiveRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteFolderRecursiveAsync(FolderName name)
 *           <li><p> deleteFolderRecursiveAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFolderRecursiveOperationCallable()
 *           <li><p> deleteFolderRecursiveCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetStorageLayout</td>
 *      <td><p> Returns the storage layout configuration for a given bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getStorageLayout(GetStorageLayoutRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getStorageLayout(StorageLayoutName name)
 *           <li><p> getStorageLayout(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getStorageLayoutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateManagedFolder</td>
 *      <td><p> Creates a new managed folder.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createManagedFolder(CreateManagedFolderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createManagedFolder(BucketName parent, ManagedFolder managedFolder, String managedFolderId)
 *           <li><p> createManagedFolder(String parent, ManagedFolder managedFolder, String managedFolderId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createManagedFolderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteManagedFolder</td>
 *      <td><p> Permanently deletes an empty managed folder.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteManagedFolder(DeleteManagedFolderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteManagedFolder(ManagedFolderName name)
 *           <li><p> deleteManagedFolder(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteManagedFolderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetManagedFolder</td>
 *      <td><p> Returns metadata for the specified managed folder.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getManagedFolder(GetManagedFolderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getManagedFolder(ManagedFolderName name)
 *           <li><p> getManagedFolder(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getManagedFolderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListManagedFolders</td>
 *      <td><p> Retrieves a list of managed folders for a given bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listManagedFolders(ListManagedFoldersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listManagedFolders(BucketName parent)
 *           <li><p> listManagedFolders(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listManagedFoldersPagedCallable()
 *           <li><p> listManagedFoldersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAnywhereCache</td>
 *      <td><p> Creates an Anywhere Cache instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAnywhereCacheAsync(CreateAnywhereCacheRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAnywhereCacheAsync(BucketName parent, AnywhereCache anywhereCache)
 *           <li><p> createAnywhereCacheAsync(String parent, AnywhereCache anywhereCache)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAnywhereCacheOperationCallable()
 *           <li><p> createAnywhereCacheCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAnywhereCache</td>
 *      <td><p> Updates an Anywhere Cache instance. Mutable fields include `ttl` and `admission_policy`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAnywhereCacheAsync(UpdateAnywhereCacheRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAnywhereCacheAsync(AnywhereCache anywhereCache, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAnywhereCacheOperationCallable()
 *           <li><p> updateAnywhereCacheCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisableAnywhereCache</td>
 *      <td><p> Disables an Anywhere Cache instance. A disabled instance is read-only. The disablement could be revoked by calling ResumeAnywhereCache. The cache instance will be deleted automatically if it remains in the disabled state for at least one hour.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disableAnywhereCache(DisableAnywhereCacheRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> disableAnywhereCache(AnywhereCacheName name)
 *           <li><p> disableAnywhereCache(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disableAnywhereCacheCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PauseAnywhereCache</td>
 *      <td><p> Pauses an Anywhere Cache instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> pauseAnywhereCache(PauseAnywhereCacheRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> pauseAnywhereCache(AnywhereCacheName name)
 *           <li><p> pauseAnywhereCache(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> pauseAnywhereCacheCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResumeAnywhereCache</td>
 *      <td><p> Resumes a disabled or paused Anywhere Cache instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resumeAnywhereCache(ResumeAnywhereCacheRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> resumeAnywhereCache(AnywhereCacheName name)
 *           <li><p> resumeAnywhereCache(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resumeAnywhereCacheCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAnywhereCache</td>
 *      <td><p> Gets an Anywhere Cache instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAnywhereCache(GetAnywhereCacheRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAnywhereCache(AnywhereCacheName name)
 *           <li><p> getAnywhereCache(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAnywhereCacheCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAnywhereCaches</td>
 *      <td><p> Lists Anywhere Cache instances for a given bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAnywhereCaches(ListAnywhereCachesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAnywhereCaches(BucketName parent)
 *           <li><p> listAnywhereCaches(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAnywhereCachesPagedCallable()
 *           <li><p> listAnywhereCachesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetProjectIntelligenceConfig</td>
 *      <td><p> Returns the Project scoped singleton IntelligenceConfig resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProjectIntelligenceConfig(GetProjectIntelligenceConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProjectIntelligenceConfig(IntelligenceConfigName name)
 *           <li><p> getProjectIntelligenceConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProjectIntelligenceConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateProjectIntelligenceConfig</td>
 *      <td><p> Updates the Project scoped singleton IntelligenceConfig resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateProjectIntelligenceConfig(UpdateProjectIntelligenceConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateProjectIntelligenceConfig(IntelligenceConfig intelligenceConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateProjectIntelligenceConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFolderIntelligenceConfig</td>
 *      <td><p> Returns the Folder scoped singleton IntelligenceConfig resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFolderIntelligenceConfig(GetFolderIntelligenceConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFolderIntelligenceConfig(IntelligenceConfigName name)
 *           <li><p> getFolderIntelligenceConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFolderIntelligenceConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFolderIntelligenceConfig</td>
 *      <td><p> Updates the Folder scoped singleton IntelligenceConfig resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFolderIntelligenceConfig(UpdateFolderIntelligenceConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateFolderIntelligenceConfig(IntelligenceConfig intelligenceConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFolderIntelligenceConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetOrganizationIntelligenceConfig</td>
 *      <td><p> Returns the Organization scoped singleton IntelligenceConfig resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOrganizationIntelligenceConfig(GetOrganizationIntelligenceConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOrganizationIntelligenceConfig(IntelligenceConfigName name)
 *           <li><p> getOrganizationIntelligenceConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOrganizationIntelligenceConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateOrganizationIntelligenceConfig</td>
 *      <td><p> Updates the Organization scoped singleton IntelligenceConfig resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateOrganizationIntelligenceConfig(UpdateOrganizationIntelligenceConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateOrganizationIntelligenceConfig(IntelligenceConfig intelligenceConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateOrganizationIntelligenceConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the IAM policy for a specified bucket. The `resource` field in the request should be `projects/_/buckets/{bucket}` for a bucket, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(ResourceName resource)
 *           <li><p> getIamPolicy(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Updates an IAM policy for the specified bucket. The `resource` field in the request should be `projects/_/buckets/{bucket}` for a bucket, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(ResourceName resource, Policy policy)
 *           <li><p> setIamPolicy(String resource, Policy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Tests a set of permissions on the given bucket, object, or managed folder to see which, if any, are held by the caller. The `resource` field in the request should be `projects/_/buckets/{bucket}` for a bucket, `projects/_/buckets/{bucket}/objects/{object}` for an object, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testIamPermissions(ResourceName resource, List&lt;String&gt; permissions)
 *           <li><p> testIamPermissions(String resource, List&lt;String&gt; permissions)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of StorageControlSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageControlSettings storageControlSettings =
 *     StorageControlSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * StorageControlClient storageControlClient = StorageControlClient.create(storageControlSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageControlSettings storageControlSettings =
 *     StorageControlSettings.newBuilder().setEndpoint(myEndpoint).build();
 * StorageControlClient storageControlClient = StorageControlClient.create(storageControlSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageControlSettings storageControlSettings =
 *     StorageControlSettings.newHttpJsonBuilder().build();
 * StorageControlClient storageControlClient = StorageControlClient.create(storageControlSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class StorageControlClient implements BackgroundResource {
  private final StorageControlSettings settings;
  private final StorageControlStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of StorageControlClient with default settings. */
  public static final StorageControlClient create() throws IOException {
    return create(StorageControlSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of StorageControlClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final StorageControlClient create(StorageControlSettings settings)
      throws IOException {
    return new StorageControlClient(settings);
  }

  /**
   * Constructs an instance of StorageControlClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(StorageControlSettings).
   */
  public static final StorageControlClient create(StorageControlStub stub) {
    return new StorageControlClient(stub);
  }

  /**
   * Constructs an instance of StorageControlClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected StorageControlClient(StorageControlSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((StorageControlStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected StorageControlClient(StorageControlStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final StorageControlSettings getSettings() {
    return settings;
  }

  public StorageControlStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new folder. This operation is only applicable to a hierarchical namespace enabled
   * bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");
   *   Folder folder = Folder.newBuilder().build();
   *   String folderId = "folderId294109737";
   *   Folder response = storageControlClient.createFolder(parent, folder, folderId);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the bucket in which the folder will reside. The bucket must be
   *     a hierarchical namespace enabled bucket.
   * @param folder Required. Properties of the new folder being created. The bucket and name of the
   *     folder are specified in the parent and folder_id fields, respectively. Populating those
   *     fields in `folder` will result in an error.
   * @param folderId Required. The full name of a folder, including all its parent folders. Folders
   *     use single '/' characters as a delimiter. The folder_id must end with a slash. For example,
   *     the folder_id of "books/biographies/" would create a new "biographies/" folder under the
   *     "books/" folder.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder createFolder(BucketName parent, Folder folder, String folderId) {
    CreateFolderRequest request =
        CreateFolderRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFolder(folder)
            .setFolderId(folderId)
            .build();
    return createFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new folder. This operation is only applicable to a hierarchical namespace enabled
   * bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String parent = BucketName.of("[PROJECT]", "[BUCKET]").toString();
   *   Folder folder = Folder.newBuilder().build();
   *   String folderId = "folderId294109737";
   *   Folder response = storageControlClient.createFolder(parent, folder, folderId);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the bucket in which the folder will reside. The bucket must be
   *     a hierarchical namespace enabled bucket.
   * @param folder Required. Properties of the new folder being created. The bucket and name of the
   *     folder are specified in the parent and folder_id fields, respectively. Populating those
   *     fields in `folder` will result in an error.
   * @param folderId Required. The full name of a folder, including all its parent folders. Folders
   *     use single '/' characters as a delimiter. The folder_id must end with a slash. For example,
   *     the folder_id of "books/biographies/" would create a new "biographies/" folder under the
   *     "books/" folder.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder createFolder(String parent, Folder folder, String folderId) {
    CreateFolderRequest request =
        CreateFolderRequest.newBuilder()
            .setParent(parent)
            .setFolder(folder)
            .setFolderId(folderId)
            .build();
    return createFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new folder. This operation is only applicable to a hierarchical namespace enabled
   * bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   CreateFolderRequest request =
   *       CreateFolderRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setFolder(Folder.newBuilder().build())
   *           .setFolderId("folderId294109737")
   *           .setRecursive(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Folder response = storageControlClient.createFolder(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder createFolder(CreateFolderRequest request) {
    return createFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new folder. This operation is only applicable to a hierarchical namespace enabled
   * bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   CreateFolderRequest request =
   *       CreateFolderRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setFolder(Folder.newBuilder().build())
   *           .setFolderId("folderId294109737")
   *           .setRecursive(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Folder> future = storageControlClient.createFolderCallable().futureCall(request);
   *   // Do something.
   *   Folder response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFolderRequest, Folder> createFolderCallable() {
    return stub.createFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty folder. This operation is only applicable to a hierarchical
   * namespace enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");
   *   storageControlClient.deleteFolder(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the folder. Format:
   *     `projects/{project}/buckets/{bucket}/folders/{folder}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFolder(FolderName name) {
    DeleteFolderRequest request =
        DeleteFolderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty folder. This operation is only applicable to a hierarchical
   * namespace enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString();
   *   storageControlClient.deleteFolder(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the folder. Format:
   *     `projects/{project}/buckets/{bucket}/folders/{folder}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFolder(String name) {
    DeleteFolderRequest request = DeleteFolderRequest.newBuilder().setName(name).build();
    deleteFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty folder. This operation is only applicable to a hierarchical
   * namespace enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   DeleteFolderRequest request =
   *       DeleteFolderRequest.newBuilder()
   *           .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   storageControlClient.deleteFolder(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFolder(DeleteFolderRequest request) {
    deleteFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty folder. This operation is only applicable to a hierarchical
   * namespace enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   DeleteFolderRequest request =
   *       DeleteFolderRequest.newBuilder()
   *           .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = storageControlClient.deleteFolderCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFolderRequest, Empty> deleteFolderCallable() {
    return stub.deleteFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified folder. This operation is only applicable to a hierarchical
   * namespace enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");
   *   Folder response = storageControlClient.getFolder(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the folder. Format:
   *     `projects/{project}/buckets/{bucket}/folders/{folder}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder getFolder(FolderName name) {
    GetFolderRequest request =
        GetFolderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified folder. This operation is only applicable to a hierarchical
   * namespace enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString();
   *   Folder response = storageControlClient.getFolder(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the folder. Format:
   *     `projects/{project}/buckets/{bucket}/folders/{folder}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder getFolder(String name) {
    GetFolderRequest request = GetFolderRequest.newBuilder().setName(name).build();
    return getFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified folder. This operation is only applicable to a hierarchical
   * namespace enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetFolderRequest request =
   *       GetFolderRequest.newBuilder()
   *           .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Folder response = storageControlClient.getFolder(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder getFolder(GetFolderRequest request) {
    return getFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified folder. This operation is only applicable to a hierarchical
   * namespace enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetFolderRequest request =
   *       GetFolderRequest.newBuilder()
   *           .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Folder> future = storageControlClient.getFolderCallable().futureCall(request);
   *   // Do something.
   *   Folder response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFolderRequest, Folder> getFolderCallable() {
    return stub.getFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of folders. This operation is only applicable to a hierarchical namespace
   * enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");
   *   for (Folder element : storageControlClient.listFolders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the bucket in which to look for folders. The bucket must be a
   *     hierarchical namespace enabled bucket.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFoldersPagedResponse listFolders(BucketName parent) {
    ListFoldersRequest request =
        ListFoldersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of folders. This operation is only applicable to a hierarchical namespace
   * enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String parent = BucketName.of("[PROJECT]", "[BUCKET]").toString();
   *   for (Folder element : storageControlClient.listFolders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the bucket in which to look for folders. The bucket must be a
   *     hierarchical namespace enabled bucket.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFoldersPagedResponse listFolders(String parent) {
    ListFoldersRequest request = ListFoldersRequest.newBuilder().setParent(parent).build();
    return listFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of folders. This operation is only applicable to a hierarchical namespace
   * enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ListFoldersRequest request =
   *       ListFoldersRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setPrefix("prefix-980110702")
   *           .setDelimiter("delimiter-250518009")
   *           .setLexicographicStart("lexicographicStart-2093413008")
   *           .setLexicographicEnd("lexicographicEnd1646968169")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   for (Folder element : storageControlClient.listFolders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFoldersPagedResponse listFolders(ListFoldersRequest request) {
    return listFoldersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of folders. This operation is only applicable to a hierarchical namespace
   * enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ListFoldersRequest request =
   *       ListFoldersRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setPrefix("prefix-980110702")
   *           .setDelimiter("delimiter-250518009")
   *           .setLexicographicStart("lexicographicStart-2093413008")
   *           .setLexicographicEnd("lexicographicEnd1646968169")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Folder> future =
   *       storageControlClient.listFoldersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Folder element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse>
      listFoldersPagedCallable() {
    return stub.listFoldersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of folders. This operation is only applicable to a hierarchical namespace
   * enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ListFoldersRequest request =
   *       ListFoldersRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setPrefix("prefix-980110702")
   *           .setDelimiter("delimiter-250518009")
   *           .setLexicographicStart("lexicographicStart-2093413008")
   *           .setLexicographicEnd("lexicographicEnd1646968169")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   while (true) {
   *     ListFoldersResponse response = storageControlClient.listFoldersCallable().call(request);
   *     for (Folder element : response.getFoldersList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable() {
    return stub.listFoldersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a source folder to a destination folder. This operation is only applicable to a
   * hierarchical namespace enabled bucket. During a rename, the source and destination folders are
   * locked until the long running operation completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");
   *   String destinationFolderId = "destinationFolderId-480084905";
   *   Folder response = storageControlClient.renameFolderAsync(name, destinationFolderId).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the source folder being renamed. Format:
   *     `projects/{project}/buckets/{bucket}/folders/{folder}`
   * @param destinationFolderId Required. The destination folder ID, e.g. `foo/bar/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, RenameFolderMetadata> renameFolderAsync(
      FolderName name, String destinationFolderId) {
    RenameFolderRequest request =
        RenameFolderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationFolderId(destinationFolderId)
            .build();
    return renameFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a source folder to a destination folder. This operation is only applicable to a
   * hierarchical namespace enabled bucket. During a rename, the source and destination folders are
   * locked until the long running operation completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString();
   *   String destinationFolderId = "destinationFolderId-480084905";
   *   Folder response = storageControlClient.renameFolderAsync(name, destinationFolderId).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the source folder being renamed. Format:
   *     `projects/{project}/buckets/{bucket}/folders/{folder}`
   * @param destinationFolderId Required. The destination folder ID, e.g. `foo/bar/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, RenameFolderMetadata> renameFolderAsync(
      String name, String destinationFolderId) {
    RenameFolderRequest request =
        RenameFolderRequest.newBuilder()
            .setName(name)
            .setDestinationFolderId(destinationFolderId)
            .build();
    return renameFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a source folder to a destination folder. This operation is only applicable to a
   * hierarchical namespace enabled bucket. During a rename, the source and destination folders are
   * locked until the long running operation completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   RenameFolderRequest request =
   *       RenameFolderRequest.newBuilder()
   *           .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
   *           .setDestinationFolderId("destinationFolderId-480084905")
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Folder response = storageControlClient.renameFolderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, RenameFolderMetadata> renameFolderAsync(
      RenameFolderRequest request) {
    return renameFolderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a source folder to a destination folder. This operation is only applicable to a
   * hierarchical namespace enabled bucket. During a rename, the source and destination folders are
   * locked until the long running operation completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   RenameFolderRequest request =
   *       RenameFolderRequest.newBuilder()
   *           .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
   *           .setDestinationFolderId("destinationFolderId-480084905")
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Folder, RenameFolderMetadata> future =
   *       storageControlClient.renameFolderOperationCallable().futureCall(request);
   *   // Do something.
   *   Folder response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RenameFolderRequest, Folder, RenameFolderMetadata>
      renameFolderOperationCallable() {
    return stub.renameFolderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a source folder to a destination folder. This operation is only applicable to a
   * hierarchical namespace enabled bucket. During a rename, the source and destination folders are
   * locked until the long running operation completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   RenameFolderRequest request =
   *       RenameFolderRequest.newBuilder()
   *           .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
   *           .setDestinationFolderId("destinationFolderId-480084905")
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = storageControlClient.renameFolderCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenameFolderRequest, Operation> renameFolderCallable() {
    return stub.renameFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a folder recursively. This operation is only applicable to a hierarchical namespace
   * enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");
   *   storageControlClient.deleteFolderRecursiveAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the folder being deleted, however all of its contents will be
   *     deleted too. Format: `projects/{project}/buckets/{bucket}/folders/{folder}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteFolderRecursiveMetadata> deleteFolderRecursiveAsync(
      FolderName name) {
    DeleteFolderRecursiveRequest request =
        DeleteFolderRecursiveRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteFolderRecursiveAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a folder recursively. This operation is only applicable to a hierarchical namespace
   * enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString();
   *   storageControlClient.deleteFolderRecursiveAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the folder being deleted, however all of its contents will be
   *     deleted too. Format: `projects/{project}/buckets/{bucket}/folders/{folder}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteFolderRecursiveMetadata> deleteFolderRecursiveAsync(
      String name) {
    DeleteFolderRecursiveRequest request =
        DeleteFolderRecursiveRequest.newBuilder().setName(name).build();
    return deleteFolderRecursiveAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a folder recursively. This operation is only applicable to a hierarchical namespace
   * enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   DeleteFolderRecursiveRequest request =
   *       DeleteFolderRecursiveRequest.newBuilder()
   *           .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   storageControlClient.deleteFolderRecursiveAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteFolderRecursiveMetadata> deleteFolderRecursiveAsync(
      DeleteFolderRecursiveRequest request) {
    return deleteFolderRecursiveOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a folder recursively. This operation is only applicable to a hierarchical namespace
   * enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   DeleteFolderRecursiveRequest request =
   *       DeleteFolderRecursiveRequest.newBuilder()
   *           .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, DeleteFolderRecursiveMetadata> future =
   *       storageControlClient.deleteFolderRecursiveOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFolderRecursiveRequest, Empty, DeleteFolderRecursiveMetadata>
      deleteFolderRecursiveOperationCallable() {
    return stub.deleteFolderRecursiveOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a folder recursively. This operation is only applicable to a hierarchical namespace
   * enabled bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   DeleteFolderRecursiveRequest request =
   *       DeleteFolderRecursiveRequest.newBuilder()
   *           .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       storageControlClient.deleteFolderRecursiveCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFolderRecursiveRequest, Operation>
      deleteFolderRecursiveCallable() {
    return stub.deleteFolderRecursiveCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the storage layout configuration for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   StorageLayoutName name = StorageLayoutName.of("[PROJECT]", "[BUCKET]");
   *   StorageLayout response = storageControlClient.getStorageLayout(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the StorageLayout resource. Format:
   *     `projects/{project}/buckets/{bucket}/storageLayout`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StorageLayout getStorageLayout(StorageLayoutName name) {
    GetStorageLayoutRequest request =
        GetStorageLayoutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getStorageLayout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the storage layout configuration for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name = StorageLayoutName.of("[PROJECT]", "[BUCKET]").toString();
   *   StorageLayout response = storageControlClient.getStorageLayout(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the StorageLayout resource. Format:
   *     `projects/{project}/buckets/{bucket}/storageLayout`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StorageLayout getStorageLayout(String name) {
    GetStorageLayoutRequest request = GetStorageLayoutRequest.newBuilder().setName(name).build();
    return getStorageLayout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the storage layout configuration for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetStorageLayoutRequest request =
   *       GetStorageLayoutRequest.newBuilder()
   *           .setName(StorageLayoutName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPrefix("prefix-980110702")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   StorageLayout response = storageControlClient.getStorageLayout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StorageLayout getStorageLayout(GetStorageLayoutRequest request) {
    return getStorageLayoutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the storage layout configuration for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetStorageLayoutRequest request =
   *       GetStorageLayoutRequest.newBuilder()
   *           .setName(StorageLayoutName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPrefix("prefix-980110702")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<StorageLayout> future =
   *       storageControlClient.getStorageLayoutCallable().futureCall(request);
   *   // Do something.
   *   StorageLayout response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStorageLayoutRequest, StorageLayout> getStorageLayoutCallable() {
    return stub.getStorageLayoutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");
   *   ManagedFolder managedFolder = ManagedFolder.newBuilder().build();
   *   String managedFolderId = "managedFolderId-2027084056";
   *   ManagedFolder response =
   *       storageControlClient.createManagedFolder(parent, managedFolder, managedFolderId);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the bucket this managed folder belongs to.
   * @param managedFolder Required. Properties of the managed folder being created. The bucket and
   *     managed folder names are specified in the `parent` and `managed_folder_id` fields.
   *     Populating these fields in `managed_folder` will result in an error.
   * @param managedFolderId Required. The name of the managed folder. It uses a single `/` as
   *     delimiter and leading and trailing `/` are allowed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagedFolder createManagedFolder(
      BucketName parent, ManagedFolder managedFolder, String managedFolderId) {
    CreateManagedFolderRequest request =
        CreateManagedFolderRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setManagedFolder(managedFolder)
            .setManagedFolderId(managedFolderId)
            .build();
    return createManagedFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String parent = BucketName.of("[PROJECT]", "[BUCKET]").toString();
   *   ManagedFolder managedFolder = ManagedFolder.newBuilder().build();
   *   String managedFolderId = "managedFolderId-2027084056";
   *   ManagedFolder response =
   *       storageControlClient.createManagedFolder(parent, managedFolder, managedFolderId);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the bucket this managed folder belongs to.
   * @param managedFolder Required. Properties of the managed folder being created. The bucket and
   *     managed folder names are specified in the `parent` and `managed_folder_id` fields.
   *     Populating these fields in `managed_folder` will result in an error.
   * @param managedFolderId Required. The name of the managed folder. It uses a single `/` as
   *     delimiter and leading and trailing `/` are allowed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagedFolder createManagedFolder(
      String parent, ManagedFolder managedFolder, String managedFolderId) {
    CreateManagedFolderRequest request =
        CreateManagedFolderRequest.newBuilder()
            .setParent(parent)
            .setManagedFolder(managedFolder)
            .setManagedFolderId(managedFolderId)
            .build();
    return createManagedFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   CreateManagedFolderRequest request =
   *       CreateManagedFolderRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setManagedFolder(ManagedFolder.newBuilder().build())
   *           .setManagedFolderId("managedFolderId-2027084056")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ManagedFolder response = storageControlClient.createManagedFolder(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagedFolder createManagedFolder(CreateManagedFolderRequest request) {
    return createManagedFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   CreateManagedFolderRequest request =
   *       CreateManagedFolderRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setManagedFolder(ManagedFolder.newBuilder().build())
   *           .setManagedFolderId("managedFolderId-2027084056")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<ManagedFolder> future =
   *       storageControlClient.createManagedFolderCallable().futureCall(request);
   *   // Do something.
   *   ManagedFolder response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateManagedFolderRequest, ManagedFolder>
      createManagedFolderCallable() {
    return stub.createManagedFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ManagedFolderName name = ManagedFolderName.of("[PROJECT]", "[BUCKET]", "[MANAGED_FOLDER]");
   *   storageControlClient.deleteManagedFolder(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the managed folder. Format:
   *     `projects/{project}/buckets/{bucket}/managedFolders/{managedFolder}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteManagedFolder(ManagedFolderName name) {
    DeleteManagedFolderRequest request =
        DeleteManagedFolderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteManagedFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name = ManagedFolderName.of("[PROJECT]", "[BUCKET]", "[MANAGED_FOLDER]").toString();
   *   storageControlClient.deleteManagedFolder(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the managed folder. Format:
   *     `projects/{project}/buckets/{bucket}/managedFolders/{managedFolder}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteManagedFolder(String name) {
    DeleteManagedFolderRequest request =
        DeleteManagedFolderRequest.newBuilder().setName(name).build();
    deleteManagedFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   DeleteManagedFolderRequest request =
   *       DeleteManagedFolderRequest.newBuilder()
   *           .setName(ManagedFolderName.of("[PROJECT]", "[BUCKET]", "[MANAGED_FOLDER]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setAllowNonEmpty(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   storageControlClient.deleteManagedFolder(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteManagedFolder(DeleteManagedFolderRequest request) {
    deleteManagedFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   DeleteManagedFolderRequest request =
   *       DeleteManagedFolderRequest.newBuilder()
   *           .setName(ManagedFolderName.of("[PROJECT]", "[BUCKET]", "[MANAGED_FOLDER]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setAllowNonEmpty(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future =
   *       storageControlClient.deleteManagedFolderCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteManagedFolderRequest, Empty> deleteManagedFolderCallable() {
    return stub.deleteManagedFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ManagedFolderName name = ManagedFolderName.of("[PROJECT]", "[BUCKET]", "[MANAGED_FOLDER]");
   *   ManagedFolder response = storageControlClient.getManagedFolder(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the managed folder. Format:
   *     `projects/{project}/buckets/{bucket}/managedFolders/{managedFolder}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagedFolder getManagedFolder(ManagedFolderName name) {
    GetManagedFolderRequest request =
        GetManagedFolderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getManagedFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name = ManagedFolderName.of("[PROJECT]", "[BUCKET]", "[MANAGED_FOLDER]").toString();
   *   ManagedFolder response = storageControlClient.getManagedFolder(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the managed folder. Format:
   *     `projects/{project}/buckets/{bucket}/managedFolders/{managedFolder}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagedFolder getManagedFolder(String name) {
    GetManagedFolderRequest request = GetManagedFolderRequest.newBuilder().setName(name).build();
    return getManagedFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetManagedFolderRequest request =
   *       GetManagedFolderRequest.newBuilder()
   *           .setName(ManagedFolderName.of("[PROJECT]", "[BUCKET]", "[MANAGED_FOLDER]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ManagedFolder response = storageControlClient.getManagedFolder(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagedFolder getManagedFolder(GetManagedFolderRequest request) {
    return getManagedFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetManagedFolderRequest request =
   *       GetManagedFolderRequest.newBuilder()
   *           .setName(ManagedFolderName.of("[PROJECT]", "[BUCKET]", "[MANAGED_FOLDER]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<ManagedFolder> future =
   *       storageControlClient.getManagedFolderCallable().futureCall(request);
   *   // Do something.
   *   ManagedFolder response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetManagedFolderRequest, ManagedFolder> getManagedFolderCallable() {
    return stub.getManagedFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of managed folders for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");
   *   for (ManagedFolder element : storageControlClient.listManagedFolders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the bucket this managed folder belongs to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagedFoldersPagedResponse listManagedFolders(BucketName parent) {
    ListManagedFoldersRequest request =
        ListManagedFoldersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listManagedFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of managed folders for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String parent = BucketName.of("[PROJECT]", "[BUCKET]").toString();
   *   for (ManagedFolder element : storageControlClient.listManagedFolders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the bucket this managed folder belongs to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagedFoldersPagedResponse listManagedFolders(String parent) {
    ListManagedFoldersRequest request =
        ListManagedFoldersRequest.newBuilder().setParent(parent).build();
    return listManagedFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of managed folders for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ListManagedFoldersRequest request =
   *       ListManagedFoldersRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setPrefix("prefix-980110702")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   for (ManagedFolder element : storageControlClient.listManagedFolders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagedFoldersPagedResponse listManagedFolders(
      ListManagedFoldersRequest request) {
    return listManagedFoldersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of managed folders for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ListManagedFoldersRequest request =
   *       ListManagedFoldersRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setPrefix("prefix-980110702")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<ManagedFolder> future =
   *       storageControlClient.listManagedFoldersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ManagedFolder element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListManagedFoldersRequest, ListManagedFoldersPagedResponse>
      listManagedFoldersPagedCallable() {
    return stub.listManagedFoldersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of managed folders for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ListManagedFoldersRequest request =
   *       ListManagedFoldersRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setPrefix("prefix-980110702")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   while (true) {
   *     ListManagedFoldersResponse response =
   *         storageControlClient.listManagedFoldersCallable().call(request);
   *     for (ManagedFolder element : response.getManagedFoldersList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListManagedFoldersRequest, ListManagedFoldersResponse>
      listManagedFoldersCallable() {
    return stub.listManagedFoldersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");
   *   AnywhereCache anywhereCache = AnywhereCache.newBuilder().build();
   *   AnywhereCache response =
   *       storageControlClient.createAnywhereCacheAsync(parent, anywhereCache).get();
   * }
   * }</pre>
   *
   * @param parent Required. The bucket to which this cache belongs. Format:
   *     `projects/{project}/buckets/{bucket}`
   * @param anywhereCache Required. Properties of the Anywhere Cache instance being created. The
   *     parent bucket name is specified in the `parent` field. Server uses the default value of
   *     `ttl` or `admission_policy` if not specified in request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnywhereCache, CreateAnywhereCacheMetadata> createAnywhereCacheAsync(
      BucketName parent, AnywhereCache anywhereCache) {
    CreateAnywhereCacheRequest request =
        CreateAnywhereCacheRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAnywhereCache(anywhereCache)
            .build();
    return createAnywhereCacheAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String parent = BucketName.of("[PROJECT]", "[BUCKET]").toString();
   *   AnywhereCache anywhereCache = AnywhereCache.newBuilder().build();
   *   AnywhereCache response =
   *       storageControlClient.createAnywhereCacheAsync(parent, anywhereCache).get();
   * }
   * }</pre>
   *
   * @param parent Required. The bucket to which this cache belongs. Format:
   *     `projects/{project}/buckets/{bucket}`
   * @param anywhereCache Required. Properties of the Anywhere Cache instance being created. The
   *     parent bucket name is specified in the `parent` field. Server uses the default value of
   *     `ttl` or `admission_policy` if not specified in request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnywhereCache, CreateAnywhereCacheMetadata> createAnywhereCacheAsync(
      String parent, AnywhereCache anywhereCache) {
    CreateAnywhereCacheRequest request =
        CreateAnywhereCacheRequest.newBuilder()
            .setParent(parent)
            .setAnywhereCache(anywhereCache)
            .build();
    return createAnywhereCacheAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   CreateAnywhereCacheRequest request =
   *       CreateAnywhereCacheRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setAnywhereCache(AnywhereCache.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AnywhereCache response = storageControlClient.createAnywhereCacheAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnywhereCache, CreateAnywhereCacheMetadata> createAnywhereCacheAsync(
      CreateAnywhereCacheRequest request) {
    return createAnywhereCacheOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   CreateAnywhereCacheRequest request =
   *       CreateAnywhereCacheRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setAnywhereCache(AnywhereCache.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AnywhereCache, CreateAnywhereCacheMetadata> future =
   *       storageControlClient.createAnywhereCacheOperationCallable().futureCall(request);
   *   // Do something.
   *   AnywhereCache response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateAnywhereCacheRequest, AnywhereCache, CreateAnywhereCacheMetadata>
      createAnywhereCacheOperationCallable() {
    return stub.createAnywhereCacheOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   CreateAnywhereCacheRequest request =
   *       CreateAnywhereCacheRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setAnywhereCache(AnywhereCache.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       storageControlClient.createAnywhereCacheCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAnywhereCacheRequest, Operation> createAnywhereCacheCallable() {
    return stub.createAnywhereCacheCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Anywhere Cache instance. Mutable fields include `ttl` and `admission_policy`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   AnywhereCache anywhereCache = AnywhereCache.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AnywhereCache response =
   *       storageControlClient.updateAnywhereCacheAsync(anywhereCache, updateMask).get();
   * }
   * }</pre>
   *
   * @param anywhereCache Required. The Anywhere Cache instance to be updated.
   * @param updateMask Required. List of fields to be updated. Mutable fields of AnywhereCache
   *     include `ttl` and `admission_policy`.
   *     <p>To specify ALL fields, specify a single field with the value `&#42;`. Note: We recommend
   *     against doing this. If a new field is introduced at a later time, an older client updating
   *     with the `&#42;` may accidentally reset the new field's value.
   *     <p>Not specifying any fields is an error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnywhereCache, UpdateAnywhereCacheMetadata> updateAnywhereCacheAsync(
      AnywhereCache anywhereCache, FieldMask updateMask) {
    UpdateAnywhereCacheRequest request =
        UpdateAnywhereCacheRequest.newBuilder()
            .setAnywhereCache(anywhereCache)
            .setUpdateMask(updateMask)
            .build();
    return updateAnywhereCacheAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Anywhere Cache instance. Mutable fields include `ttl` and `admission_policy`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   UpdateAnywhereCacheRequest request =
   *       UpdateAnywhereCacheRequest.newBuilder()
   *           .setAnywhereCache(AnywhereCache.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AnywhereCache response = storageControlClient.updateAnywhereCacheAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnywhereCache, UpdateAnywhereCacheMetadata> updateAnywhereCacheAsync(
      UpdateAnywhereCacheRequest request) {
    return updateAnywhereCacheOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Anywhere Cache instance. Mutable fields include `ttl` and `admission_policy`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   UpdateAnywhereCacheRequest request =
   *       UpdateAnywhereCacheRequest.newBuilder()
   *           .setAnywhereCache(AnywhereCache.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AnywhereCache, UpdateAnywhereCacheMetadata> future =
   *       storageControlClient.updateAnywhereCacheOperationCallable().futureCall(request);
   *   // Do something.
   *   AnywhereCache response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateAnywhereCacheRequest, AnywhereCache, UpdateAnywhereCacheMetadata>
      updateAnywhereCacheOperationCallable() {
    return stub.updateAnywhereCacheOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Anywhere Cache instance. Mutable fields include `ttl` and `admission_policy`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   UpdateAnywhereCacheRequest request =
   *       UpdateAnywhereCacheRequest.newBuilder()
   *           .setAnywhereCache(AnywhereCache.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       storageControlClient.updateAnywhereCacheCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAnywhereCacheRequest, Operation> updateAnywhereCacheCallable() {
    return stub.updateAnywhereCacheCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables an Anywhere Cache instance. A disabled instance is read-only. The disablement could be
   * revoked by calling ResumeAnywhereCache. The cache instance will be deleted automatically if it
   * remains in the disabled state for at least one hour.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   AnywhereCacheName name = AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]");
   *   AnywhereCache response = storageControlClient.disableAnywhereCache(name);
   * }
   * }</pre>
   *
   * @param name Required. The name field in the request should be:
   *     `projects/{project}/buckets/{bucket}/anywhereCaches/{anywhere_cache}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache disableAnywhereCache(AnywhereCacheName name) {
    DisableAnywhereCacheRequest request =
        DisableAnywhereCacheRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return disableAnywhereCache(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables an Anywhere Cache instance. A disabled instance is read-only. The disablement could be
   * revoked by calling ResumeAnywhereCache. The cache instance will be deleted automatically if it
   * remains in the disabled state for at least one hour.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name = AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString();
   *   AnywhereCache response = storageControlClient.disableAnywhereCache(name);
   * }
   * }</pre>
   *
   * @param name Required. The name field in the request should be:
   *     `projects/{project}/buckets/{bucket}/anywhereCaches/{anywhere_cache}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache disableAnywhereCache(String name) {
    DisableAnywhereCacheRequest request =
        DisableAnywhereCacheRequest.newBuilder().setName(name).build();
    return disableAnywhereCache(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables an Anywhere Cache instance. A disabled instance is read-only. The disablement could be
   * revoked by calling ResumeAnywhereCache. The cache instance will be deleted automatically if it
   * remains in the disabled state for at least one hour.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   DisableAnywhereCacheRequest request =
   *       DisableAnywhereCacheRequest.newBuilder()
   *           .setName(AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AnywhereCache response = storageControlClient.disableAnywhereCache(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache disableAnywhereCache(DisableAnywhereCacheRequest request) {
    return disableAnywhereCacheCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables an Anywhere Cache instance. A disabled instance is read-only. The disablement could be
   * revoked by calling ResumeAnywhereCache. The cache instance will be deleted automatically if it
   * remains in the disabled state for at least one hour.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   DisableAnywhereCacheRequest request =
   *       DisableAnywhereCacheRequest.newBuilder()
   *           .setName(AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<AnywhereCache> future =
   *       storageControlClient.disableAnywhereCacheCallable().futureCall(request);
   *   // Do something.
   *   AnywhereCache response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableAnywhereCacheRequest, AnywhereCache>
      disableAnywhereCacheCallable() {
    return stub.disableAnywhereCacheCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   AnywhereCacheName name = AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]");
   *   AnywhereCache response = storageControlClient.pauseAnywhereCache(name);
   * }
   * }</pre>
   *
   * @param name Required. The name field in the request should be:
   *     `projects/{project}/buckets/{bucket}/anywhereCaches/{anywhere_cache}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache pauseAnywhereCache(AnywhereCacheName name) {
    PauseAnywhereCacheRequest request =
        PauseAnywhereCacheRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return pauseAnywhereCache(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name = AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString();
   *   AnywhereCache response = storageControlClient.pauseAnywhereCache(name);
   * }
   * }</pre>
   *
   * @param name Required. The name field in the request should be:
   *     `projects/{project}/buckets/{bucket}/anywhereCaches/{anywhere_cache}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache pauseAnywhereCache(String name) {
    PauseAnywhereCacheRequest request =
        PauseAnywhereCacheRequest.newBuilder().setName(name).build();
    return pauseAnywhereCache(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   PauseAnywhereCacheRequest request =
   *       PauseAnywhereCacheRequest.newBuilder()
   *           .setName(AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AnywhereCache response = storageControlClient.pauseAnywhereCache(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache pauseAnywhereCache(PauseAnywhereCacheRequest request) {
    return pauseAnywhereCacheCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   PauseAnywhereCacheRequest request =
   *       PauseAnywhereCacheRequest.newBuilder()
   *           .setName(AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<AnywhereCache> future =
   *       storageControlClient.pauseAnywhereCacheCallable().futureCall(request);
   *   // Do something.
   *   AnywhereCache response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PauseAnywhereCacheRequest, AnywhereCache>
      pauseAnywhereCacheCallable() {
    return stub.pauseAnywhereCacheCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a disabled or paused Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   AnywhereCacheName name = AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]");
   *   AnywhereCache response = storageControlClient.resumeAnywhereCache(name);
   * }
   * }</pre>
   *
   * @param name Required. The name field in the request should be:
   *     `projects/{project}/buckets/{bucket}/anywhereCaches/{anywhere_cache}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache resumeAnywhereCache(AnywhereCacheName name) {
    ResumeAnywhereCacheRequest request =
        ResumeAnywhereCacheRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return resumeAnywhereCache(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a disabled or paused Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name = AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString();
   *   AnywhereCache response = storageControlClient.resumeAnywhereCache(name);
   * }
   * }</pre>
   *
   * @param name Required. The name field in the request should be:
   *     `projects/{project}/buckets/{bucket}/anywhereCaches/{anywhere_cache}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache resumeAnywhereCache(String name) {
    ResumeAnywhereCacheRequest request =
        ResumeAnywhereCacheRequest.newBuilder().setName(name).build();
    return resumeAnywhereCache(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a disabled or paused Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ResumeAnywhereCacheRequest request =
   *       ResumeAnywhereCacheRequest.newBuilder()
   *           .setName(AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AnywhereCache response = storageControlClient.resumeAnywhereCache(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache resumeAnywhereCache(ResumeAnywhereCacheRequest request) {
    return resumeAnywhereCacheCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a disabled or paused Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ResumeAnywhereCacheRequest request =
   *       ResumeAnywhereCacheRequest.newBuilder()
   *           .setName(AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<AnywhereCache> future =
   *       storageControlClient.resumeAnywhereCacheCallable().futureCall(request);
   *   // Do something.
   *   AnywhereCache response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResumeAnywhereCacheRequest, AnywhereCache>
      resumeAnywhereCacheCallable() {
    return stub.resumeAnywhereCacheCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   AnywhereCacheName name = AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]");
   *   AnywhereCache response = storageControlClient.getAnywhereCache(name);
   * }
   * }</pre>
   *
   * @param name Required. The name field in the request should be:
   *     `projects/{project}/buckets/{bucket}/anywhereCaches/{anywhere_cache}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache getAnywhereCache(AnywhereCacheName name) {
    GetAnywhereCacheRequest request =
        GetAnywhereCacheRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAnywhereCache(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name = AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString();
   *   AnywhereCache response = storageControlClient.getAnywhereCache(name);
   * }
   * }</pre>
   *
   * @param name Required. The name field in the request should be:
   *     `projects/{project}/buckets/{bucket}/anywhereCaches/{anywhere_cache}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache getAnywhereCache(String name) {
    GetAnywhereCacheRequest request = GetAnywhereCacheRequest.newBuilder().setName(name).build();
    return getAnywhereCache(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetAnywhereCacheRequest request =
   *       GetAnywhereCacheRequest.newBuilder()
   *           .setName(AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AnywhereCache response = storageControlClient.getAnywhereCache(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnywhereCache getAnywhereCache(GetAnywhereCacheRequest request) {
    return getAnywhereCacheCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Anywhere Cache instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetAnywhereCacheRequest request =
   *       GetAnywhereCacheRequest.newBuilder()
   *           .setName(AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<AnywhereCache> future =
   *       storageControlClient.getAnywhereCacheCallable().futureCall(request);
   *   // Do something.
   *   AnywhereCache response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAnywhereCacheRequest, AnywhereCache> getAnywhereCacheCallable() {
    return stub.getAnywhereCacheCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Anywhere Cache instances for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");
   *   for (AnywhereCache element : storageControlClient.listAnywhereCaches(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The bucket to which this cache belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnywhereCachesPagedResponse listAnywhereCaches(BucketName parent) {
    ListAnywhereCachesRequest request =
        ListAnywhereCachesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnywhereCaches(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Anywhere Cache instances for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String parent = BucketName.of("[PROJECT]", "[BUCKET]").toString();
   *   for (AnywhereCache element : storageControlClient.listAnywhereCaches(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The bucket to which this cache belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnywhereCachesPagedResponse listAnywhereCaches(String parent) {
    ListAnywhereCachesRequest request =
        ListAnywhereCachesRequest.newBuilder().setParent(parent).build();
    return listAnywhereCaches(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Anywhere Cache instances for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ListAnywhereCachesRequest request =
   *       ListAnywhereCachesRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   for (AnywhereCache element : storageControlClient.listAnywhereCaches(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnywhereCachesPagedResponse listAnywhereCaches(
      ListAnywhereCachesRequest request) {
    return listAnywhereCachesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Anywhere Cache instances for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ListAnywhereCachesRequest request =
   *       ListAnywhereCachesRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<AnywhereCache> future =
   *       storageControlClient.listAnywhereCachesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AnywhereCache element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAnywhereCachesRequest, ListAnywhereCachesPagedResponse>
      listAnywhereCachesPagedCallable() {
    return stub.listAnywhereCachesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Anywhere Cache instances for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ListAnywhereCachesRequest request =
   *       ListAnywhereCachesRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   while (true) {
   *     ListAnywhereCachesResponse response =
   *         storageControlClient.listAnywhereCachesCallable().call(request);
   *     for (AnywhereCache element : response.getAnywhereCachesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAnywhereCachesRequest, ListAnywhereCachesResponse>
      listAnywhereCachesCallable() {
    return stub.listAnywhereCachesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Project scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   IntelligenceConfigName name =
   *       IntelligenceConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
   *   IntelligenceConfig response = storageControlClient.getProjectIntelligenceConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `IntelligenceConfig` resource associated with your
   *     project.
   *     <p>Format: `projects/{id}/locations/global/intelligenceConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig getProjectIntelligenceConfig(IntelligenceConfigName name) {
    GetProjectIntelligenceConfigRequest request =
        GetProjectIntelligenceConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getProjectIntelligenceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Project scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name =
   *       IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]").toString();
   *   IntelligenceConfig response = storageControlClient.getProjectIntelligenceConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `IntelligenceConfig` resource associated with your
   *     project.
   *     <p>Format: `projects/{id}/locations/global/intelligenceConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig getProjectIntelligenceConfig(String name) {
    GetProjectIntelligenceConfigRequest request =
        GetProjectIntelligenceConfigRequest.newBuilder().setName(name).build();
    return getProjectIntelligenceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Project scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetProjectIntelligenceConfigRequest request =
   *       GetProjectIntelligenceConfigRequest.newBuilder()
   *           .setName(
   *               IntelligenceConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]")
   *                   .toString())
   *           .build();
   *   IntelligenceConfig response = storageControlClient.getProjectIntelligenceConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig getProjectIntelligenceConfig(
      GetProjectIntelligenceConfigRequest request) {
    return getProjectIntelligenceConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Project scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetProjectIntelligenceConfigRequest request =
   *       GetProjectIntelligenceConfigRequest.newBuilder()
   *           .setName(
   *               IntelligenceConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<IntelligenceConfig> future =
   *       storageControlClient.getProjectIntelligenceConfigCallable().futureCall(request);
   *   // Do something.
   *   IntelligenceConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigCallable() {
    return stub.getProjectIntelligenceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Project scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   IntelligenceConfig intelligenceConfig = IntelligenceConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   IntelligenceConfig response =
   *       storageControlClient.updateProjectIntelligenceConfig(intelligenceConfig, updateMask);
   * }
   * }</pre>
   *
   * @param intelligenceConfig Required. The `IntelligenceConfig` resource to be updated.
   * @param updateMask Required. The `update_mask` that specifies the fields within the
   *     `IntelligenceConfig` resource that should be modified by this update. Only the listed
   *     fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig updateProjectIntelligenceConfig(
      IntelligenceConfig intelligenceConfig, FieldMask updateMask) {
    UpdateProjectIntelligenceConfigRequest request =
        UpdateProjectIntelligenceConfigRequest.newBuilder()
            .setIntelligenceConfig(intelligenceConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateProjectIntelligenceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Project scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   UpdateProjectIntelligenceConfigRequest request =
   *       UpdateProjectIntelligenceConfigRequest.newBuilder()
   *           .setIntelligenceConfig(IntelligenceConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   IntelligenceConfig response = storageControlClient.updateProjectIntelligenceConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig updateProjectIntelligenceConfig(
      UpdateProjectIntelligenceConfigRequest request) {
    return updateProjectIntelligenceConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Project scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   UpdateProjectIntelligenceConfigRequest request =
   *       UpdateProjectIntelligenceConfigRequest.newBuilder()
   *           .setIntelligenceConfig(IntelligenceConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<IntelligenceConfig> future =
   *       storageControlClient.updateProjectIntelligenceConfigCallable().futureCall(request);
   *   // Do something.
   *   IntelligenceConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigCallable() {
    return stub.updateProjectIntelligenceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Folder scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   IntelligenceConfigName name =
   *       IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]");
   *   IntelligenceConfig response = storageControlClient.getFolderIntelligenceConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `IntelligenceConfig` resource associated with your
   *     folder.
   *     <p>Format: `folders/{id}/locations/global/intelligenceConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig getFolderIntelligenceConfig(IntelligenceConfigName name) {
    GetFolderIntelligenceConfigRequest request =
        GetFolderIntelligenceConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getFolderIntelligenceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Folder scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name =
   *       IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]").toString();
   *   IntelligenceConfig response = storageControlClient.getFolderIntelligenceConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `IntelligenceConfig` resource associated with your
   *     folder.
   *     <p>Format: `folders/{id}/locations/global/intelligenceConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig getFolderIntelligenceConfig(String name) {
    GetFolderIntelligenceConfigRequest request =
        GetFolderIntelligenceConfigRequest.newBuilder().setName(name).build();
    return getFolderIntelligenceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Folder scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetFolderIntelligenceConfigRequest request =
   *       GetFolderIntelligenceConfigRequest.newBuilder()
   *           .setName(
   *               IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]").toString())
   *           .build();
   *   IntelligenceConfig response = storageControlClient.getFolderIntelligenceConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig getFolderIntelligenceConfig(
      GetFolderIntelligenceConfigRequest request) {
    return getFolderIntelligenceConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Folder scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetFolderIntelligenceConfigRequest request =
   *       GetFolderIntelligenceConfigRequest.newBuilder()
   *           .setName(
   *               IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<IntelligenceConfig> future =
   *       storageControlClient.getFolderIntelligenceConfigCallable().futureCall(request);
   *   // Do something.
   *   IntelligenceConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigCallable() {
    return stub.getFolderIntelligenceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Folder scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   IntelligenceConfig intelligenceConfig = IntelligenceConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   IntelligenceConfig response =
   *       storageControlClient.updateFolderIntelligenceConfig(intelligenceConfig, updateMask);
   * }
   * }</pre>
   *
   * @param intelligenceConfig Required. The `IntelligenceConfig` resource to be updated.
   * @param updateMask Required. The `update_mask` that specifies the fields within the
   *     `IntelligenceConfig` resource that should be modified by this update. Only the listed
   *     fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig updateFolderIntelligenceConfig(
      IntelligenceConfig intelligenceConfig, FieldMask updateMask) {
    UpdateFolderIntelligenceConfigRequest request =
        UpdateFolderIntelligenceConfigRequest.newBuilder()
            .setIntelligenceConfig(intelligenceConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateFolderIntelligenceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Folder scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   UpdateFolderIntelligenceConfigRequest request =
   *       UpdateFolderIntelligenceConfigRequest.newBuilder()
   *           .setIntelligenceConfig(IntelligenceConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   IntelligenceConfig response = storageControlClient.updateFolderIntelligenceConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig updateFolderIntelligenceConfig(
      UpdateFolderIntelligenceConfigRequest request) {
    return updateFolderIntelligenceConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Folder scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   UpdateFolderIntelligenceConfigRequest request =
   *       UpdateFolderIntelligenceConfigRequest.newBuilder()
   *           .setIntelligenceConfig(IntelligenceConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<IntelligenceConfig> future =
   *       storageControlClient.updateFolderIntelligenceConfigCallable().futureCall(request);
   *   // Do something.
   *   IntelligenceConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigCallable() {
    return stub.updateFolderIntelligenceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Organization scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   IntelligenceConfigName name = IntelligenceConfigName.ofOrgLocationName("[ORG]", "[LOCATION]");
   *   IntelligenceConfig response = storageControlClient.getOrganizationIntelligenceConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `IntelligenceConfig` resource associated with your
   *     organization.
   *     <p>Format: `organizations/{org_id}/locations/global/intelligenceConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig getOrganizationIntelligenceConfig(IntelligenceConfigName name) {
    GetOrganizationIntelligenceConfigRequest request =
        GetOrganizationIntelligenceConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOrganizationIntelligenceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Organization scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String name =
   *       IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]").toString();
   *   IntelligenceConfig response = storageControlClient.getOrganizationIntelligenceConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `IntelligenceConfig` resource associated with your
   *     organization.
   *     <p>Format: `organizations/{org_id}/locations/global/intelligenceConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig getOrganizationIntelligenceConfig(String name) {
    GetOrganizationIntelligenceConfigRequest request =
        GetOrganizationIntelligenceConfigRequest.newBuilder().setName(name).build();
    return getOrganizationIntelligenceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Organization scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetOrganizationIntelligenceConfigRequest request =
   *       GetOrganizationIntelligenceConfigRequest.newBuilder()
   *           .setName(IntelligenceConfigName.ofOrgLocationName("[ORG]", "[LOCATION]").toString())
   *           .build();
   *   IntelligenceConfig response = storageControlClient.getOrganizationIntelligenceConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig getOrganizationIntelligenceConfig(
      GetOrganizationIntelligenceConfigRequest request) {
    return getOrganizationIntelligenceConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Organization scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetOrganizationIntelligenceConfigRequest request =
   *       GetOrganizationIntelligenceConfigRequest.newBuilder()
   *           .setName(IntelligenceConfigName.ofOrgLocationName("[ORG]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<IntelligenceConfig> future =
   *       storageControlClient.getOrganizationIntelligenceConfigCallable().futureCall(request);
   *   // Do something.
   *   IntelligenceConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigCallable() {
    return stub.getOrganizationIntelligenceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Organization scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   IntelligenceConfig intelligenceConfig = IntelligenceConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   IntelligenceConfig response =
   *       storageControlClient.updateOrganizationIntelligenceConfig(intelligenceConfig, updateMask);
   * }
   * }</pre>
   *
   * @param intelligenceConfig Required. The `IntelligenceConfig` resource to be updated.
   * @param updateMask Required. The `update_mask` that specifies the fields within the
   *     `IntelligenceConfig` resource that should be modified by this update. Only the listed
   *     fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig updateOrganizationIntelligenceConfig(
      IntelligenceConfig intelligenceConfig, FieldMask updateMask) {
    UpdateOrganizationIntelligenceConfigRequest request =
        UpdateOrganizationIntelligenceConfigRequest.newBuilder()
            .setIntelligenceConfig(intelligenceConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateOrganizationIntelligenceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Organization scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   UpdateOrganizationIntelligenceConfigRequest request =
   *       UpdateOrganizationIntelligenceConfigRequest.newBuilder()
   *           .setIntelligenceConfig(IntelligenceConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   IntelligenceConfig response =
   *       storageControlClient.updateOrganizationIntelligenceConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IntelligenceConfig updateOrganizationIntelligenceConfig(
      UpdateOrganizationIntelligenceConfigRequest request) {
    return updateOrganizationIntelligenceConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Organization scoped singleton IntelligenceConfig resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   UpdateOrganizationIntelligenceConfigRequest request =
   *       UpdateOrganizationIntelligenceConfigRequest.newBuilder()
   *           .setIntelligenceConfig(IntelligenceConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<IntelligenceConfig> future =
   *       storageControlClient.updateOrganizationIntelligenceConfigCallable().futureCall(request);
   *   // Do something.
   *   IntelligenceConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigCallable() {
    return stub.updateOrganizationIntelligenceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for a specified bucket. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ResourceName resource = AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]");
   *   Policy response = storageControlClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for a specified bucket. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String resource =
   *       AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString();
   *   Policy response = storageControlClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for a specified bucket. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = storageControlClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for a specified bucket. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = storageControlClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IAM policy for the specified bucket. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ResourceName resource = AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = storageControlClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IAM policy for the specified bucket. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String resource =
   *       AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = storageControlClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IAM policy for the specified bucket. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = storageControlClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IAM policy for the specified bucket. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = storageControlClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests a set of permissions on the given bucket, object, or managed folder to see which, if any,
   * are held by the caller. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, `projects/_/buckets/{bucket}/objects/{object}` for
   * an object, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed
   * folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   ResourceName resource = AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]");
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       storageControlClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests a set of permissions on the given bucket, object, or managed folder to see which, if any,
   * are held by the caller. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, `projects/_/buckets/{bucket}/objects/{object}` for
   * an object, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed
   * folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   String resource =
   *       AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       storageControlClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests a set of permissions on the given bucket, object, or managed folder to see which, if any,
   * are held by the caller. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, `projects/_/buckets/{bucket}/objects/{object}` for
   * an object, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed
   * folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = storageControlClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests a set of permissions on the given bucket, object, or managed folder to see which, if any,
   * are held by the caller. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, `projects/_/buckets/{bucket}/objects/{object}` for
   * an object, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed
   * folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageControlClient storageControlClient = StorageControlClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AnywhereCacheName.of("[PROJECT]", "[BUCKET]", "[ANYWHERE_CACHE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       storageControlClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListFoldersPagedResponse
      extends AbstractPagedListResponse<
          ListFoldersRequest,
          ListFoldersResponse,
          Folder,
          ListFoldersPage,
          ListFoldersFixedSizeCollection> {

    public static ApiFuture<ListFoldersPagedResponse> createAsync(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ApiFuture<ListFoldersResponse> futureResponse) {
      ApiFuture<ListFoldersPage> futurePage =
          ListFoldersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListFoldersPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListFoldersPagedResponse(ListFoldersPage page) {
      super(page, ListFoldersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFoldersPage
      extends AbstractPage<ListFoldersRequest, ListFoldersResponse, Folder, ListFoldersPage> {

    private ListFoldersPage(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ListFoldersResponse response) {
      super(context, response);
    }

    private static ListFoldersPage createEmptyPage() {
      return new ListFoldersPage(null, null);
    }

    @Override
    protected ListFoldersPage createPage(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ListFoldersResponse response) {
      return new ListFoldersPage(context, response);
    }

    @Override
    public ApiFuture<ListFoldersPage> createPageAsync(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ApiFuture<ListFoldersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFoldersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFoldersRequest,
          ListFoldersResponse,
          Folder,
          ListFoldersPage,
          ListFoldersFixedSizeCollection> {

    private ListFoldersFixedSizeCollection(List<ListFoldersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFoldersFixedSizeCollection createEmptyCollection() {
      return new ListFoldersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFoldersFixedSizeCollection createCollection(
        List<ListFoldersPage> pages, int collectionSize) {
      return new ListFoldersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListManagedFoldersPagedResponse
      extends AbstractPagedListResponse<
          ListManagedFoldersRequest,
          ListManagedFoldersResponse,
          ManagedFolder,
          ListManagedFoldersPage,
          ListManagedFoldersFixedSizeCollection> {

    public static ApiFuture<ListManagedFoldersPagedResponse> createAsync(
        PageContext<ListManagedFoldersRequest, ListManagedFoldersResponse, ManagedFolder> context,
        ApiFuture<ListManagedFoldersResponse> futureResponse) {
      ApiFuture<ListManagedFoldersPage> futurePage =
          ListManagedFoldersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListManagedFoldersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListManagedFoldersPagedResponse(ListManagedFoldersPage page) {
      super(page, ListManagedFoldersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListManagedFoldersPage
      extends AbstractPage<
          ListManagedFoldersRequest,
          ListManagedFoldersResponse,
          ManagedFolder,
          ListManagedFoldersPage> {

    private ListManagedFoldersPage(
        PageContext<ListManagedFoldersRequest, ListManagedFoldersResponse, ManagedFolder> context,
        ListManagedFoldersResponse response) {
      super(context, response);
    }

    private static ListManagedFoldersPage createEmptyPage() {
      return new ListManagedFoldersPage(null, null);
    }

    @Override
    protected ListManagedFoldersPage createPage(
        PageContext<ListManagedFoldersRequest, ListManagedFoldersResponse, ManagedFolder> context,
        ListManagedFoldersResponse response) {
      return new ListManagedFoldersPage(context, response);
    }

    @Override
    public ApiFuture<ListManagedFoldersPage> createPageAsync(
        PageContext<ListManagedFoldersRequest, ListManagedFoldersResponse, ManagedFolder> context,
        ApiFuture<ListManagedFoldersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListManagedFoldersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListManagedFoldersRequest,
          ListManagedFoldersResponse,
          ManagedFolder,
          ListManagedFoldersPage,
          ListManagedFoldersFixedSizeCollection> {

    private ListManagedFoldersFixedSizeCollection(
        List<ListManagedFoldersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListManagedFoldersFixedSizeCollection createEmptyCollection() {
      return new ListManagedFoldersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListManagedFoldersFixedSizeCollection createCollection(
        List<ListManagedFoldersPage> pages, int collectionSize) {
      return new ListManagedFoldersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAnywhereCachesPagedResponse
      extends AbstractPagedListResponse<
          ListAnywhereCachesRequest,
          ListAnywhereCachesResponse,
          AnywhereCache,
          ListAnywhereCachesPage,
          ListAnywhereCachesFixedSizeCollection> {

    public static ApiFuture<ListAnywhereCachesPagedResponse> createAsync(
        PageContext<ListAnywhereCachesRequest, ListAnywhereCachesResponse, AnywhereCache> context,
        ApiFuture<ListAnywhereCachesResponse> futureResponse) {
      ApiFuture<ListAnywhereCachesPage> futurePage =
          ListAnywhereCachesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAnywhereCachesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAnywhereCachesPagedResponse(ListAnywhereCachesPage page) {
      super(page, ListAnywhereCachesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnywhereCachesPage
      extends AbstractPage<
          ListAnywhereCachesRequest,
          ListAnywhereCachesResponse,
          AnywhereCache,
          ListAnywhereCachesPage> {

    private ListAnywhereCachesPage(
        PageContext<ListAnywhereCachesRequest, ListAnywhereCachesResponse, AnywhereCache> context,
        ListAnywhereCachesResponse response) {
      super(context, response);
    }

    private static ListAnywhereCachesPage createEmptyPage() {
      return new ListAnywhereCachesPage(null, null);
    }

    @Override
    protected ListAnywhereCachesPage createPage(
        PageContext<ListAnywhereCachesRequest, ListAnywhereCachesResponse, AnywhereCache> context,
        ListAnywhereCachesResponse response) {
      return new ListAnywhereCachesPage(context, response);
    }

    @Override
    public ApiFuture<ListAnywhereCachesPage> createPageAsync(
        PageContext<ListAnywhereCachesRequest, ListAnywhereCachesResponse, AnywhereCache> context,
        ApiFuture<ListAnywhereCachesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnywhereCachesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnywhereCachesRequest,
          ListAnywhereCachesResponse,
          AnywhereCache,
          ListAnywhereCachesPage,
          ListAnywhereCachesFixedSizeCollection> {

    private ListAnywhereCachesFixedSizeCollection(
        List<ListAnywhereCachesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnywhereCachesFixedSizeCollection createEmptyCollection() {
      return new ListAnywhereCachesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnywhereCachesFixedSizeCollection createCollection(
        List<ListAnywhereCachesPage> pages, int collectionSize) {
      return new ListAnywhereCachesFixedSizeCollection(pages, collectionSize);
    }
  }
}
