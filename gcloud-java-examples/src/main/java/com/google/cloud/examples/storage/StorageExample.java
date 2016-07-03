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

package com.google.cloud.examples.storage;

import com.google.cloud.AuthCredentials;
import com.google.cloud.AuthCredentials.ServiceAccountAuthCredentials;
import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.spi.StorageRpc;
import com.google.cloud.storage.spi.StorageRpc.Tuple;
import com.google.common.collect.ImmutableMap;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * An example of using Google Cloud Storage.
 *
 * <p>This example demonstrates a simple/typical storage usage.
 *
 * <p>See the
 * <a href="https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/README.md">
 * README</a> for compilation instructions. Run this code with
 * <pre>{@code target/appassembler/bin/StorageExample [<project_id>]
 *  list [<bucket>] |
 *  info [<bucket> [<file>]] |
 *  download <bucket> <path> [local_file] |
 *  upload <local_file> <bucket> [<path>] |
 *  delete <bucket> <path>+ |
 *  cp <from_bucket> <from_path> <to_bucket> <to_path> |
 *  compose <bucket> <from_path>+ <to_path> |
 *  update_metadata <bucket> <file> [key=value]* |
 *  sign_url <service_account_private_key_file> <service_account_email> <bucket> <path> |
 *  add-acl domain <bucket> <path>? <domain> OWNER|READER|WRITER |
 *  add-acl project <bucket> <path>? <projectId>:(OWNERS|EDITORS|VIEWERS) OWNER|READER|WRITER |
 *  add-acl user <bucket> <path>? <userEmail>|allUsers|allAuthenticatedUsers OWNER|READER|WRITER |
 *  add-acl group <bucket> <path>? <group> OWNER|READER|WRITER}</pre>
 *
 * <p>The first parameter is an optional {@code project_id} (logged-in project will be used if not
 * supplied). Second parameter is a Storage operation (list, delete, compose,...) and can be used to
 * demonstrate its usage. Any other arguments are specific to the operation. See each action's run
 * method for the specific Storage interaction.
 */
public class StorageExample {

  private static final Map<String, StorageAction> ACTIONS = new HashMap<>();
  private static final Map<String, StorageAction> ACL_ACTIONS = new HashMap<>();

  private abstract static class StorageAction<T> {

    abstract void run(Storage storage, T arg) throws Exception;

    abstract T parse(String... args) throws Exception;

    protected String params() {
      return "";
    }
  }

  private abstract static class BlobsAction extends StorageAction<BlobId[]> {

    @Override
    BlobId[] parse(String... args) {
      if (args.length < 2) {
        throw new IllegalArgumentException();
      }
      BlobId[] blobs = new BlobId[args.length - 1];
      for (int i = 1; i < args.length; i++) {
        blobs[i - 1] = BlobId.of(args[0], args[i]);
      }
      return blobs;
    }

    @Override
    public String params() {
      return "<bucket> <path>+";
    }
  }

  private static class ParentAction extends StorageAction<StorageRpc.Tuple<StorageAction, Object>> {

    private final Map<String, StorageAction> subActions;

    ParentAction(Map<String, StorageAction> subActions) {
      this.subActions = ImmutableMap.copyOf(subActions);
    }

    @Override
    @SuppressWarnings("unchecked")
    void run(Storage storage, StorageRpc.Tuple<StorageAction, Object> subaction) throws Exception {
      subaction.x().run(storage, subaction.y());
    }

    @Override
    StorageRpc.Tuple<StorageAction, Object> parse(String... args) throws Exception {
      if (args.length >= 1) {
        StorageAction action = subActions.get(args[0]);
        if (action != null) {
          Object actionArguments = action.parse(Arrays.copyOfRange(args, 1, args.length));
          return StorageRpc.Tuple.of(action, actionArguments);
        } else {
          throw new IllegalArgumentException("Unrecognized entity '" + args[0] + "'.");
        }
      }
      throw new IllegalArgumentException("Missing required entity.");
    }

    @Override
    public String params() {
      StringBuilder builder = new StringBuilder();
      for (Map.Entry<String, StorageAction> entry : subActions.entrySet()) {
        builder.append('\n').append(entry.getKey());
        String param = entry.getValue().params();
        if (param != null && !param.isEmpty()) {
          builder.append(' ').append(param);
        }
      }
      return builder.toString();
    }
  }

