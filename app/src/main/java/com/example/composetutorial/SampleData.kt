package com.example.composetutorial

object SampleData {
    val conversationSample = listOf(
        Message(
            "Colleague",
            "Test...Test...Test..."
        ),
        Message(
            "Colleague",
            "List of Android versions:\n" +
                    "Android KitKat (API 19)\n" +
                    "Android Lollipop (API 21)\n" +
                    "Android Marshmallow (API 23)\n" +
                    "Android Nougat (API 24)\n" +
                    "Android Oreo (API 26)\n" +
                    "Android Pie (API 28)\n" +
                    "Android 10 (API 29)\n" +
                    "Android 11 (API 30)\n" +
                    "Android 12 (API 31)\n"
        ),
        Message(
            "Colleague",
            "I think Kotlin is my favorite programming language.\n" +
                    "It's so much fun!"
        ),
        Message(
            "Colleague",
            "Searching for alternatives to XML layouts..."
        ),
        Message(
            "Colleague",
            "Hey, take a look at Jetpack Compose, it's great!\n" +
                    "It's the Android's modern toolkit for building native UI." +
                    "It simplifies and accelerates UI development on Android." +
                    "Less code, powerful tools, and intuitive Kotlin APIs :)"
        ),
        Message(
            "Colleague",
            "It's available from API 21+ :)"
        ),
        Message(
            "Colleague",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Colleague",
            "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "Colleague",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Colleague",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "Colleague",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "Colleague",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
    )

    val conversationSample1 = listOf(
        Message(
            "Colleague",
            "Test...Test...Test..."
        ),
        Message(
            "Colleague",
            "Can you hear me?"
        ),
        Message(
            "Colleague",
            "Hey, take a look at Jetpack Compose, it's great!\n" +
                    "It's the Android's modern toolkit for building native UI." +
                    "It simplifies and accelerates UI development on Android." +
                    "Less code, powerful tools, and intuitive Kotlin APIs :)"
        ))

    val buttons = listOf(
        MainActivity.Button("Compose overview CodeLab","ComposeOverviewTutorialActivity"),
        MainActivity.Button("Compose basics CodeLab","ComposeBasicsActivity"),
        MainActivity.Button("Compose Migration CodeLab","ComposeMigrateActivity"),
        MainActivity.Button("Compose Basic layouts CodeLab","ComposeBasicLayoutsActivity"))

    val cards = listOf(
        ComposeBasicsActivity.Greeting("Hello, 1","This is the content for 1!"),
        ComposeBasicsActivity.Greeting("Hello, 2","This is the content for 2!"),
        ComposeBasicsActivity.Greeting("Hello, 3","This is the content for 3!"),
        ComposeBasicsActivity.Greeting("Hello, 4","This is the content for 4!"),
        ComposeBasicsActivity.Greeting("Hello, 5","This is the content for 5!"),
        ComposeBasicsActivity.Greeting("Hello, 6","This is the content for 6!"),
        ComposeBasicsActivity.Greeting("Hello, 7","This is the content for 7!"),
        ComposeBasicsActivity.Greeting("Hello, 8","This is the content for 8!"),
        ComposeBasicsActivity.Greeting("Hello, 9","This is the content for 9!"),
        ComposeBasicsActivity.Greeting("Hello, 10","This is the content for 10!"),
        ComposeBasicsActivity.Greeting("Hello, 11","This is the content for 11!"),
        ComposeBasicsActivity.Greeting("Hello, 12","This is the content for 12!"),
        ComposeBasicsActivity.Greeting("Hello, 13","This is the content for 13!"),
        ComposeBasicsActivity.Greeting("Hello, 14","This is the content for 14!"),
        ComposeBasicsActivity.Greeting("Hello, 15","This is the content for 15!"),
        ComposeBasicsActivity.Greeting("Hello, 16","This is the content for 16!"),
        ComposeBasicsActivity.Greeting("Hello, 17","This is the content for 17!"),
        ComposeBasicsActivity.Greeting("Hello, 18","This is the content for 18!"),
        ComposeBasicsActivity.Greeting("Hello, 19","This is the content for 19!"),
        ComposeBasicsActivity.Greeting("Hello, 20","This is the content for 20!"))

    val workouts=listOf(
        ComposeBasicLayoutsActivity.Workout("Inversions",R.drawable.image5),
        ComposeBasicLayoutsActivity.Workout("Natural meditation",R.drawable.images),
        ComposeBasicLayoutsActivity.Workout("Self massage", R.drawable.images3),
        ComposeBasicLayoutsActivity.Workout("Stress and anxiety",R.drawable.images4),
        ComposeBasicLayoutsActivity.Workout("Inversions",R.drawable.img1)
    )

}
