# Diplom_3

##Учебный проект от Яндекс Практикума
##10 Спринт - Тестирование Веб приложения

## Запуск тестов
Запустить все тесты
> mvn clean test

Выбор браузера (по умолчанию chrome)
> mvn clean test -Dbrowser=firefox

Запустить тесты определенного класса
> mvn clean test -Dtest=RegistrationTest

Запустить конкретный тест
> mvn clean test -Dtest=RegistrationTest#successRegistrationTest

Запустить тест + сгенерировать отчет
> mvn clean test -Dtest=RegistrationTest#successRegistrationTest allure:report

Запустить тест + сгенерировать и захостить отчет
> mvn clean test -Dtest=RegistrationTest#successRegistrationTest allure:serve

## Используемый стек
| Инструмент  | Версия |
| ------------- | ------------- |
| Java  | 11  |
| Web Driver manager  | 5.5.2  |
| Selenide  | 5.4.0  |
| Rest Assured  | 5.4.0  |
| JUnit  |  5.9.1|
| Allure  | 2.13.1|
| Owner  | 1.0.2  |
| Faker  | 1.0.2  |
| Lombok  | 1.18.28  |
| Maven surefire plugin  | 3.0.0-M4 |