  /**
   * This class demonstrates how to retrieve Bucket or Blob metadata.
   * If more than one blob is supplied a Batch operation would be used to get all blobs metadata
   * in a single RPC.
   *
   * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/get">Objects: get</a>
   */
  private static class InfoAction extends BlobsAction {

    /**
     * Gets information for the provided blobs, using the {@code storage} service. If
     * {@code blobIds} contains only one blob identity and {@code blobIds[0].name()} is empty, this
     * method gets information for the bucket identified by {@code blobIds[0].bucket()}.
     */
    @Override
    public void run(Storage storage, BlobId... blobIds) {
      if (blobIds.length == 1) {
        if (blobIds[0].name().isEmpty()) {
          // get Bucket
          Bucket bucket = storage.get(blobIds[0].bucket());
          if (bucket == null) {
            System.out.println("No such bucket");
            return;
          }
          System.out.printf("Bucket info: %s%n", bucket);
        } else {
          // get Blob
          Blob blob = storage.get(blobIds[0]);
          if (blob == null) {
            System.out.println("No such object");
            return;
          }
          System.out.printf("Blob info: %s%n", blob);
        }
      } else {
        // use batch to get multiple blobs.
        List<Blob> blobs = storage.get(blobIds);
        for (Blob blob : blobs) {
          if (blob != null) {
            System.out.println(blob);
          }
        }
      }
    }

    @Override
    BlobId[] parse(String... args) {
      if (args.length < 2) {
        return new BlobId[] {BlobId.of(args[0], "")};
      }
      return super.parse(args);
    }

    @Override
    public String params() {
      return "<bucket> [<path>+]";
    }
  }

  /**
   * This class demonstrates how to delete a blob.
   * If more than one blob is supplied a Batch operation would be used to delete all requested
   * blobs in a single RPC.
   *
   * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/delete">Objects: delete</a>
   */
  private static class DeleteAction extends BlobsAction {
    @Override
    public void run(Storage storage, BlobId... blobIds) {
      // use batch operation
      List<Boolean> deleteResults = storage.delete(blobIds);
      int index = 0;
      for (Boolean deleted : deleteResults) {
        if (deleted) {
          // request order is maintained
          System.out.printf("Blob %s was deleted%n", blobIds[index]);
        }
        index++;
      }
    }
  }

  /**
   * This class demonstrates how to list buckets or a bucket's blobs.
   *
   * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/list">Objects: list</a>
   */
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
    public void run(Storage storage, String bucketName) {
      if (bucketName == null) {
        // list buckets
        Iterator<Bucket> bucketIterator = storage.list().iterateAll();
        while (bucketIterator.hasNext()) {
          System.out.println(bucketIterator.next());
        }
      } else {
        // list a bucket's blobs
        Bucket bucket = storage.get(bucketName);
        if (bucket == null) {
          System.out.println("No such bucket");
          return;
        }
        Iterator<Blob> blobIterator = bucket.list().iterateAll();
        while (blobIterator.hasNext()) {
          System.out.println(blobIterator.next());
        }
      }
    }

