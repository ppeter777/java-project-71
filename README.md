### Hexlet tests and linter status:

[![Actions Status](https://github.com/ppeter777/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/ppeter777/java-project-71/actions)

[![Github Actions](https://github.com/ppeter777/java-project-71/actions/workflows/my_workflow.yml/badge.svg)](https://github.com/ppeter777/java-project-71/actions/workflows/my_workflow.yml)

<a href="https://codeclimate.com/github/ppeter777/java-project-71/maintainability"><img src="https://api.codeclimate.com/v1/badges/06476602d8f5343b1456/maintainability" /></a>

<a href="https://codeclimate.com/github/ppeter777/java-project-71/test_coverage"><img src="https://api.codeclimate.com/v1/badges/06476602d8f5343b1456/test_coverage" /></a> 

### Описание

Вычислитель отличий – программа, определяющая разницу между двумя структурами данных.  
Это популярная задача, для решения которой существует множество онлайн-сервисов, например: http://www.jsondiff.com/.  
Подобный механизм используется при выводе тестов или при автоматическом отслеживании изменении в конфигурационных файлах.

### Возможности утилиты:

Поддержка разных входных форматов: yaml и json  
Генерация отчета в виде plain text, stylish и json

### Установка

    git clone git@github.com:ppeter777/java-project-71.git
    cd java-project-71/app
    make install

### Запуск

Сравнение файлов JSON:

    ./build/install/app/bin/app filepath1.json filepath2.json

Сравнение файлов yaml:

    ./build/install/app/bin/app filepath1.yaml filepath2.yaml
  
### Формат отчета

По умолчанию вывод результата сравнения производится в формате stylish.

Вывод результата сравнения в формате plain:

    ./build/install/app/bin/app -f plain filepath1 filepath2  

Вывод результата сравнения в формате json:

    ./build/install/app/bin/app -f json filepath1 filepath2
    
### Вызов справки

    ./build/install/app/bin/app -h

### Примеры работы

Сравнение плоских файлов (JSON):  
https://asciinema.org/a/jQkaVWfDj2EzOWWXKHEh8HMs9

Сравнение плоских файлов (yaml):  
https://asciinema.org/a/yFLcW3B7UngZOlq4qUMp9Fc0h

Сравнение файлов, имеющих вложенные структуры (JSON):  
https://asciinema.org/a/tLoqIe46XJgfdmEQbQyyyDT26

Сравнение файлов, имеющих вложенные структуры (yaml):  
https://asciinema.org/a/7J6O8BrMYSfcGQfBsKDihqyXG

Вывод результата сравнения в формате plain:  
https://asciinema.org/a/4A8L3xcV9mugWPBgIkYPzfehl

Вывод результата сравнения в формате json:  
https://asciinema.org/a/CYrNoCiBBQIvLOBb5dsXAh26v


