## ResponseBodyIssue: Java библиотека стандартизированных HTTP ответов.
***
[![license](https://img.shields.io/badge/license-MIT-blue)](LICENSE)

## Описание
***

Библиотека ResponseBodyIssue содержит DTO-классы для HTTP-ответов с кодами 4xx.
Библиотека предоставляет единый формат тела ответа 
для серверных архитектур на основе микросервисов.
Она позволяет сервисам использовать единообразный контракт ошибок, 
не раскрывая детали внутренней реализации, такие как 
классы сервисов, исключения, внутренняя архитектура или используемые фреймворки.

## Содержание
***

- [Начало работы](#начало-работы)
- [Использование](#использование)
- [Внутренняя структура](#внутренняя-структура)
- [Лицензия](#лицензия)

## Начало работы
***

Чтобы собрать проект и установить его в локальный репозиторий Maven, 
выполните следующую команду в корневом каталоге проекта:

```bash
mvn clean install
```

Чтобы добавить ResponseBodyIssue в качестве зависимости Maven, 
добавьте следующий код в файл pom.xml:

```xml
<dependency>
    <groupId>ru.reel</groupId>  
    <artifactId>response-body-issue</artifactId>
    <version>1.1</version>
</dependency>
```

## Использование
***

1. Простой пример создания сущности `RequestError` без параметров для сообщения:
```java
import ru.reel.request.error.RequestError;
import ru.reel.request.error.reason.ErrorReason;

RequestError.builder()
            .errorReason(ErrorReason.JSON_FORMAT)
            .message()
            .build();
```

Результат в формате JSON:

```json
{
  "errorReason" : "JSON_FORMAT",
  "message" : "Invalid JSON format."
}
```

2. Пример создания сущности `RequestError` с одним параметром 
для стандартизированного сообщения, сгенерированного с помощью `ErrorMessageFactory`:
```java
import ru.reel.request.error.RequestError;
import ru.reel.request.error.reason.ErrorReason;

RequestError.builder()
            .errorReason(ErrorReason.EMPTY)
            .message("field_name") // %s is empty or null.
            .build();
```

Результат в формате JSON:

```json
{
  "errorReason" : "EMPTY",
  "message" : "field_name is empty or null."
}
```

3. Пример создания сущности `RequestFieldError` с несколькими параметрами 
для стандартизированного сообщения, сгенерированного с помощью `ErrorMessageFactory`:
```java
import ru.reel.request.error.RequestFieldError;
import ru.reel.request.error.reason.ErrorReason;

RequestFieldError.builder()
            .field("password")
            .errorReason(ErrorReason.LESS_SIZE)
            .message("password", "6") // %s cannot be less than %s.
            .build();
```

Результат в формате JSON:

```json
{
  "field" : "password",
  "errorReason" : "LESS_SIZE",
  "message" : "password cannot be less than 6."
}
```

Чтобы
Чтобы определить количество параметров, 
необходимых для стандартизированного сообщения, 
обратитесь к документации JavaDoc класса ErrorMessageFactory.

## Внутренняя структура
***

- **Issue** - содержит базовый абстрактный DTO-класс для описания проблемы запроса.
- **Error** - содержит DTO-классы для HTTP-ответов с кодом 4xx.
    - **Reason** - содержит перечисление, определяющее причины ответов с кодом 4xx.
    - **Message** - содержит класс-фабрику для создания стандартизированных сообщений об ошибках.

## Лицензия
***

Этот проект распространяется на условиях лицензии MIT.