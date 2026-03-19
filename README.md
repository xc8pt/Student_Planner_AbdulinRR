# Лабораторная работа №15-16. Navigation in Jetpack Compose
Цель работы: Изучить принципы навигации в приложениях на Jetpack Compose с
использованием библиотеки Navigation Compose. Научиться создавать многоэкранные приложения,
передавать данные между экранами и управлять стеком навигации. Разработать приложение
"Студенческий планер" с несколькими экранами для демонстрации различных типов навигации.

 - Поспать
 - Поесть
 - [x] Выполнить работу по Android St

## Список реализованных экранов:
 - Экран "Мои дисциплины"
 - Экран "Детали дисциплины"
 - Экран "Настройки"
 - Экран "Профиль студента"

## Используемые технологии:
 - Kotlin Composable функция
```kotlin
@Composable
fun StudentPlannerNavHost()  
```
---
 - Jetpack Compose аннотация; Compose Modifier
```kotlin
@Composable  
`modifier: Modifier = Modifier`
```
---
 - Navigation Compose - Основной NavHost; Composable маршрут
```kotlin
NavHost(navController = navController)  

composable(route = Screen.Home.route)   

navController.navigate(Screen.Details.createRoute(subjectId))  

navArgument("subjectId") { type = NavType.StringType }
```

## Схему навигации между экранами
```mermaid
Home --> Details(subjectId) --> Back --> Home
Home --> Profile --> Back --> Home  
Home --> Settings --> Back --> Home
```
---
## Скриншоты основных экранов:
![Скриншот задания 1 ](/app/img/step7_navigation_working_AbdulinRR_1.png)
![Скриншот задания 2 ](/app/img/step7_navigation_working_AbdulinRR_2.png)
![Скриншот задания 3 ](/app/img/step7_navigation_working_AbdulinRR_3.png)
![Скриншот задания 4 ](/app/img/step7_navigation_working_AbdulinRR_4.png)

## Контрольные вопросы:

### Что такое NavController и для чего он используется?
 - NavController - диспетчер навигации, управляет стеком экранов.
 - Роль:
   - navigate() - переход вперед
   - popBackStack() — возврат назад
   - Хранит текущий стек и параметры маршрутов
 - Почему rememberNavController()?
Без remember контроллер пересоздается при каждом recompose -> стек навигации ломается. remember сохраняет один экземпляр.

### Как передать параметр в маршрут навигации?
 - Процесс:
   - Определить маршрут с шаблоном: "details/{subjectId}"
   - Передать параметр: navController.navigate("details/$subjectId")
   - Объявить аргумент в composable: navArgument("subjectId") { type = NavType.StringType }
   - Извлечь: backStackEntry.arguments?.getString("subjectId")
 - Обязательные vs Опциональные:
   - Обязательные: "details/{id}" — маршрут НЕ сработает без параметра
   - Опциональные: "details?id={id}" — маршрут работает и без параметра (id = null)
   
### Зачем использовать sealed class для маршрутов?
 - Преимущества:
   - Типобезопасность - компилятор проверяет все маршруты
   - Автодополнение в IDE
   - Exhaustive when - нельзя пропустить маршрут
   - Все маршруты в одном файле — полный обзор

 - Ошибка без sealed class:
```kotlin
//  Ошибка: опечатка в строке
navController.navigate("detials/$id")  // "detials" вместо "details"
```
---
```kotlin
//  Sealed class спасает
navController.navigate(Screen.Details.createRoute(id))  // Компилятор проверит!
```
Вывод: Sealed class превращает строковые маршруты в типобезопасную систему.

### Что такое Back Stack и как им управлять?
 - Back Stack - стек экранов LIFO (последний вошел, первый вышел).

 - Схема: Home -> Profile -> Settings
```mermaid
[Home] <- [Profile] <- [Settings]  <- вершина стека (текущий экран)
```
---
 - popBackStack() на Settings
```mermaid
[Home] <- [Profile] <- [Settings]
```
---
Результат: Settings удаляется, показывается Profile.

### Как работает startDestination в NavHost?
 - startDestination - первый экран при запуске приложения.
 - Работа:
   - NavHost загружает экран с startDestination = Screen.Home.route
   - В вашем коде это Home Screen
 - Первый экран: `Screen.Home.route` ("home")
 - Динамическое изменение: Нельзя. Фиксируется при создании NavHost. Для динамики используйте `navController.navigate()` после запуска.

### Что произойдёт, если навигировать на несуществующий маршрут?
 - Несуществующий маршрут → NavController игнорирует команду, ничего не происходит.

 - Обработка:
```mermaid
navController.navigate("fakeRoute")  // краш нет

Решения:
1. Sealed class - компилятор не даст ошибку
2. Проверка: navController.graph.findNode(route) != null
3. Catch: try { navigate() } catch (e: Exception) { showError() }
```
 - Лучший способ: sealed class Screen.

### Зачем нужен параметр launchSingleTop в навигации?
 - launchSingleTop - предотвращает дублирование экрана на вершине стека.

 - Проблема без него:
```mermaid
Home -> Profile -> Profile (клик повторно)
Стек: [Home] <- [Profile] <- [Profile]  // Два одинаковых!
```
---
 - С launchSingleTop = true:
```mermaid
Home -> Profile -> Profile (повторно)
Стек: [Home] <- [Profile]  // Один экземпляр + onNewIntent()
```
---
 - Влияние на Back Stack: Если экран уже на вершине - не добавляет новый, обновляет текущий.