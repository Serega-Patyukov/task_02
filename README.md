***
## Тестовое задание
```
        Задача 2
Имеется embedded реляционная база данных (h2, hsqldb, sqlite и т.д. - любая sql
embedded БД). Завести в БД таблицу данных о студентах, которая будет содержать:
имя, фамилия, отчество, дата рождения, группа, уникальный номер.
Реализовать консольный или графический пользовательский интерфейс, с помощью
которого можно: добавить студента, удалить студента по уникальному номеру,
вывести список студентов.

        Требования к выполненным заданиям:
  - Версия java любая из трех: 8, 11, 17
  - Код проекта присылать в любом виде: zip архив, ссылка на github, bitbucket и т.д.
  - Приложение не должно требовать для работы предварительного ручного выполнения sql
 скриптов, таблицы должны автоматически создаваться при запуске приложения.
  - После сборки проекта приложение должно быть готово для запуска одной командой
```
***
## Запуск
- Склонировать репозиторий, выполнив команду:   
  `git clone https://github.com/Serega-Patyukov/task_02.git`
- Перейти в корневую папку проекта и собрать проект:    
  `./mvnw clean package`
- Запустить:
  `./mvnw spring-boot:run`
***

## Endpoints

  `http://localhost:8080/`
***

## Примечания

`Задание выполненно на java 17.0.3.1`

`Для успешной сборки приложения на компьютере должна быть установленна java 17.0.3.1`
***