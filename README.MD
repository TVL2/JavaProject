## Разработка web-приложения "База данных"

### Задание 1

Реализуйте методы save, get, delete, clear, getAll, size в классе JavaProject.storage.ArrayStorage, организовав хранение резюме в массиве
Храните все резюме в начале storage (без пустот в виде null), чтобы не перебирать каждый раз все 10_000 элементов
При реализации метода delete учитывайте, что после удаления резюме между оставшимися резюме не должно быть пустых ячеек, заполненных null
Схема хранения резюме в массиве storage (в элементах от 0 до size-1 отсутствуют null):

- r1, r2, r3,..., rn, null, null,..., null
- <----- size ----->
- <------- storage.length (10000) ------->

Проверьте вашу реализацию с помощью классов MainArray.main() и MainTestArrayStorage.main()


### Задание 2

- Реализовать метод update в классе JavaProject.storage.ArrayStorage.
- в классе JavaProject.storage.ArrayStorage для методов update, save, delete реализовать проверку наличия резюме в  массиве storage.


### Задание 3
- добавить методы equals,hashcode, setUuid в класс JavaProject.model.Resume
- создать интерфейс Storage;
- создать классы AbstractArrayStorage, SortedArrayStorage.

### Задание 4
- добавить exeptions
- добавить юнит-тесты

### Задание 5
 - Выделить общий класс AbstractStorage и реализовать подкласс ListStorage. 
 - сделать класс для тестирования ListStorage

### Задание 6
 - метод saveOverflow() должен исполняться только для массивов
 - в конструктор Resume добавить второй параметр — fullName
 - во всех реализациях Storage заменить метод Resume[] getAll() на List<Resume> getAllSorted()
 - Реализовать MapUuidStorage