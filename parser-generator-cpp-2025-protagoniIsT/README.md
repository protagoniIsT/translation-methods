# Генератор трансляторов

Текущий статус тестирования GitHub Actions: [![CI/CD](../../actions/workflows/classroom.yml/badge.svg?branch=main&event=workflow_dispatch)](../../actions/workflows/classroom.yml).

## Сборка и запуск

Для сборки вам понадобится

* CMake (версии 3.11 и выше);
* компилятор GNU GCC (версии 11 и выше) или LLVM Clang (версии 18 и выше);
* система сборки GNU make;
* [ANTLR](https://github.com/antlr/antlr4) (версии 4.13.0 и выше).

| Команда        | Комментарий                                         |
|:---------------|:----------------------------------------------------|
| `make antlr`   | Генерация классов по разработанной грамматике ANTLR |
| `make build`   | Сборка программы с заданными параметрами            |
| `make clean`   | Очистка от артефактов сборки программы              |
| `make rebuild` | См. `make clean`, `make antlr` и `make build`       |
| `make run`     | Запуск разработанного приложения-генератора         |

## Структура проекта

Ниже приведена интересующая вас структура проекта, исключая компоненты, предназначенные для корректной настройки проекта.

* [**`resources/Grammar.g4`**](./resources/Grammar.g4) - определение грамматики для разборщика грамматики, *не изменяйте название грамматики*.
* [**`app/`**](./app/) - приложение-генератор.
* [**`app/antlr/`**](./app/antlr/) - директория сгенерированных классов для разборщика грамматики (команда `make antlr`) по [разработанной грамматике](./resources/Grammar.g4).
* [**`resources/Calculator.grammar`**](./resources/Calculator.grammar) - определение грамматики калькулятора, *не изменяйте название файла*.
* [**`resources/RecursiveParsing.grammar`**](./resources/RecursiveParsing.grammar) - определение грамматики вашего варианта лабораторной работы №2, *не изменяйте название файла*.
* [**`resources/ANTLR.grammar`**](./resources/ANTLR.grammar) - определение грамматики вашего варианта лабораторной работы №3, *не изменяйте название файла*.

> [!NOTE]
> Значение `output_dir` во всех тестах - путь к директории [`out/`](./out/). *Не изменяйте* [`out/Makefile`](out/Makefile).

## Технические рекомендации

Чтобы не пришлось скачивать Jar'ник ANTLR, рекомендуется обратиться к [**Quick Start**](https://www.antlr.org/):

1. инициализируйте [виртуальную среду Python](https://docs.python.org/3/library/venv.html);
2. установите генератор ANTLR4:

    ```bash
    pip install antlr4-tools
    ```

Для быстрой и безболезненной установки библиотек рекомендуется обратиться к [**vcpkg**](https://github.com/microsoft/vcpkg):

1. установите `vcpkg`;
2. установите библиотеки:

    ```bash
    vcpkg install antlr4
    ```

3. команда `vcpkg integrate install` укажет на необходимый для [CMake toolchain-файл](https://cmake.org/cmake/help/latest/variable/CMAKE_TOOLCHAIN_FILE.html);
4. собрать проект с использованием `vcpkg`:

    ```bash
    # в данном случае путь - пример
    make CMAKE_TOOLCHAIN_FILE="/opt/vcpkg/scripts/buildsystems/vcpkg.cmake" build
    ```

При локальной разработке вы также можете изменять тип сборки и включать/выключать санитайзеры:

```bash
# сборка в Release, без санитайзеров
make CMAKE_BUILD_TYPE=Release BUILD_USE_SANITIZERS=OFF build

# сборка в Debug (по умолчанию), без санитайзеров
make BUILD_USE_SANITIZERS=ON build

# сборка в Debug (по умолчанию), с санитайзерами (по умолчанию)
make build
```
