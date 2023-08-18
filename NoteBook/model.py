note_book: list[dict[str, str]] = []

path = 'notebook.txt'


def open_nb():
    global note_book, path
    with open(path, 'r', encoding='UTF-8') as file:
        data = file.readlines()
    for note in data:
        note = note.strip().split(';')
        note_book.append(
            {'name': note[0], 'comment': note[1], 'date': note[2]})


def save_nb():
    global note_book, path
    data = []
    for note in note_book:
        note = ';'.join([value for value in note.values()])
        data.append(note)
    with open(path, 'w', encoding='UTF-8') as file:
        file.write('\n'.join(data))


def get_nb() -> list[dict[str, str]]:
    global note_book
    return note_book


def add_note(note: dict[str, str]):
    global note_book
    note_book.append(note)
    return note.get('name')


def change_note(index: int, new_note):
    note_book.insert(index-1, new_note)
    return note_book.pop(index).get('name')


def del_note(index: int):
    return note_book.pop(index-1).get('name')
