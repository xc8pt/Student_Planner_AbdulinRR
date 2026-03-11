package com.abdulin.studentplanner.data

import kotlinx.serialization.descriptors.SerialDescriptor

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
        description = "Разработка нативных Android-приложений с использованием Kotlin и современных компонентов Jetpack Compose. Изучение архитектурных паттернов MVVM," +
                "работы с локальными базами данных и сетевыми API."
    ), //1
    Subject(
        id = "3",
        name = "Системное программирование",
        professor = "Токаев Т.И.",
        credits = 75,
        currentGrade = "Хорошо",
        description = "Низкоуровневая разработка на языке Rust: " +
                "управление памятью без сборщика мусора, многопоточность," +
                " работа с операционной системой и создание высокопроизводительных системных компонентов."
    ), //2
    Subject(
        id = "2",
        name = "Разработка програмных модулей",
        professor = "Донскова Д.А.",
        credits = 80,
        currentGrade = "Хорошо",
        description = "Изучение програмных модулей на Visual Studio 2022, разработка програмных модулей, таких как: WPF, Console App, Windows Forms App. Подготовка к итоговому экзамену."
    ), //3
    Subject(
        id = "4",
        name = "Инструментальные средства разработки программного обеспечения",
        professor = "Леонтьев Д.А.",
        credits = 90,
        currentGrade = "Великолептно",
        description = "Изучение fullstack-разработки. Обучение писать background на языке html. Так же язык CSS для красоты и понятности сайта."
    ), //4
    Subject(
        id = "5",
        name = "Менеджмент в проффессиональной деятельности",
        professor = "Запорожская С.А.",
        credits = 50,
        currentGrade = "Пойдёт",
        description = "Обучение управленческим знаниям, или подчененьческим"
    ), //5
    Subject(
        id = "6",
        name = "Обеспечение качества функционирования компьютерных систем",
        professor = "Ушакова М.А.",
        credits = 100,
        currentGrade = "Красаучик!",
        description = "Обучение пользования ПО. Изучение проблем ПО. И многое другое с ПО..."
    ), //6
)