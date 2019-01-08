/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import java.io.IOException;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;
import org.kohsuke.args4j.spi.SubCommands;

/**
 * Defines the different sub-commands and their parameters, for command-line invocation.
 */
class SnippetCommands {
  /**
   * An interface for a command-line sub-command.
   */
  interface Command {
    void run() throws IOException;
  }

  // Most of the commands take some subset of the same arguments, so specify groups of arguments
  // as classes for greater code reuse.
  static class ProjectIdArgs {
    @Option(name = "--project-id", aliases = "-p", required = true, usage = "Your GCP project ID")
    String projectId;
  }

  static class LocationIdArgs extends ProjectIdArgs {
    @Argument(metaVar = "locationId", required = true, index = 0, usage = "The location id")
    String locationId;
  }

  static class KeyRingArgs extends LocationIdArgs {
    @Argument(metaVar = "keyRingId", required = true, index = 1, usage = "The key ring id")
    String keyRingId;
  }

  static class KeyArgs extends KeyRingArgs {
    @Argument(metaVar = "cryptoKeyId", required = true, index = 2, usage = "The crypto key id")
    String cryptoKeyId;
  }

  static class KeyVersionArgs extends KeyArgs {
    @Argument(metaVar = "version", required = true, index = 3, usage = "The key version")
    String version;
  }


  public static class CreateKeyRingCommand extends KeyRingArgs implements Command {
    public void run() throws IOException {
      Snippets.createKeyRing(projectId, locationId, keyRingId);
    }
  }

  public static class CreateCryptoKeyCommand extends KeyArgs implements Command {
    public void run() throws IOException {
      Snippets.createCryptoKey(projectId, locationId, keyRingId, cryptoKeyId);
    }
  }

  public static class CreateCryptoKeyVersionCommand extends KeyArgs implements Command {
    public void run() throws IOException {
      Snippets.createCryptoKeyVersion(projectId, locationId, keyRingId, cryptoKeyId);
    }
  }

  public static class ListKeyRingsCommand extends LocationIdArgs implements Command {
    public void run() throws IOException {
      Snippets.listKeyRings(projectId, locationId);
    }
  }

  public static class ListCryptoKeysCommand extends KeyRingArgs implements Command {
    public void run() throws IOException {
      Snippets.listCryptoKeys(projectId, locationId, keyRingId);
    }
  }

  public static class ListCryptoKeyVersionsCommand extends KeyArgs implements Command {
    public void run() throws IOException {
      Snippets.listCryptoKeyVersions(projectId, locationId, keyRingId, cryptoKeyId);
    }
  }

  public static class DisableCryptoKeyVersionCommand extends KeyVersionArgs implements Command {
    public void run() throws IOException {
      Snippets.disableCryptoKeyVersion(projectId, locationId, keyRingId, cryptoKeyId, version);
    }
  }

  public static class EnableCryptoKeyVersionCommand extends KeyVersionArgs implements Command {
    public void run() throws IOException {
      Snippets.enableCryptoKeyVersion(projectId, locationId, keyRingId, cryptoKeyId, version);
    }
  }

  public static class DestroyCryptoKeyVersionCommand extends KeyVersionArgs implements Command {
    public void run() throws IOException {
      Snippets.destroyCryptoKeyVersion(projectId, locationId, keyRingId, cryptoKeyId, version);
    }
  }

  public static class RestoreCryptoKeyVersionCommand extends KeyVersionArgs implements Command {
    public void run() throws IOException {
      Snippets.restoreCryptoKeyVersion(projectId, locationId, keyRingId, cryptoKeyId, version);
    }
  }

  public static class SetPrimaryVersionCommand extends KeyVersionArgs implements Command {

    public void run() throws IOException {
      Snippets.setPrimaryVersion(projectId, locationId, keyRingId, cryptoKeyId, version);
    }
  }

  public static class GetKeyRingPolicyCommand extends KeyRingArgs implements Command {
    public void run() throws IOException {
      Snippets.getKeyRingPolicy(projectId, locationId, keyRingId);
    }
  }

  public static class GetCryptoKeyPolicyCommand extends KeyArgs implements Command {
    public void run() throws IOException {
      Snippets.getCryptoKeyPolicy(projectId, locationId, keyRingId, cryptoKeyId);
    }
  }

