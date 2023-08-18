import view
import model
import text


def start():
    while True:
        choice = view.main_menu()
        match choice:
            case 1:
                # открыть файл
                model.open_nb()
                view.print_message(text.load_succesful)
            case 2:
                # записать файл
                model.save_nb()
                view.print_message(text.save_succesful)
            case 3:
                # показать заметки
                nb = model.get_nb()
                view.print_note(nb, text.load_error)
            case 4:
                # добавить заметки
                note = view.input_note(
                    text.new_note, text.cancel_input)
                name = model.add_note(note)
                view.print_message(text.new_note_succesful(name))
            case 5:
                # найти заметку
                nb = model.get_nb()
                fl = view.find_note(nb)
                view.print_note(fl, text.find_error)
            case 6:
                # изменить заметку
                nb = model.get_nb()
                index = view.input_index(
                    text.index_change_note, nb, text.load_error)
                change_note = view.input_note(
                    text.new_change_note, text.cancel_input)
                name = model.change_note(index, change_note)
                view.print_message(text.change_note(name))
            case 7:
                # удалить заметку
                nb = model.get_nb()
                index = view.input_index(
                    text.index_del_note, nb, text.load_error)
                name = model.del_note(index)
                view.print_message(text.del_note(name))
            case 8:
                # выход
                break
