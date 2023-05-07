<p align = "center">МИНИСТЕРСТВО НАУКИ И ВЫСШЕГО ОБРАЗОВАНИЯ<br>
РОССИЙСКОЙ ФЕДЕРАЦИИ<br>
ФЕДЕРАЛЬНОЕ ГОСУДАРСТВЕННОЕ БЮДЖЕТНОЕ<br>
ОБРАЗОВАТЕЛЬНОЕ УЧРЕЖДЕНИЕ ВЫСШЕГО ОБРАЗОВАНИЯ<br>
«САХАЛИНСКИЙ ГОСУДАРСТВЕННЫЙ УНИВЕРСИТЕТ»</p>
<br><br><br><br><br><br>
<p align = "center">Институт естественных наук и техносферной безопасности<br>Кафедра информатики<br>Сунагатов Денис Ринатович</p>
<br><br><br>
<p align = "center">Лабораторная работа №2<br><strong>"https://github.com/flysand7/android-dev-lab2.git"</strong><br>01.03.02 Прикладная математика и информатика</p>
<br><br><br><br><br><br><br><br><br><br><br><br>
<p align = "right">Научный руководитель<br>
Соболев Евгений Игоревич</p>
<br><br><br>
<p align = "center">г. Южно-Сахалинск<br>2022 г.</p>
<br><br><br><br><br><br><br><br><br><br><br><br>

<h1 align = "center">Введение</h1>

<p><b>Android Studio</b> — интегрированная среда разработки (IDE) для работы с платформой Android, анонсированная 16 мая 2013 года на конференции Google I/O. В последней версии Android Studio поддерживается Android 4.1 и выше.</p>
<p><b>Kotlin</b> — это кроссплатформенный статически типизированный язык программирования общего назначения высокого уровня. Kotlin предназначен для полного взаимодействия с Java, а версия стандартной библиотеки Kotlin для JVM зависит от библиотеки классов Java, но вывод типов позволяет сделать ее синтаксис более кратким. Kotlin в основном нацелен на JVM, но также компилируется в JavaScript (например, для интерфейсных веб-приложений, использующих React) или собственный код через LLVM (например, для собственных приложений iOS, разделяющих бизнес-логику с приложениями Android). Затраты на разработку языка несет JetBrains, а Kotlin Foundation защищает торговую марку Kotlin.</p>

<br>
<h1 align = "center">Цели и задачи</h1>

Задачи:

1. Добавление слушателя для TextView
Кнопка NEXT удобна, но было бы неплохо, если бы пользователь мог переходить к следующему вопросу простым нажатием на виджетTextView. 
Подсказка. Для TextView можно использовать слушателя View.OnClickListener, который использовался с Button, потому что класс TextView также является производным от View.

2. Добавление кнопки возврата
Добавьте кнопку для возвращения к предыдущему вопросу. Пользовательский интерфейс должен выглядеть примерно так, как показано на рис. 2.13. 

3. От Button к ImageButton
Возможно, пользовательский интерфейс будет смотреться еще лучше, если на кнопках будут отображаться только значки, как на рис. 2.14.
Для этого оба виджета должны относиться к типу ImageButton (вместо обычного Button). ВиджетImageButton является производным от ImageView, в отличие от виджетаButton, производного от TextView. Диаграммы их наследования изображены на рис. 2.15. Атрибуты text и drawable кнопки NEXT можно заменить одним атрибутом ImageView:

<h1 align = "center">Решение</h1>

1. Чтобы добавить слушателя к TextView добавил следующий код

```
question_view.setOnClickListener {
    nextQuestion()
}
```

2. Добавив кнопки в XML лейаута, добавил следующий код:

```
prev_button = findViewById(R.id.prev_button)
next_button = findViewById(R.id.next_button)
next_button.setOnClickListener {
    nextQuestion()
}
prev_button.setOnClickListener {
    prevQuestion()
}
```

3. Изменил XML кнопок возврата и перехода к следующему вопросу:

```
<ImageButton
    android:id="@+id/prev_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@drawable/arrow_left" />

<ImageButton
    android:id="@+id/next_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@drawable/arrow_right" />
```

<h1 align = "center">Вывод</h1>
Опираясь на материал с лекции и помощь сторонних ресурсов, я научился использовать ImageButton, узнал что такое модель MVC и как ей легко можно воспользоваться для написания расширяемого приложения.