  public static class AddMemberToKeyRingPolicyCommand extends KeyRingArgs implements Command {
    @Argument(metaVar = "member", required = true, index = 1,
        usage = "The member to add.\n"
            + "See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding "
            + "for valid values.")
    String member;
    @Argument(metaVar = "role", required = true, index = 2,
        usage = "The role for the member.\n"
            + "See https://g.co/cloud/iam/docs/understanding-roles for valid values.")
    String role;

    public void run() throws IOException {
      Snippets.addMemberToKeyRingPolicy(projectId, locationId, keyRingId, member, role);
    }
  }

  public static class AddMemberToCryptoKeyPolicyCommand extends KeyArgs implements Command {
    @Argument(metaVar = "member", required = true, index = 2,
        usage = "The member to add.\n"
            + "See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding "
            + "for valid values.")
    String member;
    @Argument(metaVar = "role", required = true, index = 3,
        usage = "The role for the member.\n"
            + "See https://g.co/cloud/iam/docs/understanding-roles for valid values.")
    String role;

    public void run() throws IOException {
      Snippets
          .addMemberToCryptoKeyPolicy(projectId, locationId, keyRingId, cryptoKeyId, member, role);
    }
  }

  public static class RemoveMemberFromKeyRingPolicyCommand extends KeyRingArgs implements Command {
    @Argument(metaVar = "member", required = true, index = 1,
        usage = "The member to add.\n"
            + "See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding "
            + "for valid values.")
    String member;
    @Argument(metaVar = "role", required = true, index = 2,
        usage = "The role for the member.\n"
            + "See https://g.co/cloud/iam/docs/understanding-roles for valid values.")
    String role;

    public void run() throws IOException {
      Snippets.removeMemberFromKeyRingPolicy(projectId, locationId, keyRingId, member, role);
    }
  }

  public static class RemoveMemberFromCryptoKeyPolicyCommand extends KeyArgs implements Command {
    @Argument(metaVar = "member", required = true, index = 2,
        usage = "The member to add.\n"
            + "See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding "
            + "for valid values.")
    String member;
    @Argument(metaVar = "role", required = true, index = 3,
        usage = "The role for the member.\n"
            + "See https://g.co/cloud/iam/docs/understanding-roles for valid values.")
    String role;

    public void run() throws IOException {
      Snippets
          .removeMemberFromCryptoKeyPolicy(projectId, locationId, keyRingId, cryptoKeyId, member,
              role);
    }
  }

  @Argument(metaVar = "command", required = true, handler = SubCommandHandler.class,
      usage = "The subcommand to run")
  @SubCommands({
      @SubCommand(name = "createKeyRing", impl = CreateKeyRingCommand.class),
      @SubCommand(name = "createCryptoKey", impl = CreateCryptoKeyCommand.class),
      @SubCommand(name = "createCryptoKeyVersion", impl = CreateCryptoKeyVersionCommand.class),
      @SubCommand(name = "listKeyRings", impl = ListKeyRingsCommand.class),
      @SubCommand(name = "listCryptoKeys", impl = ListCryptoKeysCommand.class),
      @SubCommand(name = "listCryptoKeyVersions", impl = ListCryptoKeyVersionsCommand.class),
      @SubCommand(name = "disableCryptoKeyVersion", impl = DisableCryptoKeyVersionCommand.class),
      @SubCommand(name = "enableCryptoKeyVersion", impl = EnableCryptoKeyVersionCommand.class),
      @SubCommand(name = "destroyCryptoKeyVersion", impl = DestroyCryptoKeyVersionCommand.class),
      @SubCommand(name = "restoreCryptoKeyVersion", impl = RestoreCryptoKeyVersionCommand.class),
      @SubCommand(name = "getKeyRingPolicy", impl = GetKeyRingPolicyCommand.class),
      @SubCommand(name = "getCryptoKeyPolicy", impl = GetCryptoKeyPolicyCommand.class),
      @SubCommand(name = "setPrimaryVersion", impl = SetPrimaryVersionCommand.class),
      @SubCommand(name = "addMemberToKeyRingPolicy", impl = AddMemberToKeyRingPolicyCommand.class),
      @SubCommand(name = "addMemberToCryptoKeyPolicy",
          impl = AddMemberToCryptoKeyPolicyCommand.class),
      @SubCommand(name = "removeMemberFromKeyRingPolicy",
          impl = RemoveMemberFromKeyRingPolicyCommand.class),
      @SubCommand(name = "removeMemberFromCryptoKeyPolicy",
          impl = RemoveMemberFromCryptoKeyPolicyCommand.class)
  })
  Command command;
}
