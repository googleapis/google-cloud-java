"""
Utility to compare the contents of two XML files.
This focuses on the tree structure of both XML files, meaning that element order and whitespace will be disregarded.
The only comparison points are: element path (e.g. project/dependencies) and element text
There is a special case for `dependency`, where the maven coordinates are prepared as well
"""

from library_generation.utils.utilities import eprint
import xml.etree.ElementTree as et
from collections import Counter
import sys
import os

current = os.path.dirname(os.path.realpath(__file__))
parent = os.path.dirname(current)
sys.path.append(parent)


def get_text_from_element(node, element_name, namespace):
    """
    Convenience method to access a node's child elements via path and get
    its text.
    """
    child = node.find(namespace + element_name)
    return child.text if child is not None else ""


def print_counter(counter):
    """
    Convenience method to pretty print the contents of a Counter (or dict)
    """
    for key, value in counter.items():
        eprint(f"{key}: {value}")


def append_to_element_list(node, path, elements):
    """
    Recursively traverses a node tree and appends element text to a given
    `elements` array. If the element tag is `dependency`
    then the maven coordinates for its children will be computed as well
    """
    namespace_start, namespace_end, tag_name = node.tag.rpartition("}")
    namespace = namespace_start + namespace_end
    if tag_name == "dependency":
        group_id = get_text_from_element(node, "groupId", namespace)
        artifact_id = get_text_from_element(node, "artifactId", namespace)
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
        append_to_element_list(child, child_path, elements)

    return elements


def compare_xml(expected, actual, print_trees):
    """
    compares two XMLs for content differences
    the argument print_whole_trees determines if both trees should be printed
    """
    try:
        expected_tree = et.parse(expected)
        actual_tree = et.parse(actual)
    except et.ParseError as e:
        eprint(f"Error parsing XML")
        raise e
    except FileNotFoundError as e:
        eprint(f"Error reading file")
        raise e

    expected_elements = []
    actual_elements = []

    append_to_element_list(expected_tree.getroot(), "/", expected_elements)
    append_to_element_list(actual_tree.getroot(), "/", actual_elements)

    expected_counter = Counter(expected_elements)
    actual_counter = Counter(actual_elements)
    intersection = expected_counter & actual_counter
    only_in_expected = expected_counter - intersection
    only_in_actual = actual_counter - intersection
    if print_trees:
        eprint("expected")
        print_counter(actual_counter)
        eprint("actual")
        print_counter(expected_counter)
    if len(only_in_expected) > 0 or len(only_in_actual) > 0:
        eprint("only in " + expected)
        print_counter(only_in_expected)
        eprint("only in " + actual)
        print_counter(only_in_actual)
        return True
    return False


def compare_pom_in_subdir(base_dir: str, subdir: str) -> bool:
    golden = os.path.join(base_dir, subdir, "pom-golden.xml")
    pom = os.path.join(base_dir, subdir, "pom.xml")
    return compare_xml(
        golden,
        pom,
        False,
    )


if __name__ == "__main__":
    if len(sys.argv) != 4:
        eprint(
            "Usage: python compare_xml.py <file1> <file2> <print_whole_trees(true|false)>"
        )
        sys.exit(1)

    file1 = sys.argv[1]
    file2 = sys.argv[2]
    print_whole_trees = sys.argv[3]
    has_diff = compare_xml(file1, file2, print_whole_trees)

    if has_diff:
        eprint(f"The poms are different")
        sys.exit(1)
    eprint("The XML files are the same.")
    sys.exit(0)
