TARGET_NAME = main.exe
TARGET_SRCS := $(shell find . -type f | grep -E "(cpp|cc|cxx|c++|cppm|ixx)$$")

.PHONY: all build clean rebuild run
.SILENT: all build clean rebuild run
.ONESHELL:

all: rebuild run

build:
	c++ -std=c++23 -Wall -Wextra -Wpedantic -O0 -g -fsanitize=address,leak,undefined $(TARGET_SRCS) -o $(TARGET_NAME)

clean:
	rm -rf *.obj *.o *.exe

rebuild: clean build

run: $(TARGET_NAME)
	./$(TARGET_NAME)
