# Copyright 2024 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
import difflib
import json
import os
import sys
import unittest
import xml.etree.ElementTree as tree
from collections import Counter
from filecmp import dircmp

script_dir = os.path.dirname(os.path.realpath(__file__))


class IntegrationTest(unittest.TestCase):

    def test_monorepo_generation(self):
        repo_dest = "/workspace/google-cloud-java"
        golden_dir = "/workspace/golden"
        library_names = [
            "java-apigee-connect",
            "java-alloydb",
            "java-alloydb-connectors",
            "java-cloudcontrolspartner",
        ]
        for library_name in library_names:
            actual_library = f"{repo_dest}/{library_name}"
            print("*" * 50)
            print(f"Checking for differences in '{library_name}'.")
            print(f"  The expected library is in {golden_dir}/{library_name}.")
            print(f"  The actual library is in {actual_library}.")
            compare_result = dircmp(
                f"{golden_dir}/{library_name}",
                actual_library,
                # README.md is ignored because the golden files in the 
                # google-cloud-java repository still contain the old build badges.
                # TODO: Remove README.md from ignore list once golden files are updated.
                ignore=[".repo-metadata.json", "README.md"],
            )
            diff_files = []
            golden_only = []
            generated_only = []
            # compare source code
            self.__recursive_diff_files(
                compare_result, diff_files, golden_only, generated_only
            )

            # print all found differences for inspection
            def print_file(f: str) -> None:
                return print(f"   -  {f}")

            if len(diff_files) > 0:
                print("  Some files (found in both folders) are differing:")
                for diff_file in diff_files:
                    print(f"Difference in {diff_file}:")
                    with open(
                        f"{golden_dir}/{library_name}/{diff_file}"
                    ) as expected_file:
                        with open(f"{actual_library}/{diff_file}") as actual_file:
                            [
                                print(line)
                                for line in difflib.unified_diff(
                                    expected_file.readlines(),
                                    actual_file.readlines(),
                                )
                            ]
            if len(golden_only) > 0:
                print("  There were files found only in the golden dir:")
                [print_file(f) for f in golden_only]
            if len(generated_only) > 0:
                print("  There were files found only in the generated dir:")
                [print_file(f) for f in generated_only]

            self.assertTrue(len(golden_only) == 0)
            self.assertTrue(len(generated_only) == 0)
            self.assertTrue(len(diff_files) == 0)

            print(f"  No differences found in {library_name}")
            # compare .repo-metadata.json
            self.assertTrue(
                self.__compare_json_files(
                    f"{golden_dir}/{library_name}/.repo-metadata.json",
                    f"{actual_library}/.repo-metadata.json",
                ),
                msg=f"  The generated {library_name}/.repo-metadata.json is different from golden.",
            )
            print("  .repo-metadata.json comparison succeed.")
            # compare gapic-libraries-bom/pom.xml and pom.xml
            self.assertFalse(
                self.compare_xml(
                    f"{golden_dir}/gapic-libraries-bom/pom.xml",
                    f"{repo_dest}/gapic-libraries-bom/pom.xml",
                    False,
                )
            )
            print("  gapic-libraries-bom/pom.xml comparison succeed.")
            self.assertFalse(
                self.compare_xml(
                    f"{golden_dir}/pom.xml",
                    f"{repo_dest}/pom.xml",
                    False,
                )
            )
            print("  pom.xml comparison succeed.")

    @classmethod
    def __compare_json_files(cls, expected: str, actual: str) -> bool:
        return cls.__load_json_to_sorted_list(
            expected
        ) == cls.__load_json_to_sorted_list(actual)

    @classmethod
    def __load_json_to_sorted_list(cls, path: str) -> list[tuple]:
        with open(path) as f:
            data = json.load(f)
        res = [(key, value) for key, value in data.items()]

        return sorted(res, key=lambda x: x[0])

    @classmethod
    def __recursive_diff_files(
        cls,
        dcmp: dircmp,
        diff_files: list[str],
        left_only: list[str],
        right_only: list[str],
        dirname: str = "",
    ):
        """
        Recursively compares two subdirectories. The found differences are
        passed to three expected list references.
        """

        def append_dirname(d: str) -> str:
            return dirname + d

        diff_files.extend(map(append_dirname, dcmp.diff_files))
        left_only.extend(map(append_dirname, dcmp.left_only))
        right_only.extend(map(append_dirname, dcmp.right_only))
        for sub_dirname, sub_dcmp in dcmp.subdirs.items():
            cls.__recursive_diff_files(
                sub_dcmp, diff_files, left_only, right_only, dirname + sub_dirname + "/"
            )

    @classmethod
    def compare_xml(cls, expected, actual, print_trees):
        """
        compares two XMLs for content differences
        the argument print_whole_trees determines if both trees should be printed
        """
        try:
            expected_tree = tree.parse(expected)
            actual_tree = tree.parse(actual)
        except tree.ParseError as e:
            cls.eprint(f"Error parsing XML")
            raise e
        except FileNotFoundError as e:
            cls.eprint(f"Error reading file")
            raise e

        expected_elements = []
        actual_elements = []

        cls.append_to_element_list(expected_tree.getroot(), "/", expected_elements)
        cls.append_to_element_list(actual_tree.getroot(), "/", actual_elements)

        expected_counter = Counter(expected_elements)
        actual_counter = Counter(actual_elements)
        intersection = expected_counter & actual_counter
        only_in_expected = expected_counter - intersection
        only_in_actual = actual_counter - intersection
        if print_trees:
            cls.eprint("expected")
            cls.print_counter(actual_counter)
            cls.eprint("actual")
            cls.print_counter(expected_counter)
        if len(only_in_expected) > 0 or len(only_in_actual) > 0:
            cls.eprint("only in " + expected)
            cls.print_counter(only_in_expected)
            cls.eprint("only in " + actual)
            cls.print_counter(only_in_actual)
            return True
        return False

    @classmethod
    def append_to_element_list(cls, node, path, elements):
        """
        Recursively traverses a node tree and appends element text to a given
        `elements` array. If the element tag is `dependency`
        then the maven coordinates for its children will be computed as well
        """
        namespace_start, namespace_end, tag_name = node.tag.rpartition("}")
        namespace = namespace_start + namespace_end
        if tag_name == "dependency":
            group_id = cls.get_text_from_element(node, "groupId", namespace)
            artifact_id = cls.get_text_from_element(node, "artifactId", namespace)
            artifact_str = ""
            artifact_str += group_id
            artifact_str += ":" + artifact_id
            elements.append(path + "/" + tag_name + "=" + artifact_str)
        if node.text and len(node.text.strip()) > 0:
            elements.append(path + "/" + tag_name + "=" + node.text)

        if tag_name == "version":
            # versions may be yet to be processed, we disregard them
            return elements

        for child in node:
            child_path = path + "/" + tag_name
            cls.append_to_element_list(child, child_path, elements)

        return elements

    @classmethod
    def get_text_from_element(cls, node, element_name, namespace):
        """
        Convenience method to access a node's child elements via path and get
        its text.
        """
        child = node.find(namespace + element_name)
        return child.text if child is not None else ""

    @classmethod
    def eprint(cls, *args, **kwargs):
        """
        prints to stderr
        """
        print(*args, file=sys.stderr, **kwargs)

    @classmethod
    def print_counter(cls, counter):
        """
        Convenience method to pretty print the contents of a Counter (or dict)
        """
        for key, value in counter.items():
            cls.eprint(f"{key}: {value}")