    @Override
    public String params() {
      return "[<bucket>]";
    }
  }

  /**
   * This class demonstrates how to create a new Blob or to update its content.
   *
   * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/insert">Objects: insert</a>
   */
  private static class UploadAction extends StorageAction<Tuple<Path, BlobInfo>> {
    @Override
    public void run(Storage storage, Tuple<Path, BlobInfo> tuple) throws Exception {
      run(storage, tuple.x(), tuple.y());
    }

    private void run(Storage storage, Path uploadFrom, BlobInfo blobInfo) throws IOException {
      if (Files.size(uploadFrom) > 1_000_000) {
        // When content is not available or large (1MB or more) it is recommended
        // to write it in chunks via the blob's channel writer.
        try (WriteChannel writer = storage.writer(blobInfo)) {
          byte[] buffer = new byte[1024];
          try (InputStream input = Files.newInputStream(uploadFrom)) {
            int limit;
            while ((limit = input.read(buffer)) >= 0) {
              try {
                writer.write(ByteBuffer.wrap(buffer, 0, limit));
              } catch (Exception ex) {
                ex.printStackTrace();
              }
            }
          }
        }
      } else {
        byte[] bytes = Files.readAllBytes(uploadFrom);
        // create the blob in one request.
        storage.create(blobInfo, bytes);
      }
      System.out.println("Blob was created");
    }

    @Override
    Tuple<Path, BlobInfo> parse(String... args) throws IOException {
      if (args.length < 2 || args.length > 3) {
        throw new IllegalArgumentException();
      }
      Path path = Paths.get(args[0]);
      String contentType = Files.probeContentType(path);
      String blob = args.length < 3 ? path.getFileName().toString() : args[2];
      return Tuple.of(path, BlobInfo.builder(args[1], blob).contentType(contentType).build());
    }

    @Override
    public String params() {
      return "<local_file> <bucket> [<path>]";
    }
  }

  /**
   * This class demonstrates how read a blob's content.
   * The example will dump the content to a local file if one was given or write
   * it to stdout otherwise.
   *
   * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/get">Objects: get</a>
   */
  private static class DownloadAction extends StorageAction<Tuple<BlobId, Path>> {

    @Override
    public void run(Storage storage, Tuple<BlobId, Path> tuple) throws IOException {
      run(storage, tuple.x(), tuple.y());
    }

    private void run(Storage storage, BlobId blobId, Path downloadTo) throws IOException {
      Blob blob = storage.get(blobId);
      if (blob == null) {
        System.out.println("No such object");
        return;
      }
      PrintStream writeTo = System.out;
      if (downloadTo != null) {
        writeTo = new PrintStream(new FileOutputStream(downloadTo.toFile()));
      }
      if (blob.size() < 1_000_000) {
        // Blob is small read all its content in one request
        byte[] content = blob.content();
        writeTo.write(content);
      } else {
        // When Blob size is big or unknown use the blob's channel reader.
        try (ReadChannel reader = blob.reader()) {
          WritableByteChannel channel = Channels.newChannel(writeTo);
          ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
          while (reader.read(bytes) > 0) {
            bytes.flip();
            channel.write(bytes);
            bytes.clear();
          }
        }
      }
      if (downloadTo == null) {
        writeTo.println();
      } else {
        writeTo.close();
      }
    }

    @Override
    Tuple<BlobId, Path> parse(String... args) {
      if (args.length < 2 || args.length > 3) {
        throw new IllegalArgumentException();
      }
      Path path;
      if (args.length > 2) {
        path = Paths.get(args[2]);
        if (Files.isDirectory(path)) {
          path = path.resolve(Paths.get(args[1]).getFileName());
        }
      } else {
        path = null;
      }
      return Tuple.of(BlobId.of(args[0], args[1]), path);
    }

    @Override
    public String params() {
      return "<bucket> <path> [local_file]";
    }
  }

  /**
   * This class demonstrates how to use the copy command.
   *
   * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/copy">Objects: copy</a>
   */
  private static class CopyAction extends StorageAction<CopyRequest> {
    @Override
    public void run(Storage storage, CopyRequest request) {
      CopyWriter copyWriter = storage.copy(request);
      System.out.printf("Copied %s%n", copyWriter.result());
    }

    @Override
    CopyRequest parse(String... args) {
      if (args.length != 4) {
        throw new IllegalArgumentException();
      }
      return CopyRequest.of(args[0], args[1], BlobId.of(args[2], args[3]));
    }

    @Override
    public String params() {
      return "<from_bucket> <from_path> <to_bucket> <to_path>";
    }
  }

  /**
   * This class demonstrates how to use the compose command.
   *
   * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/compose">Objects: compose</a>
   */
  private static class ComposeAction extends StorageAction<ComposeRequest> {
    @Override
    public void run(Storage storage, ComposeRequest request) {
      BlobInfo composedBlobInfo = storage.compose(request);
      System.out.printf("Composed %s%n", composedBlobInfo);
    }

    @Override
    ComposeRequest parse(String... args) {
      if (args.length < 3) {
        throw new IllegalArgumentException();
      }
      ComposeRequest.Builder request = ComposeRequest.builder();
      request.target(BlobInfo.builder(args[0], args[args.length - 1]).build());
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

  /**
   * This class demonstrates how to update a blob's metadata.
   *
   * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/update">Objects: update</a>
   */
  private static class UpdateMetadataAction extends
      StorageAction<Tuple<BlobId, Map<String, String>>> {

    @Override
    public void run(Storage storage, Tuple<BlobId, Map<String, String>> tuple)
        throws IOException {
      run(storage, tuple.x(), tuple.y());
    }

    private void run(Storage storage, BlobId blobId, Map<String, String> metadata) {
      Blob blob = storage.get(blobId);
      if (blob == null) {
        System.out.println("No such object");
        return;
      }
      Blob updateBlob = blob.toBuilder().metadata(metadata).build().update();
      System.out.printf("Updated %s%n", updateBlob);
    }

    @Override
    Tuple<BlobId, Map<String, String>> parse(String... args) {
      if (args.length < 2) {
        throw new IllegalArgumentException();
      }
      BlobId blobId = BlobId.of(args[0], args[1]);
      Map<String, String> metadata = new HashMap<>();
      for (int i = 2; i < args.length; i++) {
        int idx = args[i].indexOf('=');
        if (idx < 0) {
          metadata.put(args[i], "");
        } else {
          metadata.put(args[i].substring(0, idx), args[i].substring(idx + 1));
        }
      }
      return Tuple.of(blobId, metadata);
    }

    @Override
    public String params() {
      return "<bucket> <path> [local_file]";
    }
  }

  /**
   * This class demonstrates how to sign a url.
   * URL will be valid for 1 day.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed URLs</a>
   */
  private static class SignUrlAction extends
      StorageAction<Tuple<ServiceAccountAuthCredentials, BlobInfo>> {

    private static final char[] PASSWORD = "notasecret".toCharArray();

    @Override
    public void run(Storage storage, Tuple<ServiceAccountAuthCredentials, BlobInfo> tuple)
        throws Exception {
      run(storage, tuple.x(), tuple.y());
    }

    private void run(Storage storage, ServiceAccountAuthCredentials cred, BlobInfo blobInfo) {
      Blob blob = storage.get(blobInfo.blobId());
      System.out.printf("Signed URL: %s%n",
          blob.signUrl(1, TimeUnit.DAYS, SignUrlOption.signWith(cred)));
    }

    @Override
    Tuple<ServiceAccountAuthCredentials, BlobInfo> parse(String... args) throws IOException,
        KeyStoreException, CertificateException, NoSuchAlgorithmException,
        UnrecoverableKeyException {
      if (args.length != 4) {
        throw new IllegalArgumentException();
      }
      KeyStore keystore = KeyStore.getInstance("PKCS12");
      keystore.load(Files.newInputStream(Paths.get(args[0])), PASSWORD);
      PrivateKey privateKey = (PrivateKey) keystore.getKey("privatekey", PASSWORD);
      ServiceAccountAuthCredentials cred = AuthCredentials.createFor(args[1], privateKey);
      return Tuple.of(cred, BlobInfo.builder(BlobId.of(args[2], args[3])).build());
    }

    @Override
    public String params() {
      return "<service_account_private_key_file> <service_account_email> <bucket> <path>";
    }
  }

  private abstract static class AclAction extends StorageAction<Tuple<BlobId, Acl>> {

    /**
     * Sets the ACL according to the provided {@code params}, using the {@code storage} service. If
     * {@code params.x()} returns a complete blob identity, the {@code params.y()} ACL is added to
     * the blob. If {@code params.x().name()} is empty, the {@code params.y()} ACL is added to the
     * bucket identified by {@code params.x().bucket()}.
     */
    @Override
    public void run(Storage storage, Tuple<BlobId, Acl> params) {
      BlobId blobId = params.x();
      Acl acl = params.y();
      if (blobId.name().isEmpty()) {
        Bucket bucket = storage.get(blobId.bucket());
        if (bucket == null) {
          System.out.printf("Bucket %s does not exist%n", blobId.bucket());
          return;
        }
        bucket.toBuilder().acl(addAcl(bucket.acl(), acl)).build().update();
        System.out.printf("Added ACL %s to bucket %s%n", acl, blobId.bucket());
      } else {
        Blob blob = storage.get(blobId);
        if (blob == null) {
          System.out.printf("Blob %s does not exist%n", blobId);
          return;
        }
        blob.toBuilder().acl(addAcl(blob.acl(), acl)).build().update();
        System.out.printf("Added ACL %s to blob %s%n", acl, blobId);
      }
    }

    private static List<Acl> addAcl(List<Acl> acls, Acl newAcl) {
      List<Acl> newAcls = new LinkedList<>(acls);
      newAcls.add(newAcl);
      return newAcls;
    }
  }

  /**
   * This class demonstrates how to add an ACL to a blob or a bucket for a group of users
   * (identified by the group's email).
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control/lists#permissions">Access
   *     Control Lists (ACLs)</a>
   */
  private static class AddGroupAclAction extends AclAction {

    @Override
    Tuple<BlobId, Acl> parse(String... args) {
      if (args.length >= 3) {
        BlobId blob;
        int nextArg;
        if (args.length == 3) {
          blob = BlobId.of(args[0], "");
          nextArg = 1;
        } else if (args.length == 4) {
          blob = BlobId.of(args[0], args[1]);
          nextArg = 2;
        } else {
          throw new IllegalArgumentException("Too many arguments.");
        }
        String group = args[nextArg++];
        Acl.Role role = Acl.Role.valueOf(args[nextArg]);
        return Tuple.of(blob, Acl.of(new Acl.Group(group), role));
      }
      throw new IllegalArgumentException("Missing required bucket, groupEmail or role arguments.");
    }

    @Override
    public String params() {
      return "<bucket> <path>? <group> OWNER|READER|WRITER";
    }
  }

  /**
   * This class demonstrates how to add an ACL to a blob or a bucket for a domain.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control/lists#permissions">Access
   *     Control Lists (ACLs)</a>
   */
  private static class AddDomainAclAction extends AclAction {

    @Override
    Tuple<BlobId, Acl> parse(String... args) {
      if (args.length >= 3) {
        BlobId blob;
        int nextArg;
        if (args.length == 3) {
          blob = BlobId.of(args[0], "");
          nextArg = 1;
        } else if (args.length == 4) {
          blob = BlobId.of(args[0], args[1]);
          nextArg = 2;
        } else {
          throw new IllegalArgumentException("Too many arguments.");
        }
        String domain = args[nextArg++];
        Acl.Role role = Acl.Role.valueOf(args[nextArg]);
        return Tuple.of(blob, Acl.of(new Acl.Domain(domain), role));
      }
      throw new IllegalArgumentException("Missing required bucket, domain or role arguments.");
    }

    @Override
    public String params() {
      return "<bucket> <path>? <domain> OWNER|READER|WRITER";
    }
  }

  /**
   * This class demonstrates how to add an ACL to a blob or a bucket for either a user (if an email
   * is provided), all users (if {@code allUsers} is provided), or all authenticated users (if
   * {@code allAuthenticatedUsers} is provided).
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control/lists#permissions">Access
   *     Control Lists (ACLs)</a>
   */
  private static class AddUserAclAction extends AclAction {

    @Override
    Tuple<BlobId, Acl> parse(String... args) {
      if (args.length >= 3) {
        BlobId blob;
        int nextArg;
        if (args.length == 3) {
          blob = BlobId.of(args[0], "");
          nextArg = 1;
        } else if (args.length == 4) {
          blob = BlobId.of(args[0], args[1]);
          nextArg = 2;
        } else {
          throw new IllegalArgumentException("Too many arguments.");
        }
        String user = args[nextArg++];
        Acl.Role role = Acl.Role.valueOf(args[nextArg]);
        return Tuple.of(blob, Acl.of(new Acl.User(user), role));
      }
      throw new IllegalArgumentException("Missing required bucket, userEmail or role arguments.");
    }

    @Override
    public String params() {
      return "<bucket> <path>? <userEmail>|allUsers|allAuthenticatedUsers OWNER|READER|WRITER";
    }
  }

  /**
   * This class demonstrates how to add an ACL to a blob or a bucket for all users that have a
   * specific role in a provided project.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control/lists#permissions">Access
   *     Control Lists (ACLs)</a>
   */
  private static class AddProjectAclAction extends AclAction {

    @Override
    Tuple<BlobId, Acl> parse(String... args) {
      if (args.length >= 3) {
        BlobId blob;
        int nextArg;
        if (args.length == 3) {
          blob = BlobId.of(args[0], "");
          nextArg = 1;
        } else if (args.length == 4) {
          blob = BlobId.of(args[0], args[1]);
          nextArg = 2;
        } else {
          throw new IllegalArgumentException("Too many arguments.");
        }
        String[] projectAndRole = args[nextArg++].split(":");
        if (projectAndRole.length != 2) {
          throw new IllegalArgumentException(
              "Project entity must be specified as <projectId>:(OWNERS|READERS|WRITERS)");
        } else {
          Acl.Project.ProjectRole projectRole = Acl.Project.ProjectRole.valueOf(projectAndRole[1]);
          Acl.Role role = Acl.Role.valueOf(args[nextArg]);
          return Tuple.of(blob, Acl.of(new Acl.Project(projectRole, projectAndRole[0]), role));
        }
      }
      throw new IllegalArgumentException("Missing required bucket, project or role arguments.");
    }

    @Override
    public String params() {
      return "<bucket> <path>? <projectId>:(OWNERS|EDITORS|VIEWERS) OWNER|READER|WRITER";
    }
  }

  static {
    ACTIONS.put("info", new InfoAction());
    ACTIONS.put("delete", new DeleteAction());
    ACTIONS.put("list", new ListAction());
    ACTIONS.put("upload", new UploadAction());
    ACTIONS.put("download", new DownloadAction());
    ACTIONS.put("cp", new CopyAction());
    ACTIONS.put("compose", new ComposeAction());
    ACTIONS.put("update_metadata", new UpdateMetadataAction());
    ACTIONS.put("sign_url", new SignUrlAction());
    ACL_ACTIONS.put("group", new AddGroupAclAction());
    ACL_ACTIONS.put("domain", new AddDomainAclAction());
    ACL_ACTIONS.put("user", new AddUserAclAction());
    ACL_ACTIONS.put("project", new AddProjectAclAction());
    ACTIONS.put("add-acl", new ParentAction(ACL_ACTIONS));
  }

  private static void printUsage() {
    StringBuilder actionAndParams = new StringBuilder();
    for (Map.Entry<String, StorageAction> entry : ACTIONS.entrySet()) {
      actionAndParams.append("\n\t").append(entry.getKey());

      String param = entry.getValue().params();
      if (param != null && !param.isEmpty()) {
        // Add extra padding for multi-line action
        actionAndParams.append(' ').append(param.replace("\n", "\n\t\t"));
      }
    }
    System.out.printf("Usage: %s [<project_id>] operation [entity] <args>*%s%n",
        StorageExample.class.getSimpleName(), actionAndParams);
  }

  @SuppressWarnings("unchecked")
  public static void main(String... args) throws Exception {
    if (args.length < 1) {
      System.out.println("Missing required project id and action");
      printUsage();
      return;
    }
    StorageOptions.Builder optionsBuilder = StorageOptions.builder();
    StorageAction action;
    String actionName;
    if (args.length >= 2 && !ACTIONS.containsKey(args[0])) {
      actionName = args[1];
      optionsBuilder.projectId(args[0]);
      action = ACTIONS.get(args[1]);
      args = Arrays.copyOfRange(args, 2, args.length);
    } else {
      actionName = args[0];
      action = ACTIONS.get(args[0]);
      args = Arrays.copyOfRange(args, 1, args.length);
    }
    if (action == null) {
      System.out.println("Unrecognized action.");
      printUsage();
      return;
    }
    Storage storage = optionsBuilder.build().service();
    Object arg;
    try {
      arg = action.parse(args);
    } catch (IllegalArgumentException ex) {
      System.out.printf("Invalid input for action '%s'. %s%n", actionName, ex.getMessage());
      System.out.printf("Expected: %s%n", action.params());
      return;
    } catch (Exception ex) {
      System.out.println("Failed to parse arguments.");
      ex.printStackTrace();
      return;
    }
    action.run(storage, arg);
  }
}
