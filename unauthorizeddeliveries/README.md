# Unauthorized Deliveries Service

## Описание

В сам postings.cvs файл ничего не добавлялось, а только в бд

## Технологии

- Java 21
- Spring Boot 3.5.4
- PostgreSQL 16
- Hibernate 6.6
- OpenCSV 5.9
- Maven

## Требования

- JDK 21+
- PostgreSQL 14+
- Maven 3.9+

## Установка и настройка

### 1. Настройка базы данных

```bash
# Создание БД
sudo -u postgres psql -c "CREATE DATABASE unauthorized_deliveries;"

# Установка пароля для пользователя postgres
sudo -u postgres psql -c "ALTER USER postgres WITH PASSWORD '12345';"
```

### 2. Запуск приложения

```bash
mvn clean install
mvn spring-boot:run
```

## API Endpoints

### Получение поставок

**GET** `/api/postings`

Параметры:
- `startDate` - начальная дата (формат: `DD-MM-YYYY`)
- `endDate` - конечная дата (формат: `DD-MM-YYYY`)
- `isAuthorized` - фильтр по авторизации (`true`/`false`)

Примеры:
- За июль 2020 (неавторизованные): `GET http://localhost:8080/api/postings?startDate=2020-07-01&endDate=2020-07-31`
- За июль авторизованные: `GET http://localhost:8080/api/postings?startDate=2020-07-01&endDate=2020-07-31&isAuthorized=true`

## Структура данных

### Таблица `logins`
| Поле            | Тип       | Описание                |
|-----------------|-----------|-------------------------|
| id              | BIGINT    | Первичный ключ          |
| application     | VARCHAR   | Приложение              |
| app_account_name| VARCHAR   | Уникальное имя аккаунта |
| is_active       | BOOLEAN   | Активен ли пользователь |
| job_title       | VARCHAR   | Должность               |
| department      | VARCHAR   | Отдел                   |

### Таблица `postings`
| Поле                | Тип       | Описание                     |
|---------------------|-----------|------------------------------|
| id                  | BIGINT    | Первичный ключ               |
| mat_doc             | VARCHAR   | Номер поставки               |
| item                | INTEGER   | Номер товара в поставке      |
| doc_date            | DATE      | Дата договора                |
| pstng_date          | DATE      | Дата поставки                |
| material_description| VARCHAR   | Описание материала           |
| quantity            | DOUBLE    | Количество                   |
| bun                 | VARCHAR   | Единица измерения            |
| amount_lc           | DOUBLE    | Стоимость в валюте           |
| crcy                | VARCHAR   | Валюта                       |
| user_name           | VARCHAR   | Пользователь                 |
| is_authorized       | BOOLEAN   | Авторизована ли поставка     |



## Изменения
В logins.csv была добалена строчка 'SAP,NLIMONOV,True,Заведующий складом,Группа складского хозяйства'


## Пример вывода

1) бд для logins
![alt text](<Screenshot from 2025-08-10 23-51-41.png>)


2) бд для postings (добавлялись только те, где quantity >= 0)
![alt text](<Screenshot from 2025-08-11 00-07-37.png>)

3) Для 'http://localhost:8080/api/postings?startDate=2020-07-01&endDate=2020-07-31&isAuthorized=false'
![alt text](<Screenshot from 2025-08-10 23-46-48.png>)
