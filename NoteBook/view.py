import text
from datetime import datetime, date, time


def main_menu() -> int:
    print(text.main_menu)
    while True:
        choice = input(text.input_choice)
        if choice.isdigit() and 0 < int(choice) < 9:
            return int(choice)


def print_message(message: str):
    print('\n' + '=' * len(message))
    print(message)
    print('=' * len(message) + '\n')


def print_note(nb: list[dict[str, str]], error: str):
    if nb:
        print('\n' + '=' * 72)
        for i, note in enumerate(nb, 1):
            print(
                f"{i :>3}. {note.get('name'):<20} | {note.get('comment'):<20} | {note.get('date'):<20}")
        print('=' * 72)
    else:
        print_message(error)


def find_note(nb: list[dict[str, str]]):
    find_list = []
    search_value = input(text.find_choice)
    for note in nb:
        for value in note.values():
            if search_value.lower() in value.lower():
                find_list.append(note)
    return find_list


def change_note(nb: list[dict[str, str]], index: int):
    pass


def input_note(message: str, cancel: str) -> dict:
    new_note = {}
    print(message)
    for key, value in text.input_note.items():
        new_date = datetime.now().strftime("%d-%m-%Y %H:%M:%S")
        data = input(value)
        new_note[key] = new_date
        if data:
            new_note[key] = data
        else:
            new_note[key] = new_date
            # print_message(cancel)
    return new_note


def input_index(message: str, nb: list, error: str) -> int:
    print_note(nb, error)
    while True:
        index = input(message)
        if index.isdigit() and 0 < int(index) < len(nb) + 1:
            return int(index)
