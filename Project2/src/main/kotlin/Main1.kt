fun main() {
    var choice: Int
    do {
        println("\nВыберите задачу (1-6) или 0 для выхода:")
        print("> ")
        choice = readLine()?.toIntOrNull() ?: -1

        when (choice) {
            1 -> task1()
            2 -> task2()
            3 -> task3()
            4 -> task4()
            5 -> task5()
            6 -> task6()
            0 -> println("Выход...")
            else -> println("Неверный выбор!")
        }
    } while (choice != 0)
}

fun task1() {
    println("Задача 1: Кодирование строки (RLE)")
    println("Введите строку для обработки:")

    while (true) {
        val input = readLine()
        if (input.isNullOrEmpty()) {
            println("Строка не может быть пустой! Повторите ввод:")
            continue
        }

        val result = buildString {
            var i = 0
            while (i < input.length) {
                val currentChar = input[i]
                var count = 1
                while (i + 1 < input.length && input[i + 1] == currentChar) {
                    count++
                    i++
                }
                append(currentChar)
                if (count > 1) append(count)
                i++
            }
        }
        println("Результат: $result")
        break
    }
}

fun task2() {
    println("Задача 2: Подсчет символов")
    println("Введите строку для анализа:")

    val input = readLine() ?: ""
    val frequencyMap = mutableMapOf<Char, Int>()

    for (char in input) {
        frequencyMap[char] = frequencyMap.getOrDefault(char, 0) + 1
    }

    // Сортировка символов в алфавитном порядке
    val sortedChars = frequencyMap.keys.sorted()

    for (char in sortedChars) {
        println("$char - ${frequencyMap[char]}")
    }
}

fun task3() {
    println("Задача 3: Перевод в двоичную систему")
    println("Введите натуральное число:")

    while (true) {
        val input = readLine()
        val number = input?.toIntOrNull()

        if (number == null || number < 1) {
            println("Некорректный ввод! Введите целое число больше 0:")
            continue
        }

        // Ручной перевод в двоичную систему
        var n = number
        val binary = buildString {
            if (n == 0) append("0")
            while (n > 0) {
                append((n % 2).toString())
                n /= 2
            }
        }.reversed()

        println("Результат: $binary")
        break
    }
}

fun task4() {
    println("Задача 4: Калькулятор")
    println("Введите выражение в формате: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ")

    while (true) {
        val input = readLine()?.split(" ") ?: emptyList()

        if (input.size != 3) {
            println("Неверный формат! Нужно ввести 3 значения через пробел:")
            continue
        }

        val a = input[0].toDoubleOrNull()
        val b = input[2].toDoubleOrNull()
        val op = input[1]

        if (a == null || b == null) {
            println("Ошибка в числах! Повторите ввод:")
            continue
        }

        val result = when (op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if (b != 0.0) a / b else null
            else -> null
        }

        if (result == null) {
            println("Недопустимая операция или деление на ноль! Повторите ввод:")
            continue
        }

        println("Результат: $result")
        break
    }
}

fun task5() {
    println("Задача 5: Поиск показателя степени")
    println("Введите n и x через пробел:")

    while (true) {
        val input = readLine()?.split(" ") ?: emptyList()

        if (input.size != 2) {
            println("Нужно ввести 2 числа! Повторите:")
            continue
        }

        val n = input[0].toIntOrNull()
        val x = input[1].toIntOrNull()

        if (n == null || x == null) {
            println("Ошибка в числах! Повторите:")
            continue
        }

        if (x == 0) {
            println("Основание не может быть 0!")
            continue
        }

        if (x == 1) {
            println("Целочисленный показатель не существует")
            continue
        }

        if (n == 1) {
            println("y = 0")
            continue
        }

        var y = 0
        var power = 1
        var found = false

        while (power <= n) {
            if (power == n) {
                println("y = $y")
                found = true
                break
            }
            y++
            power *= x
        }

        if (!found) {
            println("Целочисленный показатель не существует")
        }
        break
    }
}

fun task6() {
    println("Задача 6: Создание нечетного числа")
    println("Введите две разные цифры:")

    while (true) {
        val input1 = readLine()
        val input2 = readLine()

        if (input1 == null || input2 == null || input1.length != 1 || input2.length != 1) {
            println("Ошибка! Введите по одной цифре на каждой строке:")
            continue
        }

        val digit1 = input1[0].toString().toIntOrNull()
        val digit2 = input2[0].toString().toIntOrNull()

        if (digit1 == null || digit2 == null || digit1 !in 0..9 || digit2 !in 0..9) {
            println("Ошибка! Введите две цифры (0-9):")
            continue
        }

        if (digit1 == digit2) {
            println("Цифры должны быть разными! Повторите ввод:")
            continue
        }

        val num1 = digit1 * 10 + digit2
        val num2 = digit2 * 10 + digit1

        val oddNumbers = mutableListOf<Int>()
        if (num1 % 2 != 0) oddNumbers.add(num1)
        if (num2 % 2 != 0) oddNumbers.add(num2)

        if (oddNumbers.isEmpty()) {
            println("Создать нечетное число невозможно")
        } else {
            println("Результат: ${oddNumbers.max()}")
        }
        break
    }
}

