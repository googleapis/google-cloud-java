# Script to split a main release note into CHANGELOG.md in each module.

# 1st argument: the path to a file that contains the main changelog. You can get
#     the body of a pull request via `gh pr view
#     https://github.com/googleapis/google-cloud-java/pull/9502 --json body
#     --jq '.body'`
# 2nd argument: the path to a directory that whose child directories contain
#     ".OwlBot.yaml", "pom.xml", and "CHANGELOG.md". It's the root directory
#     of the google-cloud-java repository.
# Example:
#   google-cloud-java$ python3 split_release_note.py main_changelog.txt .
# where the last "." indicates the root of the repository copy.

import sys
import re
from collections import defaultdict
from pathlib import Path
import xml.etree.ElementTree as ET


class LibraryModule:
    def __init__(self, path: Path, api_name: str, version: str,
        changelog: Path):
        self.path = path
        self.api_name = api_name
        self.version = version
        self.changelog = changelog

    def __str__(self):
        return f"LibraryModule({self.path}, {self.api_name}, {self.version}, {self.changelog})"

    def __repr__(self):
        return f"LibraryModule({self.path}, {self.api_name}, {self.version}, {self.changelog})"


POM_NAMESPACES = {'mvn': 'http://maven.apache.org/POM/4.0.0'}


# Returns the list of target modules that has CHANGELOG.md
def detect_modules(root_directory: Path):
    modules = []
    for owlbot_yaml_path in root_directory.rglob('*/.OwlBot.yaml'):

        # This CHANGELOG.md might not exist for newly created libraries
        changelog = owlbot_yaml_path.parent / 'CHANGELOG.md'

        module_pom_xml = owlbot_yaml_path.parent / 'pom.xml'
        if not module_pom_xml.exists():
            continue
        tree = ET.parse(module_pom_xml)
        root = tree.getroot()
        version = root.find('mvn:version', POM_NAMESPACES).text

        with open(owlbot_yaml_path, 'r') as file:
            owlbot_yaml_content = file.read()
            match = re.search(r'api-name: (.+)', owlbot_yaml_content)
            if match:
                api_name = match.group(1)
                modules.append(LibraryModule(owlbot_yaml_path, api_name,
                                             version,
                                             changelog))
    return modules


# Returns the dictionary from api name to a list of changelogs
def group_changes_by_api(main_changes: [str]):
    api_to_changelog = defaultdict(list)
    for changelog in main_changes:
        match = re.search(r'\* \[(.+?)] (.+)', changelog)
        if match:
            api_name = match.group(1)
            note = match.group(2)
            api_to_changelog[api_name].append(note)
    return api_to_changelog


CHANGELOG_HEADER_MARK = '# Changelog'


def create_changelog_entry(current_date: str, module: LibraryModule,
    changelog_lines: [str]):
    changelog_entry = f'## {module.version} ({current_date})' \
                      f'\n\n### Features\n\n'
    for line in changelog_lines:
        changelog_entry += f'* {line}\n'
    return changelog_entry


def write_changelog(current_date: str, module: LibraryModule,
    changelog_entries: [str]):
    changelog_file = module.changelog
    if changelog_file.exists():
        with open(changelog_file, 'r') as file:
            changelog_content = file.read()
    else:
        changelog_content = CHANGELOG_HEADER_MARK

    # Avoid adding the same version twice
    if re.search(f'## {module.version}', changelog_content):
        return

    entry = create_changelog_entry(current_date, module, changelog_entries)
    replaced = changelog_content.replace(CHANGELOG_HEADER_MARK,
                                         f'{CHANGELOG_HEADER_MARK}'
                                         f'\n\n{entry}')
    with open(module.changelog, 'w') as file:
        file.write(replaced)


def main():
    if len(sys.argv) != 3:
        print("Please specify main changelog file and path to the repository "
              "root")
        sys.exit(1)

    # Step 1: Reads the main changelog from standard input
    main_changes = []
    main_release_note_file = sys.argv[1]
    current_date = None
    with open(main_release_note_file, 'r') as file:
        for line in file:
            main_changes.append(line.strip())
            if not current_date:
                match = re.search(r'## .* \((\d\d\d\d-\d\d-\d\d)\)', line)
                if match:
                    current_date = match.group(1)

    # Step 2: Detects target modules by .OwlBot.yaml for api-name: field.
    root_directory = sys.argv[2]
    modules = detect_modules(Path(root_directory))
    api_to_modules = {module.api_name: module for module in modules}

    # Step 3: Splits the changelog to ~100 modules
    api_to_changelog_entries = group_changes_by_api(main_changes)

    # Step 4: Writes the changelog entry to the CHANGELOG.md files in the
    # modules
    for module in modules:
        changelog_entries = api_to_changelog_entries.get(module.api_name,
                                                         ['No change'])
        write_changelog(current_date, module, changelog_entries)


if __name__ == '__main__':
    main()
