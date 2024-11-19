import unittest

# Unit tests for split_release_note.py

from split_release_note import LibraryModule, create_changelog_entry, group_changes_by_api, ChangesOnApi
from pathlib import Path

dummy_module = LibraryModule(
    Path('release-note-generation/test/java-analyics-admin'),
    'foo-api', '1.2.3',
    Path('release-note-generation/test/java-analyics-admin/CHANGELOG.md'))


class TestCase(unittest.TestCase):

    def test_create_changelog_entry(self):
        changes = ChangesOnApi(
            features=['Add support for disabling Pod overprovisioning',
                      'Enhanced query generation performance'],
            dependency_upgrades=[
                'update google-cloud-shared-dependencies to 1.2.3']
        )
        entry = create_changelog_entry(
            '2023-06-10',
            dummy_module,
            changes
        )
        self.assertEqual(entry, f'''## 1.2.3 (2023-06-10)

### Features

* Add support for disabling Pod overprovisioning
* Enhanced query generation performance

### Dependencies

* update google-cloud-shared-dependencies to 1.2.3
''')

    def test_create_changelog_entry_only_deps(self):
        dep_changes = ChangesOnApi(
            dependency_upgrades=[
                'update dependency com.google.cloud:sdk-platform-java-config to 1.2.3']
        )
        entry = create_changelog_entry(
            '2023-06-10',
            dummy_module,
            dep_changes,
        )
        self.assertEqual(entry, f'''## 1.2.3 (2023-06-10)

### Dependencies

* update dependency com.google.cloud:sdk-platform-java-config to 1.2.3
''')

    def test_create_changelog_entry_empty(self):
        empty_changes = ChangesOnApi()
        entry = create_changelog_entry(
            '2023-06-10',
            dummy_module,
            empty_changes
        )
        self.assertEqual(entry, f'''## 1.2.3 (2023-06-10)

* No change
''')

    def test_group_changes_by_api(self):
        main_changes = [
            '# Features',
            '* [foo-api] This is Change A',
            '* [bar-api] This is Change B'
        ]
        changes_by_api = group_changes_by_api(main_changes)
        self.assertEqual(set(changes_by_api.keys()),
                         {'foo-api', 'bar-api'})
        self.assertEqual(changes_by_api['bar-api'],
                         ChangesOnApi(features=['This is Change B']))
        self.assertEqual(changes_by_api.get('nonexistent',
                                     ['No change']),
                         ['No change'])


if __name__ == "__main__":
    unittest.main()
