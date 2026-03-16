package com.abdulin.student_planner.data

data class Subject(
    val id: String,
    val name: String,
    val professor: String,
    val credits: Int,
    val currentGrade: String,
    val description: String
)

val sampleSubject = listOf(
    Subject(
        id = "1",
        name = "Разработка мобильных приложений",
        professor = "Леонтьев Д.А.",
        credits = 91,
        currentGrade = "Отлично",
        description = "Разработка нативных Android-приложений с использованием Kotlin и " +
                "современных компонентов Jetpack Compose. Изучение архитектурных паттернов MVVM, " +
                "работы с локальными базами данных и сетевыми API."
    ), //1
    Subject(
        id = "2",
        name = "Разработка програмных модулей",
        professor = "Донскова Д.А.",
        credits = 70,
        currentGrade = "Пойдет",
        description = "Разработка програмных модулей на языке c#. Работа с WPF и Windows Form."
    ), //2
    Subject(
        id = "3",
        name = "Системное программирование",
        professor = "Токаев Т.И.",
        credits = 75,
        currentGrade = "Хорошо",
        description = "Низкоуровневая разработка на языке Rust: управление памятью без сборщика мусора," +
                " многопоточность, работа с операционной системой и " +
                "создание высокопроизводительных системных компонентов."
    ), //3
    Subject(
        id = "4",
        name = "Инструментальные средства разработки программного обеспечения",
        professor = "Леонтьев Д.А.",
        credits = 92,
        currentGrade = "Красаучик!",
        description = "Обучение fullstack-разработки. Изучение HTML и CSS языков."
    ), //4
    Subject(
        id = "5",
        name = "Управление проектами",
        professor = "Трошина О.В.",
        credits = 61,
        currentGrade = "Пойдет",
        description = "Изучение структуры проектной деятельности."
    ), //5
    Subject(
        id = "6",
        name = "Математическое моделирование",
        professor = "Трошина О.В.",
        credits = 70,
        currentGrade = "Пойдет",
        description = "Обучение решению задач по менеджменту."
    ), //6
)